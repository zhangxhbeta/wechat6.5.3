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

public class GameIndexGroup extends LinearLayout implements OnClickListener {
    private String appId;
    TextView dID;
    int gjl;
    private String gtj;
    TextView gtl;
    TextView gtm;
    ImageView gtu;
    private int gtv;
    Context mContext;

    public GameIndexGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131755226);
        this.gtl = (TextView) findViewById(2131757316);
        this.gtm = (TextView) findViewById(2131757317);
        this.gtu = (ImageView) findViewById(2131757324);
        v.i("MicroMsg.GameIndexGroup", "initView finished");
    }

    public final void l(String str, int i, String str2) {
        this.appId = str;
        this.gtv = i;
        this.gtj = str2;
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            v.w("MicroMsg.GameIndexGroup", "jumpUrl is null");
            return;
        }
        c.n(this.mContext, (String) view.getTag(), "game_center_mygame_group");
        af.a(this.mContext, 10, 1002, this.gtv, 7, this.appId, this.gjl, this.gtj);
    }
}
