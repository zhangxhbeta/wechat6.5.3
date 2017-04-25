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

public final class la extends c {
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-6447715);
                Path h = c.h(looper);
                h.moveTo(58.5f, 46.0f);
                h.lineTo(60.0f, 46.0f);
                h.lineTo(60.0f, 0.0f);
                h.lineTo(57.0f, 0.0f);
                h.lineTo(57.0f, 43.0f);
                h.lineTo(51.0f, 43.0f);
                h.lineTo(51.0f, 46.0f);
                h.lineTo(58.5f, 46.0f);
                h.close();
                h.moveTo(15.5f, 0.0f);
                h.lineTo(14.0f, 0.0f);
                h.lineTo(14.0f, 9.0f);
                h.lineTo(17.0f, 9.0f);
                h.lineTo(17.0f, 3.0f);
                h.lineTo(57.0f, 3.0f);
                h.lineTo(57.0f, 0.0f);
                h.lineTo(15.5f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-6447715);
                Path h2 = c.h(looper);
                h2.moveTo(0.0f, 13.5f);
                h2.lineTo(0.0f, 12.0f);
                h2.lineTo(48.0f, 12.0f);
                h2.lineTo(48.0f, 13.5f);
                h2.lineTo(48.0f, 58.0f);
                h2.lineTo(48.0f, 60.0f);
                h2.lineTo(0.0f, 60.0f);
                h2.lineTo(0.0f, 58.0f);
                h2.lineTo(0.0f, 13.5f);
                h2.close();
                h2.moveTo(3.0f, 15.0f);
                h2.lineTo(45.0f, 15.0f);
                h2.lineTo(45.0f, 57.0f);
                h2.lineTo(3.0f, 57.0f);
                h2.lineTo(3.0f, 15.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
