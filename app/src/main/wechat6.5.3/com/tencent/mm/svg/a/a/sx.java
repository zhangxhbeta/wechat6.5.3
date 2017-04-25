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

public final class sx extends c {
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
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.35f, 1.5f);
                h.cubicTo(3.74f, 0.7f, 5.46f, 1.12f, 6.99f, 0.97f);
                h.cubicTo(25.38f, 1.08f, 43.78f, 0.89f, 62.17f, 1.07f);
                h.cubicTo(64.14f, 0.97f, 65.25f, 3.16f, 64.99f, 4.89f);
                h.cubicTo(65.01f, 17.64f, 65.01f, 30.4f, 64.99f, 43.16f);
                h.cubicTo(65.41f, 45.4f, 63.42f, 47.45f, 61.15f, 46.99f);
                h.cubicTo(42.39f, 47.01f, 23.62f, 47.01f, 4.85f, 46.99f);
                h.cubicTo(3.08f, 47.28f, 0.96f, 46.11f, 1.07f, 44.13f);
                h.cubicTo(0.89f, 31.42f, 1.07f, 18.7f, 0.98f, 5.99f);
                h.cubicTo(1.05f, 4.43f, 0.78f, 2.44f, 2.35f, 1.5f);
                h.lineTo(2.35f, 1.5f);
                h.close();
                h.moveTo(7.98f, 14.89f);
                h.cubicTo(15.34f, 19.29f, 22.84f, 23.48f, 30.24f, 27.82f);
                h.cubicTo(31.9f, 28.96f, 34.09f, 28.95f, 35.76f, 27.82f);
                h.cubicTo(43.14f, 23.48f, 50.64f, 19.31f, 57.99f, 14.91f);
                h.cubicTo(61.35f, 13.52f, 58.13f, 7.66f, 55.13f, 9.74f);
                h.cubicTo(47.7f, 13.88f, 40.39f, 18.25f, 33.0f, 22.46f);
                h.cubicTo(25.61f, 18.25f, 18.31f, 13.88f, 10.88f, 9.75f);
                h.cubicTo(7.92f, 7.68f, 4.67f, 13.4f, 7.98f, 14.89f);
                h.lineTo(7.98f, 14.89f);
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
