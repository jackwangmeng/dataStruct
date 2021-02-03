package com.wm.IO.bio.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wm
 * @Package com.wm.IO.bio
 * @date 2021/2/2 16:27
 */
public class BioSocketServer {
    public static void main(String[] args) throws IOException {
        //缓存线程池，最大线程数200,60秒回收线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 200, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<>());

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务启动成功！");

        while (!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
            System.out.println("收到新的连接：" + socket.toString());

            // 为了满足同时能够处理多个客户端连接的需求,专门分配一个线程来处理客户的请求.
            // 但是最大只能处理200个任务,超过200个任务还是会阻塞
            threadPoolExecutor.execute(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    String requestMsg;
                    while ((requestMsg = reader.readLine()) != null) {
                        if (requestMsg.length() != 0) {
                            System.out.println(requestMsg);
                        }
                    }
                    System.out.println("收到数据，来自于：" + socket.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
