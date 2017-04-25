package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class BottleWizardStep2 extends MMPreference {
    private c euU;

    public final int Oo() {
        return 2131099660;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235088);
        this.euU = new c(this, this.ocZ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep2 euV;

            {
                this.euV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.euV.goBack();
                return true;
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep2 euV;

            {
                this.euV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                c.XM();
                bf zO = bf.zO();
                if (be.a(Integer.valueOf(zO.bBZ), 0) <= 0) {
                    g.A(this.euV.nDR.nEl, this.euV.getString(2131231534), this.euV.getString(2131231164));
                } else if (be.kS(zO.getProvince())) {
                    g.A(this.euV.nDR.nEl, this.euV.getString(2131231533), this.euV.getString(2131231164));
                } else {
                    Intent intent = new Intent().setClass(this.euV, BottleBeachUI.class);
                    intent.addFlags(67108864);
                    this.euV.startActivity(intent);
                    this.euV.finish();
                }
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent().setClass(this, BottleWizardStep1.class);
        intent.addFlags(67108864);
        startActivity(intent);
        axg();
        finish();
    }

    public void onResume() {
        super.onResume();
        this.euU.update();
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str.equals("settings_district")) {
            return this.euU.XO();
        }
        if (str.equals("settings_signature")) {
            return this.euU.XN();
        }
        return false;
    }
}
