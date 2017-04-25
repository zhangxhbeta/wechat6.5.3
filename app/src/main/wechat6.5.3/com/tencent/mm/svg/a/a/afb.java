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

public final class afb extends c {
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
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -127.0f, 0.0f, 1.0f, -128.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 128.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-9276814);
                c = c.a(c, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 5.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(78.0f, 47.0f);
                h.cubicTo(78.0f, 68.53911f, 60.539104f, 86.0f, 39.0f, 86.0f);
                h.cubicTo(17.460896f, 86.0f, 0.0f, 68.53911f, 0.0f, 47.0f);
                h.cubicTo(0.0f, 29.647755f, 11.332416f, 14.942338f, 27.0f, 9.880997f);
                h.lineTo(27.0f, 18.408052f);
                h.cubicTo(15.838201f, 23.098259f, 8.0f, 34.133774f, 8.0f, 47.0f);
                h.cubicTo(8.0f, 64.12083f, 21.879173f, 78.0f, 39.0f, 78.0f);
                h.cubicTo(56.120827f, 78.0f, 70.0f, 64.12083f, 70.0f, 47.0f);
                h.cubicTo(70.0f, 34.133774f, 62.1618f, 23.098259f, 51.0f, 18.408056f);
                h.lineTo(51.0f, 9.880997f);
                h.cubicTo(66.66759f, 14.942338f, 78.0f, 29.647755f, 78.0f, 47.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(35.0f, 2.0f);
                h.cubicTo(35.0f, 0.89543045f, 35.89543f, 0.0f, 37.0f, 0.0f);
                h.lineTo(42.0f, 0.0f);
                h.cubicTo(43.10457f, 0.0f, 44.0f, 0.89543045f, 44.0f, 2.0f);
                h.lineTo(44.0f, 28.0f);
                h.cubicTo(44.0f, 29.10457f, 43.10457f, 30.0f, 42.0f, 30.0f);
                h.lineTo(37.0f, 30.0f);
                h.cubicTo(35.89543f, 30.0f, 35.0f, 29.10457f, 35.0f, 28.0f);
                h.lineTo(35.0f, 2.0f);
                h.close();
                canvas.drawPath(h, a);
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
