package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class zf extends c {
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
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                a.setColor(-1315861);
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(171.0f, 90.18926f);
                h.lineTo(171.0f, 9.032258f);
                h.lineTo(9.0f, 9.032258f);
                h.lineTo(9.0f, 89.96034f);
                h.lineTo(60.553738f, 41.65066f);
                h.lineTo(121.92021f, 98.15694f);
                h.lineTo(113.13358f, 80.02691f);
                h.lineTo(138.16164f, 60.600388f);
                h.lineTo(171.0f, 90.18926f);
                h.lineTo(171.0f, 90.18926f);
                h.lineTo(171.0f, 90.18926f);
                h.close();
                h.moveTo(4.494371f, 0.0f);
                h.cubicTo(2.0121984f, 0.0f, 0.0f, 2.0194945f, 0.0f, 4.5191708f);
                h.lineTo(0.0f, 135.48083f);
                h.cubicTo(0.0f, 137.9767f, 2.0214844f, 140.0f, 4.494371f, 140.0f);
                h.lineTo(175.50563f, 140.0f);
                h.cubicTo(177.98781f, 140.0f, 180.0f, 137.9805f, 180.0f, 135.48083f);
                h.lineTo(180.0f, 4.5191708f);
                h.cubicTo(180.0f, 2.0233016f, 177.97852f, 0.0f, 175.50563f, 0.0f);
                h.lineTo(4.494371f, 0.0f);
                h.lineTo(4.494371f, 0.0f);
                h.lineTo(4.494371f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
