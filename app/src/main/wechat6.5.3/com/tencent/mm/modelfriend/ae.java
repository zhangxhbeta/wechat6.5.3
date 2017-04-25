package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class ae extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )"};
    public final com.tencent.mm.bg.g cuX;

    public ae(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final ad fs(int i) {
        ad adVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = " + i, null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                adVar = new ad();
                adVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return adVar;
    }

    public final boolean a(ad adVar) {
        Assert.assertTrue(adVar != null);
        ContentValues Fy = adVar.Fy();
        if (Fy.size() <= 0) {
            v.e("MicroMsg.QQGroupStorage", "update failed, no values set");
            return false;
        }
        if (this.cuX.update("qqgroup", Fy, "grouopid= ?", new String[]{adVar.cIs}) <= 0) {
            return false;
        }
        Ls();
        return true;
    }
}
