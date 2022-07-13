package com.xtest.gulimall.product.dao;

import com.xtest.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author XiaoWan
 * @email xiaowan2333@qq.com
 * @date 2022-07-12 17:14:50
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
