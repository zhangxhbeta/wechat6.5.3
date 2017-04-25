package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class xk extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
                Paint g = c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                c.a(g2, looper).setStrokeWidth(1.0f);
                Paint a = c.a(g, looper);
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 46.0f, 0.0f, 1.0f, 41.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(58.04338f, 85.02192f);
                h.cubicTo(68.83248f, 74.17345f, 75.5f, 59.221767f, 75.5f, 42.712807f);
                h.cubicTo(75.5f, 25.998095f, 68.66525f, 10.879722f, 57.638073f, 5.1184834E-11f);
                h.lineTo(50.21325f, 7.424826f);
                h.cubicTo(59.340397f, 16.404242f, 65.0f, 28.897589f, 65.0f, 42.712807f);
                h.cubicTo(65.0f, 56.322273f, 59.507717f, 68.64895f, 50.618725f, 77.59726f);
                h.lineTo(58.04338f, 85.02192f);
                h.close();
                h.moveTo(40.01204f, 66.99058f);
                h.cubicTo(46.186604f, 60.7568f, 50.0f, 52.180138f, 50.0f, 42.712807f);
                h.cubicTo(50.0f, 33.039722f, 46.01905f, 24.29644f, 39.606136f, 18.031939f);
                h.lineTo(32.18078f, 25.457294f);
                h.cubicTo(36.693905f, 29.821022f, 39.5f, 35.939213f, 39.5f, 42.712807f);
                h.cubicTo(39.5f, 49.280643f, 36.86179f, 55.232292f, 32.587296f, 59.565834f);
                h.lineTo(40.01204f, 66.99058f);
                h.close();
                h.moveTo(13.0f, 55.5f);
                h.cubicTo(20.1797f, 55.5f, 26.0f, 49.679703f, 26.0f, 42.5f);
                h.cubicTo(26.0f, 35.320297f, 20.1797f, 29.5f, 13.0f, 29.5f);
                h.cubicTo(5.820298f, 29.5f, 0.0f, 35.320297f, 0.0f, 42.5f);
                h.cubicTo(0.0f, 49.679703f, 5.820298f, 55.5f, 13.0f, 55.5f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
