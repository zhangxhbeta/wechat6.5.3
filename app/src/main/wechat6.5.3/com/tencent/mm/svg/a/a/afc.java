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

public final class afc extends c {
    private final int height = 39;
    private final int width = 39;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(15.911817f, 28.210007f);
                h.cubicTo(12.592391f, 26.960802f, 10.230769f, 23.756193f, 10.230769f, 20.0f);
                h.cubicTo(10.230769f, 15.156888f, 14.156888f, 11.230769f, 19.0f, 11.230769f);
                h.cubicTo(23.843113f, 11.230769f, 27.76923f, 15.156888f, 27.76923f, 20.0f);
                h.cubicTo(27.76923f, 20.19488f, 27.762875f, 20.388273f, 27.750357f, 20.579987f);
                h.cubicTo(30.774906f, 21.11086f, 33.20298f, 23.374031f, 33.973866f, 26.308788f);
                h.cubicTo(34.5412f, 26.484497f, 35.077324f, 26.731188f, 35.57187f, 27.038485f);
                h.cubicTo(36.491306f, 24.876438f, 37.0f, 22.497625f, 37.0f, 20.0f);
                h.cubicTo(37.0f, 10.058874f, 28.941126f, 2.0f, 19.0f, 2.0f);
                h.cubicTo(9.058874f, 2.0f, 1.0f, 10.058874f, 1.0f, 20.0f);
                h.cubicTo(1.0f, 29.941126f, 9.058874f, 38.0f, 19.0f, 38.0f);
                h.cubicTo(19.099163f, 38.0f, 19.198141f, 37.9992f, 19.296925f, 37.9976f);
                h.cubicTo(19.3516f, 37.999195f, 19.406475f, 38.0f, 19.461538f, 38.0f);
                h.lineTo(32.384617f, 38.0f);
                h.lineTo(32.384617f, 37.9793f);
                h.cubicTo(34.97223f, 37.74612f, 37.0f, 35.571404f, 37.0f, 32.923077f);
                h.cubicTo(37.0f, 30.269276f, 34.96384f, 28.091045f, 32.368565f, 27.865429f);
                h.cubicTo(32.142185f, 24.75823f, 29.549576f, 22.307692f, 26.384615f, 22.307692f);
                h.cubicTo(23.496096f, 22.307692f, 21.084314f, 24.348843f, 20.512947f, 27.067463f);
                h.cubicTo(20.216953f, 26.979319f, 19.868599f, 26.929428f, 19.461538f, 26.923077f);
                h.cubicTo(18.110815f, 26.923077f, 16.873026f, 27.406603f, 15.911817f, 28.210007f);
                h.close();
                canvas.saveLayerAlpha(null, 76, 4);
                g2 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
