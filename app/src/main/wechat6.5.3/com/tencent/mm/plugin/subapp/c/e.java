package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class e {
    private static final f<Integer, e> cqx = new f(100);
    public String aXa;
    public int cob;
    public String coc;
    public int kfB;
    public int kfC;
    public String kfD;
    public int kfE;
    public int kfF;
    public int kfG;
    public int kfH;

    public static e Cs(String str) {
        if (be.kS(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        e eVar = (e) cqx.get(Integer.valueOf(hashCode));
        if (eVar != null) {
            return eVar;
        }
        Map q = bf.q(str, "msg");
        if (q == null) {
            v.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
            return null;
        }
        try {
            e eVar2 = new e();
            eVar2.cob = be.getInt((String) q.get(".msg.appmsg.appattach.totallen"), 0);
            eVar2.aXa = (String) q.get(".msg.appmsg.appattach.attachid");
            eVar2.coc = (String) q.get(".msg.appmsg.appattach.fileext");
            eVar2.kfB = be.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
            eVar2.kfC = be.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
            eVar2.kfD = (String) q.get(".msg.appmsg.voicecmd.reminder.$remindattachid");
            eVar2.kfE = be.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
            eVar2.kfF = be.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
            eVar2.kfG = be.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
            eVar2.kfH = be.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
            cqx.k(Integer.valueOf(hashCode), eVar2);
            return eVar2;
        } catch (Throwable e) {
            v.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
            v.a("MicroMsg.VoiceRemindAppMsgExInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }
}
