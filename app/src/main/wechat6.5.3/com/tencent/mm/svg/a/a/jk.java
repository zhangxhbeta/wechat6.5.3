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

public final class jk extends c {
    private final int height = 191;
    private final int width = 191;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 191;
            case 1:
                return 191;
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
                g.setColor(-686547);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(71.7024f, 113.94841f);
                h.lineTo(70.50466f, 117.91833f);
                h.cubicTo(68.771225f, 123.66382f, 71.968994f, 129.74753f, 77.638115f, 131.50388f);
                h.lineTo(96.88131f, 137.46565f);
                h.cubicTo(102.55444f, 139.22325f, 108.55855f, 135.99077f, 110.29208f, 130.24493f);
                h.lineTo(111.371895f, 126.665886f);
                h.lineTo(143.50204f, 136.96637f);
                h.cubicTo(146.29303f, 137.86111f, 148.55556f, 136.22597f, 148.55556f, 133.26476f);
                h.lineTo(148.55556f, 55.65808f);
                h.cubicTo(148.55556f, 52.718987f, 146.2936f, 51.04703f, 143.50204f, 51.92406f);
                h.lineTo(55.177776f, 79.67322f);
                h.lineTo(55.177776f, 108.65085f);
                h.lineTo(71.7024f, 113.94841f);
                h.lineTo(71.7024f, 113.94841f);
                h.close();
                h.moveTo(105.589226f, 124.81204f);
                h.lineTo(104.67921f, 127.869804f);
                h.cubicTo(103.85574f, 130.63673f, 101.00234f, 132.19417f, 98.304535f, 131.34686f);
                h.lineTo(80.01574f, 125.60284f);
                h.cubicTo(77.32027f, 124.756256f, 75.80068f, 121.823364f, 76.6236f, 119.05828f);
                h.lineTo(77.58325f, 115.833725f);
                h.lineTo(105.589226f, 124.81204f);
                h.lineTo(105.589226f, 124.81204f);
                h.close();
                h.moveTo(0.0f, 0.0f);
                h.lineTo(191.0f, 0.0f);
                h.lineTo(191.0f, 191.0f);
                h.lineTo(0.0f, 191.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                h.moveTo(47.03692f, 77.76699f);
                h.cubicTo(44.500565f, 76.31182f, 42.444443f, 77.51847f, 42.444443f, 80.42022f);
                h.lineTo(42.444443f, 108.45738f);
                h.cubicTo(42.444443f, 111.37789f, 44.49037f, 112.57163f, 47.03692f, 111.11062f);
                h.lineTo(53.055557f, 107.65758f);
                h.lineTo(53.055557f, 81.22003f);
                h.lineTo(47.03692f, 77.76699f);
                h.lineTo(47.03692f, 77.76699f);
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
