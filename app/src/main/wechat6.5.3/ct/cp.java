package ct;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mmdb.database.SQLiteDatabase;
import ct.b.a;
import org.json.JSONObject;

final class cp implements TencentPoi {
    private String a;
    private String b;
    private String c;
    private double d;
    private String e;
    private double f;
    private double g;
    private String h;

    public cp(TencentPoi tencentPoi) {
        this.a = tencentPoi.getName();
        this.b = tencentPoi.getAddress();
        this.c = tencentPoi.getCatalog();
        this.d = tencentPoi.getDistance();
        this.e = tencentPoi.getUid();
        this.f = tencentPoi.getLatitude();
        this.g = tencentPoi.getLongitude();
        this.h = tencentPoi.getDirection();
    }

    public cp(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getString("name");
            this.b = jSONObject.getString("addr");
            this.c = jSONObject.getString("catalog");
            this.d = jSONObject.optDouble("dist");
            this.e = jSONObject.getString("uid");
            this.f = jSONObject.optDouble("latitude");
            this.g = jSONObject.optDouble("longitude");
            this.h = jSONObject.optString(TencentLocation.EXTRA_DIRECTION, SQLiteDatabase.KeyEmpty);
            if (Double.isNaN(this.f)) {
                this.f = jSONObject.optDouble("pointy");
            }
            if (Double.isNaN(this.g)) {
                this.g = jSONObject.optDouble("pointx");
            }
        } catch (Throwable e) {
            a.a("TencentJson", "json error", e);
            throw e;
        }
    }

    public final String getName() {
        return this.a;
    }

    public final String getAddress() {
        return this.b;
    }

    public final String getCatalog() {
        return this.c;
    }

    public final double getDistance() {
        return this.d;
    }

    public final double getLatitude() {
        return this.f;
    }

    public final double getLongitude() {
        return this.g;
    }

    public final String getUid() {
        return this.e;
    }

    public final String getDirection() {
        return this.h;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PoiData{");
        stringBuilder.append("name=").append(this.a).append(",");
        stringBuilder.append("addr=").append(this.b).append(",");
        stringBuilder.append("catalog=").append(this.c).append(",");
        stringBuilder.append("dist=").append(this.d).append(",");
        stringBuilder.append("latitude=").append(this.f).append(",");
        stringBuilder.append("longitude=").append(this.g).append(",");
        stringBuilder.append("direction=").append(this.h).append(",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
