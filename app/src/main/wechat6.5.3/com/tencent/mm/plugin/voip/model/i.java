package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.voip.model.m.AnonymousClass2;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.b;
import java.util.Map;

public final class i implements d {

    public static final class a {
        public static int ktB = 1;
        public static int ktC = 2;
        public static int ktD = 3;
        public static int ktE = 4;
        public static int ktF = 0;
        public static int ktG = 1;
        public int ktA;
        public int kty;
        public long ktz;
        public int status;

        public final boolean bbT() {
            return this.ktA == ktF;
        }

        public final boolean parse(String str) {
            this.ktA = ktF;
            try {
                Map q = bf.q(str, "voipinvitemsg");
                if (q == null) {
                    return false;
                }
                if (q.get(".voipinvitemsg.roomid") != null) {
                    this.kty = be.getInt((String) q.get(".voipinvitemsg.roomid"), 0);
                }
                if (q.get(".voipinvitemsg.key") != null) {
                    this.ktz = be.getLong((String) q.get(".voipinvitemsg.key"), 0);
                }
                if (q.get(".voipinvitemsg.status") != null) {
                    this.status = be.getInt((String) q.get(".voipinvitemsg.status"), 0);
                }
                if (q.get(".voipinvitemsg.invitetype") != null) {
                    this.ktA = be.getInt((String) q.get(".voipinvitemsg.invitetype"), 0);
                }
                return true;
            } catch (Throwable e) {
                v.a("MicroMsg.VoipExtension", e, "", new Object[0]);
                v.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[]{e.getMessage()});
                return false;
            }
        }
    }

    public final b b(com.tencent.mm.v.d.a aVar) {
        bm bmVar = aVar.czu;
        String a = m.a(bmVar.mbU);
        String a2 = m.a(bmVar.mbV);
        String a3 = m.a(bmVar.mbW);
        v.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[]{a, a3});
        ak.yW();
        au wJ = c.wJ();
        ak.yW();
        String str = (String) c.vf().get(2, "");
        if (str.length() <= 0) {
            return null;
        }
        at atVar;
        at S = wJ.S(str.equals(a) ? a2 : a, bmVar.mcb);
        if (S.field_msgId == 0) {
            S = new at();
            S.y(bmVar.mcb);
            S.z(aw.h(a, (long) bmVar.hNS));
            atVar = S;
        } else {
            atVar = S;
        }
        d.bbw();
        a CN = m.CN(a3);
        if (CN == null) {
            v.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
            return null;
        }
        if ((CN.status == a.ktC ? 1 : null) != null) {
            v.i("MicroMsg.VoipExtension", "recv voip cancel message");
            m bbw = d.bbw();
            if (!(a3 == null || a3.length() == 0)) {
                a aVar2 = new a();
                if (aVar2.parse(a3) && aVar2.status == 2) {
                    bbw.rM(aVar2.kty);
                    n nVar = bbw.kuO;
                    v.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + aVar2.kty);
                    if (nVar.kqI.ksh != null && aVar2.kty == nVar.kqI.ksh.mqS) {
                        nVar.bcP();
                        nVar.kqI.shutdown();
                    }
                }
            }
            if (CN.kty == d.bbw().kuU) {
                v.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
                return null;
            }
            atVar.setType(bmVar.gll);
            atVar.setContent(CN.bbT() ? at.nvC : at.nvB);
            atVar.di(0);
            atVar.cH(a);
            atVar.dh(bmVar.eeO > 3 ? bmVar.eeO : 3);
            atVar.cN(null);
            aw.a(atVar, aVar);
            v.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[]{CN});
            if (atVar.field_msgId == 0) {
                a aVar3;
                if (CN == null) {
                    aVar3 = new a();
                    aVar3.parse(a3);
                } else {
                    aVar3 = CN;
                }
                v.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[]{Integer.valueOf(aVar3.kty)});
                if (d.bbw().kuT.get(Integer.valueOf(aVar3.kty)) == null) {
                    atVar.x(aw.e(atVar));
                    d.bbw().kuT.put(Integer.valueOf(aVar3.kty), Long.valueOf(atVar.field_msgId));
                } else {
                    ak.yW();
                    c.wJ().a(((Long) d.bbw().kuT.get(Integer.valueOf(aVar3.kty))).longValue(), atVar);
                }
                return new b(atVar, true);
            }
            ak.yW();
            c.wJ().b(bmVar.mcb, atVar);
            return new b(atVar, false);
        }
        if ((CN.status == a.ktE ? 1 : null) != null) {
            return null;
        }
        if ((CN.status == a.ktB ? 1 : null) == null) {
            return null;
        }
        v.i("MicroMsg.VoipExtension", "recv voip invite delay");
        ad.o(new AnonymousClass2(d.bbw(), CN.kty, CN.ktz));
        return null;
    }

    public final void d(at atVar) {
    }
}
