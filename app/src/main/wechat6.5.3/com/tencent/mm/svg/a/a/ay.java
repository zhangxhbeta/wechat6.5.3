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

public final class ay extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 23.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(26.599453f, 7.383812E-15f);
                h.lineTo(35.745975f, 0.0f);
                h.cubicTo(46.030285f, 0.0f, 51.298946f, 5.4486866f, 51.298946f, 15.3482685f);
                h.cubicTo(51.298946f, 25.247852f, 46.00221f, 33.253735f, 35.745975f, 33.253735f);
                h.lineTo(26.599453f, 33.253735f);
                h.lineTo(26.599453f, 7.383812E-15f);
                h.close();
                h.moveTo(31.768106f, 5.216272f);
                h.cubicTo(31.768106f, 5.216272f, 28.448256f, 5.216272f, 35.442616f, 5.216272f);
                h.cubicTo(42.436977f, 5.216272f, 46.02019f, 8.955566f, 46.02019f, 15.749397f);
                h.cubicTo(46.02019f, 22.543228f, 42.41788f, 28.037462f, 35.442616f, 28.037462f);
                h.lineTo(31.768106f, 28.037462f);
                h.lineTo(31.768106f, 5.216272f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 33.253735f);
                h.lineTo(0.0f, 0.0f);
                h.cubicTo(0.0f, 0.0f, 6.980508f, 8.159173E-16f, 12.058983f, 0.0f);
                h.cubicTo(17.137459f, -8.0728937E-16f, 20.661282f, 3.5846686f, 21.510666f, 5.115959f);
                h.cubicTo(21.59788f, 5.27319f, 21.68077f, 5.428216f, 21.75931f, 5.5818195f);
                h.cubicTo(22.445667f, 6.9241815f, 22.79953f, 8.157933f, 22.79953f, 9.805588f);
                h.cubicTo(22.79953f, 12.445591f, 21.901007f, 14.838656f, 20.2218f, 16.626867f);
                h.cubicTo(18.306856f, 18.755327f, 15.92558f, 20.037506f, 11.199739f, 20.213055f);
                h.cubicTo(6.473898f, 20.037506f, 5.6830688f, 20.213055f, 5.6830688f, 20.213055f);
                h.lineTo(5.6830688f, 33.253735f);
                h.lineTo(0.0f, 33.253735f);
                h.close();
                h.moveTo(5.6830688f, 16.30085f);
                h.lineTo(11.36023f, 16.30085f);
                h.cubicTo(17.764584f, 16.30085f, 17.116463f, 11.837833f, 17.116463f, 9.892929f);
                h.cubicTo(17.116463f, 7.9480257f, 17.553057f, 3.912204f, 11.36023f, 3.912204f);
                h.lineTo(5.6830688f, 3.912204f);
                h.lineTo(5.6830688f, 16.30085f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(53.198906f, 0.0f);
                h2.lineTo(53.198906f, 33.253735f);
                h2.lineTo(58.410225f, 33.253735f);
                h2.lineTo(58.410225f, 17.604918f);
                h2.lineTo(72.144226f, 17.604918f);
                h2.lineTo(72.144226f, 13.04068f);
                h2.lineTo(58.410225f, 13.04068f);
                h2.lineTo(58.410225f, 5.216272f);
                h2.lineTo(74.09847f, 5.216272f);
                h2.lineTo(74.09847f, 0.0f);
                h2.lineTo(53.198906f, 0.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
