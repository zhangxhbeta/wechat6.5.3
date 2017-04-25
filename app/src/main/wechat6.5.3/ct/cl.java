package ct;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.map.geolocation.TencentLocation;
import org.json.JSONObject;

final class cl implements cr {
    public String a;
    public String b;
    public String c;
    public double d;
    public double e;
    public double f;
    public String g;
    public String h;

    static {
        AnonymousClass1 anonymousClass1 = new Creator<cl>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                cl clVar = new cl();
                clVar.a = parcel.readString();
                clVar.b = parcel.readString();
                clVar.c = parcel.readString();
                clVar.d = parcel.readDouble();
                clVar.e = parcel.readDouble();
                clVar.f = parcel.readDouble();
                clVar.g = parcel.readString();
                clVar.h = parcel.readString();
                return clVar;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new cl[i];
            }
        };
    }

    public cl(JSONObject jSONObject) {
        this.a = jSONObject.optString("name");
        this.b = jSONObject.optString("dtype");
        this.c = jSONObject.optString("addr");
        this.d = jSONObject.optDouble("pointx");
        this.e = jSONObject.optDouble("pointy");
        this.f = jSONObject.optDouble("dist");
        this.g = jSONObject.optString(TencentLocation.EXTRA_DIRECTION);
        this.h = jSONObject.optString("tag");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddressData{");
        stringBuilder.append("name=").append(this.a).append(",");
        stringBuilder.append("dtype=").append(this.b).append(",");
        stringBuilder.append("pointx=").append(this.d).append(",");
        stringBuilder.append("pointy=").append(this.e).append(",");
        stringBuilder.append("dist=").append(this.f).append(",");
        stringBuilder.append("direction=").append(this.g).append(",");
        stringBuilder.append("tag=").append(this.h).append(",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.e);
        parcel.writeDouble(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
