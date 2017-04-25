package com.tencent.mm.ui.account.bind;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.ui.friend.i.b;

public class BindMobileUI extends MMWizardActivity {
    private String bfd = null;
    private String bhT;
    private String cQn = null;
    private TextView dID;
    private LinearLayout nIF;
    private TextView nIG;
    private String nII = null;
    private BindWordingContent nNa;
    private int nNb;
    private EditText nNg;
    private TextView nNh;
    private i nNi;
    private Button nNj;
    private TextView nNk;
    private TextView nNl;
    private CheckBox nNm;
    private CheckBox nNn;
    private LinearLayout nNo;
    private ImageView nNp;
    private boolean nNq;

    static /* synthetic */ void a(BindMobileUI bindMobileUI, final String str) {
        if (bindMobileUI.nNi == null) {
            bindMobileUI.nNi = new i(b.oPf, bindMobileUI, new a(bindMobileUI) {
                final /* synthetic */ BindMobileUI nNs;

                public final void vV(int i) {
                    boolean z = true;
                    if (i == 1) {
                        if (this.nNs.nNq) {
                            BindMobileUI bindMobileUI = this.nNs;
                            boolean z2 = !this.nNs.nNm.isChecked();
                            if (this.nNs.nNn.isChecked()) {
                                z = false;
                            }
                            BindMobileStatusUI.b(bindMobileUI, z2, z);
                            this.nNs.exit(-1);
                            return;
                        }
                        Intent intent = new Intent(this.nNs, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", this.nNs.nNa);
                        intent.putExtra("kstyle_bind_recommend_show", this.nNs.nNb);
                        intent.putExtra("Kfind_friend_by_mobile_flag", this.nNs.nNm.isChecked());
                        intent.putExtra("Krecom_friends_by_mobile_flag", this.nNs.nNn.isChecked());
                        MMWizardActivity.w(this.nNs, intent);
                    } else if (i == 2) {
                        BindMobileUI.d(this.nNs, str);
                    }
                }
            });
            bindMobileUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMobileUI.nNi);
        }
        bindMobileUI.nNi.Pv(str);
        if (bindMobileUI.nNq) {
            bindMobileUI.nNi.oPb = false;
        }
    }

