package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder implements SafeParcelable {
    public static final g CREATOR = new g();
    private static final a ana = new a(new String[0]) {
    };
    public final int akn;
    final String[] amS;
    Bundle amT;
    final CursorWindow[] amU;
    final Bundle amV;
    int[] amW;
    int amX;
    Object amY;
    private boolean amZ = true;
    boolean mClosed = false;
    final int mVersionCode;

    public static class a {
        private final String[] amS;
        private final ArrayList<HashMap<String, Object>> anb;
        private final String anc;
        private final HashMap<Object, Integer> and;
        private boolean ane;
        private String anf;

        private a(String[] strArr, String str) {
            this.amS = (String[]) w.Z(strArr);
            this.anb = new ArrayList();
            this.anc = str;
            this.and = new HashMap();
            this.ane = false;
            this.anf = null;
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mVersionCode = i;
        this.amS = strArr;
        this.amU = cursorWindowArr;
        this.akn = i2;
        this.amV = bundle;
    }

    private boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final String b(String str, int i, int i2) {
        f(str, i);
        return this.amU[i2].getString(i, this.amT.getInt(str));
    }

    public final int bL(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.amX;
        w.aa(z);
        while (i2 < this.amW.length) {
            if (i < this.amW[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.amW.length ? i2 - 1 : i2;
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.amU) {
                    close.close();
                }
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    final void f(String str, int i) {
        if (this.amT == null || !this.amT.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.amX) {
            throw new CursorIndexOutOfBoundsException(i, this.amX);
        }
    }

    protected final void finalize() {
        try {
            if (this.amZ && this.amU.length > 0 && !isClosed()) {
                new StringBuilder("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(this.amY == null ? "internal object: " + toString() : this.amY.toString()).append(")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final void jG() {
        int i;
        int i2 = 0;
        this.amT = new Bundle();
        for (i = 0; i < this.amS.length; i++) {
            this.amT.putInt(this.amS[i], i);
        }
        this.amW = new int[this.amU.length];
        i = 0;
        while (i2 < this.amU.length) {
            this.amW[i2] = i;
            i += this.amU[i2].getNumRows() - (i - this.amU[i2].getStartPosition());
            i2++;
        }
        this.amX = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
