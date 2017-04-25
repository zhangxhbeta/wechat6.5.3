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

public final class qk extends c {
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
                g.setColor(-499359);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(79.03704f, 25.0f);
                h.lineTo(29.962963f, 25.0f);
                h.cubicTo(28.879408f, 25.0f, 28.0f, 25.881067f, 28.0f, 26.966667f);
                h.lineTo(28.0f, 82.03333f);
                h.cubicTo(28.0f, 83.118935f, 28.879408f, 84.0f, 29.962963f, 84.0f);
                h.lineTo(79.03704f, 84.0f);
                h.cubicTo(80.12059f, 84.0f, 81.0f, 83.118935f, 81.0f, 82.03333f);
                h.lineTo(81.0f, 26.966667f);
                h.cubicTo(81.0f, 25.880083f, 80.12059f, 25.0f, 79.03704f, 25.0f);
                h.lineTo(79.03704f, 25.0f);
                h.close();
                h.moveTo(69.22222f, 40.388184f);
                h.lineTo(69.22222f, 52.533333f);
                h.cubicTo(69.22222f, 60.679268f, 62.630592f, 67.28333f, 54.5f, 67.28333f);
                h.cubicTo(46.369408f, 67.28333f, 39.77778f, 60.679268f, 39.77778f, 52.533333f);
                h.lineTo(39.77778f, 40.388184f);
                h.cubicTo(38.61963f, 39.83555f, 37.814816f, 38.66145f, 37.814816f, 37.291668f);
                h.cubicTo(37.814816f, 35.3899f, 39.352795f, 33.85f, 41.25f, 33.85f);
                h.cubicTo(43.147205f, 33.85f, 44.685184f, 35.3899f, 44.685184f, 37.291668f);
                h.cubicTo(44.685184f, 38.662434f, 43.88037f, 39.83555f, 42.72222f, 40.388184f);
                h.lineTo(42.72222f, 52.533333f);
                h.cubicTo(42.72222f, 59.049885f, 47.99474f, 64.333336f, 54.5f, 64.333336f);
                h.cubicTo(61.004276f, 64.333336f, 66.27778f, 59.049885f, 66.27778f, 52.533333f);
                h.lineTo(66.27778f, 40.388184f);
                h.cubicTo(65.11963f, 39.83555f, 64.31481f, 38.66145f, 64.31481f, 37.291668f);
                h.cubicTo(64.31481f, 35.3899f, 65.8528f, 33.85f, 67.75f, 33.85f);
                h.cubicTo(69.6472f, 33.85f, 71.18519f, 35.3899f, 71.18519f, 37.291668f);
                h.cubicTo(71.18519f, 38.66145f, 70.37939f, 39.83555f, 69.22222f, 40.388184f);
                h.lineTo(69.22222f, 40.388184f);
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
