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

public final class xv extends c {
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
                canvas.saveLayerAlpha(null, 179, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(87.28f, 0.0f);
                h.lineTo(92.51f, 0.0f);
                h.cubicTo(113.57f, 0.61f, 134.34f, 8.79f, 149.99f, 22.93f);
                h.cubicTo(168.12f, 38.95f, 179.11f, 62.56f, 180.0f, 86.72f);
                h.lineTo(180.0f, 92.68f);
                h.cubicTo(179.38f, 113.25f, 171.51f, 133.48f, 157.98f, 148.99f);
                h.cubicTo(141.79f, 167.8f, 117.59f, 179.28f, 92.78f, 180.0f);
                h.lineTo(87.53f, 180.0f);
                h.cubicTo(66.65f, 179.42f, 46.09f, 171.37f, 30.47f, 157.49f);
                h.cubicTo(12.08f, 141.44f, 0.89f, 117.65f, 0.0f, 93.27f);
                h.lineTo(0.0f, 87.28f);
                h.cubicTo(0.7f, 63.65f, 11.08f, 40.48f, 28.42f, 24.38f);
                h.cubicTo(44.21f, 9.43f, 65.56f, 0.68f, 87.28f, 0.0f);
                h.lineTo(87.28f, 0.0f);
                h.close();
                h.moveTo(78.54f, 6.79f);
                h.cubicTo(52.9f, 10.12f, 29.4f, 26.19f, 16.83f, 48.75f);
                h.cubicTo(5.72f, 68.22f, 3.03f, 92.22f, 9.41f, 113.7f);
                h.cubicTo(14.51f, 131.23f, 25.57f, 146.95f, 40.32f, 157.72f);
                h.cubicTo(54.3f, 168.06f, 71.59f, 173.82f, 88.98f, 173.98f);
                h.cubicTo(107.05f, 174.25f, 125.16f, 168.48f, 139.68f, 157.72f);
                h.cubicTo(153.56f, 147.57f, 164.19f, 133.06f, 169.63f, 116.75f);
                h.cubicTo(176.1f, 97.62f, 175.35f, 76.15f, 167.48f, 57.54f);
                h.cubicTo(160.07f, 39.76f, 146.32f, 24.72f, 129.28f, 15.75f);
                h.cubicTo(113.87f, 7.52f, 95.83f, 4.4f, 78.54f, 6.79f);
                h.lineTo(78.54f, 6.79f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(66.01f, 49.0f);
                h.cubicTo(88.67f, 62.68f, 111.34f, 76.33f, 134.0f, 90.01f);
                h.cubicTo(111.33f, 103.67f, 88.67f, 117.33f, 66.01f, 131.0f);
                h.cubicTo(66.0f, 103.67f, 66.0f, 76.34f, 66.01f, 49.0f);
                h.lineTo(66.01f, 49.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
