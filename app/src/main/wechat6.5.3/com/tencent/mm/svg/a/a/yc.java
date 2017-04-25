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

public final class yc extends c {
    private final int height = 76;
    private final int width = 76;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(72.0f, 0.0f);
                h.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                h.lineTo(76.0f, 72.0f);
                h.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                h.lineTo(4.0f, 76.0f);
                h.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-5658199);
                float[] a2 = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(3.077093f, 0.40822864f);
                h.cubicTo(6.376807f, -1.1489923f, 10.591013f, 1.994287f, 9.93107f, 5.6854773f);
                h.cubicTo(9.553961f, 9.520855f, 4.528967f, 11.36645f, 1.7572072f, 8.838369f);
                h.cubicTo(-1.1371136f, 6.6563373f, -0.28861567f, 1.590563f, 3.077093f, 0.40822864f);
                h.lineTo(3.077093f, 0.40822864f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(23.623188f, 16.071012f);
                h.cubicTo(26.064592f, 14.068773f, 28.851942f, 12.245839f, 32.093967f, 12.086457f);
                h.cubicTo(38.943733f, 11.219816f, 45.90223f, 16.98746f, 45.93188f, 24.050083f);
                h.cubicTo(46.07026f, 31.361742f, 45.95165f, 38.6734f, 45.971416f, 45.985058f);
                h.cubicTo(42.976498f, 46.004982f, 39.971695f, 46.004982f, 36.976776f, 45.985058f);
                h.cubicTo(36.8977f, 39.330853f, 37.075615f, 32.676643f, 36.927353f, 26.022438f);
                h.cubicTo(37.085503f, 22.396492f, 33.73475f, 19.238733f, 30.196198f, 19.418037f);
                h.cubicTo(26.677414f, 19.28854f, 23.465042f, 22.436338f, 23.553999f, 25.992554f);
                h.cubicTo(23.326662f, 32.656723f, 23.563883f, 39.32089f, 23.455156f, 45.995018f);
                h.lineTo(16.04199f, 45.995018f);
                h.cubicTo(16.170485f, 35.127148f, 15.755347f, 24.249311f, 16.249557f, 13.391398f);
                h.cubicTo(18.52293f, 13.431244f, 20.7963f, 13.441206f, 23.079557f, 13.431244f);
                h.cubicTo(23.208052f, 14.088696f, 23.48481f, 15.403599f, 23.623188f, 16.071012f);
                h.lineTo(23.623188f, 16.071012f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(1.0f, 13.019893f);
                h.cubicTo(3.6736567f, 12.989608f, 6.336828f, 12.989608f, 9.0f, 13.050178f);
                h.cubicTo(8.968545f, 24.023357f, 9.010485f, 34.996536f, 8.979031f, 45.97981f);
                h.cubicTo(6.3263435f, 45.989906f, 3.6841416f, 46.0f, 1.0314548f, 46.0f);
                h.cubicTo(1.0f, 35.00663f, 1.0524247f, 24.013262f, 1.0f, 13.019893f);
                h.lineTo(1.0f, 13.019893f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
