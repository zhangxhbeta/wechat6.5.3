package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.s;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.e.a.m;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.o;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.config.j.b;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.f;
import java.io.Serializable;
import java.util.HashMap;

public final class AppBrandProfileUI extends b implements OnClickListener, b {
    private String dRA;
    private c dRB;
    private long dRC = 0;
    private LinearLayout dRD;
    private ImageView dRE;
    private TextView dRF;
    private TextView dRG;
    private TextView dRH;
    private a dRI;
    private View oCJ;
    private AppBrandExportUrlParams oCK;
    private View owj;

    private final class a extends s implements OnClickListener {
        String bkp;
        final /* synthetic */ AppBrandProfileUI dRJ;
        ImageView dRO;
        TextView dRP;

        static /* synthetic */ void a(a aVar, bjg com_tencent_mm_protocal_c_bjg) {
            aVar.dRP.setText(com_tencent_mm_protocal_c_bjg.title);
            aVar.bkp = com_tencent_mm_protocal_c_bjg.username;
            com.tencent.mm.t.a.b.AL().a(aVar.dRO, com_tencent_mm_protocal_c_bjg.eBZ, com.tencent.mm.t.a.a.AK(), com.tencent.mm.t.a.c.cxH);
        }

        a(AppBrandProfileUI appBrandProfileUI, View view) {
            this.dRJ = appBrandProfileUI;
            super(view);
            this.dRP = (TextView) view.findViewById(2131755392);
            this.dRO = (ImageView) view.findViewById(2131755391);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            if (!be.kS(this.bkp)) {
                com.tencent.mm.ay.c.b(this.aal.getContext(), "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", this.bkp).putExtra("key_start_biz_profile_from_app_brand_profile", true).putExtra("force_get_contact", true));
                this.dRJ.bd(3, 1);
            }
        }
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI) {
        f fVar = new f(appBrandProfileUI, f.pbS, false);
        fVar.jXn = new n.c(appBrandProfileUI) {
            final /* synthetic */ AppBrandProfileUI dRJ;

            {
                this.dRJ = r1;
            }

            public final void a(l lVar) {
                lVar.dg(1, 2131230941);
            }
        };
        fVar.jXo = new d(appBrandProfileUI) {
            final /* synthetic */ AppBrandProfileUI dRJ;

            {
                this.dRJ = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        if (this.dRJ.oCK == null) {
                            v.e("MicroMsg.AppBrandProfileUI", "appBrandExportUrlParams is null");
                            return;
                        }
                        Intent intent = new Intent();
                        String a = g.a(this.dRJ.oCK);
                        v.i("MicroMsg.AppBrandProfileUI", "appBrandExportUrlParams:%s", new Object[]{this.dRJ.oCK.toString()});
                        v.v("MicroMsg.AppBrandProfileUI", "KRawUrl " + a);
                        intent.putExtra("rawUrl", a);
                        intent.putExtra("forceHideShare", true);
                        com.tencent.mm.ay.c.b(this.dRJ, "webview", ".ui.tools.WebViewUI", intent);
                        this.dRJ.bd(7, 1);
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, c cVar, long j) {
        if (!appBrandProfileUI.isFinishing() && !appBrandProfileUI.nDT && cVar != null) {
            if ((appBrandProfileUI.dRB == null || !be.ma(appBrandProfileUI.dRB.dCR).equals(cVar.dCR)) && appBrandProfileUI.dRE != null) {
                com.tencent.mm.t.a.b.AL().a(appBrandProfileUI.dRE, cVar.dCR, com.tencent.mm.t.a.a.AK(), new com.tencent.mm.t.a.c());
            }
            if ((appBrandProfileUI.dRB == null || !be.ma(appBrandProfileUI.dRB.dCP).equals(cVar.dCP)) && appBrandProfileUI.dRF != null) {
                appBrandProfileUI.dRF.setText(cVar.dCP);
                appBrandProfileUI.Fd(cVar.dCP);
            }
            if ((appBrandProfileUI.dRB == null || !be.ma(appBrandProfileUI.dRB.dCN).equals(cVar.dCN)) && appBrandProfileUI.dRG != null) {
                if (be.kS(cVar.dCN)) {
                    appBrandProfileUI.dRG.setText("");
                    appBrandProfileUI.dRG.setVisibility(8);
                } else {
                    appBrandProfileUI.dRG.setText(cVar.dCN);
                    appBrandProfileUI.dRG.setVisibility(0);
                }
            }
            if ((appBrandProfileUI.dRB == null || !be.ma(cVar.Px()).equals(appBrandProfileUI.dRB.Px())) && appBrandProfileUI.dRH != null) {
                appBrandProfileUI.dRH.setText(cVar.Px());
                appBrandProfileUI.owj.setVisibility(0);
            }
            if (appBrandProfileUI.dRI != null) {
                if (be.bP(cVar.Pw())) {
                    appBrandProfileUI.dRI.aal.setVisibility(8);
                } else {
                    a.a(appBrandProfileUI.dRI, (bjg) cVar.Pw().get(0));
                    appBrandProfileUI.dRI.aal.setVisibility(0);
                }
                if (j != appBrandProfileUI.dRC && (2 & j) > 0) {
                    appBrandProfileUI.dRI.aal.setVisibility(8);
                }
            }
            if (appBrandProfileUI.dRB == null || appBrandProfileUI.dRB.dCV == null || !(cVar.dCV == null || cVar.dCV.ndI == appBrandProfileUI.dRB.dCV.ndI)) {
                boolean z = cVar.dCV == null || cVar.dCV.ndI != 0;
                appBrandProfileUI.bI(z);
            }
            appBrandProfileUI.dRB = cVar;
            appBrandProfileUI.dRC = j;
        }
    }

    public static void a(Context context, String str, String str2, AppBrandExportUrlParams appBrandExportUrlParams) {
        if (!be.kS(str)) {
            if (context == null) {
                context = aa.getContext();
            }
            Intent putExtra = new Intent(context, AppBrandProfileUI.class).putExtra("key_username", str).putExtra("key_from_scene", 3).putExtra("key_scene_note", str2).putExtra("key_can_swipe_back", true).putExtra("key_scene_export_url_params", appBrandExportUrlParams);
            if (!(context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            context.startActivity(putExtra);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (!be.kS(this.dRA)) {
            com.tencent.mm.plugin.appbrand.a.a.OO().b(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.dRA = stringExtra;
        if (be.kS(stringExtra)) {
            finish();
        } else {
            bB(true);
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        bd(6, 1);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.dRA = stringExtra;
        if (be.kS(stringExtra)) {
            finish();
            return;
        }
        this.oCK = (AppBrandExportUrlParams) getIntent().getParcelableExtra("key_scene_export_url_params");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandProfileUI dRJ;

            {
                this.dRJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dRJ.onBackPressed();
                return true;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandProfileUI dRJ;

            {
                this.dRJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandProfileUI.a(this.dRJ);
                return true;
            }
        });
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(2130903109, this.dRD, true);
        View inflate2 = from.inflate(2130903108, this.dRD, true);
        this.dRE = (ImageView) inflate.findViewById(2131755383);
        this.dRF = (TextView) inflate.findViewById(2131755384);
        this.dRG = (TextView) inflate.findViewById(2131755385);
        this.dRH = (TextView) inflate.findViewById(2131755388);
        this.owj = inflate.findViewById(2131760117);
        this.dRI = new a(this, inflate.findViewById(2131755389));
        this.oCJ = inflate.findViewById(2131755393);
        bI(true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        inflate2.setClickable(false);
        inflate2.setLongClickable(false);
        View findViewById = inflate2.findViewById(2131755381);
        inflate = inflate2.findViewById(2131755382);
        findViewById.setOnClickListener(this);
        inflate.setOnClickListener(this);
        bB(true);
        bd(1, 1);
    }

    protected final void bB(View view) {
        super.bB(view);
        View scrollView = new ScrollView(this);
        scrollView.setBackgroundResource(2131689531);
        this.dRD = new LinearLayout(this);
        this.dRD.setOrientation(1);
        scrollView.addView(this.dRD, new LayoutParams(-1, -2));
        ((FrameLayout) view).addView(scrollView);
    }

    protected final void onResume() {
        super.onResume();
        if (this.nFw != null) {
            this.nFw.hVC = getIntent().getBooleanExtra("key_can_swipe_back", true);
        }
    }

    private void bI(boolean z) {
        if (this.oCJ != null) {
            if (z) {
                this.oCJ.setVisibility(8);
                return;
            }
            this.oCJ.setVisibility(0);
            this.oCJ.setOnClickListener(this);
        }
    }

    private void bd(int i, int i2) {
        m mVar = new m();
        mVar.aWJ.aWH = this.dRA;
        com.tencent.mm.sdk.c.a.nhr.z(mVar);
        String str = mVar.aWK.appId;
        int intExtra = getIntent().getIntExtra("key_from_scene", 3);
        String ma = be.ma(getIntent().getStringExtra("key_scene_note"));
        v.d("MicroMsg.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s", new Object[]{Integer.valueOf(13919), str, Integer.valueOf(intExtra), ma, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.plugin.report.service.g.iuh.h(13919, new Object[]{str, Integer.valueOf(intExtra), ma, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(be.Nh())});
    }

    protected final void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.appbrand.a.a.OO().b(this);
    }

    public final void onClick(final View view) {
        switch (view.getId()) {
            case 2131755381:
                if (this.dRB != null) {
                    String str;
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1024;
                    String str2 = this.dRB.dCO;
                    String str3 = this.dRB.dCP;
                    String str4 = this.dRB.dCU.mbH;
                    if (be.kS(this.dRB.dCR)) {
                        str = this.dRB.dCQ;
                    } else {
                        str = this.dRB.dCR;
                    }
                    AppBrandLaunchingLogic.a(this, str2, str3, str4, 0, str, null, appBrandStatObject, true);
                    bd(4, 1);
                    return;
                }
                return;
            case 2131755382:
                final c ng = com.tencent.mm.plugin.appbrand.a.a.OO().ng(this.dRA);
                if (ng == null) {
                    v.w("MicroMsg.AppBrandProfileUI", "attrs is null.");
                    return;
                }
                Serializable hashMap = new HashMap();
                hashMap.put("desc", "");
                hashMap.put("title", ng.dCP);
                hashMap.put("img_url", ng.dCR);
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("scene_from", 3);
                intent.putExtra("appbrand_params", hashMap);
                intent.putExtra("Retr_Msg_Type", 2);
                com.tencent.mm.ay.c.a((MMActivity) view.getContext(), ".ui.transmit.SelectConversationUI", intent, 1, new com.tencent.mm.ui.MMActivity.a(this) {
                    final /* synthetic */ AppBrandProfileUI dRJ;

                    public final void a(int i, int i2, Intent intent) {
                        if (i != 1) {
                            this.dRJ.bd(5, 2);
                        } else if (i2 == -1) {
                            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                            if (stringExtra == null || stringExtra.length() == 0) {
                                v.i("MicroMsg.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
                                return;
                            }
                            v.i("MicroMsg.AppBrandProfileUI", "result success toUser : %s ", new Object[]{stringExtra});
                            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
                            String str = ng.dCU != null ? ng.dCU.mbH : "";
                            o.yx().n(o.fz("wxapp_" + str), true).l("prePublishId", "wxapp_" + str);
                            com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
                            aVar.title = ng.dCP;
                            aVar.type = 33;
                            aVar.cqp = this.dRJ.dRA;
                            aVar.cqq = str;
                            aVar.cqr = 1;
                            aVar.bnX = "wxapp_" + str;
                            aVar.thumburl = ng.dCQ;
                            aVar.url = g.mI(str);
                            aVar.bnR = this.dRJ.dRA;
                            aVar.bnS = ng.dCP;
                            com.tencent.mm.pluginsdk.model.app.l.a(aVar, str, ng.dCP, stringExtra, null, null);
                            if (!be.kS(stringExtra2)) {
                                mr mrVar = new mr();
                                mrVar.boa.bob = stringExtra;
                                mrVar.boa.content = stringExtra2;
                                mrVar.boa.type = com.tencent.mm.model.m.fp(stringExtra);
                                mrVar.boa.flags = 0;
                                com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                            }
                            com.tencent.mm.ui.base.g.bf(view.getContext(), view.getContext().getResources().getString(2131231155));
                            this.dRJ.bd(5, 1);
                        }
                    }
                });
                return;
            case 2131755393:
                if (this.dRB != null && !be.kS(this.dRB.dCU.mbH)) {
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", g.mH(this.dRB.dCU.mbH)).putExtra("forceHideShare", true));
                    bd(2, 1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void bB(final boolean z) {
        e.a(new Runnable(this) {
            final /* synthetic */ AppBrandProfileUI dRJ;

            public final void run() {
                final c ng = com.tencent.mm.plugin.appbrand.a.a.OO().ng(this.dRJ.dRA);
                final long nf = com.tencent.mm.plugin.appbrand.a.a.OO().nf(this.dRJ.dRA);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 pQV;

                    public final void run() {
                        AppBrandProfileUI.a(this.pQV.dRJ, ng, nf);
                        if (z && !this.pQV.dRJ.isFinishing() && !this.pQV.dRJ.nDT) {
                            com.tencent.mm.plugin.appbrand.a.a.OO().a(this.pQV.dRJ);
                        }
                    }
                });
                if (z && (ng == null || ng.Pw() == null || be.kS(ng.Px()))) {
                    k.J(this.dRJ.dRA, true);
                } else {
                    k.a(this.dRJ.dRA, null);
                }
            }
        }, "AppBrandProfile");
    }

    public final void PD() {
        bB(false);
    }
}
