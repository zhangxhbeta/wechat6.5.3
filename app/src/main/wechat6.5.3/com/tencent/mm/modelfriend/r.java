package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;

public final class r extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private com.tencent.mm.bg.g cuX;

    public r(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(q qVar) {
        if (iK(qVar.getUsername())) {
            qVar.bkU = -1;
            if (this.cuX.update("invitefriendopen", qVar.py(), "username=?", new String[]{qVar.getUsername()}) > 0) {
                return true;
            }
            return false;
        }
        qVar.bkU = -1;
        if (((int) this.cuX.insert("invitefriendopen", "username", qVar.py())) == -1) {
            return false;
        }
        return true;
    }

    public final boolean iK(String str) {
        Cursor rawQuery = this.cuX.rawQuery("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + be.lZ(str) + "\"", null);
        boolean z = rawQuery.getCount() > 0;
        rawQuery.close();
        return z;
    }
}
