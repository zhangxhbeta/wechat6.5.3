package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.af.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class RegByMobileVoiceVerifySelectUI extends MMPreference implements e {
    private f dxf;
    private String iMg;
    private a[] nLh;

    public final void a(int i, int i2, String str, k kVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        NI();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int Oo() {
        return 2130903175;
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).nIA;
        if (aVar == null) {
            return false;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("voice_verify_language", aVar.nIB);
        bundle.putString("voice_verify_code", aVar.nID);
        intent.putExtras(bundle);
        setResult(0, intent);
        finish();
        return true;
    }

    protected final void NI() {
        axg();
        this.iMg = getIntent().getExtras().getString("voice_verify_code");
        vD(2131231459);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifySelectUI nLi;

            {
                this.nLi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nLi.axg();
                this.nLi.finish();
                return true;
            }
        });
        this.nLh = bAZ();
        if (this.nLh != null && this.nLh.length > 0) {
            this.dxf.removeAll();
            this.dxf.a(new PreferenceCategory(this));
            for (a aVar : this.nLh) {
                if (aVar.nID.equalsIgnoreCase(this.iMg)) {
                    aVar.gxa = true;
                }
                Preference languagePreference = new LanguagePreference(this);
                languagePreference.a(aVar);
                languagePreference.setKey(aVar.nID);
                this.dxf.a(languagePreference);
            }
        }
    }

    public static String Ol(String str) {
        a[] bAZ = bAZ();
        String jo = b.jo(str);
        for (a aVar : bAZ) {
            if (aVar.nID.equalsIgnoreCase(jo)) {
                return aVar.nIB;
            }
        }
        return "English";
    }

    private static a[] bAZ() {
        String[] split = aa.getContext().getString(2131231453).trim().split(",");
        a[] aVarArr = new a[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            aVarArr[i] = new a(split2[1], split2[2], split2[0], false);
        }
        return aVarArr;
    }
}
