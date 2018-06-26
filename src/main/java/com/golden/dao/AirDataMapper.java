package com.golden.dao;

import com.golden.pojo.AirData;
import com.golden.pojo.AirDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirDataMapper {
    long countByExample(AirDataExample example);

    int deleteByExample(AirDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AirData record);

    int insertSelective(AirData record);

    List<AirData> selectByExample(AirDataExample example);

    AirData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AirData record, @Param("example") AirDataExample example);

    int updateByExample(@Param("record") AirData record, @Param("example") AirDataExample example);

    int updateByPrimaryKeySelective(AirData record);

    int updateByPrimaryKey(AirData record);
}