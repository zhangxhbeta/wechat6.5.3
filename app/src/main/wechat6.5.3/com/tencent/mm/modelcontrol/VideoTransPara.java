package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoTransPara implements Parcelable {
    public static final Creator<VideoTransPara> CREATOR = new Creator<VideoTransPara>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VideoTransPara(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VideoTransPara[i];
        }
    };
    public int audioSampleRate;
    public int cGk;
    public int cGl;
    public int cGm;
    public int cGn;
    public int cGx;
    public int cdg;
    public int duration;
    public int height;
    public boolean isDefault;
    public int width;

    protected VideoTransPara(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.cdg = parcel.readInt();
        this.cGx = parcel.readInt();
        this.duration = parcel.readInt();
        this.cGl = parcel.readInt();
        this.cGk = parcel.readInt();
        this.audioSampleRate = parcel.readInt();
        this.cGm = parcel.readInt();
        this.cGn = parcel.readInt();
        this.isDefault = parcel.readInt() > 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.cdg);
        parcel.writeInt(this.cGx);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.cGl);
        parcel.writeInt(this.cGk);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.cGm);
        parcel.writeInt(this.cGn);
        parcel.writeInt(this.isDefault ? 1 : 0);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[isDefault " + this.isDefault + "width " + this.width + " height " + this.height + " fps " + this.cdg + " video bitrate " + this.cGx + " iFrame " + this.cGl + " audio bitrate " + this.cGk + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.cGm + " preset index " + this.cGn + "]";
    }
}
