package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class WalletUnbindBankCardProxyUI extends WalletBaseUI {
    private String kHq;
    private Bankcard kHr;
    private Map<String, String> kHs;

    public void onCreate(Bundle bundle) {
        Bankcard bankcard = null;
        super.onCreate(bundle);
        Intent intent = getIntent();
        setResult(0);
        if (intent != null) {
            this.kHq = intent.getStringExtra("packageExt");
            if (be.kS(this.kHq)) {
                v.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
                setResult(1);
                finish();
                return;
            }
            Map hashMap;
            String str = this.kHq;
            if (!be.kS(str)) {
                String[] split = str.split("&");
                hashMap = new HashMap();
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        String str22;
                        if (!be.kS(str22)) {
                            int indexOf = str22.indexOf("=");
                            String substring = str22.substring(0, indexOf);
                            str22 = str22.substring(indexOf + 1, str22.length());
                            if (!(be.kS(substring) || be.kS(str22))) {
                                hashMap.put(substring, str22);
                            }
                        }
                    }
                    this.kHs = hashMap;
                    if (this.kHs.containsKey("bank_type") || !this.kHs.containsKey("bind_serial")) {
                        v.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.kHq);
                        setResult(1);
                        finish();
                        return;
                    }
                    Cursor rawQuery = k.bfY().cie.rawQuery("select * from WalletBankcard where bindSerial = '" + ((String) this.kHs.get("bind_serial")) + "'", null);
                    if (rawQuery != null) {
                        if (rawQuery.getCount() == 0) {
                            rawQuery.close();
                        } else {
                            if (rawQuery.moveToNext()) {
                                bankcard = new Bankcard();
                                bankcard.b(rawQuery);
                            }
                            rawQuery.close();
                        }
                    }
                    this.kHr = bankcard;
                    if (this.kHr == null) {
                        v.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
                        setResult(0);
                        finish();
                        return;
                    }
                    intent.putExtra("key_is_show_detail", false);
                    intent.putExtra("key_bankcard", this.kHr);
                    intent.putExtra("scene", 1);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, intent.getExtras(), new b.a(this) {
                        final /* synthetic */ WalletUnbindBankCardProxyUI kHt;

                        {
                            this.kHt = r1;
                        }

                        public final Intent e(int i, Bundle bundle) {
                            switch (i) {
                                case -1:
                                    this.kHt.setResult(-1);
                                    break;
                                case 0:
                                    this.kHt.setResult(0);
                                    break;
                                case 1:
                                    this.kHt.setResult(1);
                                    break;
                            }
                            return null;
                        }
                    });
                    return;
                }
            }
            hashMap = null;
            this.kHs = hashMap;
            if (this.kHs.containsKey("bank_type")) {
            }
            v.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.kHq);
            setResult(1);
            finish();
            return;
        }
        v.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
        finish();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onNewIntent(Intent intent) {
        finish();
    }
}
