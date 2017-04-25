package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class hp extends c {
    private final int height = 80;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 80;
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
                g = c.a(g, looper);
                g.setColor(-12206054);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(46.16f, 67.69f);
                h.cubicTo(68.72f, 45.13f, 91.28f, 22.57f, 113.84f, 0.01f);
                h.cubicTo(115.9f, 2.05f, 117.95f, 4.1f, 119.99f, 6.16f);
                h.cubicTo(95.39f, 30.78f, 70.77f, 55.38f, 46.16f, 79.99f);
                h.cubicTo(30.77f, 64.62f, 15.38f, 49.24f, 0.01f, 33.85f);
                h.cubicTo(2.05f, 31.79f, 4.1f, 29.74f, 6.16f, 27.71f);
                h.cubicTo(19.5f, 41.02f, 32.81f, 54.37f, 46.16f, 67.69f);
                h.lineTo(46.16f, 67.69f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
