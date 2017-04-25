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

public final class mm extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                Paint a = c.a(g, looper);
                a.setColor(-9473160);
                a.setStrokeWidth(3.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 10.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(25.826185f, 69.26216f);
                h.cubicTo(27.02675f, 70.278595f, 28.996534f, 70.27632f, 30.197113f, 69.24175f);
                h.cubicTo(30.197113f, 69.24175f, 56.0f, 48.740444f, 56.0f, 27.843023f);
                h.cubicTo(56.0f, 12.398772f, 43.463974f, 0.0f, 28.405798f, 0.0f);
                h.cubicTo(12.536027f, 0.0f, 0.0f, 12.398772f, 0.0f, 27.843023f);
                h.cubicTo(0.0f, 48.740444f, 25.826185f, 69.26216f, 25.826185f, 69.26216f);
                h.close();
                h.moveTo(28.0f, 37.0f);
                h.cubicTo(32.970562f, 37.0f, 37.0f, 32.970562f, 37.0f, 28.0f);
                h.cubicTo(37.0f, 23.029438f, 32.970562f, 19.0f, 28.0f, 19.0f);
                h.cubicTo(23.029438f, 19.0f, 19.0f, 23.029438f, 19.0f, 28.0f);
                h.cubicTo(19.0f, 32.970562f, 23.029438f, 37.0f, 28.0f, 37.0f);
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
