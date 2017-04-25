package com.tencent.mm.m.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mmdb.AbstractCursor;
import com.tencent.mmdb.DatabaseUtils;
import com.tencent.mmdb.database.SQLiteCursorDriver;
import com.tencent.mmdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g extends AbstractCursor implements d {
    private final i chI;
    private int chJ = 3000;
    public a chK;
    private boolean chL;
    private b<a> chM;
    c chN;
    private boolean chO;
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final Throwable mStackTrace = null;

    public interface a {
        ArrayList<a> e(ArrayList<Object> arrayList);

        a tZ();
    }

    public g(SQLiteCursorDriver sQLiteCursorDriver, String str, i iVar) {
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.chI = iVar;
        this.mColumns = iVar.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    }

    public final void eo(int i) {
        if (i <= 15000 && i >= 2000) {
            this.chJ = i;
        }
    }

    public final void aI(boolean z) {
        this.chL = z;
    }

    public final boolean onMove(int i, int i2) {
        if (!this.chL) {
            boolean z;
            if (this.chN == null) {
                ud();
            }
            c cVar = this.chN;
            int i3 = i2 / cVar.chB;
            if (cVar.chA.indexOfKey(i3) >= 0) {
                if (((Object[]) cVar.chA.get(i3))[(i2 % cVar.chB) * cVar.columnCount] != null) {
                    z = true;
                    if (!z) {
                        eq((i2 / this.chJ) * this.chJ);
                    }
                    this.chN.moveToPosition(i2);
                }
            }
            z = false;
            if (z) {
                eq((i2 / this.chJ) * this.chJ);
            }
            this.chN.moveToPosition(i2);
        } else if (this.chM == null || !this.chM.em(i2)) {
            eq((i2 / this.chJ) * this.chJ);
        }
        return true;
    }

    private void ud() {
        if (this.chN == null) {
            this.chN = new c(this.mColumns, (byte) 0);
        }
    }

    public final int getCount() {
        boolean z = false;
        if (this.mCount == -1) {
            this.mCount = eq(0);
            if (this.chM != null) {
                if (this.mCount != -1 && this.mCount == this.chM.chv.size()) {
                    z = true;
                }
                this.chO = z;
            }
        }
        if (this.chL) {
            return this.chO ? this.chM.chv.size() : this.mCount;
        } else {
            return this.mCount;
        }
    }

    protected final void checkPosition() {
        super.checkPosition();
    }

    private int eq(int i) {
        if (this.chM == null && this.chL) {
            this.chM = new b<a>(this) {
                final /* synthetic */ g chP;

                {
                    this.chP = r1;
                }

                public final a tZ() {
                    g gVar = this.chP;
                    return gVar.chK != null ? gVar.chK.tZ() : null;
                }

                public final ArrayList<a> e(ArrayList<Object> arrayList) {
                    g gVar = this.chP;
                    return gVar.chK != null ? gVar.chK.e(arrayList) : null;
                }
            };
            this.chM.mStartPos = i;
        } else {
            ud();
        }
        return this.chI.a(this.chM, i, this.chJ, this.chN);
    }

    public final int getColumnIndex(String str) {
        int i;
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            Map hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str.lastIndexOf(46);
        if (i != -1) {
            Exception exception = new Exception();
            Log.e("MMDB.SQLiteNewCursor", "requesting column name with table name -- " + str, exception);
            str = str.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final String[] getColumnNames() {
        return this.mColumns;
    }

    public final void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    public final void close() {
        super.close();
        synchronized (this) {
            this.chI.close();
            this.mDriver.cursorClosed();
        }
    }

    public final boolean requery() {
        boolean z = false;
        if (!isClosed()) {
            synchronized (this) {
                if (this.chI.getDatabase().isOpen()) {
                    if (this.chM != null) {
                        this.chM.ua();
                    }
                    this.mPos = -1;
                    this.mCount = -1;
                    this.mDriver.cursorRequeried(this);
                    try {
                        z = super.requery();
                    } catch (IllegalStateException e) {
                        Log.w("MMDB.SQLiteNewCursor", "requery() failed " + e.getMessage(), e);
                    }
                }
            }
        }
        return z;
    }

    protected final void finalize() {
        try {
            if (this.chM != null) {
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final String getString(int i) {
        if (this.chL) {
            return null;
        }
        return this.chN.getString(i);
    }

    public final short getShort(int i) {
        if (this.chL) {
            return (short) 0;
        }
        return this.chN.getShort(i);
    }

    public final int getInt(int i) {
        if (this.chL) {
            return 0;
        }
        return this.chN.getInt(i);
    }

    public final long getLong(int i) {
        if (this.chL) {
            return 0;
        }
        return this.chN.getLong(i);
    }

    public final float getFloat(int i) {
        if (this.chL) {
            return 0.0f;
        }
        return this.chN.getFloat(i);
    }

    public final double getDouble(int i) {
        if (this.chL) {
            return 0.0d;
        }
        return this.chN.getDouble(i);
    }

    public final boolean isNull(int i) {
        if (this.chL) {
            return false;
        }
        return this.chN.isNull(i);
    }

    public final byte[] getBlob(int i) {
        if (this.chL) {
            return null;
        }
        return this.chN.getBlob(i);
    }

    public final a en(int i) {
        a aVar = null;
        if (this.chM != null) {
            b bVar = this.chM;
            if (bVar.em(i)) {
                Object obj = bVar.chv.get(i);
                aVar = (a) bVar.chx.get(obj);
                if (aVar == null) {
                    if (bVar.chy.size() != 0) {
                        ArrayList e = bVar.e(bVar.chy);
                        for (int i2 = 0; i2 < e.size(); i2++) {
                            aVar = (a) e.get(i2);
                            if (aVar != null) {
                                bVar.chx.put(aVar.getKey(), aVar);
                            } else {
                                Log.e("MMDB.CursorDataWindow", "newcursor obj is null");
                            }
                        }
                        bVar.chy.clear();
                    }
                    aVar = (a) bVar.chx.get(obj);
                    if (aVar == null) {
                        Log.e("MMDB.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i);
                    }
                }
            } else {
                Log.e("MMDB.CursorDataWindow", "newcursor cursor getItem error: pos " + i + " loaded num :" + bVar.chv.size());
            }
        }
        return aVar;
    }

    public final boolean a(Object obj, a aVar) {
        if (this.chL && this.chM != null) {
            if (!this.chO && (obj instanceof Object[]) && this.chM.ak(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.chJ -= ((Object[]) obj).length;
            }
            b bVar = this.chM;
            if (aVar != null) {
                Log.i("MMDB.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + aVar);
                bVar.chx.put(obj, aVar);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object remove : objArr) {
                    bVar.chx.remove(remove);
                }
                bVar.c(objArr);
            } else {
                if (bVar.chy == null) {
                    bVar.chy = new ArrayList();
                }
                if (!bVar.chy.contains(obj)) {
                    bVar.chy.add(obj);
                    Log.i("MMDB.CursorDataWindow", "newcursor cursor clearData : " + obj);
                }
                bVar.chx.remove(obj);
            }
        } else if (!this.chL) {
            c cVar = this.chN;
            cVar.mPos = 0;
            cVar.chA.clear();
        }
        return false;
    }

    public final boolean ub() {
        return this.chO;
    }

    public final boolean ep(int i) {
        if (!this.chL) {
            return false;
        }
        b bVar = this.chM;
        if (i > 50) {
            return false;
        }
        if (bVar.chw < 10) {
            return true;
        }
        if (((double) i) / ((double) bVar.chw) < 0.1d) {
            return true;
        }
        return false;
    }

    public final boolean ak(Object obj) {
        if (this.chL && this.chM != null) {
            return this.chM.ak(obj);
        }
        return false;
    }

    public final a am(Object obj) {
        if (!this.chL) {
            Log.e("MMDB.SQLiteNewCursor", "newcursor getItemByKey error " + obj);
            return null;
        } else if (this.chM == null) {
            Log.e("MMDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            return null;
        } else {
            b bVar = this.chM;
            if (bVar.chx != null) {
                return (a) bVar.chx.get(obj);
            }
            return null;
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void a(a aVar) {
        this.chK = aVar;
    }

    public final SparseArray<Object>[] uc() {
        if (!this.chL) {
            return null;
        }
        return new SparseArray[]{this.chM.chv};
    }
}
