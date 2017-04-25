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

public final class el extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g.setColor(-8683387);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(11.0f, 67.75325f);
                h.lineTo(11.0f, 67.75325f);
                h.lineTo(11.0f, 63.701298f);
                h.cubicTo(11.007332f, 66.43168f, 12.668421f, 69.08772f, 15.0f, 70.792206f);
                h.lineTo(15.0f, 70.792206f);
                h.lineTo(43.0f, 87.0f);
                h.cubicTo(43.626083f, 86.7779f, 43.811207f, 86.89193f, 44.0f, 87.0f);
                h.lineTo(44.0f, 53.57143f);
                h.lineTo(11.0f, 34.324677f);
                h.lineTo(11.0f, 67.75325f);
                h.close();
                h.moveTo(52.0f, 53.57143f);
                h.lineTo(52.0f, 87.0f);
                h.cubicTo(52.188793f, 86.89292f, 52.373917f, 86.77946f, 53.0f, 87.0f);
                h.lineTo(81.0f, 70.792206f);
                h.lineTo(81.0f, 70.792206f);
                h.cubicTo(83.33158f, 69.17696f, 84.99267f, 66.53409f, 85.0f, 63.701298f);
                h.lineTo(85.0f, 68.766235f);
                h.lineTo(85.0f, 68.766235f);
                h.lineTo(85.0f, 34.324677f);
                h.lineTo(52.0f, 53.57143f);
                h.close();
                h.moveTo(53.0f, 10.012987f);
                h.cubicTo(51.805397f, 9.510585f, 50.266872f, 9.0f, 49.0f, 9.0f);
                h.cubicTo(46.95472f, 9.0f, 45.416195f, 9.510585f, 44.0f, 10.012987f);
                h.lineTo(16.0f, 27.233767f);
                h.lineTo(48.0f, 46.48052f);
                h.lineTo(81.0f, 27.233767f);
                h.lineTo(53.0f, 10.012987f);
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
