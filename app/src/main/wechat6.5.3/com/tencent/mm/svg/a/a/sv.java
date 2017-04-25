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

public final class sv extends c {
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
                a.setColor(-12632257);
                c = c.a(c, 1.0f, 0.0f, 27.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(21.18f, 1.19f);
                h.cubicTo(25.06f, 0.83f, 28.99f, 0.81f, 32.86f, 1.21f);
                h.cubicTo(33.54f, 2.1f, 34.17f, 3.02f, 34.74f, 3.98f);
                h.cubicTo(40.18f, 4.16f, 45.65f, 3.69f, 51.07f, 4.21f);
                h.cubicTo(53.73f, 5.33f, 52.78f, 8.74f, 53.11f, 11.0f);
                h.lineTo(0.89f, 11.0f);
                h.cubicTo(1.23f, 8.75f, 0.22f, 5.23f, 2.97f, 4.21f);
                h.cubicTo(8.38f, 3.68f, 13.83f, 4.16f, 19.25f, 3.98f);
                h.cubicTo(19.84f, 3.01f, 20.49f, 2.08f, 21.18f, 1.19f);
                h.lineTo(21.18f, 1.19f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(6.0f, 14.0f);
                h.lineTo(48.0f, 14.0f);
                h.cubicTo(48.0f, 27.68f, 47.99f, 41.37f, 48.02f, 55.06f);
                h.cubicTo(47.94f, 56.59f, 48.16f, 58.56f, 46.64f, 59.5f);
                h.cubicTo(45.23f, 60.25f, 43.52f, 59.9f, 41.99f, 60.03f);
                h.cubicTo(31.28f, 59.94f, 20.56f, 60.06f, 9.85f, 59.98f);
                h.cubicTo(8.08f, 60.22f, 5.97f, 59.13f, 6.09f, 57.12f);
                h.cubicTo(5.87f, 42.75f, 6.07f, 28.37f, 6.0f, 14.0f);
                h.lineTo(6.0f, 14.0f);
                h.close();
                h.moveTo(14.95f, 23.34f);
                h.cubicTo(15.03f, 32.42f, 15.03f, 41.5f, 14.95f, 50.58f);
                h.cubicTo(16.27f, 50.55f, 18.19f, 51.75f, 18.83f, 50.02f);
                h.cubicTo(19.28f, 41.14f, 18.82f, 32.23f, 19.04f, 23.34f);
                h.cubicTo(17.68f, 23.31f, 16.32f, 23.31f, 14.95f, 23.34f);
                h.lineTo(14.95f, 23.34f);
                h.close();
                h.moveTo(25.16f, 23.99f);
                h.cubicTo(24.73f, 32.86f, 25.19f, 41.77f, 24.95f, 50.65f);
                h.cubicTo(26.31f, 50.69f, 27.68f, 50.69f, 29.04f, 50.67f);
                h.cubicTo(28.98f, 41.59f, 28.96f, 32.5f, 29.05f, 23.42f);
                h.cubicTo(27.74f, 23.45f, 25.79f, 22.25f, 25.16f, 23.99f);
                h.lineTo(25.16f, 23.99f);
                h.close();
                h.moveTo(35.54f, 23.46f);
                h.cubicTo(34.51f, 24.64f, 35.21f, 26.57f, 34.97f, 28.03f);
                h.cubicTo(35.09f, 35.07f, 34.88f, 42.11f, 35.05f, 49.15f);
                h.cubicTo(34.79f, 50.89f, 36.76f, 51.32f, 38.06f, 51.01f);
                h.cubicTo(39.31f, 50.05f, 38.89f, 48.36f, 39.03f, 47.0f);
                h.cubicTo(38.93f, 39.63f, 39.11f, 32.24f, 38.95f, 24.87f);
                h.cubicTo(39.31f, 23.0f, 36.6f, 22.3f, 35.54f, 23.46f);
                h.lineTo(35.54f, 23.46f);
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
