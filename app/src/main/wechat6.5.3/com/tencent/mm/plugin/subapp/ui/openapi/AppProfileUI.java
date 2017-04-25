package com.tencent.mm.plugin.subapp.ui.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI extends MMPreference implements a {
    private f dxf;
    private com.tencent.mm.pluginsdk.model.app.f gpF;
    private ac handler = null;
    private AppHeaderPreference.a kgN;

    public final int Oo() {
        return 2131099655;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected void onResume() {
        super.onResume();
        am.bnB().c(this);
    }

    protected void onPause() {
        am.bnB().d(this);
        super.onPause();
    }

    protected final void NI() {
        boolean z = true;
        this.kgN = new AppHeaderPreference.a(this) {
            final /* synthetic */ AppProfileUI kgO;

            {
                this.kgO = r1;
            }

            public final String aZz() {
                return g.a(this.kgO.nDR.nEl, this.kgO.gpF, null);
            }

            public final Bitmap aZA() {
                return g.b(this.kgO.gpF.field_appId, 1, com.tencent.mm.bd.a.getDensity(this.kgO));
            }

            public final String gD(boolean z) {
                return this.kgO.nDR.nEl.getString(z ? 2131235101 : 2131235109);
            }

            public final String getHint() {
                ActionBarActivity actionBarActivity = this.kgO.nDR.nEl;
                com.tencent.mm.pluginsdk.model.app.f a = this.kgO.gpF;
                if (actionBarActivity == null || a == null) {
                    return null;
                }
                String di = g.di(actionBarActivity);
                if (di.equalsIgnoreCase("zh_CN")) {
                    return a.field_appDiscription;
                }
                return (di.equalsIgnoreCase("zh_TW") || di.equalsIgnoreCase("zh_HK")) ? be.kS(a.field_appDiscription_tw) ? a.field_appDiscription : a.field_appDiscription_tw : di.equalsIgnoreCase("en") ? be.kS(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en : be.kS(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en;
            }
        };
        this.gpF = g.aC(getIntent().getStringExtra("AppProfileUI_AppId"), true);
        String str = "initView : appInfo does not exist";
        if (this.gpF == null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        vD(2131231132);
        this.dxf = this.ocZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppProfileUI kgO;

            {
                this.kgO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kgO.finish();
                return true;
            }
        });
        refresh();
    }

    private void refresh() {
        boolean z;
        boolean z2 = true;
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099655);
        if (this.gpF.field_status == 1) {
            this.dxf.Ox("app_profile_add");
        } else {
            this.dxf.Ox("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.dxf.Ow("app_profile_header");
        AppHeaderPreference.a aVar = this.kgN;
        if (this.gpF.field_status == 1) {
            z = true;
        } else {
            z = false;
        }
        if (aVar == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        appHeaderPreference.kgE = aVar;
        appHeaderPreference.brc = z;
    }

    private void aZB() {
        this.handler = new ac(this) {
            final /* synthetic */ AppProfileUI kgO;

            {
                this.kgO = r1;
            }

            public final void handleMessage(Message message) {
                this.kgO.finish();
            }
        };
        this.handler.sendEmptyMessageDelayed(0, 30);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.gpF.field_status = 1;
            this.gpF.field_modifyTime = System.currentTimeMillis();
            am.bnB().a(this.gpF, new String[0]);
            refresh();
            a(this.gpF, true);
            aZB();
            return true;
        } else if (!str.equals("app_profile_remove")) {
            return false;
        } else {
            this.gpF.field_status = 0;
            this.gpF.field_modifyTime = System.currentTimeMillis();
            am.bnB().a(this.gpF, new String[0]);
            refresh();
            a(this.gpF, false);
            aZB();
            return true;
        }
    }

    public final void a(String str, i iVar) {
        if (str.equals(this.gpF.field_appId)) {
            NI();
        }
    }

    private static void a(com.tencent.mm.pluginsdk.model.app.f fVar, boolean z) {
        List linkedList = new LinkedList();
        linkedList.add(new com.tencent.mm.ak.i.a(10165, fVar.field_appId + "," + (z ? "1" : "2")));
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.i(linkedList));
    }
}
