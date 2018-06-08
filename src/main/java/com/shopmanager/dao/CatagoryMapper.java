package com.shopmanager.dao;

import com.shopmanager.model.Catagory;
import com.shopmanager.model.CatagoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CatagoryMapper {
    int countByExample(CatagoryExample example);

    int deleteByExample(CatagoryExample example);

    int deleteByPrimaryKey(Integer cataId);

    int insert(Catagory record);

    int insertSelective(Catagory record);

    List<Catagory> selectByExample(CatagoryExample example);

    Catagory selectByPrimaryKey(Integer cataId);

    int updateByExampleSelective(@Param("record") Catagory record, @Param("example") CatagoryExample example);

    int updateByExample(@Param("record") Catagory record, @Param("example") CatagoryExample example);

    int updateByPrimaryKeySelective(Catagory record);

    int updateByPrimaryKey(Catagory record);

    List<Catagory> getAll();
}