package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;

public class MultiTalkGroupData implements Parcelable {
    public static final Creator<MultiTalkGroupData> CREATOR = new Creator<MultiTalkGroupData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.pta = be.ah(parcel.readString(), "");
            multiTalkGroup.ptb = be.ah(parcel.readString(), "");
            multiTalkGroup.ptc = be.ah(parcel.readString(), "");
            multiTalkGroup.ppl = parcel.readInt();
            multiTalkGroup.ptd = be.ah(parcel.readString(), "");
            int readInt = parcel.readInt();
            multiTalkGroup.pte = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                multiTalkGroup.pte.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).hyW);
            }
            return new MultiTalkGroupData(multiTalkGroup);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupData[i];
        }
    };
    private MultiTalkGroup hyV;

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.hyV = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(be.ah(this.hyV.pta, ""));
        parcel.writeString(be.ah(this.hyV.ptb, ""));
        parcel.writeString(be.ah(this.hyV.ptc, ""));
        parcel.writeInt(this.hyV.ppl);
        parcel.writeString(be.ah(this.hyV.ptd, ""));
        parcel.writeInt(this.hyV.pte.size());
        for (int i2 = 0; i2 < this.hyV.pte.size(); i2++) {
            parcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember) this.hyV.pte.get(i2)), i);
        }
    }
}
