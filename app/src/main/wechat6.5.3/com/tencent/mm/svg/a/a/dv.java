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

public final class dv extends c {
    private final int height = 144;
    private final int width = 144;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                a.setColor(-9276814);
                Path h = c.h(looper);
                h.moveTo(90.0f, 38.572f);
                h.cubicTo(90.0f, 40.466f, 91.536f, 42.0f, 93.428f, 42.0f);
                h.lineTo(122.0f, 42.0f);
                h.lineTo(90.0f, 10.0f);
                h.lineTo(90.0f, 38.572f);
                h.lineTo(90.0f, 38.572f);
                h.close();
                h.moveTo(84.0f, 10.0f);
                h.lineTo(40.0f, 10.0f);
                h.cubicTo(36.686f, 10.0f, 34.0f, 12.686f, 34.0f, 16.0f);
                h.lineTo(34.0f, 116.0f);
                h.cubicTo(34.0f, 119.314f, 36.686f, 122.0f, 40.0f, 122.0f);
                h.lineTo(116.0f, 122.0f);
                h.cubicTo(119.314f, 122.0f, 122.0f, 119.314f, 122.0f, 116.0f);
                h.lineTo(122.0f, 48.0f);
                h.lineTo(90.0f, 48.0f);
                h.cubicTo(86.686f, 48.002f, 84.0f, 45.316f, 84.0f, 42.0f);
                h.lineTo(84.0f, 10.0f);
                h.close();
                h.moveTo(28.0f, 34.0f);
                h.cubicTo(24.686f, 34.0f, 22.0f, 36.686f, 22.0f, 40.0f);
                h.lineTo(22.0f, 128.0f);
                h.cubicTo(22.0f, 131.314f, 24.686f, 134.0f, 28.0f, 134.0f);
                h.lineTo(96.0f, 134.0f);
                h.cubicTo(99.314f, 134.0f, 102.0f, 131.314f, 102.0f, 128.0f);
                h.lineTo(34.0f, 128.0f);
                h.cubicTo(30.686f, 128.0f, 28.0f, 125.314f, 28.0f, 122.0f);
                h.lineTo(28.0f, 34.0f);
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
