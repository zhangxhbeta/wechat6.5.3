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

public final class ja extends c {
    private final int height = 192;
    private final int width = 192;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                g2.setColor(-12953699);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(192.0f, 0.0f);
                h.lineTo(192.0f, 192.0f);
                h.lineTo(0.0f, 192.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(104.72727f, 192.0f);
                h2.lineTo(104.72727f, 117.818184f);
                h2.lineTo(80.0f, 117.818184f);
                h2.lineTo(80.0f, 87.27273f);
                h2.lineTo(104.72727f, 87.27273f);
                h2.lineTo(104.72727f, 61.090908f);
                h2.cubicTo(104.62603f, 44.320255f, 121.209656f, 29.09091f, 138.18182f, 29.09091f);
                h2.lineTo(164.36363f, 29.09091f);
                h2.lineTo(164.36363f, 58.18182f);
                h2.lineTo(148.36363f, 58.18182f);
                h2.cubicTo(137.98802f, 58.097572f, 133.74586f, 62.3439f, 133.81818f, 72.72727f);
                h2.lineTo(133.81818f, 87.27273f);
                h2.lineTo(164.36363f, 87.27273f);
                h2.lineTo(158.54546f, 117.818184f);
                h2.lineTo(133.81818f, 117.818184f);
                h2.lineTo(133.81818f, 192.0f);
                h2.lineTo(104.72727f, 192.0f);
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
