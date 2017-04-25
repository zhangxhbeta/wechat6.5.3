package com.tencent.mm.plugin.wenote.ui.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.wenote.ui.WNNoteFavVoiceBaseView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.json.JSONObject;

public class WNNoteWebViewBaseUI extends WebViewUI {
    private static int lvC = 0;
    private ImageButton fQv;
    public OnLongClickListener llD = new OnLongClickListener(this) {
        final /* synthetic */ WNNoteWebViewBaseUI lvD;

        {
            this.lvD = r1;
        }

        public final boolean onLongClick(View view) {
            this.lvD.lvA = true;
            return false;
        }
    };
    public boolean lvA = false;
    public View lvB = null;
    public WNNoteFavVoiceBaseView lvf;
    public p lvu = null;
    public View lvv = null;
    public LinearLayout lvw;
    public boolean lvx = false;
    public boolean lvy = false;
    public boolean lvz = false;

    private class a extends i {
        final /* synthetic */ WNNoteWebViewBaseUI lvD;

        private a(WNNoteWebViewBaseUI wNNoteWebViewBaseUI) {
            this.lvD = wNNoteWebViewBaseUI;
            super(wNNoteWebViewBaseUI);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.lvD.V(0, false);
            this.lvD.V(1, true);
            if (this.lvD.lvy) {
                this.lvD.U(1, false);
            } else {
                this.lvD.U(1, true);
            }
            boolean z = this.lvD.lvy;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.lvD.V(0, false);
            this.lvD.V(1, true);
            if (this.lvD.lvy) {
                this.lvD.U(1, false);
            } else {
                this.lvD.U(1, true);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            return shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (!(webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().contains("wenote"))) {
                InputStream openRead;
                v.i("MicroMsg.WNNoteWebViewBaseUI", "url=%s | thread=%d", new Object[]{webResourceRequest.getUrl().toString(), Long.valueOf(Thread.currentThread().getId())});
                String uri = Uri.parse(uri).toString();
                String substring = uri.substring("file://".length(), uri.length());
                InputStream inputStream = null;
                try {
                    openRead = FileOp.openRead(substring);
                } catch (FileNotFoundException e) {
                    openRead = inputStream;
                }
                if (!(openRead == null || substring.endsWith("WNNote.html"))) {
                    return new WebResourceResponse("image/*", "utf8", openRead);
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str.contains("wenote")) {
                InputStream openRead;
                v.i("MicroMsg.WNNoteWebViewBaseUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
                String uri = Uri.parse(str).toString();
                String substring = uri.substring("file://".length(), uri.length());
                InputStream inputStream = null;
                try {
                    openRead = FileOp.openRead(substring);
                } catch (FileNotFoundException e) {
                    openRead = inputStream;
                }
                if (!(openRead == null || substring.endsWith("WNNote.html"))) {
                    return new WebResourceResponse("image/*", "utf8", openRead);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    protected void aqj() {
        super.aqj();
        this.igd.setWebViewClient(new a());
        if (this.lvy) {
            this.igd.setOnLongClickListener(this.llD);
        } else {
            this.igd.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ WNNoteWebViewBaseUI lvD;

                {
                    this.lvD = r1;
                }

                public final boolean onLongClick(View view) {
                    return true;
                }
            });
        }
        if (this.llx != null) {
            this.llx.hx(true);
        }
    }

    protected void NI() {
        int bmk;
        super.NI();
        this.lvx = true;
        this.lvw = (LinearLayout) findViewById(2131760106);
        if (d.dW(21)) {
            bmk = bmk();
        } else {
            bmk = 0;
        }
        this.lvB = View.inflate(this.nDR.nEl, 2130904716, null);
        this.lvf = (WNNoteFavVoiceBaseView) this.lvB.findViewById(2131757008);
        this.fQv = (ImageButton) findViewById(2131757009);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, bmk, 0, 0);
        if (this.nDR.dtW != null) {
            ((ViewGroup) getWindow().getDecorView()).addView(this.lvB, layoutParams);
            this.lvB.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WNNoteWebViewBaseUI lvD;

                {
                    this.lvD = r1;
                }

                public final void onClick(View view) {
                }
            });
        }
        this.lvv = q.em(this).inflate(2130904715, null);
        ((ViewGroup) this.nDR.dtW).addView(this.lvv, new FrameLayout.LayoutParams(-1, -2, 17));
        this.lvv.setVisibility(8);
        this.igd.getSettings().setAllowFileAccessFromFileURLs(true);
    }

    protected void a(WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        d.dW(21);
    }

    protected void n(int i, final Bundle bundle) {
        String string;
        int i2;
        WNNoteFavVoiceBaseView wNNoteFavVoiceBaseView;
        switch (i) {
            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                String string2 = bundle.getString("editorId");
                string = bundle.getString("localPath");
                String string3 = bundle.getString("iconPath", null);
                i2 = bundle.getInt("voiceDuration", 0);
                final JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("localEditorId", string2);
                    jSONObject.put("localPath", string);
                    jSONObject.put("downloaded", true);
                    if (!be.kS(string3)) {
                        jSONObject.put("iconPath", string3);
                    }
                    if (i2 > 0) {
                        jSONObject.put(Columns.TYPE, 4);
                        jSONObject.put("length", (int) com.tencent.mm.au.a.au((long) i2));
                        jSONObject.put("lengthStr", com.tencent.mm.au.a.s(this.nDR.nEl, jSONObject.getInt("length")).toString());
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.WNNoteWebViewBaseUI", e, "", new Object[0]);
                }
                v.i("MicroMsg.WNNoteWebViewBaseUI", "WNNote: Insert:%s", new Object[]{jSONObject.toString()});
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteWebViewBaseUI lvD;

                    public final void run() {
                        if (this.lvD.lkl != null) {
                            this.lvD.lkl.G(jSONObject);
                        }
                    }
                });
                return;
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                if (this.lvu != null) {
                    this.lvu.dismiss();
                }
                finish();
                return;
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
                v.d("MicroMsg.WNNoteWebViewBaseUI", "webview reload");
                this.igd.reload();
                return;
            case JsApiGetLocation.CTRL_INDEX /*37*/:
                if (be.kS(this.lvf.path) || !this.lvf.path.equals(bundle.getString("voicePath"))) {
                    this.lvf.XV();
                    View view = this.lvf;
                    view.setVisibility(0);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (WNNoteFavVoiceBaseView.co(view) * -1), 0.0f);
                    translateAnimation.setDuration(500);
                    view.startAnimation(translateAnimation);
                    this.lvf.liH = this.liH;
                    wNNoteFavVoiceBaseView = this.lvf;
                    wNNoteFavVoiceBaseView.path = bundle.getString("voicePath");
                    wNNoteFavVoiceBaseView.bdW = bundle.getInt("voiceType");
                    wNNoteFavVoiceBaseView.duration = bundle.getInt("voiceDuration");
                    string = wNNoteFavVoiceBaseView.path;
                    int i3 = wNNoteFavVoiceBaseView.bdW;
                    i2 = wNNoteFavVoiceBaseView.duration;
                    wNNoteFavVoiceBaseView.path = be.ah(string, "");
                    wNNoteFavVoiceBaseView.bdW = i3;
                    wNNoteFavVoiceBaseView.duration = i2;
                    if (wNNoteFavVoiceBaseView.liH != null) {
                        try {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("actionCode", 2);
                            wNNoteFavVoiceBaseView.liH.i(55, bundle2);
                        } catch (Throwable e2) {
                            v.a("MicroMsg.WNNoteFavVoiceBaseView", e2, "", new Object[0]);
                        }
                    }
                    this.lvf.cT(this.nDR.nEl);
                    return;
                }
                return;
            case aq.CTRL_INDEX /*38*/:
                wNNoteFavVoiceBaseView = this.lvf;
                string = bundle.getString("path");
                boolean z = bundle.getBoolean("isPlay");
                boolean z2 = bundle.getBoolean("resumePlay");
                boolean z3 = bundle.getBoolean("isPause");
                double d = bundle.getDouble("getProgress");
                wNNoteFavVoiceBaseView.luN = string;
                wNNoteFavVoiceBaseView.luO = z;
                wNNoteFavVoiceBaseView.luP = z2;
                wNNoteFavVoiceBaseView.luQ = z3;
                wNNoteFavVoiceBaseView.luR = d;
                WNNoteFavVoiceBaseView wNNoteFavVoiceBaseView2 = this.lvf;
                int i4 = bundle.getInt("actionCode");
                if (i4 == 1) {
                    if (!be.ah(wNNoteFavVoiceBaseView2.path, "").equals(wNNoteFavVoiceBaseView2.luN)) {
                        wNNoteFavVoiceBaseView2.aUd();
                        return;
                    } else if (wNNoteFavVoiceBaseView2.luO) {
                        v.i("MicroMsg.WNNoteFavVoiceBaseView", "pause play");
                        if (wNNoteFavVoiceBaseView2.liH != null) {
                            try {
                                wNNoteFavVoiceBaseView2.liH.i(57, null);
                            } catch (Throwable e22) {
                                v.a("MicroMsg.WNNoteFavVoiceBaseView", e22, "", new Object[0]);
                            }
                        }
                        wNNoteFavVoiceBaseView2.luS.pause();
                        return;
                    } else {
                        v.i("MicroMsg.WNNoteFavVoiceBaseView", "resume play");
                        boolean z4 = wNNoteFavVoiceBaseView2.luP;
                        a aVar = wNNoteFavVoiceBaseView2.luS;
                        aVar.cOX = false;
                        aVar.removeMessages(4096);
                        aVar.sendEmptyMessage(4096);
                        aVar.luV.fQv.setImageResource(2130839561);
                        aVar.luV.fQv.setContentDescription(aVar.luV.getContext().getResources().getString(2131231108));
                        if (!z4) {
                            wNNoteFavVoiceBaseView2.aUd();
                            return;
                        }
                        return;
                    }
                } else if (i4 == 2) {
                    if (!wNNoteFavVoiceBaseView2.path.equals(wNNoteFavVoiceBaseView2.luN)) {
                        wNNoteFavVoiceBaseView2.luS.kO(wNNoteFavVoiceBaseView2.duration);
                        return;
                    } else if (wNNoteFavVoiceBaseView2.luO) {
                        wNNoteFavVoiceBaseView2.luS.b(wNNoteFavVoiceBaseView2.luR, wNNoteFavVoiceBaseView2.duration, true);
                        return;
                    } else if (wNNoteFavVoiceBaseView2.luQ) {
                        wNNoteFavVoiceBaseView2.luS.b(wNNoteFavVoiceBaseView2.luR, wNNoteFavVoiceBaseView2.duration, false);
                        return;
                    } else {
                        wNNoteFavVoiceBaseView2.luS.kO(wNNoteFavVoiceBaseView2.duration);
                        return;
                    }
                } else if (i4 == 3 && wNNoteFavVoiceBaseView2.luO) {
                    wNNoteFavVoiceBaseView2.aUd();
                    return;
                } else {
                    return;
                }
            case y.CTRL_INDEX /*39*/:
                wNNoteFavVoiceBaseView = this.lvf;
                if (bundle.getBoolean("result")) {
                    wNNoteFavVoiceBaseView.luS.begin();
                    return;
                } else {
                    Toast.makeText(wNNoteFavVoiceBaseView.getContext(), 2131232754, 1).show();
                    return;
                }
            case 40:
                wNNoteFavVoiceBaseView = this.lvf;
                switch (bundle.getInt("actionCode")) {
                    case 1:
                        if (bundle.getBoolean("result")) {
                            wNNoteFavVoiceBaseView.luS.stop();
                            return;
                        }
                        if (bundle.getInt("position", 0) == 0) {
                            wNNoteFavVoiceBaseView.fLw = 0;
                        }
                        wNNoteFavVoiceBaseView.luS.begin();
                        return;
                    case 2:
                        wNNoteFavVoiceBaseView.luS.luW = true;
                        wNNoteFavVoiceBaseView.luS.stop();
                        return;
                    case 3:
                        wNNoteFavVoiceBaseView.luS.pause();
                        return;
                    default:
                        return;
                }
            case 44:
                if (this.lvu == null) {
                    this.lvu = g.a(this.nDR.nEl, getString(2131236682), true, null);
                    return;
                }
                return;
            case 45:
                if (this.lvu != null) {
                    this.lvu.dismiss();
                }
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteWebViewBaseUI lvD;

