package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_core.ui.k.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String kFn = "";
    private k kFo;
    private String mTitle = "";

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        oa(4);
        this.mTitle = this.uA.getString("key_pwd_cash_title");
        this.kFn = this.uA.getString("key_pwd_cash_money");
        v.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", new Object[]{be.ma(this.kFn), be.ma(this.mTitle)});
        if (be.kS(this.mTitle) || be.kS(this.kFn)) {
            i = 0;
        }
        if (i == 0) {
            g.a(this.nDR.nEl, 2131236242, 0, new OnClickListener(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI kFp;

                {
                    this.kFp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kFp.finish();
                }
            });
        } else {
            showDialog();
        }
    }

    private void showDialog() {
        if (this.kFo != null && this.kFo.isShowing()) {
            this.kFo.dismiss();
        }
        String str = "";
        if (((Orders) this.uA.getParcelable("key_orders")).iro > 0.0d) {
            str = getResources().getString(2131235980, new Object[]{e.d(r0.iro, r0.hNg)});
        }
        if (this.kFo == null) {
            this.kFo = k.a(this, this.mTitle, this.kFn, str, new c(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI kFp;

                {
                    this.kFp = r1;
                }

                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    this.kFp.kFo.dismiss();
                    if (this.kFp.bLC() != null) {
                        this.kFp.bLD().j(str);
                    }
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI kFp;

                {
                    this.kFp = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    v.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: dialog cancel. finish");
                    this.kFp.kFo.dismiss();
                    this.kFp.finish();
                }
            }, new k.a(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI kFp;

                {
                    this.kFp = r1;
                }

                public final void aEX() {
                    v.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: pwd cancel.finish");
                    this.kFp.kFo.dismiss();
                    this.kFp.finish();
                }
            });
            return;
        }
        k kVar = this.kFo;
        if (kVar.kUT != null) {
            kVar.kUT.aJx();
        }
        this.kFo.show();
    }

    public final void nU(int i) {
        if (i == 0) {
            finish();
        } else if (i == 1) {
            showDialog();
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
