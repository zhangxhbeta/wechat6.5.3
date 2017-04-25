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

public final class km extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-2565928);
                c = c.a(c, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(18.11f, 25.83f);
                h.cubicTo(26.56f, 17.39f, 35.0f, 8.92f, 43.47f, 0.49f);
                h.cubicTo(44.61f, 1.63f, 45.83f, 2.71f, 46.84f, 3.98f);
                h.cubicTo(46.51f, 5.07f, 45.35f, 5.72f, 44.65f, 6.58f);
                h.cubicTo(35.76f, 15.37f, 26.97f, 24.25f, 18.11f, 33.07f);
                h.cubicTo(12.07f, 27.04f, 6.03f, 21.01f, 0.0f, 14.97f);
                h.cubicTo(1.21f, 13.76f, 2.42f, 12.56f, 3.62f, 11.35f);
                h.cubicTo(8.45f, 16.18f, 13.28f, 21.01f, 18.11f, 25.83f);
                h.lineTo(18.11f, 25.83f);
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
