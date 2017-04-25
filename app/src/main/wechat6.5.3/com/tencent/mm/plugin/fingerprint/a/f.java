package com.tencent.mm.plugin.fingerprint.a;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.fx;
import com.tencent.mm.e.a.fx.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.m;

public final class f extends c<fx> implements e {
    private fx fTE;
    private int fTF;
    private String fTG;
    ac fTH;
    private boolean fTx;

    private class a implements com.tencent.mm.plugin.fingerprint.a.n.a {
        final /* synthetic */ f fTI;

        private a(f fVar) {
            this.fTI = fVar;
        }

        public final void tp(final String str) {
            this.fTI.fTH.post(new Runnable(this) {
                final /* synthetic */ a fTK;

                public final void run() {
                    if (TextUtils.isEmpty(str)) {
                        v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
                    }
                    ak.vy().a(new com.tencent.mm.plugin.fingerprint.b.e(str), 0);
                }
            });
        }
    }

    public f() {
        this.fTF = 0;
        this.fTG = "";
        this.fTx = false;
        this.fTH = new ac(Looper.getMainLooper());
        this.nhz = fx.class.getName().hashCode();
    }

    private boolean a(fx fxVar) {
        if (ak.uz()) {
            v.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
            this.fTx = false;
            if (!(fxVar instanceof fx)) {
                return false;
            }
            if (e.anx()) {
                this.fTE = fxVar;
                ak.vy().a(385, this);
                boolean z = this.fTE.bfn.bfp;
                this.fTF = this.fTE.bfn.bfq;
                this.fTG = this.fTE.bfn.bfr;
                if (z) {
                    v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                    z = true;
                } else {
                    Object rsaKey = FingerPrintAuth.getRsaKey(e.bL(aa.getContext()), e.getUserId(), p.rK());
                    if (TextUtils.isEmpty(rsaKey)) {
                        v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                        z = true;
                    } else {
                        v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                        ak.vy().a(new com.tencent.mm.plugin.fingerprint.b.e(rsaKey), 0);
                        z = false;
                    }
                }
                if (z) {
                    v.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                    new n(new a()).anR();
                }
                return true;
            }
            v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
            b bVar = new b();
            bVar.bbq = false;
            this.fTE.bfo = bVar;
            this.fTx = true;
            ZH();
            return true;
        }
        v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.b.e) {
            b bVar = new b();
            bVar.bbq = false;
            v.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                com.tencent.mm.plugin.fingerprint.b.e eVar = (com.tencent.mm.plugin.fingerprint.b.e) kVar;
                String str2 = eVar.fTO;
                String str3 = eVar.bft;
                String userId = e.getUserId();
                String rK = p.rK();
                String bLf = m.bLf();
                if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.bL(aa.getContext()), userId, rK, String.valueOf(this.fTF), bLf, "", str2, str3, Build.MODEL))) {
                    v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                } else {
                    v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    bVar.bbq = true;
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.bL(aa.getContext()), userId, rK, String.valueOf(this.fTF), bLf, this.fTG, Build.MODEL);
                userId = FingerPrintAuth.genOpenFPSign(e.bL(aa.getContext()), e.getUserId(), p.rK(), genPayFPEncrypt);
                bVar.bfs = genPayFPEncrypt;
                bVar.bft = userId;
            } else {
                v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            ak.vy().b(385, this);
            this.fTE.bfo = bVar;
            this.fTx = true;
            ZH();
        }
    }

    private void ZH() {
        v.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.fTE.bpT != null) {
            this.fTE.bpT.run();
        }
        if (this.fTx) {
            this.fTE = null;
        }
    }
}
