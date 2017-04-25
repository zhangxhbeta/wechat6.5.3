package com.tencent.mm.plugin.soter_mp.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.soter.c.i;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.plugin.soter_mp.b.a;
import com.tencent.mm.plugin.soter_mp.b.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.v.e;
import java.lang.ref.WeakReference;
import java.security.Signature;

public final class b extends c implements e {
    TextView hfW = null;
    boolean kdS = false;
    private CancellationSignal kdT = null;
    private h kdU = null;
    ImageView kdV = null;
    private final int kdW = 3;
    int kdX = 0;
    private final long kdY = 500;
    Animation kdZ = null;
    Animation kea = null;
    Runnable keb = new Runnable(this) {
        final /* synthetic */ b kec;

        {
            this.kec = r1;
        }

        public final void run() {
            this.kec.hfW.setTextColor(this.kec.hfW.getResources().getColor(2131689788));
            this.kec.hfW.setText(this.kec.hfW.getResources().getString(2131236712));
            this.kec.kdV.setImageResource(2131165565);
        }
    };

    class AnonymousClass6 implements AnimationListener {
        final /* synthetic */ b kec;
        final /* synthetic */ CharSequence lh;

        AnonymousClass6(b bVar, CharSequence charSequence) {
            this.kec = bVar;
            this.lh = charSequence;
        }

        public final void onAnimationStart(Animation animation) {
            this.kec.kdV.setImageResource(2131165566);
            this.kec.hfW.setText(this.lh);
            this.kec.hfW.setTextColor(this.kec.hfW.getResources().getColor(2131690115));
            this.kec.hfW.removeCallbacks(this.kec.keb);
        }

