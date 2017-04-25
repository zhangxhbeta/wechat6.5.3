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

public final class abw extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-2105120);
                c = c.a(c, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 6.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(18.423912f, 1.6996584f);
                h.cubicTo(26.590271f, -0.43927705f, 35.747402f, 2.4392903f, 41.2717f, 8.786131f);
                h.cubicTo(48.177082f, 16.36236f, 48.967697f, 28.696222f, 42.943005f, 37.01208f);
                h.cubicTo(39.270145f, 41.95962f, 30.072983f, 41.249973f, 27.981354f, 35.123024f);
                h.cubicTo(24.368542f, 36.812183f, 19.955105f, 37.791695f, 16.30226f, 35.65276f);
                h.cubicTo(11.628621f, 33.084038f, 10.357632f, 27.037048f, 11.458488f, 22.179464f);
                h.cubicTo(12.289135f, 17.721684f, 14.821107f, 12.594236f, 19.814995f, 11.914575f);
                h.cubicTo(22.547123f, 11.174942f, 25.129133f, 12.32437f, 27.130692f, 14.123475f);
                h.cubicTo(27.36087f, 13.603733f, 27.831238f, 12.564251f, 28.071424f, 12.054504f);
                h.cubicTo(30.283146f, 12.04451f, 32.49487f, 12.004529f, 34.706593f, 11.944559f);
                h.cubicTo(28.351643f, 6.4073153f, 17.833452f, 6.757141f, 12.219081f, 13.183943f);
                h.cubicTo(5.884148f, 19.700699f, 6.924958f, 31.424864f, 14.320717f, 36.71223f);
                h.cubicTo(17.863476f, 39.71074f, 22.60717f, 39.87066f, 26.980576f, 40.360416f);
                h.cubicTo(30.393232f, 40.600296f, 30.303162f, 46.77722f, 26.860481f, 46.85718f);
                h.cubicTo(20.415462f, 47.576824f, 13.670211f, 45.55783f, 8.806423f, 41.229984f);
                h.cubicTo(2.4314594f, 35.73272f, -0.45078483f, 26.54729f, 1.7108984f, 18.401346f);
                h.cubicTo(3.6424024f, 10.315371f, 10.347624f, 3.6486883f, 18.423912f, 1.6996584f);
                h.lineTo(18.423912f, 1.6996584f);
                h.close();
                h.moveTo(35.088074f, 12.0f);
                h.cubicTo(34.97896f, 18.984352f, 34.959118f, 25.989065f, 35.097996f, 32.983597f);
                h.cubicTo(38.321896f, 33.278854f, 39.15515f, 29.521967f, 39.680897f, 27.027555f);
                h.cubicTo(40.8415f, 21.570395f, 38.728603f, 15.9706955f, 35.088074f, 12.0f);
                h.lineTo(35.088074f, 12.0f);
                h.close();
                h.moveTo(19.826458f, 29.112526f);
                h.cubicTo(22.167404f, 30.596699f, 25.000652f, 30.143202f, 27.0f, 28.318907f);
                h.cubicTo(26.89953f, 24.783693f, 26.92967f, 21.24848f, 26.959812f, 17.713264f);
                h.cubicTo(25.60347f, 17.434982f, 24.257175f, 17.043327f, 22.88074f, 17.0021f);
                h.cubicTo(17.153961f, 16.837193f, 14.632171f, 26.432774f, 19.826458f, 29.112526f);
                h.lineTo(19.826458f, 29.112526f);
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
