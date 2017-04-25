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

public final class ls extends c {
    private final int height = 136;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 136;
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
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 40.5f, 0.0f, 1.0f, 25.5f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-13917627);
                Path h = c.h(looper);
                h.moveTo(25.5f, 73.5f);
                h.lineTo(30.0f, 73.5f);
                h.lineTo(30.0f, 81.0f);
                h.lineTo(25.5f, 81.0f);
                h.lineTo(25.5f, 73.5f);
                h.close();
                h.moveTo(10.493185f, 81.0f);
                h.cubicTo(9.668522f, 81.0f, 9.0f, 81.663994f, 9.0f, 82.498436f);
                h.lineTo(9.0f, 84.001564f);
                h.cubicTo(9.0f, 84.829124f, 9.666799f, 85.5f, 10.493185f, 85.5f);
                h.lineTo(45.006813f, 85.5f);
                h.cubicTo(45.83148f, 85.5f, 46.5f, 84.836006f, 46.5f, 84.001564f);
                h.lineTo(46.5f, 82.498436f);
                h.cubicTo(46.5f, 81.670876f, 45.833202f, 81.0f, 45.006813f, 81.0f);
                h.lineTo(10.493185f, 81.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-13917627);
                a2.setStrokeWidth(4.5f);
                a2.setStrokeCap(Cap.ROUND);
                a2.setStrokeJoin(Join.MITER);
                h = c.h(looper);
                h.moveTo(0.0f, 42.0f);
                h.lineTo(0.0f, 45.67666f);
                h.cubicTo(0.0f, 61.043068f, 12.424098f, 73.5f, 27.75f, 73.5f);
                h.cubicTo(43.0759f, 73.5f, 55.5f, 61.043068f, 55.5f, 45.67666f);
                h.lineTo(55.5f, 42.0f);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-13917627);
                a2.setStrokeWidth(4.5f);
                h = c.h(looper);
                h.moveTo(12.0f, 22.5f);
                h.cubicTo(12.0f, 10.073592f, 19.051514f, -1.577997E-13f, 27.75f, -1.577997E-13f);
                h.lineTo(27.75f, -1.577997E-13f);
                h.cubicTo(36.448486f, -1.577997E-13f, 43.5f, 10.073592f, 43.5f, 22.5f);
                h.lineTo(43.5f, 39.0f);
                h.cubicTo(43.5f, 51.426407f, 36.448486f, 61.5f, 27.75f, 61.5f);
                h.lineTo(27.75f, 61.5f);
                h.cubicTo(19.051514f, 61.5f, 12.0f, 51.426407f, 12.0f, 39.0f);
                h.lineTo(12.0f, 22.5f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
