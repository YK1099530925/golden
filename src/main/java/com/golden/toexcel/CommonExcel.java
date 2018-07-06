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
	//��ʾ������ı���
	private String title;
	//�����������
	private String[] rowName;
	//�������ļ���
	private String fileName;
	
	private List<Object[]> list = new ArrayList<>();
	
	private HttpServletResponse response;
	
	//���췽��������Ҫ��������ݣ�ʹ��List<Object>����ͨ���ԣ����Զ�ÿһ������е�����
	public CommonExcel(String title, String[] rowName, List<Object[]> dataList, HttpServletResponse response, String fileName) {
		this.list = dataList;
        this.rowName = rowName;
        this.title = title;
        this.response = response;
        this.fileName = fileName;
	}
	
	//��������
	public void downloadExcel() {
		try {
			//��������������
			HSSFWorkbook workbook = new HSSFWorkbook();
			//����������
			HSSFSheet sheet = workbook.createSheet();
			//������������
			HSSFRow rowm = sheet.createRow(0);
			HSSFCell cellTitle = rowm.createCell(0);
			//sheet��ʽ����
			HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);
			//��Ԫ����ʽ����
			HSSFCellStyle style = this.getStyle(workbook);
			sheet.addMergedRegion(	new CellRangeAddress(0, 1, 0, (rowName.length - 1)));
			cellTitle.setCellStyle(columnTopStyle);
			cellTitle.setCellValue(title);
			//�������������
			int columnNum = rowName.length;
			//������2��λ�ô�����
			HSSFRow rowRowName = sheet.createRow(2);
			//����ͷ���õ�sheet��Ԫ����
			for(int n = 0; n < columnNum; n++) {
				//������ͷ��Ӧ�����ĵ�Ԫ��
				HSSFCell cellRowName = rowRowName.createCell(n);
				//������ͷ��Ԫ�����������
				cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);
				HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
				//������ͷ��Ԫ���ֵ
				cellRowName.setCellValue(text);
				//������ͷ��Ԫ���ʽ
				cellRowName.setCellStyle(columnTopStyle);
			}
			//�����ݲ�ѯ�������������õ���Ԫ����
			for(int i = 0; i < list.size(); i++) {
				//����ÿ������
				Object[] obj = list.get(i);
				//�������������
				HSSFRow row = sheet.createRow(i + 3);
				for (int j = 0; j < obj.length; j++) {
					//���õ�Ԫ�����������
			        HSSFCell cell = null;   
			        if (j == 0) {
			            cell = row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
			            cell.setCellValue(i + 1);
			        } else {
			            cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
			            if (!"".equals(obj[j]) && obj[j] != null) {
			            	//���õ�Ԫ���ֵ
			                cell.setCellValue(obj[j].toString());                       
			            }
			        }
			        //���õ�Ԫ�����ʽ
			        cell.setCellStyle(style);
				}
			}
			//���п����ŵ������г��Զ���Ӧ
			for(int colNum = 0; colNum < columnNum; colNum++) {
				int columnWidth = sheet.getColumnWidth(colNum) / 256;
				for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
			        HSSFRow currentRow;
			        //��ǰ��δ��ʹ�ù�
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
     * ��ͷ��Ԫ����ʽ
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // ��������
        HSSFFont font = workbook.createFont();
        //���������С
        font.setFontHeightInPoints((short) 12);
        //����Ӵ�
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //������������
        font.setFontName("΢���ź�");
        //������ʽ;
        HSSFCellStyle style = workbook.createCellStyle();
        //���õױ߿�;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //���õױ߿���ɫ;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //������߿�;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //������߿���ɫ;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //�����ұ߿�;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //�����ұ߿���ɫ;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //���ö��߿�;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //���ö��߿���ɫ;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //����ʽ��Ӧ�����õ�����;
        style.setFont(font);
        //�����Զ�����;
        style.setWrapText(false);
        //����ˮƽ�������ʽΪ���ж���;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //���ô�ֱ�������ʽΪ���ж���;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }
    
    /*
     * ��������Ϣ��Ԫ����ʽ
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // ��������
        HSSFFont font = workbook.createFont();
        //������������
        font.setFontName("΢���ź�");
        //������ʽ;
        HSSFCellStyle style = workbook.createCellStyle();
        //���õױ߿�;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //���õױ߿���ɫ;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //������߿�;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //������߿���ɫ;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //�����ұ߿�;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //�����ұ߿���ɫ;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //���ö��߿�;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //���ö��߿���ɫ;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //����ʽ��Ӧ�����õ�����;
        style.setFont(font);
        //�����Զ�����;
        style.setWrapText(false);
        //����ˮƽ�������ʽΪ���ж���;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //���ô�ֱ�������ʽΪ���ж���;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }
    
    //���Է���
    public static void main1(String[] args) {
    	HttpServletResponse response=null;
        String title = "������ʪ��";
        String[] rowsName = new String[]{"id","����id","�豸��ʶ","�豸����","�����¶�","����ʪ��","����"};
        List<Object[]>  dataList = new ArrayList<>();
        Object[] objs = null;
        for (int i = 0; i < 10; i++) {
            objs = new Object[rowsName.length];
            objs[0] = i;
            objs[1] = "e903";
            objs[2] = "005b001c1336313634323948";
            objs[3] = "b3";
            objs[4] = "16.1��C";
            objs[5] = "28";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());
            objs[6] = date;
            dataList.add(objs);
        }
        String fileName="������ʪ��-"+String.valueOf(System.currentTimeMillis()).substring(4,13)+".xls";
        CommonExcel ex = new CommonExcel(title, rowsName, dataList,response,fileName);
        ex.downloadExcel();
	}
}
