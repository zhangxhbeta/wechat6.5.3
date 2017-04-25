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

public final class n extends c {
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
                a.setColor(-3355444);
                c = c.a(c, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(14.987003f, 13.975044f);
                h.cubicTo(21.005089f, 9.323351f, 27.003181f, 4.6516933f, 33.021267f, 0.0f);
                h.lineTo(37.0f, 0.0f);
                h.lineTo(37.0f, 56.0f);
                h.cubicTo(35.340527f, 55.740463f, 33.401146f, 56.13975f, 32.03158f, 54.961853f);
                h.cubicTo(26.323397f, 50.619606f, 20.645203f, 46.247414f, 14.937019f, 41.91515f);
                h.cubicTo(10.648384f, 41.835293f, 6.339755f, 42.134758f, 2.0611162f, 41.78538f);
                h.cubicTo(0.22170141f, 41.605705f, -0.06820635f, 39.499466f, 0.01176821f, 38.032085f);
                h.cubicTo(0.00177139f, 31.314081f, 0.00177139f, 24.596079f, 0.01176821f, 17.878075f);
                h.cubicTo(-0.058209527f, 16.440641f, 0.2117046f, 14.274509f, 2.0511193f, 14.144741f);
                h.cubicTo(6.3497515f, 13.735473f, 10.678374f, 14.074866f, 14.987003f, 13.975044f);
                h.lineTo(14.987003f, 13.975044f);
                h.lineTo(14.987003f, 13.975044f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(52.339943f, 7.6842885f);
                h.cubicTo(49.13705f, 5.6012874f, 52.26988f, 0.3937841f, 55.58287f, 2.4867043f);
                h.cubicTo(67.53366f, 9.856561f, 72.35802f, 26.480894f, 66.53276f, 39.147526f);
                h.cubicTo(64.27071f, 44.42446f, 60.207047f, 48.66982f, 55.58287f, 51.9927f);
                h.cubicTo(52.500084f, 52.151405f, 49.997826f, 49.701397f, 51.39909f, 46.68601f);
                h.cubicTo(59.506413f, 42.37122f, 64.41084f, 32.83901f, 62.689285f, 23.80275f);
                h.cubicTo(61.758446f, 17.20658f, 57.504604f, 11.681667f, 52.339943f, 7.6842885f);
                h.lineTo(52.339943f, 7.6842885f);
                h.lineTo(52.339943f, 7.6842885f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(44.38676f, 13.448668f);
                h.cubicTo(47.04146f, 11.830107f, 48.88165f, 14.987299f, 50.44028f, 16.635832f);
                h.cubicTo(54.512833f, 20.991959f, 56.161964f, 27.55612f, 54.13072f, 33.21109f);
                h.cubicTo(52.984367f, 36.618057f, 50.44028f, 39.365616f, 47.57441f, 41.46375f);
                h.cubicTo(46.025837f, 42.682663f, 43.481747f, 41.693542f, 43.05941f, 39.805225f);
                h.cubicTo(42.808018f, 38.60629f, 43.421413f, 37.467304f, 43.652695f, 36.318325f);
                h.cubicTo(45.301826f, 35.149364f, 47.16213f, 34.02037f, 48.036972f, 32.11207f);
                h.cubicTo(50.239166f, 27.815887f, 48.348698f, 22.320776f, 44.47726f, 19.643158f);
                h.cubicTo(43.300747f, 17.834766f, 41.94323f, 14.857414f, 44.38676f, 13.448668f);
                h.lineTo(44.38676f, 13.448668f);
                h.lineTo(44.38676f, 13.448668f);
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
