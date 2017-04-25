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

public final class cs extends c {
    private final int height = 192;
    private final int width = 192;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                g.setColor(-8421505);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(101.0f, 91.0f);
                h.lineTo(101.0f, 55.997814f);
                h.cubicTo(101.0f, 54.350853f, 99.65671f, 53.0f, 97.99967f, 53.0f);
                h.lineTo(94.00033f, 53.0f);
                h.cubicTo(92.34865f, 53.0f, 91.0f, 54.342167f, 91.0f, 55.997814f);
                h.lineTo(91.0f, 91.0f);
                h.lineTo(55.997814f, 91.0f);
                h.cubicTo(54.350853f, 91.0f, 53.0f, 92.34329f, 53.0f, 94.00033f);
                h.lineTo(53.0f, 97.99967f);
                h.cubicTo(53.0f, 99.65135f, 54.342167f, 101.0f, 55.997814f, 101.0f);
                h.lineTo(91.0f, 101.0f);
                h.lineTo(91.0f, 136.00218f);
                h.cubicTo(91.0f, 137.64914f, 92.34329f, 139.0f, 94.00033f, 139.0f);
                h.lineTo(97.99967f, 139.0f);
                h.cubicTo(99.65135f, 139.0f, 101.0f, 137.65784f, 101.0f, 136.00218f);
                h.lineTo(101.0f, 101.0f);
                h.lineTo(136.00218f, 101.0f);
                h.cubicTo(137.64914f, 101.0f, 139.0f, 99.65671f, 139.0f, 97.99967f);
                h.lineTo(139.0f, 94.00033f);
                h.cubicTo(139.0f, 92.34865f, 137.65784f, 91.0f, 136.00218f, 91.0f);
                h.lineTo(101.0f, 91.0f);
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
