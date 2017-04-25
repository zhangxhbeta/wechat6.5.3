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

public final class qc extends c {
    private final int height = 45;
    private final int width = 45;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                g2 = c.a(g2, looper);
                g2.setStrokeWidth(1.0f);
                Paint a = c.a(g, looper);
                Paint a2 = c.a(g2, looper);
                a.setColor(-16139513);
                a2.setColor(-16139513);
                a2.setStrokeWidth(0.5f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Paint a4 = c.a(a2, looper);
                c = c.a(c, 0.70710677f, -0.70710677f, 10.0f, 0.70710677f, 0.70710677f, -4.1421356f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(-1.3137084f, 7.1715727f);
                h.lineTo(21.313707f, 7.1715727f);
                h.lineTo(21.313707f, 12.828427f);
                h.lineTo(-1.3137084f, 12.828427f);
                h.lineTo(-1.3137084f, 7.1715727f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a2 = c.a(a2, looper);
                c = c.a(c, -0.70710677f, -0.70710677f, 44.62742f, 0.70710677f, -0.70710677f, 1.514719f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h2 = c.h(looper);
                h2.moveTo(10.686292f, 7.1715727f);
                h2.lineTo(33.31371f, 7.1715727f);
                h2.lineTo(33.31371f, 12.828427f);
                h2.lineTo(10.686292f, 12.828427f);
                h2.lineTo(10.686292f, 7.1715727f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
