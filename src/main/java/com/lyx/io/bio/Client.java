package com.lyx.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lvyunxiao
 * @classname Client
 * @description Client
 * @date 2020/5/12
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // Socket s = new Socket("127.0.0.1", 9099);
        Socket s = new Socket("127.0.0.1", 8888);
        // OutputStream out = s.getOutputStream();
        s.getOutputStream().write("HelloServer".getBytes());
        s.getOutputStream().flush();
        System.out.println("write over, waiting for back ... ");
        byte[] bytes = new byte[1024];
        // InputStream in = s.getInputStream();
        int len = s.getInputStream().read(bytes);
        System.out.println("Client read info : " + new String(bytes, 0, len));
        s.close();
    }
}
