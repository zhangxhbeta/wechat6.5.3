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

public final class vh extends c {
    private final int height = 206;
    private final int width = 888;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 888;
            case 1:
                return 206;
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
                g2 = c.a(g2, looper);
                g2.setStrokeWidth(1.0f);
                Paint a = c.a(g, looper);
                Paint a2 = c.a(g2, looper);
                a.setColor(-855638017);
                a2.setColor(419430400);
                a2.setStrokeWidth(2.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                a = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(487.3696f, 158.0f);
                h.lineTo(865.59595f, 158.0f);
                h.cubicTo(873.5463f, 158.0f, 880.0f, 151.55057f, 880.0f, 143.5948f);
                h.lineTo(880.0f, 14.405201f);
                h.cubicTo(880.0f, 6.4388275f, 873.5511f, 0.0f, 865.59595f, 0.0f);
                h.lineTo(14.404071f, 0.0f);
                h.cubicTo(6.4536805f, 0.0f, 0.0f, 6.449428f, 0.0f, 14.405201f);
                h.lineTo(0.0f, 143.5948f);
                h.cubicTo(0.0f, 151.56117f, 6.448922f, 158.0f, 14.404071f, 158.0f);
                h.lineTo(391.99994f, 158.0f);
                h.cubicTo(401.8239f, 158.0f, 416.78622f, 166.02438f, 429.78192f, 186.76418f);
                h.cubicTo(442.77762f, 207.50397f, 454.39465f, 186.99791f, 454.39465f, 186.99791f);
                h.cubicTo(454.39465f, 186.99791f, 474.19223f, 158.00002f, 487.3696f, 158.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
