package ct;

import ct.b.a;
import org.json.JSONObject;

final class co {
    public double a;
    public double b;
    public double c;
    public float d;
    public String e;
    public String f;

    co() {
    }

    public co(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getDouble("latitude");
            this.b = jSONObject.getDouble("longitude");
            this.c = jSONObject.getDouble("altitude");
            this.d = (float) jSONObject.getDouble("accuracy");
            this.e = jSONObject.optString("name");
            this.f = jSONObject.optString("addr");
        } catch (Throwable e) {
            a.a("TencentJson", "json error", e);
            throw e;
        }
    }
}
