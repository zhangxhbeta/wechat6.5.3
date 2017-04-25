package com.tencent.mm.ui.account.mobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegByMobileVoiceVerifyUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.l;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileVerifyUI extends MMActivity {
    String aGX;
    protected String bhT;
    int cZg;
    protected ProgressDialog dwR = null;
    String fTP;
    String ivg;
    protected Button kHi;
    private ContentResolver kRR;
    private String[] kRW;
    private Timer kyE;
    SecurityImage nFq = null;
    protected boolean nJV = false;
    private com.tencent.mm.pluginsdk.j.a nJo;
    private int nLq = 30;
    private int nNV;
    protected EditText nNt;
    protected MMFormInputView nOG;
    protected TextView nOH;
    protected TextView nOI;
    protected TextView nOJ;
    protected ScrollView nOK;
    private c nOL;
    private long nOM = 0;
    private boolean nON = false;
    private String nOO;
    private boolean nOP = false;
    Boolean nOQ;
    Boolean nOR;
    protected boolean nOS = false;
    protected boolean nOT = false;
    protected int nOU = -1;
    private b nOV;
    String nOW;
    protected TextView nOf;

    protected enum a {
        ;

        public static int[] bBu() {
            return (int[]) nPh.clone();
        }

        static {
            nPd = 1;
            nPe = 2;
            nPf = 3;
            nPg = 4;
            nPh = new int[]{nPd, nPe, nPf, nPg};
        }
    }

    public interface b {
        void a(MobileVerifyUI mobileVerifyUI);

        void start();

        void stop();

        boolean vX(int i);
    }

    public class c extends ContentObserver {
        private Activity aXH;
        final /* synthetic */ MobileVerifyUI nOX;

        public c(MobileVerifyUI mobileVerifyUI, Activity activity) {
            this.nOX = mobileVerifyUI;
            super(ac.fetchFreeHandler());
            this.aXH = activity;
        }

        public final void onChange(boolean z) {
            super.onChange(z);
            if (this.nOX.nNV != 3 && this.nOX.nNV != 1) {
                v.i("MicroMsg.MobileVerifyUI", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.aXH, "android.permission.READ_SMS", FileUtils.S_IWUSR, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.aXH);
                if (com.tencent.mm.pluginsdk.i.a.a(this.aXH, "android.permission.READ_SMS", FileUtils.S_IWUSR, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                    this.nOX.bBm();
                }
            }
        }
    }

    static /* synthetic */ void d(MobileVerifyUI mobileVerifyUI) {
        mobileVerifyUI.nON = false;
        if (mobileVerifyUI.kyE != null) {
            mobileVerifyUI.kyE.cancel();
        }
    }

    static /* synthetic */ int h(MobileVerifyUI mobileVerifyUI) {
        switch (mobileVerifyUI.nNV) {
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 3;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.model.be.zN();
        this.nOR = Boolean.valueOf(true);
        this.nNV = getIntent().getIntExtra("mobile_verify_purpose", 0);
        this.nOW = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
        this.fTP = getIntent().getStringExtra("kintent_password");
        this.aGX = getIntent().getStringExtra("kintent_nickname");
        this.nOQ = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
        this.nJV = getIntent().getBooleanExtra("from_deep_link", false);
        switch (this.nNV) {
            case 1:
                this.nOV = new g();
                break;
            case 2:
                this.nOV = new i();
                if (this.fTP != null && this.fTP.length() >= 8) {
                    this.cZg = 1;
                    break;
                } else {
                    this.cZg = 4;
                    break;
                }
                break;
            case 3:
                this.nOV = new f();
                break;
            case 4:
                this.nOV = new h();
                break;
            default:
                v.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", Integer.valueOf(this.nNV));
                finish();
                return;
        }
        String string = getString(2131231430);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        Fd(string);
        this.nLq = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.nOS = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.nOT = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.bhT = getIntent().getExtras().getString("bindmcontact_mobile");
        this.ivg = com.tencent.mm.plugin.a.b.Oa();
        NI();
        this.nOV.a(this);
        if (this.nOW != null) {
            this.nNt.setText(this.nOW);
            bfv();
        } else {
            this.nOL = new c(this, this);
            getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.nOL);
        }
        this.nJo = new com.tencent.mm.pluginsdk.j.a();
    }

    public void onDestroy() {
        if (this.nOL != null) {
            getContentResolver().unregisterContentObserver(this.nOL);
            this.nOL = null;
        }
        if (this.nJo != null) {
            this.nJo.close();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        this.nOV.start();
    }

    public void onPause() {
        super.onPause();
        this.nOV.stop();
    }

    protected final int getLayoutId() {
        return 2130904089;
    }

    private void aCo() {
        if (!this.nON) {
            this.kyE = new Timer();
            this.nON = true;
            this.nOM = (long) this.nLq;
            this.kyE.schedule(new TimerTask(this) {
                final /* synthetic */ MobileVerifyUI nOX;

                {
                    this.nOX = r1;
                }

                public final void run() {
                    this.nOX.nOI.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 nOY;

                        {
                            this.nOY = r1;
                        }

                        public final void run() {
                            this.nOY.nOX.nOM = this.nOY.nOX.nOM - 1;
                            if (this.nOY.nOX.nOM >= 0) {
                                this.nOY.nOX.nOI.setText(this.nOY.nOX.getResources().getQuantityString(2131361810, (int) this.nOY.nOX.nOM, new Object[]{Integer.valueOf((int) this.nOY.nOX.nOM)}));
                                return;
                            }
                            this.nOY.nOX.nOI.setVisibility(8);
                            this.nOY.nOX.nOH.setVisibility(0);
                            MobileVerifyUI.d(this.nOY.nOX);
                            this.nOY.nOX.nOH.setEnabled(true);
                            this.nOY.nOX.nOH.setText(this.nOY.nOX.getString(2131233868));
                        }
                    });
                }
            }, 1000, 1000);
        }
    }

    public final void aRG() {
        if (this.nDR.nEB == 1) {
            this.nOK.scrollTo(0, this.nOK.getChildAt(0).getMeasuredHeight() - this.nOK.getMeasuredHeight());
        } else {
            this.nOK.scrollTo(0, 0);
        }
    }

    protected final void NI() {
        v.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.bhT);
        this.nOG = (MMFormInputView) findViewById(2131755621);
        MMFormInputView mMFormInputView = this.nOG;
        if (mMFormInputView.idd != null) {
            mMFormInputView.idd.setImeOptions(5);
        } else {
            v.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
        this.nOG.setInputType(3);
        this.nNt = this.nOG.idd;
        this.nOH = (TextView) findViewById(2131758321);
        this.nOI = (TextView) findViewById(2131758322);
        this.nOf = (TextView) findViewById(2131755619);
        this.nOf.setText(this.bhT);
        this.bhT = al.Kq(this.bhT);
        this.nOH.setText(getString(2131233869));
        this.nOJ = (TextView) findViewById(2131758320);
        this.kHi = (Button) findViewById(2131756365);
        this.nOK = (ScrollView) findViewById(2131755102);
        this.kRW = getResources().getStringArray(2131296295);
        this.nOJ.setText(Html.fromHtml(getString(2131234421)));
        InputFilter[] inputFilterArr = new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ MobileVerifyUI nOX;

            {
                this.nOX = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return be.E(charSequence);
            }
        }};
        this.nOI.setVisibility(0);
        this.nOI.setText(getResources().getQuantityString(2131361810, this.nLq, new Object[]{Integer.valueOf(this.nLq)}));
        aCo();
        this.nOP = false;
        this.nNt.setFilters(inputFilterArr);
        this.nNt.addTextChangedListener(new com.tencent.mm.ui.widget.MMEditText.c(this.nNt, null, 12));
        this.kHi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileVerifyUI nOX;

            {
                this.nOX = r1;
            }

            public final void onClick(View view) {
                this.nOX.bfv();
            }
        });
        this.kHi.setEnabled(false);
        this.nNt.setTextSize(15.0f);
        this.nNt.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MobileVerifyUI nOX;

            {
                this.nOX = r1;
            }

            public final void afterTextChanged(Editable editable) {
                if (be.kS(this.nOX.nNt.getText().toString())) {
                    this.nOX.nNt.setTextSize(15.0f);
                    this.nOX.nNt.setGravity(16);
                } else {
                    this.nOX.nNt.setTextSize(24.0f);
                    this.nOX.nNt.setGravity(16);
                }
                if (this.nOX.nNt.getText() == null || this.nOX.nNt.getText().toString().length() <= 0) {
                    this.nOX.kHi.setEnabled(false);
                } else {
                    this.nOX.kHi.setEnabled(true);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nOH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileVerifyUI nOX;
            private final int nOZ = 0;
            private final int nPa = 1;
            private final int nPb = 2;

            {
                this.nOX = r2;
            }

            public final void onClick(View view) {
                l lVar = new l(this.nOX);
                lVar.jXn = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ AnonymousClass8 nPc;

                    {
                        this.nPc = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.d(0, this.nPc.nOX.getString(2131233869));
                        if (com.tencent.mm.af.b.jn(this.nPc.nOX.bhT)) {
                            lVar.d(1, this.nPc.nOX.getString(2131231455));
                        }
                        if (this.nPc.nOX.nNV == 2 && this.nPc.nOX.nOT) {
                            lVar.d(2, this.nPc.nOX.getString(2131234424));
                        }
                    }
                };
                lVar.jXo = new n.d(this) {
                    final /* synthetic */ AnonymousClass8 nPc;

                    {
                        this.nPc = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                this.nPc.nOX.bBt();
                                return;
                            case 1:
                                this.nPc.nOX.axg();
                                if (this.nPc.nOX.nNV == 2) {
                                    com.tencent.mm.plugin.a.b.mi("R200_500");
                                } else if (this.nPc.nOX.nNV == 1) {
                                    com.tencent.mm.plugin.a.b.mi("L600_400");
                                } else if (this.nPc.nOX.nNV == 3) {
                                    com.tencent.mm.plugin.a.b.mi("F200_300");
                                }
                                Intent intent = new Intent(this.nPc.nOX, RegByMobileVoiceVerifyUI.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("bindmcontact_mobile", this.nPc.nOX.bhT);
                                bundle.putInt("voice_verify_type", MobileVerifyUI.h(this.nPc.nOX));
                                intent.putExtras(bundle);
                                this.nPc.nOX.startActivity(intent);
                                return;
                            default:
                                return;
                        }
                    }
                };
                lVar.aXZ();
            }
        });
        this.nOH.setEnabled(false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileVerifyUI nOX;

            {
                this.nOX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nOX.goBack();
                return true;
            }
        });
        this.nNt.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ MobileVerifyUI nOX;

            {
                this.nOX = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                this.nOX.bfv();
                return true;
            }
        });
        this.nNt.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MobileVerifyUI nOX;

            {
                this.nOX = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.nOX.bfv();
                return true;
            }
        });
    }

    private void bfv() {
        axg();
        if (this.nNt.getText().toString().trim().equals(SQLiteDatabase.KeyEmpty)) {
            g.f(this, 2131231452, 2131231164);
        } else {
            this.nOV.vX(a.nPe);
        }
    }

    private void bBt() {
        this.nOP = false;
        this.nOH.setEnabled(false);
        this.nOI.setVisibility(0);
        this.nOI.setText(getResources().getQuantityString(2131361810, this.nLq, new Object[]{Integer.valueOf(this.nLq)}));
        this.nOH.setVisibility(8);
        aCo();
        this.nOV.vX(a.nPf);
        g.bf(this, getString(2131233850));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.a.b.mi(this.ivg);
        if (!this.nOV.vX(a.nPd)) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("nofification_type");
            v.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", stringExtra);
            if (stringExtra != null && stringExtra.equals("no_reg_notification")) {
                bBt();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean k(int r8, int r9, java.lang.String r10) {
        /*
        r7 = this;
        r3 = 0;
        r2 = 0;
        r1 = 1;
        r0 = com.tencent.mm.f.a.dm(r10);
        if (r0 == 0) goto L_0x000e;
    L_0x0009:
        r0.a(r7, r3, r3);
        r0 = r1;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = 4;
        if (r8 != r0) goto L_0x0014;
    L_0x0011:
        switch(r9) {
            case -75: goto L_0x0032;
            case -1: goto L_0x001c;
            default: goto L_0x0014;
        };
    L_0x0014:
        switch(r9) {
            case -100: goto L_0x008b;
            case -43: goto L_0x0043;
            case -41: goto L_0x004f;
            case -36: goto L_0x005b;
            case -34: goto L_0x0037;
            case -33: goto L_0x007b;
            case -32: goto L_0x0067;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r2;
    L_0x0018:
        if (r0 == 0) goto L_0x00c7;
    L_0x001a:
        r0 = r1;
        goto L_0x000d;
    L_0x001c:
        r0 = com.tencent.mm.model.ak.vy();
        r0 = r0.BJ();
        r2 = 5;
        if (r0 != r2) goto L_0x0032;
    L_0x0027:
        r0 = 2131234021; // 0x7f080ce5 float:1.8084196E38 double:1.052969513E-314;
        r2 = 2131234020; // 0x7f080ce4 float:1.8084194E38 double:1.0529695125E-314;
        com.tencent.mm.ui.base.g.f(r7, r0, r2);
        r0 = r1;
        goto L_0x000d;
    L_0x0032:
        com.tencent.mm.platformtools.l.bl(r7);
        r0 = r1;
        goto L_0x000d;
    L_0x0037:
        r0 = 2131231402; // 0x7f0802aa float:1.8078884E38 double:1.052968219E-314;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0043:
        r0 = 2131231399; // 0x7f0802a7 float:1.8078878E38 double:1.0529682176E-314;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x004f:
        r0 = 2131231401; // 0x7f0802a9 float:1.8078882E38 double:1.0529682186E-314;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x005b:
        r0 = 2131231404; // 0x7f0802ac float:1.8078888E38 double:1.05296822E-314;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0067:
        r0 = 2131231447; // 0x7f0802d7 float:1.8078975E38 double:1.0529682413E-314;
        r0 = r7.getString(r0);
        r3 = "";
        r4 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$12;
        r4.<init>(r7);
        com.tencent.mm.ui.base.g.a(r7, r0, r3, r4);
        r0 = r1;
        goto L_0x0018;
    L_0x007b:
        r0 = 2131231445; // 0x7f0802d5 float:1.8078971E38 double:1.0529682403E-314;
        r3 = 2131231451; // 0x7f0802db float:1.8078983E38 double:1.0529682433E-314;
        r4 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$2;
        r4.<init>(r7);
        com.tencent.mm.ui.base.g.a(r7, r0, r3, r4);
        r0 = r1;
        goto L_0x0018;
    L_0x008b:
        com.tencent.mm.model.ak.hold();
        r0 = r7.nDR;
        r3 = r0.nEl;
        r0 = com.tencent.mm.model.ak.uA();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x00c2;
    L_0x009c:
        r0 = r7.nDR;
        r0 = r0.nEl;
        r4 = 2131233716; // 0x7f080bb4 float:1.8083577E38 double:1.0529693623E-314;
        r0 = com.tencent.mm.bd.a.O(r0, r4);
    L_0x00a7:
        r4 = r7.nDR;
        r4 = r4.nEl;
        r5 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r4 = r4.getString(r5);
        r5 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$3;
        r5.<init>(r7);
        r6 = new com.tencent.mm.ui.account.mobile.MobileVerifyUI$4;
        r6.<init>(r7);
        com.tencent.mm.ui.base.g.a(r3, r0, r4, r5, r6);
        r0 = r1;
        goto L_0x0018;
    L_0x00c2:
        r0 = com.tencent.mm.model.ak.uA();
        goto L_0x00a7;
    L_0x00c7:
        r0 = new com.tencent.mm.pluginsdk.j.p;
        r0.<init>(r8, r9, r10);
        r3 = r7.nJo;
        r0 = r3.a(r7, r0);
        if (r0 == 0) goto L_0x00d7;
    L_0x00d4:
        r0 = r1;
        goto L_0x000d;
    L_0x00d7:
        r0 = r2;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.mobile.MobileVerifyUI.k(int, int, java.lang.String):boolean");
    }

    protected final void je(boolean z) {
        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(2131235066));
        intent.putExtra("kintent_cancelable", z);
        startActivityForResult(intent, 0);
    }

    private void bBm() {
        Exception e;
        Cursor cursor;
        Throwable th;
        String str = null;
        Uri parse = Uri.parse("content://sms/inbox");
        this.kRR = getContentResolver();
        String[] strArr = new String[]{"body", "_id", "date"};
        String str2 = "( ";
        int i = 0;
        while (i < this.kRW.length) {
            str2 = i == this.kRW.length + -1 ? str2 + " body like \"%" + this.kRW[i] + "%\" ) " : str2 + "body like \"%" + this.kRW[i] + "%\" or ";
            i++;
        }
        String str3 = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        v.v("MicroMsg.MobileVerifyUI", "sql where:" + str3);
        if (str3 != null && !str3.equals(SQLiteDatabase.KeyEmpty)) {
            Cursor query;
            try {
                query = this.kRR.query(parse, strArr, str3, null, null);
                if (query != null) {
                    int i2 = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        try {
                            int position;
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                position = query.getPosition();
                            } else {
                                j2 = j;
                                position = i2;
                            }
                            i2 = position;
                            j = j2;
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    this.nOO = null;
                    if (i2 >= 0) {
                        query.moveToPosition(i2);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            str = matcher.group();
                        }
                        this.nOO = str;
                        if (!this.nOP) {
                            this.nOP = true;
                            this.nNt.setText(this.nOO);
                            axg();
                            if (!this.nNt.getText().toString().trim().equals(SQLiteDatabase.KeyEmpty)) {
                                if (this.dwR != null) {
                                    this.dwR.dismiss();
                                    this.dwR = null;
                                }
                                this.nOV.vX(a.nPg);
                            }
                        }
                    }
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                } else if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                try {
                    v.e("MicroMsg.MobileVerifyUI", e.toString());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = cursor;
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                query = null;
                query.close();
                throw th;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.MobileVerifyUI";
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
        v.i("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0) {
                    bBm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
