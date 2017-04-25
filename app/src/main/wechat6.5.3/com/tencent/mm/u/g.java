package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.be;

public final class g extends com.tencent.mm.sdk.h.g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    com.tencent.mm.bg.g cuX;

    public g(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final int a(String str, f fVar) {
        return this.cuX.update("hdheadimginfo", fVar.py(), "username=?", new String[]{str});
    }

    public final f gP(String str) {
        f fVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + be.lZ(str) + "\"", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                fVar = new f();
                fVar.username = rawQuery.getString(0);
                fVar.cyr = rawQuery.getInt(1);
                fVar.cys = rawQuery.getInt(2);
                fVar.cyt = rawQuery.getString(3);
                fVar.cyu = rawQuery.getInt(4);
                fVar.cyv = rawQuery.getInt(5);
                fVar.cyw = rawQuery.getInt(6);
                fVar.cyx = rawQuery.getString(7);
                fVar.cyy = rawQuery.getString(8);
                fVar.cyz = rawQuery.getInt(9);
                fVar.cyA = rawQuery.getInt(10);
            }
            rawQuery.close();
        }
        return fVar;
    }
}
