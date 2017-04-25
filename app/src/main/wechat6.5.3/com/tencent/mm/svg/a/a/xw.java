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

public final class xw extends c {
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
                h.moveTo(33.88f, 0.0f);
                h.lineTo(37.99f, 0.0f);
                h.cubicTo(46.5f, 0.63f, 54.85f, 4.06f, 60.96f, 10.08f);
                h.cubicTo(67.43f, 16.24f, 71.33f, 24.85f, 72.0f, 33.73f);
                h.lineTo(72.0f, 37.97f);
                h.cubicTo(71.44f, 46.97f, 67.49f, 55.71f, 60.95f, 61.93f);
                h.cubicTo(54.91f, 67.87f, 46.69f, 71.3f, 38.29f, 72.0f);
                h.lineTo(34.16f, 72.0f);
                h.cubicTo(25.58f, 71.47f, 17.17f, 67.95f, 11.02f, 61.9f);
                h.cubicTo(4.53f, 55.72f, 0.62f, 47.06f, 0.0f, 38.14f);
                h.lineTo(0.0f, 34.2f);
                h.cubicTo(0.52f, 24.67f, 4.91f, 15.44f, 12.08f, 9.12f);
                h.cubicTo(18.04f, 3.69f, 25.89f, 0.64f, 33.88f, 0.0f);
                h.lineTo(33.88f, 0.0f);
                h.close();
                h.moveTo(29.41f, 3.66f);
                h.cubicTo(22.9f, 5.01f, 16.79f, 8.34f, 12.2f, 13.16f);
                h.cubicTo(1.73f, 23.69f, -0.01f, 41.47f, 8.24f, 53.82f);
                h.cubicTo(16.74f, 67.7f, 36.16f, 73.15f, 50.6f, 65.58f);
                h.cubicTo(65.28f, 58.72f, 72.84f, 40.21f, 67.13f, 25.04f);
                h.cubicTo(62.1f, 9.87f, 45.03f, 0.13f, 29.41f, 3.66f);
                h.lineTo(29.41f, 3.66f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(26.0f, 19.01f);
                h.cubicTo(35.33f, 24.67f, 44.66f, 30.33f, 53.99f, 36.0f);
                h.cubicTo(44.67f, 41.67f, 35.34f, 47.33f, 26.0f, 52.99f);
                h.lineTo(26.0f, 19.01f);
                h.lineTo(26.0f, 19.01f);
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
