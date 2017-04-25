package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.a;
import java.util.List;
import java.util.Map;

public final class e implements b {
    public final void a(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar.gll == 10002) {
            String a = m.a(bmVar.mbW);
            if (be.kS(a)) {
                v.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
                return;
            }
            Map q = bf.q(a, "sysmsg");
            if (q != null && q.size() > 0) {
                String str = (String) q.get(".sysmsg.$type");
                if (be.kS(str) || !str.equalsIgnoreCase("NewRecommendEmotion")) {
                    v.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                }
                List rF = d.rF(a);
                String[] strArr = new String[]{"1", com.tencent.mm.storage.a.a.nwG, "7"};
                g.afx().fci.cie.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", strArr);
                com.tencent.mm.storage.a.b bVar = g.afx().fci;
                v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
                bVar.ch(rF);
                return;
            }
            return;
        }
        v.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(bmVar.gll)});
    }
}
