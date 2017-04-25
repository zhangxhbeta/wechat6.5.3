package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.mm.e.a.n;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.o;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.asl;
import com.tencent.mm.protocal.c.asm;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ag extends k implements j {
    long bao = 0;
    at bmk = null;
    String cMU = SQLiteDatabase.KeyEmpty;
    private a cNe = new a(this) {
        final /* synthetic */ ag lAW;

        {
            this.lAW = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            v.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.lAW.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
            if (i == -21005) {
                v.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.lAW.cMU);
                return 0;
            } else if (i != 0) {
                this.lAW.bmk.dh(5);
                ak.yW();
                c.wJ().a(this.lAW.bmk.field_msgId, this.lAW.bmk);
                g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.lAW.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), SQLiteDatabase.KeyEmpty);
                this.lAW.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lAW);
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        v.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.lAW.bmk.dh(5);
                        ak.yW();
                        c.wJ().a(this.lAW.bmk.field_msgId, this.lAW.bmk);
                        g.iuh.h(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.lAW.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.lAW.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.lAW);
                    } else {
                        if (this.lAW.dgF > 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength > 0) {
                            com.tencent.mm.sdk.platformtools.ag.o("SendAppMsgThumbTooBig", this.lAW.dgF + "," + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "," + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, this.lAW.dgF * 2 > com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                        }
                        v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), be.KW(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                        ak.vy().a(new ah(this.lAW.bao, false, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                            final /* synthetic */ AnonymousClass1 lAX;

                            public final void aS(int i, int i2) {
                                v.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                                g.iuh.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.lAX.lAW.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                                this.lAX.lAW.cii.a(i, i2, SQLiteDatabase.KeyEmpty, this.lAX.lAW);
                            }
                        }, this.lAW.jGE, null), 0);
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    private com.tencent.mm.v.b cif;
    e cii;
    int dgF = 0;
    String jGE;
    private String jXL;
    private rc jkm;
    private n lAV;
    long startTime = 0;

    public ag(long j, String str, String str2) {
        this.bao = j;
        this.jGE = str;
        this.jXL = str2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new asl();
        aVar.czo = new asm();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.czm = 222;
        aVar.czp = MMGIFException.D_GIF_ERR_WRONG_RECORD;
        aVar.czq = 1000000107;
        this.cif = aVar.Bv();
        v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", Long.valueOf(j), str, be.KW(str2), be.bur());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (this.startTime == 0) {
            this.startTime = be.Ni();
        }
        ak.yW();
        this.bmk = c.wJ().ek(this.bao);
        if (this.bmk == null || this.bmk.field_msgId != this.bao) {
            return -1;
        }
        com.tencent.mm.q.a.a aVar;
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.bmk.field_content);
        if (dV == null) {
            com.tencent.mm.storage.ag Mv = com.tencent.mm.storage.ag.Mv(this.bmk.field_content);
            if (be.kS(Mv.nva)) {
                dV = new com.tencent.mm.q.a.a();
                dV.cod = Mv.aZy;
                dV.type = 8;
                v.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                aVar = dV;
            } else {
                aVar = com.tencent.mm.q.a.a.dV(Mv.nva);
            }
        } else {
            aVar = dV;
        }
        Assert.assertTrue("content != null [[" + this.bmk.field_content + "]]", aVar != null);
        if (aVar == null) {
            this.bmk = null;
            return -1;
        }
        String str;
        Object obj;
        String str2 = SQLiteDatabase.KeyEmpty;
        if (be.kS(this.bmk.field_imgPath)) {
            str = str2;
        } else {
            str = com.tencent.mm.ae.n.GH().iW(this.bmk.field_imgPath);
        }
        if (aVar.type == 8 || aVar.type == 9 || aVar.type == 6) {
            v.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", Integer.valueOf(aVar.type));
            obj = null;
        } else if (be.kS(str)) {
            v.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", Integer.valueOf(aVar.type));
            obj = null;
        } else {
            this.dgF = com.tencent.mm.a.e.aQ(str);
            if (aVar.type != 33 && this.dgF >= 262144) {
                v.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(this.dgF));
                obj = null;
            } else if (be.kS(aVar.aXa)) {
                com.tencent.mm.modelcdntran.g.DZ();
                if (com.tencent.mm.modelcdntran.c.fk(4)) {
                    this.cMU = d.a("upappmsg", this.bmk.field_createTime, this.bmk.field_talker, this.bmk.field_msgId);
                    if (be.kS(this.cMU)) {
                        v.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", Long.valueOf(this.bmk.field_msgId));
                        obj = null;
                    } else {
                        h hVar = new h();
                        hVar.cFR = this.cNe;
                        hVar.field_mediaId = this.cMU;
                        hVar.field_fullpath = SQLiteDatabase.KeyEmpty;
                        hVar.field_thumbpath = str;
                        hVar.field_fileType = b.MediaType_THUMBIMAGE;
                        hVar.field_talker = this.bmk.field_talker;
                        hVar.field_priority = b.cEA;
                        hVar.field_needStorage = false;
                        hVar.field_isStreamMedia = false;
                        hVar.cFR = this.cNe;
                        hVar.field_force_aeskeycdn = true;
                        hVar.field_trysafecdn = false;
                        v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", Integer.valueOf(aVar.type), str, this.cMU, Integer.valueOf(hVar.field_fileType), Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_onlycheckexist), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn));
                        if (com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                            obj = 1;
                        } else {
                            v.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                            this.cMU = SQLiteDatabase.KeyEmpty;
                            obj = null;
                        }
                    }
                } else {
                    Object[] objArr = new Object[1];
                    com.tencent.mm.modelcdntran.g.DZ();
                    objArr[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(4));
                    v.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", objArr);
                    obj = null;
                }
            } else {
                v.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", Long.valueOf(this.bao));
                obj = null;
            }
        }
        if (obj != null) {
            v.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", this.cMU);
            return 0;
        }
        String str3;
        asl com_tencent_mm_protocal_c_asl = (asl) this.cif.czk.czs;
        co coVar = new co();
        coVar.glj = aVar.appId;
        coVar.mcN = this.bmk.field_talker + this.bmk.field_msgId + "T" + this.bmk.field_createTime;
        coVar.hQP = com.tencent.mm.q.a.a.a(aVar, null, null, 0, 0);
        coVar.hNS = (int) be.Nh();
        coVar.gom = this.bmk.field_talker;
        coVar.gon = com.tencent.mm.model.k.xF();
        coVar.efm = aVar.type;
        coVar.mcM = aVar.sdkVer;
        coVar.mcP = aVar.coe;
        if (com.tencent.mm.modelbiz.e.hC(this.bmk.field_talker)) {
            coVar.mbZ = com.tencent.mm.modelbiz.a.e.hY(this.bmk.bNo);
        } else {
            coVar.mbZ = ax.zr();
        }
        coVar.mcR = aVar.bnU;
        coVar.mcS = aVar.bnV;
        coVar.mcT = aVar.bnW;
        o.b fy = o.yx().fy(this.jGE);
        if (fy != null) {
            this.jkm = new rc();
            this.jkm.bsP.url = aVar.url;
            this.jkm.bsP.bsQ = fy.getString("prePublishId", SQLiteDatabase.KeyEmpty);
            this.jkm.bsP.bsS = fy.getString("preUsername", SQLiteDatabase.KeyEmpty);
            this.jkm.bsP.bsT = fy.getString("preChatName", SQLiteDatabase.KeyEmpty);
            this.jkm.bsP.bsU = fy.bf("preMsgIndex");
            this.jkm.bsP.bsY = fy.bf("sendAppMsgScene");
            this.jkm.bsP.bsZ = fy.bf("getA8KeyScene");
            this.jkm.bsP.bta = fy.getString("referUrl", null);
            this.jkm.bsP.btb = fy.getString("adExtStr", null);
            this.jkm.bsP.bsV = this.bmk.field_talker;
            this.jkm.bsP.btc = aVar.title;
            ak.yW();
            u LX = c.wH().LX(this.bmk.field_talker);
            if (LX != null) {
                this.jkm.bsP.bsW = LX.tT();
            }
            this.jkm.bsP.bsX = i.el(this.bmk.field_talker);
            str3 = SQLiteDatabase.KeyEmpty;
            if (aVar.bnY != null) {
                axz com_tencent_mm_protocal_c_axz = new axz();
                try {
                    com_tencent_mm_protocal_c_axz.az(Base64.decode(aVar.bnY, 0));
                    if (com_tencent_mm_protocal_c_axz.mVv != null) {
                        str3 = com_tencent_mm_protocal_c_axz.mVv.ghW;
                    }
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_asl.mRi = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.jkm.bsP.bsQ, this.jkm.bsP.bsS, this.jkm.bsP.bsT, Integer.valueOf(com.tencent.mm.model.n.F(this.jkm.bsP.bsS, this.jkm.bsP.bsT)), Integer.valueOf(this.jkm.bsP.bsZ), str3});
        }
        if (fy != null && aVar.type == 33) {
            this.lAV = new n();
            int bf = fy.bf("fromScene");
            this.lAV.aWO.scene = bf;
            String string = fy.getString("preChatName", SQLiteDatabase.KeyEmpty);
            if (2 == bf) {
                this.lAV.aWO.aWP = string + ":" + fy.getString("preUsername", SQLiteDatabase.KeyEmpty);
            } else {
                this.lAV.aWO.aWP = string;
            }
            str3 = this.bmk.field_talker;
            boolean z = fy.getBoolean("moreRetrAction", false);
            if (str3.endsWith("@chatroom")) {
                this.lAV.aWO.action = z ? 5 : 2;
            } else {
                this.lAV.aWO.action = z ? 4 : 1;
            }
            this.lAV.aWO.aWQ = aVar.cqo;
            this.lAV.aWO.aWH = aVar.cqp;
            this.lAV.aWO.appId = aVar.cqq;
            this.lAV.aWO.aWS = be.Nh();
            this.lAV.aWO.aWT = 1;
        }
        v.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", aVar.bnU, aVar.bnV, aVar.bnW);
        if (!be.kS(str)) {
            byte[] c = com.tencent.mm.a.e.c(str, 0, -1);
            if (!be.bl(c)) {
                coVar.mcO = new are().ba(c);
            }
        }
        str3 = "MicroMsg.NetSceneSendAppMsg";
        String str4 = "doScene thumbFile:[%s] thumbdata:%d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(coVar.mcO != null ? coVar.mcO.mQu : -1);
        v.d(str3, str4, objArr2);
        com_tencent_mm_protocal_c_asl.mRg = coVar;
        if (aVar.cof != 0 || aVar.cob > 26214400) {
            com_tencent_mm_protocal_c_asl.mdC = b.cEC;
        }
        com_tencent_mm_protocal_c_asl.mpC = aVar.filemd5;
        com_tencent_mm_protocal_c_asl.cHf = this.jXL;
        v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", com_tencent_mm_protocal_c_asl.mpC, be.KW(com_tencent_mm_protocal_c_asl.cHf), Integer.valueOf(com_tencent_mm_protocal_c_asl.mdC), com_tencent_mm_protocal_c_asl.mRi);
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.bao), this.bmk.field_content);
        if (i2 == 3 && i3 == -1 && !be.kS(this.cMU)) {
            v.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.cMU);
        } else if (i2 == 0 && i3 == 0) {
            asm com_tencent_mm_protocal_c_asm = (asm) ((com.tencent.mm.v.b) pVar).czl.czs;
            asl com_tencent_mm_protocal_c_asl = (asl) ((com.tencent.mm.v.b) pVar).czk.czs;
            this.bmk.dh(2);
            this.bmk.y(com_tencent_mm_protocal_c_asm.mcb);
            ak.yW();
            c.wJ().a(this.bmk.field_msgId, this.bmk);
            com.tencent.mm.modelstat.b.daJ.p(this.bmk);
            if (!(this.jkm == null || be.kS(this.jkm.bsP.url))) {
                this.jkm.bsP.bsR = "msg_" + Long.toString(com_tencent_mm_protocal_c_asm.mcb);
                com.tencent.mm.sdk.c.a.nhr.z(this.jkm);
            }
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.bmk.field_content);
            if (dV != null && "wx4310bbd51be7d979".equals(dV.appId)) {
                Object obj = (be.kS(this.bmk.field_talker) || !this.bmk.field_talker.endsWith("@chatroom")) ? null : 1;
                String str2 = SQLiteDatabase.KeyEmpty;
                try {
                    str2 = URLEncoder.encode(dV.description, "UTF-8");
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneSendAppMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                v.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", "1," + (obj != null ? 2 : 1) + ",," + str2);
                g.iuh.Y(13717, r0);
            }
            if (this.lAV != null) {
                this.lAV.aWO.aWR = "msg_" + this.bmk.field_msgSvrId;
                com.tencent.mm.sdk.c.a.nhr.z(this.lAV);
            }
            if (com_tencent_mm_protocal_c_asl.mRg.mcO != null) {
                g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(com_tencent_mm_protocal_c_asl.mRg.mcO.mQu));
            }
            this.cii.a(i2, i3, str, this);
        } else {
            this.bmk.dh(5);
            ak.yW();
            c.wJ().a(this.bmk.field_msgId, this.bmk);
            v.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + i2 + "," + i3 + ", msgId " + this.bmk.field_msgId);
            if (i2 == 4) {
                g.iuh.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(0));
            }
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 222;
    }

    protected final int a(p pVar) {
        return b.czU;
    }
}
