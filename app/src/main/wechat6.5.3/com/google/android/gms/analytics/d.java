package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.s;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.al;
import com.google.android.gms.c.am;
import com.google.android.gms.c.an;
import com.google.android.gms.c.ao;
import com.google.android.gms.c.ap;
import com.google.android.gms.c.aq;
import com.google.android.gms.c.ar;
import com.google.android.gms.c.e;
import com.google.android.gms.c.f;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.w;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d extends n implements ai {
    private static DecimalFormat aiY;
    private final q ahP;
    private final String aiZ;
    private final Uri aja;
    private final boolean ajb;
    private final boolean ajc;

    public d(q qVar, String str) {
        this(qVar, str, (byte) 0);
    }

    private d(q qVar, String str, byte b) {
        super(qVar);
        w.U(str);
        this.ahP = qVar;
        this.aiZ = str;
        this.ajb = true;
        this.ajc = false;
        this.aja = O(this.aiZ);
    }

    public static Uri O(String str) {
        w.U(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, d(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    private static void b(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static Map<String, String> c(ae aeVar) {
        CharSequence e;
        Map hashMap = new HashMap();
        g gVar = (g) aeVar.a(g.class);
        if (gVar != null) {
            for (Entry entry : Collections.unmodifiableMap(gVar.afL).entrySet()) {
                Object obj;
                Boolean value = entry.getValue();
                if (value == null) {
                    obj = null;
                } else if (value instanceof String) {
                    String str = (String) value;
                    if (TextUtils.isEmpty(str)) {
                        obj = null;
                    }
                } else if (value instanceof Double) {
                    Double d = (Double) value;
                    obj = d.doubleValue() != 0.0d ? d(d.doubleValue()) : null;
                } else {
                    obj = value instanceof Boolean ? value != Boolean.FALSE ? "1" : null : String.valueOf(value);
                }
                if (obj != null) {
                    hashMap.put(entry.getKey(), obj);
                }
            }
        }
        h hVar = (h) aeVar.a(h.class);
        if (hVar != null) {
            b(hashMap, "t", hVar.awZ);
            b(hashMap, "cid", hVar.agW);
            b(hashMap, "uid", hVar.axa);
            b(hashMap, "sc", hVar.axd);
            a(hashMap, "sf", hVar.axf);
            a(hashMap, "ni", hVar.axe);
            b(hashMap, "adid", hVar.axb);
            a(hashMap, "ate", hVar.axc);
        }
        ap apVar = (ap) aeVar.a(ap.class);
        if (apVar != null) {
            b(hashMap, "cd", apVar.azE);
            a(hashMap, "a", (double) apVar.azF);
            b(hashMap, "dr", apVar.azI);
        }
        an anVar = (an) aeVar.a(an.class);
        if (anVar != null) {
            b(hashMap, "ec", anVar.sa);
            b(hashMap, "ea", anVar.apk);
            b(hashMap, "el", anVar.azA);
            a(hashMap, "ev", (double) anVar.azB);
        }
        ak akVar = (ak) aeVar.a(ak.class);
        if (akVar != null) {
            b(hashMap, "cn", akVar.mName);
            b(hashMap, "cs", akVar.azi);
            b(hashMap, "cm", akVar.azj);
            b(hashMap, "ck", akVar.azk);
            b(hashMap, "cc", akVar.azl);
            b(hashMap, "ci", akVar.afy);
            b(hashMap, "anid", akVar.azm);
            b(hashMap, "gclid", akVar.azn);
            b(hashMap, "dclid", akVar.azo);
            b(hashMap, "aclid", akVar.azp);
        }
        ao aoVar = (ao) aeVar.a(ao.class);
        if (aoVar != null) {
            b(hashMap, "exd", aoVar.azC);
            a(hashMap, "exf", aoVar.azD);
        }
        aq aqVar = (aq) aeVar.a(aq.class);
        if (aqVar != null) {
            b(hashMap, "sn", aqVar.azM);
            b(hashMap, "sa", aqVar.apk);
            b(hashMap, "st", aqVar.azN);
        }
        ar arVar = (ar) aeVar.a(ar.class);
        if (arVar != null) {
            b(hashMap, "utv", arVar.azO);
            a(hashMap, "utt", (double) arVar.azP);
            b(hashMap, "utc", arVar.sa);
            b(hashMap, "utl", arVar.azA);
        }
        e eVar = (e) aeVar.a(e.class);
        if (eVar != null) {
            for (Entry entry2 : Collections.unmodifiableMap(eVar.awX).entrySet()) {
                e = e.e("cd", ((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(e)) {
                    hashMap.put(e, entry2.getValue());
                }
            }
        }
        f fVar = (f) aeVar.a(f.class);
        if (fVar != null) {
            for (Entry entry22 : Collections.unmodifiableMap(fVar.awY).entrySet()) {
                e = e.e("cm", ((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(e)) {
                    hashMap.put(e, d(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        am amVar = (am) aeVar.a(am.class);
        if (amVar != null) {
            b bVar = amVar.azz;
            if (bVar != null) {
                for (Entry entry3 : new HashMap(bVar.afx).entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), entry3.getValue());
                    } else {
                        hashMap.put(entry3.getKey(), entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (c u : Collections.unmodifiableList(amVar.azx)) {
                hashMap.putAll(u.u(e.e("promo", i)));
                i++;
            }
            i = 1;
            for (a u2 : Collections.unmodifiableList(amVar.azw)) {
                hashMap.putAll(u2.u(e.e("pr", i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry32 : amVar.azy.entrySet()) {
                List<a> list = (List) entry32.getValue();
                String e2 = e.e("il", i2);
                i = 1;
                for (a u3 : list) {
                    hashMap.putAll(u3.u(e2 + e.e("pi", i)));
                    i++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry32.getKey())) {
                    hashMap.put(e2 + "nm", entry32.getKey());
                }
                i2++;
            }
        }
        al alVar = (al) aeVar.a(al.class);
        if (alVar != null) {
            b(hashMap, "ul", alVar.azq);
            a(hashMap, "sd", (double) alVar.azr);
            a(hashMap, "sr", alVar.azs, alVar.azt);
            a(hashMap, "vp", alVar.azu, alVar.azv);
        }
        aj ajVar = (aj) aeVar.a(aj.class);
        if (ajVar != null) {
            b(hashMap, "an", ajVar.afG);
            b(hashMap, "aid", ajVar.azg);
            b(hashMap, "aiid", ajVar.azh);
            b(hashMap, "av", ajVar.afH);
        }
        return hashMap;
    }

    private static String d(double d) {
        if (aiY == null) {
            aiY = new DecimalFormat("0.######");
        }
        return aiY.format(d);
    }

    public final void b(ae aeVar) {
        w.Z(aeVar);
        w.b(aeVar.ayL, "Can't deliver not submitted measurement");
        w.W("deliver should be called on worker thread");
        ae kW = aeVar.kW();
        h hVar = (h) kW.b(h.class);
        if (TextUtils.isEmpty(hVar.awZ)) {
            this.afY.hZ().a(c(kW), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(hVar.agW)) {
            this.afY.hZ().a(c(kW), "Ignoring measurement without client id");
        } else if (!this.ahP.ic().afw) {
            double d = hVar.axf;
            if (k.a(d, hVar.agW)) {
                e("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
                return;
            }
            Map c = c(kW);
            c.put("v", "1");
            c.put("_v", p.agD);
            c.put("tid", this.aiZ);
            if (this.ahP.ic().afv) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Entry entry : c.entrySet()) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                }
                a(4, "Dry run is enabled. GoogleAnalytics would have sent", stringBuilder.toString(), null, null);
                return;
            }
            Map hashMap = new HashMap();
            k.a(hashMap, "uid", hVar.axa);
            aj ajVar = (aj) aeVar.a(aj.class);
            if (ajVar != null) {
                k.a(hashMap, "an", ajVar.afG);
                k.a(hashMap, "aid", ajVar.azg);
                k.a(hashMap, "av", ajVar.afH);
                k.a(hashMap, "aiid", ajVar.azh);
            }
            c.put("_s", String.valueOf(this.afY.ib().a(new s(0, hVar.agW, this.aiZ, !TextUtils.isEmpty(hVar.axb), 0, hashMap))));
            this.afY.ib().c(new com.google.android.gms.analytics.internal.c(this.afY.hZ(), c, aeVar.ayM));
        }
    }

    public final Uri iS() {
        return this.aja;
    }
}
