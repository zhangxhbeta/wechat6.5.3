package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnDragListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.as.u;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.ba;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.f2f.F2FButton;
import com.tencent.mm.pluginsdk.model.app.af;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;

public class ChatFooter extends LinearLayout implements OnGlobalLayoutListener, com.tencent.mm.pluginsdk.ui.chat.i.a {
    private static int count = 0;
    private static final int[] ewE = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] ewF = new int[]{2130837628, 2130837629, 2130837630, 2130837631, 2130837632, 2130837633, 2130837634};
    private Activity aXH;
    public String bhM;
    private Context context;
    private ImageView ewN;
    private boolean ewV;
    private final ac exe;
    public View fDt;
    public View fTc;
    public View fTd;
    public View fTe;
    public View fTf;
    private String fmg;
    public MMEditText hhK;
    public Button hhL;
    public ChatFooterPanel hhM;
    public o klr;
    private TextView kls;
    private ImageView klt;
    public View klu;
    public g lGn;
    private int lGo;
    private InputMethodManager lMA;
    public int lMB;
    private boolean lMC;
    private boolean lMD;
    public boolean lME;
    public boolean lMF;
    public b lMG;
    private com.tencent.mm.pluginsdk.ui.chat.m.a lMH;
    private boolean lMI;
    public p lMJ;
    private boolean lMK;
    private Animation lML;
    private Animation lMM;
    private AlphaAnimation lMN;
    private boolean lMO;
    private com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a lMP;
    private com.tencent.mm.pluginsdk.ui.chat.AppPanel.b lMQ;
    public d lMR;
    private int lMS;
    public boolean lMT;
    private final int lMU;
    private final int lMV;
    private final int lMW;
    private final int lMX;
    private final int lMY;
    private final int lMZ;
    public n lMh;
    public AppPanel lMi;
    public F2FButton lMj;
    public TextView lMk;
    private Button lMl;
    public ImageButton lMm;
    public LinearLayout lMn;
    public ChatFooterBottom lMo;
    public ImageButton lMp;
    public ImageButton lMq;
    private h lMr;
    private j lMs;
    public m lMt;
    public b lMu;
    private c lMv;
    public final a lMw;
    public boolean lMx;
    public boolean lMy;
    private TextView lMz;
    private final int lNa;
    private final int lNb;
    private int lNc;
    private int lNd;
    private int lNe;
    private int lNf;
    private boolean lNg;
    private final int lNh;
    private final int lNi;
    private volatile boolean lNj;
    private ac lNk;
    private int lNl;
    private int lNm;
    private int lNn;
    private View lNo;
    public boolean lNp;
    private int lNq;
    public final ac mHandler;
    public String toUser;

    class AnonymousClass20 implements Runnable {
        final /* synthetic */ ChatFooter lNr;
        final /* synthetic */ boolean lNs = false;

        AnonymousClass20(ChatFooter chatFooter, boolean z) {
            this.lNr = chatFooter;
        }

        public final void run() {
            this.lNr.il(this.lNs);
        }
    }

    private static class a {
        public String lNv;
        public String lNw;
        public int lNx;

        private a() {
        }
    }

    public interface b {
        void a(Boolean bool, Boolean bool2);

        void b(Boolean bool, Boolean bool2);
    }

    public interface c {
        boolean im(boolean z);
    }

    public class d implements TextWatcher {
        private boolean lNA = f.dX(11);
        final /* synthetic */ ChatFooter lNr;
        TextWatcher lNy;
        private boolean lNz = false;

        public d(ChatFooter chatFooter, TextWatcher textWatcher) {
            this.lNr = chatFooter;
            this.lNy = textWatcher;
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = true;
            if (this.lNr.lMD && this.lNz && editable.length() > 0) {
                this.lNz = false;
                this.lNr.hhK.setText(editable.subSequence(0, editable.length() - 1));
                if (this.lNr.hhK.length() > 0) {
                    this.lNr.hhL.performClick();
                }
                v.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
                return;
            }
            this.lNy.afterTextChanged(editable);
            if (this.lNr.lMk != null) {
                if (this.lNr.hhK.getLineCount() > 1) {
                    this.lNr.lMk.setVisibility(0);
                    this.lNr.lMk.setText(editable.length() + "/140");
                } else {
                    this.lNr.lMk.setVisibility(8);
                }
            }
            if (editable.length() <= 0 || editable.toString().trim().length() <= 0) {
                z = false;
            }
            this.lNr.ee(z);
            if (this.lNr.hhM != null) {
                this.lNr.hhM.cB(z);
            }
            v.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lNy.beforeTextChanged(charSequence, i, i2, i3);
            v.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.lNr.lMD && i2 == 0 && i == charSequence.length() - 1 && i3 == 1 && charSequence.charAt(charSequence.length() - 1) == '\n') {
                this.lNz = true;
            } else {
                this.lNy.onTextChanged(charSequence, i, i2, i3);
            }
        }
    }

    static /* synthetic */ void C(ChatFooter chatFooter) {
        if (u.bj(chatFooter.context) || com.tencent.mm.ah.a.aT(chatFooter.context)) {
            v.d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            return;
        }
        chatFooter.findViewById(2131756068).setVisibility(8);
        chatFooter.lMB = 1;
        chatFooter.hhK.setVisibility(8);
        chatFooter.lMl.setVisibility(8);
        chatFooter.ue(2130838016);
        if (chatFooter.hhM != null) {
            chatFooter.hhM.setVisibility(8);
        }
        chatFooter.lMi.setVisibility(8);
        chatFooter.ig(false);
        if (chatFooter.lMh == null) {
            chatFooter.lMh = new n(chatFooter.getContext());
            chatFooter.lMo.addView(chatFooter.lMh, new LayoutParams(-1, -1));
            chatFooter.lMh.lOr = new com.tencent.mm.pluginsdk.ui.chat.n.a(chatFooter) {
                final /* synthetic */ ChatFooter lNr;

                {
                    this.lNr = r1;
                }

                public final void bqp() {
                    this.lNr.bpH();
                }

                public final void HI(String str) {
                    this.lNr.lMu.wm(str);
                    this.lNr.lMh.reset();
                }
            };
            chatFooter.lMh.um(j.aD(chatFooter.context));
        }
        chatFooter.lMh.bqu();
        chatFooter.lMh.bpy();
        chatFooter.lMh.setVisibility(0);
        chatFooter.lMF = true;
    }

    static /* synthetic */ void M(ChatFooter chatFooter) {
        chatFooter.lNk.removeMessages(4097);
        chatFooter.lNk.sendEmptyMessageDelayed(4097, 1);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i, String str) {
        if (be.kS(chatFooter.fmg)) {
            v.e("MicroMsg.ChatFooter", "doSendImage : talker is null");
        } else if (str == null || str.equals(SQLiteDatabase.KeyEmpty) || !e.aR(str)) {
            v.e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
        } else {
            ak.vy().a(new k(4, com.tencent.mm.model.k.xF(), chatFooter.fmg, str, i, null, 0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, 2130837922), 0);
        }
    }

    static /* synthetic */ int bqo() {
        int i = count;
        count = i + 1;
        return i;
    }

    static /* synthetic */ void q(ChatFooter chatFooter) {
        if (chatFooter.lMB == 1) {
            v.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(chatFooter.aXH, "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), chatFooter.aXH);
            if (com.tencent.mm.pluginsdk.i.a.a(chatFooter.aXH, "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                chatFooter.R(2, true);
                return;
            }
            return;
        }
        chatFooter.R(1, true);
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooter(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.fDt = null;
        this.lMj = null;
        this.hhK = null;
        this.hhL = null;
        this.lMk = null;
        this.lMv = null;
        this.lMw = new a();
        this.lMx = false;
        this.lMy = false;
        this.ewV = false;
        this.lMC = false;
        this.lMD = false;
        this.lME = false;
        this.lMF = false;
        this.lMH = new com.tencent.mm.pluginsdk.ui.chat.m.a(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void clear() {
                ChatFooter chatFooter = this.lNr;
                if (chatFooter.hhK != null) {
                    chatFooter.hhK.setText(SQLiteDatabase.KeyEmpty);
                }
            }
        };
        this.mHandler = new ac(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            @SuppressLint({"NewApi"})
            @TargetApi(11)
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                        if (this.lNr.hhK != null && message.obj != null) {
                            boolean booleanValue = ((Boolean) message.obj).booleanValue();
                            if (booleanValue) {
                                this.lNr.hhK.setAlpha(1.0f);
                            } else {
                                this.lNr.hhK.setAlpha(0.5f);
                            }
                            this.lNr.ig(booleanValue);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lMI = false;
        this.lMK = false;
        this.lMN = null;
        this.lMO = false;
        this.lMP = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void ayC() {
                this.lNr.lMB = 1;
                this.lNr.lMn.setVisibility(0);
                this.lNr.lMl.setVisibility(8);
                this.lNr.ig(true);
                this.lNr.ue(2130838016);
                if (this.lNr.hhL != null) {
                    this.lNr.hhL.performClick();
                }
            }

            public final void ef(boolean z) {
                this.lNr.lMB = 1;
                this.lNr.lMn.setVisibility(0);
                this.lNr.lMl.setVisibility(8);
                this.lNr.ue(2130838016);
                if (this.lNr.hhK != null) {
                    this.lNr.ik(z);
                }
            }

            public final void Tm() {
                this.lNr.lMB = 1;
                this.lNr.lMn.setVisibility(0);
                this.lNr.lMl.setVisibility(8);
                this.lNr.ig(true);
                this.lNr.ue(2130838016);
                this.lNr.hhK.pcq.sendKeyEvent(new KeyEvent(0, 67));
                this.lNr.hhK.pcq.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                this.lNr.lMB = 1;
                this.lNr.lMn.setVisibility(0);
                this.lNr.lMl.setVisibility(8);
                this.lNr.ig(true);
                this.lNr.ue(2130838016);
                try {
                    this.lNr.hhK.PL(str);
                } catch (Throwable e) {
                    v.a("MicroMsg.ChatFooter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        };
        this.lMQ = new com.tencent.mm.pluginsdk.ui.chat.AppPanel.b(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void bpB() {
                v.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.lNr.aXH, "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.lNr.aXH);
                if (com.tencent.mm.pluginsdk.i.a.a(this.lNr.aXH, "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                    int BJ = ak.vy().BJ();
                    if (BJ == 4 || BJ == 6) {
                        ChatFooter.C(this.lNr);
                    } else if (this.lNr.lMr == null || !this.lNr.lMr.isShowing()) {
                        this.lNr.lMr = g.f(this.lNr.getContext(), 2131235928, 2131231164);
                    }
                }
            }
        };
        this.exe = new ac(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (this.lNr.klr != null) {
                    this.lNr.klr.dismiss();
                    this.lNr.lMl.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.lNr.getContext(), 2130839043));
                    this.lNr.lMl.setEnabled(true);
                }
            }
        };
        this.lMS = 0;
        this.lMT = false;
        this.lMU = 0;
        this.lMV = 1;
        this.lMW = 2;
        this.lMX = 3;
        this.lMY = 20;
        this.lMZ = 21;
        this.lNa = 22;
        this.lNb = 23;
        this.lNc = 0;
        this.lNd = 0;
        this.lNe = -1;
        this.lNf = -1;
        this.lNg = false;
        this.lNh = 4097;
        this.lNi = 4098;
        this.lNk = new ac(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 4097:
                        this.lNr.lNj = true;
                        ViewGroup.LayoutParams layoutParams = this.lNr.lMo.getLayoutParams();
                        int bottom = this.lNr.lMo.getBottom() - this.lNr.lMo.getTop();
                        if (this.lNr.bqe()) {
                            if (this.lNr.hhM != null) {
                                this.lNr.hhM.setVisibility(8);
                            }
                            this.lNr.lMi.setVisibility(8);
                            this.lNr.lMo.setVisibility(4);
                        }
                        if (bottom <= 3) {
                            this.lNr.lNj = false;
                            this.lNr.lMo.setVisibility(8);
                            this.lNr.uj(j.aA(this.lNr.getContext()));
                            return;
                        }
                        layoutParams.height = Math.max(bottom - 60, 1);
                        this.lNr.lMo.setLayoutParams(layoutParams);
                        ChatFooter.M(this.lNr);
                        return;
                    default:
                        return;
                }
            }
        };
        this.lNl = -1;
        this.lNm = -1;
        this.lNn = -1;
        this.lNo = null;
        this.lNp = true;
        this.lNq = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.lMA = (InputMethodManager) context.getSystemService("input_method");
        this.fDt = inflate(context, 2130903286, this);
        this.hhK = (MMEditText) this.fDt.findViewById(2131756073);
        com.tencent.mm.ui.tools.a.c.b(this.hhK).yn(com.tencent.mm.h.b.sD()).a(null);
        this.hhK.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        com.tencent.mm.sdk.c.b lcVar = new lc();
        lcVar.bmw.bmy = this.hhK;
        lcVar.bmw.bmx = new com.tencent.mm.pluginsdk.ui.a.a(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void Hu(final String str) {
                v.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", str);
                if (be.kS(this.lNr.fmg) || be.kS(str)) {
                    v.e("MicroMsg.ChatFooter", "onImageReceived, error args");
                } else {
                    g.a(this.lNr.getContext(), this.lNr.getContext().getString(2131232599), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass22 lNu;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            int i2 = 1;
                            boolean a = com.tencent.mm.model.k.a(str, this.lNu.lNr.fmg, true);
                            ChatFooter chatFooter = this.lNu.lNr;
                            if (!a) {
                                i2 = 0;
                            }
                            ChatFooter.a(chatFooter, i2, str);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass22 lNu;

                        {
                            this.lNu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(lcVar);
        this.lMn = (LinearLayout) this.fDt.findViewById(2131756072);
        this.lMo = (ChatFooterBottom) findViewById(2131756080);
        this.lMp = (ImageButton) this.fDt.findViewById(2131756078);
        this.hhL = (Button) this.fDt.findViewById(2131756079);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.lMl = (Button) this.fDt.findViewById(2131756074);
        this.lMm = (ImageButton) findViewById(2131756071);
        ee(false);
        bql();
        this.lMs = new j(getContext(), getRootView(), this, new com.tencent.mm.pluginsdk.ui.chat.j.a(this) {
            final /* synthetic */ ChatFooter lNr;

            public final void HJ(String str) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                if (this.lNr.bhM != null) {
                    intent.putExtra("GalleryUI_FromUser", this.lNr.bhM);
                }
                if (this.lNr.toUser != null) {
                    intent.putExtra("GalleryUI_ToUser", this.lNr.toUser);
                }
                intent.putExtra("query_source_type", 3);
                intent.putExtra("preview_image", true);
                intent.putStringArrayListExtra("preview_image_list", arrayList);
                intent.putExtra("max_select_count", 1);
                intent.addFlags(67108864);
                if (this.lNr.lMJ != null) {
                    com.tencent.mm.ay.c.a(this.lNr.lMJ, "gallery", ".ui.GalleryEntryUI", intent, 217);
                } else {
                    com.tencent.mm.ay.c.b(context, "gallery", ".ui.GalleryEntryUI", intent, 217);
                }
            }
        });
        this.lMs.lNR = this;
        this.lMt = new m(getContext(), getRootView(), this, this.hhK);
        this.lMt.lMH = this.lMH;
        v.d("MicroMsg.ChatFooter", "send edittext ime option %s", Integer.valueOf(this.hhK.getImeOptions()));
        this.hhK.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4 && (i != 0 || !this.lNr.lMD)) {
                    return false;
                }
                this.lNr.hhL.performClick();
                return true;
            }
        });
        this.hhK.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lNr.ik(true);
                this.lNr.k(3, -1, true);
                this.lNr.lMu.azn();
                this.lNr.postDelayed(new AnonymousClass20(this.lNr, false), 10);
                return false;
            }
        });
        this.hhK.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final boolean onLongClick(View view) {
                return false;
            }
        });
        this.hhL.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final synchronized void onClick(View view) {
                String obj = this.lNr.hhK.getText().toString();
                v.d("MicroMsg.ChatFooter", "send msg onClick");
                if (obj.trim().length() == 0 && obj.length() != 0) {
                    v.d("MicroMsg.ChatFooter", "empty message cant be sent");
                    if (this.lNr.lMr == null || !this.lNr.lMr.isShowing()) {
                        this.lNr.lMr = g.f(this.lNr.getContext(), 2131231777, 2131231164);
                    }
                } else if (this.lNr.lMu.wm(obj)) {
                    this.lNr.hhK.clearComposingText();
                    this.lNr.hhK.setText(SQLiteDatabase.KeyEmpty);
                }
            }
        });
        this.lMl.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == this.lNr.lMl) {
                    v.v("RcdBtnEvent", "event.getAction():" + motionEvent.getAction());
                    switch (motionEvent.getAction()) {
                        case 0:
                            v.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", Integer.valueOf(ChatFooter.count));
                            if (this.lNr.context instanceof Activity) {
                                ((Activity) this.lNr.context).getWindow().addFlags(FileUtils.S_IWUSR);
                            }
                            if (!(this.lNr.ewV || this.lNr.lMC)) {
                                this.lNr.ewV = true;
                                this.lNr.lMl.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.lNr.getContext(), 2130839044));
                                this.lNr.lMl.setText(2131231752);
                                this.lNr.lMu.azk();
                                this.lNr.lMl.setContentDescription(this.lNr.getContext().getString(2131231730));
                                break;
                            }
                        case 1:
                        case 3:
                            if (this.lNr.context instanceof Activity) {
                                ((Activity) this.lNr.context).getWindow().clearFlags(FileUtils.S_IWUSR);
                            }
                            v.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.count));
                            this.lNr.bqj();
                            v.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.bqo()));
                            break;
                        case 2:
                            if (this.lNr.fTe == null || this.lNr.fTf == null) {
                                v.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", this.lNr.fTe, this.lNr.fTf);
                            }
                            if (motionEvent.getX() > 0.0f && motionEvent.getY() > ((float) ((-this.lNr.lMS) / 2)) && motionEvent.getX() < ((float) this.lNr.lMl.getWidth())) {
                                if (this.lNr.fTe != null) {
                                    this.lNr.fTe.setVisibility(0);
                                }
                                if (this.lNr.fTf != null) {
                                    this.lNr.lMl.setText(2131231752);
                                    this.lNr.fTf.setVisibility(8);
                                    break;
                                }
                            }
                            v.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(this.lNr.lMS), Integer.valueOf(this.lNr.lMl.getWidth()), Integer.valueOf(this.lNr.lMl.getHeight()));
                            if (this.lNr.fTe != null) {
                                this.lNr.fTe.setVisibility(8);
                            }
                            if (this.lNr.fTf != null) {
                                this.lNr.lMl.setText(2131231736);
                                this.lNr.fTf.setVisibility(0);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        this.lMl.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getAction()) {
                    case 0:
                        if (!((i != 23 && i != 66) || this.lNr.lMC || this.lNr.ewV)) {
                            this.lNr.lMC = true;
                            this.lNr.lMl.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.lNr.getContext(), 2130839044));
                            this.lNr.lMl.setText(2131231752);
                            this.lNr.lMu.azk();
                            this.lNr.lMl.setContentDescription(this.lNr.getContext().getString(2131231730));
                            break;
                        }
                    case 1:
                        if (i == 23 || i == 66) {
                            this.lNr.lMl.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.lNr.getContext(), 2130839043));
                            this.lNr.lMl.setText(2131231751);
                            this.lNr.lMu.azh();
                            this.lNr.lMC = false;
                            break;
                        }
                }
                return false;
            }
        });
        this.lMm.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void onClick(View view) {
                ChatFooter.q(this.lNr);
            }
        });
        bpF();
        this.lMp.setVisibility(0);
        this.lMp.setContentDescription(getContext().getString(2131231723));
        this.lMp.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void onClick(View view) {
                this.lNr.bpD();
                if (com.tencent.mm.model.k.yo().booleanValue() && this.lNr.lMG != null) {
                    this.lNr.lMG.a(Boolean.valueOf(true), Boolean.valueOf(true));
                }
            }
        });
        uj(-1);
        this.lMj = (F2FButton) this.fDt.findViewById(2131756070);
        this.lMj.setVisibility(8);
        this.lMj.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.c.a.nhr.z(new ba());
            }
        });
        findViewById(2131756068).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        v.d("MicroMsg.ChatFooter", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void a(Context context, Activity activity) {
        this.aXH = activity;
        bql();
        if (this.hhM != null) {
            this.hhM.onResume();
        }
        if (!this.lMI && this.lMD) {
            v.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
            this.lMD = false;
            this.hhK.setImeOptions(0);
            this.hhK.setInputType(this.hhK.getInputType() | 64);
        } else if (this.lMI && !this.lMD) {
            bqb();
        }
        if (this.lMi != null) {
            this.lMi.context = context;
        }
        this.context = context;
        this.lMs.lNQ = false;
        if (!this.lMF) {
            this.fDt.findViewById(2131756076).setVisibility(0);
            this.hhK.setVisibility(0);
        }
        bpY();
        post(new Runnable(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void run() {
                j.f(this.lNr.aXH);
            }
        });
    }

    public final void onPause() {
        this.lMK = true;
        if (this.hhM != null) {
            this.hhM.onPause();
        }
        if (this.lMF && this.lMh != null) {
            this.lMh.pause();
        }
        this.lMu.onPause();
        this.lNp = false;
    }

    public final void destroy() {
        if (this.hhM != null) {
            v.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
            this.hhM.ahl();
            this.hhM.destroy();
            this.hhM = null;
        }
        if (this.lMh != null) {
            this.lMh.reset();
            this.lMF = false;
        }
        if (this.lMu != null) {
            this.lMu.release();
        }
        if (this.lMt != null) {
            this.lMt.lMH = null;
            this.lMt.lOc = null;
            this.lMt.hide();
        }
        v.d("MicroMsg.ChatFooter", "jacks destory");
    }

    public final void bpC() {
        if (this.lMi != null) {
            this.lMi.bps();
        }
    }

    private void ee(boolean z) {
        if (this.lML == null) {
            this.lML = AnimationUtils.loadAnimation(getContext(), 2130968641);
            this.lML.setDuration(150);
        }
        if (this.lMM == null) {
            this.lMM = AnimationUtils.loadAnimation(getContext(), 2130968642);
            this.lMM.setDuration(150);
        }
        if (this.hhL != null && this.lMp != null) {
            if (this.lMI) {
                if (this.lMp.getVisibility() != 0) {
                    this.lMp.setVisibility(0);
                }
            } else if (this.hhL.getVisibility() != 0 || !z) {
                if (this.lMp.getVisibility() != 0 || z) {
                    if (z) {
                        this.hhL.startAnimation(this.lML);
                        this.hhL.setVisibility(0);
                        this.lMp.startAnimation(this.lMM);
                        this.lMp.setVisibility(8);
                    } else {
                        this.lMp.startAnimation(this.lML);
                        if (!this.lMy) {
                            this.lMp.setVisibility(0);
                        }
                        this.hhL.startAnimation(this.lMM);
                        this.hhL.setVisibility(8);
                    }
                    v.i("MicroMsg.ChatFooter", "jacks canSend:%B", Boolean.valueOf(z));
                    this.hhL.getParent().requestLayout();
                }
            }
        }
    }

    public final void bpD() {
        this.lMu.azm();
        if (this.lMi.getVisibility() != 0 || this.lMo.bqC) {
            k(2, 22, true);
            if (this.lMh != null && this.lMh.getVisibility() == 0 && this.lMF) {
                v.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.lMh.setVisibility(8);
                this.lMF = false;
                this.lMh.reset();
            }
            an bnG = an.bnG();
            Context context = aa.getContext();
            if (ak.uz() && context != null) {
                try {
                    String value = com.tencent.mm.h.j.sU().getValue("ShowAPPSuggestion");
                    if (be.kS(value) || Integer.valueOf(value).intValue() != 1) {
                        v.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", value);
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", e.getMessage());
                }
                if (bnG.lBB) {
                    v.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    v.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    bnG.lBB = true;
                    if (System.currentTimeMillis() - bnG.lBE < 43200000) {
                        v.d("MicroMsg.SuggestionAppListLogic", "not now");
                        bnG.lBB = false;
                    } else {
                        ak.yW();
                        bnG.lBE = com.tencent.mm.model.c.vf().vc(352275);
                        if (System.currentTimeMillis() - bnG.lBE < 43200000) {
                            v.w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            bnG.lBB = false;
                        } else {
                            if (bnG.cUi == null) {
                                bnG.cUi = com.tencent.mm.sdk.platformtools.u.d(context.getSharedPreferences(aa.bti(), 0));
                            }
                            com.tencent.mm.pluginsdk.model.app.v afVar = new af(bnG.cUi, new LinkedList());
                            am.ash();
                            com.tencent.mm.pluginsdk.model.app.d.a(4, afVar);
                        }
                    }
                }
            }
            an bnG2 = an.bnG();
            Context context2 = aa.getContext();
            if (ak.uz() && context2 != null) {
                if (bnG2.lBC) {
                    v.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
                    return;
                }
                bnG2.lBC = true;
                if (System.currentTimeMillis() - bnG2.lBH < 43200000) {
                    v.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                    bnG2.lBC = false;
                    return;
                }
                ak.yW();
                bnG2.lBH = com.tencent.mm.model.c.vf().vc(352276);
                if (System.currentTimeMillis() - bnG2.lBH < 43200000) {
                    v.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                    bnG2.lBC = false;
                    return;
                }
                if (bnG2.cUi == null) {
                    bnG2.cUi = com.tencent.mm.sdk.platformtools.u.d(context2.getSharedPreferences(aa.bti(), 0));
                }
                an.bC(bnG2.cUi, bnG2.lBG);
            }
        } else if (this.lMB == 1) {
            k(1, -1, true);
        } else {
            k(0, -1, false);
        }
    }

    public final void ig(boolean z) {
        if (this.hhK != null) {
            if (z) {
                this.hhK.requestFocus();
            } else {
                this.hhK.clearFocus();
            }
        }
    }

    public final void bpE() {
        if (f.lNK == null) {
            this.hhM = new e(this.context);
            return;
        }
        if (this.hhM != null) {
            this.hhM.destroy();
        }
        this.hhM = f.lNK.bC(this.context);
        if (this.hhM != null) {
            this.hhM.jT(ChatFooterPanel.lGq);
            if (this.hhM != null) {
                this.hhM.setVisibility(8);
            }
            if (this.hhM != null) {
                this.hhM.tN(this.lGo);
            }
            if (this.lMo != null) {
                this.lMo.addView(this.hhM, -1, -2);
            }
            if (this.hhM != null) {
                this.hhM.lGm = this.lMP;
            }
            if (this.hhM != null) {
                this.hhM.cB(this.hhK.getText().length() > 0);
            }
            if (this.hhM != null) {
                this.hhM.rL(this.fmg);
                this.hhM.jS(j.aA(getContext()));
                if (!be.kS(this.hhK.getText().toString())) {
                    this.hhM.ahr();
                }
            }
            if (this.lME) {
                ahm();
            }
            b(this.lGn);
        }
    }

    public final void ahm() {
        this.lME = true;
        if (this.hhM != null) {
            this.hhM.ahm();
        }
    }

    public final void b(g gVar) {
        this.lGn = gVar;
        if (this.hhM != null) {
            this.hhM.a(gVar);
        }
    }

    public final void a(k kVar) {
        this.lMt.lOc = kVar;
    }

    private void ue(int i) {
        if (this.lMm != null) {
            int i2;
            if (i == 2130838016) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.lMm != null) {
                if (i2 != 0) {
                    this.lMm.setContentDescription(getContext().getString(2131231729));
                } else {
                    this.lMm.setContentDescription(getContext().getString(2131231728));
                }
            }
            this.lMm.setImageResource(i);
            this.lMm.setPadding(0, 0, 0, 0);
        }
    }

    private void bpF() {
        this.lMi = (AppPanel) findViewById(2131756081);
        this.lMi.lLm = this.lMQ;
        this.lMi.ud(j.aA(getContext()));
        if (m.fn(this.fmg) || m.fg(this.fmg)) {
            this.lMi.init(0);
        } else if (m.eD(this.fmg)) {
            this.lMi.init(4);
        } else if (m.dE(this.fmg)) {
            this.lMi.init(2);
        } else {
            this.lMi.init(1);
        }
    }

    public final void bpG() {
        this.lMB = 1;
        this.lMn.setVisibility(0);
        this.lMl.setVisibility(8);
        if (this.lMh != null) {
            this.lMh.setVisibility(8);
            this.lMF = false;
            this.lMh.reset();
        }
        k(2, 21, true);
    }

    public final void bpH() {
        View findViewById = findViewById(2131756068);
        this.lMF = false;
        if (this.lMh != null) {
            this.lMh.destory();
            this.lMh.setVisibility(8);
        }
        findViewById.setVisibility(0);
        this.hhK.setVisibility(0);
        this.hhK.setText(SQLiteDatabase.KeyEmpty);
        ig(true);
        bpY();
        k(0, -1, false);
    }

    public final void HD(String str) {
        this.lMw.lNw = str;
    }

    public final void HE(String str) {
        this.lMw.lNv = str;
    }

    public final void uf(int i) {
        this.lMw.lNx = i;
    }

    public final void HF(String str) {
        l(str, -1, true);
    }

    public final void l(String str, int i, boolean z) {
        if (z && (str == null || str.length() == 0 || this.hhK == null)) {
            this.hhK.setText(SQLiteDatabase.KeyEmpty);
            return;
        }
        this.lMx = true;
        this.hhK.setText(com.tencent.mm.pluginsdk.ui.d.e.a(getContext(), (CharSequence) str, this.hhK.getTextSize()));
        this.lMx = false;
        if (i < 0 || i > this.hhK.getText().length()) {
            this.hhK.setSelection(this.hhK.getText().length());
        } else {
            this.hhK.setSelection(i);
        }
    }

    public final void bpI() {
        this.lMl.setEnabled(false);
        this.lMl.setBackgroundDrawable(com.tencent.mm.bd.a.a(getContext(), 2130839042));
        if (this.klr != null) {
            this.fTd.setVisibility(0);
            this.fTc.setVisibility(8);
            this.klu.setVisibility(8);
            this.klr.update();
        }
        this.exe.sendEmptyMessageDelayed(0, 500);
    }

    public final String bpJ() {
        return this.hhK == null ? SQLiteDatabase.KeyEmpty : this.hhK.getText().toString();
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        this.lMR = new d(this, textWatcher);
        this.hhK.addTextChangedListener(this.lMR);
    }

    public final void ug(int i) {
        this.lMS = 0;
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), 180);
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(getContext(), 50.0f);
        if (i + a < fromDPToPix) {
            this.lMS = -1;
        } else {
            this.lMS = ((i - fromDPToPix) / 2) + a;
        }
        if (this.klr == null) {
            this.klr = new o(View.inflate(getContext(), 2130904588, null), -1, -2);
            this.ewN = (ImageView) this.klr.getContentView().findViewById(2131756976);
            this.fTe = this.klr.getContentView().findViewById(2131756974);
            this.fTf = this.klr.getContentView().findViewById(2131756978);
            this.kls = (TextView) this.klr.getContentView().findViewById(2131756980);
            this.klt = (ImageView) this.klr.getContentView().findViewById(2131756979);
            this.klu = this.klr.getContentView().findViewById(2131759671);
            this.fTc = this.klr.getContentView().findViewById(2131756973);
            this.fTd = this.klr.getContentView().findViewById(2131756981);
            this.lMz = (TextView) this.klr.getContentView().findViewById(2131759670);
        }
        if (this.lMS != -1) {
            this.fTd.setVisibility(8);
            this.fTc.setVisibility(8);
            this.klu.setVisibility(0);
            this.klr.showAtLocation(this, 49, 0, this.lMS);
        }
    }

    public final void HG(String str) {
        if (str != null && this.lMz != null) {
            this.lMz.setText(str);
        }
    }

    public final void bpK() {
        this.klu.setVisibility(8);
        this.fTc.setVisibility(0);
    }

    public final void anf() {
        post(new Runnable(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void run() {
                if (this.lNr.klr != null) {
                    this.lNr.klr.dismiss();
                    this.lNr.fTc.setVisibility(0);
                    this.lNr.klu.setVisibility(8);
                    this.lNr.fTd.setVisibility(8);
                    this.lNr.fTf.setVisibility(8);
                    this.lNr.fTe.setVisibility(0);
                }
                this.lNr.lMl.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.lNr.getContext(), 2130839043));
                this.lNr.lMl.setText(2131231751);
                this.lNr.lMC = false;
                this.lNr.ewV = false;
            }
        });
    }

    public final void uh(int i) {
        int i2 = 0;
        while (i2 < ewF.length) {
            if (i >= ewE[i2] && i < ewE[i2 + 1]) {
                this.ewN.setBackgroundDrawable(com.tencent.mm.bd.a.a(getContext(), ewF[i2]));
                break;
            }
            i2++;
        }
        if (i == -1 && this.klr != null) {
            this.klr.dismiss();
            this.klu.setVisibility(0);
            this.fTc.setVisibility(8);
            this.fTd.setVisibility(8);
        }
    }

    private void ui(int i) {
        this.lMB = i;
        switch (i) {
            case 1:
                this.lMn.setVisibility(0);
                this.lMl.setVisibility(8);
                ue(2130838016);
                return;
            case 2:
                this.lMn.setVisibility(8);
                this.lMl.setVisibility(0);
                ue(2130838015);
                if (com.tencent.mm.model.k.yo().booleanValue() && this.lMG != null) {
                    this.lMG.b(Boolean.valueOf(true), Boolean.valueOf(true));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void R(int i, boolean z) {
        boolean z2 = true;
        ui(i);
        switch (i) {
            case 1:
                ig(true);
                bqi();
                if (z) {
                    k(1, -1, true);
                    if (this.hhK.length() <= 0) {
                        z2 = false;
                    }
                    ee(z2);
                    return;
                }
                ee(false);
                return;
            case 2:
                k(0, -1, false);
                ee(false);
                return;
            default:
                setVisibility(0);
                return;
        }
    }

    public final void ih(boolean z) {
        if (this.hhM != null) {
            this.hhM.l(z, false);
        }
    }

    public final void bpL() {
        this.lMn.setVisibility(0);
        this.lMm.setVisibility(8);
        this.lMl.setVisibility(8);
    }

    public final void bpM() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLI.value = false;
        appPanel.bpu();
    }

    public final void bpN() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lMa.value = false;
        appPanel.bpu();
    }

    public final void bpO() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLJ.value = false;
        appPanel.bpu();
    }

    public final void bpP() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLL.value = false;
        appPanel.bpu();
    }

    public final void bpQ() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLM.value = false;
        appPanel.bpu();
    }

    public final void bpR() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLZ.value = false;
        appPanel.bpu();
    }

    public final void bpS() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLN.value = false;
        appPanel.bpu();
        v.d("MicroMsg.AppPanel", "enable false" + " isVoipPluginEnable " + appPanel.lLp.lLO.value);
        this.lMi.ib(true);
    }

    public final void ii(boolean z) {
        AppPanel appPanel = this.lMi;
        boolean z2 = !z;
        appPanel.lLp.lMc.value = z2;
        appPanel.bpu();
        v.d("MicroMsg.AppPanel", "enable " + appPanel.lLp.lMc.value + " isMultiTalkEnable " + z2);
    }

    public final void ij(boolean z) {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLV.value = !z;
        appPanel.bpu();
    }

    public final void bpT() {
        AppPanel appPanel = this.lMi;
        appPanel.lLx = true;
        appPanel.lLp.ie(false);
        appPanel.bpu();
    }

    public final void bpU() {
        AppPanel appPanel = this.lMi;
        appPanel.lLy = true;
        appPanel.lLp.id(false);
        appPanel.bpu();
    }

    public final void bpV() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLS.value = false;
        appPanel.bpu();
        v.d("MicroMsg.AppPanel", new StringBuilder("disableTalkroom enable false").toString());
    }

    public final void bpW() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLX.value = false;
        appPanel.bpu();
    }

    public final void bpX() {
        AppPanel appPanel = this.lMi;
        appPanel.lLp.lLR.value = false;
        appPanel.bpu();
    }

    public final void bpY() {
        this.lMq = (ImageButton) this.fDt.findViewById(2131756075);
        this.lMq.setVisibility(0);
        this.lMq.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ChatFooter lNr;

            {
                this.lNr = r1;
            }

            public final void onClick(View view) {
                this.lNr.lMu.azl();
                if (this.lNr.lMo.bqC || this.lNr.hhM == null || this.lNr.hhM.getVisibility() != 0) {
                    if (this.lNr.lMy) {
                        this.lNr.ahm();
                    }
                    this.lNr.bpG();
                    if (!be.kS(this.lNr.hhK.getText().toString())) {
                        this.lNr.hhM.ahr();
                        return;
                    }
                    return;
                }
                this.lNr.k(1, -1, true);
            }
        });
        if (this.lMt != null) {
            this.lMt.lOb = this.lMq;
        }
    }

    public final void bpZ() {
        if (this.lMq != null) {
            this.lMq.setVisibility(8);
        }
    }

    public final void bqa() {
        AppPanel appPanel = this.lMi;
        appPanel.lLz = true;
        appPanel.lLp.if(false);
        appPanel.bpu();
    }

    public final void bqb() {
        v.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.lMD = true;
        this.hhK.setImeOptions(4);
        this.hhK.setInputType(this.hhK.getInputType() & -65);
    }

    public final void bqc() {
        if (this.hhM != null) {
            this.hhM.refresh();
        }
    }

    public final void bqd() {
        this.lMi.refresh();
    }

    public final boolean bqe() {
        return this.lMo.getVisibility() == 0;
    }

    @TargetApi(11)
    public final void a(OnDragListener onDragListener) {
        this.hhK.setOnDragListener(onDragListener);
    }

    public final void a(com.tencent.mm.pluginsdk.ui.chat.AppPanel.a aVar) {
        this.lMi.lLl = aVar;
    }

    public static void bqf() {
    }

    public final void a(c cVar) {
        this.lMv = cVar;
        if (cVar != null) {
            View findViewById = findViewById(2131756069);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ ChatFooter lNr;

                {
                    this.lNr = r1;
                }

                public final void onClick(View view) {
                    if (this.lNr.lMv != null) {
                        this.lNr.lMv.im(false);
                    }
                }
            });
        }
    }

    @TargetApi(11)
    public final void ik(final boolean z) {
        if (f.dW(11)) {
            com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a(this) {
                final /* synthetic */ ChatFooter lNr;

                public final void run() {
                    Message message = new Message();
                    message.what = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
                    message.obj = Boolean.valueOf(z);
                    this.lNr.mHandler.sendMessage(message);
                }
            });
        } else if (z) {
            this.hhK.setTextColor(getResources().getColor(2131690157));
        } else {
            this.hhK.setTextColor(getResources().getColor(2131689781));
            ig(false);
        }
    }

    public final void bqg() {
        k(2, 20, false);
    }

    public final void k(int i, int i2, boolean z) {
        boolean z2 = true;
        if (!z) {
            this.lMp.setContentDescription(getContext().getString(2131231723));
            switch (i) {
                case 0:
                    be.cw(this);
                    ig(false);
                    if (!this.lMF) {
                        bqi();
                        break;
                    }
                    break;
                case 1:
                    be.cw(this);
                    break;
                case 2:
                    if (i2 != 20) {
                        if (i2 != 22) {
                            if (i2 != 21) {
                                if (i2 == 23) {
                                    bpH();
                                    bqi();
                                    break;
                                }
                            } else if (this.hhM != null) {
                                this.hhM.setVisibility(8);
                                break;
                            }
                        }
                        this.lMi.setVisibility(8);
                        break;
                    } else if (!this.lMF) {
                        bqi();
                        break;
                    } else {
                        be.cw(this);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        if (com.tencent.mm.model.k.yo().booleanValue() && this.lMG != null) {
            this.lMG.a(Boolean.valueOf(true), Boolean.valueOf(false));
            this.lMG.b(Boolean.valueOf(true), Boolean.valueOf(false));
        }
        this.lMp.setContentDescription(getContext().getString(2131231722));
        switch (i) {
            case 1:
                this.lMo.bqq();
                ig(true);
                ik(true);
                this.lMA.showSoftInput(this.hhK, 0);
                break;
            case 2:
                if (i2 == 22) {
                    if (this.lMi == null) {
                        bpF();
                    }
                    this.lMi.bpy();
                    if (this.hhM != null) {
                        this.hhM.setVisibility(8);
                    }
                    this.lMi.setVisibility(0);
                    j jVar = this.lMs;
                    ak.vA().x(new com.tencent.mm.pluginsdk.ui.chat.j.AnonymousClass3(jVar, new com.tencent.mm.pluginsdk.ui.chat.j.AnonymousClass2(jVar, jVar.context.getMainLooper())));
                    ig(false);
                    if (this.lMB == 2) {
                        ui(1);
                    }
                } else if (i2 == 21) {
                    if (this.lMi != null) {
                        this.lMi.setVisibility(8);
                    }
                    if (this.hhM == null) {
                        bpE();
                    }
                    if (this.hhM != null) {
                        this.hhM.setVisibility(0);
                    }
                    il(true);
                    ig(true);
                }
                this.lMo.setVisibility(0);
                if (!(bqh() && j.aF(getContext()))) {
                    ViewGroup.LayoutParams layoutParams = this.lMo.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == 0) {
                        layoutParams.height = j.aD(getContext());
                        this.lMo.setLayoutParams(layoutParams);
                    }
                }
                be.cw(this);
                break;
            case 3:
                this.lMo.bqq();
                ig(true);
                ik(true);
                break;
            default:
                z = false;
                break;
        }
        if (!((!z || i2 == 21 || this.lMq == null) && (this.lMq == null || z || (i2 != 21 && i2 != 20)))) {
            il(false);
        }
        if (i == 0 && !z) {
            il(false);
        } else if (z && i2 != 22) {
            if (this.hhK.length() <= 0) {
                z2 = false;
            }
            ee(z2);
        }
    }

    private boolean bqh() {
        return this.lNe > 0 && this.lNe < this.lNf;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onLayout(z, i, i2, i3, i4);
        if (getTop() != 0) {
            if (getTop() > this.lNd) {
                this.lNd = getTop();
            }
            if (this.lNd - getTop() > 50) {
                if (this.lMu != null) {
                    this.lMu.eg(true);
                }
            } else if (this.lMu != null) {
                this.lMu.eg(false);
            }
        }
        if (z && this.lMt != null) {
            m mVar = this.lMt;
            if (mVar.lNZ.isShowing()) {
                mVar.lNZ.dismiss();
                mVar.bqt();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", Integer.valueOf(MeasureSpec.getSize(i2)), Integer.valueOf(getMeasuredHeight()));
        super.onMeasure(i, i2);
        v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", Integer.valueOf(getMeasuredHeight()));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private void il(boolean z) {
        if (this.lMq != null) {
            if (!this.lNg || !z) {
                if (this.lNg || z) {
                    this.lNg = z;
                    if (z) {
                        this.lMq.setImageDrawable(getContext().getResources().getDrawable(2130838015));
                    } else {
                        this.lMq.setImageDrawable(getContext().getResources().getDrawable(2130838010));
                    }
                }
            }
        }
    }

    public final void bqi() {
        this.lMo.setVisibility(8);
        this.lMi.setVisibility(8);
        if (this.hhM != null) {
            this.hhM.setVisibility(8);
        }
        il(false);
    }

    public final void uj(int i) {
        j.so();
        int o = j.o(this.context, i);
        this.lNc = o;
        if (o > 0 && this.lMo != null) {
            v.d("MicroMsg.ChatFooter", "set bottom panel height: %d", Integer.valueOf(o));
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 0);
            layoutParams.height = o;
            this.lMo.setLayoutParams(layoutParams);
        }
        if (this.lMi != null) {
            this.lMi.ud(o);
            AppPanel appPanel = this.lMi;
            appPanel.bpy();
            appPanel.ahk();
        }
        if (this.lMh != null) {
            this.lMh.um(o);
            this.lMh.bpy();
        }
        if (this.hhM != null) {
            if (!bqh()) {
                bqc();
            }
            this.hhM.jS(o);
            this.hhM.ahq();
        }
    }

    public final void bqj() {
        this.ewV = false;
        this.lMl.setBackgroundDrawable(com.tencent.mm.bd.a.a(getContext(), 2130839043));
        this.lMl.setText(2131231751);
        if (this.lMu == null) {
            return;
        }
        if (this.fTf == null || this.fTf.getVisibility() != 0) {
            this.lMu.azh();
        } else {
            this.lMu.azj();
        }
    }

    public final boolean bqk() {
        return this.lNd - getTop() > 50;
    }

    public final void HH(String str) {
        this.fmg = str;
        if (this.hhM != null) {
            this.hhM.rL(this.fmg);
        }
        if (this.lMi == null) {
            return;
        }
        if (m.fn(this.fmg) || m.fg(this.fmg)) {
            this.lMi.lLs = 0;
        } else if (m.eD(this.fmg)) {
            this.lMi.lLs = 4;
        } else if (m.dE(this.fmg)) {
            this.lMi.lLs = 2;
        } else {
            this.lMi.lLs = 1;
        }
    }

    public final void bql() {
        ak.yW();
        this.lMI = ((Boolean) com.tencent.mm.model.c.vf().get(66832, Boolean.valueOf(false))).booleanValue();
    }

    public final void uk(int i) {
        this.lNo = null;
        this.lNn = i;
    }

    public void onGlobalLayout() {
        if (this.aXH != null && this.aXH.getWindow() != null && this.aXH.getWindow().getDecorView() != null) {
            if (this.lNn == -1) {
                v.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
                return;
            }
            if (this.lNo == null) {
                this.lNo = this.aXH.getWindow().getDecorView().findViewById(this.lNn);
            }
            if (this.lNo == null) {
                v.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", Integer.valueOf(this.lNn));
                return;
            }
            int height = this.lNo.getHeight();
            int width = this.lNo.getWidth();
            v.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", Integer.valueOf(this.lNo.getMeasuredHeight()), Integer.valueOf(height));
            if (this.lNf < height) {
                this.lNf = height;
            }
            this.lNe = height;
            if (this.lNl <= 0) {
                this.lNl = height;
            } else if (this.lNm <= 0) {
                this.lNm = width;
            } else if (this.lNl != height || this.lNm != width) {
                if (bqh() && this.lMK) {
                    this.lMK = false;
                    v.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                    postDelayed(new Runnable(this) {
                        final /* synthetic */ ChatFooter lNr;

                        {
                            this.lNr = r1;
                        }

                        public final void run() {
                            this.lNr.bqg();
                        }
                    }, 10);
                }
                v.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", Integer.valueOf(this.lNl), Integer.valueOf(height));
                int abs = Math.abs(this.lNl - height);
                this.lNl = height;
                height = Math.abs(this.lNm - width);
                this.lNm = width;
                v.d("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", Integer.valueOf(height));
                if (this.lNp) {
                    if (abs == 0) {
                        if (this.lMi != null) {
                            this.lMi.lLE = true;
                            this.lMi.ahk();
                        }
                        if (this.hhM != null) {
                            this.hhM.jS(j.aD(this.context));
                            bqc();
                            this.hhM.ahq();
                        }
                    } else if (j.aF(this.context)) {
                        v.d("MicroMsg.ChatFooter", "alvinluo keyboard current height: %d", Integer.valueOf(this.lNc));
                        if (this.lNc != abs || abs == -1) {
                            height = j.aD(this.context);
                            v.d("MicroMsg.ChatFooter", "alvinluo valid panel height: %d", Integer.valueOf(height));
                            if (abs >= j.aC(this.context) && abs <= j.aB(this.context)) {
                                height = abs;
                            }
                            if (this.lMT) {
                                this.lMT = false;
                                if (height < this.lNc) {
                                    height = this.lNc;
                                }
                                this.lNc = height;
                                uj(height);
                            } else {
                                this.lNc = height;
                                v.i("MicroMsg.ChatFooter", "jacks calc keyBord dialog height:%d", Integer.valueOf(this.lNc));
                                j.n(getContext(), height);
                                uj(height);
                            }
                        }
                    } else {
                        return;
                    }
                }
                v.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: " + abs);
            }
        }
    }

    public final int bqm() {
        int aD = j.aD(getContext());
        int height = getHeight();
        return height < aD ? height + aD : height;
    }
}
