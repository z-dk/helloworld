package com.zhudengkui.helloworld;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    public static void main(String[] args) throws IOException {
        generatorByTableName("user","user");
    }
    
    public static void generatorByTableName(String tableName,String packageName) throws IOException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
    
        Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zdk");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);
    
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(properties.getProperty("spring.datasource.url"));
        dsc.setDriverName(properties.getProperty("spring.datasource.driver-class-name"));
        dsc.setUsername(properties.getProperty("spring.datasource.data-username"));
        dsc.setPassword(properties.getProperty("spring.datasource.data-password"));
        mpg.setDataSource(dsc);
    
        //数据表配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude(tableName);
        sc.setNaming(NamingStrategy.underline_to_camel);
        mpg.setStrategy(sc);
        
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.zhudengkui.helloworld."+packageName);
        
        mpg.setPackageInfo(pc);
        
        mpg.execute();
    }
    
    public static void templateConfig(AutoGenerator mpg,String moduleName){
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
    
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
    
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
    
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(moduleName + "_");
        mpg.setStrategy(strategy);
    }
    
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
