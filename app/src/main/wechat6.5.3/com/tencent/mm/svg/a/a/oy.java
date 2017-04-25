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

public final class oy extends c {
    private final int height = 216;
    private final int width = 216;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 216;
            case 1:
                return 216;
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-5066062);
                Path h = c.h(looper);
                h.moveTo(0.0f, 40.0f);
                h.cubicTo(0.0f, 17.90861f, 17.90861f, 0.0f, 40.0f, 0.0f);
                h.lineTo(176.0f, 0.0f);
                h.cubicTo(198.09138f, 0.0f, 216.0f, 17.90861f, 216.0f, 40.0f);
                h.lineTo(216.0f, 176.0f);
                h.cubicTo(216.0f, 198.09138f, 198.09138f, 216.0f, 176.0f, 216.0f);
                h.lineTo(40.0f, 216.0f);
                h.cubicTo(17.90861f, 216.0f, 0.0f, 198.09138f, 0.0f, 176.0f);
                h.lineTo(0.0f, 40.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
