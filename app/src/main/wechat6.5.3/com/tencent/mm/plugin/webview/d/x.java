package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public abstract class x {
    public String aST;
    public String appId;
    public int bcp;
    public String bde;
    public String ldU;
    public String lek;
    public String lel;
    public a lem;
    public boolean leo;
    public boolean lep = true;
    public boolean leq = true;
    public String mediaId;

    public static class a {
        public String field_aesKey;
        public String field_fileId;
        public int field_fileLength;
        public String field_fileUrl;
    }

    public abstract x bih();

    public abstract String bii();

    public abstract String bij();

    public static x DT(String str) {
        x zVar = new z();
        zVar.lel = str;
        zVar.bih();
        zVar.mediaId = d.a("jsupimg", be.Ni(), zVar.bde, zVar.bde);
        return zVar;
    }

    public static x DU(String str) {
        x acVar = new ac();
        acVar.aST = str;
        acVar.bih();
        acVar.mediaId = d.a("jsupvoice", be.Ni(), acVar.bde, acVar.bde);
        return acVar;
    }

    public static ab DV(String str) {
        ab abVar = new ab();
        abVar.lel = str;
        abVar.bih();
        abVar.mediaId = d.a("jsvideofile", be.Ni(), abVar.bde, abVar.bde);
        v.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[]{str, abVar.bde, abVar.mediaId});
        return abVar;
    }

    public void b(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.lem == null) {
            this.lem = new a();
        }
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            v.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.lem.field_aesKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
        this.lem.field_fileId = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        this.lem.field_fileUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
        this.lem.field_fileLength = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
    }
}
