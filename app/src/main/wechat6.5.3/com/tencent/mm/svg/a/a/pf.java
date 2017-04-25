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

public final class pf extends c {
    private final int height = 13;
    private final int width = 22;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 22;
            case 1:
                return 13;
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
                c = c.a(c, 1.0f, 0.0f, -1097.0f, 0.0f, 1.0f, -2690.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 988.0f, 0.0f, 1.0f, 2659.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, 0.70710677f, 0.70710677f, 11.626389f, -0.70710677f, 0.70710677f, 94.94632f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(115.736046f, 38.224194f);
                h.lineTo(115.736046f, 35.24749f);
                h.lineTo(115.736046f, 27.069532f);
                h.cubicTo(115.736046f, 26.204807f, 115.03649f, 25.504086f, 114.173546f, 25.504086f);
                h.cubicTo(113.30458f, 25.504086f, 112.611046f, 26.20479f, 112.611046f, 27.069153f);
                h.lineTo(112.611046f, 39.180725f);
                h.cubicTo(112.53231f, 39.367065f, 112.48876f, 39.571815f, 112.48876f, 39.786694f);
                h.cubicTo(112.48876f, 40.57306f, 113.06137f, 41.215767f, 113.80943f, 41.33084f);
                h.cubicTo(113.92626f, 41.358826f, 114.04818f, 41.37365f, 114.173546f, 41.37365f);
                h.cubicTo(114.268715f, 41.37365f, 114.36178f, 41.365265f, 114.45206f, 41.349194f);
                h.lineTo(118.61492f, 41.349194f);
                h.lineTo(126.79288f, 41.349194f);
                h.cubicTo(127.65761f, 41.349194f, 128.35832f, 40.64964f, 128.35832f, 39.786694f);
                h.cubicTo(128.35832f, 38.917732f, 127.65762f, 38.224194f, 126.79326f, 38.224194f);
                h.lineTo(115.736046f, 38.224194f);
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
