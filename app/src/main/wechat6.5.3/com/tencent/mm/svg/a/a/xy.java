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

public final class xy extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(-6710887);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(34.0f, 0.0f);
                h.lineTo(37.77f, 0.0f);
                h.cubicTo(46.83f, 0.56f, 55.72f, 4.44f, 61.96f, 11.09f);
                h.cubicTo(67.89f, 17.18f, 71.41f, 25.42f, 72.0f, 33.88f);
                h.lineTo(72.0f, 37.76f);
                h.cubicTo(71.52f, 46.61f, 67.74f, 55.23f, 61.42f, 61.47f);
                h.cubicTo(55.3f, 67.71f, 46.82f, 71.34f, 38.15f, 72.0f);
                h.lineTo(34.35f, 72.0f);
                h.cubicTo(25.49f, 71.52f, 16.81f, 67.81f, 10.58f, 61.46f);
                h.cubicTo(4.3f, 55.27f, 0.55f, 46.73f, 0.0f, 37.95f);
                h.lineTo(0.0f, 34.45f);
                h.cubicTo(0.43f, 24.82f, 4.87f, 15.48f, 12.1f, 9.1f);
                h.cubicTo(18.08f, 3.66f, 25.97f, 0.6f, 34.0f, 0.0f);
                h.lineTo(34.0f, 0.0f);
                h.close();
                h.moveTo(29.41f, 3.66f);
                h.cubicTo(18.26f, 5.87f, 8.62f, 14.23f, 4.9f, 24.97f);
                h.cubicTo(0.62f, 36.67f, 3.76f, 50.63f, 12.68f, 59.33f);
                h.cubicTo(22.99f, 69.98f, 40.66f, 72.12f, 53.18f, 64.16f);
                h.cubicTo(66.79f, 56.23f, 72.81f, 37.9f, 66.52f, 23.45f);
                h.cubicTo(60.91f, 9.13f, 44.44f, 0.29f, 29.41f, 3.66f);
                h.lineTo(29.41f, 3.66f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(24.0f, 24.0f);
                h2.lineTo(48.0f, 24.0f);
                h2.lineTo(48.0f, 48.0f);
                h2.lineTo(24.0f, 48.0f);
                h2.lineTo(24.0f, 24.0f);
                h2.lineTo(24.0f, 24.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
