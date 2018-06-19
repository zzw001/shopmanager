package com.shopmanager.dao;

import com.shopmanager.model.Transportation;
import com.shopmanager.model.TransportationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportationMapper {
    int countByExample(TransportationExample example);

    int deleteByExample(TransportationExample example);

    int deleteByPrimaryKey(String tranId);

    int insert(Transportation record);

    int insertSelective(Transportation record);

    List<Transportation> selectByExample(TransportationExample example);

    Transportation selectByPrimaryKey(String tranId);

    int updateByExampleSelective(@Param("record") Transportation record, @Param("example") TransportationExample example);

    int updateByExample(@Param("record") Transportation record, @Param("example") TransportationExample example);

    int updateByPrimaryKeySelective(Transportation record);

    int updateByPrimaryKey(Transportation record);

    Transportation selectByCateId(Integer cateId);
}