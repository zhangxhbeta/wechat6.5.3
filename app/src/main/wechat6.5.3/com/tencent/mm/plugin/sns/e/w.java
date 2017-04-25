package com.tencent.mm.plugin.sns.e;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.avo;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.c.axf;
import com.tencent.mm.protocal.c.bah;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.io.ByteArrayOutputStream;

public final class w extends k implements j {
    public String cMU;
    int cMV;
    private a cNe;
    private int cNp;
    private b cif;
    public e cii;
    private int cyu;
    private int jdV;
    private String jkL;
    private axe jkM;
    private String jkN;
    private boolean jkO;
    private boolean jkP;
    private boolean jkQ;
    long jkR;
    int jkS;
    private int offset;
    private String path;
    long startTime;

    static /* synthetic */ void a(w wVar, int i) {
        for (int i2 : com.tencent.mm.modelcdntran.a.cEy) {
            if (i == i2) {
                wVar.pX(0);
                return;
            }
        }
        wVar.onError();
    }

    public w(int i, String str, boolean z, int i2) {
        this.cNp = 8192;
        this.offset = 0;
        this.path = "";
        this.jkL = "";
        this.jdV = 0;
        this.jkN = "";
        this.cMU = "";
        this.jkO = false;
        this.jkP = false;
        this.jkQ = false;
        this.jkR = 0;
        this.startTime = 0;
        this.cMV = 0;
        this.jkS = 0;
        this.cNe = new a(this) {
            final /* synthetic */ w jkT;

            {
                this.jkT = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21005) {
                    v.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jkT.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.jkT.cii.a(3, -1, "doScene failed", this.jkT);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                    v.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jkT.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.jkT.a(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl, 1, com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl, 1, "upload_" + this.jkT.cMU, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    v.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.jkT.jkR) + " " + com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    g.iuh.h(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.jkT.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.jkT.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.jkT.cii.a(0, 0, "doScene", this.jkT);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    v.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jkT.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    if (this.jkT.jkS == 21) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode <= -10000 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode > -20000) {
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(10);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode <= -20000 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= -22000) {
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(11);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode > -5103000 || com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode < -5103087) {
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(15);
                        } else {
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(9);
                        }
                    }
                    w.a(this.jkT, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                    g.iuh.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.jkT.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.jkT.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.jkT.cii.a(3, -1, "doScene failed", this.jkT);
                    return 0;
                } else if (i != 0) {
                    v.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jkT.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.jkT.pX(0);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        g.iuh.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.jkT.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.jkT.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    }
                    this.jkT.cii.a(3, -1, "doScene failed", this.jkT);
                    return 0;
                } else {
                    v.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jkT.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] i(String str, byte[] bArr) {
                return null;
            }
        };
        this.jkR = System.currentTimeMillis();
        this.jdV = i;
        this.jkN = str;
        this.jkS = i2;
        b.a aVar = new b.a();
        aVar.czn = new axe();
        aVar.czo = new axf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsupload";
        aVar.czm = 207;
        aVar.czp = 95;
        aVar.czq = 1000000095;
        this.cif = aVar.Bv();
        this.jkM = (axe) this.cif.czk.czs;
        o de = ad.aSt().de((long) i);
        this.jkQ = z;
        v.i("MicroMsg.NetSceneMMSnsUpload", "start snsupload netscene localId " + i + "  offset " + de.offset + " path " + de.jCo + " totallen " + de.jCn);
        if (!z) {
            this.jkM.mTr = 1;
            v.i("MicroMsg.NetSceneMMSnsUpload", "this is single upload");
        }
        try {
            Object obj;
            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
            this.jkL = i.zN(de.jCo);
            this.path = al.cA(ad.xh(), de.jCo) + this.jkL;
            this.cyu = (int) FileOp.jP(this.path);
            this.jkO = i.zW(this.path);
            v.i("MicroMsg.NetSceneMMSnsUpload", "totallen " + this.cyu + " isLongPic: " + this.jkO);
            String str2 = com_tencent_mm_protocal_c_aie.mIJ;
            if (be.kS(str2)) {
                str2 = com.tencent.mm.a.g.m((be.Nj()).getBytes());
                com_tencent_mm_protocal_c_aie.mIJ = str2;
                try {
                    de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
                    ad.aSt().a(de.jBI, de);
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneMMSnsUpload", e, "", new Object[0]);
                }
            }
            this.jkM.mdz = this.cyu;
            this.jkM.mdA = de.offset;
            this.jkM.mbN = str2;
            this.cMU = str2;
            v.d("MicroMsg.NetSceneMMSnsUpload", "filter style " + com_tencent_mm_protocal_c_aie.mIl);
            this.jkM.mIl = com_tencent_mm_protocal_c_aie.mIl;
            v.d("MicroMsg.NetSceneMMSnsUpload", "syncWeibo " + com_tencent_mm_protocal_c_aie.mIm);
            this.jkM.mdJ = com_tencent_mm_protocal_c_aie.gkC;
            this.jkM.mIm = com_tencent_mm_protocal_c_aie.mIm;
            v.d("MicroMsg.NetSceneMMSnsUpload", "request upload type " + de.type + " md5: " + com_tencent_mm_protocal_c_aie.aZy + " appid " + com_tencent_mm_protocal_c_aie.bmJ + " contenttype " + com_tencent_mm_protocal_c_aie.job);
            this.jkM.efm = de.type;
            bah com_tencent_mm_protocal_c_bah = new bah();
            com_tencent_mm_protocal_c_bah.mWT = com_tencent_mm_protocal_c_aie.token;
            com_tencent_mm_protocal_c_bah.mWU = com_tencent_mm_protocal_c_aie.mIu;
            this.jkM.mNq = com_tencent_mm_protocal_c_bah;
            if (!be.kS(com_tencent_mm_protocal_c_aie.aZy)) {
                this.jkM.mpI = com_tencent_mm_protocal_c_aie.aZy;
            }
            if (!be.kS(com_tencent_mm_protocal_c_aie.bmJ)) {
                this.jkM.glj = com_tencent_mm_protocal_c_aie.bmJ;
            }
            this.jkM.mUv = com_tencent_mm_protocal_c_aie.job;
            if (q.dpM) {
                this.jkM.efm = 0;
            }
            if (this.startTime == 0) {
                this.startTime = be.Ni();
                this.cMV = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            }
            axe com_tencent_mm_protocal_c_axe = this.jkM;
            com.tencent.mm.modelcdntran.g.DZ();
            if (!c.fk(32)) {
                Object[] objArr = new Object[1];
                com.tencent.mm.modelcdntran.g.DZ();
                objArr[0] = Boolean.valueOf(c.fk(32));
                v.w("MicroMsg.NetSceneMMSnsUpload", "cdntra not use cdn flag:%b", objArr);
                obj = null;
            } else if (q.dqB == 2) {
                obj = null;
            } else {
                this.cMU = com_tencent_mm_protocal_c_axe.mbN;
                if (be.kS(this.cMU)) {
                    v.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.jkP = true;
            } else if (!WB()) {
                onError();
            }
        } catch (Exception e2) {
            v.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    private boolean WB() {
        o de = ad.aSt().de((long) this.jdV);
        int i = de.jCn - de.offset;
        if (i > this.cNp) {
            i = this.cNp;
        }
        this.offset = de.offset;
        byte[] c = FileOp.c(this.path, this.offset, i);
        if (c == null || c.length <= 0) {
            return false;
        }
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(c);
        this.jkM.meT = com_tencent_mm_protocal_c_are;
        this.jkM.mdA = this.offset;
        return true;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        if (this.jkO) {
            return 675;
        }
        return 100;
    }

    public final int getType() {
        return 207;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        axf com_tencent_mm_protocal_c_axf = (axf) ((b) pVar).czl.czs;
        if (i2 == 4) {
            pX(i3);
            if (this.jkS == 21) {
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(12);
            }
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            o de = ad.aSt().de((long) this.jdV);
            if (com_tencent_mm_protocal_c_axf.mdA < 0 || (com_tencent_mm_protocal_c_axf.mdA > de.jCn && de.jCn > 0)) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.b.b.kZ(14);
                }
            } else if (com_tencent_mm_protocal_c_axf.mdA < de.offset) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.b.b.kZ(14);
                }
            } else {
                v.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + com_tencent_mm_protocal_c_axf.mUw.glb + " bufferUrlType: " + com_tencent_mm_protocal_c_axf.mUw.efm + "  id:" + com_tencent_mm_protocal_c_axf.mjq + " thumb Count: " + com_tencent_mm_protocal_c_axf.mIG + "  type " + com_tencent_mm_protocal_c_axf.efm + " startPos : " + com_tencent_mm_protocal_c_axf.mdA);
                de.offset = com_tencent_mm_protocal_c_axf.mdA;
                ad.aSt().a(this.jdV, de);
                Object obj = (de.offset != de.jCn || de.jCn == 0) ? null : 1;
                if (obj != null) {
                    v.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.jkR));
                    if (com_tencent_mm_protocal_c_axf.mIH.size() == 0 || com_tencent_mm_protocal_c_axf.mIH.size() <= 0) {
                        a(com_tencent_mm_protocal_c_axf.mUw.glb, com_tencent_mm_protocal_c_axf.mUw.efm, "", 0, com_tencent_mm_protocal_c_axf.mjq, this.jkM.mpI);
                    } else {
                        a(com_tencent_mm_protocal_c_axf.mUw.glb, com_tencent_mm_protocal_c_axf.mUw.efm, ((avo) com_tencent_mm_protocal_c_axf.mIH.get(0)).glb, ((avo) com_tencent_mm_protocal_c_axf.mIH.get(0)).efm, com_tencent_mm_protocal_c_axf.mjq, this.jkM.mpI);
                    }
                    this.cii.a(i2, i3, str, this);
                } else if (WB() && a(this.czE, this.cii) < 0) {
                    this.cii.a(3, -1, "doScene failed", this);
                }
            }
        } else {
            onError();
            if (this.jkS == 21) {
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(13);
            }
            this.cii.a(i2, i3, str, this);
        }
    }

    public final boolean a(String str, int i, String str2, int i2, String str3, String str4) {
        aie com_tencent_mm_protocal_c_aie;
        o de = ad.aSt().de((long) this.jdV);
        v.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + str + "  " + str3 + "  " + i + " thumbUrl: " + str2);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(this.path, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        int i3 = -1;
        if (toLowerCase.endsWith("jpg") || toLowerCase.endsWith("jpeg")) {
            i3 = MMNativeJpeg.queryQuality(this.path);
            if (i3 == 0) {
                i3 = -1;
            }
        }
        com.tencent.mm.plugin.sns.i.c.a(str, options.outMimeType, options.outWidth, options.outHeight, i3, FileOp.jP(this.path));
        de.jCr = str3;
        try {
            com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
        } catch (Exception e) {
            com_tencent_mm_protocal_c_aie = null;
        }
        if (com_tencent_mm_protocal_c_aie == null) {
            com_tencent_mm_protocal_c_aie = new aie();
        }
        ahz com_tencent_mm_protocal_c_ahz = new ahz();
        com_tencent_mm_protocal_c_ahz.efm = i;
        com_tencent_mm_protocal_c_ahz.glb = str;
        com_tencent_mm_protocal_c_aie.mIF = com_tencent_mm_protocal_c_ahz;
        com_tencent_mm_protocal_c_aie.mII = 0;
        com_tencent_mm_protocal_c_aie.aZy = str4;
        if (!be.kS(str2)) {
            com_tencent_mm_protocal_c_ahz = new ahz();
            com_tencent_mm_protocal_c_ahz.efm = i2;
            com_tencent_mm_protocal_c_ahz.glb = str2;
            com_tencent_mm_protocal_c_aie.mIH.add(com_tencent_mm_protocal_c_ahz);
        }
        try {
            de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
        } catch (Throwable e2) {
            v.a("MicroMsg.NetSceneMMSnsUpload", e2, "", new Object[0]);
        }
        de.aVd();
        ad.aSt().a(this.jdV, de);
        ad.aSD().qc(this.jdV);
        if (ad.aSA() != null) {
            ad.aSA().aTe();
        }
        return true;
    }

    final void pX(int i) {
        o de = ad.aSt().de((long) this.jdV);
        try {
            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
            com_tencent_mm_protocal_c_aie.mII = 1;
            com_tencent_mm_protocal_c_aie.mIt = i;
            de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
        } catch (Exception e) {
        }
        ad.aSD().qc(this.jdV);
        ad.aSt().a(this.jdV, de);
    }

    private void onError() {
        o de = ad.aSt().de((long) this.jdV);
        de.offset = 0;
        try {
            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
            com_tencent_mm_protocal_c_aie.mIJ = "";
            de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
            ad.aSt().a(this.jdV, de);
            ad.aSD().qc(this.jdV);
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    protected final void cancel() {
        super.cancel();
        if (this.jkP && !be.kS(this.cMU)) {
            v.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.cMU);
            com.tencent.mm.modelcdntran.g.DZ().ip(this.cMU);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = ba.CTRL_INDEX;
        this.cii = eVar2;
        if (!this.jkP) {
            return a(eVar, this.cif, this);
        }
        this.cMU = this.jkM.mbN;
        if (be.kS(this.cMU)) {
            v.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        } else {
            h hVar = new h();
            hVar.cFR = this.cNe;
            hVar.field_mediaId = this.cMU;
            hVar.field_fullpath = this.path;
            hVar.field_thumbpath = "";
            hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            hVar.field_talker = "";
            hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
            hVar.field_needStorage = true;
            hVar.field_isStreamMedia = false;
            if (com.tencent.mm.plugin.sns.storage.p.aVf()) {
                if (!this.jkQ) {
                    i = 107;
                }
                hVar.field_appType = i;
            } else if (com.tencent.mm.plugin.sns.storage.p.aVe()) {
                if (!this.jkQ) {
                    i = 107;
                }
                hVar.field_appType = i;
            } else {
                com.tencent.mm.modelcdntran.g.DZ();
                if (c.fk(64)) {
                    hVar.field_appType = this.jkQ ? UpdateLogConst.ACTION_POP_INSTALL_DIALOG : 103;
                } else {
                    hVar.field_appType = this.jkQ ? 101 : 100;
                }
            }
            hVar.field_bzScene = 1;
            if (!com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                v.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{this.cMU});
                this.cMU = "";
            }
        }
        return 0;
    }
}
