package com.tencent.mm.plugin.chatroom.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
public class RoomAnnouncementUI extends MMActivity {
    private String ePn;
    private WebView eQN;
    private boolean eQO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eQO = getIntent().getBooleanExtra("need_bind_mobile", false);
        this.ePn = getIntent().getStringExtra("RoomInfo_Id");
        NI();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.eQN != null) {
            this.eQN.setVisibility(8);
            ((ViewGroup) this.eQN.getParent()).removeView(this.eQN);
            this.eQN.removeAllViews();
            this.eQN.destroy();
            this.eQN = null;
            System.gc();
        }
        super.onDestroy();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected final void NI() {
        vD(2131234685);
        this.eQN = a.h(this, 2131756023);
        this.eQN.getSettings().setJavaScriptEnabled(true);
        this.eQN.getSettings().setDomStorageEnabled(true);
        this.eQN.getSettings().setBuiltInZoomControls(true);
        this.eQN.getSettings().setUseWideViewPort(true);
        this.eQN.getSettings().setLoadWithOverviewMode(true);
        this.eQN.getSettings().setSavePassword(false);
        this.eQN.getSettings().setSaveFormData(false);
        this.eQN.getSettings().setGeolocationEnabled(false);
        this.eQN.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.eQN.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ RoomAnnouncementUI eQP;

            {
                this.eQP = r1;
            }

            public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                g.a(this.eQP, str2, null, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 eQQ;

                    {
                        this.eQQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.eQQ.eQP.eQN.requestFocus();
                    }
                });
                jsResult.cancel();
                return true;
            }
        });
        this.eQN.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ RoomAnnouncementUI eQP;

            {
                this.eQP = r1;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!str.equals("weixin://chatroom/upgradeagree")) {
                    return false;
                }
                a.a(this.eQP, this.eQP.ePn, this.eQP.eQO);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomAnnouncementUI eQP;

            {
                this.eQP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eQP.setResult(0);
                this.eQP.finish();
                return true;
            }
        });
        this.eQN.loadUrl(getString(2131231755, new Object[]{u.bsY()}));
    }

    public final int getLayoutId() {
        return 2130903273;
    }
}
