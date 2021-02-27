package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <b>类 名 称</b> :  Server<br/>
 * <b>类 描 述</b> :  bio服务端<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/31 9:59<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/31 9:59<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Server {
    
    public static void main(String[] args) throws IOException {
        startServer();
    }
    
    private static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(58090);
        System.out.println("server start on 8090");
        Socket client = serverSocket.accept();
        
        InputStream inputStream = client.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(reader.readLine());
    }
    
}
