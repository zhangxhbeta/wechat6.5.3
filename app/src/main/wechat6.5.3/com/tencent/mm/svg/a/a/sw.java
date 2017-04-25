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

public final class sw extends c {
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
                c = c.a(c, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 30.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.38f, 1.48f);
                h.cubicTo(3.77f, 0.71f, 5.46f, 1.12f, 6.98f, 0.98f);
                h.cubicTo(25.36f, 1.07f, 43.74f, 0.9f, 62.12f, 1.06f);
                h.cubicTo(64.07f, 0.95f, 65.25f, 3.06f, 64.99f, 4.8f);
                h.cubicTo(65.01f, 17.57f, 65.0f, 30.35f, 64.99f, 43.12f);
                h.cubicTo(65.27f, 44.9f, 64.08f, 47.07f, 62.08f, 46.95f);
                h.cubicTo(43.01f, 47.07f, 23.94f, 46.97f, 4.88f, 47.0f);
                h.cubicTo(3.08f, 47.3f, 0.92f, 46.08f, 1.05f, 44.06f);
                h.cubicTo(0.91f, 31.37f, 1.06f, 18.67f, 0.98f, 5.98f);
                h.cubicTo(1.03f, 4.41f, 0.78f, 2.4f, 2.38f, 1.48f);
                h.lineTo(2.38f, 1.48f);
                h.close();
                h.moveTo(8.02f, 14.93f);
                h.cubicTo(15.36f, 19.28f, 22.81f, 23.46f, 30.16f, 27.78f);
                h.cubicTo(31.84f, 28.96f, 34.13f, 28.99f, 35.81f, 27.79f);
                h.cubicTo(43.18f, 23.46f, 50.65f, 19.28f, 58.0f, 14.92f);
                h.cubicTo(61.44f, 13.4f, 57.94f, 7.55f, 54.96f, 9.82f);
                h.cubicTo(47.6f, 13.96f, 40.33f, 18.27f, 33.0f, 22.46f);
                h.cubicTo(25.67f, 18.27f, 18.4f, 13.97f, 11.05f, 9.83f);
                h.cubicTo(8.06f, 7.54f, 4.56f, 13.41f, 8.02f, 14.93f);
                h.lineTo(8.02f, 14.93f);
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
