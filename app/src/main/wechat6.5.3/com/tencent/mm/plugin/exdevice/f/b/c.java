package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.f.a.f;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.f.a.m;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c implements e {
    public f fwI;
    public f fwJ;

    public c() {
        v.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        ak.vy().a(1042, this);
        ak.vy().a(1041, this);
        ak.vy().a(1043, this);
        ak.vy().a(1040, this);
    }

    public static ArrayList<d> si(String str) {
        ArrayList<d> arrayList = null;
        v.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (be.kS(str)) {
            v.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
        } else {
            com.tencent.mm.plugin.exdevice.f.b.b.d ajr = ac.ajr();
            if (be.kS(str)) {
                v.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceRankInfo", "rankID", "score"});
                Cursor rawQuery = ajr.cie.rawQuery(format, new String[]{be.ah(str, "")});
                if (rawQuery == null) {
                    v.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                } else if (rawQuery.getCount() == 0) {
                    v.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    rawQuery.close();
                } else {
                    arrayList = new ArrayList();
                    if (rawQuery.moveToFirst()) {
                        while (!rawQuery.isAfterLast()) {
                            d dVar = new d();
                            dVar.b(rawQuery);
                            rawQuery.moveToNext();
                            arrayList.add(dVar);
                        }
                    }
                    rawQuery.close();
                }
            }
        }
        return arrayList;
    }

    public static void a(String str, ArrayList<d> arrayList) {
        com.tencent.mm.plugin.exdevice.f.b.b.d ajr = ac.ajr();
        Assert.assertTrue(!be.kS(str));
        if (arrayList != null) {
            int i;
            Cursor rawQuery = ajr.cie.rawQuery(String.format("select COUNT(*) from %s where %s = ?", new Object[]{"HardDeviceRankInfo", "rankID"}), new String[]{be.ah(str, "")});
            if (rawQuery == null) {
                v.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i = 0;
            } else if (rawQuery.getCount() == 0) {
                v.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                rawQuery.close();
                i = 0;
            } else {
                if (rawQuery.moveToFirst()) {
                    i = rawQuery.getInt(0);
                } else {
                    i = 0;
                }
                rawQuery.close();
            }
            Iterator it;
            if (i == 0) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    ajr.a((d) it.next(), false);
                }
                return;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                ajr.b((d) it.next(), false);
            }
            return;
        }
        v.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar instanceof j) {
            if (i != 0 || i2 != 0) {
                v.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
            }
        } else if (kVar instanceof l) {
            if (i != 0 || i2 != 0) {
                v.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        } else if (!(kVar instanceof m)) {
        } else {
            if (i != 0 || i2 != 0) {
                v.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        }
    }
}
