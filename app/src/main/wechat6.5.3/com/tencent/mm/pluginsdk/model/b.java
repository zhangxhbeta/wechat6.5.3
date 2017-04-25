package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.ar.h;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b implements d {
    public final com.tencent.mm.v.d.b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null || bmVar.gll != 47) {
            v.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
            return null;
        }
        String a = m.a(bmVar.mbU);
        String a2 = m.a(bmVar.mbV);
        ak.yW();
        if (!((String) c.vf().get(2, null)).equals(a)) {
            a2 = a;
        }
        String a3 = m.a(bmVar.mbW);
        if (!j.a.bmr().a(a2, a3, bmVar.mcb, bmVar.mbZ, aVar)) {
            v.w("MicroMsg.EmojiExtension", "emoji plugin not found");
            at atVar = new at();
            atVar.setType(47);
            atVar.cH(a2);
            atVar.di(k.eo(a) ? 1 : 0);
            atVar.cI("no_plugin_md5");
            atVar.y(bmVar.mcb);
            atVar.setContent(a3);
            atVar.z(atVar.field_isSend == 1 ? aw.fN(atVar.field_talker) : aw.h(atVar.field_talker, (long) bmVar.hNS));
            atVar.dh(3);
            atVar.cN(bmVar.mbZ);
            aw.a(atVar, aVar);
            ak.yW();
            c.wJ().R(atVar);
        }
        com.tencent.mm.model.aw.b fP = aw.fP(bmVar.mbZ);
        if (fP != null) {
            v.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", fP.ctu);
            if (fP.ctw != null && fP.scene == 1) {
                a2 = m.a(bmVar.mbU);
                ak.yW();
                c.vf().set(73729, Integer.valueOf(1));
                h hVar = new h();
                hVar.field_content = aa.getContext().getString(2131234014);
                hVar.field_createtime = be.Nh();
                hVar.field_imgpath = SQLiteDatabase.KeyEmpty;
                hVar.field_sayhicontent = hVar.field_content;
                hVar.field_sayhiuser = a2;
                hVar.field_scene = 18;
                hVar.field_status = bmVar.eeO > 3 ? bmVar.eeO : 3;
                hVar.field_svrid = bmVar.mcb;
                hVar.field_talker = a2;
                hVar.field_type = bmVar.gll;
                hVar.field_isSend = 0;
                hVar.field_sayhiencryptuser = a2;
                hVar.field_ticket = fP.ctw;
                l.KE().a(hVar);
                com.tencent.mm.sdk.c.b hnVar = new hn();
                hnVar.bhi.bhj = a2;
                com.tencent.mm.sdk.c.a.nhr.z(hnVar);
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }
}
