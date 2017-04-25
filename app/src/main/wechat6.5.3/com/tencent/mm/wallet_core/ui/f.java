package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b.g;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.d.a.b;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class f {
    private static int dLT = 0;
    private static int dLU = 0;
    private static String dLV = null;

    static /* synthetic */ void c(WalletBaseUI walletBaseUI) {
        if (dLT == BaseReportManager.MAX_READ_COUNT) {
            switch (dLU) {
                case 1:
                    if (!walletBaseUI.ayL()) {
                        walletBaseUI.oa(0);
                    }
                    walletBaseUI.nU(0);
                    break;
                case 3:
                    a.b(walletBaseUI.nDR.nEl, walletBaseUI.uA, dLU);
                    break;
                default:
                    if (!walletBaseUI.ayJ() && walletBaseUI.bLy() == 0) {
                        walletBaseUI.nU(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
            }
        }
        a.i(walletBaseUI.nDR.nEl, dLU);
        dLT = 0;
        dLU = 0;
        dLV = null;
    }

    public static void a(final WalletBaseUI walletBaseUI, int i, int i2, String str, k kVar, boolean z) {
        boolean aEQ;
        boolean z2;
        boolean z3 = true;
        if (be.kS(str)) {
            str = walletBaseUI.getString(2131236492);
        }
        if (kVar instanceof g) {
            aEQ = ((g) kVar).aEQ();
        } else {
            aEQ = true;
        }
        if (kVar instanceof com.tencent.mm.wallet_core.b.f) {
            z2 = ((com.tencent.mm.wallet_core.b.f) kVar).boF;
        } else {
            z2 = aEQ;
        }
        v.i("MicroMsg.WalletBaseUI", "dispatch errType:%d errMsg: %s, isBlock %s scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z2), kVar});
        if (!((kVar instanceof com.tencent.mm.wallet_core.e.a.k) || (kVar instanceof b))) {
            if (kVar instanceof g) {
                boolean z4;
                g gVar = (g) kVar;
                if (gVar.piy == null) {
                    z4 = false;
                } else {
                    z4 = "1".equals(gVar.piy.trim());
                }
                if (z4) {
                    v.d("MicroMsg.WalletBaseUI", "order pay end!!!");
                    Bundle bundle = walletBaseUI.uA;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", gVar.piz);
                    bundle.putString("intent_wap_pay_jump_url", gVar.piA);
                    bundle.putBoolean("intent_pay_end", true);
                    a.l(walletBaseUI, bundle);
                }
                if (z2 && e.a(walletBaseUI, i, i2, str)) {
                    aEQ = false;
                } else {
                    aEQ = true;
                }
                if (!aEQ) {
                    v.d("MicroMsg.WalletBaseUI", "wallet base consume this response before subclass!");
                } else if ((walletBaseUI.bLC() == null || !walletBaseUI.bLD().d(i, i2, str, kVar)) && !walletBaseUI.d(i, i2, str, (g) kVar) && z2) {
                    if (i == 0 && i2 == 0) {
                        v.d("MicroMsg.WalletBaseUI", "wallet this response havn't error!");
                    } else {
                        dLT = i;
                        dLU = i2;
                        dLV = str;
                        v.d("MicroMsg.WalletBaseUI", "wallet base consume this response in the end!");
                    }
                }
            } else if (!walletBaseUI.d(i, i2, str, kVar) && z2) {
                if (i == 0 && i2 == 0) {
                    v.d("MicroMsg.WalletBaseUI", "wallet other scene this response havn't error!");
                } else {
                    dLT = i;
                    dLU = i2;
                    dLV = str;
                    v.d("MicroMsg.WalletBaseUI", "wallet base consume this response in the end!");
                }
            }
        }
        if (z) {
            v.d("MicroMsg.WalletBaseUI", "scenes & forcescenes isEmpty! %s", new Object[]{Boolean.valueOf(z2)});
            if (dLU != 0) {
                v.e("MicroMsg.WalletBaseUI", "showAlert! mErrCode : " + dLU);
                if (kVar instanceof g) {
                    final String bLb = ((g) kVar).bLb();
                    if (!be.kS(bLb)) {
                        v.i("MicroMsg.WalletBaseUI", "error_detail_url is not null ");
                        com.tencent.mm.ui.base.g.a(walletBaseUI.nDR.nEl, dLV, null, walletBaseUI.getResources().getString(2131236171), walletBaseUI.getResources().getString(2131231107), true, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", bLb);
                                c.b(walletBaseUI.nDR.nEl, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                e.yD(3);
                                f.c(walletBaseUI);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f.c(walletBaseUI);
                            }
                        });
                        e.yD(4);
                        if (z3) {
                            v.i("MicroMsg.WalletBaseUI", "error_detail_url is null ");
                            com.tencent.mm.ui.base.g.a(walletBaseUI.nDR.nEl, dLV, null, false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    f.c(walletBaseUI);
                                }
                            });
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    v.i("MicroMsg.WalletBaseUI", "error_detail_url is null ");
                    com.tencent.mm.ui.base.g.a(walletBaseUI.nDR.nEl, dLV, null, false, /* anonymous class already generated */);
                }
            } else if (!walletBaseUI.ayL()) {
                walletBaseUI.oa(0);
            }
        }
    }

    public static void bLA() {
        dLT = 0;
        dLU = 0;
        dLV = null;
    }
}
