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

public final class nu extends c {
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
                a.setColor(-7368817);
                c = c.a(c, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 15.269435f);
                h.cubicTo(9.8166485f, 5.6009107f, 23.567987f, -0.087618165f, 37.479923f, 0.0012651015f);
                h.cubicTo(51.411938f, -0.09749408f, 65.17332f, 5.591035f, 75.0f, 15.269435f);
                h.cubicTo(73.404045f, 16.839706f, 71.79804f, 18.419853f, 70.21213f, 20.0f);
                h.cubicTo(61.65016f, 11.536338f, 49.65538f, 6.539123f, 37.5f, 6.6280065f);
                h.cubicTo(25.354658f, 6.548999f, 13.349839f, 11.526462f, 4.8079495f, 20.0f);
                h.cubicTo(3.222029f, 18.4001f, 1.5658458f, 16.869333f, 0.0f, 15.269435f);
                h.lineTo(0.0f, 15.269435f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(10.0f, 26.154007f);
                h.cubicTo(17.026365f, 19.148605f, 26.678946f, 14.890619f, 36.52973f, 15.002138f);
                h.cubicTo(46.360695f, 14.910895f, 55.983543f, 19.168882f, 63.0f, 26.143867f);
                h.cubicTo(61.42427f, 27.765959f, 59.84854f, 29.37791f, 58.27281f, 31.0f);
                h.cubicTo(52.505047f, 25.271996f, 44.616493f, 21.693258f, 36.51982f, 21.804777f);
                h.cubicTo(28.413239f, 21.68312f, 20.504862f, 25.251719f, 14.727188f, 31.0f);
                h.cubicTo(13.151459f, 29.388048f, 11.575729f, 27.776096f, 10.0f, 26.154007f);
                h.lineTo(10.0f, 26.154007f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(21.0f, 36.39119f);
                h.cubicTo(26.48116f, 31.299276f, 34.513546f, 28.796799f, 41.967922f, 30.564959f);
                h.cubicTo(46.1635f, 31.386234f, 49.84086f, 33.676147f, 53.0f, 36.39119f);
                h.cubicTo(51.42541f, 37.917797f, 49.880722f, 39.46373f, 48.29617f, 40.990337f);
                h.cubicTo(42.246964f, 35.08681f, 31.763002f, 35.08681f, 25.713797f, 41.0f);
                h.cubicTo(24.13921f, 39.473392f, 22.584553f, 37.917797f, 21.0f, 36.39119f);
                h.lineTo(21.0f, 36.39119f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(31.0f, 47.010326f);
                h.cubicTo(34.274048f, 44.367195f, 38.80581f, 44.26062f, 42.0f, 47.106247f);
                h.cubicTo(40.193283f, 49.088593f, 38.356625f, 51.038967f, 36.529945f, 53.0f);
                h.cubicTo(34.61343f, 51.070942f, 32.82668f, 49.01399f, 31.0f, 47.010326f);
                h.lineTo(31.0f, 47.010326f);
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