        public final void onAnimationEnd(Animation animation) {
            this.kec.hfW.post(this.kec.keb);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public b(WeakReference<Activity> weakReference, com.tencent.mm.plugin.soter_mp.b.b bVar, c cVar) {
        super(weakReference, bVar, cVar);
    }

    @TargetApi(23)
    public final void cW() {
        if (!k.cC(aa.getContext())) {
            this.kef.errCode = 90011;
            this.kef.biS = "no fingerprint enrolled";
            aYY();
        }
        ak.vy().a(1185, this);
        try {
            if (aa.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                String[] strArr = new String[]{"android.permission.USE_FINGERPRINT"};
                if (SoterAuthenticationUI.kem != null) {
                    Message obtainMessage = SoterAuthenticationUI.kem.obtainMessage(3);
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("permissions", strArr);
                    bundle.putInt("request_code", 0);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    return;
                }
                v.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
                return;
            }
            this.kdS = true;
        } catch (NoSuchMethodError e) {
            v.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.kdS = true;
        }
    }

    private boolean aYT() {
        if (k.Cl(d.aYZ()) && k.Cm(d.aYZ())) {
            return true;
        }
        if (SoterAuthenticationUI.kem != null) {
            SoterAuthenticationUI.kem.obtainMessage(4).sendToTarget();
        } else {
            v.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
        v.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        f.a(aa.getContext(), d.aYZ(), new com.tencent.mm.pluginsdk.l.d(this) {
            final /* synthetic */ b kec;

            {
                this.kec = r1;
            }

            public final void h(int i, String str, String str2) {
                v.i("MicroMsg.SoterControllerFingerprint", "hy: on authkey result errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                c.aYV();
                if (i == 0) {
                    com.tencent.mm.plugin.soter.c.h Cn = k.Cn(d.aYZ());
                    if (Cn == null) {
                        v.e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
                        this.kec.kef.errCode = 90007;
                        this.kec.kef.biS = "auth key can not be retrieved";
                        this.kec.aYY();
                        return;
                    }
                    ak.vy().a(new a(Cn), 0);
                    return;
                }
                k.ar(d.aYZ(), true);
                this.kec.kef.errCode = 90007;
                this.kec.kef.biS = "auth key generate failed";
                this.kec.aYY();
            }
        }, true);
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 0) {
            return;
        }
        if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
            v.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
            this.kef.errCode = 90002;
            this.kef.biS = "user not grant to use fingerprint";
            aYY();
            return;
        }
        v.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        aYT();
        this.kdS = true;
        if (aYT()) {
            aYU();
        }
    }

    @TargetApi(16)
    private void aYU() {
        if (this.keg == null || this.keg.get() == null) {
            v.e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
            this.kef.errCode = 90007;
            this.kef.biS = "internal error occurred: ui released";
            aYY();
        } else {
            if (this.kdU == null) {
                Activity activity = (Activity) this.keg.get();
                h.a aVar = new h.a(activity);
                View inflate = activity.getLayoutInflater().inflate(2130903646, null, false);
                this.kdV = (ImageView) inflate.findViewById(2131757046);
                this.hfW = (TextView) inflate.findViewById(2131757047);
                ((TextView) inflate.findViewById(2131757045)).setText(this.kee.content);
                aVar.cC(inflate);
                aVar.jk(true);
                aVar.wq(2131231010).b(new OnClickListener(this) {
                    final /* synthetic */ b kec;

                    {
                        this.kec = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
                        this.kec.aYX();
                    }
                });
                aVar.c(new OnCancelListener(this) {
                    final /* synthetic */ b kec;

                    {
                        this.kec = r1;
                    }

                    @TargetApi(16)
                    public final void onCancel(DialogInterface dialogInterface) {
                        v.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
                        this.kec.aYX();
                    }
                });
                this.kdU = aVar.RX();
                c.a(this.kdU);
            }
            if (!this.kdU.isShowing()) {
                this.kdU.show();
            }
        }
        if (this.kdT == null || this.kdT.isCanceled()) {
            this.kdT = new CancellationSignal();
        }
        f.a(aa.getContext(), this.kee.fUl, d.aYZ(), new com.tencent.mm.pluginsdk.l.d(this) {
            final /* synthetic */ b kec;

            {
                this.kec = r1;
            }

            public final void h(int i, String str, String str2) {
                v.i("MicroMsg.SoterControllerFingerprint", "hy: request fingerprint onProcessEnd errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                if (i != 0) {
                    if (i == 15) {
                        v.i("MicroMsg.SoterControllerFingerprint", "hy: request fingerprint error, maybe key invalid. remove former key and give suggestion");
                        k.ar(d.aYZ(), true);
                    }
                    this.kec.kef.errCode = 90007;
                    this.kec.kef.biS = "start fingerprint authen failed";
                    this.kec.kdS = false;
                    this.kec.aYY();
                    return;
                }
                this.kec.kdS = true;
            }
        }, new com.tencent.mm.pluginsdk.l.b(this) {
            final /* synthetic */ b kec;

            {
                this.kec = r1;
            }

            public final void s(int i, String str) {
                v.e("MicroMsg.SoterControllerFingerprint", "hy: on authen error errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), str});
                this.kec.kdS = false;
                if (i == 10308) {
                    this.kec.kef.errCode = 90010;
                    this.kec.kef.biS = "authenticate freeze. please try again later";
                } else {
                    this.kec.kef.errCode = 90007;
                    this.kec.kef.biS = "authenticate error: " + str;
                }
                this.kec.aYY();
            }

            public final void t(int i, String str) {
                v.i("MicroMsg.SoterControllerFingerprint", "hy: on authen help errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), str});
            }

            public final void a(String str, final Signature signature) {
                v.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
                b bVar = this.kec;
                bVar.hfW.removeCallbacks(bVar.keb);
                bVar.kdV.setImageResource(2131165567);
                bVar.hfW.setTextColor(bVar.hfW.getResources().getColor(2131690053));
                bVar.hfW.setText(bVar.hfW.getResources().getString(2131236713));
                ad.g(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 ked;

                    public final void run() {
                        try {
                            this.ked.kec.kdS = false;
                            i aE = k.aE(signature.sign());
                            this.ked.kec.kef.errCode = 0;
                            this.ked.kec.kef.biS = "OK";
                            this.ked.kec.kef.kei = (byte) 1;
                            this.ked.kec.kef.bnI = aE.kdn;
                            this.ked.kec.kef.kej = aE.kdo;
                            this.ked.kec.aYW();
                        } catch (Throwable e) {
                            v.a("MicroMsg.SoterControllerFingerprint", e, "hy: mp sign error", new Object[0]);
                        }
                    }
                }, 500);
            }

            public final void kq(String str) {
                v.w("MicroMsg.SoterControllerFingerprint", "hy: user trying failed");
                b bVar = this.kec;
                int i = bVar.kdX;
                bVar.kdX = i + 1;
                if (i >= 3) {
                    v.i("MicroMsg.SoterControllerFingerprint", "hy: exceed session trial. inform fail.");
                    this.kec.kef.errCode = 90009;
                    this.kec.kef.biS = "trial time exceed 3 times per session";
                    this.kec.aYY();
                    return;
                }
                bVar = this.kec;
                CharSequence string = aa.getContext().getString(2131235585);
                if (bVar.kdZ == null) {
                    bVar.kdZ = com.tencent.mm.ui.c.a.eq(bVar.kdV.getContext());
                }
                if (bVar.kea == null) {
                    bVar.kea = com.tencent.mm.ui.c.a.eq(bVar.kdV.getContext());
                }
                bVar.kdZ.setAnimationListener(new AnonymousClass6(bVar, string));
                bVar.hfW.startAnimation(bVar.kdZ);
                bVar.kdV.startAnimation(bVar.kea);
                ad.g(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 ked;

                    {
                        this.ked = r1;
                    }

                    public final void run() {
                        this.ked.kec.kdS = false;
                        this.ked.kec.aYU();
                    }
                }, 500);
            }
        }, this.kdT);
    }

    public final void onResume() {
        if (aYT() && this.kdS) {
            aYU();
        }
    }

    @TargetApi(16)
    public final void onPause() {
        if (this.kdS && this.kdT != null) {
            this.kdT.cancel();
        }
    }

    public final void onDestroy() {
        ak.vy().b(1185, this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof a) {
            v.i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errtype: %d, errcode: %d, errmsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                aYU();
                return;
            }
            v.i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key and ask");
            k.ar(d.aYZ(), true);
            this.kef.errCode = 90007;
            this.kef.biS = "auth key update error";
            aYY();
        }
    }
}
