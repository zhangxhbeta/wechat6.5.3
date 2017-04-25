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

public final class lp extends c {
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-13917627);
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(93.95766f, 36.84429f);
                h.cubicTo(93.98636f, 36.989033f, 94.0014f, 37.138695f, 94.0014f, 37.2919f);
                h.lineTo(94.0014f, 78.515076f);
                h.lineTo(94.0014f, 83.09649f);
                h.cubicTo(94.0014f, 87.362976f, 91.116806f, 91.52309f, 87.23697f, 93.31541f);
                h.cubicTo(86.515724f, 93.64859f, 81.95949f, 94.65729f, 81.36456f, 94.77584f);
                h.cubicTo(75.64816f, 95.91493f, 71.25599f, 92.58525f, 71.01411f, 87.68092f);
                h.cubicTo(70.772224f, 82.776596f, 74.019295f, 80.207344f, 77.78672f, 79.45662f);
                h.lineTo(86.05384f, 77.74991f);
                h.cubicTo(87.69175f, 77.41177f, 89.0f, 75.80068f, 89.0f, 74.14648f);
                h.lineTo(89.0f, 38.127525f);
                h.lineTo(55.0f, 46.928032f);
                h.lineTo(55.0f, 87.738686f);
                h.lineTo(55.0f, 92.3201f);
                h.cubicTo(55.0f, 96.586586f, 52.115402f, 100.7467f, 48.23557f, 102.53902f);
                h.cubicTo(47.51432f, 102.8722f, 42.958088f, 103.8809f, 42.36316f, 103.99944f);
                h.cubicTo(36.64676f, 105.138535f, 32.254585f, 101.80886f, 32.012703f, 96.90453f);
                h.cubicTo(31.77082f, 92.0002f, 35.01789f, 89.430954f, 38.78532f, 88.68023f);
                h.lineTo(47.05244f, 86.97352f);
                h.cubicTo(48.690346f, 86.635376f, 49.998596f, 85.02429f, 49.998596f, 83.37009f);
                h.lineTo(49.998596f, 46.515507f);
                h.cubicTo(49.999065f, 46.514046f, 49.99953f, 46.512585f, 50.0f, 46.511124f);
                h.lineTo(50.0f, 42.888493f);
                h.cubicTo(50.0f, 42.060284f, 50.656136f, 41.219055f, 51.451427f, 41.013203f);
                h.lineTo(92.54858f, 30.375685f);
                h.cubicTo(93.350174f, 30.1682f, 94.0f, 30.68019f, 94.0f, 31.499603f);
                h.lineTo(94.0f, 36.833332f);
                h.lineTo(93.95766f, 36.84429f);
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
