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

public final class uw extends c {
    private final int height = 84;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                a.setColor(-12206054);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 8.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(31.552f, 0.089f);
                h.cubicTo(36.477f, -0.264f, 41.481f, 0.453f, 46.096f, 2.217f);
                h.cubicTo(52.452f, 4.625f, 58.037f, 9.004f, 61.913f, 14.586f);
                h.cubicTo(63.992f, 17.566f, 65.588f, 20.883f, 66.615f, 24.369f);
                h.cubicTo(68.773f, 31.659f, 68.4f, 39.674f, 65.539f, 46.72f);
                h.cubicTo(63.273f, 52.354f, 59.455f, 57.347f, 54.627f, 61.029f);
                h.cubicTo(49.385f, 65.052f, 42.943f, 67.485f, 36.348f, 67.918f);
                h.cubicTo(31.984f, 68.218f, 27.561f, 67.681f, 23.404f, 66.314f);
                h.cubicTo(17.003f, 64.229f, 11.27f, 60.173f, 7.147f, 54.854f);
                h.cubicTo(4.738f, 51.759f, 2.868f, 48.244f, 1.658f, 44.512f);
                h.cubicTo(0.025f, 39.504f, -0.4f, 34.114f, 0.381f, 28.907f);
                h.cubicTo(1.448f, 21.662f, 4.972f, 14.819f, 10.213f, 9.709f);
                h.cubicTo(15.02f, 4.983f, 21.263f, 1.734f, 27.902f, 0.548f);
                h.cubicTo(29.109f, 0.329f, 30.328f, 0.176f, 31.552f, 0.089f);
                h.lineTo(31.552f, 0.089f);
                h.close();
                h.moveTo(30.439f, 26.843f);
                h.cubicTo(28.893f, 27.609f, 27.609f, 28.891f, 26.842f, 30.437f);
                h.cubicTo(23.199f, 37.657f, 19.553f, 44.875f, 15.911f, 52.096f);
                h.cubicTo(23.174f, 48.431f, 30.436f, 44.765f, 37.699f, 41.1f);
                h.cubicTo(39.147f, 40.347f, 40.354f, 39.139f, 41.103f, 37.688f);
                h.cubicTo(44.772f, 30.427f, 48.437f, 23.165f, 52.104f, 15.904f);
                h.cubicTo(44.882f, 19.55f, 37.66f, 23.195f, 30.439f, 26.843f);
                h.lineTo(30.439f, 26.843f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(33.346f, 31.079f);
                h.cubicTo(34.928f, 30.679f, 36.668f, 31.815f, 36.943f, 33.421f);
                h.cubicTo(37.306f, 35.014f, 36.122f, 36.729f, 34.507f, 36.961f);
                h.cubicTo(32.928f, 37.277f, 31.267f, 36.087f, 31.044f, 34.497f);
                h.cubicTo(30.753f, 32.98f, 31.835f, 31.384f, 33.346f, 31.079f);
                h.lineTo(33.346f, 31.079f);
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
