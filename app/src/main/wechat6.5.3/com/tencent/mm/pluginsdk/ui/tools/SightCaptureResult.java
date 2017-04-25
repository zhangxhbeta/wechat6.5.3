package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.common.c.c;

public class SightCaptureResult implements Parcelable {
    public static final Creator<SightCaptureResult> CREATOR = new Creator<SightCaptureResult>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SightCaptureResult(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightCaptureResult[i];
        }
    };
    public boolean jFc = false;
    public boolean lTX = false;
    public boolean lTY = true;
    public String lTZ = SQLiteDatabase.KeyEmpty;
    public String lUa = SQLiteDatabase.KeyEmpty;
    public String lUb = SQLiteDatabase.KeyEmpty;
    public String lUc = SQLiteDatabase.KeyEmpty;
    public int lUd = 0;
    public ahn lUe = new ahn();
    public String lUf = SQLiteDatabase.KeyEmpty;

    public SightCaptureResult(boolean z, String str, String str2, String str3, String str4, int i, ahn com_tencent_mm_protocal_c_ahn) {
        this.lTY = z;
        this.lTZ = str;
        this.lUa = str2;
        this.lUb = str3;
        this.lUd = i;
        this.lUe = com_tencent_mm_protocal_c_ahn;
        this.lUc = str4;
        this.jFc = true;
        this.lTX = false;
    }

    public SightCaptureResult(boolean z, String str) {
        this.lTY = z;
        this.lUf = str;
        this.jFc = false;
        this.lTX = true;
    }

    protected SightCaptureResult(Parcel parcel) {
        boolean z;
        this.jFc = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.lTX = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.lTY = z;
        this.lTZ = parcel.readString();
        this.lUa = parcel.readString();
        this.lUb = parcel.readString();
        this.lUc = parcel.readString();
        this.lUd = parcel.readInt();
        this.lUf = parcel.readString();
        try {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.lUe = new ahn();
            this.lUe.az(bArr);
        } catch (Exception e) {
            c.e("MicroMsg.SightCaptureResult", "read ext info error: %s", e.getMessage());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeByte((byte) (this.jFc ? 1 : 0));
        if (this.lTX) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.lTY) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.lTZ);
        parcel.writeString(this.lUa);
        parcel.writeString(this.lUb);
        parcel.writeString(this.lUc);
        parcel.writeInt(this.lUd);
        parcel.writeString(this.lUf);
        try {
            byte[] toByteArray = this.lUe.toByteArray();
            parcel.writeInt(toByteArray.length);
            parcel.writeByteArray(toByteArray);
        } catch (Exception e) {
            c.e("MicroMsg.SightCaptureResult", "write ext info error");
        }
    }
}
