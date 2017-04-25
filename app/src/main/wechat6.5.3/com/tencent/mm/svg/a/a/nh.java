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

public final class nh extends c {
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
                g.setColor(-13824);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(21.0f, 54.0f);
                h.cubicTo(21.0f, 72.226f, 35.773f, 87.0f, 53.999f, 87.0f);
                h.cubicTo(72.225f, 87.0f, 87.0f, 72.226f, 87.0f, 54.0f);
                h.cubicTo(87.0f, 35.774f, 72.225f, 21.0f, 53.999f, 21.0f);
                h.cubicTo(35.773f, 21.0f, 21.0f, 35.774f, 21.0f, 54.0f);
                h.close();
                h.moveTo(68.0f, 37.0f);
                h.cubicTo(70.762f, 37.0f, 73.0f, 39.462f, 73.0f, 42.5f);
                h.cubicTo(73.0f, 45.538f, 70.762f, 48.0f, 68.0f, 48.0f);
                h.cubicTo(65.238f, 48.0f, 63.0f, 45.538f, 63.0f, 42.5f);
                h.cubicTo(63.0f, 39.462f, 65.238f, 37.0f, 68.0f, 37.0f);
                h.lineTo(68.0f, 37.0f);
                h.close();
                h.moveTo(41.0f, 37.0f);
                h.cubicTo(43.762f, 37.0f, 46.0f, 39.462f, 46.0f, 42.5f);
                h.cubicTo(46.0f, 45.538f, 43.762f, 48.0f, 41.0f, 48.0f);
                h.cubicTo(38.238f, 48.0f, 36.0f, 45.538f, 36.0f, 42.5f);
                h.cubicTo(36.0f, 39.462f, 38.238f, 37.0f, 41.0f, 37.0f);
                h.lineTo(41.0f, 37.0f);
                h.close();
                h.moveTo(54.0f, 77.0f);
                h.cubicTo(34.667f, 77.0f, 32.0f, 59.0f, 32.0f, 59.0f);
                h.cubicTo(32.0f, 59.0f, 46.361f, 57.0f, 54.0f, 57.0f);
                h.cubicTo(61.639f, 57.0f, 76.0f, 59.0f, 76.0f, 59.0f);
                h.cubicTo(76.0f, 59.0f, 73.333f, 77.0f, 54.0f, 77.0f);
                h.lineTo(54.0f, 77.0f);
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