                    public final void run() {
                        if (this.lvD.lvv.getVisibility() == 0) {
                            this.lvD.lvv.setVisibility(8);
                        }
                        if (bundle == null) {
                            return;
                        }
                        if (bundle.getBoolean("AC_WNNOTE_SEND_TO_USER")) {
                            com.tencent.mm.ui.snackbar.a.f(this.lvD, this.lvD.nDR.nEl.getString(2131232839));
                            return;
                        }
                        String string = this.lvD.nDR.nEl.getString(2131232724);
                        if (bundle.getBoolean("AC_WNNOTE_SEND_TO_USER_FAILE_REASON")) {
                            string = this.lvD.nDR.nEl.getString(2131230745);
                        }
                        g.bf(this.lvD.nDR.nEl, string);
                    }
                });
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130904717;
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onStart() {
        super.onStart();
    }

    protected final boolean bkx() {
        return true;
    }

    protected final boolean bkr() {
        return false;
    }

    protected void onDestroy() {
        this.lvf.XV();
        this.lvf.bmf();
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteWebViewBaseUI lvD;

            {
                this.lvD = r1;
            }

            public final void run() {
                try {
                    if (this.lvD.liH != null) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("wenote_editstatus", false);
                        this.lvD.liH.i(51, bundle);
                    }
                } catch (RemoteException e) {
                }
            }
        });
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
    }

    private int bmk() {
        int dimensionPixelSize;
        Throwable e;
        if (lvC != 0) {
            return lvC;
        }
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            dimensionPixelSize = getResources().getDimensionPixelSize(be.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
            try {
                lvC = dimensionPixelSize;
                return dimensionPixelSize;
            } catch (Exception e2) {
                e = e2;
                v.a("MicroMsg.WNNoteWebViewBaseUI", e, "", new Object[0]);
                return dimensionPixelSize;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            dimensionPixelSize = 38;
            e = th;
            v.a("MicroMsg.WNNoteWebViewBaseUI", e, "", new Object[0]);
            return dimensionPixelSize;
        }
    }

    protected final boolean bjX() {
        return false;
    }
}
