package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.avv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.b.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.OutputStream;

public final class n extends k implements j {
    private b cif;
    public e cii;
    private OutputStream cyK = null;
    private String filename;
    private aib jfX;
    private String jka;
    private int jkb = -1;
    int jkc = -1;
    private boolean jkd = true;
    private String jke = null;
    String mediaId = "";

    public n(aib com_tencent_mm_protocal_c_aib, String str, String str2, int i, boolean z, int i2, String str3) {
        this.mediaId = str;
        this.jfX = com_tencent_mm_protocal_c_aib;
        this.jkd = z;
        this.jkb = i;
        this.jkc = i2;
        this.jke = str3;
        this.jka = al.cA(ad.xh(), str);
        a aVar = new a();
        aVar.czn = new avu();
        aVar.czo = new avv();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        aVar.czm = 208;
        aVar.czp = 96;
        aVar.czq = 1000000096;
        this.cif = aVar.Bv();
        avu com_tencent_mm_protocal_c_avu = (avu) this.cif.czk.czs;
        o BG = ad.aSt().BG(str);
        if (BG == null) {
            BG = new o();
        }
        BG.jCr = str;
        BG.offset = 0;
        ad.aSt().a(str, BG);
        if (z) {
            this.filename = i.m(com_tencent_mm_protocal_c_aib);
        } else {
            this.filename = i.l(com_tencent_mm_protocal_c_aib);
        }
        FileOp.jS(this.jka);
        FileOp.deleteFile(al.cA(ad.xh(), str) + this.filename);
        com_tencent_mm_protocal_c_avu.mTd = str2;
        com_tencent_mm_protocal_c_avu.mTe = 0;
        com_tencent_mm_protocal_c_avu.mdA = 0;
        com_tencent_mm_protocal_c_avu.mdz = 0;
        com_tencent_mm_protocal_c_avu.efm = this.jkb;
        v.d("MicroMsg.NetSceneSnsDownload", "requestKey " + str3);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSnsDownload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        avv com_tencent_mm_protocal_c_avv = (avv) ((b) pVar).czl.czs;
        if (((c) pVar.ze()).lWU != 0) {
            this.cii.a(i2, i3, str, this);
            ad.aSz().Ag(this.jke);
            return;
        }
        o BG = ad.aSt().BG(this.mediaId);
        if (com_tencent_mm_protocal_c_avv.mdz <= 0) {
            v.e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
        } else if (com_tencent_mm_protocal_c_avv.meT == null) {
            v.e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
        } else if (com_tencent_mm_protocal_c_avv.mdA < 0 || com_tencent_mm_protocal_c_avv.mdA + com_tencent_mm_protocal_c_avv.meT.mQw.lVU.length > com_tencent_mm_protocal_c_avv.mdz) {
            v.e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
        } else if (com_tencent_mm_protocal_c_avv.mdA != BG.offset) {
            v.e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
        } else {
            int z = z(com_tencent_mm_protocal_c_avv.meT.mQw.toByteArray());
            if (z < 0) {
                v.e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                return;
            }
            BG.offset += z;
            BG.jCn = com_tencent_mm_protocal_c_avv.mdz;
            v.d("MicroMsg.NetSceneSnsDownload", "byteLen " + z + "  totalLen " + com_tencent_mm_protocal_c_avv.mdz);
            ad.aSt().a(this.mediaId, BG);
            Object obj = (BG.offset != BG.jCn || BG.jCn == 0) ? null : 1;
            if (obj != null) {
                v.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                String c = this.jkc == 1 ? i.c(this.jfX) : i.k(this.jfX);
                String cA = al.cA(ad.xh(), this.mediaId);
                FileOp.deleteFile(cA + c);
                FileOp.n(cA, this.filename, c);
                if (this.jkd) {
                    com.tencent.mm.plugin.sns.storage.p.b(cA, c, i.d(this.jfX), (float) ad.aSK());
                } else {
                    String c2 = i.c(this.jfX);
                    if (!FileOp.aR(cA + c2)) {
                        com.tencent.mm.plugin.sns.storage.p.a(cA, c, c2, (float) ad.aSL());
                    }
                    c2 = i.d(this.jfX);
                    if (!FileOp.aR(cA + c2)) {
                        com.tencent.mm.plugin.sns.storage.p.b(cA, c, c2, (float) ad.aSK());
                    }
                }
                ad.aSz().Ag(this.jke);
                this.cii.a(i2, i3, str, this);
                return;
            }
            a(this.czE, this.cii);
        }
    }

    private void onError() {
        ad.aSz().Ag(this.jke);
    }

    public final int getType() {
        return 208;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 100;
    }

    private int z(byte[] bArr) {
        if (!i.zV(ad.xq())) {
            return 0;
        }
        try {
            if (this.cyK == null) {
                FileOp.jS(this.jka);
                this.cyK = FileOp.gt(this.jka + this.filename);
            }
            v.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
            this.cyK.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneSnsDownload", e, "appendBuf failed: " + this.filename, new Object[0]);
            return -1;
        } finally {
            Bh();
        }
    }

    private void Bh() {
        try {
            if (this.cyK != null) {
                this.cyK.flush();
                this.cyK.close();
                this.cyK = null;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneSnsDownload", e, "", new Object[0]);
        }
    }
}
