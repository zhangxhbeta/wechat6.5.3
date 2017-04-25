package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class fx extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c = c.a(c, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 15.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.98f, 33.0f);
                h.cubicTo(11.64f, 22.32f, 22.32f, 11.64f, 33.0f, 0.98f);
                h.cubicTo(34.9f, 2.86f, 36.8f, 4.76f, 38.68f, 6.66f);
                h.cubicTo(31.25f, 14.11f, 23.8f, 21.54f, 16.37f, 28.99f);
                h.cubicTo(32.58f, 29.01f, 48.79f, 28.99f, 65.0f, 29.0f);
                h.cubicTo(65.0f, 31.69f, 65.0f, 34.37f, 64.99f, 37.06f);
                h.cubicTo(48.81f, 37.08f, 32.62f, 37.05f, 16.43f, 37.07f);
                h.cubicTo(23.84f, 44.5f, 31.27f, 51.91f, 38.68f, 59.34f);
                h.cubicTo(36.8f, 61.24f, 34.9f, 63.14f, 33.0f, 65.02f);
                h.cubicTo(22.32f, 54.36f, 11.64f, 43.68f, 0.98f, 33.0f);
                h.lineTo(0.98f, 33.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
