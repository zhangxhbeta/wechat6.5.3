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

public final class afj extends c {
    private final int height = 242;
    private final int width = 245;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 245;
            case 1:
                return 242;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-3552823);
                c = c.a(c, 1.0f, 0.0f, 55.0f, 0.0f, 1.0f, 75.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(134.481f, 27.64f);
                h.lineTo(125.895f, 36.226f);
                h.cubicTo(110.961f, 21.261f, 90.312f, 12.0f, 67.499f, 12.0f);
                h.cubicTo(44.686f, 12.0f, 24.037f, 21.261f, 9.103f, 36.226f);
                h.lineTo(0.517f, 27.64f);
                h.cubicTo(17.694f, 10.56f, 41.362f, 0.0f, 67.499f, 0.0f);
                h.cubicTo(93.636f, 0.0f, 117.304f, 10.56f, 134.481f, 27.64f);
                h.lineTo(134.481f, 27.64f);
                h.close();
                h.moveTo(115.389f, 46.732f);
                h.lineTo(106.807f, 55.314f);
                h.cubicTo(96.758f, 45.234f, 82.859f, 38.996f, 67.501f, 38.996f);
                h.cubicTo(52.142f, 38.996f, 38.242f, 45.235f, 28.192f, 55.316f);
                h.lineTo(19.608f, 46.732f);
                h.cubicTo(31.899f, 34.537f, 48.817f, 27.0f, 67.499f, 27.0f);
                h.cubicTo(86.181f, 27.0f, 103.098f, 34.537f, 115.389f, 46.732f);
                h.lineTo(115.389f, 46.732f);
                h.close();
                h.moveTo(96.196f, 65.925f);
                h.lineTo(87.607f, 74.514f);
                h.cubicTo(82.517f, 69.262f, 75.393f, 65.993f, 67.502f, 65.993f);
                h.cubicTo(59.609f, 65.993f, 52.484f, 69.263f, 47.394f, 74.517f);
                h.lineTo(38.802f, 65.925f);
                h.cubicTo(46.135f, 58.56f, 56.284f, 54.0f, 67.499f, 54.0f);
                h.cubicTo(78.714f, 54.0f, 88.862f, 58.56f, 96.196f, 65.925f);
                h.lineTo(96.196f, 65.925f);
                h.close();
                h.moveTo(77.2f, 84.921f);
                h.lineTo(67.498f, 94.623f);
                h.lineTo(57.796f, 84.922f);
                h.cubicTo(60.314f, 82.497f, 63.729f, 81.0f, 67.499f, 81.0f);
                h.cubicTo(71.269f, 81.0f, 74.683f, 82.497f, 77.2f, 84.921f);
                h.lineTo(77.2f, 84.921f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-3552823);
                a3.setStrokeWidth(4.0f);
                h = c.h(looper);
                h.moveTo(123.0f, 7.0f);
                h.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                h.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                h.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                h.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                h.close();
                canvas.drawPath(h, a3);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
