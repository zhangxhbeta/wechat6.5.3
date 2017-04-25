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

public final class xz extends c {
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
                h.moveTo(33.94f, 0.0f);
                h.lineTo(37.86f, 0.0f);
                h.cubicTo(45.96f, 0.56f, 53.93f, 3.66f, 59.96f, 9.15f);
                h.cubicTo(67.07f, 15.44f, 71.42f, 24.59f, 72.0f, 34.05f);
                h.lineTo(72.0f, 37.83f);
                h.cubicTo(71.46f, 47.59f, 66.85f, 57.03f, 59.39f, 63.35f);
                h.cubicTo(53.54f, 68.46f, 45.97f, 71.35f, 38.26f, 72.0f);
                h.lineTo(34.11f, 72.0f);
                h.cubicTo(25.1f, 71.45f, 16.32f, 67.55f, 10.09f, 60.97f);
                h.cubicTo(4.16f, 54.9f, 0.65f, 46.69f, 0.0f, 38.25f);
                h.lineTo(0.0f, 34.13f);
                h.cubicTo(0.55f, 24.37f, 5.18f, 14.93f, 12.65f, 8.61f);
                h.cubicTo(18.55f, 3.47f, 26.18f, 0.61f, 33.94f, 0.0f);
                h.lineTo(33.94f, 0.0f);
                h.close();
                h.moveTo(29.4f, 3.66f);
                h.cubicTo(23.12f, 4.97f, 17.2f, 8.12f, 12.68f, 12.67f);
                h.cubicTo(2.03f, 22.96f, -0.12f, 40.65f, 7.83f, 53.16f);
                h.cubicTo(16.0f, 67.24f, 35.31f, 73.15f, 49.93f, 65.9f);
                h.cubicTo(64.75f, 59.37f, 72.74f, 41.04f, 67.36f, 25.73f);
                h.cubicTo(62.61f, 10.2f, 45.28f, 0.06f, 29.4f, 3.66f);
                h.lineTo(29.4f, 3.66f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(24.0f, 24.0f);
                h2.lineTo(48.0f, 24.0f);
                h2.lineTo(48.0f, 48.0f);
                h2.lineTo(24.0f, 48.0f);
                h2.lineTo(24.0f, 24.0f);
                h2.lineTo(24.0f, 24.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
