package com.tencent.mm.ae;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bci;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class l extends k implements j {
    private d cNL;
    private a cNM;
    private int cNw;
    private final b cif;
    private e cii;

    interface a {
        void a(long j, int i, int i2, int i3);
    }

    public l(int i, bci com_tencent_mm_protocal_c_bci, d dVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar) {
        int i2;
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new bci();
        aVar2.czo = new bcj();
        aVar2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar2.czm = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        this.cif = aVar2.Bv();
        this.cNM = aVar;
        this.cNw = i;
        this.cNL = dVar;
        bci com_tencent_mm_protocal_c_bci2 = (bci) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bci2.mbU = com_tencent_mm_protocal_c_bci.mbU;
        com_tencent_mm_protocal_c_bci2.mbV = com_tencent_mm_protocal_c_bci.mbV;
        com_tencent_mm_protocal_c_bci2.mXW = com_tencent_mm_protocal_c_bci.mXW;
        com_tencent_mm_protocal_c_bci2.gll = com_tencent_mm_protocal_c_bci.gll;
        com_tencent_mm_protocal_c_bci2.mbZ = com_tencent_mm_protocal_c_bci.mbZ;
        com_tencent_mm_protocal_c_bci2.mYf = com_tencent_mm_protocal_c_bci.mYf;
        Options JS = d.JS(n.GH().l(dVar.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
        com_tencent_mm_protocal_c_bci2.mYe = JS != null ? JS.outWidth : 0;
        if (JS != null) {
            i2 = JS.outHeight;
        } else {
            i2 = 0;
        }
        com_tencent_mm_protocal_c_bci2.mYd = i2;
        com_tencent_mm_protocal_c_bci2.mYb = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        com_tencent_mm_protocal_c_bci2.mYc = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bci2.mdz = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bci2.mdA = 0;
        com_tencent_mm_protocal_c_bci2.mdB = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bci2.mfg = new are().ba(new byte[0]);
        com_tencent_mm_protocal_c_bci2.mfj = 1;
        if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
            v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc), com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
            com_tencent_mm_protocal_c_bci2.mRj = 1;
            com_tencent_mm_protocal_c_bci2.mjT = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_bci2.mDJ = SQLiteDatabase.KeyEmpty;
        } else {
            com_tencent_mm_protocal_c_bci2.mjT = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
            com_tencent_mm_protocal_c_bci2.mDJ = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
        }
        com_tencent_mm_protocal_c_bci2.mzC = com_tencent_mm_protocal_c_bci.mzC;
        if (com_tencent_mm_protocal_c_bci.mzC == 1) {
            com_tencent_mm_protocal_c_bci2.mXZ = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
            com_tencent_mm_protocal_c_bci2.mYa = com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength;
            com_tencent_mm_protocal_c_bci2.mXX = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
            com_tencent_mm_protocal_c_bci2.mXY = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        } else {
            com_tencent_mm_protocal_c_bci2.mXZ = 0;
            com_tencent_mm_protocal_c_bci2.mYa = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
            com_tencent_mm_protocal_c_bci2.mXX = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_bci2.mXY = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        }
        com_tencent_mm_protocal_c_bci2.mjU = com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc;
        com_tencent_mm_protocal_c_bci2.mpC = com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5;
        v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bci2.mYf), Integer.valueOf(com_tencent_mm_protocal_c_bci2.mRj), be.KW(com_tencent_mm_protocal_c_bci2.mjT), Integer.valueOf(com_tencent_mm_protocal_c_bci2.mjU));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", ((bci) this.cif.czk.czs).toString());
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        bcj com_tencent_mm_protocal_c_bcj = (bcj) ((b) pVar).czl.czs;
        v.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", Integer.valueOf(com_tencent_mm_protocal_c_bcj.hNS), Long.valueOf(com_tencent_mm_protocal_c_bcj.mcb));
        if (this.cNM != null) {
            this.cNM.a(com_tencent_mm_protocal_c_bcj.mcb, com_tencent_mm_protocal_c_bcj.hNS, i2, i3);
        }
        this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_CLOSE_FAILED;
    }
}
