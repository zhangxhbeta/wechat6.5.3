package com.tencent.mm.plugin.sns.lucky.b;

import android.app.Activity;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.b.b;
import com.tencent.mm.plugin.sns.lucky.a.a.c;
import com.tencent.mm.plugin.sns.lucky.a.a.d;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class w extends a implements e {
    public i jfA;
    private j jfw;
    private h jfx;
    private d jfy;
    private g jfz;

    public final void x(Activity activity) {
        super.x(activity);
        ak.vy().a(1640, this);
        ak.vy().a(1641, this);
        ak.vy().a(1642, this);
        ak.vy().a(1554, this);
        ak.vy().a(1639, this);
    }

    public final void axD() {
        super.axD();
        ak.vy().b(1640, this);
        ak.vy().b(1641, this);
        ak.vy().b(1642, this);
        ak.vy().b(1554, this);
        ak.vy().b(1639, this);
    }

    public final boolean a(b bVar) {
        if (com.tencent.mm.plugin.sns.lucky.a.a.e.TYPE.equals(bVar.mType)) {
            ak.vy().a(new j(bVar.gZY.getString("sendId"), bVar.gZY.getString("ticket")), 0);
        } else if (c.TYPE.equals(bVar.mType)) {
            ak.vy().a(new h(bVar.gZY.getString("sendId"), bVar.gZY.getString("headImg"), bVar.gZY.getString("nickName"), bVar.gZY.getString("sessionUserName"), bVar.gZY.getString("ticket")), 0);
        } else if (com.tencent.mm.plugin.sns.lucky.a.a.a.TYPE.equals(bVar.mType)) {
            ak.vy().a(new d(bVar.gZY.getString("sendId"), bVar.gZY.getInt("limit"), bVar.gZY.getInt("offset"), (long) bVar.gZY.getInt("befortTimestamp"), bVar.gZY.getString("ver"), bVar.gZY.getString("ticket")), 0);
        } else if (com.tencent.mm.plugin.sns.lucky.a.a.b.TYPE.equals(bVar.mType)) {
            ak.vy().a(new g("v1.0"), 0);
        } else if (d.TYPE.equals(bVar.mType)) {
            int i = bVar.gZY.getInt("total_num", 0);
            long j = bVar.gZY.getLong("total_amount", 0);
            String string = bVar.gZY.getString("wishing");
            bVar.gZY.getLong("total_amount", 0);
            String string2 = bVar.gZY.getString("userName");
            ak.vy().a(new i(i, j, string, bVar.gZY.getString("headImg"), bVar.gZY.getString("nickName"), bVar.gZY.getString("feedId"), string2), 0);
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof j) {
            if (i == 0 && i2 == 0) {
                this.jfw = (j) kVar;
                a.vX(com.tencent.mm.plugin.sns.lucky.a.a.e.TYPE);
            } else {
                a.ca(com.tencent.mm.plugin.sns.lucky.a.a.e.TYPE, str);
            }
        }
        if (kVar instanceof h) {
            if (i == 0 && i2 == 0) {
                this.jfx = (h) kVar;
                a.vX(c.TYPE);
            } else {
                a.ca(c.TYPE, str);
            }
        }
        if (kVar instanceof d) {
            if (i == 0 && i2 == 0) {
                this.jfy = (d) kVar;
                a.vX(com.tencent.mm.plugin.sns.lucky.a.a.a.TYPE);
            } else {
                a.ca(com.tencent.mm.plugin.sns.lucky.a.a.a.TYPE, str);
            }
        }
        if (kVar instanceof g) {
            if (i == 0 && i2 == 0) {
                this.jfz = (g) kVar;
                a.vX(com.tencent.mm.plugin.sns.lucky.a.a.b.TYPE);
            } else {
                a.ca(com.tencent.mm.plugin.sns.lucky.a.a.b.TYPE, str);
            }
        }
        if (!(kVar instanceof i)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.jfA = (i) kVar;
            a.vX(d.TYPE);
            return;
        }
        a.ca(d.TYPE, str);
    }
}
