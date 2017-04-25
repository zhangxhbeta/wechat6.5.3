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

public final class tm extends c {
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
                c = c.a(c, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 25.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(43.01f, 0.01f);
                h.cubicTo(50.34f, 6.18f, 57.67f, 12.34f, 65.0f, 18.5f);
                h.cubicTo(57.67f, 24.67f, 50.34f, 30.83f, 43.01f, 36.99f);
                h.cubicTo(43.0f, 33.32f, 43.0f, 29.64f, 43.0f, 25.97f);
                h.cubicTo(36.32f, 26.17f, 29.09f, 26.33f, 23.36f, 30.22f);
                h.cubicTo(19.21f, 33.0f, 17.04f, 37.67f, 14.94f, 42.01f);
                h.cubicTo(15.22f, 31.95f, 18.09f, 20.86f, 26.63f, 14.65f);
                h.cubicTo(31.27f, 11.04f, 37.36f, 10.73f, 43.0f, 11.02f);
                h.cubicTo(42.99f, 7.35f, 43.0f, 3.68f, 43.01f, 0.01f);
                h.lineTo(43.01f, 0.01f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.01f, 13.9f);
                h.cubicTo(0.71f, 12.13f, 1.86f, 9.97f, 3.86f, 10.06f);
                h.cubicTo(9.23f, 9.86f, 14.62f, 10.09f, 20.0f, 9.98f);
                h.cubicTo(17.97f, 12.06f, 16.28f, 14.44f, 14.88f, 16.99f);
                h.cubicTo(12.59f, 17.01f, 10.29f, 17.0f, 8.0f, 17.0f);
                h.lineTo(8.0f, 51.0f);
                h.lineTo(54.0f, 51.0f);
                h.lineTo(54.0f, 37.59f);
                h.cubicTo(56.34f, 35.63f, 58.66f, 33.65f, 61.0f, 31.69f);
                h.cubicTo(60.94f, 39.5f, 61.11f, 47.31f, 60.93f, 55.12f);
                h.cubicTo(61.01f, 57.09f, 58.92f, 58.3f, 57.14f, 57.99f);
                h.cubicTo(39.7f, 58.0f, 22.26f, 58.01f, 4.83f, 57.99f);
                h.cubicTo(3.07f, 58.29f, 0.95f, 57.08f, 1.06f, 55.12f);
                h.cubicTo(0.92f, 41.38f, 1.03f, 27.64f, 1.01f, 13.9f);
                h.lineTo(1.01f, 13.9f);
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
