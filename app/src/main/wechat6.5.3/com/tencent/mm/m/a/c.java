package com.tencent.mm.m.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mmdb.AbstractCursor;

public final class c extends AbstractCursor {
    public SparseArray<Object[]> chA;
    public int chB;
    public int chC;
    public final int columnCount;
    private final String[] columnNames;

    public class a {
        private Object[] chD;
        final /* synthetic */ c chE;
        private final int endIndex;
        private int index;

        public a(c cVar, int i, int i2, Object[] objArr) {
            this.chE = cVar;
            this.index = i;
            this.endIndex = i2;
            this.chD = objArr;
        }

        public final a al(Object obj) {
            if (this.index == this.endIndex) {
                throw new CursorIndexOutOfBoundsException("No more columns left.");
            }
            Object[] objArr = this.chD;
            int i = this.index;
            this.index = i + 1;
            objArr[i] = obj;
            return this;
        }
    }

    private c(String[] strArr) {
        this.chB = 3000;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.chA = new SparseArray();
    }

    public c(String[] strArr, byte b) {
        this(strArr);
    }

    private Object get(int i) {
        if (i < 0 || i >= this.columnCount) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + i + ", # of columns: " + this.columnCount);
        } else if (this.mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        } else if (this.mPos >= this.chC) {
            throw new CursorIndexOutOfBoundsException("After last row.");
        } else {
            return ((Object[]) this.chA.get(this.mPos / this.chB))[((this.mPos % this.chB) * this.columnCount) + i];
        }
    }

    public final int getCount() {
        return this.chC;
    }

    public final String[] getColumnNames() {
        return this.columnNames;
    }

    public final String getString(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public final short getShort(int i) {
        Object obj = get(i);
        if (obj == null) {
            return (short) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        return Short.parseShort(obj.toString());
    }

    public final int getInt(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return Integer.parseInt(obj.toString());
    }

    public final long getLong(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return Long.parseLong(obj.toString());
    }

    public final float getFloat(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return Float.parseFloat(obj.toString());
    }

    public final double getDouble(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return Double.parseDouble(obj.toString());
    }

    public final boolean isNull(int i) {
        return get(i) == null;
    }

    public final byte[] getBlob(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return (byte[]) obj;
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
