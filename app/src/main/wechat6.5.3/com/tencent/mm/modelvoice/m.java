package com.tencent.mm.modelvoice;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.c.b.i;
import com.tencent.mm.e.a.lr;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bf;
import com.tencent.mm.v.d;
import java.util.HashMap;
import junit.framework.Assert;

public class m implements ag {
    private static HashMap<Integer, c> bXq;
    private bf djA;
    private i djB;
    private r djC = new r();
    private com.tencent.mm.sdk.c.c djD = new com.tencent.mm.sdk.c.c<lr>(this) {
        final /* synthetic */ m djE;

        {
            this.djE = r2;
            this.nhz = lr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            int i = (int) ((lr) bVar).bmV.aXd.field_msgId;
            ak.yW();
            at ek = com.tencent.mm.model.c.wJ().ek((long) i);
            if (!(ek.field_msgId == 0 || ek.field_imgPath == null || be.kS(ek.field_imgPath))) {
                p lJ = m.Lz().lJ(ek.field_imgPath);
                if (!(lJ == null || be.kS(lJ.aST))) {
                    lJ.status = 3;
                    lJ.dgC = 0;
                    lJ.dhH = System.currentTimeMillis() / 1000;
                    lJ.dhI = System.currentTimeMillis() / 1000;
                    lJ.bkU = 8648;
                    q.a(lJ);
                    v.d("MicroMsg.VoiceLogic", " file:" + lJ.aST + " msgid:" + lJ.dhL + "  stat:" + lJ.status);
                    if (lJ.dhL == 0 || be.kS(lJ.ble)) {
                        v.e("MicroMsg.VoiceLogic", " failed msg id:" + lJ.dhL + " user:" + lJ.ble);
                    } else {
                        ek.dh(1);
                        ak.yW();
                        com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
                        m.LB().run();
                    }
                }
            }
            return false;
        }
    };
    private u djz;

    private static m Ly() {
        m mVar = (m) ak.yP().fY(m.class.getName());
        if (mVar != null) {
            return mVar;
        }
        Object mVar2 = new m();
        ak.yP().a(m.class.getName(), mVar2);
        return mVar2;
    }

    public static u Lz() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Ly().djz == null) {
            String str = "dataDB is null ";
            ak.yW();
            Assert.assertTrue(str, com.tencent.mm.model.c.wE() != null);
            m Ly = Ly();
            ak.yW();
            Ly.djz = new u(com.tencent.mm.model.c.wE());
        }
        return Ly().djz;
    }

    public static bf LA() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Ly().djA == null) {
            String str = "dataDB is null ";
            ak.yW();
            Assert.assertTrue(str, com.tencent.mm.model.c.wE() != null);
            m Ly = Ly();
            ak.yW();
            Ly.djA = new bf(com.tencent.mm.model.c.wE());
        }
        return Ly().djA;
    }

    public static i LB() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (Ly().djB == null) {
            Ly().djB = new i();
        }
        return Ly().djB;
    }

    public final void th() {
        if (Ly().djB != null) {
            Ly().djB.aVw = 0;
        }
        d.c.aw(Integer.valueOf(34));
        a.nhr.f(this.djD);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return u.cic;
            }
        });
        bXq.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return bf.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(34), this.djC);
        a.nhr.e(this.djD);
    }

    public final void aH(boolean z) {
    }
}
