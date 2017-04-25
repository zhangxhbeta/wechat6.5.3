package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b implements e {
    private static Map<Long, a> aVs = new HashMap();
    public ah aVA = new ah(ak.vA().htb.getLooper(), new ah.a(this) {
        final /* synthetic */ b fMn;

        {
            this.fMn = r1;
        }

        public final boolean oU() {
            try {
                b.b(this.fMn);
            } catch (Throwable e) {
                v.a("MicroMsg.CheckFavCdnService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private Queue<i> aVq = new LinkedList();
    private boolean aVu = false;
    private boolean aVv = false;
    private long aVx = 0;
    public m cEZ = new m.a(this) {
        final /* synthetic */ b fMn;

        {
            this.fMn = r1;
        }

        public final void cI(int i) {
            List list = null;
            try {
                boolean isWifi = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());
                if (i == 4 || i == 6) {
                    v.i("MicroMsg.CheckFavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(this.fMn.fMm)});
                    if (!this.fMn.fMm && isWifi) {
                        b bVar = this.fMn;
                        j alu = h.alu();
                        Cursor rawQuery = alu.cie.rawQuery("select " + j.fKI + " from FavItemInfo where itemStatus" + "=3", null);
                        if (rawQuery != null) {
                            if (rawQuery.getCount() == 0) {
                                rawQuery.close();
                            } else {
                                list = new LinkedList();
                                while (rawQuery.moveToNext()) {
                                    i iVar = new i();
                                    iVar.b(rawQuery);
                                    list.add(iVar);
                                }
                                rawQuery.close();
                            }
                        }
                        if (list != null && list.size() > 0) {
                            v.i("MicroMsg.CheckFavCdnService", "startAll list.size:%d", new Object[]{Integer.valueOf(list.size())});
                            for (i iVar2 : list) {
                                if (iVar2.field_itemStatus == 3) {
                                    iVar2.field_itemStatus = 1;
                                    h.alu().a(iVar2, "localId");
                                }
                            }
                            bVar.run();
                        }
                    }
                    this.fMn.fMm = isWifi;
                    return;
                }
                this.fMn.fMm = isWifi;
            } catch (Throwable e) {
                v.a("MicroMsg.CheckFavCdnService", e, "", new Object[0]);
            }
        }
    };
    private boolean fMm = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());

    static /* synthetic */ void b(b bVar) {
        bVar.aVx = System.currentTimeMillis();
        if (!bVar.aVu && bVar.aVq.size() == 0) {
            j alu = h.alu();
            Cursor rawQuery = alu.cie.rawQuery("select " + j.fKI + " from FavItemInfo where itemStatus" + "=1", null);
            List list;
            if (rawQuery == null) {
                list = null;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                list = null;
            } else {
                list = new LinkedList();
                while (rawQuery.moveToNext()) {
                    i iVar = new i();
                    iVar.b(rawQuery);
                    list.add(iVar);
                }
                rawQuery.close();
            }
            if (!(r0 == null || r0.size() == 0)) {
                for (i iVar2 : r0) {
                    i iVar22;
                    if (aVs.containsKey(Long.valueOf(iVar22.field_localId))) {
                        v.d("MicroMsg.CheckFavCdnService", "File is Already running:" + iVar22.field_localId);
                    } else {
                        bVar.aVq.add(iVar22);
                        aVs.put(Long.valueOf(iVar22.field_localId), null);
                    }
                }
                v.d("MicroMsg.CheckFavCdnService", "klem GetNeedRun procing:" + aVs.size() + ",send:" + bVar.aVq.size() + "]");
                bVar.aVq.size();
            }
        }
        if (!bVar.aVu && bVar.aVq.size() <= 0) {
            bVar.pu();
            v.d("MicroMsg.CheckFavCdnService", "klem No Data Any More , Stop Service");
        } else if (!bVar.aVu && bVar.aVq.size() > 0) {
            iVar22 = (i) bVar.aVq.poll();
            if (iVar22 != null && iVar22.field_localId > 0) {
                bVar.aVu = true;
                ak.vy().a(new com.tencent.mm.plugin.favorite.b.aa(iVar22), 0);
            }
        }
    }

    public b() {
        ak.a(this.cEZ);
        ak.vy().a(404, this);
    }

    public final void a(final int i, int i2, String str, final k kVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ b fMn;

            public final void run() {
                if (kVar.getType() == 404 && (kVar instanceof com.tencent.mm.plugin.favorite.b.aa)) {
                    this.fMn.aVu = false;
                    long j = ((com.tencent.mm.plugin.favorite.b.aa) kVar).fLP.field_localId;
                    i iVar = ((com.tencent.mm.plugin.favorite.b.aa) kVar).fLP;
                    b.aVs.remove(Long.valueOf(j));
                    if (i != 0) {
                        v.e("MicroMsg.CheckFavCdnService", "achieved retry limit, set error, localId:%d", new Object[]{Long.valueOf(j)});
                        g.iuh.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(iVar.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.k(iVar)), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.bG(iVar.field_localId))});
                        h.alu().r(3, j);
                    }
                    b.b(this.fMn);
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ b fMn;

            {
                this.fMn = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.fMn.aVx;
                if (this.fMn.aVv) {
                    if (currentTimeMillis >= 60000) {
                        v.e("MicroMsg.CheckFavCdnService", "klem ERR: Try Run service runningFlag:" + this.fMn.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.fMn.aVv);
                    } else {
                        return;
                    }
                }
                this.fMn.aVu = false;
                this.fMn.aVv = true;
                this.fMn.aVA.ea(10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void pu() {
        this.aVq.clear();
        aVs.clear();
        this.aVv = false;
        this.aVu = false;
    }
}
