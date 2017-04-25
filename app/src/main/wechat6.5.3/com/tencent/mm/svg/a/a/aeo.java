package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aeo extends c {
    private final int height = 60;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
            case 1:
                return 60;
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
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3355444);
                c = c.a(c, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 17.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(6.095757f, 5.7777686f);
                h.cubicTo(22.562868f, -1.9462895f, 42.458115f, -1.9055293f, 58.93528f, 5.7777686f);
                h.cubicTo(64.454475f, 8.08072f, 64.40421f, 14.979384f, 63.620064f, 20.023458f);
                h.cubicTo(63.13751f, 21.694628f, 63.54969f, 24.11986f, 61.699905f, 24.975822f);
                h.cubicTo(56.512463f, 24.36442f, 51.31497f, 23.528835f, 46.23811f, 22.36717f);
                h.cubicTo(45.956623f, 22.07166f, 45.41375f, 21.460257f, 45.142315f, 21.164745f);
                h.cubicTo(45.464016f, 17.649178f, 46.80109f, 14.357791f, 47.97731f, 11.066404f);
                h.cubicTo(45.293114f, 9.833408f, 42.548595f, 8.671742f, 39.592957f, 8.366041f);
                h.cubicTo(32.032967f, 7.418367f, 23.950207f, 7.499887f, 17.013512f, 11.056214f);
                h.cubicTo(17.958511f, 14.561592f, 20.491913f, 18.454191f, 19.34585f, 22.000328f);
                h.cubicTo(14.580642f, 23.763206f, 9.322828f, 23.946629f, 4.33645f, 24.904493f);
                h.cubicTo(1.8432609f, 25.597416f, 1.8332077f, 22.34679f, 1.4813464f, 20.736763f);
                h.cubicTo(0.6167728f, 15.509267f, 0.29507095f, 8.213191f, 6.095757f, 5.7777686f);
                h.lineTo(6.095757f, 5.7777686f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
