package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.fingerprint.a.c;
import com.tencent.mm.plugin.fingerprint.a.e;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private boolean cOX = false;
    private a fUA;
    private boolean fUB = false;
    private final int fUC = 1;
    private Dialog fUq = null;
    private g fUr = null;
    private Animation fUt;
    private int fUu = 0;
    private TextView fUy;
    private c fUz;

    public class a implements b {
        final /* synthetic */ FingerPrintAuthUI fUD;
        private WeakReference<FingerPrintAuthUI> fUG = null;

        public a(FingerPrintAuthUI fingerPrintAuthUI, FingerPrintAuthUI fingerPrintAuthUI2) {
            this.fUD = fingerPrintAuthUI;
            this.fUG = new WeakReference(fingerPrintAuthUI2);
        }

        private FingerPrintAuthUI anV() {
            if (this.fUG != null) {
                return (FingerPrintAuthUI) this.fUG.get();
            }
            return null;
        }

        public final void ap(int i, int i2) {
            switch (i) {
                case 0:
                    v.i("MicroMsg.FingerPrintAuthUI", "identify success");
                    if (anV() != null) {
                        FingerPrintAuthUI.a(anV(), i2);
                        return;
                    }
                    return;
                case 2001:
                    v.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                    if (anV() != null) {
                        this.fUD.dh(false);
                        return;
                    }
                    return;
                case 2002:
                    v.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    if (anV() != null) {
                        FingerPrintAuthUI.a(anV());
                        this.fUD.dh(true);
                        return;
                    }
                    return;
                case 2005:
                case 2007:
                case 10308:
                    v.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    String string = aa.getContext().getString(2131235586);
                    if (i == 10308) {
                        string = aa.getContext().getString(2131235587);
                        com.tencent.mm.pluginsdk.f.a.b(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.pluginsdk.f.a.b(BaseReportManager.MAX_READ_COUNT, -1000223, i, "fingerprint error");
                    }
                    if (anV() != null) {
                        anV().ax(string, -1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.fUu > 1) {
            fingerPrintAuthUI.fUu = currentTimeMillis;
            fingerPrintAuthUI.fUy.setText(2131232828);
            fingerPrintAuthUI.fUy.setTextColor(fingerPrintAuthUI.getResources().getColor(2131689960));
            fingerPrintAuthUI.fUy.setVisibility(4);
            if (fingerPrintAuthUI.fUt == null) {
                fingerPrintAuthUI.fUt = AnimationUtils.loadAnimation(fingerPrintAuthUI.nDR.nEl, 2130968624);
            }
            fingerPrintAuthUI.fUy.startAnimation(fingerPrintAuthUI.fUt);
            ad.g(new Runnable(fingerPrintAuthUI) {
                final /* synthetic */ FingerPrintAuthUI fUD;

                {
                    this.fUD = r1;
                }

                public final void run() {
                    this.fUD.fUy.setVisibility(0);
                }
            }, fingerPrintAuthUI.fUt.getDuration());
        }
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, int i) {
        fingerPrintAuthUI.fUB = false;
        c.abort();
        c.release();
        fingerPrintAuthUI.fUr.a(fingerPrintAuthUI, String.valueOf(i), 1);
    }

    static /* synthetic */ boolean c(FingerPrintAuthUI fingerPrintAuthUI) {
        String str = "MicroMsg.FingerPrintAuthUI";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!fingerPrintAuthUI.cOX);
        v.i(str, str2, objArr);
        return !fingerPrintAuthUI.cOX;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd(getString(2131234135));
        this.fUy = (TextView) findViewById(2131755571);
        com.tencent.mm.plugin.fingerprint.a.ank();
        this.fUz = com.tencent.mm.plugin.fingerprint.a.anl();
        this.fUr = c.ans();
        Bundle ad = com.tencent.mm.wallet_core.a.ad(this);
        if (ad != null) {
            Object string = ad.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                v.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                ax(getString(2131232833), -1);
                com.tencent.mm.pluginsdk.f.a.b(BaseReportManager.MAX_READ_COUNT, -1000223, -1, "get user pwd error");
                return;
            } else if (e.anx()) {
                cg(true);
                this.fUr.a(this, new com.tencent.mm.pluginsdk.wallet.a(this) {
                    final /* synthetic */ FingerPrintAuthUI fUD;

                    {
                        this.fUD = r1;
                    }

                    public final void K(int i, String str) {
                        this.fUD.cg(false);
                        if (i == 0) {
                            this.fUD.fUB = true;
                            if (FingerPrintAuthUI.c(this.fUD)) {
                                this.fUD.dh(false);
                                return;
                            }
                            return;
                        }
                        this.fUD.ax(str, i);
                    }
                }, string);
                return;
            } else {
                v.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                return;
            }
        }
        v.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
        ax(getString(2131232833), -1);
        com.tencent.mm.pluginsdk.f.a.b(BaseReportManager.MAX_READ_COUNT, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
    }

    protected final void cg(final boolean z) {
        ad.o(new Runnable(this) {
            final /* synthetic */ FingerPrintAuthUI fUD;

            public final void run() {
                if (z) {
                    this.fUD.fUq = com.tencent.mm.wallet_core.ui.g.a(this.fUD, false, null);
                } else if (this.fUD.fUq != null && this.fUD.fUq.isShowing()) {
                    this.fUD.fUq.dismiss();
                    this.fUD.fUq = null;
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.cOX = false;
        if (this.fUB) {
            dh(false);
        }
    }

    private void dh(boolean z) {
        com.tencent.mm.plugin.fingerprint.a.ank();
        com.tencent.mm.plugin.fingerprint.a.anl();
        c.abort();
        c.release();
        if (c.anr()) {
            if (this.fUA == null) {
                this.fUA = new a(this, this);
            }
            if (c.a(this.fUA, z) != 0) {
                v.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
                return;
            }
            return;
        }
        v.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
    }

    public void onPause() {
        super.onPause();
        this.cOX = true;
        WakeLock newWakeLock = ((PowerManager) this.nDR.nEl.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        v.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.ank();
        if (com.tencent.mm.plugin.fingerprint.a.anl() != null) {
            c.anq();
        }
        if (newWakeLock != null) {
            newWakeLock.release();
        }
    }

    public void onDestroy() {
        v.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.fUt != null) {
            this.fUt.cancel();
        }
        this.fUA = null;
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (this.fUr.d(i, i2, str, kVar)) {
            return true;
        }
        if (!(kVar instanceof l)) {
            return false;
        }
        cg(false);
        com.tencent.mm.wallet_core.a.b((Activity) this, new Bundle(), 0);
        Toast.makeText(this, 2131232834, 0).show();
        return true;
    }

    private void ax(final String str, final int i) {
        ad.o(new Runnable(this) {
            final /* synthetic */ FingerPrintAuthUI fUD;

            public final void run() {
                com.tencent.mm.ui.base.g.a(this.fUD, str, "", this.fUD.getString(2131233285), false, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 fUF;

                    {
                        this.fUF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.b(this.fUF.fUD, new Bundle(), i);
                    }
                });
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903645;
    }

    protected final int NO() {
        return 1;
    }

    public final void K(int i, String str) {
        if (i == 0) {
            v.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            b(new l(null), false);
            return;
        }
        cg(false);
        v.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        com.tencent.mm.ui.base.g.a(this, getString(2131232833), "", new OnClickListener(this) {
            final /* synthetic */ FingerPrintAuthUI fUD;

            {
                this.fUD = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.wallet_core.a.b(this.fUD, new Bundle(), -1);
            }
        });
    }
}
