package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class br extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, -275.0f, 0.0f, 1.0f, -1626.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 126.0f, 0.0f, 1.0f, 1626.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 149.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                g2 = c.a(a, looper);
                a2.setColor(-70474);
                g2.setColor(-36352);
                g2.setStrokeWidth(5.4f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(42.0f, 21.25926f);
                h.cubicTo(42.0f, 9.401778f, 32.59822f, 0.0f, 20.74074f, 0.0f);
                h.cubicTo(9.401778f, 0.0f, 0.0f, 9.401778f, 0.0f, 21.25926f);
                h.cubicTo(0.0f, 32.59822f, 9.401778f, 42.0f, 20.74074f, 42.0f);
                h.cubicTo(32.59822f, 42.0f, 42.0f, 32.59822f, 42.0f, 21.25926f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                a3.setColor(-36352);
                h = c.h(looper);
                h.moveTo(7.1932015f, 22.069902f);
                h.cubicTo(7.0209723f, 21.90468f, 7.0013413f, 21.619408f, 7.147708f, 21.434807f);
                h.lineTo(8.144134f, 20.17808f);
                h.cubicTo(8.291237f, 19.992548f, 8.567782f, 19.95389f, 8.763619f, 20.093018f);
                h.lineTo(15.588285f, 24.941442f);
                h.cubicTo(15.783314f, 25.079996f, 16.094162f, 25.074368f, 16.278591f, 24.931952f);
                h.lineTo(33.272747f, 11.8091545f);
                h.cubicTo(33.45896f, 11.6653595f, 33.751038f, 11.677971f, 33.93421f, 11.845651f);
                h.lineTo(34.814766f, 12.651727f);
                h.cubicTo(34.993866f, 12.815679f, 34.995564f, 13.079486f, 34.821854f, 13.237947f);
                h.lineTo(16.258057f, 30.172258f);
                h.cubicTo(16.08287f, 30.332067f, 15.798551f, 30.325104f, 15.629005f, 30.162458f);
                h.lineTo(7.1932015f, 22.069902f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
