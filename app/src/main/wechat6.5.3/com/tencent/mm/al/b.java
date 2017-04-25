package com.tencent.mm.al;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import junit.framework.Assert;

public final class b extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public com.tencent.mm.bg.g cuX;

    public b(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(a aVar) {
        aVar.bkU = -1;
        if (((int) this.cuX.insert("chattingbginfo", "username", aVar.py())) == -1) {
            return false;
        }
        Lf(aVar.getUsername());
        return true;
    }

    public final boolean b(a aVar) {
        Assert.assertTrue(aVar != null);
        ContentValues py = aVar.py();
        if (py.size() > 0) {
            if (this.cuX.update("chattingbginfo", py, "username= ?", new String[]{aVar.getUsername()}) > 0) {
                Lf(aVar.getUsername());
                return true;
            }
        }
        return false;
    }

    public final a jt(String str) {
        a aVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + be.lZ(str) + "\"", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                aVar = new a();
                aVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return aVar;
    }
}
