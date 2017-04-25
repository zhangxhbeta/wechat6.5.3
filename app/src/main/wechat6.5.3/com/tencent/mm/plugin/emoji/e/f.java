package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.e.a.bz;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.bbu;
import com.tencent.mm.protocal.c.bbv;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.protocal.c.nz;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    private c aYc;
    private final b cif;
    private e cii;
    private boolean fdT = true;

    public f(c cVar) {
        this.aYc = cVar;
        a aVar = new a();
        aVar.czn = new ny();
        aVar.czo = new nz();
        aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        aVar.czm = 703;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ny nyVar = (ny) this.cif.czk.czs;
        bbu com_tencent_mm_protocal_c_bbu = new bbu();
        if (this.aYc != null) {
            g.afx().fch.a(aa.getContext(), this.aYc);
            com_tencent_mm_protocal_c_bbu.mpI = this.aYc.EB();
            com_tencent_mm_protocal_c_bbu.mdz = this.aYc.field_size;
            nyVar.mpP.add(com_tencent_mm_protocal_c_bbu);
        }
    }

    public final int getType() {
        return 703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        int i2 = -1;
        this.cii = eVar2;
        bbu com_tencent_mm_protocal_c_bbu = (bbu) ((ny) this.cif.czk.czs).mpP.get(0);
        int i3;
        byte[] cZ;
        if (this.fdT) {
            v.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + com_tencent_mm_protocal_c_bbu.mpI);
            com_tencent_mm_protocal_c_bbu.mdA = 0;
            i3 = this.aYc.field_size + 0;
            if (i3 <= 8192) {
                i = i3;
            }
            cZ = this.aYc.cZ(0, i);
            if (cZ == null || cZ.length <= 0) {
                v.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            com_tencent_mm_protocal_c_bbu.mdA = 0;
            com_tencent_mm_protocal_c_bbu.mXF = new com.tencent.mm.ba.b(cZ);
            String str = "MicroMsg.emoji.NetSceneEmojiUpload";
            String str2 = "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(cZ.length);
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bbu.mXF.lVU.length);
            objArr[2] = Integer.valueOf(this.aYc == null ? -1 : this.aYc.field_start);
            if (this.aYc != null) {
                i2 = this.aYc.field_size;
            }
            objArr[3] = Integer.valueOf(i2);
            v.i(str, str2, objArr);
            return a(eVar, this.cif, this);
        } else if (this.aYc == null || this.aYc.field_start == 0) {
            v.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            return -1;
        } else {
            i3 = this.aYc.field_size - this.aYc.field_start;
            if (i3 <= 8192) {
                i = i3;
            }
            cZ = this.aYc.cZ(this.aYc.field_start, i);
            if (cZ == null || cZ.length <= 0) {
                v.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            i3 = cZ.length;
            com_tencent_mm_protocal_c_bbu.mdA = this.aYc.field_start;
            com_tencent_mm_protocal_c_bbu.mXF = new com.tencent.mm.ba.b(cZ);
            v.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[]{Integer.valueOf(cZ.length), Integer.valueOf(com_tencent_mm_protocal_c_bbu.mXF.lVU.length)});
            v.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.aYc.field_start + ", total:" + this.aYc.field_size + ", len:" + i3);
            return a(eVar, this.cif, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i2 + " errcode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ny nyVar = (ny) ((b) pVar).czk.czs;
            nz nzVar = (nz) ((b) pVar).czl.czs;
            if (nyVar.mpP.size() != nzVar.mpP.size()) {
                v.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + nyVar.mpP.size() + ", resp size:" + nzVar.mpP.size());
                afJ();
                this.cii.a(i2, i3, str, this);
                d(this.aYc, false);
                return;
            }
            bbv com_tencent_mm_protocal_c_bbv = null;
            if (nzVar.mpP != null && nzVar.mpP.size() > 0) {
                com_tencent_mm_protocal_c_bbv = (bbv) nzVar.mpP.get(0);
            }
            String str2;
            if (com_tencent_mm_protocal_c_bbv == null || com_tencent_mm_protocal_c_bbv.mpI == null || !com_tencent_mm_protocal_c_bbv.mpI.equals(this.aYc.EB()) || com_tencent_mm_protocal_c_bbv.mdA < this.aYc.field_start) {
                String str3 = "MicroMsg.emoji.NetSceneEmojiUpload";
                str2 = "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d";
                Object[] objArr = new Object[5];
                objArr[0] = com_tencent_mm_protocal_c_bbv.mpI;
                objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bbv.mdz);
                objArr[2] = Integer.valueOf(com_tencent_mm_protocal_c_bbv == null ? -1 : com_tencent_mm_protocal_c_bbv.mdA);
                objArr[3] = Integer.valueOf(this.aYc == null ? -1 : this.aYc.field_start);
                objArr[4] = Integer.valueOf(this.aYc == null ? -1 : this.aYc.field_size);
                v.e(str3, str2, objArr);
                afJ();
                this.cii.a(4, -2, "", this);
                d(this.aYc, false);
                return;
            } else if (com_tencent_mm_protocal_c_bbv != null && this.aYc != null && com_tencent_mm_protocal_c_bbv.mcj != 0 && com_tencent_mm_protocal_c_bbv.mdA == com_tencent_mm_protocal_c_bbv.mdz && com_tencent_mm_protocal_c_bbv.mdA > 0) {
                v.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[]{this.aYc.EB(), Integer.valueOf(com_tencent_mm_protocal_c_bbv.mcj), Integer.valueOf(com_tencent_mm_protocal_c_bbv.mdA), Integer.valueOf(com_tencent_mm_protocal_c_bbv.mdz)});
                afJ();
                this.cii.a(i2, i3, "", this);
                return;
            } else if (nzVar.mQl.mcj == 0 && (com_tencent_mm_protocal_c_bbv == null || com_tencent_mm_protocal_c_bbv.mcj == 0)) {
                if (this.fdT) {
                    this.fdT = false;
                }
                if (com_tencent_mm_protocal_c_bbv.mdA >= com_tencent_mm_protocal_c_bbv.mdz) {
                    this.aYc.field_start = 0;
                    this.aYc.field_state = c.nxa;
                    this.aYc.field_needupload = c.nxf;
                    g.afx().fch.r(this.aYc);
                    this.cii.a(i2, i3, "", this);
                    d(this.aYc, true);
                    v.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    return;
                }
                v.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bbv.mdA)});
                this.aYc.field_start = com_tencent_mm_protocal_c_bbv.mdA;
                g.afx().fch.r(this.aYc);
                if (a(this.czE, this.cii) < 0) {
                    this.cii.a(3, -1, "", this);
                    d(this.aYc, false);
                    return;
                }
                return;
            } else {
                str2 = "MicroMsg.emoji.NetSceneEmojiUpload";
                String str4 = "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(nzVar.mQl.mcj);
                objArr2[1] = Integer.valueOf(com_tencent_mm_protocal_c_bbv == null ? -1 : com_tencent_mm_protocal_c_bbv.mcj);
                v.e(str2, str4, objArr2);
                afJ();
                this.cii.a(i2, i3, "", this);
                return;
            }
        }
        afJ();
        this.cii.a(i2, i3, str, this);
        d(this.aYc, false);
    }

    protected final int ul() {
        return 256;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    private void afJ() {
        this.aYc.field_start = 0;
        g.afx().fch.r(this.aYc);
    }

    private static void d(c cVar, boolean z) {
        if (cVar != null && !be.kS(cVar.EB())) {
            v.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[]{cVar.EB(), Boolean.valueOf(z)});
            bz bzVar = new bz();
            bzVar.aZx.aZy = cVar.EB();
            bzVar.aZx.aYt = 0;
            bzVar.aZx.aZz = z;
            com.tencent.mm.sdk.c.a.nhr.z(bzVar);
        }
    }
}
