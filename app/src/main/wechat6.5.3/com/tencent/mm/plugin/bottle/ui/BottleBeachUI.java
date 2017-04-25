package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.plugin.bottle.a.h;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.e;
import java.io.Serializable;
import junit.framework.Assert;

@a(1)
public class BottleBeachUI extends MMActivity implements OnClickListener, j.a.a, b, e {
    private p dwg = null;
    private View etH;
    private FrameLayout etI;
    private ThrowBottleUI etJ;
    private PickBottleUI etK;
    private OpenBottleUI etL;
    private BallonImageView etM;
    private LightHouseImageView etN;
    private ImageView etO;
    private MoonImageView etP;
    private ImageView etQ;
    private int etR = 0;
    boolean etS = true;
    private ImageView etT;
    private ImageView etU;
    private ImageView etV;
    private TextView etW;
    private d etX;
    private b etY;
    private boolean etZ = true;

    protected final int getLayoutId() {
        return 2130903186;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!k.xX()) {
            ak.yW();
            c.wG().b(new g(11, 1));
        }
        NI();
        ak.vy().a(v.CTRL_INDEX, this);
        ak.vy().a(new d(), 0);
    }

    protected void onResume() {
        super.onResume();
        XK();
        this.nDR.nDX.postDelayed(new Runnable(this) {
            final /* synthetic */ BottleBeachUI eua;

            {
                this.eua = r1;
            }

            public final void run() {
                if (this.eua.etM != null && this.eua.etR == 0 && this.eua.etZ) {
                    this.eua.XJ();
                }
            }
        }, 1000);
        if (this.etR == 3 && this.etL != null) {
            OpenBottleUI openBottleUI = this.etL;
            if (openBottleUI.aXd != null && openBottleUI.aXd.bwb()) {
                OpenBottleUI.evt.a(openBottleUI);
            }
            openBottleUI.ca(true);
            openBottleUI.evC = be.Nj();
        }
        ak.yW();
        c.wK().a(this);
        u.DG().a(this);
        ak.vy().a(106, this);
    }

    protected void onPause() {
        super.onPause();
        if (this.etR == 1 && this.etJ != null) {
            this.etJ.Yg();
        }
        if (this.etR == 3 && this.etL != null) {
            this.etL.onPause();
        }
        if (ak.uz()) {
            ak.yW();
            c.wK().b(this);
            ak.vy().b(106, this);
        }
        u.DG().b(this);
    }

    public void onDestroy() {
        if (this.etJ != null) {
            ThrowBottleUI throwBottleUI = this.etJ;
            throwBottleUI.ewG = null;
            throwBottleUI.ewJ = null;
            if (throwBottleUI.ewK != null) {
                throwBottleUI.ewK.cancel();
                throwBottleUI.ewK = null;
            }
            if (throwBottleUI.ewL != null) {
                throwBottleUI.ewL.release();
            }
            throwBottleUI.ewL = null;
            throwBottleUI.ewM = null;
            throwBottleUI.evl = null;
            if (throwBottleUI.ewH != null) {
                throwBottleUI.ewH.release();
            }
            this.etJ = null;
        }
        if (this.etK != null) {
            PickBottleUI pickBottleUI = this.etK;
            pickBottleUI.handler.removeCallbacks(pickBottleUI.evK);
            pickBottleUI.handler.removeCallbacks(pickBottleUI.evL);
            pickBottleUI.evl = null;
            pickBottleUI.evG = null;
            pickBottleUI.evH = null;
            this.etK = null;
        }
        if (this.etX != null) {
            this.etX.cancel();
            this.etX.context = null;
            this.etX = null;
        }
        if (this.etL != null) {
            OpenBottleUI openBottleUI = this.etL;
            if (openBottleUI.aXd != null && openBottleUI.aXd.bwb()) {
                openBottleUI.XT();
            }
            openBottleUI.evl = null;
            if (openBottleUI.evu != null) {
                openBottleUI.evu.release();
                openBottleUI.evu = null;
            }
            OpenBottleUI.evt = null;
            ak.yW();
            c.wH().b(openBottleUI);
            this.etL = null;
        }
        this.etM = null;
        this.etN = null;
        this.etP = null;
        if (this.etY != null) {
            this.etY.dismiss();
            this.etY = null;
        }
        ak.vy().b(v.CTRL_INDEX, this);
        super.onDestroy();
    }

    protected final int NO() {
        return 1;
    }

    protected final void NI() {
        int i = 8;
        vD(2131231509);
        a(0, 2131230801, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleBeachUI eua;

            {
                this.eua = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.eua, BottlePersonalInfoUI.class);
                intent.putExtra("is_allow_set", false);
                this.eua.startActivity(intent);
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleBeachUI eua;

            {
                this.eua = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eua.axg();
                this.eua.finish();
                return false;
            }
        });
        boolean bui = be.bui();
        if (this.etM == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(2131755643);
            ((FrameLayout) frameLayout.getParent()).removeView(frameLayout);
            ((FrameLayout) getWindow().getDecorView()).addView(frameLayout, 0);
            frameLayout.setBackgroundResource(bui ? 2130837729 : 2130837739);
            frameLayout.setVisibility(0);
            this.etM = (BallonImageView) findViewById(2131755644);
            this.etN = (LightHouseImageView) findViewById(2131755647);
            this.etO = (ImageView) findViewById(2131755645);
            this.etP = (MoonImageView) findViewById(2131755646);
        }
        this.etM.setVisibility(bui ? 0 : 8);
        this.etN.setVisibility(bui ? 8 : 0);
        this.etP.etO = this.etO;
        MoonImageView moonImageView = this.etP;
        if (!bui) {
            i = 0;
        }
        moonImageView.setVisibility(i);
        this.etH = findViewById(2131755648);
        this.etH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BottleBeachUI eua;

            {
                this.eua = r1;
            }

            public final void onClick(View view) {
                this.eua.XJ();
            }
        });
        this.etT = (ImageView) findViewById(2131755649);
        this.etU = (ImageView) findViewById(2131755650);
        this.etV = (ImageView) findViewById(2131755651);
        this.etT.setOnClickListener(this);
        this.etU.setOnClickListener(this);
        this.etV.setOnClickListener(this);
        this.etQ = (ImageView) findViewById(2131755656);
        this.etQ.setOnClickListener(this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        com.tencent.mm.sdk.platformtools.v.d("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (i2 == -2002 && this.etR == 0) {
            iz(2131231508);
            return;
        }
        switch (kVar.getType()) {
            case 106:
                com.tencent.mm.sdk.platformtools.v.i("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (this.dwg != null) {
                    this.dwg.dismiss();
                    this.dwg = null;
                }
                if (!com.tencent.mm.plugin.bottle.a.drq.a(this.nDR.nEl, i, i2, str)) {
                    if (i == 4 && i2 == -4) {
                        com.tencent.mm.ui.base.g.f(this.nDR.nEl, 2131230867, 2131231164);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        ars Jx = ((y) kVar).Jx();
                        String a = m.a(Jx.moM);
                        n.AX().g(a, m.a(Jx.mbY));
                        Intent intent = new Intent();
                        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Jx, 25);
                        if (be.ma(a).length() > 0) {
                            if ((Jx.mFu & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(10298, a + ",25");
                            }
                            com.tencent.mm.plugin.bottle.a.drp.d(intent, this.nDR.nEl);
                            return;
                        }
                        return;
                    } else {
                        Toast.makeText(this.nDR.nEl, this.nDR.nEl.getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                }
                return;
            case v.CTRL_INDEX /*152*/:
                XK();
                return;
            default:
                iy(2131231520);
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            if (this.etR == 3) {
                com.tencent.mm.sdk.platformtools.v.v("MM.UI.BottleUI", "on key dwon");
                AudioManager audioManager = (AudioManager) getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                int streamMaxVolume = audioManager.getStreamMaxVolume(0);
                int streamVolume;
                int i2;
                if (i == 25 && this.etL.XW()) {
                    streamVolume = audioManager.getStreamVolume(0);
                    com.tencent.mm.sdk.platformtools.v.v("MM.UI.BottleUI", "volume current:" + streamVolume + " max:" + streamMaxVolume);
                    i2 = streamMaxVolume / 7;
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    audioManager.setStreamVolume(0, streamVolume - i2, 5);
                    com.tencent.mm.sdk.platformtools.v.v("MM.UI.BottleUI", "volume current:" + streamVolume + " max:" + streamMaxVolume);
                    return true;
                } else if (i == 24 && this.etL.XW()) {
                    streamVolume = audioManager.getStreamVolume(0);
                    com.tencent.mm.sdk.platformtools.v.v("MM.UI.BottleUI", "volume current:" + streamVolume + " max:" + streamMaxVolume);
                    i2 = streamMaxVolume / 7;
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    audioManager.setStreamVolume(0, i2 + streamVolume, 5);
                    com.tencent.mm.sdk.platformtools.v.v("MM.UI.BottleUI", "volume current:" + streamVolume + " max:" + streamMaxVolume);
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        } else if (!this.etS) {
            return true;
        } else {
            if (this.etR == 0) {
                finish();
                return true;
            }
            iA(0);
            return true;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (2131755649 == id) {
            if (com.tencent.mm.plugin.bottle.a.c.Xy() > 0) {
                iA(1);
            } else {
                iz(2131231514);
            }
        } else if (2131755650 == id) {
            if (com.tencent.mm.plugin.bottle.a.c.Xz() > 0) {
                iA(2);
            } else {
                iz(2131231513);
            }
        } else if (2131755651 == id) {
            if (!this.etZ) {
                XJ();
            }
            r0 = new Intent();
            r0.setClass(this, BottleConversationUI.class);
            r0.putExtra("conversation_from", "from_beach");
            startActivity(r0);
        } else if (2131755656 == id) {
            if (this.etR == 3) {
                this.etL.onPause();
                this.etL.XT();
            }
            iA(0);
            g(0, 8, 8, 8);
        } else if (2131755674 == id) {
            String str = ((PickedBottleImageView) view).evv;
            String str2 = ((PickedBottleImageView) view).eto;
            if (str2 != null && str2.length() > 0) {
                iA(0);
                ak.yW();
                com.tencent.mm.storage.u LX = c.wH().LX(str2);
                if (LX == null || ((int) LX.chr) == 0 || !com.tencent.mm.i.a.ei(LX.field_type)) {
                    final y yVar = new y(str2);
                    ak.vy().a(yVar, 0);
                    ActionBarActivity actionBarActivity = this.nDR.nEl;
                    getString(2131231164);
                    this.dwg = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131230873), true, new OnCancelListener(this) {
                        final /* synthetic */ BottleBeachUI eua;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(yVar);
                        }
                    });
                    return;
                }
                r0 = new Intent();
                r0.putExtra("Contact_User", LX.field_username);
                if (LX.bvm()) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10298, LX.field_username + ",25");
                    r0.putExtra("Contact_Scene", 25);
                }
                com.tencent.mm.plugin.bottle.a.drp.d(r0, this.nDR.nEl);
            } else if (str != null) {
                iA(3);
                OpenBottleUI openBottleUI = this.etL;
                if (openBottleUI.evu == null) {
                    openBottleUI.evu = (ThrowBottleAnimUI) openBottleUI.evl.findViewById(2131755655);
                    openBottleUI.evu.ewz = new ThrowBottleAnimUI.a(openBottleUI) {
                        final /* synthetic */ OpenBottleUI evE;

                        {
                            this.evE = r1;
                        }

                        public final void XX() {
                            this.evE.evu.setVisibility(8);
                            this.evE.evl.iA(0);
                        }
                    };
                }
                if (openBottleUI.evm == null) {
                    openBottleUI.evm = (TextView) openBottleUI.findViewById(2131755667);
                    openBottleUI.evn = (LinearLayout) openBottleUI.findViewById(2131755668);
                    openBottleUI.evo = (FrameLayout) openBottleUI.findViewById(2131755669);
                    openBottleUI.evp = (ImageView) openBottleUI.findViewById(2131755670);
                    openBottleUI.evq = (TextView) openBottleUI.findViewById(2131755671);
                    openBottleUI.evr = (TextView) openBottleUI.findViewById(2131755664);
                    openBottleUI.evs = (TextView) openBottleUI.findViewById(2131755665);
                    openBottleUI.evo.setOnClickListener(openBottleUI);
                }
                openBottleUI.evv = str;
                com.tencent.mm.sdk.platformtools.v.d("MM.Bottle_OpenBottleUI", str);
                ak.yW();
                openBottleUI.aXd = c.wJ().MI(str);
                if (openBottleUI.aXd.bwb()) {
                    openBottleUI.evm.setVisibility(8);
                    openBottleUI.evn.setVisibility(0);
                    at atVar = openBottleUI.aXd;
                    boolean z = atVar != null && atVar.bwb();
                    Assert.assertTrue(z);
                    float f = ((float) new com.tencent.mm.modelvoice.n(atVar.field_content).time) / 1000.0f;
                    if (f < 1.0f) {
                        f = 1.0f;
                    }
                    openBottleUI.evo.setMinimumWidth(com.tencent.mm.bd.a.fromDPToPix(openBottleUI.evl, OpenBottleUI.iF((int) (((float) Math.round(f * 10.0f)) / 10.0f))));
                    openBottleUI.evq.setText(openBottleUI.evl.getString(2131232930, new Object[]{Integer.valueOf((int) f)}));
                    OpenBottleUI.evt.a(openBottleUI);
                    if (openBottleUI.aXd != null) {
                        f = q.au(new com.tencent.mm.modelvoice.n(openBottleUI.aXd.field_content).time);
                        FrameLayout frameLayout = openBottleUI.evo;
                        openBottleUI.getResources().getString(2131231546);
                        frameLayout.setContentDescription(String.format("%d", new Object[]{Integer.valueOf((int) f)}));
                    }
                } else {
                    openBottleUI.evm.setVisibility(0);
                    openBottleUI.evn.setVisibility(8);
                    openBottleUI.evm.setText(openBottleUI.aXd.field_content);
                    com.tencent.mm.pluginsdk.ui.d.e.e(openBottleUI.evm, 1);
                }
                openBottleUI.XU();
                if (openBottleUI.evA == null) {
                    openBottleUI.evA = (TextView) openBottleUI.findViewById(2131755666);
                    openBottleUI.evA.setOnClickListener(new OnClickListener(openBottleUI) {
                        final /* synthetic */ OpenBottleUI evE;

                        {
                            this.evE = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            String substring = be.kS(this.evE.evv) ? "" : this.evE.evv.substring(0, this.evE.evv.indexOf(58));
                            String substring2 = be.kS(this.evE.evv) ? "" : this.evE.evv.substring(this.evE.evv.indexOf(58) + 1);
                            intent.putExtra("k_username", substring);
                            Serializable kz = com.tencent.mm.ar.a.kz(this.evE.evv);
                            substring = "";
                            if (kz.size() > 0) {
                                substring = (String) kz.get(0);
                            }
                            kz.clear();
                            kz.add(String.format("<exposecontent><bottleid>%s</bottleid><hellomsg>%s</hellomsg></exposecontent>", new Object[]{substring2, substring}));
                            intent.putExtra("k_outside_expose_proof_item_list", kz);
                            intent.putExtra("showShare", false);
                            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(37)}));
                            com.tencent.mm.ay.c.b(this.evE.evl, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    });
                }
            } else {
                iA(0);
            }
        }
    }

    private void XJ() {
        boolean z = this.etZ;
        iR(z);
        this.etZ = !z;
    }

    private void iy(int i) {
        CharSequence string = i > 0 ? this.nDR.nEl.getString(i) : null;
        if (this.etX == null) {
            this.etX = new d(this);
        }
        this.etX.cancel();
        if (string != null) {
            this.etX.setDuration(0);
            this.etX.setText(string);
            this.etX.show();
        }
    }

    public final void iz(int i) {
        if (this.etY == null) {
            this.etY = new b(this);
        }
        b bVar = this.etY;
        bVar.eux.setText(getString(i));
        this.etY.show();
    }

    public final void iA(int i) {
        this.etR = i;
        iy(0);
        if (this.etZ) {
            XJ();
        }
        switch (i) {
            case 0:
                this.etS = true;
                g(0, 8, 8, 8);
                return;
            case 1:
                g(8, 0, 8, 8);
                return;
            case 2:
                g(8, 8, 0, 8);
                return;
            case 3:
                g(8, 8, 8, 0);
                return;
            default:
                g(8, 8, 8, 8);
                return;
        }
    }

    private void g(int i, int i2, int i3, int i4) {
        com.tencent.mm.sdk.platformtools.v.v("MM.UI.BottleUI", "set frame visible");
        if (this.etI == null) {
            this.etI = (FrameLayout) findViewById(2131755653);
        }
        this.etH.setVisibility(i);
        if (i == 0) {
            XK();
            this.etQ.setVisibility(8);
            axg();
        }
        if (i2 == 0 && this.etJ == null) {
            this.etJ = (ThrowBottleUI) View.inflate(this, 2130903190, null);
            this.etI.addView(this.etJ);
            ThrowBottleUI throwBottleUI = this.etJ;
            throwBottleUI.ewH = new ToneGenerator(1, 60);
            throwBottleUI.ewK = (Vibrator) throwBottleUI.evl.getSystemService("vibrator");
            throwBottleUI.ewN = (ImageView) throwBottleUI.findViewById(2131755679);
            throwBottleUI.ewO = (TextView) throwBottleUI.findViewById(2131755678);
            throwBottleUI.ewO.setVisibility(8);
            throwBottleUI.ewP = (ImageView) throwBottleUI.findViewById(2131755683);
            throwBottleUI.ewQ = (MMEditText) throwBottleUI.findViewById(2131755680);
            throwBottleUI.ewR = throwBottleUI.findViewById(2131755681);
            throwBottleUI.ewU = (ThrowBottleFooter) throwBottleUI.findViewById(2131755684);
            throwBottleUI.evI = (ImageView) throwBottleUI.evl.findViewById(2131755656);
            throwBottleUI.ewT = (ImageButton) throwBottleUI.findViewById(2131755685);
            throwBottleUI.ewT.setOnClickListener(throwBottleUI);
            throwBottleUI.ewS = (Button) throwBottleUI.findViewById(2131755687);
            throwBottleUI.ewS.setOnTouchListener(new OnTouchListener(throwBottleUI) {
                final /* synthetic */ ThrowBottleUI exg;

                {
                    this.exg = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    int i = 2131231540;
                    if (view == this.exg.ewS) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                if (!this.exg.ewV) {
                                    com.tencent.mm.sdk.platformtools.v.i("MM.Bottle.ThrowBottleUI", "summerper checkPermission checkMicrophone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.exg.evl, "android.permission.RECORD_AUDIO", 80, null, null))});
                                    if (com.tencent.mm.pluginsdk.i.a.a(this.exg.evl, "android.permission.RECORD_AUDIO", 80, null, null)) {
                                        ThrowBottleUI throwBottleUI = this.exg;
                                        throwBottleUI.ewV = true;
                                        throwBottleUI.ewS.setBackgroundDrawable(com.tencent.mm.bd.a.a(throwBottleUI.evl, 2130839044));
                                        Button button = throwBottleUI.ewS;
                                        if (throwBottleUI.ewA) {
                                            i = 2131231542;
                                        }
                                        button.setText(i);
                                        if (throwBottleUI.ewA) {
                                            if (!com.tencent.mm.as.u.bj(throwBottleUI.getContext()) && !com.tencent.mm.ah.a.aT(throwBottleUI.evl)) {
                                                ak.yW();
                                                if (!c.isSDCardAvailable()) {
                                                    s.ey(throwBottleUI.evl);
                                                    break;
                                                }
                                                throwBottleUI.exd = true;
                                                com.tencent.mm.sdk.platformtools.v.v("MM.Bottle.ThrowBottleUI", "record start");
                                                if (throwBottleUI.ewG != null) {
                                                    throwBottleUI.ewG.etn = null;
                                                    throwBottleUI.ewG = null;
                                                }
                                                throwBottleUI.ewG = new h.d(throwBottleUI.getContext(), throwBottleUI);
                                                throwBottleUI.exb.ea(100);
                                                throwBottleUI.ewN.setVisibility(0);
                                                throwBottleUI.ewO.setVisibility(0);
                                                throwBottleUI.ewM = (AnimationDrawable) throwBottleUI.ewO.getBackground();
                                                throwBottleUI.ewM.start();
                                                throwBottleUI.ewP.setVisibility(8);
                                                if (throwBottleUI.ewG != null) {
                                                    ab.Ki("keep_app_silent");
                                                    throwBottleUI.ewG.by("_USER_FOR_THROWBOTTLE_");
                                                    throwBottleUI.ewW = false;
                                                    throwBottleUI.exc.ea(200);
                                                    throwBottleUI.ewH.startTone(24);
                                                    throwBottleUI.handler.postDelayed(new Runnable(throwBottleUI) {
                                                        final /* synthetic */ ThrowBottleUI exg;

                                                        {
                                                            this.exg = r1;
                                                        }

                                                        public final void run() {
                                                            this.exg.ewH.stopTone();
                                                        }
                                                    }, 200);
                                                    throwBottleUI.ewK.vibrate(50);
                                                    throwBottleUI.ewG.a(throwBottleUI.exf);
                                                }
                                                throwBottleUI.evl.getWindow().getDecorView().setKeepScreenOn(true);
                                                break;
                                            }
                                            com.tencent.mm.sdk.platformtools.v.d("MM.Bottle.ThrowBottleUI", "voip is running, can't record voice");
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                this.exg.ewV = false;
                                this.exg.ewS.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.exg.evl, 2130839043));
                                Button f = this.exg.ewS;
                                if (this.exg.ewA) {
                                    i = 2131231543;
                                }
                                f.setText(i);
                                if (!this.exg.ewA) {
                                    this.exg.cb(false);
                                    String trim = this.exg.ewQ.getText().toString().trim();
                                    if (trim.length() < 5) {
                                        this.exg.evl.iz(2131231541);
                                        break;
                                    }
                                    this.exg.ewQ.setText("");
                                    h.c cVar = new h.c(trim, this.exg);
                                    this.exg.Yf();
                                } else if (!this.exg.ewW) {
                                    this.exg.Yg();
                                }
                                this.exg.exd = false;
                                break;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            throwBottleUI.setOnClickListener(throwBottleUI);
            if (throwBottleUI.ewX == null) {
                throwBottleUI.ewX = (LayoutParams) throwBottleUI.ewQ.getLayoutParams();
                throwBottleUI.ewZ = throwBottleUI.ewX.topMargin;
            }
            throwBottleUI.ewU.ewD = new ThrowBottleFooter.a(throwBottleUI) {
                final /* synthetic */ ThrowBottleUI exg;

                {
                    this.exg = r1;
                }

                public final void Yd() {
                    if (this.exg.ewY == 0) {
                        this.exg.ewY = this.exg.getHeight();
                    }
                    int[] iArr = new int[]{0, 0};
                    int[] iArr2 = new int[]{0, 0};
                    this.exg.getLocationInWindow(iArr);
                    this.exg.ewU.getLocationInWindow(iArr2);
                    if ((((double) (iArr2[1] - iArr[1])) * 1.0d) / ((double) this.exg.ewY) < 0.5d) {
                        this.exg.ewX.topMargin = this.exg.ewZ;
                        this.exg.ewX.bottomMargin = 0;
                        this.exg.ewR.setVisibility(0);
                        this.exg.requestLayout();
                        return;
                    }
                    this.exg.ewX.topMargin = (this.exg.ewZ * 1) / 6;
                    this.exg.ewX.bottomMargin = this.exg.ewU.getHeight();
                    this.exg.ewR.setVisibility(8);
                    this.exg.requestLayout();
                }
            };
        }
        if (this.etJ != null) {
            this.etJ.setVisibility(i2);
        }
        if (i3 == 0 && this.etK == null) {
            this.etK = (PickBottleUI) View.inflate(this, 2130903189, null);
            this.etI.addView(this.etK);
            this.etK.NI();
        }
        if (this.etK != null) {
            this.etK.setVisibility(i3);
        }
        if (i3 == 0) {
            this.etK.density = com.tencent.mm.bd.a.getDensity(this);
            PickBottleUI pickBottleUI = this.etK;
            pickBottleUI.evH.setVisibility(8);
            pickBottleUI.evG.x(Integer.MAX_VALUE, -1, -1);
            pickBottleUI.evI.setVisibility(8);
            pickBottleUI.evl.etS = false;
            pickBottleUI.handler.postDelayed(pickBottleUI.evK, 1000);
        }
        if (i4 == 0 && this.etL == null) {
            this.etL = (OpenBottleUI) View.inflate(this, 2130903188, null);
            this.etI.addView(this.etL);
            Object obj = this.etL;
            ((Button) obj.findViewById(2131755672)).setOnClickListener(obj);
            ((Button) obj.findViewById(2131755673)).setOnClickListener(obj);
            obj.evB = this;
        }
        if (this.etL != null) {
            this.etL.setVisibility(i4);
        }
    }

    private void XK() {
        if (this.etW == null) {
            this.etW = (TextView) findViewById(2131755652);
            this.etW.setBackgroundResource(com.tencent.mm.ui.tools.s.eN(this.nDR.nEl));
        }
        int XA = com.tencent.mm.plugin.bottle.a.c.XA();
        this.etW.setText(String.valueOf(XA));
        this.etW.setVisibility(XA > 0 ? 0 : 8);
    }

    public final void hO(String str) {
        if (this.etK != null) {
            PickBottleUI pickBottleUI = this.etK;
            if (pickBottleUI.evH != null) {
                PickedBottleImageView pickedBottleImageView = pickBottleUI.evH;
                if (str.equals(pickedBottleImageView.eto)) {
                    pickedBottleImageView.evQ = j.b(pickedBottleImageView.eto, pickedBottleImageView.iconUrl, 2130838793);
                    pickedBottleImageView.update();
                    pickedBottleImageView.invalidate();
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        XK();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.v.i("MM.UI.BottleUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BottleBeachUI eua;

                        {
                            this.eua = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.eua.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
