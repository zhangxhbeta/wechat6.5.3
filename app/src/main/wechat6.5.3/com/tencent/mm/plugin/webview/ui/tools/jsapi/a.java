package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Message;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;

public final class a extends ac {
    String aZy = null;
    private String bmJ;
    private e leB;
    int len = 0;
    private k loe;
    private i lof;
    String url;

    public a(e eVar, k kVar, String str, String str2, i iVar) {
        this.leB = eVar;
        this.loe = kVar;
        this.url = str;
        this.bmJ = str2;
        this.lof = iVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case -1:
                a(this.loe, "add_emoticon:cancel");
                return;
            case 10:
                int i = message.arg1;
                c cVar = null;
                if (!be.kS(this.aZy)) {
                    switch (i) {
                        case 0:
                            cVar = com.tencent.mm.pluginsdk.j.a.bmr().a(this.aZy, "", c.nwR, c.nwX, this.len, this.url, this.bmJ, "");
                            break;
                        case 1:
                            cVar = com.tencent.mm.pluginsdk.j.a.bmr().a(this.aZy, "", c.nwR, c.nwW, this.len, this.url, this.bmJ, "");
                            break;
                    }
                }
                if (cVar == null) {
                    v.e("MicroMsg.AddEmojIconHandler", "anna : add_emoticon fail insert db fail");
                    a(this.loe, "add_emoticon:unknown");
                    return;
                }
                v.v("MicroMsg.AddEmojIconHandler", "anna : add_emoticon ok gif emojiUrl : " + this.url);
                a(this.loe, "add_emoticon:ok");
                return;
            case 11:
                a(this.loe, "add_emoticon:download_failed");
                return;
            default:
                a(this.loe, "add_emoticon:unknown");
                return;
        }
    }

    private void a(k kVar, String str) {
        if (this.lof != null) {
            this.lof.fHM = false;
        }
        try {
            this.leB.a(kVar.lqX, str, k.O(null), true);
        } catch (Exception e) {
            v.w("MicroMsg.AddEmojIconHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }
}
