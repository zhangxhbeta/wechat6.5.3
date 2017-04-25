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

public final class aeg extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-10329502);
                c = c.a(c, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(21.0f, 4.0f);
                h.cubicTo(21.0f, 1.7908609f, 22.790861f, 0.0f, 25.0f, 0.0f);
                h.lineTo(26.0f, 0.0f);
                h.cubicTo(28.209139f, 0.0f, 30.0f, 1.7908609f, 30.0f, 4.0f);
                h.lineTo(30.0f, 42.0f);
                h.cubicTo(30.0f, 44.20914f, 28.209139f, 46.0f, 26.0f, 46.0f);
                h.lineTo(25.0f, 46.0f);
                h.cubicTo(22.790861f, 46.0f, 21.0f, 44.20914f, 21.0f, 42.0f);
                h.lineTo(21.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(5.0f, 0.0f);
                h.cubicTo(7.209139f, 0.0f, 9.0f, 1.7908609f, 9.0f, 4.0f);
                h.lineTo(9.0f, 42.0f);
                h.cubicTo(9.0f, 44.20914f, 7.209139f, 46.0f, 5.0f, 46.0f);
                h.lineTo(4.0f, 46.0f);
                h.cubicTo(1.7908609f, 46.0f, 0.0f, 44.20914f, 0.0f, 42.0f);
                h.lineTo(0.0f, 4.0f);
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
