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

public final class xu extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                h.moveTo(87.2f, 0.0f);
                h.lineTo(92.22f, 0.0f);
                h.cubicTo(113.42f, 0.53f, 134.32f, 8.75f, 150.06f, 22.99f);
                h.cubicTo(168.44f, 39.28f, 179.52f, 63.39f, 180.0f, 87.94f);
                h.lineTo(180.0f, 92.07f);
                h.cubicTo(179.55f, 113.06f, 171.47f, 133.75f, 157.55f, 149.48f);
                h.cubicTo(141.39f, 167.99f, 117.4f, 179.26f, 92.84f, 180.0f);
                h.lineTo(87.55f, 180.0f);
                h.cubicTo(65.97f, 179.42f, 44.72f, 170.82f, 28.92f, 156.09f);
                h.cubicTo(11.34f, 140.02f, 0.77f, 116.72f, 0.0f, 92.92f);
                h.lineTo(0.0f, 87.36f);
                h.cubicTo(0.68f, 63.01f, 11.7f, 39.15f, 29.95f, 22.98f);
                h.cubicTo(45.54f, 8.88f, 66.21f, 0.69f, 87.2f, 0.0f);
                h.lineTo(87.2f, 0.0f);
                h.close();
                h.moveTo(78.51f, 6.8f);
                h.cubicTo(52.12f, 10.22f, 28.04f, 27.17f, 15.74f, 50.74f);
                h.cubicTo(5.37f, 70.12f, 3.19f, 93.65f, 9.69f, 114.64f);
                h.cubicTo(14.98f, 132.03f, 26.14f, 147.55f, 40.91f, 158.15f);
                h.cubicTo(55.33f, 168.63f, 73.18f, 174.25f, 91.01f, 173.98f);
                h.cubicTo(108.18f, 173.82f, 125.27f, 168.21f, 139.16f, 158.1f);
                h.cubicTo(153.28f, 147.95f, 164.1f, 133.29f, 169.62f, 116.8f);
                h.cubicTo(176.01f, 97.92f, 175.37f, 76.76f, 167.8f, 58.32f);
                h.cubicTo(160.56f, 40.44f, 146.93f, 25.24f, 129.94f, 16.11f);
                h.cubicTo(114.38f, 7.61f, 96.07f, 4.36f, 78.51f, 6.8f);
                h.lineTo(78.51f, 6.8f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(66.0f, 49.0f);
                h.cubicTo(88.66f, 62.67f, 111.34f, 76.33f, 134.0f, 90.01f);
                h.cubicTo(111.33f, 103.67f, 88.66f, 117.33f, 66.0f, 131.01f);
                h.lineTo(66.0f, 49.0f);
                h.lineTo(66.0f, 49.0f);
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
