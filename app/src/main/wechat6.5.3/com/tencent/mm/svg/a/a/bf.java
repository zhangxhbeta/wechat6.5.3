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

public final class bf extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                g.setColor(-1);
                canvas.save();
                g = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(61.0f, 33.0f);
                h.lineTo(61.0f, 64.0f);
                h.lineTo(19.0f, 64.0f);
                h.lineTo(19.0f, 17.0f);
                h.lineTo(47.0f, 17.0f);
                h.lineTo(47.0f, 33.0f);
                h.lineTo(49.0f, 33.0f);
                h.lineTo(61.0f, 33.0f);
                h.close();
                h.moveTo(60.989494f, 29.0f);
                h.lineTo(51.0f, 18.140165f);
                h.lineTo(51.0f, 29.0f);
                h.lineTo(60.989494f, 29.0f);
                h.close();
                h.moveTo(63.0f, 68.0f);
                h.lineTo(15.0f, 68.0f);
                h.lineTo(15.0f, 66.0f);
                h.lineTo(15.0f, 15.0f);
                h.lineTo(15.0f, 13.0f);
                h.lineTo(51.0f, 13.0f);
                h.lineTo(51.0f, 13.028122f);
                h.lineTo(65.04203f, 28.0f);
                h.lineTo(65.0f, 28.010773f);
                h.lineTo(65.0f, 68.0f);
                h.lineTo(63.0f, 68.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
