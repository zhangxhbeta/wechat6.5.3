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

public final class ada extends c {
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
                c = c.a(c, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a = c.a(g, looper);
                a.setColor(-9473160);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(48.0f, 2.2325583f);
                h.cubicTo(22.722824f, 2.2325583f, 2.2325583f, 22.722431f, 2.2325583f, 48.0f);
                h.cubicTo(2.2325583f, 73.277565f, 22.722824f, 93.76744f, 48.0f, 93.76744f);
                h.cubicTo(73.277176f, 93.76744f, 93.76744f, 73.277565f, 93.76744f, 48.0f);
                h.cubicTo(93.76744f, 22.722431f, 73.277176f, 2.2325583f, 48.0f, 2.2325583f);
                h.lineTo(48.0f, 0.0f);
                h.cubicTo(74.50971f, 3.96582E-15f, 96.0f, 21.488955f, 96.0f, 48.0f);
                h.cubicTo(96.0f, 74.51105f, 74.50971f, 96.0f, 48.0f, 96.0f);
                h.cubicTo(21.490286f, 96.0f, 0.0f, 74.51105f, 0.0f, 48.0f);
                h.cubicTo(0.0f, 21.488955f, 21.490286f, 3.96582E-15f, 48.0f, 3.96582E-15f);
                h.lineTo(48.0f, 2.2325583f);
                h.close();
                h.moveTo(48.0f, 78.0f);
                h.cubicTo(31.26898f, 78.0f, 21.57295f, 68.294815f, 20.0f, 54.0f);
                h.lineTo(76.0f, 54.0f);
                h.cubicTo(74.426834f, 68.29482f, 64.72965f, 78.0f, 48.0f, 78.0f);
                h.close();
                h.moveTo(64.5f, 44.0f);
                h.cubicTo(67.53757f, 44.0f, 70.0f, 40.865993f, 70.0f, 37.0f);
                h.cubicTo(70.0f, 33.134007f, 67.53757f, 30.0f, 64.5f, 30.0f);
                h.cubicTo(61.462433f, 30.0f, 59.0f, 33.134007f, 59.0f, 37.0f);
                h.cubicTo(59.0f, 40.865993f, 61.462433f, 44.0f, 64.5f, 44.0f);
                h.close();
                h.moveTo(31.5f, 44.0f);
                h.cubicTo(34.537567f, 44.0f, 37.0f, 40.865993f, 37.0f, 37.0f);
                h.cubicTo(37.0f, 33.134007f, 34.537567f, 30.0f, 31.5f, 30.0f);
                h.cubicTo(28.462435f, 30.0f, 26.0f, 33.134007f, 26.0f, 37.0f);
                h.cubicTo(26.0f, 40.865993f, 28.462435f, 44.0f, 31.5f, 44.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(419430400);
                h = c.h(looper);
                h.moveTo(48.0f, 0.0f);
                h.cubicTo(74.509674f, 0.0f, 96.0f, 21.49033f, 96.0f, 48.0f);
                h.cubicTo(96.0f, 74.509674f, 74.509674f, 96.0f, 48.0f, 96.0f);
                h.cubicTo(21.49033f, 96.0f, 0.0f, 74.509674f, 0.0f, 48.0f);
                h.cubicTo(0.0f, 21.49033f, 21.49033f, 0.0f, 48.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
