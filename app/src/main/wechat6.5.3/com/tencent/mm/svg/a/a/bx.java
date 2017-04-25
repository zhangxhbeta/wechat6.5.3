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

public final class bx extends c {
    private final int height = 58;
    private final int width = 58;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -249.0f, 0.0f, 1.0f, -79.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, 0.70710677f, 0.70710677f, 4.6425705f, -0.70710677f, 0.70710677f, 229.20816f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(277.0f, 118.906f);
                h.lineTo(277.0f, 141.0f);
                h.lineTo(283.0f, 141.0f);
                h.lineTo(283.0f, 118.61951f);
                h.cubicTo(292.68488f, 116.751785f, 300.0f, 108.23016f, 300.0f, 98.0f);
                h.cubicTo(300.0f, 86.40202f, 290.598f, 77.0f, 279.0f, 77.0f);
                h.cubicTo(267.402f, 77.0f, 258.0f, 86.40202f, 258.0f, 98.0f);
                h.cubicTo(258.0f, 108.92341f, 266.34015f, 117.89888f, 277.0f, 118.906f);
                h.close();
                h.moveTo(279.0f, 113.0f);
                h.cubicTo(287.28427f, 113.0f, 294.0f, 106.28427f, 294.0f, 98.0f);
                h.cubicTo(294.0f, 89.71573f, 287.28427f, 83.0f, 279.0f, 83.0f);
                h.cubicTo(270.71573f, 83.0f, 264.0f, 89.71573f, 264.0f, 98.0f);
                h.cubicTo(264.0f, 106.28427f, 270.71573f, 113.0f, 279.0f, 113.0f);
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
