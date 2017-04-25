package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d extends f<com.tencent.mm.plugin.exdevice.f.b.a.d> {
    public static final String[] cic = new String[]{f.a(com.tencent.mm.plugin.exdevice.f.b.a.d.chq, "HardDeviceRankInfo")};
    public com.tencent.mm.sdk.h.d cie;

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, com.tencent.mm.plugin.exdevice.f.b.a.d.chq, "HardDeviceRankInfo", null);
        this.cie = dVar;
        dVar.dF("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
    }

    public final com.tencent.mm.plugin.exdevice.f.b.a.d a(com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        com.tencent.mm.plugin.exdevice.f.b.a.d dVar2 = null;
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankInfo", "rankID", "username"});
        Cursor rawQuery = this.cie.rawQuery(format, new String[]{be.ah(dVar.fwr, ""), be.ah(dVar.username, "")});
        if (rawQuery == null) {
            v.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        } else if (rawQuery.getCount() == 0) {
            v.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            rawQuery.close();
        } else {
            dVar2 = new com.tencent.mm.plugin.exdevice.f.b.a.d();
            if (rawQuery.moveToFirst()) {
                dVar2.b(rawQuery);
            }
            rawQuery.close();
        }
        return dVar2;
    }

    public final void b(String str, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> arrayList) {
        if (be.kS(str) || arrayList == null) {
            v.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
            return;
        }
        v.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", new Object[]{str, Integer.valueOf(arrayList.size())});
        for (int i = 0; i < arrayList.size(); i++) {
            a((com.tencent.mm.plugin.exdevice.f.b.a.d) arrayList.get(i), false);
        }
        ac.ajz().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(str, null, null));
    }

    public final boolean a(com.tencent.mm.plugin.exdevice.f.b.a.d dVar, boolean z) {
        if (!b(dVar, z)) {
            Assert.assertTrue(dVar != null);
            b(dVar);
            v.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
            if (z) {
                ac.ajz().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
            }
        }
        return true;
    }

    public final boolean b(com.tencent.mm.plugin.exdevice.f.b.a.d dVar, boolean z) {
        Assert.assertTrue(dVar != null);
        com.tencent.mm.plugin.exdevice.f.b.a.d a = a(new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        if (a == null) {
            return false;
        }
        a.field_likecount = dVar.field_likecount;
        a.field_selfLikeState = dVar.field_selfLikeState;
        a(a, new String[]{"rankID", "username"});
        v.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
        if (!z) {
            return true;
        }
        ac.ajz().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        return true;
    }
}
