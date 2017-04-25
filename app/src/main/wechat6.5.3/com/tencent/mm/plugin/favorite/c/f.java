package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.ad;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.w;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements e {
    private static Map<Integer, a> aVs = new HashMap();
    private static Map<Integer, Integer> fMA = new HashMap();
    public ah aVA = new ah(ak.vA().htb.getLooper(), new ah.a(this) {
        final /* synthetic */ f fMB;

        {
            this.fMB = r1;
        }

        public final boolean oU() {
            try {
                f.d(this.fMB);
            } catch (Throwable e) {
                v.a("MicroMsg.FavModService", e, "", new Object[0]);
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
    public int aVw = 0;
    private long aVx = 0;

    static /* synthetic */ boolean d(f fVar) {
        i iVar;
        fVar.aVx = System.currentTimeMillis();
        if (!fVar.aVu && fVar.aVq.size() == 0) {
            j alu = h.alu();
            Cursor rawQuery = alu.cie.rawQuery("select " + j.fKI + " from FavItemInfo where itemStatus" + "=17", null);
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
                    if (aVs.containsKey(Integer.valueOf(iVar3.field_id))) {
                        v.d("MicroMsg.FavModService", "File is Already running:" + iVar3.field_id);
                    } else {
                        if (!fMA.containsKey(Integer.valueOf(iVar3.field_id))) {
                            fMA.put(Integer.valueOf(iVar3.field_id), Integer.valueOf(3));
                        }
                        fVar.aVq.add(iVar3);
                        aVs.put(Integer.valueOf(iVar3.field_id), null);
                    }
                }
                v.d("MicroMsg.FavModService", "klem GetNeedRun procing:" + aVs.size() + ",send:" + fVar.aVq.size() + "]");
                fVar.aVq.size();
            }
        }
        if (!fVar.aVu && fVar.aVq.size() <= 0) {
            fVar.pu();
            v.d("MicroMsg.FavModService", "klem No Data Any More , Stop Service");
        } else if (!fVar.aVu && fVar.aVq.size() > 0) {
            iVar3 = (i) fVar.aVq.poll();
            if (iVar3 != null && iVar3.field_id > 0) {
                fVar.aVu = true;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (iVar3.field_type != 18) {
                    w.a(iVar3.field_localId, linkedList, linkedList2);
                    ak.vy().a(new ad(iVar3.field_id, linkedList, linkedList2), 0);
                } else {
                    aix com_tencent_mm_protocal_c_aix = new aix();
                    com_tencent_mm_protocal_c_aix.mJs = 1;
                    com_tencent_mm_protocal_c_aix.mJt = (int) be.Nh();
                    linkedList.add(com_tencent_mm_protocal_c_aix);
                    ak.vy().a(new ad(iVar3.field_id, linkedList, linkedList2, i.b(iVar3)), 0);
                }
                return true;
            }
        }
        return false;
    }

    public f() {
        ak.vy().a(426, this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        if (kVar.getType() == 426 && (kVar instanceof ad)) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ f fMB;

                public final void run() {
                    this.fMB.aVu = false;
                    int i = ((ad) kVar).fMa;
                    f.aVs.remove(Integer.valueOf(i));
                    if (!(i2 == 3 && i2 == 0)) {
                        this.fMB.aVw = this.fMB.aVw - 1;
                    }
                    i bC = h.alu().bC((long) i);
                    if (bC != null && bC.field_itemStatus != 10) {
                        if (i != 0 || i2 != 0) {
                            Integer valueOf = Integer.valueOf(be.a((Integer) f.fMA.get(Integer.valueOf(i)), 0));
                            if (!(i == 1 || i == 0)) {
                                valueOf = Integer.valueOf(valueOf.intValue() - 1);
                            }
                            if (valueOf.intValue() <= 0) {
                                int bD = com.tencent.mm.plugin.favorite.b.v.bD(i, i2);
                                g.iuh.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(bC.field_type), Integer.valueOf(bD), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.k(bC)), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.bG(bC.field_localId))});
                                f.fMA.remove(Integer.valueOf(i));
                                v.e("MicroMsg.FavModService", "achieved retry limit, set error, favId:%d", new Object[]{Integer.valueOf(i)});
                                bC.field_itemStatus = 18;
                                h.alu().a(bC, "localId");
                            }
                        } else if (bC.field_itemStatus == 17) {
                            g.iuh.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(bC.field_type), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.k(bC)), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.bG(bC.field_localId))});
                            v.v("MicroMsg.FavModService", "mod end set status done. favId:%d", new Object[]{Integer.valueOf(bC.field_id)});
                            bC.field_itemStatus = 10;
                            h.alu().a(bC, "localId");
                            h.alp().bz(bC.field_localId);
                        }
                        if (this.fMB.aVw <= 0) {
                            v.d("MicroMsg.FavModService", "klem stopFlag <= 0 , Stop Service");
                            this.fMB.pu();
                        } else if (!f.d(this.fMB)) {
                            com.tencent.mm.plugin.favorite.b.v.startSync();
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|onSceneEnd";
                }
            });
        }
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ f fMB;

            {
                this.fMB = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.fMB.aVx;
                if (this.fMB.aVv) {
                    if (currentTimeMillis >= 60000) {
                        v.e("MicroMsg.FavModService", "klem ERR: Try Run service runningFlag:" + this.fMB.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.fMB.aVv);
                    } else {
                        return;
                    }
                }
                this.fMB.aVu = false;
                this.fMB.aVv = true;
                this.fMB.aVw = 3;
                this.fMB.aVA.ea(10);
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
        fMA.clear();
    }
}
