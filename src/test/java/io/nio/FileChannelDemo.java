package io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * <b>类 名 称</b> :  FileChannelDemo<br/>
 * <b>类 描 述</b> :  NIO的FileChannel的使用示例<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/29 16:18<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/29 16:18<br/>
 * <b>修改备注</b> :
 */
public class FileChannelDemo {
    
    public static void main(String[] args) {
        writeFile();
        readFile();
    }
    
    private static void writeFile() {
        RandomAccessFile raf = null;
        FileChannel inChannel = null;
        try {
            raf = new RandomAccessFile("E:/environment/java/workSpace/helloword/src/main/resources/static/files/NIO.txt","rw");
            inChannel = raf.getChannel();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // try with resource方式实现--优雅地--关闭资源
        String path = "E:/environment/java/workSpace/helloword/src/main/resources/static/files/NIO.txt";
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(path,"rw");
                 FileChannel fileChannel = randomAccessFile.getChannel()) {
            ByteBuffer writeBuffer = ByteBuffer.allocate(24);
            writeBuffer.put("new filechannel test".getBytes());
    
            // 把Buffer变为读模式
            writeBuffer.flip();
            // 从buffer中读取数据并写入到Channel中
            fileChannel.write(writeBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 方法描述: nio读取文件数据，如有中文等字符时，缓存区字节数可能不足以完成中文字符的转换，需另使用字符buffer并使用utf-8
     * 对于不足转换字符的剩余字节进行保存以和下次的字节一起完成转换
     * @param 
     * @return void
     * @author zdk
     * <br/><b>创建时间:</b>2020/11/29 17:48
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/29 17:48
     * @since  1.0.0
     */
    private static void readFile() {
        RandomAccessFile raf = null;
        FileChannel inChannel = null;
        try {
            raf = new RandomAccessFile("E:/environment/java/workSpace/helloword/src/main/resources/static/files/NIO.txt","rw");
            inChannel = raf.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(24);
            CharBuffer charBuffer = CharBuffer.allocate(24);
    
            CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
            int bytesRead = inChannel.read(readBuffer);
            int leftNum;    // 未成功转码的字节数
            byte[] remainByte = null;
            while (bytesRead != -1) {
                System.out.println("Read:" + bytesRead);
                // 把Buffer变为读模式
                readBuffer.flip();
                charsetDecoder.decode(readBuffer, charBuffer, true);
                charBuffer.flip();
                
                leftNum = readBuffer.limit() - readBuffer.position();
                if (leftNum > 0) {
                    remainByte = new byte[leftNum];
                    readBuffer.get(remainByte,0,leftNum);
                }
                while (charBuffer.hasRemaining()) {
                    System.out.print(charBuffer.get());
                }
                
                // 清空缓存区，切换为写模式
                readBuffer.clear();
                charBuffer.clear();
                if (remainByte != null) {
                    readBuffer.put(remainByte); // 未转换完的字节写入
                }
                bytesRead = inChannel.read(readBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
