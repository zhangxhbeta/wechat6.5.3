package com.tencent.mm.ui.base;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bi.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class h extends Dialog implements DialogInterface {
    private View dUU;
    private TextView fCp;
    private boolean iPt;
    private View kC;
    public EditText kL;
    public Button kUN;
    private Button kik;
    public Context mContext;
    public LinearLayout nTL;
    private TextView nTM;
    private TextView nTN;
    private TextView nTO;
    private TextView nTP;
    private CdnImageView nTQ;
    private View nTR;
    private ViewStub nTS;
    private LinearLayout nTT;
    private ViewGroup nTU;
    private LinearLayout nTV;
    private ViewGroup nTW;
    private View nTX;
    private boolean nTY = false;
    private Animation nTZ;
    private Animation nUa;
    private Animation nUb;
    private Animation nUc;
    private b nUd;
    private int[] nUe = new int[]{2131756421, 2131756422, 2131756423, 2131756424, 2131756425, 2131756426, 2131756427, 2131756428, 2131756429};

    public static class a {
        private Context mContext;
        public c nUn = new c();

        public interface a {
            void bpg();
        }

        public interface b {
            CharSequence a(CharSequence charSequence, float f);
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final a Op(String str) {
            this.nUn.title = str;
            return this;
        }

        public final a wm(int i) {
            this.nUn.title = this.mContext.getString(i);
            return this;
        }

        public final a Oq(String str) {
            this.nUn.nRO = str;
            return this;
        }

        public final a wn(int i) {
            this.nUn.nRO = this.mContext.getString(i);
            return this;
        }

        public final a K(CharSequence charSequence) {
            this.nUn.nRP = charSequence;
            return this;
        }

        public final a jj(boolean z) {
            this.nUn.nRU = z;
            return this;
        }

        public final a a(String str, CharSequence charSequence, Boolean bool, a aVar) {
            this.nUn.nRE = str;
            this.nUn.nRG = charSequence;
            this.nUn.nRH = bool.booleanValue();
            this.nUn.nRJ = aVar;
            return this;
        }

        public final a a(Bitmap bitmap, boolean z, int i) {
            this.nUn.nRN = bitmap;
            this.nUn.nRV = z;
            this.nUn.nSc = i;
            return this;
        }

        public final a wo(int i) {
            this.nUn.nSb = i;
            return this;
        }

        public final a Or(String str) {
            this.nUn.nRD = str;
            return this;
        }

        public final a cC(View view) {
            this.nUn.lks = view;
            return this;
        }

        public final a Os(String str) {
            this.nUn.nRR = str;
            return this;
        }

        public final a wp(int i) {
            this.nUn.nRR = this.mContext.getString(i);
            return this;
        }

        public final a a(OnClickListener onClickListener) {
            this.nUn.nRW = onClickListener;
            return this;
        }

        public final a a(boolean z, OnClickListener onClickListener) {
            this.nUn.nRW = onClickListener;
            this.nUn.nSe = z;
            return this;
        }

        public final a Ot(String str) {
            this.nUn.nRS = str;
            return this;
        }

        public final a wq(int i) {
            this.nUn.nRS = this.mContext.getString(i);
            return this;
        }

        public final a b(OnClickListener onClickListener) {
            this.nUn.nRX = onClickListener;
            return this;
        }

        public final a c(OnCancelListener onCancelListener) {
            this.nUn.Fe = onCancelListener;
            return this;
        }

        public final a a(OnDismissListener onDismissListener) {
            this.nUn.Ff = onDismissListener;
            return this;
        }

        public final a jk(boolean z) {
            this.nUn.iPt = z;
            return this;
        }

        public final a jl(boolean z) {
            this.nUn.nRT = z;
            return this;
        }

        public h RX() {
            h hVar = new h(this.mContext);
            hVar.a(this.nUn);
            return hVar;
        }
    }

    static /* synthetic */ void a(h hVar, Animation animation) {
        if (hVar.nTT != null) {
            hVar.nTT.startAnimation(animation);
        }
        if (hVar.nTV != null) {
            hVar.nTV.startAnimation(animation);
        }
        if (hVar.nTP != null && hVar.nTY) {
            hVar.nTP.startAnimation(animation);
        }
        if (hVar.kL != null) {
            hVar.kL.startAnimation(animation);
        }
    }

    public h(Context context) {
        super(context, 2131559263);
        this.mContext = context;
        this.nTL = (LinearLayout) q.em(this.mContext).inflate(2130903967, null);
        this.kUN = (Button) this.nTL.findViewById(2131756397);
        this.kik = (Button) this.nTL.findViewById(2131756396);
        this.fCp = (TextView) this.nTL.findViewById(2131758203);
        this.nTM = (TextView) this.nTL.findViewById(2131758207);
        this.nTN = (TextView) this.nTL.findViewById(2131756401);
        this.nTO = (TextView) this.nTL.findViewById(2131756402);
        this.nTP = (TextView) this.nTL.findViewById(2131756408);
        this.kL = (EditText) this.nTL.findViewById(2131756405);
        this.nTQ = (CdnImageView) this.nTL.findViewById(2131756400);
        this.dUU = this.nTL.findViewById(2131758202);
        this.nTS = (ViewStub) this.nTL.findViewById(2131758204);
        this.nTT = (LinearLayout) this.nTL.findViewById(2131757307);
        this.nTU = (ViewGroup) this.nTL.findViewById(2131758209);
        this.nTX = this.nTL.findViewById(2131758210);
        this.nTV = (LinearLayout) this.nTL.findViewById(2131758208);
        this.nTW = (ViewGroup) this.nTL.findViewById(2131758205);
        setCanceledOnTouchOutside(true);
        this.nTZ = AnimationUtils.loadAnimation(aa.getContext(), 2130968586);
        this.nUa = AnimationUtils.loadAnimation(aa.getContext(), 2130968586);
        this.nUb = AnimationUtils.loadAnimation(aa.getContext(), 2130968587);
        this.nUc = AnimationUtils.loadAnimation(aa.getContext(), 2130968587);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.nTL);
    }

    public final void setTitle(CharSequence charSequence) {
        this.dUU.setVisibility(0);
        this.fCp.setVisibility(0);
        if (this.nUd != null) {
            charSequence = this.nUd.a(charSequence.toString(), this.fCp.getTextSize());
        }
        this.fCp.setMaxLines(2);
        this.fCp.setText(charSequence);
    }

    public final void setTitle(int i) {
        this.dUU.setVisibility(0);
        this.fCp.setVisibility(0);
        this.fCp.setMaxLines(2);
        this.fCp.setText(i);
    }

    public final void setMessage(CharSequence charSequence) {
        this.nTT.setVisibility(0);
        this.nTM.setVisibility(0);
        if (this.nUd != null) {
            b bVar = this.nUd;
            this.nTM.getContext();
            charSequence = bVar.a(charSequence.toString(), this.nTM.getTextSize());
        }
        this.nTM.setText(charSequence);
    }

    private void jh(boolean z) {
        if (z) {
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 8);
            this.nTT.setVisibility(0);
            this.nTT.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.nTT.setBackgroundResource(2130838109);
        }
    }

    private void wj(int i) {
        if (this.nTT != null) {
            this.nTT.setVisibility(i);
        }
        if (this.nTV != null) {
            this.nTV.setVisibility(i);
        }
        if (this.nTP != null && this.nTY) {
            this.nTP.setVisibility(i);
        }
        if (this.kL != null) {
            this.kL.setVisibility(i);
        }
    }

    private void cm(List<String> list) {
        LinearLayout linearLayout;
        this.nTS.setLayoutResource(2130903404);
        try {
            linearLayout = (LinearLayout) this.nTS.inflate();
        } catch (Exception e) {
            this.nTS.setVisibility(0);
            linearLayout = null;
        }
        if (list != null) {
            int i = 0;
            for (String str : list) {
                if (i <= 8) {
                    int i2;
                    if (linearLayout != null) {
                        ImageView imageView = (ImageView) linearLayout.findViewById(this.nUe[i]);
                        if (str != null) {
                            imageView.setVisibility(0);
                            b.m(imageView, str);
                            i2 = i + 1;
                            i = i2;
                        }
                    }
                    i2 = i;
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    private void C(View view, int i) {
        this.kC = view;
        if (this.kC != null) {
            this.nTT.setVisibility(0);
            this.nTV.setVisibility(0);
            this.nTV.removeAllViews();
            this.nTV.setGravity(1);
            this.nTV.addView(this.kC, new LayoutParams(i, i));
        }
    }

    public final void a(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        if (this.kUN != null) {
            this.kUN.setVisibility(0);
            this.kUN.setText(charSequence);
            this.kUN.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ h nUh;

                public final void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onClick(this.nUh, -1);
                    }
                    if (z) {
                        this.nUh.dismiss();
                    }
                }
            });
        }
    }

    public final void wk(int i) {
        this.kUN.setTextColor(i);
    }

    public final void wl(int i) {
        this.kik.setTextColor(i);
    }

    public final void a(int i, OnClickListener onClickListener) {
        a(this.mContext.getString(i), true, onClickListener);
    }

    public final void b(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        if (this.kik != null) {
            this.kik.setVisibility(0);
            this.kik.setText(charSequence);
            this.kik.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ h nUh;

                public final void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onClick(this.nUh, -2);
                    }
                    if (z) {
                        this.nUh.cancel();
                    }
                }
            });
        }
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.iPt = z;
        setCanceledOnTouchOutside(this.iPt);
    }

    public final void ji(boolean z) {
        super.setCancelable(false);
    }

    public final Button getButton(int i) {
        switch (i) {
            case -2:
                return this.kik;
            case -1:
                return this.kUN;
            default:
                return null;
        }
    }

    public final void a(c cVar) {
        CharSequence charSequence;
        CharSequence charSequence2;
        ImageView imageView;
        TextView textView;
        if (cVar.title != null && cVar.title.length() > 0) {
            setTitle(cVar.title);
        }
        if (cVar.lFe != 0) {
            this.fCp.setTextColor(ColorStateList.valueOf(cVar.lFe));
        }
        if (cVar.nRZ != 0) {
            this.fCp.setMaxLines(cVar.nRZ);
        }
        if (cVar.nSa != 0) {
            this.nTM.setMaxLines(cVar.nSa);
        }
        if (cVar.lks != null) {
            C(cVar.lks, -1);
        }
        if (cVar.nRY != null) {
            this.nTR = cVar.nRY;
            if (this.nTR != null) {
                this.nTT.setVisibility(8);
                this.nTP.setVisibility(8);
                this.kL.setVisibility(8);
                this.nTW.removeAllViews();
                this.nTW.addView(this.nTR, new LayoutParams(-1, -1));
                this.nTW.setVisibility(8);
            }
        }
        if (cVar.nRL != null) {
            Drawable drawable = cVar.nRL;
            if (this.kC == null) {
                this.nTT.setVisibility(0);
                this.nTQ.setVisibility(0);
                this.nTQ.setBackgroundDrawable(drawable);
            }
        }
        if (cVar.nRO != null && cVar.nRO.length() > 0) {
            setMessage(cVar.nRO);
        }
        jh(cVar.nRU);
        if (cVar.bdZ != null) {
            String str = cVar.bdZ;
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 120);
            this.nTT.setVisibility(0);
            this.nTQ.setVisibility(0);
            this.nTQ.G(str, fromDPToPix, fromDPToPix);
            int i = cVar.nSd;
            this.nTT.setVisibility(i);
            this.nTQ.setVisibility(i);
        }
        if (!(cVar.nSf || cVar.nSg)) {
            if (cVar.nRO != null && cVar.nRO.length() > 0) {
                setMessage(cVar.nRO);
            }
            if (cVar.nRP == null || cVar.nRP.length() <= 0) {
                jh(false);
            } else {
                charSequence = cVar.nRP;
                this.nTT.setVisibility(0);
                this.nTN.setVisibility(0);
                this.nTN.setMaxLines(2);
                this.nTN.setText(charSequence);
            }
            if (cVar.nRQ != null && cVar.nRQ.length() > 0) {
                charSequence = cVar.nRQ;
                if (charSequence != null) {
                    this.nTT.setVisibility(0);
                    this.nTO.setVisibility(0);
                    if (this.nUd != null) {
                        b bVar = this.nUd;
                        this.nTO.getContext();
                        charSequence = bVar.a(charSequence.toString(), this.nTO.getTextSize());
                    }
                    this.nTO.setText(charSequence);
                }
            }
            if (cVar.nRM != null) {
                Bitmap bitmap = cVar.nRM;
                if (this.kC == null) {
                    this.nTT.setVisibility(0);
                    this.nTQ.setVisibility(0);
                    this.nTQ.setImageBitmap(bitmap);
                }
            }
        }
        Bitmap bitmap2;
        CharSequence charSequence3;
        View inflate;
        if (cVar.nSf) {
            bitmap2 = cVar.nRM;
            charSequence2 = cVar.nRP;
            charSequence3 = cVar.nRQ;
            inflate = q.em(this.mContext).inflate(2130903394, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(2131756400);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(2131756401);
                textView.setVisibility(0);
                if (this.nUd != null) {
                    charSequence2 = this.nUd.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(2131756402);
                textView.setVisibility(0);
                if (this.nUd != null) {
                    charSequence2 = this.nUd.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            C(inflate, -1);
        } else if (cVar.nSg) {
            bitmap2 = cVar.nRM;
            charSequence2 = cVar.nRP;
            charSequence3 = cVar.nRQ;
            inflate = q.em(this.mContext).inflate(2130903395, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(2131756400);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(2131756401);
                textView.setVisibility(0);
                if (this.nUd != null) {
                    charSequence2 = this.nUd.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(2131756402);
                textView.setVisibility(0);
                if (this.nUd != null) {
                    charSequence2 = this.nUd.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            C(inflate, -1);
        }
        if (!(cVar.nRE == null && cVar.nRG == null)) {
            String str2 = cVar.nRE;
            charSequence2 = cVar.nRG;
            Boolean valueOf = Boolean.valueOf(cVar.nRH);
            final a aVar = cVar.nRJ;
            this.nTS.setLayoutResource(2130903403);
            LinearLayout linearLayout = null;
            try {
                linearLayout = (LinearLayout) this.nTS.inflate();
            } catch (Exception e) {
                this.nTS.setVisibility(0);
            }
            if (!(linearLayout == null || str2 == null)) {
                imageView = (ImageView) linearLayout.findViewById(2131756418);
                imageView.setVisibility(0);
                b.m(imageView, str2);
            }
            if (!(linearLayout == null || charSequence2 == null)) {
                textView = (TextView) linearLayout.findViewById(c.pfh);
                textView.setVisibility(0);
                if (this.nUd != null) {
                    charSequence2 = this.nUd.a(charSequence2.toString(), this.fCp.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (valueOf.booleanValue() && linearLayout != null) {
                imageView = (ImageView) linearLayout.findViewById(2131756420);
                imageView.setVisibility(0);
                wj(0);
                linearLayout.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ h nUh;

                    public final void onClick(View view) {
                        if (aVar != null) {
                            aVar.bpg();
                        }
                        if (imageView.isSelected()) {
                            this.nUh.nTW.startAnimation(this.nUh.nUc);
                            this.nUh.nUc.setAnimationListener(new AnimationListener(this) {
                                final /* synthetic */ AnonymousClass1 nUi;

                                {
                                    this.nUi = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                    h.a(this.nUi.nUh, this.nUi.nUh.nTZ);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    this.nUi.nUh.nTW.setVisibility(8);
                                    this.nUi.nUh.wj(0);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView, "rotation", new float[]{180.0f, 0.0f}).setDuration(200).start();
                            imageView.setSelected(false);
                            return;
                        }
                        this.nUh.nTW.startAnimation(this.nUh.nUa);
                        this.nUh.nUa.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ AnonymousClass1 nUi;

                            {
                                this.nUi = r1;
                            }

                            public final void onAnimationStart(Animation animation) {
                                h.a(this.nUi.nUh, this.nUi.nUh.nUb);
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.nUi.nUh.nTW.setVisibility(0);
                                this.nUi.nUh.wj(8);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 180.0f}).setDuration(200).start();
                        imageView.setSelected(true);
                    }
                });
            }
        }
        if (cVar.nRF != null) {
            cm(cVar.nRF);
        }
        if (!(cVar.nRN == null || cVar.nRN.isRecycled())) {
            Bitmap bitmap3 = cVar.nRN;
            boolean z = cVar.nRV;
            int i2 = cVar.nSc;
            if (bitmap3 != null) {
                Bitmap bitmap4;
                jh(false);
                this.nTT.setVisibility(0);
                this.nTT.setGravity(1);
                this.nTT.setPadding(0, 0, 0, 0);
                View inflate2 = View.inflate(this.mContext, 2130903396, null);
                imageView = (ImageView) inflate2.findViewById(2131756400);
                if (z) {
                    int i3;
                    int i4;
                    bitmap4 = null;
                    float height = ((float) bitmap3.getHeight()) / ((float) bitmap3.getWidth());
                    int N = com.tencent.mm.bd.a.N(this.mContext, 2131493019);
                    int N2 = com.tencent.mm.bd.a.N(this.mContext, 2131493018);
                    if (height > 0.0f && ((double) height) < 0.5d) {
                        i3 = (int) (((float) N) / height);
                        i4 = N;
                    } else if (((double) height) >= 0.5d && height < 1.0f) {
                        N = (int) (((float) N2) * height);
                        i3 = N2;
                        i4 = N;
                    } else if (height >= 1.0f && height < 2.0f) {
                        N = (int) (((float) N2) / height);
                        i3 = N;
                        i4 = N2;
                        r18 = N2;
                        N2 = N;
                        N = r18;
                    } else if (height >= 2.0f) {
                        i4 = (int) (((float) N) * height);
                        i3 = N;
                        r18 = N;
                        N = N2;
                        N2 = r18;
                    } else {
                        N = 0;
                        N2 = 0;
                        i3 = 0;
                        i4 = 0;
                    }
                    if (i4 > 0 && i3 > 0 && bitmap3 != null) {
                        bitmap4 = Bitmap.createScaledBitmap(bitmap3, i3, i4, true);
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(N2, N));
                    }
                    bitmap4 = d.a(bitmap4, true, (float) com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 3));
                } else {
                    bitmap4 = bitmap3;
                }
                imageView.setImageBitmap(bitmap4);
                imageView = (ImageView) inflate2.findViewById(2131756403);
                if (i2 == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    if (i2 == 1) {
                        imageView.setImageResource(2131165239);
                    } else if (i2 == 2) {
                        imageView.setImageResource(2131165245);
                    }
                }
                C(inflate2, -2);
            }
        }
        if (cVar.nRC != null && cVar.nRC.length() > 0) {
            charSequence = cVar.nRC;
            if (charSequence != null) {
                this.nTP.setVisibility(0);
                this.nTP.setText(charSequence);
            }
            this.nTY = true;
            i = cVar.nSb;
            if (this.nTP != null) {
                this.nTP.setGravity(i);
            }
        }
        if (cVar.nRD != null && cVar.nRD.length() > 0) {
            charSequence = cVar.nRD;
            this.kL.setVisibility(0);
            this.kL.setHint(charSequence);
        }
        if (cVar.nRR != null && cVar.nRR.length() > 0) {
            a(cVar.nRR, cVar.nSe, cVar.nRW);
        }
        if (cVar.nRS != null && cVar.nRS.length() > 0) {
            b(cVar.nRS, true, cVar.nRX);
        }
        if (cVar.Fe != null) {
            setOnCancelListener(cVar.Fe);
        }
        if (cVar.Ff != null) {
            setOnDismissListener(cVar.Ff);
        }
        if (cVar.nRK != null) {
            this.nUd = cVar.nRK;
        }
        setCancelable(cVar.iPt);
        this.iPt = cVar.iPt;
        if (!this.iPt) {
            super.setCancelable(cVar.nRT);
        }
        if (cVar.nRI) {
            View inflate3 = q.em(getContext()).inflate(2130903392, null);
            this.kik = (Button) inflate3.findViewById(2131756396);
            this.kUN = (Button) inflate3.findViewById(2131756397);
            if (cVar.nRR != null && cVar.nRR.length() > 0) {
                a(cVar.nRR, cVar.nSe, cVar.nRW);
            }
            if (cVar.nRS != null && cVar.nRS.length() > 0) {
                b(cVar.nRS, true, cVar.nRX);
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.nTX.setVisibility(8);
            this.nTU.removeAllViews();
            this.nTU.addView(inflate3, layoutParams);
        }
    }

    public final void show() {
        try {
            super.show();
        } catch (Throwable e) {
            v.a("MicroMsg.MMAlertDialog", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ad.o(new Runnable(this) {
                final /* synthetic */ h nUh;

                {
                    this.nUh = r1;
                }

                public final void run() {
                    this.nUh.dismiss();
                }
            });
            v.e("MicroMsg.MMAlertDialog", be.bur().toString());
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
