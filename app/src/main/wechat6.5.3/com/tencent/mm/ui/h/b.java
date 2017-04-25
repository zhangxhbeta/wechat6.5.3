package com.tencent.mm.ui.h;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@SuppressLint({"SetJavaScriptEnabled"})
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class b extends Dialog {
    static final float[] oNu = new float[]{20.0f, 60.0f};
    static final float[] oNv = new float[]{40.0f, 60.0f};
    static final LayoutParams oNw = new LayoutParams(-1, -1);
    private MMWebView jyU;
    private String mUrl;
    private FrameLayout oNA;
    private ProgressDialog oNy;
    private ImageView oNz;
    private a oYs;

    public interface a {
        void bJS();

        void k(Bundle bundle);

        void onCancel();
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
    private class b extends WebViewClient {
        private boolean oNC;
        final /* synthetic */ b oYt;

        private b(b bVar) {
            this.oYt = bVar;
            this.oNC = true;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            v.d("Twitter-WebView", "Redirect URL: " + str);
            if (str.startsWith("wechatapp://sign-in-twitter.wechatapp.com/")) {
                Bundle Pr = Pr(str);
                if (Pr.getString("denied") == null) {
                    this.oYt.oYs.k(Pr);
                } else {
                    this.oYt.oYs.onCancel();
                }
                this.oYt.dismiss();
            } else {
                this.oYt.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
            return true;
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.oNC = false;
            a a = this.oYt.oYs;
            com.tencent.mm.ui.e.a.b bVar = new com.tencent.mm.ui.e.a.b(str, i, str2);
            a.bJS();
            try {
                this.oYt.dismiss();
                this.oYt.oNy.dismiss();
            } catch (Throwable e) {
                v.a("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            v.d("Twitter-WebView", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            try {
                this.oYt.oNy.show();
                this.oYt.oNy.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ b oYu;

                    {
                        this.oYu = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (this.oYu.oNC && this.oYu.oYt != null) {
                            this.oYu.oYt.oYs.onCancel();
                            this.oYu.oYt.dismiss();
                        }
                    }
                });
            } catch (Throwable e) {
                v.a("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.oNC = false;
            try {
                this.oYt.oNy.dismiss();
            } catch (Throwable e) {
                v.a("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
            this.oYt.oNA.setBackgroundColor(0);
            this.oYt.jyU.setVisibility(0);
            this.oYt.oNz.setVisibility(0);
        }

        private static Bundle Pq(String str) {
            Bundle bundle = new Bundle();
            if (str != null) {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            return bundle;
        }

        private static Bundle Pr(String str) {
            try {
                URL url = new URL(str.replace("wechatapp", "http"));
                Bundle Pq = Pq(url.getQuery());
                Pq.putAll(Pq(url.getRef()));
                return Pq;
            } catch (MalformedURLException e) {
                return new Bundle();
            }
        }
    }

    public b(Context context, String str, a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.oYs = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oNy = new ProgressDialog(getContext());
        this.oNy.requestWindowFeature(1);
        this.oNy.setMessage(getContext().getString(2131235701));
        requestWindowFeature(1);
        this.oNA = new FrameLayout(getContext());
        this.oNz = new ImageView(getContext());
        this.oNz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b oYt;

            {
                this.oYt = r1;
            }

            public final void onClick(View view) {
                this.oYt.oYs.onCancel();
                this.oYt.dismiss();
            }
        });
        this.oNz.setImageDrawable(getContext().getResources().getDrawable(2130838039));
        this.oNz.setVisibility(4);
        int intrinsicWidth = this.oNz.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.jyU = com.tencent.mm.ui.widget.MMWebView.a.eP(getContext());
        this.jyU.setVerticalScrollBarEnabled(false);
        this.jyU.setHorizontalScrollBarEnabled(false);
        this.jyU.setWebViewClient(new b());
        this.jyU.getSettings().setJavaScriptEnabled(true);
        this.jyU.loadUrl(this.mUrl);
        this.jyU.setLayoutParams(oNw);
        this.jyU.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.jyU);
        this.oNA.addView(linearLayout);
        this.oNA.addView(this.oNz, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.oNA, new ViewGroup.LayoutParams(-1, -1));
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.oYs.onCancel();
        dismiss();
        return true;
    }
}
