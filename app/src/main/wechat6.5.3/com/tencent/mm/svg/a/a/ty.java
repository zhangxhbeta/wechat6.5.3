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

public final class ty extends c {
    private final int height = 24;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 24;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(60.0f, 24.0f);
                h.cubicTo(66.62742f, 24.0f, 72.0f, 18.627417f, 72.0f, 12.0f);
                h.cubicTo(72.0f, 5.372583f, 66.62742f, 0.0f, 60.0f, 0.0f);
                h.cubicTo(53.37258f, 0.0f, 48.0f, 5.372583f, 48.0f, 12.0f);
                h.cubicTo(48.0f, 18.627417f, 53.37258f, 24.0f, 60.0f, 24.0f);
                h.close();
                h.moveTo(12.0f, 24.0f);
                h.cubicTo(18.627417f, 24.0f, 24.0f, 18.627417f, 24.0f, 12.0f);
                h.cubicTo(24.0f, 5.372583f, 18.627417f, 0.0f, 12.0f, 0.0f);
                h.cubicTo(5.372583f, 0.0f, 0.0f, 5.372583f, 0.0f, 12.0f);
                h.cubicTo(0.0f, 18.627417f, 5.372583f, 24.0f, 12.0f, 24.0f);
                h.close();
                h.moveTo(108.0f, 24.0f);
                h.cubicTo(114.62742f, 24.0f, 120.0f, 18.627417f, 120.0f, 12.0f);
                h.cubicTo(120.0f, 5.372583f, 114.62742f, 0.0f, 108.0f, 0.0f);
                h.cubicTo(101.37258f, 0.0f, 96.0f, 5.372583f, 96.0f, 12.0f);
                h.cubicTo(96.0f, 18.627417f, 101.37258f, 24.0f, 108.0f, 24.0f);
                h.close();
                canvas.saveLayerAlpha(null, 76, 4);
                g2 = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                a2 = c.a(a, looper);
                a2.setColor(-1);
                h = c.h(looper);
                h.moveTo(60.0f, 0.0f);
                h.cubicTo(66.62742f, 0.0f, 72.0f, 5.3725824f, 72.0f, 12.0f);
                h.cubicTo(72.0f, 18.627419f, 66.62742f, 24.0f, 60.0f, 24.0f);
                h.cubicTo(53.37258f, 24.0f, 48.0f, 18.627419f, 48.0f, 12.0f);
                h.cubicTo(48.0f, 5.3725824f, 53.37258f, 0.0f, 60.0f, 0.0f);
                h.close();
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.drawPath(h, c.a(a2, looper));
                canvas.restore();
                a = c.a(a, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(12.0f, 0.0f);
                h.cubicTo(18.627419f, 0.0f, 24.0f, 5.3725824f, 24.0f, 12.0f);
                h.cubicTo(24.0f, 18.627419f, 18.627419f, 24.0f, 12.0f, 24.0f);
                h.cubicTo(5.3725824f, 24.0f, 0.0f, 18.627419f, 0.0f, 12.0f);
                h.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                h.close();
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.drawPath(h, c.a(a, looper));
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
