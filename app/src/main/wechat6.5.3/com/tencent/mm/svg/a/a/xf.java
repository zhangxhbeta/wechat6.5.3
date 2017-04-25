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

public final class xf extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 50.0f, 0.0f, 1.0f, 36.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(24.867924f, 54.0f);
                h.lineTo(2.0f, 54.0f);
                h.cubicTo(1.277121f, 54.0f, 0.50183654f, 53.545902f, -1.0658141E-14f, 53.0f);
                h.cubicTo(-0.17057356f, 51.97461f, 0.02324753f, 51.06792f, 1.0f, 50.0f);
                h.lineTo(43.0f, 1.0f);
                h.cubicTo(43.767178f, 0.09632745f, 44.461952f, -0.13072085f, 45.0f, 7.1054274E-15f);
                h.cubicTo(45.696445f, 0.28127408f, 46.048306f, 0.8571648f, 46.0f, 1.0f);
                h.lineTo(42.132076f, 42.0f);
                h.lineTo(67.0f, 42.0f);
                h.cubicTo(67.66808f, 42.0f, 68.47741f, 42.454098f, 69.0f, 43.0f);
                h.cubicTo(69.17823f, 44.026894f, 68.97627f, 44.93208f, 68.0f, 46.0f);
                h.lineTo(24.0f, 95.0f);
                h.cubicTo(23.331083f, 95.90367f, 22.604643f, 96.12922f, 22.0f, 96.0f);
                h.cubicTo(21.31604f, 95.717224f, 20.949804f, 95.14284f, 21.0f, 95.0f);
                h.lineTo(24.867924f, 54.0f);
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
