package com.xtest.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtest.common.utils.PageUtils;
import com.xtest.gulimall.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author XiaoWan
 * @email xiaowan2333@qq.com
 * @date 2022-07-13 10:39:07
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

