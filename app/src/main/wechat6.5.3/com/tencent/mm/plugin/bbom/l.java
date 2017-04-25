package com.tencent.mm.plugin.bbom;

import com.tencent.mm.model.ac;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.f.a.a.j;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ax.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class l implements j {
    private static List<ac> eod = new ArrayList();
    private boolean eoe = false;
    private boolean eof = false;
    private List<at> eog = new LinkedList();

    public static void a(ac acVar) {
        synchronized (eod) {
            if (!eod.contains(acVar)) {
                eod.add(acVar);
            }
        }
    }

    public static void b(ac acVar) {
        synchronized (eod) {
            eod.remove(acVar);
        }
    }

    public l(boolean z) {
        this.eoe = z;
        this.eof = false;
        this.eog = new LinkedList();
    }

    public final void Xd() {
        final List linkedList = new LinkedList();
        linkedList.addAll(this.eog);
        this.eog.clear();
        List<ac> arrayList = new ArrayList();
        synchronized (eod) {
            for (ac add : eod) {
                arrayList.add(add);
            }
        }
        for (final ac add2 : arrayList) {
            new com.tencent.mm.sdk.platformtools.ac(add2.getLooper()).post(new Runnable(this) {
                final /* synthetic */ l eoj;

                public final void run() {
                    add2.q(linkedList);
                }
            });
        }
    }

    public final void a(final at atVar, final bm bmVar) {
        if (!this.eoe) {
            v.i("MicroMsg.SyncMessageNotifier", "notifyNewMsg is false, do nothing and return.");
        } else if (eod.isEmpty()) {
            v.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
        } else if (atVar.field_isSend != 0 || atVar.field_status == 4) {
            v.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        } else {
            String a = m.a(bmVar.mbU);
            ak.yW();
            ax Nr = c.wN().Nr(new a(a).Nq(SQLiteDatabase.KeyEmpty));
            if (Nr != null && !Nr.bxf()) {
                v.d("MicroMsg.SyncMessageNotifier", "account no notification");
            } else if (this.eof) {
                this.eog.add(atVar);
            } else {
                this.eof = true;
                List<ac> arrayList = new ArrayList();
                synchronized (eod) {
                    for (ac add : eod) {
                        arrayList.add(add);
                    }
                }
                for (final ac add2 : arrayList) {
                    new com.tencent.mm.sdk.platformtools.ac(add2.getLooper()).post(new Runnable(this) {
                        final /* synthetic */ l eoj;

                        public final void run() {
                            if (bmVar.gll == 49) {
                                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(com.tencent.mm.pluginsdk.model.app.j.d(bmVar));
                                if (dV.cpy != 1 || be.kS(dV.cpz) || be.kS(dV.cpA)) {
                                    add2.a(atVar);
                                    return;
                                } else {
                                    add2.a(39, dV.cpA, SQLiteDatabase.KeyEmpty, dV.cpz, null, null);
                                    return;
                                }
                            }
                            add2.a(atVar);
                        }
                    });
                }
            }
        }
    }
}
