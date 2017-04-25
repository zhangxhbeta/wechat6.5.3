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

public final class ww extends c {
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
                float[] a = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-1);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(1.0493919f, 4.9551387f);
                h.cubicTo(0.73974586f, 3.1585698f, 1.9383756f, 0.9428011f, 3.976046f, 1.1024961f);
                h.cubicTo(22.345047f, 0.9727439f, 40.724033f, 1.0725534f, 59.093037f, 1.0525914f);
                h.cubicTo(60.89098f, 0.72322047f, 63.00856f, 1.970838f, 62.908672f, 3.9570448f);
                h.cubicTo(63.04851f, 17.002132f, 62.948627f, 30.04722f, 62.958614f, 43.092308f);
                h.cubicTo(63.238297f, 44.82899f, 62.07962f, 46.994858f, 60.11187f, 46.895046f);
                h.cubicTo(53.07991f, 47.05474f, 46.03796f, 46.90503f, 38.99601f, 46.954933f);
                h.lineTo(38.99601f, 50.95729f);
                h.cubicTo(42.32221f, 50.927345f, 45.658394f, 50.8475f, 48.984592f, 51.17687f);
                h.cubicTo(48.984592f, 52.274773f, 48.914673f, 54.400715f, 47.17666f, 53.93161f);
                h.cubicTo(37.068214f, 53.951572f, 26.95977f, 53.951572f, 16.851326f, 53.93161f);
                h.cubicTo(15.083348f, 54.410694f, 14.993451f, 52.25481f, 15.093336f, 51.136948f);
                h.cubicTo(18.389568f, 50.87744f, 21.705776f, 50.917366f, 25.011997f, 50.95729f);
                h.lineTo(25.011997f, 46.954933f);
                h.cubicTo(17.980036f, 46.90503f, 10.948075f, 47.05474f, 3.926103f, 46.895046f);
                h.cubicTo(1.9084098f, 47.0248f, 0.73974586f, 44.80903f, 1.0493919f, 43.032425f);
                h.cubicTo(1.0294148f, 30.336668f, 1.0294148f, 17.650894f, 1.0493919f, 4.9551387f);
                h.lineTo(1.0493919f, 4.9551387f);
                h.close();
                h.moveTo(5.0f, 5.0f);
                h.lineTo(5.0f, 39.0f);
                h.lineTo(59.0f, 39.0f);
                h.lineTo(59.0f, 5.0f);
                h.lineTo(5.0f, 5.0f);
                h.lineTo(5.0f, 5.0f);
                h.close();
                h.moveTo(31.225903f, 41.13082f);
                h.cubicTo(28.789328f, 42.126995f, 30.338081f, 45.77963f, 32.794384f, 44.84987f);
                h.cubicTo(35.201366f, 43.844208f, 33.65261f, 40.276962f, 31.225903f, 41.13082f);
                h.lineTo(31.225903f, 41.13082f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-15658735);
                c = c.a(a, 1.0f, 0.0f, 29.0f, 0.0f, 1.0f, 40.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, 17, 4);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(2.2259018f, 1.130823f);
                h.cubicTo(4.6526113f, 0.2769606f, 6.2013645f, 3.8442078f, 3.7943847f, 4.849868f);
                h.cubicTo(1.3380812f, 5.779629f, -0.21067229f, 2.1269958f, 2.2259018f, 1.130823f);
                h.lineTo(2.2259018f, 1.130823f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
