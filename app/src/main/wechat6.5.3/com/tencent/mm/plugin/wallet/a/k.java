package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.a;
import java.io.File;
import java.util.HashMap;

public class k implements ag {
    private i kHY = new i();
    private r kHZ = new r();
    private j kIa = new j();
    private f kIb = new f();

    static {
        com.tencent.mm.compatible.util.k.b("wechatBankCardRecog", k.class.getClassLoader());
        a.b("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
        a.b("BindCardProcess", b.class);
    }

    public k() {
        File file = new File(com.tencent.mm.plugin.wallet_core.c.b.bgQ());
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static k beN() {
        k kVar = (k) ak.yP().fY("plugin.wallet");
        if (kVar != null) {
            return kVar;
        }
        v.w("MicroMsg.SubCoreMMWallet", "not found in MMCore, new one");
        kVar = new k();
        ak.yP().a("plugin.wallet", kVar);
        return kVar;
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.c.a.nhr.e(this.kHY);
        com.tencent.mm.sdk.c.a.nhr.e(this.kHZ);
        com.tencent.mm.sdk.c.a.nhr.e(this.kIa.kHU);
        com.tencent.mm.sdk.c.a.nhr.e(this.kIa.kHV);
        com.tencent.mm.sdk.c.a.nhr.e(this.kIa.kHW);
        com.tencent.mm.sdk.c.a.nhr.e(this.kIb);
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.kHY);
        com.tencent.mm.sdk.c.a.nhr.f(this.kHZ);
        com.tencent.mm.sdk.c.a.nhr.f(this.kIa.kHU);
        com.tencent.mm.sdk.c.a.nhr.f(this.kIa.kHV);
        com.tencent.mm.sdk.c.a.nhr.f(this.kIa.kHW);
        com.tencent.mm.sdk.c.a.nhr.f(this.kIb);
    }

    public static ab beO() {
        return com.tencent.mm.plugin.wallet_core.model.k.bga();
    }

    public static String Fk() {
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(6, null);
        String vl = al.vl(str);
        if (be.kS(str)) {
            return "";
        }
        return str.substring(vl.length() + 1);
    }

    public static String beP() {
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(6, null);
        if (be.kS(str)) {
            str = "";
        } else {
            str = al.vl(str.replace("+", ""));
        }
        if (!be.kS(str)) {
            return str;
        }
        if (com.tencent.mm.model.k.xT()) {
            return "27";
        }
        return "86";
    }
}
