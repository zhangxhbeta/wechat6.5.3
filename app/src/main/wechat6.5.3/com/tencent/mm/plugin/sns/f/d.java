package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public boolean aZW = true;
    public String gRN = "";
    public int jpY = 0;
    public List<b> jpZ = new ArrayList();
    public String jpw = "";
    public String jpx = "";

    static class a {
        public int actionType;
        public int index;
        public String jqa;
        public String jqb;
        public int jqc;
        public String jumpUrl;

        a() {
        }
    }

    static class b {
        public int aXx;
        public int jqd;
        public List<a> jqe = new ArrayList();
        public String title;

        b() {
        }
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.jpx = str;
        this.jpw = str2;
        if (map != null) {
            try {
                this.jpZ.clear();
                this.gRN = be.ah((String) map.get("language"), "");
                if (!this.gRN.equals("zh_cn")) {
                    this.aZW = false;
                }
                int KL = be.KL((String) map.get("tipcount"));
                int KL2 = be.KL((String) map.get("expertype"));
                for (int i = 0; i < KL; i++) {
                    b bVar = new b();
                    bVar.title = be.ah((String) map.get(String.format("tip_%d_basetextformat", new Object[]{Integer.valueOf(i)})), "");
                    bVar.jqd = be.KL((String) map.get(String.format("tip_%d_id", new Object[]{Integer.valueOf(i)})));
                    bVar.aXx = be.KL((String) map.get(String.format("tip_%d_showtype", new Object[]{Integer.valueOf(i)})));
                    int KL3 = be.KL((String) map.get(String.format("tip_%d_button_count", new Object[]{Integer.valueOf(i)})));
                    if (bVar.aXx >= 6) {
                        this.aZW = false;
                    }
                    for (int i2 = 0; i2 < KL3; i2++) {
                        a aVar = new a();
                        aVar.index = be.KL((String) map.get(String.format("tip_%d_button_%d_index", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.actionType = be.KL((String) map.get(String.format("tip_%d_button_%d_actiontype", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.jqa = be.ah((String) map.get(String.format("tip_%d_button_%d_basetextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.jumpUrl = be.ah((String) map.get(String.format("tip_%d_button_%d_jumpurl", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.jqb = be.ah((String) map.get(String.format("tip_%d_button_%d_priortextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.jqc = be.KL((String) map.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        if (aVar.actionType >= 9) {
                            this.aZW = false;
                        }
                        bVar.jqe.add(aVar);
                    }
                    this.jpZ.add(bVar);
                }
                v.i("Micromsg.SnsABTestInfo", "expertType " + KL2 + " " + str);
            } catch (Throwable e) {
                v.a("Micromsg.SnsABTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
