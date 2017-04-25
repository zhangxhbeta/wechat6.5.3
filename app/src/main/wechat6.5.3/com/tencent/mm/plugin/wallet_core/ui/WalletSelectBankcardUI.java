package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSelectBankcardUI extends WalletBaseUI {
    private int cVh = 0;
    private MaxListView kVA;
    private TextView kVB;
    private a kVC = null;
    private String kVD = null;
    private boolean kVE = true;
    private String kVF = null;
    private List<Bankcard> kVG = null;
    private TextView kVz;

    private class a extends BaseAdapter {
        final /* synthetic */ WalletSelectBankcardUI kVH;

        class a {
            TextView kVK;
            final /* synthetic */ a kVL;

            a(a aVar) {
                this.kVL = aVar;
            }
        }

        private a(WalletSelectBankcardUI walletSelectBankcardUI) {
            this.kVH = walletSelectBankcardUI;
        }

        public final int getCount() {
            return this.kVH.kVE ? this.kVH.kVG == null ? 1 : this.kVH.kVG.size() + 1 : this.kVH.kVG == null ? 0 : this.kVH.kVG.size();
        }

        public final Object getItem(int i) {
            if (this.kVH.kVG == null || this.kVH.kVG.size() <= i) {
                return null;
            }
            return this.kVH.kVG.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            Bankcard bankcard = (Bankcard) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(this.kVH).inflate(2130904682, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.kVK = (TextView) view.findViewById(2131760022);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (bankcard != null) {
                aVar.kVK.setText(bankcard.field_desc);
            } else {
                aVar.kVK.setText(2131236464);
            }
            return view;
        }
    }

    static /* synthetic */ void a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        walletSelectBankcardUI.uA.putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.bLD().j(new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236022);
        this.cVh = this.uA.getInt("key_scene", 0);
        this.kVD = this.uA.getString("key_top_tips");
        this.kVE = this.uA.getBoolean("key_is_show_new_bankcard", true);
        this.kVF = this.uA.getString("bottom_tips");
        this.kVG = this.uA.getParcelableArrayList("key_showing_bankcards");
        if (this.kVG == null) {
            this.kVG = k.bga().bgG();
        }
        this.kVz = (TextView) findViewById(2131760023);
        this.kVA = (MaxListView) findViewById(2131760024);
        this.kVB = (TextView) findViewById(2131760025);
        if (be.kS(this.kVD)) {
            this.kVz.setVisibility(8);
        } else {
            this.kVz.setVisibility(0);
            this.kVz.setText(this.kVD);
        }
        if (be.kS(this.kVF)) {
            this.kVB.setVisibility(8);
        } else {
            this.kVB.setVisibility(0);
            this.kVB.setText(this.kVF);
        }
        if (this.cVh == 0) {
            this.kVB.setVisibility(0);
            g gVar = new g(this);
            gVar.kTx = new com.tencent.mm.plugin.wallet_core.ui.g.a(this) {
                final /* synthetic */ WalletSelectBankcardUI kVH;

                {
                    this.kVH = r1;
                }

                public final void onClick(View view) {
                    v.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
                    e.bk(this.kVH, this.kVH.getString(2131236026));
                }
            };
            String string = getString(2131236458);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 14, string.length(), 33);
            this.kVB.setText(spannableString);
            this.kVB.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.kVC = new a();
        this.kVA.setAdapter(this.kVC);
        this.kVA.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSelectBankcardUI kVH;

            {
                this.kVH = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i);
                if (bankcard != null) {
                    g.a(this.kVH, true, this.kVH.getString(2131236460, new Object[]{bankcard.field_desc, bankcard.field_mobile}), this.kVH.getString(2131236462), this.kVH.getString(2131236459), this.kVH.getString(2131236461), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 kVJ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kVJ.kVH.uA.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                            WalletSelectBankcardUI.a(this.kVJ.kVH, bankcard);
                            com.tencent.mm.plugin.report.service.g.iuh.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 kVJ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kVJ.kVH.uA.putBoolean("key_balance_change_phone_need_confirm_phone", true);
                            WalletSelectBankcardUI.a(this.kVJ.kVH, bankcard);
                        }
                    });
                    return;
                }
                this.kVH.uA.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(this.kVH, null);
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904683;
    }

    protected final boolean beY() {
        return true;
    }
}
