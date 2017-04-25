package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;

@a(7)
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    protected final void aKg() {
        b(new e(this.bZy), false);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar instanceof e) {
            this.irT = false;
        }
        if (i != 0 || i2 != 0 || !(kVar instanceof e)) {
            return false;
        }
        final e eVar = (e) kVar;
        this.bZy = eVar.username;
        if (be.kS(this.bZy)) {
            v.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.cVh);
            finish();
            return true;
        }
        final Intent intent = new Intent();
        intent.putExtra("fee", eVar.eWz);
        intent.putExtra("desc", eVar.desc);
        intent.putExtra("scan_remittance_id", eVar.irz);
        intent.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.PS(eVar.iry));
        ak.yW();
        if (c.wH().LW(this.bZy) != null) {
            c(this.bZy, eVar.scene, intent);
        } else {
            v.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
            final long Ni = be.Ni();
            ab.a.crZ.a(this.bZy, "", new ab.c.a(this) {
                final /* synthetic */ PayURemittanceAdapterUI laq;

                public final void p(String str, boolean z) {
                    if (z) {
                        v.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (be.Ni() - Ni) + " ms");
                        b.r(str, 3);
                        n.Bq().gD(str);
                    } else {
                        v.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
                    }
                    this.laq.c(this.laq.bZy, eVar.scene, intent);
                }
            });
        }
        return true;
    }

    protected final void c(String str, int i, Intent intent) {
        Intent intent2;
        v.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.cVh + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.setClass(this, PayURemittanceUI.class);
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.cVh);
        intent2.putExtra("pay_scene", i);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
