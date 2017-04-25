package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class CardAddEntranceUI extends MMActivity {
    private String appId;
    private int bon = 8;
    private String eHE = "";
    private String eHF;
    private int eHG = 0;
    LinkedList<iv> eHu = new LinkedList();

    protected final int getLayoutId() {
        return 2130903204;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
            setResult(0);
            finish();
            return;
        }
        v.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.bon = intent.getIntExtra("key_from_scene", 8);
        this.eHG = intent.getIntExtra("key_stastic_scene", 0);
        v.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.bon + "  from_origin_scene:" + this.eHG);
        this.eHE = intent.getStringExtra("key_package_name");
        String stringExtra2 = intent.getStringExtra("key_sign");
        String stringExtra3 = getIntent().getStringExtra("src_username");
        v.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:" + stringExtra3);
        String stringExtra4 = getIntent().getStringExtra("js_url");
        this.appId = getIntent().getStringExtra("key_app_id");
        this.eHF = getIntent().getStringExtra("key_transaction");
        String stringExtra5 = getIntent().getStringExtra("key_consumed_card_id");
        v.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:" + stringExtra5);
        String stringExtra6 = getIntent().getStringExtra("key_template_id");
        List al = f.al(stringExtra, this.bon);
        if (al == null || al.size() == 0) {
            v.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
            setResult(0);
            finish();
            return;
        }
        this.eHu.clear();
        this.eHu.addAll(al);
        Intent intent2 = new Intent();
        intent2.putExtra("key_from_scene", this.bon);
        intent2.putExtra("key_stastic_scene", this.eHG);
        if (al.size() == 1) {
            iv ivVar = (iv) al.get(0);
            intent2.putExtra("key_card_id", ivVar.eBK);
            intent2.putExtra("key_card_ext", ivVar.bom);
            intent2.putExtra("src_username", stringExtra3);
            intent2.putExtra("js_url", stringExtra4);
            intent2.putExtra("key_consumed_card_id", stringExtra5);
            intent2.putExtra("key_template_id", stringExtra6);
            intent2.setClass(this, CardDetailUI.class);
            startActivityForResult(intent2, 1);
            return;
        }
        intent2.putExtra("key_in_card_list", stringExtra);
        intent2.putExtra("key_package_name", this.eHE);
        intent2.putExtra("key_sign", stringExtra2);
        intent2.putExtra("src_username", stringExtra3);
        intent2.putExtra("js_url", stringExtra4);
        intent2.putExtra("key_consumed_card_id", stringExtra5);
        intent2.putExtra("key_template_id", stringExtra6);
        intent2.setClass(this, CardAcceptCardListUI.class);
        startActivityForResult(intent2, 2);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
        if (i2 == -1) {
            v.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
        } else {
            v.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = this.eHu.iterator();
        while (it.hasNext()) {
            iv ivVar = (iv) it.next();
            e eVar = new e();
            eVar.eBK = ivVar.eBK;
            eVar.bom = ivVar.bom;
            linkedList.add(eVar);
        }
        Intent intent2;
        if (i != 1) {
            if (i == 2) {
                v.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
                Object obj = "";
                if (intent != null) {
                    obj = intent.getStringExtra("card_list");
                }
                if (this.bon != 7 && this.bon != 16) {
                    switch (i2) {
                        case -1:
                            if (!TextUtils.isEmpty(obj)) {
                                E(-1, obj);
                                break;
                            } else {
                                E(-1, f.a(linkedList, true, this.bon));
                                break;
                            }
                        case 0:
                            if (!TextUtils.isEmpty(obj)) {
                                E(0, obj);
                                break;
                            } else {
                                E(0, f.a(linkedList, false, this.bon));
                                break;
                            }
                        default:
                            break;
                    }
                }
                intent2 = new Intent();
                switch (i2) {
                    case -1:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", f.qr(obj));
                            setResult(-1, intent);
                            break;
                        }
                        intent2.putExtra("card_list", f.a(linkedList, true, this.bon));
                        setResult(-1, intent2);
                        break;
                    case 0:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", f.qr(obj));
                            setResult(0, intent);
                            break;
                        }
                        intent2.putExtra("card_list", f.a(linkedList, false, this.bon));
                        intent2.putExtra("result_code", 1);
                        setResult(0, intent2);
                        break;
                        break;
                    default:
                        break;
                }
            }
        }
        v.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
        if (this.bon != 7 && this.bon != 16) {
            switch (i2) {
                case -1:
                    if (intent != null && linkedList.size() > 0) {
                        ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                    }
                    E(-1, f.a(linkedList, true, this.bon));
                    break;
                case 0:
                    E(0, f.a(linkedList, false, this.bon));
                    break;
                default:
                    break;
            }
        }
        intent2 = new Intent();
        switch (i2) {
            case -1:
                if (intent != null && linkedList.size() > 0) {
                    ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                }
                intent2.putExtra("card_list", f.a(linkedList, true, this.bon));
                setResult(-1, intent2);
                break;
            case 0:
                intent2.putExtra("card_list", f.a(linkedList, false, this.bon));
                setResult(0, intent2);
                break;
        }
        finish();
    }

    private void E(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_add_card_to_wx_card_list", str);
        com.tencent.mm.pluginsdk.model.app.f aC = g.aC(this.appId, true);
        com.tencent.mm.sdk.f.a.a aVar = new com.tencent.mm.sdk.f.a.a(bundle);
        if (aC != null) {
            aVar.bfm = aC.field_openId;
        }
        aVar.lBj = this.eHF;
        String str2 = "MicroMsg.CardAddEntranceUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.appId;
        objArr[1] = aC == null ? "null appinfo" : aC.field_appName;
        objArr[2] = aC == null ? "null appinfo" : aC.field_openId;
        objArr[3] = this.eHF;
        v.i(str2, str3, objArr);
        aVar.t(bundle);
        v.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:" + i);
        if (i == -1) {
            aVar.errCode = 0;
        } else {
            aVar.errCode = -2;
        }
        com.tencent.mm.sdk.a.a.a aVar2 = new com.tencent.mm.sdk.a.a.a();
        aVar2.nhj = this.eHE;
        aVar2.nhl = bundle;
        p.R(bundle);
        p.S(bundle);
        com.tencent.mm.sdk.a.a.a(aa.getContext(), aVar2);
    }
}
