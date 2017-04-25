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

public final class au extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                g2 = c.a(g, looper);
                g2.setColor(-12206054);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(180.0f, 0.0f);
                h.lineTo(180.0f, 180.0f);
                h.lineTo(0.0f, 180.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(90.5913f, 147.6f);
                h2.cubicTo(92.65838f, 147.6f, 130.8f, 106.356995f, 130.8f, 75.1625f);
                h2.cubicTo(130.8f, 52.10819f, 112.53322f, 33.6f, 90.5913f, 33.6f);
                h2.cubicTo(67.46678f, 33.6f, 49.2f, 52.10819f, 49.2f, 75.1625f);
                h2.cubicTo(49.2f, 106.356995f, 87.34162f, 147.6f, 90.5913f, 147.6f);
                h2.close();
                h2.moveTo(90.0f, 87.6f);
                h2.cubicTo(97.9529f, 87.6f, 104.4f, 81.1529f, 104.4f, 73.2f);
                h2.cubicTo(104.4f, 65.2471f, 97.9529f, 58.8f, 90.0f, 58.8f);
                h2.cubicTo(82.0471f, 58.8f, 75.6f, 65.2471f, 75.6f, 73.2f);
                h2.cubicTo(75.6f, 81.1529f, 82.0471f, 87.6f, 90.0f, 87.6f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
