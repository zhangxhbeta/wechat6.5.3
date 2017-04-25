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

public final class jl extends c {
    private final int height = 480;
    private final int width = 480;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                g2.setColor(-16337763);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(480.0f, 0.0f);
                h.lineTo(480.0f, 480.0f);
                h.lineTo(0.0f, 480.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(110.0f, 114.0f);
                h2.cubicTo(110.0f, 111.79086f, 111.79086f, 110.0f, 114.0f, 110.0f);
                h2.lineTo(366.0f, 110.0f);
                h2.cubicTo(368.20914f, 110.0f, 370.0f, 111.79086f, 370.0f, 114.0f);
                h2.lineTo(370.0f, 366.0f);
                h2.cubicTo(370.0f, 368.20914f, 368.20914f, 370.0f, 366.0f, 370.0f);
                h2.lineTo(114.0f, 370.0f);
                h2.cubicTo(111.79086f, 370.0f, 110.0f, 368.20914f, 110.0f, 366.0f);
                h2.lineTo(110.0f, 114.0f);
                h2.close();
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-16337763);
                h2 = c.h(looper);
                h2.moveTo(240.0f, 156.0f);
                h2.cubicTo(262.0914f, 156.0f, 280.0f, 173.90862f, 280.0f, 196.0f);
                h2.cubicTo(280.0f, 218.09138f, 262.0914f, 236.0f, 240.0f, 236.0f);
                h2.cubicTo(217.90862f, 236.0f, 200.0f, 218.09138f, 200.0f, 196.0f);
                h2.cubicTo(200.0f, 173.90862f, 217.90862f, 156.0f, 240.0f, 156.0f);
                h2.close();
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-16337763);
                h2 = c.h(looper);
                h2.moveTo(191.0f, 244.0f);
                h2.cubicTo(213.09138f, 244.0f, 231.0f, 261.9086f, 231.0f, 284.0f);
                h2.cubicTo(231.0f, 306.0914f, 213.09138f, 324.0f, 191.0f, 324.0f);
                h2.cubicTo(168.90862f, 324.0f, 151.0f, 306.0914f, 151.0f, 284.0f);
                h2.cubicTo(151.0f, 261.9086f, 168.90862f, 244.0f, 191.0f, 244.0f);
                h2.close();
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-16337763);
                h2 = c.h(looper);
                h2.moveTo(289.0f, 324.0f);
                h2.cubicTo(311.0914f, 324.0f, 329.0f, 306.0914f, 329.0f, 284.0f);
                h2.cubicTo(329.0f, 261.9086f, 311.0914f, 244.0f, 289.0f, 244.0f);
                h2.cubicTo(266.9086f, 244.0f, 249.0f, 261.9086f, 249.0f, 284.0f);
                h2.cubicTo(249.0f, 306.0914f, 266.9086f, 324.0f, 289.0f, 324.0f);
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
