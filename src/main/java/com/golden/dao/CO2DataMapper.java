package com.golden.dao;

import com.golden.pojo.CO2Data;
import com.golden.pojo.CO2DataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CO2DataMapper {
    long countByExample(CO2DataExample example);

    int deleteByExample(CO2DataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CO2Data record);

    int insertSelective(CO2Data record);

    List<CO2Data> selectByExample(CO2DataExample example);

    CO2Data selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CO2Data record, @Param("example") CO2DataExample example);

    int updateByExample(@Param("record") CO2Data record, @Param("example") CO2DataExample example);

    int updateByPrimaryKeySelective(CO2Data record);

    int updateByPrimaryKey(CO2Data record);
}