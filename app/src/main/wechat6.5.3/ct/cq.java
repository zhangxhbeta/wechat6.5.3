package ct;

import android.os.Bundle;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import ct.b.a;
import org.json.JSONObject;

final class cq {
    public static final cq a = new cq();
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public final Bundle l = new Bundle();

    cq() {
    }

    private cq(cq cqVar) {
        if (cqVar.l.size() > 0) {
            this.l.putAll(cqVar.l);
            return;
        }
        this.b = cqVar.b;
        this.c = cqVar.c;
        this.d = cqVar.d;
        this.e = cqVar.e;
        this.f = cqVar.f;
        this.g = cqVar.g;
        this.h = cqVar.h;
        this.i = cqVar.i;
        this.j = cqVar.j;
        this.k = cqVar.k;
    }

    public static cq a(cq cqVar) {
        if (cqVar == null) {
            return null;
        }
        return new cq(cqVar);
    }

    public cq(JSONObject jSONObject) {
        try {
            if (jSONObject.has(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL1)) {
                String string = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_NATION);
                String string2 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL1);
                String string3 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL2);
                String string4 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL3);
                String string5 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_LOCALITY);
                String string6 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY);
                String string7 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ROUTE);
                this.l.putString(TencentExtraKeys.LOCATION_KEY_NATION, string);
                this.l.putString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL1, string2);
                this.l.putString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL2, string3);
                this.l.putString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL3, string4);
                this.l.putString(TencentExtraKeys.LOCATION_KEY_LOCALITY, string5);
                this.l.putString(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY, string6);
                this.l.putString(TencentExtraKeys.LOCATION_KEY_ROUTE, string7);
                return;
            }
            this.c = jSONObject.getString("name");
            this.d = jSONObject.getString("code");
            this.b = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_NATION);
            this.e = jSONObject.getString("province");
            this.f = jSONObject.getString("city");
            this.g = jSONObject.getString("district");
            this.h = jSONObject.getString("town");
            this.i = jSONObject.getString("village");
            this.j = jSONObject.getString("street");
            this.k = jSONObject.getString("street_no");
        } catch (Throwable e) {
            a.a("TencentJson", "json error", e);
            throw e;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubnationData{");
        stringBuilder.append("name=").append(this.c).append(",");
        stringBuilder.append("code=").append(this.d).append(",");
        stringBuilder.append("nation=").append(this.b).append(",");
        stringBuilder.append("province=").append(this.e).append(",");
        stringBuilder.append("city=").append(this.f).append(",");
        stringBuilder.append("district=").append(this.g).append(",");
        stringBuilder.append("town=").append(this.h).append(",");
        stringBuilder.append("village=").append(this.i).append(",");
        stringBuilder.append("street=").append(this.j).append(",");
        stringBuilder.append("street_no=").append(this.k).append(",");
        stringBuilder.append("bundle").append(this.l).append(",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
