package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.v;

public class GameIndexRankView extends LinearLayout implements OnClickListener {
    String appId;
    TextView dID;
    int gjl;
    ImageView gtp;
    ImageView gtu;
    TextView gtw;
    Context mContext;

    public GameIndexRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131755226);
        this.gtw = (TextView) findViewById(2131757325);
        this.gtu = (ImageView) findViewById(2131757324);
        this.gtp = (ImageView) findViewById(2131757322);
        v.i("MicroMsg.GameIndexRankView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof bn)) {
            v.w("MicroMsg.GameIndexRankView", "jumpURL is null");
            return;
        }
        bn bnVar = (bn) view.getTag();
        c.n(this.mContext, bnVar.gkT, "game_center_mygame_rank");
        af.a(this.mContext, 10, 1002, bnVar.gkU, 7, this.appId, this.gjl, af.ug(bnVar.gkV));
    }
}
