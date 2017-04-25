package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class e {
    public static boolean a(final WalletBaseUI walletBaseUI, int i, final int i2, String str) {
        if (i != BaseReportManager.MAX_READ_COUNT) {
            return false;
        }
        String string;
        if (be.kS(str)) {
            string = walletBaseUI.getString(2131236492);
        } else {
            string = str;
        }
        b ae = a.ae(walletBaseUI);
        switch (i2) {
            case -100869:
                g.a(walletBaseUI, walletBaseUI.getString(2131236175), null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.b(walletBaseUI, walletBaseUI.uA, i2);
                        if (walletBaseUI.ayJ()) {
                            walletBaseUI.finish();
                        }
                    }
                });
                return true;
            case -100868:
                g.a(walletBaseUI, walletBaseUI.getString(2131236176), null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.b(walletBaseUI, walletBaseUI.uA, i2);
                        if (walletBaseUI.ayJ()) {
                            walletBaseUI.finish();
                        }
                    }
                });
                return true;
            case 401:
                g.a(walletBaseUI, false, string, "", walletBaseUI.getString(2131236186), walletBaseUI.getString(2131231144), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (k.xT()) {
                            a.b(walletBaseUI, "PayUForgotPwdProcess", null);
                        } else {
                            a.b(walletBaseUI, "ForgotPwdProcess", null);
                        }
                        if (walletBaseUI.ayJ()) {
                            walletBaseUI.finish();
                        }
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        walletBaseUI.nU(1);
                    }
                });
                return true;
            case 402:
            case 403:
            case 408:
                if (ae != null) {
                    return ae.a(walletBaseUI, i2, string);
                }
                return false;
            case 404:
                if (ae != null) {
                    return ae.a(walletBaseUI, i2, string);
                }
                return false;
            case 405:
                g.b(walletBaseUI, string, "", walletBaseUI.getString(2131236455), walletBaseUI.getString(2131231010), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        walletBaseUI.ku(true);
                    }
                }, null);
                return true;
            case 407:
                bLq();
                if (k.xT()) {
                    b(walletBaseUI, i2, string);
                } else {
                    g.a(walletBaseUI, string, null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.b(walletBaseUI, null, i2);
                            if (walletBaseUI.ayJ()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                }
                return true;
            case 412:
                g.b(walletBaseUI, string, "", walletBaseUI.getString(2131236512), walletBaseUI.getString(2131231010), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_is_bind_bankcard", false);
                        a.a(walletBaseUI, "BindCardProcess", bundle, new b.a(this) {
                            final /* synthetic */ AnonymousClass5 piT;

                            {
                                this.piT = r1;
                            }

                            public final Intent e(int i, Bundle bundle) {
                                return null;
                            }
                        });
                    }
                }, null);
                return true;
            case 414:
                bLq();
                b(walletBaseUI, i2, string);
                return true;
            default:
                return false;
        }
    }

    private static void bLq() {
        com.tencent.mm.v.k bVar;
        if (k.xT()) {
            bVar = new com.tencent.mm.wallet_core.d.a.b();
        } else {
            bVar = new com.tencent.mm.wallet_core.e.a.k();
        }
        ak.vy().a(bVar, 0);
    }

    private static void b(final WalletBaseUI walletBaseUI, final int i, String str) {
        g.a(walletBaseUI, false, str, "", walletBaseUI.getString(2131236174), walletBaseUI.getString(2131231010), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
                c.b(walletBaseUI, "webview", ".ui.tools.WebViewUI", intent);
                if (walletBaseUI.ayJ() || walletBaseUI.nDR.dtW.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.b(walletBaseUI, walletBaseUI.uA, i);
                if (walletBaseUI.ayJ() || walletBaseUI.nDR.dtW.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
            }
        });
    }
}
