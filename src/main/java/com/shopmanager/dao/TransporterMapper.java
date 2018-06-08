package com.shopmanager.dao;

import com.shopmanager.model.Transporter;
import com.shopmanager.model.TransporterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransporterMapper {
    int countByExample(TransporterExample example);

    int deleteByExample(TransporterExample example);

    int deleteByPrimaryKey(Integer trerId);

    int insert(Transporter record);

    int insertSelective(Transporter record);

    List<Transporter> selectByExample(TransporterExample example);

    Transporter selectByPrimaryKey(Integer trerId);

    int updateByExampleSelective(@Param("record") Transporter record, @Param("example") TransporterExample example);

    int updateByExample(@Param("record") Transporter record, @Param("example") TransporterExample example);

    int updateByPrimaryKeySelective(Transporter record);

    int updateByPrimaryKey(Transporter record);

    Transporter selectByTrerName(String trerName);
}