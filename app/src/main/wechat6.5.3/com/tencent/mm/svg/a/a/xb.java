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

public final class xb extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 46.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(22.687244f, 25.113926f);
                h.lineTo(22.687244f, 17.929688f);
                h.cubicTo(22.687244f, 8.027395f, 30.660164f, 0.0f, 40.500088f, 0.0f);
                h.cubicTo(50.33785f, 0.0f, 58.31293f, 8.029507f, 58.31293f, 17.929688f);
                h.lineTo(58.31293f, 25.113926f);
                h.cubicTo(58.31293f, 30.056797f, 55.683815f, 37.087967f, 52.44355f, 40.815125f);
                h.lineTo(50.540165f, 43.004528f);
                h.cubicTo(47.94651f, 45.987915f, 48.729496f, 49.78213f, 52.28948f, 51.47937f);
                h.lineTo(74.85725f, 62.23866f);
                h.cubicTo(77.52539f, 63.510708f, 80.02758f, 66.93197f, 80.44377f, 69.86416f);
                h.lineTo(80.96394f, 73.529015f);
                h.cubicTo(81.243225f, 75.49664f, 79.869606f, 77.09172f, 77.89612f, 76.99588f);
                h.lineTo(3.1040568f, 76.99588f);
                h.cubicTo(1.1304631f, 77.09172f, -0.24384984f, 75.50228f, 0.036229156f, 73.529015f);
                h.lineTo(0.55640864f, 69.86416f);
                h.cubicTo(0.97361827f, 66.92476f, 3.480438f, 63.507545f, 6.1249685f, 62.246185f);
                h.lineTo(28.7107f, 51.473454f);
                h.cubicTo(32.27047f, 49.775547f, 33.05514f, 45.98354f, 30.460012f, 42.999973f);
                h.lineTo(28.556623f, 40.811687f);
                h.cubicTo(25.315056f, 37.084923f, 22.687244f, 30.056068f, 22.687244f, 25.113926f);
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
