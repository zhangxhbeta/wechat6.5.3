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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class wo extends c {
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
                a.setColor(-8355712);
                c = c.a(c, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 19.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(25.0f, 0.0f);
                h.cubicTo(29.048916f, -0.06493359f, 33.00111f, -0.074923374f, 37.0f, 0.0f);
                h.cubicTo(37.143414f, 0.4745147f, 37.62368f, 0.99398345f, 38.0f, 1.0f);
                h.cubicTo(38.224014f, 9.495289f, 37.89383f, 17.766829f, 38.0f, 26.0f);
                h.cubicTo(41.665924f, 26.02838f, 45.337967f, 26.02838f, 49.0f, 26.0f);
                h.cubicTo(43.00667f, 32.032238f, 37.003334f, 38.01612f, 31.0f, 44.0f);
                h.cubicTo(24.996664f, 38.01612f, 18.99333f, 32.032238f, 13.0f, 26.0f);
                h.cubicTo(16.662035f, 26.02838f, 20.334074f, 26.02838f, 24.0f, 26.0f);
                h.cubicTo(24.10617f, 17.766829f, 23.775988f, 9.485299f, 24.0f, 1.0f);
                h.cubicTo(24.396332f, 0.97400385f, 24.886604f, 0.46452492f, 25.0f, 0.0f);
                h.lineTo(25.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(-3.5527137E-15f, 41.0f);
                h.lineTo(7.0f, 41.0f);
                h.cubicTo(7.0189643f, 44.66132f, 7.0189643f, 48.312668f, 7.0f, 52.0f);
                h.cubicTo(23.006926f, 51.973988f, 38.99489f, 51.973988f, 55.0f, 52.0f);
                h.cubicTo(54.98285f, 48.312668f, 54.98285f, 44.66132f, 55.0f, 41.0f);
                h.lineTo(62.0f, 41.0f);
                h.cubicTo(61.917625f, 46.00813f, 62.09749f, 51.026234f, 62.0f, 56.0f);
                h.cubicTo(62.01755f, 58.029633f, 59.899147f, 59.276676f, 58.0f, 59.0f);
                h.cubicTo(40.01412f, 58.957436f, 21.947723f, 58.96741f, 4.0f, 59.0f);
                h.cubicTo(2.1426363f, 59.24675f, 0.014238917f, 58.089493f, -3.5527137E-15f, 56.0f);
                h.cubicTo(-0.10567079f, 51.106045f, 0.08418625f, 46.048035f, -3.5527137E-15f, 41.0f);
                h.lineTo(-3.5527137E-15f, 41.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
