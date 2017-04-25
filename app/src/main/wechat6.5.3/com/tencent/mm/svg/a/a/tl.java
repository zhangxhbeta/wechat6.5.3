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

public final class tl extends c {
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
                c = c.a(c, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 25.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(43.01f, 0.01f);
                h.cubicTo(50.34f, 6.17f, 57.67f, 12.34f, 65.0f, 18.51f);
                h.lineTo(43.01f, 36.99f);
                h.cubicTo(42.99f, 33.32f, 43.01f, 29.65f, 42.99f, 25.98f);
                h.cubicTo(35.87f, 26.15f, 27.95f, 26.39f, 22.17f, 31.13f);
                h.cubicTo(18.73f, 33.94f, 16.85f, 38.08f, 14.97f, 42.0f);
                h.cubicTo(15.17f, 31.93f, 18.12f, 20.84f, 26.65f, 14.64f);
                h.cubicTo(31.29f, 11.04f, 37.37f, 10.72f, 42.99f, 11.02f);
                h.cubicTo(43.01f, 7.35f, 42.99f, 3.68f, 43.01f, 0.01f);
                h.lineTo(43.01f, 0.01f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.0f, 13.88f);
                h.cubicTo(0.68f, 12.08f, 1.93f, 9.91f, 3.94f, 10.05f);
                h.cubicTo(9.3f, 9.91f, 14.66f, 10.06f, 20.02f, 9.99f);
                h.cubicTo(17.95f, 12.03f, 16.26f, 14.42f, 14.9f, 16.99f);
                h.cubicTo(12.6f, 16.99f, 10.3f, 17.01f, 8.0f, 17.0f);
                h.lineTo(8.0f, 51.0f);
                h.lineTo(54.0f, 51.0f);
                h.cubicTo(54.04f, 46.48f, 53.9f, 41.96f, 54.08f, 37.45f);
                h.cubicTo(56.43f, 35.59f, 58.69f, 33.62f, 60.99f, 31.71f);
                h.cubicTo(60.97f, 39.5f, 61.07f, 47.29f, 60.95f, 55.08f);
                h.cubicTo(61.04f, 57.06f, 58.93f, 58.34f, 57.12f, 58.0f);
                h.lineTo(4.86f, 58.0f);
                h.cubicTo(3.09f, 58.32f, 0.95f, 57.09f, 1.05f, 55.12f);
                h.cubicTo(0.93f, 41.38f, 1.03f, 27.62f, 1.0f, 13.88f);
                h.lineTo(1.0f, 13.88f);
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
