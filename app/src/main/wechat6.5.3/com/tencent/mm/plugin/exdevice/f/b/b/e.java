package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e extends f<com.tencent.mm.plugin.exdevice.f.b.a.e> {
    public static final String[] cic = new String[]{f.a(com.tencent.mm.plugin.exdevice.f.b.a.e.chq, "HardDeviceLikeUser")};
    private d cie;

    public e(d dVar) {
        super(dVar, com.tencent.mm.plugin.exdevice.f.b.a.e.chq, "HardDeviceLikeUser", null);
        this.cie = dVar;
        dVar.dF("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
    }

    public final ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> sn(String str) {
        ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList = null;
        if (be.kS(str)) {
            v.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
        } else {
            String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceLikeUser", "rankID", "timestamp"});
            Cursor rawQuery = this.cie.rawQuery(format, new String[]{be.ah(str, "")});
            if (rawQuery == null) {
                v.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
            } else if (rawQuery.getCount() == 0) {
                v.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: no record");
                rawQuery.close();
            } else {
                arrayList = new ArrayList();
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        com.tencent.mm.plugin.exdevice.f.b.a.e eVar = new com.tencent.mm.plugin.exdevice.f.b.a.e();
                        eVar.b(rawQuery);
                        rawQuery.moveToNext();
                        arrayList.add(eVar);
                    }
                }
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public final void a(String str, String str2, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList) {
        Assert.assertTrue(!be.kS(str));
        if (arrayList == null) {
            v.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.f.b.a.e eVar = (com.tencent.mm.plugin.exdevice.f.b.a.e) it.next();
            Assert.assertTrue(eVar != null);
            if (a(eVar, new String[]{"rankID", "username"})) {
                v.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
            } else if (b(eVar)) {
                v.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
            } else {
                v.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
            }
        }
        ac.ajz().a("HardDeviceLikeUser", new com.tencent.mm.plugin.exdevice.f.b.d(str, str2, null));
    }
}
