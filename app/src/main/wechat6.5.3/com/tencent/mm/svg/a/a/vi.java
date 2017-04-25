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

public final class vi extends c {
    private final int height = 96;
    private final int width = 43;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 43;
            case 1:
                return 96;
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
                g2 = c.a(g2, looper);
                g2.setStrokeWidth(1.0f);
                g = c.a(g, looper);
                g2 = c.a(g2, looper);
                g.setColor(-1);
                g2.setColor(832018327);
                g2.setStrokeWidth(1.44f);
                canvas.save();
                Paint a = c.a(g, looper);
                Paint a2 = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(21.5f, 31.0f);
                h.cubicTo(31.164984f, 31.0f, 39.0f, 38.835014f, 39.0f, 48.5f);
                h.cubicTo(39.0f, 58.164986f, 31.164984f, 66.0f, 21.5f, 66.0f);
                h.cubicTo(11.835016f, 66.0f, 4.0f, 58.164986f, 4.0f, 48.5f);
                h.cubicTo(4.0f, 38.835014f, 11.835016f, 31.0f, 21.5f, 31.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.drawPath(h, a2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
