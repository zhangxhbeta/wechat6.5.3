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

public final class oj extends c {
    private final int height = 36;
    private final int width = 40;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 36;
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
                a.setColor(-11048043);
                Path h = c.h(looper);
                h.moveTo(6.223777f, 2.4243011f);
                h.cubicTo(10.598335f, -0.4037837f, 16.69516f, 1.2488136f, 20.001913f, 5.0172887f);
                h.cubicTo(22.709318f, 1.97485f, 26.97365f, 0.38448447f, 30.996866f, 1.2349844f);
                h.cubicTo(33.95228f, 1.8296428f, 36.28078f, 4.2635937f, 37.23836f, 7.070935f);
                h.cubicTo(38.643734f, 11.081422f, 38.023716f, 15.610507f, 36.039665f, 19.31675f);
                h.cubicTo(32.52624f, 26.065432f, 26.649864f, 31.368956f, 20.001913f, 34.923077f);
                h.cubicTo(12.603054f, 30.926418f, 5.9619923f, 24.76548f, 2.8756897f, 16.785994f);
                h.cubicTo(1.1740899f, 11.966495f, 1.7803279f, 5.5635448f, 6.223777f, 2.4243011f);
                h.lineTo(6.223777f, 2.4243011f);
                h.lineTo(6.223777f, 2.4243011f);
                h.close();
                h.moveTo(6.579045f, 8.803145f);
                h.cubicTo(5.6772685f, 12.076567f, 6.2279716f, 15.709856f, 8.059059f, 18.561125f);
                h.cubicTo(11.005321f, 23.336306f, 15.466016f, 26.921152f, 20.002432f, 30.076923f);
                h.cubicTo(23.50628f, 27.668571f, 26.858686f, 24.983397f, 29.639736f, 21.744577f);
                h.cubicTo(31.945807f, 19.045563f, 33.942104f, 15.744459f, 33.831963f, 12.062725f);
                h.cubicTo(33.983406f, 9.391392f, 32.937073f, 6.0210834f, 29.997694f, 5.391313f);
                h.cubicTo(25.970676f, 4.1871367f, 22.94181f, 7.848109f, 20.002432f, 9.965798f);
                h.cubicTo(17.118126f, 7.9173145f, 14.22005f, 4.3324685f, 10.282523f, 5.3359485f);
                h.cubicTo(8.478971f, 5.619691f, 7.0746775f, 7.0799274f, 6.579045f, 8.803145f);
                h.lineTo(6.579045f, 8.803145f);
                h.lineTo(6.579045f, 8.803145f);
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
