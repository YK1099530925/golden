package com.golden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.golden.dao.BeamDataMapper;
import com.golden.pojo.BeamData;

@Service
public class BeamDataServiceImpl implements BeamDataService {
	
	@Autowired
	BeamDataMapper beamDataMapper;
	
	@Override
	public List<BeamData> selectAllBeamData() {
		return beamDataMapper.selectByExample(null);
	}

}
