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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class xx extends c {
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
                a.setColor(-9276814);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(33.9f, 0.0f);
                h.lineTo(38.04f, 0.0f);
                h.cubicTo(46.52f, 0.64f, 54.84f, 4.06f, 60.93f, 10.05f);
                h.cubicTo(67.46f, 16.26f, 71.4f, 24.96f, 72.0f, 33.92f);
                h.lineTo(72.0f, 38.04f);
                h.cubicTo(71.41f, 47.03f, 67.47f, 55.74f, 60.93f, 61.95f);
                h.cubicTo(54.9f, 67.87f, 46.7f, 71.29f, 38.32f, 72.0f);
                h.lineTo(33.95f, 72.0f);
                h.cubicTo(25.01f, 71.39f, 16.3f, 67.52f, 10.12f, 61.0f);
                h.cubicTo(4.16f, 54.92f, 0.64f, 46.69f, 0.0f, 38.23f);
                h.lineTo(0.0f, 33.93f);
                h.cubicTo(0.66f, 23.3f, 6.2f, 13.1f, 14.85f, 6.87f);
                h.cubicTo(20.36f, 2.78f, 27.09f, 0.58f, 33.9f, 0.0f);
                h.lineTo(33.9f, 0.0f);
                h.close();
                h.moveTo(29.45f, 3.65f);
                h.cubicTo(21.99f, 5.18f, 15.07f, 9.34f, 10.31f, 15.3f);
                h.cubicTo(1.3f, 26.14f, 0.57f, 42.84f, 8.63f, 54.42f);
                h.cubicTo(17.32f, 67.89f, 36.42f, 73.03f, 50.65f, 65.55f);
                h.cubicTo(65.31f, 58.67f, 72.85f, 40.15f, 67.11f, 24.99f);
                h.cubicTo(62.07f, 9.86f, 45.05f, 0.15f, 29.45f, 3.65f);
                h.lineTo(29.45f, 3.65f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(26.01f, 19.02f);
                h.cubicTo(35.34f, 24.67f, 44.66f, 30.33f, 53.98f, 36.0f);
                h.cubicTo(44.68f, 41.69f, 35.33f, 47.31f, 26.03f, 53.0f);
                h.cubicTo(25.97f, 41.67f, 26.01f, 30.34f, 26.01f, 19.02f);
                h.lineTo(26.01f, 19.02f);
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
