package com.zdk.hello;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * <b>类 名 称</b> :  CodeGenerator<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创建时间</b> :  2021 01 23 9:45<br/>
 * <b>修 改 人</b> :  zdk<br/>
 * <b>修改时间</b> :  2021 01 23 9:45<br/>
 * <b>修改备注</b> :  <br/>
 * @author  zdk 
 */
public class CodeGenerator {

    public static void main(String[] args) throws IOException {
        generatorByTableName("role","role");
    }
    
    public static void generatorByTableName(String tableName,String packageName) throws IOException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
    
        Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "\\hello-web\\src\\main\\java");
        gc.setAuthor("zdk");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);
    
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/hello-world?useSSL=false");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Mysql@1111");
        mpg.setDataSource(dsc);
    
        //数据表配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude(tableName);
        sc.setNaming(NamingStrategy.underline_to_camel);
        mpg.setStrategy(sc);
        
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.zdk.hello.service."+packageName);
        
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
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
