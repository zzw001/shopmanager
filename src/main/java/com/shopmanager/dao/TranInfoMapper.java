package com.shopmanager.dao;

import com.shopmanager.model.TranInfo;
import com.shopmanager.model.TranInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TranInfoMapper {
    int countByExample(TranInfoExample example);

    int deleteByExample(TranInfoExample example);

    int deleteByPrimaryKey(Integer tranInfoId);

    int insert(TranInfo record);

    int insertSelective(TranInfo record);

    List<TranInfo> selectByExample(TranInfoExample example);

    TranInfo selectByPrimaryKey(Integer tranInfoId);

    int updateByExampleSelective(@Param("record") TranInfo record, @Param("example") TranInfoExample example);

    int updateByExample(@Param("record") TranInfo record, @Param("example") TranInfoExample example);

    int updateByPrimaryKeySelective(TranInfo record);

    int updateByPrimaryKey(TranInfo record);

    List<TranInfo> selectByTranId(String TranId);
}