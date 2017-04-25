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

public final class rt extends c {
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
                g.setColor(-1);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(31.0f, 26.001389f);
                h.cubicTo(31.0f, 24.896053f, 31.895857f, 24.0f, 32.99739f, 24.0f);
                h.lineTo(38.00261f, 24.0f);
                h.cubicTo(39.105736f, 24.0f, 40.0f, 24.894938f, 40.0f, 26.001389f);
                h.lineTo(40.0f, 69.99861f);
                h.cubicTo(40.0f, 71.10395f, 39.10414f, 72.0f, 38.00261f, 72.0f);
                h.lineTo(32.99739f, 72.0f);
                h.cubicTo(31.894262f, 72.0f, 31.0f, 71.105064f, 31.0f, 69.99861f);
                h.lineTo(31.0f, 26.001389f);
                h.close();
                h.moveTo(56.0f, 26.001389f);
                h.cubicTo(56.0f, 24.896053f, 56.89586f, 24.0f, 57.99739f, 24.0f);
                h.lineTo(63.00261f, 24.0f);
                h.cubicTo(64.105736f, 24.0f, 65.0f, 24.894938f, 65.0f, 26.001389f);
                h.lineTo(65.0f, 69.99861f);
                h.cubicTo(65.0f, 71.10395f, 64.10414f, 72.0f, 63.00261f, 72.0f);
                h.lineTo(57.99739f, 72.0f);
                h.cubicTo(56.894264f, 72.0f, 56.0f, 71.105064f, 56.0f, 69.99861f);
                h.lineTo(56.0f, 26.001389f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
