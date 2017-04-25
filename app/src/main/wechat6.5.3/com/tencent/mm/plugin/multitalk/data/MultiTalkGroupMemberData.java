package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData implements Parcelable {
    public static final Creator<MultiTalkGroupMemberData> CREATOR = new Creator<MultiTalkGroupMemberData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.ptf = be.ah(parcel.readString(), "");
            multiTalkGroupMember.ptg = be.ah(parcel.readString(), "");
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.bhB = parcel.readInt();
            multiTalkGroupMember.pse = parcel.readInt();
            return new MultiTalkGroupMemberData(multiTalkGroupMember);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMemberData[i];
        }
    };
    MultiTalkGroupMember hyW;

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.hyW = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(be.ah(this.hyW.ptf, ""));
        parcel.writeString(be.ah(this.hyW.ptg, ""));
        parcel.writeInt(this.hyW.status);
        parcel.writeInt(this.hyW.bhB);
        parcel.writeInt(this.hyW.pse);
    }
}
