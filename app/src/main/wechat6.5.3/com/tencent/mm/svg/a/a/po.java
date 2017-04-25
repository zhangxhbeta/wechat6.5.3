package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class po extends c {
    private final int height = 55;
    private final int width = 35;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 35;
            case 1:
                return 55;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                a.setColor(-5066062);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(5.0f, 0.0f);
                h.cubicTo(7.209139f, 0.0f, 9.0f, 1.7908609f, 9.0f, 4.0f);
                h.lineTo(9.0f, 51.0f);
                h.cubicTo(9.0f, 53.20914f, 7.209139f, 55.0f, 5.0f, 55.0f);
                h.lineTo(4.0f, 55.0f);
                h.cubicTo(1.7908609f, 55.0f, 0.0f, 53.20914f, 0.0f, 51.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(26.0f, 4.0f);
                h.cubicTo(26.0f, 1.7908609f, 27.790861f, 0.0f, 30.0f, 0.0f);
                h.lineTo(31.0f, 0.0f);
                h.cubicTo(33.20914f, 0.0f, 35.0f, 1.7908609f, 35.0f, 4.0f);
                h.lineTo(35.0f, 51.0f);
                h.cubicTo(35.0f, 53.20914f, 33.20914f, 55.0f, 31.0f, 55.0f);
                h.lineTo(30.0f, 55.0f);
                h.cubicTo(27.790861f, 55.0f, 26.0f, 53.20914f, 26.0f, 51.0f);
                h.lineTo(26.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
