package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.mm.a.e;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.b;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.e.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.l;
import java.io.File;

public final class f {
    public static void g(final Context context, final String str, final boolean z) {
        bY(str, 1);
        if (!p.o(context, "com.tencent.wework")) {
            g.a(context, 2131232479, 2131232480, 2131232478, 2131231010, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Context context = context;
                    String str = str;
                    boolean z = z;
                    f.bY(str, 3);
                    String str2 = "https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = z ? "on" : "off";
                    str = String.format(str2, objArr);
                    com.tencent.mm.pluginsdk.model.downloader.f GO = d.bnK().GO(str);
                    if (GO == null || GO.status != 3) {
                        s.makeText(context, context.getString(2131232481), 2000).show();
                        a aVar = new a();
                        aVar.GQ(str);
                        aVar.GR(context.getString(2131232477));
                        aVar.tE(1);
                        aVar.hO(true);
                        d.bnK().a(aVar.lCn);
                    } else if (e.aR(GO.path)) {
                        p.c(context, Uri.fromFile(new File(GO.path)));
                    }
                }
            }, null);
        } else if (z) {
            l lVar = new l(context);
            lVar.oTB = null;
            lVar.oTC = null;
            lVar.jXn = new c() {
                public final void a(com.tencent.mm.ui.base.l lVar) {
                    lVar.add(2131232482);
                }
            };
            lVar.jXo = new n.d() {
                public final void c(MenuItem menuItem, int i) {
                    f.bb(context, str);
                }
            };
            lVar.aXZ();
        } else {
            bb(context, str);
        }
    }

    static void bb(Context context, String str) {
        bY(str, 2);
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework"));
    }

    static void bY(String str, int i) {
        int i2;
        int i3;
        BizInfo ho = u.Dy().ho(str);
        if (ho.CA()) {
            str = ho.CF();
            i2 = 2;
        } else {
            i2 = 1;
        }
        b gZ = u.DF().gZ(str);
        int i4 = gZ != null ? gZ.field_qyUin : 0;
        if (gZ != null) {
            i3 = gZ.field_userUin;
        } else {
            i3 = 0;
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(13656, Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
        v.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void bZ(String str, int i) {
        if (i > 0) {
            int i2;
            int i3;
            b gZ = u.DF().gZ(str);
            if (gZ != null) {
                i2 = gZ.field_qyUin;
            } else {
                i2 = 0;
            }
            if (gZ != null) {
                i3 = gZ.field_userUin;
            } else {
                i3 = 0;
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(13703, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
            v.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
        }
    }
}
