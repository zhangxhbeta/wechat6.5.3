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

public final class tg extends c {
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
                h.moveTo(87.115f, 33.87689f);
                h.cubicTo(87.115f, 30.632847f, 84.48362f, 28.0f, 81.23811f, 28.0f);
                h.lineTo(26.876888f, 28.0f);
                h.cubicTo(23.631376f, 28.0f, 21.0f, 30.632847f, 21.0f, 33.87689f);
                h.lineTo(21.0f, 75.01658f);
                h.cubicTo(21.0f, 78.26209f, 23.631376f, 80.892f, 26.876888f, 80.892f);
                h.lineTo(81.23811f, 80.892f);
                h.cubicTo(84.48362f, 80.892f, 87.115f, 78.26209f, 87.115f, 75.01658f);
                h.lineTo(87.115f, 66.199776f);
                h.lineTo(72.422775f, 66.199776f);
                h.cubicTo(65.931755f, 66.199776f, 60.669f, 60.937023f, 60.669f, 54.446f);
                h.cubicTo(60.669f, 47.954975f, 65.931755f, 42.692223f, 72.422775f, 42.692223f);
                h.lineTo(87.115f, 42.692223f);
                h.lineTo(87.115f, 33.87689f);
                h.lineTo(87.115f, 33.87689f);
                h.close();
                h.moveTo(66.54589f, 54.446f);
                h.cubicTo(66.54589f, 57.69298f, 69.17727f, 60.322887f, 72.422775f, 60.322887f);
                h.cubicTo(75.66829f, 60.322887f, 78.29967f, 57.69298f, 78.29967f, 54.446f);
                h.cubicTo(78.29967f, 51.20049f, 75.66829f, 48.56911f, 72.422775f, 48.56911f);
                h.cubicTo(69.17727f, 48.56911f, 66.54589f, 51.20049f, 66.54589f, 54.446f);
                h.lineTo(66.54589f, 54.446f);
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
