package com.crm.Excel;


import java.io.*;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 工具类
 * @Date 2018-06-06
 * @Time 14:07
 */
public class ExcelUtil {
	/**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param object    映射实体类，Excel 模型
     */
	static OutputStream outputStream =null;
    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                  String fileName, String sheetName, BaseRowModel object) throws IOException {
    	try {
			outputStream= response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, object.getClass());
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
        response.setHeader("Content-Type", "applicationnd.openxmlformats-officedocument.spreadsheetml.sheet");
        writer.finish();
        outputStream.flush();
        outputStream.close();
    }

	
	  /**
     * 导出文件时为Writer生成OutputStream
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        try {
            if (!dbfFile.exists() || dbfFile.isDirectory()) {
                dbfFile.createNewFile();
            }
            fileName = new String(filePath.getBytes(), "ISO-8859-1");
            response.addHeader("Content-Disposition", "filename=" + fileName);
            return response.getOutputStream();
        } catch (IOException e) {
        	throw new ExcelException("创建文件失败！");
        }
    }

}
