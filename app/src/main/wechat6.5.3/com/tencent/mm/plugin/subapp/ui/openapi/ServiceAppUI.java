package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServiceAppUI extends MMPreference implements e {
    private String bdo;
    private f dxf;
    private ServicePreference kgP;
    private ServicePreference kgQ;
    private PreferenceTitleCategory kgR;
    private PreferenceTitleCategory kgS;
    private List<com.tencent.mm.pluginsdk.model.app.f> kgT = new ArrayList();
    private List<com.tencent.mm.pluginsdk.model.app.f> kgU = new ArrayList();
    private OnItemClickListener kgV;
    private OnItemClickListener kgW;

    static /* synthetic */ void a(ServiceAppUI serviceAppUI, com.tencent.mm.pluginsdk.model.app.f fVar) {
        if (fVar == null) {
            v.e("MicroMsg.ServiceAppUI", "app is null");
            return;
        }
        g.iuh.h(10923, new Object[]{Integer.valueOf(13), fVar.field_appId, Integer.valueOf(1)});
        if (fVar.bxJ == 2 && !be.kS(fVar.bxI)) {
            int size;
            Intent intent;
            Bundle bundle;
            String d = u.d(serviceAppUI.getSharedPreferences(aa.bti(), 0));
            if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                d = Locale.getDefault().toString();
            }
            if (m.dE(serviceAppUI.bdo)) {
                o LC = ak.yW().wO().LC(serviceAppUI.bdo);
                if (LC != null) {
                    size = LC.DM().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", fVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    bundle.putString("sendAppMsgToUserName", serviceAppUI.bdo);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("forceHideShare", true);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.bxI, Integer.valueOf(size), d}));
                    c.b(serviceAppUI.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                    serviceAppUI.finish();
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fVar.field_appId);
            bundle.putBoolean("isFromService", true);
            bundle.putString("sendAppMsgToUserName", serviceAppUI.bdo);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("forceHideShare", true);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.bxI, Integer.valueOf(size), d}));
            c.b(serviceAppUI.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            serviceAppUI.finish();
        } else if (fVar.bxJ == 3) {
            Intent intent2 = new Intent();
            intent2.putExtra("service_app_package_name", fVar.field_packageName);
            intent2.putExtra("service_app_openid", fVar.field_openId);
            intent2.putExtra("service_app_appid", fVar.field_appId);
            serviceAppUI.setResult(-1, intent2);
            serviceAppUI.finish();
        } else if (fVar.bxJ == 1) {
            b.drp.p(serviceAppUI.nDR.nEl, fVar.bxI);
            serviceAppUI.finish();
        }
    }

    public final int Oo() {
        return 2131099716;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        NI();
        if (this.kgP != null) {
            this.kgP.onResume();
        }
        if (this.kgQ != null) {
            this.kgQ.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kgP != null) {
            this.kgP.onPause();
        }
        if (this.kgQ != null) {
            this.kgQ.onPause();
        }
    }

    protected final void NI() {
        vD(2131234926);
        this.bdo = getIntent().getStringExtra("service_app_talker_user");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ServiceAppUI kgX;

            {
                this.kgX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kgX.finish();
                return true;
            }
        });
        this.kgT.clear();
        this.kgU.clear();
        Cursor cQ = m.dE(this.bdo) ? am.bnB().cQ(0, 2) : m.eD(this.bdo) ? am.bnB().cQ(0, 4) : am.bnB().cQ(0, 1);
        if (cQ != null) {
            if (cQ.moveToFirst()) {
                do {
                    com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                    fVar.b(cQ);
                    if (fVar.field_serviceAppType == 1) {
                        this.kgT.add(fVar);
                    } else if (fVar.field_serviceAppType == 2) {
                        this.kgU.add(fVar);
                    }
                } while (cQ.moveToNext());
            }
            cQ.close();
        }
        if (this.kgV == null) {
            this.kgV = new OnItemClickListener(this) {
                final /* synthetic */ ServiceAppUI kgX;

                {
                    this.kgX = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.kgX.kgP == null) {
                        v.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f ro = this.kgX.kgP.ro(i);
                    if (ro == null) {
                        v.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                        return;
                    }
                    v.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(ro.bxJ), ro.field_packageName, ro.field_appId});
                    ServiceAppUI.a(this.kgX, ro);
                }
            };
        }
        if (this.kgW == null) {
            this.kgW = new OnItemClickListener(this) {
                final /* synthetic */ ServiceAppUI kgX;

                {
                    this.kgX = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.kgX.kgQ == null) {
                        v.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f ro = this.kgX.kgQ.ro(i);
                    if (ro == null) {
                        v.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                        return;
                    }
                    v.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(ro.bxJ), ro.field_packageName, ro.field_appId});
                    ServiceAppUI.a(this.kgX, ro);
                }
            };
        }
        this.dxf = this.ocZ;
        this.dxf.removeAll();
        if (this.kgT.size() > 0) {
            this.kgP = new ServicePreference(this);
            this.kgP.kgD = this.kgT;
            if (this.kgV != null) {
                this.kgP.kgG = this.kgV;
            }
            if (this.kgR == null) {
                this.kgR = new PreferenceTitleCategory(this);
                this.kgR.setTitle(2131236695);
            }
            this.dxf.a(this.kgR);
            this.dxf.a(this.kgP);
        }
        if (this.kgU.size() > 0) {
            this.kgQ = new ServicePreference(this);
            this.kgQ.kgD = this.kgU;
            if (this.kgW != null) {
                this.kgQ.kgG = this.kgW;
            }
            if (this.kgS == null) {
                this.kgS = new PreferenceTitleCategory(this);
                this.kgS.setTitle(2131231491);
            }
            this.dxf.a(this.kgS);
            this.dxf.a(this.kgQ);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            v.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
