package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class zp extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(57.74f, 0.0f);
                h.lineTo(61.88f, 0.0f);
                h.cubicTo(76.5f, 0.47f, 90.87f, 6.44f, 101.42f, 16.6f);
                h.cubicTo(112.63f, 27.2f, 119.36f, 42.25f, 120.0f, 57.65f);
                h.lineTo(120.0f, 62.03f);
                h.cubicTo(119.47f, 77.56f, 112.7f, 92.75f, 101.39f, 103.42f);
                h.cubicTo(90.95f, 113.49f, 76.75f, 119.41f, 62.28f, 120.0f);
                h.lineTo(58.1f, 120.0f);
                h.cubicTo(42.07f, 119.5f, 26.38f, 112.32f, 15.65f, 100.39f);
                h.cubicTo(6.15f, 90.08f, 0.61f, 76.34f, 0.0f, 62.36f);
                h.lineTo(0.0f, 57.99f);
                h.cubicTo(0.53f, 42.26f, 7.48f, 26.86f, 19.05f, 16.16f);
                h.cubicTo(29.45f, 6.34f, 43.46f, 0.59f, 57.74f, 0.0f);
                h.lineTo(57.74f, 0.0f);
                h.close();
                h.moveTo(50.53f, 4.81f);
                h.cubicTo(34.94f, 7.39f, 20.71f, 17.0f, 12.43f, 30.46f);
                h.cubicTo(4.17f, 43.58f, 1.85f, 60.21f, 6.07f, 75.11f);
                h.cubicTo(9.83f, 88.74f, 19.02f, 100.74f, 31.15f, 108.0f);
                h.cubicTo(44.42f, 116.08f, 61.13f, 118.16f, 76.0f, 113.67f);
                h.cubicTo(89.73f, 109.64f, 101.71f, 100.06f, 108.73f, 87.6f);
                h.cubicTo(115.52f, 75.74f, 117.64f, 61.35f, 114.7f, 48.02f);
                h.cubicTo(111.63f, 33.64f, 102.57f, 20.7f, 90.16f, 12.83f);
                h.cubicTo(78.57f, 5.32f, 64.13f, 2.44f, 50.53f, 4.81f);
                h.lineTo(50.53f, 4.81f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(42.0f, 32.01f);
                h.cubicTo(57.32f, 41.34f, 72.66f, 50.64f, 87.97f, 60.0f);
                h.cubicTo(72.67f, 69.37f, 57.32f, 78.66f, 42.01f, 88.0f);
                h.cubicTo(42.0f, 69.33f, 42.0f, 50.67f, 42.0f, 32.01f);
                h.lineTo(42.0f, 32.01f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
