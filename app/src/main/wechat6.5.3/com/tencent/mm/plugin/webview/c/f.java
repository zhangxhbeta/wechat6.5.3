package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsearch.t;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bir;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class f extends t implements j {
    private b cQA;
    private e cii;
    private bis ldE;

    public f(String str, boolean z, long j, int i, int i2, String str2) {
        boolean z2 = false;
        this.jVO = str;
        this.cVh = i;
        this.cVf = i2;
        if (be.kS(str)) {
            v.e("MicroMsg.FTS.NetSceneWebSuggest", "keyword is unavailable");
            return;
        }
        v.i("MicroMsg.FTS.NetSceneWebSuggest", "Constructors: query=%s", new Object[]{str});
        a aVar = new a();
        aVar.czm = 1161;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
        aVar.czn = new bir();
        aVar.czo = new bis();
        this.cQA = aVar.Bv();
        bir com_tencent_mm_protocal_c_bir = (bir) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_bir.muW = str;
        com_tencent_mm_protocal_c_bir.miQ = j;
        com_tencent_mm_protocal_c_bir.ncj = h.cVT;
        com_tencent_mm_protocal_c_bir.mPQ = z ? 1 : 0;
        com_tencent_mm_protocal_c_bir.mGZ = h.Ig();
        com_tencent_mm_protocal_c_bir.maG = i;
        try {
            JSONArray jSONArray = new JSONArray(str2);
            com_tencent_mm_protocal_c_bir.ndi = new LinkedList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                com_tencent_mm_protocal_c_bir.ndi.add(URLDecoder.decode(jSONArray.getString(i3), "UTF-8"));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.FTS.NetSceneWebSuggest", e, "decode json error", new Object[0]);
        }
        String str3 = "MicroMsg.FTS.NetSceneWebSuggest";
        String str4 = "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(j);
        if (com_tencent_mm_protocal_c_bir.mGZ != null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Long.valueOf(j);
        objArr[4] = Boolean.valueOf(z);
        objArr[5] = Integer.valueOf(i2);
        v.i(str3, str4, objArr);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.FTS.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.ldE = (bis) this.cQA.czl.czs;
            if (this.ldE != null) {
                v.v("MicroMsg.FTS.NetSceneWebSuggest", "return data\n%s", new Object[]{this.ldE.min});
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1161;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final String AI() {
        return this.ldE != null ? this.ldE.min : "";
    }
}
