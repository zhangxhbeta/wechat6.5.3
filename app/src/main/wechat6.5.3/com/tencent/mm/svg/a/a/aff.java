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

public final class aff extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                c = c.a(c, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 31.994999f);
                h.cubicTo(10.501568f, 21.323332f, 21.023138f, 10.661666f, 31.534706f, 0.0f);
                h.cubicTo(33.36498f, 1.830286f, 35.185253f, 3.6805751f, 36.99552f, 5.5308642f);
                h.cubicTo(29.674429f, 13.022035f, 22.323332f, 20.493202f, 15.002239f, 27.994373f);
                h.lineTo(67.0f, 27.994373f);
                h.lineTo(67.0f, 35.995625f);
                h.cubicTo(49.66741f, 35.995625f, 32.334827f, 35.985622f, 15.002239f, 36.005627f);
                h.cubicTo(22.333334f, 43.486794f, 29.664427f, 50.967964f, 37.005524f, 58.44913f);
                h.cubicTo(35.185253f, 60.299423f, 33.36498f, 62.14971f, 31.534706f, 64.0f);
                h.cubicTo(21.023138f, 53.32833f, 10.501568f, 42.666668f, 0.0f, 31.994999f);
                h.lineTo(0.0f, 31.994999f);
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
