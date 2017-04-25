package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.b;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "HardDeviceRankFollowInfo")};
    private d cie;

    public a(d dVar) {
        super(dVar, c.chq, "HardDeviceRankFollowInfo", null);
        this.cie = dVar;
        dVar.dF("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
    }

    public final c a(b bVar) {
        c cVar = null;
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "username", "appusername"});
        Cursor rawQuery = this.cie.rawQuery(format, new String[]{be.ah(bVar.fwr, ""), be.ah(bVar.username, ""), be.ah(bVar.appName, "")});
        if (rawQuery == null) {
            v.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
        } else if (rawQuery.getCount() == 0) {
            v.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            rawQuery.close();
        } else {
            cVar = new c();
            if (rawQuery.moveToFirst()) {
                cVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return cVar;
    }

    public final boolean sk(String str) {
        Cursor rawQuery = this.cie.rawQuery(String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername", "username"}), new String[]{be.ah("hardcode_rank_id", ""), be.ah("hardcode_app_name", ""), be.ah(str, "")});
        if (rawQuery == null) {
            v.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
            return false;
        }
        v.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", new Object[]{Boolean.valueOf(rawQuery.getCount() == 1)});
        rawQuery.close();
        return rawQuery.getCount() == 1;
    }

    public final ArrayList<c> ajE() {
        ArrayList<c> arrayList = null;
        String format = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername"});
        Cursor rawQuery = this.cie.rawQuery(format, new String[]{"hardcode_rank_id", "hardcode_app_name"});
        if (rawQuery == null) {
            v.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
        } else if (rawQuery.getCount() == 0) {
            v.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            rawQuery.close();
        } else {
            arrayList = new ArrayList();
            if (rawQuery.moveToFirst()) {
                while (!rawQuery.isAfterLast()) {
                    c cVar = new c();
                    cVar.b(rawQuery);
                    v.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", new Object[]{Integer.valueOf(rawQuery.getColumnIndex("rowid")), cVar.toString()});
                    rawQuery.moveToNext();
                    arrayList.add(cVar);
                }
            }
            v.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", new Object[]{Integer.valueOf(arrayList.size()), arrayList.toString()});
            rawQuery.close();
        }
        return arrayList;
    }

    public final void a(ArrayList<qs> arrayList, String str, String str2) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                qs qsVar = (qs) it.next();
                c cVar = new c();
                cVar.field_rankID = str;
                cVar.field_step = qsVar.eWn;
                cVar.field_username = qsVar.username;
                cVar.field_appusername = str2;
                a(cVar);
            }
        }
    }

    public final void ao(List<c> list) {
        String str = "hardcode_app_name";
        if (be.kS("hardcode_rank_id") || be.kS(str)) {
            v.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
        } else {
            int delete = this.cie.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[]{r0, str});
            v.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", new Object[]{r0, str, Integer.valueOf(delete)});
        }
        if (list != null) {
            for (c cVar : list) {
                cVar.field_rankID = "hardcode_rank_id";
                cVar.field_appusername = "hardcode_app_name";
                a(cVar);
            }
        }
    }

    private boolean a(c cVar) {
        boolean z;
        boolean z2 = false;
        if (cVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        c a = a(new b(cVar.field_rankID, cVar.field_appusername, cVar.field_username));
        if (a != null) {
            a.field_step = cVar.field_step;
            a(a, new String[]{"rankID", "appusername", "username"});
            v.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (cVar != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            b(cVar);
            v.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
        }
        return true;
    }

    public final boolean sl(String str) {
        c a = a(new b("hardcode_rank_id", "hardcode_app_name", str));
        if (a == null) {
            return false;
        }
        c(a, new String[]{"rankID", "appusername", "username"});
        v.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
        return true;
    }
}
