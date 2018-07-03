package com.golden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.dao.CO2DataMapper;
import com.golden.pojo.CO2Data;

@Service
public class CO2DataServiceImpl implements CO2DataService {
	
	@Autowired
	CO2DataMapper co2DataMapper;

	@Override
	public List<CO2Data> selectAllCO2Data() {
		return co2DataMapper.selectByExample(null);
	}

}
