package com.tencent.mm.v;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class n implements e {
    private static int cAj = 1;
    private static n czZ = null;
    public e cAa;
    private Vector<k> cAb = new Vector();
    private Vector<k> cAc = new Vector();
    private final Map<Integer, Set<e>> cAd = new HashMap();
    private Boolean cAe = null;
    private final a cAf;
    private long cAg = 21600000;
    private boolean cAh = false;
    private ah cAi = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ n cAk;

        {
            this.cAk = r1;
        }

        public final boolean oU() {
            boolean z = false;
            if (this.cAk.cAf == null) {
                return false;
            }
            v.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(this.cAk.cAb.size()), Integer.valueOf(this.cAk.cAc.size()), Boolean.valueOf(this.cAk.foreground));
            a b = this.cAk.cAf;
            n nVar = this.cAk;
            if (this.cAk.cAh && this.cAk.cAb.isEmpty() && this.cAk.cAc.isEmpty()) {
                z = true;
            }
            b.a(nVar, z);
            return true;
        }
    }, true);
    public ad ckz = null;
    public boolean foreground = false;
    private final ac handler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ n cAk;

        public final void handleMessage(Message message) {
            this.cAk.a((k) message.obj, 0);
        }
    };
    private final Object lock = new Object();

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ n cAk;
        final /* synthetic */ int cAl;

        public AnonymousClass4(n nVar, int i) {
            this.cAk = nVar;
            this.cAl = i;
        }

        public final void run() {
            n.b(this.cAk, this.cAl);
        }

        public final String toString() {
            return super.toString() + "|cancelImp_" + this.cAl;
        }
    }

    public interface a {
        void a(n nVar);

        void a(n nVar, boolean z);
    }

    static /* synthetic */ void a(n nVar, int i) {
        synchronized (nVar.lock) {
            Iterator it = nVar.cAb.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    nVar.c(kVar);
                    return;
                }
            }
            it = nVar.cAc.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    nVar.c(kVar);
                    return;
                }
            }
        }
    }

    static /* synthetic */ void b(n nVar, int i) {
        synchronized (nVar.lock) {
            Iterator it = nVar.cAb.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (!(kVar == null || kVar.hashCode() != i || kVar == null)) {
                    v.j("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                    kVar.cancel();
                    it.remove();
                }
            }
            it = nVar.cAc.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (!(kVar == null || kVar.hashCode() != i || kVar == null)) {
                    v.j("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                    kVar.cancel();
                    it.remove();
                }
            }
        }
    }

    public final void aQ(boolean z) {
        this.cAh = z;
        if (this.cAh) {
            v.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
            this.cAi.ea(this.cAg);
            return;
        }
        this.cAi.QI();
    }

    public final void a(int i, String str, int i2, boolean z) {
        if (this.cAa == null) {
            v.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
        } else {
            this.cAa.a(i, str, i2, z);
        }
    }

    public final void aR(boolean z) {
        this.foreground = z;
        this.cAe = Boolean.valueOf(z);
        b.aR(z);
        if (this.cAa == null) {
            v.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
        } else {
            this.cAa.aT(z);
        }
    }

    public final int BJ() {
        try {
            if (this.cAa != null && this.cAa.BV() != null) {
                return this.cAa.BV().Mb();
            }
            v.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
            if (ak.isConnected(aa.getContext())) {
                return 6;
            }
            return 0;
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneQueue", "exception:%s", be.e(e));
        }
    }

    public final boolean BK() {
        if (this.cAa != null) {
            return this.cAa.BK();
        }
        return true;
    }

    public final String getNetworkServerIp() {
        if (this.cAa != null) {
            return this.cAa.getNetworkServerIp();
        }
        return "unknown";
    }

    private n(a aVar) {
        this.cAf = aVar;
    }

    public final void d(e eVar) {
        this.cAa = eVar;
        eVar.aT(this.foreground);
        BN();
    }

    public static n a(a aVar) {
        if (czZ == null) {
            czZ = new n(aVar);
        }
        return czZ;
    }

    public final void a(int i, e eVar) {
        synchronized (this.cAd) {
            if (!this.cAd.containsKey(Integer.valueOf(i))) {
                this.cAd.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) this.cAd.get(Integer.valueOf(i))).contains(eVar)) {
                ((Set) this.cAd.get(Integer.valueOf(i))).add(eVar);
            }
        }
    }

    public final void b(int i, e eVar) {
        synchronized (this.cAd) {
            try {
                if (this.cAd.get(Integer.valueOf(i)) != null) {
                    ((Set) this.cAd.get(Integer.valueOf(i))).remove(eVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void reset() {
        if (this.cAa != null) {
            this.cAa.reset();
        }
        BL();
        List<k> list = this.cAc;
        this.cAc = new Vector();
        for (k kVar : list) {
            v.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            b(3, -1, "doScene failed clearWaitingQueue", kVar);
        }
        list.clear();
    }

    public final void BL() {
        List<k> list = this.cAb;
        this.cAb = new Vector();
        for (k kVar : list) {
            v.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            b(3, -1, "doScene failed clearRunningQueue", kVar);
        }
        list.clear();
    }

    public final void BM() {
        v.i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.cAa != null) {
            this.cAa.reset();
            this.cAa = null;
        }
    }

    public final e uX() {
        return this.cAa;
    }

    public final void cancel(final int i) {
        v.j("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i));
        this.ckz.x(new Runnable(this) {
            final /* synthetic */ n cAk;

            public final void run() {
                n.a(this.cAk, i);
            }

            public final String toString() {
                return super.toString() + "|cancelImp_" + i;
            }
        });
    }

    public final void c(k kVar) {
        if (kVar != null) {
            v.j("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
            kVar.cancel();
            synchronized (this.lock) {
                this.cAc.remove(kVar);
                this.cAb.remove(kVar);
            }
        }
    }

    public final boolean d(k kVar) {
        return a(kVar, 0);
    }

    public final boolean a(k kVar, int i) {
        boolean z = kVar != null || i >= 0;
        Assert.assertTrue(z);
        String str = "worker thread has not been set";
        if (this.ckz != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        if (!e(kVar)) {
            return false;
        }
        b(kVar, i);
        return true;
    }

    private void b(final k kVar, int i) {
        boolean BO = BO();
        int size = this.cAb.size();
        String str = "MicroMsg.NetSceneQueue";
        String str2 = "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.BE());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.cAc.size());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(BO);
        objArr[7] = Integer.valueOf(this.cAa == null ? 0 : this.cAa.hashCode());
        v.i(str, str2, objArr);
        if (i == 0 && BO && this.cAa != null) {
            synchronized (this.lock) {
                this.cAb.add(kVar);
                if (size == this.cAb.size()) {
                    v.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(kVar.getType()), Integer.valueOf(kVar.hashCode()), Integer.valueOf(size), Integer.valueOf(this.cAb.size()), Integer.valueOf(this.cAc.size()));
                }
            }
            this.ckz.x(new Runnable(this) {
                final /* synthetic */ n cAk;

                public final void run() {
                    int a;
                    String str;
                    String str2;
                    Object[] objArr;
                    int i = 0;
                    kVar.czJ = this.cAk;
                    if (this.cAk.cAa != null) {
                        a = kVar.a(this.cAk.cAa, this.cAk);
                        if (a >= 0) {
                            str = "MicroMsg.NetSceneQueue";
                            str2 = "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                            objArr = new Object[7];
                            objArr[0] = Integer.valueOf(kVar.getType());
                            objArr[1] = Integer.valueOf(kVar.hashCode());
                            objArr[2] = Integer.valueOf(kVar.BE());
                            objArr[3] = Integer.valueOf(this.cAk.cAb.size());
                            objArr[4] = Integer.valueOf(this.cAk.cAc.size());
                            objArr[5] = Integer.valueOf(a);
                            objArr[6] = Integer.valueOf(this.cAk.cAa == null ? 0 : this.cAk.cAa.hashCode());
                            v.i(str, str2, objArr);
                            kVar.czK = false;
                            return;
                        }
                    }
                    a = 0;
                    str = "MicroMsg.NetSceneQueue";
                    str2 = "doscene mmcgi Failed type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(kVar.getType());
                    objArr[1] = Integer.valueOf(kVar.hashCode());
                    objArr[2] = Integer.valueOf(kVar.BE());
                    objArr[3] = Integer.valueOf(this.cAk.cAb.size());
                    objArr[4] = Integer.valueOf(this.cAk.cAc.size());
                    objArr[5] = Integer.valueOf(a);
                    if (this.cAk.cAa != null) {
                        i = this.cAk.cAa.hashCode();
                    }
                    objArr[6] = Integer.valueOf(i);
                    v.w(str, str2, objArr);
                    kVar.czJ = null;
                    synchronized (this.cAk.lock) {
                        this.cAk.cAb.remove(kVar);
                    }
                    this.cAk.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 cAm;

                        {
                            this.cAm = r1;
                        }

                        public final void run() {
                            this.cAm.cAk.a(3, -1, "doScene failed", kVar);
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|doSceneImp_" + kVar + "_type=" + kVar.getType();
                }
            });
        } else if (i > 0) {
            Message obtain = Message.obtain();
            obtain.obj = kVar;
            this.handler.sendMessageDelayed(obtain, (long) i);
            v.i("MicroMsg.NetSceneQueue", "timed: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_after_sec=" + i);
        } else {
            v.i("MicroMsg.NetSceneQueue", "waited: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.cAc.size());
            synchronized (this.lock) {
                this.cAc.add(kVar);
            }
            v.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.cAc.size());
        }
        if (this.cAa == null) {
            if (this.cAf != null) {
                g.vx();
                if (!g.vu().cjo) {
                    this.cAf.a(this);
                    new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                        final /* synthetic */ n cAk;
                        private long cAo = 10;

                        {
                            this.cAk = r3;
                        }

                        public final boolean oU() {
                            if (this.cAk.cAa == null) {
                                long j = this.cAo;
                                this.cAo = j - 1;
                                if (j > 0) {
                                    return true;
                                }
                            }
                            this.cAk.BN();
                            return false;
                        }
                    }, true).ea((long) (cAj * 100));
                    if (cAj < 512) {
                        cAj *= 2;
                        return;
                    }
                    return;
                }
            }
            Object[] objArr2 = new Object[2];
            objArr2[0] = this.cAf;
            g.vx();
            objArr2[1] = Boolean.valueOf(g.vu().cjo);
            v.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s, acc accInitializing:[%b]", objArr2);
            return;
        }
        cAj = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        kVar.czK = true;
        synchronized (this.lock) {
            this.cAb.remove(kVar);
        }
        String str2 = "MicroMsg.NetSceneQueue";
        String str3 = "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.BE());
        objArr[3] = Integer.valueOf(this.cAb.size());
        objArr[4] = Integer.valueOf(this.cAc.size());
        if (this.cAa != null) {
            i3 = this.cAa.hashCode();
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(i);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = str;
        v.i(str2, str3, objArr);
        BN();
        b(i, i2, str, kVar);
        if (this.cAh && this.cAb.isEmpty() && this.cAc.isEmpty()) {
            this.cAi.ea(this.cAg);
        }
    }

    private void b(int i, int i2, String str, k kVar) {
        final k kVar2 = kVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ n cAk;

            public final void run() {
                Set set = (Set) this.cAk.cAd.get(Integer.valueOf(kVar2.getType()));
                if (set != null && set.size() > 0) {
                    Set<e> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i3, i4, str2, kVar2);
                        }
                    }
                }
                set = (Set) this.cAk.cAd.get(Integer.valueOf(-1));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar2 : hashSet) {
                        if (eVar2 != null && set.contains(eVar2)) {
                            eVar2.a(i3, i4, str2, kVar2);
                        }
                    }
                }
            }
        });
    }

    private void BN() {
        synchronized (this.lock) {
            if (this.cAc.size() > 0) {
                k kVar = (k) this.cAc.get(0);
                int i = 1;
                int i2 = kVar.priority;
                k kVar2 = kVar;
                while (i < this.cAc.size()) {
                    k kVar3;
                    int i3;
                    if (((k) this.cAc.get(i)).priority > i2) {
                        this.cAc.get(i);
                        if (BO()) {
                            kVar = (k) this.cAc.get(i);
                            kVar3 = kVar;
                            i3 = kVar.priority;
                            i++;
                            kVar2 = kVar3;
                            i2 = i3;
                        }
                    }
                    i3 = i2;
                    kVar3 = kVar2;
                    i++;
                    kVar2 = kVar3;
                    i2 = i3;
                }
                this.cAc.remove(kVar2);
                v.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.cAc.size());
                b(kVar2, 0);
            }
        }
    }

    private boolean BO() {
        if (this.cAb.size() >= 50) {
            return false;
        }
        return true;
    }

    private boolean e(k kVar) {
        int type = kVar.getType();
        if (kVar.Bz()) {
            synchronized (this.lock) {
                k kVar2;
                Iterator it = this.cAb.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        v.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.cAb.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            v.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.cAb.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                v.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + "acinfo[" + kVar2.getInfo() + "] scinfo[" + kVar.getInfo() + "]");
                                v.bta();
                                Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                it = this.cAc.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        v.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.cAc.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            v.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.cAc.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                v.bta();
                                Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
