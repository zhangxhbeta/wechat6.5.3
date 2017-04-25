package com.tencent.mm.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BindWordingContent implements Parcelable {
    public static final Creator<BindWordingContent> CREATOR = new Creator<BindWordingContent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BindWordingContent(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BindWordingContent[i];
        }
    };
    public Integer cYh = Integer.valueOf(0);
    public String content = SQLiteDatabase.KeyEmpty;
    public String title = SQLiteDatabase.KeyEmpty;

    public BindWordingContent(String str, String str2) {
        this.title = str;
        this.content = str2;
    }

    public BindWordingContent(Parcel parcel) {
        String[] strArr = new String[2];
        parcel.readStringArray(strArr);
        this.title = strArr[0];
        this.content = strArr[1];
        this.cYh = Integer.valueOf(parcel.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{this.title, this.content});
        parcel.writeInt(this.cYh.intValue());
    }
}
