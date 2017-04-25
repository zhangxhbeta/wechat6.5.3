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

public final class fh extends c {
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-9276814);
                Path h = c.h(looper);
                h.moveTo(71.998f, 42.0f);
                h.cubicTo(73.462f, 42.0f, 74.892f, 42.14f, 76.3f, 42.344f);
                h.lineTo(47.036f, 13.08f);
                h.cubicTo(33.486f, 18.83f, 22.316f, 29.098f, 15.452f, 42.018f);
                h.lineTo(71.672f, 42.018f);
                h.cubicTo(71.784f, 42.018f, 71.888f, 42.0f, 71.998f, 42.0f);
                h.lineTo(71.998f, 42.0f);
                h.close();
                h.moveTo(101.998f, 15.5f);
                h.lineTo(101.998f, 72.0f);
                h.cubicTo(101.998f, 73.43f, 101.864f, 74.826f, 101.67f, 76.202f);
                h.lineTo(130.91f, 46.96f);
                h.cubicTo(125.16f, 33.45f, 114.88f, 22.356f, 101.998f, 15.5f);
                h.lineTo(101.998f, 15.5f);
                h.close();
                h.moveTo(93.248f, 50.828f);
                h.cubicTo(94.248f, 51.83f, 95.148f, 52.924f, 95.998f, 54.058f);
                h.lineTo(95.998f, 12.674f);
                h.cubicTo(88.584f, 9.672f, 80.49f, 8.0f, 71.998f, 8.0f);
                h.cubicTo(65.474f, 8.0f, 59.19f, 9.002f, 53.26f, 10.818f);
                h.lineTo(93.26f, 50.818f);
                h.lineTo(93.248f, 50.828f);
                h.lineTo(93.248f, 50.828f);
                h.close();
                h.moveTo(54.046f, 48.018f);
                h.lineTo(12.662f, 48.018f);
                h.cubicTo(9.664f, 55.426f, 8.0f, 63.516f, 8.0f, 72.0f);
                h.cubicTo(8.0f, 78.558f, 9.014f, 84.874f, 10.848f, 90.832f);
                h.lineTo(49.742f, 51.938f);
                h.cubicTo(51.042f, 50.494f, 52.49f, 49.188f, 54.046f, 48.018f);
                h.lineTo(54.046f, 48.018f);
                h.close();
                h.moveTo(41.998f, 128.534f);
                h.lineTo(41.998f, 71.998f);
                h.cubicTo(41.998f, 70.584f, 42.13f, 69.204f, 42.32f, 67.842f);
                h.lineTo(13.114f, 97.048f);
                h.cubicTo(18.87f, 110.554f, 29.116f, 121.684f, 41.998f, 128.534f);
                h.lineTo(41.998f, 128.534f);
                h.close();
                h.moveTo(47.998f, 89.952f);
                h.lineTo(47.998f, 131.328f);
                h.cubicTo(55.412f, 134.33f, 63.508f, 135.998f, 71.998f, 135.998f);
                h.cubicTo(78.582f, 135.998f, 84.918f, 134.976f, 90.894f, 133.128f);
                h.lineTo(52.868f, 95.104f);
                h.cubicTo(51.042f, 93.594f, 49.422f, 91.852f, 47.998f, 89.952f);
                h.lineTo(47.998f, 89.952f);
                h.close();
                h.moveTo(133.18f, 53.178f);
                h.lineTo(93.896f, 92.462f);
                h.cubicTo(92.682f, 93.76f, 91.338f, 94.932f, 89.914f, 96.002f);
                h.lineTo(131.33f, 96.002f);
                h.cubicTo(134.332f, 88.588f, 136.0f, 80.492f, 136.0f, 72.002f);
                h.cubicTo(135.998f, 65.448f, 135.01f, 59.128f, 133.18f, 53.178f);
                h.lineTo(133.18f, 53.178f);
                h.close();
                h.moveTo(67.942f, 101.694f);
                h.lineTo(97.108f, 130.86f);
                h.cubicTo(110.586f, 125.1f, 121.692f, 114.862f, 128.534f, 102.0f);
                h.lineTo(71.998f, 102.0f);
                h.cubicTo(70.62f, 102.0f, 69.272f, 101.874f, 67.942f, 101.694f);
                h.lineTo(67.942f, 101.694f);
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
