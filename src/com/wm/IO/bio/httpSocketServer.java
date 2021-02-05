package com.wm.IO.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wm
 * @Package com.wm.IO.bio
 * @date 2021/2/2 17:56
 */
public class httpSocketServer {

    public static void main(String[] args) throws IOException {
        // 缓存线程池,最大线程数为200,60秒回收线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 200,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务启动成功");

        while (!serverSocket.isClosed()) {
            // TODO 会阻塞等待客户端连接
            Socket request = serverSocket.accept();
            System.out.println("收到新的连接:" + request.toString());

            // 为了满足同时能够处理多个客户端连接的需求,专门分配一个线程来处理客户的请求.但是最大只能处理200个任务,超过200个任务还是会阻塞
            threadPoolExecutor.execute(() -> {
                try {
                    // 读取连接的数据打印出来
                    BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
                    String requestMsg;

                    // TODO 没读取到数据会阻塞
                    while ((requestMsg = reader.readLine()) != null) {
                        if (requestMsg.length() != 0) {
                            System.out.println(requestMsg);
                        } else {
                            break;
                        }
                    }
                    System.out.println("收到数据,来自于:" + request.toString());


                    //响应客户端
                    OutputStream outputStream = request.getOutputStream();
                    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                    outputStream.write("Content-Length 11\r\n\r\n".getBytes());
                    outputStream.write("Hello World".getBytes());
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

