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

public final class bl extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g2 = c.a(g, looper);
                g2.setColor(-13008703);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(86.0f, 0.0f);
                h.cubicTo(88.20914f, 0.0f, 90.0f, 1.7908609f, 90.0f, 4.0f);
                h.lineTo(90.0f, 86.0f);
                h.cubicTo(90.0f, 88.20914f, 88.20914f, 90.0f, 86.0f, 90.0f);
                h.lineTo(4.0f, 90.0f);
                h.cubicTo(1.7908609f, 90.0f, 0.0f, 88.20914f, 0.0f, 86.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(29.596294f, 64.99123f);
                h.lineTo(18.0f, 25.0f);
                h.lineTo(24.626453f, 25.0f);
                h.lineTo(30.700703f, 48.328217f);
                h.lineTo(32.90952f, 56.65972f);
                h.cubicTo(33.146145f, 56.24236f, 33.806232f, 53.49346f, 35.11834f, 48.328217f);
                h.lineTo(41.19259f, 25.0f);
                h.lineTo(47.819042f, 25.0f);
                h.lineTo(53.341084f, 48.328217f);
                h.lineTo(55.549904f, 56.10429f);
                h.lineTo(57.75872f, 48.328217f);
                h.lineTo(64.38518f, 25.0f);
                h.lineTo(70.45943f, 25.0f);
                h.lineTo(58.310925f, 64.99123f);
                h.lineTo(51.68447f, 64.99123f);
                h.lineTo(45.61022f, 41.10758f);
                h.lineTo(43.95361f, 34.442375f);
                h.lineTo(36.222748f, 64.99123f);
                h.lineTo(29.596294f, 64.99123f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
