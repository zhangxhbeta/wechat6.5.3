package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;

@a(3)
public class WalletIdCardCheckUI extends WalletBaseUI implements OnEditorActionListener, WalletFormView.a {
    private WalletFormView kKF;
    private TextView kKG;
    private TextView kKH;
    private Button kKI;
    private int kKJ = 1;

    static /* synthetic */ boolean a(WalletIdCardCheckUI walletIdCardCheckUI) {
        boolean z = true;
        if (!walletIdCardCheckUI.kKF.de(walletIdCardCheckUI.kKH)) {
            walletIdCardCheckUI.kKH.setText(2131236094);
            walletIdCardCheckUI.kKH.setTextColor(walletIdCardCheckUI.getResources().getColor(2131689960));
            z = false;
        }
        if (z) {
            walletIdCardCheckUI.kKH.setVisibility(4);
        } else {
            walletIdCardCheckUI.kKH.setVisibility(0);
        }
        return z;
    }

    protected final int getLayoutId() {
        return 2130904633;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236298);
        gQ(1580);
        NI();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletIdCardCheckUI kKK;

            {
                this.kKK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
                this.kKK.finish();
                return false;
            }
        });
        com.tencent.mm.wallet_core.ui.formview.a.c(this.kKF);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        gR(1580);
    }

    protected final void NI() {
        this.kKF = (WalletFormView) findViewById(2131759858);
        this.kKH = (TextView) findViewById(2131759859);
        this.kKG = (TextView) findViewById(2131759856);
        this.kKF.pkk = this;
        this.kKF.setOnEditorActionListener(this);
        this.kKH.setVisibility(4);
        this.kKI = (Button) findViewById(2131759879);
        d(this.kKF, 1, false);
        this.kKI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletIdCardCheckUI kKK;

            {
                this.kKK = r1;
            }

            public final void onClick(View view) {
                if (WalletIdCardCheckUI.a(this.kKK)) {
                    g.iuh.h(13731, new Object[]{Integer.valueOf(2)});
                    this.kKK.j(new f(this.kKK.kKF.getText(), this.kKK.kKJ, k.bga().bgB()));
                }
            }
        });
        this.kKJ = k.bga().bgC();
        v.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[]{Integer.valueOf(this.kKJ), k.bgi().E(this, this.kKJ)});
        WalletFormView walletFormView = this.kKF;
        int i = this.kKJ;
        b bVar = walletFormView.pkm;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).yE(i);
        }
        this.kKF.PZ(r1);
        this.kKF.aJx();
        if (this.kKJ == 1) {
            d(this.kKF, 1, false);
        } else {
            d(this.kKF, 1, true);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.hcJ == null || !this.hcJ.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.hcJ.setVisibility(8);
        return true;
    }

    protected final int NO() {
        return 1;
    }

    public final boolean g(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("Micromsg.WalletIdCardCheckUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0 && (kVar instanceof f)) {
            com.tencent.mm.ui.base.g.a(this, getString(2131236293), "", getString(2131230747), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletIdCardCheckUI kKK;

                {
                    this.kKK = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kKK.setResult(-1);
                    this.kKK.finish();
                }
            });
        }
        return true;
    }

    public final void fc(boolean z) {
        this.kKH.setVisibility(4);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
