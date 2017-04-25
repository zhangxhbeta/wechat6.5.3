package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class r extends l {
    public r(Context context, g gVar, ViewGroup viewGroup) {
        super(context, gVar, viewGroup);
    }

    protected final void d(Button button) {
        final g aTY = aTY();
        if (com.tencent.mm.pluginsdk.model.app.g.o(this.context, aTY.jvp)) {
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ r jyX;

                public final void onClick(View view) {
                    this.jyX.aTX();
                    f aC = com.tencent.mm.pluginsdk.model.app.g.aC(aTY.jvp, true);
                    if (aC == null || TextUtils.isEmpty(aC.field_packageName) || !this.jyX.Bh(aC.field_packageName)) {
                        this.jyX.aTZ();
                    }
                }
            });
        } else {
            super.d(button);
        }
    }

    public final boolean Bh(String str) {
        if (this.context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            this.context.startActivity(launchIntentForPackage);
            return true;
        } catch (Throwable e) {
            v.e("AdLandingPageOpenAppBtnComp", be.e(e));
            return false;
        }
    }
}
