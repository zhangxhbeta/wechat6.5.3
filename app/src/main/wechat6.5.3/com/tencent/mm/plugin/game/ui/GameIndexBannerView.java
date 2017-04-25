package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.v;

public class GameIndexBannerView extends LinearLayout implements OnClickListener {
    TextView dID;
    String dzg;
    int gjl;
    String gtj;
    ImageView gtk;
    int kB;
    Context mContext;

    public GameIndexBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131755226);
        this.gtk = (ImageView) findViewById(2131755052);
        v.i("MicroMsg.GameIndexBannerView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            v.w("MicroMsg.GameIndexBannerView", "jumpURL is null");
            return;
        }
        c.n(this.mContext, (String) view.getTag(), "game_center_mygame_banner");
        af.a(this.mContext, 10, 1002, this.kB, 7, this.dzg, this.gjl, this.gtj);
    }
}
