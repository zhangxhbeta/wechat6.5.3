package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.common.c.c;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup implements Parcelable {
    public static final Creator<MultiTalkGroup> CREATOR = new Creator<MultiTalkGroup>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.pta = parcel.readString();
            multiTalkGroup.ptb = parcel.readString();
            multiTalkGroup.ptc = parcel.readString();
            multiTalkGroup.ppl = parcel.readInt();
            multiTalkGroup.ptd = parcel.readString();
            int readInt = parcel.readInt();
            multiTalkGroup.pte = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) parcel.readParcelable(MultiTalkGroupMember.class.getClassLoader());
                if (multiTalkGroupMember != null) {
                    multiTalkGroup.pte.add(multiTalkGroupMember);
                } else {
                    c.d("MultiTalkGroup", "CLTNOT readParcelable member = null");
                }
            }
            return multiTalkGroup;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroup[i];
        }
    };
    public int ppl;
    public String pta = SQLiteDatabase.KeyEmpty;
    public String ptb = SQLiteDatabase.KeyEmpty;
    public String ptc = SQLiteDatabase.KeyEmpty;
    public String ptd = SQLiteDatabase.KeyEmpty;
    public List<MultiTalkGroupMember> pte = new ArrayList();

    public String toString() {
        return "MultiTalkGroup [mMultiTalkGroupId=" + this.pta + ", mMultiTalkClientGroupId=" + this.ptb + ", mWxGroupId=" + this.ptc + ", mRouteId=" + this.ppl + ", mCreatorUsrName=" + this.ptd + ", mMultiTalkGroupMemberList=" + this.pte + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.pta == null ? SQLiteDatabase.KeyEmpty : this.pta);
        parcel.writeString(this.ptb == null ? SQLiteDatabase.KeyEmpty : this.ptb);
        parcel.writeString(this.ptc == null ? SQLiteDatabase.KeyEmpty : this.ptc);
        parcel.writeInt(this.ppl);
        parcel.writeString(this.ptd == null ? SQLiteDatabase.KeyEmpty : this.ptd);
        int size = this.pte == null ? 0 : this.pte.size();
        parcel.writeInt(size);
        while (i2 < size) {
            parcel.writeParcelable((MultiTalkGroupMember) this.pte.get(i2), i);
            i2++;
        }
    }

    public int describeContents() {
        return 0;
    }
}
