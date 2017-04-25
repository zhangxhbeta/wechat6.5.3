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

public final class ads extends c {
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
                a.setColor(-289488);
                c = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(3.0f, 1.0f);
                h.cubicTo(4.828907f, -0.06993529f, 6.447556f, 0.06993529f, 8.0f, 0.0f);
                h.cubicTo(27.350111f, 0.07992605f, 46.733932f, -0.05994454f, 66.0f, 0.0f);
                h.cubicTo(69.624825f, -0.009990756f, 72.352554f, 3.4168386f, 72.0f, 7.0f);
                h.cubicTo(71.9329f, 26.575413f, 72.032814f, 46.34712f, 72.0f, 66.0f);
                h.cubicTo(71.97287f, 69.22595f, 69.165215f, 72.00338f, 66.0f, 72.0f);
                h.cubicTo(46.344257f, 72.013374f, 26.640703f, 71.923454f, 7.0f, 72.0f);
                h.cubicTo(3.500016f, 72.39302f, -0.0070568826f, 69.66554f, 0.0f, 66.0f);
                h.cubicTo(-0.027040204f, 46.35711f, 0.052893084f, 26.615376f, 0.0f, 7.0f);
                h.cubicTo(-0.18690678f, 4.35597f, 1.0520592f, 1.6984286f, 3.0f, 1.0f);
                h.lineTo(3.0f, 1.0f);
                h.close();
                h.moveTo(32.0f, 18.0f);
                h.cubicTo(26.9957f, 19.467379f, 26.498104f, 26.318546f, 28.0f, 31.0f);
                h.cubicTo(28.777092f, 34.038593f, 31.742762f, 35.916172f, 32.0f, 39.0f);
                h.cubicTo(32.14084f, 42.55761f, 27.821709f, 43.39653f, 25.0f, 45.0f);
                h.cubicTo(22.447676f, 47.121727f, 17.581192f, 48.659744f, 18.0f, 53.0f);
                h.cubicTo(17.700615f, 54.662006f, 19.641237f, 55.151375f, 21.0f, 55.0f);
                h.cubicTo(31.563627f, 54.871735f, 42.23208f, 55.111427f, 53.0f, 55.0f);
                h.cubicTo(54.68192f, 53.613358f, 54.094757f, 50.497375f, 53.0f, 49.0f);
                h.cubicTo(48.99938f, 45.943245f, 44.23241f, 44.385254f, 40.0f, 41.0f);
                h.cubicTo(38.012466f, 39.052128f, 40.799004f, 36.225773f, 42.0f, 34.0f);
                h.cubicTo(44.859383f, 31.042456f, 45.058422f, 26.54825f, 44.0f, 23.0f);
                h.cubicTo(42.839146f, 17.809515f, 36.798332f, 15.862026f, 32.0f, 18.0f);
                h.lineTo(32.0f, 18.0f);
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
