package cn.textwar.console;

import cn.textwar.plugins.EventManager;
import cn.textwar.plugins.Listener;
import cn.textwar.plugins.NativeListener;
import cn.textwar.plugins.events.MapLoadEvent;
import cn.textwar.plugins.events.PlayerJoinEvent;
import cn.textwar.protocol.events.PacketReceiveEvent;
import cn.textwar.protocol.events.PacketSendEvent;

@NativeListener
public class ServerListener implements Listener {

    private ServerConsole console;

    public ServerListener(ServerConsole console){
        this.console = console;
    }

    @EventManager
    public void onMap(MapLoadEvent e){
        console.getLogger().info("load map == "+e.getMap().toString());
    }

    @EventManager
    public void onSend(PacketSendEvent e){
        console.getLogger().info("Send Packet - "+e.getProtocol().getJson());
        console.getLogger().info("Send Packet Data - "+e.getProtocol());
    }

    @EventManager
    public void onReceive(PacketReceiveEvent e){
        console.getLogger().info("Receive Packet - "+e.getProtocol().getJson());
        console.getLogger().info("Receive Packet Data - "+e.getProtocol());
    }

    @EventManager
    public void onPlayerJoin(PlayerJoinEvent e){
        console.getLogger().info(e.getPlayer().getId()+" : "+e.getPlayer().getIp()+"/ join in the game ");
    }
}
