package com.tencent.mm.ar;

import com.tencent.mm.sdk.h.g;

public final class m extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS verifycontact ( id INTEGER PRIMARY KEY, username varchar(40), nickname varchar(40), fullpy varchar(60), shortpy varchar(40), imgflag int, scene int, content text, status int, reserved1 int,reserved2 int,reserved3 text,reserved4 text)", "CREATE UNIQUE INDEX IF NOT EXISTS verifyContactIndex  ON verifycontact ( username )"};
    private com.tencent.mm.bg.g cuX;

    public m(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }
}
