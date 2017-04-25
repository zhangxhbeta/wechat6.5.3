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

public final class sb extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-921103);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(120.0f, 0.0f);
                h.lineTo(120.0f, 120.0f);
                h.lineTo(0.0f, 120.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3552823);
                Path h2 = c.h(looper);
                h2.moveTo(50.865784f, 61.30489f);
                h2.cubicTo(54.72159f, 67.43002f, 48.319912f, 70.20336f, 45.64623f, 71.743996f);
                h2.cubicTo(34.143787f, 78.28783f, 29.117647f, 80.738686f, 29.117647f, 83.92295f);
                h2.lineTo(29.117647f, 88.272575f);
                h2.cubicTo(29.117647f, 89.670944f, 30.16357f, 90.882355f, 31.727423f, 90.882355f);
                h2.lineTo(88.272575f, 90.882355f);
                h2.cubicTo(89.83643f, 90.882355f, 90.882355f, 89.670944f, 90.882355f, 88.272575f);
                h2.lineTo(90.882355f, 83.92295f);
                h2.cubicTo(90.882355f, 80.738686f, 85.85622f, 78.28783f, 74.35377f, 71.743996f);
                h2.cubicTo(71.680084f, 70.20336f, 65.27841f, 67.43002f, 69.13422f, 61.30489f);
                h2.cubicTo(72.55844f, 56.21983f, 75.23033f, 54.14847f, 75.223694f, 45.64623f);
                h2.cubicTo(75.23033f, 37.574806f, 69.26139f, 29.117647f, 60.434963f, 29.117647f);
                h2.cubicTo(50.73861f, 29.117647f, 44.769665f, 37.574806f, 44.776306f, 45.64623f);
                h2.cubicTo(44.769665f, 54.14847f, 47.44156f, 56.21983f, 50.865784f, 61.30489f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
