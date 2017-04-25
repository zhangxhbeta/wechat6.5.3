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

public final class tr extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(58.99807f, 24.0f);
                h.lineTo(47.996223f, 24.0f);
                h.cubicTo(47.445435f, 24.0f, 46.99807f, 24.443586f, 46.99807f, 24.990778f);
                h.lineTo(46.99807f, 29.009222f);
                h.cubicTo(46.99807f, 29.549025f, 47.444958f, 30.0f, 47.996223f, 30.0f);
                h.lineTo(58.99807f, 30.0f);
                h.lineTo(58.99807f, 41.001846f);
                h.cubicTo(58.99807f, 41.552635f, 59.441654f, 42.0f, 59.988846f, 42.0f);
                h.lineTo(64.00729f, 42.0f);
                h.cubicTo(64.5471f, 42.0f, 64.99807f, 41.553112f, 64.99807f, 41.001846f);
                h.lineTo(64.99807f, 30.0f);
                h.lineTo(75.999916f, 30.0f);
                h.cubicTo(76.550705f, 30.0f, 76.99807f, 29.556414f, 76.99807f, 29.009222f);
                h.lineTo(76.99807f, 24.990778f);
                h.cubicTo(76.99807f, 24.450975f, 76.55118f, 24.0f, 75.999916f, 24.0f);
                h.lineTo(64.99807f, 24.0f);
                h.lineTo(64.99807f, 12.998154f);
                h.cubicTo(64.99807f, 12.447365f, 64.55448f, 12.0f, 64.00729f, 12.0f);
                h.lineTo(59.988846f, 12.0f);
                h.cubicTo(59.449043f, 12.0f, 58.99807f, 12.446889f, 58.99807f, 12.998154f);
                h.lineTo(58.99807f, 24.0f);
                h.close();
                h.moveTo(55.99517f, 51.671585f);
                h.cubicTo(55.95076f, 47.44745f, 55.089516f, 46.365105f, 40.725517f, 38.43724f);
                h.cubicTo(37.76138f, 36.80069f, 31.511587f, 34.22469f, 35.636276f, 28.296413f);
                h.cubicTo(35.95876f, 27.832f, 36.162483f, 27.363724f, 36.278343f, 26.896414f);
                h.cubicTo(38.76552f, 23.956413f, 40.579723f, 20.117517f, 40.703312f, 16.545103f);
                h.lineTo(40.726482f, 16.545103f);
                h.lineTo(40.726482f, 11.454897f);
                h.lineTo(40.666622f, 11.454897f);
                h.cubicTo(40.0651f, 3.2904828f, 33.36538f, 0.0f, 27.999035f, 0.0f);
                h.cubicTo(22.626896f, 0.0f, 15.920414f, 3.106069f, 15.329517f, 11.454897f);
                h.lineTo(15.271586f, 11.454897f);
                h.lineTo(15.271586f, 16.545103f);
                h.lineTo(15.294759f, 16.545103f);
                h.cubicTo(15.4183445f, 20.117517f, 17.232552f, 23.956413f, 19.719725f, 26.896414f);
                h.cubicTo(19.835587f, 27.362759f, 20.038345f, 27.832f, 20.361794f, 28.296413f);
                h.cubicTo(24.485518f, 34.22469f, 18.235723f, 36.801655f, 15.272552f, 38.43724f);
                h.cubicTo(0.90855175f, 46.365105f, 0.047310345f, 47.44745f, 0.0028965517f, 51.671585f);
                h.cubicTo(0.0028965517f, 51.680275f, 0.0f, 51.688965f, 0.0f, 51.69862f);
                h.lineTo(0.0f, 52.66414f);
                h.cubicTo(0.0f, 54.50538f, 1.4936552f, 55.999035f, 3.3358622f, 55.999035f);
                h.lineTo(52.66414f, 55.999035f);
                h.cubicTo(54.506344f, 55.999035f, 56.0f, 54.50538f, 56.0f, 52.66414f);
                h.lineTo(56.0f, 51.69862f);
                h.cubicTo(55.99807f, 51.68993f, 55.99517f, 51.68124f, 55.99517f, 51.671585f);
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
