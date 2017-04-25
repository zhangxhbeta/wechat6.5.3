package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@a(3)
public class WalletPayUStartOpenUI extends WalletBaseUI {
    private String hUm;
    private WalletPayUOpenIntroView kZa;
    private MMFormMobileInputView kZb;
    private EditText kZc;
    private EditText kZd;
    private Button kZe;
    private TextView kZf;
    private TextView kZg;
    private String kZh;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hUm = this.uA.getString("key_mobile");
        this.kZh = this.uA.getString("dial_code");
        if (be.kS(this.kZh)) {
            this.kZh = "27";
        }
        this.kZa = (WalletPayUOpenIntroView) findViewById(2131758537);
        WalletPayUOpenIntroView walletPayUOpenIntroView = this.kZa;
        walletPayUOpenIntroView.kYY = new d[]{new d(2130838861, 2131236392, 2131236386), new d(2130838862, 2131236393, 2131236387), new d(2130838863, 2131236394, 2131236388)};
        walletPayUOpenIntroView.acG = new ArrayList();
        if (walletPayUOpenIntroView.kYY != null) {
            for (int i = 0; i < walletPayUOpenIntroView.kYY.length; i++) {
                walletPayUOpenIntroView.acG.add(LayoutInflater.from(walletPayUOpenIntroView.mContext).inflate(2130904158, null));
            }
        }
        walletPayUOpenIntroView.kYX = new a();
        walletPayUOpenIntroView.kYV.a(walletPayUOpenIntroView.kYX);
        walletPayUOpenIntroView.kYW.dh(walletPayUOpenIntroView.kYY == null ? 0 : walletPayUOpenIntroView.kYY.length, 0);
        this.kZb = (MMFormMobileInputView) findViewById(2131758538);
        this.kZe = (Button) findViewById(2131758539);
        this.kZc = this.kZb.nKp;
        this.kZd = this.kZb.nVf;
        if (!be.kS(this.hUm)) {
            this.kZd.setText(this.hUm);
        }
        if (!be.kS(this.kZh)) {
            this.kZc.setText(this.kZh);
        }
        TextWatcher anonymousClass1 = new TextWatcher(this) {
            final /* synthetic */ WalletPayUStartOpenUI kZi;

            {
                this.kZi = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.kZi.bhC();
            }
        };
        this.kZd.addTextChangedListener(anonymousClass1);
        this.kZc.addTextChangedListener(anonymousClass1);
        this.kZe.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUStartOpenUI kZi;

            {
                this.kZi = r1;
            }

            public final void onClick(View view) {
                if (this.kZi.kZb.getVisibility() == 0) {
                    this.kZi.uA.putString("key_mobile", this.kZi.hUm);
                    this.kZi.uA.putString("dial_code", this.kZi.kZh);
                }
                this.kZi.bLD().j(new Object[0]);
            }
        });
        this.kZf = (TextView) findViewById(2131758531);
        c.a(this, this.kZf);
        this.kZg = (TextView) findViewById(2131758540);
        this.kZg.setText(q.bLl());
    }

    public void onResume() {
        super.onResume();
        bhC();
    }

    private String beP() {
        return this.kZb.getCountryCode().startsWith("+") ? this.kZb.getCountryCode().substring(1) : this.kZb.getCountryCode();
    }

    private void bhC() {
        if (this.kZb.getVisibility() == 0) {
            boolean z = (be.kS(beP()) || be.kS(this.kZd.getText().toString())) ? false : true;
            if (z) {
                this.kZh = beP();
                this.hUm = this.kZb.bBT();
                this.kZe.setEnabled(true);
                return;
            }
            this.kZe.setEnabled(false);
        }
    }

    protected final boolean beY() {
        return true;
    }

    protected final int getLayoutId() {
        return 2130904156;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
