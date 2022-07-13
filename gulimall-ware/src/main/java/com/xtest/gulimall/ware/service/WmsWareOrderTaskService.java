package com.xtest.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xtest.common.utils.PageUtils;
import com.xtest.gulimall.ware.entity.WmsWareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author XiaoWan
 * @email xiaowan2333@qq.com
 * @date 2022-07-13 10:57:38
 */
public interface WmsWareOrderTaskService extends IService<WmsWareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

