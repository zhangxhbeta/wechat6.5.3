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

public final class yz extends c {
    private final int height = 36;
    private final int width = 46;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                g.setColor(-9205837);
                canvas.save();
                g2 = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(9.0f, 12.0f);
                h.lineTo(36.0f, 12.0f);
                h.lineTo(36.0f, 17.0f);
                h.lineTo(9.0f, 17.0f);
                h.lineTo(9.0f, 12.0f);
                h.lineTo(9.0f, 12.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 3.0074198f);
                h2.cubicTo(0.0f, 1.3464677f, 1.3517805f, 0.0f, 3.0004442f, 0.0f);
                h2.lineTo(42.999557f, 0.0f);
                h2.cubicTo(44.656654f, 0.0f, 46.0f, 1.3455393f, 46.0f, 3.0074198f);
                h2.lineTo(46.0f, 32.99258f);
                h2.cubicTo(46.0f, 34.653534f, 44.64822f, 36.0f, 42.999557f, 36.0f);
                h2.lineTo(3.0004442f, 36.0f);
                h2.cubicTo(1.3433446f, 36.0f, 0.0f, 34.65446f, 0.0f, 32.99258f);
                h2.lineTo(0.0f, 3.0074198f);
                h2.close();
                h2.moveTo(3.0666666f, 3.0f);
                h2.lineTo(43.0f, 3.0f);
                h2.lineTo(43.0f, 33.0f);
                h2.lineTo(3.0666666f, 33.0f);
                h2.lineTo(3.0666666f, 3.0f);
                h2.close();
                h2.moveTo(9.2f, 12.0f);
                h2.lineTo(37.0f, 12.0f);
                h2.lineTo(37.0f, 17.0f);
                h2.lineTo(9.2f, 17.0f);
                h2.lineTo(9.2f, 12.0f);
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
