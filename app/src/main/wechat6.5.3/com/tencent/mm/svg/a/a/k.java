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

public final class k extends c {
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 19.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(42.313f, 39.809f);
                h.cubicTo(39.234f, 38.115f, 32.741f, 35.447f, 37.025f, 29.307f);
                h.cubicTo(37.36f, 28.827f, 37.571f, 28.341f, 37.692f, 27.858f);
                h.cubicTo(40.269f, 24.814f, 42.161f, 20.834f, 42.29f, 17.135f);
                h.lineTo(42.314f, 17.135f);
                h.lineTo(42.314f, 11.863f);
                h.lineTo(42.252f, 11.863f);
                h.cubicTo(41.627f, 3.408f, 34.667f, 0.0f, 29.092f, 0.0f);
                h.cubicTo(23.51f, 0.0f, 16.542f, 3.216f, 15.929f, 11.863f);
                h.lineTo(15.868f, 11.863f);
                h.lineTo(15.868f, 17.135f);
                h.lineTo(15.893f, 17.135f);
                h.cubicTo(16.022f, 20.837f, 17.908f, 24.816f, 20.495f, 27.863f);
                h.cubicTo(20.615f, 28.344f, 20.822f, 28.828f, 21.156f, 29.307f);
                h.cubicTo(25.441f, 35.447f, 18.947f, 38.115f, 15.868f, 39.809f);
                h.cubicTo(4.042f, 46.316f, 1.028f, 48.37f, 0.262f, 51.119f);
                h.cubicTo(0.1f, 51.408f, 0.0f, 51.735f, 0.0f, 52.089f);
                h.lineTo(0.0f, 55.999f);
                h.cubicTo(0.0f, 57.103f, 0.896f, 57.999f, 2.0f, 57.999f);
                h.lineTo(56.182f, 57.999f);
                h.cubicTo(57.286f, 57.999f, 58.182f, 57.103f, 58.182f, 55.999f);
                h.lineTo(58.182f, 52.089f);
                h.cubicTo(58.182f, 51.735f, 58.082f, 51.407f, 57.92f, 51.119f);
                h.cubicTo(57.153f, 48.37f, 54.138f, 46.315f, 42.313f, 39.809f);
                h.lineTo(42.313f, 39.809f);
                h.lineTo(42.313f, 39.809f);
                h.close();
                h.moveTo(79.943f, 47.53f);
                h.cubicTo(79.661f, 45.044f, 77.982f, 43.752f, 68.098f, 38.315f);
                h.cubicTo(65.788f, 37.044f, 60.918f, 35.042f, 64.132f, 30.437f);
                h.cubicTo(64.382f, 30.078f, 64.538f, 29.715f, 64.628f, 29.354f);
                h.cubicTo(66.567f, 27.069f, 67.982f, 24.085f, 68.079f, 21.309f);
                h.lineTo(68.098f, 21.309f);
                h.lineTo(68.098f, 17.354f);
                h.lineTo(68.052f, 17.354f);
                h.cubicTo(67.583f, 11.013f, 62.364f, 8.457f, 58.181f, 8.457f);
                h.cubicTo(53.995f, 8.457f, 48.769f, 10.87f, 48.309f, 17.354f);
                h.lineTo(48.264f, 17.354f);
                h.lineTo(48.264f, 21.309f);
                h.lineTo(48.283f, 21.309f);
                h.cubicTo(48.38f, 24.085f, 49.795f, 27.07f, 51.735f, 29.354f);
                h.cubicTo(51.825f, 29.715f, 51.98f, 30.078f, 52.231f, 30.437f);
                h.cubicTo(55.12f, 34.577f, 51.48f, 36.61f, 49.036f, 37.903f);
                h.cubicTo(64.284f, 46.296f, 65.378f, 47.545f, 65.449f, 51.956f);
                h.lineTo(78.045f, 51.956f);
                h.cubicTo(79.125f, 51.956f, 80.0f, 51.082f, 80.0f, 50.003f);
                h.lineTo(80.0f, 47.98f);
                h.cubicTo(79.999f, 47.824f, 79.977f, 47.675f, 79.943f, 47.53f);
                h.lineTo(79.943f, 47.53f);
                h.lineTo(79.943f, 47.53f);
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
