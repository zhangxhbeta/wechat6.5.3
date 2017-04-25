package com.tencent.mm.plugin.fingerprint.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.soter.c.i;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.pluginsdk.l.a.c;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.security.Signature;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends a {
    private k fTY = null;
    private CancellationSignal fTZ = null;

    public final boolean ant() {
        boolean z;
        if (p.ceE.ceP == 1) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(k.cB(aa.getContext()))});
        return z && k.cB(aa.getContext());
    }

    public final boolean anu() {
        return k.cC(aa.getContext());
    }

    public final void anv() {
        v.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
        e.df(true);
        e.de(true);
    }

    public final boolean anw() {
        return false;
    }

    public final void bK(Context context) {
        v.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    }

    public final boolean anx() {
        return ant();
    }

    @TargetApi(16)
    public final int a(final b bVar, int i, boolean z) {
        if (!z || anP()) {
            this.fTZ = new CancellationSignal();
            f.a(aa.getContext(), o.kQn.fUl, e.anF(), new d(this) {
                final /* synthetic */ j fUb;

                public final void h(int i, String str, String str2) {
                    if (i != 0) {
                        if (i == 15) {
                            v.i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                            k.ar(e.anF(), true);
                            bVar.ap(2007, -1);
                        }
                        if (bVar != null) {
                            bVar.ap(2005, -1);
                        }
                    }
                }
            }, new com.tencent.mm.pluginsdk.l.b(this) {
                final /* synthetic */ j fUb;

                public final void s(int i, String str) {
                    v.e("MicroMsg.SoterAuthMgrImp", "hy: authenticate error: errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                    if (bVar == null) {
                        return;
                    }
                    if (i == 10308) {
                        v.i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                        bVar.ap(i, -1);
                        return;
                    }
                    bVar.ap(2005, -1);
                }

                public final void t(int i, String str) {
                    v.e("MicroMsg.SoterAuthMgrImp", "hy: onAuthenticationHelp error: helpMsg: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                    if (bVar != null) {
                        bVar.ap(2000, -1);
                    }
                }

                public final void a(String str, Signature signature) {
                    v.i("MicroMsg.SoterAuthMgrImp", "hy: onAuthenticationSucceeded");
                    o.kQn.kQo = signature;
                    if (bVar != null) {
                        bVar.ap(0, -1);
                    }
                }

                public final void kq(String str) {
                    v.e("MicroMsg.SoterAuthMgrImp", "hy:onAuthenticateFailed");
                    if (bVar != null) {
                        bVar.ap(2002, -1);
                    }
                }
            }, this.fTZ);
        } else {
            v.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
        }
        return 0;
    }

    private static boolean anP() {
        return VERSION.SDK_INT < 23;
    }

    @SuppressLint({"NewApi"})
    public final void any() {
        boolean z = true;
        if (anP()) {
            String str = "MicroMsg.SoterAuthMgrImp";
            String str2 = "hy: systemRelease mSignal is null: %b";
            Object[] objArr = new Object[1];
            if (this.fTZ != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.i(str, str2, objArr);
            if (this.fTZ != null) {
                this.fTZ.cancel();
                return;
            }
            return;
        }
        v.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    @SuppressLint({"NewApi"})
    public final void anz() {
        boolean z = true;
        if (anP()) {
            String str = "MicroMsg.SoterAuthMgrImp";
            String str2 = "hy: systemAbort mSignal is null: %b";
            Object[] objArr = new Object[1];
            if (this.fTZ != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.i(str, str2, objArr);
            if (this.fTZ != null) {
                this.fTZ.cancel();
                return;
            }
            return;
        }
        v.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    public final void a(jm jmVar, int i) {
        v.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
        jmVar.bjS.bjV = anQ();
        jmVar.bjS.errCode = !be.kS(jmVar.bjS.bjV) ? 0 : 1;
        jmVar.bjS.bfs = "";
        jmVar.bjS.bft = "";
        if (jmVar.bjR.bjU != null) {
            jmVar.bjR.bjU.run();
        }
    }

    private static String anQ() {
        Signature signature = o.kQn.kQo;
        if (signature != null) {
            try {
                i aE = k.aE(signature.sign());
                if (aE == null) {
                    v.e("MicroMsg.SoterAuthMgrImp", "hy: result is null");
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("json", aE.kdn);
                jSONObject.put("signature", aE.kdo);
                return jSONObject.toString();
            } catch (SignatureException e) {
                v.e("MicroMsg.SoterAuthMgrImp", "hy: error when sign: %s", new Object[]{e.toString()});
                return "";
            } catch (Throwable e2) {
                v.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[]{e2.toString()});
                v.a("MicroMsg.SoterAuthMgrImp", e2, "", new Object[0]);
                return "";
            }
        }
        v.e("MicroMsg.SoterAuthMgrImp", "hy: signature obj is null");
        return "";
    }

    public final void anA() {
        if (k.Cl(e.anF())) {
            k.ar(e.anF(), false);
        }
    }

    public final g ans() {
        this.fTY = new k();
        return this.fTY;
    }

    public final Map<String, String> anB() {
        Map<String, String> hashMap = new HashMap();
        c bol = e.bol();
        String str = bol.bgr;
        String str2 = bol.bgs;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        return hashMap;
    }

    public final h anC() {
        return new l();
    }

    public final Map<String, String> anD() {
        return anB();
    }

    public final boolean anE() {
        if (!(k.aYM() && k.Cl(e.anF()) && k.Cm(e.anF()))) {
            v.i("MicroMsg.SoterAuthMgrImp", "hy: no ask or auth key");
            o.kQn.fUm = true;
        }
        if (o.kQn.fUm) {
            return false;
        }
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        v.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (!z) {
            final String string = bundle.getString("pwd");
            if (be.kS(string)) {
                v.e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
            } else if (o.kQn.fUm) {
                v.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start process async");
                v.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start regen");
                f.a(aa.getContext(), e.anF(), new d(this) {
                    final /* synthetic */ j fUb;

                    public final void h(int i, String str, String str2) {
                        v.i("MicroMsg.SoterAuthMgrImp", "hy: gen auth key end: errCode: %d, errMsg: %s, extras: %s", new Object[]{Integer.valueOf(i), str, str2});
                        if (i == 0) {
                            v.i("MicroMsg.SoterAuthMgrImp", "hy: gen auth key ok: start upload");
                            com.tencent.mm.plugin.soter.c.h Cn = k.Cn(e.anF());
                            if (Cn == null || be.kS(Cn.kdf) || be.kS(Cn.bCj)) {
                                v.e("MicroMsg.SoterAuthMgrImp", "hy: failed upload: model is null or necessary elements null");
                            } else {
                                ak.vy().a(new com.tencent.mm.plugin.fingerprint.b.c(string, Cn), 0);
                            }
                        } else {
                            v.e("MicroMsg.SoterAuthMgrImp", "hy: gen auth key failed");
                        }
                        o.kQn.reset();
                    }
                }, true);
            }
        }
        return false;
    }

    public final boolean ano() {
        return (com.tencent.mm.plugin.soter.a.c.aYG() || com.tencent.mm.plugin.soter.a.c.aYF()) ? false : true;
    }

    public final void anq() {
        if (this.fTZ != null && VERSION.SDK_INT >= 16) {
            this.fTZ.cancel();
            if (a.bmL()) {
                a.b(1, -1000223, -1, "user cancelled");
            }
        }
    }
}
