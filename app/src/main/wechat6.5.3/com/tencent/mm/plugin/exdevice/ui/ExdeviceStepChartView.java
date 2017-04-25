package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.v;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView extends View {
    Paint evR;
    private final int fEG;
    private final int fEH;
    private final int fEI;
    private final float fEJ;
    private final float fEK;
    private final float fEL;
    private final float fEM;
    private final float fEN;
    private final int fEO;
    private final int fEP;
    private final int fEQ;
    private final int fER;
    private int fES;
    private int fET;
    private int fEU;
    private final float fEV;
    private final float fEW;
    private final int fEX;
    private final float fEY;
    private final int fEZ;
    private final int fFA;
    private final int fFB;
    private final float fFC;
    private final int fFD;
    private final float fFE;
    private final int fFF;
    private final float fFG;
    private final int fFH;
    private final float fFI;
    private final int fFJ;
    private final float fFK;
    private final int fFL;
    private final int fFM;
    private final int fFN;
    private final int fFO;
    private final int fFP;
    private final int fFQ;
    private final int fFR;
    private final int fFS;
    private final int fFT;
    private int fFU;
    private final Typeface fFV;
    private final Typeface fFW;
    private int fFX;
    private int fFY;
    int[] fFZ;
    private final float fFa;
    private final int fFb;
    private final float fFc;
    private final int fFd;
    private final float fFe;
    private final int fFf;
    private final float fFg;
    private final int fFh;
    private final float fFi;
    private final int fFj;
    private final float fFk;
    private final int fFl;
    private final float fFm;
    private final int fFn;
    private final float fFo;
    private final int fFp;
    private final float fFq;
    private final int fFr;
    private final float fFs;
    private final int fFt;
    private final float fFu;
    private final float fFv;
    private final float fFw;
    private final float fFx;
    private final int fFy;
    private final int fFz;
    private final int fGa;
    private float[] fGb;
    private float[] fGc;
    private boolean[] fGd;
    Path fGe;
    Path fGf;
    List<String> fGg;
    private boolean fGh;
    PathEffect fGi;
    private int fGj;
    private int fGk;
    private boolean fGl;
    List<Point> points;

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEG = -1;
        this.fEH = -1;
        this.fEI = getResources().getColor(2131689694);
        this.fEJ = 12.0f;
        this.fEK = 28.0f;
        this.fEL = 33.0f;
        this.fEM = 12.0f;
        this.fEN = 12.0f;
        this.fEO = getResources().getColor(2131689695);
        this.fEP = -1;
        this.fEQ = getResources().getColor(2131689695);
        this.fER = -1;
        this.fES = Integer.MAX_VALUE;
        this.fET = 0;
        this.fEU = 0;
        this.fEV = 10.0f;
        this.fEW = 2.5f;
        this.fEX = (int) g(1, 2.5f);
        this.fEY = 4.0f;
        this.fEZ = (int) g(1, 4.0f);
        this.fFa = 1.8f;
        this.fFb = (int) g(1, 1.8f);
        this.fFc = 1.0f;
        this.fFd = (int) g(1, 1.0f);
        this.fFe = 8.0f;
        this.fFf = (int) g(1, 8.0f);
        this.fFg = 22.0f;
        this.fFh = (int) g(1, 22.0f);
        this.fFi = 67.0f;
        this.fFj = (int) g(1, 67.0f);
        this.fFk = 40.0f;
        this.fFl = (int) g(1, 40.0f);
        this.fFm = 22.0f;
        this.fFn = (int) g(1, 22.0f);
        this.fFo = 55.0f;
        this.fFp = (int) g(1, 55.0f);
        this.fFq = 35.0f;
        this.fFr = (int) g(1, 35.0f);
        this.fFs = 45.0f;
        this.fFt = (int) g(1, 45.0f);
        this.fFu = 8.0f;
        this.fFv = (float) ((int) g(1, 8.0f));
        this.fFw = 8.0f;
        this.fFx = (float) ((int) g(1, 8.0f));
        this.fFy = 2;
        this.fFz = (int) g(1, 2.0f);
        this.fFA = 15;
        this.fFB = (int) g(1, 15.0f);
        this.fFC = 33.0f;
        this.fFD = (int) g(1, 33.0f);
        this.fFE = 8.0f;
        this.fFF = (int) g(1, 8.0f);
        this.fFG = 35.0f;
        this.fFH = (int) g(1, 35.0f);
        this.fFI = 10.0f;
        this.fFJ = (int) g(1, 10.0f);
        this.fFK = 58.0f;
        this.fFL = (int) g(1, 58.0f);
        this.fFM = (int) g(1, 1.0f);
        this.fFN = 102;
        this.fFO = 102;
        this.fFP = 153;
        this.fFQ = 102;
        this.fFR = 102;
        this.fFS = 102;
        this.fFT = 204;
        this.fFU = 0;
        this.fFV = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.fFW = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.fFX = 0;
        this.fFY = 0;
        this.fFZ = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.fGa = 7;
        this.fGb = new float[7];
        this.fGc = new float[7];
        this.fGd = new boolean[7];
        this.fGh = false;
        this.fGi = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        akC();
    }

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEG = -1;
        this.fEH = -1;
        this.fEI = getResources().getColor(2131689694);
        this.fEJ = 12.0f;
        this.fEK = 28.0f;
        this.fEL = 33.0f;
        this.fEM = 12.0f;
        this.fEN = 12.0f;
        this.fEO = getResources().getColor(2131689695);
        this.fEP = -1;
        this.fEQ = getResources().getColor(2131689695);
        this.fER = -1;
        this.fES = Integer.MAX_VALUE;
        this.fET = 0;
        this.fEU = 0;
        this.fEV = 10.0f;
        this.fEW = 2.5f;
        this.fEX = (int) g(1, 2.5f);
        this.fEY = 4.0f;
        this.fEZ = (int) g(1, 4.0f);
        this.fFa = 1.8f;
        this.fFb = (int) g(1, 1.8f);
        this.fFc = 1.0f;
        this.fFd = (int) g(1, 1.0f);
        this.fFe = 8.0f;
        this.fFf = (int) g(1, 8.0f);
        this.fFg = 22.0f;
        this.fFh = (int) g(1, 22.0f);
        this.fFi = 67.0f;
        this.fFj = (int) g(1, 67.0f);
        this.fFk = 40.0f;
        this.fFl = (int) g(1, 40.0f);
        this.fFm = 22.0f;
        this.fFn = (int) g(1, 22.0f);
        this.fFo = 55.0f;
        this.fFp = (int) g(1, 55.0f);
        this.fFq = 35.0f;
        this.fFr = (int) g(1, 35.0f);
        this.fFs = 45.0f;
        this.fFt = (int) g(1, 45.0f);
        this.fFu = 8.0f;
        this.fFv = (float) ((int) g(1, 8.0f));
        this.fFw = 8.0f;
        this.fFx = (float) ((int) g(1, 8.0f));
        this.fFy = 2;
        this.fFz = (int) g(1, 2.0f);
        this.fFA = 15;
        this.fFB = (int) g(1, 15.0f);
        this.fFC = 33.0f;
        this.fFD = (int) g(1, 33.0f);
        this.fFE = 8.0f;
        this.fFF = (int) g(1, 8.0f);
        this.fFG = 35.0f;
        this.fFH = (int) g(1, 35.0f);
        this.fFI = 10.0f;
        this.fFJ = (int) g(1, 10.0f);
        this.fFK = 58.0f;
        this.fFL = (int) g(1, 58.0f);
        this.fFM = (int) g(1, 1.0f);
        this.fFN = 102;
        this.fFO = 102;
        this.fFP = 153;
        this.fFQ = 102;
        this.fFR = 102;
        this.fFS = 102;
        this.fFT = 204;
        this.fFU = 0;
        this.fFV = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.fFW = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.fFX = 0;
        this.fFY = 0;
        this.fFZ = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.fGa = 7;
        this.fGb = new float[7];
        this.fGc = new float[7];
        this.fGd = new boolean[7];
        this.fGh = false;
        this.fGi = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        akC();
    }

    private void a(Canvas canvas, boolean z) {
        int i = 0;
        if (z) {
            this.fGf.reset();
            this.fGf.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                this.fGf.lineTo((float) ((Point) this.points.get(i2)).x, (float) ((Point) this.points.get(i2)).y);
            }
            this.fGf.lineTo(this.fGb[this.fGb.length - 1], (float) ((this.fEU - this.fFr) - 1));
            this.fGf.lineTo((float) this.fFf, (float) ((this.fEU - this.fFr) - 1));
            this.fGf.lineTo((float) this.fFf, this.fGc[0]);
            canvas.drawPath(this.fGf, this.evR);
            return;
        }
        this.fGf.reset();
        this.fGf.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
        while (i < this.points.size()) {
            if (i <= 0) {
                akE();
            } else if (((Point) this.points.get(i - 1)).y == this.fEU - this.fFl) {
                this.evR.reset();
                this.evR.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.evR.setAntiAlias(true);
                this.evR.setStrokeWidth((float) this.fFb);
                this.evR.setStyle(Style.STROKE);
                this.evR.setColor(-1);
            } else {
                akE();
            }
            this.fGf.lineTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            canvas.drawPath(this.fGf, this.evR);
            this.fGf.reset();
            this.fGf.moveTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            i++;
        }
    }

    private void d(Canvas canvas) {
        this.evR.reset();
        this.evR.setAntiAlias(true);
        this.evR.setColor(-1);
        this.evR.setStrokeWidth(0.0f);
        this.evR.setStyle(Style.FILL);
        for (int i = 0; i < this.points.size(); i++) {
            Point point = (Point) this.points.get(i);
            if (i == this.points.size() - 1) {
                canvas.drawCircle((float) point.x, (float) point.y, (float) this.fEZ, this.evR);
            } else {
                canvas.drawCircle((float) point.x, (float) point.y, (float) this.fEX, this.evR);
            }
        }
    }

    public final void akB() {
        this.fGh = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getResources().getString(2131232569));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d");
        this.fGg.clear();
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, -6);
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                this.fGg.add(simpleDateFormat.format(instance.getTime()));
            } else {
                this.fGg.add(simpleDateFormat2.format(instance.getTime()));
            }
            instance.add(5, 1);
        }
        invalidate();
    }

    private float g(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        return TypedValue.applyDimension(i, f, system.getDisplayMetrics());
    }

    private void a(Canvas canvas, List<String> list) {
        if (list != null && list.size() == 7) {
            this.evR.reset();
            this.evR.setAntiAlias(true);
            this.evR.setStrokeWidth(0.0f);
            this.evR.setTextSize(g(2, 12.0f));
            this.evR.setAlpha(153);
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    this.evR.setTextAlign(Align.LEFT);
                } else {
                    this.evR.setTextAlign(Align.CENTER);
                }
                if (this.fGd[i]) {
                    this.evR.setColor(-1);
                } else {
                    this.evR.setColor(this.fEO);
                }
                canvas.drawText((String) list.get(i), (float) ((Point) this.points.get(i)).x, (float) (this.fEU - this.fFB), this.evR);
            }
        }
    }

    private void akC() {
        this.evR = new Paint();
        this.fGe = new Path();
        this.fGf = new Path();
        this.points = new LinkedList();
        this.fGg = new LinkedList();
        akD();
    }

    private void akD() {
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                this.fGd[i] = true;
            } else {
                this.fGd[i] = false;
            }
        }
    }

    private void akE() {
        this.evR.reset();
        this.evR.setAntiAlias(true);
        this.evR.setStrokeWidth((float) this.fFb);
        this.evR.setStyle(Style.STROKE);
        this.evR.setColor(-1);
    }

    protected void onDraw(Canvas canvas) {
        int i;
        this.points.clear();
        View findViewById = findViewById(2131756846);
        this.fET = findViewById.getWidth();
        this.fEU = findViewById.getHeight();
        this.fFX = ((this.fET - this.fFf) - this.fFh) / 6;
        this.fFY = ((this.fEU - this.fFj) - this.fFl) / 2;
        for (i = 0; i < this.fGb.length; i++) {
            this.fGb[i] = (float) (this.fFf + (this.fFX * i));
        }
        i = this.fFZ.length;
        if (i > 7) {
            i = 7;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.fFZ[i3] > 100000) {
                this.fFZ[i3] = 100000;
            }
            if (this.fFZ[i3] < 0) {
                this.fFZ[i3] = 0;
            }
            if (this.fFZ[i3] > i2) {
                i2 = this.fFZ[i3];
            }
        }
        if (i2 <= 15000 && i2 >= 0) {
            i2 = 15000;
        } else if (i2 <= 15000 || i2 > 100000) {
            i2 = 0;
        } else if (((double) i2) / 5000.0d > ((double) (((float) i2) / 5000.0f))) {
            i2 = ((i2 / 5000) + 1) * 5000;
        }
        this.fFU = (((this.fEU - this.fFj) - this.fFl) * 10000) / i2;
        this.fFU = (this.fEU - this.fFl) - this.fFU;
        for (int i4 = 0; i4 < i; i4++) {
            this.fGc[i4] = ((float) (this.fEU - this.fFl)) - ((((float) this.fFZ[i4]) / ((float) i2)) * ((float) ((this.fEU - this.fFj) - this.fFl)));
            this.points.add(new Point((int) this.fGb[i4], (int) this.fGc[i4]));
        }
        super.onDraw(canvas);
        if (!this.fGh) {
            d(canvas);
            if (this.fES != Integer.MAX_VALUE) {
                i2 = this.fES;
                this.evR.reset();
                this.evR.setColor(this.fEO);
                this.evR.setAntiAlias(true);
                this.evR.setStrokeWidth(0.0f);
                this.evR.setTextSize(g(2, 12.0f));
                this.evR.setTextAlign(Align.CENTER);
                if (i2 >= 0 && i2 <= 6) {
                    if (i2 == 0) {
                        this.evR.setTextAlign(Align.LEFT);
                    }
                    if (i2 == 6) {
                        this.evR.setTextAlign(Align.RIGHT);
                    }
                    if (!this.fGl) {
                        this.fGj = ((Point) this.points.get(i2)).y - this.fFL;
                        this.fGk = this.fGj;
                        this.fGl = true;
                    }
                    if (this.fGl) {
                        float f = (float) (((double) this.fGk) / 8.0d);
                        if (this.fGj > 0) {
                            this.evR.setAlpha(((this.fGk - this.fGj) * 255) / this.fGk);
                        }
                        canvas.drawText(this.fFZ[i2], (float) ((Point) this.points.get(i2)).x, (float) (this.fGj + this.fFL), this.evR);
                        if (this.fGj > 0) {
                            if (((float) this.fGj) / ((float) this.fGk) <= 1.0f / f) {
                                this.fGj--;
                            } else {
                                this.fGj = (int) (((float) this.fGj) - ((((float) this.fGj) / ((float) this.fGk)) * f));
                            }
                            invalidate();
                        } else {
                            this.fGl = false;
                        }
                    }
                }
                i = this.fES;
                if (i >= 0 && i <= 6) {
                    this.fGd[i] = true;
                }
            }
        }
        this.evR.reset();
        this.fGe.reset();
        this.evR.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.evR.setColor(this.fEI);
        this.evR.setStrokeWidth((float) this.fFd);
        this.evR.setAlpha(102);
        this.evR.setStyle(Style.STROKE);
        if (!(this.fFU == 0 || this.fGh)) {
            this.fGe.moveTo((float) this.fFf, (float) this.fFU);
            this.fGe.lineTo((float) (this.fET - this.fFn), (float) this.fFU);
            canvas.drawPath(this.fGe, this.evR);
        }
        this.evR.reset();
        this.fGe.reset();
        this.evR.setColor(this.fEI);
        this.evR.setStrokeWidth((float) this.fFd);
        this.evR.setStyle(Style.STROKE);
        this.evR.setAlpha(102);
        this.fGe.reset();
        this.fGe.moveTo(this.fFv, (float) (this.fEU - this.fFr));
        this.fGe.lineTo(((float) this.fET) - this.fFx, (float) (this.fEU - this.fFr));
        this.fGe.moveTo(this.fFv, (float) this.fFt);
        this.fGe.lineTo(((float) this.fET) - this.fFx, (float) this.fFt);
        canvas.drawPath(this.fGe, this.evR);
        if (!this.fGh) {
            this.evR.reset();
            this.evR.setColor(this.fEQ);
            this.evR.setAntiAlias(true);
            this.evR.setAlpha(102);
            this.evR.setStrokeWidth(0.0f);
            this.evR.setTextSize(g(2, 12.0f));
            this.evR.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(2131232568), (float) (this.fET - this.fFz), (float) (((double) this.fFU) + (((double) this.evR.getTextSize()) * 0.34d)), this.evR);
        }
        this.evR.reset();
        this.evR.setColor(-1);
        this.evR.setAntiAlias(true);
        this.evR.setStrokeWidth(0.0f);
        this.evR.setTypeface(this.fFV);
        this.evR.setTextSize(g(2, 28.0f));
        canvas.drawText(getResources().getString(2131232570), (float) this.fFF, (float) this.fFD, this.evR);
        this.evR.setTextAlign(Align.RIGHT);
        this.evR.setTextSize(g(2, 33.0f));
        canvas.drawText(this.fFZ[this.fFZ.length - 1], (float) (this.fET - this.fFJ), (float) this.fFH, this.evR);
        if (this.points.size() > 2) {
            this.evR.reset();
            this.evR.setAntiAlias(true);
            this.evR.setStrokeWidth(0.0f);
            this.evR.setAlpha(102);
            this.evR.setStyle(Style.FILL_AND_STROKE);
            this.evR.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.fEU - this.fFr), -1, 16777215, TileMode.REPEAT));
            this.evR.setColor(-1);
            a(canvas, true);
            akE();
            if (!this.fGh) {
                a(canvas, false);
            }
        }
        a(canvas, this.fGg);
    }

    private int M(float f) {
        this.fES = Integer.MAX_VALUE;
        if (this.points.size() > 0) {
            int i = 0;
            while (i < this.points.size()) {
                if (i != 0) {
                    if (i > 0 && i < this.points.size() - 1) {
                        if (f < ((float) (((Point) this.points.get(i)).x + (this.fFX / 2))) && f > ((float) (((Point) this.points.get(i)).x - (this.fFX / 2)))) {
                            this.fES = i;
                            invalidate();
                            break;
                        }
                    } else if (i == this.points.size() - 1) {
                        if (f < ((float) this.fET) && f > ((float) (((Point) this.points.get(i)).x - (this.fFX / 2)))) {
                            this.fES = i;
                            invalidate();
                            break;
                        }
                    } else {
                        this.fES = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f < ((float) (((Point) this.points.get(i)).x + (this.fFX / 2))) && f > 0.0f) {
                    this.fES = i;
                    invalidate();
                    break;
                }
                i++;
            }
        }
        return this.fES;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        v.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.fES);
        switch (motionEvent.getAction()) {
            case 0:
                v.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
                return true;
            case 1:
                v.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
                this.fES = M(x);
                akD();
                this.fGl = false;
                invalidate();
                return false;
            default:
                v.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
                return false;
        }
    }
}
