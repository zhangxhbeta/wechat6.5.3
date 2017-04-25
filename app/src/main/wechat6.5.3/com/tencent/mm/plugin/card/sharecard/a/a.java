package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a implements e {
    public byte[] cGJ = new byte[0];
    public List<n> eAO = af.aat().aah();
    public List<n> eAP = new ArrayList();
    private List<WeakReference<d>> eAR = new ArrayList();
    public com.tencent.mm.plugin.card.sharecard.model.e eEk;
    private int eEl = 0;
    public int eEm = 5;
    private Runnable lv = new Runnable(this) {
        final /* synthetic */ a eEn;

        {
            this.eEn = r1;
        }

        public final void run() {
            v.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
            ak.vy().a(new h(), 0);
        }
    };
    public ac mHandler = new ac(Looper.getMainLooper());

    public a() {
        v.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", new Object[]{Integer.valueOf(this.eAO.size())});
        ak.vy().a(903, this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ZI() {
        /*
        r5 = this;
        r4 = 10;
        r2 = 0;
        r0 = new java.util.LinkedList;
        r0.<init>();
        r1 = r5.cGJ;
        monitor-enter(r1);
        r3 = r5.eAO;	 Catch:{ all -> 0x0032 }
        r3 = r3.size();	 Catch:{ all -> 0x0032 }
        if (r3 != 0) goto L_0x001e;
    L_0x0013:
        r0 = "MicroMsg.ShareCardBatchGetCardMgr";
        r2 = "scsmgr getNow, no pending cardinfo ,no need to get";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ all -> 0x0032 }
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
    L_0x001d:
        return;
    L_0x001e:
        r3 = r5.eAO;	 Catch:{ all -> 0x0032 }
        r0.addAll(r3);	 Catch:{ all -> 0x0032 }
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
        r1 = r5.eEk;
        if (r1 == 0) goto L_0x0035;
    L_0x0028:
        r0 = "MicroMsg.ShareCardBatchGetCardMgr";
        r1 = "scsmgr getNow, already doing scene, not trigger now";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x001d;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r3 = new java.util.LinkedList;
        r3.<init>();
        r1 = r0.size();
        if (r1 > r4) goto L_0x005e;
    L_0x0040:
        r3.addAll(r0);
    L_0x0043:
        r4 = new java.util.LinkedList;
        r4.<init>();
        r1 = r2;
    L_0x0049:
        r0 = r3.size();
        if (r1 >= r0) goto L_0x0066;
    L_0x004f:
        r0 = r3.get(r1);
        r0 = (com.tencent.mm.plugin.card.sharecard.model.n) r0;
        r0 = r0.field_card_id;
        r4.add(r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0049;
    L_0x005e:
        r0 = r0.subList(r2, r4);
        r3.addAll(r0);
        goto L_0x0043;
    L_0x0066:
        r0 = new com.tencent.mm.plugin.card.sharecard.model.e;
        r0.<init>(r4);
        r5.eEk = r0;
        r0 = com.tencent.mm.model.ak.vy();
        r1 = r5.eEk;
        r0.a(r1, r2);
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.a.a.ZI():void");
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.eEk = null;
        List<n> z;
        o aat;
        if (i == 0 && i2 == 0) {
            z = z(((com.tencent.mm.plugin.card.sharecard.model.e) kVar).eDt);
            v.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[]{Integer.valueOf(z.size())});
            synchronized (this.cGJ) {
                this.eAO.removeAll(z);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            long er = c.wE().er(Thread.currentThread().getId());
            aat = af.aat();
            if (z.size() == 0) {
                v.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
            } else {
                for (n nVar : z) {
                    if (nVar != null) {
                        aat.c(nVar, new String[0]);
                    }
                }
            }
            ak.yW();
            c.wE().es(er);
            v.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            ZI();
            Yj();
            return;
        }
        v.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        z = z(((com.tencent.mm.plugin.card.sharecard.model.e) kVar).eDs);
        synchronized (this.cGJ) {
            if (z.size() > 0) {
                this.eAO.removeAll(z);
                this.eAP.addAll(z);
            }
        }
        aat = af.aat();
        if (z.size() == 0) {
            v.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
            return;
        }
        for (n nVar2 : z) {
            if (nVar2 != null) {
                nVar2.field_retryCount++;
                aat.a(nVar2, new String[0]);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<com.tencent.mm.plugin.card.sharecard.model.n> z(java.util.LinkedList<java.lang.String> r8) {
        /*
        r7 = this;
        r3 = 0;
        r5 = new java.util.ArrayList;
        r5.<init>();
        r6 = new java.util.LinkedList;
        r6.<init>();
        r1 = r7.cGJ;
        monitor-enter(r1);
        r0 = r7.eAO;	 Catch:{ all -> 0x005d }
        r0 = r0.size();	 Catch:{ all -> 0x005d }
        if (r0 != 0) goto L_0x0022;
    L_0x0016:
        r0 = "MicroMsg.ShareCardBatchGetCardMgr";
        r2 = "getSuccessShareCardSyncItem pendingList size is 0";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        r0 = r5;
    L_0x0021:
        return r0;
    L_0x0022:
        r0 = r7.eAO;	 Catch:{ all -> 0x005d }
        r6.addAll(r0);	 Catch:{ all -> 0x005d }
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        r2 = r3;
    L_0x0029:
        r0 = r8.size();
        if (r2 >= r0) goto L_0x0064;
    L_0x002f:
        r0 = r8.get(r2);
        r0 = (java.lang.String) r0;
        r4 = r3;
    L_0x0036:
        r1 = r6.size();
        if (r4 >= r1) goto L_0x0060;
    L_0x003c:
        if (r0 == 0) goto L_0x0059;
    L_0x003e:
        r1 = r6.get(r4);
        if (r1 == 0) goto L_0x0059;
    L_0x0044:
        r1 = r6.get(r4);
        r1 = (com.tencent.mm.plugin.card.sharecard.model.n) r1;
        r1 = r1.field_card_id;
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0059;
    L_0x0052:
        r1 = r6.get(r4);
        r5.add(r1);
    L_0x0059:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x0036;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        throw r0;
    L_0x0060:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0029;
    L_0x0064:
        r0 = r5;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.a.a.z(java.util.LinkedList):java.util.ArrayList<com.tencent.mm.plugin.card.sharecard.model.n>");
    }

    public final void aay() {
        int i;
        v.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i2 = currentTimeMillis - this.eEl;
        if (this.eEm <= 0) {
            i = 5;
        } else {
            i = this.eEm;
        }
        if (i2 >= i) {
            ak.vy().a(new h(), 0);
        } else {
            v.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is " + i2);
            this.mHandler.removeCallbacks(this.lv);
            this.mHandler.postDelayed(this.lv, (long) (i * BaseReportManager.MAX_READ_COUNT));
        }
        this.eEl = currentTimeMillis;
    }

    public final void Yj() {
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    d dVar = (d) weakReference.get();
                    if (dVar != null) {
                        dVar.ZG();
                    }
                }
            }
        }
    }

    public final void a(d dVar) {
        if (this.eAR == null) {
            this.eAR = new ArrayList();
        }
        if (dVar != null) {
            this.eAR.add(new WeakReference(dVar));
        }
    }

    public final void b(d dVar) {
        if (this.eAR != null && dVar != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    d dVar2 = (d) weakReference.get();
                    if (dVar2 != null && dVar2.equals(dVar)) {
                        this.eAR.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }
}
