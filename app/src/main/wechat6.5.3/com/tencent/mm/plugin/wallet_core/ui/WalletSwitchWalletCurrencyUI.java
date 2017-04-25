package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.b.e;
import com.tencent.mm.plugin.wallet_core.b.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI extends WalletBaseUI implements OnClickListener {
    private ListView kVS;
    private ArrayList<s> kVT = null;
    private l kVU = null;
    private s kVV;
    private s kVW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236488);
        ak.yW();
        c.vf().a(a.nrO, Boolean.valueOf(true));
        getIntent().getIntExtra("switch_wallet_scene", 0);
        this.kVT = k.bgd().bgS();
        if (this.kVT == null || this.kVT.size() == 0) {
            v.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
            hr(true);
        } else {
            v.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
            hr(false);
        }
        NI();
        setResult(0);
    }

    protected final void NI() {
        this.kVS = (ListView) findViewById(2131760035);
        this.kVU = new l(this, this.kVT);
        this.kVS.setAdapter(this.kVU);
        if (this.kVT != null && this.kVT.size() > 0) {
            this.kVU.mData = this.kVT;
            this.kVU.notifyDataSetChanged();
        }
        this.kVS.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSwitchWalletCurrencyUI kVX;

            {
                this.kVX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                s sv = this.kVX.kVU.sv(i);
                this.kVX.kVW = this.kVX.kVU.kVY;
                if (sv == null) {
                    return;
                }
                if (this.kVX.kVW == null || !this.kVX.kVW.field_wallet_tpa_country.equals(sv.field_wallet_tpa_country)) {
                    this.kVX.kVV = sv;
                    WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI = this.kVX;
                    String str = sv.field_wallet_tpa_country;
                    v.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = " + str);
                    walletSwitchWalletCurrencyUI.p(new g(str));
                }
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof e) {
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
                this.kVT = k.bgd().bgS();
                this.kVU.mData = this.kVT;
                this.kVU.notifyDataSetChanged();
                return true;
            }
            v.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
            if (this.kVT == null) {
                v.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
                return false;
            }
            v.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
            return true;
        } else if (!(kVar instanceof g) || i != 0 || i2 != 0) {
            return false;
        } else {
            this.kVV.field_wallet_selected = 1;
            v.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.kVV.field_wallet_type + " " + this.kVV.field_wallet_tpa_country_mask);
            k.bgd().a(this.kVV, new String[0]);
            s sVar = this.kVU.kVY;
            if (sVar != null) {
                sVar.field_wallet_selected = 0;
                k.bgd().a(sVar, new String[0]);
            }
            ak.yW();
            c.vf().set(339975, Integer.valueOf(this.kVV.field_wallet_type));
            ak.yW();
            c.vf().a(a.nsQ, Integer.valueOf(this.kVV.field_wallet_tpa_country_mask));
            if (com.tencent.mm.model.k.xU()) {
                k.bfW();
                k.q(this, null);
            }
            setResult(-1);
            finish();
            return true;
        }
    }

    protected final int getLayoutId() {
        return 2130904687;
    }

    private void hr(boolean z) {
        v.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = " + z);
        b(new e(), z);
    }

    public void onClick(View view) {
    }
}
