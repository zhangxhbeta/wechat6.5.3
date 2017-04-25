package com.tencent.mm.modelsimple;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f extends k implements j {
    private p cAt = new a();
    private e cii;

    public static class a extends i {
        private final com.tencent.mm.protocal.m.a cYq = new com.tencent.mm.protocal.m.a();
        private final b cYr = new b();

        protected final c zd() {
            return this.cYq;
        }

        public final d ze() {
            return this.cYr;
        }

        public final int getType() {
            return 0;
        }

        public final String getUri() {
            return null;
        }
    }

    public static void be(boolean z) {
        if (ak.uz() && ak.vy() != null && ak.vy().cAa != null && ak.vy().cAa.BU() != null) {
            if (z) {
                ak.vy().cAa.BU().aS(true);
                ak.vy().a(new f(true), 0);
                return;
            }
            ak.vy().cAa.BU().aS(ge(2));
            ak.vy().a(new f(ge(1)), 0);
        }
    }

    private static boolean ge(int i) {
        int i2;
        if (q.dqQ != -1) {
            i2 = q.dqQ;
        } else {
            try {
                i2 = be.getInt(com.tencent.mm.h.j.sU().getValue("MuteRoomDisable"), 0);
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneBgFg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                i2 = 0;
            }
        }
        v.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", Integer.valueOf(i), Integer.valueOf(q.dqQ), Integer.valueOf(i2), Boolean.valueOf(com.tencent.mm.sdk.b.b.foreground));
        if ((i2 & i) != 0) {
            return true;
        }
        return r3;
    }

    private f(boolean z) {
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.cAt.Bx();
        aVar.netType = com.tencent.mm.protocal.a.getNetType(aa.getContext());
        aVar.lWW = z ? 1 : 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBgFg", " ret[%d]", Integer.valueOf(((b) pVar.ze()).lWX.hKq));
        this.cii.a(i2, i3, str, this);
    }
}
