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

public final class yu extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 8.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(40.739872f, 0.951031f);
                h.cubicTo(42.90053f, -1.4607488f, 46.528423f, 1.1793065f, 46.95051f, 3.7101865f);
                h.cubicTo(47.27209f, 5.1890144f, 45.9556f, 6.2311416f, 45.05114f, 7.1938686f);
                h.cubicTo(36.941135f, 15.133884f, 28.891432f, 23.153301f, 20.801529f, 31.113167f);
                h.cubicTo(19.515184f, 32.60192f, 17.123386f, 32.065968f, 16.058132f, 30.616915f);
                h.cubicTo(11.405182f, 25.892607f, 6.5914383f, 21.327097f, 1.9485373f, 16.592863f);
                h.cubicTo(-1.2271264f, 13.724532f, 4.350384f, 8.295546f, 7.24466f, 11.362377f);
                h.cubicTo(11.103695f, 15.084259f, 14.862233f, 18.905392f, 18.701168f, 22.6372f);
                h.cubicTo(26.077553f, 15.44156f, 33.33334f, 8.116896f, 40.739872f, 0.951031f);
                h.lineTo(40.739872f, 0.951031f);
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
