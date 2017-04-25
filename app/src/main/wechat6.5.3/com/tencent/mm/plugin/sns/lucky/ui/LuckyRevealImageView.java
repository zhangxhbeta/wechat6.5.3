package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.bd.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LuckyRevealImageView extends ImageView {
    static int jfC = 0;
    static int jfD = 0;
    private static Point jgb = null;
    private int alpha;
    ac cnC;
    private Paint evR;
    Bitmap jfE;
    Bitmap jfF;
    private Bitmap jfG;
    int jfH;
    private int jfI;
    private int jfJ;
    private int jfK;
    private int jfL;
    private int jfM;
    private float jfN;
    private float jfO;
    private int jfP;
    private int jfQ;
    private int jfR;
    private int jfS;
    private float jfT;
    private boolean jfU;
    private boolean jfV;
    private boolean jfW;
    aib jfX;
    private float[] jfY;
    private float jfZ;
    private float jga;
    private Runnable jgc;
    private float jgd;
    private boolean jge;
    private boolean jgf;

    static /* synthetic */ void b(LuckyRevealImageView luckyRevealImageView) {
        if (luckyRevealImageView.jfX != null) {
            int i;
            float f;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                luckyRevealImageView.jfU = false;
                InputStream openRead = FileOp.openRead(luckyRevealImageView.aRo());
                Options options = new Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeStream(openRead, null, options, null, 0, new int[0]);
                luckyRevealImageView.jfP = options.outWidth;
                luckyRevealImageView.jfQ = options.outHeight;
                luckyRevealImageView.jfR = luckyRevealImageView.jfE.getWidth();
                luckyRevealImageView.jfS = luckyRevealImageView.jfE.getHeight();
                luckyRevealImageView.jfN = ((float) luckyRevealImageView.jfP) / ((float) luckyRevealImageView.jfR);
                luckyRevealImageView.jfO = ((float) luckyRevealImageView.jfQ) / ((float) luckyRevealImageView.jfS);
                i = luckyRevealImageView.azJ().x / 3;
                if ((luckyRevealImageView.jfN <= 1.0f || luckyRevealImageView.jfO <= 1.0f) && (luckyRevealImageView.jfR < i || luckyRevealImageView.jfS < i)) {
                    v.i("MicroMsg.LuckyRevealImageView", "calcRoundScaleRatio, too small, coordXScaleRatio: %s, coordYScaleRatio: %s, originSmallImgWidth: %s, originSmallImgHeight: %s, originBigImgWidth: %s, originBigImgHeight: %s, sizeLimit: %s", new Object[]{Float.valueOf(luckyRevealImageView.jfN), Float.valueOf(luckyRevealImageView.jfO), Integer.valueOf(luckyRevealImageView.jfR), Integer.valueOf(luckyRevealImageView.jfS), Integer.valueOf(luckyRevealImageView.jfP), Integer.valueOf(luckyRevealImageView.jfQ), Integer.valueOf(i)});
                    while (true) {
                        if (luckyRevealImageView.jfR >= i && luckyRevealImageView.jfS >= i) {
                            break;
                        }
                        luckyRevealImageView.jfR *= 2;
                        luckyRevealImageView.jfS *= 2;
                    }
                    luckyRevealImageView.jfP = luckyRevealImageView.jfR;
                    luckyRevealImageView.jfQ = luckyRevealImageView.jfS;
                    luckyRevealImageView.jfE = Bitmap.createScaledBitmap(luckyRevealImageView.jfE, luckyRevealImageView.jfR, luckyRevealImageView.jfS, true);
                    luckyRevealImageView.jfF = Bitmap.createScaledBitmap(luckyRevealImageView.jfF, luckyRevealImageView.jfR, luckyRevealImageView.jfS, true);
                    luckyRevealImageView.jfN = 1.0f;
                    luckyRevealImageView.jfO = 1.0f;
                    v.i("MicroMsg.LuckyRevealImageView", "after scale, originSmallImgWidth: %s, originSmallImgHeight: %s", new Object[]{Integer.valueOf(luckyRevealImageView.jfR), Integer.valueOf(luckyRevealImageView.jfS)});
                    luckyRevealImageView.cnC.post(new Runnable(luckyRevealImageView) {
                        final /* synthetic */ LuckyRevealImageView jgg;

                        {
                            this.jgg = r1;
                        }

                        public final void run() {
                            this.jgg.aRn();
                        }
                    });
                    luckyRevealImageView.jfU = true;
                }
                if (luckyRevealImageView.getScaleType() == ScaleType.CENTER_CROP) {
                    luckyRevealImageView.jga = ((float) luckyRevealImageView.azJ().x) / ((float) luckyRevealImageView.jfR);
                    luckyRevealImageView.jfZ = (((float) luckyRevealImageView.azJ().y) - (((float) luckyRevealImageView.jfS) * luckyRevealImageView.jga)) * 0.5f;
                    v.i("MicroMsg.LuckyRevealImageView", "CENTER_CROP, dy: %s, scale: %s", new Object[]{Float.valueOf(luckyRevealImageView.jfZ), Float.valueOf(luckyRevealImageView.jga)});
                    luckyRevealImageView.jfZ = Math.abs(luckyRevealImageView.jfZ);
                }
                Point azJ = luckyRevealImageView.azJ();
                f = ((float) azJ.x) / ((float) luckyRevealImageView.jfP);
                float f2 = ((float) azJ.y) / ((float) luckyRevealImageView.jfQ);
                int i2 = Math.max(f, f2) >= 1.5f ? 1 : 0;
                boolean z = ((float) luckyRevealImageView.jfR) / ((float) luckyRevealImageView.jfS) >= 2.0f;
                if (i2 != 0) {
                    if (luckyRevealImageView.getScaleType() == ScaleType.CENTER_CROP || !z) {
                        luckyRevealImageView.jfT = f;
                    } else {
                        luckyRevealImageView.jfT = f2 / 1.5f;
                    }
                }
                if (i2 != 0) {
                    luckyRevealImageView.jfT = Math.max(1.0f, luckyRevealImageView.jfT);
                }
                if (luckyRevealImageView.jfS >= luckyRevealImageView.azJ().y && luckyRevealImageView.getScaleType() == ScaleType.CENTER_CROP) {
                    v.i("MicroMsg.LuckyRevealImageView", "origin small img is too big!");
                    luckyRevealImageView.jfV = true;
                    luckyRevealImageView.jfN = 1.0f;
                    luckyRevealImageView.jfO = 1.0f;
                }
                v.d("MicroMsg.LuckyRevealImageView", "screenWidth/bigImgWidth: %s, screenHeight/bigImgHeight: %s, screeSize: %s, radiusCompensateRatio: %s, isLongPic: %b", new Object[]{Float.valueOf(f), Float.valueOf(f2), azJ, Float.valueOf(luckyRevealImageView.jfT), Boolean.valueOf(z)});
                v.i("MicroMsg.LuckyRevealImageView", "calcRoundScaleRatio, bigImgWidth: %d, bigImgHeight: %d, smallWidth: %d, smallHeight: %d, coordXScaleRatio: %f, coordYScaleRatio: %f", new Object[]{Integer.valueOf(luckyRevealImageView.jfP), Integer.valueOf(luckyRevealImageView.jfQ), Integer.valueOf(luckyRevealImageView.jfR), Integer.valueOf(luckyRevealImageView.jfS), Float.valueOf(luckyRevealImageView.jfN), Float.valueOf(luckyRevealImageView.jfO)});
            } catch (Exception e) {
                try {
                    v.e("MicroMsg.LuckyRevealImageView", "calcRoundScaleRatio error: %s", new Object[]{e.getMessage()});
                } catch (Exception e2) {
                    v.e("MicroMsg.LuckyRevealImageView", "clipRound, error: %s", new Object[]{e2.getMessage()});
                }
            }
            if (luckyRevealImageView.jfV) {
                luckyRevealImageView.jfN = 1.0f;
                luckyRevealImageView.jfO = 1.0f;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            Random random = new Random();
            if (luckyRevealImageView.jfQ == 0 || luckyRevealImageView.jfP == 0) {
                luckyRevealImageView.jfR = luckyRevealImageView.jfE.getWidth();
                luckyRevealImageView.jfS = luckyRevealImageView.jfE.getHeight();
            }
            if (((float) luckyRevealImageView.jfP) / ((float) luckyRevealImageView.jfQ) >= 2.0f) {
                i = Math.max(luckyRevealImageView.jfS, luckyRevealImageView.jfR) / 2;
                luckyRevealImageView.jfK = (int) (((float) (random.nextInt(a.fromDPToPix(luckyRevealImageView.getContext(), 30)) + a.fromDPToPix(luckyRevealImageView.getContext(), 70))) / Math.min(luckyRevealImageView.jfN, luckyRevealImageView.jfO));
            } else {
                i = Math.max(luckyRevealImageView.jfS, luckyRevealImageView.jfR) / 2;
                luckyRevealImageView.jfK = (int) (((float) (random.nextInt(a.fromDPToPix(luckyRevealImageView.getContext(), 20)) + a.fromDPToPix(luckyRevealImageView.getContext(), 30))) / Math.min(luckyRevealImageView.jfN, luckyRevealImageView.jfO));
            }
            if (luckyRevealImageView.jfN > 1.0f && luckyRevealImageView.jfO > 1.0f) {
                luckyRevealImageView.jfK = Math.min(i, luckyRevealImageView.jfK);
            }
            luckyRevealImageView.jfL = luckyRevealImageView.jfK;
            luckyRevealImageView.jfK = (int) (((float) luckyRevealImageView.jfK) * Math.max(luckyRevealImageView.jfN, luckyRevealImageView.jfO));
            if (luckyRevealImageView.jfT > 0.0f) {
                luckyRevealImageView.jfK = (int) (((float) luckyRevealImageView.jfK) / luckyRevealImageView.jfT);
            }
            if (luckyRevealImageView.getScaleType() == ScaleType.CENTER_CROP && luckyRevealImageView.jfV) {
                luckyRevealImageView.jfK = (int) (((float) luckyRevealImageView.jfK) / luckyRevealImageView.jga);
            }
            v.i("MicroMsg.LuckyRevealImageView", "setRandomRoundRadius, roundRadius: %s, radiusCompensateRatio: %s, isLongPic: %s, screenWidth / originSmallImgWidth: %s, screenHeight / originSmallImgHeight: %s", new Object[]{Integer.valueOf(luckyRevealImageView.jfK), Float.valueOf(luckyRevealImageView.jfT), Boolean.valueOf(r1), Float.valueOf(((float) luckyRevealImageView.azJ().x) / ((float) luckyRevealImageView.jfR)), Float.valueOf(((float) luckyRevealImageView.azJ().y) / ((float) luckyRevealImageView.jfS))});
            List aRr = luckyRevealImageView.aRr();
            long currentTimeMillis3 = System.currentTimeMillis();
            v.d("MicroMsg.LuckyRevealImageView", "setRoundParam, detectFace used %dms, bitmapWidth: %d, bitmapHeight: %d, isUseFace: %b", new Object[]{Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Integer.valueOf(luckyRevealImageView.jfE.getWidth()), Integer.valueOf(luckyRevealImageView.jfE.getHeight()), Boolean.valueOf(new Random().nextFloat() >= 0.5f)});
            v.d("MicroMsg.LuckyRevealImageView", "setRoundParam, faceList.size: %d", new Object[]{Integer.valueOf(aRr.size())});
            if (aRr.size() >= 5 || aRr.size() <= 0 || !r0) {
                luckyRevealImageView.aRq();
            } else {
                Face face;
                if (aRr.size() == 1) {
                    face = (Face) aRr.get(0);
                } else {
                    i = new Random().nextInt(aRr.size());
                    if (i >= aRr.size()) {
                        i = 0;
                    }
                    face = (Face) aRr.get(i);
                }
                PointF pointF = new PointF();
                face.getMidPoint(pointF);
                v.d("MicroMsg.LuckyRevealImageView", "select face midPoint: %s, eyeDistance: %s", new Object[]{pointF, Float.valueOf(face.eyesDistance())});
                Random random2 = new Random();
                f = random2.nextFloat();
                float eyesDistance = face.eyesDistance() * 1.5f;
                if (f >= 0.9f) {
                    luckyRevealImageView.jfI = (int) (pointF.x * luckyRevealImageView.jfN);
                    luckyRevealImageView.jfJ = (int) ((eyesDistance + pointF.y) * luckyRevealImageView.jfO);
                    luckyRevealImageView.aRp();
                } else if (f >= 0.6f) {
                    if (pointF.x > eyesDistance) {
                        luckyRevealImageView.jfI = (int) (((float) random2.nextInt((int) (pointF.x - eyesDistance))) + ((pointF.x - eyesDistance) * luckyRevealImageView.jfN));
                    } else {
                        luckyRevealImageView.jfI = (int) (((pointF.x + eyesDistance) + ((float) random2.nextInt(10))) * luckyRevealImageView.jfN);
                    }
                    if (pointF.y > eyesDistance) {
                        luckyRevealImageView.jfJ = (int) (((pointF.y - eyesDistance) * luckyRevealImageView.jfN) + ((float) random2.nextInt((int) (pointF.y - eyesDistance))));
                    } else {
                        luckyRevealImageView.jfJ = (int) (((eyesDistance + pointF.y) + ((float) random2.nextInt(10))) * luckyRevealImageView.jfO);
                    }
                    luckyRevealImageView.aRp();
                } else {
                    luckyRevealImageView.aRq();
                }
                v.d("MicroMsg.LuckyRevealImageView", "setFaceRoundParam, roundCenterX: %d, roundCenterY: %d, roundRadius: %d", new Object[]{Integer.valueOf(luckyRevealImageView.jfI), Integer.valueOf(luckyRevealImageView.jfJ), Integer.valueOf(luckyRevealImageView.jfK)});
            }
            luckyRevealImageView.jfM = luckyRevealImageView.jfK - ((int) (((float) luckyRevealImageView.jfK) * 0.3f));
            v.i("MicroMsg.LuckyRevealImageView", "setRoundParam, roundInnerRadius: %d, blurEdgeLen: %d", new Object[]{Integer.valueOf(luckyRevealImageView.jfM), Integer.valueOf(i)});
            v.i("MicroMsg.LuckyRevealImageView", "roundCenterX: %d, roundCenterY: %d, radius: %d", new Object[]{Integer.valueOf(luckyRevealImageView.jfI), Integer.valueOf(luckyRevealImageView.jfJ), Integer.valueOf(luckyRevealImageView.jfK)});
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            if (luckyRevealImageView.jfU || luckyRevealImageView.jfV) {
                luckyRevealImageView.jfG = Bitmap.createBitmap(luckyRevealImageView.jfE.getWidth(), luckyRevealImageView.jfE.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(luckyRevealImageView.jfG);
                Path path = new Path();
                path.addCircle((float) luckyRevealImageView.jfI, (float) luckyRevealImageView.jfJ, (float) luckyRevealImageView.jfK, Direction.CW);
                canvas.clipPath(path);
                canvas.drawBitmap(luckyRevealImageView.jfE, 0.0f, 0.0f, paint);
                luckyRevealImageView.jfG = Bitmap.createBitmap(luckyRevealImageView.jfG, luckyRevealImageView.jfI - luckyRevealImageView.jfK, luckyRevealImageView.jfJ - luckyRevealImageView.jfK, luckyRevealImageView.jfK * 2, luckyRevealImageView.jfK * 2);
            } else {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(FileOp.openRead(luckyRevealImageView.aRo()), true);
                Rect rect = new Rect(luckyRevealImageView.jfI - luckyRevealImageView.jfK, luckyRevealImageView.jfJ - luckyRevealImageView.jfK, luckyRevealImageView.jfI + luckyRevealImageView.jfK, luckyRevealImageView.jfJ + luckyRevealImageView.jfK);
                Options options2 = new Options();
                options2.inJustDecodeBounds = false;
                luckyRevealImageView.jfG = newInstance.decodeRegion(rect, options2);
                if (luckyRevealImageView.jfG != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(luckyRevealImageView.jfG.getWidth(), luckyRevealImageView.jfG.getHeight(), Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    Path path2 = new Path();
                    path2.addCircle((float) (luckyRevealImageView.jfG.getWidth() / 2), (float) (luckyRevealImageView.jfG.getHeight() / 2), (float) luckyRevealImageView.jfK, Direction.CW);
                    canvas2.clipPath(path2, Op.REPLACE);
                    canvas2.drawBitmap(luckyRevealImageView.jfG, 0.0f, 0.0f, paint);
                    luckyRevealImageView.jfG = createBitmap;
                } else {
                    v.e("MicroMsg.LuckyRevealImageView", "clip round bitmap error! roundBitmap is null!");
                }
            }
            luckyRevealImageView.aRs();
            luckyRevealImageView.cnC.post(new Runnable(luckyRevealImageView) {
                final /* synthetic */ LuckyRevealImageView jgg;

                {
                    this.jgg = r1;
                }

                public final void run() {
                    LuckyRevealImageView.c(this.jgg);
                }
            });
            v.d("MicroMsg.LuckyRevealImageView", "clipRound used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    static /* synthetic */ void c(LuckyRevealImageView luckyRevealImageView) {
        luckyRevealImageView.alpha = 0;
        luckyRevealImageView.jfW = true;
        luckyRevealImageView.jgd = 13.6f;
        luckyRevealImageView.jge = true;
        luckyRevealImageView.jgf = false;
        v.d("MicroMsg.LuckyRevealImageView", "scheduleShowClip, alphaChangeStep: %s", new Object[]{Float.valueOf(luckyRevealImageView.jgd)});
        luckyRevealImageView.invalidate();
    }

    static /* synthetic */ void e(LuckyRevealImageView luckyRevealImageView) {
        luckyRevealImageView.alpha = 255;
        luckyRevealImageView.jgf = true;
        luckyRevealImageView.jgd = 13.6f;
        luckyRevealImageView.jgd = -luckyRevealImageView.jgd;
        v.d("MicroMsg.LuckyRevealImageView", "scheduleHideClip, alphaChangeStep: %s", new Object[]{Float.valueOf(luckyRevealImageView.jgd)});
        luckyRevealImageView.invalidate();
    }

    public LuckyRevealImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnC = new ac(Looper.getMainLooper());
        this.jfE = null;
        this.jfF = null;
        this.jfG = null;
        this.jfH = Integer.MIN_VALUE;
        this.jfU = false;
        this.jfV = false;
        this.jfY = new float[9];
        this.jgc = new Runnable(this) {
            final /* synthetic */ LuckyRevealImageView jgg;

            {
                this.jgg = r1;
            }

            public final void run() {
                this.jgg.jge = false;
                LuckyRevealImageView.e(this.jgg);
            }
        };
        this.evR = new Paint();
        this.alpha = 0;
        this.jgd = 0.0f;
        this.jge = false;
        this.jgf = false;
    }

    public LuckyRevealImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cnC = new ac(Looper.getMainLooper());
        this.jfE = null;
        this.jfF = null;
        this.jfG = null;
        this.jfH = Integer.MIN_VALUE;
        this.jfU = false;
        this.jfV = false;
        this.jfY = new float[9];
        this.jgc = /* anonymous class already generated */;
        this.evR = new Paint();
        this.alpha = 0;
        this.jgd = 0.0f;
        this.jge = false;
        this.jgf = false;
    }

    final void aRn() {
        k.h(this, this.jfF.getWidth(), this.jfF.getHeight());
        this.jfR = this.jfE.getWidth();
        this.jfS = this.jfE.getHeight();
        v.i("MicroMsg.LuckyRevealImageView", "setFinalScaleType, originSmallImgWidth/originSmallImgHeight: %s, screenWidth/screenHeight: %s", new Object[]{Float.valueOf(((float) this.jfR) / ((float) this.jfS)), Float.valueOf(((float) azJ().x) / ((float) azJ().y))});
        if (((float) this.jfR) / ((float) this.jfS) < ((float) azJ().x) / ((float) azJ().y)) {
            setScaleType(ScaleType.CENTER_CROP);
        } else {
            setScaleType(ScaleType.FIT_CENTER);
        }
        setImageBitmap(this.jfF);
    }

    private String aRo() {
        return al.cA(ad.xh(), this.jfX.gID) + i.b(this.jfX);
    }

    private Point azJ() {
        if (jgb == null) {
            jgb = new Point();
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getSize(jgb);
        }
        return jgb;
    }

    private void aRp() {
        int i;
        int i2;
        if (this.jfV) {
            i = this.jfR;
            i2 = this.jfS;
        } else {
            i = this.jfP;
            i2 = this.jfQ;
        }
        if (i > this.jfK * 3) {
            this.jfI = Math.min(i - (this.jfK * 3), Math.max(this.jfK * 2, this.jfI));
        } else {
            this.jfI = Math.min(i / 2, Math.max(this.jfK * 2, this.jfI));
        }
        v.d("MicroMsg.LuckyRevealImageView", "trimRoundCenterCoord, widthBound/heightBound: %s, screenWidth/screenHeight: %s", new Object[]{Float.valueOf(((float) i) / ((float) i2)), Float.valueOf(((float) azJ().x) / ((float) azJ().y))});
        if (getScaleType() == ScaleType.CENTER_CROP && this.jfV) {
            if (((float) this.jfJ) <= (this.jfZ / this.jga) + ((float) (this.jfK * 2))) {
                this.jfJ = (int) ((this.jfZ / this.jga) + ((float) (this.jfK * 2)));
            }
        } else if (i2 > this.jfK * 3) {
            this.jfJ = Math.min(i2 - (this.jfK * 3), Math.max(this.jfK * 2, this.jfJ));
        } else {
            this.jfJ = Math.min(i2 / 2, Math.max(this.jfK * 2, this.jfJ));
        }
        if (this.jfV && getScaleType() == ScaleType.CENTER_CROP) {
            i2 = ((int) (((float) i2) - (this.jfZ / this.jga))) - (this.jfK * 2);
        } else {
            float f = ((float) i) / ((float) i2);
            float f2 = ((float) azJ().x) / ((float) azJ().y);
            if (((double) Math.abs(f - f2)) >= 0.4d) {
                i2 = (i2 - (i2 / 5)) - (this.jfK * 2);
            } else if (((double) Math.abs(f - f2)) <= 0.2d) {
                i2 = (i2 - (i2 / 4)) - (this.jfK * 2);
            } else if (((double) f) < 0.5d) {
                i2 = (i2 - (i2 / 3)) - (this.jfK * 2);
            }
        }
        if (getScaleType() == ScaleType.CENTER_CROP) {
            if (this.jfV) {
                i2 -= a.fromDPToPix(getContext(), 50);
            } else {
                i2 = (int) (((float) i2) - (((float) a.fromDPToPix(getContext(), 50)) / (this.jga / this.jfO)));
            }
        }
        if (i2 > 0) {
            this.jfJ = Math.min(i2, this.jfJ);
        }
        v.i("MicroMsg.LuckyRevealImageView", "trimRoundCenterCoord, yCoordUpperBound: %d, roundCenterY: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.jfJ)});
    }

    private void aRq() {
        Random random = new Random();
        this.jfI = random.nextInt(this.jfR);
        if (getScaleType() == ScaleType.CENTER_CROP && this.jfV) {
            this.jfJ = (int) ((((float) random.nextInt(azJ().y)) / this.jga) + ((float) ((int) (this.jfZ / this.jga))));
            v.i("MicroMsg.LuckyRevealImageView", "setNormalRandomRoundParam, smallImgTooBig, topOffset: %d", new Object[]{Integer.valueOf(r1)});
        } else {
            this.jfJ = random.nextInt(this.jfS);
        }
        v.d("MicroMsg.LuckyRevealImageView", "setNormalRandomRoundParam, radius: %d, centerX: %d, centerY: %d,  bitmapWidth: %d, bitmapHeight: %d", new Object[]{Integer.valueOf(this.jfK), Integer.valueOf(this.jfI), Integer.valueOf(this.jfJ), Integer.valueOf(this.jfR), Integer.valueOf(this.jfS)});
        this.jfI = (int) (((float) this.jfI) * this.jfN);
        this.jfJ = (int) (((float) this.jfJ) * this.jfO);
        aRp();
        v.i("MicroMsg.LuckyRevealImageView", "after process, centerX: %d, centerY: %d, radius: %d, 50_DP: %s", new Object[]{Integer.valueOf(this.jfI), Integer.valueOf(this.jfJ), Integer.valueOf(this.jfK), Integer.valueOf(jfC)});
    }

    private List<Face> aRr() {
        List<Face> arrayList = new ArrayList();
        try {
            FaceDetector faceDetector = new FaceDetector(this.jfE.getWidth(), this.jfE.getHeight(), 10);
            Bitmap createBitmap = Bitmap.createBitmap(this.jfE.getWidth(), this.jfE.getHeight(), Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.jfE, 0.0f, 0.0f, null);
            Face[] faceArr = new Face[10];
            faceDetector.findFaces(createBitmap, faceArr);
            for (int i = 0; i < 10; i++) {
                Face face = faceArr[i];
                if (face != null && ((double) face.confidence()) > 0.3d) {
                    arrayList.add(face);
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.LuckyRevealImageView", "detectFace error: %s", new Object[]{e.getMessage()});
        }
        return arrayList;
    }

    private void aRs() {
        long currentTimeMillis = System.currentTimeMillis();
        int width = this.jfG.getWidth();
        int height = this.jfG.getHeight();
        int[] iArr = new int[(width * height)];
        this.jfG.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = this.jfK - this.jfM;
        for (int i2 = 0; i2 < width; i2++) {
            for (int i3 = 0; i3 < height; i3++) {
                int sqrt = (int) Math.sqrt(Math.pow((double) (i2 - (width / 2)), 2.0d) + Math.pow((double) (i3 - (height / 2)), 2.0d));
                if (sqrt >= this.jfM) {
                    if (iArr[(i3 * width) + i2] != 0) {
                        int i4 = iArr[(i3 * width) + i2];
                        int alpha = Color.alpha(i4);
                        iArr[(i3 * width) + i2] = Color.argb(Math.min(255, Math.max((int) (((float) ((Math.sin((((double) (1.0f - (((float) (sqrt - this.jfM)) / ((float) i)))) * 3.141592653589793d) - 1.5707963267948966d) + 1.0d) / 2.0d)) * ((float) alpha)), 0)), Color.red(i4), Color.green(i4), Color.blue(i4));
                    } else {
                        iArr[(i3 * width) + i2] = Color.argb(0, 0, 0, 0);
                    }
                }
            }
        }
        this.jfG.setPixels(iArr, 0, width, 0, 0, width, height);
        v.d("MicroMsg.LuckyRevealImageView", "blurRoundEdge used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jfW && this.jfG != null) {
            this.evR.reset();
            if (this.jge || this.jgf) {
                this.alpha = (int) (((float) this.alpha) + this.jgd);
                this.alpha = Math.min(255, Math.max(0, this.alpha));
                this.evR.setAlpha(this.alpha);
            }
            int i = this.jfI - this.jfK;
            int i2 = this.jfJ - this.jfK;
            if (getImageMatrix() == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                canvas.save();
                canvas.translate((float) i, (float) i2);
                canvas.drawBitmap(this.jfG, 0.0f, 0.0f, this.evR);
                canvas.restore();
            } else {
                canvas.save();
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                getImageMatrix().getValues(this.jfY);
                float f = this.jfY[2];
                float f2 = this.jfY[5];
                float f3 = this.jfY[0];
                float f4 = this.jfY[4];
                canvas.translate(f, f2);
                canvas.scale(f3 / this.jfN, f4 / this.jfO);
                canvas.translate((float) i, (float) i2);
                canvas.drawBitmap(this.jfG, 0.0f, 0.0f, this.evR);
                canvas.restore();
            }
            if (this.alpha >= 255 && this.jge) {
                this.jge = false;
                this.cnC.postDelayed(this.jgc, 1500);
            } else if (this.alpha <= 0 && this.jgf) {
                this.jfW = false;
                invalidate();
            } else if (this.jfW || this.jgf) {
                invalidate();
            }
        }
    }
}
