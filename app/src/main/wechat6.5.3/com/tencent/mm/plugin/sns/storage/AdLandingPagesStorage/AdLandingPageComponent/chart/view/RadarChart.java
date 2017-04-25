package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart extends Chart {
    private Context context;
    public ArrayList<a> jwS;
    public c jwT = new c();
    public TextView jwU;
    public RadarGrid jwV;
    private RadarDataLayer[] jwW;
    private a jwX;
    private boolean jwY = true;
    private boolean jwZ = true;
    public int jxa = 3;
    public int jxb = 0;
    public int jxc = 4;
    public Spannable[] jxd;
    private float jxe = 1.0f;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public final void a(a... aVarArr) {
        int i;
        int i2 = 0;
        removeAllViews();
        for (a size : aVarArr) {
            if (size.size() <= 0) {
                throw new Exception("Not enough elements.");
            }
        }
        for (a size2 : aVarArr) {
            i = 0;
            while (i < aVarArr.length) {
                if (size2.a(aVarArr[i])) {
                    i++;
                } else {
                    throw new Error("Layer not compatible.");
                }
            }
        }
        this.jxd = aVarArr[0].aTD();
        this.jxb = aVarArr[0].size();
        if (this.jwS == null) {
            this.jwS = new ArrayList();
        }
        for (Object add : aVarArr) {
            this.jwS.add(add);
        }
        this.jwV = new RadarGrid(this.context, this.jxb, this.jxc, this.jxe, this.jxd, this.jwT);
        addView(this.jwV);
        this.jwW = new RadarDataLayer[this.jxa];
        while (i2 < this.jwW.length && this.jwS.size() > i2) {
            this.jwW[i2] = new RadarDataLayer(this.context, this.jxe, (a) this.jwS.get(i2));
            addView(this.jwW[i2]);
            i2++;
        }
        if (this.jwX == null) {
            this.jwX = new a(this.context, this.jwT);
        }
        addView(this.jwX);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }
}
