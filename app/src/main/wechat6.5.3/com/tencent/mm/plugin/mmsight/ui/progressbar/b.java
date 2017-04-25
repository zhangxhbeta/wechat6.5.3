package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;

public final class b {
    ValueAnimator hvM;
    float hyB = 0.0f;
    a hyC;
    a hyD;
    boolean hyE = false;
    public a hyF;
    PointF hyG;
    PointF hyH;
    PointF hyI;
    PointF hyJ;
    PointF hyK;
    PointF hyL;
    float hyM = 0.0f;
    float hyN = 0.0f;
    float hyO = 0.0f;
    float hyP = 0.0f;
    Path hyQ;
    private Paint hyR = null;

    public interface a {
        void a(a aVar);

        void aBM();
    }

    public b(a aVar, a aVar2, a aVar3) {
        this.hyC = aVar;
        this.hyD = aVar2;
        this.hyF = aVar3;
        this.hyN = ((float) MMSightProgressBar.fEX) * 2.0f;
        this.hyO = ((float) (-MMSightProgressBar.fEX)) * 0.5f;
        this.hyQ = new Path();
        this.hyR = new Paint();
        this.hyR.setAntiAlias(true);
        this.hyR.setStyle(Style.FILL);
    }
}
