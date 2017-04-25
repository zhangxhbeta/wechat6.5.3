package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bc extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.0f);
                c = c.a(c, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(36.925568f, 47.054665f);
                h.cubicTo(56.11064f, 47.054665f, 71.45919f, 26.668798f, 71.45919f, 26.668798f);
                h.cubicTo(72.148895f, 25.817219f, 72.17743f, 24.403841f, 71.5037f, 23.523014f);
                h.cubicTo(71.5037f, 23.523014f, 55.69043f, 0.96764195f, 36.505352f, 0.96764195f);
                h.cubicTo(17.320274f, 0.96764195f, 1.4598377f, 23.541723f, 1.4598377f, 23.541723f);
                h.cubicTo(0.8014887f, 24.417181f, 0.84271175f, 25.819351f, 1.5628284f, 26.651388f);
                h.cubicTo(1.5628284f, 26.651388f, 17.740492f, 47.054665f, 36.925568f, 47.054665f);
                h.lineTo(36.925568f, 47.054665f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(22.42774f, 20.499218f);
                h.cubicTo(22.148413f, 21.58994f, 22.0f, 22.732264f, 22.0f, 23.908884f);
                h.cubicTo(22.0f, 31.55521f, 28.267693f, 37.75321f, 36.0f, 37.75321f);
                h.cubicTo(43.732307f, 37.75321f, 50.0f, 31.55521f, 50.0f, 23.908884f);
                h.cubicTo(50.0f, 16.262556f, 43.732307f, 10.064558f, 36.0f, 10.064558f);
                h.cubicTo(34.347454f, 10.064558f, 32.76181f, 10.347658f, 31.289946f, 10.867492f);
                h.lineTo(34.60256f, 20.195063f);
                h.lineTo(31.98528f, 23.138868f);
                h.lineTo(22.42774f, 20.499218f);
                h.lineTo(22.42774f, 20.499218f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
