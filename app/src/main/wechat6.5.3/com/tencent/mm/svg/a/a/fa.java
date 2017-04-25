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

public final class fa extends c {
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
                g.setColor(-8683387);
                canvas.save();
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(69.0f, 12.0f);
                h.lineTo(60.0f, 21.0f);
                h.lineTo(69.0f, 29.0f);
                h.lineTo(77.0f, 21.0f);
                h.lineTo(69.0f, 12.0f);
                h.close();
                h.moveTo(20.0f, 60.0f);
                h.lineTo(20.0f, 60.0f);
                h.lineTo(20.0f, 60.0f);
                h.lineTo(20.0f, 69.0f);
                h.lineTo(29.0f, 69.0f);
                h.lineTo(63.0f, 34.0f);
                h.lineTo(55.0f, 26.0f);
                h.lineTo(20.0f, 60.0f);
                h.close();
                h.moveTo(12.0f, 85.0f);
                h.lineTo(85.0f, 85.0f);
                h.lineTo(85.0f, 77.0f);
                h.lineTo(12.0f, 77.0f);
                h.lineTo(12.0f, 85.0f);
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
