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

public final class ee extends c {
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
                g.setColor(-8617851);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(81.0f, 60.0f);
                h.lineTo(72.0f, 60.0f);
                h.lineTo(72.0f, 68.0f);
                h.lineTo(64.0f, 68.0f);
                h.lineTo(64.0f, 77.0f);
                h.lineTo(72.0f, 77.0f);
                h.lineTo(72.0f, 85.0f);
                h.lineTo(81.0f, 85.0f);
                h.lineTo(81.0f, 77.0f);
                h.lineTo(89.0f, 77.0f);
                h.lineTo(89.0f, 68.0f);
                h.lineTo(81.0f, 68.0f);
                h.lineTo(81.0f, 60.0f);
                h.close();
                h.moveTo(33.0f, 66.0f);
                h.lineTo(27.0f, 69.0f);
                h.lineTo(28.0f, 64.0f);
                h.cubicTo(20.127745f, 59.652744f, 15.2f, 52.282616f, 15.0f, 44.0f);
                h.cubicTo(15.2f, 30.296667f, 28.315445f, 19.235294f, 48.0f, 19.0f);
                h.cubicTo(67.684555f, 19.235294f, 80.8f, 30.296667f, 81.0f, 44.0f);
                h.cubicTo(80.8f, 46.829475f, 80.203674f, 49.600197f, 79.0f, 52.0f);
                h.lineTo(88.0f, 52.0f);
                h.cubicTo(88.59775f, 49.54438f, 89.0f, 46.78464f, 89.0f, 44.0f);
                h.cubicTo(89.0f, 25.74804f, 72.60592f, 11.0f, 48.0f, 11.0f);
                h.cubicTo(23.394077f, 11.0f, 7.0f, 25.74804f, 7.0f, 44.0f);
                h.cubicTo(7.0f, 53.683987f, 11.725022f, 62.435818f, 20.0f, 68.0f);
                h.lineTo(15.0f, 81.0f);
                h.lineTo(31.0f, 74.0f);
                h.cubicTo(36.047134f, 75.924774f, 41.76071f, 76.882355f, 48.0f, 77.0f);
                h.cubicTo(50.683678f, 76.882355f, 53.264854f, 76.696144f, 56.0f, 76.0f);
                h.lineTo(56.0f, 68.0f);
                h.cubicTo(53.296288f, 68.428825f, 50.71238f, 68.64706f, 48.0f, 69.0f);
                h.cubicTo(42.51602f, 68.64706f, 37.537712f, 67.78236f, 33.0f, 66.0f);
                h.lineTo(33.0f, 66.0f);
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
