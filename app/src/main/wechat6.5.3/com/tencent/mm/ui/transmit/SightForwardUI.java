package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.pluginsdk.n.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.ChattingUI;

public class SightForwardUI extends MMActivity {
    private String aEZ;
    private MainSightForwardContainerView oYc;

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        cU().cV().hide();
        this.aEZ = getIntent().getStringExtra("sight_local_path");
        if (!d.zC(this.aEZ)) {
            v.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", this.aEZ);
            finish();
        } else if (ak.uz()) {
            String lb = o.lb(String.valueOf(SystemClock.elapsedRealtime()));
            k.KV();
            lb = o.lc(lb);
            if (e.p(this.aEZ, lb) <= 0) {
                v.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", this.aEZ, lb);
                finish();
                return;
            }
            this.aEZ = lb;
            v.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", this.aEZ);
            this.oYc = (MainSightForwardContainerView) findViewById(2131757998);
            this.oYc.iYi = new b(this) {
                final /* synthetic */ SightForwardUI oYd;

                {
                    this.oYd = r1;
                }

                public final void zF(String str) {
                    Intent intent = new Intent(this.oYd.nDR.nEl, ChattingUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("Chat_User", str);
                    this.oYd.startActivity(intent);
                    this.oYd.finish();
                }

                public final void fJ(boolean z) {
                    Intent intent = new Intent();
                    intent.setClass(this.oYd.nDR.nEl, LauncherUI.class).addFlags(67108864);
                    this.oYd.startActivity(intent);
                    this.oYd.finish();
                }
            };
            MainSightForwardContainerView mainSightForwardContainerView = this.oYc;
            lb = this.aEZ;
            mainSightForwardContainerView.iYA = this;
            mainSightForwardContainerView.iYP = lb;
            mainSightForwardContainerView.iYw = g.aX(lb);
            long currentTimeMillis = System.currentTimeMillis();
            mainSightForwardContainerView.iYQ = 1.3333334f;
            mainSightForwardContainerView.iYg = (SightCameraView) ((ViewStub) mainSightForwardContainerView.findViewById(2131757999)).inflate();
            mainSightForwardContainerView.iYg.pL(a.lFo);
            mainSightForwardContainerView.iYg.Y(mainSightForwardContainerView.iYQ);
            mainSightForwardContainerView.iYg.setVisibility(0);
            mainSightForwardContainerView.iYl = mainSightForwardContainerView.findViewById(2131758004);
            mainSightForwardContainerView.iYl.setLayoutParams(new LayoutParams(-1, cU().cV().getHeight()));
            mainSightForwardContainerView.iYj = mainSightForwardContainerView.findViewById(2131758005);
            mainSightForwardContainerView.hgp = mainSightForwardContainerView.findViewById(2131758006);
            mainSightForwardContainerView.iYo = mainSightForwardContainerView.findViewById(2131758000);
            mainSightForwardContainerView.iYj.setOnClickListener(new OnClickListener(mainSightForwardContainerView) {
                final /* synthetic */ MainSightForwardContainerView iYR;

                {
                    this.iYR = r1;
                }

                public final void onClick(View view) {
                    this.iYR.fO(true);
                }
            });
            mainSightForwardContainerView.hgp.setOnClickListener(new OnClickListener(mainSightForwardContainerView) {
                final /* synthetic */ MainSightForwardContainerView iYR;

                {
                    this.iYR = r1;
                }

                public final void onClick(View view) {
                    this.iYR.aQj();
                }
            });
            mainSightForwardContainerView.aQg();
            v.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.oYc.aQf();
            mainSightForwardContainerView = this.oYc;
            if (mainSightForwardContainerView.iYe == null) {
                DisplayMetrics displayMetrics = mainSightForwardContainerView.getResources().getDisplayMetrics();
                float f = ((float) displayMetrics.widthPixels) / mainSightForwardContainerView.iYQ;
                mainSightForwardContainerView.iYe = (MainSightSelectContactView) mainSightForwardContainerView.findViewById(2131758003);
                MainSightSelectContactView mainSightSelectContactView = mainSightForwardContainerView.iYe;
                MMFragmentActivity mMFragmentActivity = mainSightForwardContainerView.iYA;
                int i = (int) (((float) displayMetrics.heightPixels) - f);
                int i2 = displayMetrics.heightPixels;
                mainSightSelectContactView.a(mMFragmentActivity, i, mainSightForwardContainerView, mainSightForwardContainerView);
                mainSightForwardContainerView.iYe.bZ(mainSightForwardContainerView.findViewById(2131756534));
                mainSightForwardContainerView.iYe.iZn = mainSightForwardContainerView.findViewById(2131758001);
                mainSightForwardContainerView.iYe.iZo = mainSightForwardContainerView;
            }
            mainSightForwardContainerView.fL(true);
            mainSightForwardContainerView.iYg.postDelayed(new Runnable(mainSightForwardContainerView) {
                final /* synthetic */ MainSightForwardContainerView iYR;

                {
                    this.iYR = r1;
                }

                public final void run() {
                    this.iYR.iYe.show();
                }
            }, 50);
        } else {
            v.e("MicroMsg.SightForwardUI", "acc not ready");
            finish();
        }
    }

    protected final int getLayoutId() {
        return 2130903918;
    }

    protected void onResume() {
        super.onResume();
        this.oYc.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.oYc.onPause();
    }
}
