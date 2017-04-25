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

public final class cj extends c {
    private final int height = 80;
    private final int width = 84;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 80;
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
                a.setColor(-13882324);
                c = c.a(c, 1.0f, 0.0f, -1347.0f, 0.0f, 1.0f, -215.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 1250.0f, 0.0f, 1.0f, 215.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(131.0f, 51.0f);
                h.lineTo(131.0f, 64.0f);
                h.cubicTo(131.0f, 65.044205f, 132.50389f, 66.62656f, 134.0f, 66.0f);
                h.lineTo(158.0f, 66.0f);
                h.lineTo(169.0f, 76.0f);
                h.cubicTo(169.0921f, 76.41986f, 169.86208f, 76.09059f, 170.0f, 74.0f);
                h.lineTo(170.0f, 66.0f);
                h.lineTo(177.0f, 66.0f);
                h.cubicTo(178.48862f, 66.62656f, 180.0f, 65.03394f, 180.0f, 64.0f);
                h.lineTo(180.0f, 29.0f);
                h.cubicTo(180.0f, 27.582346f, 178.4798f, 26.0f, 177.0f, 26.0f);
                h.lineTo(156.0f, 26.0f);
                h.lineTo(156.0f, 46.0f);
                h.cubicTo(154.65517f, 48.362537f, 152.38159f, 50.729206f, 150.0f, 51.0f);
                h.lineTo(131.0f, 51.0f);
                h.close();
                h.moveTo(149.02345f, 4.0f);
                h.cubicTo(150.66736f, 4.0f, 152.0f, 5.334057f, 152.0f, 6.97253f);
                h.lineTo(152.0f, 44.02747f);
                h.cubicTo(152.0f, 45.66915f, 150.66797f, 47.0f, 149.02759f, 47.0f);
                h.lineTo(121.0f, 47.0f);
                h.lineTo(110.64339f, 55.630512f);
                h.cubicTo(109.73577f, 56.38686f, 109.0f, 56.041157f, 109.0f, 54.854748f);
                h.lineTo(109.0f, 47.0f);
                h.lineTo(99.96629f, 47.0f);
                h.cubicTo(98.32806f, 47.0f, 97.0f, 45.665943f, 97.0f, 44.02747f);
                h.lineTo(97.0f, 6.97253f);
                h.cubicTo(97.0f, 5.330847f, 98.332306f, 4.0f, 99.97654f, 4.0f);
                h.lineTo(149.02345f, 4.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
