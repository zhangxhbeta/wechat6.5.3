package com.tencent.mm.model;

import com.tencent.mm.e.a.oz;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import junit.framework.Assert;

public final class bn {
    private int cvA = 1;
    private a cvw = null;
    private long cvx = 0;
    private long cvy = 0;
    private String cvz = SQLiteDatabase.KeyEmpty;

    public interface a {
        boolean Ad();
    }

    public bn(a aVar) {
        Assert.assertTrue(true);
        this.cvw = aVar;
        zW();
    }

    private void zW() {
        this.cvA = 1;
        this.cvx = 0;
        this.cvy = 0;
        this.cvz = SQLiteDatabase.KeyEmpty;
    }

    public final synchronized boolean zX() {
        boolean z = true;
        synchronized (this) {
            long Ni = be.Ni();
            this.cvz = be.bur().toString();
            if (this.cvA == 1) {
                this.cvy = Ni;
                this.cvx = 3600000;
                v.i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", Long.valueOf(3600000), this.cvz);
                this.cvA = 2;
                if (this.cvw.Ad()) {
                    zZ();
                }
            } else {
                long j = this.cvy + this.cvx;
                Ni += 3600000;
                if (Ni > j) {
                    this.cvx += Ni - j;
                }
                v.i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", Integer.valueOf(this.cvA), Long.valueOf(3600000), Long.valueOf(Ni - j), Long.valueOf(this.cvx), this.cvz);
                z = false;
            }
        }
        return z;
    }

    public final synchronized void zY() {
        v.d("MicroMsg.SyncPauser", "restartSync currState:%d %s", Integer.valueOf(this.cvA), be.bur());
        if (this.cvA == 1) {
            v.d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", be.bur());
        } else {
            zW();
            b ozVar = new oz();
            ozVar.bql.status = 1;
            com.tencent.mm.sdk.c.a.nhr.z(ozVar);
        }
    }

    public final synchronized void zZ() {
        if (this.cvA != 2) {
            v.e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", Integer.valueOf(this.cvA), be.bur());
        } else {
            v.d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", Long.valueOf(be.ay(this.cvy)), be.bur());
            this.cvA = 3;
            b ozVar = new oz();
            ozVar.bql.status = 3;
            com.tencent.mm.sdk.c.a.nhr.z(ozVar);
        }
    }

    private synchronized void Aa() {
        if (this.cvA != 1 && this.cvx + this.cvy < be.Ni()) {
            zY();
        }
    }

    public final synchronized boolean Ab() {
        Aa();
        return this.cvA == 2;
    }

    public final synchronized boolean Ac() {
        Aa();
        return this.cvA == 3;
    }
}
