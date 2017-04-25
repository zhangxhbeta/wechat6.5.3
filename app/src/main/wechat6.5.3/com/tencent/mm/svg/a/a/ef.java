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

public final class ef extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-8617851);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 8.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(53.00009f, 8.0f);
                h.lineTo(45.00009f, 0.0f);
                h.lineTo(20.00009f, 0.0f);
                h.lineTo(12.000091f, 8.0f);
                h.lineTo(9.0277776E-5f, 8.0f);
                h.lineTo(9.0277776E-5f, 16.0f);
                h.lineTo(65.00009f, 16.0f);
                h.lineTo(65.00009f, 8.0f);
                h.lineTo(53.00009f, 8.0f);
                h.close();
                h.moveTo(12.000091f, 67.0f);
                h.lineTo(20.00009f, 67.0f);
                h.lineTo(20.00009f, 31.0f);
                h.lineTo(12.000091f, 31.0f);
                h.lineTo(12.000091f, 67.0f);
                h.close();
                h.moveTo(28.00009f, 67.0f);
                h.lineTo(36.00009f, 67.0f);
                h.lineTo(36.00009f, 31.0f);
                h.lineTo(28.00009f, 31.0f);
                h.lineTo(28.00009f, 67.0f);
                h.close();
                h.moveTo(45.00009f, 67.0f);
                h.lineTo(53.00009f, 67.0f);
                h.lineTo(53.00009f, 31.0f);
                h.lineTo(45.00009f, 31.0f);
                h.lineTo(45.00009f, 67.0f);
                h.close();
                h.moveTo(4.00009f, 68.0f);
                h.cubicTo(4.00009f, 74.53162f, 9.468924f, 80.0f, 16.00009f, 80.0f);
                h.lineTo(49.00009f, 80.0f);
                h.cubicTo(55.531708f, 80.0f, 61.00009f, 74.53162f, 61.00009f, 68.0f);
                h.lineTo(61.00009f, 23.0f);
                h.lineTo(4.00009f, 23.0f);
                h.lineTo(4.00009f, 68.0f);
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
