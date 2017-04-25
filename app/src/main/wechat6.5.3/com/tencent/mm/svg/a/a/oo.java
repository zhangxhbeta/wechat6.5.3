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

public final class oo extends c {
    private final int height = 33;
    private final int width = 38;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 33;
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
                g.setColor(-4547478);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(14.666667f, 23.0f);
                h.lineTo(33.0f, 23.0f);
                h.lineTo(33.0f, 5.0f);
                h.lineTo(5.0f, 5.0f);
                h.lineTo(5.0f, 23.0f);
                h.lineTo(11.0f, 23.0f);
                h.lineTo(11.0f, 26.0f);
                h.lineTo(14.666667f, 23.0f);
                h.close();
                h.moveTo(15.222222f, 27.0f);
                h.lineTo(35.000294f, 27.0f);
                h.cubicTo(36.110107f, 27.0f, 37.0f, 26.105911f, 37.0f, 25.002995f);
                h.lineTo(37.0f, 2.9970047f);
                h.cubicTo(37.0f, 1.8949789f, 36.104702f, 1.0f, 35.000294f, 1.0f);
                h.lineTo(2.9997072f, 1.0f);
                h.cubicTo(1.8898926f, 1.0f, 1.0f, 1.8940895f, 1.0f, 2.9970047f);
                h.lineTo(1.0f, 25.002995f);
                h.cubicTo(1.0f, 26.10502f, 1.8952994f, 27.0f, 2.9997072f, 27.0f);
                h.lineTo(8.0f, 27.0f);
                h.lineTo(8.0f, 32.0f);
                h.lineTo(15.222222f, 27.0f);
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
