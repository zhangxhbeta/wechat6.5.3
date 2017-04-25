package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXPayEntryActivity extends AutoLoginActivity {
    private String enO = null;

    public void onCreate(Bundle bundle) {
        r.i(getIntent(), "key_auto_login_wizard_exit");
        super.onCreate(bundle);
    }

    protected final boolean p(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        boolean z = true;
        if (intent == null) {
            finish();
            return;
        }
        v.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = " + aVar);
        switch (aVar) {
            case LOGIN_OK:
                break;
            case LOGIN_CANCEL:
                iq(-2);
                v.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + aVar);
                finish();
                return;
            case LOGIN_FAIL:
                iq(-1);
                v.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + aVar);
                finish();
                return;
            default:
                v.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        this.enO = r.g(intent, "_mmessage_appPackage");
        v.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.enO);
        if (getIntent() == null || r.T(getIntent()) == null) {
            z = false;
        } else {
            com.tencent.mm.sdk.g.a aVar2 = new com.tencent.mm.sdk.g.a();
            aVar2.u(r.T(getIntent()));
            String str = aVar2.appId;
            v.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = " + str);
            if (str == null || str.length() == 0) {
                v.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
                z = false;
            } else {
                f aC = g.aC(str, true);
                if (aC == null) {
                    v.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
                    aC = new f();
                    aC.field_appId = str;
                    aC.field_appName = SQLiteDatabase.KeyEmpty;
                    aC.field_packageName = this.enO;
                    aC.field_status = 0;
                    String aM = p.aM(this, this.enO);
                    if (aM != null) {
                        aC.field_signature = aM;
                    }
                    if (am.bnB().m(aC) && t.kS(aC.field_openId)) {
                        v.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = " + str);
                        am.bnF().Ez(str);
                    }
                } else if (aC.field_status == 3) {
                    v.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
                    z = false;
                } else if (!p.b(this, aC, this.enO)) {
                    AutoLoginActivity.a(this, aC, this.enO, 5);
                    v.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
                    z = false;
                }
            }
        }
        if (!z) {
            v.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
        try {
            intent.putExtra("key_scene", 0);
        } catch (Throwable e) {
            v.a("MicroMsg.IntentUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        e.a((Context) this, r.T(intent), z);
        finish();
    }

    private void iq(int i) {
        com.tencent.mm.sdk.g.a aVar = new com.tencent.mm.sdk.g.a();
        aVar.u(r.T(getIntent()));
        com.tencent.mm.sdk.g.a.a aVar2 = new com.tencent.mm.sdk.g.a.a();
        aVar2.u(r.T(getIntent()));
        b bVar = new b();
        bVar.kXw = aVar.kXw;
        bVar.nhO = aVar.nhO;
        bVar.errCode = i;
        com.tencent.mm.plugin.wallet_index.ui.a.a(this, r.g(getIntent(), "_mmessage_appPackage"), bVar, aVar2);
    }
}
