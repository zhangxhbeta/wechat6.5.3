package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class m extends c {
    CircularImageView jyd;

    public m(Context context, k kVar, ViewGroup viewGroup) {
        super(context, kVar, viewGroup);
    }

    protected final View aTT() {
        return new CircularImageView(this.context);
    }

    public final View aTM() {
        this.jyd = (CircularImageView) this.dtW;
        return this.dtW;
    }

    protected final void aTS() {
        if (this.dtW != null && this.jyd != null) {
            k kVar = (k) this.jxU;
            if (kVar != null) {
                d.a(kVar.jvA, kVar.jvH, new a(this) {
                    final /* synthetic */ m jye;

                    {
                        this.jye = r1;
                    }

                    public final void aRx() {
                    }

                    public final void aTV() {
                    }

                    public final void Bg(String str) {
                        try {
                            Bitmap decodeFile = BitmapFactory.decodeFile(str);
                            m mVar = this.jye;
                            if (decodeFile == null) {
                                v.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
                            } else if (mVar.jyd == null) {
                                v.e("AdLandingPageCircleImgComp", "when set image the img is null!");
                            } else if (decodeFile.getWidth() == 0) {
                                v.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
                            } else {
                                mVar.jyd.setImageBitmap(decodeFile);
                            }
                        } catch (Throwable e) {
                            v.e("AdLandingPageCircleImgComp", "%s" + be.e(e));
                        }
                    }
                });
            }
        }
    }
}
