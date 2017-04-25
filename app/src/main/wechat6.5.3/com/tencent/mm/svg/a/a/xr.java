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

public final class xr extends c {
    private final int height = 44;
    private final int width = 44;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 44;
            case 1:
                return 44;
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
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a = c.a(g, looper);
                a.setColor(-2236963);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(21.0f, 0.02f);
                h.cubicTo(23.3f, 4.18f, 25.62f, 8.33f, 27.86f, 12.53f);
                h.cubicTo(32.55f, 13.51f, 37.27f, 14.36f, 41.98f, 15.27f);
                h.cubicTo(38.77f, 18.7f, 35.63f, 22.2f, 32.3f, 25.52f);
                h.cubicTo(32.59f, 30.38f, 33.47f, 35.17f, 33.97f, 40.0f);
                h.cubicTo(29.65f, 37.97f, 25.33f, 35.93f, 21.0f, 33.91f);
                h.cubicTo(16.67f, 35.93f, 12.35f, 37.97f, 8.03f, 40.0f);
                h.cubicTo(8.54f, 35.18f, 9.38f, 30.39f, 9.71f, 25.56f);
                h.cubicTo(6.39f, 22.22f, 3.24f, 18.7f, 0.01f, 15.28f);
                h.cubicTo(4.72f, 14.34f, 9.47f, 13.54f, 14.16f, 12.5f);
                h.cubicTo(16.38f, 8.31f, 18.72f, 4.18f, 21.0f, 0.02f);
                h.lineTo(21.0f, 0.02f);
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
