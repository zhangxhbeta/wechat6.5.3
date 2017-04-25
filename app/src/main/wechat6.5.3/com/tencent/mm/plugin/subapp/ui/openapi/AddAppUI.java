package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class AddAppUI extends MMPreference implements e {
    private f dxf;
    private AppPreference kgy;
    private AppPreference kgz;

    static /* synthetic */ void a(AddAppUI addAppUI, String str) {
        Intent intent = new Intent(addAppUI, AppProfileUI.class);
        intent.putExtra("AppProfileUI_AppId", str);
        addAppUI.startActivity(intent);
    }

    static /* synthetic */ void d(com.tencent.mm.pluginsdk.model.app.f fVar) {
        fVar.field_status = 0;
        fVar.field_modifyTime = System.currentTimeMillis();
        am.bnB().a(fVar, new String[0]);
    }

    public final int Oo() {
        return 2131099652;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        NI();
        if (this.kgy != null) {
            this.kgy.onResume();
        }
        if (this.kgz != null) {
            this.kgz.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kgy != null) {
            this.kgy.onPause();
        }
        if (this.kgz != null) {
            this.kgz.onPause();
        }
    }

    protected final void NI() {
        vD(2131230820);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddAppUI kgA;

            {
                this.kgA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kgA.finish();
                return true;
            }
        });
        this.dxf = this.ocZ;
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099652);
        this.kgy = (AppPreference) this.dxf.Ow("addapp_added");
        this.kgy.kgC = 1;
        this.kgy.kgG = new OnItemClickListener(this) {
            final /* synthetic */ AddAppUI kgA;

            {
                this.kgA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.a(this.kgA, this.kgA.kgy.ro(i).field_appId);
            }
        };
        this.kgy.kgH = new OnItemClickListener(this) {
            final /* synthetic */ AddAppUI kgA;

            {
                this.kgA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.d(this.kgA.kgy.ro(i));
                this.kgA.NI();
            }
        };
        this.kgz = (AppPreference) this.dxf.Ow("addapp_available");
        this.kgz.kgC = 0;
        this.kgz.kgG = new OnItemClickListener(this) {
            final /* synthetic */ AddAppUI kgA;

            {
                this.kgA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.a(this.kgA, this.kgA.kgz.ro(i).field_appId);
            }
        };
    }

    public final boolean a(f fVar, Preference preference) {
        if (!preference.dnU.equals("addapp_recommend")) {
            return false;
        }
        String d = u.d(this.nDR.nEl.getSharedPreferences(aa.bti(), 0));
        String string = getString(2131230825, new Object[]{Integer.valueOf(d.lWh), d, u.bsX()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        c.b(this, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            v.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
