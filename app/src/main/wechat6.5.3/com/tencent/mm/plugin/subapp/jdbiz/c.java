package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.mm.e.a.gl;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.j.al;
import com.tencent.mm.pluginsdk.j.h;
import com.tencent.mm.pluginsdk.j.s;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public class c implements ag, s {
    private com.tencent.mm.sdk.c.c bYn = new com.tencent.mm.sdk.c.c<gl>(this) {
        final /* synthetic */ c kfl;

        {
            this.kfl = r2;
            this.nhz = gl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gl glVar = (gl) bVar;
            if (glVar != null && (glVar instanceof gl)) {
                glVar.bfX.url = this.kfl.aZr();
            }
            return false;
        }
    };
    private a kfi = null;
    private b kfj = null;
    Map<String, Integer> kfk = new HashMap();

    public final /* synthetic */ h aZs() {
        return aZn();
    }

    public c() {
        v.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + be.bur());
    }

    public static c aZi() {
        c cVar = (c) al.lyl;
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        al.lyl = cVar2;
        return cVar2;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.kfi == null) {
            this.kfi = new a();
        }
        ak.yU().a("jd", this.kfi, true);
        a.nhr.e(this.bYn);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        v.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        if (this.kfi != null) {
            a.nhr.f(this.kfi.keR);
            ak.yU().b("jd", this.kfi, true);
        }
        this.kfk.clear();
        this.kfi = null;
        a.nhr.f(this.bYn);
    }

    public final boolean aZj() {
        ak.yW();
        return "1".equals((String) com.tencent.mm.model.c.vf().get(327939, SQLiteDatabase.KeyEmpty));
    }

    public final boolean aZk() {
        ak.yW();
        return "1".equals((String) com.tencent.mm.model.c.vf().get(327938, SQLiteDatabase.KeyEmpty));
    }

    public final void aZl() {
        ak.yW();
        com.tencent.mm.model.c.vf().set(327938, SQLiteDatabase.KeyEmpty);
    }

    public final void aZm() {
        ak.yW();
        com.tencent.mm.model.c.vf().set(327939, SQLiteDatabase.KeyEmpty);
    }

    public final b aZn() {
        if (this.kfj == null) {
            this.kfj = b.aZb();
        }
        return this.kfj;
    }

    public static void b(b bVar) {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        c aZi = aZi();
        if (aZi.kfj == null) {
            aZi.kfj = b.aZb();
        }
        v.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", aZi.kfj.Wb(), bVar.Wb());
        if (bVar.a(aZi.kfj)) {
            if (!be.kS(bVar.keY) || bVar.keX) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(327939, "1");
            }
            if (bVar.keW) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(327938, "1");
            } else {
                ak.yW();
                com.tencent.mm.model.c.vf().set(327938, SQLiteDatabase.KeyEmpty);
            }
            aZi.kfj = bVar;
            ak.yW();
            com.tencent.mm.model.c.vf().set(327942, bVar.blu);
            aZi.aZo();
            return;
        }
        v.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
    }

    private void aZo() {
        new ac(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ c kfl;

            {
                this.kfl = r1;
            }

            public final void run() {
                a.nhr.z(new hi());
            }
        });
    }

    public final void aZp() {
        if (!ak.uz()) {
            return;
        }
        if (aZi().aZj() || aZi().aZk()) {
            b aZn = aZi().aZn();
            if ((!be.kS(aZn.keY) || aZn.keX) && aZn.aZc()) {
                v.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
                aZi().aZl();
                aZi().aZm();
                aZi().aZo();
            }
        }
    }

    public static String bc(String str, int i) {
        if (-1 != str.indexOf(35)) {
            return str;
        }
        if (-1 == str.indexOf(63)) {
            return str + "?wc_scene=" + i;
        }
        return str + "&wc_scene=" + i;
    }

    public static boolean aZq() {
        return (be.kS(j.sU().getValue("JDEntranceConfigName")) || be.kS(j.sU().getValue("JDEntranceConfigIconUrl")) || be.kS(j.sU().getValue("JDEntranceConfigJumpUrl"))) ? false : true;
    }

    public final String aZr() {
        int i = 1;
        String value = j.sU().getValue("JDEntranceConfigJumpUrl");
        if (be.kS(value)) {
            return null;
        }
        int i2;
        int i3;
        b aZn = aZn();
        if (aZj()) {
            if (!aZn.aZc() && "3".equals(aZn.keU) && !be.kS(aZn.jumpUrl)) {
                v.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", aZn.jumpUrl);
                value = aZn.jumpUrl;
                i2 = 6;
                if (aZn.kfa < System.currentTimeMillis() / 1000) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (i3 != 0) {
                    i = 0;
                    if (i == 0) {
                        value = aZn.jumpUrl;
                        i2 = 3;
                    }
                }
                return bc(value, i2);
            } else if (aZn.keX) {
                i2 = 2;
                if ("2".equals(aZn.keU) && !be.kS(aZn.jumpUrl)) {
                    if (aZn.kfa < System.currentTimeMillis() / 1000) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        if (aZn.kfb == 0 || aZn.kfb >= System.currentTimeMillis() / 1000) {
                            i = 0;
                        }
                        if (i == 0) {
                            value = aZn.jumpUrl;
                            i2 = 3;
                        }
                    }
                }
                return bc(value, i2);
            }
        }
        i2 = 1;
        if (aZn.kfa < System.currentTimeMillis() / 1000) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            i = 0;
            if (i == 0) {
                value = aZn.jumpUrl;
                i2 = 3;
            }
        }
        return bc(value, i2);
    }
}
