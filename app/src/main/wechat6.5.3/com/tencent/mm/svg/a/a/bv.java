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

public final class bv extends c {
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -1463.0f, 0.0f, 1.0f, -215.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 1463.0f, 0.0f, 1.0f, 215.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(8.0f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(72.0f, 52.0f);
                h.lineTo(77.1435f, 52.0f);
                h.cubicTo(80.375984f, 52.0f, 81.20154f, 50.09575f, 78.983025f, 47.746735f);
                h.lineTo(53.01697f, 20.253265f);
                h.cubicTo(50.80398f, 17.910099f, 47.201538f, 17.904251f, 44.98303f, 20.253265f);
                h.lineTo(19.016973f, 47.746735f);
                h.cubicTo(16.803982f, 50.0899f, 17.622042f, 52.0f, 20.856497f, 52.0f);
                h.lineTo(26.0f, 52.0f);
                h.lineTo(26.0f, 74.07317f);
                h.cubicTo(26.0f, 75.69759f, 27.31177f, 77.0f, 28.92992f, 77.0f);
                h.lineTo(69.070076f, 77.0f);
                h.cubicTo(70.69741f, 77.0f, 72.0f, 75.68961f, 72.0f, 74.07317f);
                h.lineTo(72.0f, 52.0f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(54.0f, 63.0f);
                h2.lineTo(54.0f, 74.0f);
                h2.lineTo(45.0f, 74.0f);
                h2.lineTo(45.0f, 63.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
