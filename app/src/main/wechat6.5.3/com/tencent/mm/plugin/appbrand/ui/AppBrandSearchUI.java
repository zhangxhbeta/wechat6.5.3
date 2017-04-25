package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.FTSEditTextView;
import com.tencent.mm.ui.widget.d.b;
import java.util.List;

public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private String dQH;
    private View dRQ;
    private String dRR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dRR = getIntent().getStringExtra("key_session_id");
        v.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[]{this.dRR});
        g.iuh.h(13929, new Object[]{this.dRR, "", Integer.valueOf(1)});
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.dRR);
        setResult(-1, intent);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean Si() {
        this.dRQ.setVisibility(8);
        return super.Si();
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        if (!TextUtils.isEmpty(str2)) {
            this.dRQ.setVisibility(8);
        }
        try {
            this.liH.i(10001, null);
        } catch (RemoteException e) {
            v.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[]{e});
        }
        super.a(str, str2, list, bVar);
    }

    protected final void bB(View view) {
        super.bB(view);
        this.dQH = getIntent().getStringExtra("key_nearby_url");
        final String stringExtra = getIntent().getStringExtra("key_nearby_list_id");
        this.dRQ = getLayoutInflater().inflate(2130903112, (ViewGroup) view, false);
        View findViewById = this.dRQ.findViewById(2131755398);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppBrandSearchUI dRS;

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(this.dRS.dQH)) {
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", this.dRS.dQH);
                    intent.putExtra("geta8key_scene", 41);
                    c.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    a.A(1, stringExtra);
                }
            }
        });
        if (TextUtils.isEmpty(this.dQH)) {
            findViewById.setVisibility(8);
            this.dRQ.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.dRQ.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.dRQ);
            return;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (getWindow().hasFeature(9)) {
            View view2 = this.dRQ;
            int paddingLeft = this.dRQ.getPaddingLeft();
            Rect rect = new Rect();
            int bjY = bjY();
            View decorView = getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int height = decorView.getHeight();
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            if (height == 0) {
                bjY += Sj();
            }
            bjY = (height - rect.height() < 0 || iArr[1] <= 200) ? bjY + rect.top : bjY + (height - rect.height());
            view2.setPadding(paddingLeft, bjY + this.dRQ.getPaddingTop(), this.dRQ.getPaddingRight(), this.dRQ.getPaddingBottom());
        }
        addContentView(this.dRQ, layoutParams);
    }

    private int Sj() {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = getResources().getDimensionPixelSize(be.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        return i;
    }
}
