package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.model.ab.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b implements d {

    private static class a implements e {
        public a() {
            ak.vy().a(167, (e) this);
            ak.vy().a(new a(), 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            ak.vy().b(167, (e) this);
        }
    }

    public final String eI(int i) {
        return M(i, true);
    }

    public final String eJ(int i) {
        return M(i, false);
    }

    private String M(int i, boolean z) {
        int i2 = 0;
        ak.yW();
        if (!c.isSDCardAvailable()) {
            return null;
        }
        int i3;
        if (i != 0) {
            i3 = 0;
            while (i3 < 32) {
                i = (i >> 1) & Integer.MAX_VALUE;
                if (i == 0) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            i2 = 1 << i3;
        }
        String u = i2 == 0 ? null : u(i2, z);
        if (com.tencent.mm.a.e.aR(u)) {
            return u;
        }
        yG();
        return null;
    }

    public final void yG() {
        ak.yW();
        if (c.isSDCardAvailable()) {
            ak.yW();
            long a = be.a((Long) c.vf().get(66051, null), 0);
            long Ni = be.Ni();
            if (432000000 <= Ni - a) {
                ak.yW();
                c.vf().set(66051, Long.valueOf(Ni));
                a aVar = new a();
            }
        }
    }

    public final boolean eK(int i) {
        if (i == 0) {
            return false;
        }
        int i2 = 0;
        while (i2 < 32) {
            if (!com.tencent.mm.a.e.aR(u((1 << i2) & i, false)) || !com.tencent.mm.a.e.aR(u((1 << i2) & i, true))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public final String u(int i, boolean z) {
        if (i == 0) {
            return null;
        }
        return com.tencent.mm.compatible.util.e.cgh + "vuserpic_" + Integer.toHexString(i) + (z ? "_HD" : SQLiteDatabase.KeyEmpty) + ".png";
    }
}
