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
	if(hour < 10){
		hour = "0" + hour;
	}
	if(minutes < 10){
		minutes = "0" + minutes;
	}
	if(seconds < 10){
		seconds = "0" + seconds;
	}
	var birthday = y + "-" + m + "-" + d + " " + hour + ":" + minutes + ":" + seconds;
		
	return birthday;
}