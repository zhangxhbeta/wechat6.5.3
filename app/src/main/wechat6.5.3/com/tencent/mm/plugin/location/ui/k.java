package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.model.i;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.pluginsdk.j.x;
import com.tencent.mm.pluginsdk.j.y;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public final class k implements y, e {
    private Activity aXH;
    private List<String> bir = new LinkedList();
    Button gVG;
    public VolumeMeter gVH;
    RelativeLayout gVI;
    private boolean gVJ = true;
    private String gVK;
    String gVL;
    private String gVM;
    boolean gVN = false;
    int gVO = 0;
    private long gVP = 500;
    long gVQ = 0;
    ah gVR = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ k gVY;

        {
            this.gVY = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
            this.gVY.awM();
            return false;
        }
    }, false);
    ah gVS = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ k gVY;

        {
            this.gVY = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
            k.a(this.gVY);
            return false;
        }
    }, false);
    private ah gVT = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ k gVY;

        {
            this.gVY = r1;
        }

        public final boolean oU() {
            this.gVY.awN();
            return false;
        }
    }, false);
    public x gVU;
    public a gVV;
    final ah gVW = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ k gVY;

        {
            this.gVY = r1;
        }

        public final boolean oU() {
            int bap;
            if (this.gVY.gVO == 3) {
                bap = this.gVY.gVU.bap();
            } else if (be.kS(this.gVY.gVL)) {
                return false;
            } else {
                bap = this.gVY.gVU.baq();
            }
            k kVar = this.gVY;
            float f = (float) bap;
            if (f < 10.0f) {
                f = 10.0f;
            }
            if (f > 100.0f) {
                f = 100.0f;
            }
            VolumeMeter volumeMeter = kVar.gVH;
            f /= 100.0f;
            volumeMeter.gWH = volumeMeter.gWI;
            volumeMeter.gWI = f;
            kVar.gVH.invalidate();
            return true;
        }
    }, true);
    private boolean gVX = true;

    public interface a {
        void awI();

        void awJ();

        void awK();

        void vR(String str);

        void vS(String str);
    }

    static /* synthetic */ void a(k kVar) {
        if (kVar.gVO == 5) {
            kVar.gVO = 3;
            kVar.gVU.aZS();
            kVar.gVW.ea(100);
        }
    }

    public k(Activity activity, Button button) {
        this.aXH = activity;
        this.gVG = button;
        this.gVI = (RelativeLayout) this.aXH.findViewById(2131757414);
        this.gVI.setVisibility(8);
        this.gVH = (VolumeMeter) this.gVI.findViewById(2131757415);
        this.gVH.gWD = this.gVG;
        VolumeMeter volumeMeter = this.gVH;
        if (volumeMeter.gWG == null) {
            com.tencent.mm.sdk.i.e.d(new Runnable(volumeMeter) {
                final /* synthetic */ VolumeMeter gWV;

                {
                    this.gWV = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.gWV.gWG = new ac();
                    Looper.loop();
                }
            }, "VolumeMeter_handler", 1).start();
        }
        this.gVU = com.tencent.mm.pluginsdk.j.a.lxH;
        if (this.gVU == null) {
            v.e("MicroMsg.TalkMgr", "cannot get talkroom server");
        }
    }

    public final void awL() {
        this.gVM = this.aXH.getIntent().getStringExtra("map_talker_name");
        this.gVU.a(this);
        v.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[]{this.gVM});
        final String str = this.gVM;
        this.gVK = str;
        if (!be.kS(this.gVK)) {
            if (m.dE(str)) {
                List ej = i.ej(str);
                if (ej == null) {
                    com.tencent.mm.model.ab.a.crZ.I(str, "");
                } else {
                    this.bir = ej;
                }
            } else {
                this.bir.clear();
                this.bir.add(str);
                this.bir.add(com.tencent.mm.model.k.xF());
            }
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ k gVY;

                public final void run() {
                    this.gVY.gVU.bd(str, 1);
                }
            });
            this.gVG.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ k gVY;

                {
                    this.gVY = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            this.gVY.gVN = true;
                            this.gVY.gVI.setVisibility(0);
                            this.gVY.gVH.reset();
                            VolumeMeter volumeMeter = this.gVY.gVH;
                            if (!volumeMeter.gWC) {
                                volumeMeter.gWB = true;
                                volumeMeter.axa();
                            }
                            this.gVY.gVG.setPressed(true);
                            if (this.gVY.gVN) {
                                ao.a(aa.getContext(), 2131235641, new com.tencent.mm.sdk.platformtools.ao.a(this) {
                                    final /* synthetic */ AnonymousClass7 gWa;

                                    {
                                        this.gWa = r1;
                                    }

                                    public final void pa() {
                                        v.i("MicroMsg.TalkMgr", "play press sound end");
                                    }
                                });
                                this.gVY.gVO = 1;
                                v.i("MicroMsg.TalkMgr", "micBtn pressed down");
                                this.gVY.gVQ = be.Nj();
                                this.gVY.gVU.baj();
                                this.gVY.awN();
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            this.gVY.gVG.setPressed(false);
                            this.gVY.gVI.setVisibility(8);
                            this.gVY.gVH.reset();
                            this.gVY.gVH.gWB = false;
                            if (this.gVY.gVN) {
                                this.gVY.gVN = false;
                                if (this.gVY.gVO == 5) {
                                    v.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                                    this.gVY.gVR.QI();
                                    this.gVY.gVS.QI();
                                }
                                this.gVY.gVO = 0;
                                this.gVY.gVW.QI();
                                this.gVY.gVU.bak();
                                ao.T(aa.getContext(), 2131235644);
                                this.gVY.awN();
                                if (this.gVY.gVV != null) {
                                    this.gVY.gVV.awJ();
                                    break;
                                }
                            }
                            break;
                        case 2:
                            if (this.gVY.gVN) {
                                break;
                            }
                            break;
                    }
                    return false;
                }
            });
        }
    }

    final void awM() {
        if (this.gVO == 5) {
            this.gVR.QI();
            awN();
            ao.a(aa.getContext(), 2131235637, new com.tencent.mm.sdk.platformtools.ao.a(this) {
                final /* synthetic */ k gVY;

                {
                    this.gVY = r1;
                }

                public final void pa() {
                    this.gVY.gVS.QI();
                    k.a(this.gVY);
                }
            });
            this.gVS.ea(1000);
        }
    }

    final void awN() {
        if (!this.gVJ) {
            if (com.tencent.mm.pluginsdk.j.a.lxH.bar()) {
                v.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
                if (this.gVV != null) {
                    this.gVV.vR(null);
                    this.gVV.awJ();
                }
            }
            switch (this.gVO) {
                case 0:
                    v.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[]{this.gVL});
                    if (this.gVV == null) {
                        return;
                    }
                    if (be.kS(this.gVL)) {
                        this.gVV.vR(null);
                        return;
                    } else {
                        this.gVV.vR(this.gVL);
                        return;
                    }
                case 1:
                    v.d("MicroMsg.TalkMgr", "seize, state seizing");
                    if (this.gVV != null) {
                        this.gVV.awK();
                        return;
                    }
                    return;
                case 2:
                    v.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[]{this.gVL});
                    if (this.gVV != null && !be.kS(this.gVL)) {
                        this.gVV.vS(this.gVL);
                        return;
                    }
                    return;
                case 3:
                case 5:
                    v.d("MicroMsg.TalkMgr", "seize, state success or prepare");
                    if (this.gVV != null) {
                        this.gVV.awI();
                        return;
                    }
                    return;
                case 4:
                    v.d("MicroMsg.TalkMgr", "seize time out");
                    return;
                default:
                    return;
            }
        }
    }

    public static void awO() {
        pd pdVar = new pd();
        pdVar.bqt.bqw = true;
        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
    }

    public final void awP() {
        this.gVJ = false;
        this.gVG.setEnabled(true);
        awN();
    }

    public final void A(String str, int i, int i2) {
        v.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[]{str});
        l.awi().mp(3);
        this.aXH.finish();
    }

    public final void awQ() {
        if (this.gVO == 1) {
            this.gVO = 5;
            if (be.az(this.gVQ) < this.gVP) {
                v.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
                this.gVR.ea(this.gVP - be.az(this.gVQ));
                return;
            }
            awM();
        }
    }

    public final void mq(int i) {
        v.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
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
        awN();
        ao.a(aa.getContext(), null);
    }

    public final void vT(String str) {
        v.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[]{str});
        this.gVL = str;
        awN();
        if (be.kS(str)) {
            this.gVW.QI();
            return;
        }
        ao.T(aa.getContext(), 2131235640);
        this.gVW.ea(100);
    }

    public final void bZ(String str, String str2) {
        v.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[]{str, str2});
        if (!this.gVJ) {
        }
    }

    public final void g(int i, int i2, String str) {
    }

    public final void awR() {
    }

    public final void awS() {
        awN();
    }

    public final void awT() {
        awN();
    }

    public final void awU() {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
    }
}
