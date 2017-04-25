package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.mm.m.a.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class e<K, T extends com.tencent.mm.m.a.a> extends BaseAdapter {
    public String TAG;
    private int chJ;
    public Context context;
    private int gTv;
    public boolean nzO;
    private c nzP;
    private HashMap<K, b<K, T>> nzQ;
    protected a nzR;
    public int nzS;
    public int nzT;
    public boolean nzU;
    int nzV;
    private boolean nzW;
    private boolean nzX;
    private e nzY;
    public K nzZ;

    public interface a {
        void Oi();

        void Oj();
    }

    public static class b<K, T> {
        public int nAc;
        public T nAd = null;
        public K yt;

        public b(K k, int i, T t) {
            this.yt = k;
            this.nAc = i;
        }

        public final int hashCode() {
            return (this.yt == null ? 0 : this.yt.hashCode()) + ((this.nAc + 31) * 31);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.nAc != bVar.nAc) {
                return false;
            }
            if (this.yt == null) {
                if (bVar.yt != null) {
                    return false;
                }
                return true;
            } else if (this.yt.equals(bVar.yt)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private interface d {
        void bzb();
    }

    private class e {
        final /* synthetic */ e nAa;
        com.tencent.mm.ui.e$e.b nAe;
        private com.tencent.mm.ui.e$e.c nAf;
        LinkedList<Integer> nAg;
        int nAh;

        private class a {
            int nAi;
            final /* synthetic */ e nAj;

            public a(e eVar, int i) {
                this.nAj = eVar;
                this.nAi = i;
            }
        }

        class b extends ac {
            final /* synthetic */ e nAj;
            boolean nAk;
            public final int nAl = 1;
            public final int nAm = 2;

            public b(e eVar, Looper looper) {
                this.nAj = eVar;
                super(looper);
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (!this.nAk) {
                    synchronized (this.nAj) {
                        this.nAj.nAh = this.nAj.bzf();
                        v.i(this.nAj.nAa.TAG, "newcursor updateWorkerRefresh status %d", Integer.valueOf(this.nAj.nAh));
                    }
                    if (message.what == 1) {
                        this.nAj.nAa.bza();
                    } else if (message.what == 2) {
                        this.nAj.nAa.a((c) message.obj, false, true);
                    }
                }
            }
        }

        class c extends ac {
            long lastUpdateTime;
            final /* synthetic */ e nAj;
            long nAn;
            final int nAo = (hashCode() | 1910);
            final int nAp = (hashCode() | 1914);

            public c(e eVar, Looper looper) {
                this.nAj = eVar;
                super(looper);
                eVar.nAg = new LinkedList();
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == this.nAp) {
                    removeMessages(this.nAo);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.nAn > ((long) this.nAj.nAa.nzS) || currentTimeMillis - this.nAn < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) this.nAj.nAa.nzT)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                        e.a(this.nAj);
                    } else {
                        sendEmptyMessageDelayed(this.nAo, (long) this.nAj.nAa.nzS);
                    }
                    this.nAn = currentTimeMillis;
                } else if (message.what == this.nAo) {
                    e.a(this.nAj);
                }
            }
        }

        static /* synthetic */ void a(e eVar) {
            int bzf;
            synchronized (eVar) {
                bzf = eVar.bzf();
                eVar.nAg.clear();
            }
            a aVar = new a(eVar, bzf);
            if (aVar.nAi == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                c cVar = new c(aVar.nAj.nAa, aVar.nAj.nAa.byW());
                bzf = cVar.getCount();
                v.i(aVar.nAj.nAa.TAG, "newcursor fillCursor last : %d  count %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(bzf));
                b bVar = aVar.nAj.nAe;
                Message obtain = Message.obtain();
                obtain.obj = cVar;
                obtain.what = 2;
                bVar.sendMessage(obtain);
                return;
            }
            aVar.nAj.nAe.sendEmptyMessage(1);
        }

        public e(e eVar) {
            this.nAa = eVar;
            bzc();
        }

        private void bzc() {
            this.nAe = new b(this, Looper.getMainLooper());
            this.nAf = new c(this, ak.vA().htb.getLooper());
        }

        private void bzd() {
            c cVar = this.nAf;
            cVar.removeMessages(cVar.nAo);
            cVar.removeMessages(cVar.nAp);
            b bVar = this.nAe;
            bVar.nAk = true;
            bVar.removeMessages(1);
            bVar.removeMessages(2);
            this.nAg.clear();
            this.nAh = 0;
        }

        public final synchronized void bze() {
            v.i(this.nAa.TAG, "newcursor resetQueue ");
            bzd();
            bzc();
        }

        public final synchronized void quit() {
            v.i(this.nAa.TAG, "newcursor quit ");
            bzd();
        }

        final int bzf() {
            if (this.nAg.size() > 1) {
                return 2;
            }
            if (this.nAg.size() == 1) {
                return ((Integer) this.nAg.get(0)).intValue();
            }
            return 0;
        }

        public final synchronized boolean bzg() {
            return this.nAh != 0;
        }

        final synchronized void bzh() {
            this.nAf.lastUpdateTime = System.currentTimeMillis();
        }

        final synchronized int bzi() {
            return this.nAh;
        }

        final synchronized void vu(int i) {
            if (!this.nAg.contains(Integer.valueOf(i))) {
                this.nAg.add(Integer.valueOf(i));
            }
            this.nAh = bzf();
            c cVar = this.nAf;
            cVar.sendEmptyMessage(cVar.nAp);
        }
    }

    class c extends h<K, T> {
        final /* synthetic */ e nAa;

        public c(e eVar, com.tencent.mm.m.a.d<K> dVar) {
            this.nAa = eVar;
            super(dVar, eVar.chJ);
        }

        public final T ue() {
            return this.nAa.tZ();
        }

        public final ArrayList<T> e(ArrayList arrayList) {
            return this.nAa.e(arrayList);
        }
    }

    public abstract SparseArray<K>[] a(HashSet<b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    public abstract com.tencent.mm.m.a.d<K> byW();

    public abstract ArrayList<T> e(ArrayList<K> arrayList);

    public abstract T tZ();

    static /* synthetic */ boolean a(e eVar, HashMap hashMap) {
        for (b bVar : hashMap.values()) {
            if (bVar == null || bVar.nAc == 5) {
                if (bVar == eVar.nzZ) {
                }
            }
            return false;
        }
        return true;
    }

    public /* synthetic */ Object getItem(int i) {
        return en(i);
    }

    public final void a(a aVar) {
        this.nzR = aVar;
    }

    public final void byT() {
        this.nzR = null;
    }

    public e(Context context) {
        this(true, context);
        this.chJ = 5000;
        v.i(this.TAG, "newCursor setPageSize %d", Integer.valueOf(5000));
    }

    private e(boolean z, Context context) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.nzO = true;
        this.nzS = 1000;
        this.nzT = 3000;
        this.nzU = true;
        this.gTv = 0;
        this.nzV = 0;
        this.nzZ = null;
        this.context = context;
        this.nzW = true;
    }

    private e(Context context, int i, int i2) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.nzO = true;
        this.nzS = 1000;
        this.nzT = 3000;
        this.nzU = true;
        this.gTv = 0;
        this.nzV = 0;
        this.nzZ = null;
        this.context = context;
        this.nzW = true;
        this.nzX = false;
        this.nzS = 800;
        this.nzT = 2000;
    }

    public e(Context context, byte b) {
        this(context, 800, 2000);
    }

    private void a(c cVar) {
        iJ(false);
        this.nzP = cVar;
        this.nzP.getCount();
        byU();
    }

    private void a(com.tencent.mm.m.a.d<K> dVar) {
        iJ(true);
        if (this.nzP == null || this.nzP.chQ != dVar) {
            if (!(this.nzP == null || this.nzP.isClosed())) {
                this.nzP.close();
                this.nzP = null;
            }
            this.nzP = new c(this, dVar);
            this.nzP.getCount();
            byU();
            notifyDataSetChanged();
        }
    }

    private void byU() {
        if (this.nzW) {
            int i = this.nzP.ub() ? 1 : 2;
            if (!(i == this.nzV || this.nzV == 0)) {
                if (this.nzY != null && this.nzY.bzg()) {
                    a(new c(this, byW()), true, false);
                }
                v.i(this.TAG, "newcursor change update stats  %d ", Integer.valueOf(i));
            }
            this.nzV = i;
        }
    }

    public boolean ub() {
        if (this.nzP == null) {
            return false;
        }
        return this.nzP.ub();
    }

    public int getCount() {
        if (this.nzP == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(byW());
            v.i(this.TAG, "newcursor createCursor last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        aK("getcount", false);
        return this.nzP.getCount();
    }

    public final int byV() {
        if (this.nzP == null) {
            return 0;
        }
        com.tencent.mm.m.a.d dVar = this.nzP.chQ;
        if (dVar == null) {
            return 0;
        }
        if (dVar instanceof com.tencent.mm.m.a.e) {
            return ((com.tencent.mm.m.a.e) dVar).chG[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    public final void aK(String str, boolean z) {
        if (this.gTv == 0) {
            int i = 1;
        } else {
            boolean z2 = false;
        }
        if (i == 0 && (this.nzU | z) != 0) {
            if (!z) {
                v.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", Boolean.valueOf(this.nzU), str, be.bur());
            }
            iI(false);
        }
    }

    public final T en(int i) {
        if (this.nzP == null) {
            a(byW());
        }
        aK("getItem", false);
        this.nzP.chQ.moveToPosition(i);
        T en = this.nzP.chQ.en(i);
        if (en != null) {
            en.tY();
        } else {
            v.e(this.TAG, "newcursor getItem error %d", Integer.valueOf(i));
        }
        return en;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final T am(K k) {
        if (this.nzP == null) {
            return null;
        }
        return this.nzP.chQ.am(k);
    }

    public final SparseArray<K>[] byX() {
        if (this.nzP == null) {
            return null;
        }
        SparseArray[] uc = this.nzP.uc();
        SparseArray<K>[] sparseArrayArr = new SparseArray[uc.length];
        for (int i = 0; i < sparseArrayArr.length; i++) {
            sparseArrayArr[i] = new SparseArray();
            for (int i2 = 0; i2 < uc[i].size(); i2++) {
                sparseArrayArr[i].put(i2, uc[i].get(i2));
            }
        }
        return sparseArrayArr;
    }

    private void byY() {
        this.nzQ.clear();
        this.nzQ.put(this.nzZ, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void iI(boolean r10) {
        /*
        r9 = this;
        r8 = 2;
        r3 = 1;
        r2 = 0;
        r0 = r9.nzX;
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        if (r10 == 0) goto L_0x006e;
    L_0x0009:
        r0 = r9.nzY;
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r9.nzY;
        r0 = r0.bzg();
        if (r0 != 0) goto L_0x001b;
    L_0x0015:
        r0 = r9.byZ();
        if (r0 == 0) goto L_0x0068;
    L_0x001b:
        r0 = r3;
    L_0x001c:
        if (r0 == 0) goto L_0x0065;
    L_0x001e:
        r1 = r9.byZ();
        r0 = r9.nzY;
        if (r0 == 0) goto L_0x009d;
    L_0x0026:
        r0 = r9.nzY;
        r0 = r0.bzi();
        r4 = r9.TAG;
        r5 = "newcursor mWorkerHandler.isHandingMsg,type is %d ";
        r6 = new java.lang.Object[r3];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        if (r0 == 0) goto L_0x0043;
    L_0x003e:
        r4 = r9.nzY;
        r4.bze();
    L_0x0043:
        if (r1 == r8) goto L_0x009d;
    L_0x0045:
        r1 = r9.TAG;
        r4 = "newcursor ensureNewState  refreshstatus is %d ";
        r5 = new java.lang.Object[r3];
        r6 = java.lang.Integer.valueOf(r0);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r1, r4, r5);
        r9.gTv = r2;
        if (r0 != r8) goto L_0x006a;
    L_0x0059:
        r0 = new com.tencent.mm.ui.e$c;
        r1 = r9.byW();
        r0.<init>(r9, r1);
        r9.a(r0, r3, r3);
    L_0x0065:
        r9.gTv = r2;
    L_0x0067:
        return;
    L_0x0068:
        r0 = r2;
        goto L_0x001c;
    L_0x006a:
        r9.bza();
        goto L_0x0065;
    L_0x006e:
        r0 = r9.byZ();
        if (r0 != 0) goto L_0x007d;
    L_0x0074:
        r0 = r9.TAG;
        r1 = "newcursor need not change ";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0067;
    L_0x007d:
        if (r0 != r8) goto L_0x008c;
    L_0x007f:
        r1 = r9.TAG;
        r3 = "newcursor enqueueMessage resetcursor ";
        com.tencent.mm.sdk.platformtools.v.i(r1, r3);
        r1 = r9.nzQ;
        r1.clear();
    L_0x008c:
        r1 = r9.nzY;
        if (r1 != 0) goto L_0x0097;
    L_0x0090:
        r1 = new com.tencent.mm.ui.e$e;
        r1.<init>(r9);
        r9.nzY = r1;
    L_0x0097:
        r1 = r9.nzY;
        r1.vu(r0);
        goto L_0x0065;
    L_0x009d:
        r0 = r1;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.e.iI(boolean):void");
    }

    private int byZ() {
        if (this.nzQ == null || this.nzQ.size() == 0) {
            return 0;
        }
        if (this.nzQ.containsKey(this.nzZ)) {
            return 2;
        }
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(K r10, int r11) {
        /*
        r9 = this;
        r6 = 5;
        r8 = 3;
        r7 = 2;
        r1 = 0;
        r2 = 1;
        r0 = r9.nzP;
        if (r0 == 0) goto L_0x0070;
    L_0x0009:
        r0 = r9.nzQ;
        if (r0 != 0) goto L_0x0014;
    L_0x000d:
        r0 = new java.util.HashMap;
        r0.<init>();
        r9.nzQ = r0;
    L_0x0014:
        r0 = r9.nzQ;
        r3 = r9.nzZ;
        r0 = r0.containsKey(r3);
        if (r11 == r6) goto L_0x0024;
    L_0x001e:
        r3 = r9.nzW;
        if (r3 == 0) goto L_0x0024;
    L_0x0022:
        if (r11 != r2) goto L_0x007f;
    L_0x0024:
        if (r11 == r6) goto L_0x0071;
    L_0x0026:
        r9.byY();
    L_0x0029:
        r0 = r9.TAG;
        r3 = "newcursor syncHandle is true ,changeType is %d  ";
        r4 = new java.lang.Object[r2];
        r5 = java.lang.Integer.valueOf(r11);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        r0 = r2;
    L_0x003a:
        r3 = r9.byZ();
        r9.gTv = r3;
        r4 = r9.TAG;
        r5 = "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ";
        r6 = new java.lang.Object[r8];
        r3 = r9.gTv;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r1] = r3;
        r3 = r9.nzV;
        if (r3 != r2) goto L_0x0168;
    L_0x0053:
        r3 = r2;
    L_0x0054:
        r3 = java.lang.Boolean.valueOf(r3);
        r6[r2] = r3;
        r3 = java.lang.Integer.valueOf(r11);
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        if (r0 == 0) goto L_0x016b;
    L_0x0065:
        r0 = r9.TAG;
        r1 = "newcursor event is refresh sync ";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r9.iI(r2);
    L_0x0070:
        return;
    L_0x0071:
        if (r0 != 0) goto L_0x0029;
    L_0x0073:
        r0 = r9.nzQ;
        r3 = new com.tencent.mm.ui.e$b;
        r4 = 0;
        r3.<init>(r10, r11, r4);
        r0.put(r10, r3);
        goto L_0x0029;
    L_0x007f:
        if (r0 == 0) goto L_0x008a;
    L_0x0081:
        r0 = r9.TAG;
        r1 = "newcursor need reset ,return ";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0070;
    L_0x008a:
        r0 = r9.nzV;
        if (r0 != r2) goto L_0x0162;
    L_0x008e:
        r0 = r9.nzP;
        r0 = r0.ak(r10);
        if (r0 != 0) goto L_0x0098;
    L_0x0096:
        if (r11 != r7) goto L_0x0157;
    L_0x0098:
        r4 = r9.nzQ;
        r5 = new com.tencent.mm.ui.e$b;
        r0 = 0;
        r5.<init>(r10, r11, r0);
        r0 = r5.nAc;
        if (r0 != r7) goto L_0x00b0;
    L_0x00a4:
        r0 = r9.nzP;
        r3 = r5.yt;
        r0 = r0.ak(r3);
        if (r0 == 0) goto L_0x00b0;
    L_0x00ae:
        r5.nAc = r8;
    L_0x00b0:
        r0 = r4.get(r10);
        r0 = (com.tencent.mm.ui.e.b) r0;
        if (r0 == 0) goto L_0x0111;
    L_0x00b8:
        r3 = r2;
    L_0x00b9:
        if (r3 == 0) goto L_0x0152;
    L_0x00bb:
        r4.remove(r0);
        r3 = r5.nAc;
        switch(r3) {
            case 2: goto L_0x0126;
            case 3: goto L_0x00c3;
            case 4: goto L_0x00c3;
            case 5: goto L_0x0113;
            default: goto L_0x00c3;
        };
    L_0x00c3:
        r0 = r0.nAc;
        switch(r0) {
            case 2: goto L_0x014e;
            case 3: goto L_0x00c8;
            case 4: goto L_0x00c8;
            case 5: goto L_0x0144;
            default: goto L_0x00c8;
        };
    L_0x00c8:
        r5.nAc = r8;
    L_0x00ca:
        r4.put(r10, r5);
    L_0x00cd:
        r0 = r9.nzP;
        r3 = r4.size();
        r0 = r0.chQ;
        r0 = r0.ep(r3);
        if (r0 != 0) goto L_0x00f8;
    L_0x00db:
        r0 = r9.TAG;
        r3 = "newcursor events size exceed limit :size is :  %d";
        r5 = new java.lang.Object[r2];
        r6 = r4.size();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r5);
        r4.clear();
        r0 = r9.nzZ;
        r3 = 0;
        r4.put(r0, r3);
    L_0x00f8:
        r0 = r9.TAG;
        r3 = "newcursor add event events size %d";
        r4 = new java.lang.Object[r2];
        r5 = r9.nzQ;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        r0 = r1;
        goto L_0x003a;
    L_0x0111:
        r3 = r1;
        goto L_0x00b9;
    L_0x0113:
        r0 = r0.nAc;
        switch(r0) {
            case 2: goto L_0x00f8;
            case 3: goto L_0x0118;
            case 4: goto L_0x0118;
            case 5: goto L_0x011b;
            default: goto L_0x0118;
        };
    L_0x0118:
        r5.nAc = r6;
        goto L_0x00ca;
    L_0x011b:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now delete, impossible";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        r5.nAc = r6;
        goto L_0x00ca;
    L_0x0126:
        r0 = r0.nAc;
        switch(r0) {
            case 2: goto L_0x0139;
            case 3: goto L_0x012b;
            case 4: goto L_0x012b;
            case 5: goto L_0x0136;
            default: goto L_0x012b;
        };
    L_0x012b:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last update, now insert, impossible";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        r5.nAc = r7;
        goto L_0x00ca;
    L_0x0136:
        r5.nAc = r8;
        goto L_0x00ca;
    L_0x0139:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last insert, now insert, impossible";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        r5.nAc = r7;
        goto L_0x00ca;
    L_0x0144:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now update, impossible";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        goto L_0x00c8;
    L_0x014e:
        r5.nAc = r7;
        goto L_0x00ca;
    L_0x0152:
        r4.put(r10, r5);
        goto L_0x00cd;
    L_0x0157:
        r0 = r9.TAG;
        r3 = "newcursor event pass ";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        r0 = r1;
        goto L_0x003a;
    L_0x0162:
        r9.byY();
        r0 = r1;
        goto L_0x003a;
    L_0x0168:
        r3 = r1;
        goto L_0x0054;
    L_0x016b:
        r0 = r9.nzO;
        if (r0 == 0) goto L_0x0070;
    L_0x016f:
        r0 = r9.nzU;
        if (r0 == 0) goto L_0x0070;
    L_0x0173:
        r9.iI(r1);
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.e.o(java.lang.Object, int):void");
    }

    public void pause() {
        this.nzO = false;
        v.i(this.TAG, "new cursor pasue");
    }

    private void a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.nzR != null) {
            this.nzR.Oj();
        }
        dVar.bzb();
        notifyDataSetChanged();
        if (this.nzR != null) {
            this.nzR.Oi();
        }
        if (this.nzY != null) {
            this.nzY.bzh();
        }
        v.i(this.TAG, "newcursor update callback last :%d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void bza() {
        if (this.nzP == null || this.nzP.isClosed() || this.nzQ.size() != 0) {
            a(new d(this) {
                final /* synthetic */ e nAa;

                {
                    this.nAa = r1;
                }

                public final void bzb() {
                    if (e.a(this.nAa, this.nAa.nzQ)) {
                        HashSet hashSet = new HashSet(this.nAa.nzQ.size());
                        for (b bVar : this.nAa.nzQ.values()) {
                            hashSet.add(bVar.yt);
                        }
                        v.i(this.nAa.TAG, "newcursor all event is delete");
                        this.nAa.nzP.b(hashSet.toArray(), null);
                    } else if (this.nAa.nzQ.containsKey(this.nAa.nzZ)) {
                        r2 = System.currentTimeMillis();
                        this.nAa.a(new c(this.nAa, this.nAa.byW()), true, false);
                        v.i(this.nAa.TAG, "cache unuseful,reset cursor,last : %d", Long.valueOf(System.currentTimeMillis() - r2));
                    } else {
                        r2 = System.currentTimeMillis();
                        SparseArray[] byX = this.nAa.byX();
                        SparseArray[] a = this.nAa.a(new HashSet(this.nAa.nzQ.values()), byX);
                        int length = byX.length;
                        if (length > 1) {
                            for (int i = 0; i < length; i++) {
                                v.i(this.nAa.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - r2), Integer.valueOf(byX[i].size()), Integer.valueOf(a[i].size()));
                            }
                        } else {
                            v.i(this.nAa.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Long.valueOf(System.currentTimeMillis() - r2), Integer.valueOf(byX[0].size()), Integer.valueOf(a[0].size()));
                        }
                        for (b bVar2 : this.nAa.nzQ.values()) {
                            if (bVar2 != null) {
                                if (bVar2.nAd != null) {
                                    v.i(this.nAa.TAG, "newcursor notify cache update : key : %s ", bVar2.yt);
                                }
                                this.nAa.nzP.b(bVar2.yt, (com.tencent.mm.m.a.a) bVar2.nAd);
                            } else {
                                v.e(this.nAa.TAG, "newcursor event is null ! ");
                            }
                        }
                        this.nAa.a(a);
                        v.i(this.nAa.TAG, "newcursor after resort new pos size :%d  ", Integer.valueOf(this.nAa.nzP.uc()[0].size()));
                    }
                    this.nAa.nzQ.clear();
                }
            });
        } else {
            v.i(this.TAG, "events size is 0  ");
        }
    }

    private void a(final c cVar, boolean z, boolean z2) {
        if (z) {
            if (this.nzY != null && this.nzY.bzg()) {
                this.nzY.bze();
            }
            if (this.nzQ != null) {
                this.nzQ.clear();
            }
        }
        if (z2) {
            a(new d(this) {
                final /* synthetic */ e nAa;

                public final void bzb() {
                    this.nAa.a(cVar);
                }
            });
        } else {
            a((c) cVar);
        }
    }

    public final void a(SparseArray<K>[] sparseArrayArr) {
        SparseArray[] uc = this.nzP.uc();
        for (int i = 0; i < uc.length; i++) {
            uc[i].clear();
            for (int i2 = 0; i2 < sparseArrayArr[i].size(); i2++) {
                uc[i].put(i2, sparseArrayArr[i].get(i2));
            }
        }
    }

    public final void iJ(boolean z) {
        if (this.nzP != null) {
            this.nzP.close();
            this.nzP = null;
        }
        if (z && this.nzY != null) {
            this.nzY.quit();
            this.nzY = null;
            if (this.nzQ != null) {
                this.nzQ.clear();
                v.i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.gTv = 0;
        this.nzV = 0;
    }
}
