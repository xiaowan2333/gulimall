package com.xtest.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtest.common.utils.PageUtils;
import com.xtest.gulimall.member.entity.UmsMemberCollectSpuEntity;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author XiaoWan
 * @email xiaowan2333@qq.com
 * @date 2022-07-13 10:53:22
 */
public interface UmsMemberCollectSpuService extends IService<UmsMemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

