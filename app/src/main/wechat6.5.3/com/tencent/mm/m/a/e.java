package com.tencent.mm.m.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.m.a.g.a;
import com.tencent.mmdb.AbstractCursor;

public final class e extends AbstractCursor implements d {
    private DataSetObserver Xm = new DataSetObserver(this) {
        final /* synthetic */ e chH;

        {
            this.chH = r1;
        }

        public final void onChanged() {
            this.chH.mPos = -1;
        }

        public final void onInvalidated() {
            this.chH.mPos = -1;
        }
    };
    private d chF;
    public d[] chG;

    public e(g[] gVarArr) {
        int i = 0;
        this.chG = gVarArr;
        this.chF = gVarArr[0];
        while (i < this.chG.length) {
            if (this.chG[i] != null) {
                this.chG[i].registerDataSetObserver(this.Xm);
            }
            i++;
        }
    }

    public final int getCount() {
        int i = 0;
        int length = this.chG.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.chG[i2] != null) {
                i += this.chG[i2].getCount();
            }
        }
        return i;
    }

    public final boolean onMove(int i, int i2) {
        this.chF = null;
        int length = this.chG.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.chG[i4] != null) {
                if (i2 < this.chG[i4].getCount() + i3) {
                    this.chF = this.chG[i4];
                    break;
                }
                i3 += this.chG[i4].getCount();
            }
        }
        if (this.chF != null) {
            return this.chF.moveToPosition(i2 - i3);
        }
        return false;
    }

    public final String getString(int i) {
        return this.chF.getString(i);
    }

    public final short getShort(int i) {
        return this.chF.getShort(i);
    }

    public final int getInt(int i) {
        return this.chF.getInt(i);
    }

    public final long getLong(int i) {
        return this.chF.getLong(i);
    }

    public final float getFloat(int i) {
        return this.chF.getFloat(i);
    }

    public final double getDouble(int i) {
        return this.chF.getDouble(i);
    }

    public final boolean isNull(int i) {
        return this.chF.isNull(i);
    }

    public final byte[] getBlob(int i) {
        return this.chF.getBlob(i);
    }

    public final String[] getColumnNames() {
        if (this.chF != null) {
            return this.chF.getColumnNames();
        }
        return new String[0];
    }

    public final void deactivate() {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].deactivate();
            }
        }
        super.deactivate();
    }

    public final void close() {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].close();
            }
        }
        super.close();
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].registerContentObserver(contentObserver);
            }
        }
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].unregisterContentObserver(contentObserver);
            }
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public final boolean requery() {
        int length = this.chG.length;
        int i = 0;
        while (i < length) {
            if (this.chG[i] != null && !this.chG[i].requery()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void a(a aVar) {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].a(aVar);
            }
        }
    }

    public final void aI(boolean z) {
        int length = this.chG.length;
        for (int i = 0; i < length; i++) {
            if (this.chG[i] != null) {
                this.chG[i].aI(z);
            }
        }
    }

    public final boolean ub() {
        int length = this.chG.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            if (!(this.chG[i] == null || this.chG[i].ub())) {
                z = false;
            }
            i++;
        }
        return z;
    }

    public final a en(int i) {
        int length = this.chG.length;
        for (int i2 = 0; i2 < length; i2++) {
            int count = this.chG[i2].getCount();
            if (i < count) {
                return this.chG[i2].en(i);
            }
            i -= count;
        }
        return null;
    }

    public final boolean a(Object obj, a aVar) {
        boolean z = false;
        int length = this.chG.length;
        int i = 0;
        while (i < length) {
            if (this.chG[i] != null && this.chG[i].a(obj, aVar)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final SparseArray<Object>[] uc() {
        int length = this.chG.length;
        SparseArray<Object>[] sparseArrayArr = new SparseArray[length];
        for (int i = 0; i < length; i++) {
            sparseArrayArr[i] = this.chG[i].uc()[0];
        }
        return sparseArrayArr;
    }

    public final boolean ep(int i) {
        int length = this.chG.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            if (!(this.chG[i2] == null || this.chG[i2].ep(i))) {
                z = false;
            }
            i2++;
        }
        return z;
    }

    public final boolean ak(Object obj) {
        boolean z = false;
        int length = this.chG.length;
        int i = 0;
        while (i < length) {
            if (this.chG[i] != null && this.chG[i].ak(obj)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final a am(Object obj) {
        return this.chF.am(obj);
    }

    public final void eo(int i) {
        int length = this.chG.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.chG[i2] != null) {
                this.chG[i2].eo(i);
            }
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }
}
