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

public final class sz extends c {
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
                c = c.a(c, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 22.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(20.81f, 4.81f);
                h.cubicTo(23.86f, 3.28f, 26.6f, 0.97f, 29.96f, 0.16f);
                h.cubicTo(32.24f, 0.32f, 34.1f, 1.89f, 36.06f, 2.92f);
                h.cubicTo(42.71f, 7.01f, 49.79f, 10.4f, 56.18f, 14.9f);
                h.cubicTo(49.39f, 19.34f, 42.13f, 23.01f, 35.18f, 27.18f);
                h.cubicTo(32.87f, 28.52f, 30.02f, 30.57f, 27.42f, 28.62f);
                h.cubicTo(19.51f, 24.06f, 11.48f, 19.7f, 3.7f, 14.91f);
                h.cubicTo(9.07f, 11.02f, 15.13f, 8.22f, 20.81f, 4.81f);
                h.lineTo(20.81f, 4.81f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(0.96f, 19.47f);
                h.cubicTo(3.76f, 19.53f, 6.0f, 21.35f, 8.35f, 22.63f);
                h.cubicTo(13.69f, 25.65f, 18.99f, 28.73f, 24.35f, 31.7f);
                h.cubicTo(25.95f, 32.63f, 27.99f, 33.76f, 27.92f, 35.91f);
                h.cubicTo(28.15f, 42.61f, 27.91f, 49.32f, 28.01f, 56.02f);
                h.cubicTo(27.99f, 58.72f, 28.31f, 61.51f, 27.32f, 64.08f);
                h.cubicTo(19.59f, 59.67f, 11.88f, 55.24f, 4.15f, 50.84f);
                h.cubicTo(2.75f, 50.0f, 1.05f, 48.93f, 1.09f, 47.08f);
                h.cubicTo(0.83f, 37.88f, 1.13f, 28.67f, 0.96f, 19.47f);
                h.lineTo(0.96f, 19.47f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(54.91f, 20.81f);
                h.cubicTo(56.18f, 20.05f, 57.58f, 19.57f, 59.05f, 19.39f);
                h.cubicTo(58.9f, 28.3f, 59.08f, 37.21f, 58.98f, 46.11f);
                h.cubicTo(59.14f, 47.96f, 58.22f, 49.75f, 56.55f, 50.59f);
                h.cubicTo(50.46f, 54.2f, 44.18f, 57.49f, 38.08f, 61.08f);
                h.cubicTo(36.17f, 62.2f, 34.21f, 63.43f, 31.94f, 63.6f);
                h.cubicTo(32.14f, 54.37f, 31.84f, 45.13f, 32.07f, 35.91f);
                h.cubicTo(32.04f, 33.77f, 34.12f, 32.68f, 35.7f, 31.74f);
                h.cubicTo(42.13f, 28.15f, 48.52f, 24.47f, 54.91f, 20.81f);
                h.lineTo(54.91f, 20.81f);
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
