package com.wm.IO.bio.simpleThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wm
 * @Package com.wm.IO.bio
 * @date 2021/2/2 16:27
 */
public class BioSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务启动成功！");

        while (!serverSocket.isClosed()) {
            //TODO 会阻塞等待客户端连接
            Socket request = serverSocket.accept();
            System.out.println("收到新的连接：" + request.toString());

            //读取连接的数据并打印
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String requestMsg;

            //TODO 没读取到数据会阻塞
            while ((requestMsg = reader.readLine()) != null) {
                if (requestMsg.length() != 0) {
                    System.out.println(requestMsg);
                }
            }
            System.out.println("收到数据，来自于：" + request.toString());
        }
    }
}
