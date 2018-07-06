package com.golden.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.dao.AirDataMapper;
import com.golden.pojo.AirData;

@Service
public class OtherServiceImpl implements OtherService {

	@Autowired
	AirDataMapper airDataMapper;
	
	/**
	 * 获取airdata，并将其转成object[]
	 */
	@Override
	public List<Object[]> selectDatas() {
		List<AirData> airDatas = airDataMapper.selectByExample(null);
		List<Object[]> objects = new ArrayList<>();
		for(AirData airData : airDatas) {
			Object object[] = new Object[8];
			//因为第一列，他无论放的任何数字，都会从1开始排序
			object[0] = 1;
			object[1] = airData.getId();
			object[2] = airData.getWifiid();
			object[3] = airData.getShebeibiaozhi();
			object[4] = airData.getShebeileixing();
			if(airData.getTemperature().length() == 0) {
				object[5] = "0°C";
			}else {
				object[5] = airData.getTemperature();
			}
			if(airData.getHumidity().length() == 0) {
				object[6] = "0%";
			}else {
				object[6] = airData.getHumidity() + "%";
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			object[7] = df.format(new Date());
			objects.add(object);
		}
		return objects;
	}

}
