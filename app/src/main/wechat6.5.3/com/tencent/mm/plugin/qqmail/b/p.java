package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mm.v.k.a;
import java.util.Random;

public final class p extends k implements j {
    private String blm;
    private f cMP;
    private b cif;
    private e cii;
    private int cyu = 0;
    private int cyv = 0;
    public String filePath = null;

    public p(String str, String str2, f fVar) {
        this.filePath = str;
        this.blm = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.cMP = fVar;
        v.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[]{this.blm, this.filePath});
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bbz com_tencent_mm_protocal_c_bbz = (bbz) ((b) pVar).czl.czs;
            String str2 = com_tencent_mm_protocal_c_bbz.mbN;
            v.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[]{com_tencent_mm_protocal_c_bbz.mbN, Integer.valueOf(com_tencent_mm_protocal_c_bbz.mdz), com_tencent_mm_protocal_c_bbz.mon});
            if (str2.equals(this.blm)) {
                this.cyv = com_tencent_mm_protocal_c_bbz.mdA;
                if (this.cyv < this.cyu) {
                    v.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[]{Integer.valueOf(this.cyv), Integer.valueOf(this.cyu)});
                    if (a(this.czE, this.cii) < 0) {
                        v.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                        if (this.cii != null) {
                            this.cii.a(i2, i3, str, this);
                        }
                        if (this.cMP != null) {
                            this.cMP.a(this.cyv, this.cyu, this);
                            return;
                        }
                        return;
                    }
                }
                String str3 = com_tencent_mm_protocal_c_bbz.mon;
                v.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[]{Integer.valueOf(this.cyv), Integer.valueOf(this.cyu), str3});
                if (this.cii != null) {
                    this.cii.a(i2, i3, str, this);
                }
                if (this.cMP != null) {
                    this.cMP.a(this.cyv, this.cyu, this);
                }
            }
        } else if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    protected final int ul() {
        return 640;
    }

    protected final int a(com.tencent.mm.network.p pVar) {
        if (!be.kS(this.filePath) && com.tencent.mm.a.e.aR(this.filePath)) {
            return k.b.czU;
        }
        v.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
        return k.b.czV;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 484;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (be.kS(this.filePath)) {
            v.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            return -1;
        } else if (com.tencent.mm.a.e.aR(this.filePath)) {
            if (this.cyu == 0) {
                this.cyu = com.tencent.mm.a.e.aQ(this.filePath);
                v.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[]{Integer.valueOf(this.cyu)});
            }
            int min = Math.min(this.cyu - this.cyv, 32768);
            v.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[]{Integer.valueOf(this.cyv), Integer.valueOf(min)});
            byte[] c = com.tencent.mm.a.e.c(this.filePath, this.cyv, min);
            if (c == null) {
                v.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                return -1;
            }
            v.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[]{Integer.valueOf(c.length)});
            b.a aVar = new b.a();
            aVar.czn = new bby();
            aVar.czo = new bbz();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadfile";
            aVar.czm = 484;
            aVar.czp = 0;
            aVar.czq = 0;
            this.cif = aVar.Bv();
            bby com_tencent_mm_protocal_c_bby = (bby) this.cif.czk.czs;
            com_tencent_mm_protocal_c_bby.mbN = this.blm;
            com_tencent_mm_protocal_c_bby.mdz = this.cyu;
            com_tencent_mm_protocal_c_bby.mdA = this.cyv;
            com_tencent_mm_protocal_c_bby.mdB = min;
            com_tencent_mm_protocal_c_bby.mfg = m.H(c);
            v.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[]{Integer.valueOf(a(eVar, this.cif, this))});
            return a(eVar, this.cif, this);
        } else {
            v.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[]{this.filePath});
            return -1;
        }
    }

    public final bbz aHz() {
        if (this.cif != null) {
            return (bbz) this.cif.czl.czs;
        }
        return null;
    }
}
