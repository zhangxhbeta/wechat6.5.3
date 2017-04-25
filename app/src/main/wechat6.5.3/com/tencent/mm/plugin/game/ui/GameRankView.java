package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;

public class GameRankView extends FrameLayout {
    ListView gwO;
    View gwP;
    q gwQ;
    private GameRankFooter gwR;
    private Context mContext;

    public GameRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gwO = (ListView) findViewById(2131757357);
        this.gwR = (GameRankFooter) View.inflate(this.mContext, 2130903750, null);
        GameRankFooter gameRankFooter = this.gwR;
        gameRankFooter.gwC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameRankView gwS;

            {
                this.gwS = r1;
            }

            public final void onClick(View view) {
                q a = this.gwS.gwQ;
                if (a.gwn.size() > a.gwp) {
                    if (a.gwp + 25 >= a.gwn.size()) {
                        a.gwp = a.gwn.size();
                        a.gws.asz();
                        a.gwu = true;
                    } else {
                        a.gwp += 25;
                        a.gws.asy();
                    }
                    a.gwo = a.gwn.subList(0, a.gwp);
                    if (a.gwt || a.gwv <= a.gwp) {
                        a.gws.asA();
                    } else if (a.gwr != null) {
                        a.gws.a(a.gwr);
                    } else {
                        a.gws.asA();
                    }
                    a.notifyDataSetChanged();
                }
            }
        });
        this.gwO.addFooterView(this.gwR);
        this.gwQ = new q(this.mContext, this.gwR);
        this.gwP = findViewById(2131757355);
    }
}
