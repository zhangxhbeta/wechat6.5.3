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
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class GameGiftBannerView extends LinearLayout implements OnClickListener {
    String dzg;
    ImageView fqF;
    int gjl;
    TextView gth;
    TextView gti;
    String gtj;
    int kB;
    Context mContext;

    public GameGiftBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public GameGiftBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gth = (TextView) findViewById(2131755226);
        this.gti = (TextView) findViewById(2131757305);
        this.fqF = (ImageView) findViewById(2131757306);
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            v.w("MicroMsg.GameGiftBannerView", "jumpURL is null");
            return;
        }
        String str = (String) view.getTag();
        if (be.kS(str)) {
            v.w("MicroMsg.GameGiftBannerView", "jumpURL is null");
            return;
        }
        c.n(this.mContext, str, "game_center_mygame_banner");
        af.a(this.mContext, 10, 1002, this.kB, 7, this.dzg, this.gjl, this.gtj);
    }
}
