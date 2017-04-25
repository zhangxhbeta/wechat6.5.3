package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements ag, e {
    ConcurrentHashMap<Integer, p> hii = new ConcurrentHashMap();
    private boolean hij = false;
    private b hik = new b(this) {
        final /* synthetic */ c hil;

        {
            this.hil = r1;
        }

        public final void a(a aVar) {
            final String a = m.a(aVar.czu.mbW);
            v.i("MicroMsg.SubCoreMall", "WalletNotifyConfXml:" + a);
            this.hil.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 him;

                public final void run() {
                    com.tencent.mm.plugin.wallet_core.model.mall.c bgL = com.tencent.mm.plugin.wallet_core.model.mall.c.bgL();
                    String str = a;
                    MallNews Di = com.tencent.mm.plugin.wallet_core.model.mall.c.Di(str);
                    if (Di == null) {
                        return;
                    }
                    if ("2".equals(Di.type)) {
                        v.d("MicroMsg.MallNewsManager", "removeNews : " + Di);
                        MallNews mallNews = (MallNews) bgL.kRx.get(Di.kRn);
                        if (mallNews != null && mallNews.keV.equals(Di.keV) && mallNews.bax.equals(Di.bax)) {
                            v.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + Di.kRn);
                            bgL.kRx.remove(Di.kRn);
                            return;
                        }
                        v.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
                        return;
                    }
                    bgL.kRx.put(Di.kRn, Di);
                    v.d("MicroMsg.MallNewsManager", "onRecieveMsg : " + str);
                    bgL.aGr();
                    if (Di.aXx == 0) {
                        v.d("MicroMsg.MallNewsManager", "showType New");
                        com.tencent.mm.p.c.us().s(262156, true);
                    } else if (Di.aXx == 1) {
                        v.d("MicroMsg.MallNewsManager", "showType Dot");
                        com.tencent.mm.p.c.us().t(262156, true);
                    }
                }
            });
        }
    };
    ac mHandler = new ac(Looper.getMainLooper());

    public static c ayF() {
        c cVar = (c) ak.yP().fY("plugin.mall");
        if (cVar != null) {
            return cVar;
        }
        v.w("MicroMsg.SubCoreMall", "not found in MMCore, new one");
        cVar = new c();
        ak.yP().a("plugin.mall", cVar);
        return cVar;
    }

    public final p mM(int i) {
        Object obj = null;
        if (!this.hii.contains(Integer.valueOf(i))) {
            com.tencent.mm.plugin.wallet_core.c.e bgf = k.bgf();
            String str = "select * from WalletFunciontList where wallet_region = " + i;
            Cursor rawQuery = bgf.cie.rawQuery(str, null);
            v.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo " + str);
            if (rawQuery != null) {
                if (rawQuery.getCount() == 0) {
                    rawQuery.close();
                } else {
                    if (rawQuery.moveToNext()) {
                        obj = new p();
                        obj.b(rawQuery);
                    }
                    rawQuery.close();
                }
            }
            if (obj != null) {
                this.hii.put(Integer.valueOf(i), obj);
            }
        }
        p pVar = (p) this.hii.get(Integer.valueOf(i));
        if (pVar == null) {
            return new p();
        }
        return pVar;
    }

    public final ArrayList<MallFunction> mN(int i) {
        return mM(i).hid;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        ak.yU().a("mallactivity", this.hik, true);
        com.tencent.mm.plugin.wallet_core.model.mall.c.bgL().NH();
        d.bgO().NH();
        if (com.tencent.mm.model.k.xT() && com.tencent.mm.model.k.xO()) {
            com.tencent.mm.plugin.wallet_core.model.mall.b.so(com.tencent.mm.plugin.wallet_core.model.mall.b.kRk);
        } else {
            com.tencent.mm.plugin.wallet_core.model.mall.b.so(com.tencent.mm.plugin.wallet_core.model.mall.b.kRj);
        }
        ak.vy().a(302, this);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        ak.yU().b("mallactivity", this.hik, true);
        ak.vy().b(302, this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i2 == 0 && i == 0 && !this.hij && com.tencent.mm.model.k.xT()) {
            this.hij = true;
            com.tencent.mm.plugin.wallet_core.model.mall.b.so(com.tencent.mm.plugin.wallet_core.model.mall.b.kRk);
        }
    }
}
