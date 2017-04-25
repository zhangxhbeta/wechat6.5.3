package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.remittance.c.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.b.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceAdapterUI extends WalletBaseUI {
    public String bZy = null;
    public int cVh;
    protected int hcU;
    public boolean irT = false;
    protected com.tencent.mm.plugin.wallet.a irU = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(8);
        this.cVh = getIntent().getIntExtra("scene", 0);
        this.bZy = getIntent().getStringExtra("receiver_name");
        this.hcU = getIntent().getIntExtra("pay_channel", -1);
        this.irU = com.tencent.mm.plugin.wallet.a.K(getIntent());
        if (this.hcU == -1) {
            b bLC = bLC();
            if (bLC != null) {
                this.hcU = bLC.fNM.getInt("pay_channel", -1);
            }
        }
        if (this.cVh == 1) {
            this.irT = true;
            aKg();
        } else if (this.cVh == 3) {
            gQ(580);
            if (getIntent() == null) {
                v.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                return;
            }
            k aVar = new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3);
            aVar.mProcessName = "RemittanceProcess";
            p(aVar);
        } else if (this.cVh == 2) {
            if (be.kS(this.bZy)) {
                v.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.cVh);
                finish();
                return;
            }
            c(this.bZy, 31, null);
        } else if (this.cVh != 5) {
            c(null, 31, null);
        } else if (be.kS(this.bZy)) {
            v.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.cVh);
            finish();
        } else {
            String str = this.bZy;
            v.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.cVh + ", name=" + str);
            Intent intent = new Intent();
            com.tencent.mm.plugin.wallet.a.a(this.irU, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.cVh);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.hcU);
            startActivity(intent);
            setResult(-1);
            finish();
        }
    }

    public void aKg() {
        k eVar = new e(this.bZy);
        eVar.mProcessName = "RemittanceProcess";
        b(eVar, false);
    }

    public void onDestroy() {
        if (this.cVh == 3) {
            gR(580);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.irT) {
            v.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
            return;
        }
        v.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
        finish();
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof e) {
            this.irT = false;
        }
        if (i != 0 || i2 != 0) {
            setResult(0);
            g.bf(this, str);
            finish();
            return true;
        } else if (kVar instanceof e) {
            final e eVar = (e) kVar;
            this.bZy = eVar.username;
            if (be.kS(this.bZy)) {
                v.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.cVh);
                finish();
                return true;
            }
            if (this.cVh == 1) {
                if (eVar.scene == 33) {
                    this.irU = com.tencent.mm.plugin.wallet.a.bg(this.bZy, 2);
                    this.irU.aj(20, getIntent().getStringExtra("receiver_name"));
                } else {
                    this.irU = com.tencent.mm.plugin.wallet.a.bg(this.bZy, 3);
                    this.irU.aj(10, getIntent().getStringExtra("receiver_name"));
                }
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", eVar.eWz);
            intent.putExtra("desc", eVar.desc);
            intent.putExtra("scan_remittance_id", eVar.irz);
            intent.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.PS(eVar.iry));
            intent.putExtra("receiver_tips", eVar.irA);
            intent.putExtra("rcvr_new_desc", eVar.irB);
            ak.yW();
            if (c.wH().LW(this.bZy) != null) {
                c(this.bZy, eVar.scene, intent);
            } else {
                v.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long Ni = be.Ni();
                ab.a.crZ.a(this.bZy, "", new ab.c.a(this) {
                    final /* synthetic */ RemittanceAdapterUI irX;

                    public final void p(String str, boolean z) {
                        if (z) {
                            v.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (be.Ni() - Ni) + " ms");
                            com.tencent.mm.u.b.r(str, 3);
                            n.Bq().gD(str);
                        } else {
                            v.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
                        }
                        this.irX.c(this.irX.bZy, eVar.scene, intent);
                    }
                });
            }
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a)) {
            return false;
        } else {
            c(null, 31, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void c(String str, int i, Intent intent) {
        Intent intent2;
        v.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.cVh + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        com.tencent.mm.plugin.wallet.a.a(this.irU, intent2);
        intent2.setClass(this, RemittanceUI.class);
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.cVh);
        intent2.putExtra("pay_scene", i);
        intent2.putExtra("pay_channel", this.hcU);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
