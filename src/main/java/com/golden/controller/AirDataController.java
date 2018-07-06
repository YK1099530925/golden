package com.golden.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.golden.pojo.AirData;
import com.golden.service.AirDataService;
import com.golden.service.OtherService;
import com.golden.toexcel.CommonExcel;

import net.sf.json.JSONObject;

@Controller
public class AirDataController {

	@Autowired
	AirDataService airDataService;
	
	@Autowired
	OtherService otherService;
	
	@RequestMapping(value="/airDatas/{pageNum}",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String airData(@PathVariable("pageNum")Integer pageNum) {
		//每页显示5条数据
		PageHelper.startPage(pageNum, 5);
		List<AirData> airDatas = airDataService.selectAllAirData();
		PageInfo<AirData> pageInfo = new PageInfo<>(airDatas,5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", pageInfo);
		System.out.println("data:" + jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/airToExcel",method=RequestMethod.POST)
	@ResponseBody
	public String airToExcel() {
		HttpServletResponse response = null;
		String title = "空气温湿度";
        String[] rowsName = new String[]{"序号","id","无线id","设备标识","设备类型","空气温度","空气湿度","检测时间"};
        List<Object[]>  dataList = otherService.selectDatas();
        String fileName="空气温湿度-"+String.valueOf(System.currentTimeMillis()).substring(4,13)+".xls";
       CommonExcel ex = new CommonExcel(title, rowsName, dataList,response,fileName);
       ex.downloadExcel();
        System.out.println("下载成功");
		return "1";
	}
}
