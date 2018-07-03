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
import com.golden.pojo.CO2Data;
import com.golden.service.CO2DataService;

import net.sf.json.JSONObject;

@Controller
public class CO2DataController {
	@Autowired
	CO2DataService co2DataService;
	
	@RequestMapping(value="/co2Datas/{pageNum}",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String co2Data(@PathVariable("pageNum")Integer pageNum) {
		//每页显示5条数据
		PageHelper.startPage(pageNum, 5);
		List<CO2Data> co2Datas = co2DataService.selectAllCO2Data();
		PageInfo<CO2Data> pageInfo = new PageInfo<>(co2Datas, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", pageInfo);
		System.out.println("data:" + jsonObject.toString());
		return jsonObject.toString();
	}
}
