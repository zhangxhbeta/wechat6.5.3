package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.sdk.platformtools.be;

public class LocationIntent implements Parcelable {
    public static final Creator<LocationIntent> CREATOR = new Creator<LocationIntent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            LocationIntent locationIntent = new LocationIntent();
            locationIntent.lat = parcel.readDouble();
            locationIntent.lng = parcel.readDouble();
            locationIntent.bhu = parcel.readInt();
            locationIntent.label = parcel.readString();
            locationIntent.gUr = be.ah(parcel.readString(), "");
            locationIntent.lyO = be.ah(parcel.readString(), "");
            locationIntent.gRO = be.ah(parcel.readString(), "");
            locationIntent.lyP = parcel.readInt();
            locationIntent.cJy = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
            return locationIntent;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationIntent[i];
        }
    };
    public int bhu = 0;
    public Addr cJy = null;
    public String gRO;
    public String gUr = "";
    public String label = "";
    public double lat;
    public double lng;
    public String lyO = "";
    public int lyP = 0;

    public final String Wb() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lat " + this.lat + ";");
        stringBuffer.append("lng " + this.lng + ";");
        stringBuffer.append("scale " + this.bhu + ";");
        stringBuffer.append("label " + this.label + ";");
        stringBuffer.append("poiname " + this.gUr + ";");
        stringBuffer.append("infourl " + this.lyO + ";");
        stringBuffer.append("locTypeId " + this.gRO + ";");
        stringBuffer.append("poiType " + this.lyP + ";");
        if (this.cJy != null) {
            stringBuffer.append("addr " + this.cJy.toString() + ";");
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.bhu);
        parcel.writeString(this.label);
        parcel.writeString(this.gUr);
        parcel.writeString(this.lyO);
        parcel.writeString(this.gRO);
        parcel.writeInt(this.lyP);
        parcel.writeParcelable(this.cJy, i);
    }
}
