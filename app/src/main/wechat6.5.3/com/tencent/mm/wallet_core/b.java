package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b.h;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class b {
    public Bundle fNM = new Bundle();
    protected a pio;

    public interface a {
        Intent e(int i, Bundle bundle);
    }

    public abstract void a(Activity activity, int i, Bundle bundle);

    public abstract String anS();

    public abstract void d(Activity activity, int i);

    public abstract void d(Activity activity, Bundle bundle);

    public abstract boolean e(Activity activity, Bundle bundle);

    public final b Z(Bundle bundle) {
        this.fNM.putAll(bundle);
        return this;
    }

    private static String bu(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Bundle) {
            return String.format("Bundle: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Context) {
            return String.format("Context: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Class) {
            return String.format("Class: %s, ", new Object[]{((Class) obj).getSimpleName()});
        } else {
            return String.format("Value: %s, ", new Object[]{obj.toString()});
        }
    }

    public final void t(Object... objArr) {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("this %s, procname %s", new Object[]{this, anS()}));
        if (objArr.length <= 0) {
            v.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
            stringBuilder = stringBuilder2.toString();
        } else {
            int length = objArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder2.append(bu(objArr[i])).append(',');
            }
            stringBuilder2.append(bu(objArr[length]));
            stringBuilder = stringBuilder2.toString();
        }
        v.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[]{stringBuilder});
    }

    public final void b(Activity activity, Class<?> cls, Bundle bundle) {
        t("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        activity.startActivity(intent);
        if (bundle != null) {
            this.fNM.putAll(bundle);
        }
        v.d("MicroMsg.ProcessManager", "bankcard tag :" + bKU());
    }

    public final void a(Activity activity, String str, String str2, Bundle bundle) {
        t("startActivity3", activity, str, str2, bundle);
        Class du = c.du(str, str2);
        if (du != null) {
            b(activity, du, bundle);
        } else {
            v.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + str + str2);
        }
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, int i) {
        t("startActivityForResult1", activity, cls, bundle, Integer.valueOf(i));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivityForResult(intent, i);
        if (bundle != null) {
            this.fNM.putAll(bundle);
        }
    }

    public void D(Activity activity) {
        t("finishActivity", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
    }

    public final void a(Activity activity, Class<?> cls, int i) {
        t("finishActivity", activity, cls, "errCode " + i);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivity(intent);
        this.fNM.putInt("key_err_code", i);
    }

    public b c(Activity activity, Bundle bundle) {
        return this;
    }

    public final void a(a aVar) {
        this.pio = aVar;
    }

    public final void af(Activity activity) {
        t("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.fNM != null) {
            this.fNM.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, int i, Intent intent, boolean z) {
        Intent e;
        t("endProcess2", activity, cls, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.pio != null) {
            e = this.pio.e(i, this.fNM);
        } else {
            e = intent;
        }
        if (e == null) {
            e = new Intent(activity, cls);
            e.putExtra("key_process_is_stay", z);
        } else if (!(e.getExtras() == null || e.getExtras().containsKey("key_process_is_stay"))) {
            e.putExtra("key_process_is_stay", true);
        }
        e.addFlags(67108864);
        e.putExtra("key_process_is_end", true);
        activity.startActivity(e);
        if (this.fNM != null) {
            this.fNM.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, String str, String str2, int i, boolean z) {
        a(activity, str, str2, i, null, z);
    }

    public final void a(Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        Intent e;
        t("endProcess3", activity, str, str2, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.pio != null) {
            e = this.pio.e(i, this.fNM);
        } else {
            e = intent;
        }
        if (e == null) {
            e = new Intent();
            e.putExtra("key_process_is_stay", z);
        } else if (!(e.getExtras() == null || e.getExtras().containsKey("key_process_is_stay"))) {
            e.putExtra("key_process_is_stay", true);
        }
        e.addFlags(67108864);
        e.putExtra("key_process_is_end", true);
        c.b(activity, str, str2, e);
        if (this.fNM != null) {
            this.fNM.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, int i, boolean z) {
        a(activity, (Class) cls, i, null, z);
    }

    public final void b(Activity activity, Class<?> cls) {
        a(activity, (Class) cls, -1, null, true);
    }

    public final void d(Activity activity, String str, String str2) {
        a(activity, str, str2, -1, true);
    }

    public final int bKU() {
        return this.fNM.getInt("key_support_bankcard", 1);
    }

    public final boolean bKV() {
        return this.fNM.getBoolean("key_is_oversea", false);
    }

    public final boolean bKW() {
        return this.fNM.getInt("key_pay_flag", 0) == 1;
    }

    public final boolean bKX() {
        return this.fNM.getInt("key_pay_flag", 0) == 3;
    }

    public d a(MMActivity mMActivity, f fVar) {
        return null;
    }

    public boolean i(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean bKY() {
        String string = this.fNM.getString("key_bank_username");
        v.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.fNM.getBoolean("key_is_follow_bank_username", false) + ", username : " + string);
        if (!this.fNM.getBoolean("key_is_follow_bank_username", false) || be.kS(string)) {
            return false;
        }
        ak.vy().a(new h(string), 0);
        return true;
    }

    public int d(MMActivity mMActivity, int i) {
        return -1;
    }

    public boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }
}
