package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.radar.a.c.d;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class RadarMemberView extends RelativeLayout {
    private u euW;
    private ac handler = new ac(this) {
        final /* synthetic */ RadarMemberView ijm;

        {
            this.ijm = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 0) {
                this.ijm.a(this.ijm.iiD, this.ijm.iiE);
            } else if (message.what == 1) {
                this.ijm.setVisibility(4);
                this.ijm.reset();
                if (this.ijm.iiT != null) {
                    this.ijm.iiT.setVisibility(0);
                }
                if (this.ijm.ijg != null) {
                    this.ijm.ijg.c(this.ijm.iiD, this.ijm.iiE);
                }
            }
        }
    };
    private EditText idd = null;
    public apa iiD = null;
    public d iiE = null;
    private View iiT = null;
    private View iiU = null;
    private ImageView iiV = null;
    private View iiW = null;
    private Button iiX = null;
    private TextView iiY = null;
    private TextView iiZ = null;
    private Button ija = null;
    private TextView ijb = null;
    private int[] ijc = null;
    private TextView ijd = null;
    private boolean ije = false;
    private ba ijf;
    a ijg = null;
    private OnClickListener ijh = new OnClickListener(this) {
        final /* synthetic */ RadarMemberView ijm;

        {
            this.ijm = r1;
        }

        public final void onClick(View view) {
            String str = "";
            if (this.ijm.euW != null) {
                if (com.tencent.mm.i.a.ei(this.ijm.euW.field_type)) {
                    str = this.ijm.euW.field_conRemark;
                } else {
                    ak.yW();
                    ba Nw = c.wI().Nw(this.ijm.euW.field_username);
                    if ((Nw == null || be.kS(Nw.field_encryptUsername)) && !be.kS(this.ijm.euW.field_encryptUsername)) {
                        ak.yW();
                        Nw = c.wI().Nw(this.ijm.euW.field_encryptUsername);
                    }
                    if (Nw != null) {
                        str = Nw.field_conRemark;
                    }
                }
            }
            if (be.kS(str) && this.ijm.iiD != null) {
                str = this.ijm.iiD.efy;
            }
            RadarMemberView.a(this.ijm, str);
        }
    };
    private h iji = null;
    private View ijj = null;
    private TextView ijk = null;
    private TextView ijl = null;

    public interface a {
        void b(apa com_tencent_mm_protocal_c_apa, d dVar);

        void c(apa com_tencent_mm_protocal_c_apa, d dVar);
    }

    static /* synthetic */ void a(RadarMemberView radarMemberView, String str) {
        radarMemberView.ijj = View.inflate(radarMemberView.getContext(), 2130904345, null);
        radarMemberView.ijk = (TextView) radarMemberView.ijj.findViewById(2131759061);
        radarMemberView.ijk.setText("");
        radarMemberView.idd = (EditText) radarMemberView.ijj.findViewById(2131759062);
        radarMemberView.ijl = (TextView) radarMemberView.ijj.findViewById(2131756526);
        radarMemberView.ijl.setVisibility(0);
        radarMemberView.idd.setText(str);
        radarMemberView.ijl.setText("50");
        radarMemberView.idd.setFilters(i.lTR);
        radarMemberView.idd.addTextChangedListener(new TextWatcher(radarMemberView) {
            final /* synthetic */ RadarMemberView ijm;

            {
                this.ijm = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = false;
                int length = 50 - editable.length();
                if (length < 0) {
                    length = 0;
                }
                if (this.ijm.ijl != null) {
                    this.ijm.ijl.setText(String.valueOf(length));
                }
                if (this.ijm.iji != null) {
                    Button button = this.ijm.iji.getButton(-1);
                    if (editable.length() > 0) {
                        z = true;
                    }
                    button.setEnabled(z);
                }
            }
        });
        radarMemberView.iji = g.a(radarMemberView.getContext(), radarMemberView.getContext().getString(2131234296), radarMemberView.ijj, new DialogInterface.OnClickListener(radarMemberView) {
            final /* synthetic */ RadarMemberView ijm;

            {
                this.ijm = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.ijm.iji != null) {
                    this.ijm.iji.dismiss();
                    this.ijm.iji = null;
                }
                RadarMemberView.k(this.ijm);
            }
        }, new DialogInterface.OnClickListener(radarMemberView) {
            final /* synthetic */ RadarMemberView ijm;

            {
                this.ijm = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.ijm.iji != null) {
                    this.ijm.iji.dismiss();
                    this.ijm.iji = null;
                }
            }
        });
        radarMemberView.idd.post(new Runnable(radarMemberView) {
            final /* synthetic */ RadarMemberView ijm;

            {
                this.ijm = r1;
            }

            public final void run() {
                if (this.ijm.getContext() instanceof Activity) {
                    RadarMemberView.J((Activity) this.ijm.getContext());
                }
            }
        });
    }

    static /* synthetic */ boolean k(RadarMemberView radarMemberView) {
        if (radarMemberView.idd == null) {
            return false;
        }
        String trim = radarMemberView.idd.getText().toString().trim();
        String b = c.b(radarMemberView.iiD);
        if (be.kS(b)) {
            return false;
        }
        if (com.tencent.mm.i.a.ei(radarMemberView.euW.field_type)) {
            ak.yW();
            ba Nw = c.wI().Nw(radarMemberView.euW.field_username);
            if ((Nw == null || be.kS(Nw.field_encryptUsername)) && !be.kS(radarMemberView.euW.field_encryptUsername)) {
                ak.yW();
                Nw = c.wI().Nw(radarMemberView.euW.field_encryptUsername);
            }
            if (!(Nw == null || be.kS(Nw.field_encryptUsername))) {
                ak.yW();
                c.wI().Nx(Nw.field_encryptUsername);
            }
            radarMemberView.euW.bQ(trim);
            m.b(radarMemberView.euW, trim);
        } else {
            radarMemberView.euW.bQ(trim);
            ak.yW();
            c.wI().c(new ba(b, trim));
        }
        if (radarMemberView.iiZ != null) {
            radarMemberView.iiZ.setText(trim);
        }
        return true;
    }

    public RadarMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarMemberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void c(String str, d dVar) {
        if (isShowing() && !this.ije) {
            if (str.equals(this.iiD.mrE) || str.equals(this.iiD.gln)) {
                a(this.iiD, dVar);
            }
        }
    }

    private void a(apa com_tencent_mm_protocal_c_apa, d dVar) {
        this.ijd.setVisibility(0);
        switch (dVar) {
            case Stranger:
                this.iiZ.setVisibility(0);
                this.ija.setVisibility(0);
                this.iiX.setText(2131234301);
                this.iiX.setVisibility(0);
                this.iiY.setVisibility(8);
                this.ijb.setVisibility(8);
                return;
            case Verifying:
                this.iiZ.setVisibility(0);
                this.ija.setVisibility(0);
                this.iiY.setText(2131234308);
                this.iiX.setVisibility(8);
                this.iiY.setVisibility(0);
                this.ijb.setVisibility(8);
                return;
            case Added:
                this.iiZ.setVisibility(0);
                this.ija.setVisibility(0);
                this.iiY.setText(2131234288);
                this.iiX.setVisibility(8);
                this.iiY.setVisibility(0);
                this.ijb.setVisibility(8);
                return;
            case NeedVerify:
                this.iiZ.setVisibility(0);
                this.ija.setVisibility(0);
                this.iiX.setText(2131234287);
                this.iiX.setVisibility(0);
                this.iiY.setVisibility(8);
                this.ijb.setText(getContext().getString(2131234299, new Object[]{com_tencent_mm_protocal_c_apa.efy}));
                this.ijb.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void a(View view, final apa com_tencent_mm_protocal_c_apa, d dVar) {
        CharSequence charSequence;
        v.d("MicroMsg.RadarMemberView", "popup");
        this.iiE = dVar;
        this.iiD = com_tencent_mm_protocal_c_apa;
        if (this.iiU == null) {
            this.iiU = findViewById(2131758731);
        }
        if (this.iiV == null) {
            this.iiV = (ImageView) findViewById(2131758735);
        }
        if (this.iiW == null) {
            this.iiW = findViewById(2131758734);
        }
        if (this.iiX == null) {
            this.iiX = (Button) findViewById(2131758730);
        }
        this.iiX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RadarMemberView ijm;

            public final void onClick(View view) {
                if (this.ijm.iiE != null && this.ijm.ijg != null) {
                    this.ijm.ijg.b(com_tencent_mm_protocal_c_apa, this.ijm.iiE);
                    this.ijm.dismiss();
                }
            }
        });
        if (this.iiY == null) {
            this.iiY = (TextView) findViewById(2131758729);
        }
        if (this.iiZ == null) {
            this.iiZ = (TextView) findViewById(2131758732);
        }
        if (this.ija == null) {
            this.ija = (Button) findViewById(2131758733);
            this.ija.setOnClickListener(this.ijh);
        }
        if (this.ijb == null) {
            this.ijb = (TextView) findViewById(2131758728);
        }
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ RadarMemberView ijm;

            {
                this.ijm = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view != this.ijm.iiX && motionEvent.getAction() == 1 && this.ijm.isShowing()) {
                    this.ijm.dismiss();
                }
                return true;
            }
        });
        if (this.ijd == null) {
            this.ijd = (TextView) findViewById(2131758736);
        }
        this.ijd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RadarMemberView ijm;

            {
                this.ijm = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("k_username", this.ijm.euW.field_username);
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(38)}));
                com.tencent.mm.ay.c.b(this.ijm.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        String b = c.b(com_tencent_mm_protocal_c_apa);
        if (!be.kS(b)) {
            ak.yW();
            this.euW = c.wH().LX(b);
        }
        if (this.euW == null || !com.tencent.mm.i.a.ei(this.euW.field_type)) {
            ak.yW();
            this.ijf = c.wI().Nw(b);
            charSequence = this.ijf.field_conRemark;
        } else {
            charSequence = this.euW.field_conRemark;
        }
        if (this.euW == null || be.kS(charSequence)) {
            this.iiZ.setText(e.a(getContext(), com_tencent_mm_protocal_c_apa.efy, this.iiZ.getTextSize()));
        } else {
            this.iiZ.setText(e.a(getContext(), charSequence, this.iiZ.getTextSize()));
        }
        this.iiZ.setVisibility(4);
        this.ija.setVisibility(4);
        reset();
        this.iiT = view;
        ImageView imageView = (ImageView) this.iiT.findViewById(2131758739);
        View findViewById = this.iiT.findViewById(2131758734);
        this.iiT.setVisibility(4);
        this.iiV.setImageDrawable(imageView.getDrawable());
        this.iiW.setVisibility(0);
        int[] iArr = new int[2];
        findViewById.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        this.iiU.getLocationInWindow(iArr2);
        this.ijc = iArr2;
        setVisibility(0);
        Animation animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        float height = ((float) this.iiU.getHeight()) / ((float) findViewById.getHeight());
        Animation translateAnimation = new TranslateAnimation((float) iArr[0], ((float) iArr2[0]) - (((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height), (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(1.0f, height, 1.0f, height));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ RadarMemberView ijm;

            {
                this.ijm = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                v.d("MicroMsg.RadarMemberView", "popup animation end");
                this.ijm.handler.sendEmptyMessage(0);
            }
        });
        this.iiW.startAnimation(animationSet);
    }

    public final void dismiss() {
        v.d("MicroMsg.RadarMemberView", "dismiss");
        if (!this.ije) {
            this.ije = true;
            View findViewById = this.iiT.findViewById(2131758734);
            Animation animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            animationSet.setRepeatCount(1);
            animationSet.setDuration(500);
            int[] iArr = this.ijc;
            int[] iArr2 = new int[2];
            findViewById.getLocationInWindow(iArr2);
            float height = ((float) this.iiU.getHeight()) / ((float) findViewById.getHeight());
            Animation translateAnimation = new TranslateAnimation(((float) iArr[0]) - (((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height), (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
            animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarMemberView ijm;

                {
                    this.ijm = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    v.d("MicroMsg.RadarMemberView", "dismiss animation end");
                    this.ijm.ije = false;
                    this.ijm.handler.sendEmptyMessage(1);
                }
            });
            this.iiZ.setVisibility(4);
            this.ija.setVisibility(4);
            this.iiX.setVisibility(8);
            this.iiY.setVisibility(8);
            this.ijb.setVisibility(8);
            this.ijd.setVisibility(8);
            this.iiW.startAnimation(animationSet);
        }
    }

    private void reset() {
        this.iiW.setVisibility(8);
        this.iiZ.setVisibility(4);
        this.ija.setVisibility(4);
        this.iiX.setVisibility(8);
        this.iiY.setVisibility(8);
        this.ijb.setVisibility(8);
        this.ijd.setVisibility(8);
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    public static void J(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
