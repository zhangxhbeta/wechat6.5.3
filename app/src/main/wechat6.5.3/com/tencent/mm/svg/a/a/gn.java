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

public final class gn extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-15028967);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(18.0743f, 25.9257f);
                h.cubicTo(21.81657f, 29.66797f, 25.362413f, 31.423225f, 26.673681f, 31.320438f);
                h.cubicTo(27.98495f, 31.217651f, 31.250372f, 28.972013f, 32.791916f, 29.001904f);
                h.cubicTo(33.5328f, 29.01627f, 38.37422f, 32.290524f, 38.960274f, 32.669083f);
                h.cubicTo(39.54633f, 33.047638f, 40.089733f, 33.48984f, 39.987553f, 34.049404f);
                h.cubicTo(39.885376f, 34.608967f, 37.757626f, 40.772552f, 32.325485f, 39.919037f);
                h.cubicTo(26.893343f, 39.06552f, 19.320179f, 33.20958f, 15.004804f, 28.995195f);
                h.lineTo(18.0743f, 25.9257f);
                h.lineTo(18.0743f, 25.9257f);
                h.close();
                h.moveTo(18.0743f, 25.9257f);
                h.cubicTo(14.33203f, 22.18343f, 12.576774f, 18.637587f, 12.679562f, 17.326319f);
                h.cubicTo(12.782349f, 16.01505f, 15.027987f, 12.749629f, 14.998096f, 11.208082f);
                h.cubicTo(14.983731f, 10.467202f, 11.709476f, 5.625779f, 11.330918f, 5.0397243f);
                h.cubicTo(10.952361f, 4.45367f, 10.510159f, 3.9102678f, 9.950595f, 4.012446f);
                h.cubicTo(9.391031f, 4.1146235f, 3.2274485f, 6.2423735f, 4.080963f, 11.674515f);
                h.cubicTo(4.9344783f, 17.106657f, 10.790419f, 24.679821f, 15.004804f, 28.995195f);
                h.lineTo(18.0743f, 25.9257f);
                h.lineTo(18.0743f, 25.9257f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(39.25f, 16.954916f);
                h.cubicTo(39.652576f, 17.12634f, 40.0f, 16.78943f, 40.0f, 16.273945f);
                h.lineTo(40.0f, 7.7189007f);
                h.cubicTo(40.0f, 7.1419024f, 39.615803f, 6.899748f, 39.25f, 7.03793f);
                h.cubicTo(39.033016f, 7.2903256f, 36.0f, 10.012693f, 36.0f, 10.012693f);
                h.lineTo(36.0f, 13.939582f);
                h.cubicTo(36.0f, 13.939582f, 39.103306f, 16.747684f, 39.25f, 16.954916f);
                h.close();
                h.moveTo(22.0f, 8.47057f);
                h.cubicTo(22.0f, 8.210681f, 22.25619f, 8.0f, 22.570713f, 8.0f);
                h.lineTo(33.429287f, 8.0f);
                h.cubicTo(33.744484f, 8.0f, 34.0f, 8.209868f, 34.0f, 8.47057f);
                h.lineTo(34.0f, 15.52943f);
                h.cubicTo(34.0f, 15.789319f, 33.743813f, 16.0f, 33.429287f, 16.0f);
                h.lineTo(22.570713f, 16.0f);
                h.cubicTo(22.255516f, 16.0f, 22.0f, 15.790132f, 22.0f, 15.52943f);
                h.lineTo(22.0f, 8.47057f);
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
