package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;

public final class c implements a {
    String appName = null;
    String fvY = null;

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        v.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null || !str.equals(this.fvY)) {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                v.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
            }
        } else if (i == 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
            v.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
            v.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", new Object[]{str, com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
            aVar.field_username = k.xF();
            b.sg(aVar.field_championUrl);
            ac.aju().a(aVar, true);
            ac.ajy();
            ak.vy().a(new m(aVar.field_championUrl, aVar.field_championMotto), 0);
        } else {
            v.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
        }
        return 0;
    }
}
