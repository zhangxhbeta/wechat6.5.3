package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import org.json.JSONObject;

public final class u extends c {
    private ImageView bdF;
    ProgressBar elJ;
    private int eww;
    private int ewx;
    boolean jvx;
    boolean jxO = true;
    private WindowManager jzl;

    public u(Context context, k kVar, ViewGroup viewGroup) {
        super(context, kVar, viewGroup);
    }

    protected final int aGY() {
        return 2130904426;
    }

    public final View aTM() {
        this.bdF = (ImageView) this.dtW.findViewById(2131759241);
        this.elJ = (ProgressBar) this.dtW.findViewById(2131757495);
        return this.dtW;
    }

    protected final void aTS() {
        if (this.dtW != null && this.bdF != null && this.elJ != null && ((k) this.jxU) != null) {
            if (this.jzl == null) {
                this.jzl = (WindowManager) this.context.getSystemService("window");
                this.eww = this.jzl.getDefaultDisplay().getWidth();
                this.ewx = this.jzl.getDefaultDisplay().getHeight();
            }
            float f = ((k) this.jxU).jvK;
            float f2 = ((k) this.jxU).jvL;
            String str = ((k) this.jxU).jvA;
            float f3 = ((k) this.jxU).height;
            float f4 = ((k) this.jxU).width;
            this.jvx = ((k) this.jxU).jvx;
            if (f3 != 0.0f && f4 != 0.0f && !this.jvx) {
                this.bdF.setLayoutParams(new LayoutParams((this.eww - ((int) f)) - ((int) f2), (((this.eww - ((int) f)) - ((int) f2)) * ((int) f3)) / ((int) f4)));
            } else if (!this.jvx || f3 == 0.0f || f4 == 0.0f) {
                this.bdF.setLayoutParams(new LayoutParams(this.eww, this.ewx));
            } else {
                this.bdF.setLayoutParams(new LayoutParams(this.eww, this.ewx));
            }
            Bitmap cK = d.cK("adId", str);
            if (cK == null || !z(cK)) {
                this.jxO = false;
                startLoading();
                d.a(str, ((k) this.jxU).jvH, new a(this) {
                    final /* synthetic */ u jzm;

                    {
                        this.jzm = r1;
                    }

                    public final void aRx() {
                        this.jzm.startLoading();
                    }

                    public final void aTV() {
                        this.jzm.elJ.setVisibility(8);
                    }

                    public final void Bg(String str) {
                        try {
                            this.jzm.z(BitmapFactory.decodeFile(str));
                        } catch (Throwable e) {
                            v.e("AdLandingPagePureImageComponet", "%s" + be.e(e));
                        }
                    }
                });
                return;
            }
            v.i("AdLandingPagePureImageComponet", "loaded cached image with  " + str);
            this.jxO = true;
        }
    }

    public final void startLoading() {
        this.elJ.setVisibility(0);
    }

    public final boolean z(Bitmap bitmap) {
        if (bitmap == null) {
            v.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            return false;
        } else if (this.bdF == null) {
            v.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            return false;
        } else if (bitmap.getWidth() == 0) {
            v.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            return false;
        } else {
            this.bdF.setImageBitmap(bitmap);
            this.elJ.setVisibility(8);
            if (this.jvx) {
                this.bdF.setLayoutParams(new LayoutParams(this.eww, (this.eww * bitmap.getHeight()) / bitmap.getWidth()));
            }
            return true;
        }
    }

    public final boolean x(JSONObject jSONObject) {
        if (!super.x(jSONObject)) {
            return false;
        }
        try {
            if (!this.jxO) {
                String Kg = z.Kg(((k) this.jxU).jvA);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Kg);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            v.a("AdLandingPagePureImageComponet", e, "", new Object[0]);
            return false;
        }
    }
}
