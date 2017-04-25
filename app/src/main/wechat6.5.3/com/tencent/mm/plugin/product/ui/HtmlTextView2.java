package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class HtmlTextView2 extends MMWebView {
    private WebViewClient hRx = new WebViewClient(this) {
        final /* synthetic */ HtmlTextView2 hRy;

        {
            this.hRy = r1;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            v.d("test", str);
            return true;
        }
    };

    public HtmlTextView2(Context context, AttributeSet attributeSet, int i) {
        super(aa.getContext(), attributeSet, i);
        NI();
    }

    public HtmlTextView2(Context context, AttributeSet attributeSet) {
        super(aa.getContext(), attributeSet);
        NI();
    }

    private void NI() {
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ HtmlTextView2 hRy;

            {
                this.hRy = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
        setVerticalScrollBarEnabled(false);
        getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        getSettings().setDefaultTextEncodingName("utf-8");
    }
}
