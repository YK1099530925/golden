package com.golden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.dao.AirDataMapper;
import com.golden.pojo.AirData;

@Service
public class AirDataServiceImpl implements AirDataService {
	
	@Autowired
	AirDataMapper airDataMapper;
	
	@Override
	public List<AirData> selectAllAirData() {
		return airDataMapper.selectByExample(null);
	}

}
