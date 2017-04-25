package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
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

public final class h extends j {
    ImageView bdF;
    ProgressBar elJ;
    boolean jxO;

    public h(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private h(Context context, ViewGroup viewGroup, byte b) {
        super(context, null, viewGroup);
        this.jxO = true;
    }

    public final View aTM() {
        View view = this.dtW;
        this.bdF = (ImageView) view.findViewById(2131759241);
        this.elJ = (ProgressBar) view.findViewById(2131757495);
        return view;
    }

    protected final int aGY() {
        return 2130904422;
    }

    protected final void aTS() {
        if (this.dtW != null && this.bdF != null && this.elJ != null && ((k) this.jxU) != null) {
            float f = ((k) this.jxU).jvI;
            float f2 = ((k) this.jxU).jvJ;
            float f3 = ((k) this.jxU).jvK;
            float f4 = ((k) this.jxU).jvL;
            String str = ((k) this.jxU).jvA;
            float f5 = ((k) this.jxU).height;
            LayoutParams layoutParams = (LayoutParams) this.bdF.getLayoutParams();
            layoutParams.width = (int) ((k) this.jxU).width;
            layoutParams.height = (int) f5;
            this.bdF.setLayoutParams(layoutParams);
            this.jxO = false;
            startLoading();
            d.a(str, ((k) this.jxU).jvH, new a(this) {
                final /* synthetic */ h jxP;

                {
                    this.jxP = r1;
                }

                public final void aRx() {
                    this.jxP.startLoading();
                }

                public final void aTV() {
                    this.jxP.elJ.setVisibility(8);
                }

                public final void Bg(String str) {
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        h hVar = this.jxP;
                        if (decodeFile == null) {
                            v.e("AdLandingImageComp", "when set image the bmp is null!");
                        } else if (hVar.bdF == null) {
                            v.e("AdLandingImageComp", "when set image the imageView is null!");
                        } else if (decodeFile.getWidth() == 0) {
                            v.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                        } else {
                            hVar.bdF.setImageBitmap(decodeFile);
                            hVar.elJ.setVisibility(8);
                        }
                    } catch (Throwable e) {
                        v.e("AdLandingImageComp", "%s" + be.e(e));
                    }
                }
            });
            this.dtW.setPadding((int) f3, (int) f, (int) f4, (int) f2);
            gl(false);
        }
    }

    public final void startLoading() {
        this.elJ.setVisibility(0);
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
            v.a("AdLandingImageComp", e, "", new Object[0]);
            return false;
        }
    }
}
