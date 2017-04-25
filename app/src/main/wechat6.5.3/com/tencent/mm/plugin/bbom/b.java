package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ae.n;
import com.tencent.mm.ar.h;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.d.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b implements com.tencent.mm.model.e.b {
    public final void a(a aVar, at atVar, final String str, String str2, boolean z) {
        int i = 1;
        final bm bmVar = aVar.czu;
        final com.tencent.mm.model.aw.b fP = aw.fP(bmVar.mbZ);
        if (fP != null) {
            atVar.cO(fP.ctv);
            atVar.cL(fP.ctu);
            v.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", fP.ctu);
            if (!(fP.ctw == null || fP.scene != 1 || bmVar.gll == 10000)) {
                ak.yW();
                com.tencent.mm.i.a LX = c.wH().LX(str);
                if (LX == null || ((int) LX.chr) <= 0) {
                    ab.a.crZ.a(str, null, new ab.c.a(this) {
                        final /* synthetic */ b enS;

                        public final void p(String str, boolean z) {
                            ak.yW();
                            b.a(bmVar, fP, c.wH().LX(str));
                        }
                    });
                } else {
                    a(bmVar, fP, LX);
                }
            }
        }
        int i2;
        if (m.eC(str) && m.fs(str)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!m.dE(str) || m.fr(str)) {
            i = 0;
        }
        if (!z && atVar.bwj() && r0 == 0 && r1 == 0) {
            com.tencent.mm.modelcontrol.c.Eg();
            if (com.tencent.mm.modelcontrol.c.h(atVar)) {
                com.tencent.mm.ae.a GJ = n.GJ();
                long j = atVar.field_msgId;
                com.tencent.mm.modelcontrol.c.Eg();
                if (com.tencent.mm.modelcontrol.c.Eh()) {
                    synchronized (GJ.cKP) {
                        if (GJ.cKP.size() >= 100) {
                            GJ.cKP.remove(0);
                        }
                        GJ.cKP.push(Long.valueOf(j));
                    }
                    GJ.cKT = System.currentTimeMillis();
                    GJ.start();
                }
            }
        }
    }

    static void a(bm bmVar, com.tencent.mm.model.aw.b bVar, u uVar) {
        int i;
        String a = com.tencent.mm.platformtools.m.a(bmVar.mbU);
        ak.yW();
        c.vf().set(73729, Integer.valueOf(1));
        String str = uVar.field_nickname;
        h hVar = new h();
        hVar.field_content = com.tencent.mm.platformtools.m.a(bmVar.mbW);
        hVar.field_createtime = be.Nh();
        hVar.field_imgpath = SQLiteDatabase.KeyEmpty;
        hVar.field_sayhicontent = bmVar.gll == 3 ? aa.getContext().getString(2131234015) : com.tencent.mm.platformtools.m.a(bmVar.mbW);
        hVar.field_sayhiuser = a;
        hVar.field_scene = 18;
        if (bmVar.eeO > 3) {
            i = bmVar.eeO;
        } else {
            i = 3;
        }
        hVar.field_status = i;
        hVar.field_svrid = bmVar.mcb;
        hVar.field_talker = str;
        hVar.field_type = bmVar.gll;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = a;
        hVar.field_ticket = bVar.ctw;
        l.KE().a(hVar);
        com.tencent.mm.sdk.c.b hnVar = new hn();
        hnVar.bhi.bhj = a;
        com.tencent.mm.sdk.c.a.nhr.z(hnVar);
    }
}
