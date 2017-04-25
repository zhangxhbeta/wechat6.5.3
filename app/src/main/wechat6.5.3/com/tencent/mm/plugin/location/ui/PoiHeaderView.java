package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView eRp;
    public String gUx = "";
    public String gUy = "";
    public SimpleImageView gUz;

    public PoiHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, 2130904165, this);
        this.eRp = (TextView) inflate.findViewById(2131758571);
        this.gUz = (SimpleImageView) inflate.findViewById(2131758572);
        this.eRp.setVisibility(8);
        this.gUz.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PoiHeaderView gUA;

            {
                this.gUA = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                v.d("MicroMsg.PoiHeaderView", "click url %s", new Object[]{be.kS(this.gUA.gUy) ? this.gUA.gUx : this.gUA.gUy});
                intent.putExtra("rawUrl", r0);
                intent.putExtra("showShare", false);
                c.a(this.gUA.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        });
    }
}
