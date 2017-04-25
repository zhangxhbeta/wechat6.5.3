package android.support.v4.os;

import android.os.Parcel;

public interface c<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
