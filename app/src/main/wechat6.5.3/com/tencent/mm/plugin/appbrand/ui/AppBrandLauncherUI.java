package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppBrandLauncherUI extends b {
    private static final int dRj;
    private static final int dRk;
    private static final int dRl = Color.parseColor("#BFBFC3");
    private int dRm;
    private boolean dRn = false;
    private int dRo;

    static abstract class a extends Fragment {
        View Hq;
        int cVh;

        abstract void NI();

        a() {
        }

        void RZ() {
        }

        final int ho(int i) {
            Context aG = aG();
            if (aG == null) {
                aG = aa.getContext();
            }
            return com.tencent.mm.bd.a.fromDPToPix(aG, i);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Hq = new FrameLayout(viewGroup.getContext());
            NI();
            return this.Hq;
        }
    }

    static abstract class b<T> extends com.tencent.mm.plugin.appbrand.k.f.a {
        protected final List<T> dRq;
        protected final List<T> dRr;

        public b(List<T> list, List<T> list2) {
            this.dRq = list;
            this.dRr = list2;
        }

        public final int Sf() {
            return this.dRq == null ? 0 : this.dRq.size();
        }

        public final int Sg() {
            return this.dRr == null ? 0 : this.dRr.size();
        }
    }

    static {
        int parseColor = Color.parseColor("#EFEFF4");
        dRj = parseColor;
        dRk = parseColor;
    }

    final void bA(boolean z) {
        Class cls = z ? d.class : c.class;
        Fragment E = super.aS().E(2131755016);
        if (E == null || !cls.isInstance(E)) {
            n aW = super.aS().aW();
            a dVar;
            if (z) {
                dVar = new d();
                dVar.cVh = this.dRm;
                aW.b(2131755016, dVar);
            } else {
                dVar = new c();
                dVar.cVh = this.dRm;
                aW.b(2131755016, dVar);
            }
            aW.commit();
        }
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && !f.Sl()) {
            f.a(getWindow(), true);
            return dRk;
        } else if (VERSION.SDK_INT >= 21) {
            return dRl;
        } else {
            return super.getStatusBarColor();
        }
    }

    @TargetApi(21)
    protected final void PK() {
        super.PK();
        getWindow().setSoftInputMode(3);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nd ndVar = new nd();
        com.tencent.mm.sdk.c.a.nhr.z(ndVar);
        if (ndVar.dRM.dRN) {
            this.dRn = true;
            this.dRm = getIntent().getIntExtra("enter_desktop_scene", 1);
            if (cU().cV() != null) {
                cU().cV().setBackgroundDrawable(new ColorDrawable(dRj));
            }
            P(new Runnable(this) {
                final /* synthetic */ AppBrandLauncherUI dRp;

                {
                    this.dRp = r1;
                }

                public final void run() {
                    if (!this.dRp.nDT && !this.dRp.isFinishing()) {
                        Fragment E = super.aS().E(2131755016);
                        if (E != null && (E instanceof a)) {
                            ((a) E).RZ();
                        }
                    }
                }
            });
            Fd(getResources().getString(2131230936));
            vC(-16777216);
            k kVar = this.nDR;
            if (kVar.nEr != null) {
                kVar.nEr.setBackgroundColor(2130706432);
            }
            a(new OnMenuItemClickListener(this) {
                final /* synthetic */ AppBrandLauncherUI dRp;

                {
                    this.dRp = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.dRp.onBackPressed();
                    return true;
                }
            }, 2130837829);
            if (d.bRN()) {
                Drawable mutate = com.tencent.mm.svg.b.a.c(getResources(), 2131165207).mutate();
                mutate.setColorFilter(-16777216, Mode.SRC_ATOP);
                this.nDR.a(0, getString(2131235684), mutate, new OnMenuItemClickListener(this) {
                    final /* synthetic */ AppBrandLauncherUI dRp;

                    {
                        this.dRp = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                        intent.putExtra("neverGetA8Key", true);
                        intent.setClass(this.dRp.nDR.nEl, AppBrandSearchUI.class);
                        intent.putExtra("key_trust_url", true);
                        intent.putExtra("title", this.dRp.getString(2131230944));
                        intent.putExtra("searchbar_tips", this.dRp.getString(2131230944));
                        intent.putExtra("KRightBtn", true);
                        intent.putExtra("ftsneedkeyboard", true);
                        intent.putExtra("ftsType", 64);
                        intent.putExtra("ftsbizscene", 201);
                        Map hashMap = new HashMap();
                        hashMap.put("scene", "201");
                        hashMap.put(Columns.TYPE, "64");
                        hashMap.put("lang", u.dJ(aa.getContext()));
                        hashMap.put("platform", "android");
                        hashMap.put("version", String.valueOf(c.RM()));
                        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100192");
                        boolean z = Ls.isValid() && "1".equals(Ls.buX().get("openSearchSuggestion"));
                        v.i("MicroMsg.WxaFTSSearchLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b", new Object[]{Integer.valueOf(201), Boolean.valueOf(false), Integer.valueOf(64), Boolean.valueOf(z), Boolean.valueOf(false)});
                        if (z) {
                            hashMap.put("isSug", "1");
                        }
                        hashMap.put("isHomePage", "0");
                        intent.putExtra("rawUrl", c.l(hashMap));
                        intent.putExtra("key_load_js_without_delay", true);
                        intent.addFlags(67108864);
                        intent.putExtra("key_nearby_url", com.tencent.mm.plugin.appbrand.f.a.QL());
                        intent.putExtra("key_nearby_list_id", com.tencent.mm.plugin.appbrand.f.a.QN());
                        StringBuilder stringBuilder = new StringBuilder("sid_");
                        ak.yW();
                        com.tencent.mm.t.b.jHr = stringBuilder.append(com.tencent.mm.model.c.ww()).append("_").append(be.Ni()).toString();
                        v.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[]{com.tencent.mm.t.b.jHr});
                        intent.putExtra("key_session_id", com.tencent.mm.t.b.jHr);
                        String str = "key_search_input_hint";
                        ak.yW();
                        Object obj = com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.pRG, null);
                        String str2 = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
                        intent.putExtra(str, str2);
                        this.dRp.startActivityForResult(intent, 1);
                        return true;
                    }
                });
            }
            this.nDR.dtW.setBackgroundColor(dRj);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            View frameLayout = new FrameLayout(this);
            frameLayout.setId(2131755016);
            ((ViewGroup) this.nDR.dtW).addView(frameLayout, layoutParams);
            g.iuh.a(465, 0, 1, false);
            return;
        }
        finish();
    }

    protected final boolean Sd() {
        return true;
    }

    protected final void onResume() {
        boolean z;
        super.onResume();
        getStatusBarColor();
        if (!this.dRn) {
            if (this.dRo == 1) {
                this.dRm = 7;
            } else if (this.dRo == 2) {
                this.dRm = 8;
            } else {
                this.dRm = 4;
            }
            this.dRo = 0;
            a aVar = (a) super.aS().E(2131755016);
            if (aVar != null) {
                aVar.cVh = this.dRm;
            }
        }
        this.dRn = false;
        if (com.tencent.mm.plugin.appbrand.a.a.dzS.Pp()) {
            z = true;
        } else {
            com.tencent.mm.plugin.appbrand.b.c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
            com.tencent.mm.plugin.appbrand.b.c.Pq();
            z = false;
        }
        bA(z);
    }

    protected final void Se() {
        setRequestedOrientation(1);
    }

    protected final void onPause() {
        super.onPause();
    }

    protected final void onDestroy() {
        super.onDestroy();
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.dRo = i;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            v.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[]{stringExtra, com.tencent.mm.t.b.jHs});
            g.iuh.h(13929, new Object[]{stringExtra, com.tencent.mm.t.b.jHs, Integer.valueOf(2)});
        }
    }

    public final void finish() {
        super.finish();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void setTitle(CharSequence charSequence) {
        H(charSequence);
    }

    public final void setTitle(int i) {
        vD(i);
    }

    public final void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
