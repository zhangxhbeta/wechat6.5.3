package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mmdb.database.SQLiteDatabase;

public class SightParams implements Parcelable {
    public static final Creator<SightParams> CREATOR = new Creator<SightParams>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SightParams(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightParams[i];
        }
    };
    public VideoTransPara hnB;
    public int hww = 2;
    public String lUg = SQLiteDatabase.KeyEmpty;
    public String lUh = SQLiteDatabase.KeyEmpty;
    public String lUi = SQLiteDatabase.KeyEmpty;
    public String lUj = SQLiteDatabase.KeyEmpty;
    public String lUk = SQLiteDatabase.KeyEmpty;
    public boolean lUl = true;
    public int lUm;
    public int mode = 0;
    public int scene = -1;

    public SightParams(int i, int i2) {
        if (i == 1) {
            this.hnB = d.En().Ej();
        } else if (i == 2 || i == 3) {
            this.hnB = d.En().Ek();
        } else {
            this.hnB = d.En().Ek();
        }
        this.scene = i;
        this.mode = i2;
        ak.yW();
        this.lUm = ((Integer) c.vf().get(344066, Integer.valueOf(0))).intValue();
    }

    protected SightParams(Parcel parcel) {
        this.mode = parcel.readInt();
        this.hnB = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.lUg = parcel.readString();
        this.lUh = parcel.readString();
        this.lUi = parcel.readString();
        this.lUj = parcel.readString();
        this.lUm = parcel.readInt();
        this.hww = parcel.readInt();
        this.lUl = parcel.readInt() > 0;
        this.scene = parcel.readInt();
    }

    public final SightParams l(String str, String str2, String str3, String str4) {
        this.lUi = str;
        this.lUg = str2;
        this.lUh = str3;
        this.lUj = str4;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mode);
        parcel.writeParcelable(this.hnB, i);
        parcel.writeString(this.lUg);
        parcel.writeString(this.lUh);
        parcel.writeString(this.lUi);
        parcel.writeString(this.lUj);
        parcel.writeInt(this.lUm);
        parcel.writeInt(this.hww);
        parcel.writeInt(this.lUl ? 1 : 0);
        parcel.writeInt(this.scene);
    }
}
