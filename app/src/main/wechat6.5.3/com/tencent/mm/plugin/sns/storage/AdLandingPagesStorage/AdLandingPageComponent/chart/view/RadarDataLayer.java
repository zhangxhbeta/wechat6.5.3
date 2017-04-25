package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import java.util.Map.Entry;
import java.util.Set;

public class RadarDataLayer extends DataLayerView {
    public static final Point jxg = new Point(0, 0);
    private int jxb = 4;
    private float jxe = 1.0f;
    private a jxh;
    private a jxi;
    private b jxj = new b();
    private ValueAnimator jxk;
    private boolean jxl = true;
    private int jxm = 80;
    private Point jxn = jxg;
    private Path mT = new Path();

    public RadarDataLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aTE();
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aTE();
    }

    public RadarDataLayer(Context context, float f, a aVar) {
        super(context);
        this.jxe = f;
        this.jxj = aVar.jwo;
        this.jxb = aVar.size();
        this.jxh = aVar;
        TimeInterpolator timeInterpolator = aVar.jwp;
        long j = aVar.dfS;
        if (j > 0) {
            this.jxk = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.jxi = new a();
            this.jxk.setDuration(j);
            this.jxk.setInterpolator(timeInterpolator);
            this.jxk.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ RadarDataLayer jxo;

                {
                    this.jxo = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (Entry entry : this.jxo.jxh.entrySet()) {
                        this.jxo.jxi.put(entry.getKey(), Float.valueOf(((Float) entry.getValue()).floatValue() * floatValue));
                        this.jxo.invalidate();
                    }
                }
            });
        }
    }

    private void aTE() {
        setMinimumHeight(160);
        setMinimumWidth(160);
    }

    protected final int aTB() {
        return this.jxm * 2;
    }

    protected final int aTC() {
        return this.jxm * 2;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.jxm = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.jxn.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.jxh == null) {
            throw new RuntimeException("Error: NullPointerException at data.");
        } else if (this.jxh != null) {
            Set entrySet;
            if (this.jxi == null) {
                entrySet = this.jxh.entrySet();
            } else {
                entrySet = this.jxi.entrySet();
            }
            int i = 0;
            for (Entry entry : r0) {
                float floatValue = (float) (((double) this.jxn.x) - (((double) ((((Float) entry.getValue()).floatValue() / this.jxe) * ((float) this.jxm))) * Math.sin(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.jxb)))));
                float floatValue2 = (float) (((double) this.jxn.y) - (((double) ((((Float) entry.getValue()).floatValue() / this.jxe) * ((float) this.jxm))) * Math.cos(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.jxb)))));
                if (i == 0) {
                    this.mT.moveTo(floatValue, floatValue2);
                } else {
                    this.mT.lineTo(floatValue, floatValue2);
                }
                if (this.jxl) {
                    float f = (float) this.jxj.jww;
                    Paint paint = new Paint();
                    paint.setColor(this.jxj.jwv);
                    canvas.drawCircle(floatValue, floatValue2, f, paint);
                }
                i++;
            }
            this.mT.close();
            Path path = this.mT;
            Paint paint2 = new Paint();
            b bVar = this.jxj;
            paint2.setColor(bVar.jwt == -1 ? bVar.jwr : bVar.jwt);
            paint2.setStyle(Style.FILL);
            paint2.setAntiAlias(true);
            paint2.setAlpha(this.jxj.jwu);
            canvas.drawPath(path, paint2);
            Path path2 = this.mT;
            Paint paint3 = new Paint();
            paint3.setColor(this.jxj.jwr);
            paint3.setStyle(Style.STROKE);
            paint3.setStrokeWidth(this.jxj.jws);
            paint3.setAntiAlias(true);
            canvas.drawPath(path2, paint3);
            this.mT.reset();
        }
    }
}
