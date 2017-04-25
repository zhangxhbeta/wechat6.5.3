package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import org.json.JSONObject;

public final class s extends j implements SensorEventListener {
    private SensorManager aHA;
    Sensor aLo;
    Sensor aLq;
    ImageView bdF;
    ProgressBar elJ;
    int jyY;
    final float jyZ = 10.0f;
    final int jza = 1;
    HorizontalScrollView jzb;
    float[] jzc;
    float[] jzd;
    private int jze = 0;
    boolean jzf = true;

    public s(Context context, j jVar, ViewGroup viewGroup) {
        super(context, jVar, viewGroup);
    }

    protected final int aGY() {
        return 2130904419;
    }

    public final View aTM() {
        View view = this.dtW;
        this.aHA = (SensorManager) this.context.getSystemService("sensor");
        this.aLo = this.aHA.getDefaultSensor(1);
        this.aLq = this.aHA.getDefaultSensor(2);
        this.jzb = (HorizontalScrollView) view.findViewById(2131759236);
        this.bdF = (ImageView) view.findViewById(2131759237);
        this.elJ = (ProgressBar) view.findViewById(2131757495);
        this.elJ.setVisibility(8);
        return view;
    }

    protected final void aTS() {
        if (!e.aR(d.cI("adId", ((j) this.jxU).jvA))) {
            this.jzf = false;
        }
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.jzb.setLayoutParams(new LayoutParams(width, height));
        this.bdF.setLayoutParams(new LayoutParams(width, height));
        this.dtW.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        this.dtW.setPadding(this.dtW.getPaddingLeft(), (int) ((j) this.jxU).jvI, this.dtW.getPaddingRight(), (int) ((j) this.jxU).jvJ);
        String str = ((j) this.jxU).jvA;
        Bitmap cK = d.cK("adId", str);
        if (cK != null) {
            v.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  " + str);
            y(cK);
            return;
        }
        startLoading();
        d.a(str, ((j) this.jxU).jvH, new a(this) {
            final /* synthetic */ s jzg;

            {
                this.jzg = r1;
            }

            public final void aRx() {
                this.jzg.startLoading();
            }

            public final void aTV() {
                this.jzg.elJ.setVisibility(8);
            }

            public final void Bg(String str) {
                try {
                    this.jzg.y(BitmapFactory.decodeFile(str));
                } catch (Throwable e) {
                    v.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + be.e(e));
                }
            }
        });
    }

    public final void startLoading() {
        this.elJ.setVisibility(0);
    }

    public final void y(Bitmap bitmap) {
        if (bitmap == null) {
            v.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
        } else if (this.bdF == null) {
            v.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
        } else if (bitmap.getHeight() == 0) {
            v.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
        } else {
            this.elJ.setVisibility(8);
            this.bdF.setImageBitmap(bitmap);
            WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
            final int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            this.bdF.setLayoutParams(new LayoutParams((bitmap.getWidth() * height) / bitmap.getHeight(), height));
            this.bdF.post(new Runnable(this) {
                final /* synthetic */ s jzg;

                public final void run() {
                    int measuredWidth = this.jzg.bdF.getMeasuredWidth();
                    if (measuredWidth > width) {
                        this.jzg.jyY = (measuredWidth - width) / 2;
                        this.jzg.jzb.scrollBy(this.jzg.jyY, 0);
                    }
                }
            });
            if (bitmap.getHeight() != 0) {
                this.dtW.setLayoutParams(new LinearLayout.LayoutParams((bitmap.getWidth() * height) / bitmap.getHeight(), height));
            }
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -10.0f;
        if (sensorEvent.sensor.getType() == 1) {
            this.jzc = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.jzd = sensorEvent.values;
        }
        if (this.jzc != null && this.jzd != null) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, new float[9], this.jzc, this.jzd)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                float f2 = fArr2[2];
                if (this.jyY != 0) {
                    if (f2 > 10.0f) {
                        f2 = 10.0f;
                    }
                    if (f2 >= -10.0f) {
                        f = f2;
                    }
                    this.jzb.scrollBy((int) ((f * ((float) this.jyY)) / 10.0f), 0);
                }
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void aTO() {
        super.aTO();
        this.aHA.registerListener(this, this.aLo, 1);
        this.aHA.registerListener(this, this.aLq, 1);
    }

    public final void aTP() {
        super.aTP();
        this.aHA.unregisterListener(this);
    }

    public final boolean x(JSONObject jSONObject) {
        if (!super.x(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("swipeCount", this.jze);
            if (!this.jzf) {
                String Kg = z.Kg(((j) this.jxU).jvA);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Kg);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e, "", new Object[0]);
            return false;
        }
    }
}
