package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

public class WalletGestureCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView kKC;
    private i kKD;
    private TextView kpT;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236146);
        this.kKC = (EditHintPasswdView) findViewById(2131758506);
        this.kpT = (TextView) findViewById(2131759758);
        this.kpT.setText(2131236145);
        vD(2131236545);
        this.kKC.pkg = new a(this) {
            final /* synthetic */ WalletGestureCheckPwdUI kKE;

            {
                this.kKE = r1;
            }

            public final void fc(boolean z) {
                if (z) {
                    this.kKE.kKD = new i(this.kKE.kKC.getText(), 6, this.kKE.bLx());
                    this.kKE.p(this.kKE.kKD);
                }
            }
        };
        d(this.kKC, 0, false);
    }

    protected final int getLayoutId() {
        return 2130904634;
    }

    public final void nU(int i) {
        super.nU(i);
        this.kKC.aJx();
    }

    private void v(int i, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("key_result", i);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.WalletGestureCheckPwdUI", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            if (i == 0 && i2 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    finish();
                    Intent intent = new Intent();
                    intent.setAction("action.switch_on_pattern");
                    intent.addFlags(131072);
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", iVar.token);
                    intent.putExtra("type", iVar.kLm);
                    intent.setPackage(aa.getPackageName());
                    c.b(this, "gesture", ".ui.GestureGuardLogicUI", intent);
                    return true;
                }
                v(0, iVar.token, iVar.kLm);
                return true;
            } else if (i == 1000 && i2 == 3) {
                v(-1, null, null);
                return true;
            }
        }
        return false;
    }
}
