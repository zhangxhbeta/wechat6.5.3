package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
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

public final class iy extends c {
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
                c = c.a(c, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(47.704567f, 7.1032724f);
                h2.cubicTo(48.198116f, 7.035328f, 48.706787f, 7.0f, 49.229694f, 7.0f);
                h2.cubicTo(56.058342f, 7.0f, 60.45939f, 13.02472f, 60.45939f, 19.03764f);
                h2.cubicTo(60.45939f, 24.831484f, 58.489338f, 26.30708f, 56.180534f, 29.742367f);
                h2.cubicTo(53.121593f, 34.293007f, 57.841705f, 36.26868f, 60.119278f, 37.523205f);
                h2.cubicTo(68.294106f, 42.0279f, 72.0f, 43.77384f, 72.0f, 46.117085f);
                h2.lineTo(72.0f, 49.046967f);
                h2.cubicTo(72.0f, 50.137016f, 71.22881f, 51.0f, 70.01977f, 51.0f);
                h2.lineTo(64.71711f, 51.0f);
                h2.cubicTo(64.658745f, 48.05218f, 60.1475f, 45.825893f, 50.273735f, 40.140404f);
                h2.cubicTo(47.504784f, 38.546654f, 41.766323f, 36.03675f, 45.48522f, 30.255606f);
                h2.cubicTo(48.29214f, 25.891405f, 50.68722f, 24.016804f, 50.68722f, 16.656288f);
                h2.cubicTo(50.68722f, 13.247847f, 49.62196f, 9.83642f, 47.704567f, 7.1032724f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(15.0f, 16.0f);
                h2.cubicTo(14.951405f, 24.315659f, 17.503698f, 26.327835f, 20.0f, 31.0f);
                h2.cubicTo(24.457859f, 37.21774f, 18.342735f, 39.91184f, 15.0f, 42.0f);
                h2.cubicTo(4.80116f, 47.765316f, 0.0f, 50.14615f, 0.0f, 53.0f);
                h2.lineTo(0.0f, 57.0f);
                h2.cubicTo(0.0f, 58.823204f, 0.99910563f, 60.0f, 3.0f, 60.0f);
                h2.lineTo(56.0f, 60.0f);
                h2.cubicTo(58.000893f, 60.0f, 59.0f, 58.823204f, 59.0f, 57.0f);
                h2.lineTo(59.0f, 53.0f);
                h2.cubicTo(59.0f, 50.14615f, 54.19884f, 47.765316f, 44.0f, 42.0f);
                h2.cubicTo(40.657265f, 39.91184f, 34.54214f, 37.21774f, 39.0f, 31.0f);
                h2.cubicTo(41.496304f, 26.327835f, 44.048595f, 24.315659f, 44.0f, 16.0f);
                h2.cubicTo(44.048595f, 8.215528f, 38.346832f, 0.0f, 30.0f, 0.0f);
                h2.cubicTo(20.653166f, 0.0f, 14.951405f, 8.215528f, 15.0f, 16.0f);
                h2.lineTo(15.0f, 16.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
