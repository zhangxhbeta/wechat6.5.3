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

public final class vd extends c {
    private final int height = 38;
    private final int width = 24;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 38;
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
                g.setColor(-3684404);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(24.0f, 18.928122f);
                h.cubicTo(17.76f, 25.30391f, 11.27f, 31.564438f, 5.0f, 37.856243f);
                h.cubicTo(3.9782472f, 37.015377f, 0.34215337f, 33.172558f, 0.0f, 32.87516f);
                h.cubicTo(4.52f, 28.130583f, 10.31f, 23.60038f, 15.0f, 18.928122f);
                h.cubicTo(10.89f, 14.514881f, 0.0f, 3.9848678f, 0.0f, 3.9848678f);
                h.cubicTo(0.046293356f, 3.965954f, 3.7586608f, 0.9880148f, 5.0f, 0.0f);
                h.cubicTo(5.0f, 0.0f, 18.55f, 13.568475f, 24.0f, 18.928122f);
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
