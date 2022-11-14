package com.zq.service;

import com.zq.entity.House;

/**
 * @Author: 阿庆
 * @Date: 2022/11/12 18:56
 * @Description: TODO
 */
public interface HouseService extends BaseService<House> {
    void publish(Long id, Integer status);
}
