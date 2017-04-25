package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class vc extends c {
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
                c.d(looper);
                c.c(looper);
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
                g = c.a(g, looper);
                g.setColor(-16896);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(5.2080674f, 81.84925f);
                h.cubicTo(3.9541583f, 83.99987f, 4.9507284f, 85.7433f, 7.4474754f, 85.7433f);
                h.lineTo(88.74638f, 85.7433f);
                h.cubicTo(91.23708f, 85.7433f, 92.23893f, 83.99854f, 90.985794f, 81.84925f);
                h.lineTo(50.367332f, 12.183118f);
                h.cubicTo(49.113426f, 10.032495f, 47.07966f, 10.033827f, 45.826527f, 12.183118f);
                h.lineTo(5.2080674f, 81.84925f);
                h.close();
                h.moveTo(45.896564f, 36.946117f);
                h.cubicTo(45.070587f, 36.946117f, 44.432064f, 37.61737f, 44.470753f, 38.453403f);
                h.lineTo(45.63274f, 63.56276f);
                h.lineTo(50.5597f, 63.56276f);
                h.lineTo(51.721687f, 38.453403f);
                h.cubicTo(51.760212f, 37.620953f, 51.122555f, 36.946117f, 50.295876f, 36.946117f);
                h.lineTo(45.896564f, 36.946117f);
                h.close();
                h.moveTo(48.096222f, 75.39238f);
                h.cubicTo(50.137035f, 75.39238f, 51.791443f, 73.73729f, 51.791443f, 71.695625f);
                h.cubicTo(51.791443f, 69.65396f, 50.137035f, 67.99887f, 48.096222f, 67.99887f);
                h.cubicTo(46.055405f, 67.99887f, 44.401f, 69.65396f, 44.401f, 71.695625f);
                h.cubicTo(44.401f, 73.73729f, 46.055405f, 75.39238f, 48.096222f, 75.39238f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
