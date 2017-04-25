package com.tencent.mm.v;

import android.os.Looper;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k.a;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.utils.TbsLog;

public final class q extends a {
    private final k aZJ;
    private final long cAs = 330000;
    private p cAt;
    private j cAu;
    private boolean cAv = false;
    private boolean cAw = false;
    Runnable cAx = new Runnable(this) {
        final /* synthetic */ q cAy;

        {
            this.cAy = r1;
        }

        public final void run() {
            int i = 0;
            if (this.cAy.cAv || this.cAy.cAw) {
                int i2;
                String str = "MicroMsg.RemoteOnGYNetEnd";
                String str2 = "time exceed But removeCallbacks failed hash:%d type:%d";
                Object[] objArr = new Object[2];
                if (this.cAy.aZJ == null) {
                    i2 = 0;
                } else {
                    i2 = this.cAy.aZJ.hashCode();
                }
                objArr[0] = Integer.valueOf(i2);
                if (this.cAy.aZJ != null) {
                    i = this.cAy.aZJ.getType();
                }
                objArr[1] = Integer.valueOf(i);
                v.e(str, str2, objArr);
                return;
            }
            final boolean a = this.cAy.cAv;
            final boolean b = this.cAy.cAw;
            String str3 = "MicroMsg.RemoteOnGYNetEnd";
            String str4 = "time exceed, force to callback hash:%d type:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(this.cAy.aZJ == null ? 0 : this.cAy.aZJ.hashCode());
            if (this.cAy.aZJ != null) {
                i = this.cAy.aZJ.getType();
            }
            objArr2[1] = Integer.valueOf(i);
            v.w(str3, str4, objArr2);
            this.cAy.cAv = true;
            e.a(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 cAB;

                public final void run() {
                    int i = 0;
                    this.cAB.cAy.czE.gU("push process's network haven't callback in 5.5min!!!! cancelStatus:" + a + " hasCallbackStatus:" + b);
                    String str = "MicroMsg.RemoteOnGYNetEnd";
                    String str2 = "time exceed, force to callback . kill push fin. hash:%d type:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(this.cAB.cAy.aZJ == null ? 0 : this.cAB.cAy.aZJ.hashCode());
                    if (this.cAB.cAy.aZJ != null) {
                        i = this.cAB.cAy.aZJ.getType();
                    }
                    objArr[1] = Integer.valueOf(i);
                    v.w(str, str2, objArr);
                }
            }, "RemoteOnGYNetEnd_killPush");
            this.cAy.cAu.a(-1, 3, -1, "time exceed, force to callback", this.cAy.cAt, null);
        }
    };
    private final com.tencent.mm.network.e czE;
    private final e czJ;
    final ac handler;

    public q(p pVar, j jVar, k kVar, e eVar, com.tencent.mm.network.e eVar2) {
        this.cAt = pVar;
        this.cAu = jVar;
        this.aZJ = kVar;
        this.czJ = eVar;
        this.handler = Looper.myLooper() == null ? new ac(Looper.getMainLooper()) : new ac();
        this.czE = eVar2;
    }

    public final void cancel() {
        this.cAv = true;
        this.handler.removeCallbacks(this.cAx);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        v.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.cAv), Integer.valueOf(this.aZJ.hashCode()), Integer.valueOf(this.cAt.hashCode()));
        this.aZJ.czG = -1;
        if (!this.cAv && !this.cAw) {
            this.cAw = true;
            this.handler.removeCallbacks(this.cAx);
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final byte[] bArr2 = bArr;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ q cAy;

                public final void run() {
                    if (this.cAy.cAv) {
                        v.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i4));
                        return;
                    }
                    int i = i5;
                    int i2 = i6;
                    if (10016 == com.tencent.mm.platformtools.q.dqj && !be.kS(com.tencent.mm.platformtools.q.dql)) {
                        v.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", com.tencent.mm.platformtools.q.dql);
                        String[] split = com.tencent.mm.platformtools.q.dql.split(",");
                        if (split != null && split.length == 3 && be.getInt(split[0], -1) == this.cAy.aZJ.getType()) {
                            i = be.getInt(split[1], 0);
                            i2 = be.getInt(split[2], 0);
                            if (i == TbsLog.TBSLOG_CODE_SDK_INIT) {
                                v.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", com.tencent.mm.platformtools.q.dql);
                                return;
                            }
                        }
                    }
                    v.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.cAy.cAv), Integer.valueOf(this.cAy.aZJ.hashCode()));
                    this.cAy.cAu.a(i4, i, i2, str2, this.cAy.cAt, bArr2);
                    if (this.cAy.aZJ.BC() && !this.cAy.aZJ.czK) {
                        v.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(this.cAy.aZJ.getType()));
                        v.bta();
                    }
                }
            });
        }
    }
}
