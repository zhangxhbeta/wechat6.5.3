package com.tencent.mm.modelstat;

import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {

    public enum a {
        Expose(1),
        Click(2);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(at atVar, a aVar) {
        if (!be.kS(atVar.bNx)) {
            int i;
            c cVar = new c();
            cVar.n("20ExpIdStr", atVar.bNx + ",");
            cVar.n("21OpType", aVar.value + ",");
            cVar.n("22msgId", atVar.field_msgSvrId + ",");
            cVar.n("23MessageType", atVar.field_type + ",");
            if (atVar.bvY()) {
                com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(atVar.field_content, atVar.field_reserved);
                i = B == null ? 0 : B.type;
            } else {
                i = 0;
            }
            String str = atVar.field_talker;
            cVar.n("24AppMsgInnerType", i + ",");
            cVar.n("25curUsername", str + ",");
            String str2 = SQLiteDatabase.KeyEmpty;
            if (atVar.field_isSend == 1) {
                str2 = k.xF();
            } else if (str == null || !str.endsWith("@chatroom")) {
                str2 = str;
            } else if (atVar.field_content != null) {
                int fK = aw.fK(atVar.field_content);
                if (fK != -1) {
                    str2 = atVar.field_content.substring(0, fK).trim();
                }
            }
            cVar.n("26msgPostUserName", str2 + ",");
            cVar.n("27MediaState", atVar.bNy + ",");
            v.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + cVar.JH());
            g.iuh.h(13564, cVar);
        }
    }
}
