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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class wn extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-8355712);
                c = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(37.83f, 1.16f);
                h.cubicTo(38.08f, 1.4f, 38.59f, 1.9f, 38.84f, 2.14f);
                h.cubicTo(39.24f, 10.42f, 38.88f, 18.72f, 39.0f, 27.0f);
                h.cubicTo(42.66f, 26.99f, 46.33f, 27.01f, 49.99f, 27.01f);
                h.cubicTo(44.0f, 33.01f, 38.0f, 39.0f, 32.0f, 45.0f);
                h.cubicTo(26.0f, 39.0f, 20.0f, 33.01f, 14.01f, 27.0f);
                h.cubicTo(17.67f, 27.01f, 21.34f, 26.99f, 25.0f, 27.0f);
                h.cubicTo(25.12f, 18.73f, 24.77f, 10.45f, 25.16f, 2.2f);
                h.cubicTo(25.4f, 1.94f, 25.87f, 1.42f, 26.11f, 1.17f);
                h.cubicTo(30.0f, 0.87f, 33.93f, 0.86f, 37.83f, 1.16f);
                h.lineTo(37.83f, 1.16f);
                h.lineTo(37.83f, 1.16f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(1.0f, 42.0f);
                h.lineTo(8.0f, 42.0f);
                h.cubicTo(7.99f, 45.67f, 8.01f, 49.33f, 8.0f, 53.0f);
                h.lineTo(56.0f, 53.0f);
                h.cubicTo(55.99f, 49.33f, 56.01f, 45.67f, 56.0f, 42.0f);
                h.lineTo(63.0f, 42.0f);
                h.cubicTo(62.93f, 47.03f, 63.14f, 52.07f, 62.93f, 57.11f);
                h.cubicTo(63.02f, 59.09f, 60.92f, 60.29f, 59.13f, 59.99f);
                h.cubicTo(41.05f, 60.01f, 22.97f, 60.01f, 4.89f, 59.99f);
                h.cubicTo(3.1f, 60.29f, 0.95f, 59.11f, 1.07f, 57.1f);
                h.cubicTo(0.86f, 52.07f, 1.07f, 47.03f, 1.0f, 42.0f);
                h.lineTo(1.0f, 42.0f);
                h.lineTo(1.0f, 42.0f);
                h.lineTo(1.0f, 42.0f);
                h.lineTo(1.0f, 42.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
