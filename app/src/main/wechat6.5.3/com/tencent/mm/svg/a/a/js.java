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

public final class js extends c {
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-14187817);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(108.0f, 0.0f);
                h.lineTo(108.0f, 108.0f);
                h.lineTo(0.0f, 108.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(80.744995f, 77.86161f);
                h2.lineTo(80.75248f, 77.86909f);
                h2.lineTo(91.35908f, 67.26249f);
                h2.lineTo(89.237755f, 65.14117f);
                h2.lineTo(80.75012f, 73.6288f);
                h2.lineTo(76.743034f, 69.62171f);
                h2.lineTo(74.62171f, 71.743034f);
                h2.lineTo(80.74264f, 77.86396f);
                h2.lineTo(80.744995f, 77.86161f);
                h2.lineTo(80.744995f, 77.86161f);
                h2.close();
                h2.moveTo(70.593575f, 84.0f);
                h2.lineTo(26.608969f, 84.0f);
                h2.cubicTo(25.016039f, 84.0f, 24.0f, 82.823204f, 24.0f, 81.33677f);
                h2.lineTo(24.0f, 77.34148f);
                h2.cubicTo(24.0f, 74.14615f, 28.882536f, 71.76532f, 39.652912f, 65.62255f);
                h2.cubicTo(42.65363f, 63.91184f, 48.8724f, 61.21774f, 44.842228f, 55.012318f);
                h2.cubicTo(41.80037f, 50.327835f, 39.20482f, 48.31566f, 39.20482f, 40.414963f);
                h2.cubicTo(39.20482f, 32.215527f, 45.00322f, 24.0f, 54.0f, 24.0f);
                h2.cubicTo(62.99678f, 24.0f, 68.79518f, 32.215527f, 68.79518f, 40.414963f);
                h2.cubicTo(68.79518f, 48.31566f, 66.19963f, 50.327835f, 63.157772f, 55.012318f);
                h2.cubicTo(60.146255f, 59.649273f, 62.85746f, 62.325607f, 65.672424f, 64.09607f);
                h2.cubicTo(64.914856f, 66.0857f, 64.5f, 68.244385f, 64.5f, 70.5f);
                h2.cubicTo(64.5f, 75.87621f, 66.85677f, 80.7018f, 70.593575f, 84.0f);
                h2.lineTo(70.593575f, 84.0f);
                h2.lineTo(70.593575f, 84.0f);
                h2.close();
                h2.moveTo(69.0f, 70.50122f);
                h2.cubicTo(69.0f, 71.18327f, 69.05058f, 71.8535f, 69.14821f, 72.50836f);
                h2.cubicTo(70.11773f, 79.01188f, 75.72652f, 84.0f, 82.5f, 84.0f);
                h2.cubicTo(89.95676f, 84.0f, 96.0f, 77.95676f, 96.0f, 70.50122f);
                h2.cubicTo(96.0f, 63.044464f, 89.95676f, 57.0f, 82.5f, 57.0f);
                h2.cubicTo(75.044464f, 57.0f, 69.0f, 63.044464f, 69.0f, 70.50122f);
                h2.lineTo(69.0f, 70.50122f);
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
