package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.fingerprint.a.c;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

@a(7)
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    LinearLayout eZK = null;
    private b fTA = new b(this) {
        final /* synthetic */ FingerPrintAuthTransparentUI fUw;

        {
            this.fUw = r1;
        }

        public final void ap(int i, int i2) {
            switch (i) {
                case 0:
                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                    this.fUw.fUs = i2;
                    FingerPrintAuthTransparentUI.a(this.fUw);
                    return;
                case 2001:
                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                    return;
                case 2002:
                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    FingerPrintAuthTransparentUI.b(this.fUw);
                    this.fUw.dh(true);
                    return;
                case 2005:
                case 2007:
                case 10308:
                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    String string = aa.getContext().getString(2131235586);
                    if (i == 10308) {
                        string = aa.getContext().getString(2131235587);
                        com.tencent.mm.pluginsdk.f.a.b(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.pluginsdk.f.a.b(BaseReportManager.MAX_READ_COUNT, -1000223, i, "fingerprint error");
                    }
                    this.fUw.M(-1, string);
                    return;
                default:
                    return;
            }
        }
    };
    private i fUp = null;
    Dialog fUq;
    private g fUr = null;
    private int fUs = -1;
    private Animation fUt;
    private int fUu = 0;
    private boolean fUv = false;

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        fingerPrintAuthTransparentUI.fUv = false;
        com.tencent.mm.plugin.fingerprint.a.ank();
        com.tencent.mm.plugin.fingerprint.a.anl();
        c.release();
        fingerPrintAuthTransparentUI.fUp.dismiss();
        fingerPrintAuthTransparentUI.fUr.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.fUs, 2);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.fUu > 1) {
            fingerPrintAuthTransparentUI.fUu = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.eZK.findViewById(2131755290)).setVisibility(8);
            final TextView textView = (TextView) fingerPrintAuthTransparentUI.eZK.findViewById(2131757043);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.fUt == null) {
                fingerPrintAuthTransparentUI.fUt = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.nDR.nEl, 2130968624);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.fUt);
            ad.g(new Runnable(fingerPrintAuthTransparentUI) {
                final /* synthetic */ FingerPrintAuthTransparentUI fUw;

                public final void run() {
                    textView.setVisibility(0);
                }
            }, fingerPrintAuthTransparentUI.fUt.getDuration());
        }
    }

    static /* synthetic */ void c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        v.i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.eZK = (LinearLayout) View.inflate(fingerPrintAuthTransparentUI, 2130903644, null);
        ViewParent parent = fingerPrintAuthTransparentUI.eZK.getParent();
        ViewGroup viewGroup = parent != null ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.eZK.findViewById(2131757042)).setOnClickListener(new OnClickListener(fingerPrintAuthTransparentUI) {
            final /* synthetic */ FingerPrintAuthTransparentUI fUw;

            {
                this.fUw = r1;
            }

            public final void onClick(View view) {
                if (this.fUw.fUp != null) {
                    this.fUw.fUp.cancel();
                }
                FingerPrintAuthTransparentUI.anT();
                this.fUw.finish();
            }
        });
        if (fingerPrintAuthTransparentUI.fUp != null && fingerPrintAuthTransparentUI.fUp.isShowing()) {
            fingerPrintAuthTransparentUI.fUp.dismiss();
            fingerPrintAuthTransparentUI.fUp = null;
        }
        fingerPrintAuthTransparentUI.fUp = new i(fingerPrintAuthTransparentUI, 2131559266);
        fingerPrintAuthTransparentUI.fUp.setContentView(fingerPrintAuthTransparentUI.eZK);
        fingerPrintAuthTransparentUI.fUp.setCancelable(true);
        fingerPrintAuthTransparentUI.fUp.show();
        fingerPrintAuthTransparentUI.fUp.setOnCancelListener(new OnCancelListener(fingerPrintAuthTransparentUI) {
            final /* synthetic */ FingerPrintAuthTransparentUI fUw;

            {
                this.fUw = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.anT();
                this.fUw.finish();
            }
        });
        com.tencent.mm.ui.base.g.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.fUp);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        if (!e.anx()) {
            v.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
        } else if (k.xT()) {
            v.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
        } else if (e.anJ()) {
            v.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFP is true, finish UI!");
            finish();
        } else {
            com.tencent.mm.plugin.fingerprint.a.ank();
            com.tencent.mm.plugin.fingerprint.a.anl();
            if (c.anr()) {
                if (p.ceE.ceP != 1) {
                    v.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
                    finish();
                }
                ab bga = com.tencent.mm.plugin.wallet_core.model.k.bga();
                com.tencent.mm.plugin.fingerprint.a.ank();
                com.tencent.mm.plugin.fingerprint.a.anl();
                this.fUr = c.ans();
                if (!bga.bgv() || bga.bgx()) {
                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + bga.bgv() + ";isOpenTouch:" + bga.bgx());
                    v.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                    finish();
                    return;
                }
                v.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
                com.tencent.mm.plugin.report.service.g.iuh.h(12924, new Object[]{Integer.valueOf(1)});
                com.tencent.mm.pluginsdk.f.a.tr(0);
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.nqc, Boolean.valueOf(true));
                com.tencent.mm.ui.base.g.a(this, getString(2131233193), "", getString(2131231557), getString(2131231010), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FingerPrintAuthTransparentUI fUw;

                    {
                        this.fUw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FingerPrintAuthTransparentUI.c(this.fUw);
                        Bundle ad = com.tencent.mm.wallet_core.a.ad(this.fUw);
                        String str = "";
                        if (ad != null) {
                            str = ad.getString("key_pwd1");
                        }
                        this.fUw.fUr.a(this.fUw, new com.tencent.mm.pluginsdk.wallet.a(this) {
                            final /* synthetic */ AnonymousClass4 fUx;

                            {
                                this.fUx = r1;
                            }

                            public final void K(int i, String str) {
                                this.fUx.fUw.cg(false);
                                if (i == 0) {
                                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                                    this.fUx.fUw.dh(false);
                                    return;
                                }
                                this.fUx.fUw.M(-1, str);
                            }
                        }, str);
                        this.fUw.cg(true);
                        dialogInterface.dismiss();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FingerPrintAuthTransparentUI fUw;

                    {
                        this.fUw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.pluginsdk.f.a.b(1, -1000223, -1, "user cancelled");
                        this.fUw.finish();
                    }
                });
                return;
            }
            v.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.fUv) {
            dh(false);
        }
    }

    public void onPause() {
        super.onPause();
        WakeLock newWakeLock = ((PowerManager) this.nDR.nEl.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        anT();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    private void dh(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.ank();
        com.tencent.mm.plugin.fingerprint.a.anl();
        c.abort();
        c.release();
        if (!c.anr()) {
            v.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        } else if (c.a(this.fTA, z) != 0) {
            v.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
        }
    }

    private static void anT() {
        v.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.ank();
        if (com.tencent.mm.plugin.fingerprint.a.anl() != null) {
            c.anq();
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return this.fUr.d(i, i2, str, kVar);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void finish() {
        if (this.fUr != null) {
            this.fUr.clear();
        }
        super.finish();
    }

    private void M(int i, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = getString(-1);
        } else {
            string = str;
        }
        com.tencent.mm.ui.base.g.a(this, string, "", getString(2131233285), false, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FingerPrintAuthTransparentUI fUw;

            {
                this.fUw = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
                dialogInterface.dismiss();
                this.fUw.finish();
            }
        });
    }

    protected final void cg(boolean z) {
        if (z) {
            this.fUq = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else if (this.fUq != null && this.fUq.isShowing()) {
            this.fUq.dismiss();
            this.fUq = null;
        }
    }

    public void onDestroy() {
        if (this.fUp != null && this.fUp.isShowing()) {
            this.fUp.dismiss();
            this.fUp = null;
        }
        if (this.fUt != null) {
            this.fUt.cancel();
        }
        cg(false);
        super.onDestroy();
    }

    protected final int NO() {
        return 1;
    }

    public final void K(int i, String str) {
        cg(false);
        if (i == 0) {
            v.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            b(new l(null), false);
            com.tencent.mm.ui.base.g.a(this, "", getString(2131233285), (LinearLayout) View.inflate(this, 2130903643, null), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerPrintAuthTransparentUI fUw;

                {
                    this.fUw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
                    this.fUw.finish();
                }
            });
        } else if (i == -2) {
            String string;
            v.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            if (TextUtils.isEmpty(str)) {
                string = getString(2131232833);
            } else {
                string = str;
            }
            com.tencent.mm.ui.base.g.a(this, string, "", getString(2131232838), getString(2131231010), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerPrintAuthTransparentUI fUw;

                {
                    this.fUw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
                    FingerPrintAuthTransparentUI.c(this.fUw);
                    this.fUw.dh(false);
                    dialogInterface.dismiss();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ FingerPrintAuthTransparentUI fUw;

                {
                    this.fUw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.fUw.finish();
                }
            });
        } else {
            M(-1, str);
        }
    }
}
