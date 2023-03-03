package top.promisedland.nukkitqqbot;


import cn.nukkit.event.Event;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginLogger;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import top.promisedland.nukkitqqbot.Bot.BotClient;
import top.promisedland.nukkitqqbot.command.ChatCommand;
import top.promisedland.nukkitqqbot.util.Protocol;
import top.promisedland.nukkitqqbot.util.QQBot;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Main extends PluginBase {
    public static Main INSTANCE;
    public PluginLogger log;
    @Override
    public void onLoad(){
        INSTANCE = this;
        log = new PluginLogger(this);
        this.getServer().getCommandMap().registerSimpleCommands(new ChatCommand());
        try {
            BotClient client = new BotClient(new URI("ws://127.0.0.1:5700/"));
            client.connect();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onEnable(){
        log.info("OnEnable");
    }

    @Override
    public void onDisable(){
        log.info("OnDisable");
    }

    public static Main getINSTANCE() {
        return INSTANCE;
    }

}