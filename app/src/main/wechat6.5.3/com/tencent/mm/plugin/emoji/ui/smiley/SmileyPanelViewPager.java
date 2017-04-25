package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.CustomViewPager;

public class SmileyPanelViewPager extends CustomViewPager {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    f fkM;
    a fmC;
    private boolean fmD = j.aF(getContext());
    private int fmE = 0;
    private int fmF = 0;

    public interface a {
        void jW(int i);
    }

    public SmileyPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (be.getInt(VERSION.SDK, 0) >= 9) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        boolean aF = j.aF(getContext());
        if (this.fkM != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.fmE) || (i > 0 && i != this.fmF)))) {
            if (this.fkM.fmc <= 0) {
                this.fkM.jY(i2);
            }
            this.fkM.fmd = i;
            this.fkM.flZ = 0;
            if (!(this.fmC == null || (this.fkM.fmp && !this.fkM.fmq && this.fmD == aF))) {
                v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
                this.fkM.fmq = false;
                this.fmC.jW(i2);
            }
        }
        this.fmD = aF;
        if (i2 > 0) {
            this.fmE = i2;
        }
        if (i > 0) {
            this.fmF = i;
        }
    }

    public final void a(t tVar) {
        super.a(tVar);
    }

    public final void a(g gVar) {
        if (gVar != null) {
            gVar.ahR();
            gVar.fmG = false;
        }
        super.a(gVar);
    }
}
