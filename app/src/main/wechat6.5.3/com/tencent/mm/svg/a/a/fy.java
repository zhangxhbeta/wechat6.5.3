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

public final class fy extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3289392);
                Path h = c.h(looper);
                h.moveTo(17.0f, 48.02f);
                h.cubicTo(27.66f, 37.34f, 38.34f, 26.66f, 49.02f, 16.0f);
                h.cubicTo(50.92f, 17.88f, 52.82f, 19.78f, 54.7f, 21.68f);
                h.cubicTo(47.27f, 29.13f, 39.82f, 36.56f, 32.39f, 44.01f);
                h.cubicTo(48.6f, 44.03f, 64.81f, 44.01f, 81.02f, 44.02f);
                h.cubicTo(81.02f, 46.71f, 81.02f, 49.39f, 81.01f, 52.08f);
                h.cubicTo(64.83f, 52.1f, 48.64f, 52.07f, 32.45f, 52.09f);
                h.cubicTo(39.86f, 59.52f, 47.29f, 66.93f, 54.7f, 74.36f);
                h.cubicTo(52.82f, 76.26f, 50.92f, 78.16f, 49.02f, 80.04f);
                h.cubicTo(38.34f, 69.38f, 27.66f, 58.7f, 17.0f, 48.02f);
                h.lineTo(17.0f, 48.02f);
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
