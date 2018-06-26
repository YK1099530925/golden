package com.golden.dao;

import com.golden.pojo.SoilData;
import com.golden.pojo.SoilDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoilDataMapper {
    long countByExample(SoilDataExample example);

    int deleteByExample(SoilDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SoilData record);

    int insertSelective(SoilData record);

    List<SoilData> selectByExample(SoilDataExample example);

    SoilData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SoilData record, @Param("example") SoilDataExample example);

    int updateByExample(@Param("record") SoilData record, @Param("example") SoilDataExample example);

    int updateByPrimaryKeySelective(SoilData record);

    int updateByPrimaryKey(SoilData record);
}