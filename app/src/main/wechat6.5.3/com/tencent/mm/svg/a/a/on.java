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

public final class on extends c {
    private final int height = 36;
    private final int width = 40;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 36;
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
                a.setColor(-11048043);
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.95f, 1.02f);
                h.cubicTo(12.96f, 0.94f, 22.98f, 1.06f, 32.99f, 0.97f);
                h.cubicTo(34.31f, 1.13f, 36.14f, 0.52f, 36.9f, 2.0f);
                h.cubicTo(37.18f, 8.98f, 36.88f, 15.98f, 37.03f, 22.97f);
                h.cubicTo(36.86f, 24.28f, 37.48f, 26.12f, 36.02f, 26.9f);
                h.cubicTo(28.94f, 27.17f, 21.85f, 26.9f, 14.76f, 27.0f);
                h.cubicTo(12.19f, 28.76f, 9.6f, 30.48f, 7.0f, 32.2f);
                h.cubicTo(7.0f, 30.47f, 6.99f, 28.75f, 7.0f, 27.02f);
                h.cubicTo(5.09f, 26.72f, 2.45f, 27.83f, 1.1f, 26.03f);
                h.cubicTo(0.84f, 18.67f, 1.09f, 11.3f, 0.98f, 3.93f);
                h.cubicTo(0.79f, 2.67f, 1.23f, 0.69f, 2.95f, 1.02f);
                h.close();
                h.moveTo(5.0f, 5.0f);
                h.lineTo(5.0f, 23.0f);
                h.lineTo(9.99f, 23.0f);
                h.cubicTo(9.99f, 23.67f, 10.0f, 25.03f, 10.0f, 25.7f);
                h.cubicTo(10.93f, 24.8f, 11.84f, 23.9f, 12.75f, 22.99f);
                h.cubicTo(19.5f, 23.01f, 26.25f, 23.0f, 33.0f, 23.0f);
                h.lineTo(33.0f, 5.0f);
                h.lineTo(5.0f, 5.0f);
                h.lineTo(5.0f, 5.0f);
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
