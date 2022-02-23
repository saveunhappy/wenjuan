package com.course.generator.server;

import com.course.generator.util.DbUtil;
import com.course.generator.util.Field;
import com.course.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.*;

public class ServerGenerator {
    static String MODULE = "business";
    static String toDtoPath = "server\\src\\main\\java\\com\\course\\server\\dto\\";
    static String toServicePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
    static String toControllerPath = MODULE + "\\src\\main\\java\\com\\course\\" + MODULE + "\\controller\\admin\\";

    public static void main(String[] args) throws Exception {
        String Domain = "Section";
        String domain = "section";
        String tableNameCn = "小节";
        String module = MODULE;
        //获取所有的类型，名称啊，类型啊，注释啊。
        List<Field> fieldList = DbUtil.getColumnByTableName(domain);
        //进行去重，为了import，就是类型，
        Set<String> typeSet = getJavaTypes(fieldList);
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        map.put("tableNameCn", tableNameCn);
        map.put("module", module);
        map.put("fieldList", fieldList);
        map.put("typeSet", typeSet);
        //生成dto
        FreemarkerUtil.initConfig("dto.ftl");
        FreemarkerUtil.generate(toDtoPath + Domain + "Dto.java", map);

        //生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generate(toServicePath + Domain + "Service.java", map);

        //生成controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generate(toControllerPath + Domain + "Controller.java", map);

    }
    /**
     * 获取所有的Java类型，使用Set去重,这个就是用来import使用的。
     */
    private static Set<String> getJavaTypes(List<Field> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            set.add(field.getJavaType());
        }
        return set;
    }
}
