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

public final class aag extends c {
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
                a.setColor(-5592406);
                c = c.a(c, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(3.35f, 12.4f);
                h.cubicTo(7.25f, 5.36f, 14.93f, 0.63f, 22.96f, 0.27f);
                h.cubicTo(31.48f, -0.27f, 40.05f, 4.2f, 44.53f, 11.46f);
                h.cubicTo(49.92f, 19.74f, 49.24f, 31.19f, 43.22f, 38.97f);
                h.cubicTo(48.42f, 44.2f, 53.65f, 49.4f, 58.86f, 54.62f);
                h.cubicTo(57.46f, 56.07f, 56.03f, 57.5f, 54.53f, 58.84f);
                h.cubicTo(49.4f, 53.57f, 44.14f, 48.41f, 38.95f, 43.2f);
                h.cubicTo(34.16f, 46.84f, 28.05f, 48.71f, 22.04f, 48.11f);
                h.cubicTo(13.48f, 47.41f, 5.55f, 41.7f, 2.22f, 33.77f);
                h.cubicTo(-0.77f, 26.99f, -0.35f, 18.82f, 3.35f, 12.4f);
                h.lineTo(3.35f, 12.4f);
                h.close();
                h.moveTo(22.25f, 6.34f);
                h.cubicTo(12.73f, 7.14f, 5.11f, 16.55f, 6.33f, 26.04f);
                h.cubicTo(7.03f, 35.6f, 16.43f, 43.3f, 25.94f, 42.13f);
                h.cubicTo(35.7f, 41.45f, 43.55f, 31.72f, 42.08f, 22.03f);
                h.cubicTo(41.15f, 12.55f, 31.71f, 5.05f, 22.25f, 6.34f);
                h.lineTo(22.25f, 6.34f);
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
