package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * <b>类 名 称</b> :  Client<br/>
 * <b>类 描 述</b> :  selector示例的客户端<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/29 19:27<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/29 19:27<br/>
 * <b>修改备注</b> :
 */
public class Client {
    
    public static void main(String[] args) {
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1",8800));
    
            ByteBuffer writeBuff = ByteBuffer.allocate(1024);
            ByteBuffer readBuff = ByteBuffer.allocate(1024);
            writeBuff.put("Hello server".getBytes());
            writeBuff.flip();
            
            while (true) {
                writeBuff.rewind();
                channel.write(writeBuff);
                readBuff.clear();
                channel.read(readBuff);
                System.out.println("Client receive:" + new String(readBuff.array()));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
