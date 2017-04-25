package ct;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mmdb.database.SQLiteDatabase;
import ct.b.a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONObject;

public final class ci {
    public static int a = 0;
    private final ck b;
    private final cg c;
    private final ch d;

    public ci(ck ckVar, cg cgVar, ch chVar) {
        this.b = ckVar;
        this.c = cgVar;
        this.d = chVar;
    }

    @Nullable
    public final ch a() {
        return this.d;
    }

    public final boolean b() {
        return this.d != null;
    }

    private String a(int i, int i2, String str, bk bkVar, boolean z, boolean z2, boolean z3) {
        if (bkVar == null) {
            return null;
        }
        try {
            boolean z4;
            String str2;
            if (this.c == null) {
                z4 = true;
            } else {
                z4 = a != this.c.e;
                a = this.c.e;
            }
            String a = a.a(this.b);
            String a2 = a.a(this.c, z4);
            String a3 = a.a(this.d);
            if (z2) {
                str2 = "{}";
            } else {
                str2 = a3;
            }
            bl g = bkVar.g();
            if (g == null) {
                return null;
            }
            int abs;
            Map hashMap = new HashMap();
            hashMap.put("imei", g.a());
            hashMap.put("imsi", g.b());
            hashMap.put("phonenum", a.b(g.e));
            hashMap.put("qq", a.b(g.g));
            hashMap.put("mac", g.c().toLowerCase(Locale.ENGLISH));
            g.a.a();
            String jSONObject = new JSONObject(hashMap).toString();
            if (g.n == null) {
                StringBuilder stringBuilder = new StringBuilder(100);
                stringBuilder.append(g.a()).append("_").append(g.b()).append("_").append(g.c()).append("_QQGeoLocation");
                g.n = a.d(stringBuilder.toString());
            }
            String str3 = g.n;
            cy.a();
            int a4 = cy.a(bkVar.a);
            String b = da.b(bkVar);
            a3 = g.j;
            if (a3 != null) {
                a3 = a3.replace("\"", SQLiteDatabase.KeyEmpty);
            }
            if (a3 != null) {
                a3 = a3.replace("|", SQLiteDatabase.KeyEmpty);
            }
            String str4 = a3 + "_" + g.i;
            if (z3) {
                String a5 = g.a();
                if (a5 != null) {
                    abs = (Math.abs(a5.hashCode()) % 1000) + MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                    a3 = ("{\"version\":\"" + (g.q != null ? "None" : g.q) + "\",\"address\":" + i) + ",\"source\":" + abs + ",\"access_token\":\"" + str3 + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str4 + "\",\"bearing\":1";
                    if (i2 >= 0) {
                        a3 = a3 + ",\"control\":" + i2;
                    }
                    if (z) {
                        a3 = a3 + ",\"detectgps\":0";
                    } else {
                        a3 = a3 + ",\"detectgps\":1";
                    }
                    return ((a3 + ",\"pstat\":" + a4) + ",\"wlan\":" + b) + ",\"attribute\":" + jSONObject + ",\"location\":" + str2 + ",\"cells\":" + a2 + ",\"wifis\":" + a + "}";
                }
            }
            abs = 203;
            if (g.q != null) {
            }
            a3 = ("{\"version\":\"" + (g.q != null ? "None" : g.q) + "\",\"address\":" + i) + ",\"source\":" + abs + ",\"access_token\":\"" + str3 + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str4 + "\",\"bearing\":1";
            if (i2 >= 0) {
                a3 = a3 + ",\"control\":" + i2;
            }
            if (z) {
                a3 = a3 + ",\"detectgps\":0";
            } else {
                a3 = a3 + ",\"detectgps\":1";
            }
            return ((a3 + ",\"pstat\":" + a4) + ",\"wlan\":" + b) + ",\"attribute\":" + jSONObject + ",\"location\":" + str2 + ",\"cells\":" + a2 + ",\"wifis\":" + a + "}";
        } catch (Exception e) {
            return null;
        }
    }

    public final String a(int i, String str, bk bkVar, boolean z, boolean z2, boolean z3, boolean z4) {
        if (z3) {
            return a(i, 1, str, bkVar, z, z2, z4);
        }
        return a(i, 0, str, bkVar, z, z2, z4);
    }
}
