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

public final class zh extends c {
    private final int height = 270;
    private final int width = 270;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
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
                g = c.a(g, looper);
                g.setColor(-12601288);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(131.16f, 0.0f);
                h.lineTo(138.59f, 0.0f);
                h.cubicTo(169.69f, 0.83f, 200.36f, 12.7f, 223.71f, 33.28f);
                h.cubicTo(251.77f, 57.44f, 268.83f, 93.6f, 270.0f, 130.59f);
                h.lineTo(270.0f, 137.53f);
                h.cubicTo(269.48f, 168.53f, 257.86f, 199.15f, 237.66f, 222.67f);
                h.cubicTo(213.11f, 251.69f, 175.86f, 269.39f, 137.83f, 270.0f);
                h.lineTo(132.41f, 270.0f);
                h.cubicTo(106.69f, 269.5f, 81.14f, 261.55f, 59.82f, 247.12f);
                h.cubicTo(35.24f, 230.72f, 16.33f, 205.99f, 7.01f, 177.95f);
                h.cubicTo(2.53f, 164.82f, 0.31f, 150.97f, 0.0f, 137.13f);
                h.lineTo(0.0f, 133.07f);
                h.cubicTo(0.36f, 94.51f, 18.29f, 56.6f, 47.89f, 31.9f);
                h.cubicTo(70.96f, 12.2f, 100.85f, 0.89f, 131.16f, 0.0f);
                h.lineTo(131.16f, 0.0f);
                h.close();
                h.moveTo(203.02f, 82.05f);
                h.cubicTo(171.35f, 113.7f, 139.71f, 145.38f, 108.03f, 177.02f);
                h.cubicTo(95.98f, 165.08f, 84.03f, 153.03f, 72.01f, 141.05f);
                h.cubicTo(71.22f, 140.01f, 69.44f, 139.34f, 68.41f, 140.39f);
                h.cubicTo(65.92f, 142.65f, 63.6f, 145.1f, 61.23f, 147.49f);
                h.cubicTo(59.98f, 148.45f, 60.3f, 150.46f, 61.49f, 151.33f);
                h.cubicTo(76.33f, 166.21f, 91.18f, 181.09f, 106.08f, 195.91f);
                h.cubicTo(107.0f, 197.16f, 108.96f, 197.19f, 109.91f, 195.94f);
                h.cubicTo(144.3f, 161.65f, 178.59f, 127.26f, 212.96f, 92.94f);
                h.cubicTo(214.03f, 91.97f, 215.05f, 90.77f, 214.44f, 89.23f);
                h.cubicTo(211.96f, 86.51f, 209.35f, 83.91f, 206.66f, 81.41f);
                h.cubicTo(205.59f, 80.26f, 203.84f, 81.02f, 203.02f, 82.05f);
                h.lineTo(203.02f, 82.05f);
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
