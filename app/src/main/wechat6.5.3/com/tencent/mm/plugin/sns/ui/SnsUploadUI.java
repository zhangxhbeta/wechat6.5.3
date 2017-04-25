package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.af.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.og;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(17)
public class SnsUploadUI extends MMActivity implements LocationWidget.a {
    private SnsAdClick bmB = null;
    private String desc;
    private SnsUploadConfigView jEh;
    private int jGH = 0;
    private boolean jIz = false;
    private SnsEditText jJZ;
    private w jKa = null;
    private LinearLayout jKb;
    private boolean jKd = false;
    private long jKe = 0;
    private AtContactWidget jYi;
    private LocationWidget jYj;
    private RangeWidget jYk;
    private SnsUploadSayFooter jYl;
    private KeyboardLinearLayout jYm;
    private boolean jYn = false;
    private boolean jYo = false;
    private String jYp = null;
    private FrameLayout jYq = null;
    private long jYr = 0;
    private String jhM = "";
    private String jhN = "";
    private int jhO = 0;
    private int jhP = 0;
    private ArrayList<String> jhQ;
    private boolean jhR = false;

    static /* synthetic */ void h(SnsUploadUI snsUploadUI) {
        snsUploadUI.jJZ.requestFocus();
        v.d("MicroMsg.SnsUploadUI", "request fouces");
        if (snsUploadUI.jYl.aYg()) {
            snsUploadUI.jYl.aYh();
        }
        snsUploadUI.nDR.dtW.postInvalidate();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.jJZ != null) {
            bundle.putString("contentdesc", this.jJZ.getText().toString());
        }
        bundle.getString("contentdesc");
        this.jKa.w(bundle);
        super.onSaveInstanceState(bundle);
    }

    protected final boolean aYi() {
        return ak.uz();
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        e.f(this);
        super.onCreate(bundle);
        if (ak.uz()) {
            Fd("");
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
            this.jKd = getIntent().getBooleanExtra("KSnsPostManu", false);
            this.jKe = getIntent().getLongExtra("KTouchCameraTime", 0);
            this.jGH = getIntent().getIntExtra("Ksnsupload_type", 0);
            this.bmB = (SnsAdClick) getIntent().getParcelableExtra("KsnsAdTag");
            this.jIz = getIntent().getBooleanExtra("Kis_take_photo", false);
            this.jYn = getIntent().getBooleanExtra("need_result", false);
            this.jYo = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
            this.jYp = getIntent().getStringExtra("Ksnsupload_canvas_info");
            this.jJZ = (SnsEditText) findViewById(2131759456);
            this.jJZ.setTextSize(1, (u.ds(this.nDR.nEl) * this.jJZ.getTextSize()) / com.tencent.mm.bd.a.getDensity(this.nDR.nEl));
            if (!be.kS(getIntent().getStringExtra("Kdescription"))) {
                this.jJZ.setText(getIntent().getStringExtra("Kdescription"));
            } else if (!(this.jJZ == null || bundle == null)) {
                CharSequence string = bundle.getString("contentdesc");
                if (string != null) {
                    this.jJZ.setText(string);
                }
            }
            if (this.jGH == 8) {
                this.jJZ.setText(getIntent().getStringExtra("Kdescription"));
                this.jJZ.setEnabled(false);
            }
            this.jYm = (KeyboardLinearLayout) findViewById(2131755452);
            this.jYl = (SnsUploadSayFooter) findViewById(2131757964);
            SnsUploadSayFooter snsUploadSayFooter = this.jYl;
            SnsEditText snsEditText = this.jJZ;
            snsUploadSayFooter.jij = snsEditText;
            snsEditText.setOnClickListener(new OnClickListener(snsUploadSayFooter) {
                final /* synthetic */ SnsUploadSayFooter jYh;

                {
                    this.jYh = r1;
                }

                public final void onClick(View view) {
                    if (this.jYh.getVisibility() == 8) {
                        this.jYh.setVisibility(0);
                    }
                    if (this.jYh.aYg()) {
                        this.jYh.SR();
                    }
                }
            });
            snsEditText.setOnEditorActionListener(new OnEditorActionListener(snsUploadSayFooter) {
                final /* synthetic */ SnsUploadSayFooter jYh;

                {
                    this.jYh = r1;
                }

                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return false;
                }
            });
            this.jYl.setVisibility(8);
            this.jYq = (FrameLayout) findViewById(2131759455);
            this.jYq.post(new Runnable(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final void run() {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    this.jYs.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    ad.aSt();
                    p.cv(displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
            });
            this.jJZ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final void onClick(View view) {
                    SnsUploadUI.h(this.jYs);
                }
            });
            this.jJZ.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final boolean onLongClick(View view) {
                    SnsUploadUI.h(this.jYs);
                    return false;
                }
            });
            WrapScollview wrapScollview = (WrapScollview) findViewById(2131757620);
            wrapScollview.dtW = this.jJZ;
            wrapScollview.jZY = false;
            this.jEh = (SnsUploadConfigView) findViewById(2131759512);
            com.tencent.mm.ui.h.a.a aVar = this.jEh;
            aVar.jYc.mjN = -1000.0f;
            aVar.jYc.mjM = -1000.0f;
            if (!aVar.jSz) {
                ak.yW();
                int f = be.f((Integer) c.vf().get(68404, null));
                aVar.jXX = (f & 2) != 0;
                aVar.jXY = (f & 8) != 0;
                if (!b.He()) {
                    aVar.jXY = false;
                }
                if (!k.yf()) {
                    aVar.jXX = false;
                }
            }
            aVar.gx(false);
            aVar.aYc();
            aVar.aYd();
            if (aVar.jXY) {
                aVar.jYd.a(aVar);
            }
            if (this.jGH != 0) {
                SnsUploadConfigView snsUploadConfigView = this.jEh;
                snsUploadConfigView.jXT.setVisibility(8);
                snsUploadConfigView.jXU.setVisibility(8);
                snsUploadConfigView.jXV.setVisibility(8);
            }
            if (this.jGH == 9) {
                this.jEh.jXV.setVisibility(0);
            }
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (this.jYs.jGH == 9) {
                        this.jYs.setResult(0, new Intent());
                        this.jYs.finish();
                    } else {
                        g.a(this.jYs, 2131235573, 0, 2131230903, 2131231010, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass12 jYv;

                            {
                                this.jYv = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (this.jYv.jYs.bmB != null) {
                                    this.jYv.jYs.bmB.gg(10);
                                }
                                this.jYv.jYs.setResult(0, new Intent());
                                this.jYv.jYs.finish();
                            }
                        }, null, 2131689512);
                    }
                    return true;
                }
            });
            a(0, getString(2131231149), new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (!this.jYs.isFinishing() && System.currentTimeMillis() - this.jYs.jYr >= 500) {
                        this.jYs.jYr = System.currentTimeMillis();
                        f.oR(22);
                        com.tencent.mm.ui.tools.a.c yn = com.tencent.mm.ui.tools.a.c.b(this.jYs.jJZ).yn(com.tencent.mm.h.b.sE());
                        yn.oWy = true;
                        yn.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                            final /* synthetic */ AnonymousClass13 jYw;

                            {
                                this.jYw = r1;
                            }

                            public final void qK(String str) {
                                int aYf = this.jYw.jYs.jEh.aYf();
                                ak.yW();
                                c.vf().set(68404, Integer.valueOf(aYf));
                                this.jYw.jYs.desc = this.jYw.jYs.jJZ.getText().toString();
                                int i = this.jYw.jYs.jJZ.jOn;
                                int aYe = this.jYw.jYs.jEh.aYe();
                                int aYf2 = this.jYw.jYs.jEh.aYf();
                                if (this.jYw.jYs.jYn) {
                                    this.jYw.jYs.setResult(-1, new Intent());
                                }
                                if (this.jYw.jYs.jKa instanceof ad) {
                                    ad adVar = (ad) this.jYw.jYs.jKa;
                                    LocationWidget m = this.jYw.jYs.jYj;
                                    agp com_tencent_mm_protocal_c_agp = new agp();
                                    com_tencent_mm_protocal_c_agp.mjN = m.jGU;
                                    com_tencent_mm_protocal_c_agp.mjM = m.hGE;
                                    com_tencent_mm_protocal_c_agp.aJp = m.aJp;
                                    com_tencent_mm_protocal_c_agp.jGV = m.jGV;
                                    adVar.jIE = com_tencent_mm_protocal_c_agp;
                                }
                                if (this.jYw.jYs.jKa instanceof ab) {
                                    this.jYw.jYs.jJZ.setText("");
                                }
                                PInt pInt = new PInt();
                                this.jYw.jYs.jKa.a(aYe, aYf2, this.jYw.jYs.jEh.jYd.oYf, this.jYw.jYs.desc, this.jYw.jYs.jYi.aVp(), this.jYw.jYs.jYj.aVN(), i, this.jYw.jYs.jhR, this.jYw.jYs.jhQ, pInt, this.jYw.jYs.jYp, this.jYw.jYs.jhO, this.jYw.jYs.jhP);
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                                Object[] objArr = new Object[4];
                                objArr[0] = Long.valueOf(this.jYw.jYs.jKe);
                                objArr[1] = Long.valueOf(be.Nh());
                                objArr[2] = Integer.valueOf(this.jYw.jYs.jKd ? 0 : 1);
                                objArr[3] = Integer.valueOf(pInt.value);
                                gVar.h(13303, objArr);
                                String str2 = "MicroMsg.SnsUploadUI";
                                String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                                objArr = new Object[4];
                                objArr[0] = Long.valueOf(this.jYw.jYs.jKe);
                                objArr[1] = Long.valueOf(be.Nh());
                                objArr[2] = Integer.valueOf(this.jYw.jYs.jKd ? 0 : 1);
                                objArr[3] = Integer.valueOf(pInt.value);
                                v.d(str2, str3, objArr);
                                com.tencent.mm.plugin.report.service.g.iuh.Y(10910, "1");
                                if (!be.kS(this.jYw.jYs.jhM)) {
                                    if (this.jYw.jYs.jhR) {
                                        com.tencent.mm.plugin.report.service.g.iuh.h(11455, new Object[]{"", this.jYw.jYs.jhM, Integer.valueOf(-1), Integer.valueOf(-1)});
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.iuh.h(11455, new Object[]{this.jYw.jYs.jhM, "", Integer.valueOf(-1), Integer.valueOf(-1)});
                                    }
                                }
                                if (this.jYw.jYs.bmB != null) {
                                    this.jYw.jYs.bmB.gg(9);
                                }
                                if (this.jYw.jYs.jYo) {
                                    Intent intent = new Intent(this.jYw.jYs, SnsTimeLineUI.class);
                                    intent.putExtra("sns_resume_state", false);
                                    intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                                    intent.addFlags(67108864);
                                    this.jYw.jYs.startActivity(intent);
                                }
                                com.tencent.mm.sdk.c.a.nhr.z(new og());
                            }

                            public final void adq() {
                            }

                            public final void adr() {
                                g.f(this.jYw.jYs, 2131235575, 2131235576);
                            }
                        });
                    }
                    return false;
                }
            }, com.tencent.mm.ui.k.b.nET);
            ((LinearLayout) findViewById(2131759508)).setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    v.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
                    this.jYs.axg();
                    if (!this.jYs.jYl.aYg()) {
                        return false;
                    }
                    this.jYs.jYl.aYh();
                    return true;
                }
            });
            this.jYi = (AtContactWidget) findViewById(2131759511);
            this.jYi.jEh = this.jEh;
            this.jYj = (LocationWidget) findViewById(2131759454);
            this.jYj.jGW = this;
            switch (this.jGH) {
                case 0:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 9:
                case 10:
                case 12:
                case as.CTRL_INDEX /*13*/:
                case an.CTRL_INDEX /*14*/:
                    this.jYk = (RangeWidget) findViewById(2131759510);
                    findViewById(2131759509).setVisibility(8);
                    break;
                case 1:
                case 11:
                    this.jYk = (RangeWidget) findViewById(2131759510);
                    findViewById(2131759509).setVisibility(8);
                    break;
                case 2:
                case 8:
                    this.jYk = (RangeWidget) findViewById(2131759510);
                    findViewById(2131759509).setVisibility(8);
                    this.jYi.setVisibility(8);
                    break;
            }
            this.jYk.jEh = this.jEh;
            axg();
            v.d("MicroMsg.SnsUploadUI", "share type %d, isManuSnsPost:%b", new Object[]{Integer.valueOf(this.jGH), Boolean.valueOf(this.jKd)});
            switch (this.jGH) {
                case 0:
                    this.jKa = new ad(this);
                    break;
                case 1:
                case 11:
                    this.jKa = new x(this);
                    this.jYk.jJs = true;
                    break;
                case 2:
                    this.jKa = new z(this);
                    this.jYk.jJs = true;
                    break;
                case 3:
                    this.jKa = new ae(this, 9);
                    this.jYk.jJs = true;
                    break;
                case 4:
                    this.jKa = new n(this);
                    this.jYk.jJs = true;
                    break;
                case 5:
                    this.jKa = new ae(this, 14);
                    this.jYk.jJs = true;
                    break;
                case 6:
                    this.jKa = new ae(this, 12);
                    this.jYk.jJs = true;
                    break;
                case 7:
                    this.jKa = new ae(this, 13);
                    this.jYk.jJs = true;
                    break;
                case 8:
                    this.jKa = new bb(this);
                    this.jYk.jJs = true;
                    break;
                case 9:
                    ak.yW();
                    CharSequence ah = be.ah((String) c.vf().get(68408, ""), "");
                    ak.yW();
                    int a = be.a((Integer) c.vf().get(7489, Integer.valueOf(0)), 0);
                    if (be.kS(ah)) {
                        z = false;
                    }
                    this.jKa = new ab(this, z);
                    this.jJZ.jOn = a;
                    this.jJZ.append(ah);
                    this.jJZ.addTextChangedListener(new TextWatcher(this) {
                        final /* synthetic */ SnsUploadUI jYs;

                        {
                            this.jYs = r1;
                        }

                        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }

                        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            if (this.jYs.jJZ.getText().toString().trim().length() > 0) {
                                this.jYs.iT(true);
                            } else {
                                this.jYs.iT(false);
                            }
                        }

                        public final void afterTextChanged(Editable editable) {
                        }
                    });
                    break;
                case 10:
                    this.jKa = new l(this);
                    this.jYk.jJs = true;
                    break;
                case 12:
                    this.jKa = new m(this);
                    this.jYk.jJs = true;
                    break;
                case as.CTRL_INDEX /*13*/:
                    this.jKa = new o(this);
                    this.jYk.jJs = true;
                    break;
                case an.CTRL_INDEX /*14*/:
                    this.jKa = new aa(this);
                    break;
            }
            this.jKa.v(bundle);
            this.jKb = (LinearLayout) findViewById(2131759457);
            View aVz = this.jKa.aVz();
            if (aVz != null) {
                this.jKb.addView(aVz);
            } else {
                this.jKb.setVisibility(8);
            }
            if (this.jKa instanceof x) {
                LayoutParams layoutParams = (LayoutParams) aVz.getLayoutParams();
                layoutParams.width = -1;
                aVz.setLayoutParams(layoutParams);
            }
            aYj();
            this.jYm.nBa = new KeyboardLinearLayout.a(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final void mC(int i) {
                    if (i == -3) {
                        v.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
                        new ac().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 jYt;

                            {
                                this.jYt = r1;
                            }

                            public final void run() {
                                SnsUploadSayFooter b = this.jYt.jYs.jYl;
                                b.setVisibility(0);
                                if (b.hhJ != null) {
                                    b.hhJ.setImageResource(2130839241);
                                }
                                this.jYt.jYs.jYl.postInvalidate();
                                this.jYt.jYs.nDR.dtW.postInvalidate();
                            }
                        }, 100);
                        return;
                    }
                    new ac().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 jYt;

                        {
                            this.jYt = r1;
                        }

                        public final void run() {
                            SnsUploadSayFooter b = this.jYt.jYs.jYl;
                            if (!b.aYg()) {
                                b.setVisibility(8);
                            }
                            this.jYt.jYs.jYl.postInvalidate();
                            this.jYt.jYs.nDR.dtW.postInvalidate();
                        }
                    }, 200);
                    v.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
                }
            };
            if (this.jGH == 0) {
                if (!(this.jKa instanceof ad)) {
                    v.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
                } else if (VERSION.SDK_INT < 11) {
                    v.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
                } else {
                    new Runnable(this) {
                        final /* synthetic */ SnsUploadUI jYs;

                        {
                            this.jYs = r1;
                        }

                        public final void run() {
                            OnDragListener anonymousClass1 = new OnDragListener(this) {
                                final /* synthetic */ AnonymousClass7 jYu;

                                {
                                    this.jYu = r1;
                                }

                                public final boolean onDrag(View view, DragEvent dragEvent) {
                                    boolean z;
                                    switch (dragEvent.getAction()) {
                                        case 1:
                                        case 2:
                                        case 4:
                                        case 5:
                                            v.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[]{Integer.valueOf(dragEvent.getAction())});
                                            z = true;
                                            break;
                                        case 3:
                                            v.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
                                            ClipData clipData = dragEvent.getClipData();
                                            if (clipData == null) {
                                                z = true;
                                                break;
                                            }
                                            int itemCount = clipData.getItemCount();
                                            List arrayList = new ArrayList();
                                            for (int i = 0; i < itemCount; i++) {
                                                Item itemAt = clipData.getItemAt(i);
                                                if (itemAt == null) {
                                                    v.e("MicroMsg.SnsUploadUI", "item == null");
                                                } else if (itemAt.getIntent() != null) {
                                                    this.jYu.jYs.startActivity(itemAt.getIntent());
                                                } else if (itemAt.getUri() != null) {
                                                    m mVar = new m(this.jYu.jYs.nDR.nEl, itemAt.getUri());
                                                    if (mVar.fileType != 0 && mVar.filePath != null) {
                                                        switch (mVar.fileType) {
                                                            case 3:
                                                                arrayList.add(mVar.filePath);
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                    }
                                                    v.e("MicroMsg.SnsUploadUI", "get file path failed");
                                                }
                                            }
                                            if (arrayList.size() >= 0) {
                                                ((ad) this.jYu.jYs.jKa).b(arrayList, 0, false);
                                                z = true;
                                                break;
                                            }
                                            v.e("MicroMsg.SnsUploadUI", "no image file available");
                                            return true;
                                            break;
                                        default:
                                            v.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
                                            z = false;
                                            break;
                                    }
                                    return z;
                                }
                            };
                            if (this.jYs.jYq != null) {
                                this.jYs.jYq.setOnDragListener(anonymousClass1);
                            }
                        }
                    }.run();
                }
            }
            e.g(this);
            return;
        }
        v.e("MicroMsg.SnsUploadUI", "onCreate acc not ready finish");
        v.btb();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        SnsUploadSayFooter snsUploadSayFooter = this.jYl;
        int i2 = (snsUploadSayFooter.aYg() || snsUploadSayFooter.getVisibility() == 0) ? 1 : 0;
        if (i2 != 0) {
            this.jYl.aYh();
            return true;
        } else if (this.jGH == 9) {
            setResult(0, new Intent());
            finish();
            return true;
        } else {
            g.a(this, 2131235573, 0, 2131230903, 2131231010, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SnsUploadUI jYs;

                {
                    this.jYs = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.jYs.bmB != null) {
                        this.jYs.bmB.gg(10);
                    }
                    this.jYs.setResult(0, new Intent());
                    this.jYs.finish();
                }
            }, null, 2131689512);
            return true;
        }
    }

    private void aYj() {
        if (this.jKa.aVy()) {
            iT(true);
        } else {
            iT(false);
        }
    }

    protected void onPause() {
        if (this.jGH == 9) {
            String trim = this.jJZ.getText().toString().trim();
            ak.yW();
            c.vf().set(68408, trim);
            if (be.kS(trim)) {
                ak.yW();
                c.vf().set(7489, Integer.valueOf(0));
            } else {
                ak.yW();
                c.vf().set(7489, Integer.valueOf(this.jJZ.jOn));
            }
        }
        super.axg();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.jYl.post(new Runnable(this) {
            final /* synthetic */ SnsUploadUI jYs;

            {
                this.jYs = r1;
            }

            public final void run() {
                j.f(this.jYs);
            }
        });
        if (this.jKa != null && (this.jKa instanceof aa)) {
            aa aaVar = (aa) this.jKa;
            if (aaVar.jHi != null && !be.kS(aaVar.bou)) {
                aaVar.jHi.ag(aaVar.bou, false);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jKa != null) {
            this.jKa.aVA();
        }
        if (this.jYj != null) {
            this.jYj.stop();
        }
        if (this.jYl != null) {
            SnsUploadSayFooter snsUploadSayFooter = this.jYl;
            if (snsUploadSayFooter.hhM != null) {
                snsUploadSayFooter.hhM.ahl();
                snsUploadSayFooter.hhM.destroy();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jJZ != null) {
            this.jJZ.clearFocus();
        }
        if (i2 == -1) {
            if (this.jKa.a(i, intent)) {
                aYj();
            }
            switch (i) {
                case 5:
                    if (intent != null) {
                        this.jYk.a(i, i2, intent, this.jYi);
                        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                        if (intExtra >= 2) {
                            this.jhM = intent.getStringExtra("Klabel_name_list");
                            this.jhN = intent.getStringExtra("Kother_user_name_list");
                            List list;
                            if (be.kS(this.jhM)) {
                                list = null;
                            } else {
                                list = Arrays.asList(this.jhM.split(","));
                            }
                            List list2;
                            if (be.kS(this.jhN)) {
                                list2 = null;
                            } else {
                                list2 = Arrays.asList(this.jhN.split(","));
                            }
                            this.jhQ = new ArrayList();
                            this.jhO = 0;
                            if (r1 != null && r1.size() > 0) {
                                Collection hashSet = new HashSet();
                                for (String vv : r1) {
                                    List<String> vy = com.tencent.mm.pluginsdk.j.a.bmu().vy(com.tencent.mm.pluginsdk.j.a.bmu().vv(vv));
                                    if (vy == null || vy.size() == 0) {
                                        v.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                                        this.jhQ = new ArrayList(hashSet);
                                    } else {
                                        for (String vv2 : vy) {
                                            hashSet.add(vv2);
                                            this.jhO++;
                                            v.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[]{vv2});
                                        }
                                    }
                                }
                                this.jhQ = new ArrayList(hashSet);
                            }
                            if (r1 != null) {
                                int i3 = 0;
                                for (String vv22 : r1) {
                                    int i4;
                                    if (be.kS(vv22)) {
                                        i4 = i3;
                                    } else {
                                        i4 = i3 + 1;
                                    }
                                    i3 = i4;
                                }
                                this.jhO = i3;
                            }
                            this.jhP = 0;
                            if (r2 != null && r2.size() > 0) {
                                for (String vv222 : r2) {
                                    if (!this.jhQ.contains(vv222)) {
                                        this.jhQ.add(vv222);
                                        this.jhP++;
                                    }
                                }
                            }
                            if (intExtra == 2) {
                                this.jhR = false;
                                return;
                            } else {
                                this.jhR = true;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 6:
                    if (intent != null) {
                        this.jYi.G(intent);
                        return;
                    }
                    return;
                case 8:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                        SnsUploadConfigView snsUploadConfigView = this.jEh;
                        if (booleanExtra) {
                            snsUploadConfigView.jXX = true;
                            snsUploadConfigView.gx(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (intent != null) {
                        this.jYj.G(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return 2130904518;
    }

    public final ArrayList<Exif.a> aVP() {
        if (!(this.jKa instanceof ad)) {
            return null;
        }
        ad adVar = (ad) this.jKa;
        ArrayList arrayList = adVar.jIx.jIJ;
        ArrayList<Exif.a> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Exif.a aVar = (Exif.a) adVar.jIA.get((String) it.next());
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    public final boolean aVQ() {
        return this.jIz;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.SnsUploadUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    this.jYj.aVJ();
                    return;
                } else {
                    g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SnsUploadUI jYs;

                        {
                            this.jYs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.jYs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SnsUploadUI jYs;

                        {
                            this.jYs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
