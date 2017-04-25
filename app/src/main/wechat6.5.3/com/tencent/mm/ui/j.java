package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class j<T> extends BaseAdapter implements com.tencent.mm.sdk.h.g.a, b {
    public Context context;
    public int count;
    private ac iqg = new ac(Looper.getMainLooper());
    public T nDI;
    public Map<Integer, T> nDJ = null;
    public a nDK;
    private int nDL = 0;
    private int nDM = 0;
    private int nDN = 0;
    private Runnable nDO = new Runnable(this) {
        final /* synthetic */ j nDP;

        {
            this.nDP = r1;
        }

        public final void run() {
            if (this.nDP.nDL != 0) {
                v.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", Integer.valueOf(this.nDP.nDL), Integer.valueOf(j.b(this.nDP)));
                this.nDP.iqg.removeCallbacks(this.nDP.nDO);
                if (20 > this.nDP.nDN) {
                    this.nDP.iqg.postDelayed(this.nDP.nDO, 100);
                    return;
                } else {
                    v.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", Integer.valueOf(this.nDP.nDL), Integer.valueOf(this.nDP.nDN));
                }
            }
            v.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
            this.nDP.nDN = 0;
            this.nDP.bzQ();
        }
    };
    private Cursor nxS = null;

    public interface a {
        void Oi();

        void Oj();
    }

    public abstract void Ol();

    public abstract void Om();

    public abstract T a(T t, Cursor cursor);

    static /* synthetic */ int b(j jVar) {
        int i = jVar.nDN + 1;
        jVar.nDN = i;
        return i;
    }

    public j(Context context, T t) {
        this.nDI = t;
        this.context = context;
        this.count = -1;
    }

    public final Cursor getCursor() {
        if (this.nxS == null || this.nxS.isClosed()) {
            Om();
            Assert.assertNotNull(this.nxS);
        }
        return this.nxS;
    }

    public final void setCursor(Cursor cursor) {
        this.nxS = cursor;
        this.count = -1;
    }

    public final void iQ(boolean z) {
        if (z) {
            if (this.nDJ == null) {
                this.nDJ = new HashMap();
            }
        } else if (this.nDJ != null) {
            this.nDJ.clear();
            this.nDJ = null;
        }
    }

    public void avc() {
        if (this.nDJ != null) {
            this.nDJ.clear();
        }
        if (this.nxS != null) {
            this.nxS.close();
        }
        this.count = -1;
    }

    public int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count + asv();
    }

    public final int aij() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count;
    }

    public long getItemId(int i) {
        return 0;
    }

    public void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public void a(String str, i iVar) {
        bzQ();
    }

    private void bzQ() {
        v.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        if (this.nDK != null) {
            this.nDK.Oj();
        }
        avc();
        Ol();
        if (this.nDK != null) {
            this.nDK.Oi();
        }
    }

    public T getItem(int i) {
        if (lB(i)) {
            return asw();
        }
        T t;
        if (this.nDJ != null) {
            t = this.nDJ.get(Integer.valueOf(i));
            if (t != null) {
                return t;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.nDJ == null) {
            return a(this.nDI, getCursor());
        }
        t = a(null, getCursor());
        this.nDJ.put(Integer.valueOf(i), t);
        return t;
    }

    public boolean lB(int i) {
        return i >= this.count && i < this.count + asv();
    }

    public int asv() {
        return 0;
    }

    public T asw() {
        return this.nDI;
    }
}
