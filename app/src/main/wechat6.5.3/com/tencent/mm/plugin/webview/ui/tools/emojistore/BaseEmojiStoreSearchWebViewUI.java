package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.30;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements b {
    String bkC;
    private p exP;
    private boolean iHQ = true;
    private boolean lnl;
    private int lnm;
    private int type;

    private class a extends i {
        final /* synthetic */ BaseEmojiStoreSearchWebViewUI lnn;

        private a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
            this.lnn = baseEmojiStoreSearchWebViewUI;
            super(baseEmojiStoreSearchWebViewUI);
        }

        public final void onPageFinished(WebView webView, String str) {
            v.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[]{str});
            super.onPageFinished(webView, str);
            this.lnn.iU(false);
            this.lnn.exP.Pw(this.lnn.bkC);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.lnn.iU(false);
        }
    }

    protected final void aqj() {
        super.aqj();
        this.bkC = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra("type", 0);
        this.lnl = getIntent().getBooleanExtra("showkeyboard", false);
        this.lnm = getIntent().getIntExtra("sence", 0);
        this.igd.setWebViewClient(new a());
        this.igd.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ BaseEmojiStoreSearchWebViewUI lnn;

            {
                this.lnn = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lnn.axg();
                return false;
            }
        });
        this.exP = new p();
        a(this.exP);
        this.exP.kj(false);
        this.exP.oUs = this;
        iU(false);
        if (this.llx != null) {
            this.llx.hx(true);
        }
        this.igd.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ BaseEmojiStoreSearchWebViewUI lnn;

            {
                this.lnn = r1;
            }

            public final boolean onLongClick(View view) {
                return true;
            }
        });
    }

    public final void Og() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.exP != null) {
            this.exP.a(this, menu);
            this.exP.setHint(getString(2131232358));
        }
        return true;
    }

    public final void Of() {
        finish();
    }

    public final void ml(String str) {
        if (this.iHQ && be.kS(str)) {
            this.iHQ = false;
            if (this.lnl) {
                this.exP.bIU();
                aJs();
                return;
            }
            ad.g(new Runnable(this) {
                final /* synthetic */ BaseEmojiStoreSearchWebViewUI lnn;

                {
                    this.lnn = r1;
                }

                public final void run() {
                    this.lnn.exP.clearFocus();
                    this.lnn.axg();
                }
            }, 500);
        }
    }

    public final boolean mk(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.bkC = str;
        if (!be.kS(str)) {
            this.bkC = str;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BaseEmojiStoreSearchWebViewUI lnn;

                {
                    this.lnn = r1;
                }

                public final void run() {
                    if (this.lnn.lkl != null) {
                        this.lnn.lkl.blh();
                    }
                }
            });
            Bundle bundle = new Bundle();
            bundle.putInt("type", this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.bkC);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.lkl.blk());
            try {
                if (this.liH != null) {
                    this.liH.j(1, bundle);
                } else {
                    v.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (Throwable e) {
                v.a("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e, "doSearch", new Object[0]);
            }
        }
        axg();
        String str2 = "";
        if (!be.kS(str)) {
            str2 = str.replace(",", " ");
        }
        g.iuh.h(13054, new Object[]{Integer.valueOf(this.lnm), Integer.valueOf(1), str2});
        return false;
    }

    public final void Oh() {
        this.exP.bIU();
        aJs();
    }

    protected void m(int i, Bundle bundle) {
        v.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 80001:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j = bundle.getLong("emoji_store_search_id");
                f fVar = this.lkl;
                if (fVar.loB) {
                    v.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                    Map hashMap = new HashMap();
                    hashMap.put("json", string);
                    hashMap.put("newQuery", Boolean.valueOf(z));
                    hashMap.put("nextPageBuffer", string2);
                    v.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[]{Long.valueOf(j)});
                    fVar.loL = j;
                    v.i("MicroMsg.JsApiHandler", "event:%s", new Object[]{com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("getSearchEmotionDataCallBack", hashMap, fVar.loD, fVar.loE)});
                    ad.o(new 30(fVar, string));
                    return;
                }
                v.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                return;
            case 80002:
                this.lkl.blh();
                return;
            default:
                super.m(i, bundle);
                return;
        }
    }

    protected final void bkg() {
        finish();
    }

    protected final int getLayoutId() {
        return 2130903517;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final boolean bks() {
        return true;
    }
}
