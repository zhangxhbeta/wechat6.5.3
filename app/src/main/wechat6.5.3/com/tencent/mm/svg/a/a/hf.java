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

public final class hf extends c {
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 26.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(7.54f, 0.56f);
                h.cubicTo(9.03f, -0.52f, 11.01f, 0.49f, 11.71f, 2.02f);
                h.cubicTo(12.07f, 3.88f, 10.53f, 5.18f, 9.6f, 6.56f);
                h.cubicTo(5.87f, 11.22f, 4.8f, 17.83f, 6.84f, 23.44f);
                h.cubicTo(7.6f, 25.87f, 9.29f, 27.83f, 10.47f, 30.05f);
                h.cubicTo(11.03f, 31.94f, 9.0f, 33.56f, 7.24f, 32.92f);
                h.cubicTo(-1.92f, 24.68f, -1.65f, 8.7f, 7.54f, 0.56f);
                h.lineTo(7.54f, 0.56f);
                h.lineTo(7.54f, 0.56f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(16.63f, 7.39f);
                h.cubicTo(18.52f, 5.6f, 22.11f, 7.44f, 21.66f, 10.01f);
                h.cubicTo(21.07f, 12.61f, 18.21f, 14.23f, 18.25f, 17.08f);
                h.cubicTo(17.82f, 19.77f, 20.27f, 21.5f, 20.98f, 23.86f);
                h.cubicTo(21.37f, 26.54f, 17.58f, 28.31f, 15.8f, 26.27f);
                h.cubicTo(11.33f, 20.87f, 12.03f, 12.48f, 16.63f, 7.39f);
                h.lineTo(16.63f, 7.39f);
                h.lineTo(16.63f, 7.39f);
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
