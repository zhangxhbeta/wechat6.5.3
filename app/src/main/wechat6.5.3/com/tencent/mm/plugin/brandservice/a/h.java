package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    private String aXp;
    private String bpB;
    private e cii;
    private b exr;
    private aru exs;
    private long ext;
    private int offset;
    private int scene;

    public h(String str, long j, int i, int i2, String str2) {
        this.aXp = str;
        this.ext = j;
        this.offset = i;
        this.scene = i2;
        this.bpB = str2;
        v.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[]{str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.exr != null) {
            this.exs = (aru) this.exr.czl.czs;
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1071;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (be.kS(this.aXp)) {
            v.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
            return -1;
        }
        a aVar = new a();
        aVar.czm = 1071;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
        aVar.czn = new art();
        aVar.czo = new aru();
        aVar.czp = 0;
        aVar.czq = 0;
        this.exr = aVar.Bv();
        art com_tencent_mm_protocal_c_art = (art) this.exr.czk.czs;
        com_tencent_mm_protocal_c_art.mGZ = c.Ig();
        com_tencent_mm_protocal_c_art.mxU = this.aXp;
        com_tencent_mm_protocal_c_art.miQ = this.ext;
        com_tencent_mm_protocal_c_art.mfb = this.offset;
        com_tencent_mm_protocal_c_art.mQL = this.scene;
        com_tencent_mm_protocal_c_art.miU = this.bpB;
        return a(eVar, this.exr, this);
    }

    public final hy Ym() {
        return this.exs == null ? null : this.exs.mQN;
    }
}
