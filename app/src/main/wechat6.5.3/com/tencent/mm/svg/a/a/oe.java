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

public final class oe extends c {
    private final int height = 72;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 72;
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
                a.setColor(-2171170);
                Path h = c.h(looper);
                h.moveTo(10.02f, 4.03f);
                h.cubicTo(16.37f, -0.03f, 25.25f, 2.32f, 30.0f, 7.82f);
                h.cubicTo(34.75f, 2.31f, 43.65f, -0.03f, 50.0f, 4.04f);
                h.cubicTo(56.64f, 8.75f, 57.4f, 18.37f, 54.62f, 25.46f);
                h.cubicTo(49.99f, 36.69f, 40.55f, 45.38f, 30.0f, 51.04f);
                h.cubicTo(19.44f, 45.38f, 10.0f, 36.68f, 5.38f, 25.44f);
                h.cubicTo(2.59f, 18.35f, 3.37f, 8.73f, 10.02f, 4.03f);
                h.moveTo(10.78f, 12.53f);
                h.cubicTo(9.05f, 17.39f, 9.87f, 23.01f, 12.63f, 27.35f);
                h.cubicTo(16.91f, 34.26f, 23.39f, 39.46f, 30.0f, 44.02f);
                h.cubicTo(35.84f, 40.01f, 41.47f, 35.49f, 45.75f, 29.79f);
                h.cubicTo(48.53f, 26.15f, 50.43f, 21.67f, 50.08f, 17.01f);
                h.cubicTo(50.12f, 13.43f, 48.4f, 9.15f, 44.52f, 8.35f);
                h.cubicTo(38.67f, 6.6f, 34.27f, 11.91f, 30.0f, 14.96f);
                h.cubicTo(26.8f, 12.47f, 23.72f, 9.6f, 19.86f, 8.15f);
                h.cubicTo(16.34f, 7.44f, 12.05f, 8.89f, 10.78f, 12.53f);
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
