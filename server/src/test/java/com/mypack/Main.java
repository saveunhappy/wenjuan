package com.mypack;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.course.server.domain.Student;
import com.course.server.service.StudentListener;
import org.junit.Test;

public class Main {
    @Test
    public void test() throws Exception{
        //获取一个工作蒲对象
        ExcelReaderBuilder read = EasyExcel.read("aaa.xlsx", Student.class, new StudentListener());

        ExcelReaderSheetBuilder sheet = read.sheet();

        sheet.doRead();


    }
}
