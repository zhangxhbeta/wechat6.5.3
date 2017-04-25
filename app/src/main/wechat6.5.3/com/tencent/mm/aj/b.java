package com.tencent.mm.aj;

import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
    public String bax = null;
    public String cTd;
    public LinkedList<String> cTe = new LinkedList();
    public String cTf = null;
    public String text = null;

    public b(Map<String, String> map, at atVar) {
        super(map, atVar);
    }

    protected final boolean HK() {
        if (this.values == null) {
            v.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        v.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", be.ma(this.TYPE), Integer.valueOf(this.values.size()));
        if (be.kS(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            v.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", be.ma(this.TYPE));
            return false;
        }
        this.cTd = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket";
        if (this.values.containsKey(cSV)) {
            this.text = be.ma((String) this.values.get(cSV));
        }
        if (this.values.containsKey(str)) {
            this.cTf = be.ma((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.bax = be.ma((String) this.values.get(str2));
        }
        this.cSX = this.text;
        if (this.bmk.bwB()) {
            this.cSX += " " + aa.getContext().getString(2131233279);
        } else {
            this.cSZ.add(this.cTf);
            this.cTa.add(Integer.valueOf(this.cSX.length()));
            this.cSX += this.cTf;
            this.cTb.add(Integer.valueOf(this.cSX.length()));
        }
        for (String str3 : this.values.keySet()) {
            if (str3.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
                this.cTe.add(this.values.get(str3));
            }
        }
        return true;
    }
}
