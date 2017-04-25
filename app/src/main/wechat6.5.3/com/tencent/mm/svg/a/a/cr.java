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

public final class cr extends c {
    private final int height = 192;
    private final int width = 192;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                a.setColor(-8421505);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 52.0f, 0.0f, 1.0f, 60.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(51.209858f, 40.05964f);
                h.lineTo(3.504289f, 40.05964f);
                h.cubicTo(1.8527762f, 40.05964f, 0.5f, 41.4067f, 0.5f, 43.06838f);
                h.lineTo(0.5f, 48.061665f);
                h.cubicTo(0.5f, 49.720272f, 1.845066f, 51.070408f, 3.504289f, 51.070408f);
                h.lineTo(46.77892f, 51.070408f);
                h.cubicTo(46.36196f, 58.577297f, 45.623863f, 68.698906f, 45.507942f, 69.59223f);
                h.cubicTo(45.34903f, 71.23931f, 47.599426f, 71.77455f, 50.015602f, 69.59223f);
                h.cubicTo(52.308044f, 67.73306f, 84.49499f, 45.123127f, 86.07686f, 42.99458f);
                h.cubicTo(88.44803f, 42.097687f, 87.434166f, 40.06258f, 86.07686f, 40.039284f);
                h.cubicTo(83.053604f, 40.02327f, 53.310036f, 40.061066f, 51.518154f, 40.039284f);
                h.cubicTo(51.416916f, 40.039772f, 51.31401f, 40.046738f, 51.209858f, 40.05964f);
                h.close();
                h.moveTo(36.790142f, 31.010767f);
                h.lineTo(84.49571f, 31.010767f);
                h.cubicTo(86.147224f, 31.010767f, 87.5f, 29.663708f, 87.5f, 28.002028f);
                h.lineTo(87.5f, 23.008741f);
                h.cubicTo(87.5f, 21.350136f, 86.15494f, 20.0f, 84.49571f, 20.0f);
                h.lineTo(41.22108f, 20.0f);
                h.cubicTo(41.63804f, 12.493111f, 42.376137f, 2.3715022f, 42.492058f, 1.4781721f);
                h.cubicTo(42.65097f, -0.16890648f, 40.400574f, -0.70414233f, 37.984398f, 1.4781721f);
                h.cubicTo(35.691956f, 3.337342f, 3.505013f, 25.947277f, 1.9231391f, 28.075827f);
                h.cubicTo(-0.44802973f, 28.972721f, 0.5658374f, 31.007828f, 1.9231391f, 31.031122f);
                h.cubicTo(4.9463964f, 31.047138f, 34.689964f, 31.009338f, 36.481846f, 31.031122f);
                h.cubicTo(36.583084f, 31.030634f, 36.68599f, 31.02367f, 36.790142f, 31.010767f);
                h.lineTo(36.790142f, 31.010767f);
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
