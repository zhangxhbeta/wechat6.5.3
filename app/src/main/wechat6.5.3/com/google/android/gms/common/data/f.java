package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public abstract class f {
    public final DataHolder amM;
    public int ani;
    private int anj;

    public f(DataHolder dataHolder, int i) {
        this.amM = (DataHolder) w.Z(dataHolder);
        boolean z = i >= 0 && i < this.amM.amX;
        w.aa(z);
        this.ani = i;
        this.anj = this.amM.bL(this.ani);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return v.d(Integer.valueOf(fVar.ani), Integer.valueOf(this.ani)) && v.d(Integer.valueOf(fVar.anj), Integer.valueOf(this.anj)) && fVar.amM == this.amM;
    }

    public final byte[] getByteArray(String str) {
        DataHolder dataHolder = this.amM;
        int i = this.ani;
        int i2 = this.anj;
        dataHolder.f(str, i);
        return dataHolder.amU[i2].getBlob(i, dataHolder.amT.getInt(str));
    }

    public final int getInteger(String str) {
        DataHolder dataHolder = this.amM;
        int i = this.ani;
        int i2 = this.anj;
        dataHolder.f(str, i);
        return dataHolder.amU[i2].getInt(i, dataHolder.amT.getInt(str));
    }

    public final String getString(String str) {
        return this.amM.b(str, this.ani, this.anj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.ani), Integer.valueOf(this.anj), this.amM});
    }
}
