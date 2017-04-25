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

public final class cu extends c {
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
                a.setColor(-1158579);
                Path h = c.h(looper);
                h.moveTo(28.12f, 0.0f);
                h.lineTo(31.27f, 0.0f);
                h.cubicTo(46.17f, 0.38f, 59.22f, 13.21f, 60.0f, 28.08f);
                h.lineTo(60.0f, 31.41f);
                h.cubicTo(59.54f, 46.48f, 46.34f, 59.63f, 31.27f, 60.0f);
                h.lineTo(28.62f, 60.0f);
                h.cubicTo(13.75f, 59.56f, 0.77f, 46.74f, 0.0f, 31.91f);
                h.lineTo(0.0f, 28.41f);
                h.cubicTo(0.57f, 13.61f, 13.35f, 0.76f, 28.12f, 0.0f);
                h.moveTo(13.33f, 25.52f);
                h.cubicTo(11.45f, 26.76f, 12.08f, 29.29f, 11.98f, 31.17f);
                h.cubicTo(11.71f, 32.93f, 12.93f, 35.04f, 14.88f, 34.94f);
                h.cubicTo(24.96f, 35.04f, 35.06f, 35.05f, 45.14f, 34.93f);
                h.cubicTo(47.09f, 35.04f, 48.25f, 32.9f, 48.02f, 31.17f);
                h.cubicTo(48.05f, 29.08f, 48.46f, 26.07f, 46.0f, 25.17f);
                h.cubicTo(36.68f, 24.75f, 27.32f, 25.15f, 17.99f, 24.97f);
                h.cubicTo(16.46f, 25.14f, 14.7f, 24.67f, 13.33f, 25.52f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(13.33f, 25.52f);
                h.cubicTo(14.7f, 24.67f, 16.46f, 25.14f, 17.99f, 24.97f);
                h.cubicTo(27.32f, 25.15f, 36.68f, 24.75f, 46.0f, 25.17f);
                h.cubicTo(48.46f, 26.07f, 48.05f, 29.08f, 48.02f, 31.17f);
                h.cubicTo(48.25f, 32.9f, 47.09f, 35.04f, 45.14f, 34.93f);
                h.cubicTo(35.06f, 35.05f, 24.96f, 35.04f, 14.88f, 34.94f);
                h.cubicTo(12.93f, 35.04f, 11.71f, 32.93f, 11.98f, 31.17f);
                h.cubicTo(12.08f, 29.29f, 11.45f, 26.76f, 13.33f, 25.52f);
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
