package cn.qqtextwar.tests;


import java.net.InetSocketAddress;
import java.net.Socket;

public class Test03 {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.out.println("启动");
                Socket socket11 = new Socket();
                socket11.connect(new InetSocketAddress("127.0.0.1",8000));
                socket11.getOutputStream().write("[TextWar]\r\n".getBytes());
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
