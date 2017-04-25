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

public final class eq extends c {
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
                g = c.a(g, looper);
                g.setColor(-8617851);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(69.0f, 73.0f);
                h.cubicTo(69.0f, 75.18871f, 67.16411f, 77.0f, 65.0f, 77.0f);
                h.lineTo(57.0f, 77.0f);
                h.lineTo(57.0f, 57.0f);
                h.lineTo(40.0f, 57.0f);
                h.lineTo(40.0f, 77.0f);
                h.lineTo(32.0f, 77.0f);
                h.cubicTo(29.835434f, 77.0f, 28.0f, 75.18871f, 28.0f, 73.0f);
                h.lineTo(28.0f, 38.0f);
                h.lineTo(49.0f, 18.0f);
                h.lineTo(69.0f, 38.0f);
                h.lineTo(69.0f, 73.0f);
                h.close();
                h.moveTo(52.0f, 9.0f);
                h.lineTo(52.0f, 9.0f);
                h.cubicTo(50.78988f, 8.532246f, 49.708397f, 8.0f, 49.0f, 8.0f);
                h.cubicTo(47.291603f, 8.0f, 46.21012f, 8.532246f, 45.0f, 9.0f);
                h.lineTo(45.0f, 9.0f);
                h.lineTo(8.0f, 47.0f);
                h.lineTo(14.0f, 53.0f);
                h.lineTo(20.0f, 46.0f);
                h.lineTo(20.0f, 73.0f);
                h.cubicTo(20.146534f, 79.55686f, 25.5868f, 85.0f, 32.0f, 85.0f);
                h.lineTo(40.0f, 85.0f);
                h.lineTo(57.0f, 85.0f);
                h.lineTo(65.0f, 85.0f);
                h.cubicTo(71.4132f, 85.0f, 76.85346f, 79.55686f, 77.0f, 73.0f);
                h.lineTo(77.0f, 46.0f);
                h.lineTo(83.0f, 53.0f);
                h.lineTo(89.0f, 47.0f);
                h.lineTo(52.0f, 9.0f);
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
