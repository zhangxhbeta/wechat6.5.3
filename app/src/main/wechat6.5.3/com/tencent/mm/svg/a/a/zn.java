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

public final class zn extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-899014);
                c = c.a(c, 1.0f, 0.0f, -728.0f, 0.0f, 1.0f, -128.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -3.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 734.0f, 0.0f, 1.0f, 137.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 24.0f);
                h.cubicTo(0.0f, 37.2f, 10.8f, 48.0f, 24.0f, 48.0f);
                h.cubicTo(37.2f, 48.0f, 48.0f, 37.2f, 48.0f, 24.0f);
                h.cubicTo(48.0f, 10.8f, 37.2f, 0.0f, 24.0f, 0.0f);
                h.cubicTo(10.8f, 0.0f, 0.0f, 10.8f, 0.0f, 24.0f);
                h.close();
                h.moveTo(4.0f, 24.0f);
                h.cubicTo(4.0f, 35.0f, 13.0f, 44.0f, 24.0f, 44.0f);
                h.cubicTo(35.0f, 44.0f, 44.0f, 35.0f, 44.0f, 24.0f);
                h.cubicTo(44.0f, 13.0f, 35.0f, 4.0f, 24.0f, 4.0f);
                h.cubicTo(13.0f, 4.0f, 4.0f, 13.0f, 4.0f, 24.0f);
                h.close();
                h.moveTo(10.0f, 24.0f);
                h.cubicTo(10.0f, 31.7f, 16.3f, 38.0f, 24.0f, 38.0f);
                h.cubicTo(31.7f, 38.0f, 38.0f, 31.7f, 38.0f, 24.0f);
                h.cubicTo(38.0f, 16.3f, 31.7f, 10.0f, 24.0f, 10.0f);
                h.cubicTo(16.3f, 10.0f, 10.0f, 16.3f, 10.0f, 24.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
