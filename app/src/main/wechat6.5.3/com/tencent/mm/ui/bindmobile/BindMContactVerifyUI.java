package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ak.j;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.go;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BindMContactVerifyUI extends MMWizardActivity implements e {
    private String bhT;
    private SharedPreferences cnm;
    private p dwg = null;
    private boolean edL = false;
    private EditText nNt;
    private Button nNw;
    private boolean nNx = false;
    private boolean nNz = false;
    private TextView nOf;
    private boolean ofL = false;
    private boolean ofN = false;
    private boolean ofz = false;
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(132, (e) this);
        vD(2131231430);
        this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = k.xJ();
        NI();
    }

    public void onDestroy() {
        ak.vy().b(132, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903174;
    }

    protected final void NI() {
        ak.yW();
        this.bhT = (String) c.vf().get(4097, null);
        this.nNt = (EditText) findViewById(2131755621);
        this.nNx = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.ofz = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.nNz = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.ofN = getIntent().getBooleanExtra("BIND_FIND_ME_BY_MOBILE", false);
        this.ofL = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.edL = getIntent().getBooleanExtra("KEnterFromBanner", false);
        Button button = (Button) findViewById(2131755622);
        if (this.bhT == null || this.bhT.equals(SQLiteDatabase.KeyEmpty)) {
            ak.yW();
            this.bhT = (String) c.vf().get(6, null);
        }
        this.nNt.setFilters(new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ BindMContactVerifyUI ofO;

            {
                this.ofO = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return be.E(charSequence);
            }
        }});
        this.nNw = (Button) findViewById(2131755583);
        this.nOf = (TextView) findViewById(2131755619);
        boolean z = this.ofN;
        if (z) {
            this.status &= -513;
        } else {
            this.status |= 512;
        }
        this.cnm.edit().putBoolean("settings_find_me_by_mobile", z).commit();
        v.d("MicroMsg.BindMContactVerifyUI", "Bind mobile update = " + this.status);
        this.nOf.setText(getString(2131231416, new Object[]{this.bhT}));
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactVerifyUI ofO;

            {
                this.ofO = r1;
            }

            public final void onClick(View view) {
                String trim = this.ofO.nNt.getText().toString().trim();
                if (trim.equals(SQLiteDatabase.KeyEmpty)) {
                    g.f(this.ofO, 2131231452, 2131231164);
                    return;
                }
                this.ofO.axg();
                b gnVar = new gn();
                gnVar.bfZ.context = this.ofO;
                a.nhr.z(gnVar);
                String str = gnVar.bga.bgb;
                gnVar = new go();
                a.nhr.z(gnVar);
                String str2 = gnVar.bgc.bgd;
                int i = 2;
                if (this.ofO.ofL) {
                    i = 19;
                }
                final com.tencent.mm.v.k vVar = new com.tencent.mm.modelfriend.v(this.ofO.bhT, i, trim, SQLiteDatabase.KeyEmpty, str, str2);
                ak.vy().a(vVar, 0);
                BindMContactVerifyUI bindMContactVerifyUI = this.ofO;
                Context context = this.ofO;
                this.ofO.getString(2131231164);
                bindMContactVerifyUI.dwg = g.a(context, this.ofO.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 ofP;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(vVar);
                    }
                });
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMContactVerifyUI ofO;

            {
                this.ofO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ofO.bAv();
                return true;
            }
        });
        this.nNw.setVisibility(com.tencent.mm.af.b.jn(this.bhT) ? 0 : 8);
        this.nNw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactVerifyUI ofO;

            {
                this.ofO = r1;
            }

            public final void onClick(View view) {
                this.ofO.axg();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", this.ofO.bhT);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.a.a.drp.e(this.ofO, intent);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bAv();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.BindMContactVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((com.tencent.mm.modelfriend.v) kVar).AG() == 2 || ((com.tencent.mm.modelfriend.v) kVar).AG() == 19) {
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            boolean z;
            if (i != 0 || i2 != 0) {
                com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this, null, null);
                    return;
                }
                if (!com.tencent.mm.plugin.a.a.drq.a((Context) this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            dm = com.tencent.mm.f.a.dm(str);
                            if (dm != null) {
                                dm.a(this, null, null);
                            }
                            z = true;
                            break;
                        case -43:
                            Toast.makeText(this, 2131231399, 0).show();
                            z = true;
                            break;
                        case -41:
                            Toast.makeText(this, 2131231401, 0).show();
                            z = true;
                            break;
                        case -36:
                            Toast.makeText(this, 2131231404, 0).show();
                            z = true;
                            break;
                        case -35:
                            Toast.makeText(this, 2131231400, 0).show();
                            z = true;
                            break;
                        case -34:
                            Toast.makeText(this, 2131231402, 0).show();
                            z = true;
                            break;
                        case -33:
                            g.a((Context) this, 2131231445, 2131231451, null);
                            z = true;
                            break;
                        case -32:
                            g.a((Context) this, 2131231446, 2131231451, null);
                            z = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                z = true;
                if (!z) {
                    Toast.makeText(this, getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((com.tencent.mm.modelfriend.v) kVar).AG() != 2 && ((com.tencent.mm.modelfriend.v) kVar).AG() != 19) {
            } else {
                if (this.nNx) {
                    if (!k.xN()) {
                        b puVar = new pu();
                        puVar.brb.brc = true;
                        puVar.brb.brd = true;
                        a.nhr.z(puVar);
                    }
                    bAv();
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.a.a.drp.d((Context) this, intent);
                } else if (this.nNz) {
                    bAv();
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else {
                    int i3;
                    z = (this.status & 512) > 0;
                    ak.yW();
                    c.vf().set(7, Integer.valueOf(this.status));
                    com.tencent.mm.ba.a rcVar = new rc();
                    rcVar.muR = 8;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    rcVar.muS = i3;
                    ak.yW();
                    c.wG().b(new j.a(23, rcVar));
                    com.tencent.mm.plugin.a.a.drq.ow();
                    if (!this.ofz) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.Ew();
                    }
                    if (this.ofL) {
                        g.bf(this, getString(2131231392));
                    }
                    if (this.edL) {
                        if (this.ofz) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11002, Integer.valueOf(3), Integer.valueOf(3));
                        } else {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11002, Integer.valueOf(1), Integer.valueOf(2));
                        }
                    }
                    MMWizardActivity.w(this, new Intent(this, BindMContactStatusUI.class));
                }
            }
        }
    }
}
