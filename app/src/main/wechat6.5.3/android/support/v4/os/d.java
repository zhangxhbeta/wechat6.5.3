package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class d<T> implements ClassLoaderCreator<T> {
    private final c<T> uW;

    public d(c<T> cVar) {
        this.uW = cVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.uW.createFromParcel(parcel, null);
    }

    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.uW.createFromParcel(parcel, classLoader);
    }

    public final T[] newArray(int i) {
        return this.uW.newArray(i);
    }
}
