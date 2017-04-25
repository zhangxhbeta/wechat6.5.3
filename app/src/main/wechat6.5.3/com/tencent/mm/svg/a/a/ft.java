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

public final class ft extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(51.0f, 102.0f);
                h.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                h.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                h.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                h.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                h.close();
                h.moveTo(51.0f, 98.0f);
                h.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                h.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                h.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                h.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                a3 = c.a(a3, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(15.415947f, 1.2113346f);
                h.cubicTo(16.290796f, 0.54233295f, 17.0f, 0.8949788f, 17.0f, 1.9970046f);
                h.lineTo(17.0f, 24.002995f);
                h.cubicTo(17.0f, 25.105911f, 16.291174f, 25.457956f, 15.415947f, 24.788666f);
                h.lineTo(1.5840529f, 14.211334f);
                h.cubicTo(0.7092046f, 13.542333f, 0.70882535f, 12.457957f, 1.5840529f, 11.788666f);
                h.lineTo(15.415947f, 1.2113346f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                g = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(14.0f, 9.0f);
                h2.lineTo(55.0f, 9.0f);
                h2.lineTo(55.0f, 17.0f);
                h2.lineTo(14.0f, 17.0f);
                h2.lineTo(14.0f, 9.0f);
                h2.close();
                canvas.drawPath(h2, g);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
