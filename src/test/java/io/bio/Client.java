package io.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * <b>类 名 称</b> :  Client<br/>
 * <b>类 描 述</b> :  bio客户端<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/31 10:03<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/31 10:03<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Client {
    
    public static void main(String[] args) throws IOException {
        coonect();
    }
    
    private static void coonect() throws IOException {
        Socket socket = new Socket("localhost", 58090);
    
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("hello server，你好，服务器");
        writer.flush();
        writer.close();
    }
    
}
