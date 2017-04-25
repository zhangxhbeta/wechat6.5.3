package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class tf extends c {
    private final int height = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
            case 1:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
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
                g.setColor(-15683841);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(86.0f, 81.0f);
                h.lineTo(23.0f, 81.0f);
                h.cubicTo(21.344f, 81.0f, 20.0f, 79.657f, 20.0f, 78.0f);
                h.lineTo(20.0f, 31.0f);
                h.cubicTo(20.0f, 29.343f, 21.344f, 28.0f, 23.0f, 28.0f);
                h.lineTo(86.0f, 28.0f);
                h.cubicTo(87.656f, 28.0f, 89.0f, 29.343f, 89.0f, 31.0f);
                h.lineTo(89.0f, 78.0f);
                h.cubicTo(89.0f, 79.657f, 87.656f, 81.0f, 86.0f, 81.0f);
                h.lineTo(86.0f, 81.0f);
                h.close();
                h.moveTo(24.0f, 32.0f);
                h.lineTo(24.0f, 68.031f);
                h.lineTo(43.951f, 48.001f);
                h.lineTo(68.0f, 68.706f);
                h.lineTo(64.273f, 61.914f);
                h.lineTo(71.0f, 54.0f);
                h.lineTo(85.0f, 70.471f);
                h.lineTo(85.0f, 32.0f);
                h.lineTo(24.0f, 32.0f);
                h.lineTo(24.0f, 32.0f);
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
