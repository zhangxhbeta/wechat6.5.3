package com.tencent.mm.m.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mmdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a> extends SQLiteClosable {
    public SparseArray<Object> chv = new SparseArray();
    public int chw;
    public HashMap<Object, T> chx = new HashMap();
    ArrayList<Object> chy;
    public T chz;
    public int mStartPos = 0;

    public abstract ArrayList<T> e(ArrayList<Object> arrayList);

    public abstract T tZ();

    public final boolean em(int i) {
        return this.chv.indexOfKey(i) >= 0;
    }

    public final void ua() {
        this.chv.clear();
        this.chx.clear();
    }

    protected void onAllReferencesReleased() {
        ua();
    }

    final void c(Object[] objArr) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < this.chv.size(); i2++) {
            int keyAt = this.chv.keyAt(i2);
            Object valueAt = this.chv.valueAt(i2);
            Object obj = 1;
            for (Object equals : objArr) {
                if (equals.equals(valueAt)) {
                    i++;
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                sparseArray.put(keyAt - i, valueAt);
            } else {
                Log.i("MMDB.CursorDataWindow", "newcursor delete index : " + i2 + " obj : " + valueAt);
            }
        }
        if (this.chv.size() != sparseArray.size()) {
            Log.i("MMDB.CursorDataWindow", "newcursor oldposition size :" + this.chv.size() + " newposistion Size : " + sparseArray.size());
        }
        this.chv = sparseArray;
    }

    public final boolean ak(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                if (this.chx == null || !this.chx.containsKey(objArr[0])) {
                    return false;
                }
                return true;
            }
        }
        return this.chx != null && this.chx.containsKey(obj);
    }
}
