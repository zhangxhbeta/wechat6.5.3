package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ak.j;
import com.tencent.mm.e.a.or;
import com.tencent.mm.h.i;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;

@a(3)
public class WebWXLogoutUI extends MMActivity implements af, e {
    private ProgressDialog iKE = null;
    private c jmu = new c<or>(this) {
        final /* synthetic */ WebWXLogoutUI ltj;

        {
            this.ltj = r2;
            this.nhz = or.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            or orVar = (or) bVar;
            v.d("MicroMsg.WebWXLogoutUI", "status Notify function");
            if (orVar.bpY.bdf == 8) {
                this.ltj.finish();
            }
            return false;
        }
    };
    private boolean lsT = false;
    private boolean lsZ;
    private boolean lta;
    private ImageButton ltb;
    private ImageButton ltc;
    private ImageView ltd;
    private int lte;
    private int ltf;
    private int ltg;
    private Animator lth;
    private int lti;

    static /* synthetic */ boolean b(WebWXLogoutUI webWXLogoutUI) {
        if (!ak.uz()) {
            return false;
        }
        int xL = k.xL();
        xL = webWXLogoutUI.lsZ ? xL | 8192 : xL & -8193;
        i.eb(xL);
        ak.yW();
        com.tencent.mm.model.c.vf().set(40, Integer.valueOf(xL));
        webWXLogoutUI.lsT = true;
        webWXLogoutUI.blU();
        return true;
    }

