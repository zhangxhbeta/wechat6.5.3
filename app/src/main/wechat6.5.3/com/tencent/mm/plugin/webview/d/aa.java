package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class aa extends x {
    public int fileType;
    public String let;

    public aa() {
        this.fileType = -1;
        this.bcp = 3;
    }

    public final x bih() {
        this.bde = ah.DZ(this.lel);
        return this;
    }

    public final void b(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        super.b(com_tencent_mm_modelcdntran_keep_SceneResult);
        List arrayList = new ArrayList();
        arrayList.add(this.fileType);
        arrayList.add(this.let);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
        Context context = com.tencent.mm.sdk.platformtools.aa.getContext();
        if (ak.isWifi(context)) {
            arrayList.add("1");
        } else if (ak.is3G(context)) {
            arrayList.add("4");
        } else if (ak.is4G(context)) {
            arrayList.add("5");
        } else if (ak.is2G(context)) {
            arrayList.add("3");
        } else if (ak.isWap(context)) {
            arrayList.add("2");
        } else {
            arrayList.add("0");
        }
        v.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[]{Integer.valueOf(this.fileType), this.let, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId});
        g.iuh.d(12018, arrayList);
        String str = this.lel;
        if (!be.kS(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final String bii() {
        return "file";
    }

    public final String bij() {
        return "nomal";
    }
}
