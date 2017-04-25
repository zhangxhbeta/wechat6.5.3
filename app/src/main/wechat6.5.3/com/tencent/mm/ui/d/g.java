package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.be;

public final class g extends b {
    String nQH = null;
    String nQI = null;
    boolean nQK = false;

    public g(Context context, String str, String str2, boolean z) {
        super(context);
        this.nQH = str;
        this.nQI = str2;
        this.nQK = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(2131756284);
            CharSequence M = ak.yW().xu().M(this.nQH, "wording");
            CharSequence M2 = ak.yW().xu().M(this.nQI, "wording");
            if (!be.kS(M)) {
                textView.setText(M);
            } else if (!be.kS(M2)) {
                textView.setText(M2);
            }
            ((TextView) this.view.findViewById(2131756285)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ g nQL;

                {
                    this.nQL = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("k_username", this.nQL.nQH);
                    int i = 39;
                    if (this.nQL.nQK) {
                        i = 36;
                    }
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
                    if (this.nQL.lKT.get() != null) {
                        c.b((Context) this.nQL.lKT.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    ak.yW().xu().gh(this.nQL.nQH);
                    ak.yW().xu().gh(this.nQL.nQI);
                }
            });
            ((ImageView) this.view.findViewById(2131756286)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ g nQL;

                {
                    this.nQL = r1;
                }

                public final void onClick(View view) {
                    ak.yW().xu().gh(this.nQL.nQH);
                    ak.yW().xu().gh(this.nQL.nQI);
                }
            });
        }
    }

    public final int getLayoutId() {
        return 2130903366;
    }

    public final void destroy() {
    }
}
