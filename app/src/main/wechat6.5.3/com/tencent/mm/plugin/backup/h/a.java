package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class a extends k implements j {
    protected e cii;
    protected int cyu = 0;
    protected String ehp = SQLiteDatabase.KeyEmpty;
    protected int emn = 0;
    protected int emo = 0;
    protected boolean emp = false;

    public abstract p BD();

    public final int Wx() {
        return this.emn;
    }

    public final boolean pm(String str) {
        if (be.kS(str) || be.kS(this.ehp)) {
            return false;
        }
        return str.equals(this.ehp);
    }

    protected void cancel() {
        this.emp = true;
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (this.emp) {
            return -1;
        }
        return a(eVar, BD(), this);
    }

    public final int Wy() {
        return this.emo;
    }

    public final int Wz() {
        return this.cyu;
    }
}
