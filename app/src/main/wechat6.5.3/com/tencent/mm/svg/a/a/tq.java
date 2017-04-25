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

public final class tq extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                g.setColor(-5592406);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(28.0f, 24.0f);
                h.lineTo(34.0f, 24.0f);
                h.lineTo(34.0f, 36.0f);
                h.lineTo(28.0f, 36.0f);
                h.lineTo(28.0f, 24.0f);
                h.close();
                h.moveTo(38.0f, 24.0f);
                h.lineTo(43.0f, 24.0f);
                h.lineTo(43.0f, 36.0f);
                h.lineTo(38.0f, 36.0f);
                h.lineTo(38.0f, 24.0f);
                h.close();
                h.moveTo(47.0f, 24.0f);
                h.lineTo(51.0f, 24.0f);
                h.lineTo(51.0f, 36.0f);
                h.lineTo(47.0f, 36.0f);
                h.lineTo(47.0f, 24.0f);
                h.close();
                h.moveTo(25.763962f, 14.012434f);
                h.cubicTo(26.998892f, 12.900997f, 28.0f, 13.345539f, 28.0f, 15.00742f);
                h.lineTo(28.0f, 44.99258f);
                h.cubicTo(28.0f, 46.653534f, 27.008198f, 47.107376f, 25.763962f, 45.987564f);
                h.lineTo(10.236038f, 32.012436f);
                h.cubicTo(9.001108f, 30.900997f, 8.991803f, 29.107378f, 10.236038f, 27.987566f);
                h.lineTo(25.763962f, 14.012434f);
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
