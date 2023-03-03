package top.promisedland.nukkitqqbot.command;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.simple.Arguments;
import cn.nukkit.command.simple.Command;
import cn.nukkit.item.Item;
import top.promisedland.nukkitqqbot.Main;
import top.promisedland.nukkitqqbot.util.ContentMaker;
import top.promisedland.nukkitqqbot.util.ImageParser;
import top.promisedland.nukkitqqbot.util.Protocol;
import top.promisedland.nukkitqqbot.util.QQBot;

import static top.promisedland.nukkitqqbot.util.ContentMaker.*;

public class ChatCommand {
    private Main server = Main.getINSTANCE();
    @Command(name = "qchat",description = "发送消息到QQ群",usageMessage = "/qchat <内容>")
    @Arguments(max = 10,min = 0)
    public boolean onQChatCommand(CommandSender sender, String label, String[] args){
        if (args == null) {
            sender.sendMessage("请输入内容");
            return false;
        }else {
            if (sender.isPlayer()) {
                server.log.info(QQBot.SendMessage(ContentReplacer(sender.getName()+"："+args[0], sender.asPlayer())));
            } else{
                server.log.info(QQBot.SendMessage(sender.getName()+": "+args[0]));
            }
        }
        return true;
    }

}
