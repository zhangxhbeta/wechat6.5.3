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

public final class no extends c {
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
                h.moveTo(83.536f, 51.622f);
                h.cubicTo(83.706f, 50.222f, 82.506f, 49.728f, 81.518f, 49.842f);
                h.cubicTo(77.568f, 50.3f, 75.446f, 56.019f, 76.0f, 57.999f);
                h.cubicTo(76.771f, 60.757f, 74.209f, 64.999f, 72.0f, 64.999f);
                h.lineTo(43.992f, 64.999f);
                h.cubicTo(42.34f, 64.999f, 41.0f, 66.339f, 41.0f, 67.992f);
                h.lineTo(41.0f, 68.992f);
                h.cubicTo(41.0f, 70.653f, 42.346f, 71.999f, 44.007f, 71.999f);
                h.lineTo(55.412f, 71.999f);
                h.cubicTo(59.928f, 82.978f, 64.233f, 85.999f, 68.0f, 85.999f);
                h.lineTo(75.0f, 85.999f);
                h.cubicTo(82.11f, 85.999f, 86.0f, 80.155f, 86.0f, 74.999f);
                h.cubicTo(86.0f, 63.905f, 82.28f, 61.959f, 83.536f, 51.622f);
                h.lineTo(83.536f, 51.622f);
                h.close();
                h.moveTo(68.0f, 39.006f);
                h.cubicTo(68.0f, 37.345f, 66.654f, 35.999f, 64.993f, 35.999f);
                h.lineTo(52.962f, 35.999f);
                h.cubicTo(51.374f, 31.975f, 49.0f, 26.999f, 49.0f, 26.999f);
                h.cubicTo(47.568f, 23.262f, 43.749f, 22.312f, 40.952f, 22.077f);
                h.cubicTo(40.83f, 22.067f, 40.734f, 22.058f, 40.64f, 22.052f);
                h.cubicTo(40.429f, 22.029f, 40.219f, 22.0f, 40.0f, 22.0f);
                h.lineTo(34.0f, 22.0f);
                h.cubicTo(25.557f, 22.0f, 22.0f, 27.843f, 22.0f, 33.0f);
                h.cubicTo(22.0f, 44.094f, 25.721f, 46.039f, 24.465f, 56.377f);
                h.cubicTo(24.295f, 57.776f, 25.495f, 58.271f, 26.483f, 58.156f);
                h.cubicTo(30.433f, 57.698f, 32.555f, 51.98f, 32.001f, 49.999f);
                h.cubicTo(31.23f, 47.241f, 32.200043f, 45.572628f, 32.54726f, 44.979992f);
                h.cubicTo(33.241585f, 43.794914f, 34.52841f, 42.999f, 36.001f, 42.999f);
                h.lineTo(65.008f, 42.999f);
                h.cubicTo(66.661f, 42.998f, 68.0f, 41.659f, 68.0f, 40.006f);
                h.lineTo(68.0f, 39.006f);
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
