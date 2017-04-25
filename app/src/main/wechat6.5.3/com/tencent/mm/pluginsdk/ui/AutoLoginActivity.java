package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.fv;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mmdb.database.SQLiteDatabase;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity extends MMActivity {

    public enum a {
        LOGIN_OK,
        LOGIN_FAIL,
        LOGIN_CANCEL
    }

    public abstract void a(a aVar, Intent intent);

    public abstract boolean p(Intent intent);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vB(8);
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
            finish();
            return;
        }
        c.brh();
        v.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + intent.getAction());
        int a = r.a(intent, "wizard_activity_result_code", -2);
        v.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = " + a);
        if (a != -2) {
            tM(a);
        } else if (!p(intent)) {
            v.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
        } else if (aDX()) {
            finish();
            v.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
        } else {
            ak.yY();
            a(a.LOGIN_OK, intent);
        }
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            super.onNewIntent(intent);
            setIntent(intent);
            int a = r.a(intent, "wizard_activity_result_code", 0);
            v.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = " + a);
            tM(a);
        }
    }

    private void tM(int i) {
        switch (i) {
            case -1:
                a(a.LOGIN_OK, getIntent());
                return;
            case 0:
                aDX();
                return;
            case 1:
                a(a.LOGIN_CANCEL, getIntent());
                return;
            default:
                v.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = " + i);
                a(a.LOGIN_FAIL, getIntent());
                return;
        }
    }

    public boolean aDX() {
        if (ak.uN() && !ak.uG()) {
            return false;
        }
        v.w("MicroMsg.AutoLoginActivity", "not login");
        Intent intent = new Intent(this, getClass());
        intent.putExtras(getIntent());
        intent.addFlags(67108864);
        intent.setDataAndType(getIntent().getData(), getIntent().getType());
        intent.setAction(getIntent().getAction());
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        c.a((Context) this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", intent2, intent);
        return true;
    }

    public static void a(Context context, f fVar, String str, int i) {
        Signature[] aN = p.aN(context, str);
        Object obj = SQLiteDatabase.KeyEmpty;
        if (aN != null && aN.length > 0) {
            int length = aN.length;
            int i2 = 0;
            while (i2 < length) {
                i2++;
                String str2 = obj + p.GF(g.m(aN[i2].toByteArray())) + "|";
            }
        }
        if (obj.length() > 1) {
            obj = obj.substring(0, obj.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_package_name", be.ah(str, SQLiteDatabase.KeyEmpty));
            jSONObject.put("package_name", be.ah(fVar.field_packageName, SQLiteDatabase.KeyEmpty));
            jSONObject.put("raw_signature", obj);
            jSONObject.put("signature", be.ah(fVar.field_signature, SQLiteDatabase.KeyEmpty));
            jSONObject.put("scene", i);
        } catch (Exception e) {
            v.i("MicroMsg.AutoLoginActivity", "doIfAppInValid, jsonException = " + e.getMessage());
        }
        b fvVar = new fv();
        fvVar.bfk.appId = fVar.field_appId;
        fvVar.bfk.opType = 3;
        fvVar.bfk.aZh = jSONObject.toString();
        com.tencent.mm.sdk.c.a.nhr.z(fvVar);
    }

    public int getLayoutId() {
        return -1;
    }
}
