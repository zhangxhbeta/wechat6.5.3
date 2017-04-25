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

public final class ns extends c {
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
                c = c.a(c, 1.0f, 0.0f, -2815.0f, 0.0f, 1.0f, -1426.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 2744.0f, 0.0f, 1.0f, 1222.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 71.0f, 0.0f, 1.0f, 204.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-15028967);
                Path h = c.h(looper);
                h.moveTo(120.0f, 60.415924f);
                h.cubicTo(120.0f, 26.718575f, 93.13778f, 0.0f, 59.25926f, 0.0f);
                h.cubicTo(26.862223f, 0.0f, 0.0f, 26.718575f, 0.0f, 60.415924f);
                h.cubicTo(0.0f, 92.63972f, 26.862223f, 119.35829f, 59.25926f, 119.35829f);
                h.cubicTo(93.13778f, 119.35829f, 120.0f, 92.63972f, 120.0f, 60.415924f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(29.1438f, 64.33318f);
                h.cubicTo(28.75939f, 63.93746f, 28.708668f, 63.263554f, 29.03661f, 62.819717f);
                h.lineTo(31.330149f, 59.71563f);
                h.cubicTo(31.655361f, 59.275486f, 32.276066f, 59.19089f, 32.720627f, 59.5298f);
                h.lineTo(48.21306f, 71.34036f);
                h.cubicTo(48.65579f, 71.67787f, 49.36143f, 71.66416f, 49.780098f, 71.317245f);
                h.lineTo(88.357925f, 39.350655f);
                h.cubicTo(88.78065f, 39.000374f, 89.44368f, 39.031097f, 89.842575f, 39.42294f);
                h.lineTo(91.87533f, 41.419743f);
                h.cubicTo(92.27255f, 41.809944f, 92.26884f, 42.44513f, 91.874504f, 42.831135f);
                h.lineTo(49.733486f, 84.082405f);
                h.cubicTo(49.3358f, 84.471695f, 48.706734f, 84.47158f, 48.31737f, 84.07076f);
                h.lineTo(29.1438f, 64.33318f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
