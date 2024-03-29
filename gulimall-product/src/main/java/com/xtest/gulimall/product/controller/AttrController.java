package com.xtest.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.xtest.gulimall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xtest.gulimall.product.entity.AttrEntity;
import com.xtest.gulimall.product.service.AttrService;
import com.xtest.common.utils.PageUtils;
import com.xtest.common.utils.R;



/**
 * 商品属性
 *
 * @author XiaoWan
 * @email xiaowan2333@qq.com
 * @date 2022-07-13 09:50:19
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@PathVariable("catelogId") Long catelogId,
                          @RequestParam Map<String,Object> params,
                          @PathVariable("attrType")String type){
        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,type);
    return R.ok().put("page",page);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);

        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
