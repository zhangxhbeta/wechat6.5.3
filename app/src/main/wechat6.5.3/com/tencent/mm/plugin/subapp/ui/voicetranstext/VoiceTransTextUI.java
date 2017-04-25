package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.e.a.iq;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class VoiceTransTextUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long bZz;
    private int dOy;
    private int dOz;
    private View eYV = null;
    private ScrollView fzH = null;
    private int iD;
    private long ikd = 0;
    private boolean keA = false;
    private ah keB;
    private a ket;
    private c keu;
    private b kev;
    private com.tencent.mm.modelvoice.b kew;
    private volatile boolean kez = false;
    private View kig = null;
    private View kih = null;
    private LinearLayout kii = null;
    private TextView kij = null;
    private Button kik = null;
    private int kil = 6;
    private boolean kim = false;
    private p kin;
    private be kio;
    private at kip;
    private c kiq;
    private boolean kir = false;
    private boolean kis = false;
    private int kit;
    private OnTouchListener kiu;
    private OnClickListener kiv = new OnClickListener(this) {
        final /* synthetic */ VoiceTransTextUI kiy;

        {
            this.kiy = r1;
        }

        public final void onClick(View view) {
            this.kiy.finish();
        }
    };
    private ClipboardManager kiw;
    private OnLongClickListener kix = new OnLongClickListener(this) {
        final /* synthetic */ VoiceTransTextUI kiy;

        {
            this.kiy = r1;
        }

        public final boolean onLongClick(View view) {
            v.d("MicroMsg.VoiceTransTextUI", "onLongClick");
            g.a(this.kiy, SQLiteDatabase.KeyEmpty, new String[]{this.kiy.getString(2131231015)}, SQLiteDatabase.KeyEmpty, new g.c(this) {
                final /* synthetic */ AnonymousClass2 kiz;

                {
                    this.kiz = r1;
                }

                public final void gT(int i) {
                    if (i == 0 && this.kiz.kiy.kiw != null && this.kiz.kiy.kij != null) {
                        this.kiz.kiy.kiw.setText(this.kiz.kiy.kij.getText());
                    }
                }
            });
            return false;
        }
    };
    private ac mHandler = new ac(this) {
        final /* synthetic */ VoiceTransTextUI kiy;

        {
            this.kiy = r1;
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.kiy.gE(true);
            } else if (i == 2) {
                this.kiy.gE(false);
            }
        }
    };

    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] kiC = new int[a.aZL().length];
        static final /* synthetic */ int[] kiD = new int[b.aZM().length];

        static {
            try {
                kiD[b.kiJ - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kiD[b.kiK - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kiD[b.kiL - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                kiC[a.kiE - 1] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                kiC[a.kiF - 1] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                kiC[a.kiG - 1] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                kiC[a.kiH - 1] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private enum a {
        ;

        public static int[] aZL() {
            return (int[]) kiI.clone();
        }

        static {
            kiE = 1;
            kiF = 2;
            kiG = 3;
            kiH = 4;
            kiI = new int[]{kiE, kiF, kiG, kiH};
        }
    }

    private enum b {
        ;

        public static int[] aZM() {
            return (int[]) kiM.clone();
        }

        static {
            kiJ = 1;
            kiK = 2;
            kiL = 3;
            kiM = new int[]{kiJ, kiK, kiL};
        }
    }

    static /* synthetic */ void l(VoiceTransTextUI voiceTransTextUI) {
        voiceTransTextUI.dOy = 0;
        voiceTransTextUI.dOz = 0;
        voiceTransTextUI.kir = false;
        voiceTransTextUI.kis = false;
        voiceTransTextUI.mHandler.removeMessages(0);
    }

    public void onCreate(Bundle bundle) {
        int i;
        be beVar = null;
        super.onCreate(bundle);
        this.iD = ViewConfiguration.get(this.nDR.nEl).getScaledTouchSlop();
        this.kiw = (ClipboardManager) getSystemService("clipboard");
        this.eYV = findViewById(2131759677);
        this.kig = findViewById(2131759682);
        this.kih = findViewById(2131759684);
        this.kij = (TextView) findViewById(2131759681);
        this.kik = (Button) findViewById(2131759679);
        this.kii = (LinearLayout) findViewById(2131759678);
        this.fzH = (ScrollView) findViewById(2131756234);
        this.kiu = new OnTouchListener(this) {
            final /* synthetic */ VoiceTransTextUI kiy;

            {
                this.kiy = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.kiy.ikd = com.tencent.mm.sdk.platformtools.be.Nj();
                        this.kiy.dOy = view.getScrollY();
                        this.kiy.dOz = this.kiy.dOy;
                        this.kiy.mHandler.removeMessages(0);
                        if (this.kiy.kir) {
                            this.kiy.kir = false;
                            this.kiy.kis = true;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                    case 4:
                        if (Math.abs(this.kiy.dOz - view.getScrollY()) > this.kiy.iD) {
                            this.kiy.mHandler.sendMessage(this.kiy.mHandler.obtainMessage(0, view));
                        }
                        if ((com.tencent.mm.sdk.platformtools.be.Nj() - this.kiy.ikd) < 800 && Math.abs(this.kiy.dOz - view.getScrollY()) <= this.kiy.iD && !this.kiy.kis) {
                            this.kiy.mHandler.removeMessages(0);
                            VoiceTransTextUI.l(this.kiy);
                            this.kiy.finish();
                        }
                        this.kiy.kis = false;
                        break;
                }
                return false;
            }
        };
        this.kij.setOnLongClickListener(this.kix);
        this.kij.setOnClickListener(this.kiv);
        this.bZz = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.bZz < 0) {
            i = 0;
        } else {
            v.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", Long.valueOf(this.bZz));
            bf LA = m.LA();
            if (this.bZz >= 0) {
                be beVar2 = new be();
                Cursor query = LA.cie.query("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(r6)}, null, null, null);
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    beVar2.b(query);
                }
                query.close();
                beVar = beVar2;
            }
            this.kio = beVar;
            if (this.kio == null || com.tencent.mm.sdk.platformtools.be.kS(this.kio.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (com.tencent.mm.sdk.platformtools.be.kS(string)) {
                    i = 0;
                } else {
                    this.kin = m.Lz().lJ(string);
                    if (this.kin != null) {
                        v.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        i = 1;
                    } else {
                        ak.yW();
                        this.kip = com.tencent.mm.model.c.wJ().ek(this.bZz);
                        if (this.kip != null) {
                            v.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                }
            } else {
                v.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                i = 1;
            }
        }
        if (i == 0) {
            v.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            return;
        }
        ActionBar cV = cU().cV();
        if (cV != null) {
            cV.hide();
        }
        NI();
    }

    protected final int getLayoutId() {
        return 2130904593;
    }

    protected final void NI() {
        Object obj;
        vD(2131235848);
        this.kik.setOnClickListener(this);
        if (this.kio == null || com.tencent.mm.sdk.platformtools.be.kS(this.kio.field_content)) {
            obj = null;
        } else {
            ah(b.kiJ, this.kio.field_content);
            if (!(this.fzH == null || this.kii == null)) {
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ VoiceTransTextUI kiy;

                    {
                        this.kiy = r1;
                    }

                    public final void run() {
                        this.kiy.fzH.setPadding(0, 0, 0, 0);
                        this.kiy.kii.setGravity(17);
                    }
                }, 5);
            }
            obj = 1;
        }
        if (obj == null) {
            ah(b.kiK, null);
            rq(a.kiE);
        }
    }

    private void rq(int i) {
        aZI();
        switch (AnonymousClass9.kiC[i - 1]) {
            case 1:
                v.i("MicroMsg.VoiceTransTextUI", "net check");
                if (pK() > 0) {
                    v.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", Long.valueOf(pK()));
                    this.ket = new a(aZJ(), Wz(), aZK().getFormat(), pK(), getFileName());
                } else {
                    v.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", Long.valueOf(pK()));
                    this.ket = new a(aZJ(), Wz(), getFileName());
                }
                ak.vy().a(this.ket, 0);
                ak.vy().a(this.ket.getType(), (e) this);
                if (this.kiq == null) {
                    if (this.kiq == null) {
                        this.kiq = new c<iq>(this) {
                            final /* synthetic */ VoiceTransTextUI kiy;

                            {
                                this.kiy = r2;
                                this.nhz = iq.class.getName().hashCode();
                            }

                            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                                iq iqVar = (iq) bVar;
                                v.i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
                                if (this.kiy.ket != null && !this.kiy.keA && (iqVar instanceof iq) && iqVar.bjd.bje == this.kiy.ket.kie) {
                                    v.i("MicroMsg.VoiceTransTextUI", SQLiteDatabase.KeyEmpty);
                                    if (this.kiy.kez) {
                                        v.i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                                        this.kiy.kim = true;
                                    } else {
                                        new ac(this.kiy.getMainLooper()).post(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass5 kiA;

                                            {
                                                this.kiA = r1;
                                            }

                                            public final void run() {
                                                v.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
                                                if (this.kiA.kiy.keB != null) {
                                                    this.kiA.kiy.keB.QI();
                                                }
                                                this.kiA.kiy.rq(a.kiH);
                                            }
                                        });
                                    }
                                }
                                return false;
                            }
                        };
                    }
                    com.tencent.mm.sdk.c.a.nhr.e(this.kiq);
                    return;
                }
                return;
            case 2:
                v.i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.ket == null) {
                    v.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    return;
                } else if (aZK() == null) {
                    v.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
                    return;
                } else {
                    this.keu = new c(aZJ(), this.ket.kic, aZK().getFormat(), getFileName());
                    ak.vy().a(this.keu, 0);
                    ak.vy().a(this.keu.getType(), (e) this);
                    return;
                }
            case 3:
                v.i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.keu == null) {
                    v.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    return;
                }
                this.keu = new c(this.keu);
                ak.vy().a(this.keu, 0);
                ak.vy().a(this.keu.getType(), (e) this);
                return;
            case 4:
                this.kim = false;
                if (this.kez) {
                    v.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                    return;
                }
                v.i("MicroMsg.VoiceTransTextUI", "net get");
                if (this.ket == null) {
                    v.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                    return;
                }
                this.kez = true;
                this.kev = new b(aZJ());
                ak.vy().a(this.kev, 0);
                ak.vy().a(this.kev.getType(), (e) this);
                return;
            default:
                return;
        }
    }

    private void ah(int i, String str) {
        while (true) {
            switch (AnonymousClass9.kiD[i - 1]) {
                case 1:
                    if (!com.tencent.mm.sdk.platformtools.be.kS(str)) {
                        this.kii.setVisibility(0);
                        this.kig.setVisibility(8);
                        this.kik.setVisibility(4);
                        this.kih.setVisibility(8);
                        this.kij.setText(str);
                        gE(true);
                        break;
                    }
                    i = b.kiL;
                    str = null;
                case 2:
                    this.kii.setVisibility(0);
                    this.kig.setVisibility(0);
                    this.kik.setVisibility(0);
                    if (str != null) {
                        this.kij.setText(str);
                        gE(false);
                        break;
                    }
                    break;
                case 3:
                    this.kii.setVisibility(8);
                    this.kig.setVisibility(8);
                    this.kik.setHeight(0);
                    this.kik.setVisibility(8);
                    this.kih.setVisibility(0);
                    break;
                default:
                    break;
            }
            if (i == b.kiJ || i == b.kiL) {
                this.fzH.setOnTouchListener(this.kiu);
                this.eYV.setOnClickListener(this.kiv);
                return;
            }
            this.fzH.setOnTouchListener(null);
            this.eYV.setOnClickListener(null);
            return;
        }
    }

    private void aZI() {
        v.d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.ket != null) {
            ak.vy().c(this.ket);
            ak.vy().b(this.ket.getType(), (e) this);
        }
        if (this.keu != null) {
            ak.vy().c(this.keu);
            ak.vy().b(this.keu.getType(), (e) this);
        }
        if (this.kev != null) {
            ak.vy().c(this.kev);
            ak.vy().b(this.kev.getType(), (e) this);
        }
    }

    private String aZJ() {
        if (this.kin != null) {
            return this.kin.clientId;
        }
        return this.kip.field_talker + this.kip.field_msgId + "T" + this.kip.field_createTime;
    }

    private int Wz() {
        if (this.kin != null) {
            return this.kin.cyu;
        }
        return o.le(this.kip.field_imgPath);
    }

    private long pK() {
        return this.kin == null ? -1 : this.kin.bmL;
    }

    private String getFileName() {
        if (this.kin != null) {
            return this.kin.aST;
        }
        return this.kip.field_imgPath;
    }

    private com.tencent.mm.modelvoice.b aZK() {
        if (this.kew == null) {
            if (this.kin != null) {
                this.kew = q.lC(this.kin.aST);
            } else if (this.kip != null) {
                this.kew = q.lC(this.kip.field_imgPath);
            } else {
                v.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
        }
        return this.kew;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 546:
                    if (this.ket.mState == a.kia) {
                        v.i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.ket.aZF()) {
                            str2 = this.ket.kib.mZM;
                        }
                        Cy(str2);
                        return;
                    } else if (this.ket.mState == a.khZ) {
                        if (this.ket.kib != null && com.tencent.mm.sdk.platformtools.be.kS(this.ket.kib.mZM)) {
                            ah(b.kiK, this.ket.kib.mZM);
                        }
                        v.i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        rq(a.kiH);
                        return;
                    } else if (this.ket.mState == a.khY) {
                        v.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        rq(a.kiF);
                        return;
                    } else if (this.ket.kid != null) {
                        this.kil = this.ket.kid.mOA;
                        return;
                    } else {
                        return;
                    }
                case 547:
                    if (this.keu.aZH()) {
                        v.i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        rq(a.kiH);
                        return;
                    }
                    v.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", Integer.valueOf(this.keu.kic.mdA), Integer.valueOf(this.keu.kic.mdB));
                    rq(a.kiG);
                    return;
                case 548:
                    this.kil = this.kev.kif;
                    this.kez = false;
                    if (!this.kev.isComplete() && this.kev.aZF()) {
                        ah(b.kiK, this.kev.kib.mZM);
                        v.d("MicroMsg.VoiceTransTextUI", "result valid:%s", this.kev.kib.mZM);
                    } else if (!this.kev.aZF()) {
                        v.d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.kev.isComplete()) {
                        v.i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.kev.aZF()) {
                            str2 = this.kev.kib.mZM;
                        }
                        Cy(str2);
                        return;
                    } else if (this.kim) {
                        v.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        rq(a.kiH);
                        return;
                    } else {
                        v.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", Integer.valueOf(this.kil));
                        final int i3 = this.kil;
                        if (!this.keA) {
                            if (this.keB == null) {
                                this.keB = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                                    final /* synthetic */ VoiceTransTextUI kiy;

                                    public final boolean oU() {
                                        if (!this.kiy.keA) {
                                            v.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", Integer.valueOf(i3));
                                            this.kiy.rq(a.kiH);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            this.keB.ea((long) (i3 * 1000));
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
        this.keA = true;
        ah(b.kiL, null);
    }

    private void Cy(String str) {
        this.keA = true;
        if (!com.tencent.mm.sdk.platformtools.be.kS(str)) {
            bf LA = m.LA();
            be beVar = new be();
            beVar.field_msgId = this.bZz;
            String aZJ = aZJ();
            if (!com.tencent.mm.sdk.platformtools.be.kS(aZJ)) {
                beVar.field_cmsgId = aZJ;
            }
            beVar.field_content = str;
            LA.a(beVar);
        }
        ah(b.kiJ, str);
    }

    protected void onDestroy() {
        aZI();
        if (this.keB != null) {
            this.keB.QI();
        }
        if (this.kiq != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.kiq);
            this.kiq = null;
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        finish();
    }

    private void gE(final boolean z) {
        if (this.fzH != null && this.kii != null) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ VoiceTransTextUI kiy;

                public final void run() {
                    if (this.kiy.fzH.getMeasuredHeight() >= this.kiy.kii.getMeasuredHeight()) {
                        this.kiy.fzH.fullScroll(130);
                        int scrollY = this.kiy.fzH.getScrollY();
                        this.kiy.kit = this.kiy.fzH.getPaddingTop();
                        this.kiy.kit = this.kiy.kit - scrollY;
                        if (z) {
                            this.kiy.fzH.setPadding(0, 0, 0, 0);
                            this.kiy.kik.setVisibility(8);
                            this.kiy.kik.setHeight(0);
                        } else if (this.kiy.kit > 0) {
                            this.kiy.fzH.setPadding(0, this.kiy.kit, 0, 0);
                        }
                    }
                }
            }, 5);
        }
    }
}
