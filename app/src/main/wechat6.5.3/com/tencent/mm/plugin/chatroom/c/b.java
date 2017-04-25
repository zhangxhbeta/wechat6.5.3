package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.a;
import java.util.LinkedList;

public final class b extends a<dd> {
    public b(String str, String str2, String str3, LinkedList<String> linkedList) {
        v.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s", new Object[]{str, str2, be.KW(str3), linkedList});
        dc dcVar = new dc();
        dcVar.cTj = str;
        dcVar.mdG = str2;
        dcVar.bax = str3;
        dcVar.mdH = linkedList;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = dcVar;
        aVar.czo = new dd();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
        aVar.czm = 774;
        this.cif = aVar.Bv();
    }
}
