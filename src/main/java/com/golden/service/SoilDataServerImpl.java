package com.golden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.dao.SoilDataMapper;
import com.golden.pojo.SoilData;

@Service
public class SoilDataServerImpl implements SoilDataServer {
	
	@Autowired
	SoilDataMapper soilDataMapper;

	@Override
	public List<SoilData> selectAllSoilData() {
		return soilDataMapper.selectByExample(null);
	}

}
