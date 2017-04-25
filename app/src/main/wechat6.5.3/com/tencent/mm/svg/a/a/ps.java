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

public final class ps extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-16139513);
                Path h = c.h(looper);
                h.moveTo(0.0f, 1.9916575f);
                h.cubicTo(0.0f, 0.89169544f, 0.89889205f, 0.0f, 1.9916575f, 0.0f);
                h.lineTo(43.008343f, 0.0f);
                h.cubicTo(44.108303f, 0.0f, 45.0f, 0.89889205f, 45.0f, 1.9916575f);
                h.lineTo(45.0f, 43.008343f);
                h.cubicTo(45.0f, 44.108303f, 44.10111f, 45.0f, 43.008343f, 45.0f);
                h.lineTo(1.9916575f, 45.0f);
                h.cubicTo(0.89169544f, 45.0f, 0.0f, 44.10111f, 0.0f, 43.008343f);
                h.lineTo(0.0f, 1.9916575f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(31.0f, 29.0f);
                h.lineTo(27.0f, 29.0f);
                h.lineTo(27.0f, 27.0f);
                h.lineTo(31.0f, 27.0f);
                h.lineTo(31.0f, 23.0f);
                h.lineTo(33.0f, 23.0f);
                h.lineTo(33.0f, 27.0f);
                h.lineTo(37.0f, 27.0f);
                h.lineTo(37.0f, 29.0f);
                h.lineTo(33.0f, 29.0f);
                h.lineTo(33.0f, 33.0f);
                h.lineTo(31.0f, 33.0f);
                h.lineTo(31.0f, 29.0f);
                h.close();
                h.moveTo(25.730555f, 35.0f);
                h.lineTo(6.130553f, 35.0f);
                h.cubicTo(5.440284f, 35.0f, 5.0f, 34.490055f, 5.0f, 33.845936f);
                h.lineTo(5.0f, 32.11464f);
                h.cubicTo(5.0f, 30.729998f, 7.1157656f, 29.698303f, 11.782929f, 27.036438f);
                h.cubicTo(13.08324f, 26.29513f, 15.77804f, 25.127686f, 14.031632f, 22.438671f);
                h.cubicTo(12.713493f, 20.408728f, 11.588755f, 19.536785f, 11.588755f, 16.113152f);
                h.cubicTo(11.588755f, 12.560062f, 14.101395f, 9.0f, 18.0f, 9.0f);
                h.cubicTo(21.898605f, 9.0f, 24.411245f, 12.560062f, 24.411245f, 16.113152f);
                h.cubicTo(24.411245f, 19.536785f, 23.286507f, 20.408728f, 21.968369f, 22.438671f);
                h.cubicTo(20.814322f, 24.215603f, 21.599625f, 25.328108f, 22.640343f, 26.092281f);
                h.cubicTo(22.548069f, 26.631046f, 22.5f, 27.184908f, 22.5f, 27.75f);
                h.cubicTo(22.5f, 29.225077f, 22.827538f, 30.623629f, 23.413855f, 31.876896f);
                h.cubicTo(23.971626f, 33.069145f, 24.763592f, 34.129913f, 25.730555f, 35.0f);
                h.close();
                h.moveTo(24.0f, 28.125736f);
                h.cubicTo(24.0f, 28.536228f, 24.030445f, 28.939606f, 24.089201f, 29.333736f);
                h.cubicTo(24.672707f, 33.24789f, 28.048365f, 36.25f, 32.125f, 36.25f);
                h.cubicTo(36.612865f, 36.25f, 40.25f, 32.612865f, 40.25f, 28.125736f);
                h.cubicTo(40.25f, 23.637873f, 36.612865f, 20.0f, 32.125f, 20.0f);
                h.cubicTo(27.637873f, 20.0f, 24.0f, 23.637873f, 24.0f, 28.125736f);
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
