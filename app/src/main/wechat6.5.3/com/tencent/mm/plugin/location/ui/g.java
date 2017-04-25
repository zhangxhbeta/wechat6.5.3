package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.e.d;

public final class g extends RelativeLayout {
    private ImageView gUB;
    public d gUC;
    public boolean gUj = false;
    private Context mContext;

    public g(Context context, d dVar) {
        super(context);
        this.gUC = dVar;
        this.mContext = context;
        this.gUB = (ImageView) View.inflate(this.mContext, 2130904167, this).findViewById(2131758577);
    }

    public final void remove() {
        this.gUC.removeView(this);
        this.gUj = false;
    }
}
