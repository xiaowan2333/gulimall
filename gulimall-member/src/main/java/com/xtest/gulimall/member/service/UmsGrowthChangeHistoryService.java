package com.xtest.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtest.common.utils.PageUtils;
import com.xtest.gulimall.member.entity.UmsGrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author XiaoWan
 * @email xiaowan2333@qq.com
 * @date 2022-07-13 10:53:22
 */
public interface UmsGrowthChangeHistoryService extends IService<UmsGrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

