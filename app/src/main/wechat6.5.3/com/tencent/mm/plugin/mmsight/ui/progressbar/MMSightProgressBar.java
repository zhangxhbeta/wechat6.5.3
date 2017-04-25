package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.support.Log;
import java.util.ArrayList;
import java.util.List;

public class MMSightProgressBar extends View {
    public static final int fEX = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 3);
    public static final int hyo = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 5);
    private static final int[] hyp = new int[]{-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private boolean bhY = false;
    private int centerX = 0;
    private int centerY = 0;
    private Paint evR;
    private ac handler = null;
    private List<a> hyq = new ArrayList(5);
    private int hyr = 0;
    private b hys;
    private boolean hyt = false;
    private a hyu;

    public interface a {
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.evR = new Paint();
        this.evR.setColor(-65536);
        this.evR.setAntiAlias(true);
        this.handler = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ MMSightProgressBar hyv;

            public final void handleMessage(Message message) {
                if (message.what == 233 && this.hyv.bhY && this.hyv.hyq.size() > 0 && this.hyv.hyq.size() < 5) {
                    this.hyv.hys = new b((a) this.hyv.hyq.get(this.hyv.hyq.size() - 1), new a(this.hyv.hyq.size(), this.hyv.centerX, this.hyv.centerY, MMSightProgressBar.hyp[this.hyv.hyq.size()]), new com.tencent.mm.plugin.mmsight.ui.progressbar.b.a(this) {
                        final /* synthetic */ AnonymousClass1 hyw;

                        {
                            this.hyw = r1;
                        }

                        public final void a(a aVar) {
                            this.hyw.hyv.hyq.add(aVar);
                            this.hyw.hyv.hys = null;
                            if (this.hyw.hyv.hyq.size() >= 5) {
                                Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
                                if (this.hyw.hyv.hyu != null) {
                                    this.hyw.hyv.hyu;
                                }
                            } else if (this.hyw.hyv.bhY) {
                                this.hyw.hyv.handler.sendEmptyMessage(233);
                            }
                            this.hyw.hyv.invalidate();
                        }

                        public final void aBM() {
                            this.hyw.hyv.invalidate();
                        }
                    });
                    b g = this.hyv.hys;
                    g.hvM = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
                    g.hvM.addUpdateListener(new AnimatorUpdateListener(g) {
                        final /* synthetic */ b hyS;

                        {
                            this.hyS = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.hyS.hyB = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            b bVar = this.hyS;
                            float f = this.hyS.hyB;
                            bVar.hyP = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.hyo + (MMSightProgressBar.fEX * 2)))) * (f / 100.0f)));
                            bVar.hyM = bVar.hyN - ((f / 100.0f) * (bVar.hyN - bVar.hyO));
                            bVar.hyG = new PointF((float) MMSightProgressBar.fEX, 0.0f);
                            bVar.hyH = new PointF(((float) MMSightProgressBar.fEX) + (bVar.hyP / 2.0f), ((float) MMSightProgressBar.fEX) - (bVar.hyM / 2.0f));
                            bVar.hyI = new PointF(((float) MMSightProgressBar.fEX) + bVar.hyP, 0.0f);
                            bVar.hyJ = new PointF((float) MMSightProgressBar.fEX, (float) (MMSightProgressBar.fEX * 2));
                            bVar.hyK = new PointF(((float) MMSightProgressBar.fEX) + (bVar.hyP / 2.0f), ((float) MMSightProgressBar.fEX) + (bVar.hyM / 2.0f));
                            bVar.hyL = new PointF(((float) MMSightProgressBar.fEX) + bVar.hyP, ((float) MMSightProgressBar.fEX) * 2.0f);
                            v.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", new Object[]{Float.valueOf(bVar.hyP), Float.valueOf(bVar.hyM)});
                            v.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", new Object[]{bVar.hyG, bVar.hyH, bVar.hyI, bVar.hyJ, bVar.hyK, bVar.hyL});
                            if (this.hyS.hyF != null) {
                                this.hyS.hyF.aBM();
                            }
                        }
                    });
                    g.hvM.addListener(new AnimatorListenerAdapter(g) {
                        final /* synthetic */ b hyS;

                        {
                            this.hyS = r1;
                        }

                        public final void onAnimationStart(Animator animator) {
                            this.hyS.hyE = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            this.hyS.hyE = true;
                            if (this.hyS.hyF != null) {
                                this.hyS.hyF.a(this.hyS.hyD);
                            }
                        }
                    });
                    g.hvM.setInterpolator(new AccelerateDecelerateInterpolator());
                    g.hvM.setDuration(2000);
                    g.hvM.start();
                }
            }
        };
        Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[]{Integer.valueOf(fEX), Integer.valueOf(hyo)});
    }

    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.bhY && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            int right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", new Object[]{Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY)});
            Log.i("MicroMsg.MMSightProgressBar", "add init point");
            this.hyq.add(new a(0, this.centerX, this.centerY, -1));
        }
        int save = canvas.save();
        this.hyr = this.hyq.size();
        if (this.hyr % 2 == 0) {
            f = -(((((float) hyo) / 2.0f) + ((float) (((this.hyr / 2) - 1) * hyo))) + ((float) ((this.hyr / 2) * fEX)));
        } else {
            f = -(((((float) fEX) / 2.0f) + ((float) ((this.hyr / 2) * hyo))) + ((float) ((this.hyr / 2) * fEX)));
        }
        if (this.hys != null && this.hys.hyE) {
            float f2;
            right = this.hyr + 1;
            if (right % 2 == 0) {
                f2 = -(((float) ((right / 2) * fEX)) + ((((float) hyo) / 2.0f) + ((float) (((right / 2) - 1) * hyo))));
            } else {
                f2 = -(((float) ((right / 2) * fEX)) + ((((float) fEX) / 2.0f) + ((float) ((right / 2) * hyo))));
            }
            Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[]{Float.valueOf(f2), Float.valueOf(this.hys.hyB)});
            f -= (Math.abs(f2) - Math.abs(f)) * (this.hys.hyB / 100.0f);
        }
        Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[]{Float.valueOf(f), Integer.valueOf(this.hyr)});
        canvas.translate(f, 0.0f);
        if (this.hys != null && this.hys.hyE) {
            b bVar = this.hys;
            Paint paint = this.evR;
            v.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[]{Float.valueOf(bVar.hyB), Float.valueOf(((float) (hyo + (fEX * 2))) * (bVar.hyB / 100.0f))});
            if (bVar.hyM > bVar.hyO) {
                float f3 = bVar.hyC.hyx - ((float) fEX);
                f = bVar.hyC.hyy - ((float) fEX);
                paint.setColor(bVar.hyD.color);
                bVar.hyQ.reset();
                bVar.hyQ.moveTo(bVar.hyG.x + f3, bVar.hyG.y + f);
                bVar.hyQ.quadTo(bVar.hyH.x + f3, bVar.hyH.y + f, bVar.hyI.x + f3, bVar.hyI.y + f);
                bVar.hyQ.lineTo(bVar.hyL.x + f3, bVar.hyL.y + f);
                bVar.hyQ.quadTo(bVar.hyK.x + f3, bVar.hyK.y + f, bVar.hyJ.x + f3, f + bVar.hyJ.y);
                if (bVar.hyD.color != bVar.hyC.color) {
                    paint.setShader(new LinearGradient(bVar.hyG.x + f3, bVar.hyC.hyy - ((float) fEX), f3 + bVar.hyI.x, bVar.hyC.hyy - ((float) fEX), new int[]{bVar.hyC.color, bVar.hyD.color}, null, TileMode.REPEAT));
                }
                canvas.drawPath(bVar.hyQ, paint);
                paint.setShader(null);
            }
            a aVar = bVar.hyD;
            paint.setColor(aVar.color);
            aVar.hyy = (float) aVar.hyA;
            aVar.hyx = ((float) (aVar.hyz + ((aVar.index - 1) * (hyo + (fEX * 2))))) + r11;
            Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[]{Integer.valueOf(aVar.index), Float.valueOf(r11), Float.valueOf(aVar.hyx)});
            canvas.drawCircle(aVar.hyx, aVar.hyy, (float) fEX, paint);
            paint.setShader(null);
        }
        for (a aVar2 : this.hyq) {
            Paint paint2 = this.evR;
            paint2.setColor(aVar2.color);
            aVar2.hyx = (float) (aVar2.hyz + (aVar2.index * (hyo + (fEX * 2))));
            aVar2.hyy = (float) aVar2.hyA;
            Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[]{Integer.valueOf(aVar2.index), Float.valueOf(aVar2.hyx)});
            canvas.drawCircle(aVar2.hyx, aVar2.hyy, (float) fEX, paint2);
            paint2.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.bhY && !this.hyt && this.hyq.size() > 0) {
            Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.hyt = true;
            this.handler.sendEmptyMessage(233);
        }
    }
}
