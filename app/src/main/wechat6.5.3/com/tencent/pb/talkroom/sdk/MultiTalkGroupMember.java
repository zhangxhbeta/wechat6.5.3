package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MultiTalkGroupMember implements Parcelable {
    public static final Creator<MultiTalkGroupMember> CREATOR = new Creator<MultiTalkGroupMember>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.ptf = parcel.readString();
            multiTalkGroupMember.ptg = parcel.readString();
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.bhB = parcel.readInt();
            multiTalkGroupMember.pse = parcel.readInt();
            return multiTalkGroupMember;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMember[i];
        }
    };
    public int bhB;
    public int pse;
    public String ptf = SQLiteDatabase.KeyEmpty;
    public String ptg = SQLiteDatabase.KeyEmpty;
    public int status;

    public String toString() {
        return "MultiTalkGroupMember [usrName=" + this.ptf + ", inviteUsrName=" + this.ptg + ", status=" + this.status + ", reason=" + this.bhB + ", inviteTime=" + this.pse + "]";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ptf == null ? SQLiteDatabase.KeyEmpty : this.ptf);
        parcel.writeString(this.ptg == null ? SQLiteDatabase.KeyEmpty : this.ptg);
        parcel.writeInt(this.status);
        parcel.writeInt(this.bhB);
        parcel.writeInt(this.pse);
    }
}
