package cn.qqtextwar.tests;

import cn.textwar.protocol.Protocol;
import cn.textwar.protocol.TextWarProtocol;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Test04 {

    public static void main(String[] args) {
        new Thread(()->{
            int i = 0;
            try {
                System.out.println("启动");
                Socket socket11 = new Socket();
                socket11.connect(new InetSocketAddress("127.0.0.1",8765));
                Protocol protocol = new Protocol();
                while (true) {
                    TextWarProtocol protocol1 = new TextWarProtocol().addJSONCode("name",i++);
                    socket11.getOutputStream().write(protocol1.encode());
                    System.out.println(protocol1.getJson());
                    Thread.sleep(100);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
