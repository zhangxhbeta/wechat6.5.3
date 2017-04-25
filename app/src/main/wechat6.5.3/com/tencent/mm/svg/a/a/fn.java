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

public final class fn extends c {
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
                c = c.a(c, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -2054.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2697.9246f, 2114.546f);
                h.lineTo(2690.5f, 2121.9705f);
                h.lineTo(2692.6213f, 2124.0918f);
                h.lineTo(2700.046f, 2116.6672f);
                h.lineTo(2707.4705f, 2124.0918f);
                h.lineTo(2709.5918f, 2121.9705f);
                h.lineTo(2702.1672f, 2114.546f);
                h.lineTo(2709.5918f, 2107.1213f);
                h.lineTo(2707.4705f, 2105.0f);
                h.lineTo(2700.046f, 2112.4246f);
                h.lineTo(2692.6213f, 2105.0f);
                h.lineTo(2690.5f, 2107.1213f);
                h.lineTo(2697.9246f, 2114.546f);
                h.close();
                h.moveTo(2695.0f, 2156.0f);
                h.cubicTo(2666.8335f, 2156.0f, 2644.0f, 2133.1665f, 2644.0f, 2105.0f);
                h.cubicTo(2644.0f, 2076.8335f, 2666.8335f, 2054.0f, 2695.0f, 2054.0f);
                h.cubicTo(2723.1665f, 2054.0f, 2746.0f, 2076.8335f, 2746.0f, 2105.0f);
                h.cubicTo(2746.0f, 2133.1665f, 2723.1665f, 2156.0f, 2695.0f, 2156.0f);
                h.close();
                h.moveTo(2695.0f, 2153.0f);
                h.cubicTo(2668.4902f, 2153.0f, 2647.0f, 2131.5098f, 2647.0f, 2105.0f);
                h.cubicTo(2647.0f, 2078.4902f, 2668.4902f, 2057.0f, 2695.0f, 2057.0f);
                h.cubicTo(2721.5098f, 2057.0f, 2743.0f, 2078.4902f, 2743.0f, 2105.0f);
                h.cubicTo(2743.0f, 2131.5098f, 2721.5098f, 2153.0f, 2695.0f, 2153.0f);
                h.close();
                h.moveTo(2674.0f, 2081.4993f);
                h.cubicTo(2674.0f, 2080.395f, 2674.8967f, 2079.5f, 2675.9976f, 2079.5f);
                h.lineTo(2714.0024f, 2079.5f);
                h.cubicTo(2715.1057f, 2079.5f, 2716.0f, 2080.396f, 2716.0f, 2081.4993f);
                h.lineTo(2716.0f, 2128.5007f);
                h.cubicTo(2716.0f, 2129.605f, 2715.1033f, 2130.5f, 2714.0024f, 2130.5f);
                h.lineTo(2675.9976f, 2130.5f);
                h.cubicTo(2674.8943f, 2130.5f, 2674.0f, 2129.604f, 2674.0f, 2128.5007f);
                h.lineTo(2674.0f, 2081.4993f);
                h.close();
                h.moveTo(2677.0f, 2082.5f);
                h.lineTo(2713.0f, 2082.5f);
                h.lineTo(2713.0f, 2127.5f);
                h.lineTo(2677.0f, 2127.5f);
                h.lineTo(2677.0f, 2082.5f);
                h.close();
                h.moveTo(2681.5f, 2087.0f);
                h.lineTo(2696.5f, 2087.0f);
                h.lineTo(2696.5f, 2090.0f);
                h.lineTo(2681.5f, 2090.0f);
                h.lineTo(2681.5f, 2087.0f);
                h.close();
                h.moveTo(2681.5f, 2094.5f);
                h.lineTo(2696.5f, 2094.5f);
                h.lineTo(2696.5f, 2097.5f);
                h.lineTo(2681.5f, 2097.5f);
                h.lineTo(2681.5f, 2094.5f);
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
