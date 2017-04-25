package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    public boolean aZW = true;
    public String gRN = "";
    public int jpY = 0;
    public List<a> jpZ = new ArrayList();
    public String jpw = "";
    public String jpx = "";
    public String jqm = "";
    public int[] jqn;

    public final boolean aTq() {
        return this.aZW && this.jpZ != null && this.jpZ.size() > 0;
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.jpx = str;
        this.jpw = str2;
        if (map != null) {
            try {
                this.jpZ.clear();
                this.gRN = be.ah((String) map.get("language"), "");
                this.jqm = be.ah((String) map.get("first_step_order"), "");
                String[] split = this.jqm.split("\\|");
                this.jqn = new int[split.length];
                if (this.jqn.length == 0) {
                    this.aZW = false;
                }
                int i = 0;
                while (i < split.length) {
                    this.jqn[i] = be.KL(split[i]);
                    if (this.jqn[i] <= 0 || this.jqn[i] > 3) {
                        this.aZW = false;
                    }
                    i++;
                }
                int KL = be.KL((String) map.get("wording_count"));
                int KL2 = be.KL((String) map.get("expertype"));
                for (int i2 = 0; i2 < KL; i2++) {
                    a aVar = new a();
                    aVar.joP = be.KL((String) map.get(String.format("wording_%d_id", new Object[]{Integer.valueOf(i2 + 1)})));
                    aVar.joQ = be.ah((String) map.get(String.format("wording_%d_zh_CN", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.joR = be.ah((String) map.get(String.format("wording_%d_zh_TW", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.joS = be.ah((String) map.get(String.format("wording_%d_en", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.joT = be.KL((String) map.get(String.format("wording_%d_action_type", new Object[]{Integer.valueOf(i2 + 1)})));
                    this.jpZ.add(aVar);
                }
                v.i("MicroMsg.SnsAdAbTestInfo", "expertType " + KL2 + " " + str + " " + this.jqm);
            } catch (Throwable e) {
                v.a("MicroMsg.SnsAdAbTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
