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

public final class nk extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-11615450);
                c = c.a(c, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.1112194f, 10.565054f);
                h.cubicTo(4.587666f, 6.591597f, 8.452122f, 3.6065128f, 12.426419f, 1.2503928f);
                h.cubicTo(14.263783f, 0.21210259f, 15.3522215f, 2.6680582f, 16.330818f, 3.7762334f);
                h.cubicTo(18.937078f, 7.849526f, 22.262306f, 11.45359f, 24.48911f, 15.746521f);
                h.cubicTo(22.951319f, 19.690027f, 17.718826f, 20.53863f, 14.313711f, 22.535341f);
                h.cubicTo(15.721691f, 27.826628f, 19.156763f, 32.249344f, 22.871433f, 36.152916f);
                h.cubicTo(27.245157f, 40.69544f, 32.267952f, 44.898514f, 38.409138f, 46.75546f);
                h.cubicTo(40.096718f, 43.281178f, 41.464756f, 39.487427f, 44.190845f, 36.66208f);
                h.cubicTo(45.83848f, 36.172886f, 47.17656f, 37.660435f, 48.49467f, 38.419186f);
                h.cubicTo(52.08951f, 41.23455f, 56.06381f, 43.56072f, 59.52884f, 46.53582f);
                h.cubicTo(60.647232f, 47.71388f, 59.508865f, 49.14153f, 58.84981f, 50.199787f);
                h.cubicTo(56.333424f, 53.624146f, 53.677235f, 57.22821f, 49.81278f, 59.224922f);
                h.cubicTo(46.797104f, 60.81231f, 43.34206f, 59.654217f, 40.39629f, 58.48614f);
                h.cubicTo(23.520502f, 51.367863f, 9.690345f, 37.480732f, 2.520632f, 20.638466f);
                h.cubicTo(1.1725662f, 17.503628f, 0.10409919f, 13.679925f, 2.1112194f, 10.565054f);
                h.lineTo(2.1112194f, 10.565054f);
                h.lineTo(2.1112194f, 10.565054f);
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
