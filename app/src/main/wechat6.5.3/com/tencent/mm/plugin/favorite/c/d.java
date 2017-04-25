package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.ad;
import com.tencent.mm.plugin.favorite.b.f;
import com.tencent.mm.plugin.favorite.b.g;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public Map<String, a> fMx = new HashMap();

    private static class a {
        int fMa;
        f fMb;
        int retryCount;
        long time;

        private a() {
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        aVar.retryCount--;
        if (aVar.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - aVar.time < 7200000) {
                v.d("MicroMsg.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", new Object[]{Integer.valueOf(aVar.fMa), Long.valueOf(aVar.fMb.field_localId), Integer.valueOf(aVar.fMb.field_type)});
                return;
            }
            aVar.time = SystemClock.elapsedRealtime();
            aVar.retryCount = 3;
        }
        if (aVar.fMa <= 0) {
            i bB = h.alu().bB(aVar.fMb.field_localId);
            if (bB == null || bB.field_id <= 0) {
                v.w("MicroMsg.FavEditService", "want to start mod item, but favid is invalid, local id %d", new Object[]{Long.valueOf(aVar.fMb.field_localId)});
                return;
            }
            aVar.fMa = bB.field_id;
            v.d("MicroMsg.FavEditService", "want mod item, find id %d by local id %d", new Object[]{Integer.valueOf(aVar.fMa), Long.valueOf(aVar.fMb.field_localId)});
        } else if (!z) {
            v.w("MicroMsg.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", new Object[]{Integer.valueOf(aVar.fMa)});
            return;
        }
        v.d("MicroMsg.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(aVar.fMa), Integer.valueOf(aVar.fMb.field_type)});
        ak.vy().a(new ad(aVar.fMa, aVar.fMb), 0);
    }

    public d() {
        ak.vy().a(426, this);
        ak.vy().a(401, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar != null) {
            v.i("MicroMsg.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 401) {
                v.d("MicroMsg.FavEditService", "on add fav item scene end, try mod item");
                run();
                return;
            }
            ad adVar = (ad) kVar;
            if (adVar.type == 0) {
                return;
            }
            long amj;
            int amk;
            if (i == 0 && i2 == 0) {
                v.d("MicroMsg.FavEditService", "clear job, key %s", new Object[]{n(adVar.amj(), adVar.amk())});
                this.fMx.remove(r0);
                g alq = h.alq();
                amj = adVar.amj();
                amk = adVar.amk();
                alq.cie.delete("FavEditInfo", "localId=? and type=?", new String[]{String.valueOf(amj), String.valueOf(amk)});
                i bB = h.alu().bB(adVar.amj());
                if (bB != null) {
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(bB.field_id);
                    objArr[1] = Integer.valueOf(bB.field_tagProto.mub.size());
                    objArr[2] = Integer.valueOf(h.aln().alJ());
                    objArr[3] = Integer.valueOf(adVar.fMb == null ? 1 : adVar.fMb.field_scene);
                    gVar.h(11122, objArr);
                    return;
                }
                return;
            }
            v.d("MicroMsg.FavEditService", "retry job, key %s", new Object[]{n(adVar.amj(), adVar.amk())});
            final a aVar = (a) this.fMx.get(r0);
            if (aVar == null) {
                v.w("MicroMsg.FavEditService", "want to retry mod item, localid %d, type %d", new Object[]{Long.valueOf(amj), Integer.valueOf(amk)});
            } else {
                ak.vA().f(new Runnable(this) {
                    final /* synthetic */ d fMy;

                    public final void run() {
                        d.a(aVar, false);
                    }

                    public final String toString() {
                        return super.toString() + "|retryJob";
                    }
                }, 3000);
            }
        }
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ d fMy;

            {
                this.fMy = r1;
            }

            public final void run() {
                List list = null;
                g alq = h.alq();
                Cursor rawQuery = alq.cie.rawQuery("select count(*) from FavEditInfo", null);
                if (rawQuery == null) {
                    v.e("MicroMsg.FavModInfoStorage", "count all edit info, cursor is null");
                } else {
                    if (rawQuery.moveToFirst()) {
                        v.i("MicroMsg.FavModInfoStorage", "get all edit infos, count %d", new Object[]{Integer.valueOf(rawQuery.getInt(0))});
                    }
                    rawQuery.close();
                    Cursor rawQuery2 = alq.cie.rawQuery("select * from FavEditInfo", null);
                    if (rawQuery2 != null) {
                        list = new LinkedList();
                        if (rawQuery2.moveToFirst()) {
                            do {
                                f fVar = new f();
                                fVar.b(rawQuery2);
                                list.add(fVar);
                            } while (rawQuery2.moveToNext());
                        }
                        rawQuery2.close();
                    }
                }
                if (list != null) {
                    v.d("MicroMsg.FavEditService", "infos size %d", new Object[]{Integer.valueOf(list.size())});
                    for (f fVar2 : list) {
                        String n = d.n(fVar2.field_localId, fVar2.field_type);
                        a aVar = (a) this.fMy.fMx.get(n);
                        if (aVar == null) {
                            v.d("MicroMsg.FavEditService", "not match key %s", new Object[]{n});
                            aVar = new a();
                            aVar.fMb = fVar2;
                            aVar.retryCount = 3;
                            aVar.time = SystemClock.elapsedRealtime();
                            this.fMy.fMx.put(n, aVar);
                            d.a(aVar, true);
                        } else {
                            v.d("MicroMsg.FavEditService", "match key %s, check start", new Object[]{n});
                            d.a(aVar, false);
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public static String n(long j, int i) {
        return j + "&&" + i;
    }
}
