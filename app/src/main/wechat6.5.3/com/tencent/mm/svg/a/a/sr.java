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

public final class sr extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                g.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.save();
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(32.091885f, 29.970562f);
                h.lineTo(46.941124f, 15.121321f);
                h.lineTo(44.819805f, 13.0f);
                h.lineTo(29.970562f, 27.849243f);
                h.lineTo(15.121321f, 13.0f);
                h.lineTo(13.0f, 15.121321f);
                h.lineTo(27.849243f, 29.970562f);
                h.lineTo(13.0f, 44.819805f);
                h.lineTo(15.121321f, 46.941124f);
                h.lineTo(29.970562f, 32.091885f);
                h.lineTo(44.819805f, 46.941124f);
                h.lineTo(46.941124f, 44.819805f);
                h.lineTo(32.091885f, 29.970562f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
