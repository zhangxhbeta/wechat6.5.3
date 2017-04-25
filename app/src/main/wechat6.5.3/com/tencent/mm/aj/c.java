package com.tencent.mm.aj;

import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public String bax;
    public String cTd;
    public LinkedList<String> cTe = new LinkedList();
    public int cTg;
    public LinkedList<String> cTh = new LinkedList();
    public LinkedList<String> cTi = new LinkedList();
    public String cTj = null;
    public String cTk = null;
    public String cTl = null;
    public String text = null;

    public c(Map<String, String> map, at atVar) {
        super(map, atVar);
    }

    protected final boolean HK() {
        int i = 0;
        if (this.values == null) {
            v.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        v.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", be.ma(this.TYPE), Integer.valueOf(this.values.size()));
        if (be.kS(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            v.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", be.ma(this.TYPE));
            return false;
        }
        this.cTd = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername";
        String str4 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.cTl = be.ma((String) this.values.get(str));
        }
        if (this.values.containsKey(str3)) {
            this.cTj = be.ma((String) this.values.get(str3));
        }
        if (this.values.containsKey(str4)) {
            this.cTk = be.ma((String) this.values.get(str4));
        }
        if (this.values.containsKey(cSV)) {
            this.text = be.ma((String) this.values.get(cSV));
        }
        if (this.values.containsKey(str2)) {
            this.bax = (String) this.values.get(str2);
        }
        if (this.values.containsKey(str5)) {
            this.cTg = be.getInt((String) this.values.get(str5), 0);
        }
        if (this.bmk.bwB()) {
            this.cSZ.clear();
            this.cTa.clear();
            this.cTb.clear();
            this.cSX = this.text + " ";
            this.cTa.add(Integer.valueOf(this.cSX.length()));
            this.cSZ.add(aa.getContext().getString(2131233277));
            this.cSX += aa.getContext().getString(2131233277);
            this.cTb.add(Integer.valueOf(this.cSX.length()));
        } else {
            this.cTa.add(Integer.valueOf(this.text.length()));
            this.cSZ.add(this.cTl);
            this.cSX = this.text + this.cTl;
            this.cTb.add(Integer.valueOf(this.cSX.length()));
        }
        while (i < this.cTg) {
            if (i == 0) {
                this.cTe.add(be.ma((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.cTh.add(be.ma((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.cTi.add(be.ma((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.cTe.add(be.ma((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
                this.cTh.add(be.ma((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
                this.cTi.add(be.ma((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        return true;
    }
}
