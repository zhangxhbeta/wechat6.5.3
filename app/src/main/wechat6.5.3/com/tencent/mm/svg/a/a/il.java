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

public final class il extends c {
    private final int height = 240;
    private final int width = 240;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                Path h = c.h(looper);
                h.moveTo(114.11689f, 70.98039f);
                h.cubicTo(111.951485f, 70.98039f, 110.27686f, 72.72528f, 110.37761f, 74.90139f);
                h.lineTo(113.37151f, 139.56976f);
                h.cubicTo(113.42262f, 140.6737f, 114.36253f, 141.56863f, 115.46362f, 141.56863f);
                h.lineTo(124.53638f, 141.56863f);
                h.cubicTo(125.64071f, 141.56863f, 126.57727f, 140.67613f, 126.62849f, 139.56976f);
                h.lineTo(129.62239f, 74.90139f);
                h.cubicTo(129.72266f, 72.73588f, 128.0466f, 70.98039f, 125.88311f, 70.98039f);
                h.lineTo(114.11689f, 70.98039f);
                h.close();
                h.moveTo(120.0f, 172.94118f);
                h.cubicTo(125.41456f, 172.94118f, 129.80392f, 168.5518f, 129.80392f, 163.13725f);
                h.cubicTo(129.80392f, 157.7227f, 125.41456f, 153.33333f, 120.0f, 153.33333f);
                h.cubicTo(114.58544f, 153.33333f, 110.196075f, 157.7227f, 110.196075f, 163.13725f);
                h.cubicTo(110.196075f, 168.5518f, 114.58544f, 172.94118f, 120.0f, 172.94118f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 75.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-16139513);
                h = c.h(looper);
                h.moveTo(88.503105f, 63.260868f);
                h.cubicTo(81.83925f, 55.480328f, 72.46273f, 51.086956f, 62.509315f, 51.086956f);
                h.cubicTo(51.689445f, 51.086956f, 42.312923f, 55.480328f, 35.649067f, 63.260868f);
                h.lineTo(42.580746f, 70.21739f);
                h.cubicTo(47.99571f, 65.064156f, 54.781292f, 61.847816f, 62.509315f, 62.391304f);
                h.cubicTo(69.71429f, 61.847816f, 76.405556f, 64.96478f, 81.57143f, 70.21739f);
                h.lineTo(88.503105f, 63.260868f);
                h.close();
                h.moveTo(61.642857f, 25.869566f);
                h.cubicTo(44.52152f, 25.869566f, 28.799698f, 32.994526f, 17.453417f, 45.0f);
                h.lineTo(25.251553f, 52.826088f);
                h.cubicTo(35.159626f, 43.23779f, 48.249474f, 37.29962f, 62.509315f, 37.173912f);
                h.cubicTo(76.95079f, 37.29962f, 89.85206f, 43.048466f, 98.90062f, 51.95652f);
                h.lineTo(106.69876f, 45.0f);
                h.cubicTo(95.32615f, 33.14707f, 79.4547f, 25.869566f, 61.642857f, 25.869566f);
                h.close();
                h.moveTo(124.02795f, 26.73913f);
                h.cubicTo(108.21251f, 10.5176935f, 86.30065f, 0.65217394f, 62.509315f, 0.65217394f);
                h.cubicTo(37.861656f, 0.65217394f, 15.941242f, 10.526303f, 0.124223605f, 26.73913f);
                h.lineTo(7.9223604f, 34.565216f);
                h.cubicTo(22.125067f, 20.522926f, 41.417408f, 11.826344f, 62.509315f, 11.956522f);
                h.cubicTo(83.71855f, 11.826344f, 102.73295f, 20.24566f, 116.22981f, 33.695652f);
                h.lineTo(124.02795f, 26.73913f);
                h.close();
                h.moveTo(71.17391f, 80.652176f);
                h.cubicTo(68.97959f, 77.84855f, 65.76467f, 76.304344f, 62.509315f, 76.304344f);
                h.cubicTo(58.48254f, 76.304344f, 55.174686f, 77.95143f, 52.97826f, 80.652176f);
                h.lineTo(61.642857f, 89.347824f);
                h.lineTo(71.17391f, 80.652176f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.save();
                float[] a2 = c.a(c, 1.0f, 0.0f, 0.095238f, 0.0f, 1.0f, 0.652174f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
