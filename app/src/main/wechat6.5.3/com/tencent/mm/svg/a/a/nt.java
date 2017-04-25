package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nt extends c {
    private final int height = 78;
    private final int width = 78;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                g.setColor(-1776412);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(39.0f, 78.0f);
                h.cubicTo(60.539104f, 78.0f, 78.0f, 60.539104f, 78.0f, 39.0f);
                h.cubicTo(78.0f, 17.460896f, 60.539104f, 0.0f, 39.0f, 0.0f);
                h.cubicTo(17.460896f, 0.0f, 0.0f, 17.460896f, 0.0f, 39.0f);
                h.cubicTo(0.0f, 60.539104f, 17.460896f, 78.0f, 39.0f, 78.0f);
                h.close();
                h.moveTo(39.0f, 73.0f);
                h.cubicTo(57.777683f, 73.0f, 73.0f, 57.777683f, 73.0f, 39.0f);
                h.cubicTo(73.0f, 20.222319f, 57.777683f, 5.0f, 39.0f, 5.0f);
                h.cubicTo(20.222319f, 5.0f, 5.0f, 20.222319f, 5.0f, 39.0f);
                h.cubicTo(5.0f, 57.777683f, 20.222319f, 73.0f, 39.0f, 73.0f);
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
