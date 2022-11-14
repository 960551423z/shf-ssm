package com.zq.dao;

import com.zq.entity.HouseImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 14:23
 * @Description: TODO
 */
public interface HouseImageDao extends BaseDao<HouseImage> {
    // 根据房源id 查询房源或房产图片
    List<HouseImage> getHouseImageByHouseIdAndType(@Param("houseId") Integer houseId,@Param("type") Integer type);
}
