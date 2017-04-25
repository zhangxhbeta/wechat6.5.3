package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMScrollGridView;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class FacingCreateChatRoomAllInOneUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
            if (z) {
                Location location = new Location(f2, f, (int) d2, i, "", "");
                if (!location.bnO()) {
                    this.hYA.hXQ = location;
                    this.hYA.hXN = true;
                    FacingCreateChatRoomAllInOneUI.e(this.hYA);
                }
            } else {
                this.hYA.hXN = false;
            }
            return false;
        }
    };
    private String cZU;
    private ProgressDialog eZg;
    private boolean esC = false;
    private c hXK;
    private boolean hXL = false;
    private boolean hXM;
    private boolean hXN;
    private boolean hXO;
    private boolean hXP = false;
    private Location hXQ;
    private String hXR;
    private MMPwdInputView hXS;
    private View hXT;
    private ProgressBar hXU;
    private TextView hXV;
    private MMKeyBoardView hXW;
    private TextView hXX;
    private boolean hXY = false;
    private boolean hXZ = false;
    private LinkedList<pt> hYa = new LinkedList();
    private HashMap<String, pt> hYb = new HashMap();
    private LinkedList<pt> hYc = new LinkedList();
    private a hYd;
    private View hYe;
    private TextView hYf;
    private MMScrollGridView hYg;
    private View hYh;
    private View hYi;
    private Button hYj;
    private MMCallBackScrollView hYk;
    private TextView hYl;
    private boolean hYm = false;
    private ad hYn = new ad();
    private ah hYo = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final boolean oU() {
            FacingCreateChatRoomAllInOneUI.a(this.hYA);
            return false;
        }
    }, false);
    private com.tencent.mm.plugin.pwdgroup.a.a hYp;
    private com.tencent.mm.plugin.pwdgroup.a.a hYq;
    private int hYr;
    private Animation hYs;
    private AnimationSet hYt;
    private Animation hYu;
    public OnMenuItemClickListener hYv = new OnMenuItemClickListener(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.hYA.finish();
            return false;
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a hYw = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final void f(boolean z, String str) {
            v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[]{Boolean.valueOf(z), str});
            this.hYA.hXR = str;
            if (z) {
                this.hYA.hXM = true;
                FacingCreateChatRoomAllInOneUI.e(this.hYA);
            }
        }
    };
    private OnClickListener hYx = new OnClickListener(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final void onClick(View view) {
            this.hYA.hXY = false;
            FacingCreateChatRoomAllInOneUI.d(this.hYA);
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a hYy = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final void input(String str) {
            if (this.hYA.hXS == null) {
                return;
            }
            if (this.hYA.hXL || this.hYA.hXP) {
                MMPwdInputView g = this.hYA.hXS;
                g.Kz();
                g.input(str);
                this.hYA.os(a.hYE);
                return;
            }
            this.hYA.hXS.input(str);
        }

        public final void Kz() {
            if (this.hYA.hXS != null) {
                this.hYA.hXS.Kz();
            }
        }

        public final void delete() {
            if (this.hYA.hXS == null) {
                return;
            }
            if (this.hYA.hXL || this.hYA.hXP) {
                this.hYA.hXS.Kz();
                this.hYA.os(a.hYE);
                return;
            }
            MMPwdInputView g = this.hYA.hXS;
            if (g.hZt > 0) {
                g.eTM.deleteCharAt(g.hZt - 1);
            }
            g.aHi();
            g.aHh();
        }
    };
    private ah hYz = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final boolean oU() {
            this.hYA.hXM = false;
            this.hYA.os(a.hYH);
            return true;
        }
    }, false);
    private ac mHandler = new ac(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

        {
            this.hYA = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 10001:
                    if (this.hYA.hYd != null) {
                        this.hYA.hYd.B(this.hYA.hYa);
                        return;
                    }
                    return;
                case 10002:
                    FacingCreateChatRoomAllInOneUI.d(this.hYA);
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] hYD = new int[a.aHg().length];

        static {
            try {
                hYD[a.hYE - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hYD[a.hYF - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hYD[a.hYG - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                hYD[a.hYH - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private enum a {
        ;

        public static int[] aHg() {
            return (int[]) hYI.clone();
        }

        static {
            hYE = 1;
            hYF = 2;
            hYG = 3;
            hYH = 4;
            hYI = new int[]{hYE, hYF, hYG, hYH};
        }
    }

    static /* synthetic */ void a(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        if (facingCreateChatRoomAllInOneUI.esC || facingCreateChatRoomAllInOneUI.hXQ == null) {
            v.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cancel refresh chat room member.");
            return;
        }
        v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryDoSearchScene]-----------");
        facingCreateChatRoomAllInOneUI.hYp = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.hXR, facingCreateChatRoomAllInOneUI.cZU, facingCreateChatRoomAllInOneUI.hXQ.cJq, facingCreateChatRoomAllInOneUI.hXQ.cJr, facingCreateChatRoomAllInOneUI.hXQ.accuracy, facingCreateChatRoomAllInOneUI.hXQ.biJ, facingCreateChatRoomAllInOneUI.hXQ.mac, facingCreateChatRoomAllInOneUI.hXQ.biL);
        ak.vy().a(facingCreateChatRoomAllInOneUI.hYp, 0);
    }

    static /* synthetic */ void d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        facingCreateChatRoomAllInOneUI.getString(2131231164);
        facingCreateChatRoomAllInOneUI.eZg = g.a(facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(2131231182), true, new OnCancelListener(facingCreateChatRoomAllInOneUI) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

            {
                this.hYA = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().cancel(653);
            }
        });
        facingCreateChatRoomAllInOneUI.aHd();
        ak.vy().a(new com.tencent.mm.plugin.pwdgroup.a.a(1, facingCreateChatRoomAllInOneUI.hXR, facingCreateChatRoomAllInOneUI.cZU, facingCreateChatRoomAllInOneUI.hXQ.cJq, facingCreateChatRoomAllInOneUI.hXQ.cJr, facingCreateChatRoomAllInOneUI.hXQ.accuracy, facingCreateChatRoomAllInOneUI.hXQ.biJ, facingCreateChatRoomAllInOneUI.hXQ.mac, facingCreateChatRoomAllInOneUI.hXQ.biL), 0);
    }

    static /* synthetic */ void e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.hYz != null) {
            facingCreateChatRoomAllInOneUI.hYz.QI();
        }
        if (facingCreateChatRoomAllInOneUI.hXN) {
            if (facingCreateChatRoomAllInOneUI.hXM) {
                facingCreateChatRoomAllInOneUI.os(a.hYF);
            }
            if (facingCreateChatRoomAllInOneUI.hXN && facingCreateChatRoomAllInOneUI.hXM && !facingCreateChatRoomAllInOneUI.hXO) {
                v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
                facingCreateChatRoomAllInOneUI.hXO = true;
                facingCreateChatRoomAllInOneUI.hXM = false;
                facingCreateChatRoomAllInOneUI.hYq = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.hXR, "", facingCreateChatRoomAllInOneUI.hXQ.cJq, facingCreateChatRoomAllInOneUI.hXQ.cJr, facingCreateChatRoomAllInOneUI.hXQ.accuracy, facingCreateChatRoomAllInOneUI.hXQ.biJ, facingCreateChatRoomAllInOneUI.hXQ.mac, facingCreateChatRoomAllInOneUI.hXQ.biL);
                ak.vy().a(facingCreateChatRoomAllInOneUI.hYq, 0);
                return;
            }
            return;
        }
        v.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
        facingCreateChatRoomAllInOneUI.os(a.hYF);
        if (facingCreateChatRoomAllInOneUI.hYz != null) {
            facingCreateChatRoomAllInOneUI.hYz.ea(15000);
        }
    }

    protected final int getLayoutId() {
        return 2130903588;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            aHb();
        }
    }

    private void aHb() {
        this.hXK = c.FY();
        this.hXK.a(this.bYl, true);
        ak.vy().a(653, this);
        NI();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    aHb();
                    return;
                } else {
                    g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

                        {
                            this.hYA = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.hYA.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            this.hYA.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

                        {
                            this.hYA = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.hYA.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    protected void onResume() {
        if (this.hXK != null) {
            this.hXK.a(this.bYl, true);
        }
        if (this.hYm) {
            aHc();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.hXK != null) {
            this.hXK.c(this.bYl);
        }
        if (this.hYm) {
            aHd();
        }
        super.onPause();
    }

    protected void onDestroy() {
        ak.vy().b(653, this);
        if (this.hXK != null) {
            this.hXK.c(this.bYl);
        }
        if (!this.hXZ) {
            ak.vy().cancel(653);
            if (this.hXQ != null) {
                this.hYq = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.hXR, "", this.hXQ.cJq, this.hXQ.cJr, this.hXQ.accuracy, this.hXQ.biJ, this.hXQ.mac, this.hXQ.biL);
                ak.vy().a(this.hYq, 0);
            }
        }
        if (this.hYm) {
            aHd();
        }
        super.onDestroy();
    }

    protected final int NO() {
        return 1;
    }

    protected final void NI() {
        vD(2131232786);
        b(this.hYv);
        if (cU().cV() != null) {
            cU().cV().setBackgroundDrawable(getResources().getDrawable(2130838939));
        }
        this.hXT = findViewById(2131756915);
        this.hXU = (ProgressBar) findViewById(2131756916);
        this.hXV = (TextView) findViewById(2131756917);
        this.hXW = (MMKeyBoardView) findViewById(2131756918);
        this.hXX = (TextView) findViewById(2131756907);
        this.hXS = (MMPwdInputView) findViewById(2131756911);
        this.hXS.hZy = this.hYw;
        this.hXS.requestFocus();
        this.hXW.hYy = this.hYy;
        os(a.hYE);
        this.hYe = findViewById(2131756912);
        this.hYf = (TextView) findViewById(2131756913);
        this.hYg = (MMScrollGridView) findViewById(2131756914);
        this.hYg.setVisibility(4);
        this.hYj = (Button) findViewById(2131756920);
        this.hYj.setOnClickListener(this.hYx);
        this.hYh = findViewById(2131756909);
        this.hYi = findViewById(2131756919);
        this.hYf.setText(2131232628);
        this.hYk = (MMCallBackScrollView) findViewById(2131756908);
        this.hYl = (TextView) findViewById(2131756910);
        this.hYk.hYO = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

            {
                this.hYA = r1;
            }

            public final void ba(int i) {
                if (this.hYA.hYi == null) {
                    return;
                }
                if (i == 0) {
                    this.hYA.hYi.setVisibility(4);
                } else {
                    this.hYA.hYi.setVisibility(0);
                }
            }
        };
        this.hYd = new a(this);
        this.hYg.setAdapter(this.hYd);
        this.hYd.B(this.hYa);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 653:
                com.tencent.mm.plugin.pwdgroup.a.a aVar = (com.tencent.mm.plugin.pwdgroup.a.a) kVar;
                int i3 = aVar.hXJ;
                if (i3 == 0) {
                    this.hXO = false;
                    if (this.hYm) {
                        if (this.hYo != null) {
                            this.hYo.ea(3000);
                        }
                        if (i == 0 && i2 == 0) {
                            final LinkedList linkedList = aVar.aHa().mbB;
                            this.hYn.x(new Runnable(this) {
                                final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

                                public final void run() {
                                    int size;
                                    int i;
                                    pt ptVar;
                                    if (this.hYA.hYc != null) {
                                        this.hYA.hYc.clear();
                                    }
                                    if (this.hYA.hYb != null) {
                                        this.hYA.hYb.clear();
                                    }
                                    if (linkedList != null && linkedList.size() > 0) {
                                        size = linkedList.size();
                                        for (i = 0; i < size; i++) {
                                            ptVar = (pt) linkedList.get(i);
                                            if (!be.kS(ptVar.mrE)) {
                                                this.hYA.hYb.put(ptVar.mrE, ptVar);
                                            }
                                        }
                                    }
                                    size = this.hYA.hYa.size();
                                    for (i = 0; i < size; i++) {
                                        ptVar = (pt) this.hYA.hYa.get(i);
                                        if (this.hYA.hYb.containsKey(ptVar.mrE)) {
                                            this.hYA.hYb.remove(ptVar.mrE);
                                        } else {
                                            v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[]{ptVar.mrE});
                                        }
                                    }
                                    if (this.hYA.hYb != null && this.hYA.hYb.size() > 0) {
                                        for (Entry value : this.hYA.hYb.entrySet()) {
                                            this.hYA.hYc.add((pt) value.getValue());
                                            v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[]{ptVar.mrE});
                                        }
                                    }
                                    this.hYA.hYa.addAll(this.hYA.hYc);
                                    this.hYA.mHandler.sendEmptyMessage(10001);
                                }
                            });
                            this.cZU = aVar.aHa().mpB;
                            return;
                        }
                        return;
                    } else if (i == 0 && i2 == 0) {
                        os(a.hYE);
                        this.hYr = this.hXX.getHeight();
                        v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[]{Integer.valueOf(this.hYr)});
                        this.hYs = AnimationUtils.loadAnimation(this, 2130968617);
                        this.hYu = AnimationUtils.loadAnimation(this, 2130968615);
                        this.hYt = new AnimationSet(true);
                        this.hYt.addAnimation(AnimationUtils.loadAnimation(this, 2130968661));
                        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.hYr));
                        translateAnimation.setDuration(300);
                        this.hYt.addAnimation(translateAnimation);
                        this.hYs.setDuration(200);
                        this.hYt.setDuration(300);
                        this.hYu.setDuration(300);
                        this.hYs.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.hYt.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.hYu.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.hYt.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.hYt.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

                            {
                                this.hYA = r1;
                            }

                            public final void onAnimationStart(Animation animation) {
                                this.hYA.hYe.setVisibility(4);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.hYA.hYl.setVisibility(8);
                                this.hYA.hXS.setVisibility(0);
                                this.hYA.hYg.setVisibility(0);
                                this.hYA.hYh.setVisibility(0);
                                this.hYA.hYe.setVisibility(0);
                                this.hYA.hXT.setVisibility(8);
                                this.hYA.hXW.setVisibility(8);
                                this.hYA.hXS.clearAnimation();
                                this.hYA.hYg.clearAnimation();
                                this.hYA.hYe.clearAnimation();
                            }
                        });
                        this.hXS.setVisibility(4);
                        this.hXS.setAnimation(translateAnimation);
                        this.hXW.startAnimation(this.hYs);
                        this.hXT.startAnimation(this.hYs);
                        this.hXX.startAnimation(this.hYs);
                        this.hYh.startAnimation(this.hYu);
                        this.hYe.startAnimation(this.hYt);
                        this.hYh.setVisibility(4);
                        this.hXW.setVisibility(8);
                        this.hXX.setVisibility(8);
                        this.hYm = true;
                        aHc();
                        return;
                    } else if (i2 == -431) {
                        this.hXL = true;
                        os(a.hYG);
                        return;
                    } else {
                        this.hXL = true;
                        os(a.hYH);
                        return;
                    }
                } else if (i3 == 3) {
                    if (i != 0 || i2 != 0) {
                        if (i2 == -431) {
                            os(a.hYG);
                            this.hXL = true;
                            return;
                        }
                        os(a.hYH);
                        return;
                    }
                    return;
                } else if (i3 != 1) {
                    avM();
                    return;
                } else if (i == 0 && i2 == 0) {
                    avM();
                    v.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[]{aVar.aHa().moN});
                    this.hXZ = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", r0);
                    com.tencent.mm.plugin.pwdgroup.a.drp.e(intent, this);
                    return;
                } else if (i2 == -432 && !this.hXY) {
                    this.hXY = true;
                    this.mHandler.sendEmptyMessageDelayed(10002, 3000);
                    return;
                } else if (i2 == -23) {
                    avM();
                    rI(getString(2131232630));
                    if (this.hYo != null) {
                        this.hYo.ea(3000);
                        return;
                    }
                    return;
                } else {
                    avM();
                    com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null) {
                        dm.a(this.nDR.nEl, null, null);
                    } else {
                        rI(getString(2131234294));
                    }
                    if (this.hYo != null) {
                        this.hYo.ea(3000);
                        return;
                    }
                    return;
                }
            default:
                v.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void eP(boolean z) {
        if (this.hXW != null) {
            this.hXW.eQ(z);
        }
    }

    private void os(int i) {
        if (this.hXV != null) {
            switch (AnonymousClass10.hYD[i - 1]) {
                case 1:
                    eP(true);
                    this.hXL = false;
                    this.hXP = false;
                    this.hXU.setVisibility(8);
                    this.hXV.setVisibility(8);
                    return;
                case 2:
                    eP(false);
                    this.hXV.setText(2131234295);
                    this.hXU.setVisibility(0);
                    this.hXV.setVisibility(8);
                    return;
                case 3:
                    eP(true);
                    this.hXU.setVisibility(8);
                    this.hXV.setVisibility(0);
                    this.hXV.setText(2131234292);
                    aHe();
                    return;
                case 4:
                    eP(true);
                    this.hXU.setVisibility(8);
                    this.hXV.setVisibility(0);
                    this.hXV.setText(2131234294);
                    aHe();
                    return;
                default:
                    v.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    return;
            }
        }
    }

    private void avM() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }

    private void rI(String str) {
        g.a(this, str, "", getString(2131231107), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

            {
                this.hYA = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void aHc() {
        this.esC = false;
        if (this.hYo != null) {
            this.hYo.ea(0);
        }
    }

    private void aHd() {
        this.esC = true;
        if (this.hYo != null) {
            this.hYo.QI();
        }
        ak.vy().c(this.hYp);
    }

    private void aHe() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130968587);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, 2130968586);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.hYA.hXS.Kz();
                this.hYA.hXS.startAnimation(loadAnimation2);
            }
        });
        loadAnimation2.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI hYA;

            {
                this.hYA = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (this.hYA.hXW != null) {
                    this.hYA.hXW.eQ(true);
                }
            }
        });
        if (this.hXS != null) {
            this.hXS.startAnimation(loadAnimation);
        }
        if (this.hXW != null) {
            this.hXW.eQ(false);
        }
    }
}
