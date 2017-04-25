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

public final class in extends c {
    private final int height = 67;
    private final int width = 84;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 67;
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
                a.setColor(-9538696);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(50.83f, 1.1693f);
                h.cubicTo(50.65f, 0.9883f, 50.452f, 0.8253f, 50.239f, 0.6813f);
                h.cubicTo(49.814f, 0.3943f, 49.331f, 0.1873f, 48.811f, 0.0813f);
                h.cubicTo(48.551f, 0.0283f, 48.282f, 3.0E-4f, 48.006f, 3.0E-4f);
                h.lineTo(3.994f, 3.0E-4f);
                h.cubicTo(3.443f, 3.0E-4f, 2.918f, 0.1123f, 2.44f, 0.3143f);
                h.cubicTo(1.007f, 0.9213f, 0.0f, 2.3433f, 0.0f, 4.0003f);
                h.lineTo(0.0f, 58.9993f);
                h.cubicTo(0.0f, 61.2163f, 1.788f, 63.0003f, 3.994f, 63.0003f);
                h.lineTo(48.006f, 63.0003f);
                h.cubicTo(50.21f, 63.0003f, 52.0f, 61.2093f, 52.0f, 58.9993f);
                h.lineTo(52.0f, 4.0003f);
                h.cubicTo(52.0f, 2.8923f, 51.553f, 1.8923f, 50.83f, 1.1693f);
                h.close();
                h.moveTo(49.0f, 58.9993f);
                h.cubicTo(49.0f, 59.5513f, 48.554f, 60.0003f, 48.006f, 60.0003f);
                h.lineTo(3.994f, 60.0003f);
                h.cubicTo(3.446f, 60.0003f, 3.0f, 59.5513f, 3.0f, 58.9993f);
                h.lineTo(3.0f, 4.0003f);
                h.cubicTo(3.0f, 3.5093f, 3.329f, 3.1963f, 3.611f, 3.0763f);
                h.cubicTo(3.731f, 3.0253f, 3.86f, 3.0003f, 3.994f, 3.0003f);
                h.lineTo(48.006f, 3.0003f);
                h.cubicTo(48.076f, 3.0003f, 48.145f, 3.0073f, 48.211f, 3.0203f);
                h.cubicTo(48.336f, 3.0463f, 48.453f, 3.0953f, 48.56f, 3.1673f);
                h.cubicTo(48.613f, 3.2033f, 48.663f, 3.2443f, 48.708f, 3.2903f);
                h.cubicTo(48.841f, 3.4233f, 49.0f, 3.6543f, 49.0f, 4.0003f);
                h.lineTo(49.0f, 58.9993f);
                h.close();
                h.moveTo(6.0f, 52.0f);
                h.lineTo(46.0f, 52.0f);
                h.lineTo(46.0f, 10.0f);
                h.lineTo(6.0f, 10.0f);
                h.lineTo(6.0f, 52.0f);
                h.close();
                h.moveTo(9.0f, 49.0f);
                h.lineTo(43.0f, 49.0f);
                h.lineTo(43.0f, 13.0f);
                h.lineTo(9.0f, 13.0f);
                h.lineTo(9.0f, 49.0f);
                h.close();
                h.moveTo(26.0f, 54.0f);
                h.cubicTo(24.895f, 54.0f, 24.0f, 54.895f, 24.0f, 56.0f);
                h.cubicTo(24.0f, 57.105f, 24.895f, 58.0f, 26.0f, 58.0f);
                h.cubicTo(27.105f, 58.0f, 28.0f, 57.105f, 28.0f, 56.0f);
                h.cubicTo(28.0f, 54.895f, 27.105f, 54.0f, 26.0f, 54.0f);
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
