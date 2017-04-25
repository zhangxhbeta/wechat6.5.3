package com.tencent.mm.ui.account.bind;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.af.b;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.go;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI extends MMWizardActivity implements e {
    private String bhT;
    private p dwg = null;
    private Timer kyE;
    private Integer nNA = Integer.valueOf(15);
    private BindWordingContent nNa;
    private int nNb;
    private boolean nNc;
    private boolean nNd;
    private boolean nNq = false;
    private EditText nNt;
    private TextView nNu;
    private TextView nNv;
    private Button nNw;
    private boolean nNx = false;
    private boolean nNy = false;
    private boolean nNz = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(132, this);
        vD(2131231430);
        this.nNa = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.nNb = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.nNc = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.nNd = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.nNq = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        NI();
    }

    public void onDestroy() {
        ak.vy().b(132, this);
        super.onDestroy();
    }

    protected void onStop() {
        bBo();
        super.onStop();
    }

    protected final int getLayoutId() {
        return 2130903174;
    }

    protected final void NI() {
        ak.yW();
        this.bhT = (String) c.vf().get(4097, null);
        this.nNt = (EditText) findViewById(2131755621);
        this.nNu = (TextView) findViewById(2131755620);
        this.nNv = (TextView) findViewById(2131755624);
        this.nNx = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.nNy = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.nNz = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        Button button = (Button) findViewById(2131755622);
        if (this.bhT == null || this.bhT.equals("")) {
            ak.yW();
            this.bhT = (String) c.vf().get(6, null);
        }
        if (this.bhT != null && this.bhT.length() > 0) {
            this.nNu.setVisibility(0);
            this.nNu.setText(this.bhT);
        }
        this.nNt.setFilters(new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ BindMobileVerifyUI nNB;

            {
                this.nNB = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return be.E(charSequence);
            }
        }});
        this.nNw = (Button) findViewById(2131755583);
        button.setVisibility(8);
        this.nNv.setText(getResources().getQuantityString(2131361810, this.nNA.intValue(), new Object[]{this.nNA}));
        if (this.kyE == null) {
            this.kyE = new Timer();
            TimerTask anonymousClass5 = new TimerTask(this) {
                final /* synthetic */ BindMobileVerifyUI nNB;

                {
                    this.nNB = r1;
                }

                public final void run() {
                    if (this.nNB.nNv != null) {
                        this.nNB.nNv.post(new Runnable(this.nNB) {
                            final /* synthetic */ BindMobileVerifyUI nNB;

                            {
                                this.nNB = r1;
                            }

                            public final void run() {
                                this.nNB.nNA;
                                this.nNB.nNA = Integer.valueOf(this.nNB.nNA.intValue() - 1);
                                if (this.nNB.nNA.intValue() > 0) {
                                    this.nNB.nNv.setText(this.nNB.getResources().getQuantityString(2131361810, this.nNB.nNA.intValue(), new Object[]{this.nNB.nNA}));
                                    return;
                                }
                                this.nNB.nNv.setText(this.nNB.getResources().getQuantityString(2131361810, 0, new Object[]{Integer.valueOf(0)}));
                                this.nNB.bBo();
                            }
                        });
                    }
                }
            };
            if (this.kyE != null) {
                this.kyE.schedule(anonymousClass5, 1000, 1000);
            }
        }
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMobileVerifyUI nNB;

            {
                this.nNB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.nNB.nNt.getText().toString().trim();
                if (trim.equals("")) {
                    g.f(this.nNB, 2131231452, 2131231164);
                } else {
                    this.nNB.axg();
                    gn gnVar = new gn();
                    gnVar.bfZ.context = this.nNB;
                    a.nhr.z(gnVar);
                    String str = gnVar.bga.bgb;
                    go goVar = new go();
                    a.nhr.z(goVar);
                    final v vVar = new v(this.nNB.bhT, 2, trim, "", str, goVar.bgc.bgd);
                    ak.vy().a(vVar, 0);
                    BindMobileVerifyUI bindMobileVerifyUI = this.nNB;
                    BindMobileVerifyUI bindMobileVerifyUI2 = this.nNB;
                    this.nNB.getString(2131231164);
                    bindMobileVerifyUI.dwg = g.a(bindMobileVerifyUI2, this.nNB.getString(2131231440), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass2 nND;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(vVar);
                        }
                    });
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMobileVerifyUI nNB;

            {
                this.nNB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nNB.finish();
                return true;
            }
        });
        this.nNw.setVisibility(b.jn(this.bhT) ? 0 : 8);
        this.nNw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileVerifyUI nNB;

            {
                this.nNB = r1;
            }

            public final void onClick(View view) {
                this.nNB.axg();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", this.nNB.bhT);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.a.a.drp.e(this.nNB, intent);
            }
        });
    }

    private void bBo() {
        if (this.kyE != null) {
            this.kyE.cancel();
            this.kyE = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((v) kVar).AG() == 2) {
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            boolean z2;
            if (i != 0 || i2 != 0) {
                if (!com.tencent.mm.plugin.a.a.drq.a(this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                            if (dm != null) {
                                dm.a(this, null, null);
                            }
                            z2 = true;
                            break;
                        case -43:
                            Toast.makeText(this, 2131231399, 0).show();
                            z2 = true;
                            break;
                        case -41:
                            Toast.makeText(this, 2131231401, 0).show();
                            z2 = true;
                            break;
                        case -36:
                            Toast.makeText(this, 2131231404, 0).show();
                            z2 = true;
                            break;
                        case -35:
                            Toast.makeText(this, 2131231400, 0).show();
                            z2 = true;
                            break;
                        case -34:
                            Toast.makeText(this, 2131231402, 0).show();
                            z2 = true;
                            break;
                        case -33:
                            g.a(this, 2131231445, 2131231451, null);
                            z2 = true;
                            break;
                        case -32:
                            g.a(this, 2131231446, 2131231451, null);
                            z2 = true;
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                }
                z2 = true;
                if (!z2) {
                    Toast.makeText(this, getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((v) kVar).AG() != 2) {
            } else {
                Intent intent;
                if (this.nNx) {
                    if (!com.tencent.mm.model.k.xN()) {
                        pu puVar = new pu();
                        puVar.brb.brc = true;
                        puVar.brb.brd = true;
                        a.nhr.z(puVar);
                    }
                    bAv();
                    intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.a.a.drp.d(this, intent);
                } else if (this.nNz) {
                    bAv();
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else if (this.nNq) {
                    if (this.nNc) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (this.nNd) {
                        z = false;
                    }
                    BindMobileStatusUI.b(this, z2, z);
                    exit(-1);
                } else {
                    if (!this.nNy) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.Ew();
                    }
                    intent = new Intent(this, BindMobileStatusUI.class);
                    intent.putExtra("kstyle_bind_wording", this.nNa);
                    intent.putExtra("kstyle_bind_recommend_show", this.nNb);
                    intent.putExtra("Kfind_friend_by_mobile_flag", this.nNc);
                    intent.putExtra("Krecom_friends_by_mobile_flag", this.nNd);
                    w(this, intent);
                }
            }
        }
    }
}
