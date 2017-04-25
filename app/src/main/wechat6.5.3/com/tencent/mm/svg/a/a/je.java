package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class je extends c {
    private final int height = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
            case 1:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
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
                g2 = c.a(g, looper);
                g2.setColor(-12206054);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(108.0f, 0.0f);
                h.lineTo(108.0f, 108.0f);
                h.lineTo(0.0f, 108.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(47.0f, 61.0f);
                h2.cubicTo(53.445965f, 67.115555f, 59.40413f, 69.98397f, 62.0f, 70.0f);
                h2.cubicTo(63.810833f, 69.648026f, 69.2978f, 65.97824f, 72.0f, 66.0f);
                h2.cubicTo(73.13301f, 66.05056f, 81.268166f, 71.4013f, 82.0f, 72.0f);
                h2.cubicTo(83.237686f, 72.63856f, 84.15078f, 73.3612f, 84.0f, 74.0f);
                h2.cubicTo(83.807396f, 75.19006f, 80.232086f, 85.26249f, 71.0f, 84.0f);
                h2.cubicTo(61.976585f, 82.47289f, 49.251225f, 72.903206f, 42.0f, 66.0f);
                h2.lineTo(47.0f, 61.0f);
                h2.lineTo(47.0f, 61.0f);
                h2.close();
                h2.moveTo(47.0f, 61.0f);
                h2.cubicTo(40.88444f, 54.554035f, 38.01603f, 48.59587f, 38.0f, 46.0f);
                h2.cubicTo(38.35198f, 44.189167f, 42.021763f, 38.7022f, 42.0f, 36.0f);
                h2.cubicTo(41.94944f, 34.86699f, 36.598705f, 26.731834f, 36.0f, 26.0f);
                h2.cubicTo(35.36144f, 24.762312f, 34.638798f, 23.84922f, 34.0f, 24.0f);
                h2.cubicTo(32.80994f, 24.192604f, 22.737509f, 27.767912f, 24.0f, 37.0f);
                h2.cubicTo(25.52711f, 46.023415f, 35.096794f, 58.748775f, 42.0f, 66.0f);
                h2.lineTo(47.0f, 61.0f);
                h2.lineTo(47.0f, 61.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
