package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.e.a.bz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.d.d;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.protocal.c.ow;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class g extends k implements j {
    boolean cAv;
    public String cMU;
    private int cVh;
    private final b cif;
    private e cxf;
    public String fdU;
    public String fdV;
    public String fdW;
    private int fdX;
    private a fdY;
    com.tencent.mm.storage.a.a fdZ;

    static /* synthetic */ void P(String str, boolean z) {
        if (!be.kS(str)) {
            v.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", new Object[]{str, Boolean.valueOf(z)});
            bz bzVar = new bz();
            bzVar.aZx.aZy = str;
            bzVar.aZx.aYt = 2;
            bzVar.aZx.aZz = z;
            com.tencent.mm.sdk.c.a.nhr.z(bzVar);
        }
    }

    private g(String str, String str2, String str3, int i, int i2) {
        this.cMU = "";
        this.fdY = new a(this) {
            final /* synthetic */ g fea;

            {
                this.fea = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (be.kS(this.fea.cMU) || !str.equals(this.fea.cMU)) {
                    v.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
                } else if (i == -21006) {
                    v.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.fea.cMU});
                    g.d(this.fea.fdU, 6, 0, this.fea.cMU);
                } else if (i != 0) {
                    v.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[]{this.fea.fdU});
                    g.d(this.fea.fdU, -1, 0, this.fea.cMU);
                } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength) {
                        v.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
                    } else {
                        v.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.fea.cMU, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)});
                        if (!this.fea.cAv) {
                            g.d(this.fea.fdU, 6, (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f), this.fea.cMU);
                        }
                    }
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(10625, new Object[]{Integer.valueOf(2), com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, this.fea.fdU, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo});
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        v.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[]{this.fea.fdU, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                        g.d(this.fea.fdU, -1, 0, this.fea.cMU);
                    } else {
                        v.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                        try {
                            d aeS = d.aeS();
                            String str2 = this.fea.fdU;
                            if (aeS.faS != null && aeS.faS.contains(str2)) {
                                aeS.faS.remove(str2);
                            }
                            EmojiLogic.a(this.fea.fdU, this.fea.fdV, this.fea.fdZ);
                            com.tencent.mm.plugin.emoji.model.g.afx().fch.Ls();
                            g.d(this.fea.fdU, 7, 100, this.fea.cMU);
                            File file = new File(com.tencent.mm.compatible.util.e.cge + this.fea.fdU);
                            if (file.isFile() && file.exists()) {
                                file.delete();
                            }
                            g.P(this.fea.fdU, true);
                        } catch (Exception e) {
                            v.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + be.bur());
                            g.d(this.fea.fdU, -1, 0, this.fea.cMU);
                            g.P(this.fea.fdU, false);
                            return 0;
                        } catch (OutOfMemoryError e2) {
                            v.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + be.bur());
                            g.d(this.fea.fdU, -1, 0, this.fea.cMU);
                            g.P(this.fea.fdU, false);
                            return 0;
                        }
                    }
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] i(String str, byte[] bArr) {
                return null;
            }
        };
        this.fdU = str;
        this.fdV = str3;
        this.fdW = str2;
        this.fdZ = null;
        this.fdX = i;
        this.cVh = i2;
        b.a aVar = new b.a();
        aVar.czn = new ov();
        aVar.czo = new ow();
        aVar.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        aVar.czm = 423;
        aVar.czp = 213;
        aVar.czq = 1000000213;
        this.cif = aVar.Bv();
    }

    public g(String str, String str2, String str3) {
        this(str, str2, str3, 0, 0);
    }

    public g(String str, String str2) {
        this(str, null, str2, 0, 0);
    }

    public g(String str) {
        this(str, null, "", 1, 0);
    }

    public g(String str, byte b) {
        this(str, null, "", 1, 1);
    }

    public final int getType() {
        return 423;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.cVh == 0) {
                File file = new File(com.tencent.mm.compatible.util.e.cge);
                if (!file.exists()) {
                    file.mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                this.cMU = com.tencent.mm.modelcdntran.d.a("downzip", currentTimeMillis, stringBuilder.append(c.ww()).toString(), "emoji");
                od odVar = ((ow) this.cif.czl.czs).mrb;
                h hVar = new h();
                hVar.field_mediaId = this.cMU;
                hVar.field_fullpath = com.tencent.mm.compatible.util.e.cge + this.fdU;
                hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
                hVar.field_totalLen = odVar.moo;
                hVar.field_aesKey = odVar.mpF;
                hVar.field_fileId = odVar.glb;
                hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                hVar.cFR = this.fdY;
                hVar.field_needStorage = true;
                this.cAv = false;
                if (!com.tencent.mm.modelcdntran.g.DZ().a(hVar, -1)) {
                    v.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                v.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.cxf.a(i2, i3, str, this);
            ak.vy().a(new j(this.fdU), 0);
            return;
        }
        this.cxf.a(i2, i3, str, this);
        d(this.fdU, -1, 0, this.cMU);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.cxf = eVar2;
        if (this.cVh == 0) {
            d(this.fdU, 6, 0, this.cMU);
        }
        ov ovVar = (ov) this.cif.czk.czs;
        ovVar.mdM = this.fdU;
        ovVar.mqZ = this.fdW;
        ovVar.mra = this.fdX;
        ovVar.maG = this.cVh;
        return a(eVar, this.cif, this);
    }

    static void d(String str, int i, int i2, String str2) {
        com.tencent.mm.plugin.emoji.model.g.afz().d(str, i, i2, str2);
    }

    protected final void cancel() {
        super.cancel();
        this.cAv = true;
    }
}
