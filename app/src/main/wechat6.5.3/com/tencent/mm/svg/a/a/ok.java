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

public final class ok extends c {
    private final int height = 32;
    private final int width = 33;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
            case 1:
                return 32;
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
                g.setColor(-4547478);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(9.0f, 0.0f);
                h.cubicTo(4.4698386f, 0.0f, 1.2866651E-7f, 4.280687f, 0.0f, 12.0f);
                h.cubicTo(-1.2866651E-7f, 19.4983f, 7.829132f, 28.649586f, 16.5f, 31.5f);
                h.cubicTo(25.447317f, 28.649586f, 33.0f, 19.289865f, 33.0f, 12.0f);
                h.cubicTo(33.0f, 4.0722513f, 28.71333f, 1.0442231E-7f, 24.0f, 0.0f);
                h.cubicTo(19.675785f, -9.371384E-8f, 17.939146f, 1.5439653f, 16.5f, 3.0f);
                h.cubicTo(15.07374f, 1.5439653f, 12.953914f, 0.0f, 9.0f, 0.0f);
                h.close();
                h.moveTo(9.965287f, 4.0f);
                h.cubicTo(7.320104f, 4.0f, 4.0f, 6.7830515f, 4.0f, 11.904762f);
                h.cubicTo(4.0f, 17.026472f, 9.405654f, 24.647278f, 16.5f, 27.0f);
                h.cubicTo(23.820532f, 24.647278f, 29.0f, 15.826896f, 29.0f, 11.904762f);
                h.cubicTo(29.0f, 7.982628f, 26.492723f, 4.0f, 22.636364f, 4.0f);
                h.cubicTo(19.09837f, 4.0f, 17.274794f, 7.6027136f, 16.5f, 9.0f);
                h.cubicTo(15.76442f, 7.6027136f, 12.610471f, 4.0f, 9.965287f, 4.0f);
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
