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

public final class gc extends c {
    private final int height = 60;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 60;
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
                g = c.a(g, looper);
                g.setColor(-2565928);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(41.408173f, 42.897102f);
                h.cubicTo(41.20714f, 42.543682f, 40.927578f, 42.21132f, 40.650383f, 42.022015f);
                h.lineTo(40.28045f, 41.76938f);
                h.lineTo(38.0f, 39.48893f);
                h.lineTo(38.0f, 27.0f);
                h.lineTo(37.967194f, 27.0f);
                h.lineTo(37.967194f, 27.0f);
                h.cubicTo(37.54229f, 20.544485f, 33.03346f, 15.204463f, 27.0f, 13.539232f);
                h.lineTo(27.0f, 13.539232f);
                h.lineTo(27.0f, 12.001665f);
                h.cubicTo(27.0f, 10.33902f, 25.656855f, 9.0f, 24.0f, 9.0f);
                h.cubicTo(22.346518f, 9.0f, 21.0f, 10.343891f, 21.0f, 12.001665f);
                h.lineTo(21.0f, 13.132172f);
                h.cubicTo(18.522533f, 13.46226f, 16.236237f, 14.397065f, 14.294383f, 15.783313f);
                h.lineTo(5.9233284f, 7.4122577f);
                h.cubicTo(5.1494994f, 6.638429f, 3.8807518f, 6.6303186f, 3.1032145f, 7.407856f);
                h.lineTo(2.407856f, 8.103214f);
                h.cubicTo(1.627709f, 8.883362f, 1.6322894f, 10.14336f, 2.412258f, 10.923328f);
                h.lineTo(42.400352f, 50.911423f);
                h.cubicTo(43.17418f, 51.68525f, 44.44293f, 51.69336f, 45.220467f, 50.915825f);
                h.lineTo(45.915825f, 50.220467f);
                h.cubicTo(46.695972f, 49.44032f, 46.69139f, 48.18032f, 45.911423f, 47.400352f);
                h.lineTo(41.408173f, 42.897102f);
                h.close();
                h.moveTo(31.48893f, 47.0f);
                h.lineTo(18.014584f, 47.0f);
                h.lineTo(8.999534f, 47.0f);
                h.lineTo(8.999534f, 47.0f);
                h.lineTo(6.606894f, 47.0f);
                h.cubicTo(5.497854f, 47.0f, 4.788665f, 46.126583f, 5.0140424f, 45.049168f);
                h.lineTo(5.3250933f, 43.56219f);
                h.cubicTo(5.4382153f, 43.021416f, 5.897074f, 42.33107f, 6.349618f, 42.022015f);
                h.lineTo(8.0f, 40.894924f);
                h.lineTo(8.0f, 27.0f);
                h.lineTo(8.0328045f, 27.0f);
                h.cubicTo(8.099805f, 25.982077f, 8.268347f, 24.991888f, 8.528398f, 24.039469f);
                h.lineTo(31.48893f, 47.0f);
                h.lineTo(31.48893f, 47.0f);
                h.close();
                h.moveTo(29.0f, 49.0f);
                h.cubicTo(29.0f, 51.761425f, 26.761423f, 54.0f, 24.0f, 54.0f);
                h.cubicTo(21.238577f, 54.0f, 19.0f, 51.761425f, 19.0f, 49.0f);
                h.lineTo(29.0f, 49.0f);
                h.lineTo(29.0f, 49.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
