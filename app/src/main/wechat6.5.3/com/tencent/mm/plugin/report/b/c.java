package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.c.a.a.f;
import com.tencent.c.a.a.i;
import com.tencent.c.a.a.n;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c {
    private static i itu = i.R(aa.getContext());
    private static int itv = 2;

    static /* synthetic */ int ov() {
        int i = itv;
        itv = i - 1;
        return i;
    }

    public static String aKw() {
        try {
            i.a(new f() {
                public final void aK(String str) {
                    v.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", str, Integer.valueOf(c.itv));
                    if (c.ov() <= 0) {
                        v.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", Integer.valueOf(c.itv));
                        return;
                    }
                    a aVar = new a();
                    aVar.czn = new aom();
                    aVar.czo = new aon();
                    aVar.uri = "/cgi-bin/micromsg-bin/querymid";
                    aVar.czm = 684;
                    b Bv = aVar.Bv();
                    ((aom) Bv.czk.czs).mOz = str;
                    ((aom) Bv.czk.czs).gly = 1;
                    u.a(Bv, new u.a(this) {
                        final /* synthetic */ AnonymousClass1 itw;

                        {
                            this.itw = r1;
                        }

                        public final int a(int i, int i2, String str, b bVar, k kVar) {
                            v.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            return 0;
                        }
                    }, true);
                }
            });
            v.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", itu.nQ(), itu.nR());
            return itu.nQ();
        } catch (Throwable e) {
            v.e("MicroMsg.MidHelper", "QueryMid Error e:%s", be.e(e));
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public static void yJ(String str) {
        try {
            i iVar = itu;
            if (i.mContext != null) {
                i.aOB = System.currentTimeMillis();
                n.aOM = -1;
                try {
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", i.aOB);
                    edit.commit();
                } catch (Exception e) {
                }
                if (i.mHandler != null) {
                    i.mHandler.post(new com.tencent.c.a.a.i.AnonymousClass1(iVar, str));
                }
            }
            v.i("MicroMsg.MidHelper", "QueryMid local:%s", itu.nR());
        } catch (Throwable e2) {
            v.e("MicroMsg.MidHelper", "procReturnData Error e:%s", be.e(e2));
        }
    }

    public static int j(int i, int i2, String str) {
        if (g.uz()) {
            long Nh = be.Nh();
            if (i == 3 && be.a((Long) g.vw().vf().get(331778, null), 0) >= Nh) {
                return 0;
            }
            int i3;
            if (ak.is2G(aa.getContext())) {
                i3 = 1;
            } else if (ak.isWifi(aa.getContext())) {
                i3 = 3;
            } else if (ak.is3G(aa.getContext())) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            String aKw = aKw();
            v.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i), aKw);
            com.tencent.mm.plugin.report.b.itm.h(11402, aKw, Integer.valueOf(i), Integer.valueOf(i3), p.rK(), Integer.valueOf(i2), str, ak.getISPName(aa.getContext()), Integer.valueOf(0), p.getDeviceID(aa.getContext()));
            g.vw().vf().set(331778, Long.valueOf(259200 + Nh));
            return 0;
        }
        v.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
        return -1;
    }
}
