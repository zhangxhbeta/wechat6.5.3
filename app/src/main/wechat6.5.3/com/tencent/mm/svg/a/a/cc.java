package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class cc extends c {
    private final int height = 57;
    private final int width = 45;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 57;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-11184811);
                a.setStrokeWidth(3.0f);
                c = c.a(c, 1.0f, 0.0f, -1450.0f, 0.0f, 1.0f, -602.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(1470.9163f, 655.8485f);
                h.cubicTo(1472.067f, 657.03674f, 1473.9164f, 657.02386f, 1475.0333f, 655.7881f);
                h.cubicTo(1475.0333f, 655.7881f, 1492.0f, 638.46387f, 1492.0f, 624.0f);
                h.cubicTo(1492.0f, 612.767f, 1483.2695f, 604.0f, 1473.0f, 604.0f);
                h.cubicTo(1461.7305f, 604.0f, 1453.0f, 612.767f, 1453.0f, 624.0f);
                h.cubicTo(1453.0f, 638.46387f, 1470.9163f, 655.8485f, 1470.9163f, 655.8485f);
                h.close();
                h.moveTo(1473.0f, 630.0f);
                h.cubicTo(1476.0898f, 630.0f, 1479.0f, 627.08984f, 1479.0f, 624.0f);
                h.cubicTo(1479.0f, 619.91016f, 1476.0898f, 617.0f, 1473.0f, 617.0f);
                h.cubicTo(1468.9102f, 617.0f, 1466.0f, 619.91016f, 1466.0f, 624.0f);
                h.cubicTo(1466.0f, 627.08984f, 1468.9102f, 630.0f, 1473.0f, 630.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
