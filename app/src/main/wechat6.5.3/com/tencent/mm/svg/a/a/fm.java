package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
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

public final class fm extends c {
    private final int height = MMGIFException.D_GIF_ERR_READ_FAILED;
    private final int width = MMGIFException.D_GIF_ERR_READ_FAILED;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
            case 1:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -1910.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2695.0f, 2012.0f);
                h.cubicTo(2666.8335f, 2012.0f, 2644.0f, 1989.1665f, 2644.0f, 1961.0f);
                h.cubicTo(2644.0f, 1932.8335f, 2666.8335f, 1910.0f, 2695.0f, 1910.0f);
                h.cubicTo(2723.1665f, 1910.0f, 2746.0f, 1932.8335f, 2746.0f, 1961.0f);
                h.cubicTo(2746.0f, 1989.1665f, 2723.1665f, 2012.0f, 2695.0f, 2012.0f);
                h.close();
                h.moveTo(2695.0f, 2009.0f);
                h.cubicTo(2668.4902f, 2009.0f, 2647.0f, 1987.5096f, 2647.0f, 1961.0f);
                h.cubicTo(2647.0f, 1934.4904f, 2668.4902f, 1913.0f, 2695.0f, 1913.0f);
                h.cubicTo(2721.5098f, 1913.0f, 2743.0f, 1934.4904f, 2743.0f, 1961.0f);
                h.cubicTo(2743.0f, 1987.5096f, 2721.5098f, 2009.0f, 2695.0f, 2009.0f);
                h.close();
                h.moveTo(2670.963f, 1965.1285f);
                h.cubicTo(2670.7703f, 1964.9377f, 2670.7505f, 1964.6127f, 2670.9253f, 1964.3942f);
                h.lineTo(2672.8416f, 1961.9998f);
                h.cubicTo(2673.0134f, 1961.785f, 2673.332f, 1961.7294f, 2673.5615f, 1961.8812f);
                h.lineTo(2686.488f, 1970.4324f);
                h.cubicTo(2686.9482f, 1970.7368f, 2687.674f, 1970.7001f, 2688.0981f, 1970.3591f);
                h.lineTo(2720.3496f, 1944.4258f);
                h.cubicTo(2720.5632f, 1944.254f, 2720.9004f, 1944.2769f, 2721.0906f, 1944.4653f);
                h.lineTo(2722.4705f, 1945.8309f);
                h.cubicTo(2722.6663f, 1946.0247f, 2722.6665f, 1946.3383f, 2722.4734f, 1946.5293f);
                h.lineTo(2688.0308f, 1980.6161f);
                h.cubicTo(2687.639f, 1981.0037f, 2687.0027f, 1981.0023f, 2686.6143f, 1980.618f);
                h.lineTo(2670.963f, 1965.1285f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
