package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.e.a.mm;
import com.tencent.mm.e.a.mo;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.b.e;
import com.tencent.mm.plugin.scanner.b.h;
import com.tencent.mm.plugin.scanner.b.j;
import com.tencent.mm.plugin.scanner.b.q;
import com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.d.d;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.widget.f;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@a(3)
public class BaseScanUI extends MMActivity implements AutoFocusCallback, PreviewCallback, SurfaceTextureListener, b {
    private int aZl = 0;
    private final Object cCN = new Object();
    private boolean hEj = false;
    private boolean ijq = true;
    private SelectScanModePanel ixA;
    private ScanMaskView ixB = null;
    private boolean ixC = false;
    private boolean ixD = false;
    private boolean ixE = true;
    private i.a ixF;
    private int ixG;
    private int ixH;
    private int ixI;
    private int ixJ;
    private boolean ixK = true;
    private Rect ixL = new Rect();
    private TextView ixM;
    private View ixN;
    private boolean ixO = false;
    private boolean ixP = true;
    private boolean ixQ = false;
    private boolean ixR = false;
    private e ixS = null;
    private TranslateAnimation ixT;
    private ImageView ixU;
    private i ixV;
    private int ixW = 0;
    private boolean ixX = false;
    private boolean ixY = false;
    private m ixZ = new m.a(this) {
        final /* synthetic */ BaseScanUI iym;

        {
            this.iym = r1;
        }

        public final void cI(final int i) {
            if (this.iym.ixP) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 iyo;

                    public final void run() {
                        if (ak.vy().BJ() == 6 || ak.vy().BJ() == 4) {
                            if (!this.iyo.iym.ixE) {
                                if (!(this.iyo.iym.ixM == null || this.iyo.iym.ixN == null)) {
                                    this.iyo.iym.ixM.setVisibility(8);
                                    this.iyo.iym.ixN.setVisibility(8);
                                }
                                this.iyo.iym.ixE = true;
                                this.iyo.iym.ixD = false;
                                this.iyo.iym.c(true, 0);
                            } else {
                                return;
                            }
                        } else if (this.iyo.iym.ixE) {
                            if (!(this.iyo.iym.ixM == null || this.iyo.iym.ixN == null)) {
                                this.iyo.iym.ixM.setText(2131234772);
                                this.iyo.iym.ixN.setVisibility(0);
                                this.iyo.iym.ixM.setVisibility(0);
                            }
                            this.iyo.iym.ixE = false;
                            this.iyo.iym.ixD = true;
                            this.iyo.iym.aLk();
                        } else {
                            return;
                        }
                        if (this.iyo.iym.ixV != null) {
                            this.iyo.iym.ixV.aLa();
                        }
                    }
                });
            }
        }
    };
    private long ixp = 1000;
    private final long ixq = 150;
    private MMTextureView ixr;
    private SurfaceTexture ixs;
    private boolean ixt = false;
    private LinearLayout ixu;
    private TextView ixv;
    private FrameLayout ixw;
    private h ixx;
    private boolean ixy = false;
    private Point ixz;
    protected ac iya = new ac(this) {
        final /* synthetic */ BaseScanUI iym;

        {
            this.iym = r1;
        }

        public final void handleMessage(Message message) {
            if (message != null && message.what == 1 && this.iym.ixU != null && this.iym.ixT != null) {
                if (this.iym.ixP && !this.iym.ixE) {
                    return;
                }
                if (this.iym.ixV == null || this.iym.ixV.aLd() <= 0) {
                    v.w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
                    this.iym.aLk();
                    return;
                }
                this.iym.ixU.setVisibility(0);
                this.iym.ixT.setRepeatCount(-1);
                this.iym.ixT.setDuration(2600);
                this.iym.ixU.startAnimation(this.iym.ixT);
            }
        }
    };
    private final int iyb = 2600;
    protected ac iyc = new ac(this) {
        final /* synthetic */ BaseScanUI iym;

        {
            this.iym = r1;
        }

        public final void handleMessage(Message message) {
            if (message == null) {
                v.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
            } else if (this.iym.hEj) {
                v.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", new Object[]{Integer.valueOf(message.what)});
            } else {
                this.iym.hEj = true;
                if (this.iym.ixV != null) {
                    if (this.iym.ixW == message.what) {
                        this.iym.hEj = false;
                        return;
                    }
                    this.iym.ixV.onPause();
                    if (this.iym.ixV.aLb() != null) {
                        this.iym.ixV.aLb().aLM();
                    }
                    this.iym.ixV = null;
                }
                if (!this.iym.ixP || this.iym.ixE) {
                    this.iym.ixD = false;
                } else {
                    this.iym.ixD = true;
                }
                if (!this.iym.rt() || message.what == 1) {
                    if (this.iym.ixx != null) {
                        this.iym.ixx.iDF = message.what;
                    }
                    this.iym.ixW = message.what;
                    switch (message.what) {
                        case 1:
                            if (!this.iym.ixO) {
                                this.iym.vD(2131234752);
                                this.iym.ixV = new p(this.iym, this.iym.ixz, this.iym.aZl, 0);
                                break;
                            }
                            this.iym.vD(2131234751);
                            this.iym.ixV = new p(this.iym, this.iym.ixz, this.iym.aZl, 1);
                            break;
                        case 2:
                            this.iym.Fd(q.cu(q.iEh, this.iym.getString(2131234760)));
                            this.iym.ixV = new k(this.iym, this.iym.ixz);
                            break;
                        case 3:
                            this.iym.vD(2131234749);
                            this.iym.ixV = new o(this.iym, this.iym.ixz);
                            break;
                        case 4:
                            this.iym.vD(2131234752);
                            this.iym.ixV = new p(this.iym, this.iym.ixz, this.iym.aZl, 2);
                            break;
                        case 5:
                            this.iym.vD(2131234753);
                            this.iym.ixV = new q(this.iym, this.iym.ixz);
                            boolean a = com.tencent.mm.pluginsdk.i.a.a(this.iym, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
                            v.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(a), new af()});
                            break;
                        case 8:
                            this.iym.vD(2131234751);
                            this.iym.ixV = new p(this.iym, this.iym.ixz, this.iym.aZl, 1);
                            break;
                    }
                    if (this.iym.ixx != null && this.iym.ixx.isOpen() && this.iym.ixx.iDE) {
                        if (this.iym.ixW == 1 || this.iym.ixW == 8 || this.iym.ixW == 4) {
                            this.iym.ixx.aLV();
                        } else {
                            this.iym.ixx.aLW();
                        }
                    }
                    l.iwj.reset();
                    this.iym.aLj();
                    this.iym.aLr();
                    this.iym.hEj = false;
                    return;
                }
                Toast.makeText(this.iym, 2131234743, 0).show();
                this.iym.ixA.oZ(1);
                this.iym.hEj = false;
            }
        }
    };
    protected ac iyd = new ac(this) {
        final /* synthetic */ BaseScanUI iym;

        {
            this.iym = r1;
        }

        public final void handleMessage(Message message) {
            if (this.iym.ixx != null && this.iym.ixt) {
                this.iym.ixx.a(this.iym);
            }
        }
    };
    private boolean iye = false;
    private boolean iyf = true;
    private c iyg = new c<mo>(this) {
        final /* synthetic */ BaseScanUI iym;

        {
            this.iym = r2;
            this.nhz = mo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            mo moVar = (mo) bVar;
            if (moVar instanceof mo) {
                v.i("MicroMsg.scanner.BaseScanUI", "autoFocusControlEventListener, isAutoFocus: %s", new Object[]{Boolean.valueOf(moVar.bnN.bnO)});
                if (!moVar.bnN.bnO) {
                    this.iym.iyh.removeMessages(0);
                    this.iym.cz(0);
                    this.iym.iye = false;
                    this.iym.iyf = true;
                } else if (!this.iym.iye) {
                    this.iym.iye = true;
                    this.iym.iyd.removeMessages(0);
                    if (!(this.iym.ixW == 3 || this.iym.ixW == 2 || this.iym.ixx == null || !this.iym.ixx.iDE)) {
                        this.iym.iyf = false;
                        this.iym.cA(this.iym.ixp);
                    }
                }
            }
            return false;
        }
    };
    protected ac iyh = new ac(this) {
        final /* synthetic */ BaseScanUI iym;

        {
            this.iym = r1;
        }

        public final void handleMessage(Message message) {
            if (this.iym.ixx != null && this.iym.ixt && !this.iym.ixD && message.what == 0) {
                h k = this.iym.ixx;
                AutoFocusCallback autoFocusCallback = this.iym;
                if (k.cdl != null && k.iDE) {
                    try {
                        k.i(k.iDK);
                        k.cdl.autoFocus(autoFocusCallback);
                    } catch (RuntimeException e) {
                        v.w("MicroMsg.scanner.ScanCamera", "autoFocus() " + e.getMessage());
                    }
                }
            }
        }
    };
    private long iyi = 0;
    protected final int iyj = 0;
    protected final int iyk = 1;
    protected final int iyl = 2;
    private WakeLock wakeLock = null;

    public final /* bridge */ /* synthetic */ Activity aLx() {
        return this.nDR.nEl;
    }

    static /* synthetic */ void g(BaseScanUI baseScanUI) {
        v.d("MicroMsg.scanner.BaseScanUI", "backBtn onClick");
        baseScanUI.ixD = true;
        baseScanUI.aLw();
        baseScanUI.overridePendingTransition(0, 0);
    }

    protected final int getLayoutId() {
        if (rt()) {
            v.d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
            return 2130904291;
        }
        v.d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
        return 2130904290;
    }

    protected final int NO() {
        if (rt()) {
            v.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
            return 0;
        }
        v.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
        return 1;
    }

    public void onCreate(Bundle bundle) {
        this.ixW = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        super.onCreate(bundle);
        k.ed(this);
        if (ak.vy().BJ() == 6 || ak.vy().BJ() == 4) {
            this.ixE = true;
        } else {
            this.ixE = false;
        }
        if (7 == this.ixW || 11 == this.ixW) {
            this.ixP = false;
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.iyg);
        NI();
    }

    protected final void NI() {
        Button button;
        if (rt()) {
            getWindow().setFlags(1024, 1024);
            this.nDR.bAj();
            v.d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
        }
        this.ixN = findViewById(2131758953);
        this.ixM = (TextView) findViewById(2131758954);
        this.ixu = (LinearLayout) findViewById(2131758963);
        this.ixv = (TextView) findViewById(2131758964);
        this.ixw = (FrameLayout) findViewById(2131758952);
        this.ixr = (MMTextureView) findViewById(2131758951);
        this.ixr.setOpaque(false);
        this.ixr.setSurfaceTextureListener(this);
        if (7 == this.ixW || 9 == this.ixW || 10 == this.ixW || 11 == this.ixW) {
            button = (Button) findViewById(2131758965);
            button.setVisibility(0);
            findViewById(2131758957).setVisibility(8);
            findViewById(2131758960).setVisibility(8);
            if (9 == this.ixW || 10 == this.ixW) {
                LayoutParams layoutParams = button.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    button.setLayoutParams(marginLayoutParams);
                }
            }
        } else {
            button = (Button) findViewById(2131758961);
        }
        if (button != null) {
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BaseScanUI iym;

                {
                    this.iym = r1;
                }

                public final void onClick(View view) {
                    BaseScanUI.g(this.iym);
                }
            });
        } else {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BaseScanUI iym;

                {
                    this.iym = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BaseScanUI.g(this.iym);
                    return false;
                }
            });
        }
        this.ixU = (ImageView) findViewById(2131758955);
        this.aZl = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        this.ixA = (SelectScanModePanel) findViewById(2131758956);
        this.ixw.setVisibility(0);
        if (!(7 == this.ixW || 9 == this.ixW || 10 == this.ixW || 11 == this.ixW || !rt())) {
            this.ixW = 1;
            this.ixO = true;
        }
        aLq();
        NY(null);
        if (this.ixW == 2) {
            this.ixV = new k(this, this.ixz);
            aLj();
            Fd(q.cu(q.iEh, getString(2131234760)));
        } else if (this.ixW == 5) {
            this.ixV = new q(this, this.ixz);
            aLj();
            vD(2131234753);
            v.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)), new af()});
        } else if (this.ixW == 3) {
            this.ixV = new o(this, this.ixz);
            aLj();
            vD(2131234749);
        } else if (this.ixW == 4 && !rt()) {
            this.ixV = new p(this, this.ixz, this.aZl, 2);
            ((p) this.ixV).iBC = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            aLj();
            this.ixA.setVisibility(8);
            vD(2131234754);
        } else if (this.ixW == 8) {
            this.ixV = new p(this, this.ixz, this.aZl, 1);
            ((p) this.ixV).iBC = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            aLj();
            this.ixA.setVisibility(8);
            vD(2131234751);
        } else if (7 == this.ixW) {
            boolean z;
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.ixV = new j(this, this.ixz, r0, getWindowManager().getDefaultDisplay().getRotation());
            j jVar = (j) this.ixV;
            if (getIntent() == null || !getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false)) {
                z = false;
            } else {
                z = true;
            }
            jVar.iAS = z;
            aLj();
            vD(2131234744);
            this.ixA.setVisibility(8);
        } else if (9 == this.ixW) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.ixV = new m(this, this.ixz, r0, getWindowManager().getDefaultDisplay().getRotation());
            aLj();
            vD(2131234746);
            this.ixA.setVisibility(8);
        } else if (10 == this.ixW) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.ixV = new l(this, this.ixz, r0, getWindowManager().getDefaultDisplay().getRotation());
            aLj();
            vD(2131234745);
            this.ixA.setVisibility(8);
        } else if (11 == this.ixW) {
            r0 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(r0);
            this.ixV = new n(this, this.ixz, r0, getWindowManager().getDefaultDisplay().getRotation());
            aLj();
            vD(2131234747);
            vE(2131236646);
            this.ixA.setVisibility(8);
        } else {
            this.ixW = 1;
            this.ixV = new p(this, this.ixz, this.aZl, rt() ? 1 : 0);
            ((p) this.ixV).iBC = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
            aLj();
            if (com.tencent.mm.af.b.Hd()) {
                this.ixO = true;
                this.ixA.setVisibility(8);
            } else if (getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false)) {
                this.ixO = false;
                this.ixA.setVisibility(8);
            }
            if (this.ixO) {
                vD(2131234751);
            } else {
                vD(2131234752);
            }
        }
        this.ixK = this.ixV.aLf();
        this.ixU.setBackgroundResource(this.ixK ? 2130838968 : 2130838969);
        int i = this.ixW;
        if (!(7 == this.ixW || 9 == this.ixW || 10 == this.ixW || 11 == this.ixW)) {
            this.ixA.iCw = new SelectScanModePanel.a(this) {
                final /* synthetic */ BaseScanUI iym;

                {
                    this.iym = r1;
                }

                public final void oY(int i) {
                    this.iym.oX(i);
                }
            };
            this.ixA.oZ(i);
        }
        if (this.ixx != null) {
            this.ixx.iDF = this.ixW;
        }
        v.i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", new Object[]{Integer.valueOf(this.aZl), Integer.valueOf(this.ixW)});
    }

    private void aLj() {
        if (this.ixV != null) {
            this.ixw.removeAllViews();
            View.inflate(this, this.ixV.aLc(), this.ixw);
            this.ixV.bX(this.ixw.getChildAt(0));
            this.ixV.aLe();
            if (this.ixt) {
                aLp();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        v.d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
        this.ixD = true;
        aLw();
        overridePendingTransition(0, 0);
        return true;
    }

    protected void onResume() {
        super.onResume();
        if (!this.ixX) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            this.ixX = true;
        }
        if (this.ijq) {
            v.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, null, null))});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, null, null)) {
                aIP();
            } else {
                return;
            }
        }
        this.ixY = false;
        if (!this.ixD) {
            if (this.ixW == 1 || this.ixW == 8 || this.ixW == 4) {
                l.iwj.reset();
                l.iwj.oW(l.iwg);
            }
        }
    }

    private void aIP() {
        boolean z = true;
        if (com.tencent.mm.compatible.e.b.sf()) {
            if (!this.ixP || this.ixE) {
                this.ixD = false;
                c(false, 0);
            } else {
                this.ixD = true;
                aLk();
            }
            this.ixR = false;
            synchronized (this.cCN) {
                v.d("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
                int i = this.ixW;
                if (!(7 == this.ixW || 9 == this.ixW || 10 == this.ixW || 11 == this.ixW)) {
                    z = false;
                }
                this.ixx = new h(this, i, z);
                aLm();
            }
            if (this.ixV != null) {
                if (this.ixV.aLb() != null) {
                    this.ixV.aLb().aLN();
                }
                this.ixV.onResume();
            }
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
                this.wakeLock.acquire();
            }
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
            if (this.ixP) {
                ak.a(this.ixZ);
            }
            if (this.ixS != null) {
                this.ixS.onResume();
                return;
            }
            return;
        }
        g.a(this, getString(2131231160), getString(2131231099), getString(2131231100), true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ BaseScanUI iym;

            {
                this.iym = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.compatible.e.b.ay(this.iym);
                this.iym.finish();
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.scanner.BaseScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    aIP();
                    return;
                }
                this.ijq = false;
                g.a(this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BaseScanUI iym;

                    {
                        this.iym = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iym.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.iym.ijq = true;
                        this.iym.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BaseScanUI iym;

                    {
                        this.iym = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iym.ijq = true;
                        this.iym.finish();
                    }
                });
                return;
            case 64:
                if (iArr[0] != 0) {
                    g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BaseScanUI iym;

                        {
                            this.iym = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.iym.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        v.i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", new Object[]{this.ixV, this.ixS});
        this.ixD = true;
        if (this.ixV != null) {
            this.ixV.onPause();
            if (this.ixV.aLb() != null) {
                this.ixV.aLb().aLM();
            }
        }
        aLn();
        if (this.wakeLock != null && this.wakeLock.isHeld()) {
            this.wakeLock.release();
            this.wakeLock = null;
        }
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
        if (this.ixP) {
            ak.b(this.ixZ);
        }
        if (this.ixS != null) {
            this.ixS.onPause();
        }
        if (this.ixW == 1 || this.ixW == 8 || this.ixW == 4) {
            l.iwj.auO();
        }
        super.onPause();
    }

    protected void onDestroy() {
        v.i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
        if (this.ixB != null) {
            this.ixB.aLG();
        }
        if (this.ixr != null) {
            this.ixr.setSurfaceTextureListener(null);
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.iyg);
        super.onDestroy();
    }

    private void c(boolean z, long j) {
        if (this.ixI >= 0 && this.ixJ > 0) {
            if (this.ixV == null || this.ixV.aLg()) {
                if (z) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ixU.getLayoutParams();
                    if (this.ixK) {
                        layoutParams.width = this.ixG;
                        layoutParams.gravity = 1;
                    } else {
                        layoutParams.height = this.ixH;
                        layoutParams.gravity = 48;
                        layoutParams.topMargin = this.ixL.top;
                    }
                    this.ixU.setLayoutParams(layoutParams);
                    this.ixU.invalidate();
                    this.ixU.setVisibility(0);
                    if (this.ixK) {
                        this.ixT = new TranslateAnimation(0.0f, 0.0f, (float) this.ixI, (float) this.ixJ);
                    } else {
                        this.ixT = new TranslateAnimation((float) this.ixI, (float) this.ixJ, 0.0f, 0.0f);
                    }
                }
                this.iya.removeMessages(1);
                if (j <= 0) {
                    this.iya.sendEmptyMessage(1);
                    return;
                }
                aLk();
                this.iya.sendEmptyMessageDelayed(1, j);
            }
        }
    }

    public final void aLk() {
        if (this.ixU != null && this.ixT != null) {
            this.ixU.setVisibility(8);
            this.ixU.clearAnimation();
            this.ixU.setAnimation(null);
        }
    }

    public final void aLl() {
        ao.T(this, 2131234270);
    }

    private void aLm() {
        ad.g(new Runnable(this) {
            final /* synthetic */ BaseScanUI iym;

            {
                this.iym = r1;
            }

            public final void run() {
                try {
                    if (this.iym.ixx == null) {
                        v.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
                    } else if (!this.iym.ixQ) {
                        this.iym.ixR = true;
                    } else if (this.iym.ixs == null) {
                        v.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in openCamera");
                    } else {
                        if (this.iym.ixx.isOpen()) {
                            v.d("MicroMsg.scanner.BaseScanUI", "camera already open");
                        } else {
                            synchronized (this.iym.cCN) {
                                h k = this.iym.ixx;
                                SurfaceTexture m = this.iym.ixs;
                                if (k.iDE) {
                                    v.w("MicroMsg.scanner.ScanCamera", "in open(), previewing");
                                    k.release();
                                }
                                int rs = com.tencent.mm.compatible.d.c.rs();
                                long Nj = be.Nj();
                                com.tencent.mm.compatible.d.c.a.a b = com.tencent.mm.compatible.d.c.b(k.bij, rs);
                                if (b == null) {
                                    v.e("MicroMsg.scanner.ScanCamera", "in open(), openCameraRes == null");
                                    throw new IOException();
                                }
                                v.d("MicroMsg.scanner.ScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[]{Integer.valueOf(rs), Long.valueOf(be.az(Nj))});
                                k.iDM = b.cdi;
                                k.iDI = b.cdi % 180 != 0;
                                k.cdl = b.cdl;
                                if (k.cdl == null) {
                                    v.e("MicroMsg.scanner.ScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[]{Boolean.valueOf(k.iDI)});
                                    throw new IOException();
                                }
                                k.cdl.setPreviewTexture(m);
                                Parameters parameters = k.cdl.getParameters();
                                Point point = k.iDG;
                                Point point2 = k.iDH;
                                boolean z = 9 == k.iDF || 10 == k.iDF || 7 == k.iDF || 11 == k.iDF;
                                k.iAO = h.a(parameters, point, point2, z);
                                v.d("MicroMsg.scanner.ScanCamera", "getCameraResolution: " + k.iDG + " camera:" + k.iAO);
                                parameters.setPreviewSize(k.iAO.x, k.iAO.y);
                                ak.yW();
                                p.dr(com.tencent.mm.model.c.vg().bxh());
                                z = p.ceJ.cdN == 1 || p.ceJ.cdN == -1;
                                v.i("MicroMsg.scanner.ScanCamera", "isZoom: %s, qrCodeZoom: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(p.ceJ.cdN)});
                                if (k.iDG.x >= 720 && z) {
                                    String str = parameters.get("zoom-supported");
                                    if (str == null || Boolean.parseBoolean(str)) {
                                        rs = 300;
                                        List zoomRatios = parameters.getZoomRatios();
                                        v.i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s", new Object[]{zoomRatios});
                                        if (zoomRatios != null) {
                                            Collections.sort(zoomRatios);
                                            rs = ((Integer) zoomRatios.get(Math.round((float) (zoomRatios.size() / 5)))).intValue();
                                        }
                                        v.i("MicroMsg.scanner.ScanCamera", "tenDesiredZoom: %s", new Object[]{Integer.valueOf(rs)});
                                        String str2 = parameters.get("max-zoom");
                                        if (str2 != null) {
                                            v.d("MicroMsg.scanner.ScanCamera", "maxZoomString: %s", new Object[]{str2});
                                            try {
                                                int i = (int) (10.0d * be.getDouble(str2, 0.0d));
                                                double d = 2.5d;
                                                if (p.ceJ.cdO != -1.0d) {
                                                    d = p.ceJ.cdO;
                                                }
                                                v.i("MicroMsg.scanner.ScanCamera", "tenMaxZoom: %d, divideRatio: %s, zoomLimit: %s", new Object[]{Integer.valueOf(i), Double.valueOf(d), Double.valueOf(((double) i) / d)});
                                                if (((double) rs) > ((double) i) / d) {
                                                    rs = (int) (((double) i) / d);
                                                }
                                            } catch (Exception e) {
                                                v.w("MicroMsg.scanner.ScanCamera", "setZoom error: %s", new Object[]{e.getMessage()});
                                            }
                                        }
                                        v.i("MicroMsg.scanner.ScanCamera", "tenDesiredZoom: %d", new Object[]{Integer.valueOf(rs)});
                                        if (str2 != null) {
                                            k.iDP = String.valueOf(((double) rs) / 10.0d);
                                            parameters.set("zoom", k.iDP);
                                            v.i("MicroMsg.scanner.ScanCamera", "set zoom, value: %s", new Object[]{k.iDP});
                                        }
                                    }
                                }
                                try {
                                    Object obj;
                                    List<Integer> supportedPreviewFormats;
                                    Object obj2;
                                    if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                                        v.i("MicroMsg.scanner.ScanCamera", "camera not support FOCUS_MODE_AUTO");
                                        obj = null;
                                        supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                                        for (Integer intValue : supportedPreviewFormats) {
                                            rs = intValue.intValue();
                                            v.d("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat: " + rs);
                                            if (rs == 17) {
                                                obj2 = 1;
                                                break;
                                            }
                                            obj = rs != 842094169 ? 1 : obj;
                                        }
                                        obj2 = null;
                                        if (obj2 != null) {
                                            parameters.setPreviewFormat(17);
                                        } else if (obj == null) {
                                            v.e("MicroMsg.scanner.ScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                                            parameters.setPreviewFormat(842094169);
                                        } else {
                                            v.e("MicroMsg.scanner.ScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                                            parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                                        }
                                        k.cdl.setParameters(parameters);
                                        v.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                                    } else {
                                        v.i("MicroMsg.scanner.ScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
                                        parameters.setFocusMode("auto");
                                        obj = null;
                                        supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                                        while (r7.hasNext()) {
                                            rs = intValue.intValue();
                                            v.d("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat: " + rs);
                                            if (rs == 17) {
                                                obj2 = 1;
                                                break;
                                            }
                                            if (rs != 842094169) {
                                            }
                                            obj = rs != 842094169 ? 1 : obj;
                                        }
                                        obj2 = null;
                                        if (obj2 != null) {
                                            parameters.setPreviewFormat(17);
                                        } else if (obj == null) {
                                            v.e("MicroMsg.scanner.ScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                                            parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                                        } else {
                                            v.e("MicroMsg.scanner.ScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                                            parameters.setPreviewFormat(842094169);
                                        }
                                        k.cdl.setParameters(parameters);
                                        v.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
                                    }
                                } catch (Exception e2) {
                                    v.e("MicroMsg.scanner.ScanCamera", "set focus mode error: %s", new Object[]{e2.getMessage()});
                                }
                            }
                        }
                        this.iym.ixt = true;
                        this.iym.ixR = false;
                        this.iym.aLp();
                    }
                } catch (Throwable e3) {
                    v.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", new Object[]{e3.toString()});
                    v.a("MicroMsg.scanner.BaseScanUI", e3, "", new Object[0]);
                    this.iym.aLo();
                }
            }
        }, 25);
        ad.g(new Runnable(this) {
            final /* synthetic */ BaseScanUI iym;

            {
                this.iym = r1;
            }

            public final void run() {
                try {
                    if (this.iym.ixx == null) {
                        v.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in startPreview");
                    } else if (!this.iym.ixx.isOpen()) {
                        v.w("MicroMsg.scanner.BaseScanUI", "camera not open");
                    } else if (this.iym.ixs == null) {
                        v.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in startPreview");
                    } else {
                        v.d("MicroMsg.scanner.BaseScanUI", "camera startPreview.");
                        synchronized (this.iym.cCN) {
                            this.iym.ixx.b(this.iym.ixs);
                            v.d("MicroMsg.scanner.BaseScanUI", "camera startPreview. done");
                        }
                        if (this.iym.ixx != null && this.iym.ixx.isOpen() && this.iym.ixx.iDE) {
                            if (this.iym.ixW == 1 || this.iym.ixW == 8 || this.iym.ixW == 4) {
                                this.iym.ixx.aLV();
                            } else {
                                this.iym.ixx.aLW();
                            }
                        }
                        this.iym.cA(0);
                    }
                } catch (Throwable e) {
                    v.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.startPreview(), [%s]", new Object[]{e.toString()});
                    v.a("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
                    this.iym.aLo();
                }
            }
        }, 50);
    }

    private void aLn() {
        this.ixy = true;
        com.tencent.mm.sdk.i.e.a(new Runnable(this) {
            final /* synthetic */ BaseScanUI iym;

            {
                this.iym = r1;
            }

            public final void run() {
                if (this.iym.ixx != null) {
                    synchronized (this.iym.cCN) {
                        if (this.iym.ixy && this.iym.ixx != null) {
                            v.d("MicroMsg.scanner.BaseScanUI", "closeCamera");
                            this.iym.ixx.release();
                            this.iym.ixx = null;
                            this.iym.ixy = false;
                            v.d("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
                        }
                    }
                }
            }
        }, "BaseScanUI_closeCamera");
    }

    private void aLo() {
        if (!this.ixC) {
            this.ixC = true;
            fh(true);
            jv jvVar = new jv();
            jvVar.bky.type = 2;
            com.tencent.mm.sdk.c.a.nhr.z(jvVar);
            if (jvVar.bkz.bkx) {
                v.i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
                this.ixD = true;
                aLn();
                aLw();
                overridePendingTransition(0, 0);
                return;
            }
            com.tencent.mm.ui.base.h a = g.a(this, getString(2131234774), getString(2131231164), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ BaseScanUI iym;

                {
                    this.iym = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iym.ixD = true;
                    this.iym.aLn();
                    this.iym.aLw();
                    this.iym.overridePendingTransition(0, 0);
                }
            });
            if (a == null) {
                v.d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
                return;
            }
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void aLp() {
        try {
            aLq();
            if (this.ixV == null || this.ixV.p(true, rt()) == null) {
                v.d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
            } else if (this.ixx != null) {
                this.ixx.iDH = this.ixz;
                this.ixV.c(this.ixx.iAO);
                h hVar = this.ixx;
                Rect p = this.ixV.p(false, rt());
                int i = this.ixW;
                hVar.iDO = false;
                hVar.iDN = null;
                hVar.iDK = new Rect();
                if (!hVar.iDI || hVar.iDJ) {
                    hVar.iDK.left = (p.left * hVar.iAO.x) / hVar.iDH.x;
                    hVar.iDK.right = (p.right * hVar.iAO.x) / hVar.iDH.x;
                    hVar.iDK.top = (p.top * hVar.iAO.y) / hVar.iDH.y;
                    hVar.iDK.bottom = (p.bottom * hVar.iAO.y) / hVar.iDH.y;
                    if (hVar.iDK.bottom > hVar.iAO.y) {
                        hVar.iDK.bottom = hVar.iAO.y;
                    }
                    if (hVar.iDK.right > hVar.iAO.x) {
                        hVar.iDK.right = hVar.iAO.x;
                    }
                } else {
                    v.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + hVar.iDI + " needLandscape = " + hVar.iDJ);
                    hVar.iDK.top = (p.left * hVar.iAO.y) / hVar.iDH.x;
                    hVar.iDK.bottom = (p.right * hVar.iAO.y) / hVar.iDH.x;
                    hVar.iDK.left = (p.top * hVar.iAO.x) / hVar.iDH.y;
                    hVar.iDK.right = (p.bottom * hVar.iAO.x) / hVar.iDH.y;
                    if (hVar.iDK.bottom > hVar.iAO.y) {
                        hVar.iDK.bottom = hVar.iAO.y;
                    }
                    if (hVar.iDK.right > hVar.iAO.x) {
                        hVar.iDK.right = hVar.iAO.x;
                    }
                }
                if (7 == i || 11 == i) {
                    if (!hVar.iDI || hVar.iDJ) {
                        if ((((double) hVar.iDK.width()) * 1.0d) / ((double) hVar.iDK.height()) < 1.5859999656677246d) {
                            i = (int) (((float) hVar.iDK.width()) / 1.586f);
                            hVar.iDK.top = ((hVar.iDK.top + hVar.iDK.bottom) / 2) - (i / 2);
                            hVar.iDK.bottom = i + hVar.iDK.top;
                        } else {
                            i = (int) (((float) hVar.iDK.height()) * 1.586f);
                            hVar.iDK.left = ((hVar.iDK.left + hVar.iDK.right) / 2) - (i / 2);
                            hVar.iDK.right = i + hVar.iDK.left;
                        }
                    } else if (((float) hVar.iDK.height()) / 1.586f < ((float) hVar.iDK.width())) {
                        i = (int) (((float) hVar.iDK.height()) / 1.586f);
                        hVar.iDK.left = ((hVar.iDK.left + hVar.iDK.right) / 2) - (i / 2);
                        hVar.iDK.right = i + hVar.iDK.left;
                    } else {
                        i = (int) (((float) hVar.iDK.width()) * 1.586f);
                        hVar.iDK.top = ((hVar.iDK.top + hVar.iDK.bottom) / 2) - (i / 2);
                        hVar.iDK.bottom = i + hVar.iDK.top;
                    }
                }
                v.d("MicroMsg.scanner.ScanCamera", "scanDisplayRect.left: %d, scanDisplayRect.top: %d, scanDisplayRect.right: %d, scanDisplayRect.bottom: %d", new Object[]{Integer.valueOf(hVar.iDK.left), Integer.valueOf(hVar.iDK.top), Integer.valueOf(hVar.iDK.right), Integer.valueOf(hVar.iDK.bottom)});
                hVar.i(p);
                hVar.iDO = true;
                Rect rect = hVar.iDK;
                v.d("MicroMsg.scanner.BaseScanUI", "CameraScreenHeightRate() = [%s], CameraScreenWidthRate() = [%s], rect = [%s]", new Object[]{Float.valueOf(this.ixx.aLU()), Float.valueOf(this.ixx.aLT()), rect});
                if (com.tencent.mm.compatible.d.c.rt() || rt()) {
                    v.d("MicroMsg.scanner.BaseScanUI", "landscape needRotate:" + this.ixx.iDI);
                    this.ixG = (int) (((float) rect.width()) * this.ixx.aLT());
                    this.ixH = (int) (((float) rect.height()) * this.ixx.aLU());
                } else {
                    v.d("MicroMsg.scanner.BaseScanUI", "portrait needRotate:" + this.ixx.iDI);
                    if (!this.ixx.iDI || rt()) {
                        this.ixG = (int) (((float) rect.width()) * this.ixx.aLT());
                        this.ixH = (int) (((float) rect.height()) * this.ixx.aLU());
                    } else {
                        this.ixG = (int) (((float) rect.height()) * this.ixx.aLT());
                        this.ixH = (int) (((float) rect.width()) * this.ixx.aLU());
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ixG, this.ixH, 3);
                if (!this.ixx.iDI || rt()) {
                    layoutParams.leftMargin = (int) (((float) rect.left) * this.ixx.aLT());
                    layoutParams.topMargin = (int) (((float) rect.top) * this.ixx.aLU());
                } else {
                    layoutParams.leftMargin = (int) (((float) rect.top) * this.ixx.aLT());
                    layoutParams.topMargin = (int) (((float) rect.left) * this.ixx.aLU());
                }
                v.d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s], needRotate=[%s]", new Object[]{Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(this.ixG), Integer.valueOf(this.ixH), Boolean.valueOf(this.ixx.iDI)});
                if (1 == this.ixW || 4 == this.ixW || 8 == this.ixW) {
                    i = BackwardSupportUtil.b.a(this, 20.0f);
                    rect = new Rect(layoutParams.leftMargin + i, layoutParams.topMargin + i, (layoutParams.leftMargin + this.ixG) - i, ((layoutParams.topMargin + this.ixH) - i) - i);
                } else {
                    rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + this.ixG, layoutParams.topMargin + this.ixH);
                }
                if (this.ixz.x - rect.right < rect.left) {
                    v.w("MicroMsg.scanner.BaseScanUI", "this is a special device");
                    if (this.ixz.x - rect.left > rect.left) {
                        rect.right = this.ixz.x - rect.left;
                    }
                }
                this.ixG = rect.width();
                if (this.ixB != null) {
                    p = this.ixB.iAq;
                    this.ixB.aLG();
                    this.ixB = new ScanMaskView((Context) this, p);
                } else {
                    this.ixB = new ScanMaskView((Context) this, rect);
                }
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                this.ixB.setLayoutParams(layoutParams2);
                this.ixw.removeAllViews();
                View.inflate(this, this.ixV.aLc(), this.ixw);
                this.ixV.bX(this.ixw.getChildAt(0));
                this.ixw.addView(this.ixB, 0, layoutParams2);
                ScanMaskView scanMaskView = this.ixB;
                if (!(rect.left == scanMaskView.iAq.left && rect.right == scanMaskView.iAq.right && rect.top == scanMaskView.iAq.top && rect.bottom == scanMaskView.iAq.bottom)) {
                    scanMaskView.iAx = (float) (rect.left - scanMaskView.iAq.left);
                    scanMaskView.iAy = (float) (rect.right - scanMaskView.iAq.right);
                    scanMaskView.iAz = (float) (rect.top - scanMaskView.iAq.top);
                    scanMaskView.iAA = (float) (rect.bottom - scanMaskView.iAq.bottom);
                    scanMaskView.iAv = new Rect(scanMaskView.iAq.left, scanMaskView.iAq.top, scanMaskView.iAq.right, scanMaskView.iAq.bottom);
                    scanMaskView.iAu = true;
                    scanMaskView.iAC = new ValueAnimator();
                    scanMaskView.iAC.setFloatValues(new float[]{0.0f, 1.0f});
                    scanMaskView.iAC.setDuration(200);
                    scanMaskView.iAC.addUpdateListener(new AnimatorUpdateListener(scanMaskView) {
                        final /* synthetic */ ScanMaskView iAD;

                        {
                            this.iAD = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            this.iAD.iAq.left = this.iAD.iAv.left + ((int) (this.iAD.iAx * floatValue));
                            this.iAD.iAq.right = this.iAD.iAv.right + ((int) (this.iAD.iAy * floatValue));
                            this.iAD.iAq.top = this.iAD.iAv.top + ((int) (this.iAD.iAz * floatValue));
                            this.iAD.iAq.bottom = ((int) (floatValue * this.iAD.iAA)) + this.iAD.iAv.bottom;
                            this.iAD.invalidate();
                        }
                    });
                    scanMaskView.iAC.start();
                }
                this.ixV.g(rect);
                this.ixB.setBackgroundColor(0);
                v.d("MicroMsg.scanner.BaseScanUI", "newRect = %s", new Object[]{rect});
                if (this.ixK) {
                    this.ixI = rect.top;
                    this.ixJ = rect.bottom - BackwardSupportUtil.b.a(this, 8.0f);
                } else {
                    this.ixI = rect.left;
                    this.ixJ = rect.right - BackwardSupportUtil.b.a(this, 8.0f);
                    this.ixL = rect;
                }
                if (!this.ixP || this.ixE) {
                    c(true, 350);
                    if (this.ixx != null && this.ixx.iDE) {
                        cA(0);
                    }
                    if (this.ixM != null && this.ixN != null) {
                        this.ixM.setVisibility(8);
                        this.ixN.setVisibility(8);
                    }
                } else if (this.ixM != null && this.ixN != null) {
                    this.ixM.setText(2131234772);
                    this.ixN.setVisibility(0);
                    this.ixM.setVisibility(0);
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
        }
    }

    public void onStart() {
        super.onStart();
        aLq();
    }

    private void aLq() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.ixz = new Point(rect.width(), rect.height());
        v.d("MicroMsg.scanner.BaseScanUI", "visible rect: %s", new Object[]{this.ixz});
    }

    public final void h(long j, boolean z) {
        v.i("MicroMsg.scanner.BaseScanUI", "startAutoFocusAndTakeShot, autoFocusInterval: %s, setInterval: %s", new Object[]{Long.valueOf(j), Boolean.valueOf(z)});
        if (z && j > 0) {
            this.ixp = j;
        }
        if (!this.ixD && this.ixx != null && this.ixx.iDE) {
            cz(50);
            if (j == 0) {
                cA(30);
            } else {
                cA(this.ixp);
            }
        }
    }

    public final void aLr() {
        if (this.ixx != null && this.ixt && this.ixs != null) {
            try {
                this.ixx.b(this.ixs);
                cz(50);
                cA(0);
            } catch (Throwable e) {
                v.e("MicroMsg.scanner.BaseScanUI", "in setPreviewState");
                v.a("MicroMsg.scanner.BaseScanUI", e, "", new Object[0]);
            }
            c(false, 150);
        }
    }

    public final void oX(int i) {
        this.iyc.removeMessages(0);
        this.iyc.sendEmptyMessageDelayed(i, 50);
    }

    public final void cz(long j) {
        v.i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", new Object[]{Long.valueOf(j)});
        this.iyd.removeMessages(0);
        if (this.ixD) {
            v.w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
        } else {
            this.iyd.sendEmptyMessageDelayed(0, j);
        }
    }

    public final void cA(long j) {
        v.i("MicroMsg.scanner.BaseScanUI", "autoFocusDelay: %s", new Object[]{Long.valueOf(j)});
        this.iyh.removeMessages(0);
        if (j == 0) {
            this.iyh.sendEmptyMessageDelayed(0, 100);
            this.iyi = System.currentTimeMillis();
            return;
        }
        boolean z = this.ixx.iDE;
        if (System.currentTimeMillis() - this.iyi < this.ixp) {
            v.d("MicroMsg.scanner.BaseScanUI", "autoFocusDelay sendEmptyMessageDelayed [%s]", new Object[]{Long.valueOf(this.ixp - (System.currentTimeMillis() - this.iyi))});
            this.iyh.sendEmptyMessageDelayed(0, this.ixp - (System.currentTimeMillis() - this.iyi));
            return;
        }
        v.d("MicroMsg.scanner.BaseScanUI", "autoFocusDelay sendEmptyMessageDelayed [%s].", new Object[]{Long.valueOf(j)});
        this.iyh.sendEmptyMessageDelayed(0, j);
        this.iyi = System.currentTimeMillis();
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        String str = "MicroMsg.scanner.BaseScanUI";
        String str2 = "onPreviewFrame, data==null: %s, camera: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr == null);
        objArr[1] = camera;
        v.i(str, str2, objArr);
        if (this.ixD || this.ixV == null || this.ixV.aLb() == null || this.ixV.p(false, rt()) == null) {
            v.w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", new Object[]{Boolean.valueOf(this.ixD)});
        } else if (bArr == null || bArr.length <= 0) {
            str = "MicroMsg.scanner.BaseScanUI";
            str2 = "onPreviewFrame, wrong data, data is null [%s]";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            v.e(str, str2, objArr);
            aLo();
        } else if (this.ixx == null) {
            v.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
        } else if (!this.ixV.oZ() && this.iyf && !this.ixD) {
            com.tencent.mm.plugin.scanner.b.b aLb = this.ixV.aLb();
            Point point = this.ixx.iAO;
            int i = this.ixx.iDM;
            h hVar = this.ixx;
            Rect fk = this.ixV.fk(rt());
            int i2 = this.ixW;
            if (hVar.iDL == null) {
                hVar.iDO = false;
                hVar.iDN = null;
                hVar.iDL = new Rect();
                if (!hVar.iDI || hVar.iDJ) {
                    hVar.iDL.left = (fk.left * hVar.iAO.x) / hVar.iDH.x;
                    hVar.iDL.right = (fk.right * hVar.iAO.x) / hVar.iDH.x;
                    hVar.iDL.top = (fk.top * hVar.iAO.y) / hVar.iDH.y;
                    hVar.iDL.bottom = (fk.bottom * hVar.iAO.y) / hVar.iDH.y;
                    if (hVar.iDL.bottom > hVar.iAO.y) {
                        hVar.iDL.bottom = hVar.iAO.y;
                    }
                    if (hVar.iDL.right > hVar.iAO.x) {
                        hVar.iDL.right = hVar.iAO.x;
                    }
                } else {
                    v.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + hVar.iDI + " needLandscape = " + hVar.iDJ);
                    hVar.iDL.top = (fk.left * hVar.iAO.y) / hVar.iDH.x;
                    hVar.iDL.bottom = (fk.right * hVar.iAO.y) / hVar.iDH.x;
                    hVar.iDL.left = (fk.top * hVar.iAO.x) / hVar.iDH.y;
                    hVar.iDL.right = (fk.bottom * hVar.iAO.x) / hVar.iDH.y;
                    if (hVar.iDL.bottom > hVar.iAO.y) {
                        hVar.iDL.bottom = hVar.iAO.y;
                    }
                    if (hVar.iDL.right > hVar.iAO.x) {
                        hVar.iDL.right = hVar.iAO.x;
                    }
                }
                if (7 == i2 || 11 == i2) {
                    if (!hVar.iDI || hVar.iDJ) {
                        if ((((double) hVar.iDL.width()) * 1.0d) / ((double) hVar.iDL.height()) < 1.5859999656677246d) {
                            i2 = (int) (((float) hVar.iDL.width()) / 1.586f);
                            hVar.iDL.top = ((hVar.iDL.top + hVar.iDL.bottom) / 2) - (i2 / 2);
                            hVar.iDL.bottom = i2 + hVar.iDL.top;
                        } else {
                            i2 = (int) (((float) hVar.iDL.height()) * 1.586f);
                            hVar.iDL.left = ((hVar.iDL.left + hVar.iDL.right) / 2) - (i2 / 2);
                            hVar.iDL.right = i2 + hVar.iDL.left;
                        }
                    } else if (((float) hVar.iDL.height()) / 1.586f < ((float) hVar.iDL.width())) {
                        i2 = (int) (((float) hVar.iDL.height()) / 1.586f);
                        hVar.iDL.left = ((hVar.iDL.left + hVar.iDL.right) / 2) - (i2 / 2);
                        hVar.iDL.right = i2 + hVar.iDL.left;
                    } else {
                        i2 = (int) (((float) hVar.iDL.width()) * 1.586f);
                        hVar.iDL.top = ((hVar.iDL.top + hVar.iDL.bottom) / 2) - (i2 / 2);
                        hVar.iDL.bottom = i2 + hVar.iDL.top;
                    }
                }
                v.d("MicroMsg.scanner.ScanCamera", "scanRect.left: %d, scanRect.top: %d, scanRect.right: %d, scanRect.bottom: %d", new Object[]{Integer.valueOf(hVar.iDL.left), Integer.valueOf(hVar.iDL.top), Integer.valueOf(hVar.iDL.right), Integer.valueOf(hVar.iDL.bottom)});
            }
            hVar.i(fk);
            hVar.iDO = true;
            Rect rect = hVar.iDL;
            v.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
            com.tencent.mm.sdk.i.e.b(new com.tencent.mm.plugin.scanner.b.b.AnonymousClass1(aLb, bArr, i, point, rect), "scan_decode", 10);
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        v.i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", new Object[]{Boolean.valueOf(z), camera});
        if (!this.ixD && this.ixV != null && this.ixW != 3 && this.ixW != 2 && this.ixx != null && this.ixx.iDE) {
            this.iyf = true;
            if (this.ixx != null && this.ixt) {
                this.ixx.a(this);
            }
            cA(this.ixp);
        }
    }

    public final void a(i.a aVar) {
        this.ixF = aVar;
    }

    public final void aLs() {
        Intent intent = new Intent();
        intent.putExtra("preview_ui_title", 2131234792);
        com.tencent.mm.pluginsdk.ui.tools.l.a(this, 4660, intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.ixF != null) {
            this.ixF.b(this, i, i2, intent);
        }
    }

    public final void fh(boolean z) {
        this.ixD = z;
        if (z) {
            aLk();
            if (this.ixN != null) {
                this.ixN.setVisibility(0);
                return;
            }
            return;
        }
        h(0, false);
        c(false, 0);
        if (this.ixN != null) {
            this.ixN.setVisibility(8);
        }
    }

    public final void b(int i, final OnClickListener onClickListener) {
        if (this.ixu != null) {
            if (getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
                this.ixu.setVisibility(8);
            } else if (onClickListener != null) {
                this.ixu.setVisibility(i);
                this.ixu.setOnClickListener(onClickListener);
                this.ixv.setBackgroundDrawable(null);
                this.ixv.setText(getString(2131234881));
            }
        } else if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
            if (onClickListener != null) {
                a(0, 2130838681, new OnMenuItemClickListener(this) {
                    final /* synthetic */ BaseScanUI iym;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        f fVar = new f(this.iym.nDR.nEl, f.pbS, false);
                        fVar.jXn = new n.c(this) {
                            final /* synthetic */ AnonymousClass10 iyq;

                            {
                                this.iyq = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                if (!com.tencent.mm.plugin.scanner.b.p.cu(this.iyq.iym)) {
                                    lVar.dg(0, 2131230812);
                                }
                                if (onClickListener != null) {
                                    lVar.dg(1, 2131234880);
                                }
                                if (j.aLX()) {
                                    lVar.dg(2, 2131234756);
                                    v.i("MicroMsg.scanner.BaseScanUI", "show history list");
                                }
                                if (com.tencent.mm.platformtools.q.dqT) {
                                    lVar.d(3, "TestScanner");
                                }
                            }
                        };
                        fVar.jXo = new n.d(this) {
                            final /* synthetic */ AnonymousClass10 iyq;

                            {
                                this.iyq = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        Context context = this.iyq.iym;
                                        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                                        intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(2131232781));
                                        intent.putExtra("duplicate", false);
                                        Parcelable intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                        intent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                                        intent2.addFlags(67108864);
                                        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, 2130839071));
                                        context.sendBroadcast(intent);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(11410, new Object[0]);
                                        Toast.makeText(this.iyq.iym.nDR.nEl, 2131230813, 1).show();
                                        return;
                                    case 1:
                                        if (onClickListener != null) {
                                            onClickListener.onClick(null);
                                            return;
                                        }
                                        return;
                                    case 2:
                                        Intent intent3 = new Intent();
                                        intent3.setClass(this.iyq.iym, ScannerHistoryUI.class);
                                        this.iyq.iym.startActivity(intent3);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(12684, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                                        return;
                                    case 3:
                                        com.tencent.mm.platformtools.q.dqW = 0;
                                        com.tencent.mm.platformtools.q.dqU = true;
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        fVar.bKh();
                        return false;
                    }
                });
            } else {
                vH(0);
            }
        }
    }

    public final boolean aLt() {
        if (this.ixx != null) {
            return this.ixx.iDI;
        }
        v.d("MicroMsg.scanner.BaseScanUI", "scanCamera == null, cameraNeedRotate return false");
        return false;
    }

    public final void aLu() {
        aLw();
    }

    public final void aLv() {
        super.finish();
    }

    private void aLw() {
        mm mmVar = new mm();
        mmVar.bnK.bkU = 1;
        com.tencent.mm.sdk.c.a.nhr.z(mmVar);
        setResult(0);
        finish();
    }

    private boolean rt() {
        return 7 == this.ixW || 9 == this.ixW || 10 == this.ixW || 11 == this.ixW || com.tencent.mm.compatible.d.c.rt();
    }

    public final void a(String str, int i, int i2, int i3, e.a aVar) {
        v.d("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.ixS != null) {
            this.ixS.aLS();
        }
        this.ixY = true;
        this.ixS = new e();
        this.ixS.a(this, str, i, i2, i3, aVar);
        if (this.ixW == 1 || this.ixW == 8 || this.ixW == 4) {
            int i4 = l.iwj.iwo;
            i4 = l.iwg;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        v.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
        this.ixr.bCE();
        this.ixs = surfaceTexture;
        this.ixQ = true;
        if (this.ixR) {
            aLm();
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        v.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
        this.ixs = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        v.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
        this.ixt = false;
        this.ixQ = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
