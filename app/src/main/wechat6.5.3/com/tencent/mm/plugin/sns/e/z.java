package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.a.g;
import com.tencent.mm.as.j;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;

public final class z {
    String aEZ;
    private String bdZ;
    String cMU;
    int cMV;
    private com.tencent.mm.modelcdntran.h.a cNe;
    private String clientId;
    private String fgK;
    private int jdV;
    private long jkR;
    o jlh;
    a jli;
    private aie jlj;
    long startTime;

    public interface a {
        void fS(boolean z);
    }

    static /* synthetic */ void a(z zVar) {
        try {
            zVar.jlj = (aie) new aie().az(zVar.jlh.jCs);
            zVar.fgK = g.aX(zVar.aEZ);
            zVar.jlj.aZy = zVar.fgK;
            zVar.jlh.jCs = zVar.jlj.toByteArray();
            v.i("MicroMsg.SightCdnUpload", "new md5 is %s %s", new Object[]{zVar.aEZ, zVar.fgK});
            ad.aSt().a(zVar.jlh.jBI, zVar.jlh);
        } catch (Exception e) {
            v.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[]{e.getMessage()});
        }
    }

    public z(int i, o oVar, String str, String str2, a aVar) {
        this.clientId = "";
        this.jkR = 0;
        this.startTime = 0;
        this.cMV = 0;
        this.fgK = "";
        this.jlj = new aie();
        this.cNe = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ z jlm;

            {
                this.jlm = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21005) {
                    v.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jlm.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.jlm.jli.fS(true);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                    v.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jlm.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.jlm.M(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl, com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl, "upload_" + this.jlm.cMU);
                    com.tencent.mm.plugin.report.service.g.iuh.h(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.jlm.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.jlm.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    j.KT().a(com_tencent_mm_modelcdntran_keep_SceneResult, this.jlm.aEZ);
                    this.jlm.jli.fS(true);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    v.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jlm.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.jlm.pX(0);
                    com.tencent.mm.plugin.report.service.g.iuh.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.jlm.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.jlm.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.jlm.jli.fS(false);
                    return 0;
                } else if (i != 0) {
                    v.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jlm.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.jlm.pX(0);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.jlm.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.jlm.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    }
                    this.jlm.jli.fS(false);
                    return 0;
                } else {
                    v.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.jlm.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
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
        this.aEZ = str;
        this.bdZ = str2;
        this.jli = aVar;
        this.jdV = i;
        this.jlh = oVar;
        try {
            this.jlj = (aie) new aie().az(oVar.jCs);
            this.clientId = this.jlj.mIJ;
            this.fgK = this.jlj.aZy;
            if (be.kS(this.clientId)) {
                this.clientId = g.m((be.Nj()).getBytes());
                this.jlj.mIJ = this.clientId;
                try {
                    oVar.jCs = this.jlj.toByteArray();
                    ad.aSt().a(oVar.jBI, oVar);
                } catch (Throwable e) {
                    v.a("MicroMsg.SightCdnUpload", e, "", new Object[0]);
                }
            }
            int jP = (int) FileOp.jP(str);
            v.i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(jP), this.fgK});
        } catch (Exception e2) {
            v.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    public final boolean aSe() {
        String aX = g.aX(this.aEZ);
        if (be.kS(this.fgK) || this.fgK.equals(aX)) {
            ahn com_tencent_mm_protocal_c_ahn;
            if (this.jlj.mIM != null) {
                com_tencent_mm_protocal_c_ahn = this.jlj.mIM;
            } else {
                com_tencent_mm_protocal_c_ahn = new ahn();
            }
            v.i("MicroMsg.SightCdnUpload", "check upload %s %d %s", new Object[]{this.aEZ, Integer.valueOf(com_tencent_mm_protocal_c_ahn.mHe), Boolean.valueOf(com_tencent_mm_protocal_c_ahn.mHd)});
            if (com_tencent_mm_protocal_c_ahn.mHd) {
                int i = e.hno;
                if (com_tencent_mm_protocal_c_ahn.mHe >= 3) {
                    onError();
                    return false;
                }
                v.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[]{Integer.valueOf(i), this.aEZ});
                final nz nzVar = new nz();
                nzVar.bpT = new Runnable(this) {
                    final /* synthetic */ z jlm;

                    public final void run() {
                        v.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[]{Integer.valueOf(nzVar.boX.bpc)});
                        if (nzVar.boX.bpc >= 0) {
                            z.a(this.jlm);
                            this.jlm.a(com_tencent_mm_protocal_c_ahn);
                            return;
                        }
                        this.jlm.onError();
                    }
                };
                nzVar.boW.bpb = new f(this) {
                    final /* synthetic */ z jlm;

                    {
                        this.jlm = r1;
                    }

                    public final boolean azE() {
                        v.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
                        z.a(this.jlm);
                        return false;
                    }
                };
                nzVar.boW.boY = this.aEZ;
                nzVar.boW.scene = i;
                nzVar.boW.boZ = com_tencent_mm_protocal_c_ahn;
                nzVar.boW.bpa = new Runnable(this) {
                    final /* synthetic */ z jlm;

                    public final void run() {
                        com_tencent_mm_protocal_c_ahn.mHe++;
                        try {
                            v.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ahn.mHe)});
                            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(this.jlm.jlh.jCs);
                            com_tencent_mm_protocal_c_aie.mIM = com_tencent_mm_protocal_c_ahn;
                            this.jlm.jlh.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
                            ad.aSt().a(this.jlm.jlh.jBI, this.jlm.jlh);
                        } catch (Exception e) {
                            v.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[]{e.getMessage()});
                        }
                    }
                };
                com.tencent.mm.sdk.c.a.nhr.a(nzVar, ad.aSr().getLooper());
                return true;
            }
            a(com_tencent_mm_protocal_c_ahn);
            return true;
        }
        v.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.fgK, aX});
        pX(-2);
        this.jli.fS(false);
        return false;
    }

    final boolean a(ahn com_tencent_mm_protocal_c_ahn) {
        if (this.startTime == 0) {
            this.startTime = be.Ni();
            this.cMV = b.cEE;
        }
        String str = this.clientId;
        if (be.kS(str)) {
            v.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            return false;
        }
        h hVar = new h();
        hVar.cFR = this.cNe;
        hVar.field_mediaId = str;
        hVar.field_fullpath = this.aEZ;
        hVar.field_thumbpath = this.bdZ;
        hVar.field_fileType = b.cEE;
        hVar.field_talker = "";
        hVar.field_priority = b.cEA;
        hVar.field_needStorage = true;
        hVar.field_isStreamMedia = false;
        hVar.field_appType = 102;
        hVar.field_bzScene = 1;
        hVar.field_largesvideo = true;
        String aX = g.aX(this.aEZ);
        if (!be.kS(this.fgK) && !this.fgK.equals(aX)) {
            v.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.fgK, aX});
            pX(-2);
            this.jli.fS(false);
            return false;
        } else if (com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
            int i = (com_tencent_mm_protocal_c_ahn == null || !com_tencent_mm_protocal_c_ahn.mHd) ? 5 : 4;
            j.KT().a("", this.aEZ, "", "", this.jdV, i, 1);
            return true;
        } else {
            v.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{str});
            return false;
        }
    }

    public final boolean M(String str, String str2, String str3) {
        aie com_tencent_mm_protocal_c_aie;
        o de = ad.aSt().de((long) this.jdV);
        v.d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
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
        com_tencent_mm_protocal_c_ahz.efm = 1;
        com_tencent_mm_protocal_c_ahz.glb = str;
        com_tencent_mm_protocal_c_aie.mIF = com_tencent_mm_protocal_c_ahz;
        com_tencent_mm_protocal_c_aie.mII = 0;
        com.tencent.mm.modelcdntran.g.Ea();
        com_tencent_mm_protocal_c_aie.mIk = b.io(this.aEZ);
        v.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[]{com_tencent_mm_protocal_c_aie.mIk});
        if (!be.kS(str2)) {
            com_tencent_mm_protocal_c_ahz = new ahz();
            com_tencent_mm_protocal_c_ahz.efm = 1;
            com_tencent_mm_protocal_c_ahz.glb = str2;
            com_tencent_mm_protocal_c_aie.mIH.add(com_tencent_mm_protocal_c_ahz);
        }
        try {
            de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
        } catch (Throwable e2) {
            v.a("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
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
        v.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        o de = ad.aSt().de((long) this.jdV);
        try {
            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
            com_tencent_mm_protocal_c_aie.mII = 1;
            com_tencent_mm_protocal_c_aie.mIt = i;
            if (this.jlj.mIM != null) {
                this.jlj.mIM.mHe = 0;
            }
            de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
        } catch (Exception e) {
        }
        ad.aSD().qc(this.jdV);
        ad.aSt().a(this.jdV, de);
    }

    final void onError() {
        v.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        o de = ad.aSt().de((long) this.jdV);
        de.offset = 0;
        try {
            aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
            com_tencent_mm_protocal_c_aie.mIJ = "";
            if (com_tencent_mm_protocal_c_aie.mIM != null) {
                com_tencent_mm_protocal_c_aie.mIM.mHe = 0;
            }
            de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
            ad.aSt().a(this.jdV, de);
            ad.aSD().qc(this.jdV);
        } catch (Exception e) {
            v.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }
}
