package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI extends WalletBaseUI {
    private int exT = 0;
    private ListView hOQ;
    private int kFB = 0;
    private int kFF = -1;
    private ArrayList<Bankcard> kFq;
    private Bankcard kFr;
    private String kFs;
    private TextView kGe;
    private b kGf;
    private ArrayList<a> mData = new ArrayList();

    private static class a {
        public String eEL;
        public String title;

        private a() {
            this.title = "";
            this.eEL = "";
        }
    }

    @SuppressLint({"ViewHolder"})
    class b extends BaseAdapter {
        final /* synthetic */ WalletSelectBankcardModeUI kGg;

        public final /* synthetic */ Object getItem(int i) {
            return (a) this.kGg.mData.get(i);
        }

        b(WalletSelectBankcardModeUI walletSelectBankcardModeUI) {
            this.kGg = walletSelectBankcardModeUI;
        }

        public final int getCount() {
            return this.kGg.mData.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(this.kGg, 2130904681, null);
            a aVar = (a) this.kGg.mData.get(i);
            TextView textView = (TextView) inflate.findViewById(2131760020);
            ImageView imageView = (ImageView) inflate.findViewById(2131760021);
            ((TextView) inflate.findViewById(2131760019)).setText(aVar.title);
            if (TextUtils.isEmpty(aVar.eEL)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(aVar.eEL);
            }
            if (this.kGg.kFF == i) {
                imageView.setImageResource(2131165878);
            } else {
                imageView.setImageResource(2131165881);
            }
            return inflate;
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        this.exT = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.kFF = getIntent().getIntExtra("key_select_index", -1);
        v.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.exT);
        NI();
    }

    protected final void NI() {
        vD(2131236022);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletSelectBankcardModeUI kGg;

            {
                this.kGg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kGg.setResult(0);
                this.kGg.finish();
                return true;
            }
        });
        this.kGe = (TextView) findViewById(2131760017);
        if (this.exT == 0) {
            this.kGe.setText(2131236465);
        } else if (this.exT == 1) {
            this.kGe.setText(2131236466);
        }
        this.hOQ = (ListView) findViewById(2131760018);
        this.kGf = new b(this);
        this.hOQ.setAdapter(this.kGf);
        this.hOQ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSelectBankcardModeUI kGg;

            {
                this.kGg = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.kGg.kFF = i;
                this.kGg.kGf.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("key_select_index", i);
                this.kGg.setResult(-1, intent);
                v.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is " + i);
                this.kGg.finish();
            }
        });
        this.mData.clear();
        this.kFs = getString(2131236016);
        if (this.exT == 0) {
            com.tencent.mm.plugin.wallet.a.k.beN();
            ab beO = com.tencent.mm.plugin.wallet.a.k.beO();
            this.kFq = beO.bgH();
            this.kFr = beO.a(this.kFq, null, false, true);
            if (beO.kQU != null) {
                this.kFB = beO.kQU.kFB;
                v.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.kFB);
            } else {
                this.kFB = 0;
                v.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.kFq == null || this.kFq.size() <= 0) {
                v.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                v.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.kFq.size());
                Iterator it = this.kFq.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    a aVar = new a();
                    aVar.title = bankcard.field_desc;
                    if (bankcard.field_fetch_charge_rate <= 0.0d || this.kFB != 1) {
                        v.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + bankcard.field_desc + " field_fetch_charge_rate is " + bankcard.field_fetch_charge_rate + " is_show_charge is " + this.kFB);
                    } else if (TextUtils.isEmpty(bankcard.field_fetch_charge_info)) {
                        aVar.eEL = getString(2131235987) + (bankcard.field_fetch_charge_rate * 100.0d) + "%";
                    } else {
                        aVar.eEL = bankcard.field_fetch_charge_info;
                    }
                    this.mData.add(aVar);
                    if (this.kFF == -1 && this.kFr != null && this.kFr.equals(bankcard)) {
                        this.kFF = i;
                    }
                    i++;
                }
                if (this.kFF == -1 && this.kFr == null) {
                    this.kFF = i;
                }
            }
            a aVar2 = new a();
            aVar2.title = this.kFs;
            aVar2.eEL = "";
            this.mData.add(aVar2);
        }
        this.kGf.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return 2130904680;
    }

    public final boolean ayM() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final int NO() {
        return 1;
    }
}
