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

public final class cv extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3194563);
                Path h = c.h(looper);
                h.moveTo(28.0f, 0.0f);
                h.lineTo(31.91f, 0.0f);
                h.cubicTo(46.53f, 0.77f, 59.15f, 13.36f, 60.0f, 27.97f);
                h.lineTo(60.0f, 31.8f);
                h.cubicTo(59.3f, 46.69f, 46.27f, 59.57f, 31.35f, 60.0f);
                h.lineTo(28.48f, 60.0f);
                h.cubicTo(13.76f, 59.47f, 0.96f, 46.87f, 0.0f, 32.2f);
                h.lineTo(0.0f, 28.26f);
                h.cubicTo(0.67f, 13.56f, 13.33f, 0.84f, 28.0f, 0.0f);
                h.moveTo(13.35f, 25.51f);
                h.cubicTo(11.47f, 26.71f, 12.06f, 29.22f, 11.97f, 31.09f);
                h.cubicTo(11.7f, 32.88f, 12.89f, 35.05f, 14.89f, 34.94f);
                h.cubicTo(24.63f, 35.08f, 34.38f, 34.97f, 44.13f, 34.99f);
                h.cubicTo(45.92f, 35.31f, 47.97f, 34.09f, 47.96f, 32.14f);
                h.cubicTo(47.98f, 29.78f, 48.76f, 26.29f, 45.99f, 25.15f);
                h.cubicTo(36.69f, 24.77f, 27.35f, 25.14f, 18.04f, 24.98f);
                h.cubicTo(16.5f, 25.15f, 14.73f, 24.65f, 13.35f, 25.51f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-665128);
                h = c.h(looper);
                h.moveTo(13.35f, 25.51f);
                h.cubicTo(14.73f, 24.65f, 16.5f, 25.15f, 18.04f, 24.98f);
                h.cubicTo(27.35f, 25.14f, 36.69f, 24.77f, 45.99f, 25.15f);
                h.cubicTo(48.76f, 26.29f, 47.98f, 29.78f, 47.96f, 32.14f);
                h.cubicTo(47.97f, 34.09f, 45.92f, 35.31f, 44.13f, 34.99f);
                h.cubicTo(34.38f, 34.97f, 24.63f, 35.08f, 14.89f, 34.94f);
                h.cubicTo(12.89f, 35.05f, 11.7f, 32.88f, 11.97f, 31.09f);
                h.cubicTo(12.06f, 29.22f, 11.47f, 26.71f, 13.35f, 25.51f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
