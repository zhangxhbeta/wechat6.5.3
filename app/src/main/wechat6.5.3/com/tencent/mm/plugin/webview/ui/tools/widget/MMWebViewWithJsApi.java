package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebViewClient;

public class MMWebViewWithJsApi extends MMWebView {
    private b lrI;

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bKm();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        setWebChromeClient(new a(this));
        setWebViewClient(new b(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!s.HY(userAgentString)) {
            getSettings().setUserAgentString(s.aW(getContext(), userAgentString));
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof b) {
            this.lrI = (b) webViewClient;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.lrI != null) {
            b bVar = this.lrI;
            if (bVar.gfD != null) {
                try {
                    bVar.gZX.unbindService(bVar.gfD);
                } catch (Exception e) {
                    v.e("MicroMsg.MMWebViewClient", e.getMessage());
                }
            }
            if (bVar.loX != null) {
                bVar.loX.detach();
            }
            if (bVar.lrs != null) {
                bVar.lrs.detach();
            }
            bVar.tb(233);
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (this.lrI != null) {
            this.lrI.lrD = true;
        }
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.lrI != null) {
            this.lrI.lrD = true;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }
}
