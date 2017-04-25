package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new Creator<BackStackState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mIndex;
    final String mName;
    final int nI;
    final int nJ;
    final int nN;
    final CharSequence nO;
    final int nP;
    final CharSequence nQ;
    final ArrayList<String> nR;
    final ArrayList<String> nS;
    final int[] os;

    public BackStackState(d dVar) {
        int i = 0;
        for (a aVar = dVar.nB; aVar != null; aVar = aVar.od) {
            if (aVar.ol != null) {
                i += aVar.ol.size();
            }
        }
        this.os = new int[(i + (dVar.nD * 7))];
        if (dVar.nK) {
            i = 0;
            for (a aVar2 = dVar.nB; aVar2 != null; aVar2 = aVar2.od) {
                int i2 = i + 1;
                this.os[i] = aVar2.of;
                int i3 = i2 + 1;
                this.os[i2] = aVar2.og != null ? aVar2.og.mIndex : -1;
                int i4 = i3 + 1;
                this.os[i3] = aVar2.oh;
                i2 = i4 + 1;
                this.os[i4] = aVar2.oi;
                i4 = i2 + 1;
                this.os[i2] = aVar2.oj;
                i2 = i4 + 1;
                this.os[i4] = aVar2.ok;
                if (aVar2.ol != null) {
                    int size = aVar2.ol.size();
                    i4 = i2 + 1;
                    this.os[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.os[i4] = ((Fragment) aVar2.ol.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.os[i2] = 0;
                }
            }
            this.nI = dVar.nI;
            this.nJ = dVar.nJ;
            this.mName = dVar.mName;
            this.mIndex = dVar.mIndex;
            this.nN = dVar.nN;
            this.nO = dVar.nO;
            this.nP = dVar.nP;
            this.nQ = dVar.nQ;
            this.nR = dVar.nR;
            this.nS = dVar.nS;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.os = parcel.createIntArray();
        this.nI = parcel.readInt();
        this.nJ = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.nN = parcel.readInt();
        this.nO = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.nP = parcel.readInt();
        this.nQ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.nR = parcel.createStringArrayList();
        this.nS = parcel.createStringArrayList();
    }

    public final d a(l lVar) {
        d dVar = new d(lVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.os.length) {
            a aVar = new a();
            int i3 = i2 + 1;
            aVar.of = this.os[i2];
            if (l.DEBUG) {
                new StringBuilder("Instantiate ").append(dVar).append(" op #").append(i).append(" base fragment #").append(this.os[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.os[i3];
            if (i2 >= 0) {
                aVar.og = (Fragment) lVar.pX.get(i2);
            } else {
                aVar.og = null;
            }
            i3 = i4 + 1;
            aVar.oh = this.os[i4];
            i4 = i3 + 1;
            aVar.oi = this.os[i3];
            i3 = i4 + 1;
            aVar.oj = this.os[i4];
            int i5 = i3 + 1;
            aVar.ok = this.os[i3];
            i4 = i5 + 1;
            int i6 = this.os[i5];
            if (i6 > 0) {
                aVar.ol = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (l.DEBUG) {
                        new StringBuilder("Instantiate ").append(dVar).append(" set remove fragment #").append(this.os[i4]);
                    }
                    i5 = i4 + 1;
                    aVar.ol.add((Fragment) lVar.pX.get(this.os[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            dVar.nE = aVar.oh;
            dVar.nF = aVar.oi;
            dVar.nG = aVar.oj;
            dVar.nH = aVar.ok;
            dVar.a(aVar);
            i++;
            i2 = i4;
        }
        dVar.nI = this.nI;
        dVar.nJ = this.nJ;
        dVar.mName = this.mName;
        dVar.mIndex = this.mIndex;
        dVar.nK = true;
        dVar.nN = this.nN;
        dVar.nO = this.nO;
        dVar.nP = this.nP;
        dVar.nQ = this.nQ;
        dVar.nR = this.nR;
        dVar.nS = this.nS;
        dVar.D(1);
        return dVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.os);
        parcel.writeInt(this.nI);
        parcel.writeInt(this.nJ);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.nN);
        TextUtils.writeToParcel(this.nO, parcel, 0);
        parcel.writeInt(this.nP);
        TextUtils.writeToParcel(this.nQ, parcel, 0);
        parcel.writeStringList(this.nR);
        parcel.writeStringList(this.nS);
    }
}
