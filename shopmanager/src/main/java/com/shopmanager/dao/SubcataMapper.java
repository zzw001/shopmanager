package com.shopmanager.dao;

import com.shopmanager.model.Subcata;
import com.shopmanager.model.SubcataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubcataMapper {
    int countByExample(SubcataExample example);

    int deleteByExample(SubcataExample example);

    int deleteByPrimaryKey(Integer subId);

    int insert(Subcata record);

    int insertSelective(Subcata record);

    List<Subcata> selectByExample(SubcataExample example);

    Subcata selectByPrimaryKey(Integer subId);

    int updateByExampleSelective(@Param("record") Subcata record, @Param("example") SubcataExample example);

    int updateByExample(@Param("record") Subcata record, @Param("example") SubcataExample example);

    int updateByPrimaryKeySelective(Subcata record);

    int updateByPrimaryKey(Subcata record);
}