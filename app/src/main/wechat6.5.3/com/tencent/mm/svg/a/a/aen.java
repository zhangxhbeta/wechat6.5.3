package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aen extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                g = c.a(g, looper);
                g.setColor(-16139513);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(25.802883f, 46.304134f);
                h.cubicTo(32.66371f, 53.164963f, 39.164425f, 56.38293f, 41.568413f, 56.19449f);
                h.cubicTo(43.972404f, 56.006046f, 49.959015f, 51.88904f, 52.785183f, 51.94384f);
                h.cubicTo(54.143463f, 51.970177f, 63.019405f, 57.972977f, 64.09384f, 58.667f);
                h.cubicTo(65.168274f, 59.361023f, 66.16451f, 60.171726f, 65.97718f, 61.197594f);
                h.cubicTo(65.789856f, 62.22346f, 61.88898f, 73.52336f, 51.930058f, 71.95859f);
                h.cubicTo(41.97113f, 70.39381f, 28.086994f, 59.657917f, 20.175474f, 51.931545f);
                h.lineTo(25.802883f, 46.304134f);
                h.lineTo(25.802883f, 46.304134f);
                h.close();
                h.moveTo(25.802883f, 46.304134f);
                h.cubicTo(18.942055f, 39.443306f, 15.724086f, 32.942593f, 15.91253f, 30.538603f);
                h.cubicTo(16.100973f, 28.134613f, 20.217976f, 22.148005f, 20.163176f, 19.321836f);
                h.cubicTo(20.13684f, 17.963554f, 14.13404f, 9.087612f, 13.440018f, 8.01318f);
                h.cubicTo(12.7459955f, 6.938746f, 11.935291f, 5.9425087f, 10.909425f, 6.129835f);
                h.cubicTo(9.883557f, 6.317161f, -1.4163445f, 10.218036f, 0.14843264f, 20.176962f);
                h.cubicTo(1.7132099f, 30.13589f, 12.449101f, 44.020023f, 20.175474f, 51.931545f);
                h.lineTo(25.802883f, 46.304134f);
                h.close();
                h.moveTo(71.95439f, 37.577858f);
                h.cubicTo(72.06316f, 27.928717f, 68.43634f, 18.245283f, 61.07391f, 10.8828535f);
                h.cubicTo(53.78275f, 3.591691f, 44.215294f, -0.035837848f, 34.659115f, 2.668559E-4f);
                h.lineTo(34.659115f, 2.668559E-4f);
                h.lineTo(34.659115f, 6.1705666f);
                h.cubicTo(42.622982f, 6.140183f, 50.596336f, 9.163122f, 56.672596f, 15.239385f);
                h.cubicTo(62.831516f, 21.398304f, 65.85348f, 29.506277f, 65.73848f, 37.577858f);
                h.lineTo(71.95439f, 37.577858f);
                h.close();
                h.moveTo(56.445175f, 37.661373f);
                h.cubicTo(56.561077f, 31.967367f, 54.446472f, 26.236395f, 50.10136f, 21.891281f);
                h.cubicTo(45.83891f, 17.628828f, 40.24282f, 15.512826f, 34.65626f, 15.543274f);
                h.lineTo(34.65626f, 15.543274f);
                h.lineTo(34.65626f, 21.736135f);
                h.cubicTo(38.657936f, 21.7056f, 42.669193f, 23.216957f, 45.72244f, 26.270203f);
                h.cubicTo(48.858353f, 29.406116f, 50.367752f, 33.552616f, 50.250637f, 37.661373f);
                h.lineTo(56.445175f, 37.661373f);
                h.lineTo(56.445175f, 37.661373f);
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
