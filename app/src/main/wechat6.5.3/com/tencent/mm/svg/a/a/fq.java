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

public final class fq extends c {
    private final int height = MMGIFException.D_GIF_ERR_READ_FAILED;
    private final int width = MMGIFException.D_GIF_ERR_READ_FAILED;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
            case 1:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(51.0f, 102.0f);
                h.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                h.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                h.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                h.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                h.lineTo(51.0f, 102.0f);
                h.close();
                h.moveTo(51.0f, 98.0f);
                h.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                h.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                h.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                h.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                h.lineTo(51.0f, 98.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(60.046738f, 37.910957f);
                h.cubicTo(69.13362f, 37.910957f, 76.5f, 45.204285f, 76.5f, 54.20548f);
                h.cubicTo(76.5f, 63.204693f, 69.13489f, 70.5f, 60.046738f, 70.5f);
                h.lineTo(29.047552f, 70.5f);
                h.cubicTo(28.745148f, 70.5f, 28.5f, 70.25656f, 28.5f, 69.968216f);
                h.lineTo(28.5f, 65.68932f);
                h.cubicTo(28.5f, 65.39562f, 28.735804f, 65.15753f, 29.047586f, 65.15753f);
                h.lineTo(60.048687f, 65.15753f);
                h.cubicTo(66.152725f, 65.15753f, 71.10674f, 60.25413f, 71.10674f, 54.20548f);
                h.cubicTo(71.10674f, 48.1555f, 66.15588f, 43.253426f, 60.048687f, 43.253426f);
                h.lineTo(40.83506f, 43.253426f);
                h.lineTo(40.83506f, 48.97156f);
                h.cubicTo(40.83506f, 49.56155f, 40.448963f, 49.755066f, 39.972683f, 49.402626f);
                h.lineTo(28.857897f, 41.177834f);
                h.cubicTo(28.379784f, 40.82404f, 28.38162f, 40.253983f, 28.857897f, 39.901543f);
                h.lineTo(39.972683f, 31.676752f);
                h.cubicTo(40.450798f, 31.322954f, 40.83506f, 31.517307f, 40.83506f, 32.107815f);
                h.lineTo(40.83506f, 37.910957f);
                h.lineTo(60.046738f, 37.910957f);
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
