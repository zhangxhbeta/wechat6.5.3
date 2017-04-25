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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class ht extends c {
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
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(0.0f, 80.0f);
                h.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                h.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                h.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                h.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-16139513);
                h = c.h(looper);
                h.moveTo(62.284435f, 76.0f);
                h.lineTo(88.0f, 103.0f);
                h.lineTo(57.0f, 103.0f);
                h.cubicTo(59.590897f, 99.16911f, 62.478912f, 92.10176f, 61.938694f, 79.91711f);
                h.cubicTo(62.001358f, 78.552414f, 62.116966f, 77.244446f, 62.284435f, 76.0f);
                h.moveTo(59.032513f, 80.31762f);
                h.cubicTo(59.91131f, 98.65149f, 52.0f, 103.66564f, 52.0f, 103.66564f);
                h.lineTo(52.0f, 106.0f);
                h.lineTo(96.0f, 106.0f);
                h.lineTo(60.79871f, 70.0f);
                h.cubicTo(59.848923f, 72.81619f, 59.213223f, 76.21763f, 59.032513f, 80.31762f);
                h.close();
                h.moveTo(83.02051f, 57.95267f);
                h.lineTo(83.02051f, 56.067513f);
                h.cubicTo(83.02051f, 53.063652f, 80.875374f, 51.031452f, 77.88457f, 51.031452f);
                h.cubicTo(74.90136f, 51.031452f, 73.00952f, 53.103878f, 73.00952f, 56.096867f);
                h.lineTo(73.00952f, 57.95267f);
                h.cubicTo(70.48619f, 58.716953f, 67.18386f, 60.1031f, 64.88232f, 62.578594f);
                h.lineTo(52.30372f, 50.0f);
                h.lineTo(50.0f, 52.30372f);
                h.lineTo(107.69628f, 110.0f);
                h.lineTo(110.0f, 107.69628f);
                h.lineTo(99.0663f, 96.76258f);
                h.cubicTo(97.537735f, 93.18687f, 96.3201f, 87.87494f, 96.69735f, 80.20276f);
                h.cubicTo(96.02982f, 65.39329f, 89.03693f, 59.812824f, 83.02051f, 57.95267f);
                h.close();
                h.moveTo(67.19256f, 65.0466f);
                h.lineTo(67.270584f, 64.963394f);
                h.cubicTo(68.93996f, 63.198772f, 70.999466f, 61.94311f, 73.38978f, 61.230995f);
                h.lineTo(75.99048f, 60.549137f);
                h.lineTo(75.99048f, 58.14372f);
                h.lineTo(75.99048f, 56.299133f);
                h.cubicTo(75.99048f, 55.115875f, 76.7955f, 53.989075f, 77.99451f, 53.989075f);
                h.cubicTo(79.19461f, 53.989075f, 80.000916f, 55.115875f, 80.000916f, 56.299133f);
                h.lineTo(80.000916f, 58.15777f);
                h.lineTo(80.000916f, 60.549137f);
                h.lineTo(82.40482f, 61.25477f);
                h.cubicTo(85.330345f, 62.144104f, 87.738235f, 63.84173f, 89.56147f, 66.300095f);
                h.cubicTo(92.02761f, 69.62295f, 93.42553f, 74.32356f, 93.71676f, 80.27227f);
                h.cubicTo(93.51565f, 84.521194f, 93.77281f, 88.40163f, 94.48276f, 91.88008f);
                h.lineTo(67.19256f, 65.0466f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
