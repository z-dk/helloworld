package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    
    Logger LOGGER = LoggerFactory.getLogger(PathAndFileTest.class);
    
    public static void main(String[] args) throws IOException {
        System.out.println(find(new int[]{1,2,5,6,7,8,9,11}, 11));
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
    
    public static int find(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (target != arr[(left+right)/2]) {
            int mid = (left+right)/2;
            if (target > arr[mid]) {
                left = mid;
            } else if (target < arr[mid]) {
                right = mid;
            }
        }
        return (left+right)/2;
    }
    
}