    static /* synthetic */ void c(BindMobileUI bindMobileUI, final String str) {
        String string = bindMobileUI.nDR.nEl.getString(2131231449);
        g.a(bindMobileUI.nDR.nEl, String.format("%s\n%s", new Object[]{bindMobileUI.nDR.nEl.getString(2131231450), str}), string, new OnClickListener(bindMobileUI) {
            final /* synthetic */ BindMobileUI nNs;

            public final void onClick(DialogInterface dialogInterface, int i) {
                BindMobileUI.a(this.nNs, str);
            }
        }, null);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI, String str) {
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.nNa);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.nNb);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.nNm.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.nNn.isChecked());
        intent.putExtra("is_bind_for_chatroom_upgrade", bindMobileUI.nNq);
        w(bindMobileUI, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131231424);
        this.cQn = be.ah(getIntent().getStringExtra("country_name"), "");
        this.bfd = be.ah(getIntent().getStringExtra("couttry_code"), "");
        this.nII = be.ah(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.nNa = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.nNb = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.nNq = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
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
        bAv();
        return true;
    }

    protected final void NI() {
        this.nNg = (EditText) findViewById(2131755577);
        this.nIF = (LinearLayout) findViewById(2131755574);
        this.nIG = (TextView) findViewById(2131755576);
        this.nNh = (TextView) findViewById(2131755575);
        this.dID = (TextView) findViewById(2131755573);
        this.nNj = (Button) findViewById(2131755578);
        this.nNk = (TextView) findViewById(2131755584);
        this.dID.setText(getString(2131231420));
        this.nNl = (TextView) findViewById(2131755582);
        this.nNo = (LinearLayout) findViewById(2131755579);
        this.nNn = (CheckBox) findViewById(2131755581);
        this.nNm = (CheckBox) findViewById(2131755580);
        this.nNp = (ImageView) findViewById(2131755572);
        if (this.nNa != null) {
            if (this.nNa.title != null && this.nNa.title.length() > 0) {
                this.dID.setText(this.nNa.title);
            }
            if (this.nNa.content != null && this.nNa.content.length() > 0) {
                this.nNl.setText(this.nNa.content);
            }
            switch (this.nNa.cYh.intValue()) {
                case 0:
                    this.nNp.setImageResource(2130837708);
                    break;
                case 1:
                    this.nNp.setImageResource(2130837711);
                    break;
                case 2:
                    this.nNp.setImageResource(2130837709);
                    break;
            }
        }
        switch (this.nNb) {
            case 0:
                this.nNo.setVisibility(0);
                this.nNn.setVisibility(0);
                this.nNl.setVisibility(8);
                break;
            case 1:
                this.nNo.setVisibility(8);
                this.nNn.setVisibility(8);
                this.nNl.setVisibility(0);
                break;
        }
        if (be.kS(this.cQn) && be.kS(this.bfd)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            v.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()" + simCountryIso);
            if (be.kS(simCountryIso)) {
                v.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.af.b.a g = com.tencent.mm.af.b.g(this, simCountryIso, getString(2131232236));
                if (g == null) {
                    v.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                } else {
                    this.cQn = g.cQn;
                    this.bfd = g.cQm;
                }
            }
        }
        if (!(this.cQn == null || this.cQn.equals(""))) {
            this.nIG.setText(this.cQn);
        }
        if (!(this.bfd == null || this.bfd.equals(""))) {
            this.nNh.setText("+" + this.bfd);
        }
        if (!(this.nII == null || this.nII.equals(""))) {
            this.nNg.setText(this.nII);
        }
        this.nNj.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI nNs;

            {
                this.nNs = r1;
            }

            public final void onClick(View view) {
                if (this.nNs.nNg.getText().toString() == null || this.nNs.nNg.getText().toString().length() == 0) {
                    Toast.makeText(this.nNs, this.nNs.getString(2131231401), 0).show();
                    return;
                }
                this.nNs.bhT = this.nNs.nNh.getText().toString().trim() + be.vt(this.nNs.nNg.getText().toString());
                BindMobileUI.c(this.nNs, this.nNs.bhT);
            }
        });
        this.nNk.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI nNs;

            {
                this.nNs = r1;
            }

            public final void onClick(View view) {
                this.nNs.bAv();
            }
        });
        if (this.nNq) {
            vD(2131231389);
            this.nNp.setVisibility(8);
            this.dID.setText(2131231409);
            this.nNo.setVisibility(8);
            this.nNn.setVisibility(8);
            this.nNn.setChecked(false);
            this.nNm.setVisibility(0);
            this.nNm.setChecked(false);
            this.nNl.setVisibility(8);
            this.nNl.setText(getString(2131231391));
            this.nNk.setVisibility(8);
            this.nNj.setText(2131231389);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BindMobileUI nNs;

                {
                    this.nNs = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.nNs.bAv();
                    return true;
                }
            });
        }
        this.nIF.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI nNs;

            {
                this.nNs = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.nNs.cQn);
                intent.putExtra("couttry_code", this.nNs.bfd);
                com.tencent.mm.plugin.a.a.drp.b(intent, this.nNs);
            }
        });
        this.nIF.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI nNs;

            {
                this.nNs = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.nNs.cQn);
                intent.putExtra("couttry_code", this.nNs.bfd);
                com.tencent.mm.plugin.a.a.drp.b(intent, this.nNs);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.cQn = be.ah(intent.getStringExtra("country_name"), "");
                this.bfd = be.ah(intent.getStringExtra("couttry_code"), "");
                if (!this.cQn.equals("")) {
                    this.nIG.setText(this.cQn);
                }
                if (!this.bfd.equals("")) {
                    this.nNh.setText("+" + this.bfd);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130903165;
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
        v.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
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
