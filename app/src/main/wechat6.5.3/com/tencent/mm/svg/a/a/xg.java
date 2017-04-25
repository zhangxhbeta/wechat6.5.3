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

public final class xg extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 50.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(53.458427f, 68.67285f);
                h.cubicTo(83.84122f, 68.67285f, 105.827965f, 35.957947f, 105.827965f, 35.957947f);
                h.cubicTo(106.46974f, 35.062405f, 106.47585f, 33.603374f, 105.81945f, 32.703407f);
                h.cubicTo(105.81945f, 32.703407f, 83.84122f, 2.4963452E-15f, 53.458427f, 0.0f);
                h.cubicTo(23.075638f, -2.4963452E-15f, 1.0888885f, 32.714905f, 1.0888885f, 32.714905f);
                h.cubicTo(0.4471118f, 33.610447f, 0.44100174f, 35.069477f, 1.0974094f, 35.969444f);
                h.cubicTo(1.0974094f, 35.969444f, 23.075642f, 68.67285f, 53.458427f, 68.67285f);
                h.close();
                h.moveTo(53.458427f, 54.626133f);
                h.cubicTo(64.858315f, 54.626133f, 74.09975f, 45.54212f, 74.09975f, 34.336426f);
                h.cubicTo(74.09975f, 23.13073f, 64.858315f, 14.04672f, 53.458427f, 14.04672f);
                h.cubicTo(42.058544f, 14.04672f, 32.817112f, 23.13073f, 32.817112f, 34.336426f);
                h.cubicTo(32.817112f, 45.54212f, 42.058544f, 54.626133f, 53.458427f, 54.626133f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(41.175587f, 25.24117f);
                h.cubicTo(39.181583f, 27.849945f, 38.0f, 31.093002f, 38.0f, 34.607468f);
                h.cubicTo(38.0f, 43.22759f, 45.10843f, 50.21493f, 53.877937f, 50.21493f);
                h.cubicTo(62.64744f, 50.21493f, 69.755875f, 43.22759f, 69.755875f, 34.607468f);
                h.cubicTo(69.755875f, 25.987343f, 62.64744f, 19.0f, 53.877937f, 19.0f);
                h.cubicTo(51.33193f, 19.0f, 48.92593f, 19.588953f, 46.793247f, 20.635828f);
                h.cubicTo(49.016388f, 21.031485f, 50.702347f, 22.943605f, 50.702347f, 25.242987f);
                h.cubicTo(50.702347f, 27.829023f, 48.56982f, 29.925226f, 45.93897f, 29.925226f);
                h.cubicTo(43.308117f, 29.925226f, 41.175587f, 27.829023f, 41.175587f, 25.242987f);
                h.cubicTo(41.175587f, 25.24238f, 41.175587f, 25.241776f, 41.175587f, 25.24117f);
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
