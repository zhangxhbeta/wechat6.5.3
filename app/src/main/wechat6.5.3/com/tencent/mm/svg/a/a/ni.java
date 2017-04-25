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

public final class ni extends c {
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
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(96.0f, 0.0f);
                h.lineTo(96.0f, 96.0f);
                h.lineTo(0.0f, 96.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-15683841);
                Path h2 = c.h(looper);
                h2.moveTo(63.79504f, 76.03136f);
                h2.cubicTo(66.12399f, 72.529205f, 68.7792f, 68.3831f, 71.20018f, 64.23644f);
                h2.cubicTo(75.00407f, 57.72113f, 67.96337f, 50.764866f, 69.06122f, 48.884483f);
                h2.lineTo(75.6094f, 37.66875f);
                h2.lineTo(77.45893f, 38.724712f);
                h2.lineTo(79.198235f, 35.74563f);
                h2.lineTo(65.82298f, 28.109241f);
                h2.lineTo(64.08367f, 31.088326f);
                h2.lineTo(65.30881f, 31.787794f);
                h2.lineTo(65.30881f, 31.787794f);
                h2.cubicTo(63.367702f, 35.112526f, 59.602104f, 41.562244f, 58.760628f, 43.00353f);
                h2.cubicTo(57.614784f, 44.966133f, 48.31452f, 42.2731f, 44.418648f, 48.945957f);
                h2.cubicTo(41.398506f, 54.118862f, 34.140175f, 64.83309f, 31.555475f, 68.623924f);
                h2.cubicTo(36.904846f, 68.18801f, 44.777954f, 68.44738f, 52.00923f, 72.13616f);
                h2.cubicTo(56.16449f, 74.25582f, 60.120087f, 75.47306f, 63.79504f, 76.03136f);
                h2.lineTo(63.79504f, 76.03136f);
                h2.close();
                h2.moveTo(74.7789f, 22.0f);
                h2.lineTo(71.04058f, 28.949007f);
                h2.lineTo(76.47996f, 32.174023f);
                h2.lineTo(84.06177f, 26.508453f);
                h2.lineTo(74.7789f, 22.0f);
                h2.close();
                h2.moveTo(87.90909f, 75.08898f);
                h2.cubicTo(87.90909f, 75.08898f, 77.715836f, 85.38182f, 65.84715f, 85.38182f);
                h2.cubicTo(40.000687f, 85.38182f, 50.014915f, 73.98892f, 20.0f, 72.81588f);
                h2.cubicTo(19.998188f, 72.81866f, 36.395184f, 68.36936f, 50.49552f, 75.08898f);
                h2.cubicTo(71.97876f, 85.326965f, 87.90909f, 75.08898f, 87.90909f, 75.08898f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
