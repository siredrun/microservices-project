package com.baijiaxiu.services.cloud.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liuyufeng
 * @date: 2019-07-17 16:25
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/db/db-mysql/src/main/java/com/baijiaxiu/services/cloud/");
//        gc.setOutputDir("E:/codeGen/bi");
        gc.setAuthor("liuyufeng");
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // 是否覆盖
        gc.setFileOverride(false);
        /**
         * ONLY_DATE：只用 java.util.date 代替
         * SQL_PACK：使用 java.sql.date 代替
         * TIME_PACK：使用 java.time 包下的java8 新的时间类型
         */
        gc.setDateType(DateType.ONLY_DATE);
        generator.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://39.98.227.62:3306/data_centre?useUnicode=true&useSSL=false&serverTimezone=Hongkong");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("BI");
        dsc.setPassword("bi_TEST");
        generator.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("db");
        pc.setParent("com.baijiaxiu.services.cloud");
        generator.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        //    自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/db/db-mysql/src/main/resources/db-cloud/sql/bi/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        // 如果模板引擎是 velocity
        String templateEntityPath = "/templates/entity.java.vm";
        focList.add(new FileOutConfig(templateEntityPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/db/db-mysql/src/main/java/com/baijiaxiu/services/cloud/entity/bi/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        // 如果模板引擎是 velocity
        String templateServicePath = "/templates/service.java.vm";
        focList.add(new FileOutConfig(templateServicePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/bi-stats/src/main/java/com/baijiaxiu/services/cloud/service/" + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });
        // 如果模板引擎是 velocity
        String templateServiceImplPath = "/templates/serviceImpl.java.vm";
        focList.add(new FileOutConfig(templateServiceImplPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/bi-stats/src/main/java/com/baijiaxiu/services/cloud/service/impl/" + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });
        // 如果模板引擎是 velocity
        String templateControllerPath = "/templates/controller.java.vm";
        focList.add(new FileOutConfig(templateControllerPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/bi-stats/src/main/java/com/baijiaxiu/services/cloud/controller/" + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });
        // 如果模板引擎是 velocity
        String templateMapperPath = "/templates/mapper.java.vm";
        focList.add(new FileOutConfig(templateMapperPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/db/db-mysql/src/main/java/com/baijiaxiu/services/cloud/db/mapper/bi/" + tableInfo.getMapperName() + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);
        // 配置模板 使用自定义配置时使用自己的路径
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setEntity(null);
        templateConfig.setMapper(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        generator.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setCapitalMode(true);
        // 表名 多个逗号分隔
        strategy.setInclude("college_worker_performance");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        generator.setStrategy(strategy);
        generator.execute();
    }
}
