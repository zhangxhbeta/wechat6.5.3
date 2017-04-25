package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.z;
import com.tencent.mm.modelsimple.c;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI extends MMActivity implements e {
    private String cZU;
    private ProgressDialog dwR = null;
    private ProgressBar fpm;
    private Button fzj;
    private int hGO = 0;
    private String kIC;
    private SecurityImage nFq = null;
    private a nJo;
    private EditText nKY;
    private boolean nKx = false;
    private EditText nLG;
    private String nLH;
    private String nLI;
    private int nLJ;
    private String nLK;
    private TextView nLL;
    private View nLM;
    private boolean nLN = false;
    private ImageView nLO;
    private int nLP = 3;
    private LinkedList<String> nLQ = new LinkedList();
    private ImageView nLR;
    private ImageView nLS;
    private String nLT = SQLiteDatabase.KeyEmpty;
    private ImageView nLU;
    private View nLV;
    private TextView nLW;
    private String nLX = null;
    private boolean nLY = false;
    private o nLZ;
    private View nMa;
    private boolean nMb = false;
    private ah nMc = new ah(Looper.myLooper(), new ah.a(this) {
        final /* synthetic */ RegSetInfoUI nMd;

        {
            this.nMd = r1;
        }

        public final boolean oU() {
            String str;
            String trim = this.nMd.nLG.getText().toString().trim();
            String trim2 = this.nMd.nKY.getText().toString().trim();
            if (be.kS(trim) && !be.kS(trim2)) {
                trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
            }
            if (be.kS(trim) || !be.kS(trim2)) {
                str = trim2;
            } else {
                str = trim;
            }
            if (!be.kS(trim) && this.nMd.bBa() && this.nMd.bBd()) {
                int e = this.nMd.bBh();
                String f = this.nMd.bBi();
                ak.vy().a(429, this.nMd);
                ak.vy().a(new z(f, this.nMd.cZU, e, str, trim, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty), 0);
                this.nMd.fpm.setVisibility(0);
            }
            return false;
        }
    }, true);

    static /* synthetic */ void q(RegSetInfoUI regSetInfoUI) {
        String trim = regSetInfoUI.nKY.getText().toString().trim();
        String trim2 = regSetInfoUI.nLG.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            g.f(regSetInfoUI, 2131235771, 2131234430);
        } else if (regSetInfoUI.fpm.getVisibility() == 0) {
            regSetInfoUI.getString(2131231164);
            regSetInfoUI.dwR = g.a((Context) regSetInfoUI, regSetInfoUI.getString(2131234461), true, new OnCancelListener(regSetInfoUI) {
                final /* synthetic */ RegSetInfoUI nMd;

                {
                    this.nMd = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        } else if (regSetInfoUI.bBa() && regSetInfoUI.bBd() && !be.kS(trim2)) {
            String charSequence = regSetInfoUI.nLL.getText().toString();
            if (be.kS(charSequence) || charSequence.equals(regSetInfoUI.getString(2131234474))) {
                charSequence = be.kS(regSetInfoUI.nLX) ? regSetInfoUI.getString(2131234477) : regSetInfoUI.nLX;
            }
            g.A(regSetInfoUI, charSequence, SQLiteDatabase.KeyEmpty);
        } else {
            regSetInfoUI.axg();
            int bBh;
            final k uVar;
            if (regSetInfoUI.bBd()) {
                int i = (regSetInfoUI.nLQ == null || regSetInfoUI.nLQ.size() == 0) ? 0 : regSetInfoUI.nLQ.contains(trim2) ? 1 : 2;
                bBh = regSetInfoUI.bBh();
                ak.vy().a(126, (e) regSetInfoUI);
                uVar = new u(SQLiteDatabase.KeyEmpty, regSetInfoUI.kIC, trim, regSetInfoUI.nLJ, regSetInfoUI.nLI, regSetInfoUI.nLH, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, regSetInfoUI.cZU, bBh, trim2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, regSetInfoUI.nLN, regSetInfoUI.nKx);
                ((com.tencent.mm.protocal.z.a) uVar.cAt.Bx()).lXu.mKL = i;
                ak.vy().a(uVar, 0);
                regSetInfoUI.getString(2131231164);
                regSetInfoUI.dwR = g.a((Context) regSetInfoUI, regSetInfoUI.getString(2131234461), true, new OnCancelListener(regSetInfoUI) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                        ak.vy().b(126, this.nMd);
                    }
                });
                return;
            }
            bBh = regSetInfoUI.bBh();
            ak.vy().a(126, (e) regSetInfoUI);
            uVar = new u(SQLiteDatabase.KeyEmpty, regSetInfoUI.kIC, trim, regSetInfoUI.nLJ, regSetInfoUI.nLI, regSetInfoUI.nLH, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, regSetInfoUI.cZU, bBh, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, regSetInfoUI.nLN, regSetInfoUI.nKx);
            ak.vy().a(uVar, 0);
            regSetInfoUI.getString(2131231164);
            regSetInfoUI.dwR = g.a((Context) regSetInfoUI, regSetInfoUI.getString(2131234461), true, new OnCancelListener(regSetInfoUI) {
                final /* synthetic */ RegSetInfoUI nMd;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(uVar);
                    ak.vy().b(126, this.nMd);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(2131234475);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        Fd(string);
        com.tencent.mm.plugin.a.a.drq.oz();
        this.nLH = getIntent().getStringExtra("regsetinfo_user");
        this.nLI = getIntent().getStringExtra("regsetinfo_bind_email");
        this.cZU = getIntent().getStringExtra("regsetinfo_ticket");
        this.kIC = getIntent().getStringExtra("regsetinfo_pwd");
        this.nLK = getIntent().getStringExtra("regsetinfo_binduin");
        if (!be.kS(this.nLK)) {
            this.nLJ = com.tencent.mm.a.o.ba(this.nLK);
        }
        this.hGO = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.nLN = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.nLP = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        NI();
        if (this.hGO == 1) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",1");
            b.mh("R200_900_phone");
        } else if (this.hGO == 2) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R4_QQ," + ak.dR("R4_QQ") + ",1");
            b.mh("R4_QQ");
        } else if (this.hGO == 3) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R200_900_email," + ak.dR("R200_900_email") + ",1");
            b.mh("R200_900_email");
        }
        this.nMb = false;
        this.nJo = new a();
    }

    public void onResume() {
        super.onResume();
        this.nKY.postDelayed(new Runnable(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final void run() {
                this.nMd.nLO.requestFocus();
                this.nMd.nKY.clearFocus();
            }
        }, 500);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.hGO == 1) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",2");
        } else if (this.hGO == 2) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R4_QQ," + ak.dR("R4_QQ") + ",2");
        } else if (this.hGO == 3) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R200_900_email," + ak.dR("R200_900_email") + ",2");
        }
        if (this.nJo != null) {
            this.nJo.close();
        }
    }

    protected final void NI() {
        int i;
        int i2 = 0;
        this.nMa = findViewById(2131758877);
        this.nLV = findViewById(2131758859);
        this.nLO = (ImageView) findViewById(2131758860);
        this.nKY = (EditText) findViewById(2131758875);
        this.nLW = (TextView) findViewById(2131758874);
        this.nLG = (EditText) findViewById(2131758879);
        this.nLL = (TextView) findViewById(2131758881);
        this.nLM = findViewById(2131758878);
        this.nLR = (ImageView) findViewById(2131758876);
        this.nLS = (ImageView) findViewById(2131758880);
        this.fpm = (ProgressBar) findViewById(2131758845);
        this.nLU = (ImageView) findViewById(2131758861);
        this.fzj = (Button) findViewById(2131756365);
        this.nLR.setVisibility(8);
        this.nLS.setVisibility(8);
        this.fpm.setVisibility(8);
        this.nLU.setVisibility(8);
        this.nKx = false;
        this.nLY = false;
        this.nLV.setVisibility(bBc() ? 0 : 8);
        View view = this.nLM;
        if (bBd()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        TextView textView = this.nLL;
        if (!bBd()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (bBc() && bBd()) {
            this.nLW.setText(getString(2131234472));
        } else if (bBc() && !bBd()) {
            this.nLW.setText(getString(2131234470));
        } else if (bBc() || !bBd()) {
            this.nLW.setText(getString(2131234469));
        } else {
            this.nLW.setText(getString(2131234471));
        }
        ak.vA().a(new ad.a(this) {
            String gpi;
            Bitmap mBitmap;
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final boolean Ba() {
                if (!be.kS(this.gpi) && be.kS((this.nMd.nKY.getText()).trim())) {
                    this.nMd.nKY.setText(this.gpi);
                }
                if (f.sj()) {
                    if (!(this.mBitmap == null || this.mBitmap.isRecycled() || this.nMd.nKx)) {
                        this.nMd.nLO.setImageBitmap(this.mBitmap);
                        this.nMd.nKx = true;
                        this.nMd.nLU.setVisibility(0);
                    }
                    return true;
                }
                v.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
                return false;
            }

            public final boolean AZ() {
                try {
                    this.gpi = c.aV(this.nMd);
                    this.mBitmap = c.aW(this.nMd);
                } catch (Exception e) {
                    v.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + e.getMessage());
                }
                if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(this.mBitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.cgo + "temp.avatar", false);
                    } catch (Throwable e2) {
                        v.e("MiroMsg.RegSetInfoUI", "save avatar fail." + e2.getMessage());
                        v.a("MiroMsg.RegSetInfoUI", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|initView";
            }
        });
        this.nKY.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final void afterTextChanged(Editable editable) {
                CharSequence trim = this.nMd.nKY.getText().toString().trim();
                if (trim == null || trim.length() <= 16) {
                    if (!this.nMd.nMc.btC()) {
                        this.nMd.nMc.QI();
                    }
                    this.nMd.bBb();
                    if (be.kS(this.nMd.nKY.getText().toString().trim())) {
                        this.nMd.nLR.setVisibility(8);
                    } else {
                        this.nMd.nLR.setVisibility(0);
                    }
                    if (!this.nMd.nMb) {
                        this.nMd.nLG.setText(trim);
                        return;
                    }
                    return;
                }
                this.nMd.nKY.setText(trim.substring(0, 16));
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final void onClick(View view) {
                RegSetInfoUI.q(this.nMd);
            }
        });
        this.nLG.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.nMd.nMb = true;
                    this.nMd.nMc.ea(200);
                }
            }
        });
        this.nLG.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final void afterTextChanged(Editable editable) {
                if (!this.nMd.nMc.btC()) {
                    this.nMd.nMc.QI();
                }
                String trim = this.nMd.nLG.getText().toString().trim();
                if (be.kS(trim)) {
                    this.nMd.nLL.setText(this.nMd.getString(2131234474));
                    this.nMd.F(false, false);
                    if (this.nMd.nLZ != null) {
                        this.nMd.nLZ.dismiss();
                        this.nMd.nLZ = null;
                    }
                    this.nMd.nLG.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass32 nMq;

                        {
                            this.nMq = r1;
                        }

                        public final void run() {
                            this.nMq.nMd.nLG.clearFocus();
                            this.nMq.nMd.nLG.requestFocus();
                        }
                    }, 50);
                }
                if (!be.kS(trim) && (this.nMd.bBa() || !trim.equals(this.nMd.nLT))) {
                    this.nMd.F(false, false);
                    this.nMd.nMc.ea(500);
                }
                this.nMd.nLT = trim;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nMd.aKM();
                return true;
            }
        });
        this.nKY.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                RegSetInfoUI.q(this.nMd);
                return true;
            }
        });
        this.nKY.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                RegSetInfoUI.q(this.nMd);
                return true;
            }
        });
        this.nLG.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                RegSetInfoUI.q(this.nMd);
                return true;
            }
        });
        this.nLG.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                RegSetInfoUI.q(this.nMd);
                return true;
            }
        });
        this.nLO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegSetInfoUI nMd;

            {
                this.nMd = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.a.a.drq.c(this.nMd);
            }
        });
        File file = new File(com.tencent.mm.compatible.util.e.cgo);
        if (!file.exists()) {
            file.mkdir();
        }
        bBb();
    }

    private void F(boolean z, boolean z2) {
        boolean z3 = false;
        if (be.kS(this.nLG.getText().toString().trim())) {
            z = false;
        }
        this.nLS.setImageResource(z2 ? 2130839189 : 2130839186);
        this.nLS.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.nLY = z3;
    }

    private boolean bBa() {
        return this.nLS.getVisibility() == 8 || this.nLY;
    }

    private void bBb() {
        this.fzj.setEnabled(!be.kS(this.nKY.getText().toString().trim()));
    }

    private boolean bBc() {
        return (this.nLP & 1) > 0;
    }

    private boolean bBd() {
        return (this.nLP & 2) > 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        v.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        Bitmap a = com.tencent.mm.plugin.a.a.drq.a((Activity) this, i, i2, intent);
        if (a != null) {
            this.nLO.setImageBitmap(a);
            this.nKx = true;
            this.nLU.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return 2130904273;
    }

    private boolean bBe() {
        return this.hGO == 1;
    }

    private boolean bBf() {
        return this.hGO == 2;
    }

    private boolean bBg() {
        return this.hGO == 3;
    }

    private int bBh() {
        if (bBe()) {
            return 4;
        }
        if (bBf() || !bBg()) {
            return 2;
        }
        return 6;
    }

    private String bBi() {
        if (bBe()) {
            return this.nLH;
        }
        if (bBg()) {
            return this.nLI;
        }
        return this.nLK;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int KL;
        com.tencent.mm.f.a dm;
        v.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 126) {
            ak.vy().b(126, (e) this);
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (i == 0 && i2 == 0) {
                String str2;
                String str3;
                Intent intent;
                String str4;
                final k kVar2;
                final String str5;
                final String str6;
                final boolean z;
                final k kVar3;
                final String str7;
                final String str8;
                final int i3;
                this.nLX = null;
                final String bBi = bBi();
                final String Jr = ((u) kVar).Jr();
                final int Js = ((u) kVar).Js();
                String str9 = null;
                String str10 = null;
                boolean z2 = false;
                Map q = bf.q(((u) kVar).Jt(), "wording");
                if (q != null) {
                    str2 = (String) q.get(".wording.switch");
                    if (be.kS(str2)) {
                        z2 = true;
                    } else {
                        KL = be.KL(str2);
                        if (KL == 0) {
                            z2 = false;
                        } else if (KL == 1) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        str2 = (String) q.get(".wording.title");
                        if (!be.kS(str2)) {
                            str9 = str2;
                        }
                        str2 = (String) q.get(".wording.desc");
                        if (be.kS(str2)) {
                            str3 = str9;
                        } else {
                            str10 = str2;
                            str3 = str9;
                        }
                        v.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                        ak.unhold();
                        ak.aL(true);
                        if (this.nKx) {
                            this.cZU = ((u) kVar).Jq();
                            ai.cse.J("login_user_name", bBi);
                            if (Jr == null && Jr.contains("0")) {
                                b.mi("R300_100_phone");
                                if (z2) {
                                    intent = new Intent(this, FindMContactAlertUI.class);
                                    intent.putExtra("alert_title", str3);
                                    intent.putExtra("alert_message", str10);
                                } else {
                                    intent = new Intent(this, FindMContactIntroUI.class);
                                }
                                intent.addFlags(67108864);
                                intent.putExtra("regsetinfo_ticket", this.cZU);
                                intent.putExtra("regsetinfo_NextStep", Jr);
                                intent.putExtra("regsetinfo_NextStyle", Js);
                                Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this);
                                ak.addFlags(67108864);
                                ak.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this, intent, ak);
                                finish();
                            } else {
                                intent = com.tencent.mm.plugin.a.a.drp.ak(this);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                startActivity(intent);
                                b.mj(ak.uR() + "," + getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                                finish();
                            }
                        } else {
                            str4 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar";
                            str2 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar.hd";
                            new File(str4).renameTo(new File(str2));
                            com.tencent.mm.loader.stub.b.deleteFile(str4);
                            com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                            kVar2 = kVar;
                            str5 = bBi;
                            str6 = Jr;
                            z = z2;
                            kVar3 = kVar;
                            str7 = str3;
                            str8 = str10;
                            i3 = Js;
                            new n(this, com.tencent.mm.compatible.util.e.cgo + "temp.avatar").a(new Runnable(this) {
                                final /* synthetic */ RegSetInfoUI nMd;

                                public final void run() {
                                    this.nMd.cZU = ((u) kVar2).Jq();
                                    ai.cse.J("login_user_name", str5);
                                    com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.cgo + "temp.avatar");
                                    if (str6 == null || !str6.contains("0")) {
                                        Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this.nMd);
                                        ak.addFlags(67108864);
                                        this.nMd.startActivity(ak);
                                        b.mj(ak.uR() + "," + this.nMd.getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                                        this.nMd.finish();
                                        return;
                                    }
                                    b.mi("R300_100_phone");
                                    if (z) {
                                        ak = new Intent(this.nMd, FindMContactAlertUI.class);
                                        ak.putExtra("alert_title", str3);
                                        ak.putExtra("alert_message", str10);
                                    } else {
                                        ak = new Intent(this.nMd, FindMContactIntroUI.class);
                                    }
                                    ak.addFlags(67108864);
                                    ak.putExtra("regsetinfo_ticket", this.nMd.cZU);
                                    ak.putExtra("regsetinfo_NextStep", str6);
                                    ak.putExtra("regsetinfo_NextStyle", Js);
                                    Intent ak2 = com.tencent.mm.plugin.a.a.drp.ak(this.nMd);
                                    ak2.addFlags(67108864);
                                    MMWizardActivity.b(this.nMd, ak, ak2);
                                    this.nMd.finish();
                                }
                            }, new Runnable(this) {
                                final /* synthetic */ RegSetInfoUI nMd;

                                public final void run() {
                                    this.nMd.cZU = ((u) kVar3).Jq();
                                    ai.cse.J("login_user_name", bBi);
                                    if (Jr == null || !Jr.contains("0")) {
                                        Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this.nMd);
                                        ak.addFlags(67108864);
                                        this.nMd.startActivity(ak);
                                        b.mj(ak.uR() + "," + this.nMd.getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                                        this.nMd.finish();
                                        return;
                                    }
                                    b.mi("R300_100_phone");
                                    if (z2) {
                                        ak = new Intent(this.nMd, FindMContactAlertUI.class);
                                        ak.putExtra("alert_title", str7);
                                        ak.putExtra("alert_message", str8);
                                    } else {
                                        ak = new Intent(this.nMd, FindMContactIntroUI.class);
                                    }
                                    ak.addFlags(67108864);
                                    ak.putExtra("regsetinfo_ticket", this.nMd.cZU);
                                    ak.putExtra("regsetinfo_NextStep", Jr);
                                    ak.putExtra("regsetinfo_NextStyle", i3);
                                    Intent ak2 = com.tencent.mm.plugin.a.a.drp.ak(this.nMd);
                                    ak2.addFlags(67108864);
                                    MMWizardActivity.b(this.nMd, ak, ak2);
                                    this.nMd.finish();
                                }
                            });
                        }
                    }
                }
                str3 = null;
                v.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                ak.unhold();
                ak.aL(true);
                if (this.nKx) {
                    this.cZU = ((u) kVar).Jq();
                    ai.cse.J("login_user_name", bBi);
                    if (Jr == null) {
                    }
                    intent = com.tencent.mm.plugin.a.a.drp.ak(this);
                    intent.addFlags(67108864);
                    intent.putExtra("LauncherUI.enter_from_reg", true);
                    startActivity(intent);
                    b.mj(ak.uR() + "," + getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                    finish();
                } else {
                    str4 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar";
                    str2 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar.hd";
                    new File(str4).renameTo(new File(str2));
                    com.tencent.mm.loader.stub.b.deleteFile(str4);
                    com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                    kVar2 = kVar;
                    str5 = bBi;
                    str6 = Jr;
                    z = z2;
                    kVar3 = kVar;
                    str7 = str3;
                    str8 = str10;
                    i3 = Js;
                    new n(this, com.tencent.mm.compatible.util.e.cgo + "temp.avatar").a(/* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
            if (i2 != -6 && i2 != -311 && i2 != -310) {
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this, null, null);
                    return;
                } else if (k(i, i2, str)) {
                    return;
                }
            } else if (this.nFq == null) {
                final k kVar4 = kVar;
                kVar4 = kVar;
                this.nFq = SecurityImage.a.a(this.nDR.nEl, 0, ((u) kVar).Fv(), ((u) kVar).Fw(), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = this.nMd.nLG.getText().toString().trim();
                        String trim2 = this.nMd.nKY.getText().toString().trim();
                        if (trim2 == null || trim2.length() <= 0) {
                            g.f(this.nMd, 2131235771, 2131234430);
                            return;
                        }
                        int e = this.nMd.bBh();
                        ak.vy().a(126, this.nMd);
                        final k uVar = new u(SQLiteDatabase.KeyEmpty, this.nMd.kIC, trim2, this.nMd.nLJ, this.nMd.nLI, this.nMd.nLH, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.nMd.cZU, e, trim, ((u) kVar4).Fw(), this.nMd.nFq.bBA(), this.nMd.nLN, this.nMd.nKx);
                        ak.vy().a(uVar, 0);
                        RegSetInfoUI regSetInfoUI = this.nMd;
                        Context context = this.nMd;
                        this.nMd.getString(2131231164);
                        regSetInfoUI.dwR = g.a(context, this.nMd.getString(2131234461), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass11 nMl;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(uVar);
                                ak.vy().b(126, this.nMl.nMd);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.nMd.nFq = null;
                    }
                }, new SecurityImage.b(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    public final void bAL() {
                        this.nMd.axg();
                        String trim = this.nMd.nLG.getText().toString().trim();
                        String trim2 = this.nMd.nKY.getText().toString().trim();
                        int e = this.nMd.bBh();
                        ak.vy().a(126, this.nMd);
                        ak.vy().a(new u(SQLiteDatabase.KeyEmpty, this.nMd.kIC, trim2, this.nMd.nLJ, this.nMd.nLI, this.nMd.nLH, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.nMd.cZU, e, trim, ((u) kVar4).Fw(), SQLiteDatabase.KeyEmpty, this.nMd.nLN, this.nMd.nKx), 0);
                    }
                });
                return;
            } else {
                this.nFq.a(0, ((u) kVar).Fv(), ((u) kVar).Fw(), SQLiteDatabase.KeyEmpty);
                return;
            }
        }
        if (kVar.getType() == 429) {
            ak.vy().b(429, (e) this);
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            this.fpm.setVisibility(8);
            if (i == 0 && i2 == 0) {
                this.nLX = null;
                KL = ((com.tencent.mm.protocal.u.b) ((z) kVar).cAt.ze()).lXo.mAV;
                v.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", Integer.valueOf(KL));
                if (KL == -14 || KL == -10 || KL == -7) {
                    LinkedList linkedList = ((com.tencent.mm.protocal.u.b) ((z) kVar).cAt.ze()).lXo.eeu;
                    dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null) {
                        this.nLL.setText(dm.desc);
                    }
                    this.nLQ.clear();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size() > 3 ? 3 : linkedList.size();
                        final String[] strArr = new String[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            strArr[i4] = ((arf) linkedList.get(i4)).mQy;
                            this.nLQ.add(strArr[i4]);
                        }
                        if (this.nMb) {
                            if (this.nLZ != null) {
                                this.nLZ.dismiss();
                                this.nLZ = null;
                            }
                            this.nLZ = g.a(this, this.nMa, strArr, new OnItemClickListener(this) {
                                final /* synthetic */ RegSetInfoUI nMd;

                                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                    if (this.nMd.nLZ != null) {
                                        this.nMd.nLZ.dismiss();
                                        this.nMd.nLZ = null;
                                    }
                                    this.nMd.nLG.setText(strArr[i]);
                                    this.nMd.nLG.postDelayed(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass19 nMp;

                                        {
                                            this.nMp = r1;
                                        }

                                        public final void run() {
                                            this.nMp.nMd.nLG.clearFocus();
                                            this.nMp.nMd.nLG.requestFocus();
                                        }
                                    }, 50);
                                    this.nMd.nLL.setText(this.nMd.getString(2131234474));
                                }
                            });
                        }
                    }
                    F(true, true);
                    return;
                } else if (be.kS(this.nLG.getText().toString().trim())) {
                    F(false, false);
                    return;
                } else {
                    F(true, false);
                    this.nLL.setText(getString(2131234474));
                    if (this.nLZ != null) {
                        this.nLZ.dismiss();
                        this.nLZ = null;
                    }
                    this.nLG.postDelayed(new Runnable(this) {
                        final /* synthetic */ RegSetInfoUI nMd;

                        {
                            this.nMd = r1;
                        }

                        public final void run() {
                            this.nMd.nLG.clearFocus();
                            this.nMd.nLG.requestFocus();
                        }
                    }, 50);
                    return;
                }
            } else if (i2 != -6 && i2 != -311 && i2 != -310) {
                F(true, true);
            } else if (this.nFq == null) {
                kVar4 = kVar;
                kVar4 = kVar;
                this.nFq = SecurityImage.a.a(this.nDR.nEl, 0, ((z) kVar).Fv(), ((z) kVar).Fw(), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = this.nMd.nKY.getText().toString().trim();
                        String trim2 = this.nMd.nLG.getText().toString().trim();
                        if (trim == null || trim.length() <= 0) {
                            g.f(this.nMd, 2131235771, 2131234430);
                            return;
                        }
                        this.nMd.axg();
                        int e = this.nMd.bBh();
                        String f = this.nMd.bBi();
                        ak.vy().a(429, this.nMd);
                        final k zVar = new z(f, this.nMd.cZU, e, trim, trim2, ((z) kVar4).Fw(), this.nMd.nFq.bBA());
                        ak.vy().a(zVar, 0);
                        RegSetInfoUI regSetInfoUI = this.nMd;
                        Context context = this.nMd;
                        this.nMd.getString(2131231164);
                        regSetInfoUI.dwR = g.a(context, this.nMd.getString(2131234461), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass16 nMn;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(zVar);
                                ak.vy().b(429, this.nMn.nMd);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.nMd.nFq = null;
                    }
                }, new SecurityImage.b(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    public final void bAL() {
                        this.nMd.axg();
                        int e = this.nMd.bBh();
                        String f = this.nMd.bBi();
                        ak.vy().a(429, this.nMd);
                        ak.vy().a(new z(f, this.nMd.cZU, e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, ((z) kVar4).Fw(), SQLiteDatabase.KeyEmpty), 0);
                    }
                });
                return;
            } else {
                this.nFq.a(0, ((z) kVar).Fv(), ((z) kVar).Fw(), SQLiteDatabase.KeyEmpty);
                return;
            }
        }
        if (!k(i, i2, str)) {
            if (i == 8) {
                this.nLX = getString(2131232874, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, this.nLX, 0).show();
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(2131232915, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean k(int i, int i2, String str) {
        if (this.nJo.a(this, new p(i, i2, str))) {
            return true;
        }
        if (com.tencent.mm.plugin.a.a.drq.a(this.nDR.nEl, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -100:
                String O;
                ak.hold();
                Context context = this.nDR.nEl;
                if (TextUtils.isEmpty(ak.uA())) {
                    O = com.tencent.mm.bd.a.O(this.nDR.nEl, 2131233716);
                } else {
                    O = ak.uA();
                }
                g.a(context, O, this.nDR.nEl.getString(2131231164), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return true;
            case -75:
                g.f(this, 2131230895, 2131234378);
                return true;
            case -48:
                com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this, null, null);
                } else {
                    g.A(this, getString(2131234473), SQLiteDatabase.KeyEmpty);
                }
                return true;
            case -10:
            case -7:
                g.f(this, 2131234377, 2131234378);
                return true;
            default:
                return false;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    private void aKM() {
        axg();
        if (bBe()) {
            g.a((Context) this, getString(2131234468), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RegSetInfoUI nMd;

                {
                    this.nMd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.mi("R200_100");
                    Intent intent = new Intent(this.nMd, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 2);
                    intent.addFlags(67108864);
                    this.nMd.startActivity(intent);
                    this.nMd.finish();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RegSetInfoUI nMd;

                {
                    this.nMd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (!bBf()) {
            if ((this.hGO == 0 ? 1 : null) != null) {
                g.a((Context) this, getString(2131234467), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.mi("R400_100_signup");
                        Intent intent = new Intent(this.nMd, LoginUI.class);
                        intent.addFlags(67108864);
                        this.nMd.startActivity(intent);
                        this.nMd.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (bBg()) {
                g.a((Context) this, getString(2131234467), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.mi("R500_100");
                        Intent intent = new Intent(this.nMd, RegByEmailUI.class);
                        intent.addFlags(67108864);
                        this.nMd.startActivity(intent);
                        this.nMd.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI nMd;

                    {
                        this.nMd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else {
                b.mi("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
    }
}
