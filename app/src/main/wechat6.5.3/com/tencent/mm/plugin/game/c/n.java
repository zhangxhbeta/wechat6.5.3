package com.tencent.mm.plugin.game.c;

import com.tencent.mm.e.b.bf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class n extends bf {
    protected static com.tencent.mm.sdk.h.c.a chq;
    public String dFj = "";
    public String fgr = "";
    public long giA = 0;
    public int giB = 0;
    public String giC = "";
    public String giD = "";
    public String giE = "";
    public String giF = "";
    public String giG = "";
    public String giH = "";
    public String giI = "";
    public String giJ = "";
    public String giK;
    public String giL;
    public String giM;
    public String giN;
    public String giO;
    public e giP;
    public d giQ = new d();
    public f giR = new f();
    public int giS;
    public int giT;
    public String giU;
    public int giV = 0;
    public String giW = "";
    public boolean giX = false;
    private boolean gic = false;
    public String gid = "";
    public String gie = "";
    public String gif = "";
    public String gig = "";
    public String gih = "";
    public int gii = 0;
    public String gij = "";
    public String gik = "";
    public LinkedList<g> gil = new LinkedList();
    public boolean gim;
    public b gin = new b();
    public boolean gio;
    public a gip = new a();
    public HashMap<String, c> giq = new HashMap();
    public String gir = "";
    public int gis = 0;
    public int git = 0;
    public int giu = 0;
    public String giv = "";
    public String giw = "";
    public String gix = "";
    public int giy = 0;
    public long giz = 0;

    public static class a {
        public String can;
        public String giY;
        public String giZ;
    }

    public static class b {
        public String dVK;
        public String giY;
        public int gja;
    }

    public static class c {
        public String fBu;
        public int gjb;
    }

    public static class d {
        public String giY;
        public String giZ;
        public String gjc;
    }

    public static class e {
        public String giZ;
        public String gjd;
        public String gje;
        public String gjf;
    }

    public static class f {
        public String giZ;
        public boolean gjg;
        public String mName;
    }

    public static class g {
        public String aGX;
        public String gjh;
        public String gji;
        public String gjj;
        public String gjk;
        public String userName;
    }

    public final void arp() {
        if (!this.gic) {
            if (this.field_msgType != 100) {
                if (this != null) {
                    if (!be.kS(this.field_rawXML)) {
                        Map q = com.tencent.mm.sdk.platformtools.bf.q(this.field_rawXML, "sysmsg");
                        if (q != null && q.size() != 0) {
                            if ("gamecenter".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
                                this.giy = be.getInt((String) q.get(".sysmsg.gamecenter.wifi_flag"), 0);
                                this.fgr = p.q(q);
                                this.gid = be.ah((String) q.get(".sysmsg.gamecenter.url"), "");
                                this.gir = be.ah((String) q.get(".sysmsg.gamecenter.msg_picture_url"), "");
                                this.gie = be.ah((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
                                if (be.kS(this.gie)) {
                                    this.gie = be.ah((String) q.get(".sysmsg.gamecenter.url"), "");
                                }
                                this.giS = be.getInt((String) q.get(".sysmsg.gamecenter.notify_type"), 0);
                                this.dFj = be.ah((String) q.get(".sysmsg.gamecenter.appinfo.appname2"), "");
                                if (be.kS(this.dFj)) {
                                    this.dFj = be.ah((String) q.get(".sysmsg.gamecenter.appinfo.appname"), "");
                                }
                                if (this.field_msgType == 6) {
                                    this.gij = be.ah((String) q.get(".sysmsg.gamecenter.appinfo.groupname"), "");
                                    this.gik = be.ah((String) q.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
                                } else {
                                    this.gij = this.dFj;
                                }
                                this.gif = be.ah((String) q.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
                                this.gig = be.ah((String) q.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
                                this.gih = be.ah((String) q.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
                                this.gii = be.getInt((String) q.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
                                p.a(q, this);
                                this.giU = be.ah((String) q.get(".sysmsg.gamecenter.noticeid"), "");
                                this.giz = p.r(q);
                                this.gin.gja = be.getInt((String) q.get(".sysmsg.gamecenter.badge_display_type"), 0);
                                this.gin.giY = be.ah((String) q.get(".sysmsg.gamecenter.showiconurl"), "");
                                this.gin.dVK = be.ah((String) q.get(".sysmsg.gamecenter.entrancetext"), "");
                                this.giC = be.ah((String) q.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
                                this.gis = be.getInt((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
                                this.gip.giY = be.ah((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
                                this.gip.can = be.ah((String) q.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
                                this.giV = be.getInt((String) q.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
                                this.giW = be.ah((String) q.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
                                switch (this.field_msgType) {
                                    case 2:
                                        this.git = be.getInt((String) q.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
                                        this.giu = be.getInt((String) q.get(".sysmsg.game_control_info.display_name_type"), 1);
                                        this.giv = be.ah((String) q.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
                                        this.giw = be.ah((String) q.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
                                        this.gix = be.ah((String) q.get(".sysmsg.gameshare.share_message_info.media_url"), "");
                                        this.gir = be.ah((String) q.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
                                        v.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[]{this.field_appId});
                                        break;
                                    case 4:
                                    case 10:
                                    case 11:
                                        break;
                                    case 5:
                                        this.giH = be.ah((String) q.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
                                        this.giI = be.ah((String) q.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
                                        this.giJ = be.ah((String) q.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
                                        break;
                                    case 6:
                                        this.giD = be.ah((String) q.get(".sysmsg.gamecenter.topic.reply_content"), "");
                                        this.giE = be.ah((String) q.get(".sysmsg.gamecenter.topic.replied_content"), "");
                                        this.giG = be.ah((String) q.get(".sysmsg.gamecenter.topic.topic_title"), "");
                                        this.giF = be.ah((String) q.get(".sysmsg.gamecenter.topic.topic_url"), "");
                                        break;
                                    default:
                                        v.e("MicroMsg.GameMessageParser", "error gamecenter type: " + this.field_msgType);
                                        break;
                                }
                            }
                            v.e("MicroMsg.GameMessageParser", "Type not matched");
                        } else {
                            v.e("MicroMsg.GameMessageParser", "Parse failed");
                        }
                    } else {
                        v.e("MicroMsg.GameMessageParser", "msg content is null");
                    }
                } else {
                    v.e("MicroMsg.GameMessageParser", "msg is null");
                }
            } else {
                u.arB();
                if (this == null) {
                    v.e("MicroMsg.GameNewMessageParser", "msg is null");
                } else if (be.kS(this.field_rawXML)) {
                    v.e("MicroMsg.GameNewMessageParser", "msg content is null");
                } else {
                    Map q2 = com.tencent.mm.sdk.platformtools.bf.q(this.field_rawXML, "sysmsg");
                    if (q2 == null || q2.size() == 0) {
                        v.e("MicroMsg.GameNewMessageParser", "Parse failed");
                    } else if ("gamecenter".equalsIgnoreCase((String) q2.get(".sysmsg.$type"))) {
                        this.giK = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
                        this.giL = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
                        this.giM = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
                        this.giQ.gjc = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
                        this.giQ.giY = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
                        this.giQ.giZ = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
                        this.giN = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
                        this.giO = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
                        if (q2.get(".sysmsg.gamecenter.msg_center.msg_sender") != null) {
                            this.giP = new e();
                            this.giP.gjd = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
                            this.giP.gje = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
                            this.giP.gjf = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
                            this.giP.giZ = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
                        }
                        this.gil.clear();
                        String str = ".sysmsg.gamecenter.msg_center.userinfo";
                        int i = 0;
                        while (true) {
                            String str2 = i == 0 ? str : str + i;
                            if (!q2.containsKey(str2)) {
                                break;
                            }
                            g gVar = new g();
                            gVar.userName = be.ah((String) q2.get(str2 + ".username"), "");
                            gVar.aGX = be.ah((String) q2.get(str2 + ".nickname"), "");
                            gVar.gjh = be.ah((String) q2.get(str2 + ".usericon"), "");
                            gVar.gjj = be.ah((String) q2.get(str2 + ".badge_icon"), "");
                            gVar.gjk = be.ah((String) q2.get(str2 + ".$jump_id"), "");
                            this.gil.add(gVar);
                            i++;
                        }
                        this.giR.mName = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
                        this.giR.gjg = be.getInt((String) q2.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0;
                        this.giR.giZ = be.ah((String) q2.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
                        u.b(q2, this);
                        u.c(q2, this);
                        this.gip.giY = be.ah((String) q2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
                        this.gip.can = be.ah((String) q2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
                        this.gip.giZ = be.ah((String) q2.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
                        this.giC = be.ah((String) q2.get(".sysmsg.gamecenter.float_layer.open_url"), "");
                        this.gin.gja = be.getInt((String) q2.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
                        this.gin.giY = be.ah((String) q2.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        this.gin.dVK = be.ah((String) q2.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
                    } else {
                        v.e("MicroMsg.GameNewMessageParser", "Type not matched");
                    }
                }
            }
            this.gic = true;
        }
    }

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[13];
        aVar.bXK = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "msgId";
        aVar.nmd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "msgId";
        aVar.bXK[1] = "mergerId";
        aVar.nmd.put("mergerId", "TEXT");
        stringBuilder.append(" mergerId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "gameMsgId";
        aVar.nmd.put("gameMsgId", "TEXT");
        stringBuilder.append(" gameMsgId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "msgType";
        aVar.nmd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "createTime";
        aVar.nmd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "expireTime";
        aVar.nmd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "showInMsgList";
        aVar.nmd.put("showInMsgList", "INTEGER default 'true' ");
        stringBuilder.append(" showInMsgList INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "isRead";
        aVar.nmd.put("isRead", "INTEGER default 'false' ");
        stringBuilder.append(" isRead INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "label";
        aVar.nmd.put("label", "TEXT default '' ");
        stringBuilder.append(" label TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "isHidden";
        aVar.nmd.put("isHidden", "INTEGER default 'false' ");
        stringBuilder.append(" isHidden INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "weight";
        aVar.nmd.put("weight", "TEXT default '' ");
        stringBuilder.append(" weight TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "rawXML";
        aVar.nmd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        aVar.bXK[13] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }
}
