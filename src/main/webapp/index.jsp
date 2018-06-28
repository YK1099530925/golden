<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
	pageContext.setAttribute("appPath", request.getContextPath());
%>
<script type="text/javascript" src="${appPath }/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${appPath }/js/airData.js"></script>
<link href="${appPath }/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${appPath }/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>空气温湿度</title>
</head>
<body>
	<div class="body-right" id="">
		<div class="panel panel-primary">
			<div class="panel-heading">空气温湿度</div>
			<div class="panel-body panel-body-my">
				<!-- 接收消息体 -->
				<div class="row">
					<div class="col-md-4">
						<button class="btn btn-primary" id="user_add_modal_btn">下载</button>
						<button class="btn btn-danger" id="user_delete_all_btn">其他</button>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="">
					</div>
					<div class="col-md-4">
						<button class="btn btn-default" id="select">查询</button>
					</div>
				</div>
				<table class="table table-hover" id="airData_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="" /></th>
							<th>ID</th>
							<th>无线ID</th>
							<th>设备标识</th>
							<th>设备类型</th>
							<th>温度</th>
							<th>湿度</th>
							<th>记录时间</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<div class="row">
					<div id="airData_pageInfo" class="col-md-5 col-md-offset-4"></div>
					<div id="airData_pageNav" class="col-md-6 col-md-offset-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

$(window).load(function(){
	showAllAirData(1);
});

//显示数据
function showAllAirData(pageNum){
	$.ajax({
		url:"${appPath}/airDatas/" + pageNum,
		type:"get",
		success:function(e){
			addInfo_airData(e);
			//添加页码信息
			addpageInfo_airData(e,"#airData_pageInfo");
			//添加分页导航标签
			addPageNav_airData(e,"#airData_pageNav");
		}
	});
}

function addInfo_airData(e){
	var airDataList = e.data.list.reverse();
	$("#airData_table tbody").empty();
	$.each(airDataList,function(index,item){
		var checkBox = $("<td><input type='checkbox' class='check_item_airData' /></td>");
		var id = $("<td></td>").append(item.id);
		var wifiid = $("<td></td>").append(item.wifiid);
		var shebeibiaozhi = $("<td></td>").append(item.shebeibiaozhi);
		var shebeileixing = $("<td></td>").append(item.shebeileixing);
		var temperature = $("<td></td>").append(item.temperature);
		var humidity = $("<td></td>").append(item.humidity).append("%");
		var date = $("<td></td>").append(dateFormat(item.date));
		$("<tr></tr>")
		.append(checkBox)
		.append(id)
		.append(wifiid)
		.append(shebeibiaozhi)
		.append(shebeileixing)
		.append(temperature)
		.append(humidity)
		.append(date)
		.prependTo("#airData_table tbody");
	});
}

/* 将日期格式化 */
dateFormat = function(date){
	var y = date.year;
	var m = date.month + 1;
	var d = date.date;
	//判断是2000年前还是后
	if(y >= 50){
		y = 1900 + y;
	}else{
		y = 2000 + y;
	}
	var hour = date.hours;
	var minutes = date.minutes;
	var seconds = date.seconds;
	var birthday = y + "-" + m + "-" + d + " " + hour + ":" + minutes + ":" + seconds;
		
	return birthday;
}

</script>
</html>