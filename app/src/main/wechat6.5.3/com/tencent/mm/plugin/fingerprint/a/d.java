package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b.m;
import java.util.Map;

public final class d extends a {
    b fTA = null;
    private com.b.a.a fTy = null;
    private a fTz = new a();

    private class a implements com.b.a.a.b {
        final /* synthetic */ d fTB;

        private a(d dVar) {
            this.fTB = dVar;
        }

        public final void ap(int i, int i2) {
            if (this.fTB.fTA != null) {
                this.fTB.fTA.ap(i, i2);
            }
        }
    }

    public final boolean ant() {
        boolean z;
        boolean z2;
        int[] mX = com.b.a.a.mX();
        if (mX != null) {
            for (int i : mX) {
                if (1 == i) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (p.ceE.ceP == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v.i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z && z2) {
            return true;
        }
        return false;
    }

    public final boolean anu() {
        this.fTy = com.b.a.a.mV();
        int[] mW = mW();
        if (mW == null || mW.length <= 0) {
            v.e("MicroMsg.FingerPrintMgrImpl", "ids is null");
        }
        any();
        return mW != null && mW.length > 0;
    }

    private int[] mW() {
        if (this.fTy != null) {
            return this.fTy.mW();
        }
        v.i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
        return null;
    }

    public final void bK(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.fingerprint.FingerprintSettings");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public final void anv() {
        v.i("MicroMsg.FingerPrintMgrImpl", "initFP");
        if (ant()) {
            z bgz = k.bga().bgz();
            if (bgz == null || bgz.bgp()) {
                final ac acVar = new ac(Looper.myLooper());
                v.i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
                e.a(new Runnable(this) {
                    final /* synthetic */ d fTB;

                    public final void run() {
                        if (!e.anK()) {
                            try {
                                Context context = aa.getContext();
                                v.i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
                                if (!c.anp()) {
                                    v.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
                                } else if (e.bM(context) != 0) {
                                    e.de(false);
                                    v.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
                                } else {
                                    e.de(true);
                                    v.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
                                }
                            } catch (Throwable e) {
                                v.a("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                                v.e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + e.getMessage());
                                e.de(false);
                            }
                        }
                        if (!e.anL()) {
                            try {
                                ClassLoader classLoader = com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
                                if (TextUtils.isEmpty(com.tencent.mm.compatible.util.k.dv("teec"))) {
                                    v.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
                                    e.df(false);
                                } else {
                                    v.i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
                                    com.tencent.mm.compatible.util.k.b("fingerprintauth", classLoader);
                                    e.df(true);
                                }
                            } catch (UnsatisfiedLinkError e2) {
                                v.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                                e.df(false);
                            } catch (Throwable e3) {
                                v.a("MicroMsg.FingerPrintMgrImpl", e3, "", new Object[0]);
                                v.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e3.getMessage());
                                e.df(false);
                            }
                        }
                        acVar.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 fTC;

                            {
                                this.fTC = r1;
                            }

                            public final void run() {
                                try {
                                    v.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
                                    if (!e.anx()) {
                                        v.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
                                    } else if (k.bga().bgs() || k.bga().bgw()) {
                                        v.e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
                                    } else {
                                        try {
                                            String userId = e.getUserId();
                                            v.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:" + userId);
                                            CharSequence rsaKey = FingerPrintAuth.getRsaKey(e.bL(aa.getContext()), userId, p.rK());
                                            if (TextUtils.isEmpty(rsaKey)) {
                                                v.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
                                                rsaKey = FingerPrintAuth.genRsaKey(e.bL(aa.getContext()), e.getUserId(), p.rK());
                                            }
                                            if (TextUtils.isEmpty(rsaKey)) {
                                                v.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
                                            } else {
                                                v.e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
                                            }
                                        } catch (UnsatisfiedLinkError e) {
                                            v.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e.getMessage());
                                        } catch (Throwable e2) {
                                            v.a("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                                            v.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e2.getMessage());
                                        }
                                    }
                                } catch (UnsatisfiedLinkError e3) {
                                    v.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + e3.getMessage());
                                } catch (Throwable e22) {
                                    v.a("MicroMsg.FingerPrintMgrImpl", e22, "", new Object[0]);
                                    v.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + e22.getMessage());
                                }
                            }
                        });
                    }
                }, getClass().getName());
                return;
            }
            v.e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
            return;
        }
        v.e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
    }

    public final boolean anw() {
        return true;
    }

    public final boolean anx() {
        return e.anx();
    }

    public final int a(b bVar, int i, boolean z) {
        if (this.fTy == null) {
            this.fTy = com.b.a.a.mV();
        }
        if (this.fTy == null) {
            return -1;
        }
        this.fTA = bVar;
        this.fTy = com.b.a.a.mV();
        return this.fTy.a(this.fTz, 0, mW());
    }

    public final void any() {
        this.fTA = null;
        if (this.fTy != null) {
            try {
                com.b.a.a aVar = this.fTy;
                if (aVar.aGJ != null) {
                    aVar.aGJ.removeMessages(8);
                }
                try {
                    aVar.aGH.b(aVar.aGI);
                    aVar.aGH.asBinder().unlinkToDeath(aVar.aGN, 0);
                } catch (RemoteException e) {
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.FingerPrintMgrImpl", e2, "", new Object[0]);
                v.i("MicroMsg.FingerPrintMgrImpl", "auth systemRelease occur exception e:" + e2.getMessage());
            }
            this.fTy = null;
            return;
        }
        v.i("MicroMsg.FingerPrintMgrImpl", "systemRelease auth == null");
    }

    public final void anz() {
        if (this.fTy != null) {
            try {
                this.fTy.abort();
            } catch (Throwable e) {
                v.a("MicroMsg.FingerPrintMgrImpl", e, "", new Object[0]);
                v.i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + e.getMessage());
            }
        }
    }

    public final void a(jm jmVar, int i) {
        Object genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.bL(aa.getContext()), e.getUserId(), p.rK(), String.valueOf(i), m.bLf(), jmVar != null ? jmVar.bjR.bfr : "", Build.MODEL);
        Object genOpenFPSign = FingerPrintAuth.genOpenFPSign(e.bL(aa.getContext()), e.getUserId(), p.rK(), genPayFPEncrypt);
        if (TextUtils.isEmpty(genPayFPEncrypt)) {
            v.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
        } else {
            v.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
        }
        if (TextUtils.isEmpty(genOpenFPSign)) {
            v.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
        } else {
            v.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
        }
        v.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
        if (jmVar != null && jmVar.bjR.bjU != null) {
            jm.b bVar = new jm.b();
            bVar.errCode = 0;
            bVar.bfs = genPayFPEncrypt;
            bVar.bft = genOpenFPSign;
            bVar.bfq = i;
            jmVar.bjS = bVar;
            jmVar.bjR.bjU.run();
        }
    }

    public final void anA() {
        v.e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
    }

    public final g ans() {
        return new g();
    }

    public final Map<String, String> anB() {
        return null;
    }

    public final h anC() {
        return null;
    }

    public final Map<String, String> anD() {
        return null;
    }

    public final boolean anE() {
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        return false;
    }

    public final void anq() {
        anz();
        any();
    }
}
