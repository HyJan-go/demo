package com.example.demo.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: kanjian-job-schedule
 * @description: 生成代码类
 * @author: CanJ
 * @create: 2020-04-02 14:52
 **/
public class CodeGenerator {

    private static boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
    }
    public static void main(String[] args) {

        String author = "HyJan";

        String javaPath = System.getProperty("user.dir") + "/src/main/java/com/example/demo/datasource/";
        String xmlPath = System.getProperty("user.dir") + "/src/main/resources/";

        // 数据库信息配置
        String dbUrl = "jdbc:mysql://192.168.75.134:3306/test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=Asia/Shanghai";
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String uName = "root";
        String pwd = "123456";
        String parentPackage = "com.kanjian99.schedule.datasource";
        String moduleName = "test";

        String[] tableName = {"user"};
//        String[] tableName = {"ods_video_item","ods_video_praise","ods_video_share","ods_video_share_success","ods_video_watch"};
//        String[] tableName = {"st_user_video","st_video_effects"};

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java"); //输出 文件路径
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(dbDriver);
        dsc.setUsername(uName);
        dsc.setPassword(pwd);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(parentPackage);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        //模板配置
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        // 自定义配置会被优先输出，生成的mapper
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/"+ moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成至根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);
        tc.setXml(null);
        mpg.setTemplate(tc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableName); // 需要生成的表
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix("u_");
        mpg.setStrategy(strategy);
        // 设置对应的模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.setTemplateEngine(new BeetlTemplateEngine());

        mpg.execute();
    }

}

