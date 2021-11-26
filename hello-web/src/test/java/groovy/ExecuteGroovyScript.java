package groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.runtime.InvokerHelper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b>类 名 称</b> :  ExecuteGroovyScript<br/>
 * <b>类 描 述</b> :  groovy脚本执行测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/11/26 22:02<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/11/26 22:02<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class ExecuteGroovyScript {

    private static final GroovyShell shell = new GroovyShell();

    public static void main(String[] args) {
        groovyTest();
    }

    /**
     * 对于groovy脚本, 它默认会生成名字为**script + System.currentTimeMillis() + Math.abs(text.hashCode())**的class类
     * 每传入一次脚本都会生成一个类
     */
    public static void mainTest1() {
        String script = "println 'hello'; 'name = ' + name;";
        Map<String, Object> params = new TreeMap<>();
        params.put("name", "zdk");
        while(true) {
            handle(script, params);
        }
    }

    /**
     * 同一份脚本代码,每次调用都生成一个类,导致频繁发生fullGC(PermGen区满)<br/>
     * 引用下class被gc, 需满足的三个条件:<br/>
     * 1.该类所有的实例都已经被GC<br/>
     * 2.加载该类的ClassLoader已经被GC<br/>
     * 3.该类的java.lang.Class对象没有在任何地方被引用<br/>
     * @param script groovy脚本
     * @param params 脚本参数
     */
    public static void handle(String script, Map<String, Object> params) {
        Binding binding = new Binding();
        for ( Map.Entry<String, Object> ent : params.entrySet() ) {
            binding.setVariable(ent.getKey(), ent.getValue());
        }
        Script sci = shell.parse(script);
        sci.setBinding(binding);
        sci.run();
    }

    // 使用map容器缓存同一份脚本生成的class对象,避免同一脚本生成多份class对象
    private static final ConcurrentHashMap<String, Class<Script>> clazzMaps = new ConcurrentHashMap<>();

    /**
     * 正确的使用方式
     * @param scriptText groovy脚本
     * @param params 脚本参数
     * @return 脚本执行结果
     */
    public static Object invoke(String scriptText, Map<String, Object> params) {
        String key = fingerKey(scriptText);
        Class<Script> script = clazzMaps.get(key);
        if ( script == null ) {
            synchronized (key.intern()) {
                // Double Check
                script = clazzMaps.get(key);
                if (script == null ) {
                    GroovyClassLoader classLoader = new GroovyClassLoader();
                    script = classLoader.parseClass(scriptText);
                    clazzMaps.put(key, script);
                }
            }
        }

        Binding binding = new Binding();
        for ( Map.Entry<String, Object> ent : params.entrySet() ) {
            binding.setVariable(ent.getKey(), ent.getValue());
        }
        Script scriptObj = InvokerHelper.createScript(script, binding);
        return scriptObj.run();
    }

    // 为脚本代码生成md5指纹
    public static String fingerKey(String scriptText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(scriptText.getBytes(StandardCharsets.UTF_8));

            final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
            StringBuilder ret = new StringBuilder(bytes.length * 2);
            for (byte aByte : bytes) {
                ret.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
                ret.append(HEX_DIGITS[aByte & 0x0f]);
            }
            return ret.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void groovyTest() {
        // \*) groovy 代码
        String script = "println 'hello'; 'name = ' + name;";

        // \*) 传入参数
        Binding binding = new Binding();
        binding.setVariable("name", "zdk");

        // \*) 执行脚本代码
        GroovyShell shell = new GroovyShell(binding);
        Object res = shell.evaluate(script);
        System.out.println(res);
    }
    
}
