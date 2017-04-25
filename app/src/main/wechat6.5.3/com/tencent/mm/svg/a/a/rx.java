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

public final class rx extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(1715420991);
                Path h = c.h(looper);
                h.moveTo(0.0f, 9.0f);
                h.cubicTo(0.0f, 4.029437f, 4.029437f, 0.0f, 9.0f, 0.0f);
                h.lineTo(87.0f, 0.0f);
                h.cubicTo(91.970566f, 0.0f, 96.0f, 4.029437f, 96.0f, 9.0f);
                h.lineTo(96.0f, 87.0f);
                h.cubicTo(96.0f, 91.970566f, 91.970566f, 96.0f, 87.0f, 96.0f);
                h.lineTo(9.0f, 96.0f);
                h.cubicTo(4.029437f, 96.0f, 0.0f, 91.970566f, 0.0f, 87.0f);
                h.lineTo(0.0f, 9.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1969908331);
                h = c.h(looper);
                h.moveTo(3.0f, 9.009863f);
                h.lineTo(3.0f, 86.990135f);
                h.cubicTo(3.0f, 90.3097f, 5.6904397f, 93.0f, 9.009863f, 93.0f);
                h.lineTo(86.990135f, 93.0f);
                h.cubicTo(90.3097f, 93.0f, 93.0f, 90.30956f, 93.0f, 86.990135f);
                h.lineTo(93.0f, 9.009863f);
                h.cubicTo(93.0f, 5.690301f, 90.30956f, 3.0f, 86.990135f, 3.0f);
                h.lineTo(9.009863f, 3.0f);
                h.cubicTo(5.690301f, 3.0f, 3.0f, 5.6904397f, 3.0f, 9.009863f);
                h.close();
                h.moveTo(0.0f, 9.009863f);
                h.cubicTo(0.0f, 4.033853f, 4.033179f, 0.0f, 9.009863f, 0.0f);
                h.lineTo(86.990135f, 0.0f);
                h.cubicTo(91.96615f, 0.0f, 96.0f, 4.033179f, 96.0f, 9.009863f);
                h.lineTo(96.0f, 86.990135f);
                h.cubicTo(96.0f, 91.96615f, 91.96682f, 96.0f, 86.990135f, 96.0f);
                h.lineTo(9.009863f, 96.0f);
                h.cubicTo(4.033853f, 96.0f, 0.0f, 91.96682f, 0.0f, 86.990135f);
                h.lineTo(0.0f, 9.009863f);
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
