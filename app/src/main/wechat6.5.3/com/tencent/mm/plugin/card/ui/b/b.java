package com.tencent.mm.plugin.card.ui.b;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class b extends f {
    private com.tencent.mm.plugin.card.base.b eBg;
    private MMActivity eBk;
    private View eMu;
    private TextView eMv;
    private g eMw;

    public final void NI() {
        this.eBk = this.eMF.abt();
        this.eMw = this.eMF.abv();
    }

    public final void destroy() {
        super.destroy();
        this.eBk = null;
        this.eMw = null;
    }

    public final void update() {
        if (this.eMu == null) {
            this.eMu = ((ViewStub) findViewById(2131755807)).inflate();
            this.eMu.findViewById(2131755728).setOnClickListener(this.eMF.abu());
        }
        this.eBg = this.eMF.abq();
        this.eMw = this.eMF.abv();
        boolean ace = this.eMw.ace();
        boolean acf = this.eMw.acf();
        if (ace) {
            this.eMu.setVisibility(0);
            v.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + ace + " acceptViewEnabled:" + acf);
            Button button = (Button) this.eMu.findViewById(2131755728);
            View findViewById = this.eMu.findViewById(2131755727);
            findViewById.setBackgroundDrawable(null);
            findViewById.setOnClickListener(null);
            int dimensionPixelSize = this.eBk.getResources().getDimensionPixelSize(2131493367);
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            if (acf) {
                if (!TextUtils.isEmpty(this.eBg.Zv().mkW)) {
                    button.setText(this.eBg.Zv().mkW);
                }
                Drawable c;
                Drawable bs;
                Drawable stateListDrawable;
                if (this.eBg.Zc()) {
                    button.setTextColor(j.qv(this.eBg.Zv().coN));
                    c = j.c(this.eBk, j.qv(this.eBg.Zv().coN), dimensionPixelSize);
                    bs = j.bs(j.qv(this.eBg.Zv().coN), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, bs);
                    stateListDrawable.addState(new int[0], c);
                    int[] iArr = new int[]{this.eBk.getResources().getColor(2131690127), j.qv(this.eBg.Zv().coN)};
                    int[][] iArr2 = new int[][]{new int[]{16842919, 16842910}, new int[0]};
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(new ColorStateList(iArr2, iArr));
                    layoutParams = (LayoutParams) this.eMu.getLayoutParams();
                    layoutParams.topMargin = this.eBk.getResources().getDimensionPixelSize(2131493343);
                    this.eMu.setLayoutParams(layoutParams);
                    this.eMu.findViewById(2131755737).setVisibility(8);
                    final f aby = this.eMF.aby();
                    CheckBox checkBox = (CheckBox) this.eMu.findViewById(2131755738);
                    if (aby.ZU() == null || !aby.ZU().eBW) {
                        v.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
                        checkBox.setVisibility(8);
                    } else {
                        v.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
                        checkBox.setVisibility(0);
                        qt qtVar = this.eBg.Zv().mlh;
                        if (qtVar == null || TextUtils.isEmpty(qtVar.text)) {
                            checkBox.setText(aby.ZU().title);
                        } else {
                            checkBox.setText(qtVar.text);
                        }
                        checkBox.setChecked(aby.ZU().eBX);
                        checkBox.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ b eMy;

                            public final void onClick(View view) {
                                if (((CheckBox) view).isChecked()) {
                                    aby.ZU().eBX = true;
                                } else {
                                    aby.ZU().eBX = false;
                                }
                            }
                        });
                    }
                } else if (this.eBg.Zd() || this.eBg.Zb() || this.eBg.Ze()) {
                    c = j.bs(j.qv(this.eBg.Zv().coN), dimensionPixelSize);
                    bs = j.bs(j.am(this.eBg.Zv().coN, 175), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, bs);
                    stateListDrawable.addState(new int[0], c);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.eBk.getResources().getColor(2131690182));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    c = j.bs(j.qv(this.eBg.Zv().coN), dimensionPixelSize);
                    bs = j.bs(j.am(this.eBg.Zv().coN, 175), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, bs);
                    stateListDrawable.addState(new int[0], c);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.eBk.getResources().getColor(2131690182));
                }
            } else {
                this.eMu.setEnabled(false);
                findViewById.setEnabled(false);
                button.setEnabled(false);
                button.setText(this.eBg.Zc() ? this.eBg.Zv().mkW : this.eMw.abX());
                if (this.eBg.Zc()) {
                    button.setTextColor(j.am(this.eBg.Zv().coN, 125));
                    button.setBackgroundDrawable(j.c(this.eBk, j.am(this.eBg.Zv().coN, 125), dimensionPixelSize));
                    layoutParams = (LayoutParams) this.eMu.getLayoutParams();
                    layoutParams.topMargin = this.eBk.getResources().getDimensionPixelSize(2131493344);
                    this.eMu.setLayoutParams(layoutParams);
                    this.eMu.findViewById(2131755737).setVisibility(8);
                } else if (this.eBg.Zd() || this.eBg.Zb() || this.eBg.Ze()) {
                    button.setTextColor(this.eBk.getResources().getColor(2131689769));
                    button.setBackgroundDrawable(j.t(this.eBk, this.eBk.getResources().getColor(2131689586)));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    button.setTextColor(this.eBk.getResources().getColor(2131689769));
                    button.setBackgroundDrawable(j.t(this.eBk, this.eBk.getResources().getColor(2131689586)));
                }
            }
            if (!this.eBg.Zd() && !this.eBg.Zb()) {
                if (this.eBg.Zv().mli != null && !be.kS(this.eBg.Zv().mli.text)) {
                    if (this.eMv == null) {
                        this.eMv = (TextView) this.eMu.findViewById(2131755736);
                    }
                    this.eMv.setText(this.eBg.Zv().mli.text);
                    if (!be.kS(this.eBg.Zv().mli.url)) {
                        this.eMv.setOnClickListener(this.eMF.abu());
                        this.eMv.setTextColor(j.qv(this.eBg.Zv().coN));
                    }
                    this.eMv.setVisibility(0);
                    return;
                } else if (this.eMv != null) {
                    this.eMv.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        v.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
        this.eMu.setVisibility(8);
    }

    public final void acF() {
        this.eMu.setVisibility(8);
    }
}
