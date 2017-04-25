package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.c.i;
import com.tencent.mm.plugin.luckymoney.ui.j.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.c;

public abstract class LuckyMoneyBaseUI extends MMActivity implements c {
    public i hdT = null;
    private j hdU = null;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hdT = new i(this, this);
        this.hdT.gQ(1554);
        this.hdT.gQ(1575);
        this.hdT.gQ(1668);
        this.hdT.gQ(1581);
        this.hdT.gQ(1685);
        this.hdT.gQ(1585);
        this.hdT.gQ(1514);
        this.hdT.gQ(1682);
        this.hdT.gQ(1612);
        this.hdT.gQ(1643);
        this.hdT.gQ(1558);
        this.hdU = new j(this);
        this.hdU.hhC = 1;
        j jVar = this.hdU;
        a z = j.z(jVar.eLn, jVar.hhC);
        if (jVar.eLn.cU().cV() != null) {
            if (z.hhE != null) {
                jVar.eLn.cU().cV().setBackgroundDrawable(z.hhE);
            }
            View customView = jVar.eLn.cU().cV().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(2131755264);
                if (!(findViewById == null || z.hhF == 0)) {
                    findViewById.setBackgroundColor(z.hhF);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || z.hhG == 0)) {
                    textView.setTextColor(z.hhG);
                }
                textView = (TextView) customView.findViewById(16908309);
                if (!(textView == null || z.hhH == 0)) {
                    textView.setTextColor(z.hhH);
                }
                ImageView imageView = (ImageView) customView.findViewById(2131755285);
                if (!(imageView == null || z.hhI == 0)) {
                    imageView.setImageResource(z.hhI);
                }
            }
            if (z.dZc != 0) {
                jVar.mL(z.dZc);
            }
        }
        if (getLayoutId() > 0) {
            vE(2131236646);
        }
    }

    public final void q(Drawable drawable) {
        j jVar = this.hdU;
        if (jVar.eLn.cU().cV() != null) {
            jVar.eLn.cU().cV().setBackgroundDrawable(drawable);
        }
    }

    public final void ayf() {
        j jVar = this.hdU;
        if (jVar.eLn.cU().cV() != null) {
            jVar.eLn.cU().cV().show();
        }
        jVar = this.hdU;
        a z = j.z(jVar.eLn, jVar.hhC);
        if (z.dZc != 0) {
            jVar.mL(z.dZc);
        }
    }

    public final void ayg() {
        j jVar = this.hdU;
        if (jVar.eLn.cU().cV() != null) {
            jVar.eLn.cU().cV().hide();
        }
        jVar = this.hdU;
        jVar.mL(jVar.hhD);
    }

    public void onDestroy() {
        this.hdT.gR(1554);
        this.hdT.gR(1575);
        this.hdT.gR(1668);
        this.hdT.gR(1581);
        this.hdT.gR(1685);
        this.hdT.gR(1585);
        this.hdT.gR(1514);
        this.hdT.gR(1682);
        this.hdT.gR(1612);
        this.hdT.gR(1643);
        this.hdT.gR(1558);
        this.hdU = null;
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hdT.axG()) {
                this.hdT.axF();
            }
            if (this.nDR.dtW.getVisibility() == 8 || this.nDR.dtW.getVisibility() == 4) {
                finish();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (!d(i, i2, str, kVar)) {
            if (i != 0 || i2 != 0) {
                g.bf(this, str);
                finish();
            }
        }
    }

    public final void wd(String str) {
        g.bf(this, str);
    }

    public final void gQ(int i) {
        this.hdT.gQ(i);
    }

    public final void gR(int i) {
        this.hdT.gR(i);
    }

    public final void b(k kVar, boolean z) {
        this.hdT.b(kVar, z);
    }

    public final void j(k kVar) {
        this.hdT.b(kVar, true);
    }
}
