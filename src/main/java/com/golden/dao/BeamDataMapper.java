package com.golden.dao;

import com.golden.pojo.BeamData;
import com.golden.pojo.BeamDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeamDataMapper {
    long countByExample(BeamDataExample example);

    int deleteByExample(BeamDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeamData record);

    int insertSelective(BeamData record);

    List<BeamData> selectByExample(BeamDataExample example);

    BeamData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeamData record, @Param("example") BeamDataExample example);

    int updateByExample(@Param("record") BeamData record, @Param("example") BeamDataExample example);

    int updateByPrimaryKeySelective(BeamData record);

    int updateByPrimaryKey(BeamData record);
}