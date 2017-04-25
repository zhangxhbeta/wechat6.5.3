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

public final class fj extends c {
    private final int height = 144;
    private final int width = 144;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                a.setColor(-9276814);
                Path h = c.h(looper);
                h.moveTo(120.0f, 12.0f);
                h.lineTo(24.0f, 12.0f);
                h.cubicTo(17.4f, 12.0f, 12.06f, 17.4f, 12.06f, 24.0f);
                h.lineTo(12.0f, 132.0f);
                h.lineTo(36.0f, 108.0f);
                h.lineTo(120.0f, 108.0f);
                h.cubicTo(126.6f, 108.0f, 132.0f, 102.6f, 132.0f, 96.0f);
                h.lineTo(132.0f, 24.0f);
                h.cubicTo(132.0f, 17.4f, 126.6f, 12.0f, 120.0f, 12.0f);
                h.lineTo(120.0f, 12.0f);
                h.close();
                h.moveTo(108.0f, 84.0f);
                h.lineTo(36.0f, 84.0f);
                h.lineTo(36.0f, 72.0f);
                h.lineTo(108.0f, 72.0f);
                h.lineTo(108.0f, 84.0f);
                h.lineTo(108.0f, 84.0f);
                h.close();
                h.moveTo(108.0f, 66.0f);
                h.lineTo(36.0f, 66.0f);
                h.lineTo(36.0f, 54.0f);
                h.lineTo(108.0f, 54.0f);
                h.lineTo(108.0f, 66.0f);
                h.lineTo(108.0f, 66.0f);
                h.close();
                h.moveTo(108.0f, 48.0f);
                h.lineTo(36.0f, 48.0f);
                h.lineTo(36.0f, 36.0f);
                h.lineTo(108.0f, 36.0f);
                h.lineTo(108.0f, 48.0f);
                h.lineTo(108.0f, 48.0f);
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
