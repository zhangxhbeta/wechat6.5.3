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

public final class xj extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                g.setColor(-8617594);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(76.32146f, 92.67854f);
                h.cubicTo(84.11785f, 100.47494f, 91.50503f, 104.13172f, 94.23683f, 103.91758f);
                h.cubicTo(96.96864f, 103.70344f, 103.77161f, 99.02503f, 106.98316f, 99.0873f);
                h.cubicTo(108.526665f, 99.117226f, 118.61296f, 105.93859f, 119.83391f, 106.72726f);
                h.cubicTo(121.054855f, 107.515915f, 122.18694f, 108.43717f, 121.97407f, 109.60293f);
                h.cubicTo(121.7612f, 110.768684f, 117.32839f, 123.60948f, 106.01143f, 121.83133f);
                h.cubicTo(94.694466f, 120.05317f, 78.91704f, 107.853294f, 69.926674f, 99.073326f);
                h.lineTo(76.32146f, 92.67854f);
                h.lineTo(76.32146f, 92.67854f);
                h.close();
                h.moveTo(76.32146f, 92.67854f);
                h.cubicTo(68.52506f, 84.88215f, 64.86828f, 77.49497f, 65.08242f, 74.76317f);
                h.cubicTo(65.29656f, 72.03136f, 69.97497f, 65.22839f, 69.9127f, 62.016838f);
                h.cubicTo(69.882774f, 60.47334f, 63.06141f, 50.38704f, 62.272747f, 49.166092f);
                h.cubicTo(61.484085f, 47.945145f, 60.56283f, 46.813057f, 59.39707f, 47.02593f);
                h.cubicTo(58.231316f, 47.2388f, 45.39052f, 51.67161f, 47.168674f, 62.98857f);
                h.cubicTo(48.94683f, 74.305534f, 61.146706f, 90.08296f, 69.926674f, 99.073326f);
                h.lineTo(76.32146f, 92.67854f);
                h.lineTo(76.32146f, 92.67854f);
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
