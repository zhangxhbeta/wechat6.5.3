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

public final class fu extends c {
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
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(20.001331f, 33.0f);
                h.cubicTo(17.239172f, 33.0f, 15.0f, 35.236286f, 15.0f, 38.00532f);
                h.lineTo(15.0f, 67.994675f);
                h.cubicTo(15.0f, 70.75904f, 17.233757f, 73.0f, 20.001331f, 73.0f);
                h.lineTo(75.998665f, 73.0f);
                h.cubicTo(78.760826f, 73.0f, 81.0f, 70.76372f, 81.0f, 67.994675f);
                h.lineTo(81.0f, 38.00532f);
                h.cubicTo(81.0f, 35.24096f, 78.76624f, 33.0f, 75.998665f, 33.0f);
                h.lineTo(20.001331f, 33.0f);
                h.close();
                h.moveTo(41.230534f, 24.0f);
                h.lineTo(48.0f, 24.0f);
                h.lineTo(48.0f, 33.0f);
                h.lineTo(27.74054f, 33.0f);
                h.cubicTo(33.113003f, 33.0f, 35.999054f, 24.0f, 41.230534f, 24.0f);
                h.close();
                h.moveTo(68.25946f, 33.0f);
                h.cubicTo(62.886997f, 33.0f, 60.000946f, 24.0f, 54.7683f, 24.0f);
                h.lineTo(48.0f, 24.0f);
                h.lineTo(48.0f, 33.0f);
                h.lineTo(68.25946f, 33.0f);
                h.close();
                h.moveTo(48.0f, 36.0f);
                h.cubicTo(56.83692f, 36.0f, 64.0f, 43.16308f, 64.0f, 52.0f);
                h.cubicTo(64.0f, 60.83692f, 56.83692f, 68.0f, 48.0f, 68.0f);
                h.cubicTo(39.16308f, 68.0f, 32.0f, 60.83692f, 32.0f, 52.0f);
                h.cubicTo(32.0f, 43.16308f, 39.16308f, 36.0f, 48.0f, 36.0f);
                h.close();
                h.moveTo(58.0f, 52.0f);
                h.cubicTo(58.0f, 57.523f, 53.523f, 62.0f, 48.0f, 62.0f);
                h.cubicTo(42.477f, 62.0f, 38.0f, 57.523f, 38.0f, 52.0f);
                h.cubicTo(38.0f, 46.477f, 42.477f, 42.0f, 48.0f, 42.0f);
                h.cubicTo(53.523f, 42.0f, 58.0f, 46.477f, 58.0f, 52.0f);
                h.close();
                h.moveTo(18.0f, 27.0f);
                h.lineTo(27.0f, 27.0f);
                h.lineTo(27.0f, 30.0f);
                h.lineTo(18.0f, 30.0f);
                h.lineTo(18.0f, 27.0f);
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
