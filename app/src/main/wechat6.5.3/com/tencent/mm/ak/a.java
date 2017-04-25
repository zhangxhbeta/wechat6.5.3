package com.tencent.mm.ak;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

final class a extends k implements j {
    public a cTn;
    public final List<com.tencent.mm.ak.j.b> cTo = new ArrayList();
    private e cii;

    static class b extends com.tencent.mm.protocal.l.c implements com.tencent.mm.protocal.l.a {
        public alc cTr = new alc();

        b() {
        }

        public final byte[] zf() {
            return this.cTr.toByteArray();
        }

        public final int zg() {
            return 681;
        }
    }

    static class c extends d implements com.tencent.mm.protocal.l.b {
        public ald cTs = new ald();

        c() {
        }

        public final int y(byte[] bArr) {
            this.cTs = (ald) new ald().az(bArr);
            return this.cTs.mcj;
        }
    }

    static class a extends i {
        private final b cTp = new b();
        final c cTq = new c();

        public final com.tencent.mm.protocal.l.c zd() {
            return this.cTp;
        }

        public final d ze() {
            return this.cTq;
        }

        public final int getType() {
            return 681;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/oplog";
        }
    }

    public a(List<com.tencent.mm.ak.j.b> list) {
        this.cTo.addAll(list);
        this.cTn = new a();
        ((b) this.cTn.Bx()).cTr.mLf = J(list);
    }

    private static la J(List<com.tencent.mm.ak.j.b> list) {
        la laVar = new la();
        for (com.tencent.mm.ak.j.b bVar : list) {
            byte[] buffer = bVar.getBuffer();
            kz kzVar = new kz();
            kzVar.bkM = bVar.getCmdId();
            kzVar.mnB = new are().ba(buffer);
            laVar.eeu.add(kzVar);
        }
        laVar.eet = list.size();
        v.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        return laVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cTn, this);
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 5;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 681;
    }
}
