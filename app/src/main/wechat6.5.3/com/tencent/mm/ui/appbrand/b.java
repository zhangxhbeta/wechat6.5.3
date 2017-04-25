package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.m;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.f;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    private String appId;
    private String cID;
    Context context;
    f dNk;
    private IconHeaderView dNl;
    b nPq;
    a nPr;
    String nPs;
    boolean nPt;
    AppBrandExportUrlParams pRJ;
    int scene;
    int type;
    String username;

    public interface a {
        boolean bBw();
    }

    public interface b {
        boolean bBx();
    }

    static /* synthetic */ void a(b bVar, Context context, AppBrandExportUrlParams appBrandExportUrlParams) {
        if (appBrandExportUrlParams == null) {
            v.e("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams is null");
            return;
        }
        v.i("MicroMsg.AppBrandSerivceActionSheet", "type :%d, exportUrlParams : %s", Integer.valueOf(bVar.type), appBrandExportUrlParams.toString());
        if (!be.kS(bVar.username)) {
            Intent intent = new Intent();
            intent.putExtra("key_username", bVar.username);
            intent.putExtra("key_from_scene", 4);
            intent.putExtra("key_scene_export_url_params", appBrandExportUrlParams);
            c.b(context, "appbrand", ".ui.AppBrandProfileUI", intent);
            bVar.K(bVar.username, bVar.scene, 1);
        }
    }

    public b(Context context, String str, int i, int i2, String str2, boolean z) {
        this(context, str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, null, i, i2, str2);
        this.nPt = z;
    }

    public b(final Context context, String str, String str2, String str3, AppBrandExportUrlParams appBrandExportUrlParams, int i, int i2, String str4) {
        this.nPs = SQLiteDatabase.KeyEmpty;
        this.context = context;
        this.username = str;
        this.cID = str2;
        this.appId = str3;
        this.pRJ = appBrandExportUrlParams;
        this.type = i;
        this.nPs = str4;
        this.scene = i2;
        this.dNk = new f(context, f.pbS, true);
        switch (this.type) {
            case 1:
            case 2:
                this.dNl = new IconHeaderView(context);
                this.dNl.J(this.cID);
                this.dNl.j(new OnClickListener(this) {
                    final /* synthetic */ b nPu;

                    public final void onClick(View view) {
                        b.a(this.nPu, context, this.nPu.pRJ);
                        this.nPu.dNk.bKi();
                    }
                });
                com.tencent.mm.pluginsdk.ui.a.b.o(this.dNl.nPI, this.username);
                this.dNk.dd(this.dNl);
                break;
            case 3:
            case 4:
                View inflate = q.em(context).inflate(2130903281, null);
                TextView textView = (TextView) inflate.findViewById(2131756062);
                if (this.type == 3) {
                    textView.setText(context.getString(2131230992));
                } else {
                    textView.setText(context.getString(2131230994));
                }
                this.dNk.dd(inflate);
                break;
            case 5:
            case 6:
                this.pRJ = new AppBrandExportUrlParams(this.appId, 4);
                this.dNl = new IconHeaderView(context);
                this.dNl.J(this.cID);
                com.tencent.mm.pluginsdk.ui.a.b.o(this.dNl.nPI, this.username);
                this.dNl.nPI.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b nPu;

                    {
                        this.nPu = r1;
                    }

                    public final void onClick(View view) {
                    }
                });
                this.dNl.j(new OnClickListener(this) {
                    final /* synthetic */ b nPu;

                    public final void onClick(View view) {
                        b.a(this.nPu, context, this.nPu.pRJ);
                        this.nPu.dNk.bKi();
                    }
                });
                this.dNk.dd(this.dNl);
                break;
        }
        this.dNk.jXn = new n.c(this) {
            final /* synthetic */ b nPu;

            public final void a(l lVar) {
                if (this.nPu.nPr == null || !this.nPu.nPr.bBw()) {
                    switch (this.nPu.type) {
                        case 1:
                            lVar.d(2, context.getString(2131230993));
                            return;
                        case 2:
                            lVar.d(3, context.getString(2131230995));
                            return;
                        case 3:
                            lVar.d(5, context.getString(2131230961));
                            return;
                        case 4:
                            lVar.d(6, context.getString(2131230962));
                            return;
                        case 5:
                            lVar.d(2, context.getString(2131230993));
                            return;
                        case 6:
                            lVar.d(3, context.getString(2131230995));
                            return;
                        default:
                            return;
                    }
                }
                v.d("MicroMsg.AppBrandSerivceActionSheet", "menuItemCreateListener response");
            }
        };
        this.dNk.jXo = new d(this) {
            final /* synthetic */ b nPu;

            {
                this.nPu = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                boolean z = true;
                if (this.nPu.nPq == null || !this.nPu.nPq.bBx()) {
                    v.d("MicroMsg.AppBrandSerivceActionSheet", "mActionSheet setOnMenuSelectedListener menuItem.getItemId:%d", Integer.valueOf(menuItem.getItemId()));
                    switch (menuItem.getItemId()) {
                        case 2:
                            ad.g(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 nPv;

                                {
                                    this.nPv = r1;
                                }

                                public final void run() {
                                    b bVar = new b(this.nPv.nPu.context, this.nPv.nPu.username, 3, this.nPv.nPu.scene, this.nPv.nPu.nPs, false);
                                }
                            }, 100);
                            break;
                        case 3:
                            ad.g(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 nPv;

                                {
                                    this.nPv = r1;
                                }

                                public final void run() {
                                    b bVar = new b(this.nPv.nPu.context, this.nPv.nPu.username, 4, this.nPv.nPu.scene, this.nPv.nPu.nPs, false);
                                }
                            }, 100);
                            break;
                        case 4:
                            this.nPu.dNk.bKi();
                            break;
                        case 5:
                            if (!be.kS(this.nPu.username)) {
                                a.i(this.nPu.context, this.nPu.username, true);
                                if (!this.nPu.nPt) {
                                    this.nPu.K(this.nPu.username, this.nPu.scene, 4);
                                    break;
                                } else {
                                    this.nPu.as(6, this.nPu.username);
                                    break;
                                }
                            }
                            break;
                        case 6:
                            if (!be.kS(this.nPu.username)) {
                                a.i(this.nPu.context, this.nPu.username, false);
                                if (!this.nPu.nPt) {
                                    this.nPu.K(this.nPu.username, this.nPu.scene, 2);
                                    break;
                                } else {
                                    this.nPu.as(1, this.nPu.username);
                                    break;
                                }
                            }
                            break;
                        default:
                            z = false;
                            break;
                    }
                    if (z) {
                        this.nPu.dNk.bKi();
                        return;
                    }
                    return;
                }
                v.d("MicroMsg.AppBrandSerivceActionSheet", "menuItemSelectedListener response", Integer.valueOf(menuItem.getItemId()));
            }
        };
        this.dNk.bKh();
    }

    public final void as(int i, String str) {
        com.tencent.mm.sdk.c.b mVar = new m();
        mVar.aWJ.aWH = str;
        com.tencent.mm.sdk.c.a.nhr.z(mVar);
        String str2 = mVar.aWK.appId;
        v.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), str2, this.nPs);
        g.iuh.h(13798, Integer.valueOf(i), str2, Integer.valueOf(0), this.nPs, Long.valueOf(be.Nh()));
    }

    public final void K(String str, int i, int i2) {
        com.tencent.mm.sdk.c.b mVar = new m();
        mVar.aWJ.aWH = str;
        com.tencent.mm.sdk.c.a.nhr.z(mVar);
        String str2 = mVar.aWK.appId;
        v.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", Integer.valueOf(13918), str2, Integer.valueOf(i), this.nPs, Integer.valueOf(i2));
        g.iuh.h(13918, str2, Integer.valueOf(i), this.nPs, Integer.valueOf(i2), Long.valueOf(be.Nh()));
    }
}
