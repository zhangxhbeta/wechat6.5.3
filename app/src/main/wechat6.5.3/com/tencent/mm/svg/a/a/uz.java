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

public final class uz extends c {
    private final int height = 84;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                Paint a = c.a(g, looper);
                a.setColor(-12206054);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 16.9f, 0.0f, 1.0f, 11.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(24.496f, 1.694f);
                h.cubicTo(27.29f, 0.163f, 30.624f, -0.37f, 33.751f, 0.264f);
                h.cubicTo(36.855f, 0.865f, 39.674f, 2.588f, 41.815f, 4.89f);
                h.cubicTo(44.433f, 7.703f, 46.105f, 11.33f, 46.761f, 15.102f);
                h.cubicTo(47.716f, 20.528f, 46.661f, 26.362f, 43.544f, 30.943f);
                h.cubicTo(42.692f, 32.194f, 41.686f, 33.342f, 40.546f, 34.339f);
                h.cubicTo(40.051f, 34.793f, 39.54f, 35.269f, 39.254f, 35.889f);
                h.cubicTo(39.036f, 36.362f, 39.113f, 36.896f, 39.1f, 37.401f);
                h.cubicTo(39.108f, 37.778f, 39.039f, 38.197f, 39.274f, 38.525f);
                h.cubicTo(39.747f, 39.23f, 40.511f, 39.656f, 41.225f, 40.079f);
                h.cubicTo(46.19f, 43.181f, 51.155f, 46.285f, 56.12f, 49.388f);
                h.cubicTo(56.386f, 49.557f, 56.652f, 49.73f, 56.941f, 49.862f);
                h.cubicTo(58.565f, 50.625f, 59.95f, 51.889f, 60.857f, 53.438f);
                h.cubicTo(61.652f, 54.781f, 62.084f, 56.336f, 62.098f, 57.897f);
                h.cubicTo(62.103f, 59.264f, 62.098f, 60.632f, 62.1f, 62.0f);
                h.lineTo(0.1f, 62.0f);
                h.cubicTo(0.101f, 60.632f, 0.098f, 59.265f, 0.101f, 57.898f);
                h.cubicTo(0.118f, 56.073f, 0.708f, 54.26f, 1.772f, 52.777f);
                h.cubicTo(2.712f, 51.443f, 4.034f, 50.401f, 5.517f, 49.733f);
                h.cubicTo(10.635f, 46.55f, 15.741f, 43.345f, 20.855f, 40.154f);
                h.cubicTo(21.542f, 39.728f, 22.232f, 39.279f, 22.774f, 38.671f);
                h.cubicTo(22.988f, 38.436f, 23.139f, 38.131f, 23.102f, 37.805f);
                h.cubicTo(23.061f, 37.112f, 23.229f, 36.357f, 22.865f, 35.725f);
                h.cubicTo(22.432f, 34.954f, 21.711f, 34.416f, 21.083f, 33.815f);
                h.cubicTo(18.607f, 31.451f, 16.873f, 28.367f, 15.939f, 25.086f);
                h.cubicTo(14.334f, 19.407f, 15.024f, 13.05f, 18.073f, 7.967f);
                h.cubicTo(19.632f, 5.377f, 21.82f, 3.129f, 24.496f, 1.694f);
                h.lineTo(24.496f, 1.694f);
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
