package com.tencent.mm.plugin.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.e.a.m;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.base.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Set;

public final class d extends a {
    public final int getType() {
        return 1;
    }

    public final void p(final Context context, Intent intent) {
        boolean z;
        g.iuh.a(443, 2, 1, false);
        final String pn = a.pn(r.g(intent, "id"));
        String pn2 = a.pn(r.g(intent, "ext_info"));
        Object g = r.g(intent, "token");
        final int a = r.a(intent, "ext_info_1", 0);
        if (TextUtils.isEmpty(pn) || TextUtils.isEmpty(pn2) || TextUtils.isEmpty(g)) {
            v.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
            z = false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            if (!g.equals(a.aZ(pn2, stringBuilder.append(c.ww()).toString()))) {
                SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("app_brand_global_sp", 0);
                if (sharedPreferences == null) {
                    v.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
                    z = false;
                } else {
                    Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                    if (stringSet == null || stringSet.isEmpty()) {
                        v.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
                        z = false;
                    } else {
                        Set hashSet = new HashSet();
                        for (String aZ : stringSet) {
                            hashSet.add(a.aZ(pn2, aZ));
                        }
                        if (!hashSet.contains(g)) {
                            v.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", g);
                            z = false;
                        }
                    }
                }
            }
            if (b.bsI() || a != 1) {
                com.tencent.mm.sdk.c.b okVar = new ok();
                okVar.bpu.appId = pn2;
                okVar.bpu.userName = pn;
                okVar.bpu.bpx = a;
                okVar.bpu.scene = 1023;
                okVar.bpu.bpA = true;
                okVar.bpu.context = context;
                okVar.bpu.dAl = false;
                com.tencent.mm.sdk.c.a.nhr.z(okVar);
                if (okVar.bpv.bpI) {
                    v.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", pn);
                } else if (a == 1) {
                    Toast.makeText(context, 2131230920, 0).show();
                } else if (a == 2) {
                    Toast.makeText(context, 2131236731, 0).show();
                }
                Object g2 = r.g(intent, "digest");
                if (!TextUtils.isEmpty(g2)) {
                    com.tencent.mm.sdk.c.b mVar = new m();
                    mVar.aWJ.aWH = pn;
                    com.tencent.mm.sdk.c.a.nhr.z(mVar);
                    if (mVar.aWK.aWL) {
                        if (!g2.equals(com.tencent.mm.a.g.m(((TextUtils.isEmpty(mVar.aWK.appName) ? pn : mVar.aWK.appName) + mVar.aWK.dHg + mVar.aWK.cxh).getBytes()))) {
                            v.i("MiroMsg.WxaShortcutEntry", "update shortcut for wxa(%s)", pn);
                            a.c(context, pn, intent);
                            ad.g(new Runnable(this) {
                                final /* synthetic */ d iTq;

                                public final void run() {
                                    a.o(context, pn, a);
                                }
                            }, 1000);
                        }
                    } else {
                        v.e("MiroMsg.WxaShortcutEntry", "no such WeApp(%s)", pn);
                        z = true;
                    }
                }
                intent.putExtra("type", 0);
                intent.putExtra("id", SQLiteDatabase.KeyEmpty);
                z = true;
            } else {
                v.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
                z = false;
            }
        }
        if (!z) {
            g.iuh.a(443, 3, 1, false);
        }
    }
}
