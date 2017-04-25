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

public final class ry extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(44.5f, 40.321075f);
                h.lineTo(23.613749f, 19.430162f);
                h.cubicTo(23.041075f, 18.85736f, 22.09352f, 18.853842f, 21.511253f, 19.436235f);
                h.lineTo(19.44183f, 21.506123f);
                h.cubicTo(18.850626f, 22.097458f, 18.856846f, 23.030046f, 19.435757f, 23.609087f);
                h.lineTo(40.322006f, 44.5f);
                h.lineTo(19.435757f, 65.390915f);
                h.cubicTo(18.856846f, 65.969955f, 18.850626f, 66.90254f, 19.44183f, 67.49387f);
                h.lineTo(21.511253f, 69.56377f);
                h.cubicTo(22.09352f, 70.14616f, 23.041075f, 70.14264f, 23.613749f, 69.56984f);
                h.lineTo(44.5f, 48.678925f);
                h.lineTo(65.38625f, 69.56984f);
                h.cubicTo(65.95892f, 70.14264f, 66.90648f, 70.14616f, 67.48875f, 69.56377f);
                h.lineTo(69.558174f, 67.49387f);
                h.cubicTo(70.149376f, 66.90254f, 70.14316f, 65.969955f, 69.56425f, 65.390915f);
                h.lineTo(48.677994f, 44.5f);
                h.lineTo(69.56425f, 23.609087f);
                h.cubicTo(70.14316f, 23.030046f, 70.149376f, 22.097458f, 69.558174f, 21.506123f);
                h.lineTo(67.48875f, 19.436235f);
                h.cubicTo(66.90648f, 18.853842f, 65.95892f, 18.85736f, 65.38625f, 19.430162f);
                h.lineTo(44.5f, 40.321075f);
                h.lineTo(44.5f, 40.321075f);
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
