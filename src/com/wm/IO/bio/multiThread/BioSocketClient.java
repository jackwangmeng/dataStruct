package com.wm.IO.bio.multiThread;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wm
 * @Package com.wm.IO.bio
 * @date 2021/2/2 16:33
 */
public class BioSocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);

        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的内容：");
        String msg = scanner.nextLine();
        outputStream.write(msg.getBytes("UTF-8"));
        outputStream.close();
        scanner.close();
        socket.close();
    }
}
