package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.soter.c.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;
import java.security.Signature;
import org.json.JSONObject;

public final class k implements g {
    a fTL = null;
    private a fTM = null;
    String fTP = "";
    WeakReference<WalletBaseUI> fUd = null;

    public final void a(Context context, a aVar, String str) {
        v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.fUd = new WeakReference((WalletBaseUI) context);
        this.fTL = aVar;
        this.fTP = str;
        ((WalletBaseUI) this.fUd.get()).gQ(1586);
        ((WalletBaseUI) this.fUd.get()).gQ(1665);
        ((WalletBaseUI) this.fUd.get()).gQ(1638);
        com.tencent.mm.pluginsdk.f.a.bmI();
        v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        f.a((Context) this.fUd.get(), e.anF(), new d(this) {
            final /* synthetic */ k fUe;

            {
                this.fUe = r1;
            }

            public final void h(int i, String str, String str2) {
                int optInt;
                Throwable e;
                int i2 = -1000223;
                v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key end: errCode: %d, errMsg: %s, extras: %s", new Object[]{Integer.valueOf(i), str, str2});
                if (i == 0) {
                    v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key ok: start upload");
                    h Cn = com.tencent.mm.plugin.soter.c.k.Cn(e.anF());
                    if (Cn == null || be.kS(Cn.kdf) || be.kS(Cn.bCj)) {
                        v.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                        com.tencent.mm.pluginsdk.f.a.b(4, -1000223, -1, "gen ask failed: unexpected! generated but cannot get");
                        this.fUe.fTL.K(-1, str);
                        return;
                    } else if (this.fUe.fUd.get() != null) {
                        ((WalletBaseUI) this.fUe.fUd.get()).b(new c(this.fUe.fTP, Cn), false);
                        return;
                    } else {
                        return;
                    }
                }
                v.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                if (i == 4) {
                    com.tencent.mm.pluginsdk.f.a.b(2, -1000223, -1, "gen ask failed");
                } else if (i == 6) {
                    String str3 = "upload ask failed";
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        i2 = jSONObject.optInt("err_type");
                        optInt = jSONObject.optInt("err_code");
                        try {
                            str3 = jSONObject.optString("err_msg");
                        } catch (Exception e2) {
                            e = e2;
                            v.a("MicroMsg.SoterFingerprintOpenDelegate", e, "hy: exception occurs when parsing extra json", new Object[0]);
                            com.tencent.mm.pluginsdk.f.a.b(3, i2, optInt, str3);
                            this.fUe.fTL.K(-1, str);
                        }
                    } catch (Throwable e3) {
                        e = e3;
                        optInt = -1;
                        v.a("MicroMsg.SoterFingerprintOpenDelegate", e, "hy: exception occurs when parsing extra json", new Object[0]);
                        com.tencent.mm.pluginsdk.f.a.b(3, i2, optInt, str3);
                        this.fUe.fTL.K(-1, str);
                    }
                    com.tencent.mm.pluginsdk.f.a.b(3, i2, optInt, str3);
                } else if (i == 5) {
                    com.tencent.mm.pluginsdk.f.a.b(4, -1000223, -1, "gen auth key failed");
                } else {
                    com.tencent.mm.pluginsdk.f.a.b(BaseReportManager.MAX_READ_COUNT, -1000223, i, str);
                }
                this.fUe.fTL.K(-1, str);
            }
        }, true);
    }

    public final void clear() {
        v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.fUd == null || this.fUd.get() == null)) {
            ((WalletBaseUI) this.fUd.get()).gR(1586);
            ((WalletBaseUI) this.fUd.get()).gR(1665);
            ((WalletBaseUI) this.fUd.get()).gR(1638);
        }
        this.fTL = null;
        this.fTL = null;
        o.kQn.reset();
        if (this.fUd != null && this.fUd.get() != null) {
            this.fUd.clear();
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (be.kS(str)) {
            str = ((WalletBaseUI) this.fUd.get()).getString(2131232833);
        }
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.b.a) {
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                if (be.kS(((com.tencent.mm.plugin.fingerprint.b.a) kVar).fUl)) {
                    this.fTL.K(-1, str);
                    return true;
                }
                ad.o(new Runnable(this) {
                    final /* synthetic */ k fUe;

                    {
                        this.fUe = r1;
                    }

                    public final void run() {
                        this.fUe.fTL.K(0, "");
                    }
                });
            } else {
                v.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                this.fTL.K(i2, str);
                com.tencent.mm.pluginsdk.f.a.b(7, i, i2, "get challenge failed");
                return true;
            }
        }
        if (kVar instanceof c) {
            if (i2 == 0 && i == 0) {
                v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key success");
                ((WalletBaseUI) this.fUd.get()).b(new com.tencent.mm.plugin.fingerprint.b.a(), false);
            } else {
                v.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove ");
                com.tencent.mm.plugin.soter.c.k.ar(e.anF(), true);
                com.tencent.mm.pluginsdk.f.a.b(5, i, i2, "upload auth key failed");
                ad.o(new Runnable(this) {
                    final /* synthetic */ k fUe;

                    public final void run() {
                        this.fUe.fTL.K(-1, str);
                    }
                });
            }
            return true;
        } else if (!(kVar instanceof b)) {
            return false;
        } else {
            if (i2 == 0 && i == 0) {
                v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
                com.tencent.mm.pluginsdk.f.a.bmJ();
                com.tencent.mm.pluginsdk.f.a.b(0, 0, 0, "OK");
                L(0, str);
            } else {
                v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
                com.tencent.mm.pluginsdk.f.a.b(8, i, i2, "open fp pay failed");
                L(-1, str);
            }
            return true;
        }
    }

    private void L(int i, String str) {
        v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.fTM.K(i, str);
        this.fTM = null;
    }

    public final void a(a aVar, String str, int i) {
        v.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.fTM = aVar;
        final Signature signature = o.kQn.kQo;
        if (signature != null) {
            e.a(new Runnable(this) {
                final /* synthetic */ k fUe;

                public final void run() {
                    try {
                        final i aE = com.tencent.mm.plugin.soter.c.k.aE(signature.sign());
                        if (aE != null) {
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 fUi;

                                public final void run() {
                                    if (this.fUi.fUe.fUd.get() != null) {
                                        ((WalletBaseUI) this.fUi.fUe.fUd.get()).j(new b(aE.kdn, aE.kdo, this.fUi.fUe.fTP));
                                    }
                                }
                            });
                        }
                    } catch (Throwable e) {
                        v.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: soter exception: %s", new Object[]{e.toString()});
                        v.a("MicroMsg.SoterFingerprintOpenDelegate", e, "hy: sign failed", new Object[0]);
                        com.tencent.mm.pluginsdk.f.a.b(9, -1000223, -1, "signature is null");
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 fUi;

                            {
                                this.fUi = r1;
                            }

                            public final void run() {
                                this.fUi.fUe.fTL.K(-1, ((WalletBaseUI) this.fUi.fUe.fUd.get()).getString(2131232833));
                            }
                        });
                    }
                }
            }, getClass().getName());
            return;
        }
        v.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: not set signature");
        this.fTL.K(-1, ((WalletBaseUI) this.fUd.get()).getString(2131232833));
        com.tencent.mm.pluginsdk.f.a.b(9, -1000223, -1, "signature is null");
    }
}
