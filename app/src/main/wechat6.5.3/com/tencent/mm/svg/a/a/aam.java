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

public final class aam extends c {
    private final int height = FileUtils.S_IWUSR;
    private final int width = FileUtils.S_IWUSR;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return FileUtils.S_IWUSR;
            case 1:
                return FileUtils.S_IWUSR;
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
                a.setColor(-9934744);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(8.006973f, 18.0f);
                h.cubicTo(3.584844f, 18.0f, 0.0f, 21.589066f, 0.0f, 26.007586f);
                h.lineTo(0.0f, 85.99242f);
                h.cubicTo(0.0f, 90.41488f, 3.5907528f, 94.0f, 8.006973f, 94.0f);
                h.lineTo(119.99303f, 94.0f);
                h.cubicTo(124.41515f, 94.0f, 128.0f, 90.410934f, 128.0f, 85.99242f);
                h.lineTo(128.0f, 26.007586f);
                h.cubicTo(128.0f, 21.58512f, 124.40925f, 18.0f, 119.99303f, 18.0f);
                h.lineTo(8.006973f, 18.0f);
                h.close();
                h.moveTo(51.428135f, 0.0f);
                h.lineTo(64.0f, 0.0f);
                h.lineTo(64.0f, 18.0f);
                h.lineTo(26.375288f, 18.0f);
                h.cubicTo(36.35272f, 18.0f, 41.71253f, 0.0f, 51.428135f, 0.0f);
                h.close();
                h.moveTo(101.62471f, 18.0f);
                h.cubicTo(91.647285f, 18.0f, 86.28747f, 0.0f, 76.5697f, 0.0f);
                h.lineTo(64.0f, 0.0f);
                h.lineTo(64.0f, 18.0f);
                h.lineTo(101.62471f, 18.0f);
                h.close();
                h.moveTo(93.0f, 53.0f);
                h.cubicTo(93.0f, 69.01692f, 80.01692f, 82.0f, 64.0f, 82.0f);
                h.cubicTo(47.983078f, 82.0f, 35.0f, 69.01692f, 35.0f, 53.0f);
                h.cubicTo(35.0f, 36.983078f, 47.983078f, 24.0f, 64.0f, 24.0f);
                h.cubicTo(80.01692f, 24.0f, 93.0f, 36.983078f, 93.0f, 53.0f);
                h.close();
                h.moveTo(84.0f, 53.0f);
                h.cubicTo(84.0f, 64.046f, 75.046f, 73.0f, 64.0f, 73.0f);
                h.cubicTo(52.954f, 73.0f, 44.0f, 64.046f, 44.0f, 53.0f);
                h.cubicTo(44.0f, 41.954f, 52.954f, 33.0f, 64.0f, 33.0f);
                h.cubicTo(75.046f, 33.0f, 84.0f, 41.954f, 84.0f, 53.0f);
                h.close();
                h.moveTo(6.4545455f, 6.4315085f);
                h.lineTo(24.454546f, 6.4315085f);
                h.lineTo(24.454546f, 12.431508f);
                h.lineTo(6.4545455f, 12.431508f);
                h.lineTo(6.4545455f, 6.4315085f);
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
