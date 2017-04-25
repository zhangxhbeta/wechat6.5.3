package com.tencent.mm.ui.tools;

import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mmdb.database.SQLiteDatabase;

final class i extends b {
    protected String nJJ = SQLiteDatabase.KeyEmpty;
    protected String nJK = SQLiteDatabase.KeyEmpty;
    protected byte[] nJL = null;
    protected int nJM = 0;

    i() {
    }

    public final void bAL() {
        ak.vy().a(new s(this.nJM, SQLiteDatabase.KeyEmpty, this.nJJ, this.nJK), 0);
    }
}
