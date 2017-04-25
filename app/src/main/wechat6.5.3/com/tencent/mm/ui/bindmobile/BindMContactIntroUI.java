package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.mm.v.e;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public class BindMContactIntroUI extends MMWizardActivity implements e {
    private String bhT;
    private p dwg = null;
    private boolean edL = false;
    private String iMo = null;
    private String iMp = null;
    private ImageView nMR;
    private i nNi;
    private boolean nNx = false;
    private int ofA = 0;
    private TextView ofu;
    private TextView ofv;
    private Button ofw;
    private Button ofx;
    private a ofy;
    private boolean ofz = false;

    static /* synthetic */ void a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z = true;
        switch (bindMContactIntroUI.ofy) {
            case NO_INIT:
                bindMContactIntroUI.jC(false);
                return;
            case SET_MOBILE:
                final String str = bindMContactIntroUI.bhT;
                if (bindMContactIntroUI.nNi == null) {
                    bindMContactIntroUI.nNi = new i(b.oPf, bindMContactIntroUI, new i.a(bindMContactIntroUI) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        public final void vV(int i) {
                            Intent intent;
                            if (i == 1) {
                                if (this.ofB.nNx) {
                                    if (!k.xN()) {
                                        com.tencent.mm.sdk.c.b puVar = new pu();
                                        puVar.brb.brc = true;
                                        puVar.brb.brd = true;
                                        com.tencent.mm.sdk.c.a.nhr.z(puVar);
                                    }
                                    this.ofB.bAv();
                                    intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.plugin.a.a.drp.d(this.ofB, intent);
                                    return;
                                }
                                MMWizardActivity.w(this.ofB, new Intent(this.ofB, BindMContactStatusUI.class).putExtra("is_bind_for_contact_sync", this.ofB.ofz));
                                if (!this.ofB.edL) {
                                    return;
                                }
                                if (this.ofB.ofz) {
                                    g.iuh.h(11002, Integer.valueOf(3), Integer.valueOf(3));
                                    return;
                                }
                                g.iuh.h(11002, Integer.valueOf(1), Integer.valueOf(2));
                            } else if (i == 2) {
                                intent = new Intent(this.ofB, BindMContactVerifyUI.class);
                                intent.putExtra("bindmcontact_mobile", str);
                                intent.putExtra("is_bind_for_safe_device", this.ofB.nNx);
                                intent.putExtra("is_bind_for_contact_sync", this.ofB.ofz);
                                intent.putExtra("KEnterFromBanner", this.ofB.edL);
                                MMWizardActivity.w(this.ofB, intent);
                            }
                        }
                    });
                    bindMContactIntroUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactIntroUI.nNi);
                }
                i iVar = bindMContactIntroUI.nNi;
                if (bindMContactIntroUI.nNx || bindMContactIntroUI.ofz) {
                    z = false;
                }
                iVar.oPb = z;
                bindMContactIntroUI.nNi.Pv(str);
                return;
            case SUCC_UNLOAD:
                ak.yW();
                c.vf().set(12322, Boolean.valueOf(false));
                l.a(bindMContactIntroUI, new Runnable(bindMContactIntroUI) {
                    final /* synthetic */ BindMContactIntroUI ofB;

                    {
                        this.ofB = r1;
                    }

                    public final void run() {
                        if (m.EW()) {
                            BindMContactIntroUI.bDm();
                            this.ofB.ofw.setText(this.ofB.getString(2131231410));
                            this.ofB.ofy = a.SUCC;
                            ak.yW();
                            boolean a = be.a((Boolean) c.vf().get(12322, Boolean.valueOf(false)), false);
                            if (this.ofB.edL && a) {
                                g.iuh.h(11002, Integer.valueOf(3), Integer.valueOf(3));
                            }
                        }
                    }
                }, true, bindMContactIntroUI.ofA);
                return;
            case SUCC:
                bindMContactIntroUI.startActivity(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void b(BindMContactIntroUI bindMContactIntroUI) {
        switch (bindMContactIntroUI.ofy) {
            case SET_MOBILE:
                m.EZ();
                bindMContactIntroUI.NI();
                return;
            case SUCC_UNLOAD:
                bindMContactIntroUI.jC(true);
                return;
            case SUCC:
                bindMContactIntroUI.jC(true);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void bDm() {
        int xJ = k.xJ();
        m.EV();
        xJ &= -131073;
        ak.yW();
        c.vf().set(7, Integer.valueOf(xJ));
        com.tencent.mm.plugin.a.a.drq.ow();
    }

    protected final int getLayoutId() {
        return 2130903172;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(132, (e) this);
        ak.vy().a((int) WebView.NORMAL_MODE_ALPHA, (e) this);
        ak.vy().a(254, (e) this);
        vD(2131231429);
    }

    public void onDestroy() {
        ak.vy().b(132, (e) this);
        ak.vy().b((int) WebView.NORMAL_MODE_ALPHA, (e) this);
        ak.vy().b(254, (e) this);
        if (this.nNi != null) {
            getContentResolver().unregisterContentObserver(this.nNi);
            this.nNi.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        NI();
    }

    protected final void NI() {
        this.nNx = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.ofz = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.edL = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.ofA = getIntent().getIntExtra("key_upload_scene", 0);
        this.ofy = m.EY();
        v.d("MicroMsg.BindMContactIntroUI", "state " + this.ofy);
        ak.yW();
        this.bhT = (String) c.vf().get(6, null);
        if (this.bhT == null || this.bhT.equals(SQLiteDatabase.KeyEmpty)) {
            ak.yW();
            this.bhT = (String) c.vf().get(4097, null);
        }
        this.nMR = (ImageView) findViewById(2131755613);
        this.ofu = (TextView) findViewById(2131755614);
        this.ofv = (TextView) findViewById(2131755615);
        this.ofw = (Button) findViewById(2131755616);
        this.ofx = (Button) findViewById(2131755617);
        this.ofw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactIntroUI ofB;

            {
                this.ofB = r1;
            }

            public final void onClick(View view) {
                BindMContactIntroUI.a(this.ofB);
            }
        });
        this.ofx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactIntroUI ofB;

            {
                this.ofB = r1;
            }

            public final void onClick(View view) {
                BindMContactIntroUI.b(this.ofB);
            }
        });
        if (getIntent().getBooleanExtra("skip", false)) {
            a(0, getString(2131231078), new OnMenuItemClickListener(this) {
                final /* synthetic */ BindMContactIntroUI ofB;

                {
                    this.ofB = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.ofB.aKM();
                    return true;
                }
            });
        } else {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BindMContactIntroUI ofB;

                {
                    this.ofB = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.ofB.aKM();
                    return true;
                }
            });
        }
        if (this.ofy == a.SUCC_UNLOAD || this.ofy == a.SUCC) {
            String value = j.sU().getValue("ShowUnbindPhone");
            int i = 2;
            if (!be.kS(value)) {
                i = be.KL(value);
            }
            if (i != 0) {
                a(1, 2130838681, new OnMenuItemClickListener(this) {
                    final /* synthetic */ BindMContactIntroUI ofB;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.ofB.nDR.nEl);
                        lVar.jXn = new n.c(this) {
                            final /* synthetic */ AnonymousClass23 ofF;

                            {
                                this.ofF = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                lVar.setHeaderTitle(2131231417);
                                if ((i & 2) != 0) {
                                    lVar.dg(0, 2131231435);
                                }
                                if ((i & 1) != 0) {
                                    lVar.dg(1, 2131231396);
                                }
                            }
                        };
                        lVar.jXo = new d(this) {
                            final /* synthetic */ AnonymousClass23 ofF;

                            {
                                this.ofF = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        com.tencent.mm.ui.base.g.b(this.ofF.ofB.nDR.nEl, this.ofF.ofB.getString(2131231432), this.ofF.ofB.getString(2131231433), this.ofF.ofB.getString(2131231010), this.ofF.ofB.getString(2131231431), null, new DialogInterface.OnClickListener(this.ofF.ofB) {
                                            final /* synthetic */ BindMContactIntroUI ofB;

                                            {
                                                this.ofB = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                if (this.ofB.bhT != null && !this.ofB.bhT.equals(SQLiteDatabase.KeyEmpty)) {
                                                    ak.vy().a(new h(h.cYt), 0);
                                                    BindMContactIntroUI bindMContactIntroUI = this.ofB;
                                                    Context context = this.ofB;
                                                    this.ofB.getString(2131231164);
                                                    bindMContactIntroUI.dwg = com.tencent.mm.ui.base.g.a(context, this.ofB.getString(2131235044), true, new OnCancelListener(this) {
                                                        final /* synthetic */ AnonymousClass24 ofG;

                                                        {
                                                            this.ofG = r1;
                                                        }

                                                        public final void onCancel(DialogInterface dialogInterface) {
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                        return;
                                    case 1:
                                        Intent intent = new Intent();
                                        intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                                        com.tencent.mm.ay.c.b(this.ofF.ofB, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        lVar.aXZ();
                        return false;
                    }
                });
            }
        }
        switch (this.ofy) {
            case NO_INIT:
                V(1, false);
                this.nMR.setImageResource(2131165696);
                this.ofv.setVisibility(0);
                this.ofx.setVisibility(8);
                this.ofu.setText(2131231412);
                this.ofv.setText(2131231411);
                this.ofw.setText(2131231387);
                return;
            case SET_MOBILE:
                V(1, false);
                this.nMR.setImageResource(2131165696);
                this.ofv.setVisibility(0);
                this.ofx.setVisibility(0);
                this.ofu.setText(String.format(getString(2131231448), new Object[]{this.bhT}));
                this.ofv.setText(2131231438);
                this.ofw.setText(2131231442);
                this.ofx.setText(2131231397);
                return;
            case SUCC_UNLOAD:
                V(1, true);
                this.nMR.setImageResource(2131165695);
                this.ofv.setVisibility(0);
                this.ofx.setVisibility(0);
                this.ofu.setText(String.format(getString(2131231448), new Object[]{this.bhT}));
                this.ofv.setText(2131231393);
                this.ofw.setText(2131231439);
                this.ofx.setText(2131231395);
                return;
            case SUCC:
                V(1, true);
                this.nMR.setImageResource(2131165695);
                this.ofv.setVisibility(0);
                this.ofx.setVisibility(0);
                this.ofu.setText(String.format(getString(2131231448), new Object[]{this.bhT}));
                this.ofv.setText(2131231393);
                this.ofw.setText(2131231410);
                this.ofx.setText(2131231395);
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    private void aKM() {
        axg();
        if (this.ofz) {
            cancel();
            finish();
            return;
        }
        bAv();
    }

    private void jC(boolean z) {
        Intent intent = new Intent(this, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", this.nNx);
        intent.putExtra("is_bind_for_contact_sync", this.ofz);
        intent.putExtra("is_bind_for_change_mobile", z);
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!be.kS(simCountryIso)) {
            com.tencent.mm.af.b.a g = com.tencent.mm.af.b.g(this, simCountryIso, getString(2131232236));
            if (g != null) {
                intent.putExtra("country_name", g.cQn);
                intent.putExtra("couttry_code", g.cQm);
            }
        }
        MMWizardActivity.w(this, intent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 132 && i == 0 && i2 == 0) {
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            if (((com.tencent.mm.modelfriend.v) kVar).AG() == 3) {
                com.tencent.mm.modelsimple.d.aY(this);
                if (be.kS(this.iMp)) {
                    MMWizardActivity.w(this, new Intent(this, BindMContactStatusUI.class));
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, this.iMp, SQLiteDatabase.KeyEmpty, getString(2131230747), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MMWizardActivity.w(this.ofB, new Intent(this.ofB, BindMContactStatusUI.class));
                        }
                    });
                    return;
                }
            }
            return;
        }
        Object obj;
        if (!com.tencent.mm.plugin.a.a.drq.a((Context) this, i, i2, str)) {
            obj = null;
            switch (i2) {
                case -214:
                    com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null) {
                        dm.a(this, null, null);
                    }
                    obj = 1;
                    break;
                case -43:
                    Toast.makeText(this, 2131231399, 0).show();
                    obj = 1;
                    break;
                case -41:
                    Toast.makeText(this, 2131231401, 0).show();
                    obj = 1;
                    break;
                case -36:
                    Toast.makeText(this, 2131231404, 0).show();
                    obj = 1;
                    break;
                case -35:
                    Toast.makeText(this, 2131231400, 0).show();
                    obj = 1;
                    break;
                case -34:
                    Toast.makeText(this, 2131231402, 0).show();
                    obj = 1;
                    break;
                default:
                    break;
            }
        }
        obj = 1;
        if (obj == null) {
            final com.tencent.mm.v.k vVar;
            Context context;
            if (kVar.getType() == 254) {
                if (this.dwg != null) {
                    this.dwg.dismiss();
                    this.dwg = null;
                }
                if (i == 0 && i2 == 0) {
                    this.iMp = ((h) kVar).IS().mnd;
                    this.iMo = ((h) kVar).IR();
                    if (be.kS(this.iMp)) {
                        ak.vy().a(new t(2), 0);
                        return;
                    }
                    vVar = new com.tencent.mm.modelfriend.v(this.bhT, 3, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty);
                    ak.vy().a(vVar, 0);
                    context = this.nDR.nEl;
                    getString(2131231164);
                    this.dwg = com.tencent.mm.ui.base.g.a(context, getString(2131231437), true, new OnCancelListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(vVar);
                        }
                    });
                    return;
                } else if (i2 == -3) {
                    v.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131235189), null, getString(2131235190), getString(2131235188), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.ofB.getString(2131235187));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.ay.c.b(this.ofB, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -81) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234950, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -82) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234951, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234948, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234949, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234946, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -86) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234952, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
            if (kVar.getType() == WebView.NORMAL_MODE_ALPHA) {
                if (this.dwg != null) {
                    this.dwg.dismiss();
                    this.dwg = null;
                }
                if (i2 == 0) {
                    vVar = new com.tencent.mm.modelfriend.v(this.bhT, 3, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty);
                    ak.vy().a(vVar, 0);
                    context = this.nDR.nEl;
                    getString(2131231164);
                    this.dwg = com.tencent.mm.ui.base.g.a(context, getString(2131231437), true, new OnCancelListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(vVar);
                        }
                    });
                } else {
                    v.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131235189), null, getString(2131235190), getString(2131235188), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.ofB.getString(2131235187));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.ay.c.b(this.ofB, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
            if (kVar.getType() == 132) {
                if (this.dwg != null) {
                    this.dwg.dismiss();
                    this.dwg = null;
                }
                if (((com.tencent.mm.modelfriend.v) kVar).AG() != 3) {
                    return;
                }
                if (i2 == -82) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234951, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234948, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234949, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    com.tencent.mm.ui.base.g.a((Context) this, 2131234946, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    Toast.makeText(this, getString(2131231434, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    v.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.bhT);
                    ak.vy().a(new h(h.cYt), 0);
                    getString(2131231164);
                    this.dwg = com.tencent.mm.ui.base.g.a((Context) this, getString(2131235044), true, new OnCancelListener(this) {
                        final /* synthetic */ BindMContactIntroUI ofB;

                        {
                            this.ofB = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.BindMContactIntroUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            if (iArr == null) {
                i2 = -1;
            } else {
                i2 = iArr.length;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.nNi != null) {
                    this.nNi.bBm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
