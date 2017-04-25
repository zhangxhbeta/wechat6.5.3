package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class m implements p {
    private final com.google.android.gms.common.b akQ;
    private final com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> akR;
    private final Set<com.google.android.gms.common.api.a.c> alA = new HashSet();
    com.google.android.gms.signin.d alB;
    private int alC;
    boolean alD;
    boolean alE;
    p alF;
    boolean alG;
    boolean alH;
    private final com.google.android.gms.common.internal.h alI;
    private final Map<a<?>, Integer> alJ;
    private ArrayList<Future<?>> alK = new ArrayList();
    final o alr;
    final Lock alt;
    private ConnectionResult alu;
    private int alv;
    private int alw = 0;
    private boolean alx = false;
    private int aly;
    private final Bundle alz = new Bundle();
    final Context mContext;

    private abstract class i implements Runnable {
        final /* synthetic */ m alL;

        private i(m mVar) {
            this.alL = mVar;
        }

        protected abstract void js();

        public void run() {
            this.alL.alt.lock();
            try {
                if (!Thread.interrupted()) {
                    js();
                    this.alL.alt.unlock();
                }
            } catch (RuntimeException e) {
                o oVar = this.alL.alr;
                oVar.amf.sendMessage(oVar.amf.obtainMessage(4, e));
            } finally {
                this.alL.alt.unlock();
            }
        }
    }

    private class c extends i {
        final /* synthetic */ m alL;

        private c(m mVar) {
            this.alL = mVar;
            super();
        }

        public final void js() {
            this.alL.alB.a(this.alL.alF, this.alL.alr.amj, new a(this.alL));
        }
    }

    private static class d implements com.google.android.gms.common.api.c.e {
        private final WeakReference<m> alM;
        private final a<?> alS;
        final int alT;

        public d(m mVar, a<?> aVar, int i) {
            this.alM = new WeakReference(mVar);
            this.alS = aVar;
            this.alT = i;
        }

        public final void b(ConnectionResult connectionResult) {
            boolean z = false;
            m mVar = (m) this.alM.get();
            if (mVar != null) {
                if (Looper.myLooper() == mVar.alr.akP) {
                    z = true;
                }
                w.a(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                mVar.alt.lock();
                try {
                    if (mVar.bI(0)) {
                        if (!connectionResult.iY()) {
                            mVar.b(connectionResult, this.alS, this.alT);
                        }
                        if (mVar.jt()) {
                            mVar.ju();
                        }
                        mVar.alt.unlock();
                    }
                } finally {
                    mVar.alt.unlock();
                }
            }
        }

        public final void c(ConnectionResult connectionResult) {
            boolean z = true;
            m mVar = (m) this.alM.get();
            if (mVar != null) {
                if (Looper.myLooper() != mVar.alr.akP) {
                    z = false;
                }
                w.a(z, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                mVar.alt.lock();
                try {
                    if (mVar.bI(1)) {
                        if (!connectionResult.iY()) {
                            mVar.b(connectionResult, this.alS, this.alT);
                        }
                        if (mVar.jt()) {
                            mVar.jv();
                        }
                        mVar.alt.unlock();
                    }
                } finally {
                    mVar.alt.unlock();
                }
            }
        }
    }

    private class e extends i {
        final /* synthetic */ m alL;
        private final Map<com.google.android.gms.common.api.a.b, d> alU;

        public e(m mVar, Map<com.google.android.gms.common.api.a.b, d> map) {
            this.alL = mVar;
            super();
            this.alU = map;
        }

        public final void js() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (com.google.android.gms.common.api.a.b bVar : this.alU.keySet()) {
                if (!bVar.je()) {
                    i = 0;
                    i4 = i5;
                } else if (((d) this.alU.get(bVar)).alT == 0) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = com.google.android.gms.common.b.v(this.alL.mContext);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.alL.alD) {
                    this.alL.alB.connect();
                }
                for (com.google.android.gms.common.api.a.b bVar2 : this.alU.keySet()) {
                    final com.google.android.gms.common.api.c.e eVar = (com.google.android.gms.common.api.c.e) this.alU.get(bVar2);
                    if (!bVar2.je() || i3 == 0) {
                        bVar2.a(eVar);
                    } else {
                        this.alL.alr.a(new b(this, this.alL) {
                            final /* synthetic */ e alW;

                            public final void js() {
                                eVar.b(new ConnectionResult(16, null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i3, null);
            this.alL.alr.a(new b(this, this.alL) {
                final /* synthetic */ e alW;

                public final void js() {
                    this.alW.alL.e(connectionResult);
                }
            });
        }
    }

    private class f extends i {
        final /* synthetic */ m alL;
        private final ArrayList<com.google.android.gms.common.api.a.b> alY;

        public f(m mVar, ArrayList<com.google.android.gms.common.api.a.b> arrayList) {
            this.alL = mVar;
            super();
            this.alY = arrayList;
        }

        public final void js() {
            Set set = this.alL.alr.amj;
            Set jA = set.isEmpty() ? this.alL.jA() : set;
            Iterator it = this.alY.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.a.b) it.next()).a(this.alL.alF, jA);
            }
        }
    }

    private class g implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c {
        final /* synthetic */ m alL;

        private g(m mVar) {
            this.alL = mVar;
        }

        public final void a(ConnectionResult connectionResult) {
            this.alL.alt.lock();
            try {
                if (this.alL.d(connectionResult)) {
                    this.alL.jy();
                    this.alL.jw();
                } else {
                    this.alL.e(connectionResult);
                }
                this.alL.alt.unlock();
            } catch (Throwable th) {
                this.alL.alt.unlock();
            }
        }

        public final void bH(int i) {
        }

        public final void g(Bundle bundle) {
            this.alL.alB.a(new b(this.alL));
        }
    }

    private class h extends i {
        final /* synthetic */ m alL;
        private final ArrayList<com.google.android.gms.common.api.a.b> alY;

        public h(m mVar, ArrayList<com.google.android.gms.common.api.a.b> arrayList) {
            this.alL = mVar;
            super();
            this.alY = arrayList;
        }

        public final void js() {
            Iterator it = this.alY.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.a.b) it.next()).a(this.alL.alF);
            }
        }
    }

    private static class b extends com.google.android.gms.common.internal.t.a {
        private final WeakReference<m> alM;

        b(m mVar) {
            this.alM = new WeakReference(mVar);
        }

        public final void a(final ResolveAccountResponse resolveAccountResponse) {
            final m mVar = (m) this.alM.get();
            if (mVar != null) {
                mVar.alr.a(new b(this, mVar) {
                    final /* synthetic */ b alR;

                    public final void js() {
                        m mVar = mVar;
                        ResolveAccountResponse resolveAccountResponse = resolveAccountResponse;
                        if (mVar.bI(0)) {
                            ConnectionResult connectionResult = resolveAccountResponse.amK;
                            if (connectionResult.iY()) {
                                mVar.alF = com.google.android.gms.common.internal.p.a.g(resolveAccountResponse.anF);
                                mVar.alE = true;
                                mVar.alG = resolveAccountResponse.alG;
                                mVar.alH = resolveAccountResponse.anU;
                                mVar.ju();
                            } else if (mVar.d(connectionResult)) {
                                mVar.jy();
                                mVar.ju();
                            } else {
                                mVar.e(connectionResult);
                            }
                        }
                    }
                });
            }
        }
    }

    private static class a extends com.google.android.gms.signin.internal.b {
        private final WeakReference<m> alM;

        a(m mVar) {
            this.alM = new WeakReference(mVar);
        }

        public final void a(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            final m mVar = (m) this.alM.get();
            if (mVar != null) {
                mVar.alr.a(new b(this, mVar) {
                    final /* synthetic */ a alP;

                    public final void js() {
                        m mVar = mVar;
                        ConnectionResult connectionResult = connectionResult;
                        if (!mVar.bI(2)) {
                            return;
                        }
                        if (connectionResult.iY()) {
                            mVar.jw();
                        } else if (mVar.d(connectionResult)) {
                            mVar.jy();
                            mVar.jw();
                        } else {
                            mVar.e(connectionResult);
                        }
                    }
                });
            }
        }
    }

    public m(o oVar, com.google.android.gms.common.internal.h hVar, Map<a<?>, Integer> map, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aVar, Lock lock, Context context) {
        this.alr = oVar;
        this.alI = hVar;
        this.alJ = map;
        this.akQ = bVar;
        this.akR = aVar;
        this.alt = lock;
        this.mContext = context;
    }

    private void Z(boolean z) {
        if (this.alB != null) {
            if (this.alB.isConnected() && z) {
                this.alB.lD();
            }
            this.alB.disconnect();
            this.alF = null;
        }
    }

    private static String bJ(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void jx() {
        boolean z = true;
        o oVar = this.alr;
        oVar.alt.lock();
        try {
            oVar.jC();
            oVar.amk = new l(oVar);
            oVar.amk.begin();
            oVar.alZ.signalAll();
            q.jD().execute(new Runnable(this) {
                final /* synthetic */ m alL;

                {
                    this.alL = r1;
                }

                public final void run() {
                    com.google.android.gms.common.b.w(this.alL.mContext);
                }
            });
            if (this.alB != null) {
                if (this.alG) {
                    this.alB.a(this.alF, this.alH);
                }
                Z(false);
            }
            for (com.google.android.gms.common.api.a.c cVar : this.alr.ami.keySet()) {
                ((com.google.android.gms.common.api.a.b) this.alr.amh.get(cVar)).disconnect();
            }
            if (this.alx) {
                this.alx = false;
                disconnect();
                return;
            }
            Bundle bundle = this.alz.isEmpty() ? null : this.alz;
            l lVar = this.alr.ama;
            w.a(Looper.myLooper() == lVar.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
            synchronized (lVar.aoG) {
                w.aa(!lVar.ape);
                lVar.mHandler.removeMessages(1);
                lVar.ape = true;
                if (lVar.apa.size() != 0) {
                    z = false;
                }
                w.aa(z);
                ArrayList arrayList = new ArrayList(lVar.aoZ);
                int i = lVar.apd.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.google.android.gms.common.api.c.b bVar = (com.google.android.gms.common.api.c.b) it.next();
                    if (lVar.apc && lVar.aoY.isConnected() && lVar.apd.get() == i) {
                        if (!lVar.apa.contains(bVar)) {
                            bVar.g(bundle);
                        }
                    }
                }
                lVar.apa.clear();
                lVar.ape = false;
            }
        } finally {
            oVar.alt.unlock();
        }
    }

    private void jz() {
        Iterator it = this.alK.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.alK.clear();
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t) {
        this.alr.amb.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
        if (bI(3)) {
            b(connectionResult, aVar, i);
            if (jt()) {
                jx();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void b(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.a<?> r6, int r7) {
        /*
        r4 = this;
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = 0;
        r0 = 1;
        r2 = 2;
        if (r7 == r2) goto L_0x0024;
    L_0x0008:
        r6.ja();
        if (r7 != r0) goto L_0x0016;
    L_0x000d:
        r2 = r5.iX();
        if (r2 == 0) goto L_0x0030;
    L_0x0013:
        r2 = r0;
    L_0x0014:
        if (r2 == 0) goto L_0x003c;
    L_0x0016:
        r2 = r4.alu;
        if (r2 == 0) goto L_0x001e;
    L_0x001a:
        r2 = r4.alv;
        if (r3 >= r2) goto L_0x003c;
    L_0x001e:
        if (r0 == 0) goto L_0x0024;
    L_0x0020:
        r4.alu = r5;
        r4.alv = r3;
    L_0x0024:
        r0 = r4.alr;
        r0 = r0.ami;
        r1 = r6.jb();
        r0.put(r1, r5);
        return;
    L_0x0030:
        r2 = r5.akn;
        r2 = com.google.android.gms.common.b.bD(r2);
        if (r2 == 0) goto L_0x003a;
    L_0x0038:
        r2 = r0;
        goto L_0x0014;
    L_0x003a:
        r2 = r1;
        goto L_0x0014;
    L_0x003c:
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.m.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.a, int):void");
    }

    public final void bH(int i) {
        e(new ConnectionResult(8, null));
    }

    final boolean bI(int i) {
        if (this.alw == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + bJ(this.alw) + " but received callback for step " + bJ(i));
        e(new ConnectionResult(8, null));
        return false;
    }

    public final void begin() {
        this.alr.ama.apc = true;
        this.alr.ami.clear();
        this.alx = false;
        this.alD = false;
        this.alu = null;
        this.alw = 0;
        this.alC = 2;
        this.alE = false;
        this.alG = false;
        Map hashMap = new HashMap();
        for (a aVar : this.alJ.keySet()) {
            com.google.android.gms.common.api.a.b bVar = (com.google.android.gms.common.api.a.b) this.alr.amh.get(aVar.jb());
            int intValue = ((Integer) this.alJ.get(aVar)).intValue();
            aVar.ja();
            if (bVar.jd()) {
                this.alD = true;
                if (intValue < this.alC) {
                    this.alC = intValue;
                }
                if (intValue != 0) {
                    this.alA.add(aVar.jb());
                }
            }
            hashMap.put(bVar, new d(this, aVar, intValue));
        }
        if (this.alD) {
            this.alI.aoB = Integer.valueOf(System.identityHashCode(this.alr));
            com.google.android.gms.common.api.c.b gVar = new g();
            this.alB = (com.google.android.gms.signin.d) this.akR.a(this.mContext, this.alr.akP, this.alI, this.alI.aoA, gVar, gVar);
        }
        this.aly = this.alr.amh.size();
        this.alK.add(q.jD().submit(new e(this, hashMap)));
    }

    public final void connect() {
        this.alx = false;
    }

    final boolean d(ConnectionResult connectionResult) {
        return this.alC != 2 ? this.alC == 1 && !connectionResult.iX() : true;
    }

    public final void disconnect() {
        Iterator it = this.alr.amb.iterator();
        while (it.hasNext()) {
            ((e) it.next()).cancel();
            it.remove();
        }
        this.alr.jB();
        if (this.alu != null || this.alr.amb.isEmpty()) {
            jz();
            Z(true);
            this.alr.ami.clear();
            this.alr.f(null);
            this.alr.ama.jX();
            return;
        }
        this.alx = true;
    }

    final void e(ConnectionResult connectionResult) {
        boolean z = false;
        this.alx = false;
        jz();
        Z(!connectionResult.iX());
        this.alr.ami.clear();
        this.alr.f(connectionResult);
        if (!this.alr.amc || !com.google.android.gms.common.b.k(this.mContext, connectionResult.akn)) {
            this.alr.jC();
            l lVar = this.alr.ama;
            if (Looper.myLooper() == lVar.mHandler.getLooper()) {
                z = true;
            }
            w.a(z, "onConnectionFailure must only be called on the Handler thread");
            lVar.mHandler.removeMessages(1);
            synchronized (lVar.aoG) {
                ArrayList arrayList = new ArrayList(lVar.apb);
                int i = lVar.apd.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.google.android.gms.common.api.c.c cVar = (com.google.android.gms.common.api.c.c) it.next();
                    if (!lVar.apc || lVar.apd.get() != i) {
                        break;
                    } else if (lVar.apb.contains(cVar)) {
                        cVar.a(connectionResult);
                    }
                }
            }
        }
        this.alr.ama.jX();
    }

    public final void g(Bundle bundle) {
        if (bI(3)) {
            if (bundle != null) {
                this.alz.putAll(bundle);
            }
            if (jt()) {
                jx();
            }
        }
    }

    public final String getName() {
        return "CONNECTING";
    }

    final Set<Scope> jA() {
        Set<Scope> hashSet = new HashSet(this.alI.akE);
        Map map = this.alI.aoz;
        for (a aVar : map.keySet()) {
            if (!this.alr.ami.containsKey(aVar.jb())) {
                hashSet.addAll(((com.google.android.gms.common.internal.h.a) map.get(aVar)).akY);
            }
        }
        return hashSet;
    }

    final boolean jt() {
        this.aly--;
        if (this.aly > 0) {
            return false;
        }
        if (this.aly < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            e(new ConnectionResult(8, null));
            return false;
        } else if (this.alu == null) {
            return true;
        } else {
            e(this.alu);
            return false;
        }
    }

    final void ju() {
        if (this.aly == 0) {
            if (!this.alD) {
                jw();
            } else if (this.alE) {
                ArrayList arrayList = new ArrayList();
                this.alw = 1;
                this.aly = this.alr.amh.size();
                for (com.google.android.gms.common.api.a.c cVar : this.alr.amh.keySet()) {
                    if (!this.alr.ami.containsKey(cVar)) {
                        arrayList.add(this.alr.amh.get(cVar));
                    } else if (jt()) {
                        jv();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.alK.add(q.jD().submit(new h(this, arrayList)));
                }
            }
        }
    }

    final void jv() {
        this.alw = 2;
        this.alr.amj = jA();
        this.alK.add(q.jD().submit(new c()));
    }

    final void jw() {
        ArrayList arrayList = new ArrayList();
        this.alw = 3;
        this.aly = this.alr.amh.size();
        for (com.google.android.gms.common.api.a.c cVar : this.alr.amh.keySet()) {
            if (!this.alr.ami.containsKey(cVar)) {
                arrayList.add(this.alr.amh.get(cVar));
            } else if (jt()) {
                jx();
            }
        }
        if (!arrayList.isEmpty()) {
            this.alK.add(q.jD().submit(new f(this, arrayList)));
        }
    }

    final void jy() {
        this.alD = false;
        this.alr.amj = Collections.emptySet();
        for (com.google.android.gms.common.api.a.c cVar : this.alA) {
            if (!this.alr.ami.containsKey(cVar)) {
                this.alr.ami.put(cVar, new ConnectionResult(17, null));
            }
        }
    }
}
