package top.promisedland.nukkitqqbot.util;

import cn.nukkit.Player;
import cn.nukkit.item.Item;

public class ContentMaker {
    private static final String LOCATION = ".location.";
    private static final String INFORMATION = ".information.";
    private static final String ITEMINHAND = ".item.";
    public static String ContentReplacer(String str,Player ply){
        String ctx = null;
        Item itm = ply.getInventory().getItemInHand();
        String image = ImageParser.getItemImage(itm.getNamespaceId());
        ctx = str.replace(
                    LOCATION, FuckSpaces(PlayerLocation(ply)))
                    .replace(INFORMATION,FuckSpaces(PlayerInformation(ply)))
                    .replace(ITEMINHAND,ImageMaker(image) + "物品名称：" + FuckSpaces(itm.getName()) + "%0A");
        ply.sendMessage(ply.getLocation().toString());
        return ctx;
    }
    private static String PlayerLocation(Player ply){
        return "X：" + Math.floor(ply.getX()) + "%20"
                + "Y：" + Math.floor(ply.getY()) + "%20"
                + "Z：" + Math.floor(ply.getZ()) + "%20";
    }
    private static String PlayerInformation(Player ply){
        return "玩家名称：" + ply.getDisplayName() + "%0A"
                + "玩家血量：" + Math.floor(ply.getHealth()) + "%0A"
                + "当前世界：" + ply.getLevelName() + "%0A"
                + "当前延迟：" + ply.getPing() + "%0A";
    }
    private static String ImageMaker(String image){
        return "[CQ:image,file="+image+"]";
    }
    /**
     * Fuck u fucking spaces
     * @param str 原字符串
     * @return 去除后的字符串
     * */
    public static String FuckSpaces(String str){
        return str.replace(" ","%20");
    }
}
