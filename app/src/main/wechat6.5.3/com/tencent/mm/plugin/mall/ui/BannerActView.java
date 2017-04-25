package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import java.util.List;

public class BannerActView extends LinearLayout {
    private List<a> hin;
    private TextView hio = ((TextView) LayoutInflater.from(getContext()).inflate(2130903161, this, true).findViewById(2131755549));

    public BannerActView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BannerActView hip;

            {
                this.hip = r1;
            }

            public final void onClick(View view) {
                this.hip.setVisibility(8);
                b.bB(this.hip.hin);
                if (this.hip.hin != null && this.hip.hin.size() > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ((a) this.hip.hin.get(0)).kRd);
                    c.b(this.hip.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }
}
