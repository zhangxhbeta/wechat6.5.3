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

public final class sl extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-855310);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(4.0f, 56.998116f);
                h.cubicTo(4.0f, 56.9978f, 73.99772f, 57.0f, 73.99772f, 57.0f);
                h.cubicTo(74.00232f, 57.0f, 74.0f, 14.001884f, 74.0f, 14.001884f);
                h.cubicTo(74.0f, 14.004772f, 56.5f, 14.0f, 56.5f, 14.0f);
                h.lineTo(49.0f, 4.0f);
                h.lineTo(29.0f, 4.0f);
                h.lineTo(21.5f, 14.0f);
                h.lineTo(3.999805f, 14.0f);
                h.cubicTo(3.9999309f, 14.00048f, 4.0f, 56.998116f, 4.0f, 56.998116f);
                h.close();
                h.moveTo(3.993171f, 10.0f);
                h.lineTo(19.5f, 10.0f);
                h.lineTo(27.0f, 0.0f);
                h.lineTo(51.0f, 0.0f);
                h.lineTo(58.5f, 10.0f);
                h.lineTo(74.00683f, 10.0f);
                h.cubicTo(76.20044f, 10.0f, 78.0f, 11.791705f, 78.0f, 14.001884f);
                h.lineTo(78.0f, 56.998116f);
                h.cubicTo(78.0f, 59.214787f, 76.20812f, 61.0f, 73.99772f, 61.0f);
                h.lineTo(4.002278f, 61.0f);
                h.cubicTo(1.7944237f, 61.0f, 0.0f, 59.208294f, 0.0f, 56.998116f);
                h.lineTo(0.0f, 14.001884f);
                h.cubicTo(0.0f, 11.785213f, 1.7878035f, 10.0f, 3.993171f, 10.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(21.0f, 33.0f);
                h.cubicTo(21.0f, 42.941124f, 29.058874f, 51.0f, 39.0f, 51.0f);
                h.cubicTo(44.03602f, 51.0f, 48.588997f, 48.93187f, 51.855957f, 45.598595f);
                h.lineTo(49.027344f, 42.769985f);
                h.cubicTo(46.484406f, 45.379486f, 42.931446f, 47.0f, 39.0f, 47.0f);
                h.cubicTo(31.268013f, 47.0f, 25.0f, 40.731987f, 25.0f, 33.0f);
                h.lineTo(30.5f, 33.0f);
                h.lineTo(22.5f, 25.0f);
                h.lineTo(14.5f, 33.0f);
                h.lineTo(21.0f, 33.0f);
                h.close();
                h.moveTo(57.0f, 33.0f);
                h.cubicTo(57.0f, 23.058874f, 48.941124f, 15.0f, 39.0f, 15.0f);
                h.cubicTo(33.96398f, 15.0f, 29.411005f, 17.068129f, 26.144045f, 20.401403f);
                h.lineTo(28.972656f, 23.230017f);
                h.cubicTo(31.515596f, 20.620514f, 35.068554f, 19.0f, 39.0f, 19.0f);
                h.cubicTo(46.731987f, 19.0f, 53.0f, 25.268013f, 53.0f, 33.0f);
                h.lineTo(47.5f, 33.0f);
                h.lineTo(55.5f, 41.0f);
                h.lineTo(63.5f, 33.0f);
                h.lineTo(57.0f, 33.0f);
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
