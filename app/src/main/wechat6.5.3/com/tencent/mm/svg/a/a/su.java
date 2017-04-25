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

public final class su extends c {
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
                a.setColor(-10526881);
                c = c.a(c, 1.0f, 0.0f, 27.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(21.11f, 1.23f);
                h.cubicTo(25.0f, 0.8f, 28.97f, 0.81f, 32.86f, 1.21f);
                h.cubicTo(33.54f, 2.09f, 34.16f, 3.01f, 34.72f, 3.97f);
                h.cubicTo(40.13f, 4.19f, 45.58f, 3.66f, 50.97f, 4.21f);
                h.cubicTo(53.77f, 5.17f, 52.77f, 8.75f, 53.1f, 11.0f);
                h.lineTo(0.9f, 11.0f);
                h.cubicTo(1.24f, 8.75f, 0.22f, 5.26f, 2.95f, 4.22f);
                h.cubicTo(8.37f, 3.66f, 13.84f, 4.19f, 19.29f, 3.97f);
                h.cubicTo(19.83f, 3.01f, 20.44f, 2.1f, 21.11f, 1.23f);
                h.lineTo(21.11f, 1.23f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(6.0f, 14.0f);
                h.lineTo(48.0f, 14.0f);
                h.cubicTo(47.98f, 28.03f, 48.04f, 42.05f, 47.99f, 56.08f);
                h.cubicTo(48.21f, 57.86f, 47.14f, 60.04f, 45.09f, 59.92f);
                h.cubicTo(33.36f, 60.11f, 21.62f, 59.97f, 9.89f, 59.99f);
                h.cubicTo(7.57f, 60.41f, 5.61f, 58.43f, 6.01f, 56.12f);
                h.cubicTo(5.97f, 42.08f, 6.02f, 28.04f, 6.0f, 14.0f);
                h.lineTo(6.0f, 14.0f);
                h.close();
                h.moveTo(15.49f, 23.47f);
                h.cubicTo(14.39f, 26.42f, 15.22f, 29.85f, 15.0f, 32.99f);
                h.cubicTo(15.09f, 38.36f, 14.84f, 43.75f, 15.05f, 49.12f);
                h.cubicTo(14.58f, 51.72f, 19.37f, 51.74f, 18.95f, 49.14f);
                h.cubicTo(19.04f, 41.05f, 19.06f, 32.95f, 18.94f, 24.86f);
                h.cubicTo(19.28f, 22.94f, 16.59f, 22.33f, 15.49f, 23.47f);
                h.lineTo(15.49f, 23.47f);
                h.close();
                h.moveTo(25.43f, 23.42f);
                h.cubicTo(24.45f, 31.86f, 25.2f, 40.57f, 25.05f, 49.11f);
                h.cubicTo(24.59f, 51.74f, 29.44f, 51.74f, 28.94f, 49.11f);
                h.cubicTo(29.06f, 41.05f, 29.05f, 32.97f, 28.95f, 24.91f);
                h.cubicTo(29.23f, 22.88f, 26.72f, 22.42f, 25.43f, 23.42f);
                h.lineTo(25.43f, 23.42f);
                h.close();
                h.moveTo(35.4f, 23.48f);
                h.cubicTo(34.49f, 31.92f, 35.18f, 40.59f, 35.04f, 49.11f);
                h.cubicTo(34.62f, 51.74f, 39.4f, 51.75f, 38.94f, 49.13f);
                h.cubicTo(39.05f, 41.07f, 39.05f, 32.99f, 38.94f, 24.92f);
                h.cubicTo(39.33f, 22.9f, 36.58f, 22.37f, 35.4f, 23.48f);
                h.lineTo(35.4f, 23.48f);
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
