package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item> extends com.tencent.mm.vending.base.b<_Struct, Cursor> {
    public Cursor Ay = null;
    protected Map<Integer, _Item> eBj = null;
    public int mCount;
    public a pfX;
    protected _Item pfY;

    public interface a {
        void aXR();

        void aXS();
    }

    public abstract _Item a(_Item _Item, Cursor cursor);

    public abstract Cursor aXW();

    protected /* synthetic */ Object prepareVendingDataAsynchronous() {
        if (this.pfX != null) {
            this.pfX.aXR();
        }
        Cursor aXW = aXW();
        if (this.pfX != null) {
            this.pfX.aXS();
        }
        return aXW;
    }

    public b(_Item _Item) {
        this.pfY = _Item;
        this.mCount = -1;
        bKw();
    }

    private Cursor getCursor() {
        if (this.Ay == null || this.Ay.isClosed()) {
            Assert.assertNotNull(this.Ay);
        }
        return this.Ay;
    }

    public void destroyAsynchronous() {
        avc();
    }

    public final void avc() {
        if (this.eBj != null) {
            this.eBj.clear();
        }
        if (this.Ay != null) {
            this.Ay.close();
        }
        this.mCount = -1;
    }

    public final void bKw() {
        if (this.eBj == null) {
            this.eBj = new HashMap();
        }
    }

    public final int bKx() {
        if (this.mCount < 0) {
            this.mCount = getCursor().getCount();
        }
        return this.mCount;
    }

    public final _Item getItem(int i) {
        _Item _Item;
        if (this.eBj != null) {
            _Item = this.eBj.get(Integer.valueOf(i));
            if (_Item != null) {
                return _Item;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.eBj == null) {
            return a(this.pfY, getCursor());
        }
        _Item = a(null, getCursor());
        this.eBj.put(Integer.valueOf(i), _Item);
        return _Item;
    }
}
