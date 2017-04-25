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

public final class aci extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-3487030);
                c = c.a(c, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(20.01f, 18.99f);
                h.cubicTo(22.68f, 12.67f, 25.33f, 6.34f, 28.0f, 0.02f);
                h.cubicTo(30.67f, 6.34f, 33.33f, 12.67f, 36.0f, 18.99f);
                h.cubicTo(42.66f, 19.7f, 49.32f, 20.31f, 55.98f, 21.01f);
                h.cubicTo(51.33f, 26.03f, 46.64f, 31.0f, 42.0f, 36.02f);
                h.cubicTo(43.34f, 42.68f, 44.66f, 49.33f, 46.0f, 55.99f);
                h.cubicTo(39.98f, 52.68f, 34.01f, 49.31f, 27.99f, 46.01f);
                h.cubicTo(22.32f, 49.34f, 16.66f, 52.67f, 10.99f, 56.0f);
                h.cubicTo(12.34f, 49.34f, 13.66f, 42.68f, 15.0f, 36.02f);
                h.cubicTo(10.03f, 31.0f, 5.0f, 26.03f, 0.02f, 21.01f);
                h.cubicTo(6.68f, 20.31f, 13.35f, 19.7f, 20.01f, 18.99f);
                h.lineTo(20.01f, 18.99f);
                h.close();
                h.moveTo(14.0f, 22.0f);
                h.lineTo(14.0f, 24.0f);
                h.cubicTo(20.66f, 24.01f, 27.33f, 23.99f, 33.99f, 24.0f);
                h.cubicTo(28.01f, 29.34f, 22.0f, 34.65f, 16.02f, 40.0f);
                h.lineTo(40.0f, 40.0f);
                h.lineTo(40.0f, 38.0f);
                h.cubicTo(34.67f, 37.99f, 29.35f, 38.01f, 24.02f, 37.99f);
                h.cubicTo(30.0f, 32.65f, 36.01f, 27.34f, 42.0f, 22.0f);
                h.lineTo(14.0f, 22.0f);
                h.lineTo(14.0f, 22.0f);
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
