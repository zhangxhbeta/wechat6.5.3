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

public final class gh extends c {
    private final int height = 294;
    private final int width = 322;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 322;
            case 1:
                return 294;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-657931);
                Path h = c.h(looper);
                h.moveTo(22.0f, 15.00912f);
                h.cubicTo(22.0f, 6.719812f, 28.722176f, 0.0f, 37.005398f, 0.0f);
                h.lineTo(306.9946f, 0.0f);
                h.cubicTo(315.28186f, 0.0f, 322.0f, 6.710611f, 322.0f, 15.00912f);
                h.lineTo(322.0f, 278.99088f);
                h.cubicTo(322.0f, 287.28018f, 315.27783f, 294.0f, 306.9946f, 294.0f);
                h.lineTo(37.005398f, 294.0f);
                h.cubicTo(28.718145f, 294.0f, 22.0f, 287.2894f, 22.0f, 278.99088f);
                h.lineTo(22.0f, 15.00912f);
                h.close();
                h.moveTo(0.0f, 60.37744f);
                h.lineTo(22.0f, 48.0f);
                h.lineTo(22.0f, 73.0f);
                h.lineTo(0.0f, 60.37744f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(c, 1.0f, 0.0f, 86.0f, 0.0f, 1.0f, 83.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                g2 = c.a(a, looper);
                g2.setColor(-3552823);
                g2.setStrokeWidth(20.0f);
                canvas.save();
                Paint a4 = c.a(g2, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 2.0f);
                h.cubicTo(0.0f, 0.89543045f, 0.89543045f, 0.0f, 2.0f, 0.0f);
                h.lineTo(163.0f, 0.0f);
                h.cubicTo(164.10457f, 0.0f, 165.0f, 0.89543045f, 165.0f, 2.0f);
                h.lineTo(165.0f, 118.0f);
                h.cubicTo(165.0f, 119.10457f, 164.10457f, 120.0f, 163.0f, 120.0f);
                h.lineTo(2.0f, 120.0f);
                h.cubicTo(0.89543045f, 120.0f, 0.0f, 119.10457f, 0.0f, 118.0f);
                h.lineTo(0.0f, 2.0f);
                h.close();
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-3552823);
                Path h2 = c.h(looper);
                h2.moveTo(126.73595f, 64.14897f);
                h2.lineTo(103.837265f, 81.98572f);
                h2.lineTo(111.876335f, 98.63208f);
                h2.lineTo(55.73088f, 46.75f);
                h2.lineTo(2.75f, 96.57307f);
                h2.lineTo(2.75f, 119.245766f);
                h2.lineTo(162.59375f, 119.245766f);
                h2.lineTo(162.59375f, 96.57307f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
