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

public final class os extends c {
    private final int height = 40;
    private final int width = 40;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                a.setColor(-6710887);
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(10.040016f, 6.321322f);
                h.cubicTo(18.930199f, 4.4244156f, 27.83037f, 2.5874112f, 36.780487f, 1.0f);
                h.cubicTo(37.170055f, 9.995331f, 36.92033f, 19.020613f, 36.93032f, 28.025927f);
                h.cubicTo(36.83043f, 33.047737f, 29.95802f, 34.515343f, 26.801506f, 31.31057f);
                h.cubicTo(25.263205f, 29.473566f, 25.962433f, 26.388596f, 27.980204f, 25.200533f);
                h.cubicTo(30.037931f, 23.812798f, 32.625076f, 24.072374f, 34.97248f, 23.962553f);
                h.lineTo(34.97248f, 7.2398243f);
                h.cubicTo(27.310944f, 8.767333f, 19.659393f, 10.304826f, 11.997854f, 11.8323345f);
                h.cubicTo(11.8979645f, 19.180351f, 12.187645f, 26.528368f, 11.867998f, 33.8664f);
                h.cubicTo(11.06888f, 39.277576f, 1.319647f, 39.477253f, 1.0f, 33.8664f);
                h.cubicTo(1.0799117f, 29.293858f, 6.5238996f, 28.73477f, 10.000061f, 28.954412f);
                h.cubicTo(10.020039f, 21.406721f, 9.960105f, 13.85903f, 10.040016f, 6.321322f);
                h.lineTo(10.040016f, 6.321322f);
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
