package com.golden.dao;

import com.golden.pojo.InvadeData;
import com.golden.pojo.InvadeDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvadeDataMapper {
    long countByExample(InvadeDataExample example);

    int deleteByExample(InvadeDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InvadeData record);

    int insertSelective(InvadeData record);

    List<InvadeData> selectByExample(InvadeDataExample example);

    InvadeData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InvadeData record, @Param("example") InvadeDataExample example);

    int updateByExample(@Param("record") InvadeData record, @Param("example") InvadeDataExample example);

    int updateByPrimaryKeySelective(InvadeData record);

    int updateByPrimaryKey(InvadeData record);
}