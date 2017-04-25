package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.f;
import com.tencent.smtt.sdk.WebView;
import java.util.Timer;
import java.util.TimerTask;

public class CropImageView extends ImageView {
    int bha = 0;
    private float euH;
    private Timer fUZ = new Timer(true);
    private long gWv;
    Bitmap ggw;
    private float gpD;
    float gsW = 0.0f;
    float gsX = 0.0f;
    private OnTouchListener hsc = new OnTouchListener(this) {
        final /* synthetic */ CropImageView oRT;

        {
            this.oRT = r1;
        }

        public final boolean onTouch(View view, final MotionEvent motionEvent) {
            if (!this.oRT.oRS || this.oRT.ggw == null) {
                return false;
            }
            int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
            v.d("MicroMsg.CropImageView", "on touch : event type=" + action + ", isDownOnImg=" + this.oRT.oRB);
            if (!this.oRT.oRB && action != 0) {
                return false;
            }
            switch (action) {
                case 0:
                    v.d("MicroMsg.CropImageView", "action_down");
                    this.oRT.gpD = motionEvent.getRawX();
                    this.oRT.euH = motionEvent.getRawY();
                    v.d("MicroMsg.CropImageView", "lastX=" + this.oRT.gpD + ",lastY=" + this.oRT.euH);
                    this.oRT.oRx = this.oRT.gpD;
                    this.oRT.oRy = this.oRT.euH;
                    Matrix imageMatrix = this.oRT.getImageMatrix();
                    RectF rectF = new RectF();
                    rectF.set(0.0f, 0.0f, (float) this.oRT.ggw.getWidth(), (float) this.oRT.ggw.getHeight());
                    imageMatrix.mapRect(rectF);
                    this.oRT.oRB = rectF.contains(this.oRT.gpD, this.oRT.euH);
                    this.oRT.gWv = System.currentTimeMillis();
                    return false;
                case 1:
                    v.d("MicroMsg.CropImageView", "action_up");
                    if (this.oRT.jOP) {
                        this.oRT.jOP = false;
                        if (this.oRT.oRM) {
                            this.oRT.oRM = false;
                            this.oRT.bJi();
                            this.oRT.bJi();
                            this.oRT.bJi();
                            this.oRT.bJi();
                            this.oRT.bJi();
                            return false;
                        }
                        this.oRT.oRM = true;
                        this.oRT.bJh();
                        this.oRT.bJh();
                        this.oRT.bJh();
                        this.oRT.bJh();
                        this.oRT.bJh();
                        return false;
                    }
                    this.oRT.jOP = true;
                    this.oRT.oRN = new Timer();
                    this.oRT.oRN.schedule(new TimerTask(this) {
                        final /* synthetic */ AnonymousClass3 oRV;

                        public final void run() {
                            if (this.oRV.oRT.jOP) {
                                Message message = new Message();
                                message.what = 4661;
                                message.obj = motionEvent;
                                this.oRV.oRT.oRO.sendMessage(message);
                                this.oRV.oRT.jOP = false;
                            }
                        }
                    }, 200);
                    return false;
                case 2:
                    float f;
                    v.d("MicroMsg.CropImageView", "action_move");
                    if (this.oRT.oRA) {
                        v.d("MicroMsg.CropImageView", "is valid mult down");
                        this.oRT.gsX = f.u(motionEvent);
                        f = this.oRT.gsX - this.oRT.gsW;
                        if (this.oRT.gsX > 5.0f && Math.abs(f) > 5.0f) {
                            f.a(this.oRT.oRz, motionEvent);
                            v.d("MicroMsg.CropImageView", "mX=" + this.oRT.oRz.x + ",mY=" + this.oRT.oRz.y);
                            if (f > 0.0f) {
                                v.d("MicroMsg.CropImageView", "zoom in");
                                this.oRT.bJh();
                            } else {
                                v.d("MicroMsg.CropImageView", "zoom out");
                                this.oRT.bJi();
                            }
                        }
                        this.oRT.gsW = this.oRT.gsX;
                    }
                    if (!this.oRT.oRw) {
                        f = motionEvent.getRawX() - this.oRT.gpD;
                        float rawY = motionEvent.getRawY() - this.oRT.euH;
                        if (Math.abs(f) > 5.0f || Math.abs(rawY) > 5.0f) {
                            this.oRT.getImageMatrix().postTranslate(f, rawY);
                        }
                        this.oRT.invalidate();
                    }
                    this.oRT.oRw = false;
                    this.oRT.gpD = motionEvent.getRawX();
                    this.oRT.euH = motionEvent.getRawY();
                    return false;
                case 5:
                    v.d("MicroMsg.CropImageView", "action_mult_down");
                    this.oRT.oRw = true;
                    this.oRT.gsW = f.u(motionEvent);
                    if (this.oRT.gsW <= 5.0f) {
                        return false;
                    }
                    this.oRT.oRA = true;
                    f.a(this.oRT.oRz, motionEvent);
                    return true;
                case 6:
                    v.d("MicroMsg.CropImageView", "action_mult_up");
                    this.oRT.oRA = false;
                    this.oRT.oRw = true;
                    return true;
                default:
                    return false;
            }
        }
    };
    private boolean jOP = false;
    boolean oRA = false;
    private boolean oRB = false;
    private boolean oRC = false;
    private boolean oRD = false;
    private boolean oRE = false;
    private boolean oRF = false;
    private boolean oRG = false;
    private boolean oRH = false;
    private float oRI = 1.0f;
    private float oRJ = 0.0f;
    private float oRK = 0.0f;
    private c oRL = null;
    private boolean oRM = false;
    private Timer oRN;
    private ac oRO = new ac(this) {
        final /* synthetic */ CropImageView oRT;

        {
            this.oRT = r1;
        }

        public final void handleMessage(Message message) {
            v.d("MicroMsg.CropImageView", "on handler");
            if (message.what == 4659) {
                this.oRT.bJh();
            } else if (message.what == 4658) {
                this.oRT.bJi();
            } else if (message.what == 4660) {
                if (!(this.oRT.fUZ == null || this.oRT.oRL == null)) {
                    this.oRT.oRL.cancel();
                    this.oRT.oRL = null;
                }
            } else if (message.what == 4661) {
                boolean z;
                MotionEvent motionEvent = (MotionEvent) message.obj;
                this.oRT.gWv = System.currentTimeMillis();
                this.oRT.oRB = false;
                if (motionEvent.getRawX() - this.oRT.oRx > 10.0f || motionEvent.getRawY() - this.oRT.oRy > 10.0f || motionEvent.getRawX() - this.oRT.oRx < -10.0f || motionEvent.getRawY() - this.oRT.oRy < -10.0f) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oRT.gWv != 0 && currentTimeMillis - this.oRT.gWv < 300 && currentTimeMillis - this.oRT.gWv >= 0 && this.oRT.oRR != null) {
                        this.oRT.oRR.bJf();
                    }
                    this.oRT.gWv = 0;
                }
                f.a(this.oRT.oRz, this.oRT.ggw);
            }
            super.handleMessage(message);
        }
    };
    private b oRP = null;
    private ac oRQ = new ac(this) {
        final /* synthetic */ CropImageView oRT;

        {
            this.oRT = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what != 4653) {
                CropImageView.o(this.oRT);
            } else if (!(this.oRT.fUZ == null || this.oRT.oRP == null)) {
                this.oRT.oRP.cancel();
                this.oRT.oRP = null;
            }
            super.handleMessage(message);
        }
    };
    a oRR;
    boolean oRS = true;
    boolean oRv = true;
    private boolean oRw = false;
    private float oRx;
    private float oRy;
    private PointF oRz = new PointF();
    boolean oak = false;
    com.tencent.mm.plugin.gif.a oal;

    public interface a {
        void bJf();
    }

    private class b extends TimerTask {
        final /* synthetic */ CropImageView oRT;

        public final void run() {
            Message message = new Message();
            if (this.oRT.oRG || this.oRT.oRH || this.oRT.oRF || this.oRT.oRE) {
                message.what = 4654;
            } else {
                message.what = 4653;
            }
            this.oRT.oRQ.sendMessage(message);
        }
    }

    private class c extends TimerTask {
        final /* synthetic */ CropImageView oRT;

        public final void run() {
            v.d("MicroMsg.CropImageView", "in timer task run");
            Message message = new Message();
            if (this.oRT.oRD) {
                message.what = 4659;
            } else if (this.oRT.oRC) {
                message.what = 4658;
            } else {
                message.what = 4660;
            }
            this.oRT.oRO.sendMessage(message);
        }
    }

    static /* synthetic */ void o(CropImageView cropImageView) {
        if (cropImageView.oRE) {
            cropImageView.oRJ -= -20.0f;
            if (cropImageView.oRJ > 0.0f) {
                cropImageView.oRE = false;
            }
            cropImageView.getImageMatrix().postTranslate(-20.0f, 0.0f);
        }
        if (cropImageView.oRF) {
            cropImageView.oRJ -= 20.0f;
            if (cropImageView.oRJ < 0.0f) {
                cropImageView.oRF = false;
            }
            cropImageView.getImageMatrix().postTranslate(20.0f, 0.0f);
        }
        if (cropImageView.oRG) {
            cropImageView.oRK -= 20.0f;
            if (cropImageView.oRK < 0.0f) {
                cropImageView.oRG = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, 20.0f);
        }
        if (cropImageView.oRH) {
            cropImageView.oRK -= -20.0f;
            if (cropImageView.oRK > 0.0f) {
                cropImageView.oRH = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, -20.0f);
        }
        cropImageView.setImageBitmap(cropImageView.ggw);
        cropImageView.invalidate();
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bJg();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.oak = false;
        this.ggw = bitmap;
        f.a(this.oRz, bitmap);
        super.setImageBitmap(bitmap);
    }

    public final void bJg() {
        setOnTouchListener(this.hsc);
    }

    public final void bJh() {
        this.oRI *= 1.0666f;
        if (1.0f <= this.oRI) {
            this.oRD = false;
        }
        if (1.6f < this.oRI) {
            this.oRC = true;
        } else {
            this.oRC = false;
        }
        if (!this.oRv || 4.0f >= this.oRI) {
            float[] fArr = new float[2];
            r1 = new float[2];
            float f = this.oRz.x;
            r1[0] = f;
            fArr[0] = f;
            f = this.oRz.y;
            r1[1] = f;
            fArr[1] = f;
            getImageMatrix().mapPoints(fArr);
            getImageMatrix().postScale(1.0666f, 1.0666f);
            getImageMatrix().mapPoints(r1);
            getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
            setImageBitmap(this.ggw);
            invalidate();
            return;
        }
        this.oRI = 4.0f;
    }

    public final void bJi() {
        this.oRI *= 0.9375f;
        if (1.6f > this.oRI) {
            this.oRC = false;
        }
        if (1.0f > this.oRI) {
            this.oRD = true;
        } else {
            this.oRD = false;
        }
        if (0.4f > this.oRI) {
            this.oRI = 0.4f;
            return;
        }
        float[] fArr = new float[2];
        r1 = new float[2];
        float f = this.oRz.x;
        r1[0] = f;
        fArr[0] = f;
        f = this.oRz.y;
        r1[1] = f;
        fArr[1] = f;
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postScale(0.9375f, 0.9375f);
        getImageMatrix().mapPoints(r1);
        getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
        setImageBitmap(this.ggw);
        invalidate();
    }

    public final int bJj() {
        if (!this.oak || this.oal == null) {
            return getWidth();
        }
        return this.oal.getIntrinsicWidth();
    }

    public final int bJk() {
        if (!this.oak || this.oal == null) {
            return getHeight();
        }
        return this.oal.getIntrinsicHeight();
    }
}
