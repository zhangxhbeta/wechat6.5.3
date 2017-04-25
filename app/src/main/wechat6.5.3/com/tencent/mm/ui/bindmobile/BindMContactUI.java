package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BindMContactUI extends MMWizardActivity {
    private String bfd = null;
    private String bhT;
    private String cQn = null;
    private boolean edL = false;
    private LinearLayout nIF;
    private TextView nIG;
    private String nII = null;
    private EditText nNg;
    private TextView nNh;
    private i nNi;
    private CheckBox nNm;
    private boolean nNx = false;
    private boolean nNz = false;
    private TextView ofJ;
    private LinearLayout ofK;
    private boolean ofL = false;
    private boolean ofz = false;

    static /* synthetic */ void b(BindMContactUI bindMContactUI, final String str) {
        if (bindMContactUI.nNi == null) {
            int i = b.oPf;
            if (bindMContactUI.ofL) {
                i = b.oPg;
            }
            bindMContactUI.nNi = new i(i, bindMContactUI, new a(bindMContactUI) {
                final /* synthetic */ BindMContactUI ofM;

                public final void vV(int i) {
                    Intent intent;
                    if (i == 1) {
                        if (this.ofM.nNx) {
                            if (!k.xN()) {
                                com.tencent.mm.sdk.c.b puVar = new pu();
                                puVar.brb.brc = true;
                                puVar.brb.brd = true;
                                com.tencent.mm.sdk.c.a.nhr.z(puVar);
                            }
                            this.ofM.bAv();
                            intent = new Intent();
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.a.a.drp.d(this.ofM, intent);
                        } else if (this.ofM.ofL) {
                            g.bf(this.ofM, this.ofM.getString(2131234687));
                            MMWizardActivity.w(this.ofM, new Intent(this.ofM, BindMContactStatusUI.class));
                        } else {
                            if (this.ofM.edL) {
                                if (this.ofM.ofz) {
                                    com.tencent.mm.plugin.report.service.g.iuh.h(11002, Integer.valueOf(3), Integer.valueOf(3));
                                } else {
                                    com.tencent.mm.plugin.report.service.g.iuh.h(11002, Integer.valueOf(1), Integer.valueOf(2));
                                }
                            }
                            MMWizardActivity.w(this.ofM, new Intent(this.ofM, BindMContactStatusUI.class));
                        }
                    } else if (i == 2) {
                        intent = new Intent(this.ofM, BindMContactVerifyUI.class);
                        intent.putExtra("bindmcontact_mobile", str);
                        intent.putExtra("is_bind_for_safe_device", this.ofM.nNx);
                        intent.putExtra("is_bind_for_contact_sync", this.ofM.ofz);
                        intent.putExtra("is_bind_for_change_mobile", this.ofM.ofL);
                        intent.putExtra("KEnterFromBanner", this.ofM.edL);
                        if (this.ofM.nNm != null) {
                            intent.putExtra("BIND_FIND_ME_BY_MOBILE", this.ofM.nNm.isChecked());
                        }
                        intent.putExtra("BIND_FOR_QQ_REG", this.ofM.nNz);
                        MMWizardActivity.w(this.ofM, intent);
                    }
                }
            });
            bindMContactUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactUI.nNi);
        }
        i iVar = bindMContactUI.nNi;
        boolean z = (bindMContactUI.nNx || bindMContactUI.ofz) ? false : true;
        iVar.oPb = z;
        bindMContactUI.nNi.Pv(str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131231427);
        this.cQn = be.ah(getIntent().getStringExtra("country_name"), SQLiteDatabase.KeyEmpty);
        this.bfd = be.ah(getIntent().getStringExtra("couttry_code"), SQLiteDatabase.KeyEmpty);
        this.nII = be.ah(getIntent().getStringExtra("bindmcontact_shortmobile"), SQLiteDatabase.KeyEmpty);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.nNi != null) {
            getContentResolver().unregisterContentObserver(this.nNi);
            this.nNi.recycle();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bDn();
        return true;
    }

    private void bDn() {
        if (this.nNx || this.ofz) {
            nFV.clear();
            bAv();
            return;
        }
        g.a((Context) this, this.ofL ? 2131231406 : 2131231405, this.ofL ? 2131231408 : 2131231407, new OnClickListener(this) {
            final /* synthetic */ BindMContactUI ofM;

            {
                this.ofM = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ofM.bAv();
            }
        }, null);
    }

    protected final void NI() {
        this.nNx = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.ofz = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.nNz = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.ofL = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.edL = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.nNg = (EditText) findViewById(2131755577);
        this.nIF = (LinearLayout) findViewById(2131755574);
        this.nIG = (TextView) findViewById(2131755576);
        this.nNh = (TextView) findViewById(2131755575);
        this.nNm = (CheckBox) findViewById(2131755612);
        this.ofK = (LinearLayout) findViewById(2131755611);
        this.ofJ = (TextView) findViewById(2131755610);
        if (this.ofL) {
            ak.yW();
            String str = (String) c.vf().get(6, null);
            if (!be.kS(str)) {
                String vl;
                if (str.startsWith("+")) {
                    vl = al.vl(str);
                    String str2 = vl;
                    vl = str.substring(vl.length() + 1);
                    str = str2;
                } else {
                    vl = str;
                    str = "86";
                }
                al alVar = new al();
                str = al.formatNumber(str, vl);
                this.ofJ.setText(getString(2131231394, new Object[]{str}));
            }
        }
        if (!(this.cQn == null || this.cQn.equals(SQLiteDatabase.KeyEmpty))) {
            this.nIG.setText(this.cQn);
        }
        if (!(this.bfd == null || this.bfd.equals(SQLiteDatabase.KeyEmpty))) {
            this.nNh.setText("+" + this.bfd);
        }
        if (this.nII == null || this.nII.equals(SQLiteDatabase.KeyEmpty)) {
            ak.vA().a(new ad.a(this) {
                String eRq;
                final /* synthetic */ BindMContactUI ofM;

                {
                    this.ofM = r1;
                }

                public final boolean Ba() {
                    if (be.kS((this.ofM.nNg.getText()).trim())) {
                        if (be.kS(this.eRq)) {
                            this.ofM.nNg.setText(SQLiteDatabase.KeyEmpty);
                        } else {
                            this.ofM.nNg.setText(this.eRq);
                            this.ofM.nNg.setSelection(this.eRq.length());
                        }
                    }
                    return true;
                }

                public final boolean AZ() {
                    this.eRq = com.tencent.mm.modelsimple.c.x(this.ofM, this.ofM.bfd);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initView";
                }
            });
        } else {
            this.nNg.setText(this.nII);
            this.nNg.setSelection(this.nII.length());
        }
        if (com.tencent.mm.af.b.He()) {
            this.ofK.setVisibility(4);
            this.nNm.setChecked(true);
        }
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMContactUI ofM;

            {
                this.ofM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ofM.bhT = this.ofM.nNh.getText().toString().trim() + be.vt(this.ofM.nNg.getText().toString());
                if (!com.tencent.mm.pluginsdk.a.FY(this.ofM.bhT) || be.vt(this.ofM.nNg.getText().toString()).length() <= 0) {
                    g.f(this.ofM, 2131231418, 2131231164);
                } else {
                    BindMContactUI.b(this.ofM, this.ofM.bhT);
                }
                return true;
            }
        });
        this.nNg.requestFocus();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMContactUI ofM;

            {
                this.ofM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ofM.bDn();
                return true;
            }
        });
        this.nIF.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMContactUI ofM;

            {
                this.ofM = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.ofM.cQn);
                intent.putExtra("couttry_code", this.ofM.bfd);
                com.tencent.mm.plugin.a.a.drp.b(intent, this.ofM);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.cQn = be.ah(intent.getStringExtra("country_name"), SQLiteDatabase.KeyEmpty);
                this.bfd = be.ah(intent.getStringExtra("couttry_code"), SQLiteDatabase.KeyEmpty);
                if (!this.cQn.equals(SQLiteDatabase.KeyEmpty)) {
                    this.nIG.setText(this.cQn);
                }
                if (!this.bfd.equals(SQLiteDatabase.KeyEmpty)) {
                    this.nNh.setText("+" + this.bfd);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130903171;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.BindMContactUI";
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
        v.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
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
