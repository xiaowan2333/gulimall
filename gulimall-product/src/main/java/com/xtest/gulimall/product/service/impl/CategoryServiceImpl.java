package com.xtest.gulimall.product.service.impl;

import com.xtest.common.utils.PageUtils;
import com.xtest.common.utils.Query;
import org.springframework.stereotype.Service;

import java.lang.management.LockInfo;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xtest.gulimall.product.dao.CategoryDao;
import com.xtest.gulimall.product.entity.CategoryEntity;
import com.xtest.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //找到所有分类列表
        List<CategoryEntity> categorys = baseMapper.selectList(null);
        //过滤出一级标签
        List<CategoryEntity> level1 = categorys.stream().
                filter(categoryEntity -> categoryEntity.getParentCid() == 0).
                map(menu -> {
                    menu.setChildren(getChildrens(menu, categorys));
                    return menu;
                }).
                sorted((menu1, menu2) -> {
                    return ((menu1.getSort() == null ? 0 : menu1.getSort())) - (menu2.getSort() == null ? 0 : menu2.getSort());
                }).
                collect(Collectors.toList());
        return level1;
    }

    @Override
    public void removeMenuByIds(List<Long> catIds) {
        //TODO 检查当前menu是否可删除
        baseMapper.deleteBatchIds(catIds);
    }

    /**
     * 根据catelogId查询出catelogPath
     * @param catelogId
     * @return
     */
    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> parentPath = findParentById(catelogId, paths);
        Collections.reverse(parentPath);
        Long[] longs = parentPath.toArray(new Long[parentPath.size()]);
        return longs;
    }
    private List<Long> findParentById(Long cateLogId,List<Long> paths){
        paths.add(cateLogId);
        CategoryEntity byId = this.getById(cateLogId);
        if (byId.getParentCid()!=0){
            findParentById(byId.getParentCid(),paths);
        }
        return paths;
    }


    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> categorys) {
        List<CategoryEntity> collect = categorys.stream().filter(categoryEntity -> {
            //返回所有当前根menu的所有次级子menu
            return Objects.equals(categoryEntity.getParentCid(),root.getCatId());
        }).map(categoryEntity -> {
            categoryEntity.setChildren(getChildrens(categoryEntity, categorys));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return ((menu1.getSort() == null ? 0 : menu1.getSort())) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        return collect;
    }


}