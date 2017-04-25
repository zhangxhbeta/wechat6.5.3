package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.b;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;

final class n {
    private static volatile long f = 0;
    private boolean c = false;
    private Context d = null;
    private long e = System.currentTimeMillis();
    private b pLj;
    private c pLk = null;

    public n(b bVar) {
        this.pLj = bVar;
        this.pLk = b.bPV();
        this.c = bVar.f();
        this.d = bVar.bQo();
    }

    private void a(ah ahVar) {
        ai.hu(d.pKJ).a(this.pLj, ahVar);
    }

    private void c() {
        if (r.bQv().a <= 0 || !b.l) {
            a(new q(this));
            return;
        }
        r.bQv().b(this.pLj, null, this.c, true);
        r.bQv().a(-1);
    }

    public final void a() {
        boolean z;
        long bQe;
        if (b.h > 0) {
            if (this.e > d.pKE) {
                d.g.clear();
                d.pKE = this.e + b.i;
                if (b.bPW()) {
                    d.pKH.bw("clear methodsCalledLimitMap, nextLimitCallClearTime=" + d.pKE);
                }
            }
            Integer valueOf = Integer.valueOf(this.pLj.bQt().j);
            Integer num = (Integer) d.g.get(valueOf);
            if (num != null) {
                d.g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > b.h) {
                    if (b.bPW()) {
                        d.pKH.by("event " + this.pLj.g() + " was discard, cause of called limit, current:" + num + ", limit:" + b.h + ", period:" + b.i + " ms");
                    }
                    z = true;
                    if (z) {
                        if (b.m > 0 && this.e >= f) {
                            d.gO(this.d);
                            f = this.e + b.pKu;
                            if (b.bPW()) {
                                d.pKH.bw("nextFlushTime=" + f);
                            }
                        }
                        if (f.gQ(this.d).f()) {
                            r.gR(this.d).b(this.pLj, null, this.c, false);
                            return;
                        }
                        if (b.bPW()) {
                            d.pKH.bw("sendFailedCount=" + d.a);
                        }
                        if (d.a()) {
                            if (this.pLj.pKT != null && this.pLj.pKT.d) {
                                this.pLk = c.INSTANT;
                            }
                            if (b.j && f.gQ(d.pKJ).e()) {
                                this.pLk = c.INSTANT;
                            }
                            if (b.bPW()) {
                                d.pKH.bw("strategy=" + this.pLk.name());
                            }
                            switch (i.a[this.pLk.ordinal()]) {
                                case 1:
                                    c();
                                    return;
                                case 2:
                                    r.gR(this.d).b(this.pLj, null, this.c, false);
                                    if (b.bPW()) {
                                        d.pKH.bw("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + d.c + ",difftime=" + (d.c - this.e));
                                    }
                                    if (d.c == 0) {
                                        d.c = q.bD(this.d, "last_period_ts");
                                        if (this.e > d.c) {
                                            d.gP(this.d);
                                        }
                                        bQe = this.e + ((long) ((b.bQe() * 60) * 1000));
                                        if (d.c > bQe) {
                                            d.c = bQe;
                                        }
                                        ad.ht(this.d).a();
                                    }
                                    if (b.bPW()) {
                                        d.pKH.bw("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + d.c + ",difftime=" + (d.c - this.e));
                                    }
                                    if (this.e > d.c) {
                                        d.gP(this.d);
                                        return;
                                    }
                                    return;
                                case 3:
                                case 4:
                                    r.gR(this.d).b(this.pLj, null, this.c, false);
                                    return;
                                case 5:
                                    r.gR(this.d).b(this.pLj, new o(this), this.c, true);
                                    return;
                                case 6:
                                    if (f.gQ(d.pKJ).b != 1) {
                                        c();
                                        return;
                                    } else {
                                        r.gR(this.d).b(this.pLj, null, this.c, false);
                                        return;
                                    }
                                case 7:
                                    if (l.gW(this.d)) {
                                        a(new p(this));
                                        return;
                                    }
                                    return;
                                default:
                                    d.pKH.error("Invalid stat strategy:" + b.bPV());
                                    return;
                            }
                        }
                        r.gR(this.d).b(this.pLj, null, this.c, false);
                        if (this.e - d.b > 1800000) {
                            d.gM(this.d);
                            return;
                        }
                        return;
                    }
                }
            }
            d.g.put(valueOf, Integer.valueOf(1));
        }
        z = false;
        if (z) {
            d.gO(this.d);
            f = this.e + b.pKu;
            if (b.bPW()) {
                d.pKH.bw("nextFlushTime=" + f);
            }
            if (f.gQ(this.d).f()) {
                r.gR(this.d).b(this.pLj, null, this.c, false);
                return;
            }
            if (b.bPW()) {
                d.pKH.bw("sendFailedCount=" + d.a);
            }
            if (d.a()) {
                r.gR(this.d).b(this.pLj, null, this.c, false);
                if (this.e - d.b > 1800000) {
                    d.gM(this.d);
                    return;
                }
                return;
            }
            this.pLk = c.INSTANT;
            this.pLk = c.INSTANT;
            if (b.bPW()) {
                d.pKH.bw("strategy=" + this.pLk.name());
            }
            switch (i.a[this.pLk.ordinal()]) {
                case 1:
                    c();
                    return;
                case 2:
                    r.gR(this.d).b(this.pLj, null, this.c, false);
                    if (b.bPW()) {
                        d.pKH.bw("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + d.c + ",difftime=" + (d.c - this.e));
                    }
                    if (d.c == 0) {
                        d.c = q.bD(this.d, "last_period_ts");
                        if (this.e > d.c) {
                            d.gP(this.d);
                        }
                        bQe = this.e + ((long) ((b.bQe() * 60) * 1000));
                        if (d.c > bQe) {
                            d.c = bQe;
                        }
                        ad.ht(this.d).a();
                    }
                    if (b.bPW()) {
                        d.pKH.bw("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + d.c + ",difftime=" + (d.c - this.e));
                    }
                    if (this.e > d.c) {
                        d.gP(this.d);
                        return;
                    }
                    return;
                case 3:
                case 4:
                    r.gR(this.d).b(this.pLj, null, this.c, false);
                    return;
                case 5:
                    r.gR(this.d).b(this.pLj, new o(this), this.c, true);
                    return;
                case 6:
                    if (f.gQ(d.pKJ).b != 1) {
                        r.gR(this.d).b(this.pLj, null, this.c, false);
                        return;
                    } else {
                        c();
                        return;
                    }
                case 7:
                    if (l.gW(this.d)) {
                        a(new p(this));
                        return;
                    }
                    return;
                default:
                    d.pKH.error("Invalid stat strategy:" + b.bPV());
                    return;
            }
        }
    }
}
