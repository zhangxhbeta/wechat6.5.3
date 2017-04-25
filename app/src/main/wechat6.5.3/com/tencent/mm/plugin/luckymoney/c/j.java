package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.model.k;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;

public final class j implements com.tencent.mm.modelcdntran.h.a {
    public String fvY = null;
    public a hbp;
    public String hbq;
    private boolean hbr = true;

    public interface a {
        void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z);
    }

    public static String axI() {
        return be.ma(d.a("NewYearImg", System.currentTimeMillis(), k.ym().field_username, ""));
    }

    public final boolean a(String str, String str2, int i, String str3, a aVar) {
        v.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", new Object[]{str});
        this.hbr = false;
        this.fvY = axI();
        v.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", new Object[]{this.fvY});
        this.hbq = str3;
        this.hbp = aVar;
        h hVar = new h();
        hVar.cFQ = false;
        hVar.cFR = this;
        hVar.field_fullpath = str3;
        hVar.field_mediaId = this.fvY;
        hVar.field_fileId = str;
        hVar.field_aesKey = str2;
        hVar.field_totalLen = i;
        hVar.field_fileType = b.MediaType_FILE;
        hVar.field_priority = b.cEA;
        hVar.field_needStorage = false;
        hVar.field_isStreamMedia = false;
        hVar.field_appType = 0;
        hVar.field_bzScene = 0;
        if (g.DZ().a(hVar, -1)) {
            return true;
        }
        v.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", new Object[]{str});
        return false;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        v.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && this.fvY.equals(str) && !be.kS(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId)) {
            v.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            if (i == 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                if (this.hbr) {
                    v.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    v.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                v.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", new Object[]{str, com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
                if (this.hbp != null) {
                    this.hbp.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.hbq, true);
                }
            } else {
                v.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.hbp != null) {
                    this.hbp.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.hbq, false);
                }
            }
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && this.fvY.equals(str) && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
            v.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            if (this.hbp != null) {
                this.hbp.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.hbq, false);
            }
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            v.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
