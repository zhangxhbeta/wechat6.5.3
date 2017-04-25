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

public final class gy extends c {
    private final int height = 21;
    private final int width = 28;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 21;
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
                g.setColor(-2763307);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(9.740437f, 16.82034f);
                h.cubicTo(15.206292f, 11.2271185f, 20.54201f, 5.501695f, 26.097961f, 0.0f);
                h.cubicTo(26.568466f, 0.4881356f, 27.519485f, 1.4745762f, 28.0f, 1.9728813f);
                h.cubicTo(22.303898f, 8.583051f, 15.887022f, 14.532204f, 10.040758f, 21.0f);
                h.cubicTo(6.677154f, 18.21356f, 3.283518f, 15.488135f, 0.0f, 12.620339f);
                h.lineTo(0.0f, 10.932203f);
                h.cubicTo(0.41043976f, 10.718644f, 1.2313193f, 10.291526f, 1.641759f, 10.088136f);
                h.cubicTo(4.3346443f, 12.335593f, 7.0275297f, 14.593221f, 9.740437f, 16.82034f);
                h.lineTo(9.740437f, 16.82034f);
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
