<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<%
	pageContext.setAttribute("appPath", request.getContextPath());
%>
<script type="text/javascript" src="${appPath }/js/jquery-1.12.4.min.js"></script>
<link href="${appPath }/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${appPath }/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="body-right" id="">
		<div class="panel panel-primary">
			<div class="panel-heading">员工管理</div>
			<div class="panel-body panel-body-my">
				<!-- 接收消息体 -->
				<div class="row">
					<div class="col-md-4">
						<button class="btn btn-primary" id="user_add_modal_btn">新增</button>
						<button class="btn btn-danger" id="user_delete_all_btn">删除</button>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="">
					</div>
					<div class="col-md-4">
						<button class="btn btn-default" id="">查询</button>
					</div>
				</div>
				<table class="table table-hover" id="userInfo_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="check_all_user" /></th>
							<th>ID</th>
							<th>无线ID</th>
							<th>设备标识</th>
							<th>设备类型</th>
							<th>温度</th>
							<th>湿度</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<div class="row">
					<div id="userInfo_page_Info" class="col-md-5 col-md-offset-4"></div>
					<div id="userInfo_page_nav" class="col-md-6 col-md-offset-4">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">



</script>
</html>