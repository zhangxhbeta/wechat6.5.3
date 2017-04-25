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

public final class kd extends c {
    private final int height = 21;
    private final int width = 36;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 21;
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
                g = c.a(g, looper);
                g.setColor(-6710887);
                canvas.save();
                Paint a = c.a(g, looper);
                c = c.a(c, 0.70710677f, 0.70710677f, 2.4558444f, -0.70710677f, 0.70710677f, 13.870058f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(10.970563f, 10.970563f);
                h.lineTo(29.970562f, 10.970563f);
                h.lineTo(29.970562f, 15.970563f);
                h.lineTo(5.970563f, 15.970563f);
                h.lineTo(5.970563f, 13.470563f);
                h.lineTo(5.970563f, -8.029437f);
                h.lineTo(10.970563f, -8.029437f);
                h.lineTo(10.970563f, 10.970563f);
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
