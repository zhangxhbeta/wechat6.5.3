package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class pr extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-4868683);
                c = c.a(c, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 23.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(20.43f, 0.56f);
                h.cubicTo(26.75f, -0.88f, 33.58f, 0.53f, 38.89f, 4.21f);
                h.cubicTo(47.37f, 10.01f, 51.78f, 21.3f, 49.26f, 31.28f);
                h.cubicTo(47.01f, 40.43f, 39.16f, 47.82f, 29.91f, 49.59f);
                h.cubicTo(17.72f, 51.88f, 4.26f, 44.13f, 0.95f, 32.0f);
                h.cubicTo(-3.19f, 18.46f, 6.49f, 2.93f, 20.43f, 0.56f);
                h.lineTo(20.43f, 0.56f);
                h.close();
                h.moveTo(20.46f, 3.53f);
                h.cubicTo(11.63f, 5.29f, 4.4f, 13.0f, 3.28f, 21.94f);
                h.cubicTo(2.12f, 29.59f, 5.43f, 37.68f, 11.58f, 42.35f);
                h.cubicTo(17.99f, 47.43f, 27.32f, 48.37f, 34.62f, 44.71f);
                h.cubicTo(41.38f, 41.48f, 46.2f, 34.55f, 46.83f, 27.08f);
                h.cubicTo(47.61f, 19.72f, 44.29f, 12.11f, 38.4f, 7.64f);
                h.cubicTo(33.4f, 3.72f, 26.66f, 2.21f, 20.46f, 3.53f);
                h.lineTo(20.46f, 3.53f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(24.26f, 11.33f);
                h.cubicTo(27.01f, 9.64f, 29.55f, 14.15f, 26.77f, 15.67f);
                h.cubicTo(24.01f, 17.4f, 21.42f, 12.82f, 24.26f, 11.33f);
                h.lineTo(24.26f, 11.33f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(21.0f, 19.0f);
                h.cubicTo(23.29f, 19.0f, 25.58f, 19.0f, 27.87f, 19.01f);
                h.cubicTo(27.86f, 25.15f, 27.86f, 31.3f, 27.86f, 37.45f);
                h.cubicTo(28.91f, 37.46f, 29.95f, 37.47f, 31.0f, 37.48f);
                h.lineTo(31.0f, 38.99f);
                h.cubicTo(27.67f, 39.0f, 24.33f, 39.0f, 21.0f, 38.99f);
                h.lineTo(21.0f, 37.49f);
                h.cubicTo(22.05f, 37.47f, 23.1f, 37.44f, 24.15f, 37.4f);
                h.cubicTo(24.12f, 31.78f, 24.15f, 26.17f, 24.14f, 20.55f);
                h.cubicTo(23.09f, 20.54f, 22.05f, 20.53f, 21.0f, 20.53f);
                h.lineTo(21.0f, 19.0f);
                h.lineTo(21.0f, 19.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
