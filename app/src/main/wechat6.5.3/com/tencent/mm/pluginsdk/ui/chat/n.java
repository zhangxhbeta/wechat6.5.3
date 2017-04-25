package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.qc;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;

public final class n extends LinearLayout {
    private Button hhL;
    private TelephonyManager ktJ;
    PhoneStateListener kuq = new PhoneStateListener(this) {
        final /* synthetic */ n lON;

        {
            this.lON = r1;
        }

        public final void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (this.lON.lOp != null) {
                i2 = this.lON.lOp.boS();
            }
            v.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 2) {
                this.lON.pause();
            }
        }
    };
    private boolean lIA = false;
    private MMEditText lIG;
    private int lLF = com.tencent.mm.bd.a.fromDPToPix(getContext(), 215);
    private h lMr;
    private boolean lOA = false;
    private boolean lOB = false;
    private int lOC = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
    private boolean lOD = false;
    private boolean lOE = false;
    private long lOF = 0;
    private long lOG = 0;
    private long lOH = 0;
    private boolean lOI = false;
    private l lOJ;
    private c<qc> lOK;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a lOL = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a(this) {
        final /* synthetic */ n lON;

        {
            this.lON = r1;
        }

        public final void boT() {
            this.lON.lOF = System.currentTimeMillis();
            v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(this.lON.lOF));
            v.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(this.lON.lOF));
            this.lON.lOD = false;
            this.lON.lOE = true;
            this.lON.lOG = 0;
            this.lON.lOH = 0;
            this.lON.bqw();
            this.lON.lOv.setVisibility(8);
            this.lON.lOE = false;
            this.lON.lOJ.lIr = 3;
            this.lON.lOJ.b(this.lON.lIG);
            n.bRT();
            if (this.lON.lIG == null || this.lON.lIG.getText() == null || this.lON.lIG.getText().length() != 0 || this.lON.lOs.getVisibility() != 8) {
                this.lON.lIG.requestFocus();
                be.cw(this.lON.lOp);
            } else {
                this.lON.lOs.setVisibility(0);
            }
            if (this.lON.mContext instanceof Activity) {
                ((Activity) this.lON.mContext).getWindow().addFlags(FileUtils.S_IWUSR);
            }
            this.lON.hhL.setVisibility(4);
            this.lON.lOq.setVisibility(4);
        }

        public final void boU() {
            v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            this.lON.lOJ.a(this.lON.lIG);
            this.lON.bqw();
            if (this.lON.mContext instanceof Activity) {
                ((Activity) this.lON.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.un(2);
        }

        public final void boV() {
            v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            this.lON.lOJ.a(this.lON.lIG);
            this.lON.bqw();
            if (this.lON.mContext instanceof Activity) {
                ((Activity) this.lON.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.un(3);
        }

        public final void boW() {
            v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            this.lON.lOJ.a(this.lON.lIG);
            this.lON.bqw();
            if (this.lON.mContext instanceof Activity) {
                ((Activity) this.lON.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.a(this.lON, 1);
        }

        public final void B(String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                this.lON.lOJ.a(this.lON.lIG, strArr[0], true);
                this.lON.hhL.setTextColor(this.lON.getResources().getColor(2131690123));
                if (this.lON.lOs.getVisibility() == 0 && this.lON.lIG.getText().length() != 0) {
                    this.lON.lOs.setVisibility(8);
                    this.lON.lIG.requestFocus();
                    be.cw(this.lON.lOp);
                }
                if (!this.lON.lOD && strArr[0].length() != 0) {
                    this.lON.lOD = true;
                    this.lON.lOG = System.currentTimeMillis();
                    v.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.lON.lOG - this.lON.lOF));
                }
            }
        }

        public final void P(int i, int i2, int i3) {
            v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            this.lON.lOJ.a(this.lON.lIG);
            this.lON.bqw();
            if (this.lON.mContext instanceof Activity) {
                ((Activity) this.lON.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.a(this.lON, i);
            if (i == 12) {
                Toast.makeText(this.lON.mContext, this.lON.mContext.getResources().getString(2131235812), 1).show();
            } else {
                Toast.makeText(this.lON.mContext, this.lON.mContext.getResources().getString(2131231042), 1).show();
            }
        }
    };
    private boolean lOM = true;
    private VoiceInputLayout lOp;
    private Button lOq;
    a lOr;
    private ImageView lOs;
    private VoiceInputScrollView lOt;
    private j lOu;
    private TextView lOv;
    private long lOw = 0;
    private float lOx = 0.0f;
    private float lOy = 0.0f;
    private boolean lOz = false;
    private Context mContext;
    private boolean pRt = false;

    public interface a {
        void HI(String str);

        void bqp();
    }

    static /* synthetic */ void a(n nVar, int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.fail = i;
        a(voiceInputBehavior);
        un(i);
    }

    static /* synthetic */ boolean a(n nVar, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (nVar.lOt.getScrollY() <= 0) {
                nVar.lOA = true;
                nVar.lOx = motionEvent.getRawY();
            }
            nVar.lOB = true;
        } else if (motionEvent.getAction() == 2) {
            nVar.lOz = true;
        } else if (motionEvent.getAction() == 1) {
            float f;
            if (nVar.lOz && nVar.lOA) {
                nVar.lOy = motionEvent.getRawY();
                f = nVar.lOy - nVar.lOx;
            } else {
                f = 0.0f;
            }
            nVar.lOB = false;
            nVar.lOz = false;
            nVar.lOA = false;
            nVar.lOy = 0.0f;
            nVar.lOx = 0.0f;
            if (f > ((float) nVar.lOC)) {
                nVar.bqv();
            } else if (nVar.lIA) {
                nVar.lIA = false;
            } else if ((view instanceof MMEditText) && nVar.lIG != null && nVar.lIG.getText() != null && nVar.lIG.getText().length() > 0) {
                v.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", Integer.valueOf(((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY())));
                if (nVar.lOp != null) {
                    VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                    voiceInputBehavior.textClick = nVar.lOp.boS();
                    a(voiceInputBehavior);
                }
                Intent intent = new Intent();
                intent.setClass(nVar.getContext(), VoiceInputUI.class);
                intent.putExtra("offset", r0);
                if (!(nVar.lIG == null || nVar.lIG.getText() == null)) {
                    intent.putExtra("text", nVar.lIG.getText().toString());
                    if (nVar.lOJ != null) {
                        nVar.lOJ.b(nVar.lIG);
                    }
                }
                nVar.getContext().startActivity(intent);
                be.cw(nVar.lOp);
                if (nVar.lOp != null) {
                    nVar.lOp.boP();
                }
            }
            return view instanceof MMEditText;
        }
        return view instanceof MMEditText;
    }

    static /* synthetic */ void b(n nVar) {
        v.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (nVar.lIG != null && nVar.lIG.getText() != null) {
            String obj = nVar.lIG.getText().toString();
            if (obj.trim().length() == 0 && obj.length() == 0) {
                if (nVar.lMr == null || !nVar.lMr.isShowing()) {
                    nVar.lMr = g.f(nVar.getContext(), 2131231777, 2131231164);
                }
            } else if (nVar.lOr != null) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 1;
                if (nVar.pRt) {
                    voiceInputBehavior.send = 2;
                }
                a(voiceInputBehavior);
                v.d("MicroMsg.VoiceInputPanel", "sendMsg onSendMsg");
                nVar.lOr.HI(obj);
            }
        } else if (nVar.lMr == null || !nVar.lMr.isShowing()) {
            nVar.lMr = g.f(nVar.getContext(), 2131231777, 2131231164);
        }
    }

    static /* synthetic */ void bRT() {
        v.d("MicroMsg.VoiceInputPanel", "pauseMusic");
        ak.yX().rb();
    }

    public n(Context context) {
        super(context);
        this.mContext = context;
        init();
        this.lOJ = new l(this.mContext);
        bqu();
    }

    @TargetApi(16)
    private void init() {
        v.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), 2130904582, this);
        this.lOq = (Button) findViewById(2131759650);
        this.hhL = (Button) findViewById(2131759652);
        this.lOv = (TextView) findViewById(2131759648);
        this.lOq.setVisibility(0);
        this.hhL.setVisibility(4);
        this.lIG = (MMEditText) findViewById(2131759646);
        this.lIG.setHintTextColor(getResources().getColor(2131689906));
        this.lIG.setClickable(true);
        this.lOs = (ImageView) findViewById(2131759647);
        this.lOu = new j(this.mContext);
        this.lOs.setBackground(this.lOu);
        this.lOt = (VoiceInputScrollView) findViewById(2131759644);
        this.lOq.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ n lON;

            {
                this.lON = r1;
            }

            public final void onClick(View view) {
                this.lON.bqv();
            }
        });
        this.hhL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ n lON;

            {
                this.lON = r1;
            }

            public final void onClick(View view) {
                n.b(this.lON);
            }
        });
        this.lIG.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ n lON;

            {
                this.lON = r1;
            }

            public final boolean onLongClick(View view) {
                if (this.lON.lOB) {
                    this.lON.lIA = true;
                }
                return true;
            }
        });
        this.lIG.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ n lON;

            {
                this.lON = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return n.a(this.lON, view, motionEvent);
            }
        });
        this.lOt.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ n lON;

            {
                this.lON = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return n.a(this.lON, view, motionEvent);
            }
        });
    }

    public final void bqu() {
        this.lOw = System.currentTimeMillis();
        if (this.lOK == null) {
            v.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.lOK = new c<qc>(this) {
                final /* synthetic */ n lON;

                {
                    this.lON = r2;
                    this.nhz = qc.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    qc qcVar = (qc) bVar;
                    if (!(qcVar instanceof qc)) {
                        v.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        return false;
                    } else if (qcVar == null || qcVar.brq == null) {
                        v.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        return false;
                    } else {
                        v.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s", Integer.valueOf(qcVar.brq.action));
                        if (qcVar.brq.action == 2) {
                            if (qcVar.brq.dYY == 1) {
                                this.lON.pRt = true;
                            } else {
                                this.lON.pRt = false;
                            }
                            this.lON.lOJ.a(this.lON.lIG, qcVar.brq.bfz, false);
                            this.lON.lOJ.a(this.lON.lIG);
                            this.lON.lOJ.b(this.lON.lIG);
                            this.lON.bqw();
                            this.lON.lOt.fullScroll(130);
                        } else if (qcVar.brq.action != 3) {
                            this.lON.reset();
                        } else if (this.lON.lOr != null) {
                            this.lON.lOr.bqp();
                        }
                        return true;
                    }
                }
            };
            com.tencent.mm.sdk.c.a.nhr.e(this.lOK);
        }
        if (this.lOp == null) {
            this.lOp = (VoiceInputLayout) findViewById(2131759651);
            this.lOp.lIs = this.lOL;
        }
        if (this.lOv != null) {
            this.lOv.setVisibility(0);
        }
        if (this.lOs != null) {
            this.lOs.setVisibility(8);
        }
        this.ktJ = (TelephonyManager) aa.getContext().getSystemService("phone");
        this.ktJ.listen(this.kuq, 32);
    }

    public final void pause() {
        v.d("MicroMsg.VoiceInputPanel", "pause");
        if (this.lOp != null) {
            this.lOp.boP();
        }
        this.lOx = 0.0f;
        this.lOy = 0.0f;
        this.lOz = false;
        this.lOA = false;
        this.lIA = false;
        this.lOB = false;
        this.lOI = false;
    }

    public final void reset() {
        v.d("MicroMsg.VoiceInputPanel", "reset");
        pause();
        this.pRt = false;
        if (this.lIG != null) {
            if (this.lOJ != null) {
                this.lOJ.b(this.lIG);
                this.lOJ.a(this.lIG, SQLiteDatabase.KeyEmpty, false);
                this.lOJ.a(this.lIG);
                this.lOJ.b(this.lIG);
            }
            bqw();
        }
    }

    public final void destory() {
        v.i("MicroMsg.VoiceInputPanel", "destory");
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (this.lIG == null || this.lIG.getText() == null || this.lIG.getText().length() <= 0) {
            if (this.lOI) {
                voiceInputBehavior.cancel = 2;
            } else {
                voiceInputBehavior.cancel = 15;
            }
        } else if (this.lOI) {
            voiceInputBehavior.cancel = 14;
        } else {
            voiceInputBehavior.cancel = 16;
        }
        if (this.lOw != 0) {
            voiceInputBehavior.voiceInputTime = System.currentTimeMillis() - this.lOw;
        }
        a(voiceInputBehavior);
        reset();
        if (this.lOK != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.lOK);
            this.lOK = null;
        }
        if (this.lOp != null) {
            this.lOp.lIs = null;
            this.lOp = null;
        }
        if (!(this.ktJ == null || this.kuq == null)) {
            this.ktJ.listen(this.kuq, 0);
            this.kuq = null;
        }
        this.ktJ = null;
    }

    private void bqv() {
        v.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.lOr != null) {
            this.lOI = true;
            v.d("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            this.lOr.bqp();
        }
    }

    public final void um(int i) {
        v.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", Integer.valueOf(this.lLF), Integer.valueOf(i));
        if (this.lLF != i) {
            this.lLF = i;
            this.lOM = true;
        }
    }

    public final void bpy() {
        v.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(this.lLF), Boolean.valueOf(this.lOM));
        if (this.lOM) {
            this.lOM = false;
            View findViewById = findViewById(2131759643);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = this.lLF;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            init();
            requestLayout();
        }
    }

    private void bqw() {
        v.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.lIG == null || this.lIG.getText() == null || this.lIG.getText().length() != 0) {
            this.hhL.setTextColor(getResources().getColor(2131689564));
            this.hhL.setVisibility(0);
            this.lOq.setVisibility(0);
            this.lOv.setVisibility(8);
        } else {
            this.lIG.setSelection(0);
            this.hhL.setTextColor(getResources().getColor(2131689613));
            this.hhL.setVisibility(4);
            this.lOq.setVisibility(0);
            this.lOv.setVisibility(0);
        }
        if (this.lOs.getVisibility() == 0) {
            this.lOs.setVisibility(8);
        }
        this.lIG.clearFocus();
        v.d("MicroMsg.VoiceInputPanel", "resumeMusic");
        ak.yX().rc();
        if (!this.lOE) {
            this.lOE = true;
            this.lOH = System.currentTimeMillis();
            v.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.lOH), Long.valueOf(this.lOH - this.lOG));
        }
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        v.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail));
        com.tencent.mm.ba.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        com.tencent.mm.plugin.report.service.g.iuh.a(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
    }

    private static void un(int i) {
        v.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", Integer.valueOf(i));
        com.tencent.mm.plugin.report.service.g.iuh.a(455, (long) i, 1, false);
    }
}
