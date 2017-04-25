package com.tencent.mm.aq;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bcg;
import com.tencent.mm.protocal.c.bch;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private b cif;
    e cii;
    ah cxS;
    private String dac;
    private int dad;
    private int dae;
    private int daf;
    int dag;
    private int dah;
    private String filemd5;
    String filename;

    public a(String str, int i, int i2, int i3, int i4) {
        this.dac = null;
        this.filemd5 = null;
        this.filename = null;
        this.dad = 0;
        this.dae = 0;
        this.daf = 0;
        this.dag = 0;
        this.dah = 5;
        this.cxS = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ a dai;

            {
                this.dai = r1;
            }

            public final boolean oU() {
                v.d("MicroMsg.NetSceneUploadMedia", g.sm() + " onTimerExpired: file:" + this.dai.filename + " nowlen:" + ((long) com.tencent.mm.a.e.aQ(this.dai.filename)) + " oldoff:" + this.dai.dag);
                if (this.dai.a(this.dai.czE, this.dai.cii) == -1) {
                    this.dai.cii.a(3, -1, "doScene failed", this.dai);
                }
                return false;
            }
        }, true);
        this.dac = be.Ni();
        this.filename = str;
        this.dah = i;
        this.dad = i2;
        this.dae = i3;
        this.daf = i4;
        this.filemd5 = com.tencent.mm.a.g.m(com.tencent.mm.a.e.c(this.filename, 0, com.tencent.mm.a.e.aQ(this.filename)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.cii = eVar2;
        int aQ = com.tencent.mm.a.e.aQ(this.filename);
        v.d("MicroMsg.NetSceneUploadMedia", g.sm() + " read file:" + this.filename + " filelen:" + aQ + " oldoff:" + this.dag + "this.filemd5 " + this.filemd5);
        if (aQ <= 0) {
            v.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            return -1;
        }
        int i2 = aQ - this.dag;
        if (i2 <= 3960) {
            i = i2;
        }
        v.i("MicroMsg.NetSceneUploadMedia", g.sm() + " read file:" + this.filename + " filelen:" + aQ + " oldoff:" + this.dag + "  canReadLen " + i);
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.dag, i);
        if (c == null) {
            v.e("MicroMsg.NetSceneUploadMedia", "read data error");
            return -1;
        }
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bcg();
        aVar.czo = new bch();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        aVar.czm = 240;
        aVar.czp = MMGIFException.D_GIF_ERR_NOT_READABLE;
        aVar.czq = 1000000111;
        this.cif = aVar.Bv();
        bcg com_tencent_mm_protocal_c_bcg = (bcg) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bcg.mXQ = new arf().JF(this.dac);
        com_tencent_mm_protocal_c_bcg.mfg = new are().ba(c);
        com_tencent_mm_protocal_c_bcg.mdB = c.length;
        com_tencent_mm_protocal_c_bcg.mXR = new arf().JF(this.filemd5);
        com_tencent_mm_protocal_c_bcg.mdz = aQ;
        com_tencent_mm_protocal_c_bcg.mdA = this.dag;
        com_tencent_mm_protocal_c_bcg.gng = this.dah;
        com_tencent_mm_protocal_c_bcg.mXS = 1;
        com_tencent_mm_protocal_c_bcg.mXT = this.dad;
        com_tencent_mm_protocal_c_bcg.mXU = this.dae;
        com_tencent_mm_protocal_c_bcg.mXV = this.daf;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 240;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUploadMedia", g.sm() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bcg com_tencent_mm_protocal_c_bcg = (bcg) ((b) pVar).czk.czs;
        String str2 = ((bch) ((b) pVar).czl.czs).mfo;
        v.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", this.filename, str2, Integer.valueOf(com_tencent_mm_protocal_c_bcg.mdz), Integer.valueOf(com_tencent_mm_protocal_c_bcg.mdB), Integer.valueOf(com_tencent_mm_protocal_c_bcg.mdA));
        if (i2 != 0 || i3 != 0) {
            v.e("MicroMsg.NetSceneUploadMedia", g.sm() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
        } else if (com_tencent_mm_protocal_c_bcg.mdz > com_tencent_mm_protocal_c_bcg.mdB + com_tencent_mm_protocal_c_bcg.mdA || str2 == null || str2.equals("0")) {
            this.dag = com_tencent_mm_protocal_c_bcg.mfg.mQu + com_tencent_mm_protocal_c_bcg.mdA;
            v.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.cxS.ea(500);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 60;
    }
}
