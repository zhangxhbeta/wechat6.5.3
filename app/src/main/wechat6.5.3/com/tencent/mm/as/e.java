package com.tencent.mm.as;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.bco;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import junit.framework.Assert;

public final class e extends k implements j {
    String aST = null;
    private b cif;
    private com.tencent.mm.v.e cii;
    private keep_SceneResult dgL = null;
    private a dgM = null;

    interface a {
        void aS(int i, int i2);
    }

    public e(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar) {
        boolean z = false;
        Assert.assertTrue(str != null);
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        this.aST = str;
        this.dgL = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.dgM = aVar;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        n lp = p.lp(this.aST);
        if (lp == null) {
            v.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.aST);
            this.dgM.aS(3, -1);
            return -1;
        }
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bco();
        aVar.czo = new bcp();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.czm = 149;
        aVar.czp = 39;
        aVar.czq = 1000000039;
        this.cif = aVar.Bv();
        bco com_tencent_mm_protocal_c_bco = (bco) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bco.mYk = 0;
        com_tencent_mm_protocal_c_bco.mYj = this.dgL.field_fileLength;
        com_tencent_mm_protocal_c_bco.mYl = new are().ba(new byte[0]);
        com_tencent_mm_protocal_c_bco.mHB = 0;
        com_tencent_mm_protocal_c_bco.mHA = this.dgL.field_thumbimgLength;
        com_tencent_mm_protocal_c_bco.mHC = new are().ba(new byte[0]);
        com_tencent_mm_protocal_c_bco.gon = com.tencent.mm.model.k.xF();
        com_tencent_mm_protocal_c_bco.gom = this.dgL.field_toUser;
        com_tencent_mm_protocal_c_bco.mcN = this.aST;
        if (lp.dhO == 1) {
            com_tencent_mm_protocal_c_bco.mYn = 2;
        }
        if (lp.dhR == 3) {
            com_tencent_mm_protocal_c_bco.mYn = 3;
        }
        com_tencent_mm_protocal_c_bco.mYm = lp.dhK;
        com_tencent_mm_protocal_c_bco.mpt = aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bco.mHD = 2;
        com_tencent_mm_protocal_c_bco.mYc = this.dgL.field_thumbimgLength;
        com_tencent_mm_protocal_c_bco.mYo = this.dgL.field_fileId;
        com_tencent_mm_protocal_c_bco.mDH = this.dgL.field_fileId;
        com_tencent_mm_protocal_c_bco.mfj = 1;
        if (this.dgL.isUploadBySafeCDNWithMD5()) {
            v.i("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", Boolean.valueOf(this.dgL.field_upload_by_safecdn), Integer.valueOf(this.dgL.field_UploadHitCacheType), Integer.valueOf(this.dgL.field_filecrc), this.dgL.field_aesKey);
            com_tencent_mm_protocal_c_bco.mRj = 1;
            com_tencent_mm_protocal_c_bco.mjT = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_bco.mDJ = SQLiteDatabase.KeyEmpty;
        } else {
            com_tencent_mm_protocal_c_bco.mjT = this.dgL.field_aesKey;
            com_tencent_mm_protocal_c_bco.mDJ = this.dgL.field_aesKey;
        }
        com_tencent_mm_protocal_c_bco.mYq = this.dgL.field_filemd5;
        com_tencent_mm_protocal_c_bco.mYA = this.dgL.field_mp4identifymd5;
        com_tencent_mm_protocal_c_bco.mjU = this.dgL.field_filecrc;
        com_tencent_mm_protocal_c_bco.mbZ = ax.zr();
        com_tencent_mm_protocal_c_bco.mYz = lp.bnY;
        ayk com_tencent_mm_protocal_c_ayk = lp.dhT;
        if (com_tencent_mm_protocal_c_ayk != null && !be.kS(com_tencent_mm_protocal_c_ayk.cqg)) {
            com_tencent_mm_protocal_c_bco.mYr = be.ah(com_tencent_mm_protocal_c_ayk.cqg, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYs = com_tencent_mm_protocal_c_ayk.mtD;
            com_tencent_mm_protocal_c_bco.mYt = be.ah(com_tencent_mm_protocal_c_ayk.cqi, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYv = be.ah(com_tencent_mm_protocal_c_ayk.cqk, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYu = be.ah(com_tencent_mm_protocal_c_ayk.cqj, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYw = be.ah(com_tencent_mm_protocal_c_ayk.cql, SQLiteDatabase.KeyEmpty);
        } else if (!(com_tencent_mm_protocal_c_ayk == null || be.kS(com_tencent_mm_protocal_c_ayk.cqk) || be.kS(com_tencent_mm_protocal_c_ayk.cqj))) {
            com_tencent_mm_protocal_c_bco.mYv = com_tencent_mm_protocal_c_ayk.cqk;
            com_tencent_mm_protocal_c_bco.mYu = com_tencent_mm_protocal_c_ayk.cqj;
        }
        if (com_tencent_mm_protocal_c_ayk != null) {
            com_tencent_mm_protocal_c_bco.mYy = be.ah(com_tencent_mm_protocal_c_ayk.cqm, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYx = be.ah(com_tencent_mm_protocal_c_ayk.cqn, SQLiteDatabase.KeyEmpty);
        }
        k.KV();
        Options JS = d.JS(o.ld(this.aST));
        if (JS != null) {
            com_tencent_mm_protocal_c_bco.mYe = JS.outWidth;
            com_tencent_mm_protocal_c_bco.mYd = JS.outHeight;
        } else {
            v.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", r1);
        }
        String str = "MicroMsg.NetSceneUploadVideoForCdn";
        String str2 = "summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s";
        Object[] objArr = new Object[18];
        objArr[0] = this.aST;
        objArr[1] = this.dgL.field_toUser;
        objArr[2] = Integer.valueOf(this.dgL.field_aesKey == null ? -1 : this.dgL.field_aesKey.length());
        objArr[3] = this.dgL.field_fileId;
        objArr[4] = Integer.valueOf(this.dgL.field_thumbimgLength);
        objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_bco.mYe);
        objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_bco.mYd);
        objArr[7] = be.KW(com_tencent_mm_protocal_c_bco.mDJ);
        objArr[8] = Integer.valueOf(com_tencent_mm_protocal_c_bco.mYn);
        objArr[9] = com_tencent_mm_protocal_c_bco.mYq;
        objArr[10] = Integer.valueOf(com_tencent_mm_protocal_c_bco.mRj);
        objArr[11] = Integer.valueOf(com_tencent_mm_protocal_c_bco.mjU);
        objArr[12] = com_tencent_mm_protocal_c_bco.mYA;
        objArr[13] = be.KW(com_tencent_mm_protocal_c_bco.mjT);
        objArr[14] = com_tencent_mm_protocal_c_bco.mYr;
        objArr[15] = Integer.valueOf(com_tencent_mm_protocal_c_bco.mYs);
        objArr[16] = com_tencent_mm_protocal_c_bco.mYt;
        objArr[17] = com_tencent_mm_protocal_c_bco.mYw;
        v.i(str, str2, objArr);
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 1;
    }

    protected final void a(a aVar) {
        p.lh(this.aST);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUploadVideoForCdn", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        bcp com_tencent_mm_protocal_c_bcp = (bcp) ((b) pVar).czl.czs;
        n lp = p.lp(this.aST);
        if (lp == null) {
            v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.aST);
            this.cii.a(i2, i3, str, this);
            this.dgM.aS(3, -1);
        } else if (i2 == 4 && i3 == MMGIFException.D_GIF_ERR_READ_FAILED) {
            v.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.aST + " user:" + lp.Ld());
            this.cii.a(i2, i3, str, this);
            this.dgM.aS(i2, i3);
        } else if (i2 == 4 && i3 == -22) {
            v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.aST + " user:" + lp.Ld());
            p.li(this.aST);
            this.cii.a(i2, i3, str, this);
            this.dgM.aS(i2, i3);
        } else if (i2 == 4 && i3 != 0) {
            v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.aST + " user:" + lp.Ld());
            p.lh(this.aST);
            this.cii.a(i2, i3, str, this);
            this.dgM.aS(i2, i3);
        } else if (i2 == 0 && i3 == 0) {
            lp.dhI = be.Nh();
            lp.bmL = com_tencent_mm_protocal_c_bcp.mcb;
            v.d("MicroMsg.NetSceneUploadVideoForCdn", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(lp.bmL), Integer.valueOf(q.dqk));
            if (!(10007 != q.dqj || q.dqk == 0 || lp.bmL == 0)) {
                lp.bmL = (long) q.dqk;
                q.dqk = 0;
            }
            lp.status = 199;
            lp.bkU = 1284;
            if (this.dgL.isUploadBySafeCDNWithMD5()) {
                v.d("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn aeskey[%s], old RecvXml[%s]", com_tencent_mm_protocal_c_bcp.mjT, lp.Lg());
                if (be.kS(com_tencent_mm_protocal_c_bcp.mjT)) {
                    v.w("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn need aeskey but ret null");
                } else {
                    v.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + com_tencent_mm_protocal_c_bcp.mjT + "\" cdnthumbaeskey=\"" + com_tencent_mm_protocal_c_bcp.mjT + "\" cdnvideourl=\"" + this.dgL.field_fileId + "\" ") + "cdnthumburl=\"" + this.dgL.field_fileId + "\" ") + "length=\"" + this.dgL.field_fileLength + "\" ") + "cdnthumblength=\"" + this.dgL.field_thumbimgLength + "\"/></msg>");
                    lp.dhQ = r1;
                    o KV = k.KV();
                    k.KV();
                    boolean o = KV.o(o.lc(this.aST), this.dgL.field_fileId, com_tencent_mm_protocal_c_bcp.mjT);
                    g gVar = g.iuh;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf((o ? 1 : 2) + 900);
                    objArr[1] = Integer.valueOf(lp.cyu);
                    gVar.h(12696, objArr);
                    v.d("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", com_tencent_mm_protocal_c_bcp.mjT, lp.Lg(), Boolean.valueOf(o));
                }
            }
            p.e(lp);
            p.c(lp);
            ak.yW();
            com.tencent.mm.modelstat.b.daJ.p(c.wJ().ek((long) lp.dhL));
            String Ld = lp.Ld();
            ak.yW();
            com.tencent.mm.i.a LX = c.wH().LX(Ld);
            boolean bvm = (LX == null || ((int) LX.chr) <= 0) ? false : LX.bvm();
            if (bvm || m.eP(lp.Ld())) {
                v.i("MicroMsg.NetSceneUploadVideoForCdn", "upload to biz :%s", lp.Ld());
                if (lp.bmL < 0) {
                    v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + lp.bmL + " file:" + this.aST + " toUser:" + lp.Ld());
                    p.lh(this.aST);
                    this.dgM.aS(3, -1);
                }
            } else {
                v.i("MicroMsg.NetSceneUploadVideoForCdn", "not upload to biz");
                if (lp.bmL <= 0) {
                    v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + lp.bmL + " file:" + this.aST + " toUser:" + lp.Ld());
                    p.lh(this.aST);
                    this.dgM.aS(3, -1);
                }
            }
            this.cii.a(i2, i3, str, this);
            this.dgM.aS(0, 0);
        } else {
            v.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.aST + " user:" + lp.Ld());
            p.lh(this.aST);
            this.cii.a(i2, i3, str, this);
            this.dgM.aS(i2, i3);
        }
    }

    public final int getType() {
        return 149;
    }
}
