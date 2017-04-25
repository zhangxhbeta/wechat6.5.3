package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class h implements e {
    private static Map<Long, a> aVs = new HashMap();
    private static Map<Long, Integer> fMA = new HashMap();
    private static Set<Long> fMO = new HashSet();
    public ah aVA = new ah(ak.vA().htb.getLooper(), new ah.a(this) {
        final /* synthetic */ h fMP;

        {
            this.fMP = r1;
        }

        public final boolean oU() {
            try {
                h.d(this.fMP);
            } catch (Throwable e) {
                v.a("MicroMsg.SendFavService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private Queue<i> aVq = new LinkedList();
    public boolean aVu = false;
    private boolean aVv = false;
    public int aVw = 0;
    private long aVx = 0;
    private int dgH = 0;

    static /* synthetic */ boolean d(h hVar) {
        i iVar;
        hVar.aVx = System.currentTimeMillis();
        if (!hVar.aVu && hVar.aVq.size() == 0) {
            j alu = com.tencent.mm.plugin.favorite.h.alu();
            Cursor rawQuery = alu.cie.rawQuery("select " + j.fKI + " from FavItemInfo where (itemStatus" + "=9 or itemStatus" + "=12)", null);
            List list;
            if (rawQuery == null) {
                list = null;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                list = null;
            } else {
                list = new LinkedList();
                while (rawQuery.moveToNext()) {
                    i iVar2 = new i();
                    iVar2.b(rawQuery);
                    list.add(iVar2);
                }
                rawQuery.close();
            }
            if (!(r0 == null || r0.size() == 0)) {
                for (i iVar3 : r0) {
                    if (fMO.contains(Long.valueOf(iVar3.field_localId))) {
                        v.d("MicroMsg.SendFavService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", new Object[]{Integer.valueOf(iVar3.field_id), Long.valueOf(iVar3.field_localId), Integer.valueOf(iVar3.field_sourceType), iVar3.field_sourceId});
                    } else if (aVs.containsKey(Long.valueOf(iVar3.field_localId))) {
                        v.d("MicroMsg.SendFavService", "File is Already running:" + iVar3.field_localId);
                    } else {
                        if (!fMA.containsKey(Long.valueOf(iVar3.field_localId))) {
                            fMA.put(Long.valueOf(iVar3.field_localId), Integer.valueOf(3));
                        }
                        hVar.aVq.add(iVar3);
                        aVs.put(Long.valueOf(iVar3.field_localId), null);
                    }
                }
                v.d("MicroMsg.SendFavService", "klem GetNeedRun procing:" + aVs.size() + ",send:" + hVar.aVq.size() + "]");
                hVar.aVq.size();
            }
        }
        if (!hVar.aVu && hVar.aVq.size() <= 0) {
            hVar.pu();
            v.d("MicroMsg.SendFavService", "klem No Data Any More , Stop Service");
        } else if (!hVar.aVu && hVar.aVq.size() > 0) {
            iVar3 = (i) hVar.aVq.poll();
            if (iVar3 != null && iVar3.field_localId > 0) {
                hVar.aVu = true;
                ak.vy().a(new x(iVar3), 0);
                return true;
            }
        }
        return false;
    }

    public h() {
        ak.vy().a(401, this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ h fMP;

            public final void run() {
                if (kVar.getType() == 401 && (kVar instanceof x)) {
                    this.fMP.aVu = false;
                    i iVar = ((x) kVar).fLI;
                    long j = iVar.field_localId;
                    h.aVs.remove(Long.valueOf(j));
                    if ((i == 0 && i2 == 0) || i2 == -400) {
                        h.fMO.add(Long.valueOf(j));
                    }
                    if (!(i == 0 || i2 == -400)) {
                        this.fMP.aVw = this.fMP.aVw - 1;
                    }
                    Integer valueOf = Integer.valueOf(be.a((Integer) h.fMA.get(Long.valueOf(j)), 0));
                    if (!(i == 1 || i == 0)) {
                        valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        h.fMA.put(Long.valueOf(iVar.field_localId), valueOf);
                    }
                    if (valueOf.intValue() <= 0) {
                        int bD = com.tencent.mm.plugin.favorite.b.v.bD(i, i2);
                        g.iuh.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(iVar.field_type), Integer.valueOf(bD), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.k(iVar)), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.bG(iVar.field_localId))});
                        h.fMA.remove(Long.valueOf(j));
                        v.e("MicroMsg.SendFavService", "achieved retry limit, set error, localId:%d", new Object[]{Long.valueOf(j)});
                        if (iVar.field_itemStatus == 12) {
                            com.tencent.mm.plugin.favorite.h.alu().r(14, iVar.field_localId);
                        }
                        if (iVar.field_itemStatus == 9) {
                            com.tencent.mm.plugin.favorite.h.alu().r(11, iVar.field_localId);
                        }
                    }
                    if (this.fMP.aVw <= 0) {
                        v.d("MicroMsg.SendFavService", "klem stopFlag <= 0 , Stop Service");
                        this.fMP.pu();
                    } else if (!h.d(this.fMP)) {
                        com.tencent.mm.plugin.favorite.b.v.startSync();
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ h fMP;

            {
                this.fMP = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.fMP.aVx;
                if (this.fMP.aVv) {
                    if (currentTimeMillis >= 60000) {
                        v.e("MicroMsg.SendFavService", "klem ERR: Try Run service runningFlag:" + this.fMP.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.fMP.aVv);
                    } else {
                        return;
                    }
                }
                this.fMP.aVu = false;
                this.fMP.aVv = true;
                this.fMP.aVw = 3;
                this.fMP.aVA.ea(10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void pu() {
        v.i("MicroMsg.SendFavService", "on finish");
        this.aVq.clear();
        aVs.clear();
        this.aVv = false;
        this.aVu = false;
        fMA.clear();
    }
}
