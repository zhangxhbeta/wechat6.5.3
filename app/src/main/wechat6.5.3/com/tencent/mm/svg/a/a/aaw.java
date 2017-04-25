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

public final class aaw extends c {
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
                float[] a = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-1);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(26.43f, 1.68f);
                h.cubicTo(41.46f, -1.69f, 57.9f, 7.14f, 63.51f, 21.45f);
                h.cubicTo(69.44f, 35.22f, 64.39f, 52.55f, 51.99f, 60.97f);
                h.cubicTo(39.83f, 69.86f, 21.65f, 68.7f, 10.73f, 58.32f);
                h.cubicTo(-0.37f, 48.51f, -3.25f, 30.94f, 4.11f, 18.1f);
                h.cubicTo(8.68f, 9.71f, 17.05f, 3.53f, 26.43f, 1.68f);
                h.lineTo(26.43f, 1.68f);
                h.close();
                h.moveTo(20.27f, 23.38f);
                h.cubicTo(23.8f, 26.93f, 27.34f, 30.45f, 30.87f, 34.0f);
                h.cubicTo(27.35f, 37.54f, 23.8f, 41.06f, 20.28f, 44.61f);
                h.cubicTo(20.8f, 45.14f, 21.86f, 46.2f, 22.38f, 46.73f);
                h.cubicTo(25.94f, 43.21f, 29.45f, 39.65f, 33.0f, 36.13f);
                h.cubicTo(36.55f, 39.66f, 40.07f, 43.21f, 43.62f, 46.73f);
                h.cubicTo(44.14f, 46.2f, 45.2f, 45.14f, 45.72f, 44.61f);
                h.cubicTo(42.2f, 41.06f, 38.65f, 37.54f, 35.13f, 34.0f);
                h.cubicTo(38.65f, 30.46f, 42.2f, 26.93f, 45.73f, 23.39f);
                h.cubicTo(45.2f, 22.86f, 44.14f, 21.8f, 43.61f, 21.28f);
                h.cubicTo(40.06f, 24.79f, 36.55f, 28.35f, 33.0f, 31.87f);
                h.cubicTo(29.46f, 28.34f, 25.93f, 24.8f, 22.39f, 21.27f);
                h.cubicTo(21.86f, 21.8f, 20.8f, 22.86f, 20.27f, 23.38f);
                h.lineTo(20.27f, 23.38f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                c = c.a(a, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(0.27f, 2.38f);
                h.cubicTo(0.8f, 1.86f, 1.86f, 0.8f, 2.39f, 0.27f);
                h.cubicTo(5.93f, 3.8f, 9.46f, 7.34f, 13.0f, 10.87f);
                h.cubicTo(16.55f, 7.35f, 20.06f, 3.79f, 23.61f, 0.28f);
                h.cubicTo(24.14f, 0.8f, 25.2f, 1.86f, 25.73f, 2.39f);
                h.cubicTo(22.2f, 5.93f, 18.65f, 9.46f, 15.13f, 13.0f);
                h.cubicTo(18.65f, 16.54f, 22.2f, 20.06f, 25.72f, 23.61f);
                h.cubicTo(25.2f, 24.14f, 24.14f, 25.2f, 23.62f, 25.73f);
                h.cubicTo(20.07f, 22.21f, 16.55f, 18.66f, 13.0f, 15.13f);
                h.cubicTo(9.45f, 18.65f, 5.94f, 22.21f, 2.38f, 25.73f);
                h.cubicTo(1.86f, 25.2f, 0.8f, 24.14f, 0.28f, 23.61f);
                h.cubicTo(3.8f, 20.06f, 7.35f, 16.54f, 10.87f, 13.0f);
                h.cubicTo(7.34f, 9.45f, 3.8f, 5.93f, 0.27f, 2.38f);
                h.lineTo(0.27f, 2.38f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
