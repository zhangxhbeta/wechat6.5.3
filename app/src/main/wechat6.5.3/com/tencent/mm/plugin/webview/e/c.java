package com.tencent.mm.plugin.webview.e;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.webview.d.ah;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.u;

public final class c {
    public String lgG = null;
    public String lgH = null;
    public u<Uri> lgI = null;
    public u<Uri[]> lgJ = null;

    public final void a(WebViewUI webViewUI, e eVar, u<Uri> uVar, u<Uri[]> uVar2, String str, String str2) {
        Parcelable[] parcelableArr = null;
        v.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[]{eVar, uVar, uVar2, str, str2});
        biW();
        if (eVar == null || eVar.bjS() == null) {
            v.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
            h(null);
        } else if (eVar.bjS().uC(56)) {
            this.lgI = uVar;
            this.lgJ = uVar2;
            this.lgH = System.currentTimeMillis();
            this.lgG = str;
            String str3 = this.lgH;
            Object intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (be.kS(str)) {
                intent.setType("*/*");
            } else {
                intent.setType(str);
            }
            if (be.kS(str2)) {
                if (f.dX(16)) {
                    v.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                    parcelableArr = new Intent[]{ah.DY(str3)};
                }
            } else if ("camera".equalsIgnoreCase(str2)) {
                parcelableArr = new Intent[]{ah.DY(str3)};
            } else if ("camcorder".equalsIgnoreCase(str2)) {
                parcelableArr = new Intent[]{ah.bin()};
            } else if ("microphone".equalsIgnoreCase(str2)) {
                parcelableArr = new Intent[]{ah.bio()};
            } else if ("*".equalsIgnoreCase(str2)) {
                if (str.equalsIgnoreCase("image/*")) {
                    parcelableArr = new Intent[]{ah.DY(str3)};
                } else if (str.equalsIgnoreCase("audio/*")) {
                    parcelableArr = new Intent[]{ah.bio()};
                } else if (str.equalsIgnoreCase("video/*")) {
                    parcelableArr = new Intent[]{ah.bin()};
                }
            }
            Intent intent2 = new Intent("android.intent.action.CHOOSER");
            intent2.putExtra("android.intent.extra.INITIAL_INTENTS", parcelableArr);
            intent2.putExtra("android.intent.extra.TITLE", aa.getContext().getString(2131236687));
            intent2.putExtra("android.intent.extra.INTENT", intent);
            webViewUI.startActivityForResult(intent2, 1);
        } else {
            v.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
            h(null);
        }
    }

    public final void biW() {
        this.lgG = null;
        this.lgI = null;
        this.lgJ = null;
        this.lgH = null;
    }

    public final void h(Uri uri) {
        if (this.lgI != null) {
            this.lgI.onReceiveValue(uri);
        } else if (this.lgJ == null) {
        } else {
            if (uri == null) {
                this.lgJ.onReceiveValue(null);
                return;
            }
            this.lgJ.onReceiveValue(new Uri[]{uri});
        }
    }
}
