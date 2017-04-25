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

public final class hq extends c {
    private final int height = 162;
    private final int width = 162;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 162;
            case 1:
                return 162;
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
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 80.0f);
                h.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                h.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                h.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                h.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-11711155);
                h = c.h(looper);
                h.moveTo(63.284435f, 77.0f);
                h.lineTo(89.0f, 104.0f);
                h.lineTo(58.0f, 104.0f);
                h.cubicTo(60.590897f, 100.16911f, 63.478912f, 93.10176f, 62.938694f, 80.91711f);
                h.cubicTo(63.001358f, 79.552414f, 63.116966f, 78.244446f, 63.284435f, 77.0f);
                h.moveTo(60.032513f, 81.31762f);
                h.cubicTo(60.91131f, 99.65149f, 53.0f, 104.66564f, 53.0f, 104.66564f);
                h.lineTo(53.0f, 107.0f);
                h.lineTo(97.0f, 107.0f);
                h.lineTo(61.79871f, 71.0f);
                h.cubicTo(60.848923f, 73.81619f, 60.213223f, 77.21763f, 60.032513f, 81.31762f);
                h.close();
                h.moveTo(84.02051f, 58.95267f);
                h.lineTo(84.02051f, 57.067513f);
                h.cubicTo(84.02051f, 54.063652f, 81.875374f, 52.031452f, 78.88457f, 52.031452f);
                h.cubicTo(75.90136f, 52.031452f, 74.00952f, 54.103878f, 74.00952f, 57.096867f);
                h.lineTo(74.00952f, 58.95267f);
                h.cubicTo(71.48619f, 59.716953f, 68.18386f, 61.1031f, 65.88232f, 63.578594f);
                h.lineTo(53.30372f, 51.0f);
                h.lineTo(51.0f, 53.30372f);
                h.lineTo(108.69628f, 111.0f);
                h.lineTo(111.0f, 108.69628f);
                h.lineTo(100.0663f, 97.76258f);
                h.cubicTo(98.537735f, 94.18687f, 97.3201f, 88.87494f, 97.69735f, 81.20276f);
                h.cubicTo(97.02982f, 66.39329f, 90.03693f, 60.812824f, 84.02051f, 58.95267f);
                h.close();
                h.moveTo(68.19256f, 66.0466f);
                h.lineTo(68.270584f, 65.963394f);
                h.cubicTo(69.93996f, 64.19877f, 71.999466f, 62.94311f, 74.38978f, 62.230995f);
                h.lineTo(76.99048f, 61.549137f);
                h.lineTo(76.99048f, 59.14372f);
                h.lineTo(76.99048f, 57.299133f);
                h.cubicTo(76.99048f, 56.115875f, 77.7955f, 54.989075f, 78.99451f, 54.989075f);
                h.cubicTo(80.19461f, 54.989075f, 81.000916f, 56.115875f, 81.000916f, 57.299133f);
                h.lineTo(81.000916f, 59.15777f);
                h.lineTo(81.000916f, 61.549137f);
                h.lineTo(83.40482f, 62.25477f);
                h.cubicTo(86.330345f, 63.144104f, 88.738235f, 64.84173f, 90.56147f, 67.300095f);
                h.cubicTo(93.02761f, 70.62295f, 94.42553f, 75.32356f, 94.71676f, 81.27227f);
                h.cubicTo(94.51565f, 85.521194f, 94.77281f, 89.40163f, 95.48276f, 92.88008f);
                h.lineTo(68.19256f, 66.0466f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
