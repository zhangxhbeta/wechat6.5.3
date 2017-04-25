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

public final class abk extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                a.setColor(-27648);
                c = c.a(c, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(26.4f, 1.66f);
                h.cubicTo(42.28f, -1.94f, 59.61f, 8.21f, 64.37f, 23.75f);
                h.cubicTo(69.73f, 39.03f, 61.77f, 57.35f, 46.96f, 63.88f);
                h.cubicTo(32.58f, 71.02f, 13.62f, 65.47f, 5.24f, 51.82f);
                h.cubicTo(-2.86f, 39.68f, -1.34f, 22.27f, 8.7f, 11.7f);
                h.cubicTo(13.34f, 6.59f, 19.66f, 3.07f, 26.4f, 1.66f);
                h.lineTo(26.4f, 1.66f);
                h.close();
                h.moveTo(26.42f, 4.73f);
                h.cubicTo(22.56f, 5.59f, 18.89f, 7.26f, 15.66f, 9.55f);
                h.cubicTo(3.91f, 17.54f, -0.47f, 34.34f, 5.99f, 47.02f);
                h.cubicTo(12.27f, 60.81f, 29.81f, 67.79f, 43.84f, 61.97f);
                h.cubicTo(58.14f, 56.76f, 66.51f, 39.71f, 61.68f, 25.23f);
                h.cubicTo(57.54f, 10.62f, 41.2f, 1.03f, 26.42f, 4.73f);
                h.lineTo(26.42f, 4.73f);
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
