package top.promisedland.nukkitqqbot.util;

import java.util.HashMap;

public class ImageParser {
    private static HashMap<String,String> ItemImage = new HashMap<String,String>() {
        {
            put("minecraft:bow", "https://patchwiki.biligame.com/images/mc/9/9d/7ddfluy1jm7zv1ibxc2igwy8i4oww4k.png");
            put("minecraft:diamond_sword", "https://patchwiki.biligame.com/images/mc/1/14/77xtaugkpmj8feng0em2db4liu6kkxe.png");
        }
    };
    /**
     * 获取物品图片
     * @param id 物品命名空间ID
     * @return 图片URL地址
     */
    public static String getItemImage(String id){
        return ItemImage.get(id);
    }


}
