package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class BindMobileOrQQHeaderView extends LinearLayout {
    private TextView hEO;
    private ImageView hEP;
    private int hEQ;
    private OnClickListener hER;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] hET = new int[a.aDC().length];

        static {
            try {
                hET[a.hEU - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hET[a.hEV - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] aDC() {
            return (int[]) hEW.clone();
        }

        static {
            hEU = 1;
            hEV = 2;
            hEW = new int[]{hEU, hEV};
        }
    }

    public BindMobileOrQQHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hER = new OnClickListener(this) {
            final /* synthetic */ BindMobileOrQQHeaderView hES;

            {
                this.hES = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.hES.getContext(), BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 7);
                MMWizardActivity.w(this.hES.getContext(), intent);
                if (f.Aj().ga(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
                    f.Aj().ga(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).bfz = "1";
                    e.gf(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            }
        };
        bF(context);
    }

    public BindMobileOrQQHeaderView(Context context) {
        super(context);
        this.hER = /* anonymous class already generated */;
        this.hEQ = a.hEU;
        bF(context);
    }

    private void bF(Context context) {
        View inflate = View.inflate(context, 2130904113, this);
        this.hEO = (TextView) inflate.findViewById(2131758405);
        this.hEP = (ImageView) inflate.findViewById(2131758404);
        switch (AnonymousClass2.hET[this.hEQ - 1]) {
            case 1:
                setOnClickListener(this.hER);
                this.hEP.setImageResource(2131165988);
                return;
            case 2:
                setOnClickListener(this.hER);
                this.hEP.setImageResource(2131165989);
                return;
            default:
                return;
        }
    }
}
