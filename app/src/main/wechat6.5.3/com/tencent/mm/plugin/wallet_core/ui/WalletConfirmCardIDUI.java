package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.k;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI extends WalletBaseUI {
    private boolean kTA = true;
    private Button kTy;
    private TenpaySegmentEditText kTz;

    protected final int getLayoutId() {
        return 2130904635;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        Object string = this.uA.getString("key_bankcard_id");
        Bitmap bitmap = (Bitmap) this.uA.getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            v.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
        } else if (bitmap == null) {
            v.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
        } else {
            vD(2131236151);
            this.kTy = (Button) findViewById(2131756365);
            this.kTz = (TenpaySegmentEditText) findViewById(2131759881);
            this.kTz.setText(string);
            this.mKeyboard = (MyKeyboardWindow) findViewById(2131756017);
            this.hcJ = findViewById(2131756016);
            ((ImageView) findViewById(2131759880)).setImageBitmap(bitmap);
            this.kTz.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) this.nDR.nEl.getSystemService("input_method")).hideSoftInputFromWindow(this.kTz.getWindowToken(), 0);
            this.hcJ.setVisibility(8);
            this.kTz.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletConfirmCardIDUI kTB;

                {
                    this.kTB = r1;
                }

                public final void onClick(View view) {
                    if (!(this.kTB.hcJ.isShown() || this.kTB.kTA)) {
                        this.kTB.hcJ.setVisibility(0);
                        this.kTB.mKeyboard.setVisibility(0);
                    }
                    this.kTB.kTA = false;
                }
            });
            final String str = this.kTz.get3DesEncrptData();
            this.kTy.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletConfirmCardIDUI kTB;

                public final void onClick(View view) {
                    String str = this.kTB.kTz.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        g.iuh.h(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(2)});
                    } else {
                        g.iuh.h(11353, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                    }
                    this.kTB.j(new k(this.kTB.bLx(), this.kTB.kTz.getEncryptDataWithHash(false), (PayInfo) this.kTB.uA.getParcelable("key_pay_info"), this.kTB.uA.getInt("entry_scene", -1)));
                }
            });
            this.mKeyboard = (MyKeyboardWindow) findViewById(2131756017);
            this.hcJ = findViewById(2131756016);
            View findViewById = findViewById(2131756018);
            if (!(this.mKeyboard == null || this.hcJ == null)) {
                findViewById.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletConfirmCardIDUI kTB;

                    {
                        this.kTB = r1;
                    }

                    public final void onClick(View view) {
                        this.kTB.NP();
                    }
                });
            }
            this.kTz.setFocusable(false);
            this.kTz.setFocusableInTouchMode(true);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof k) {
                k kVar2 = (k) kVar;
                if (kVar2.kLs == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.kTz.getEncryptDataWithHash(false));
                    a.k(this, bundle);
                } else if (kVar2.kLs.kNZ && kVar2.kLs.isError()) {
                    com.tencent.mm.ui.base.g.f(this, 2131236023, 2131231164);
                    return true;
                } else {
                    bundle.putString("bank_name", kVar2.kLs.kNS);
                    bundle.putParcelable("elemt_query", kVar2.kLs);
                    bundle.putString("key_card_id", this.kTz.getEncryptDataWithHash(false));
                    a.k(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof k)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.kTz.getEncryptDataWithHash(false));
            a.k(this, bundle);
            return true;
        }
        return false;
    }
}
