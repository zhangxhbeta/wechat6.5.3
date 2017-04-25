package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.v.d;
import java.util.HashMap;

public final class b implements ag {
    private m ixZ = new a(this) {
        final /* synthetic */ b kka;

        {
            this.kka = r1;
        }

        public final void cI(int i) {
            if (i == 4) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 kkb;

                    {
                        this.kkb = r1;
                    }

                    public final void run() {
                        if (this.kkb.kka.kjV != null) {
                            this.kkb.kka.kjV.gG(false);
                        }
                    }
                });
            }
        }
    };
    g kjV;
    private d kjW = new d();
    public c kjX = new c();
    private e kjY;
    f kjZ;

    public static b aZV() {
        b bVar = (b) ak.yP().fY("plugin.talkroom");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        ak.yP().a("plugin.talkroom", bVar);
        return bVar;
    }

    public static g aZW() {
        if (aZV().kjV == null) {
            aZV().kjV = new g();
        }
        return aZV().kjV;
    }

    public static e aZX() {
        if (aZV().kjY == null) {
            aZV().kjY = new e();
        }
        return aZV().kjY;
    }

    public static String aZY() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.xp()).append("talkroom/").toString();
    }

    public static f aZZ() {
        if (aZV().kjZ == null) {
            aZV().kjZ = new f();
        }
        return aZV().kjZ;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(56), this.kjW);
        ak.a(this.ixZ);
        j.a.lxG = aZX();
        j.a.lxH = aZW();
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        d.c.aw(Integer.valueOf(56));
        ak.b(this.ixZ);
        j.a.lxG = null;
        j.a.lxH = null;
        if (this.kjV != null) {
            this.kjV.awO();
            this.kjV = null;
        }
    }
}
