package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.OutputStream;

public final class ap extends j<g, String, Boolean> {
    private String aST;
    private OutputStream cyK = null;
    private String cyL;
    private String jka;
    private String jke = "";
    private String mediaId;

    public final /* synthetic */ Object aRX() {
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void m(Object[] objArr) {
        g[] gVarArr = (g[]) objArr;
        super.m(gVarArr);
        g gVar = gVarArr[0];
        if (gVar != null) {
            this.mediaId = gVar.mediaId;
            this.jka = al.cA(ad.xh(), this.mediaId);
            this.jke = i.ac(gVar.requestType, this.mediaId);
            this.cyL = "sns_tmpt_" + this.mediaId;
            this.aST = "snst_" + this.mediaId;
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        bool.booleanValue();
        ad.aSz().Af(this.jke);
    }

    public final ac aRW() {
        return ad.aSq();
    }
}
