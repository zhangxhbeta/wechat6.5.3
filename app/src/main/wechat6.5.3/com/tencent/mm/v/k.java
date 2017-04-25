package com.tencent.mm.v;

import com.tencent.mm.model.az;
import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import junit.framework.Assert;

public abstract class k {
    public int aGx = -99;
    public e czE;
    public long czF = be.Nj();
    public int czG = -1;
    public boolean czH = false;
    private q czI;
    e czJ;
    public boolean czK;
    private p czL;
    int priority = 0;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] czP = new int[b.BF().length];

        static {
            try {
                czP[b.czT - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                czP[b.czV - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                czP[b.czU - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected enum a {
        EStatusCheckFailed,
        EReachMaxLimit
    }

    protected enum b {
        ;

        public static int[] BF() {
            return (int[]) czW.clone();
        }

        static {
            czT = 1;
            czU = 2;
            czV = 3;
            czW = new int[]{czT, czU, czV};
        }
    }

    public abstract int a(e eVar, e eVar2);

    public abstract int getType();

    public void a(a aVar) {
    }

    public int a(p pVar) {
        return b.czT;
    }

    public boolean Bz() {
        return false;
    }

    public int ul() {
        return 1;
    }

    public boolean BA() {
        return this.aGx <= 0;
    }

    public boolean BB() {
        return false;
    }

    public final void c(e eVar) {
        this.czF = be.Nj();
        this.czE = eVar;
    }

    public boolean BC() {
        return ul() == 1;
    }

    public int a(e eVar, final p pVar, j jVar) {
        c(eVar);
        this.czL = pVar;
        final j a = az.a(jVar);
        if (this.aGx == -99) {
            this.aGx = ul();
            v.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.aGx);
        }
        if (ul() > 1) {
            switch (AnonymousClass2.czP[a(pVar) - 1]) {
                case 1:
                    Assert.assertTrue("scene security verification not passed, type=" + pVar.getType() + ", uri=" + pVar.getUri() + ", CHECK NOW", false);
                    break;
                case 2:
                    v.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + pVar.getType() + ", uri=" + pVar.getUri());
                    this.aGx--;
                    a(a.EStatusCheckFailed);
                    this.czG = -1;
                    return this.czG;
                case 3:
                    break;
                default:
                    Assert.assertTrue("invalid security verification status", false);
                    break;
            }
        }
        if (BA()) {
            v.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + ul());
            a(a.EReachMaxLimit);
            this.czG = -1;
            return this.czG;
        }
        this.aGx--;
        q sVar = new s(pVar);
        if (!(this.czI == null || BB())) {
            this.czI.cancel();
        }
        this.czI = new q(pVar, a, this, this.czJ, eVar);
        this.czG = eVar.a(sVar, this.czI);
        v.i("MicroMsg.NetSceneBase", "dispatcher send, %s", Integer.valueOf(this.czG));
        if (this.czG < 0) {
            v.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.czG), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(pVar.getType()));
            new ac().post(new Runnable(this) {
                final /* synthetic */ k czO;

                public final void run() {
                    v.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.czO.czG), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(pVar.getType()));
                    a.a(-1, 3, -1, "send to network failed", pVar, null);
                    v.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.czO.czG), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(pVar.getType()));
                }
            });
            return 99999999;
        }
        q qVar = this.czI;
        qVar.handler.postDelayed(qVar.cAx, 330000);
        return this.czG;
    }

    public p BD() {
        return this.czL;
    }

    public final int BE() {
        return this.czL == null ? 0 : this.czL.hashCode();
    }

    public void cancel() {
        v.i("MicroMsg.NetSceneBase", "cancel: %d", Integer.valueOf(this.czG));
        this.czH = true;
        if (this.czI != null) {
            this.czI.cancel();
        }
        if (this.czG != -1 && this.czE != null) {
            int i = this.czG;
            this.czG = -1;
            this.czE.cancel(i);
        }
    }

    public boolean a(k kVar) {
        return false;
    }

    public boolean b(k kVar) {
        return false;
    }

    public String getInfo() {
        return SQLiteDatabase.KeyEmpty;
    }
}
