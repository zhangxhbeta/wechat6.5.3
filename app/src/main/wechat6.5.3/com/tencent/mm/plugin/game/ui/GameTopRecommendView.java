package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public class GameTopRecommendView extends LinearLayout implements OnClickListener {
    private TextView dID;
    private LinearLayout fQp;
    int gjl;
    j gpM;
    int gvb;
    private Context mContext;

    public static class a {
        public String ghF;
        public String ghp;
        public LinkedList<c> gyQ;
        public String gyR;
        public String title;
        public int type;
    }

    public GameTopRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dID = (TextView) findViewById(2131755226);
        this.fQp = (LinearLayout) findViewById(2131757395);
        this.gpM = new j();
        v.i("MicroMsg.TopRecommendView", "initView finished");
    }

    final void a(a aVar) {
        if (aVar == null) {
            v.w("MicroMsg.TopRecommendView", "TopRecommendInfo is null");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (be.kS(aVar.title)) {
            this.dID.setVisibility(8);
        } else {
            this.dID.setText(aVar.title);
            this.dID.setVisibility(0);
        }
        this.fQp.removeAllViews();
        switch (aVar.type) {
            case 1:
                View imageView = new ImageView(this.mContext);
                imageView.setScaleType(ScaleType.FIT_XY);
                e.asK().e(imageView, aVar.gyR);
                this.fQp.addView(imageView, new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(this.mContext, 157)));
                setTag(aVar);
                setOnClickListener(this);
                if (this.gvb == 2) {
                    af.a(this.mContext, 1011, 1, null, this.gjl, aVar.ghF);
                    return;
                }
                return;
            case 2:
                if (be.bP(aVar.gyQ)) {
                    v.e("MicroMsg.TopRecommendView", "appinfos is null");
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                View inflate = View.inflate(this.mContext, 2130903767, null);
                int screenWidth = com.tencent.mm.plugin.game.e.c.getScreenWidth(this.mContext);
                int round = Math.round((440.0f * ((float) screenWidth)) / 750.0f);
                ImageView imageView2 = (ImageView) inflate.findViewById(2131757396);
                com.tencent.mm.plugin.game.e.e.a.a aVar2 = new com.tencent.mm.plugin.game.e.e.a.a();
                aVar2.gzU = 2130838306;
                e.asK().a(imageView2, aVar.gyR, aVar2.asL());
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131757397);
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                layoutParams.height = Math.round((((float) round) * 270.0f) / 440.0f);
                linearLayout.setLayoutParams(layoutParams);
                Iterator it = aVar.gyQ.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    LinearLayout linearLayout2 = (LinearLayout) View.inflate(this.mContext, 2130903768, null);
                    linearLayout2.setBackgroundResource(0);
                    ImageView imageView3 = (ImageView) linearLayout2.findViewById(2131755481);
                    TextView textView = (TextView) linearLayout2.findViewById(2131755483);
                    TextView textView2 = (TextView) linearLayout2.findViewById(2131757234);
                    try {
                        if (!be.kS(cVar.gho)) {
                            textView2.setTextColor(Color.parseColor(cVar.gho));
                        }
                    } catch (IllegalArgumentException e) {
                        v.e("MicroMsg.TopRecommendView", "gameDesc.setTextColor encounter a exception:" + e);
                        textView2.setTextColor(Color.parseColor("#929292"));
                    }
                    try {
                        if (!be.kS(cVar.ghE)) {
                            textView.setTextColor(Color.parseColor(cVar.ghE));
                        }
                    } catch (IllegalArgumentException e2) {
                        v.e("MicroMsg.TopRecommendView", "gameName.setTextColor encounter a exception:" + e2);
                        textView.setTextColor(Color.parseColor("#222222"));
                    }
                    e.asK().a(imageView3, cVar.field_appId, com.tencent.mm.bd.a.getDensity(this.mContext));
                    if (be.kS(cVar.name)) {
                        textView.setText(cVar.field_appName);
                    } else {
                        textView.setText(cVar.name);
                    }
                    if (!be.kS(cVar.ghn)) {
                        textView2.setText(cVar.ghn);
                        textView2.setVisibility(0);
                    }
                    linearLayout2.setTag(cVar);
                    this.gpM.ur(cVar.ghF);
                    linearLayout2.setOnClickListener(this.gpM);
                    linearLayout.addView(linearLayout2, new LayoutParams(-1, -2, 1.0f));
                    if (this.gvb == 2) {
                        af.a(this.mContext, 1012, cVar.position, null, this.gjl, cVar.ghF);
                    }
                }
                this.fQp.addView(inflate, new LayoutParams(screenWidth, round));
                setTag(null);
                return;
            default:
                v.e("MicroMsg.TopRecommendView", "unknowed type " + aVar.type);
                setVisibility(8);
                return;
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            com.tencent.mm.plugin.game.e.c.n(this.mContext, aVar.ghp, "game_center_nomygame_recommend");
            af.a(this.mContext, 10, 1011, 1, 7, this.gjl, aVar.ghF);
        }
    }
}
