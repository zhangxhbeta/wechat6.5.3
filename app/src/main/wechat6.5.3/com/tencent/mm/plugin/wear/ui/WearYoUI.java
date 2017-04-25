package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.qz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI extends Activity {
    private ImageView dtX;
    private TextView euh;
    private Vibrator ewK;
    private boolean lcA;
    private AtomicInteger lcB = new AtomicInteger();
    private Runnable lcC = new Runnable(this) {
        final /* synthetic */ WearYoUI lcF;

        {
            this.lcF = r1;
        }

        public final void run() {
            this.lcF.ewK.vibrate(200);
            this.lcF.dtX.animate().scaleX(1.2f);
            this.lcF.dtX.animate().scaleY(1.2f);
            this.lcF.dtX.animate().setDuration(200);
            this.lcF.dtX.animate().start();
            this.lcF.dtX.animate().setListener(new a(this.lcF, 1));
        }
    };
    private BroadcastReceiver lcD = new BroadcastReceiver(this) {
        final /* synthetic */ WearYoUI lcF;

        {
            this.lcF = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
                this.lcF.finish();
            }
        }
    };
    private c lcE = new c<hr>(this) {
        final /* synthetic */ WearYoUI lcF;

        {
            this.lcF = r2;
            this.nhz = hr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((hr) bVar) instanceof hr) {
                this.lcF.finish();
            }
            return false;
        }
    };
    private ImageView lcv;
    private ImageView lcw;
    private ImageView lcx;
    private ObjectAnimator[][] lcy = ((ObjectAnimator[][]) Array.newInstance(ObjectAnimator.class, new int[]{3, 3}));
    private c lcz = new c<qz>(this) {
        final /* synthetic */ WearYoUI lcF;

        {
            this.lcF = r2;
            this.nhz = qz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qz qzVar = (qz) bVar;
            if (qzVar instanceof qz) {
                switch (qzVar.bsE.aYt) {
                    case 1:
                        if (!this.lcF.username.equals(qzVar.bsE.username)) {
                            qzVar.bsF.bsG = 2;
                            break;
                        }
                        qzVar.bsF.bsG = 1;
                        break;
                    case 2:
                        if (this.lcF.username.equals(qzVar.bsE.username)) {
                            WearYoUI.b(this.lcF);
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };
    private String username;

    private class a implements AnimatorListener {
        private int eWn = 1;
        final /* synthetic */ WearYoUI lcF;

        public a(WearYoUI wearYoUI, int i) {
            this.lcF = wearYoUI;
            this.eWn = i;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.eWn == 2) {
                v.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[]{Integer.valueOf(this.lcF.lcB.get())});
                if (this.lcF.lcB.get() > 0) {
                    this.lcF.lcB.decrementAndGet();
                    ad.g(this.lcF.lcC, 1000);
                    return;
                }
                this.lcF.dtX.animate().setListener(null);
                this.lcF.lcA = false;
            } else if (this.eWn == 1) {
                this.lcF.dtX.animate().scaleX(1.0f);
                this.lcF.dtX.animate().scaleY(1.0f);
                this.lcF.dtX.animate().setDuration(100);
                this.lcF.dtX.animate().start();
                this.lcF.dtX.animate().setListener(new a(this.lcF, 2));
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.lcF.lcA = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    static /* synthetic */ void b(WearYoUI wearYoUI) {
        if (wearYoUI.lcA) {
            wearYoUI.lcB.addAndGet(1);
            v.v("MicroMsg.Wear.WearYoUI", "startAnimation count: %d", new Object[]{Integer.valueOf(wearYoUI.lcB.get())});
            return;
        }
        wearYoUI.lcA = true;
        ad.o(wearYoUI.lcC);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(4718592);
        setContentView(2130904702);
        this.ewK = (Vibrator) getSystemService("vibrator");
        this.username = getIntent().getStringExtra("key_talker");
        this.dtX = (ImageView) findViewById(2131755508);
        this.euh = (TextView) findViewById(2131756539);
        this.lcv = (ImageView) findViewById(2131760060);
        this.lcw = (ImageView) findViewById(2131760061);
        this.lcx = (ImageView) findViewById(2131760062);
        com.tencent.mm.pluginsdk.ui.a.b.o(this.dtX, this.username);
        this.euh.setText(l.er(this.username));
        this.dtX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WearYoUI lcF;

            {
                this.lcF = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.wear.model.a.bhH();
                v.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[]{this.lcF.username});
                Intent intent = new Intent();
                intent.putExtra("Main_User", r0);
                intent.putExtra("From_fail_notify", true);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                com.tencent.mm.ay.c.a(aa.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                this.lcF.finish();
            }
        });
        com.tencent.mm.sdk.c.a.nhr.e(this.lcz);
        com.tencent.mm.sdk.c.a.nhr.e(this.lcE);
        a(0, this.lcv, 0);
        a(1, this.lcw, 1300);
        a(2, this.lcx, 2600);
        this.ewK.vibrate(200);
        registerReceiver(this.lcD, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        overridePendingTransition(2130968609, 2130968610);
    }

    private void a(int i, ImageView imageView, long j) {
        this.lcy[i][0] = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 2.5f});
        this.lcy[i][0].setRepeatCount(-1);
        this.lcy[i][0].setStartDelay(j);
        this.lcy[i][0].setDuration(3900);
        this.lcy[i][0].start();
        this.lcy[i][1] = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 2.5f});
        this.lcy[i][1].setRepeatCount(-1);
        this.lcy[i][1].setStartDelay(j);
        this.lcy[i][1].setDuration(3900);
        this.lcy[i][1].start();
        this.lcy[i][2] = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{1.0f, 0.0f});
        this.lcy[i][2].setRepeatCount(-1);
        this.lcy[i][2].setInterpolator(new AccelerateInterpolator());
        this.lcy[i][2].setStartDelay(j);
        this.lcy[i][2].setDuration(3900);
        this.lcy[i][2].start();
    }

    public void onClickCheck(View view) {
        v.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[]{this.username});
        ak.vy().a(new com.tencent.mm.plugin.wear.model.d.b(this.username), 0);
        finish();
    }

    public void onClickNoCheck(View view) {
        v.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[]{this.username});
        finish();
    }

    protected void onDestroy() {
        for (int i = 0; i < this.lcy.length; i++) {
            for (ObjectAnimator cancel : this.lcy[i]) {
                cancel.cancel();
            }
        }
        unregisterReceiver(this.lcD);
        com.tencent.mm.sdk.c.a.nhr.f(this.lcE);
        com.tencent.mm.sdk.c.a.nhr.f(this.lcz);
        com.tencent.mm.plugin.wear.model.a.bhH().laY.bhW();
        super.onDestroy();
    }
}
