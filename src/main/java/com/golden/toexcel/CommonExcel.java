package com.golden.toexcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class CommonExcel {
	//显示导出表的标题
	private String title;
	//导出表的列名
	private String[] rowName;
	//导出的文件名
	private String fileName;
	
	private List<Object[]> list = new ArrayList<>();
	
	private HttpServletResponse response;
	
	//构造方法，传入要导入的数据（使用List<Object>具有通用性，可以对每一个表进行导出）
	public CommonExcel(String title, String[] rowName, List<Object[]> dataList, HttpServletResponse response, String fileName) {
		this.list = dataList;
        this.rowName = rowName;
        this.title = title;
        this.response = response;
        this.fileName = fileName;
	}
	
	//导出数据
	public void downloadExcel() {
		try {
			//创建工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook();
			//创建工作表
			HSSFSheet sheet = workbook.createSheet();
			//产生表格标题行
			HSSFRow rowm = sheet.createRow(0);
			HSSFCell cellTitle = rowm.createCell(0);
			//sheet样式定义
			HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);
			//单元格样式对象
			HSSFCellStyle style = this.getStyle(workbook);
			sheet.addMergedRegion(	new CellRangeAddress(0, 1, 0, (rowName.length - 1)));
			cellTitle.setCellStyle(columnTopStyle);
			cellTitle.setCellValue(title);
			//定义所需的列数
			int columnNum = rowName.length;
			//在索引2的位置创建行
			HSSFRow rowRowName = sheet.createRow(2);
			//将列头设置到sheet单元格中
			for(int n = 0; n < columnNum; n++) {
				//创建列头对应个数的单元格
				HSSFCell cellRowName = rowRowName.createCell(n);
				//设置列头单元格的数据类型
				cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);
				HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
				//设置列头单元格的值
				cellRowName.setCellValue(text);
				//设置列头单元格格式
				cellRowName.setCellStyle(columnTopStyle);
			}
			//将数据查询出来的数据设置到单元格中
			for(int i = 0; i < list.size(); i++) {
				//遍历每个对象
				Object[] obj = list.get(i);
				//创建所需的行数
				HSSFRow row = sheet.createRow(i + 3);
				for (int j = 0; j < obj.length; j++) {
					//设置单元格的数据类型
			        HSSFCell cell = null;   
			        if (j == 0) {
			            cell = row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
			            cell.setCellValue(i + 1);
			        } else {
			            cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
			            if (!"".equals(obj[j]) && obj[j] != null) {
			            	//设置单元格的值
			                cell.setCellValue(obj[j].toString());                       
			            }
			        }
			        //设置单元格的样式
			        cell.setCellStyle(style);
				}
			}
			//让列宽随着导出的列长自动适应
			for(int colNum = 0; colNum < columnNum; colNum++) {
				int columnWidth = sheet.getColumnWidth(colNum) / 256;
				for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
			        HSSFRow currentRow;
			        //当前行未被使用过
			        if (sheet.getRow(rowNum) == null) {
			            currentRow = sheet.createRow(rowNum);
			        } else {
			            currentRow = sheet.getRow(rowNum);
			        }
			        if (currentRow.getCell(colNum) != null) {
			            HSSFCell currentCell = currentRow.getCell(colNum);
			            if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			                int length = currentCell.getStringCellValue().getBytes().length;
			                if (columnWidth < length) {
			                    columnWidth = length;
			                }
			            }
			        }
			    }
				if (colNum == 0) {
			        sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
			    } else {
			        sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
			    }
				if (workbook != null) {
			        try {
			            if (response != null) {
			                response.setContentType("application/vnd.ms-excel;charset=utf-8");
			                response.setHeader("Content-Disposition", "attachment;filename=\""+new String(fileName.getBytes("gb2312"),"ISO8859-1"));
			                OutputStream out = response.getOutputStream();
			                workbook.write(out);
			                out.close();
			            } else {
			                FileOutputStream outputStream = new FileOutputStream("C:/E-document/hssf/"+fileName);
			                workbook.write(outputStream);
			                outputStream.close();
			            }
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
     * 列头单元格样式
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 12);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("微软雅黑");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }
    
    /*
     * 列数据信息单元格样式
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体名字
        font.setFontName("微软雅黑");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }
    
    //测试方法
    public static void main1(String[] args) {
    	HttpServletResponse response=null;
        String title = "空气温湿度";
        String[] rowsName = new String[]{"id","无线id","设备标识","设备类型","空气温度","空气湿度","日期"};
        List<Object[]>  dataList = new ArrayList<>();
        Object[] objs = null;
        for (int i = 0; i < 10; i++) {
            objs = new Object[rowsName.length];
            objs[0] = i;
            objs[1] = "e903";
            objs[2] = "005b001c1336313634323948";
            objs[3] = "b3";
            objs[4] = "16.1°C";
            objs[5] = "28";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());
            objs[6] = date;
            dataList.add(objs);
        }
        String fileName="空气温湿度-"+String.valueOf(System.currentTimeMillis()).substring(4,13)+".xls";
        CommonExcel ex = new CommonExcel(title, rowsName, dataList,response,fileName);
        ex.downloadExcel();
	}
}