    static /* synthetic */ void e(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.lta) {
            ak.vy().a(new com.tencent.mm.plugin.webwx.a.a(2), 0);
            v.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            return;
        }
        ak.vy().a(new com.tencent.mm.plugin.webwx.a.a(1), 0);
        v.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
    }

    static /* synthetic */ boolean f(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.lti == p.Jd()) {
            g.b(webWXLogoutUI.nDR.nEl, p.cYF, webWXLogoutUI.getString(2131231164), webWXLogoutUI.getString(2131236637), webWXLogoutUI.getString(2131231010), new OnClickListener(webWXLogoutUI) {
                final /* synthetic */ WebWXLogoutUI ltj;

                {
                    this.ltj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    final ah ahVar = new ah(1);
                    ak.vy().a(ahVar, 0);
                    WebWXLogoutUI webWXLogoutUI = this.ltj;
                    ActionBarActivity actionBarActivity = this.ltj.nDR.nEl;
                    this.ltj.getString(2131231164);
                    webWXLogoutUI.iKE = g.a(actionBarActivity, null, true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass8 ltl;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(ahVar);
                            if (this.ltl.ltj.iKE != null) {
                                this.ltl.ltj.iKE.cancel();
                            }
                        }
                    });
                }
            }, null);
        } else {
            webWXLogoutUI.finish();
        }
        return true;
    }

    static /* synthetic */ int g(WebWXLogoutUI webWXLogoutUI) {
        int[] iArr = new int[2];
        View findViewById = webWXLogoutUI.findViewById(2131760083);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        v.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height)});
        return (((int) (((double) point.y) / 4.0d)) - i) - height;
    }

    protected final int getLayoutId() {
        return 2130904712;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968589, 2130968644);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cU().cV().hide();
        if (getIntent() != null) {
            this.lti = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        NI();
        overridePendingTransition(2130968646, 2130968589);
        ak.vy().a(281, this);
        ak.vy().a(792, this);
        ak.yW();
        com.tencent.mm.model.c.a(this);
        com.tencent.mm.sdk.c.a.nhr.e(this.jmu);
    }

    protected void onPause() {
        super.onPause();
        if (this.lsT && ak.uz()) {
            rc rcVar = new rc();
            rcVar.muR = 27;
            rcVar.muS = k.eF(k.xL()) ? 1 : 2;
            ak.yW();
            com.tencent.mm.model.c.wG().b(new j.a(23, rcVar));
            this.lsT = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(2130968589, 2130968644);
        ak.vy().b(281, this);
        ak.vy().b(792, this);
        ak.yW();
        com.tencent.mm.model.c.b(this);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmu);
    }

    protected final void NI() {
        Fd("");
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(2131690051));
        }
        if (i.st()) {
            this.ltc = (ImageButton) findViewById(2131760088);
            if (k.eF(k.xL())) {
                this.lsZ = true;
            } else {
                this.lsZ = false;
            }
            hL(this.lsZ);
            this.ltc.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI ltj;

                {
                    this.ltj = r1;
                }

                public final void onClick(View view) {
                    this.ltj.lsZ = !this.ltj.lsZ;
                    this.ltj.hL(this.ltj.lsZ);
                    WebWXLogoutUI.b(this.ltj);
                }
            });
        } else {
            findViewById(2131760087).setVisibility(8);
            this.lsZ = false;
        }
        this.ltd = (ImageView) findViewById(2131756582);
        v.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + p.Je());
        if (p.Je()) {
            findViewById(2131760090).setVisibility(8);
        } else {
            final Animator loadAnimator = AnimatorInflater.loadAnimator(this, 2131034112);
            loadAnimator.setTarget(findViewById(2131760092));
            this.lth = AnimatorInflater.loadAnimator(this, 2131034113);
            this.lth.setTarget(findViewById(2131760092));
            this.lth.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ WebWXLogoutUI ltj;

                {
                    this.ltj = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    this.ltj.hK(this.ltj.lta);
                }
            });
            this.lta = p.Jc();
            this.ltb = (ImageButton) findViewById(2131760091);
            hK(this.lta);
            this.ltb.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI ltj;

                public final void onClick(View view) {
                    if (this.ltj.lta) {
                        this.ltj.ltb.setImageResource(2131165418);
                    } else {
                        this.ltj.ltb.setImageResource(2131165416);
                    }
                    WebWXLogoutUI.e(this.ltj);
                    this.ltj.findViewById(2131760092).setVisibility(0);
                    loadAnimator.start();
                }
            });
        }
        ImageButton imageButton = (ImageButton) findViewById(2131760094);
        v.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + p.Jf());
        if (p.Jf()) {
            imageButton.setVisibility(8);
        } else {
            imageButton.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI ltj;

                {
                    this.ltj = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", "filehelper");
                    intent.putExtra("key_show_bottom_app_panel", true);
                    com.tencent.mm.plugin.webwx.a.drp.e(intent, this.ltj);
                    v.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
                    this.ltj.finish();
                }
            });
        }
        Button button = (Button) findViewById(2131760095);
        button.setText(p.cYI);
        button.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WebWXLogoutUI ltj;

            {
                this.ltj = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.WebWXLogoutUI", "logout webwx");
                WebWXLogoutUI.f(this.ltj);
            }
        });
        ((TextView) findViewById(2131760084)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WebWXLogoutUI ltj;

            {
                this.ltj = r1;
            }

            public final void onClick(View view) {
                this.ltj.finish();
            }
        });
        Drawable drawable;
        Drawable drawable2;
        if (p.Ja() == 1) {
            drawable = getResources().getDrawable(2131165425);
            drawable2 = getResources().getDrawable(2131165427);
            if (!(drawable == null || drawable2 == null)) {
                this.lte = drawable.getIntrinsicWidth();
                this.ltf = drawable2.getIntrinsicWidth();
            }
        } else if (p.Ja() == 2) {
            drawable = getResources().getDrawable(2131165420);
            drawable2 = getResources().getDrawable(2131165422);
            if (!(drawable == null || drawable2 == null)) {
                this.lte = drawable.getIntrinsicWidth();
                this.ltf = drawable2.getIntrinsicWidth();
            }
        }
        this.ltd.post(new Runnable(this) {
            final /* synthetic */ WebWXLogoutUI ltj;

            {
                this.ltj = r1;
            }

            public final void run() {
                this.ltj.ltg = WebWXLogoutUI.g(this.ltj);
                this.ltj.blU();
            }
        });
    }

    private void blU() {
        if (!be.kS(p.cYA)) {
            ((TextView) findViewById(2131760085)).setText(p.cYA);
            if (p.Ja() == 1) {
                if (!this.lsZ) {
                    this.ltd.setImageResource(2131165427);
                    this.ltd.setPadding(this.ltf - this.lte, this.ltg, 0, 0);
                    return;
                }
            } else if (p.Ja() == 2) {
                if (this.lsZ) {
                    ((TextView) findViewById(2131760086)).setText(2131236640);
                } else if (!i.st()) {
                    ((TextView) findViewById(2131760086)).setText("");
                }
                if (this.lta) {
                    ((TextView) findViewById(2131760085)).setText(getString(2131236628, new Object[]{"Mac"}));
                    this.ltd.setImageResource(2131165421);
                    this.ltd.setPadding(0, this.ltg, 0, 0);
                    if (i.st() && !this.lsZ) {
                        ((TextView) findViewById(2131760086)).setText(2131236624);
                        this.ltd.setImageResource(2131165423);
                        this.ltd.setPadding(this.ltf - this.lte, this.ltg, 0, 0);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(2131760085)).setText(getString(2131236631, new Object[]{"Mac"}));
                this.ltd.setImageResource(2131165420);
                this.ltd.setPadding(0, this.ltg, 0, 0);
                if (i.st() && !this.lsZ) {
                    ((TextView) findViewById(2131760086)).setText(2131236624);
                    this.ltd.setImageResource(2131165422);
                    this.ltd.setPadding(this.ltf - this.lte, this.ltg, 0, 0);
                    return;
                }
                return;
            } else if (p.Ja() == 3) {
                this.ltd.setImageResource(2131165419);
                this.ltd.setPadding(0, this.ltg, 0, 0);
                return;
            }
            this.ltd.setImageResource(2131165425);
            this.ltd.setPadding(0, this.ltg, 0, 0);
        }
    }

    private void hK(boolean z) {
        if (this.ltb == null) {
            return;
        }
        if (z) {
            this.ltb.setImageResource(2130839552);
            ((TextView) findViewById(2131760093)).setText(2131236641);
            return;
        }
        this.ltb.setImageResource(2130839550);
        ((TextView) findViewById(2131760093)).setText(2131236627);
    }

    private void hL(boolean z) {
        if (this.ltc == null) {
            return;
        }
        if (z) {
            this.ltc.setImageResource(2130839548);
        } else {
            this.ltc.setImageResource(2130839551);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.iKE != null) {
            this.iKE.dismiss();
            this.iKE = null;
        }
        if (kVar.getType() == 281) {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, 2131236638, 1).show();
            }
            finish();
        } else if (kVar.getType() == 792) {
            int i3 = ((com.tencent.mm.plugin.webwx.a.a) kVar).bdf;
            if (this.lth != null) {
                this.lth.start();
            }
            if (i == 0 && i2 == 0) {
                boolean z;
                if (i3 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.lta = z;
                p.bf(this.lta);
                blU();
                String str2 = "MicroMsg.WebWXLogoutUI";
                String str3 = "%s extDevice success";
                Object[] objArr = new Object[1];
                objArr[0] = this.lta ? "lock" : "unlock";
                v.d(str2, str3, objArr);
            } else if (i3 == 1) {
                Toast.makeText(this, 2131236629, 0).show();
            } else {
                Toast.makeText(this, 2131236642, 0).show();
            }
        }
    }

    public final void yM() {
        ak.yW();
        if (!com.tencent.mm.model.c.wC()) {
            finish();
        } else if (p.Jc() && !this.lta) {
            v.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
            this.lta = true;
            hK(this.lta);
            blU();
        }
    }
}
