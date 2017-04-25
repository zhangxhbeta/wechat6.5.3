package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.d.a;
import com.tencent.mm.sdk.modelmsg.d.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class em implements dh {
    private static h<dh, Bundle> ozC = new h<dh, Bundle>() {
        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((dh) obj).U((Bundle) obj2);
        }
    };
    private Context context;
    private final Map<String, a> ozF = new HashMap();

    public em(Context context) {
        this.context = context;
    }

    public static void V(Bundle bundle) {
        ozC.bg(bundle);
        ozC.Ls();
    }

    public final void U(Bundle bundle) {
        v.d("MicroMsg.WXAppMessageShower", "handleResp, appid = " + Uri.parse(bundle.getString("_mmessage_content")).getQueryParameter("appid"));
        b bVar = new b(bundle);
        v.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + bVar.errCode + ", type = 4");
        if (((a) this.ozF.get(bVar.lBj)) == null) {
            v.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + bVar.lBj);
        } else {
            this.ozF.remove(bVar.lBj);
        }
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2) {
        v.d("MicroMsg.WXAppMessageShower", "request pkg = " + str + ", openId = " + str2);
        a a = g.a(this.context, str, wXMediaMessage, str2);
        this.ozF.put(a.lBj, a);
    }
}
