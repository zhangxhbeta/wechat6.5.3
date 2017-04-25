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

public final class ec extends c {
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
                h.moveTo(88.0f, 74.0f);
                h.lineTo(88.0f, 74.0f);
                h.lineTo(56.0f, 15.0f);
                h.lineTo(56.0f, 15.0f);
                h.cubicTo(54.97f, 11.577649f, 51.78977f, 9.0f, 48.0f, 9.0f);
                h.cubicTo(44.21023f, 9.0f, 41.029545f, 11.577649f, 40.0f, 15.0f);
                h.lineTo(40.0f, 15.0f);
                h.lineTo(8.0f, 74.0f);
                h.lineTo(8.0f, 74.0f);
                h.cubicTo(7.5070333f, 75.54358f, 7.0f, 77.10677f, 7.0f, 79.0f);
                h.cubicTo(7.0f, 83.32397f, 10.671322f, 87.0f, 15.0f, 87.0f);
                h.cubicTo(15.497933f, 87.0f, 15.791311f, 86.98221f, 16.0f, 87.0f);
                h.lineTo(16.0f, 87.0f);
                h.lineTo(48.0f, 87.0f);
                h.lineTo(48.0f, 79.0f);
                h.lineTo(44.0f, 79.0f);
                h.lineTo(44.0f, 71.0f);
                h.lineTo(48.0f, 71.0f);
                h.lineTo(48.0f, 62.0f);
                h.lineTo(44.0f, 62.0f);
                h.lineTo(42.0f, 34.0f);
                h.lineTo(48.0f, 34.0f);
                h.lineTo(48.0f, 25.0f);
                h.lineTo(48.0f, 25.0f);
                h.lineTo(48.0f, 25.0f);
                h.lineTo(48.0f, 34.0f);
                h.lineTo(54.0f, 34.0f);
                h.lineTo(52.0f, 62.0f);
                h.lineTo(48.0f, 62.0f);
                h.lineTo(48.0f, 71.0f);
                h.lineTo(52.0f, 71.0f);
                h.lineTo(52.0f, 79.0f);
                h.lineTo(48.0f, 79.0f);
                h.lineTo(48.0f, 87.0f);
                h.lineTo(80.0f, 87.0f);
                h.lineTo(80.0f, 87.0f);
                h.cubicTo(80.20824f, 86.98221f, 80.50207f, 87.0f, 81.0f, 87.0f);
                h.cubicTo(85.328674f, 87.0f, 89.0f, 83.32397f, 89.0f, 79.0f);
                h.cubicTo(89.0f, 77.10677f, 88.49251f, 75.54358f, 88.0f, 74.0f);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
