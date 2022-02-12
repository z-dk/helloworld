package com.zdk.hello;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.IOException;
import java.util.Collections;
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
@SuppressWarnings("unused")
public class CodeGenerator {

    public static void main(String[] args) throws IOException {
        generatorByTableName("province","province");
    }
    
    public static void generatorByTableName(String tableName,String packageName, String ... filterTablePrefix) {
        String projectPath = System.getProperty("user.dir") + "\\hello-web\\src\\main\\java";
        
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/hello-world?useSSL=false", "root", "Mysql@1111")
                .globalConfig(builder -> {
                    builder.author("zdk") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "todo"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(packageName) // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "todo")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置需要生成的表名
                            .addTablePrefix(filterTablePrefix); // 设置过滤表前缀
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine()) 
                .execute();
    }
    
    public static void templateConfig(AutoGenerator mpg,String moduleName){
        
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
