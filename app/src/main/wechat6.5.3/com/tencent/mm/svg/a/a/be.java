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

public final class be extends c {
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-7829368);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(86.0f, 0.0f);
                h.cubicTo(88.20914f, 0.0f, 90.0f, 1.7908609f, 90.0f, 4.0f);
                h.lineTo(90.0f, 86.0f);
                h.cubicTo(90.0f, 88.20914f, 88.20914f, 90.0f, 86.0f, 90.0f);
                h.lineTo(4.0f, 90.0f);
                h.cubicTo(1.7908609f, 90.0f, 0.0f, 88.20914f, 0.0f, 86.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(c, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(a, looper);
                a4.setColor(-1);
                a4.setStrokeWidth(4.0f);
                h = c.h(looper);
                h.moveTo(40.0f, 50.0f);
                h.cubicTo(40.0f, 51.162144f, 39.16621f, 52.0f, 38.0f, 52.0f);
                h.lineTo(2.0f, 52.0f);
                h.cubicTo(0.83545685f, 52.0f, 0.0f, 51.15074f, 0.0f, 50.0f);
                h.lineTo(0.0f, 2.0f);
                h.cubicTo(0.0f, 0.8378576f, 0.8337914f, 0.0f, 2.0f, 0.0f);
                h.lineTo(27.0f, 0.0f);
                h.lineTo(40.0f, 13.0f);
                h.lineTo(40.0f, 50.0f);
                h.close();
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(23.0f, 0.0f);
                h2.lineTo(27.0f, 0.0f);
                h2.lineTo(27.0f, 16.0f);
                h2.lineTo(23.0f, 16.0f);
                h2.lineTo(23.0f, 0.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-1);
                h2 = c.h(looper);
                h2.moveTo(23.0f, 13.0f);
                h2.lineTo(40.0f, 13.0f);
                h2.lineTo(40.0f, 17.0f);
                h2.lineTo(23.0f, 17.0f);
                h2.lineTo(23.0f, 13.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
