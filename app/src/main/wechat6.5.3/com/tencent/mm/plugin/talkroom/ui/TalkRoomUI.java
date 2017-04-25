package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.e.a.jr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.plugin.talkroom.model.h;
import com.tencent.mm.pluginsdk.j.y;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI extends MMBaseActivity implements y, e {
    private List<String> bir = new LinkedList();
    private AudioManager diI;
    private TextView dtB;
    private p ePC;
    private boolean gVJ = true;
    private String gVK;
    private String gVL;
    private boolean gVN = false;
    private int gVO = 0;
    private long gVP = 500;
    private long gVQ = 0;
    private ah gVR = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ TalkRoomUI klW;

        {
            this.klW = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
            this.klW.awM();
            return false;
        }
    }, false);
    private ah gVS = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ TalkRoomUI klW;

        {
            this.klW = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
            TalkRoomUI.a(this.klW);
            return false;
        }
    }, false);
    private ah gVT = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ TalkRoomUI klW;

        {
            this.klW = r1;
        }

        public final boolean oU() {
            this.klW.awN();
            return false;
        }
    }, false);
    private final ah gVW = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ TalkRoomUI klW;

        {
            this.klW = r1;
        }

        public final boolean oU() {
            short bap;
            int i = 15;
            int i2 = 0;
            if (this.klW.gVO == 3) {
                bap = b.aZW().bap();
            } else if (be.kS(this.klW.gVL)) {
                this.klW.baw();
                return false;
            } else {
                bap = b.aZW().baq();
            }
            if (bap <= (short) 15) {
                if (!this.klW.klN) {
                    i = 0;
                }
                this.klW.klO = this.klW.klO + 1;
                if (this.klW.klO >= 5) {
                    boolean z;
                    TalkRoomUI talkRoomUI = this.klW;
                    if (this.klW.klN) {
                        z = false;
                    } else {
                        z = true;
                    }
                    talkRoomUI.klN = z;
                    this.klW.klO = 0;
                }
            } else {
                short s = bap;
            }
            this.klW.baw();
            a aVar = this.klW.klK.kmb;
            if (i >= 0) {
                i2 = i > aVar.max ? aVar.max : i;
            }
            aVar.value = i2;
            aVar.kmr = aVar.kmh - ((aVar.kmh - aVar.kmg) * ((((float) aVar.value) * 1.0f) / ((float) aVar.max)));
            return true;
        }
    }, true);
    private boolean gVX = true;
    private float gWS = -1.0f;
    private Chronometer gWc;
    private int gWd = 0;
    private TextView hkq;
    private TextView klG;
    private ImageButton klH;
    private Button klI;
    private ImageView klJ;
    private TalkRoomVolumeMeter klK;
    private TalkRoomAvatarsFrame klL;
    private a klM;
    private boolean klN = true;
    private int klO = 0;
    private int klP;
    private AlphaAnimation klQ;
    private AlphaAnimation klR;
    private AlphaAnimation klS;
    private AlphaAnimation klT;
    private float klU = -1.0f;
    private float klV = -1.0f;
    private WakeLock wakeLock;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ i dVs;
        final /* synthetic */ TalkRoomUI klW;

        AnonymousClass2(TalkRoomUI talkRoomUI, i iVar) {
            this.klW = talkRoomUI;
            this.dVs = iVar;
        }

        public final void onClick(View view) {
            this.dVs.dismiss();
        }
    }

    private abstract class a {
        float evM;
        float evN;
        final /* synthetic */ TalkRoomUI klW;
        long kma;

        public abstract void baA();

        private a(TalkRoomUI talkRoomUI) {
            this.klW = talkRoomUI;
        }
    }

    static /* synthetic */ void a(TalkRoomUI talkRoomUI) {
        if (talkRoomUI.gVO == 5) {
            talkRoomUI.gVO = 3;
            b.aZW().aZS();
            talkRoomUI.gVW.ea(100);
        }
    }

    static /* synthetic */ boolean a(TalkRoomUI talkRoomUI, MotionEvent motionEvent) {
        if (talkRoomUI.gWS < 0.0f) {
            talkRoomUI.gWS = (((float) talkRoomUI.klH.getWidth()) - (((float) talkRoomUI.klH.getPaddingLeft()) * 2.0f)) / 2.0f;
            talkRoomUI.klU = (((float) talkRoomUI.klH.getWidth()) * 1.0f) / 2.0f;
            talkRoomUI.klV = (((float) talkRoomUI.klH.getHeight()) * 1.0f) / 2.0f;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return Math.sqrt((double) (((x - talkRoomUI.klU) * (x - talkRoomUI.klU)) + ((y - talkRoomUI.klV) * (y - talkRoomUI.klV)))) < ((double) talkRoomUI.gWS);
    }

    private void baw() {
        if (this.gVO == 3 || this.gVO == 5) {
            this.klK.gH(true);
        } else if (be.kS(this.gVL)) {
            this.klK.gH(false);
        } else {
            this.klK.gH(true);
        }
    }

    public void onCreate(Bundle bundle) {
        v.d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("enter_room_username");
        v.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", new Object[]{stringExtra});
        v.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", new Object[]{stringExtra});
        this.gVK = stringExtra;
        if (be.kS(this.gVK)) {
            CE("");
        } else {
            if (m.dE(stringExtra)) {
                List ej = com.tencent.mm.model.i.ej(stringExtra);
                if (ej == null) {
                    com.tencent.mm.model.ab.a.crZ.I(stringExtra, "");
                } else {
                    this.bir = ej;
                }
            } else {
                this.bir.clear();
                this.bir.add(stringExtra);
                this.bir.add(k.xF());
            }
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ TalkRoomUI klW;

                public final void run() {
                    b.aZW().bd(stringExtra, 0);
                }
            });
        }
        v.d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(q.em(aa.getContext()).inflate(2130904535, null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.dtB = (TextView) findViewById(2131755456);
        this.klG = (TextView) findViewById(2131759534);
        this.hkq = (TextView) findViewById(2131756548);
        this.klI = (Button) findViewById(2131759530);
        this.gWc = (Chronometer) findViewById(2131758471);
        this.klJ = (ImageView) findViewById(2131759535);
        this.klM = new a(this);
        this.klI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI klW;

            {
                this.klW = r1;
            }

            public final void onClick(View view) {
                g.a(this.klW, this.klW.getString(2131235621), this.klW.getString(2131235620), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 klX;

                    {
                        this.klX = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.klX.klW.gVX = false;
                        b.aZW().awO();
                        this.klX.klW.finish();
                    }
                }, null);
            }
        });
        findViewById(2131759531).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI klW;

            {
                this.klW = r1;
            }

            public final void onClick(View view) {
                boolean z;
                TalkRoomUI talkRoomUI = this.klW;
                ak.yW();
                if (be.a((Integer) c.vf().get(144641, null), 0) > 0) {
                    z = false;
                } else {
                    i iVar = new i(talkRoomUI, 2131559266);
                    LinearLayout linearLayout = (LinearLayout) q.em(aa.getContext()).inflate(2130904540, null);
                    linearLayout.setMinimumWidth(Constants.THREAD_BITSET_SIZE);
                    Button button = (Button) linearLayout.findViewById(2131759551);
                    iVar.setCanceledOnTouchOutside(true);
                    iVar.setOnDismissListener(new OnDismissListener(talkRoomUI) {
                        final /* synthetic */ TalkRoomUI klW;

                        {
                            this.klW = r1;
                        }

                        public final void onDismiss(DialogInterface dialogInterface) {
                            ak.yW();
                            int a = be.a((Integer) c.vf().get(144641, null), 0) + 1;
                            ak.yW();
                            c.vf().set(144641, Integer.valueOf(a));
                            this.klW.onBackPressed();
                        }
                    });
                    iVar.setCancelable(false);
                    button.setOnClickListener(new AnonymousClass2(talkRoomUI, iVar));
                    iVar.setContentView(linearLayout);
                    iVar.show();
                    z = true;
                }
                if (!z) {
                    this.klW.onBackPressed();
                }
            }
        });
        this.klH = (ImageButton) findViewById(2131759536);
        this.klH.setEnabled(false);
        this.klH.setImageResource(2130839295);
        this.klH.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TalkRoomUI klW;

            {
                this.klW = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
                /*
                r5 = this;
                r4 = 0;
                r0 = r7.getAction();
                switch(r0) {
                    case 0: goto L_0x0009;
                    case 1: goto L_0x0071;
                    case 2: goto L_0x0061;
                    case 3: goto L_0x0071;
                    default: goto L_0x0008;
                };
            L_0x0008:
                return r4;
            L_0x0009:
                r0 = r5.klW;
                r1 = r5.klW;
                r1 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r1, r7);
                r0.gVN = r1;
                r0 = r5.klW;
                r0 = r0.gVN;
                if (r0 == 0) goto L_0x0008;
            L_0x001c:
                r0 = r5.klW;
                r0 = r0.klH;
                r1 = 2130839294; // 0x7f0206fe float:1.7283594E38 double:1.052774492E-314;
                r0.setImageResource(r1);
                r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
                r1 = 2131235641; // 0x7f081339 float:1.8087482E38 double:1.0529703134E-314;
                r2 = new com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$1;
                r2.<init>(r5);
                com.tencent.mm.sdk.platformtools.ao.a(r0, r1, r2);
                r0 = r5.klW;
                r1 = 1;
                r0.gVO = r1;
                r0 = r5.klW;
                r0.baw();
                r0 = "MicroMsg.TalkRoomUI";
                r1 = "micBtn pressed down";
                com.tencent.mm.sdk.platformtools.v.i(r0, r1);
                r0 = r5.klW;
                r2 = com.tencent.mm.sdk.platformtools.be.Nj();
                r0.gVQ = r2;
                r0 = com.tencent.mm.plugin.talkroom.model.b.aZW();
                r0.baj();
                r0 = r5.klW;
                r0.awN();
                goto L_0x0008;
            L_0x0061:
                r0 = r5.klW;
                r0 = r0.gVN;
                if (r0 == 0) goto L_0x0008;
            L_0x0069:
                r0 = r5.klW;
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r0, r7);
                if (r0 != 0) goto L_0x0008;
            L_0x0071:
                r0 = r5.klW;
                r0 = r0.gVN;
                if (r0 == 0) goto L_0x0008;
            L_0x0079:
                r0 = r5.klW;
                r0.gVN = r4;
                r0 = r5.klW;
                r0 = r0.gVO;
                r1 = 5;
                if (r0 != r1) goto L_0x00a2;
            L_0x0087:
                r0 = "MicroMsg.TalkRoomUI";
                r1 = "cancel during seize-success prepare time";
                com.tencent.mm.sdk.platformtools.v.i(r0, r1);
                r0 = r5.klW;
                r0 = r0.gVR;
                r0.QI();
                r0 = r5.klW;
                r0 = r0.gVS;
                r0.QI();
            L_0x00a2:
                r0 = r5.klW;
                r0 = r0.klH;
                r1 = 2130839293; // 0x7f0206fd float:1.7283592E38 double:1.0527744915E-314;
                r0.setImageResource(r1);
                r0 = r5.klW;
                r0.gVO = r4;
                r0 = r5.klW;
                r0.baw();
                r0 = r5.klW;
                r0 = r0.gVW;
                r0.QI();
                r0 = com.tencent.mm.plugin.talkroom.model.b.aZW();
                r0.bak();
                r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
                r1 = 2131235644; // 0x7f08133c float:1.8087488E38 double:1.052970315E-314;
                r2 = new com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$2;
                r2.<init>(r5);
                com.tencent.mm.sdk.platformtools.ao.a(r0, r1, r2);
                r0 = r5.klW;
                r0.awN();
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.13.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        this.klK = (TalkRoomVolumeMeter) findViewById(2131757415);
        final a anonymousClass14 = new a(this) {
            final /* synthetic */ TalkRoomUI klW;

            {
                this.klW = r2;
            }

            public final void baA() {
                this.klW.onBackPressed();
            }
        };
        findViewById(2131759529).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TalkRoomUI klW;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                a aVar = anonymousClass14;
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.evM = motionEvent.getX();
                    aVar.evN = motionEvent.getY();
                    aVar.kma = be.Nj();
                    return true;
                }
                if (action == 1 || action == 3) {
                    float abs = Math.abs(motionEvent.getX() - aVar.evM);
                    float y = aVar.evN - motionEvent.getY();
                    if (y >= 100.0f && y / abs > 2.0f && y / ((float) be.az(aVar.kma)) > 0.6f) {
                        aVar.baA();
                        return true;
                    }
                }
                return false;
            }
        });
        this.klL = (TalkRoomAvatarsFrame) findViewById(2131759532);
        this.dtB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomUI klW;

            {
                this.klW = r1;
            }

            public final void onClick(View view) {
                this.klW.onBackPressed();
            }
        });
        this.klQ = new AlphaAnimation(0.0f, 1.0f);
        this.klQ.setDuration(300);
        this.klQ.setFillAfter(true);
        this.klR = new AlphaAnimation(1.0f, 0.0f);
        this.klR.setDuration(300);
        this.klR.setFillAfter(true);
        this.klS = new AlphaAnimation(0.0f, 1.0f);
        this.klS.setDuration(300);
        this.klS.setFillAfter(true);
        this.klT = new AlphaAnimation(1.0f, 0.0f);
        this.klT.setDuration(300);
        this.klT.setFillAfter(true);
        ak.vy().a(364, this);
        v.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        b.aZW().a((y) this);
        this.diI = (AudioManager) getSystemService("audio");
        this.klP = this.diI.getStreamMaxVolume(3);
        v.d("MicroMsg.TalkRoomUI", "onCreate end");
    }

    protected void onResume() {
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
        this.wakeLock.acquire();
        this.dtB.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, h.au(this, this.gVK), this.dtB.getTextSize()));
        b.aZV().kjX.kkc = true;
        b.aZV();
        v.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.aZV();
        com.tencent.mm.plugin.talkroom.model.c.bac();
        jr jrVar = new jr();
        jrVar.bkd.bke = true;
        com.tencent.mm.sdk.c.a.nhr.a(jrVar, getMainLooper());
        v.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    }

    protected void onPause() {
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
        this.wakeLock.release();
        this.gVW.QI();
        b.aZV().kjX.kkc = false;
        b.aZV();
        com.tencent.mm.plugin.talkroom.model.c cVar = b.aZV().kjX;
        if (cVar.gVJ) {
            cVar.Cz(aa.getContext().getString(2131235627));
        } else if (be.kS(cVar.gVg)) {
            cVar.Cz(h.au(aa.getContext(), b.aZW().kkT));
        } else {
            String string = aa.getContext().getString(2131235633, new Object[]{l.er(cVar.gVg)});
            com.tencent.mm.plugin.talkroom.model.c.bac();
            cVar.Cz(string);
        }
        jr jrVar = new jr();
        jrVar.bkd.bke = false;
        com.tencent.mm.sdk.c.a.nhr.a(jrVar, getMainLooper());
        v.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
    }

    protected void onDestroy() {
        b.aZW().b((y) this);
        ak.vy().b(364, this);
        if (this.ePC != null && this.ePC.isShowing()) {
            this.ePC.cancel();
        }
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int streamVolume;
        int i2;
        if (i == 25) {
            streamVolume = this.diI.getStreamVolume(3);
            i2 = this.klP / 7;
            if (i2 == 0) {
                i2 = 1;
            }
            this.diI.setStreamVolume(3, streamVolume - i2, 5);
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            streamVolume = this.diI.getStreamVolume(3);
            i2 = this.klP / 7;
            if (i2 == 0) {
                i2 = 1;
            }
            this.diI.setStreamVolume(3, i2 + streamVolume, 5);
            return true;
        }
    }

    public final void awP() {
        this.gVJ = false;
        this.klH.setEnabled(true);
        this.klH.setImageResource(2130839293);
        this.klI.setVisibility(0);
        awN();
        bay();
        bax();
    }

    public final void A(String str, int i, int i2) {
        v.f("MicroMsg.TalkRoomUI", "onInitFailed %s", new Object[]{str});
        String str2 = "";
        if (i == 4) {
            if (i2 != -1) {
                this.gVX = false;
                finish();
                return;
            }
            str2 = getString(2131235624);
        }
        CE(str2);
    }

    public final void mq(int i) {
        v.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
        if (i == 340) {
            if (this.gVO == 3) {
                this.gVO = 4;
            } else {
                return;
            }
        } else if (this.gVO == 1) {
            this.gVO = 2;
        } else {
            return;
        }
        baw();
        awN();
        ao.a(aa.getContext(), new com.tencent.mm.sdk.platformtools.ao.a(this) {
            final /* synthetic */ TalkRoomUI klW;

            {
                this.klW = r1;
            }

            public final void pa() {
            }
        });
    }

    public final void awQ() {
        v.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.gVO == 1) {
            this.gVO = 5;
            if (be.az(this.gVQ) < this.gVP) {
                v.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
                this.gVR.ea(this.gVP - be.az(this.gVQ));
                return;
            }
            awM();
        }
    }

    private void awM() {
        if (this.gVO == 5) {
            this.gVR.QI();
            awN();
            baw();
            ao.a(aa.getContext(), 2131235637, new com.tencent.mm.sdk.platformtools.ao.a(this) {
                final /* synthetic */ TalkRoomUI klW;

                {
                    this.klW = r1;
                }

                public final void pa() {
                    this.klW.gVS.QI();
                    TalkRoomUI.a(this.klW);
                }
            });
            this.gVS.ea(1000);
        }
    }

    public final void g(int i, int i2, String str) {
        v.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        CE("");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 364 && this.ePC != null && this.ePC.isShowing()) {
                this.ePC.cancel();
            }
        } else if (kVar.getType() == 364 && this.ePC != null && this.ePC.isShowing()) {
            this.ePC.cancel();
        }
    }

    private void CE(String str) {
        if (this.gVX) {
            this.gVX = false;
            b.aZW().awO();
            if (be.kS(str)) {
                if (com.tencent.mm.sdk.platformtools.ak.isConnected(getApplication())) {
                    str = getString(2131235624);
                } else {
                    str = getString(2131235625);
                }
            }
            if (!isFinishing()) {
                g.a(this, str, "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ TalkRoomUI klW;

                    {
                        this.klW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.klW.finish();
                    }
                });
                return;
            }
            return;
        }
        v.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void vT(String str) {
        v.d("MicroMsg.TalkRoomUI", "onCurMember %s", new Object[]{str});
        this.gVL = str;
        baw();
        awN();
        if (be.kS(str)) {
            this.gVW.QI();
            return;
        }
        ao.a(aa.getContext(), 2131235640, new com.tencent.mm.sdk.platformtools.ao.a(this) {
            final /* synthetic */ TalkRoomUI klW;

            {
                this.klW = r1;
            }

            public final void pa() {
            }
        });
        this.gVW.ea(100);
    }

    public final void awR() {
        if (this.gVX) {
            this.gVX = false;
            finish();
            return;
        }
        v.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void awS() {
        awN();
    }

    public final void awT() {
        awN();
    }

    public final void awU() {
        b(getString(2131235628), 2131690062);
    }

    private void bax() {
        List<azi> awq = b.aZW().awq();
        List linkedList = new LinkedList();
        for (azi com_tencent_mm_protocal_c_azi : awq) {
            linkedList.add(com_tencent_mm_protocal_c_azi.gln);
        }
        TalkRoomAvatarsFrame talkRoomAvatarsFrame = this.klL;
        if (talkRoomAvatarsFrame.klA != null) {
            a aVar = talkRoomAvatarsFrame.klA;
            aVar.klE = linkedList;
            aVar.notifyDataSetChanged();
        }
    }

    public final void bZ(String str, String str2) {
        v.i("MicroMsg.TalkRoomUI", "add %s,  del %s", new Object[]{str, str2});
        bax();
        if (!this.gVJ) {
            bay();
            if (!be.kS(str)) {
                CF(getString(2131235614, new Object[]{l.er(str)}));
                this.gVT.ea(3000);
            }
            if (!be.kS(str2)) {
                CF(getString(2131235619, new Object[]{l.er(str2)}));
                this.gVT.ea(3000);
            }
        }
    }

    private void awN() {
        if (!this.gVJ) {
            if (b.aZW().klh) {
                b(getString(2131235626), 2131690062);
                this.klL.CD(null);
                this.klJ.setImageResource(2130839289);
                baz();
                return;
            }
            switch (this.gVO) {
                case 0:
                    if (be.kS(this.gVL)) {
                        CharSequence string;
                        if (b.aZW().awq().size() == 1) {
                            string = getString(2131235635);
                        } else {
                            string = "";
                        }
                        b(string, 2131690061);
                        this.klL.CD(null);
                        this.klJ.setImageResource(2130839289);
                        baz();
                        return;
                    }
                    CF(l.er(this.gVL));
                    this.klL.CD(this.gVL);
                    this.klJ.setImageResource(2130839289);
                    rv(1);
                    return;
                case 1:
                    b(getString(2131235613), 2131690061);
                    this.klJ.setImageResource(2130839292);
                    return;
                case 2:
                    b(getString(2131235629), 2131690062);
                    this.klJ.setImageResource(2130839291);
                    return;
                case 3:
                case 5:
                    b(getString(2131235630), 2131690061);
                    this.klL.CD(k.xF());
                    this.klJ.setImageResource(2130839290);
                    rv(2);
                    return;
                case 4:
                    b(getString(2131235632), 2131690062);
                    this.klJ.setImageResource(2130839291);
                    baz();
                    return;
                default:
                    return;
            }
        }
    }

    private void bay() {
        v.i("MicroMsg.TalkRoomUI", "displayCount %d", new Object[]{Integer.valueOf(b.aZW().awq().size())});
        this.hkq.setText(String.valueOf(r0));
    }

    private void CF(String str) {
        b(com.tencent.mm.pluginsdk.ui.d.e.a(this, str, this.klG.getTextSize()), 2131690061);
    }

    private void b(CharSequence charSequence, int i) {
        if (be.kS(charSequence.toString())) {
            this.klG.startAnimation(this.klT);
            return;
        }
        this.klG.setTextColor(getResources().getColor(i));
        this.klG.setText(charSequence);
        this.klG.startAnimation(this.klS);
    }

    private void rv(int i) {
        if (i == 0 || this.gWd != i) {
            this.gWc.setVisibility(0);
            this.gWc.startAnimation(this.klQ);
            this.gWc.setBase(be.Nj());
            this.gWc.start();
            this.gWd = i;
        }
    }

    private void baz() {
        if (this.gWd != 0) {
            this.gWc.stop();
            this.gWd = 0;
            this.gWc.startAnimation(this.klR);
        }
    }
}
