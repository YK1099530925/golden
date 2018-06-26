package com.golden.dao;

import com.golden.pojo.DevData;
import com.golden.pojo.DevDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevDataMapper {
    long countByExample(DevDataExample example);

    int deleteByExample(DevDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DevData record);

    int insertSelective(DevData record);

    List<DevData> selectByExample(DevDataExample example);

    DevData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DevData record, @Param("example") DevDataExample example);

    int updateByExample(@Param("record") DevData record, @Param("example") DevDataExample example);

    int updateByPrimaryKeySelective(DevData record);

    int updateByPrimaryKey(DevData record);
}