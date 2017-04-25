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

public final class za extends c {
    private final int height = 36;
    private final int width = 46;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                a.setColor(-9205837);
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(5.990267f, 0.0f);
                h.lineTo(37.95505f, 0.0f);
                h.cubicTo(40.559513f, 1.7584368f, 40.86003f, 5.144684f, 42.122192f, 7.797411f);
                h.cubicTo(43.063805f, 10.480284f, 45.127342f, 13.555036f, 43.214066f, 16.308245f);
                h.cubicTo(40.839996f, 20.166758f, 35.06009f, 19.654299f, 32.565815f, 16.187666f);
                h.cubicTo(30.011436f, 19.634203f, 25.123058f, 19.86531f, 22.03777f, 17.021667f);
                h.cubicTo(18.942465f, 19.87536f, 14.074121f, 19.614107f, 11.52976f, 16.187666f);
                h.cubicTo(8.604748f, 20.4883f, 1.3122491f, 19.734684f, 0.0f, 14.459374f);
                h.lineTo(0.0f, 12.891853f);
                h.cubicTo(2.093588f, 8.671605f, 2.5744123f, 3.4264398f, 5.990267f, 0.0f);
                h.lineTo(5.990267f, 0.0f);
                h.close();
                h.moveTo(7.0525346f, 3.0f);
                h.cubicTo(5.7748885f, 6.6838603f, 4.008143f, 10.197542f, 3.0f, 13.971498f);
                h.cubicTo(4.3075914f, 17.214895f, 8.759391f, 16.0737f, 9.617809f, 13.100585f);
                h.cubicTo(10.8355665f, 13.080564f, 12.053323f, 13.020501f, 13.27108f, 12.910385f);
                h.cubicTo(14.119516f, 14.65221f, 15.756501f, 16.48413f, 17.912529f, 15.883501f);
                h.cubicTo(19.848963f, 15.112693f, 20.777252f, 13.00048f, 22.004992f, 11.4488535f);
                h.cubicTo(23.402416f, 13.110595f, 24.47045f, 16.013638f, 27.025742f, 15.933554f);
                h.cubicTo(28.902285f, 16.153784f, 29.750723f, 14.251791f, 30.698977f, 13.030511f);
                h.lineTo(34.272392f, 13.030511f);
                h.cubicTo(35.260574f, 15.923543f, 39.592594f, 17.315f, 41.0f, 13.981508f);
                h.cubicTo(40.0218f, 10.207553f, 38.235092f, 6.6838603f, 36.96743f, 3.0f);
                h.lineTo(7.0525346f, 3.0f);
                h.lineTo(7.0525346f, 3.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(4.0f, 21.0f);
                h.lineTo(7.0f, 21.0f);
                h.cubicTo(6.99f, 25.0f, 7.01f, 29.0f, 7.0f, 33.0f);
                h.cubicTo(17.0f, 32.99f, 27.0f, 32.99f, 37.0f, 33.0f);
                h.cubicTo(36.99f, 29.0f, 37.01f, 25.0f, 37.0f, 21.0f);
                h.lineTo(40.0f, 21.0f);
                h.lineTo(40.0f, 36.0f);
                h.lineTo(4.0f, 36.0f);
                h.lineTo(4.0f, 21.0f);
                h.lineTo(4.0f, 21.0f);
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
