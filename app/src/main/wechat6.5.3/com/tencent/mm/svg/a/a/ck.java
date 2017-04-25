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

public final class ck extends c {
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -1250.0f, 0.0f, 1.0f, -215.0f);
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
                h.moveTo(34.0f, 51.0f);
                h.lineTo(34.0f, 64.0f);
                h.cubicTo(34.0f, 65.044205f, 35.50389f, 66.62656f, 37.0f, 66.0f);
                h.lineTo(61.0f, 66.0f);
                h.lineTo(72.0f, 76.0f);
                h.cubicTo(72.0921f, 76.41986f, 72.86207f, 76.09059f, 73.0f, 74.0f);
                h.lineTo(73.0f, 66.0f);
                h.lineTo(80.0f, 66.0f);
                h.cubicTo(81.48861f, 66.62656f, 83.0f, 65.03394f, 83.0f, 64.0f);
                h.lineTo(83.0f, 29.0f);
                h.cubicTo(83.0f, 27.582346f, 81.4798f, 26.0f, 80.0f, 26.0f);
                h.lineTo(59.0f, 26.0f);
                h.lineTo(59.0f, 46.0f);
                h.cubicTo(57.655174f, 48.362537f, 55.381588f, 50.729206f, 53.0f, 51.0f);
                h.lineTo(34.0f, 51.0f);
                h.close();
                h.moveTo(52.02346f, 4.0f);
                h.cubicTo(53.66736f, 4.0f, 55.0f, 5.334057f, 55.0f, 6.97253f);
                h.lineTo(55.0f, 44.02747f);
                h.cubicTo(55.0f, 45.66915f, 53.66797f, 47.0f, 52.027588f, 47.0f);
                h.lineTo(24.0f, 47.0f);
                h.lineTo(13.643388f, 55.630512f);
                h.cubicTo(12.735769f, 56.38686f, 12.0f, 56.041157f, 12.0f, 54.854748f);
                h.lineTo(12.0f, 47.0f);
                h.lineTo(2.9662929f, 47.0f);
                h.cubicTo(1.3280545f, 47.0f, 0.0f, 45.665943f, 0.0f, 44.02747f);
                h.lineTo(0.0f, 6.97253f);
                h.cubicTo(0.0f, 5.330847f, 1.332306f, 4.0f, 2.97654f, 4.0f);
                h.lineTo(52.02346f, 4.0f);
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
