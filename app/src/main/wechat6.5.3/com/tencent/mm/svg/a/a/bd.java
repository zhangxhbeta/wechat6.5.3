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

public final class bd extends c {
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-14111675);
                Path h = c.h(looper);
                h.moveTo(0.0f, 4.0f);
                h.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                h.lineTo(86.0f, 0.0f);
                h.cubicTo(88.20914f, 0.0f, 90.0f, 1.7908609f, 90.0f, 4.0f);
                h.lineTo(90.0f, 86.0f);
                h.cubicTo(90.0f, 88.20914f, 88.20914f, 90.0f, 86.0f, 90.0f);
                h.lineTo(4.0f, 90.0f);
                h.cubicTo(1.7908609f, 90.0f, 0.0f, 88.20914f, 0.0f, 86.0f);
                h.lineTo(0.0f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(26.997292f, 18.0f);
                h.cubicTo(25.894218f, 18.0f, 25.0f, 18.895992f, 25.0f, 19.99926f);
                h.lineTo(25.0f, 67.00074f);
                h.cubicTo(25.0f, 68.104904f, 25.89154f, 69.0f, 26.997292f, 69.0f);
                h.lineTo(63.00271f, 69.0f);
                h.cubicTo(64.10578f, 69.0f, 65.0f, 68.104004f, 65.0f, 67.00074f);
                h.lineTo(65.0f, 19.99926f);
                h.cubicTo(65.0f, 18.8951f, 64.10846f, 18.0f, 63.00271f, 18.0f);
                h.lineTo(26.997292f, 18.0f);
                h.close();
                h.moveTo(29.0f, 22.0f);
                h.lineTo(29.0f, 65.0f);
                h.lineTo(61.0f, 65.0f);
                h.lineTo(61.0f, 22.0f);
                h.lineTo(29.0f, 22.0f);
                h.close();
                h.moveTo(57.0f, 27.0f);
                h.lineTo(57.0f, 31.0f);
                h.lineTo(33.0f, 31.0f);
                h.lineTo(33.0f, 27.0f);
                h.lineTo(57.0f, 27.0f);
                h.close();
                h.moveTo(52.0f, 36.0f);
                h.lineTo(52.0f, 40.0f);
                h.lineTo(33.0f, 40.0f);
                h.lineTo(33.0f, 36.0f);
                h.lineTo(52.0f, 36.0f);
                h.close();
                h.moveTo(46.0f, 45.0f);
                h.lineTo(46.0f, 49.0f);
                h.lineTo(33.0f, 49.0f);
                h.lineTo(33.0f, 45.0f);
                h.lineTo(46.0f, 45.0f);
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
