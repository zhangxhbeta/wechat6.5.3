package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.remittance.c.j;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceResultUI extends WalletBaseUI {
    private int isa;
    private Orders ith;
    private String iti;
    private boolean itj;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904279;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ith = (Orders) this.uA.getParcelable("key_orders");
        NI();
        if (this.isa == 31) {
            j aKd = b.aKb().aKd();
            aKd.H(aKd.irS, aKd.fgr, this.iti);
            aKd.irS = null;
            aKd.fgr = null;
        }
        t.a((PayInfo) this.uA.getParcelable("key_pay_info"), this.ith);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aKu();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void NI() {
        Fd(getString(2131234543));
        b(null);
        bzV();
        iS(false);
        TextView textView = (TextView) findViewById(2131758916);
        if (this.ith != null) {
            textView.setText(e.d(this.ith.kOU, this.ith.hNg));
        }
        PayInfo payInfo = (PayInfo) this.uA.getParcelable("key_pay_info");
        String str = "";
        if (payInfo.lVD != null) {
            this.itj = payInfo.lVD.getBoolean("extinfo_key_4");
            str = payInfo.lVD.getString("extinfo_key_1");
        }
        int i = payInfo.bkq;
        this.isa = i;
        this.iti = str;
        str = e.er(str);
        if (i == 31) {
            textView = (TextView) findViewById(2131758915);
            CharSequence string = getString(2131234542, new Object[]{str});
            if (be.kS(string)) {
                textView.setVisibility(8);
            } else {
                textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, string, textView.getTextSize()));
                textView.setVisibility(0);
            }
            findViewById(2131758919).setVisibility(8);
            if (this.ith.iro > 0.0d) {
                ((TextView) findViewById(2131758918)).setText(getResources().getString(2131234540, new Object[]{e.d(this.ith.iro, this.ith.hNg)}));
                findViewById(2131758917).setVisibility(0);
            }
        } else {
            String str2 = "";
            if (payInfo.lVD != null) {
                str2 = payInfo.lVD.getString("extinfo_key_2");
            }
            if (i == 32 || i == 33) {
                str2 = str;
            } else if (be.kS(str2)) {
                str2 = str + getString(2131234550);
            } else {
                str2 = str + "（" + e.PS(str2) + "）";
            }
            TextView textView2 = (TextView) findViewById(2131758915);
            if (be.kS(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, getString(2131234541, new Object[]{str2}), textView2.getTextSize()));
                textView2.setVisibility(0);
            }
            if (i == 33) {
                View findViewById = findViewById(2131758920);
                textView2 = (TextView) findViewById(2131758922);
                CharSequence string2 = payInfo.lVD.getString("extinfo_key_3");
                if (be.kS(string2)) {
                    findViewById.setVisibility(8);
                    findViewById(2131758919).setVisibility(8);
                } else {
                    textView2.setText(string2);
                    findViewById.setVisibility(0);
                    findViewById(2131758919).setVisibility(0);
                }
            } else if (!(i != 5 || this.ith.kPm == null || this.ith.kPm.get(0) == null || TextUtils.isEmpty(((Commodity) this.ith.kPm.get(0)).hMV))) {
                textView2.setText(((Commodity) this.ith.kPm.get(0)).hMV);
            }
        }
        ((Button) findViewById(2131758923)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RemittanceResultUI itk;

            {
                this.itk = r1;
            }

            public final void onClick(View view) {
                this.itk.aKu();
            }
        });
        ak.yW();
        Object obj = c.vf().get(com.tencent.mm.storage.t.a.nqc, Boolean.valueOf(false));
        if (obj != null ? ((Boolean) obj).booleanValue() : false) {
            v.i("MicroMsg.WalletOrderInfoUI", "has show the finger print auth guide!");
            return;
        }
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
        Bundle bundle = new Bundle();
        if (ae != null) {
            bundle = ae.fNM;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            v.i("MicroMsg.WalletOrderInfoUI", "pwd is empty, not show the finger print auth guide!");
        } else {
            ae.a(this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void aKu() {
        if (this.uA.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.uA.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceResultUI itk;

                    {
                        this.itk = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.itk.aKv();
                    }
                });
                this.uA.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        aKv();
    }

    private void aKv() {
        bLC().d(this, this.uA);
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ RemittanceResultUI itk;

            {
                this.itk = r1;
            }

            public final void run() {
                if (this.itk.isa == 33 || this.itk.isa == 32) {
                    this.itk.finish();
                } else if (be.kS(this.itk.iti) || this.itk.itj) {
                    this.itk.finish();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", this.itk.iti);
                    intent.putExtra("finish_direct", false);
                    com.tencent.mm.ay.c.a(this.itk, ".ui.chatting.ChattingUI", intent);
                }
            }
        }, 100);
    }
}
