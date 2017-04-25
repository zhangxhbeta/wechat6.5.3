package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change> implements com.tencent.mm.vending.e.a {
    private static final int MESSAGE_DO_DESTROY = 2;
    private static final int MESSAGE_NOTIFY_DATA_LOADED = 1;
    private static final int MESSAGE_PREPARE_VENDING_DATA = 1;
    private static final int SYNC_MESSAGE_APPLY_CHANGE = 1;
    private static final int SYNC_MESSAGE_CLEAR_RESOLVED_ONLY = 3;
    private static final int SYNC_MESSAGE_PREPARE_DATA_DEGRADE = 2;
    private static final String TAG = "Vending";
    private g<_Index, i<_Struct, _Index>> mArray = new g();
    private byte[] mArrayDataLock = new byte[0];
    private AtomicBoolean mCallDestroyed = new AtomicBoolean(false);
    private volatile com.tencent.mm.vending.b.c mDataChangedCallback = new com.tencent.mm.vending.b.c<d>(this, com.tencent.mm.vending.h.d.phX) {
        final /* synthetic */ Vending pgx;

        public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
            ((d) obj).aXY();
        }
    };
    private volatile com.tencent.mm.vending.b.c mDataResolvedCallback = new com.tencent.mm.vending.b.c<e>(this, com.tencent.mm.vending.h.d.phX) {
        final /* synthetic */ Vending pgx;

        public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
            ((e) obj).bm(aVar.get(0));
        }
    };
    private c<_Index> mDeadlock = new c();
    private boolean mFreezeDataChange = false;
    private boolean mHasPendingDataChange = false;
    private f mLoader = new f(this.mVendingLooper, new a<_Index>(this) {
        final /* synthetic */ Vending pgx;

        {
            this.pgx = r1;
        }

        public final void bn(_Index _Index) {
            i lock = this.pgx.getLock(_Index);
            boolean access$1100 = this.pgx.loadFromVending(lock, _Index);
            if (lock.pgj) {
                com.tencent.mm.vending.f.a.d(Vending.TAG, "This lock is defer to return %s %s", new Object[]{lock, _Index});
            } else if (!access$1100) {
                this.pgx.notifyDataLoadedIfNeed(lock);
            }
        }

        public final void cancel() {
            this.pgx.loaderClear();
            this.pgx.deadlock();
        }
    });
    private byte[] mPendingDataChangeLock = new byte[0];
    private boolean mResolveFromVending = false;
    private Handler mSubscriberHandler = new Handler(this, this.mSubscriberLooper) {
        final /* synthetic */ Vending pgx;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    i iVar = (i) message.obj;
                    this.pgx.onDataResolved(iVar.pgK, iVar.pgL);
                    return;
                default:
                    return;
            }
        }
    };
    private Looper mSubscriberLooper = Looper.getMainLooper();
    HashSet<h> mVendingDeferring = new HashSet();
    private Handler mVendingHandler = new Handler(this, this.mVendingLooper) {
        final /* synthetic */ Vending pgx;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.pgx.callPrepareVendingData();
                    return;
                case 2:
                    this.pgx.destroyAsynchronous();
                    return;
                default:
                    return;
            }
        }
    };
    private Looper mVendingLooper = com.tencent.mm.vending.i.b.bKT().pii.getLooper();
    private c mVendingSync = new c(this.mSubscriberLooper, this.mVendingLooper);

    private static final class a<T> {
        volatile T yt;

        private a() {
        }
    }

    private interface b {
        void bKB();
    }

    private static final class c<_Index> {
        a<_Index> pgy;
        i pgz;

        private c() {
            this.pgy = new a();
        }

        public final void reset() {
            this.pgy.yt = null;
            this.pgz = null;
        }
    }

    public interface d {
        void aXY();
    }

    public interface e<_Index> {
        void bm(_Index _Index);
    }

    public static final class f<_Index> {
        Handler mVendingHandler;
        HashMap<_Index, b> pgA = new HashMap();
        a<_Index> pgB = null;
        AtomicBoolean pgC = new AtomicBoolean(false);
        byte[] pgD = new byte[0];

        protected interface a<_Index> {
            void bn(_Index _Index);

            void cancel();
        }

        public enum b {
            NIL,
            PENDING,
            FILLED
        }

        protected f(Looper looper, a<_Index> aVar) {
            this.pgB = aVar;
            this.mVendingHandler = new Handler(this, looper) {
                final /* synthetic */ f pgE;

                public final void handleMessage(Message message) {
                    if (this.pgE.pgC.get()) {
                        this.pgE.pgB.cancel();
                        return;
                    }
                    Object obj = message.obj;
                    this.pgE.pgB.bn(obj);
                    synchronized (this.pgE.pgD) {
                        this.pgE.pgA.put(obj, b.FILLED);
                    }
                }
            };
        }

        protected final void bKE() {
            this.mVendingHandler.removeCallbacksAndMessages(null);
            com.tencent.mm.vending.f.a.i("Vending.Loader", "clear()", new Object[0]);
            synchronized (this.pgD) {
                this.pgA.clear();
            }
            this.pgB.cancel();
        }
    }

    static class g<K, V> extends HashMap<K, V> {
        b pgJ = new b(this) {
            final /* synthetic */ Vending pgx;

            {
                this.pgx = r1;
            }

            public final void bKB() {
                com.tencent.mm.vending.f.a.i(Vending.TAG, "SafeSparseArray fusing.", new Object[0]);
                this.pgx.deadlock();
            }
        };

        g() {
        }

        public final void clear() {
            super.clear();
            if (this.pgJ != null) {
                this.pgJ.bKB();
            }
        }
    }

    public class h {
        private _Index pgK;
        final /* synthetic */ Vending pgx;

        h(Vending vending, _Index _Index) {
            this.pgx = vending;
            this.pgK = _Index;
        }
    }

    static final class i<_Struct, _Index> {
        byte[] ciN = new byte[0];
        boolean jb = false;
        _Index pgK;
        _Struct pgL;
        boolean pgM = false;
        boolean pgN = false;
        boolean pgO = false;
        boolean pgj = false;

        i() {
        }
    }

    public abstract void applyChangeSynchronized(_Change _Change);

    public abstract void destroyAsynchronous();

    public abstract _Change prepareVendingDataAsynchronous();

    public abstract _Struct resolveAsynchronous(_Index _Index);

    f<_Index> getLoader() {
        return this.mLoader;
    }

    public void addVendingDataChangedCallback(d dVar) {
        this.mDataChangedCallback.ay(dVar);
    }

    public void addVendingDataResolvedCallback(e eVar) {
        this.mDataResolvedCallback.ay(eVar);
    }

    private void notifyDataLoadedIfNeed(i<_Struct, _Index> iVar) {
        if (iVar.pgO) {
            iVar.pgO = false;
        } else {
            this.mSubscriberHandler.sendMessage(this.mSubscriberHandler.obtainMessage(1, iVar));
        }
    }

    protected void synchronizing(int i, Object obj) {
    }

    protected i<_Struct, _Index> getLock(_Index _Index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_Index);
            if (iVar == null) {
                iVar = new i();
                this.mArray.put(_Index, iVar);
            }
        }
        return iVar;
    }

    protected i<_Struct, _Index> peekLock(_Index _Index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = (i) this.mArray.get(_Index);
        }
        return iVar;
    }

    public h defer(_Index _Index) {
        looperCheckForVending();
        if (this.mResolveFromVending) {
            getLock(_Index).pgj = true;
            h hVar = new h(this, _Index);
            this.mVendingDeferring.add(hVar);
            return hVar;
        }
        com.tencent.mm.vending.f.a.w(TAG, "Please call defer in resolveAsynchronous()", new Object[0]);
        return null;
    }

    private void deferResolved(h hVar, _Index _Index, _Struct _Struct) {
        if (this.mVendingDeferring.contains(hVar)) {
            i lock = getLock(_Index);
            synchronized (lock.ciN) {
                lock.pgj = false;
                lockResolved(lock, _Index, _Struct);
            }
            notifyDataLoadedIfNeed(lock);
        }
    }

    public <T> T peek(_Index _Index) {
        if (this.mCallDestroyed.get() || invalidIndex(_Index)) {
            return null;
        }
        i peekLock = peekLock(_Index);
        if (peekLock == null || peekLock.jb) {
            return null;
        }
        return peekLock.pgL;
    }

    public <T> T get(_Index _Index) {
        return getSync(_Index);
    }

    private _Struct getSync(_Index _Index) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        } else if (this.mCallDestroyed.get()) {
            return null;
        } else {
            i lock = getLock(_Index);
            if (invalidIndex(_Index)) {
                return lock.pgL;
            }
            if (myLooper == this.mSubscriberLooper) {
                return forSubscriberSync(lock, _Index).pgL;
            }
            loadFromVending(lock, _Index);
            return lock.pgL;
        }
    }

    private void lockResolved(i<_Struct, _Index> iVar, _Index _Index, _Struct _Struct) {
        iVar.pgL = _Struct;
        iVar.pgK = _Index;
        iVar.jb = false;
        iVar.pgM = false;
        iVar.pgN = true;
        if (this.mDeadlock.pgz == iVar) {
            iVar.pgO = true;
        }
        iVar.ciN.notify();
    }

    private boolean loadFromVending(i<_Struct, _Index> iVar, _Index _Index) {
        synchronized (iVar.ciN) {
            if (!iVar.pgN || iVar.jb || iVar.pgM) {
                this.mResolveFromVending = true;
                Object resolveAsynchronous = resolveAsynchronous(_Index);
                this.mResolveFromVending = false;
                if (iVar.pgj) {
                    return false;
                }
                lockResolved(iVar, _Index, resolveAsynchronous);
                return false;
            }
            return true;
        }
    }

    private i<_Struct, _Index> forSubscriberSync(i<_Struct, _Index> iVar, _Index _Index) {
        if (com.tencent.mm.vending.i.b.bKT().pii.isAlive()) {
            synchronized (iVar.ciN) {
                boolean requestIndex = requestIndex(iVar, _Index);
                if (!iVar.pgN || iVar.jb) {
                    if (requestIndex) {
                        this.mDeadlock.pgy.yt = _Index;
                        this.mDeadlock.pgz = iVar;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting %s", new Object[]{this, _Index});
                        long nanoTime = System.nanoTime();
                        try {
                            iVar.ciN.wait();
                        } catch (InterruptedException e) {
                        }
                        nanoTime = System.nanoTime() - nanoTime;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting duration %s", new Object[]{this, Long.valueOf(nanoTime)});
                        this.mDeadlock.reset();
                    }
                }
            }
        } else {
            com.tencent.mm.vending.f.a.e(TAG, "Vending thread is not running!", new Object[0]);
        }
        return iVar;
    }

    protected boolean invalidIndex(_Index _Index) {
        return false;
    }

    private _Struct getAsync(_Index _Index) {
        if (invalidIndex(_Index)) {
            return null;
        }
        i lock = getLock(_Index);
        if (!requestIndex(lock, _Index) || lock.jb) {
            return null;
        }
        return lock.pgL;
    }

    public void request(_Index _Index) {
        refillImpl(_Index, false);
    }

    public void requestConsistent(_Index _Index) {
        refillImpl(_Index, true);
    }

    private void refillImpl(_Index _Index, boolean z) {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            i lock = getLock(_Index);
            synchronized (lock.ciN) {
                if (lock.pgN) {
                    if (z) {
                        lock.jb = true;
                    } else {
                        lock.pgM = true;
                    }
                }
            }
            getAsync(_Index);
        }
    }

    public void resolvedClear() {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            this.mVendingSync.h(3, null);
        }
    }

    public void notifyVendingDataChange() {
        notifyVendingDataChange(false);
    }

    public void notifyVendingDataChangeSynchronize() {
        notifyVendingDataChange(true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifyVendingDataChange(boolean r4) {
        /*
        r3 = this;
        r2 = 1;
        r0 = r3.mCallDestroyed;
        r0 = r0.get();
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = android.os.Looper.myLooper();
        r1 = r3.mSubscriberLooper;
        if (r0 == r1) goto L_0x0023;
    L_0x0012:
        r0 = android.os.Looper.myLooper();
        r1 = r3.mVendingLooper;
        if (r0 == r1) goto L_0x0023;
    L_0x001a:
        r0 = new java.lang.IllegalAccessError;
        r1 = "Call from wrong thread";
        r0.<init>(r1);
        throw r0;
    L_0x0023:
        if (r4 == 0) goto L_0x002d;
    L_0x0025:
        r0 = r3.mVendingSync;
        r1 = 2;
        r2 = 0;
        r0.h(r1, r2);
        goto L_0x0009;
    L_0x002d:
        r1 = r3.mPendingDataChangeLock;
        monitor-enter(r1);
        r0 = r3.mFreezeDataChange;	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x003c;
    L_0x0034:
        r0 = 1;
        r3.mHasPendingDataChange = r0;	 Catch:{ all -> 0x0039 }
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0009;
    L_0x0039:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
    L_0x003c:
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        r0 = android.os.Looper.myLooper();
        r1 = r3.mVendingLooper;
        if (r0 != r1) goto L_0x0049;
    L_0x0045:
        r3.callPrepareVendingData();
        goto L_0x0009;
    L_0x0049:
        r0 = r3.mVendingHandler;
        r0.removeMessages(r2);
        r0 = r3.mVendingHandler;
        r1 = r3.mVendingHandler;
        r1 = r1.obtainMessage(r2);
        r0.sendMessage(r1);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.base.Vending.notifyVendingDataChange(boolean):void");
    }

    public void freezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = true;
            }
        }
    }

    public void unfreezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = false;
                if (this.mHasPendingDataChange) {
                    notifyVendingDataChange();
                    this.mHasPendingDataChange = false;
                }
            }
        }
    }

    protected void loaderClear() {
    }

    private void deadlock() {
        if (this.mDeadlock.pgy.yt != null) {
            com.tencent.mm.vending.f.a.e(TAG, "Catch deadlock! Tell Carl! .. " + this.mDeadlock.pgy.yt, new Object[0]);
            if (this.mDeadlock.pgz != null) {
                synchronized (this.mDeadlock.pgz.ciN) {
                    this.mDeadlock.pgz.ciN.notify();
                }
                this.mDeadlock.reset();
            }
        }
    }

    protected void requestIndexImpl(i<_Struct, _Index> iVar, _Index _Index) {
    }

    private boolean requestIndex(i<_Struct, _Index> iVar, _Index _Index) {
        if (invalidIndex(_Index)) {
            return false;
        }
        if (this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.e(TAG, "Vending.destroyed() has called.", new Object[0]);
            return false;
        }
        f fVar = this.mLoader;
        if (!fVar.pgC.get()) {
            synchronized (fVar.pgD) {
                fVar.pgA.put(_Index, b.PENDING);
            }
            fVar.mVendingHandler.sendMessageAtFrontOfQueue(fVar.mVendingHandler.obtainMessage(0, _Index));
        }
        requestIndexImpl(iVar, _Index);
        return true;
    }

    private void callPrepareVendingData() {
        if (!this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.i(TAG, "Vending.callPrepareVendingData()", new Object[0]);
            this.mVendingSync.h(1, prepareVendingDataAsynchronous());
        }
    }

    public Looper getLooper() {
        return this.mVendingLooper;
    }

    public final void dead() {
        looperCheckBoth();
        com.tencent.mm.vending.f.a.i(TAG, "Vending.destroy()", new Object[0]);
        this.mCallDestroyed.set(true);
        this.mVendingHandler.removeCallbacksAndMessages(null);
        this.mSubscriberHandler.removeCallbacksAndMessages(null);
        this.mLoader.pgC.set(true);
        this.mLoader.bKE();
        this.mVendingHandler.sendMessage(this.mVendingHandler.obtainMessage(2));
    }

    private void onDataResolved(_Index _Index, _Struct _Struct) {
        if (!this.mCallDestroyed.get() && this.mDataResolvedCallback != null) {
            this.mDataResolvedCallback.a(com.tencent.mm.vending.g.g.bs(_Index));
        }
    }

    public void looperCheckForVending() {
        if (Looper.myLooper() != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckForSubscriber() {
        if (Looper.myLooper() != this.mSubscriberLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    protected void looperCheckBoth() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }
}
