package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.pp;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

@a(3)
public class IPCallDialUI extends MMActivity implements b.a, e {
    private TextView duy;
    private DialPad gIX;
    private TextView gIY;
    private EditText gIZ;
    private View gJa;
    private ImageButton gJb;
    private View gJc;
    private TextView gJd;
    private c gLA = new c<pp>(this) {
        final /* synthetic */ IPCallDialUI gLB;

        {
            this.gLB = r2;
            this.nhz = pp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pp ppVar = (pp) bVar;
            if (ppVar instanceof pp) {
                String str = ppVar.bqT.bfd;
                if (!(this.gLB.gLr == null || be.kS(str))) {
                    this.gLB.gLr.uR(str);
                }
            }
            return false;
        }
    };
    private b gLr;
    private String gLs;
    private String gLt;
    private String gLu;
    private String gLv;
    private int gLw = 0;
    private int gLx = 0;
    private int gLy = -1;
    com.tencent.mm.plugin.ipcall.a.d.b gLz;
    private String gpi;

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.c.a.nhr.e(this.gLA);
        ak.vy().a(807, this);
        getWindow().addFlags(131072);
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallDialUI gLB;

            {
                this.gLB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gLB.finish();
                return true;
            }
        }, 2131165204);
        this.gpi = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.gLs = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.gLt = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.gLu = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.gLv = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.gLw = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        v.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[]{this.gpi, this.gLs, this.gLt, this.gLu, this.gLv, Integer.valueOf(this.gLw)});
        if (!be.kS(this.gLs)) {
            this.gLs = com.tencent.mm.plugin.ipcall.b.c.vt(this.gLs);
        }
        if (be.kS(this.gLu)) {
            if (com.tencent.mm.plugin.ipcall.b.a.vn(this.gLs)) {
                if (be.kS(com.tencent.mm.plugin.ipcall.b.a.vl(this.gLs))) {
                    this.gLs = com.tencent.mm.plugin.ipcall.b.a.vo(this.gLs);
                } else {
                    v.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
                    this.gLx = 4;
                    Intent intent = new Intent(this, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_contactId", this.gLt);
                    intent.putExtra("IPCallTalkUI_countryCode", this.gLu);
                    intent.putExtra("IPCallTalkUI_nickname", this.gpi);
                    intent.putExtra("IPCallTalkUI_phoneNumber", this.gLs);
                    intent.putExtra("IPCallTalkUI_dialScene", this.gLw);
                    intent.putExtra("IPCallTalkUI_countryType", this.gLx);
                    startActivityForResult(intent, 1001);
                    finish();
                    return;
                }
            }
            this.gLu = com.tencent.mm.plugin.ipcall.b.c.avC();
        }
        if (this.gLw != 1) {
            this.gLy = 0;
            this.gLx = 3;
            this.gLz = new com.tencent.mm.plugin.ipcall.a.d.b(this.gLs, this.gLu, "", be.buo(), this.gLw);
            ak.vy().a(this.gLz, 0);
        } else {
            this.gLy = -1;
            this.gLx = 4;
        }
        init();
    }

    protected void onResume() {
        v.d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
    }

    protected final int getLayoutId() {
        return 2130903822;
    }

    private void init() {
        v.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), be.bur()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            vD(2131233347);
            setVolumeControlStream(1);
            this.gIX = (DialPad) findViewById(2131757558);
            this.gIY = (TextView) findViewById(2131757549);
            this.gJc = findViewById(2131757552);
            this.gIZ = (EditText) findViewById(2131757550);
            this.gJa = findViewById(2131757551);
            this.duy = (TextView) findViewById(2131757554);
            this.gJb = (ImageButton) findViewById(2131757557);
            this.gJd = (TextView) findViewById(2131757553);
            this.gLr = new b(this, this.gIZ, this.gIY, this.gJa, this.gIX, this.gJb, this.duy, this.gJc, this.gJd);
            this.gLr.gIW = this;
            if (!be.kS(this.gLs)) {
                this.gLr.aE(this.gLs, -1);
            }
            if (!be.kS(this.gLu)) {
                this.gLr.uR(this.gLu);
            }
            if (!be.kS(this.gLs) && !be.kS(this.gLu)) {
                this.gLr.ava();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        b bVar = this.gLr;
        v.d("MicroMsg.DialPadController", "onActivityResult");
        if (i == 100 && i2 == 100) {
            String ah = be.ah(intent.getStringExtra("country_name"), "");
            String ah2 = be.ah(intent.getStringExtra("couttry_code"), "");
            v.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[]{ah2, ah});
            if (!be.kS(ah2) && !be.kS(ah)) {
                bVar.gJf = ah;
                bVar.gJg = "+" + ah2;
                bVar.gIY.setText(bVar.gJg);
                bVar.gJh = bVar.bP(ah2.replace("+", ""), bVar.gJh);
                bVar.aE(bVar.gJh, -1);
                bVar.gJk = false;
            }
        } else if (i == 1001 && i2 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            bVar.aWn.setResult(-1, intent);
            bVar.aWn.finish();
        }
    }

    public final void g(String str, String str2, String str3, String str4) {
        v.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[]{str, str2, str3, str4});
        if (com.tencent.mm.plugin.ipcall.b.c.avB()) {
            Toast.makeText(this, 2131233397, 1).show();
        } else if (com.tencent.mm.plugin.ipcall.a.c.atY().lU(be.getInt(str, -1))) {
            g.A(this, getString(2131231562), getString(2131231563));
            com.tencent.mm.plugin.report.service.g.iuh.Y(12058, str);
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            Intent intent = new Intent(this, IPCallTalkUI.class);
            intent.putExtra("IPCallTalkUI_contactId", str3);
            intent.putExtra("IPCallTalkUI_countryCode", str);
            intent.putExtra("IPCallTalkUI_nickname", str4);
            intent.putExtra("IPCallTalkUI_phoneNumber", str2);
            intent.putExtra("IPCallTalkUI_dialScene", this.gLw);
            intent.putExtra("IPCallTalkUI_countryType", this.gLx);
            startActivityForResult(intent, 1001);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.gLr != null) {
            this.gLr.gIW = null;
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.gLA);
        ak.vy().b(807, this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.IPCallDialUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ IPCallDialUI gLB;

                        {
                            this.gLB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.gLB.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ IPCallDialUI gLB;

                        {
                            this.gLB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.gLB.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.ipcall.a.d.b) && i == 0 && i2 == 0 && kVar == this.gLz) {
            if (this.gLz.gHA != null) {
                v.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[]{Integer.valueOf(this.gLz.gHA.mmL), this.gLz.gHA.mNR, this.gLz.gHA.gPJ});
            }
            if (this.gLy != 2) {
                this.gLy = 1;
                this.gLx = 1;
                com.tencent.mm.plugin.ipcall.a.d.b bVar = this.gLz;
                int i3 = (bVar.gHA == null || bVar.gHA.mmL != 2) ? 0 : 1;
                if (i3 != 0) {
                    v.i("MicroMsg.IPCallDialUI", "check error show error dialog");
                    return;
                }
                bVar = this.gLz;
                i3 = (bVar.gHA == null || !(bVar.gHA.mmL == 1 || bVar.gHA.mmL == 0)) ? 0 : 1;
                if (i3 != 0) {
                    if (this.gLz.gHA == null || be.kS(this.gLz.gHA.gPJ)) {
                        v.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                    } else if (this.gLr != null) {
                        v.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[]{this.gLz.gHA.gPJ, this.gLu});
                        this.gLu = this.gLz.gHA.gPJ;
                        this.gLr.uR(this.gLz.gHA.gPJ);
                    }
                }
                if (this.gLz.gHA != null && !be.kS(this.gLz.gHA.mNR) && this.gLr != null) {
                    v.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[]{this.gLz.gHA.mNR, this.gLs});
                    this.gLs = this.gLz.gHA.mNR;
                    this.gLr.aE(this.gLz.gHA.mNR, -1);
                    return;
                }
                return;
            }
            v.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
        }
    }

    public final void uS(String str) {
        v.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[]{str, this.gLu});
        if (this.gLy != 2 && this.gLy != -1 && !this.gLu.equals(str)) {
            avj();
        }
    }

    public final void uT(String str) {
        v.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[]{str, this.gLs});
        if (this.gLy != 2 && this.gLy != -1 && !this.gLs.equals(str)) {
            avj();
        }
    }

    private void avj() {
        v.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.gLy = 2;
        if (this.gLx == 1) {
            this.gLx = 2;
        } else {
            this.gLx = 4;
        }
    }
}
