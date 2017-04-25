package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView extends LinearLayout implements OnClickListener {
    private LinearLayout fQp;
    int gjl;
    private int guy;
    private int guz;
    private Context mContext;

    public static class a {
        public String ghD;
        public int guA;
        public String guB;
        public String guC;
        public int position;
    }

    public GameLibraryCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.fQp = (LinearLayout) findViewById(2131757330);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.guy = (width * 100) / 750;
        this.guz = (width - (this.guy * 6)) / 14;
        this.fQp.setPadding(this.guz, com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12), this.guz, com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12));
    }

    public final void B(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            v.e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fQp.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            View linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            View imageView = new ImageView(this.mContext);
            ScaleType scaleType = ScaleType.MATRIX;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.ae.a.a GL = n.GL();
            String str = aVar.ghD;
            com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
            aVar2.cPr = true;
            GL.a(str, imageView, aVar2.GU());
            linearLayout.addView(imageView, this.guy, this.guy);
            imageView = new TextView(this.mContext);
            imageView.setText(aVar.guB);
            imageView.setTextSize(1, 14.0f);
            imageView.setTextColor(getResources().getColor(2131689792));
            imageView.setSingleLine(true);
            imageView.setEllipsize(TruncateAt.END);
            imageView.setGravity(17);
            imageView.setLayoutParams(new LayoutParams(-1, -2));
            imageView.setPadding(0, com.tencent.mm.bd.a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(imageView);
            linearLayout.setTag(aVar);
            linearLayout.setOnClickListener(this);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.guz, 0, this.guz, 0);
            this.fQp.addView(linearLayout, layoutParams);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            int i = 7;
            if (be.kS(aVar.guC)) {
                Intent intent = new Intent(this.mContext, GameCategoryUI.class);
                intent.putExtra("extra_type", 1);
                intent.putExtra("extra_category_id", aVar.guA);
                intent.putExtra("extra_category_name", aVar.guB);
                intent.putExtra("game_report_from_scene", aVar.guA + 100);
                this.mContext.startActivity(intent);
                i = 6;
            } else {
                c.W(this.mContext, aVar.guC);
            }
            af.a(this.mContext, 11, aVar.guA + 100, aVar.position, i, this.gjl, null);
        }
    }
}
