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

public final class lu extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                c = c.a(c, 1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 27.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-7829368);
                a2.setStrokeWidth(5.0f);
                Path h = c.h(looper);
                h.moveTo(64.0f, 79.00877f);
                h.cubicTo(64.0f, 80.678764f, 62.665936f, 82.0f, 61.02028f, 82.0f);
                h.lineTo(2.9797204f, 82.0f);
                h.cubicTo(1.336731f, 82.0f, 0.0f, 80.66078f, 0.0f, 79.00877f);
                h.lineTo(0.0f, 2.9912248f);
                h.cubicTo(0.0f, 1.321237f, 1.3340663f, 0.0f, 2.9797204f, 0.0f);
                h.lineTo(43.162792f, 0.0f);
                h.lineTo(64.0f, 20.872726f);
                h.lineTo(64.0f, 79.00877f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(g, looper);
                a3.setColor(-7829368);
                Path h2 = c.h(looper);
                h2.moveTo(38.0f, 0.0f);
                h2.lineTo(43.0f, 0.0f);
                h2.lineTo(43.0f, 24.0f);
                h2.lineTo(38.0f, 24.0f);
                h2.lineTo(38.0f, 0.0f);
                h2.close();
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-7829368);
                h2 = c.h(looper);
                h2.moveTo(38.0f, 21.0f);
                h2.lineTo(64.0f, 21.0f);
                h2.lineTo(64.0f, 26.0f);
                h2.lineTo(38.0f, 26.0f);
                h2.lineTo(38.0f, 21.0f);
                h2.close();
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
