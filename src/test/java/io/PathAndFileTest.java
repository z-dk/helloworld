package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <b>类 名 称</b> :  PathAndFileTest<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/5 16:00<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/5 16:00<br/>
 * <b>修改备注</b> :
 */
public class PathAndFileTest {
    
    public static void main(String[] args) throws IOException {
        fileTest();
    }
    
    private static void fileTest() throws IOException {
        File tempFile = File.createTempFile("hello", ".txt");
        try(FileWriter fileWriter = new FileWriter(tempFile)) {
            fileWriter.append("Hello this is a txt file");
            System.out.println(tempFile.getAbsoluteFile());
            System.out.println(tempFile.getName());
        }
        System.out.println(tempFile.delete());
    }
    
}
