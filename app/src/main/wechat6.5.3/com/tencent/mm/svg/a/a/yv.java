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

public final class yv extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                c = c.a(c, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 5.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.9f, 0.0f);
                h.lineTo(34.1f, 0.0f);
                h.cubicTo(33.86f, 7.5f, 29.44f, 14.06f, 24.1f, 19.0f);
                h.cubicTo(29.21f, 23.71f, 33.38f, 29.87f, 34.09f, 36.94f);
                h.cubicTo(23.03f, 37.05f, 11.96f, 37.01f, 0.9f, 36.97f);
                h.cubicTo(1.62f, 29.89f, 5.78f, 23.72f, 10.9f, 19.01f);
                h.cubicTo(5.57f, 14.06f, 1.14f, 7.5f, 0.9f, 0.0f);
                h.lineTo(0.9f, 0.0f);
                h.close();
                h.moveTo(8.27f, 6.01f);
                h.cubicTo(10.16f, 10.93f, 16.03f, 13.56f, 16.48f, 19.02f);
                h.cubicTo(16.19f, 24.12f, 10.8f, 26.53f, 8.87f, 30.95f);
                h.cubicTo(14.62f, 31.03f, 20.37f, 31.03f, 26.12f, 30.94f);
                h.cubicTo(24.2f, 26.52f, 18.8f, 24.11f, 18.52f, 19.01f);
                h.cubicTo(18.99f, 13.55f, 24.84f, 10.93f, 26.73f, 6.01f);
                h.cubicTo(20.58f, 6.0f, 14.42f, 6.0f, 8.27f, 6.01f);
                h.lineTo(8.27f, 6.01f);
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
