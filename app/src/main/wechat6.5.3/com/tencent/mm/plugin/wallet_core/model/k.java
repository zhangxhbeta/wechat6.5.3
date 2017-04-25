package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.az;
import com.tencent.mm.e.a.lm;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.c.g;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.i;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k implements ag {
    private static HashMap<Integer, c> bXq;
    private m kPR = new m();
    private ab kPS = null;
    private i kPT = null;
    private com.tencent.mm.plugin.wallet_core.c.c kPU = null;
    private v kPV = null;
    private y kPW = null;
    private a kPX = null;
    private f kPY = null;
    private d kPZ = null;
    private q kQa = new q();
    private e kQb = null;
    private h kQc = null;
    private g kQd = null;
    private com.tencent.mm.plugin.wallet_core.id_verify.util.a kQe = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    private com.tencent.mm.sdk.c.c kQf = new com.tencent.mm.sdk.c.c<lm>(this) {
        final /* synthetic */ k kQi;

        {
            this.kQi = r2;
            this.nhz = lm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            lm lmVar = (lm) bVar;
            k.q(lmVar.bmR.context, lmVar.bmR.intent);
            return true;
        }
    };
    private com.tencent.mm.sdk.c.c kQg = new com.tencent.mm.sdk.c.c<az>(this) {
        final /* synthetic */ k kQi;

        {
            this.kQi = r2;
            this.nhz = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.wallet_core.b.a.bKZ();
            com.tencent.mm.wallet_core.b.a.clean();
            return false;
        }
    };
    private bo.b kQh = new bo.b(this) {
        final /* synthetic */ k kQi;

        {
            this.kQi = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            Map q = bf.q(m.a(aVar.czu.mbW), "sysmsg");
            if (q != null) {
                int i = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                v.i("MicroMsg.SubCoreNfc", "got a pay msg, type = " + i);
                switch (i) {
                    case 16:
                        i = be.getInt((String) q.get(".sysmsg.paymsg.Flag"), 0);
                        v.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                        if (i == 1) {
                            v.i("MicroMsg.SubCoreNfc", "open wallet");
                            com.tencent.mm.model.k.xP();
                            return;
                        } else if (i == 2) {
                            v.i("MicroMsg.SubCoreNfc", "close wallet");
                            i = com.tencent.mm.model.k.xL() & -32769;
                            com.tencent.mm.kernel.g.vx();
                            com.tencent.mm.kernel.g.vw().vf().set(40, Integer.valueOf(i));
                            return;
                        } else {
                            return;
                        }
                    case 17:
                        i = be.getInt((String) q.get(".sysmsg.paymsg.WalletType"), -1);
                        v.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                        if (i >= 0) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(339975, Integer.valueOf(i));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };

    static {
        com.tencent.mm.compatible.util.k.b("tenpay_utils", k.class.getClassLoader());
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return i.cic;
            }
        });
        bXq.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.wallet_core.c.c.cic;
            }
        });
        bXq.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return a.cic;
            }
        });
        bXq.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return f.cic;
            }
        });
        bXq.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        bXq.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return g.cic;
            }
        });
        bXq.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return e.cic;
            }
        });
        bXq.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return h.cic;
            }
        });
    }

    public static k bfW() {
        k kVar = (k) ak.yP().fY("plugin.wallet_core");
        if (kVar != null) {
            return kVar;
        }
        v.w("MicroMsg.SubCoreNfc", "[NFC]not found in MMCore, new one");
        kVar = new k();
        ak.yP().a("plugin.wallet_core", kVar);
        return kVar;
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public static i bfX() {
        if (ak.uz()) {
            if (bfW().kPT == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kPT = new i(com.tencent.mm.model.c.wE());
            }
            return bfW().kPT;
        }
        throw new com.tencent.mm.model.b();
    }

    public static com.tencent.mm.plugin.wallet_core.c.c bfY() {
        if (ak.uz()) {
            if (bfW().kPU == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kPU = new com.tencent.mm.plugin.wallet_core.c.c(com.tencent.mm.model.c.wE());
            }
            return bfW().kPU;
        }
        throw new com.tencent.mm.model.b();
    }

    public static g bfZ() {
        if (ak.uz()) {
            if (bfW().kQd == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kQd = new g(com.tencent.mm.model.c.wE());
            }
            return bfW().kQd;
        }
        throw new com.tencent.mm.model.b();
    }

    public static ab bga() {
        if (ak.uz()) {
            if (bfW().kPS == null) {
                bfW().kPS = new ab();
            }
            return bfW().kPS;
        }
        throw new com.tencent.mm.model.b();
    }

    public static y bgb() {
        if (ak.uz()) {
            if (bfW().kPW == null) {
                bfW().kPW = new y();
            }
            return bfW().kPW;
        }
        throw new com.tencent.mm.model.b();
    }

    public static a bgc() {
        if (ak.uz()) {
            if (bfW().kPX == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kPX = new a(com.tencent.mm.model.c.wE());
            }
            return bfW().kPX;
        }
        throw new com.tencent.mm.model.b();
    }

    public static f bgd() {
        if (ak.uz()) {
            if (bfW().kPY == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kPY = new f(com.tencent.mm.model.c.wE());
            }
            return bfW().kPY;
        }
        throw new com.tencent.mm.model.b();
    }

    public static d bge() {
        if (ak.uz()) {
            if (bfW().kPZ == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kPZ = new d(com.tencent.mm.model.c.wE());
            }
            return bfW().kPZ;
        }
        throw new com.tencent.mm.model.b();
    }

    public static e bgf() {
        if (ak.uz()) {
            if (bfW().kQb == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kQb = new e(com.tencent.mm.model.c.wE());
            }
            return bfW().kQb;
        }
        throw new com.tencent.mm.model.b();
    }

    public static h bgg() {
        if (ak.uz()) {
            if (bfW().kQc == null) {
                k bfW = bfW();
                ak.yW();
                bfW.kQc = new h(com.tencent.mm.model.c.wE());
            }
            return bfW().kQc;
        }
        throw new com.tencent.mm.model.b();
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public static v bgh() {
        return bfW().kPV;
    }

    public final void aG(boolean z) {
        com.tencent.mm.wallet_core.b.a.bKZ();
        com.tencent.mm.wallet_core.b.a.init(aa.getContext());
        ak.yU().a("paymsg", this.kQh, true);
        bga().bgF();
        this.kPV = v.bgk();
        ak.yU().a("paymsg", this.kPV.eWu, true);
        com.tencent.mm.sdk.c.a.nhr.e(this.kQf);
        com.tencent.mm.sdk.c.a.nhr.e(this.kQa);
        com.tencent.mm.sdk.c.a.nhr.d(this.kQg);
    }

    public final void th() {
        ak.yU().b("paymsg", this.kQh, true);
        bga().amB();
        y bgb = bgb();
        bgb.kQO = null;
        bgb.kQN.clear();
        bgb.kQN = new ArrayList();
        ak.yU().b("paymsg", this.kPV.eWu, true);
        if (v.kQu != null) {
            v.kQu.clear();
        }
        this.kPV = null;
        com.tencent.mm.sdk.c.a.nhr.f(this.kQf);
        com.tencent.mm.sdk.c.a.nhr.f(this.kQa);
        com.tencent.mm.sdk.c.a.nhr.f(this.kQg);
    }

    public static void q(Context context, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (com.tencent.mm.model.k.xU()) {
            intent.setFlags(536870912);
            v.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is h5,jump to ibg");
            com.tencent.mm.ay.c.b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
        } else if (com.tencent.mm.model.k.xV()) {
            intent.setFlags(536870912);
            com.tencent.mm.ay.c.b(context, "mall", ".ui.MallIndexOSUI", intent);
        } else {
            v.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is native");
            intent.setFlags(536870912);
            com.tencent.mm.ay.c.b(context, "mall", ".ui.MallIndexUI", intent);
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ak.vy().a(new com.tencent.mm.al.k(11), 0);
            }
        }
    }

    public static m bgi() {
        return bfW().kPR;
    }

    public static boolean b(MMActivity mMActivity, int i, com.tencent.mm.wallet_core.c.b bVar, com.tencent.mm.plugin.wallet_core.id_verify.util.a.a aVar, int i2) {
        return bfW().kQe.a(mMActivity, i, bVar, aVar, i2);
    }
}
