package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adq extends c {
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
                c.d(looper);
                c.c(looper);
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
                g = c.a(g, looper);
                g.setColor(-8286571);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(80.99659f, 75.89866f);
                h.cubicTo(80.944244f, 70.920204f, 79.92921f, 69.644585f, 63.000206f, 60.301033f);
                h.cubicTo(59.50676f, 58.372242f, 52.14093f, 55.336243f, 57.00217f, 48.349346f);
                h.cubicTo(57.38224f, 47.802f, 57.622345f, 47.250103f, 57.758896f, 46.699345f);
                h.cubicTo(60.69021f, 43.234344f, 62.82838f, 38.70993f, 62.974033f, 34.499588f);
                h.lineTo(63.001347f, 34.499588f);
                h.lineTo(63.001347f, 28.500414f);
                h.lineTo(62.930794f, 28.500414f);
                h.cubicTo(62.221863f, 18.878069f, 54.32576f, 15.0f, 48.001137f, 15.0f);
                h.cubicTo(41.66969f, 15.0f, 33.76562f, 18.660725f, 33.069206f, 28.500414f);
                h.lineTo(33.00093f, 28.500414f);
                h.lineTo(33.00093f, 34.499588f);
                h.lineTo(33.02824f, 34.499588f);
                h.cubicTo(33.173897f, 38.70993f, 35.31207f, 43.234344f, 38.243378f, 46.699345f);
                h.cubicTo(38.379932f, 47.248966f, 38.618896f, 47.802f, 39.000103f, 48.349346f);
                h.cubicTo(43.860207f, 55.336243f, 36.49438f, 58.37338f, 33.002068f, 60.301033f);
                h.cubicTo(16.073069f, 69.644585f, 15.058035f, 70.920204f, 15.00569f, 75.89866f);
                h.cubicTo(15.00569f, 75.9089f, 15.002275f, 75.919136f, 15.002275f, 75.93052f);
                h.lineTo(15.002275f, 77.06845f);
                h.cubicTo(15.002275f, 79.23848f, 16.762655f, 80.99886f, 18.933828f, 80.99886f);
                h.lineTo(77.070724f, 80.99886f);
                h.cubicTo(79.2419f, 80.99886f, 81.00227f, 79.23848f, 81.00227f, 77.06845f);
                h.lineTo(81.00227f, 75.93052f);
                h.cubicTo(81.0f, 75.92027f, 80.99659f, 75.910034f, 80.99659f, 75.89866f);
                h.lineTo(80.99659f, 75.89866f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
