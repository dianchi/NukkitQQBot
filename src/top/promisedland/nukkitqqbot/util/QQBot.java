package top.promisedland.nukkitqqbot.util;

public class QQBot {
    private static String url = "http://127.0.0.1:5700/";

    public static String SendMessage(String message){
        return Protocol.HttpGet(url,"send_group_msg","?group_id=623376778&message="+message);
    }

}
