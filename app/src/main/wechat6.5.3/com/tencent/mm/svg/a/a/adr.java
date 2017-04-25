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

public final class adr extends c {
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
                a.setColor(-11286452);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(45.0f, 3.0f);
                h.lineTo(45.0f, 59.0f);
                h.lineTo(9.0f, 59.0f);
                h.lineTo(9.0f, 3.0f);
                h.lineTo(45.0f, 3.0f);
                h.close();
                h.moveTo(42.0f, 6.0f);
                h.lineTo(42.0f, 53.0f);
                h.lineTo(12.0f, 53.0f);
                h.lineTo(12.0f, 6.0f);
                h.lineTo(42.0f, 6.0f);
                h.close();
                h.moveTo(27.0f, 59.0f);
                h.cubicTo(28.10457f, 59.0f, 29.0f, 58.10457f, 29.0f, 57.0f);
                h.cubicTo(29.0f, 55.89543f, 28.10457f, 55.0f, 27.0f, 55.0f);
                h.cubicTo(25.89543f, 55.0f, 25.0f, 55.89543f, 25.0f, 57.0f);
                h.cubicTo(25.0f, 58.10457f, 25.89543f, 59.0f, 27.0f, 59.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(44.321014f, 3.0f);
                h.cubicTo(42.295044f, 1.3283027f, 35.97658f, 0.20756736f, 28.648415f, 0.025989328f);
                h.cubicTo(27.95361f, 0.008773398f, 27.24973f, 0.0f, 26.53957f, 0.0f);
                h.cubicTo(18.339287f, 0.0f, 10.921131f, 1.1698043f, 8.684801f, 3.0f);
                h.lineTo(44.321014f, 3.0f);
                h.close();
                h.moveTo(44.321014f, 59.0f);
                h.cubicTo(42.295044f, 60.671696f, 35.97658f, 61.79243f, 28.648415f, 61.97401f);
                h.cubicTo(27.95361f, 61.991226f, 27.24973f, 62.0f, 26.53957f, 62.0f);
                h.cubicTo(18.339287f, 62.0f, 10.921131f, 60.830196f, 8.684801f, 59.0f);
                h.lineTo(44.321014f, 59.0f);
                h.lineTo(44.321014f, 59.0f);
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
