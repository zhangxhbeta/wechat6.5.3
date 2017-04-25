package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class act extends c {
    private final int height = 72;
    private final int width = 210;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 72;
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
                a.setColor(-11286451);
                Path h = c.h(looper);
                h.moveTo(0.0f, 12.0f);
                h.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                h.lineTo(198.0f, 0.0f);
                h.cubicTo(204.62741f, 0.0f, 210.0f, 5.3725824f, 210.0f, 12.0f);
                h.lineTo(210.0f, 60.0f);
                h.cubicTo(210.0f, 66.62742f, 204.62741f, 72.0f, 198.0f, 72.0f);
                h.lineTo(12.0f, 72.0f);
                h.cubicTo(5.3725824f, 72.0f, 0.0f, 66.62742f, 0.0f, 60.0f);
                h.lineTo(0.0f, 12.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(105.0f, 11.0f);
                h.cubicTo(105.0f, 6.581722f, 108.58172f, 3.0f, 113.0f, 3.0f);
                h.lineTo(199.0f, 3.0f);
                h.cubicTo(203.41827f, 3.0f, 207.0f, 6.581722f, 207.0f, 11.0f);
                h.lineTo(207.0f, 61.0f);
                h.cubicTo(207.0f, 65.41828f, 203.41827f, 69.0f, 199.0f, 69.0f);
                h.lineTo(113.0f, 69.0f);
                h.cubicTo(108.58172f, 69.0f, 105.0f, 65.41828f, 105.0f, 61.0f);
                h.lineTo(105.0f, 11.0f);
                h.close();
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
