package com.zq.dao;

import com.zq.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 12:42
 * @Description: TODO
 */
public interface AdminDao extends BaseDao<Admin>{

    List<Admin> findByPageAndLike(Serializable pageNum, Serializable pageSize,
                                  @Param("t") Admin t,
                                  @Param("createTimeBegin") String createTimeBegin,
                                  @Param("createTimeEnd") String createTimeEnd);

}
