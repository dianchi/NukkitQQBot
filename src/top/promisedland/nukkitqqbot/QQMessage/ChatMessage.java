package top.promisedland.nukkitqqbot.QQMessage;

public class ChatMessage extends BaseMessage{
    private String message_type;
    private String sub_type;
    private long group_id;
    private long target_id;
    private boolean anonymous;
    private String message;
    private BaseMessage sender;

    public boolean isAnonymous() {
        return anonymous;
    }

    public String getMessage() {
        return message;
    }

    public long getGroup_id() {
        return group_id;
    }

    public long getTarget_id() {
        return target_id;
    }

    public String getMessage_type() {
        return message_type;
    }

    public String getSub_type() {
        return sub_type;
    }
}
