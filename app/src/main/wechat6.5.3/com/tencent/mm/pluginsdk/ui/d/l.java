package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.base.s;
import java.io.File;

public final class l {
    public static boolean oB() {
        boolean z = true;
        if (ak.uz()) {
            boolean z2 = (be.He() || f.aPW == 1 || be.getInt(j.sU().getValue("ShowWeixinPBIntro"), 0) != 0 || p.o(aa.getContext(), "com.tencent.pb")) ? false : true;
            if (z2) {
                ak.yW();
                int a = be.a((Integer) c.vf().get(a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3);
                v.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", Integer.valueOf(a));
                if (a <= 0) {
                    return false;
                }
                ak.yW();
                c.vf().set(352257, Integer.valueOf(a - 1));
                return true;
            }
            String str = "MicroMsg.WxPhoneBookHelper";
            String str2 = "%b, %b, %b, %b";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(be.He());
            objArr[1] = Boolean.valueOf(f.aPW != 1);
            if (be.getInt(j.sU().getValue("ShowWeixinPBIntro"), 0) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            if (p.o(aa.getContext(), "com.tencent.pb")) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            v.d(str, str2, objArr);
            return false;
        }
        v.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
        return false;
    }

    public static void c(Context context, Bundle bundle) {
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        g.iuh.h(11621, Integer.valueOf(i), Integer.valueOf(0));
        com.tencent.mm.pluginsdk.model.downloader.f GO = d.bnK().GO("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (GO == null || GO.status != 3) {
            s.makeText(context, context.getString(2131231861), 2000).show();
            e.a aVar = new e.a();
            aVar.GQ("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            aVar.GR(context.getString(2131231867));
            aVar.tE(1);
            aVar.hO(true);
            d.bnK().a(aVar.lCn);
            return;
        }
        v.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (com.tencent.mm.a.e.aR(GO.path)) {
            p.c(context, Uri.fromFile(new File(GO.path)));
        }
    }
}
