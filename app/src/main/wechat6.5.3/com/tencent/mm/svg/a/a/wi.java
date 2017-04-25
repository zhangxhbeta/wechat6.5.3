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

public final class wi extends c {
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 22.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(11.0f, 11.0f);
                h.cubicTo(9.951573f, 6.6049995f, 12.71513f, 1.5564079f, 17.0f, 0.0f);
                h.cubicTo(21.716715f, -1.1690271f, 27.1437f, 2.21011f, 28.0f, 7.0f);
                h.cubicTo(28.655645f, 10.929491f, 26.342669f, 14.70085f, 23.0f, 17.0f);
                h.cubicTo(22.998363f, 17.164803f, 22.988352f, 18.482265f, 23.0f, 19.0f);
                h.cubicTo(29.656933f, 19.135967f, 36.345543f, 19.135967f, 43.0f, 19.0f);
                h.cubicTo(43.014122f, 18.341467f, 42.9941f, 16.762526f, 43.0f, 16.0f);
                h.cubicTo(38.368145f, 12.920768f, 37.58714f, 5.5791903f, 42.0f, 2.0f);
                h.cubicTo(46.198223f, -1.7623875f, 53.61777f, 0.14843407f, 55.0f, 5.0f);
                h.cubicTo(57.172344f, 9.672371f, 54.939472f, 14.49971f, 51.0f, 17.0f);
                h.cubicTo(51.034447f, 17.154747f, 51.024433f, 18.472208f, 51.0f, 19.0f);
                h.cubicTo(55.329975f, 19.246593f, 59.665554f, 18.8946f, 64.0f, 19.0f);
                h.cubicTo(66.66456f, 20.041092f, 66.674576f, 24.21473f, 64.0f, 25.0f);
                h.cubicTo(59.68558f, 25.411507f, 55.329975f, 25.059513f, 51.0f, 25.0f);
                h.cubicTo(51.104538f, 26.909994f, 50.694008f, 28.840929f, 52.0f, 30.0f);
                h.cubicTo(55.269897f, 36.816093f, 59.144882f, 43.07152f, 63.0f, 50.0f);
                h.cubicTo(64.07122f, 52.49489f, 59.635513f, 55.491863f, 58.0f, 53.0f);
                h.cubicTo(53.777977f, 47.154644f, 50.623917f, 40.979675f, 47.0f, 35.0f);
                h.cubicTo(43.875233f, 40.617626f, 40.731186f, 46.229404f, 38.0f, 52.0f);
                h.cubicTo(36.195347f, 54.536453f, 31.709576f, 54.566624f, 30.0f, 53.0f);
                h.cubicTo(26.062307f, 46.97362f, 22.888222f, 40.909275f, 19.0f, 35.0f);
                h.cubicTo(15.989344f, 40.879105f, 12.835284f, 46.90322f, 9.0f, 53.0f);
                h.cubicTo(7.3382096f, 55.75334f, 2.1615477f, 52.52506f, 4.0f, 49.0f);
                h.cubicTo(7.588532f, 42.7497f, 11.543622f, 36.273018f, 15.0f, 30.0f);
                h.cubicTo(16.159563f, 28.348139f, 15.919253f, 26.68874f, 16.0f, 25.0f);
                h.cubicTo(11.383416f, 25.059513f, 6.677359f, 25.411507f, 2.0f, 25.0f);
                h.cubicTo(-0.6520735f, 24.275072f, -0.692125f, 20.010921f, 2.0f, 19.0f);
                h.cubicTo(6.6473207f, 18.824202f, 11.333351f, 19.276764f, 16.0f, 19.0f);
                h.cubicTo(15.979331f, 18.482265f, 15.969317f, 17.164803f, 16.0f, 17.0f);
                h.cubicTo(13.89665f, 15.19364f, 11.924111f, 13.433673f, 11.0f, 11.0f);
                h.lineTo(11.0f, 11.0f);
                h.close();
                h.moveTo(23.0f, 25.0f);
                h.cubicTo(23.14918f, 26.464657f, 22.83093f, 28.077757f, 24.0f, 29.0f);
                h.cubicTo(26.858776f, 34.93591f, 30.081055f, 40.458057f, 33.0f, 46.0f);
                h.cubicTo(36.276978f, 40.774742f, 39.32024f, 35.569275f, 42.0f, 30.0f);
                h.cubicTo(43.31825f, 28.74081f, 42.860767f, 26.771442f, 43.0f, 25.0f);
                h.lineTo(23.0f, 25.0f);
                h.lineTo(23.0f, 25.0f);
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
