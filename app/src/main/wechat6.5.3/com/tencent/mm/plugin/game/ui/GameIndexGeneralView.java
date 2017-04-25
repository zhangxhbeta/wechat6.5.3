package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.v;

public class GameIndexGeneralView extends LinearLayout implements OnClickListener {
    String appId;
    TextView dID;
    int fnn;
    int gjl;
    TextView gtl;
    TextView gtm;
    ImageView gtn;
    ImageView gto;
    ImageView gtp;
    ImageView gtq;
    FrameLayout gtr;
    LinearLayout gts;
    int gtt;
    Context mContext;

    public GameIndexGeneralView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131755226);
        this.gtl = (TextView) findViewById(2131757316);
        this.gtm = (TextView) findViewById(2131757317);
        this.gtn = (ImageView) findViewById(2131757323);
        this.gto = (ImageView) findViewById(2131757319);
        this.gtp = (ImageView) findViewById(2131757322);
        this.gtq = (ImageView) findViewById(2131757320);
        this.gtr = (FrameLayout) findViewById(2131757318);
        this.gts = (LinearLayout) findViewById(2131757321);
        this.fnn = this.mContext.getResources().getDimensionPixelSize(2131492971);
        this.gtt = a.fromDPToPix(this.mContext, 8);
        v.i("MicroMsg.GameIndexGeneralView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof bo)) {
            v.w("MicroMsg.GameIndexGeneralView", "jumpURL is null");
            return;
        }
        bo boVar = (bo) view.getTag();
        c.n(this.mContext, boVar.gkT, "game_center_mygame_comm");
        af.a(this.mContext, 10, 1002, boVar.gkU, 7, this.appId, this.gjl, af.ug(boVar.gkV));
    }
}
