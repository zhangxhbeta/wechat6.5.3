package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass20;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass24;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass25;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass26;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass27;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.FTSEditTextView;
import com.tencent.mm.ui.widget.d;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSBaseWebViewUI extends WebViewUI implements com.tencent.mm.ui.widget.FTSEditTextView.a, com.tencent.mm.ui.widget.d.a {
    private d lnH;
    private boolean lnI;
    private boolean lnl;
    int scene;
    int type;

    public class a implements com.tencent.mm.ui.widget.d.b {
        final /* synthetic */ FTSBaseWebViewUI lnJ;
        String lnP;
        int lnQ;
        String userName;

        public a(FTSBaseWebViewUI fTSBaseWebViewUI) {
            this.lnJ = fTSBaseWebViewUI;
        }

        public final String getTagName() {
            return this.lnP;
        }

        public final int compareTo(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return -1;
            }
            return this.lnP.compareTo(((a) obj).lnP);
        }
    }

    private class b extends i {
        final /* synthetic */ FTSBaseWebViewUI lnJ;

        private b(FTSBaseWebViewUI fTSBaseWebViewUI) {
            this.lnJ = fTSBaseWebViewUI;
            super(fTSBaseWebViewUI);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            v.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageFinished %s", new Object[]{str});
            this.lnJ.iU(false);
            if (this.lnJ.lnH != null && !this.lnJ.lnl) {
                FTSBaseWebViewUI.bkX();
                this.lnJ.lnH.pbz.ocq.clearFocus();
                this.lnJ.axg();
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            v.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageStarted %s", new Object[]{str});
            this.lnJ.iU(false);
            if (this.lnJ.lnH != null && !this.lnJ.lnl) {
                FTSBaseWebViewUI.bkY();
                this.lnJ.lnH.pbz.ocq.clearFocus();
                this.lnJ.axg();
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            if (!(webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().startsWith("weixin://fts"))) {
                InputStream openRead;
                v.i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[]{webResourceRequest.getUrl().toString(), Long.valueOf(Thread.currentThread().getId())});
                Uri parse = Uri.parse(r0);
                InputStream inputStream = null;
                try {
                    openRead = FileOp.openRead(parse.getQueryParameter("path"));
                } catch (FileNotFoundException e) {
                    openRead = inputStream;
                }
                if (openRead != null) {
                    return new WebResourceResponse("image/*", "utf8", openRead);
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (!(webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().startsWith("weixin://fts"))) {
                InputStream openRead;
                v.i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[]{webResourceRequest.getUrl().toString(), Long.valueOf(Thread.currentThread().getId())});
                Uri parse = Uri.parse(r0);
                InputStream inputStream = null;
                try {
                    openRead = FileOp.openRead(parse.getQueryParameter("path"));
                } catch (FileNotFoundException e) {
                    openRead = inputStream;
                }
                if (openRead != null) {
                    return new WebResourceResponse("image/*", "utf8", openRead);
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str.startsWith("weixin://fts")) {
                InputStream openRead;
                v.i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
                InputStream inputStream = null;
                try {
                    openRead = FileOp.openRead(Uri.parse(str).getQueryParameter("path"));
                } catch (FileNotFoundException e) {
                    openRead = inputStream;
                }
                if (openRead != null) {
                    return new WebResourceResponse("image/*", "utf8", openRead);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    protected void aqj() {
        super.aqj();
        String trim = be.ah(getIntent().getStringExtra("ftsQuery"), "").trim();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 3);
        this.lnl = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.lnI = getIntent().getBooleanExtra("ftscaneditable", true);
        this.igd.setWebViewClient(new b());
        this.igd.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSBaseWebViewUI lnJ;

            {
                this.lnJ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lnJ.axg();
                return false;
            }
        });
        if (this.lnI) {
            this.lnH = new d(this);
            this.lnH.pbA = this;
            this.lnH.pbz.BZ(getHint());
            this.lnH.pbz.pbs = this;
            cU().cV().setCustomView(this.lnH);
            if (!be.kS(trim)) {
                this.lnH.pbz.n(trim, null);
            }
            if (this.lnl) {
                this.lnH.pbz.bKf();
                FTSEditTextView fTSEditTextView = this.lnH.pbz;
                fTSEditTextView.postDelayed(new Runnable(fTSEditTextView) {
                    final /* synthetic */ FTSEditTextView pbu;

                    {
                        this.pbu = r1;
                    }

                    public final void run() {
                        ((InputMethodManager) this.pbu.getContext().getSystemService("input_method")).showSoftInput(this.pbu.ocq, 0);
                    }
                }, 128);
            }
        }
        iU(false);
        if (this.llx != null) {
            this.llx.hx(true);
        }
        this.igd.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ FTSBaseWebViewUI lnJ;

            {
                this.lnJ = r1;
            }

            public final boolean onLongClick(View view) {
                return true;
            }
        });
    }

    protected final int bkh() {
        return 2130837595;
    }

    protected final boolean bkr() {
        return true;
    }

    protected final String bkR() {
        return this.lnH.pbz.bkR();
    }

    protected final String bkS() {
        return this.lnH.pbz.bkS();
    }

    protected final boolean bki() {
        return false;
    }

    public final void bkT() {
        finish();
    }

    public final void bkU() {
        if (!this.lnH.pbz.ocq.hasFocus()) {
            this.lnH.pbz.bKf();
            aJs();
        }
    }

    public void a(String str, String str2, List<com.tencent.mm.ui.widget.d.b> list, com.tencent.mm.ui.widget.FTSEditTextView.b bVar) {
        v.i("MicroMsg.FTS.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[]{str, str2, bVar});
        if (bVar == com.tencent.mm.ui.widget.FTSEditTextView.b.UserInput || bVar == com.tencent.mm.ui.widget.FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ FTSBaseWebViewUI lnJ;

                {
                    this.lnJ = r1;
                }

                public final void run() {
                    if (this.lnJ.lkl != null) {
                        this.lnJ.lkl.a(this.lnJ.bkR(), this.lnJ.bkS(), this.lnJ.bkW());
                    }
                }
            });
        }
    }

    public final void hD(boolean z) {
        if (z && bkS().length() > 0) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ FTSBaseWebViewUI lnJ;

                {
                    this.lnJ = r1;
                }

                public final void run() {
                    if (this.lnJ.lkl != null) {
                        this.lnJ.lkl.a(this.lnJ.bkR(), this.lnJ.bkS(), this.lnJ.bkW());
                    }
                }
            });
        }
    }

    public final void bkV() {
        if (this.lnH != null) {
            if (!this.lnH.pbz.ocq.hasFocus()) {
                this.lnH.pbz.bKf();
                aJs();
            }
            this.lnH.pbz.BZ(getHint());
        }
    }

    public boolean Si() {
        v.i("MicroMsg.FTS.FTSBaseWebViewUI", "onSearchKeyDown");
        if (bkR().length() > 0) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ FTSBaseWebViewUI lnJ;

                {
                    this.lnJ = r1;
                }

                public final void run() {
                    if (this.lnJ.lkl != null) {
                        f f = this.lnJ.lkl;
                        String bkR = this.lnJ.bkR();
                        String bkS = this.lnJ.bkS();
                        JSONArray bkW = this.lnJ.bkW();
                        if (f.loB) {
                            v.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[]{bkR, bkS, bkW.toString()});
                            Map hashMap = new HashMap();
                            hashMap.put("query", bkR);
                            hashMap.put("custom", bkS);
                            hashMap.put("tagList", bkW);
                            ad.o(new AnonymousClass23(f, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onSearchInputConfirm", hashMap, f.loD, f.loE)));
                            return;
                        }
                        v.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
                    }
                }
            });
            axg();
        }
        return false;
    }

    public final JSONArray bkW() {
        List<com.tencent.mm.ui.widget.d.b> list = this.lnH.pbz.jTC;
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.ui.widget.d.b bVar : list) {
            a aVar = (a) bVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", aVar.lnP);
                jSONObject.put("tagType", aVar.lnQ);
                jSONObject.put("userName", aVar.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        return jSONArray;
    }

    protected final void k(int i, Bundle bundle) {
        int i2 = 0;
        final String string;
        final String string2;
        switch (i) {
            case 19:
                string = bundle.getString("fts_key_json_data");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI lnJ;

                    public final void run() {
                        if (this.lnJ.lkl != null) {
                            f j = this.lnJ.lkl;
                            String str = string;
                            boolean z = z;
                            if (j.loB) {
                                v.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("json", str);
                                hashMap.put("newQuery", Boolean.valueOf(z));
                                ad.o(new AnonymousClass20(j, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onSearchDataReady", hashMap, j.loD, j.loE)));
                                return;
                            }
                            v.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
                        }
                    }
                });
                return;
            case 20:
                i2 = bundle.getInt("fts_key_ret", 0);
                string2 = bundle.getString("fts_key_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI lnJ;

                    public final void run() {
                        if (this.lnJ.lkl != null) {
                            f l = this.lnJ.lkl;
                            int i = i2;
                            String str = string2;
                            if (l.loB) {
                                Map hashMap = new HashMap();
                                hashMap.put("ret", Integer.valueOf(i));
                                hashMap.put("data", str);
                                ad.o(new AnonymousClass25(l, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onSearchImageListReady", hashMap, l.loD, l.loE)));
                                return;
                            }
                            v.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
                        }
                    }
                });
                return;
            case 21:
                string2 = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI lnJ;

                    public final void run() {
                        if (this.lnJ.lkl != null) {
                            f n = this.lnJ.lkl;
                            int i = i3;
                            String str = string2;
                            int i2 = i2;
                            if (n.loB) {
                                v.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("requestType", Integer.valueOf(i));
                                hashMap.put("json", str);
                                hashMap.put("isCacheData", Integer.valueOf(i2));
                                ad.o(new AnonymousClass26(n, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onTeachSearchDataReady", hashMap, n.loD, n.loE)));
                                return;
                            }
                            v.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
                        }
                    }
                });
                return;
            case bf.CTRL_INDEX /*22*/:
                string2 = bundle.getString("fts_key_new_query");
                String string3 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string4 = bundle.getString("fts_key_tag_list");
                v.i("MicroMsg.FTS.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[]{string2, Boolean.valueOf(z2)});
                List arrayList = new ArrayList();
                try {
                    if (!be.kS(string4)) {
                        JSONArray jSONArray = new JSONArray(string4);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            a aVar = new a(this);
                            aVar.lnP = jSONObject.getString("tagName");
                            aVar.lnQ = jSONObject.getInt("tagType");
                            aVar.userName = jSONObject.getString("userName");
                            arrayList.add(aVar);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.lnH != null) {
                    if (arrayList.size() > 0) {
                        this.lnH.pbz.n(string3, arrayList);
                    } else {
                        this.lnH.pbz.n(string2, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ FTSBaseWebViewUI lnJ;

                        {
                            this.lnJ = r1;
                        }

                        public final void run() {
                            if (this.lnJ.lkl != null) {
                                this.lnJ.lkl.a(this.lnJ.bkR(), this.lnJ.bkS(), this.lnJ.bkW());
                            }
                        }
                    });
                    if (this.lnH != null) {
                        this.lnH.pbz.bKf();
                    }
                    aJs();
                    return;
                } else if (this.lnH != null) {
                    this.lnH.pbz.ocq.clearFocus();
                    return;
                } else {
                    return;
                }
            case 24:
                string = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI lnJ;

                    public final void run() {
                        if (this.lnJ.lkl != null) {
                            f r = this.lnJ.lkl;
                            String str = string;
                            if (r.loB) {
                                v.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("json", str);
                                ad.o(new AnonymousClass24(r, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onSearchSuggestionDataReady", hashMap, r.loD, r.loE)));
                                return;
                            }
                            v.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
                        }
                    }
                });
                return;
            case 25:
                string2 = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI lnJ;

                    public final void run() {
                        if (this.lnJ.lkl != null) {
                            f t = this.lnJ.lkl;
                            String str = string2;
                            int i = i2;
                            if (t.loB) {
                                v.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("snsid", str);
                                hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i));
                                ad.o(new AnonymousClass27(t, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onMusicStatusChanged", hashMap, t.loD, t.loE)));
                                return;
                            }
                            v.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        try {
            if (this.liH != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.liH.k(1, bundle);
            }
        } catch (RemoteException e) {
        }
        super.onDestroy();
    }

    protected String getHint() {
        return null;
    }

    protected final int getLayoutId() {
        return 2130903691;
    }

    protected static boolean bkX() {
        return true;
    }

    protected static boolean bkY() {
        return true;
    }

    protected final boolean bkw() {
        return false;
    }

    protected final void bkg() {
        finish();
    }
}
