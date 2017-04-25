package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cif;
    private e cxf;
    private int fdR;
    private long fdd = 0;
    private byte[] fec = null;
    private String fee;
    int lcO = -1;
    boolean lcP = true;

    public b(int i, String str, byte[] bArr, int i2, long j) {
        a aVar = new a();
        aVar.czn = new arv();
        aVar.czo = new arw();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        aVar.czm = 234;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fdR = i;
        this.fee = str;
        this.fec = bArr;
        this.lcO = i2;
        this.fdd = j;
    }

    public final int getType() {
        return 234;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        arv com_tencent_mm_protocal_c_arv = (arv) this.cif.czk.czs;
        if (be.bl(this.fec)) {
            com_tencent_mm_protocal_c_arv.mxT = new are();
            this.lcP = true;
        } else {
            com_tencent_mm_protocal_c_arv.mxT = m.H(this.fec);
            this.lcP = false;
            com_tencent_mm_protocal_c_arv.mxW = this.fdd;
        }
        v.d("MicroMsg.emoji.NetSceneSearchEmotion", com_tencent_mm_protocal_c_arv.mxT == null ? "Buf is NULL" : com_tencent_mm_protocal_c_arv.mxT.toString());
        com_tencent_mm_protocal_c_arv.mfK = this.fdR;
        com_tencent_mm_protocal_c_arv.mxU = this.fee;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxf.a(i2, i3, str, this);
    }

    public final arw bhY() {
        return this.cif == null ? null : (arw) this.cif.czl.czs;
    }
}
