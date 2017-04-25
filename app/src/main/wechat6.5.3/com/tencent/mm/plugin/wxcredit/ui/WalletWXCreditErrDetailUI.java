package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard kGa;
    private String lwW;
    private TextView lwX;
    private TextView lwY;

    protected final int getLayoutId() {
        return 2130904698;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236040);
        NI();
    }

    protected final void NI() {
        this.kGa = (Bankcard) this.uA.getParcelable("key_bankcard");
        this.lwW = this.uA.getString("key_repayment_url");
        if (this.kGa != null) {
            this.lwX = (TextView) findViewById(2131760057);
            this.lwX.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletWXCreditErrDetailUI lwZ;

                {
                    this.lwZ = r1;
                }

                public final void onClick(View view) {
                    e.l(this.lwZ, this.lwZ.lwW, false);
                }
            });
            this.lwY = (TextView) findViewById(2131759825);
            this.lwY.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletWXCreditErrDetailUI lwZ;

                {
                    this.lwZ = r1;
                }

                public final void onClick(View view) {
                    a.k(this.lwZ, this.lwZ.uA);
                }
            });
            this.lwY.setVisibility(this.uA.getBoolean("key_can_unbind", true) ? 0 : 8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
