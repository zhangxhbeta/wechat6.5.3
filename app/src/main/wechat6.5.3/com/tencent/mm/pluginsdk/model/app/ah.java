package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.mm.e.a.n;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.o;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.asl;
import com.tencent.mm.protocal.c.asm;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Locale;

public final class ah extends k implements j {
    private long bao = 0;
    private at bmk = null;
    private keep_SceneResult cNB = null;
    private b cif;
    private e cii;
    private String jGE;
    private rc jkm;
    private n lAV;
    private b lAY = null;
    private boolean lAZ = false;
    private a lBa = null;

    interface a {
        void aS(int i, int i2);
    }

    public ah(long j, boolean z, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar, String str, b bVar) {
        this.bao = j;
        this.jGE = str;
        this.cNB = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.lBa = aVar;
        this.lAZ = z;
        this.lAY = bVar;
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new asl();
        aVar2.czo = new asm();
        aVar2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar2.czm = 222;
        aVar2.czp = MMGIFException.D_GIF_ERR_WRONG_RECORD;
        aVar2.czq = 1000000107;
        this.cif = aVar2.Bv();
        v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", Long.valueOf(j), com_tencent_mm_modelcdntran_keep_SceneResult, str, bVar, be.bur());
    }

    public final int getType() {
        return 222;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        ak.yW();
        this.bmk = c.wJ().ek(this.bao);
        if (this.bmk == null || this.bmk.field_msgId != this.bao) {
            v.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", Long.valueOf(this.bao));
            this.lBa.aS(3, -1);
            return -1;
        }
        String str;
        int bf;
        String string;
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.bmk.field_content);
        if (dV == null) {
            v.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", Long.valueOf(this.bao));
            this.lBa.aS(3, -1);
        }
        asl com_tencent_mm_protocal_c_asl = (asl) this.cif.czk.czs;
        co coVar = new co();
        coVar.glj = dV.appId;
        coVar.mcN = this.bmk.field_talker + this.bmk.field_msgId + "T" + this.bmk.field_createTime;
        coVar.hNS = (int) be.Nh();
        coVar.gom = this.bmk.field_talker;
        coVar.gon = com.tencent.mm.model.k.xF();
        coVar.efm = dV.type;
        coVar.mcM = dV.sdkVer;
        coVar.mcP = dV.coe;
        if (com.tencent.mm.modelbiz.e.hC(this.bmk.field_talker)) {
            coVar.mbZ = com.tencent.mm.modelbiz.a.e.hY(this.bmk.bNo);
        } else {
            coVar.mbZ = ax.zr();
        }
        coVar.mcR = dV.bnU;
        coVar.mcS = dV.bnV;
        coVar.mcT = dV.bnW;
        o.b fy = o.yx().fy(this.jGE);
        if (fy != null) {
            this.jkm = new rc();
            this.jkm.bsP.url = dV.url;
            this.jkm.bsP.bsQ = fy.getString("prePublishId", SQLiteDatabase.KeyEmpty);
            this.jkm.bsP.bsS = fy.getString("preUsername", SQLiteDatabase.KeyEmpty);
            this.jkm.bsP.bsT = fy.getString("preChatName", SQLiteDatabase.KeyEmpty);
            this.jkm.bsP.bsU = fy.bf("preMsgIndex");
            this.jkm.bsP.bsY = fy.bf("sendAppMsgScene");
            this.jkm.bsP.bsZ = fy.bf("getA8KeyScene");
            this.jkm.bsP.bta = fy.getString("referUrl", null);
            this.jkm.bsP.btb = fy.getString("adExtStr", null);
            this.jkm.bsP.bsV = this.bmk.field_talker;
            this.jkm.bsP.btc = dV.title;
            ak.yW();
            u LX = c.wH().LX(this.bmk.field_talker);
            if (LX != null) {
                this.jkm.bsP.bsW = LX.tT();
            }
            this.jkm.bsP.bsX = i.el(this.bmk.field_talker);
            str = SQLiteDatabase.KeyEmpty;
            if (dV.bnY != null) {
                axz com_tencent_mm_protocal_c_axz = new axz();
                try {
                    com_tencent_mm_protocal_c_axz.az(Base64.decode(dV.bnY, 0));
                    if (com_tencent_mm_protocal_c_axz.mVv != null) {
                        str = com_tencent_mm_protocal_c_axz.mVv.ghW;
                    }
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_asl.mRi = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.jkm.bsP.bsQ, this.jkm.bsP.bsS, this.jkm.bsP.bsT, Integer.valueOf(com.tencent.mm.model.n.F(this.jkm.bsP.bsS, this.jkm.bsP.bsT)), Integer.valueOf(this.jkm.bsP.bsZ), str});
        }
        if (fy != null && dV.type == 33) {
            this.lAV = new n();
            bf = fy.bf("fromScene");
            this.lAV.aWO.scene = bf;
            string = fy.getString("preChatName", SQLiteDatabase.KeyEmpty);
            if (2 == bf) {
                this.lAV.aWO.aWP = string + ":" + fy.getString("preUsername", SQLiteDatabase.KeyEmpty);
            } else {
                this.lAV.aWO.aWP = string;
            }
            str = this.bmk.field_talker;
            boolean z = fy.getBoolean("moreRetrAction", false);
            if (str.endsWith("@chatroom")) {
                this.lAV.aWO.action = z ? 5 : 2;
            } else {
                this.lAV.aWO.action = z ? 4 : 1;
            }
            this.lAV.aWO.aWQ = dV.cqo;
            this.lAV.aWO.aWH = dV.cqp;
            this.lAV.aWO.appId = dV.cqq;
            this.lAV.aWO.aWS = be.Nh();
            this.lAV.aWO.aWT = 1;
        }
        v.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", dV.bnU, dV.bnV, dV.bnW);
        int i = 0;
        bf = 0;
        if (!be.kS(this.bmk.field_imgPath)) {
            Options JS = d.JS(com.tencent.mm.ae.n.GH().iW(this.bmk.field_imgPath));
            if (JS != null) {
                i = JS.outWidth;
                bf = JS.outHeight;
            }
        }
        if (this.cNB.isUploadBySafeCDNWithMD5()) {
            v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", Integer.valueOf(this.cNB.field_filecrc), Boolean.valueOf(this.cNB.field_upload_by_safecdn), Integer.valueOf(this.cNB.field_UploadHitCacheType), this.cNB.field_aesKey);
            this.cNB.field_aesKey = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_asl.mRj = 1;
        }
        com_tencent_mm_protocal_c_asl.mjU = this.cNB.field_filecrc;
        string = null;
        if (this.lAZ) {
            string = "@cdn_" + this.cNB.field_fileId + "_" + this.cNB.field_aesKey + "_1";
        }
        coVar.hQP = com.tencent.mm.q.a.a.a(dV, string, this.cNB, i, bf);
        com_tencent_mm_protocal_c_asl.mRg = coVar;
        if (this.lAY != null && (dV.cof != 0 || dV.cob > 26214400)) {
            com_tencent_mm_protocal_c_asl.cHf = this.lAY.field_signature;
            com_tencent_mm_protocal_c_asl.mdC = com.tencent.mm.modelcdntran.b.cEC;
        }
        com_tencent_mm_protocal_c_asl.mpC = dV.filemd5;
        if (be.kS(this.cNB.field_filemd5)) {
            v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", dV.filemd5);
        } else {
            com_tencent_mm_protocal_c_asl.mpC = this.cNB.field_filemd5;
        }
        v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", com_tencent_mm_protocal_c_asl.mpC, Integer.valueOf(com_tencent_mm_protocal_c_asl.mRj), be.KW(com_tencent_mm_protocal_c_asl.cHf), Integer.valueOf(com_tencent_mm_protocal_c_asl.mdC), this.cNB, com_tencent_mm_protocal_c_asl.mRi);
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        asl com_tencent_mm_protocal_c_asl = (asl) ((b) pVar).czk.czs;
        v.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.bao), this.bmk.field_content, com_tencent_mm_protocal_c_asl.mRg.hQP);
        if (i2 == 0 && i3 == 0) {
            asm com_tencent_mm_protocal_c_asm = (asm) ((b) pVar).czl.czs;
            if (this.cNB != null && this.cNB.isUploadBySafeCDNWithMD5()) {
                v.d("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], old content[%s]", com_tencent_mm_protocal_c_asm.mjT, this.bmk.field_content);
                if (be.kS(com_tencent_mm_protocal_c_asm.mjT)) {
                    v.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
                } else {
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.bmk.field_content);
                    dV.cop = com_tencent_mm_protocal_c_asm.mjT;
                    this.bmk.setContent(com.tencent.mm.q.a.a.b(dV));
                    v.d("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", com_tencent_mm_protocal_c_asm.mjT, this.bmk.field_content);
                }
            }
            this.bmk.dh(2);
            this.bmk.y(com_tencent_mm_protocal_c_asm.mcb);
            ak.yW();
            c.wJ().a(this.bmk.field_msgId, this.bmk);
            com.tencent.mm.modelstat.b.daJ.p(this.bmk);
            this.cii.a(i2, i3, str, this);
            this.lBa.aS(i2, i3);
            if (!(this.jkm == null || be.kS(this.jkm.bsP.url))) {
                this.jkm.bsP.bsR = "msg_" + Long.toString(com_tencent_mm_protocal_c_asm.mcb);
                com.tencent.mm.sdk.c.a.nhr.z(this.jkm);
            }
            if (this.lAV != null) {
                this.lAV.aWO.aWR = "msg_" + this.bmk.field_msgSvrId;
                com.tencent.mm.sdk.c.a.nhr.z(this.lAV);
            }
        } else if (i2 == 4 && i3 == MMGIFException.D_GIF_ERR_READ_FAILED) {
            v.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
            this.cii.a(i2, i3, str, this);
            this.lBa.aS(i2, i3);
        } else {
            this.bmk.dh(5);
            ak.yW();
            c.wJ().a(this.bmk.field_msgId, this.bmk);
            v.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + i2 + "," + i3);
            this.cii.a(i2, i3, str, this);
            this.lBa.aS(i2, i3);
        }
    }
}
