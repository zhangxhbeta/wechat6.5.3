package ct;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class cs implements Parcelable, TencentLocation {
    public static final cs a = new cs(-1);
    private co b;
    private int c;
    private int d;
    private String e;
    private cm f;
    private final Bundle g;
    private String h;
    private Location i;
    private final long j;
    private long k;
    private int l;

    public static class a {
        public String a;
        public cs b;
        public int c;
        public String d = TencentLocation.NETWORK_PROVIDER;
        private Location e;

        public final cs a() {
            cs csVar;
            if (this.a != null) {
                try {
                    csVar = new cs(this.a);
                } catch (Throwable e) {
                    ct.b.a.a("TxLocation", "build: ", e);
                    return cs.a;
                }
            }
            csVar = cs.c(this.b);
            csVar.c = this.c.h = this.d.i = this.e;
            TencentExtraKeys.setRawGps(csVar, this.e);
            return csVar;
        }

        public final a a(Location location) {
            this.e = new Location(location);
            return this;
        }
    }

    static /* synthetic */ cs c(cs csVar) {
        cs csVar2 = new cs(-1);
        if (csVar == null) {
            csVar2.b = new co();
        } else {
            co coVar = csVar.b;
            co coVar2 = new co();
            if (coVar != null) {
                coVar2.a = coVar.a;
                coVar2.b = coVar.b;
                coVar2.c = coVar.c;
                coVar2.d = coVar.d;
                coVar2.e = coVar.e;
                coVar2.f = coVar.f;
            }
            csVar2.b = coVar2;
            csVar2.c = csVar.c;
            csVar2.e = csVar.e;
            cm cmVar = csVar.f;
            if (cmVar == null) {
                cmVar = null;
            } else {
                cm cmVar2 = new cm();
                cmVar2.a = cmVar.a;
                cmVar2.c = cq.a(cmVar.c);
                Iterator it = cmVar.b.iterator();
                while (it.hasNext()) {
                    cmVar2.b.add(new cp((TencentPoi) it.next()));
                }
                cmVar = cmVar2;
            }
            csVar2.f = cmVar;
            if (csVar.g.size() > 0) {
                csVar2.g.putAll(csVar.g);
            }
        }
        return csVar2;
    }

    static {
        AnonymousClass1 anonymousClass1 = new Creator<TencentLocation>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                cs csVar = new cs(parcel.readInt());
                co coVar = new co();
                cm cmVar = new cm();
                cq cqVar = new cq();
                cmVar.c = cqVar;
                csVar.h = parcel.readString();
                coVar.a = parcel.readDouble();
                coVar.b = parcel.readDouble();
                coVar.d = parcel.readFloat();
                coVar.c = parcel.readDouble();
                coVar.f = parcel.readString();
                cqVar.b = parcel.readString();
                cqVar.e = parcel.readString();
                cqVar.f = parcel.readString();
                cqVar.g = parcel.readString();
                cqVar.j = parcel.readString();
                cqVar.k = parcel.readString();
                cqVar.c = parcel.readString();
                csVar.b = coVar;
                csVar.f = cmVar;
                csVar.k = parcel.readLong();
                Bundle readBundle = parcel.readBundle();
                if (readBundle != null) {
                    csVar.g.putAll(readBundle);
                }
                return csVar;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new TencentLocation[i];
            }
        };
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeString(getProvider());
        parcel.writeDouble(getLatitude());
        parcel.writeDouble(getLongitude());
        parcel.writeDouble((double) getAccuracy());
        parcel.writeDouble(getAltitude());
        parcel.writeString(getAddress());
        parcel.writeString(getNation());
        parcel.writeString(getProvince());
        parcel.writeString(getCity());
        parcel.writeString(getDistrict());
        parcel.writeString(getStreet());
        parcel.writeString(getStreetNo());
        parcel.writeString(this.f != null ? this.f.c.d : SQLiteDatabase.KeyEmpty);
        parcel.writeString(getName());
        parcel.writeLong(this.k);
        parcel.writeBundle(this.g);
    }

    public final int describeContents() {
        return 0;
    }

    private cs(int i) {
        this.g = new Bundle();
        this.h = TencentLocation.NETWORK_PROVIDER;
        this.c = i;
        this.j = SystemClock.elapsedRealtime();
        this.k = System.currentTimeMillis();
    }

    public final void a(Location location) {
        if (location != null && this.b != null) {
            double latitude = location.getLatitude();
            double round = ((double) Math.round(location.getLongitude() * 1000000.0d)) / 1000000.0d;
            this.b.a = ((double) Math.round(latitude * 1000000.0d)) / 1000000.0d;
            this.b.b = round;
            this.b.c = location.getAltitude();
            this.b.d = location.getAccuracy();
        }
    }

    private cs(String str) {
        this.g = new Bundle();
        this.h = TencentLocation.NETWORK_PROVIDER;
        this.j = SystemClock.elapsedRealtime();
        this.k = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        try {
            this.b = new co(jSONObject.getJSONObject("location"));
            this.e = jSONObject.optString("bearing");
            this.d = jSONObject.optInt("fackgps", 0);
            this.k = jSONObject.optLong("timestamp", System.currentTimeMillis());
            try {
                String optString = jSONObject.optString("icontrol");
                if (!TextUtils.isEmpty(optString)) {
                    this.g.putInt("icontrol", Integer.valueOf(optString.split(",")[0]).intValue());
                    ct.b.a.b("TxLocation", "TxLocation control:" + optString);
                }
            } catch (Exception e) {
                ct.b.a.b("TxLocation", "parse icontrol failed");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("details");
            if (optJSONObject != null) {
                try {
                    this.f = new cm(optJSONObject);
                } catch (Throwable e2) {
                    ct.b.a.a("TxLocation", "details object not found", e2);
                    throw e2;
                }
            }
            jSONObject = jSONObject.optJSONObject("addrdesp");
            if (jSONObject != null && jSONObject.has("detail")) {
                this.f = new cm(jSONObject.optJSONObject("detail"));
            }
            if (this.f != null && this.f.c != null) {
                this.g.putAll(this.f.c.l);
            }
        } catch (JSONException e3) {
            throw e3;
        }
    }

    public final String getProvider() {
        return this.h;
    }

    public final double getLatitude() {
        return this.b != null ? this.b.a : 0.0d;
    }

    public final double getLongitude() {
        return this.b != null ? this.b.b : 0.0d;
    }

    public final double getAltitude() {
        return this.b != null ? this.b.c : 0.0d;
    }

    public final float getAccuracy() {
        return this.b != null ? this.b.d : 0.0f;
    }

    public final String getName() {
        if (this.c == 5) {
            return this.g.getString("addrdesp.name");
        }
        return this.b != null ? this.b.e : SQLiteDatabase.KeyEmpty;
    }

    public final String getAddress() {
        if (this.c == 5) {
            return this.g.getString("addrdesp.name");
        }
        return this.b != null ? this.b.f : SQLiteDatabase.KeyEmpty;
    }

    public final String getNation() {
        return this.f != null ? this.f.c.b : SQLiteDatabase.KeyEmpty;
    }

    public final String getProvince() {
        return this.f != null ? this.f.c.e : SQLiteDatabase.KeyEmpty;
    }

    public final String getCity() {
        return this.f != null ? this.f.c.f : SQLiteDatabase.KeyEmpty;
    }

    public final String getDistrict() {
        return this.f != null ? this.f.c.g : SQLiteDatabase.KeyEmpty;
    }

    public final String getTown() {
        return this.f != null ? this.f.c.h : SQLiteDatabase.KeyEmpty;
    }

    public final String getVillage() {
        return this.f != null ? this.f.c.i : SQLiteDatabase.KeyEmpty;
    }

    public final String getStreet() {
        return this.f != null ? this.f.c.j : SQLiteDatabase.KeyEmpty;
    }

    public final String getStreetNo() {
        return this.f != null ? this.f.c.k : SQLiteDatabase.KeyEmpty;
    }

    public final Integer getAreaStat() {
        return this.f != null ? Integer.valueOf(this.f.a) : null;
    }

    public final List<TencentPoi> getPoiList() {
        return this.f != null ? new ArrayList(this.f.b) : Collections.emptyList();
    }

    public final String getCityCode() {
        return this.f != null ? this.f.c.d : SQLiteDatabase.KeyEmpty;
    }

    public final Bundle getExtra() {
        return this.g;
    }

    public final int getRssi() {
        if (this.i == null) {
            return 0;
        }
        Bundle extras = this.i.getExtras();
        if (extras != null) {
            return extras.getInt("rssi", 0);
        }
        return 0;
    }

    public final float getBearing() {
        return this.i == null ? 0.0f : this.i.getBearing();
    }

    public final float getSpeed() {
        return this.i == null ? 0.0f : this.i.getSpeed();
    }

    public final long getTime() {
        return this.k;
    }

    public final int getCoordinateType() {
        return this.l;
    }

    public final long getElapsedRealtime() {
        return this.j;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TxLocation{");
        stringBuilder.append("level=").append(this.c).append(",");
        stringBuilder.append("name=").append(getName()).append(",");
        stringBuilder.append("address=").append(getAddress()).append(",");
        stringBuilder.append("provider=").append(getProvider()).append(",");
        stringBuilder.append("latitude=").append(getLatitude()).append(",");
        stringBuilder.append("longitude=").append(getLongitude()).append(",");
        stringBuilder.append("altitude=").append(getAltitude()).append(",");
        stringBuilder.append("accuracy=").append(getAccuracy()).append(",");
        stringBuilder.append("cityCode=").append(getCityCode()).append(",");
        stringBuilder.append("areaStat=").append(getAreaStat()).append(",");
        stringBuilder.append("nation=").append(getNation()).append(",");
        stringBuilder.append("province=").append(getProvince()).append(",");
        stringBuilder.append("city=").append(getCity()).append(",");
        stringBuilder.append("district=").append(getDistrict()).append(",");
        stringBuilder.append("street=").append(getStreet()).append(",");
        stringBuilder.append("streetNo=").append(getStreetNo()).append(",");
        stringBuilder.append("town=").append(getTown()).append(",");
        stringBuilder.append("village=").append(getVillage()).append(",");
        stringBuilder.append("bearing=").append(getBearing()).append(",");
        stringBuilder.append("time=").append(getTime()).append(",");
        stringBuilder.append("poilist=[");
        for (TencentPoi append : getPoiList()) {
            stringBuilder.append(append).append(",");
        }
        stringBuilder.append("]");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static cs a(cs csVar, cg cgVar) {
        if (!(csVar == null || cgVar == null || csVar.e == null)) {
            String str = csVar.e;
            int i = 0;
            int i2 = cgVar.f;
            if (str != null && str.split(",").length > 1) {
                i = Integer.parseInt(str.split(",")[1]);
            }
            co coVar = csVar.b;
            if (coVar != null) {
                try {
                    coVar.d = (float) e.r((double) coVar.d, i, i2);
                } catch (UnsatisfiedLinkError e) {
                }
            }
        }
        return csVar;
    }

    public static cs a(cs csVar, int i) {
        csVar.l = i;
        return csVar;
    }

    public static void a(cs csVar) {
        if (csVar == a) {
            throw new JSONException("location failed");
        }
    }

    public final double getDirection() {
        if (this.g != null) {
            return this.g.getDouble(TencentLocation.EXTRA_DIRECTION);
        }
        return Double.NaN;
    }

    public final int isMockGps() {
        return this.d;
    }
}
