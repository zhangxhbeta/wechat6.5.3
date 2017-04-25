package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.plugin.luckymoney.sns.b.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected f ezq;
    protected CheckBoxPreference hcD;

    private static void mx(int i) {
        nt ntVar = new nt();
        ntVar.boO.key = i;
        ntVar.boO.value = 1;
        ntVar.boO.bna = true;
        a.nhr.z(ntVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        mx(116);
    }

    protected final void NI() {
        this.ezq = this.ocZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyFreePwdSetting hcE;

            {
                this.hcE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hcE.finish();
                return false;
            }
        });
        vD(2131233614);
        this.hcD = (CheckBoxPreference) this.ezq.Ow("open_sns_pay_pref");
        axQ();
    }

    protected void onResume() {
        axQ();
        super.onResume();
    }

    private void axQ() {
        boolean z = true;
        if (com.tencent.mm.plugin.luckymoney.sns.c.a.axZ() != 1) {
            z = false;
        }
        this.hcD.ocf = z;
        this.cnm.edit().putBoolean("open_sns_pay_pref", z).commit();
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.c.a.aya())) {
            v.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
            this.hcD.setTitle(2131233611);
        } else {
            v.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.c.a.aya());
            this.hcD.setTitle(com.tencent.mm.plugin.luckymoney.sns.c.a.aya());
        }
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.c.a.ayb())) {
            v.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
            this.hcD.setSummary(2131233610);
        } else {
            v.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.c.a.ayb());
            this.hcD.setSummary(com.tencent.mm.plugin.luckymoney.sns.c.a.ayb());
        }
        this.ezq.notifyDataSetChanged();
    }

    private void ec(boolean z) {
        this.cnm.edit().putBoolean("open_sns_pay_pref", z).commit();
        this.hcD.ocf = z;
        this.ezq.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final boolean f(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            v.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (i != 0 || i2 != 0) {
                mx(119);
                v.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                axQ();
            } else if (((b) kVar).hdr == 1) {
                v.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                mx(119);
                ec(true);
            } else {
                ec(false);
                mx(118);
                v.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        return false;
    }

    public final int Oo() {
        return 2131099737;
    }

    public final boolean a(f fVar, Preference preference) {
        if ("open_sns_pay_pref".equals(preference.dnU)) {
            if (this.hcD.isChecked() || com.tencent.mm.plugin.luckymoney.sns.c.a.axZ() != 1) {
                mx(120);
                com.tencent.mm.wallet_core.a.a(this, a.class, null, null);
            } else {
                bLG().a(new b(0, "", ""), true, true);
                mx(117);
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
