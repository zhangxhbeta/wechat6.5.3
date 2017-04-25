package com.tencent.mm.plugin.card.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements e {
    public byte[] cGJ = new byte[0];
    public List<ad> eAO = af.aal().aah();
    public List<ad> eAP = new ArrayList();
    private o eAQ;
    public List<WeakReference<d>> eAR = new ArrayList();

    public b() {
        v.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[]{Integer.valueOf(this.eAO.size())});
        ak.vy().a(559, this);
    }

    public final void detach() {
        this.eAO.clear();
        this.eAP.clear();
        if (this.eAQ != null) {
            ak.vy().c(this.eAQ);
        }
        ak.vy().b(559, this);
    }

    public final void ZI() {
        if (this.eAO.size() == 0) {
            v.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
        } else if (this.eAQ != null) {
            v.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
        } else {
            LinkedList linkedList = new LinkedList();
            if (this.eAO.size() <= 10) {
                linkedList.addAll(this.eAO);
            } else {
                linkedList.addAll(this.eAO.subList(0, 10));
            }
            this.eAQ = new o(linkedList);
            ak.vy().a(this.eAQ, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        v.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.eAQ = null;
        List<ad> list = ((o) kVar).eDt;
        ae aal;
        if (i == 0 && i2 == 0) {
            String str2 = "MicroMsg.BatchGetCardMgr";
            String str3 = "onSceneEnd, batch get succ, remove succ id list, size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            v.i(str2, str3, objArr);
            if (list != null) {
                synchronized (this.cGJ) {
                    this.eAO.removeAll(list);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            long er = c.wE().er(Thread.currentThread().getId());
            aal = af.aal();
            if (list == null || list.size() == 0) {
                v.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
            } else {
                for (ad adVar : list) {
                    if (adVar != null) {
                        aal.c(adVar, new String[0]);
                    }
                }
            }
            ak.yW();
            c.wE().es(er);
            v.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            ZI();
            if (this.eAR != null) {
                while (i3 < this.eAR.size()) {
                    WeakReference weakReference = (WeakReference) this.eAR.get(i3);
                    if (weakReference != null) {
                        d dVar = (d) weakReference.get();
                        if (dVar != null) {
                            dVar.ZG();
                        }
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        v.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        synchronized (this.cGJ) {
            if (list != null) {
                if (list.size() > 0) {
                    this.eAO.removeAll(list);
                    this.eAP.addAll(list);
                }
            }
        }
        aal = af.aal();
        if (list == null || list.size() == 0) {
            v.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            return;
        }
        for (ad adVar2 : list) {
            if (adVar2 != null) {
                adVar2.field_retryCount++;
                aal.a(adVar2, new String[0]);
            }
        }
    }

    public static void iS(int i) {
        ak.vy().a(new s(i), 0);
    }
}
