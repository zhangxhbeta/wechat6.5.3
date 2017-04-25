package com.tencent.mm.ar;

import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.a.ki;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.h;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;

public final class n implements d {
    public final b b(a aVar) {
        int i = 0;
        bm bmVar = aVar.czu;
        String a = m.a(bmVar.mbU);
        if ("fmessage".equals(a) || bmVar.gll == 37) {
            String a2 = m.a(bmVar.mbW);
            final at.d MB = at.d.MB(a2);
            v.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", Integer.valueOf(MB.scene), a2);
            String xF = k.xF();
            if (MB.lct == null || !MB.lct.equals(xF)) {
                String str;
                h hVar = new h();
                hVar.username = MB.lct;
                hVar.bBY = 3;
                hVar.aP(true);
                hVar.bkU = -1;
                hVar.cyD = MB.nvI;
                hVar.cyC = MB.nvJ;
                v.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", MB.lct, hVar.Be(), hVar.Bf());
                com.tencent.mm.u.n.Bo().a(hVar);
                if (!be.kS(MB.lct)) {
                    if (MB.scene == 18) {
                        l.KE().a(bmVar, MB);
                        ak.yW();
                        c.vf().set(73729, Integer.valueOf(1));
                        ak.yW();
                        ab LX = c.wH().LX(MB.nvR);
                        if (LX == null || ((int) LX.chr) <= 0) {
                            com.tencent.mm.model.ab.a.crZ.a(MB.nvR, null, new com.tencent.mm.model.ab.c.a(this) {
                                final /* synthetic */ n dei;

                                public final void p(String str, boolean z) {
                                    ak.yW();
                                    v.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.wH().LX(MB.nvR)));
                                    com.tencent.mm.sdk.c.b hnVar = new hn();
                                    hnVar.bhi.bhj = MB.nvR;
                                    hnVar.bhi.type = 1;
                                    com.tencent.mm.sdk.c.a.nhr.z(hnVar);
                                }
                            });
                        } else {
                            str = LX.field_username;
                            if (!(str == null || com.tencent.mm.model.m.eB(str))) {
                                LX.setUsername(MB.nvR);
                                LX.bY(null);
                                ak.yW();
                                c.wH().a(str, LX);
                            }
                            com.tencent.mm.sdk.c.b hnVar = new hn();
                            hnVar.bhi.bhj = MB.nvR;
                            hnVar.bhi.type = 1;
                            com.tencent.mm.sdk.c.a.nhr.z(hnVar);
                        }
                    } else if (aw.eM(MB.scene)) {
                        l.KF().a(bmVar, MB);
                        ak.yW();
                        c.vf().set(73730, Integer.valueOf(1));
                    } else if (MB.scene == 48) {
                        com.tencent.mm.sdk.c.b kiVar = new ki();
                        kiVar.bls.blu = a2;
                        kiVar.bls.bdo = MB.lct;
                        com.tencent.mm.sdk.c.a.nhr.z(kiVar);
                    }
                }
                f fVar = new f();
                fVar.field_createTime = e.h(a, (long) bmVar.hNS);
                if (bmVar.eeO == 4) {
                    i = 2;
                }
                fVar.field_isSend = i + 0;
                fVar.field_msgContent = m.a(bmVar.mbW);
                fVar.field_svrId = bmVar.mcb;
                fVar.field_talker = MB.lct;
                ak.yW();
                com.tencent.mm.i.a LX2 = c.wH().LX(MB.biB);
                if (!(LX2 == null || ((int) LX2.chr) == -1)) {
                    fVar.field_chatroomName = MB.biB;
                }
                switch (MB.bdn) {
                    case 2:
                        fVar.field_type = 1;
                        break;
                    case 5:
                        fVar.field_type = 2;
                        break;
                    case 6:
                        fVar.field_type = 3;
                        break;
                    default:
                        fVar.field_type = 1;
                        break;
                }
                if (be.kS(MB.nvR)) {
                    v.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    b kC = l.KD().kC(fVar.field_talker);
                    if (kC != null) {
                        fVar.field_encryptTalker = kC.field_talker;
                        fVar.field_talker = kC.field_talker;
                    }
                    l.KC().a(fVar);
                } else {
                    fVar.field_encryptTalker = MB.nvR;
                    if (l.KD().kB(MB.nvR) != null) {
                        g KC = l.KC();
                        str = fVar.field_encryptTalker;
                        KC.cie.dF("fmessage_msginfo", "update fmessage_msginfo set talker = '" + be.lZ(fVar.field_talker) + "'  where talker = '" + be.lZ(str) + "'");
                        l.KD().kD(fVar.field_encryptTalker);
                    }
                    l.KC().a(fVar);
                }
            } else {
                v.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }
}
