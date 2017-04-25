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

public final class wa extends c {
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
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(44.10407f, 48.572086f);
                h.lineTo(20.999926f, 35.23115f);
                h.cubicTo(19.958965f, 34.62973f, 19.004f, 35.25858f, 19.0f, 36.462433f);
                h.lineTo(19.004f, 62.93198f);
                h.cubicTo(19.0f, 64.13482f, 19.846968f, 65.615f, 20.88693f, 66.21947f);
                h.lineTo(44.10907f, 79.74022f);
                h.cubicTo(45.149033f, 80.345695f, 46.0f, 79.85603f, 46.0f, 78.65319f);
                h.lineTo(46.0f, 51.85246f);
                h.cubicTo(45.999f, 50.648605f, 45.14603f, 49.17249f, 44.10407f, 48.572086f);
                h.close();
                h.moveTo(73.216934f, 29.458399f);
                h.lineTo(50.073246f, 16.4451f);
                h.cubicTo(49.02697f, 15.856779f, 47.311195f, 15.850846f, 46.259857f, 16.432247f);
                h.lineTo(22.789015f, 29.413904f);
                h.cubicTo(21.738686f, 29.994316f, 21.73666f, 30.948486f, 22.784964f, 31.533842f);
                h.lineTo(46.14338f, 44.56098f);
                h.cubicTo(47.19168f, 45.14634f, 48.90745f, 45.14634f, 49.956768f, 44.56098f);
                h.lineTo(73.21288f, 31.591192f);
                h.cubicTo(74.261185f, 31.006824f, 74.2622f, 30.046722f, 73.216934f, 29.458399f);
                h.close();
                h.moveTo(76.997f, 36.350918f);
                h.cubicTo(77.001f, 35.14774f, 76.151f, 34.6553f, 75.11f, 35.256382f);
                h.lineTo(51.895f, 48.66497f);
                h.cubicTo(50.853f, 49.267067f, 50.0f, 50.74337f, 50.0f, 51.94655f);
                h.lineTo(50.0f, 78.64493f);
                h.cubicTo(50.0f, 79.84912f, 50.854f, 80.34461f, 51.898f, 79.74556f);
                h.lineTo(74.994f, 66.51567f);
                h.cubicTo(76.037f, 65.91763f, 76.996f, 64.287f, 77.0f, 63.082806f);
                h.lineTo(76.997f, 36.350918f);
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
