package com.golden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.golden.pojo.BeamData;
import com.golden.service.BeamDataService;

import net.sf.json.JSONObject;

@Controller
public class BeamDataController {
	
	@Autowired
	BeamDataService beamDataService;
	
	@RequestMapping(value="/beamDatas/{pageNum}",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String soilData(@PathVariable("pageNum")Integer pageNum) {
		//每页显示5条数据
				PageHelper.startPage(pageNum, 5);
				List<BeamData> beamData = beamDataService.selectAllBeamData();
				PageInfo<BeamData> pageInfo = new PageInfo<>(beamData, 5);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("data", pageInfo);
				System.out.println("data:" + jsonObject.toString());
				return jsonObject.toString();
	}
}
