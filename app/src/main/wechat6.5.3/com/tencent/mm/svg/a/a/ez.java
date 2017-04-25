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

public final class ez extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g.setColor(-8617851);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(77.0f, 71.0f);
                h.lineTo(53.0f, 76.0f);
                h.lineTo(53.0f, 26.0f);
                h.lineTo(77.0f, 21.0f);
                h.lineTo(77.0f, 71.0f);
                h.close();
                h.moveTo(20.0f, 21.0f);
                h.lineTo(44.0f, 26.0f);
                h.lineTo(44.0f, 76.0f);
                h.lineTo(20.0f, 71.0f);
                h.lineTo(20.0f, 21.0f);
                h.close();
                h.moveTo(85.0f, 18.0f);
                h.cubicTo(85.0f, 14.723531f, 82.27647f, 12.0f, 79.0f, 12.0f);
                h.cubicTo(78.840515f, 12.0f, 78.76661f, 12.008562f, 79.0f, 12.0f);
                h.lineTo(79.0f, 12.0f);
                h.lineTo(79.0f, 12.0f);
                h.cubicTo(77.96046f, 12.0468645f, 77.32959f, 12.18205f, 77.0f, 12.0f);
                h.lineTo(49.0f, 18.0f);
                h.lineTo(20.0f, 12.0f);
                h.cubicTo(19.670408f, 12.18205f, 19.039543f, 12.0468645f, 18.0f, 12.0f);
                h.lineTo(18.0f, 12.0f);
                h.lineTo(18.0f, 12.0f);
                h.cubicTo(18.233389f, 12.008562f, 18.159487f, 12.0f, 18.0f, 12.0f);
                h.cubicTo(14.723531f, 12.0f, 12.0f, 14.723531f, 12.0f, 18.0f);
                h.cubicTo(12.0f, 18.159487f, 12.008562f, 18.233389f, 12.0f, 18.0f);
                h.lineTo(12.0f, 18.0f);
                h.lineTo(12.0f, 72.0f);
                h.lineTo(12.0f, 72.0f);
                h.cubicTo(12.008562f, 72.45797f, 12.0f, 72.53187f, 12.0f, 73.0f);
                h.cubicTo(12.0f, 75.96783f, 14.723531f, 78.69136f, 18.0f, 79.0f);
                h.cubicTo(18.159487f, 78.69136f, 18.233389f, 78.68279f, 18.0f, 79.0f);
                h.lineTo(18.0f, 79.0f);
                h.lineTo(49.0f, 85.0f);
                h.lineTo(79.0f, 79.0f);
                h.lineTo(79.0f, 79.0f);
                h.cubicTo(78.76661f, 78.68279f, 78.840515f, 78.69136f, 79.0f, 79.0f);
                h.cubicTo(82.27647f, 78.69136f, 85.0f, 75.96783f, 85.0f, 73.0f);
                h.cubicTo(85.0f, 72.53187f, 84.99144f, 72.45797f, 85.0f, 72.0f);
                h.lineTo(85.0f, 72.0f);
                h.lineTo(85.0f, 18.0f);
                h.lineTo(85.0f, 18.0f);
                h.cubicTo(84.99144f, 18.233389f, 85.0f, 18.159487f, 85.0f, 18.0f);
                h.lineTo(85.0f, 18.0f);
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
