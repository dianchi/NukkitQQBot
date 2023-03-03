package top.promisedland.nukkitqqbot.Bot;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import top.promisedland.nukkitqqbot.Main;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import com.google.gson.Gson;
import top.promisedland.nukkitqqbot.QQMessage.BaseMessage;
import top.promisedland.nukkitqqbot.QQMessage.ChatMessage;
import top.promisedland.nukkitqqbot.QQMessage.HeartbeatMessage;


public class BotClient extends WebSocketClient{
    private static Main Server = Main.getINSTANCE();
    public static WebSocketClient client;
    public BotClient(URI serverUri){
        super(serverUri);
    }
    public BotClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    public static void main(String[] args) throws URISyntaxException {
        BotClient c = new BotClient(new URI("ws://127.0.0.1:5700/")); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
        c.connect();
    }
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        Server.log.info("握手成功");
    }

    @Override
    public void onMessage(String msg) {
        System.out.println("收到消息==========" + msg);
        Gson gson = new Gson();
        BaseMessage json = gson.fromJson(msg, BaseMessage.class);
        switch (json.getPost_type()) {
            case "meta_event":
                HeartbeatMessage MetaMessage = gson.fromJson(msg, HeartbeatMessage.class);
                break;
            case "message":
                ChatMessage ChatMessage = gson.fromJson(msg, ChatMessage.class);
                if (ChatMessage.getMessage().contains("/mchat")){
                    Server.getServer().broadcastMessage(ChatMessage.getMessage().replace("/mchat ",""));
                } else if (ChatMessage.getMessage().contains("/execute")) {
                    Server.getServer().executeCommand(Server.getServer().getConsoleSender(),ChatMessage.getMessage().replace("/execute ",""));
                }
                break;
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        Server.log.info("链接已关闭");
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
        Server.log.info("发生错误已关闭");
    }
}
