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

public final class ly extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                g.setColor(-16743362);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(36.0f, 102.0f);
                h.lineTo(62.74134f, 66.040924f);
                h.lineTo(39.159912f, 33.0f);
                h.lineTo(50.05453f, 33.0f);
                h.lineTo(62.599854f, 50.697136f);
                h.cubicTo(65.20954f, 54.368366f, 67.0646f, 57.19235f, 68.16507f, 59.169167f);
                h.cubicTo(69.705734f, 56.658924f, 71.52934f, 54.038895f, 73.63596f, 51.309006f);
                h.lineTo(87.549f, 33.0f);
                h.lineTo(97.50037f, 33.0f);
                h.lineTo(73.211494f, 65.52319f);
                h.lineTo(99.38689f, 102.0f);
                h.lineTo(88.067795f, 102.0f);
                h.lineTo(70.6647f, 77.38404f);
                h.cubicTo(69.689995f, 75.97202f, 68.68387f, 74.434525f, 67.64628f, 72.771484f);
                h.cubicTo(66.10561f, 75.28173f, 65.005165f, 77.0075f, 64.34488f, 77.94884f);
                h.lineTo(46.988945f, 102.0f);
                h.lineTo(36.0f, 102.0f);
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
