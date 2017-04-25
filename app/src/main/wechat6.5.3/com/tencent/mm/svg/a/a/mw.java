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

public final class mw extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                a.setColor(-9207928);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(64.33f, 0.0f);
                h.lineTo(70.46f, 0.0f);
                h.cubicTo(86.43f, 0.79f, 102.07f, 7.27f, 113.68f, 18.29f);
                h.cubicTo(126.44f, 30.11f, 134.1f, 47.02f, 135.0f, 64.36f);
                h.lineTo(135.0f, 70.12f);
                h.cubicTo(134.28f, 87.64f, 126.56f, 104.77f, 113.68f, 116.71f);
                h.cubicTo(102.13f, 127.69f, 86.58f, 134.14f, 70.7f, 135.0f);
                h.lineTo(64.53f, 135.0f);
                h.cubicTo(48.56f, 134.21f, 32.91f, 127.73f, 21.31f, 116.7f);
                h.cubicTo(8.45f, 104.79f, 0.76f, 87.69f, 0.0f, 70.21f);
                h.lineTo(0.0f, 64.57f);
                h.cubicTo(0.83f, 47.17f, 8.5f, 30.16f, 21.31f, 18.31f);
                h.cubicTo(32.87f, 7.31f, 48.43f, 0.86f, 64.33f, 0.0f);
                h.lineTo(64.33f, 0.0f);
                h.close();
                h.moveTo(38.3f, 45.37f);
                h.cubicTo(36.95f, 46.02f, 36.95f, 47.67f, 36.99f, 48.94f);
                h.cubicTo(37.0f, 61.3f, 37.02f, 73.65f, 36.98f, 86.01f);
                h.cubicTo(37.11f, 87.41f, 36.63f, 89.13f, 37.77f, 90.25f);
                h.cubicTo(38.88f, 91.38f, 40.6f, 90.88f, 42.0f, 91.02f);
                h.cubicTo(59.04f, 90.96f, 76.07f, 91.03f, 93.11f, 90.99f);
                h.cubicTo(94.74f, 91.22f, 96.21f, 89.68f, 95.98f, 88.06f);
                h.cubicTo(96.01f, 74.68f, 96.01f, 61.3f, 95.98f, 47.92f);
                h.cubicTo(96.22f, 46.28f, 94.7f, 44.79f, 93.07f, 45.02f);
                h.cubicTo(76.38f, 44.97f, 59.68f, 45.03f, 42.99f, 44.98f);
                h.cubicTo(41.44f, 45.11f, 39.75f, 44.69f, 38.3f, 45.37f);
                h.lineTo(38.3f, 45.37f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(42.0f, 50.0f);
                h.lineTo(91.0f, 50.0f);
                h.cubicTo(91.01f, 58.8f, 90.99f, 67.6f, 91.01f, 76.4f);
                h.cubicTo(88.58f, 72.83f, 86.13f, 68.76f, 81.95f, 67.06f);
                h.cubicTo(78.44f, 66.25f, 75.78f, 69.53f, 73.18f, 71.35f);
                h.cubicTo(73.84f, 72.68f, 74.47f, 74.03f, 75.09f, 75.39f);
                h.cubicTo(70.89f, 70.42f, 67.58f, 64.27f, 61.69f, 61.07f);
                h.cubicTo(59.23f, 59.62f, 56.51f, 61.03f, 54.45f, 62.49f);
                h.cubicTo(49.5f, 65.99f, 45.24f, 70.47f, 41.98f, 75.59f);
                h.cubicTo(42.02f, 67.06f, 41.99f, 58.53f, 42.0f, 50.0f);
                h.lineTo(42.0f, 50.0f);
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
