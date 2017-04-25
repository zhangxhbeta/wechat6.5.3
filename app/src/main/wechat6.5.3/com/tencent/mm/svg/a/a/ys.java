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

public final class ys extends c {
    private final int height = 74;
    private final int width = 165;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 165;
            case 1:
                return 74;
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
                a.setColor(-7683054);
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(87.71f, 1.02f);
                h.cubicTo(97.18f, 0.98f, 106.65f, 1.01f, 116.11f, 1.0f);
                h.cubicTo(122.86f, 0.94f, 129.37f, 4.23f, 133.81f, 9.23f);
                h.cubicTo(138.87f, 14.77f, 141.51f, 22.18f, 142.0f, 29.61f);
                h.lineTo(142.0f, 36.95f);
                h.cubicTo(141.63f, 45.0f, 138.59f, 53.09f, 132.81f, 58.82f);
                h.cubicTo(128.22f, 63.52f, 121.67f, 66.29f, 115.07f, 66.0f);
                h.cubicTo(76.95f, 65.86f, 38.82f, 66.27f, 0.7f, 65.79f);
                h.cubicTo(14.4f, 65.13f, 27.91f, 61.47f, 40.08f, 55.19f);
                h.cubicTo(62.05f, 44.0f, 79.39f, 24.21f, 87.71f, 1.02f);
                h.lineTo(87.71f, 1.02f);
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
