package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class c implements b {

    public class a {
        private String aYd;
        int fex;
        int fey;
        final /* synthetic */ c fez;
        String thumburl;

        public a(c cVar, int i, int i2, String str, String str2) {
            this.fez = cVar;
            this.fex = i;
            this.fey = i2;
            this.thumburl = str;
            this.aYd = str2;
        }
    }

    public final void a(com.tencent.mm.v.d.a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar.gll == 10002) {
            String a = m.a(bmVar.mbW);
            if (be.kS(a)) {
                v.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
                return;
            }
            Map q = bf.q(a, "sysmsg");
            if (q != null && q.size() > 0) {
                a = (String) q.get(".sysmsg.$type");
                if (be.kS(a) || !a.equalsIgnoreCase("emotionstore")) {
                    v.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :" + a);
                    return;
                }
                try {
                    int i;
                    int i2;
                    String str = (String) q.get(".sysmsg.emotionstore.productid");
                    a = (String) q.get(".sysmsg.emotionstore.newcount");
                    String str2 = (String) q.get(".sysmsg.emotionstore.freecount");
                    String str3 = (String) q.get(".sysmsg.emotionstore.thumburl");
                    if (be.kS(a)) {
                        i = 0;
                    } else {
                        i = Integer.valueOf(a).intValue();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        i2 = 0;
                    } else {
                        i2 = Integer.valueOf(str2).intValue();
                    }
                    a aVar2 = new a(this, i, i2, str3, str);
                    if (be.kS(str)) {
                        a(aVar2);
                    } else {
                        v.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[]{str});
                        ak.vy().a(new j(str, aVar2), 0);
                    }
                    a = (String) q.get(".sysmsg.personalemotion.newcount");
                    if (!be.kS(a) && Integer.valueOf(a).intValue() > 0) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noJ, Boolean.valueOf(true));
                    }
                    a = (String) q.get(".sysmsg.personalemoji.emojicount");
                    if (!be.kS(a) && Integer.valueOf(a).intValue() > 0) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noM, Boolean.valueOf(true));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    v.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[]{be.e(e)});
                    return;
                }
            }
            return;
        }
        v.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(bmVar.gll)});
    }

    public static void a(a aVar) {
        if (aVar == null) {
            v.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
            return;
        }
        if (aVar.fex > 0) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(208899, Boolean.valueOf(true));
            com.tencent.mm.p.c.us().s(262147, true);
        }
        if (aVar.fey > 0) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(208913, Boolean.valueOf(true));
            com.tencent.mm.p.c.us().s(262149, true);
        }
        if (be.kS(aVar.thumburl)) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(229633, "");
            ak.yW();
            com.tencent.mm.model.c.vf().set(229634, "");
            return;
        }
        v.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[]{aVar.thumburl});
        ak.yW();
        com.tencent.mm.model.c.vf().set(229633, aVar.thumburl);
        ak.yW();
        com.tencent.mm.model.c.vf().set(229634, System.currentTimeMillis());
    }
}
