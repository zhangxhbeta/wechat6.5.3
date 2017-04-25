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

public final class uu extends c {
    private final int height = 84;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                c = c.a(c, 1.0f, 0.0f, -194.0f, 0.0f, 1.0f, -155.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 194.0f, 0.0f, 1.0f, 155.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(96.0f, 0.0f);
                h.lineTo(96.0f, 84.0f);
                h.lineTo(0.0f, 84.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-15028967);
                h = c.h(looper);
                h.moveTo(26.949f, 16.841825f);
                h.cubicTo(33.649f, 12.678541f, 41.638f, 10.73867f, 49.503f, 11.028203f);
                h.cubicTo(57.468f, 11.295772f, 65.408f, 13.88859f, 71.778f, 18.713806f);
                h.cubicTo(74.781f, 20.984144f, 77.423f, 23.748686f, 79.47f, 26.910585f);
                h.cubicTo(81.411f, 29.898766f, 82.805f, 33.248363f, 83.491f, 36.746723f);
                h.cubicTo(84.316f, 40.921986f, 84.131f, 45.29194f, 82.953f, 49.382343f);
                h.cubicTo(81.294f, 55.208942f, 77.656f, 60.36962f, 73.004f, 64.21442f);
                h.cubicTo(67.825f, 68.51448f, 61.43f, 71.26305f, 54.799f, 72.346306f);
                h.cubicTo(45.676f, 73.84489f, 36.002f, 72.303375f, 27.968f, 67.669846f);
                h.cubicTo(22.646f, 69.41203f, 17.323f, 71.15622f, 12.0f, 72.899414f);
                h.cubicTo(14.104f, 68.41964f, 16.21f, 63.94186f, 18.312f, 59.461086f);
                h.cubicTo(15.922f, 56.467915f, 14.079f, 53.024467f, 13.034f, 49.336414f);
                h.cubicTo(11.356f, 43.516804f, 11.74f, 37.141087f, 14.082f, 31.557093f);
                h.cubicTo(16.618f, 25.418991f, 21.327f, 20.318218f, 26.949f, 16.841825f);
                h.lineTo(26.949f, 16.841825f);
                h.close();
                h.moveTo(39.728f, 15.903339f);
                h.cubicTo(33.562f, 17.28511f, 27.702f, 20.30524f, 23.271f, 24.840925f);
                h.cubicTo(20.666f, 27.504627f, 18.584f, 30.699474f, 17.338f, 34.215805f);
                h.cubicTo(15.605f, 39.044018f, 15.557f, 44.450294f, 17.208f, 49.30746f);
                h.cubicTo(18.376f, 52.79384f, 20.372f, 55.975708f, 22.882f, 58.655384f);
                h.cubicTo(21.586f, 61.40595f, 20.294f, 64.15751f, 19.001f, 66.90907f);
                h.cubicTo(22.312f, 65.80685f, 25.624f, 64.70563f, 28.935f, 63.602406f);
                h.cubicTo(31.917f, 65.4634f, 35.193f, 66.84318f, 38.596f, 67.72276f);
                h.cubicTo(46.704f, 69.803406f, 55.538f, 69.15245f, 63.176f, 65.68704f);
                h.cubicTo(68.381f, 63.324852f, 73.04f, 59.60785f, 76.146f, 54.78263f);
                h.cubicTo(78.169f, 51.65268f, 79.492f, 48.059475f, 79.873f, 44.34846f);
                h.cubicTo(80.256f, 40.74727f, 79.764f, 37.061214f, 78.465f, 33.680668f);
                h.cubicTo(77.237f, 30.463856f, 75.308f, 27.531584f, 72.929f, 25.04759f);
                h.cubicTo(70.65f, 22.666431f, 67.965f, 20.684628f, 65.056f, 19.138123f);
                h.cubicTo(57.369f, 15.0547085f, 48.197f, 14.01239f, 39.728f, 15.903339f);
                h.lineTo(39.728f, 15.903339f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
