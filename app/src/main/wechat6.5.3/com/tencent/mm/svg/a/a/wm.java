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

public final class wm extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c = c.a(c, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 19.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(25.0f, -3.5527137E-15f);
                h.cubicTo(29.05f, -0.06741956f, 32.98f, -0.06741956f, 37.0f, -3.5527137E-15f);
                h.cubicTo(37.12f, 0.4619488f, 37.61f, 0.9813291f, 38.0f, 1.0f);
                h.cubicTo(38.2f, 9.481187f, 37.9f, 17.761307f, 38.0f, 26.0f);
                h.cubicTo(41.67f, 26.021452f, 45.33f, 26.021452f, 49.0f, 26.0f);
                h.cubicTo(43.0f, 32.0143f, 37.0f, 38.00715f, 31.0f, 44.0f);
                h.cubicTo(25.0f, 38.00715f, 19.0f, 32.0143f, 13.0f, 26.0f);
                h.cubicTo(16.67f, 26.021452f, 20.33f, 26.021452f, 24.0f, 26.0f);
                h.cubicTo(24.11f, 17.75132f, 23.79f, 9.471199f, 24.0f, 1.0f);
                h.cubicTo(24.4f, 0.9513649f, 24.91f, 0.45196074f, 25.0f, -3.5527137E-15f);
                h.lineTo(25.0f, -3.5527137E-15f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(-3.5527137E-15f, 41.0f);
                h.lineTo(7.0f, 41.0f);
                h.cubicTo(7.0139327f, 44.66097f, 7.0139327f, 48.31196f, 7.0f, 52.0f);
                h.cubicTo(23.004644f, 51.972927f, 38.995358f, 51.972927f, 55.0f, 52.0f);
                h.cubicTo(54.98607f, 48.31196f, 54.98607f, 44.66097f, 55.0f, 41.0f);
                h.lineTo(62.0f, 41.0f);
                h.cubicTo(61.92204f, 46.01762f, 62.091938f, 51.045216f, 62.0f, 56.0f);
                h.cubicTo(62.00199f, 58.067886f, 59.863235f, 59.27491f, 58.0f, 59.0f);
                h.cubicTo(40.00477f, 58.96567f, 21.965248f, 58.955696f, 4.0f, 59.0f);
                h.cubicTo(2.1467597f, 59.244984f, -0.03197474f, 58.097813f, -3.5527137E-15f, 56.0f);
                h.cubicTo(-0.091939904f, 51.065166f, 0.0779614f, 46.027596f, -3.5527137E-15f, 41.0f);
                h.lineTo(-3.5527137E-15f, 41.0f);
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
