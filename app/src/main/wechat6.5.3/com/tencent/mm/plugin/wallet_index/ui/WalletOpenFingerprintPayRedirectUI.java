package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.g;

public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements e {
    private boolean GD = false;
    private Dialog dxy = null;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] enx = new int[a.values().length];

        static {
            try {
                enx[a.lFV.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                enx[a.lFX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                enx[a.lFW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(385, this);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final boolean p(Intent intent) {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(385, this);
    }

    protected final void a(a aVar, Intent intent) {
        v.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = " + aVar);
        switch (AnonymousClass3.enx[aVar.ordinal()]) {
            case 1:
                v.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                ak.vy().a(new l(null, 1), 0);
                if (this.dxy != null) {
                    this.dxy.dismiss();
                    this.dxy = null;
                }
                this.dxy = g.e(this, new OnCancelListener(this) {
                    final /* synthetic */ WalletOpenFingerprintPayRedirectUI kYc;

                    {
                        this.kYc = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.kYc.GD = true;
                        this.kYc.b(4, false, "");
                    }
                });
                return;
            case 2:
            case 3:
                v.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = " + aVar);
                b(1, false, "");
                break;
            default:
                v.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = " + aVar);
                break;
        }
        b(2, true, getString(2131231042));
    }

    private void b(int i, boolean z, String str) {
        v.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[]{Integer.valueOf(i)});
        if (this.dxy != null && this.dxy.isShowing()) {
            this.dxy.dismiss();
            this.dxy = null;
        }
        if (z) {
            com.tencent.mm.ui.base.g.a(this, str, "", false, new OnClickListener(this) {
                final /* synthetic */ WalletOpenFingerprintPayRedirectUI kYc;

                {
                    this.kYc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kYc.finish();
                }
            });
        } else {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.dxy != null && this.dxy.isShowing()) {
            this.dxy.dismiss();
            this.dxy = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof l)) {
            return;
        }
        if (this.GD) {
            v.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            return;
        }
        this.GD = true;
        if (i == 0 && i2 == 0) {
            v.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
            com.tencent.mm.plugin.wallet.a.k.beN();
            ab beO = com.tencent.mm.plugin.wallet.a.k.beO();
            if (beO == null || !beO.bgv()) {
                v.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                b(5, true, getString(2131232836));
                return;
            } else if (com.tencent.mm.plugin.wallet.b.a.bfA() && p.ceE.ceQ == 1) {
                Intent intent = new Intent();
                intent.putExtra("key_is_from_system", true);
                c.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                finish();
                return;
            } else {
                v.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                b(6, true, getString(2131232837));
                return;
            }
        }
        v.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        b(3, true, getString(2131231042));
    }
}
