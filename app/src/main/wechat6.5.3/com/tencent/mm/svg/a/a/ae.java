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

public final class ae extends c {
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-16745032);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(96.0f, 0.0f);
                h.lineTo(96.0f, 96.0f);
                h.lineTo(0.0f, 96.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(50.18182f, 66.215904f);
                h2.lineTo(50.18182f, 74.181816f);
                h2.lineTo(39.272728f, 74.181816f);
                h2.lineTo(39.272728f, 37.090908f);
                h2.lineTo(50.18182f, 37.090908f);
                h2.lineTo(50.18182f, 40.65943f);
                h2.cubicTo(53.0398f, 37.994408f, 56.874897f, 36.363636f, 61.090908f, 36.363636f);
                h2.cubicTo(69.92761f, 36.363636f, 77.09091f, 43.52787f, 77.09091f, 52.363636f);
                h2.cubicTo(77.09091f, 52.607376f, 77.08546f, 52.84984f, 77.07468f, 53.090916f);
                h2.lineTo(77.09091f, 53.090908f);
                h2.lineTo(77.09091f, 74.90909f);
                h2.lineTo(66.181816f, 74.90909f);
                h2.lineTo(66.181816f, 67.95018f);
                h2.lineTo(66.181816f, 56.0f);
                h2.lineTo(66.14929f, 56.0f);
                h2.cubicTo(66.17079f, 55.760468f, 66.181816f, 55.517887f, 66.181816f, 55.272728f);
                h2.cubicTo(66.181816f, 50.85473f, 62.59982f, 47.272728f, 58.652405f, 47.272728f);
                h2.cubicTo(53.763817f, 47.272728f, 50.18182f, 50.85473f, 50.18182f, 55.272728f);
                h2.cubicTo(50.18182f, 55.517887f, 50.192844f, 55.760468f, 50.214504f, 56.0f);
                h2.lineTo(50.18182f, 56.0f);
                h2.lineTo(50.18182f, 66.215904f);
                h2.lineTo(50.18182f, 66.215904f);
                h2.close();
                h2.moveTo(21.09091f, 37.090908f);
                h2.lineTo(32.0f, 37.090908f);
                h2.lineTo(32.0f, 74.181816f);
                h2.lineTo(21.09091f, 74.181816f);
                h2.lineTo(21.09091f, 37.090908f);
                h2.close();
                h2.moveTo(33.454544f, 25.454546f);
                h2.cubicTo(33.454544f, 29.471273f, 30.198545f, 32.727272f, 26.181818f, 32.727272f);
                h2.cubicTo(22.16509f, 32.727272f, 18.90909f, 29.471273f, 18.90909f, 25.454546f);
                h2.cubicTo(18.90909f, 21.437819f, 22.16509f, 18.181818f, 26.181818f, 18.181818f);
                h2.cubicTo(30.198545f, 18.181818f, 33.454544f, 21.437819f, 33.454544f, 25.454546f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
