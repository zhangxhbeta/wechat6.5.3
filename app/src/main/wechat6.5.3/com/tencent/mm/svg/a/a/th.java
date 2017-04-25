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

public final class th extends c {
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
                c = c.a(c, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 25.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-15683841);
                Path h = c.h(looper);
                h.moveTo(58.94128f, 18.34375f);
                h.lineTo(2.708721f, 11.0f);
                h.cubicTo(1.116907f, 11.0f, -0.175f, 12.316f, -0.175f, 13.938969f);
                h.lineTo(-0.175f, 47.71875f);
                h.cubicTo(-0.175f, 49.34172f, 1.116907f, 50.65625f, 2.708721f, 50.65625f);
                h.lineTo(58.94128f, 58.0f);
                h.cubicTo(60.533092f, 58.0f, 61.825f, 56.68547f, 61.825f, 55.0625f);
                h.lineTo(61.825f, 21.28125f);
                h.cubicTo(61.825f, 19.65975f, 60.533092f, 18.34375f, 58.94128f, 18.34375f);
                h.lineTo(58.94128f, 18.34375f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-11742937);
                h = c.h(looper);
                h.moveTo(60.825f, 2.7197444f);
                h.cubicTo(60.697964f, 1.1690818f, 58.744793f, -0.117698714f, 57.168396f, 0.008567508f);
                h.lineTo(4.3879986f, 7.349033f);
                h.cubicTo(4.1931143f, 7.364639f, 4.0054483f, 7.400107f, 3.825f, 7.4497623f);
                h.lineTo(60.825f, 14.0f);
                h.lineTo(60.825f, 2.7197444f);
                h.lineTo(60.825f, 2.7197444f);
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
