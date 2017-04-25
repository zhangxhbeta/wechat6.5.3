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

public final class oz extends c {
    private final int height = 32;
    private final int width = 20;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 32;
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
                g = c.a(g, looper);
                g.setColor(-2565928);
                Path h = c.h(looper);
                h.moveTo(15.773302f, 11.530662f);
                h.lineTo(4.2426405f, -1.7763568E-15f);
                h.lineTo(0.0f, 4.2426405f);
                h.lineTo(11.530662f, 15.773302f);
                h.lineTo(0.027727231f, 27.276237f);
                h.lineTo(4.270368f, 31.518877f);
                h.lineTo(20.021301f, 15.767945f);
                h.lineTo(15.77866f, 11.525304f);
                h.lineTo(15.773302f, 11.530662f);
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
