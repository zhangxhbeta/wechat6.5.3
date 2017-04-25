package com.tencent.mm.ui.e.a;

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
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class f extends i {
    static final float[] oNu = new float[]{20.0f, 60.0f};
    static final float[] oNv = new float[]{40.0f, 60.0f};
    static final LayoutParams oNw = new LayoutParams(-1, -1);
    private MMWebView jyU;
    private String mUrl;
    private FrameLayout oNA;
    private com.tencent.mm.ui.e.a.c.a oNx;
    private ProgressDialog oNy;
    private ImageView oNz;

    private class a extends WebViewClient {
        final /* synthetic */ f oNB;
        private boolean oNC;

        private a(f fVar) {
            this.oNB = fVar;
            this.oNC = true;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            v.d("Facebook-WebView", "Redirect URL: " + str);
            if (str.startsWith("fbconnect://success")) {
                Bundle Pr = e.Pr(str);
                String string = Pr.getString("error");
                if (string == null) {
                    string = Pr.getString("error_type");
                }
                if (string == null) {
                    this.oNB.oNx.k(Pr);
                } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                    this.oNB.oNx.onCancel();
                } else {
                    this.oNB.oNx.a(new d(string));
                }
                this.oNB.dismiss();
                return true;
            } else if (str.startsWith("fbconnect://cancel")) {
                this.oNB.oNx.onCancel();
                try {
                    this.oNB.dismiss();
                    return true;
                } catch (Throwable e) {
                    v.a("MicroMsg.FbDialog", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return true;
                }
            } else if (str.contains("touch")) {
                return false;
            } else {
                this.oNB.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.oNC = false;
            this.oNB.oNx.a(new b(str, i, str2));
            try {
                this.oNB.dismiss();
                this.oNB.oNy.dismiss();
            } catch (Throwable e) {
                v.a("MicroMsg.FbDialog", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            v.d("Facebook-WebView", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            try {
                this.oNB.oNy.show();
                this.oNB.oNy.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ a oND;

                    {
                        this.oND = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (this.oND.oNC && this.oND.oNB != null) {
                            this.oND.oNB.oNx.onCancel();
                            this.oND.oNB.dismiss();
                        }
                    }
                });
            } catch (Throwable e) {
                v.a("MicroMsg.FbDialog", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.oNC = false;
            try {
                this.oNB.oNy.dismiss();
            } catch (Throwable e) {
                v.a("MicroMsg.FbDialog", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            this.oNB.oNA.setBackgroundColor(0);
            this.oNB.jyU.setVisibility(0);
            this.oNB.oNz.setVisibility(0);
        }
    }

    public f(Context context, String str, com.tencent.mm.ui.e.a.c.a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.oNx = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oNy = new ProgressDialog(getContext());
        this.oNy.requestWindowFeature(1);
        this.oNy.setMessage(getContext().getString(2131232625));
        requestWindowFeature(1);
        this.oNA = new FrameLayout(getContext());
        this.oNz = new ImageView(getContext());
        this.oNz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f oNB;

            {
                this.oNB = r1;
            }

            public final void onClick(View view) {
                this.oNB.oNx.onCancel();
                this.oNB.dismiss();
            }
        });
        this.oNz.setImageDrawable(getContext().getResources().getDrawable(2130838039));
        this.oNz.setVisibility(4);
        int intrinsicWidth = this.oNz.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.jyU = com.tencent.mm.ui.widget.MMWebView.a.eP(getContext());
        this.jyU.setVerticalScrollBarEnabled(false);
        this.jyU.setHorizontalScrollBarEnabled(false);
        this.jyU.setWebViewClient(new a());
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
        this.oNx.onCancel();
        dismiss();
        return true;
    }
}
