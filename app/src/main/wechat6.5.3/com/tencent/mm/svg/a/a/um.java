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

public final class um extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-5329234);
                c = c.a(c, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(16.0f, 7.0f);
                h.cubicTo(27.910854f, 4.663105f, 39.921577f, 2.3910866f, 52.0f, 0.0f);
                h.cubicTo(54.208645f, -0.5415185f, 56.33523f, 1.6604376f, 56.0f, 4.0f);
                h.cubicTo(55.985794f, 19.005846f, 55.995777f, 34.099255f, 56.0f, 49.0f);
                h.cubicTo(55.44666f, 57.790302f, 42.477474f, 61.5036f, 37.0f, 55.0f);
                h.cubicTo(34.92959f, 52.02518f, 35.728306f, 47.741375f, 38.0f, 45.0f);
                h.cubicTo(40.870052f, 42.206455f, 45.08329f, 41.305656f, 49.0f, 41.0f);
                h.cubicTo(48.977043f, 32.257618f, 48.987026f, 23.02942f, 49.0f, 14.0f);
                h.cubicTo(39.332523f, 15.622841f, 29.688002f, 17.494503f, 20.0f, 19.0f);
                h.cubicTo(20.053465f, 31.536978f, 19.96361f, 43.767845f, 20.0f, 56.0f);
                h.cubicTo(19.86377f, 61.453556f, 14.093031f, 65.026726f, 9.0f, 65.0f);
                h.cubicTo(4.6282225f, 65.236916f, -0.3138455f, 61.933983f, 7.1054274E-15f, 57.0f);
                h.cubicTo(0.65460014f, 50.924202f, 7.4037676f, 47.641285f, 13.0f, 48.0f);
                h.cubicTo(13.064682f, 35.75072f, 13.004778f, 23.289652f, 13.0f, 11.0f);
                h.cubicTo(12.815083f, 9.006964f, 13.983208f, 7.135301f, 16.0f, 7.0f);
                h.lineTo(16.0f, 7.0f);
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
