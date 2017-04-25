package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.e.a.jm;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends c<jm> {
    private String fTG;
    private a fTT;
    jm fTU;
    private com.tencent.mm.pluginsdk.wallet.h fTV;
    private Runnable fTW;
    boolean fTx;

    public class a implements b {
        final /* synthetic */ h fTX;

        public a(h hVar) {
            this.fTX = hVar;
        }

        public final void ap(int i, int i2) {
            if (this.fTX.fTx) {
                v.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
                return;
            }
            switch (i) {
                case 0:
                    v.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                    h hVar = this.fTX;
                    v.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
                    hVar.fTx = true;
                    com.tencent.mm.plugin.fingerprint.a.ank();
                    com.tencent.mm.plugin.fingerprint.a.anl();
                    com.tencent.mm.pluginsdk.j.a.lxX.a(hVar.fTU, i2);
                    if (hVar.fTx) {
                        hVar.fTU = null;
                    }
                    v.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
                    h.anO();
                    return;
                case 2000:
                    v.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                    return;
                case 2001:
                    this.fTX.dg(false);
                    v.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                    return;
                case 2002:
                    v.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                    this.fTX.fTx = false;
                    h.anO();
                    this.fTX.dg(true);
                    this.fTX.J(1, "");
                    return;
                case 2004:
                case 2005:
                case 2007:
                case 10308:
                    v.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    this.fTX.fTx = true;
                    String string = aa.getContext().getString(2131235586);
                    if (i == 10308) {
                        string = aa.getContext().getString(2131235587);
                    } else if (i == 2007) {
                        o.kQn.fUm = true;
                    }
                    h.anO();
                    this.fTX.J(2, string);
                    return;
                default:
                    return;
            }
        }
    }

    public h() {
        this.fTV = null;
        this.fTW = null;
        this.fTx = false;
        this.fTG = "";
        this.nhz = jm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
        jm jmVar = (jm) bVar;
        if (ak.uz()) {
            this.fTx = false;
            if (jmVar instanceof jm) {
                v.i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (e.anx()) {
                    this.fTU = jmVar;
                    if (this.fTU == null) {
                        v.e("MicroMsg.OpenFingerPrintAuthEventListener", null, new Object[]{"mEvent is null !!!"});
                    } else {
                        this.fTW = this.fTU.bjR.bjU;
                        this.fTG = jmVar.bjR.bfr;
                        com.tencent.mm.plugin.fingerprint.a.ank();
                        if (com.tencent.mm.plugin.fingerprint.a.anl() == null) {
                            return true;
                        }
                        com.tencent.mm.plugin.fingerprint.a.ank();
                        com.tencent.mm.plugin.fingerprint.a.anl();
                        boolean anr = c.anr();
                        if (this.fTT == null) {
                            this.fTT = new a(this);
                        }
                        com.tencent.mm.plugin.fingerprint.a.ank();
                        com.tencent.mm.plugin.fingerprint.a.anl();
                        this.fTV = com.tencent.mm.pluginsdk.j.a.lxX.anC();
                        if (this.fTV == null) {
                            return dg(false);
                        }
                        this.fTV.a(new com.tencent.mm.pluginsdk.wallet.a(this) {
                            final /* synthetic */ h fTX;

                            {
                                this.fTX = r1;
                            }

                            public final void K(int i, String str) {
                                v.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                                if (i == 0) {
                                    this.fTX.dg(false);
                                } else {
                                    this.fTX.J(1, "");
                                }
                            }
                        });
                        return anr;
                    }
                }
                v.e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                this.fTx = true;
                J(1, "");
                return true;
            }
        }
        v.e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        return false;
    }

    public final void release() {
        com.tencent.mm.plugin.fingerprint.a.ank();
        if (com.tencent.mm.plugin.fingerprint.a.anl() != null) {
            com.tencent.mm.plugin.fingerprint.a.ank();
            com.tencent.mm.plugin.fingerprint.a.anl();
            c.release();
        }
        this.fTU = null;
    }

    public static void anO() {
        com.tencent.mm.plugin.fingerprint.a.ank();
        if (com.tencent.mm.plugin.fingerprint.a.anl() != null) {
            com.tencent.mm.plugin.fingerprint.a.ank();
            com.tencent.mm.plugin.fingerprint.a.anl();
            c.abort();
            com.tencent.mm.plugin.fingerprint.a.ank();
            com.tencent.mm.plugin.fingerprint.a.anl();
            c.release();
            v.i("MicroMsg.OpenFingerPrintAuthEventListener", "stopIdentify()");
        }
    }

    final boolean dg(boolean z) {
        anO();
        com.tencent.mm.plugin.fingerprint.a.ank();
        com.tencent.mm.plugin.fingerprint.a.anl();
        if (c.anr()) {
            com.tencent.mm.plugin.fingerprint.a.ank();
            com.tencent.mm.plugin.fingerprint.a.anl();
            if (c.a(this.fTT, z) != 0) {
                v.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
                release();
                this.fTx = true;
                J(1, "");
                return false;
            }
            v.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
            return true;
        }
        v.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
        release();
        this.fTx = true;
        J(1, "");
        return false;
    }

    final void J(int i, String str) {
        v.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        com.tencent.mm.plugin.fingerprint.a.ank();
        com.tencent.mm.plugin.fingerprint.a.anl();
        com.tencent.mm.pluginsdk.j.a.lxX.a(this.fTU, i, str);
        if (this.fTx) {
            this.fTU = null;
        }
        v.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    }
}
