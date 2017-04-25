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

public final class acw extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                c = c.a(c, 1.3333334f, 0.0f, 0.0f, 0.0f, 1.3333334f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-6626030);
                Path h = c.h(looper);
                h.moveTo(36.83f, 10.18f);
                h.cubicTo(38.71f, 8.29f, 40.59f, 6.41f, 42.48f, 4.54f);
                h.cubicTo(53.62f, 15.45f, 56.31f, 33.8f, 48.53f, 47.35f);
                h.cubicTo(46.75f, 50.69f, 44.3f, 53.6f, 41.66f, 56.28f);
                h.cubicTo(39.84f, 54.34f, 38.0f, 52.42f, 36.19f, 50.48f);
                h.cubicTo(41.15f, 45.64f, 44.46f, 39.07f, 44.9f, 32.11f);
                h.cubicTo(45.62f, 24.06f, 42.44f, 15.94f, 36.83f, 10.18f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-6626030);
                h = c.h(looper);
                h.moveTo(29.09f, 17.92f);
                h.cubicTo(30.73f, 16.27f, 32.37f, 14.63f, 34.02f, 12.99f);
                h.cubicTo(39.1f, 18.26f, 41.84f, 25.78f, 40.78f, 33.09f);
                h.cubicTo(40.19f, 38.61f, 37.33f, 43.62f, 33.49f, 47.54f);
                h.cubicTo(31.88f, 45.86f, 30.27f, 44.18f, 28.68f, 42.48f);
                h.cubicTo(35.5f, 36.1f, 35.71f, 24.52f, 29.09f, 17.92f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-6626030);
                h = c.h(looper);
                h.moveTo(13.42f, 19.61f);
                h.cubicTo(19.82f, 17.14f, 27.45f, 22.12f, 27.94f, 28.9f);
                h.cubicTo(28.83f, 35.53f, 22.57f, 41.8f, 15.94f, 40.95f);
                h.cubicTo(9.72f, 40.5f, 4.88f, 34.08f, 6.19f, 27.96f);
                h.cubicTo(6.92f, 24.17f, 9.75f, 20.85f, 13.42f, 19.61f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 1);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
