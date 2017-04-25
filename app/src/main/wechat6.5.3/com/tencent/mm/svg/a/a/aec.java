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
import com.tencent.smtt.sdk.WebView;

public final class aec extends c {
    private final int height = WebView.NORMAL_MODE_ALPHA;
    private final int width = WebView.NORMAL_MODE_ALPHA;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return WebView.NORMAL_MODE_ALPHA;
            case 1:
                return WebView.NORMAL_MODE_ALPHA;
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
                c = c.a(c, 1.0f, 0.0f, 74.0f, 0.0f, 1.0f, 65.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(98.000374f, 0.0f);
                h.lineTo(21.999622f, 0.0f);
                h.lineTo(24.0f, 0.0f);
                h.lineTo(12.0f, 12.0f);
                h.lineTo(12.0f, 10.000714f);
                h.lineTo(12.0f, 126.0f);
                h.lineTo(108.0f, 126.0f);
                h.lineTo(108.0f, 10.000714f);
                h.lineTo(108.0f, 12.0f);
                h.lineTo(96.0f, 0.0f);
                h.lineTo(98.000374f, 0.0f);
                h.close();
                h.moveTo(108.0f, 114.0f);
                h.lineTo(96.0f, 126.0f);
                h.lineTo(108.0f, 126.0f);
                h.lineTo(108.0f, 114.0f);
                h.close();
                h.moveTo(0.0f, 48.0f);
                h.lineTo(12.0f, 48.0f);
                h.lineTo(12.0f, 126.0f);
                h.lineTo(0.0f, 126.0f);
                h.lineTo(0.0f, 48.0f);
                h.close();
                h.moveTo(0.0f, 114.0f);
                h.lineTo(12.0f, 126.0f);
                h.lineTo(0.0f, 126.0f);
                h.lineTo(0.0f, 114.0f);
                h.close();
                h.moveTo(0.0f, 60.0f);
                h.lineTo(12.0f, 48.0f);
                h.lineTo(0.0f, 48.0f);
                h.lineTo(0.0f, 60.0f);
                h.close();
                h.moveTo(36.0f, 12.0f);
                h.lineTo(48.0f, 12.0f);
                h.lineTo(48.0f, 42.0f);
                h.lineTo(36.0f, 42.0f);
                h.lineTo(36.0f, 12.0f);
                h.close();
                h.moveTo(54.0f, 12.0f);
                h.lineTo(66.0f, 12.0f);
                h.lineTo(66.0f, 42.0f);
                h.lineTo(54.0f, 42.0f);
                h.lineTo(54.0f, 12.0f);
                h.close();
                h.moveTo(72.0f, 12.0f);
                h.lineTo(84.0f, 12.0f);
                h.lineTo(84.0f, 42.0f);
                h.lineTo(72.0f, 42.0f);
                h.lineTo(72.0f, 12.0f);
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
