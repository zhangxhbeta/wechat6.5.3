package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g {
    public int bYu;
    public String boC;
    public int cWc;
    public int jBA;
    public int jBB;
    private String jBC;
    public String jBD;
    public int jBs;
    public int jBt;
    public int jBu;
    public int jBv;
    public int jBw;
    public int jBx;
    public int jBy;
    public int jBz;
    public String jpt;
    public String jpw;

    public final String aUl() {
        long j = 0;
        try {
            j = be.getLong(this.boC, 0);
        } catch (Exception e) {
            v.e("AdLandingPagesReportInfo", "", new Object[]{e});
        }
        return i.cE(j) + "," + this.jpt + "," + this.jBs + "," + this.bYu + "," + this.jBt + "," + this.jBu + "," + this.jBv + "," + this.jBw + "," + this.jBx + "," + this.jBy + "," + this.jBz + "," + this.jBA + "," + this.jBB + "," + this.cWc + "," + this.jBC + "," + System.currentTimeMillis() + "," + this.jBD + "," + (this.jpw == null ? "" : this.jpw);
    }

    public final void Z(LinkedList<j> linkedList) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (!jVar.aTW().jvS) {
                JSONObject jSONObject = new JSONObject();
                if (!jVar.o(jSONArray)) {
                    if (jVar.x(jSONObject)) {
                        jSONArray.put(jSONObject);
                    }
                    if (jVar instanceof o) {
                        Iterator it2 = ((o) jVar).aUb().iterator();
                        while (it2.hasNext()) {
                            jSONArray.put((JSONObject) it2.next());
                        }
                    }
                }
            }
        }
        this.jBC = jSONArray.toString();
        v.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[]{this.jBC});
        if (!be.kS(this.jBC)) {
            try {
                this.jBC = URLEncoder.encode(this.jBC, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                v.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e.toString());
            }
        }
    }
}
