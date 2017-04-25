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

public final class aak extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                g.setColor(-1973786);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(168.0f, 0.0f);
                h.lineTo(168.0f, 168.0f);
                h.lineTo(0.0f, 168.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                h.moveTo(0.0f, 11.997895f);
                h.cubicTo(0.0f, 5.3716407f, 5.3758125f, 0.0f, 11.997895f, 0.0f);
                h.lineTo(156.0021f, 0.0f);
                h.cubicTo(162.62836f, 0.0f, 168.0f, 5.3758125f, 168.0f, 11.997895f);
                h.lineTo(168.0f, 156.0021f);
                h.cubicTo(168.0f, 162.62836f, 162.62419f, 168.0f, 156.0021f, 168.0f);
                h.lineTo(11.997895f, 168.0f);
                h.cubicTo(5.3716407f, 168.0f, 0.0f, 162.62419f, 0.0f, 156.0021f);
                h.lineTo(0.0f, 11.997895f);
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
