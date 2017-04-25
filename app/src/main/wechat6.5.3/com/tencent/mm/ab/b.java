package com.tencent.mm.ab;

import com.tencent.mm.sdk.h.g;

public final class b extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    com.tencent.mm.bg.g cuX;

    public b(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean iN(String str) {
        if (this.cuX.delete("getcontactinfov2", "username= ?", new String[]{str}) <= 0) {
            return false;
        }
        Lf(str);
        return true;
    }
}
