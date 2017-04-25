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

public final class rl extends c {
    private final int height = 210;
    private final int width = 210;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                a.setColor(-3026479);
                c = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 48.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(29.022663f, 6.881502f);
                h.cubicTo(28.962679f, 3.3246841f, 32.48179f, 0.6071154f, 35.910923f, 1.046722f);
                h.lineTo(171.01677f, 1.046722f);
                h.cubicTo(174.47589f, 0.6071154f, 178.005f, 3.3646483f, 177.90503f, 6.941448f);
                h.cubicTo(177.99501f, 40.29161f, 177.92502f, 73.651764f, 177.94502f, 107.01192f);
                h.cubicTo(178.48488f, 110.91843f, 174.96577f, 114.48524f, 171.04677f, 113.94572f);
                h.lineTo(35.900925f, 113.94572f);
                h.cubicTo(32.4418f, 114.38532f, 28.92269f, 111.60781f, 29.012667f, 108.041f);
                h.cubicTo(28.932686f, 97.59035f, 29.002668f, 87.14969f, 28.992672f, 76.69904f);
                h.cubicTo(19.335112f, 70.45463f, 9.657558f, 64.24019f, 0.0f, 57.995773f);
                h.cubicTo(9.647561f, 51.16189f, 19.265131f, 44.288036f, 28.95268f, 37.504105f);
                h.cubicTo(29.062653f, 27.293242f, 28.902695f, 17.092367f, 29.022663f, 6.881502f);
                h.lineTo(29.022663f, 6.881502f);
                h.close();
                h.moveTo(63.374653f, 45.406013f);
                h.cubicTo(56.590252f, 46.86757f, 51.75968f, 54.195107f, 53.28151f, 61.058495f);
                h.cubicTo(54.43024f, 67.90214f, 61.469917f, 72.93858f, 68.27395f, 71.85229f);
                h.cubicTo(75.66708f, 71.09189f, 81.342026f, 63.319958f, 79.722015f, 55.992424f);
                h.cubicTo(78.51437f, 48.635265f, 70.53214f, 43.480316f, 63.374653f, 45.406013f);
                h.lineTo(63.374653f, 45.406013f);
                h.close();
                h.moveTo(100.24062f, 45.43193f);
                h.cubicTo(93.876f, 46.893433f, 89.20076f, 53.509697f, 90.1142f, 60.046963f);
                h.cubicTo(90.76244f, 67.24585f, 97.94228f, 72.914116f, 105.063194f, 71.877235f);
                h.cubicTo(112.50823f, 71.22549f, 118.313f, 63.473595f, 116.741486f, 56.08708f);
                h.cubicTo(115.5825f, 48.64131f, 107.459755f, 43.427303f, 100.24062f, 45.43193f);
                h.lineTo(100.24062f, 45.43193f);
                h.close();
                h.moveTo(136.14615f, 45.755013f);
                h.cubicTo(129.64459f, 47.81871f, 125.55901f, 55.32308f, 127.47412f, 61.938766f);
                h.cubicTo(129.1437f, 68.89018f, 136.88274f, 73.471794f, 143.74768f, 71.56608f);
                h.cubicTo(150.77959f, 70.01583f, 155.54282f, 62.146126f, 153.5393f, 55.155216f);
                h.cubicTo(151.84026f, 47.73972f, 143.23698f, 43.09886f, 136.14615f, 45.755013f);
                h.lineTo(136.14615f, 45.755013f);
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
