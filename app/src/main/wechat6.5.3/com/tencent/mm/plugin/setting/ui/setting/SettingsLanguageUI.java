package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.account.LanguagePreference;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.d.d;
import com.tencent.mm.ui.k.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsLanguageUI extends MMPreference {
    private static final String[] iMe = t.iMe;
    private f dxf;
    private List<a> iMf;
    private String iMg;
    private boolean iMh = false;

    static /* synthetic */ void a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        Locale Ke = u.Ke(str);
        if ("language_default".equalsIgnoreCase(str)) {
            if (VERSION.SDK_INT >= 24) {
                Ke = u.nik;
                Locale.setDefault(Ke);
            } else {
                Ke = Locale.getDefault();
            }
        }
        u.a(settingsLanguageUI.getSharedPreferences(aa.bti(), 0), str);
        u.a(settingsLanguageUI, Ke);
        ba.setProperty("system_property_key_locale", str);
        aa.setResources(com.tencent.mm.be.a.a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            com.tencent.mm.plugin.setting.a.drp.t(new Intent(), settingsLanguageUI);
            return;
        }
        ak.vy().a(new ay(new ay.a(settingsLanguageUI) {
            final /* synthetic */ SettingsLanguageUI iMi;

            {
                this.iMi = r1;
            }

            public final void a(e eVar) {
                if (eVar != null) {
                    c BU = eVar.BU();
                    byte[] bArr = new byte[0];
                    ak.yW();
                    BU.i(bArr, com.tencent.mm.model.c.ww());
                }
            }
        }), 0);
        ak.yW();
        com.tencent.mm.model.c.vf().set(-29414086, "TAG_DEFAULT_TAB");
        ak.yW();
        com.tencent.mm.model.c.vf().set(-29414083, Integer.valueOf(0));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        aa.getContext().sendBroadcast(intent);
        FontSelectorView.aNx();
        j.sV().cgL.clear();
        intent = new Intent();
        intent.putExtra("Intro_Need_Clear_Top ", true);
        com.tencent.mm.plugin.setting.a.drp.t(intent, settingsLanguageUI);
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
        return -1;
    }

    protected final void NI() {
        int i = 0;
        vD(2131235037);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsLanguageUI iMi;

            {
                this.iMi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMi.axg();
                this.iMi.finish();
                return true;
            }
        });
        a(0, getString(2131235036), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsLanguageUI iMi;

            {
                this.iMi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMi.finish();
                SettingsLanguageUI.a(this.iMi, this.iMi.iMg, this.iMi.iMh);
                return true;
            }
        }, b.nET);
        this.iMh = getIntent().getBooleanExtra("not_auth_setting", false);
        this.dxf.removeAll();
        String[] stringArray = getResources().getStringArray(2131296281);
        this.iMg = u.e(getSharedPreferences(aa.bti(), 0));
        this.iMf = new ArrayList();
        while (i < iMe.length) {
            String str = iMe[i];
            this.iMf.add(new a(stringArray[i], "", str, this.iMg.equalsIgnoreCase(str)));
            i++;
        }
        for (a aVar : this.iMf) {
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            this.dxf.a(languagePreference);
        }
        this.dxf.a(new PreferenceCategory(this));
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).nIA;
        if (aVar == null) {
            return false;
        }
        this.iMg = aVar.nID;
        for (a aVar2 : this.iMf) {
            aVar2.gxa = false;
        }
        aVar.gxa = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
