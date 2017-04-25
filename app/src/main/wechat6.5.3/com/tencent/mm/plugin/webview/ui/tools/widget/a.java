package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public final class a extends WebChromeClient {
    private Activity bij;
    private int llg = 0;

    public a(MMWebViewWithJsApi mMWebViewWithJsApi) {
        this.bij = (Activity) mMWebViewWithJsApi.getContext();
    }

    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }

    public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissionsCallback geolocationPermissionsCallback) {
        g.a(this.bij, false, this.bij.getString(2131236677, new Object[]{str}), this.bij.getString(2131236678), this.bij.getString(2131231107), this.bij.getString(2131231010), new OnClickListener(this) {
            final /* synthetic */ a lrr;

            public final void onClick(DialogInterface dialogInterface, int i) {
                geolocationPermissionsCallback.invoke(str, true, true);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ a lrr;

            public final void onClick(DialogInterface dialogInterface, int i) {
                geolocationPermissionsCallback.invoke(str, false, false);
            }
        });
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        h a;
        this.llg++;
        if (this.llg > 2) {
            a = g.a(this.bij, str2, "", this.bij.getString(2131236672), this.bij.getString(2131231107), new OnClickListener(this) {
                final /* synthetic */ a lrr;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.lrr.bij.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a lrr;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }, 2131689819);
        } else {
            a = g.a(this.bij, str2, "", this.bij.getString(2131231107), new OnClickListener(this) {
                final /* synthetic */ a lrr;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
        }
        if (a == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        a.setCanceledOnTouchOutside(false);
        a.ji(false);
        return true;
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        h a;
        this.llg++;
        if (this.llg > 2) {
            a = g.a(this.bij, str2, "", this.bij.getString(2131236672), this.bij.getString(2131231107), new OnClickListener(this) {
                final /* synthetic */ a lrr;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.lrr.bij.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a lrr;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }, 2131689564);
        } else {
            a = g.a(this.bij, false, str2, "", this.bij.getString(2131231107), this.bij.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a lrr;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a lrr;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
        }
        if (a == null) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }
}
