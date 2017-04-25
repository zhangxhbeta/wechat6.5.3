package com.tencent.mm.sdk.c;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a {
    public static a nhr = new a();
    private final HashMap<Integer, LinkedList<c>> nhs = new HashMap();
    private final HashMap<Integer, a> nht = new HashMap();

    private class a extends com.tencent.mm.vending.b.a<c> {
        final /* synthetic */ a nhv;

        private a(a aVar) {
            this.nhv = aVar;
        }

        public final void a(com.tencent.mm.vending.j.a aVar) {
            LinkedList bKF = bKF();
            b bVar = (b) aVar.get(0);
            if (bVar.nhx) {
                Collections.sort(bKF, new Comparator<b>(this) {
                    final /* synthetic */ a nhw;

                    {
                        this.nhw = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((c) ((b) obj2).pgX).priority - ((c) ((b) obj).pgX).priority;
                    }
                });
            }
            b[] bVarArr = new b[bKF.size()];
            bKF.toArray(bVarArr);
            int length = bVarArr.length;
            int i = 0;
            while (i < length && (!((c) bVarArr[i].pgX).a(bVar) || !bVar.nhx)) {
                i++;
            }
            if (bVar.bpT != null) {
                bVar.bpT.run();
            }
        }
    }

    private a() {
    }

    public final b<c> d(c cVar) {
        b<c> a;
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            v.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.bsK()));
            com.tencent.mm.vending.b.a aVar = (a) this.nht.get(Integer.valueOf(cVar.bsK()));
            if (aVar == null) {
                HashMap hashMap = this.nht;
                Integer valueOf = Integer.valueOf(cVar.bsK());
                aVar = new a();
                hashMap.put(valueOf, aVar);
            }
            a = aVar.a(new b(cVar, aVar));
        }
        return a;
    }

    @Deprecated
    public final boolean e(c cVar) {
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            v.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.bsK()));
            LinkedList linkedList = (LinkedList) this.nhs.get(Integer.valueOf(cVar.bsK()));
            if (linkedList == null) {
                HashMap hashMap = this.nhs;
                Integer valueOf = Integer.valueOf(cVar.bsK());
                linkedList = new LinkedList();
                hashMap.put(valueOf, linkedList);
            }
            if (linkedList.contains(cVar)) {
                return true;
            }
            boolean add = linkedList.add(cVar);
            return add;
        }
    }

    @Deprecated
    public final boolean f(c cVar) {
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.remove", cVar);
            v.v("MicroMsg.EventCenter", "removeListener %s(%d)", cVar, Integer.valueOf(cVar.bsK()));
            LinkedList linkedList = (LinkedList) this.nhs.get(Integer.valueOf(cVar.bsK()));
            if (linkedList == null) {
                return false;
            }
            boolean remove = linkedList.remove(cVar);
            return remove;
        }
    }

    public final boolean z(b bVar) {
        boolean z = false;
        boolean z2 = true;
        Assert.assertNotNull("EventPoolImpl.publish", bVar);
        v.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.bsK()));
        LinkedList linkedList = null;
        synchronized (this) {
            int bsK = bVar.bsK();
            LinkedList linkedList2 = (LinkedList) this.nhs.get(Integer.valueOf(bsK));
            if (linkedList2 != null) {
                linkedList = new LinkedList(linkedList2);
                z = true;
            }
            a aVar = (a) this.nht.get(Integer.valueOf(bsK));
            if (aVar == null) {
                z2 = z;
            }
            if (!z2) {
                v.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", bVar, Integer.valueOf(bsK), SQLiteDatabase.KeyEmpty);
            }
        }
        if (linkedList != null) {
            a(linkedList, bVar);
        }
        if (aVar != null) {
            aVar.a(g.bs(bVar));
        }
        return z2;
    }

    public final void a(final b bVar, Looper looper) {
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", bVar);
        Assert.assertNotNull("EventPoolImpl.asyncPublish looper", looper);
        v.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.bsK()));
        new ac(looper).post(new Runnable(this) {
            final /* synthetic */ a nhv;

            public final void run() {
                a.nhr.z(bVar);
            }
        });
    }

    public final synchronized boolean m(Class<? extends b> cls) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hasListener", cls);
        LinkedList linkedList = (LinkedList) this.nhs.get(Integer.valueOf(cls.getName().hashCode()));
        if (linkedList == null || linkedList.size() <= 0) {
            a aVar = (a) this.nht.get(Integer.valueOf(cls.getName().hashCode()));
            if (aVar == null || aVar.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized boolean g(c cVar) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hadListened", cVar);
        LinkedList linkedList = (LinkedList) this.nhs.get(Integer.valueOf(cVar.bsK()));
        if (linkedList == null || linkedList.isEmpty() || !linkedList.contains(cVar)) {
            a aVar = (a) this.nht.get(Integer.valueOf(cVar.bsK()));
            if (aVar == null || aVar.size() <= 0 || !aVar.contains(cVar)) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    private void a(LinkedList<c> linkedList, b bVar) {
        if (bVar.nhx) {
            Collections.sort(linkedList, new Comparator<c>(this) {
                final /* synthetic */ a nhv;

                {
                    this.nhv = r1;
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj2).priority - ((c) obj).priority;
                }
            });
        }
        c[] cVarArr = new c[linkedList.size()];
        linkedList.toArray(cVarArr);
        int length = cVarArr.length;
        int i = 0;
        while (i < length && (!cVarArr[i].a(bVar) || !bVar.nhx)) {
            i++;
        }
        if (bVar.bpT != null) {
            bVar.bpT.run();
        }
    }
}
