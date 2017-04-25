package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.aa.a;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.d.cf;
import com.tencent.mm.plugin.game.d.cg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.u;

public class GameDetailRankLikeView extends LinearLayout implements OnClickListener {
    String dzg;
    int gjl;
    aa grf;
    a grg;
    private Drawable grh;
    private Drawable gri;
    private Animation grj;
    private ImageView grk;
    private TextView grl;

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.grh = getContext().getResources().getDrawable(2130838339);
        this.gri = getContext().getResources().getDrawable(2130838338);
        this.grj = AnimationUtils.loadAnimation(getContext(), 2130968660);
        inflate(getContext(), 2130903712, this);
        setOnClickListener(this);
        this.grk = (ImageView) findViewById(2131757284);
        this.grl = (TextView) findViewById(2131757285);
    }

    final void asq() {
        if (this.grg != null) {
            if (this.grg.gjx) {
                this.grk.setImageDrawable(this.grh);
            } else {
                this.grk.setImageDrawable(this.gri);
            }
            int i = this.grg.gjw;
            if (i > 99) {
                this.grl.setText("99+");
                return;
            } else if (i == 0) {
                this.grl.setText("");
                return;
            } else {
                this.grl.setText(String.valueOf(i));
                return;
            }
        }
        setVisibility(8);
    }

    public void onClick(View view) {
        if (k.xF().equals(this.grg.ble)) {
            if (this.grg.gjw > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.dzg);
                getContext().startActivity(intent);
            }
        } else if (!this.grg.gjx) {
            this.grg.gjx = true;
            a aVar = this.grg;
            aVar.gjw++;
            this.grf.arK();
            String str = this.dzg;
            String str2 = this.grg.ble;
            b.a aVar2 = new b.a();
            aVar2.czn = new cf();
            aVar2.czo = new cg();
            aVar2.uri = "/cgi-bin/mmgame-bin/upfriend";
            aVar2.czm = 1330;
            b Bv = aVar2.Bv();
            cf cfVar = (cf) Bv.czk.czs;
            cfVar.gkz = str;
            cfVar.gom = str2;
            u.a(Bv, new u.a(this) {
                final /* synthetic */ GameDetailRankLikeView grm;

                {
                    this.grm = r1;
                }

                public final int a(int i, int i2, String str, b bVar, com.tencent.mm.v.k kVar) {
                    if (!(i == 0 && i2 == 0)) {
                        v.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    }
                    return 0;
                }
            });
            af.a(getContext(), 12, 1203, 1, 2, this.dzg, this.gjl, null);
            asq();
            this.grk.startAnimation(this.grj);
        }
    }
}
