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

public final class rq extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(1711276032);
                Path h = c.h(looper);
                h.moveTo(90.0f, 0.0f);
                h.cubicTo(139.70563f, 0.0f, 180.0f, 40.29437f, 180.0f, 90.0f);
                h.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
                h.cubicTo(40.29437f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                h.cubicTo(0.0f, 40.29437f, 40.29437f, 0.0f, 90.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(69.0f, 59.64535f);
                h.cubicTo(69.0f, 56.333775f, 71.31589f, 54.997013f, 74.19147f, 56.67054f);
                h.lineTo(126.27224f, 86.98049f);
                h.cubicTo(129.1394f, 88.649124f, 129.14781f, 91.349625f, 126.27224f, 93.023155f);
                h.lineTo(74.19147f, 123.33311f);
                h.cubicTo(71.3243f, 125.00174f, 69.0f, 123.65884f, 69.0f, 120.35829f);
                h.lineTo(69.0f, 59.64535f);
                h.close();
                canvas.saveLayerAlpha(null, 204, 4);
                Paint a2 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-855638017);
                h = c.h(looper);
                h.moveTo(90.0f, 174.0f);
                h.cubicTo(136.39192f, 174.0f, 174.0f, 136.39192f, 174.0f, 90.0f);
                h.cubicTo(174.0f, 43.60808f, 136.39192f, 6.0f, 90.0f, 6.0f);
                h.cubicTo(43.60808f, 6.0f, 6.0f, 43.60808f, 6.0f, 90.0f);
                h.cubicTo(6.0f, 136.39192f, 43.60808f, 174.0f, 90.0f, 174.0f);
                h.close();
                h.moveTo(90.0f, 180.0f);
                h.cubicTo(40.294373f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                h.cubicTo(0.0f, 40.294373f, 40.294373f, 0.0f, 90.0f, 0.0f);
                h.cubicTo(139.70563f, 0.0f, 180.0f, 40.294373f, 180.0f, 90.0f);
                h.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
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
