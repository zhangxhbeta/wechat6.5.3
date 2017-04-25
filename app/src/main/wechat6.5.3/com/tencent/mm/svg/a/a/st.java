package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class st extends c {
    private final int height = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
            case 1:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
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
                a.setColor(-5460820);
                c = c.a(c, 1.0f, 0.0f, 27.0f, 0.0f, 1.0f, 23.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(19.37f, 3.98f);
                h.cubicTo(20.17f, 3.03f, 20.35f, 0.92f, 21.98f, 1.08f);
                h.cubicTo(25.32f, 0.9f, 28.67f, 0.9f, 32.01f, 1.08f);
                h.cubicTo(33.65f, 0.92f, 33.84f, 3.02f, 34.63f, 3.98f);
                h.cubicTo(40.07f, 4.15f, 45.54f, 3.71f, 50.96f, 4.18f);
                h.cubicTo(53.77f, 5.17f, 52.82f, 8.73f, 53.06f, 11.0f);
                h.lineTo(0.94f, 11.0f);
                h.cubicTo(1.2f, 8.73f, 0.19f, 5.16f, 3.03f, 4.19f);
                h.cubicTo(8.46f, 3.71f, 13.93f, 4.15f, 19.37f, 3.98f);
                h.lineTo(19.37f, 3.98f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(6.0f, 14.0f);
                h.lineTo(48.0f, 14.0f);
                h.cubicTo(47.98f, 28.03f, 48.02f, 42.06f, 47.99f, 56.1f);
                h.cubicTo(48.22f, 57.86f, 47.15f, 60.03f, 45.13f, 59.93f);
                h.cubicTo(33.39f, 60.09f, 21.63f, 59.97f, 9.89f, 59.99f);
                h.cubicTo(8.12f, 60.24f, 5.99f, 59.17f, 6.07f, 57.15f);
                h.cubicTo(5.89f, 42.77f, 6.06f, 28.38f, 6.0f, 14.0f);
                h.lineTo(6.0f, 14.0f);
                h.close();
                h.moveTo(14.93f, 23.51f);
                h.cubicTo(15.04f, 32.5f, 15.06f, 41.5f, 14.92f, 50.49f);
                h.cubicTo(16.3f, 50.92f, 17.69f, 50.94f, 19.07f, 50.51f);
                h.cubicTo(18.86f, 41.95f, 19.13f, 33.4f, 18.96f, 24.85f);
                h.cubicTo(19.2f, 22.36f, 16.37f, 23.08f, 14.93f, 23.51f);
                h.lineTo(14.93f, 23.51f);
                h.close();
                h.moveTo(24.93f, 23.5f);
                h.cubicTo(25.04f, 32.48f, 25.07f, 41.46f, 24.91f, 50.44f);
                h.cubicTo(26.09f, 50.68f, 27.39f, 51.35f, 28.56f, 50.68f);
                h.cubicTo(29.29f, 48.89f, 28.94f, 46.9f, 29.03f, 45.02f);
                h.cubicTo(28.85f, 37.99f, 29.24f, 30.95f, 28.86f, 23.94f);
                h.cubicTo(28.15f, 22.28f, 26.18f, 23.37f, 24.93f, 23.5f);
                h.lineTo(24.93f, 23.5f);
                h.close();
                h.moveTo(34.93f, 23.5f);
                h.cubicTo(35.03f, 32.47f, 35.08f, 41.43f, 34.9f, 50.4f);
                h.cubicTo(36.39f, 51.04f, 39.3f, 51.61f, 38.96f, 49.03f);
                h.cubicTo(39.04f, 41.01f, 39.04f, 32.97f, 38.96f, 24.94f);
                h.cubicTo(39.29f, 22.39f, 36.43f, 23.04f, 34.93f, 23.5f);
                h.lineTo(34.93f, 23.5f);
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
