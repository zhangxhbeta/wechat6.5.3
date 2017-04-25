package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.List;

public class WalletPayDeductUI extends MMPreference implements OnClickListener, e {
    private Dialog dxy = null;
    protected f ezq;
    protected Button fzj;
    protected Orders ith;
    protected MMSwitchBtn kIS;
    protected ArrayList<Preference> kIT;
    protected TextView kIU;
    private TextView kIV;
    private TextView kIW;
    private String kIX;
    private String kIY;
    private Bankcard kIZ;
    private LinearLayout kJa;
    protected boolean kJb = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ezq = this.ocZ;
        setResult(0);
        b(new n(this) {
            final /* synthetic */ WalletPayDeductUI kJc;

            {
                this.kJc = r1;
            }

            public final void bfd() {
                this.kJc.setResult(0);
                this.kJc.finish();
            }
        });
        ak.vy().a(385, this);
        NI();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(385, this);
    }

    public final int Oo() {
        return -1;
    }

    protected final void NI() {
        vD(2131236348);
        vE(2131236646);
        this.kIU = (TextView) this.nDR.dtW.findViewById(2131759961);
        this.fzj = (Button) this.nDR.dtW.findViewById(2131756365);
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.WalletPayDeductUI", "intent is null");
            finish();
            return;
        }
        this.ith = (Orders) intent.getParcelableExtra("orders");
        if (this.ith == null || this.ith.kPr == null) {
            v.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.ith);
            finish();
        }
        this.kJb = this.ith.kPr.kJG == 1;
        this.kIS = (MMSwitchBtn) findViewById(2131755241);
        this.kIS.kq(this.kJb);
        this.kIS.pdu = new a(this) {
            final /* synthetic */ WalletPayDeductUI kJc;

            {
                this.kJc = r1;
            }

            public final void gB(boolean z) {
                this.kJc.hf(z);
            }
        };
        this.kJa = (LinearLayout) findViewById(2131759957);
        ((TextView) findViewById(2131759956)).setText(this.ith.kPr.title);
        ((TextView) findViewById(2131755226)).setText(((Commodity) this.ith.kPm.get(0)).desc);
        ((TextView) findViewById(2131755290)).setText(((Commodity) this.ith.kPm.get(0)).hMV);
        ((TextView) findViewById(2131759955)).setText(com.tencent.mm.wallet_core.ui.e.PQ(this.ith.hNg));
        ((TextView) findViewById(2131758504)).setText(((Commodity) this.ith.kPm.get(0)).eWz);
        TextView textView = (TextView) findViewById(2131758224);
        this.kIV = (TextView) findViewById(2131759958);
        this.kIW = (TextView) findViewById(2131759959);
        v.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[]{Integer.valueOf(this.ith.kPr.kPG)});
        if (this.ith.kPr.kPG == 1) {
            ak.yW();
            this.kIY = (String) c.vf().get(t.a.nsN, "");
            ak.yW();
            this.kIX = (String) c.vf().get(t.a.nsM, "");
            if (be.kS(this.kIX) || be.kS(this.kIX)) {
                v.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
                this.dxy = g.a(this.nDR.nEl, false, null);
                ak.vy().a(new b(), 0);
            } else {
                this.kIW.setText(this.kIY);
                bfc();
            }
        } else {
            this.kJa.setVisibility(8);
        }
        if (be.kS(this.ith.kPr.kPE)) {
            textView.setVisibility(8);
        } else {
            String string = getString(2131236157);
            CharSequence a = com.tencent.mm.pluginsdk.ui.d.e.a(this, getString(2131236156, new Object[]{string, getString(2131236158)}));
            com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this.nDR.nEl);
            CharSequence spannableString = new SpannableString(a);
            spannableString.setSpan(gVar, a.length() - r4.length(), a.length(), 33);
            textView.setTextColor(getResources().getColor(2131689792));
            textView.setText(spannableString);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        }
        this.fzj.setOnClickListener(this);
        bz(this.ith.kPr.kPF);
        hf(this.kJb);
    }

    private void bfc() {
        k.beN();
        ab beO = k.beO();
        if (this.kIZ == null) {
            this.kIZ = beO.a(null, null, true, true);
        }
        if (this.kIZ == null) {
            v.i("MicroMsg.WalletPayDeductUI", "no bank card!");
            finish();
            return;
        }
        CharSequence spannableString = new SpannableString(this.kIZ.field_desc);
        com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this.nDR.nEl);
        final List hk = beO.hk(true);
        gVar.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
            final /* synthetic */ WalletPayDeductUI kJc;

            public final void onClick(View view) {
                h.a(this.kJc.nDR.nEl, hk, null, this.kJc.kIX, this.kJc.kIZ, new com.tencent.mm.ui.base.g.a(this) {
                    final /* synthetic */ AnonymousClass3 kJe;

                    {
                        this.kJe = r1;
                    }

                    public final void oI(int i) {
                        this.kJe.kJc.kIZ = (Bankcard) hk.get(i);
                        this.kJe.kJc.bfc();
                    }
                });
            }
        };
        spannableString.setSpan(gVar, 0, spannableString.length(), 18);
        this.kIV.setText(spannableString);
        this.kIV.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected final void hf(boolean z) {
        int i = 0;
        int i2;
        if (z) {
            findViewById(16908298).setVisibility(0);
            if (this.ith.kPr.kPG == 1) {
                this.kJa.setVisibility(0);
            } else {
                this.kJa.setVisibility(8);
            }
            if (this.kIT != null && this.kIT.size() > 0) {
                int size = this.kIT.size();
                for (i2 = 0; i2 < size; i2++) {
                    this.ezq.aO(((Preference) this.kIT.get(i2)).dnU, false);
                }
                this.ezq.notifyDataSetChanged();
            }
            if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgv()) {
                this.kIU.setVisibility(8);
                this.fzj.setText(2131236162);
            } else {
                this.kIU.setVisibility(0);
                this.kIU.setText(2131236161);
                this.fzj.setText(2131236159);
            }
        } else {
            if (this.kIT != null && this.kIT.size() > 0) {
                i2 = this.kIT.size();
                while (i < i2) {
                    this.ezq.aO(((Preference) this.kIT.get(i)).dnU, true);
                    i++;
                }
            }
            findViewById(16908298).setVisibility(8);
            this.kJa.setVisibility(8);
            this.kIU.setVisibility(8);
            this.fzj.setText(2131236160);
        }
        v.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.kIS.pdq);
    }

    private void bz(List<DeductShowInfo> list) {
        if (list == null || list.size() == 0) {
            v.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
        } else if (this.kIT == null) {
            int size = list.size();
            this.kIT = new ArrayList();
            for (int i = 0; i < size; i++) {
                DeductShowInfo deductShowInfo = (DeductShowInfo) list.get(i);
                if (!(deductShowInfo == null || be.kS(deductShowInfo.name))) {
                    d dVar = new d(this);
                    dVar.setTitle(deductShowInfo.name);
                    dVar.gjc = deductShowInfo.value;
                    dVar.gjg = false;
                    String str = deductShowInfo.url;
                    if (dVar.eYV != null) {
                        dVar.eYV.setTag(2131755080, str);
                    }
                    dVar.setKey("deduct_info_" + i);
                    this.kIT.add(dVar);
                    this.ezq.a(dVar);
                    this.ezq.aO(dVar.dnU, true);
                }
            }
        }
    }

    protected final int getLayoutId() {
        return 2130904665;
    }

    public final boolean a(f fVar, Preference preference) {
        Object obj = null;
        if (preference instanceof d) {
            Object tag;
            d dVar = (d) preference;
            if (dVar.eYV != null) {
                tag = dVar.eYV.getTag(2131755080);
            } else {
                tag = null;
            }
            if (tag != null) {
                obj = tag;
            }
            if (obj != null) {
                String str = (String) obj;
                if (!be.kS(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
            }
        }
        return false;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131756365) {
            Intent intent = new Intent();
            intent.putExtra("auto_deduct_flag", this.kIS.pdq ? 1 : 0);
            if (this.kIS.pdq && this.kIZ != null) {
                intent.putExtra("deduct_bank_type", this.kIZ.field_bankcardType);
                intent.putExtra("deduct_bind_serial", this.kIZ.field_bindSerial);
                v.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[]{this.kIZ.field_bankcardType});
            }
            setResult(-1, intent);
            finish();
        } else if (id == 2131758224 && !be.kS(this.ith.kPr.kPE)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.ith.kPr.kPE);
            intent2.putExtra("showShare", false);
            com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(kVar instanceof b)) {
            v.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
        } else if (i == 0 && i2 == 0) {
            ak.yW();
            this.kIY = (String) c.vf().get(t.a.nsN, getString(2131236344));
            ak.yW();
            this.kIX = (String) c.vf().get(t.a.nsM, getString(2131236347));
            this.kIW.setText(this.kIY);
            bfc();
        }
        if (this.dxy != null) {
            this.dxy.dismiss();
        }
    }
}
