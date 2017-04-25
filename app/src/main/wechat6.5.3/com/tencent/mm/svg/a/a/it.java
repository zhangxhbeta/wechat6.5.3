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

public final class it extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-16384);
                float[] a2 = c.a(c, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 7.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(22.179684f, 20.160744f);
                h.cubicTo(25.258177f, 13.424428f, 28.385149f, 6.712214f, 31.48788f, 0.0f);
                h.cubicTo(34.69969f, 6.6881127f, 37.729702f, 13.4726305f, 40.893036f, 20.196896f);
                h.cubicTo(48.262024f, 20.67892f, 55.631012f, 21.160948f, 63.0f, 21.655024f);
                h.cubicTo(57.63082f, 26.53554f, 52.18892f, 31.34375f, 46.84398f, 36.248367f);
                h.cubicTo(48.552906f, 43.828228f, 50.24971f, 51.40809f, 51.946518f, 58.98795f);
                h.cubicTo(45.13505f, 55.228146f, 38.335705f, 51.44424f, 31.51212f, 47.708538f);
                h.cubicTo(24.688534f, 51.45629f, 17.889189f, 55.228146f, 11.077723f, 59.0f);
                h.cubicTo(12.7745285f, 51.40809f, 14.483455f, 43.828228f, 16.180262f, 36.248367f);
                h.cubicTo(11.041362f, 31.596813f, 5.963063f, 26.897058f, 0.7029627f, 22.390114f);
                h.cubicTo(0.53328204f, 22.390114f, 0.1818007f, 22.378063f, 0.0f, 22.366013f);
                h.lineTo(0.0f, 22.064747f);
                h.cubicTo(7.3083878f, 20.739176f, 14.798576f, 20.895834f, 22.179684f, 20.160744f);
                h.lineTo(22.179684f, 20.160744f);
                h.lineTo(22.179684f, 20.160744f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a2, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 29.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(6.06f, 1.52f);
                h.cubicTo(13.81f, 1.24f, 21.54f, 0.83f, 29.28f, 0.5f);
                h.cubicTo(22.8f, 6.15f, 16.29f, 11.75f, 9.81f, 17.4f);
                h.lineTo(28.01f, 17.4f);
                h.cubicTo(28.01f, 17.72f, 28.0f, 18.38f, 28.0f, 18.71f);
                h.cubicTo(19.33f, 19.12f, 10.67f, 19.57f, 2.0f, 19.99f);
                h.cubicTo(8.51f, 14.35f, 15.02f, 8.71f, 21.53f, 3.07f);
                h.cubicTo(14.37f, 2.95f, 7.21f, 3.31f, 0.07f, 2.85f);
                h.cubicTo(1.78f, 1.46f, 4.0f, 1.65f, 6.06f, 1.52f);
                h.lineTo(6.06f, 1.52f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
