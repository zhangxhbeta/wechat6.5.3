package com.tencent.mm.performance.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.performance.d.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends com.tencent.mm.performance.d.a {
    public static String TYPE = "MemoryLeakController";
    public HashSet<c> dnD;
    private long dnH = -1;
    public HashMap<WeakReference<Object>, Integer> dnI;
    public HashSet<a> dnJ;
    long dnK = 0;
    public boolean dnL = true;
    private ac dnM = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ b dnN;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    v.d("MicroMsg.WxPerformace", "gc==" + Thread.currentThread().getName());
                    com.tencent.mm.bh.a.bym();
                    this.dnN.dnH = System.currentTimeMillis();
                    return;
                default:
                    return;
            }
        }
    };

    private class a {
        final /* synthetic */ b dnN;
        public d<Object> dnO;
        public WeakReference<Object> dnP;
        public long dnQ;
        public long dnR;

        private a(b bVar) {
            this.dnN = bVar;
            this.dnQ = 0;
            this.dnR = 0;
        }
    }

    public interface c {
        void a(d<Object> dVar, boolean z);
    }

    private class b extends com.tencent.mm.performance.a.a.a {
        final /* synthetic */ b dnN;

        private b(b bVar) {
            this.dnN = bVar;
        }

        public final void p(Activity activity) {
            super.p(activity);
            b bVar = this.dnN;
            WeakReference weakReference = new WeakReference(new Object());
            d dVar = new d(activity.toString(), activity);
            synchronized (bVar) {
                a aVar = new a();
                aVar.dnO = dVar;
                aVar.dnP = weakReference;
                aVar.dnQ = System.currentTimeMillis();
                aVar.dnR = bVar.dnK;
                bVar.dnJ.add(aVar);
            }
        }

        public final void b(Activity activity, Bundle bundle) {
            super.b(activity, bundle);
            this.dnN.dnK = 1 + this.dnN.dnK;
            if (this.dnN.dnK < 0) {
                this.dnN.dnK = 0;
            }
        }
    }

    private void a(d<Object> dVar) {
        Object obj = dVar.get();
        if (obj != null) {
            boolean z = obj instanceof Activity;
            synchronized (this.dnD) {
                Iterator it = this.dnD.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(dVar, z);
                }
            }
        }
    }

    public final String MK() {
        return TYPE;
    }

    public final void ML() {
        if (this.dnJ != null && !this.dnJ.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                ArrayList arrayList;
                Iterator it;
                if (!this.dnI.isEmpty()) {
                    arrayList = null;
                    for (WeakReference weakReference : this.dnI.keySet()) {
                        if (weakReference.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(weakReference);
                        }
                        arrayList = arrayList;
                    }
                    if (arrayList != null) {
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.dnI.remove((WeakReference) it.next());
                        }
                    }
                }
                Iterator it2 = this.dnJ.iterator();
                ArrayList arrayList2 = null;
                Object obj = null;
                Object obj2 = null;
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    long j = aVar.dnR;
                    if (aVar.dnP.get() != null) {
                        obj2 = 1;
                    } else if (aVar.dnO.get() == null) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    } else {
                        Object obj3;
                        if (this.dnK - j <= 8 || currentTimeMillis - aVar.dnQ < 180000) {
                            obj3 = obj;
                        } else if (this.dnI.containsKey(aVar.dnO)) {
                            int intValue = ((Integer) this.dnI.get(aVar.dnO)).intValue();
                            if (intValue >= 3) {
                                a(aVar.dnO);
                                v.d("MicroMsg.WxPerformace", "memoryleak activity ===" + aVar.dnO.get());
                                if (arrayList2 == null) {
                                    arrayList = new ArrayList();
                                } else {
                                    arrayList = arrayList2;
                                }
                                arrayList.add(aVar);
                                arrayList2 = arrayList;
                            } else {
                                obj = 1;
                                this.dnI.put(aVar.dnO, Integer.valueOf(intValue + 1));
                            }
                        } else if (aVar.dnQ < this.dnH - 5000) {
                            this.dnI.put(aVar.dnO, Integer.valueOf(1));
                        } else {
                            obj3 = 1;
                        }
                        obj = obj3;
                    }
                }
                if (arrayList2 != null) {
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                        this.dnJ.remove((a) it.next());
                    }
                }
                if (this.dnL) {
                    if (obj != null) {
                        this.dnM.sendEmptyMessage(1);
                    } else if (obj2 != null && currentTimeMillis - this.dnH > 30000) {
                        this.dnM.sendEmptyMessage(1);
                    }
                }
            }
        }
    }
}
