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

public final class lx extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                g.setColor(-16754776);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(43.703125f, 99.5f);
                h.lineTo(25.0f, 35.0f);
                h.lineTo(35.6875f, 35.0f);
                h.lineTo(45.484375f, 72.625f);
                h.lineTo(49.046875f, 86.0625f);
                h.cubicTo(49.428513f, 85.38936f, 50.493137f, 80.95579f, 52.609375f, 72.625f);
                h.lineTo(62.40625f, 35.0f);
                h.lineTo(73.09375f, 35.0f);
                h.lineTo(82.0f, 72.625f);
                h.lineTo(85.5625f, 85.166664f);
                h.lineTo(89.125f, 72.625f);
                h.lineTo(99.8125f, 35.0f);
                h.lineTo(109.609375f, 35.0f);
                h.lineTo(90.015625f, 99.5f);
                h.lineTo(79.328125f, 99.5f);
                h.lineTo(69.53125f, 60.979168f);
                h.lineTo(66.859375f, 50.229168f);
                h.lineTo(54.390625f, 99.5f);
                h.lineTo(43.703125f, 99.5f);
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
