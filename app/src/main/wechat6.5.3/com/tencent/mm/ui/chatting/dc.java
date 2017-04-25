package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.be;
import java.util.Map;

final class dc {
    public String cCj;
    public String cqG;
    public String cqH;
    public String cqI;
    public String cqJ;
    public String cqK;
    public String eHB;
    public long time;
    public String title;
    public int type;
    public String url;

    dc() {
    }

    public static dc X(Map<String, String> map) {
        dc dcVar = new dc();
        dcVar.title = (String) map.get(".msg.appmsg.mmreader.category.item.title");
        dcVar.url = (String) map.get(".msg.appmsg.mmreader.category.item.url");
        dcVar.cCj = (String) map.get(".msg.appmsg.mmreader.category.item.native_url");
        dcVar.cqG = (String) map.get(".msg.appmsg.mmreader.category.item.shorturl");
        dcVar.cqH = (String) map.get(".msg.appmsg.mmreader.category.item.longurl");
        dcVar.time = be.getLong((String) map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
        dcVar.cqI = (String) map.get(".msg.appmsg.mmreader.category.item.cover");
        dcVar.cqJ = (String) map.get(".msg.appmsg.mmreader.category.item.tweetid");
        dcVar.cqK = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        dcVar.type = be.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
        dcVar.eHB = (String) map.get(".msg.appmsg.template_id");
        return dcVar;
    }
}
