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

public final class ax extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g2 = c.a(g, looper);
                g2.setColor(-1029070);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.19334534f, 4.0f);
                h.cubicTo(0.19334534f, 1.7908609f, 1.9842064f, 0.0f, 4.1933455f, 0.0f);
                h.lineTo(85.99379f, 0.0f);
                h.cubicTo(88.20293f, 0.0f, 89.99379f, 1.7908609f, 89.99379f, 4.0f);
                h.lineTo(89.99379f, 85.800446f);
                h.cubicTo(89.99379f, 88.00958f, 88.20293f, 89.800446f, 85.99379f, 89.800446f);
                h.lineTo(4.1933455f, 89.800446f);
                h.cubicTo(1.9842064f, 89.800446f, 0.19334534f, 88.00958f, 0.19334534f, 85.800446f);
                h.lineTo(0.19334534f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(34.45098f, 58.6f);
                h.lineTo(34.45098f, 31.0f);
                h.lineTo(43.70383f, 31.0f);
                h.cubicTo(52.31826f, 31.0f, 56.731438f, 35.522312f, 56.731438f, 43.73879f);
                h.cubicTo(56.731438f, 51.95526f, 52.294743f, 58.6f, 43.70383f, 58.6f);
                h.lineTo(34.45098f, 58.6f);
                h.lineTo(34.45098f, 58.6f);
                h.close();
                h.moveTo(38.78039f, 54.270588f);
                h.lineTo(38.78039f, 35.32941f);
                h.cubicTo(38.78039f, 35.32941f, 37.591053f, 35.32941f, 43.449726f, 35.32941f);
                h.cubicTo(49.308403f, 35.32941f, 52.309803f, 38.43296f, 52.309803f, 44.071716f);
                h.cubicTo(52.309803f, 49.710472f, 49.292408f, 54.270588f, 43.449726f, 54.270588f);
                h.lineTo(38.78039f, 54.270588f);
                h.close();
                h.moveTo(11.0f, 58.6f);
                h.lineTo(11.0f, 31.0f);
                h.lineTo(22.520216f, 31.0f);
                h.cubicTo(26.711445f, 31.0f, 29.61963f, 33.975212f, 30.320621f, 35.246155f);
                h.cubicTo(31.021612f, 36.517097f, 31.384314f, 37.614456f, 31.384314f, 39.138462f);
                h.cubicTo(31.384314f, 41.329617f, 30.642769f, 43.31582f, 29.256931f, 44.8f);
                h.cubicTo(27.676542f, 46.566586f, 25.711292f, 47.630768f, 21.811089f, 47.77647f);
                h.cubicTo(17.910885f, 47.630768f, 15.690196f, 47.77647f, 15.690196f, 47.77647f);
                h.lineTo(15.690196f, 58.6f);
                h.lineTo(11.0f, 58.6f);
                h.close();
                h.moveTo(15.690196f, 44.52941f);
                h.lineTo(20.375517f, 44.52941f);
                h.cubicTo(25.660982f, 44.52941f, 26.694118f, 40.955162f, 26.694118f, 39.397568f);
                h.cubicTo(26.694118f, 37.83997f, 25.486412f, 34.60784f, 20.375517f, 34.60784f);
                h.lineTo(15.690196f, 34.60784f);
                h.lineTo(15.690196f, 44.52941f);
                h.close();
                h.moveTo(59.705883f, 31.0f);
                h.lineTo(59.705883f, 58.6f);
                h.lineTo(64.03529f, 58.6f);
                h.lineTo(64.03529f, 45.611763f);
                h.lineTo(77.02353f, 45.611763f);
                h.lineTo(77.02353f, 41.82353f);
                h.lineTo(64.03529f, 41.82353f);
                h.lineTo(64.03529f, 35.32941f);
                h.lineTo(78.64706f, 35.32941f);
                h.lineTo(78.64706f, 31.0f);
                h.lineTo(59.705883f, 31.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
