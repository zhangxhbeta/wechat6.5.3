package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.mg;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private int cVh = -1;
    private Button kHi;
    c kKz = new c<mg>(this) {
        final /* synthetic */ WalletBankcardIdUI kSd;

        {
            this.kSd = r2;
            this.nhz = mg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mg mgVar = (mg) bVar;
            if (mgVar instanceof mg) {
                WalletBankcardIdUI.a(this.kSd, mgVar.bnr.bns, mgVar.bnr.bnt);
                this.kSd.finish();
                return true;
            }
            v.f("Micromsg.WalletInputCardIDUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    protected WalletFormView kRX;
    protected WalletFormView kRY;
    private Bankcard kRZ;
    private a kSa;
    private boolean kSb = false;
    private boolean kSc;

    private static class a extends BaseAdapter {
        private LayoutInflater CE = null;
        List<l> kSe = new LinkedList();
        private Context mContext = null;

        class a {
            TextView kFY;
            ImageView kSf;
            TextView kSg;
            TextView kSh;
            final /* synthetic */ a kSi;

            a(a aVar) {
                this.kSi = aVar;
            }
        }

        public a(Context context, List<l> list) {
            this.CE = LayoutInflater.from(context);
            this.kSe = list;
            this.mContext = context;
        }

        public final int getCount() {
            if (this.kSe == null) {
                return 0;
            }
            return this.kSe.size();
        }

        public final Object getItem(int i) {
            return this.kSe.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.CE.inflate(2130904626, viewGroup, false);
                aVar = new a(this);
                aVar.kSf = (ImageView) view.findViewById(2131759844);
                aVar.kFY = (TextView) view.findViewById(2131759845);
                aVar.kSg = (TextView) view.findViewById(2131759846);
                aVar.kSh = (TextView) view.findViewById(2131759847);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            l lVar = (l) getItem(i);
            if (be.kS(lVar.hNe)) {
                aVar.kFY.setVisibility(8);
            } else {
                aVar.kFY.setText(lVar.hNe);
                aVar.kFY.setVisibility(0);
            }
            if (be.kS(lVar.kIg)) {
                aVar.kSg.setVisibility(8);
            } else {
                aVar.kSg.setText(lVar.kIg);
                aVar.kSg.setVisibility(0);
            }
            if (be.kS(lVar.kHw)) {
                aVar.kSh.setVisibility(8);
            } else {
                aVar.kSh.setText(lVar.kHw);
                aVar.kSh.setVisibility(0);
            }
            String str = lVar.kIm;
            v.v("Micromsg.WalletInputCardIDUI", "bankType:" + lVar.kIl + ", logurl:" + str);
            aVar.kSf.setImageBitmap(null);
            if (!be.kS(str)) {
                com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
                n.GM();
                aVar2.cPN = null;
                aVar2.cPv = e.cnj;
                aVar2.cPu = com.tencent.mm.plugin.wallet_core.c.b.xK(str);
                aVar2.cPs = true;
                aVar2.cPO = true;
                n.GL().a(str, aVar.kSf, aVar2.GU());
            }
            return view;
        }
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI) {
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.nDR.nEl.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(2130903785, null);
        textView.setText(walletBankcardIdUI.getString(2131236123));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(2131493135);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        g.a(walletBankcardIdUI.nDR.nEl, walletBankcardIdUI.getString(2131236122), walletBankcardIdUI.getString(2131234768), textView, new OnClickListener(walletBankcardIdUI) {
            final /* synthetic */ WalletBankcardIdUI kSd;

            {
                this.kSd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI, String str, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(walletBankcardIdUI);
        if (ae != null) {
            ae.b(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
    }

    protected final int getLayoutId() {
        return 2130904618;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236219);
        NI();
        com.tencent.mm.sdk.c.a.nhr.e(this.kKz);
        this.cVh = this.uA.getInt("key_bind_scene");
    }

    public void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.kKz);
        super.onDestroy();
    }

    protected final void NI() {
        this.kHi = (Button) findViewById(2131756365);
        this.kRX = (WalletFormView) findViewById(2131758526);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kRX);
        this.kRY = (WalletFormView) findViewById(2131759831);
        com.tencent.mm.wallet_core.ui.formview.a.d(this, this.kRY);
        this.kRX.pkk = this;
        this.kHi.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletBankcardIdUI kSd;

            {
                this.kSd = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11353, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                this.kSd.bfv();
            }
        });
        com.tencent.mm.wallet_core.b bLC = bLC();
        if (bLC != null) {
            this.kSc = bLC.fNM.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.kSc = false;
        }
        if (this.kSc) {
            vD(2131236415);
        } else {
            vD(2131236219);
        }
        TextView textView = (TextView) findViewById(2131759758);
        if (k.bga().bgs() || k.bga().bgw()) {
            g gVar = new g(this);
            gVar.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                final /* synthetic */ WalletBankcardIdUI kSd;

                {
                    this.kSd = r1;
                }

                public final void onClick(View view) {
                    v.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
                    WalletBankcardIdUI.a(this.kSd);
                }
            };
            String string = getString(2131236214);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 6, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setVisibility(0);
            CharSequence string2 = this.uA.getString("key_custom_bind_tips");
            if (!be.kS(string2)) {
                textView.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.uA.getParcelable("key_favor_pay_info");
        Orders orders = (Orders) this.uA.getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            a a = b.kRN.a(orders);
            TextView textView2 = (TextView) findViewById(2131759832);
            if (a != null) {
                List Dm = a.Dm(a.Dp(favorPayInfo.kOv));
                if (Dm.size() > 0) {
                    this.kSa = new a(this.nDR.nEl, Dm);
                    textView2.setText(2131236212);
                    textView2.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletBankcardIdUI kSd;

                        {
                            this.kSd = r1;
                        }

                        public final void onClick(View view) {
                            this.kSd.showDialog(1);
                        }
                    });
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                v.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView2.setVisibility(8);
            }
        }
        ab bga = k.bga();
        if (!bga.bgv() || bga.bgB() == null || be.kS(bga.bgB().trim()) || !bga.bgA()) {
            this.kRY.setVisibility(8);
            this.kRX.setHint(getString(2131236216));
        } else {
            this.kRY.setVisibility(0);
            this.kRY.setText(bga.bgB());
            this.kRX.setHint(getString(2131236110));
            this.kRY.setClickable(false);
            this.kRY.setEnabled(false);
        }
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.npk, null);
        if (!be.kS(str)) {
            this.kRX.setHint(str);
        }
        this.kRZ = (Bankcard) this.uA.getParcelable("key_history_bankcard");
        if (this.kRZ != null) {
            this.kRX.setText(this.kRZ.kNr);
            this.kRX.a(new TextWatcher(this) {
                final /* synthetic */ WalletBankcardIdUI kSd;

                {
                    this.kSd = r1;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (this.kSd.kRX.Ou() && !this.kSd.kSb) {
                        this.kSd.kSb = true;
                        this.kSd.kRX.aJx();
                    }
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
        }
        Ox();
        com.tencent.mm.plugin.wallet_core.d.c.a(this, this.uA, 2);
        d(this.kRX, 0, false);
        this.kRX.k(new View.OnClickListener(this) {
            final /* synthetic */ WalletBankcardIdUI kSd;

            {
                this.kSd = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
                com.tencent.mm.wallet_core.ui.e.d(this.kSd, k.bga().bgB());
            }
        });
        if (k.bga().bgz().bgo()) {
            this.kRX.ioA.setVisibility(0);
            this.kRX.ioA.setImageResource(2131166019);
        }
    }

    protected final void bfv() {
        if (bLC() == null) {
            v.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            return;
        }
        String string = bLC().fNM.getString("kreq_token");
        int i = this.uA.getInt("entry_scene", -1);
        if (this.kRZ != null) {
            com.tencent.mm.plugin.wallet_core.b.k kVar = new com.tencent.mm.plugin.wallet_core.b.k(bLx(), null, (PayInfo) this.uA.getParcelable("key_pay_info"), string, this.cVh, i);
            kVar.kLt = this.kRZ.field_bankcardType;
            this.uA.putParcelable("key_history_bankcard", this.kRZ);
            j(kVar);
        } else if (Ox()) {
            j(new com.tencent.mm.plugin.wallet_core.b.k(bLx(), this.kRX.getText(), (PayInfo) this.uA.getParcelable("key_pay_info"), string, this.cVh, i));
        } else {
            g.f(this, 2131236224, 2131231164);
        }
    }

    protected Dialog onCreateDialog(int i) {
        if (i == 1) {
            View inflate = getLayoutInflater().inflate(2130904651, null);
            ((ListView) inflate.findViewById(2131755317)).setAdapter(this.kSa);
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
            aVar.wm(2131236211);
            aVar.cC(inflate);
            aVar.c(null);
            aVar.wp(2131233285);
            return aVar.RX();
        } else if (!this.kSc || i != BaseReportManager.MAX_READ_COUNT) {
            return super.onCreateDialog(i);
        } else {
            int d;
            String string = getString(2131236213);
            com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
            if (ae != null) {
                d = ae.d((MMActivity) this, 1);
            } else {
                d = -1;
            }
            if (d != -1) {
                string = getString(d);
            }
            return g.a(this, true, string, "", getString(2131231183), getString(2131231104), new OnClickListener(this) {
                final /* synthetic */ WalletBankcardIdUI kSd;

                {
                    this.kSd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((com.tencent.mm.plugin.wallet_core.id_verify.a) this.kSd.bLC()).d(this.kSd, 0);
                    this.kSd.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletBankcardIdUI kSd;

                {
                    this.kSd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    View findFocus = this.kSd.nDR.dtW == null ? null : this.kSd.nDR.dtW.findFocus();
                    if (findFocus != null && (findFocus instanceof EditText)) {
                        this.kSd.aJs();
                    }
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("Micromsg.WalletInputCardIDUI", " errCode: " + i2 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k) {
                com.tencent.mm.plugin.wallet_core.b.k kVar2 = (com.tencent.mm.plugin.wallet_core.b.k) kVar;
                if (kVar2.kLs == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.kRX.getText());
                    com.tencent.mm.wallet_core.a.k(this, bundle);
                } else if (kVar2.kLs.kNZ && kVar2.kLs.isError()) {
                    g.f(this, 2131236023, 2131231164);
                    return true;
                } else {
                    bundle.putString("bank_name", kVar2.kLs.kNS);
                    bundle.putParcelable("elemt_query", kVar2.kLs);
                    bundle.putString("key_card_id", this.kRX.getText());
                    com.tencent.mm.wallet_core.a.k(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.kRX.getText());
            com.tencent.mm.wallet_core.a.k(this, bundle);
            return true;
        }
        return false;
    }

    private boolean Ox() {
        if (this.kRX.de(null)) {
            this.kHi.setEnabled(true);
            this.kHi.setClickable(true);
            return true;
        }
        this.kHi.setEnabled(false);
        this.kHi.setClickable(false);
        return false;
    }

    public final void fc(boolean z) {
        if (!z) {
            this.kRZ = null;
            this.uA.putParcelable("key_history_bankcard", null);
        }
        Ox();
    }

    protected final boolean beY() {
        return true;
    }

    protected final int NO() {
        return 1;
    }
}
