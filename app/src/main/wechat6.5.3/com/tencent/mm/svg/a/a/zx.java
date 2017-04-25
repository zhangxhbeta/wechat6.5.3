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

public final class zx extends c {
    private final int height = 78;
    private final int width = 78;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -326.0f, 0.0f, 1.0f, -237.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 326.0f, 0.0f, 1.0f, 237.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-11184811);
                a2.setStrokeWidth(3.0f);
                Path h = c.h(looper);
                h.moveTo(28.72093f, 39.7907f);
                h.cubicTo(33.18872f, 47.180103f, 26.14078f, 50.233418f, 22.39535f, 52.44186f);
                h.cubicTo(10.53354f, 59.134026f, 5.0f, 61.832302f, 5.0f, 65.093025f);
                h.lineTo(5.0f, 69.83721f);
                h.cubicTo(5.0f, 71.6663f, 6.1515117f, 73.0f, 8.16279f, 73.0f);
                h.lineTo(69.83721f, 73.0f);
                h.cubicTo(71.84849f, 73.0f, 73.0f, 71.6663f, 73.0f, 69.83721f);
                h.lineTo(73.0f, 65.093025f);
                h.cubicTo(73.0f, 61.832302f, 67.46646f, 59.134026f, 55.604652f, 52.44186f);
                h.cubicTo(51.859222f, 50.233418f, 44.81128f, 47.180103f, 49.279068f, 39.7907f);
                h.cubicTo(52.82625f, 34.83821f, 55.76787f, 32.557747f, 55.604652f, 23.976744f);
                h.cubicTo(55.76787f, 14.310931f, 49.19635f, 5.0f, 39.7907f, 5.0f);
                h.cubicTo(28.803648f, 5.0f, 22.232128f, 14.310931f, 22.39535f, 23.976744f);
                h.cubicTo(22.232128f, 32.557747f, 25.173754f, 34.83821f, 28.72093f, 39.7907f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-11184811);
                h = c.h(looper);
                h.moveTo(33.032784f, 62.02452f);
                h.cubicTo(32.495216f, 63.592533f, 33.032784f, 65.79082f, 34.231796f, 66.93293f);
                h.lineTo(37.862457f, 70.39129f);
                h.cubicTo(38.465904f, 70.9661f, 39.44163f, 70.9806f, 40.061115f, 70.40576f);
                h.lineTo(43.83273f, 66.90594f);
                h.cubicTo(45.048244f, 65.778015f, 45.590824f, 63.605457f, 45.03445f, 62.02452f);
                h.lineTo(38.955097f, 44.75f);
                h.lineTo(33.032784f, 62.02452f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
