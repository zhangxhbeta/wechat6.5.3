package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.remittance.c.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceOSUI extends RemittanceBaseUI implements d.a {
    private int ita;
    private String itb;
    private String itc;
    private String itd;
    private String ite;

    public final void aKh() {
    }

    public final void aKj() {
        g.iuh.h(13337, new Object[]{Integer.valueOf(2)});
    }

    public final void aKk() {
        s.makeText(this.nDR.nEl, getString(2131234531, new Object[]{this.itb}), 0).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pjH.gQ(1622);
        this.pjH.gQ(1574);
        NI();
        this.eWC.PZ("");
        n.AX().a(this);
        this.ita = getIntent().getIntExtra("os_currency", 0);
        this.itb = getIntent().getStringExtra("os_currencyuint");
        this.itc = getIntent().getStringExtra("os_currencywording");
        this.itd = getIntent().getStringExtra("os_notice");
        this.ite = getIntent().getStringExtra("os_notice_url");
        this.eWC.PZ(this.itb);
        aKn();
    }

    public final void yG(String str) {
        String xH = k.xH();
        if (be.kS(xH)) {
            xH = k.xF();
        }
        ak.yW();
        u LX = c.wH().LX(this.bZy);
        String str2 = this.bZy;
        if (((int) LX.chr) != 0) {
            str2 = LX.tU();
        }
        com.tencent.mm.wallet_core.b.k iVar = new i(this.irZ, xH, this.bZy, str2, str, this.ita);
        iVar.mProcessName = "RemittanceProcess";
        j(iVar);
        g.iuh.h(13337, new Object[]{Integer.valueOf(1), Double.valueOf(this.irZ)});
    }

    protected final void yH(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
    }

    protected final void yI(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
    }

    public final void aKn() {
        if (be.kS(this.itd)) {
            v.i("MicroMsg.RemittanceOSUI", "no bulletin data");
        } else {
            e.a((TextView) findViewById(2131756367), "", this.itd, this.ite);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        n.AX().b(this);
        this.pjH.gR(1622);
        this.pjH.gR(1574);
    }

    public final void gM(String str) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.RemittanceOSUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.bZy);
        if (i == 3 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return 2130904280;
    }

    public final void b(int i, int i2, String str, com.tencent.mm.v.k kVar, boolean z) {
        super.b(i, i2, str, kVar, z);
        if (i == 0 && i2 == 0 && (kVar instanceof i)) {
            int i3;
            final i iVar = (i) kVar;
            boolean z2;
            if (iVar.irl <= 0) {
                z2 = false;
            } else if (iVar.irQ == 0) {
                com.tencent.mm.ui.base.g.b(this, getString(2131234536, new Object[]{Integer.valueOf(iVar.irl)}), getString(2131231139), getString(2131234484), getString(2131234530), new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI itg;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.itg.yH(iVar.irO);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI itg;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.itg.yI(iVar.irP);
                    }
                });
                i3 = 1;
            } else if (iVar.irQ == 1) {
                com.tencent.mm.ui.base.g.b(this, getString(2131234536, new Object[]{Integer.valueOf(iVar.irl)}), getString(2131231139), getString(2131234484), getString(2131234530), new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI itg;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.itg.yH(iVar.irO);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI itg;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.itg.yI(iVar.irP);
                    }
                });
                i3 = 1;
            } else {
                z2 = false;
            }
            if (i3 == 0) {
                String str2 = ((i) kVar).irO;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
            }
        }
    }
}
