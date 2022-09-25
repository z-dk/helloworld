package log;

import java.util.Enumeration;
import java.util.logging.*;

/**
 * <b>类 名 称</b> :  JavaLog<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/9/25 9:17<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/9/25 9:17<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class JavaLog {

    private static final Logger LOGGER = Logger.getGlobal();
    
    public static void main(String[] args) {
        // 设置Filter
        LOGGER.setFilter(logRecord -> {
            if (logRecord.getParameters() != null) {
                return logRecord.getParameters().length > 0;
            }
            return false;
        });

        // 默认为空
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        // 多个相同的handler日志会记录多次
        LOGGER.addHandler(consoleHandler);
        Handler[] handlers = LOGGER.getHandlers();

        LogManager logManager = LogManager.getLogManager();
        Enumeration<String> loggerNames = logManager.getLoggerNames();

        LOGGER.info("this is a info log.");
        LOGGER.log(Level.SEVERE, "this is a severe log.");
        LOGGER.log(Level.INFO, "this log handler number is {0}", handlers.length);
        LOGGER.log(Level.INFO, "the next log is {0}", loggerNames.nextElement());

    }
    
}
