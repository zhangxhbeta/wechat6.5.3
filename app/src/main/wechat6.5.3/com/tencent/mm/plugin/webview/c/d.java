package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.modelsearch.c;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.c.a.a;
import com.tencent.mm.protocal.c.bir;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;

public final class d extends c implements j {
    private b cQA;
    private e cii;
    private int lcV;
    private bis ldE;

    public d(a aVar) {
        this.cVg = aVar.aXp;
        this.vI = aVar.offset;
        this.cVh = aVar.scene;
        this.cVf = aVar.bkE;
        this.lcV = aVar.lcV;
        if (be.kS(aVar.aXp)) {
            v.e("MicroMsg.FTS.NetSceneWebSearch", "keyword is unavailable");
            return;
        }
        v.i("MicroMsg.FTS.NetSceneWebSearch", "Constructors: keyword=%s", new Object[]{aVar.aXp});
        b.a aVar2 = new b.a();
        aVar2.czm = 719;
        aVar2.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
        aVar2.czn = new bir();
        aVar2.czo = new bis();
        this.cQA = aVar2.Bv();
        bir com_tencent_mm_protocal_c_bir = (bir) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_bir.muW = aVar.aXp;
        com_tencent_mm_protocal_c_bir.mPQ = aVar.lcV;
        com_tencent_mm_protocal_c_bir.miQ = (long) aVar.cWS;
        com_tencent_mm_protocal_c_bir.mGZ = h.Ig();
        com_tencent_mm_protocal_c_bir.mfb = aVar.offset;
        com_tencent_mm_protocal_c_bir.ncj = h.cVT;
        com_tencent_mm_protocal_c_bir.mQM = aVar.lcW;
        com_tencent_mm_protocal_c_bir.maG = aVar.scene;
        com_tencent_mm_protocal_c_bir.miU = aVar.bkJ;
        com_tencent_mm_protocal_c_bir.nde = aVar.bkI;
        com_tencent_mm_protocal_c_bir.ndf = aVar.lcX;
        com_tencent_mm_protocal_c_bir.ndh = aVar.lcZ;
        com_tencent_mm_protocal_c_bir.ndg = aVar.lcY;
        com_tencent_mm_protocal_c_bir.ndi = aVar.lda;
        com_tencent_mm_protocal_c_bir.ndj = aVar.ldd;
        com_tencent_mm_protocal_c_bir.ldc = aVar.ldc;
        com_tencent_mm_protocal_c_bir.ndk = aVar.lde;
        String str = "MicroMsg.FTS.NetSceneWebSearch";
        String str2 = "contains location = %b | matchUserSize=%d | scene=%d | businessType=%d | isHomePage=%b | sceneActionType=%d | webViewId=%d";
        Object[] objArr = new Object[7];
        objArr[0] = Boolean.valueOf(com_tencent_mm_protocal_c_bir.mGZ != null);
        objArr[1] = Integer.valueOf(aVar.lcW.size());
        objArr[2] = Integer.valueOf(aVar.scene);
        objArr[3] = Integer.valueOf(aVar.cWS);
        objArr[4] = Integer.valueOf(this.lcV);
        objArr[5] = Integer.valueOf(aVar.bkI);
        objArr[6] = Integer.valueOf(aVar.bkE);
        v.i(str, str2, objArr);
        if (com_tencent_mm_protocal_c_bir.mGZ != null) {
            n.a(2005, com_tencent_mm_protocal_c_bir.mGZ.mjM, com_tencent_mm_protocal_c_bir.mGZ.mjN, com_tencent_mm_protocal_c_bir.mGZ.mrA);
        }
    }

    public final int getType() {
        return 719;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.ldE = (bis) this.cQA.czl.czs;
            if (this.ldE != null) {
                v.v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", new Object[]{this.ldE.min});
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final String AI() {
        return this.ldE != null ? this.ldE.min : "";
    }

    public final int AJ() {
        return this.ldE != null ? this.ldE.ncn : 0;
    }
}
