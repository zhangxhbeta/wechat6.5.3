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

public final class wy extends c {
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
                g.setColor(-8617594);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(42.9994f, 66.0f);
                h.cubicTo(41.342876f, 66.0f, 40.0f, 67.33791f, 40.0f, 68.99988f);
                h.lineTo(40.0f, 114.00012f);
                h.cubicTo(40.0f, 115.656906f, 41.34472f, 117.0f, 42.9994f, 117.0f);
                h.lineTo(126.0006f, 117.0f);
                h.cubicTo(127.65712f, 117.0f, 129.0f, 115.66209f, 129.0f, 114.00012f);
                h.lineTo(129.0f, 68.99988f);
                h.cubicTo(129.0f, 67.343094f, 127.65528f, 66.0f, 126.0006f, 66.0f);
                h.lineTo(42.9994f, 66.0f);
                h.close();
                h.moveTo(58.95212f, 66.0f);
                h.cubicTo(65.85957f, 66.0f, 69.57021f, 52.0f, 76.2964f, 52.0f);
                h.lineTo(85.0f, 52.0f);
                h.lineTo(85.0f, 66.0f);
                h.lineTo(58.95212f, 66.0f);
                h.close();
                h.moveTo(111.047874f, 66.0f);
                h.cubicTo(104.14043f, 66.0f, 100.42979f, 52.0f, 93.7021f, 52.0f);
                h.lineTo(85.0f, 52.0f);
                h.lineTo(85.0f, 66.0f);
                h.lineTo(111.047874f, 66.0f);
                h.close();
                h.moveTo(84.5f, 70.0f);
                h.cubicTo(95.27f, 70.0f, 104.0f, 78.73f, 104.0f, 89.5f);
                h.cubicTo(104.0f, 100.27f, 95.27f, 109.0f, 84.5f, 109.0f);
                h.cubicTo(73.73f, 109.0f, 65.0f, 100.27f, 65.0f, 89.5f);
                h.cubicTo(65.0f, 78.73f, 73.73f, 70.0f, 84.5f, 70.0f);
                h.close();
                h.moveTo(84.5f, 74.0f);
                h.cubicTo(93.06065f, 74.0f, 100.0f, 80.93935f, 100.0f, 89.5f);
                h.cubicTo(100.0f, 98.06065f, 93.06065f, 105.0f, 84.5f, 105.0f);
                h.cubicTo(75.93935f, 105.0f, 69.0f, 98.06065f, 69.0f, 89.5f);
                h.cubicTo(69.0f, 80.93935f, 75.93935f, 74.0f, 84.5f, 74.0f);
                h.close();
                h.moveTo(47.0f, 58.0f);
                h.lineTo(58.0f, 58.0f);
                h.lineTo(58.0f, 63.0f);
                h.lineTo(47.0f, 63.0f);
                h.lineTo(47.0f, 58.0f);
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
