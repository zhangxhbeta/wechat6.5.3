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

public final class sy extends c {
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
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.32f, 1.53f);
                h.cubicTo(3.67f, 0.67f, 5.43f, 1.15f, 6.94f, 0.97f);
                h.cubicTo(24.98f, 1.04f, 43.02f, 0.97f, 61.06f, 1.01f);
                h.cubicTo(63.36f, 0.51f, 65.43f, 2.58f, 64.99f, 4.88f);
                h.cubicTo(65.01f, 17.61f, 65.01f, 30.36f, 64.99f, 43.09f);
                h.cubicTo(65.43f, 45.36f, 63.43f, 47.46f, 61.14f, 46.99f);
                h.cubicTo(42.41f, 47.01f, 23.67f, 47.0f, 4.94f, 46.99f);
                h.cubicTo(3.15f, 47.3f, 0.94f, 46.12f, 1.06f, 44.1f);
                h.cubicTo(0.89f, 31.41f, 1.07f, 18.72f, 0.98f, 6.03f);
                h.cubicTo(1.05f, 4.47f, 0.75f, 2.48f, 2.32f, 1.53f);
                h.lineTo(2.32f, 1.53f);
                h.close();
                h.moveTo(6.55f, 13.11f);
                h.cubicTo(6.85f, 14.47f, 8.25f, 15.02f, 9.27f, 15.72f);
                h.cubicTo(16.54f, 19.82f, 23.69f, 24.11f, 30.96f, 28.18f);
                h.cubicTo(32.75f, 29.26f, 34.85f, 28.47f, 36.45f, 27.44f);
                h.cubicTo(43.58f, 23.2f, 50.86f, 19.19f, 57.98f, 14.92f);
                h.cubicTo(61.36f, 13.51f, 58.11f, 7.66f, 55.13f, 9.75f);
                h.cubicTo(47.69f, 13.87f, 40.39f, 18.25f, 33.0f, 22.46f);
                h.cubicTo(25.6f, 18.24f, 18.29f, 13.86f, 10.84f, 9.74f);
                h.cubicTo(8.68f, 8.22f, 6.34f, 11.0f, 6.55f, 13.11f);
                h.lineTo(6.55f, 13.11f);
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
