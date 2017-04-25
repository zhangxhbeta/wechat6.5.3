package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class b extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "HardDeviceChampionInfo")};
    private d cie;

    public b(d dVar) {
        super(dVar, a.chq, "HardDeviceChampionInfo", null);
        this.cie = dVar;
        dVar.dF("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
    }

    public final a sm(String str) {
        a aVar = null;
        String format = String.format("select *, rowid from %s where %s = ? limit 1", new Object[]{"HardDeviceChampionInfo", "username"});
        Cursor rawQuery = this.cie.rawQuery(format, new String[]{be.ah(str, "")});
        if (rawQuery == null) {
            v.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
        } else if (rawQuery.getCount() == 0) {
            v.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
            rawQuery.close();
        } else {
            aVar = new a();
            if (rawQuery.moveToFirst()) {
                aVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return aVar;
    }

    public final boolean a(a aVar, boolean z) {
        Assert.assertTrue(aVar != null);
        if (a(aVar, new String[]{"username"})) {
            v.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
            ac.ajz().a("HardDeviceChampionInfo", new com.tencent.mm.plugin.exdevice.f.b.d(null, null, aVar.field_username));
            return true;
        } else if (b(aVar)) {
            v.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
            ac.ajz().a("HardDeviceChampionInfo", new com.tencent.mm.plugin.exdevice.f.b.d(null, null, aVar.field_username));
            return true;
        } else {
            v.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
            return false;
        }
    }
}
