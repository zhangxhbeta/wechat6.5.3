package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public class GameRecommendView extends LinearLayout implements OnClickListener {
    private TextView dID;
    int gjl;
    j gpM;
    private LinearLayout gwT;
    private LayoutInflater gwU;
    private Context mContext;

    public static class a {
        public LinkedList<c> gwV;
        public String title;
    }

    public GameRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131755226);
        this.gwT = (LinearLayout) findViewById(2131756740);
        this.gwU = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.gpM = new j();
        v.i("MicroMsg.GameRecommendView", "initView finished");
    }

    final void a(a aVar) {
        if (be.kS(aVar.title)) {
            this.dID.setVisibility(8);
        } else {
            this.dID.setText(aVar.title);
            this.dID.setVisibility(0);
        }
        while (this.gwT.getChildCount() < aVar.gwV.size()) {
            this.gwT.addView((LinearLayout) this.gwU.inflate(2130903753, this.gwT, false), new LayoutParams(-1, -1, 1.0f));
        }
        for (int i = 0; i < this.gwT.getChildCount(); i++) {
            if (i < aVar.gwV.size()) {
                this.gwT.getChildAt(i).setVisibility(0);
            } else {
                this.gwT.getChildAt(i).setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < aVar.gwV.size(); i2++) {
            c cVar = (c) aVar.gwV.get(i2);
            View childAt = this.gwT.getChildAt(i2);
            ImageView imageView = (ImageView) childAt.findViewById(2131755481);
            TextView textView = (TextView) childAt.findViewById(2131755483);
            TextView textView2 = (TextView) childAt.findViewById(2131757234);
            if (be.kS(cVar.ghD)) {
                e.asK().a(imageView, cVar.field_appId, com.tencent.mm.bd.a.getDensity(this.mContext));
            } else {
                com.tencent.mm.plugin.game.e.e.a.a aVar2 = new com.tencent.mm.plugin.game.e.e.a.a();
                aVar2.gzU = 2130838303;
                e.asK().a(imageView, cVar.ghD, aVar2.asL());
            }
            if (be.kS(cVar.name)) {
                textView.setText(cVar.field_appName);
            } else {
                textView.setText(cVar.name);
            }
            if (!be.kS(cVar.ghn)) {
                textView2.setText(cVar.ghn);
                textView2.setVisibility(0);
            }
            childAt.setTag(cVar);
            if (cVar.type == 2) {
                childAt.setOnClickListener(this);
            } else {
                childAt.setOnClickListener(this.gpM);
            }
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            if (!be.kS(cVar.ghp)) {
                com.tencent.mm.plugin.game.e.c.n(this.mContext, cVar.ghp, "game_center_today_recommend");
                af.a(this.mContext, cVar.scene, cVar.bmG, cVar.position, 7, cVar.field_appId, this.gjl, cVar.bln, null);
            }
        }
    }
}
