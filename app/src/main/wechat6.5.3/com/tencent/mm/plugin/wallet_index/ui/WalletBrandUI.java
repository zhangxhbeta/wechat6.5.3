package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.e.a.qj;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.n;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI extends MMActivity implements e {
    private String appId;
    private String bkp;
    private Dialog dxy = null;
    private boolean kXE = false;
    private b kXF;
    private com.tencent.mm.sdk.c.c kXG = new com.tencent.mm.sdk.c.c<qp>(this) {
        final /* synthetic */ WalletBrandUI kXI;

        {
            this.kXI = r2;
            this.nhz = qp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            qp qpVar = (qp) bVar;
            v.i("MicroMsg.WalletBrandUI", "onPayEnd payResult : " + qpVar.bsg.bpc);
            this.kXI.setResult(qpVar.bsg.bpc);
            this.kXI.finish();
            return true;
        }
    };
    private com.tencent.mm.sdk.c.c kXH = new com.tencent.mm.sdk.c.c<qj>(this) {
        final /* synthetic */ WalletBrandUI kXI;

        {
            this.kXI = r2;
            this.nhz = qj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (this.kXI.dxy != null) {
                this.kXI.dxy.dismiss();
                this.kXI.dxy = null;
            }
            return true;
        }
    };

    interface b {
        void a(int i, int i2, String str, k kVar);

        int bhx();

        k bhy();
    }

    public class a implements b {
        final /* synthetic */ WalletBrandUI kXI;

        public a(WalletBrandUI walletBrandUI) {
            this.kXI = walletBrandUI;
        }

        public final int bhx() {
            return 1563;
        }

        public final k bhy() {
            this.kXI.appId = this.kXI.getIntent().getStringExtra("appId");
            String stringExtra = this.kXI.getIntent().getStringExtra("signtype");
            String stringExtra2 = this.kXI.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = this.kXI.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = this.kXI.getIntent().getStringExtra("packageExt");
            String stringExtra5 = this.kXI.getIntent().getStringExtra("paySignature");
            String stringExtra6 = this.kXI.getIntent().getStringExtra("url");
            this.kXI.bkp = this.kXI.getIntent().getStringExtra("bizUsername");
            com.tencent.mm.plugin.wallet_index.c.a.a aVar = new com.tencent.mm.plugin.wallet_index.c.a.a(this.kXI.appId, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra, stringExtra6, this.kXI.bkp, this.kXI.getIntent().getIntExtra("pay_channel", 0));
            ak.vy().a(aVar, 0);
            return aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.wallet_index.c.a.a)) {
                v.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[]{((com.tencent.mm.plugin.wallet_index.c.a.a) kVar).jumpUrl});
                String str2 = ((com.tencent.mm.plugin.wallet_index.c.a.a) kVar).kXx;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", r0);
                intent.putExtra("showShare", false);
                if (!be.kS(str2)) {
                    intent.putExtra("shouldForceViewPort", true);
                    intent.putExtra("view_port_code", str2);
                }
                com.tencent.mm.ay.c.b(this.kXI, "webview", ".ui.tools.WebViewUI", intent);
                this.kXI.setResult(-1);
                this.kXI.finish();
                return;
            }
            v.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            g.a(this.kXI, str, "", new OnClickListener(this) {
                final /* synthetic */ a kXJ;

                {
                    this.kXJ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kXJ.kXI.setResult(0);
                    this.kXJ.kXI.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a kXJ;

                {
                    this.kXJ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kXJ.kXI.setResult(0);
                    this.kXJ.kXI.finish();
                }
            });
        }
    }

    class c implements b {
        final /* synthetic */ WalletBrandUI kXI;

        c(WalletBrandUI walletBrandUI) {
            this.kXI = walletBrandUI;
        }

        public final k bhy() {
            this.kXI.appId = this.kXI.getIntent().getStringExtra("appId");
            String stringExtra = this.kXI.getIntent().getStringExtra("signtype");
            String stringExtra2 = this.kXI.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = this.kXI.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = this.kXI.getIntent().getStringExtra("packageExt");
            String stringExtra5 = this.kXI.getIntent().getStringExtra("paySignature");
            String stringExtra6 = this.kXI.getIntent().getStringExtra("url");
            this.kXI.bkp = this.kXI.getIntent().getStringExtra("bizUsername");
            com.tencent.mm.plugin.wallet_index.c.b.a aVar = new com.tencent.mm.plugin.wallet_index.c.b.a(this.kXI.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, this.kXI.bkp, this.kXI.getIntent().getIntExtra("pay_channel", 0));
            ak.vy().a(aVar, 0);
            return aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.wallet_index.c.b.a aVar = (com.tencent.mm.plugin.wallet_index.c.b.a) kVar;
            String str2 = aVar.kXm;
            v.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
            PayInfo payInfo = new PayInfo();
            payInfo.fTG = str2;
            payInfo.appId = this.kXI.appId;
            payInfo.kXn = aVar.kXn;
            payInfo.bkq = 3;
            payInfo.biS = str;
            payInfo.bkh = this.kXI.getIntent().getIntExtra("pay_channel", 0);
            com.tencent.mm.pluginsdk.wallet.e.a(this.kXI, payInfo, 1);
        }

        public final int bhx() {
            return 1521;
        }
    }

    class d implements b {
        final /* synthetic */ WalletBrandUI kXI;

        d(WalletBrandUI walletBrandUI) {
            this.kXI = walletBrandUI;
        }

        public final k bhy() {
            this.kXI.appId = this.kXI.getIntent().getStringExtra("appId");
            String stringExtra = this.kXI.getIntent().getStringExtra("signtype");
            String stringExtra2 = this.kXI.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = this.kXI.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = this.kXI.getIntent().getStringExtra("packageExt");
            String stringExtra5 = this.kXI.getIntent().getStringExtra("paySignature");
            String stringExtra6 = this.kXI.getIntent().getStringExtra("url");
            this.kXI.bkp = this.kXI.getIntent().getStringExtra("bizUsername");
            com.tencent.mm.plugin.wallet_index.c.a aVar = new com.tencent.mm.plugin.wallet_index.c.a(this.kXI.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, this.kXI.bkp, this.kXI.getIntent().getIntExtra("pay_channel", 0));
            aVar.piE = System.currentTimeMillis();
            aVar.mProcessName = "PayProcess";
            aVar.cVh = 3;
            ak.vy().a(aVar, 0);
            return aVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_index.c.a aVar = (com.tencent.mm.plugin.wallet_index.c.a) kVar;
                String str2 = aVar.kXm;
                v.d("MicroMsg.WalletBrandUI", "req_key = " + str2);
                PayInfo payInfo = new PayInfo();
                payInfo.fTG = str2;
                payInfo.appId = this.kXI.appId;
                payInfo.kXn = aVar.kXn;
                payInfo.bkq = 3;
                payInfo.biS = str;
                payInfo.bkh = this.kXI.getIntent().getIntExtra("pay_channel", 0);
                payInfo.lVH = aVar.piE;
                com.tencent.mm.pluginsdk.wallet.e.a(this.kXI, payInfo, 1);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_jsapi_pay_err_code", i2);
            String str3 = "key_jsapi_pay_err_msg";
            if (be.kS(str)) {
                str = this.kXI.getString(2131236223);
            }
            intent.putExtra(str3, str);
            this.kXI.setResult(5, intent);
            this.kXI.finish();
        }

        public final int bhx() {
            return 398;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        n.bLg();
        v.i("MicroMsg.WalletBrandUI", "onCreate");
        int intExtra = getIntent().getIntExtra("pay_for_wallet_type", 1);
        v.i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is " + intExtra);
        if (com.tencent.mm.model.k.xT()) {
            v.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
            this.kXF = new c(this);
        } else if (intExtra == 2) {
            v.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
            this.kXF = new a(this);
        } else {
            v.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
            this.kXF = new d(this);
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.kXG);
        com.tencent.mm.sdk.c.a.nhr.e(this.kXH);
        ak.vy().a(this.kXF.bhx(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        ak.vy().b(this.kXF.bhx(), this);
        com.tencent.mm.sdk.c.a.nhr.f(this.kXG);
        com.tencent.mm.sdk.c.a.nhr.f(this.kXH);
    }

    public void onResume() {
        v.d("MicroMsg.WalletBrandUI", "onResume");
        super.onResume();
        v.i("MicroMsg.WalletBrandUI", "Handler jump");
        if (!this.kXE) {
            this.kXE = true;
            final k bhy = this.kXF.bhy();
            if (this.dxy != null) {
                this.dxy.dismiss();
                this.dxy = null;
            }
            this.dxy = com.tencent.mm.wallet_core.ui.g.e(this, new OnCancelListener(this) {
                final /* synthetic */ WalletBrandUI kXI;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(bhy);
                    this.kXI.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        if (this.dxy != null) {
            this.dxy.dismiss();
            this.dxy = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() == this.kXF.bhx()) {
            this.kXF.a(i, i2, str, kVar);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + i2 + " requestCode: " + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    v.i("MicroMsg.WalletBrandUI", "get result to callback? " + intent.getStringExtra("test"));
                    break;
            }
        }
        finish();
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
