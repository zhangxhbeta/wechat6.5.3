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

public final class dt extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                float[] a = c.a(c, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-36352);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(15.346995f, 0.5783295f);
                h.cubicTo(22.18465f, -1.1732551f, 29.903292f, 1.1388365f, 34.658615f, 6.363563f);
                h.cubicTo(39.944534f, 11.888561f, 41.47625f, 20.57642f, 38.49291f, 27.612785f);
                h.cubicTo(35.00901f, 36.751053f, 24.08678f, 42.07587f, 14.7263f, 39.2333f);
                h.cubicTo(7.2579393f, 37.361607f, 1.3813599f, 30.705584f, 0.2901382f, 23.098701f);
                h.cubicTo(-1.5319017f, 13.179729f, 5.4358993f, 2.6401947f, 15.346995f, 0.5783295f);
                h.lineTo(15.346995f, 0.5783295f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-70474);
                c = c.a(a, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(a3, looper);
                h = c.h(looper);
                h.moveTo(13.42649f, 0.6276179f);
                h.cubicTo(22.175201f, -1.8918488f, 32.143734f, 3.4270253f, 34.983315f, 12.055199f);
                h.cubicTo(37.472946f, 18.893751f, 35.273273f, 27.092016f, 29.664099f, 31.721035f);
                h.cubicTo(23.984934f, 36.70998f, 15.086246f, 37.41983f, 8.687188f, 33.41068f);
                h.cubicTo(2.7280664f, 29.891422f, -0.7814165f, 22.712942f, 0.1484465f, 15.854395f);
                h.cubicTo(0.91833305f, 8.685912f, 6.4475183f, 2.3772476f, 13.42649f, 0.6276179f);
                h.lineTo(13.42649f, 0.6276179f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-36352);
                Path h2 = c.h(looper);
                h2.moveTo(15.0255995f, 27.656855f);
                h2.lineTo(15.003011f, 27.679443f);
                h2.lineTo(17.831438f, 30.50787f);
                h2.lineTo(31.450668f, 16.88864f);
                h2.lineTo(28.622242f, 14.060212f);
                h2.lineTo(17.854027f, 24.828426f);
                h2.lineTo(11.996721f, 18.971123f);
                h2.lineTo(9.168295f, 21.79955f);
                h2.lineTo(15.0255995f, 27.656855f);
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
