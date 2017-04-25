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

public final class xo extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c = c.a(c, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-5592406);
                Path h = c.h(looper);
                h.moveTo(3.8078494f, 11.822346f);
                h.cubicTo(8.404776f, 4.3013563f, 17.218054f, -0.42926627f, 26.051363f, 0.030794242f);
                h.cubicTo(35.185123f, 0.3208324f, 43.81813f, 6.141598f, 47.61385f, 14.432689f);
                h.cubicTo(51.018982f, 21.393604f, 50.488182f, 29.64469f, 47.854214f, 36.76563f);
                h.cubicTo(43.167152f, 49.54731f, 34.35387f, 60.318726f, 24.989763f, 70.0f);
                h.cubicTo(15.275126f, 59.908672f, 6.0412145f, 48.637188f, 1.6045299f, 35.145412f);
                h.cubicTo(-0.95933306f, 27.51441f, -0.60880494f, 18.713253f, 3.8078494f, 11.822346f);
                h.lineTo(3.8078494f, 11.822346f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(25.084106f, 24.087467f);
                h2.lineTo(16.49832f, 15.50168f);
                h2.lineTo(13.669893f, 18.330107f);
                h2.lineTo(22.25568f, 26.915894f);
                h2.lineTo(13.669893f, 35.50168f);
                h2.lineTo(16.49832f, 38.33011f);
                h2.lineTo(25.084106f, 29.74432f);
                h2.lineTo(33.66989f, 38.33011f);
                h2.lineTo(36.49832f, 35.50168f);
                h2.lineTo(27.912533f, 26.915894f);
                h2.lineTo(36.49832f, 18.330107f);
                h2.lineTo(33.66989f, 15.50168f);
                h2.lineTo(25.084106f, 24.087467f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
