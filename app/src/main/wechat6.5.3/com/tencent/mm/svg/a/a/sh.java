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

public final class sh extends c {
    private final int height = 56;
    private final int width = 40;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 56;
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
                g.setColor(-7105645);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(40.0f, 0.0f);
                h.lineTo(40.0f, 0.0f);
                h.lineTo(40.0f, 56.0f);
                h.lineTo(40.0f, 56.0f);
                h.cubicTo(28.04299f, 47.66f, 16.135965f, 39.26f, 4.0f, 31.0f);
                h.cubicTo(2.9492626f, 29.86f, 1.6795801f, 28.79f, 0.0f, 29.0f);
                h.lineTo(0.0f, 27.0f);
                h.cubicTo(0.179955f, 27.41f, 0.52986753f, 27.41f, 1.0f, 27.0f);
                h.cubicTo(13.886528f, 18.41f, 26.88328f, 9.13f, 40.0f, 0.0f);
                h.lineTo(40.0f, 0.0f);
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
