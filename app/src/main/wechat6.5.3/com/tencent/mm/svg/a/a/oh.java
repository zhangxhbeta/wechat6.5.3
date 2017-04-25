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

public final class oh extends c {
    private final int height = 54;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(1.0513232f, 4.9491887f);
                h.cubicTo(0.73179597f, 3.1712198f, 1.9300232f, 0.9937079f, 3.9270685f, 1.1035824f);
                h.cubicTo(19.633831f, 0.9837193f, 35.35058f, 1.0836052f, 51.05734f, 1.0536394f);
                h.cubicTo(52.844696f, 0.724016f, 54.961563f, 1.9426237f, 54.901653f, 3.9103754f);
                h.cubicTo(55.041443f, 14.298506f, 54.931606f, 24.696625f, 54.951576f, 35.084755f);
                h.cubicTo(55.26112f, 36.872715f, 54.062893f, 39.09018f, 52.035892f, 38.960327f);
                h.cubicTo(42.370193f, 39.080193f, 32.694508f, 38.970318f, 23.028807f, 39.010273f);
                h.cubicTo(18.685234f, 41.99686f, 14.36163f, 45.003426f, 10.028042f, 48.0f);
                h.lineTo(10.028042f, 39.010273f);
                h.cubicTo(7.152297f, 38.59075f, 2.8187084f, 40.328766f, 1.2011017f, 37.05251f);
                h.cubicTo(0.83164823f, 26.36472f, 1.1312051f, 15.646965f, 1.0513232f, 4.9491887f);
                h.lineTo(1.0513232f, 4.9491887f);
                h.close();
                h.moveTo(7.0f, 7.0f);
                h.lineTo(7.0f, 33.0f);
                h.lineTo(15.0f, 33.0f);
                h.lineTo(15.0f, 38.0f);
                h.cubicTo(17.34f, 36.33f, 19.68f, 34.66f, 22.02f, 32.99f);
                h.cubicTo(31.01f, 33.01f, 40.01f, 33.0f, 49.0f, 33.0f);
                h.lineTo(49.0f, 7.0f);
                h.lineTo(7.0f, 7.0f);
                h.lineTo(7.0f, 7.0f);
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
