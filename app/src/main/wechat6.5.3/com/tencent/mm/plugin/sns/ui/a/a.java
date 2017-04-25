package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.ah;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.u;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.MaskImageButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public boolean DEBUG = false;
    protected int eKg;
    protected boolean jMd = false;
    public ArrayList<com.tencent.mm.plugin.sns.e.am.b> jZZ = new ArrayList();
    protected as jpB;
    protected Activity pP;

    public static class c {
        public String bap;
        public String boC;
        public TextView dtB;
        public ImageView dtX;
        public int eKg;
        public TextView fBO;
        public boolean ghH;
        public aic jBT;
        public LinearLayout jDC;
        public ImageView jEe;
        public TextView jFY;
        public int jMT = 210;
        public TextView jSa;
        public View jSd;
        public String jbF;
        public awa jbw;
        public boolean jdE;
        public bc jdF;
        public TextView jip;
        public TextView jzt;
        public PhotosContent kaA;
        public View kaB;
        public ViewStub kaC;
        public boolean kaD = false;
        public ViewStub kaE;
        public ViewStub kaF;
        public View kaG = null;
        public boolean kaH = false;
        public boolean kaI = false;
        public ViewStub kaJ;
        public boolean kaK = false;
        public View kaL;
        public LinearLayout kaM;
        public TextView kaN;
        public ViewStub kaO;
        public boolean kaP = false;
        public View kaQ;
        public LinearLayout kaR;
        public ViewStub kaS;
        public boolean kaT = false;
        public View kaU;
        public ImageView kaV;
        public boolean kaW = false;
        ViewStub kaX;
        boolean kaY = false;
        public ah kaZ = new ah();
        public long kab;
        public int kac;
        public View kad;
        public AsyncTextView kae;
        public ImageView kaf;
        public ViewGroup kag;
        public AsyncNormalTextView kah;
        public SnsTranslateResultView kai;
        public ViewStub kaj;
        public boolean kak = false;
        public TextView kal;
        public TagImageView kam;
        public TextView kan;
        public int kao = 0;
        public TextView kap;
        public AsyncTextView kaq;
        public TextView kar;
        public View kas;
        public ImageView kat;
        public View kau;
        public MaskTextView kav;
        public LinearLayout kaw;
        public LinearLayout kax;
        public View kay;
        public LinearLayout kaz;
        public azr kba;
        public com.tencent.mm.i.a kbb;
        public View kbc;
        public a kbd;
        public ViewStub kbe;
        public View kbf;
        public MaskTextView kbg;
        public View kbh;
        TextView kbi;
        public String kbj;
        public int position;
    }

    class a extends j {
        final /* synthetic */ a kaa;

        a(a aVar) {
            this.kaa = aVar;
        }

        public final void onClick(View view) {
            this.kaa.jpB.jMO.jZd.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.kaa.pP.getResources().getColor(2131690028);
            if (this.hsl) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    class b extends j {
        final /* synthetic */ a kaa;

        b(a aVar) {
            this.kaa = aVar;
        }

        public final void onClick(View view) {
            this.kaa.jpB.jMO.jYT.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.kaa.pP.getResources().getColor(2131690028);
            if (this.hsl) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    class d extends j {
        final /* synthetic */ a kaa;

        d(a aVar) {
            this.kaa = aVar;
        }

        public final void onClick(View view) {
            this.kaa.jpB.jMO.jYU.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.kaa.pP.getResources().getColor(2131690028);
            if (this.hsl) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    public abstract void a(c cVar, int i, av avVar, azr com_tencent_mm_protocal_c_azr, int i2, as asVar);

    public abstract void d(c cVar);

    public final void gz(boolean z) {
        this.jMd = z;
    }

    public final View a(Activity activity, c cVar, int i, as asVar, k kVar) {
        String str;
        String str2;
        View a;
        this.pP = activity;
        this.eKg = i;
        this.jpB = asVar;
        switch (i) {
            case 0:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 1:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 2:
                str = "R.layout.sns_timeline_imagesline_one";
                break;
            case 3:
                str = "R.layout.sns_timeline_imagesline1";
                break;
            case 4:
                str = "R.layout.sns_timeline_imagesline2";
                break;
            case 5:
                str = "R.layout.sns_timeline_imagesline3";
                break;
            case 6:
                str = "R.layout.sns_timeline_item_photo_one3";
                break;
            case 7:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 8:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 9:
                str = "R.layout.sns_media_sight_item";
                break;
            case 10:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 11:
                str = "R.layout.sns_hb_reward_item";
                break;
            default:
                str = "R.layout.sns_media_sub_item2";
                break;
        }
        if ((i != 2 && i != 9) || !kVar.qC(32)) {
            str2 = str;
            a = com.tencent.mm.kiss.a.b.vH().a(this.pP, str, 2130904512);
        } else if (kVar.aUm().juN == 1) {
            str2 = "R.layout.sns_timeline_imagesline_one_ad";
            if (i == 9) {
                str2 = "R.layout.sns_timeline_imagesline_one_ad_sight";
            }
            a = com.tencent.mm.kiss.a.b.vH().a(this.pP, str2, 2130904511);
        } else {
            str2 = str;
            a = com.tencent.mm.kiss.a.b.vH().a(this.pP, str, 2130904512);
        }
        cVar.kbj = str2;
        View findViewById = a.findViewById(2131759294);
        if (findViewById instanceof ViewStub) {
            cVar.kaj = (ViewStub) findViewById;
        } else {
            cVar.kaj = null;
        }
        v.i("MicroMsg.BaseTimeLineItem", "create new item  " + i + "  " + a.hashCode());
        cVar.kbc = a.findViewById(2131759489);
        cVar.eKg = i;
        cVar.dtX = (MaskImageButton) a.findViewById(2131759292);
        cVar.dtX.setOnClickListener(asVar.joV.kbw);
        cVar.dtX.setOnLongClickListener(asVar.joV.kbx);
        cVar.kae = (AsyncTextView) a.findViewById(2131756539);
        cVar.kaf = (ImageView) a.findViewById(2131759299);
        cVar.kae.setOnTouchListener(new y());
        cVar.kag = (ViewGroup) a.findViewById(2131759490);
        cVar.kah = (AsyncNormalTextView) a.findViewById(2131759492);
        cVar.kah.e(asVar.jUp);
        if (kVar.qC(32)) {
            com.tencent.mm.plugin.sns.storage.b aUm = kVar.aUm();
            if (aUm != null && aUm.juO == 1) {
                cVar.kah.setContentWidth((((((WindowManager) this.pP.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12));
                cVar.kah.aVo();
            } else if (aUm != null && aUm.juO == 2) {
                cVar.kah.setContentWidth(((((WindowManager) this.pP.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bd.a.fromDPToPix(this.pP, 50)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12)) - com.tencent.mm.bd.a.fromDPToPix(this.pP, 12));
                cVar.kah.aVo();
            }
        }
        asVar.eyZ.a(a.findViewById(2131755458), asVar.joV.kby, asVar.joV.kbv);
        a.findViewById(2131755458).setOnTouchListener(new y());
        asVar.eyZ.a(a.findViewById(2131756358), asVar.joV.kby, asVar.joV.kbv);
        a.findViewById(2131756358).setOnTouchListener(new y());
        a.setOnTouchListener(asVar.joV.kbN);
        cVar.kai = (SnsTranslateResultView) a.findViewById(2131759300);
        cVar.kai.setVisibility(8);
        cVar.kai.jXx.setPadding(0, 0, (int) this.pP.getResources().getDimension(2131493199), 0);
        cVar.kai.iBv.setBackgroundResource(2130839207);
        asVar.eyZ.a(cVar.kai.iBv, asVar.joV.kby, asVar.joV.kbv);
        cVar.kaz = (LinearLayout) a.findViewById(2131759355);
        cVar.kap = (TextView) a.findViewById(2131759303);
        cVar.fBO = (TextView) a.findViewById(2131759304);
        cVar.kaq = (AsyncTextView) a.findViewById(2131759305);
        cVar.jSa = (TextView) a.findViewById(2131759302);
        cVar.jdF = new bc(a);
        cVar.jdF.a(asVar.joV.kbF, asVar.joV.kbS);
        cVar.jFY = (TextView) a.findViewById(2131759309);
        cVar.jFY.setText(activity.getString(2131231020));
        cVar.jFY.setOnClickListener(asVar.joV.kbz);
        cVar.kaq.setOnClickListener(asVar.joV.kbT);
        cVar.jSa.setOnClickListener(asVar.joV.kbP);
        cVar.kas = a.findViewById(2131759306);
        cVar.kas.setOnClickListener(asVar.joV.kbE);
        cVar.kar = (TextView) a.findViewById(2131759307);
        cVar.kat = (ImageView) a.findViewById(2131759316);
        cVar.kaC = (ViewStub) a.findViewById(2131759497);
        cVar.jDC = (LinearLayout) a.findViewById(2131759475);
        cVar.kbe = (ViewStub) a.findViewById(2131759496);
        cVar.kaE = (ViewStub) a.findViewById(2131759499);
        cVar.kal = (TextView) a.findViewById(2131759494);
        cVar.kal.setOnClickListener(asVar.joV.kbA);
        cVar.kbi = (TextView) a.findViewById(2131759308);
        cVar.kad = a;
        if (this.jMd) {
            com.tencent.mm.plugin.sns.abtest.c.b(a, cVar);
            com.tencent.mm.plugin.sns.abtest.a.a(a, cVar);
            ad.aSv();
            com.tencent.mm.plugin.sns.f.c.c(a, cVar);
        }
        d(cVar);
        a.setTag(cVar);
        return a;
    }

    public final void a(c cVar, int i, k kVar, azr com_tencent_mm_protocal_c_azr, int i2, as asVar) {
        String aUL;
        String str;
        CharSequence charSequence;
        com.tencent.mm.ui.a.a bAK;
        View view;
        TextView textView;
        TextView textView2;
        String str2;
        TextView textView3;
        boolean z;
        av avVar = (av) asVar.aXC().aVI().get(Integer.valueOf(i));
        this.eKg = i2;
        this.jpB = asVar;
        if (this.jMd) {
            au.B(kVar);
        }
        cVar.kab = avVar.jWv;
        cVar.ghH = false;
        cVar.position = i;
        cVar.boC = avVar.jWu;
        cVar.bap = avVar.jFt;
        cVar.kac = avVar.jWz;
        cVar.kat.setOnClickListener(asVar.jUo);
        cVar.kba = com_tencent_mm_protocal_c_azr;
        awa com_tencent_mm_protocal_c_awa = avVar.jaB;
        cVar.jbw = com_tencent_mm_protocal_c_awa;
        com.tencent.mm.plugin.sns.i.b bVar = asVar.jUe.jEo.jmQ;
        if (kVar != null) {
            aUL = kVar.aUL();
            bVar.jts.add(aUL);
            if (kVar.qC(32)) {
                bVar.jtx.add(aUL);
            }
            bVar.jty.add(kVar.field_userName);
            switch (kVar.field_type) {
                case 1:
                    bVar.jtu.add(aUL);
                    break;
                case 2:
                    bVar.jtt.add(aUL);
                    break;
                case 3:
                    if (!be.kS(com_tencent_mm_protocal_c_azr.mWr)) {
                        bVar.jtz.add(aUL);
                        break;
                    } else {
                        bVar.jtA.add(aUL);
                        break;
                    }
                case 4:
                    bVar.jtw.add(aUL);
                    break;
                case 5:
                    bVar.jtB.add(aUL);
                    break;
                case am.CTRL_INDEX /*15*/:
                    bVar.jtv.add(aUL);
                    break;
                case 18:
                    bVar.jtC.add(aUL);
                    break;
                default:
                    bVar.jtD.add(aUL);
                    break;
            }
            if (i < bVar.jtq) {
                bVar.jtq = i;
                bVar.jrW = i.g(kVar);
            }
            if (i > bVar.jtr) {
                bVar.jtr = i;
                bVar.jrX = i.g(kVar);
            }
            bVar.jsc = bVar.jtt.size();
            bVar.jsd = bVar.jtu.size();
            bVar.jse = bVar.jtv.size();
            bVar.jsg = bVar.jtw.size();
            bVar.jsf = bVar.jtx.size();
            bVar.jsh = bVar.jtB.size();
            bVar.jsp = bVar.jtC.size();
            bVar.eyU = bVar.jty.size();
            bVar.jsa = bVar.jtz.size();
            bVar.jsb = bVar.jtA.size();
            bVar.jso = bVar.jtD.size();
            bVar.jrK = bVar.jts.size();
        }
        aUL = avVar.dRA;
        if (aUL != null) {
            cVar.kbb = avVar.jWt;
            if (avVar.jWK) {
                v.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[]{aUL});
                if (com.tencent.mm.pluginsdk.ui.a.b.box().od() != null) {
                    cVar.dtX.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.box().od());
                }
                com.tencent.mm.model.ab.a.crZ.a(aUL, "", new com.tencent.mm.plugin.sns.ui.as.b(asVar.aXC(), i));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(cVar.dtX, aUL);
            }
            cVar.dtX.setTag(aUL);
            ((MaskImageButton) cVar.dtX).oTP = avVar.jFt;
            AsyncTextView asyncTextView = cVar.kae;
            String str3 = avVar.jWJ;
            com.tencent.mm.pluginsdk.ui.d.j.a aVar = asVar.jMK;
            boolean z2 = avVar.jEb;
            String str4 = avVar.jFt;
            asyncTextView.userName = aUL;
            asyncTextView.jEa = str3;
            asyncTextView.eKg = i2;
            asyncTextView.jEb = z2;
            asyncTextView.jEc = str4;
            asyncTextView.jEd = aVar;
            asyncTextView.run();
        }
        cVar.kaf.setVisibility(8);
        if (avVar.jEb) {
            cVar.jdE = true;
            cVar.ghH = avVar.jWA;
            cVar.jbF = avVar.jWB;
        } else {
            cVar.jdE = false;
            cVar.jbF = "";
        }
        AsyncNormalTextView asyncNormalTextView = cVar.kah;
        aUL = avVar.jWw;
        asyncNormalTextView.jDY = avVar.jWx;
        asyncNormalTextView.content = aUL;
        asyncNormalTextView.jpB = asVar;
        asyncNormalTextView.jDZ = avVar;
        if (be.kS(aUL)) {
            asyncNormalTextView.setVisibility(8);
        }
        cVar.kah.c(cVar);
        cVar.kar.setOnTouchListener(new y());
        a(cVar, i, avVar, com_tencent_mm_protocal_c_azr, i2, asVar);
        asVar.jUg.put(Integer.valueOf(i), new WeakReference(cVar.kad));
        if (cVar.kad.getBackground() == null) {
            cVar.kad.setBackgroundResource(2130838046);
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.pP, 12);
            cVar.kad.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, com.tencent.mm.bd.a.fromDPToPix(this.pP, 8));
        }
        cVar.fBO.setText(avVar.jWC);
        cVar.kaq.setVisibility(8);
        if (avVar.jEb) {
            com.tencent.mm.plugin.sns.storage.a aVar2 = avVar.jWD;
            cVar.kaq.setTag(avVar.jFt);
            if (avVar.jWD.juj == com.tencent.mm.plugin.sns.storage.a.jtV) {
                if (be.kS(avVar.jWG)) {
                    cVar.kaq.setVisibility(8);
                } else {
                    cVar.kaq.setText(avVar.jWG);
                    cVar.kaq.setVisibility(0);
                }
            } else if (aVar2.juj == com.tencent.mm.plugin.sns.storage.a.jtW) {
                if (be.kS(avVar.jWH)) {
                    cVar.kaq.setVisibility(8);
                } else {
                    str = avVar.jWI;
                    CharSequence charSequence2 = avVar.jWH;
                    Context context = this.pP;
                    cVar.kaq.getTextSize();
                    CharSequence fVar = new f(e.b(context, charSequence2, 1));
                    fVar.f(null, charSequence2);
                    TextPaint paint = cVar.kaq.getPaint();
                    if (com.tencent.mm.bd.a.P(this.pP, (int) Layout.getDesiredWidth(fVar, 0, fVar.length(), paint)) > cVar.jMT) {
                        while (str.length() > 1) {
                            str = str.substring(0, str.length() - 2);
                            fVar = String.format(aVar2.juk, new Object[]{str + "..."});
                            Context context2 = this.pP;
                            cVar.kaq.getTextSize();
                            CharSequence fVar2 = new f(e.b(context2, fVar, 1));
                            fVar2.f(null, fVar);
                            int P = com.tencent.mm.bd.a.P(this.pP, (int) Layout.getDesiredWidth(fVar2, 0, fVar2.length(), paint));
                            cVar.kaq.setText(fVar2, BufferType.SPANNABLE);
                            cVar.kaq.setVisibility(0);
                            if (P <= cVar.jMT) {
                            }
                        }
                    } else {
                        cVar.kaq.setText(fVar, BufferType.SPANNABLE);
                        cVar.kaq.setVisibility(0);
                    }
                }
            }
            if (cVar.kaq.getVisibility() != 8 && be.kS(aVar2.jul)) {
                cVar.kaq.setTextColor(this.pP.getResources().getColor(2131690050));
                cVar.kaq.setOnClickListener(null);
            }
        }
        if (avVar.jWM) {
            cVar.kbi.setText(asVar.aWn.getString(2131233679, new Object[]{Integer.valueOf(avVar.jWN)}));
            cVar.kbi.setVisibility(0);
        } else {
            cVar.kbi.setVisibility(8);
        }
        cVar.jSa.setTag(avVar.jFt);
        if (be.kS(avVar.jWP)) {
            cVar.jSa.setVisibility(8);
        } else {
            cVar.jSa.setVisibility(0);
            cVar.jSa.setText(avVar.jWP);
            cVar.jSa.setClickable(avVar.jWQ);
            cVar.jSa.setTextColor(avVar.jWQ ? -11048043 : -9211021);
        }
        cVar.kar.setTextColor(this.pP.getResources().getColor(2131690029));
        if (avVar.jWR) {
            cVar.kar.setVisibility(0);
            charSequence = this.pP.getString(2131235382) + avVar.dFj;
            if (charSequence.length() > 10) {
                charSequence = charSequence.substring(0, 10) + "...";
            }
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new b(this), 0, spannableString.length(), 33);
            cVar.kar.setText(spannableString, BufferType.SPANNABLE);
            if (!avVar.jWT) {
                cVar.kar.setTextColor(this.pP.getResources().getColor(2131690050));
                cVar.kar.setOnTouchListener(null);
            }
            cVar.kar.setTag(com_tencent_mm_protocal_c_azr);
        } else if (avVar.jWS) {
            cVar.kar.setVisibility(0);
            charSequence = new SpannableString(avVar.jWV);
            charSequence.setSpan(new d(this), 0, charSequence.length(), 33);
            cVar.kar.setText(charSequence, BufferType.SPANNABLE);
            cVar.kar.setTag(new ba(avVar.jWU, avVar.jWV));
        } else if (avVar.jWW) {
            cVar.kar.setVisibility(0);
            str = this.pP.getString(2131230914);
            Object obj = str + avVar.dFj;
            charSequence2 = new SpannableString(obj);
            charSequence2.setSpan(new ForegroundColorSpan(this.pP.getResources().getColor(2131690050)), 0, str.length(), 33);
            charSequence2.setSpan(new a(this), str.length(), obj.length(), 33);
            cVar.kar.setText(charSequence2, BufferType.SPANNABLE);
            if (!avVar.jWT) {
                cVar.kar.setTextColor(this.pP.getResources().getColor(2131690050));
                cVar.kar.setOnTouchListener(null);
            }
            cVar.kar.setTag(com_tencent_mm_protocal_c_azr);
        } else {
            cVar.kar.setVisibility(8);
        }
        if (avVar.jWL) {
            cVar.jFY.setVisibility(0);
            cVar.jFY.setTag(avVar.jFt);
        } else {
            cVar.jFY.setVisibility(8);
        }
        cVar.kat.setTag(cVar);
        if (avVar.jWX) {
            if (!cVar.kaI) {
                cVar.kax = (LinearLayout) cVar.kaE.inflate();
                cVar.kay = cVar.kad.findViewById(2131759447);
                cVar.kaI = true;
                cVar.kay.setTag(avVar.jFt);
                cVar.jzt = (TextView) cVar.kax.findViewById(2131759447);
            }
            cVar.kaE.setVisibility(0);
            cVar.kay.setOnClickListener(asVar.joV.kbD);
            switch (avVar.jWY) {
                case 201:
                    cVar.jzt.setText(2131235504);
                    cVar.kay.setClickable(false);
                    cVar.kay.setEnabled(false);
                    break;
                case 210:
                    cVar.jzt.setText(2131235506);
                    cVar.kay.setClickable(false);
                    cVar.kay.setEnabled(false);
                    break;
                case 211:
                    cVar.jzt.setText(2131235505);
                    cVar.kay.setClickable(true);
                    cVar.kay.setEnabled(true);
                    break;
                default:
                    cVar.jzt.setText(2131235507);
                    cVar.kay.setClickable(true);
                    cVar.kay.setEnabled(true);
                    break;
            }
            aic aUD = kVar.aUD();
            if (!(aUD == null || be.kS(aUD.mIB))) {
                cVar.jzt.setText(aUD.mIB);
            }
        } else if (cVar.kaI) {
            cVar.kaE.setVisibility(8);
        }
        if (avVar.jWZ) {
            cVar.kas.setVisibility(0);
            cVar.kas.setTag(avVar.jFt);
        } else {
            cVar.kas.setVisibility(8);
        }
        if (avVar.jXa) {
            if (!be.kS(avVar.jXb)) {
                cVar.kap.setVisibility(0);
                if (i2 == 7) {
                    charSequence = String.format(this.pP.getString(2131235563), new Object[]{avVar.jXb});
                } else {
                    charSequence = String.format(this.pP.getString(2131235564), new Object[]{avVar.jXb});
                }
                cVar.kap.setText(e.a(this.pP, charSequence, cVar.kap.getTextSize()));
            } else if (avVar.jXc) {
                cVar.kap.setVisibility(0);
                cVar.kap.setText(e.a(this.pP, this.pP.getString(2131235565).toString(), cVar.kap.getTextSize()));
            }
            if (avVar.jXd) {
                if (cVar.kbf == null) {
                    cVar.kbf = cVar.kbe.inflate();
                    cVar.jip = (TextView) cVar.kbf.findViewById(2131757966);
                    cVar.kbg = (MaskTextView) cVar.kbf.findViewById(2131757968);
                    cVar.kbg.setOnTouchListener(new y());
                }
                cVar.kbf.setVisibility(0);
                b(cVar.kbg, avVar.jXg, i2);
                cVar.jip.setText(this.pP.getString(2131235475, new Object[]{Integer.valueOf(avVar.jXe), com.tencent.mm.wallet_core.ui.e.m(avVar.jXf / 100.0d)}));
                cVar.kbf.setTag(kVar);
                cVar.kbf.setOnClickListener(asVar.joV.kbH);
            } else if (cVar.kbf != null) {
                cVar.kbf.setVisibility(8);
            }
            if ((avVar.jXh == null && avVar.jXh.size() != 0) || (avVar.jXi != null && avVar.jXi.size() != 0)) {
                if (!cVar.kaD) {
                    if (cVar.jDC == null) {
                        cVar.jDC = (LinearLayout) cVar.kaC.inflate();
                    }
                    cVar.kav = (MaskTextView) cVar.jDC.findViewById(2131759476);
                    cVar.kav.setOnTouchListener(new y());
                    cVar.kaw = (LinearLayout) cVar.kad.findViewById(2131759478);
                    cVar.jDC.setTag(avVar.jWu);
                    cVar.kav.setTag(avVar.jWu);
                    cVar.kaB = cVar.jDC.findViewById(2131759477);
                    cVar.kbh = cVar.jDC.findViewById(2131759475);
                    cVar.kaD = true;
                }
                cVar.jDC.setVisibility(0);
                if (avVar.jXh == null || avVar.jXh.size() <= 0) {
                    cVar.kav.setVisibility(8);
                } else {
                    cVar.kav.setVisibility(0);
                    a(cVar.kav, avVar.jXh, i2);
                }
                if (avVar.jXi != null) {
                    a(com_tencent_mm_protocal_c_awa.mTn, avVar.jXi, cVar);
                } else {
                    cVar.kaw.setVisibility(8);
                }
                if (avVar.jXh == null || avVar.jXh.size() == 0 || avVar.jXi == null || avVar.jXi.size() == 0) {
                    cVar.kaB.setVisibility(8);
                } else {
                    cVar.kaB.setVisibility(0);
                }
            } else if (cVar.jDC != null) {
                cVar.jDC.setVisibility(8);
            } else if (cVar.kaD) {
                cVar.kaC.setVisibility(8);
            }
            if (avVar.jXj) {
                cVar.kal.setVisibility(8);
            } else {
                cVar.kal.setTag(avVar.jFt);
                cVar.kal.setText(avVar.jXk);
                cVar.kal.setVisibility(0);
            }
            if (avVar.jEb) {
                cVar.jdF.setVisibility(8);
            } else {
                v.i("MicroMsg.BaseTimeLineItem", "adatag " + avVar.jWF);
                cVar.jdF.p(Long.valueOf(avVar.jWv), new com.tencent.mm.plugin.sns.data.b(cVar.jdF, cVar.position, avVar.jFt, avVar.jWv));
                cVar.jdF.a(avVar.jWE, avVar.jWD);
                cVar.jdF.setVisibility(0);
                if (cVar.jSa != null && cVar.jSa.getVisibility() == 0) {
                    if ((cVar.jdF.jYJ.getVisibility() != 0 ? 1 : null) != null) {
                        LayoutParams layoutParams = (LayoutParams) cVar.jSa.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.pP, 0.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
                        cVar.jSa.setLayoutParams(layoutParams);
                    }
                }
            }
            if (this.jMd) {
                ad.aSv().a(this.pP, com_tencent_mm_protocal_c_awa, cVar);
            }
            cVar.kai.iBv.setTag(new ap(avVar.jWu, avVar.jFt, false, true, 1));
            bAK = com.tencent.mm.ui.a.a.a.bAK();
            view = cVar.kad;
            textView = cVar.kae;
            textView2 = cVar.fBO;
            str2 = cVar.kah.content;
            textView3 = cVar.kan;
            z = cVar.kaY;
            if (bAK.bAJ() && bAK.aHq != null && view != null && textView != null && !be.kS(str2) && textView2 != null) {
                com.tencent.mm.ui.a.b bVar2 = new com.tencent.mm.ui.a.b();
                bVar2.Of(textView.getText().toString());
                bVar2.Of(str2);
                if (textView3 != null) {
                    bVar2.Of(textView3.getText().toString());
                }
                if (z) {
                    bVar2.Of(bAK.aHq.getString(2131232231));
                }
                bVar2.cy(view);
                return;
            }
            return;
        }
        cVar.kap.setVisibility(8);
        if (avVar.jXd) {
            if (cVar.kbf == null) {
                cVar.kbf = cVar.kbe.inflate();
                cVar.jip = (TextView) cVar.kbf.findViewById(2131757966);
                cVar.kbg = (MaskTextView) cVar.kbf.findViewById(2131757968);
                cVar.kbg.setOnTouchListener(new y());
            }
            cVar.kbf.setVisibility(0);
            b(cVar.kbg, avVar.jXg, i2);
            cVar.jip.setText(this.pP.getString(2131235475, new Object[]{Integer.valueOf(avVar.jXe), com.tencent.mm.wallet_core.ui.e.m(avVar.jXf / 100.0d)}));
            cVar.kbf.setTag(kVar);
            cVar.kbf.setOnClickListener(asVar.joV.kbH);
        } else if (cVar.kbf != null) {
            cVar.kbf.setVisibility(8);
        }
        if (avVar.jXh == null) {
        }
        if (cVar.jDC != null) {
            cVar.jDC.setVisibility(8);
        } else if (cVar.kaD) {
            cVar.kaC.setVisibility(8);
        }
        if (avVar.jXj) {
            cVar.kal.setVisibility(8);
        } else {
            cVar.kal.setTag(avVar.jFt);
            cVar.kal.setText(avVar.jXk);
            cVar.kal.setVisibility(0);
        }
        if (avVar.jEb) {
            cVar.jdF.setVisibility(8);
        } else {
            v.i("MicroMsg.BaseTimeLineItem", "adatag " + avVar.jWF);
            cVar.jdF.p(Long.valueOf(avVar.jWv), new com.tencent.mm.plugin.sns.data.b(cVar.jdF, cVar.position, avVar.jFt, avVar.jWv));
            cVar.jdF.a(avVar.jWE, avVar.jWD);
            cVar.jdF.setVisibility(0);
            if (cVar.jdF.jYJ.getVisibility() != 0) {
            }
            if ((cVar.jdF.jYJ.getVisibility() != 0 ? 1 : null) != null) {
                LayoutParams layoutParams2 = (LayoutParams) cVar.jSa.getLayoutParams();
                layoutParams2.setMargins(layoutParams2.leftMargin, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.pP, 0.0f), layoutParams2.rightMargin, layoutParams2.bottomMargin);
                cVar.jSa.setLayoutParams(layoutParams2);
            }
        }
        if (this.jMd) {
            ad.aSv().a(this.pP, com_tencent_mm_protocal_c_awa, cVar);
        }
        cVar.kai.iBv.setTag(new ap(avVar.jWu, avVar.jFt, false, true, 1));
        bAK = com.tencent.mm.ui.a.a.a.bAK();
        view = cVar.kad;
        textView = cVar.kae;
        textView2 = cVar.fBO;
        str2 = cVar.kah.content;
        textView3 = cVar.kan;
        z = cVar.kaY;
        if (bAK.bAJ()) {
        }
    }

    public static void e(c cVar) {
        if (cVar != null && cVar.kai != null) {
            cVar.kai.setVisibility(8);
        }
    }

    private boolean a(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < bVar.size()) {
            try {
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(e.a(this.pP, str, maskTextView.getTextSize()));
                i2++;
            } catch (Throwable e) {
                v.e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", new Object[]{be.e(e)});
            }
        }
        Drawable drawable = this.pP.getResources().getDrawable(i == 11 ? 2130838356 : 2130838789);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(drawable);
        eVar.pbC = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bd.a.fromDPToPix(this.pP, 2))) / 2.0f);
        spannableStringBuilder.setSpan(eVar, length, length + 1, 33);
        int i3 = i == 11 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new j((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.jpB.jMK, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.gVC = stringBuffer.toString();
        return true;
    }

    private void b(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        if (bVar.size() == 0) {
            maskTextView.setVisibility(8);
            return;
        }
        maskTextView.setVisibility(0);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < bVar.size()) {
            try {
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(e.a(this.pP, str, maskTextView.getTextSize()));
                i2++;
            } catch (Throwable e) {
                v.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[]{be.e(e)});
                return;
            }
        }
        Drawable drawable = this.pP.getResources().getDrawable(2131165586);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(drawable);
        eVar.pbC = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bd.a.fromDPToPix(this.pP, 2))) / 2.0f);
        spannableStringBuilder.setSpan(eVar, length, length + 1, 33);
        int i3 = i == 11 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new j((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.jpB.jMK, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.gVC = stringBuffer.toString();
    }

    public final void a(c cVar, int i, k kVar) {
        c cVar2 = cVar;
        int i2 = i;
        a(cVar2, i2, (av) this.jpB.aXC().aVI().get(Integer.valueOf(i)), kVar.aUp(), cVar.eKg, this.jpB);
    }

    private boolean a(List<avr> list, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, c cVar) {
        int i;
        LinearLayout linearLayout = cVar.kaw;
        int childCount = linearLayout.getChildCount();
        int size = bVar.size();
        if (childCount > size) {
            for (i = size; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(size);
                linearLayout.removeViewAt(size);
                if (childAt instanceof SnsCommentPreloadTextView) {
                    this.jpB.a((SnsCommentPreloadTextView) childAt);
                }
            }
        }
        if (bVar.size() == 0) {
            linearLayout.setVisibility(8);
            return false;
        }
        av avVar;
        linearLayout.setVisibility(0);
        u aXC = this.jpB.aXC();
        if (aXC instanceof au) {
            avVar = (av) ((au) aXC).jWl.get(cVar.position);
        } else {
            avVar = null;
        }
        if (this.DEBUG) {
            v.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + cVar.position + " commentCount: " + size);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.size(); i3++) {
            View aXy;
            View view;
            Object obj;
            Object obj2;
            View view2;
            Object obj3;
            com.tencent.mm.vending.j.a aVar = (com.tencent.mm.vending.j.a) bVar.get(i3);
            long longValue = ((Long) aVar.get(0)).longValue();
            String str = (String) aVar.get(1);
            String str2 = (String) aVar.get(2);
            String str3 = (String) aVar.get(3);
            CharSequence charSequence = (CharSequence) aVar.get(4);
            avr com_tencent_mm_protocal_c_avr = (avr) list.get(i3);
            com.tencent.mm.plugin.sns.e.am.b C = C(cVar.boC, longValue);
            if (C != null && C.cyo) {
                com.tencent.mm.plugin.sns.e.am.aT(C.id, 2);
            }
            if (i2 >= childCount) {
                if (C == null || C.cyo) {
                    aXy = this.jpB.aXy();
                    ((SnsCommentPreloadTextView) aXy).G(14.0f * com.tencent.mm.bd.a.ds(aXy.getContext()));
                    if (this.jpB.jUi == -1) {
                        this.jpB.jUi = this.pP.getResources().getColor(2131690023);
                    }
                    ((SnsCommentPreloadTextView) aXy).setTextColor(this.jpB.jUi);
                    ((SnsCommentPreloadTextView) aXy).vP();
                } else {
                    aXy = new TranslateCommentTextView(this.pP);
                    ((TranslateCommentTextView) aXy).jNO.ad(14.0f * com.tencent.mm.bd.a.ds(aXy.getContext()));
                    ((TranslateCommentTextView) aXy).jZz.setTextSize(1, 14.0f * com.tencent.mm.bd.a.ds(aXy.getContext()));
                }
                view = aXy;
                obj = 1;
            } else {
                view = linearLayout.getChildAt(i2);
                obj = null;
            }
            Object obj4 = null;
            if (C != null) {
                if (view instanceof TranslateCommentTextView) {
                    obj2 = null;
                } else {
                    linearLayout.removeView(view);
                    aXy = new TranslateCommentTextView(this.pP);
                    linearLayout.addView(aXy, i2);
                    ((TranslateCommentTextView) aXy).jNO.ad(14.0f * com.tencent.mm.bd.a.ds(aXy.getContext()));
                    ((TranslateCommentTextView) aXy).jZz.setTextSize(1, 14.0f * com.tencent.mm.bd.a.ds(aXy.getContext()));
                    obj2 = 1;
                    view = aXy;
                }
                TranslateCommentTextView translateCommentTextView = (TranslateCommentTextView) view;
                view.setOnTouchListener(null);
                a(translateCommentTextView.jZz, charSequence);
                if (!C.cvW) {
                    translateCommentTextView.jZz.setTextSize(1, 14.0f * com.tencent.mm.bd.a.ds(translateCommentTextView.getContext()));
                    translateCommentTextView.jNO.ri(2);
                    translateCommentTextView.jNO.setVisibility(0);
                    view2 = view;
                    obj3 = 1;
                } else if (C.cyo) {
                    translateCommentTextView.jNO.setVisibility(8);
                    view2 = view;
                    r2 = 1;
                } else {
                    String str4 = C.bfz;
                    String str5 = C.cDd;
                    String charSequence2 = translateCommentTextView.jZz.getText().toString();
                    if (!be.kS(charSequence2)) {
                        String[] strArr;
                        String[] split = charSequence2.split(":");
                        if (split.length > 2) {
                            strArr = new String[]{split[0], charSequence2.substring(r2[0].length() + 1)};
                        } else {
                            strArr = split;
                        }
                        if (strArr.length == 2) {
                            if (be.kS(str4)) {
                                translateCommentTextView.jNO.a(C, 2, null, str5, C.jnp);
                            } else {
                                translateCommentTextView.jNO.a(C, 2, strArr[0] + ": " + str4, str5, C.jnp);
                            }
                            translateCommentTextView.jNO.setVisibility(0);
                        }
                        translateCommentTextView.jZz.setTextSize(1, 14.0f * com.tencent.mm.bd.a.ds(translateCommentTextView.getContext()));
                    }
                    view2 = view;
                    r2 = 1;
                }
            } else {
                if (obj == null && (view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    SnsCommentPreloadTextView aXy2 = this.jpB.aXy();
                    linearLayout.addView(aXy2, i2);
                    aXy2.G(14.0f * com.tencent.mm.bd.a.ds(aXy2.getContext()));
                    view = aXy2;
                    obj4 = 1;
                }
                view.setOnTouchListener(new h(this.pP));
                a(view, charSequence);
                obj2 = obj4;
                view2 = view;
                obj3 = null;
            }
            view2.setBackgroundResource(2130839238);
            if (i2 > 0) {
                if (obj3 != null) {
                    view2.setPadding(0, com.tencent.mm.bd.a.fromDPToPix(this.pP, 2), 0, com.tencent.mm.bd.a.fromDPToPix(this.pP, 7));
                } else {
                    view2.setPadding(0, com.tencent.mm.bd.a.fromDPToPix(this.pP, 2), 0, com.tencent.mm.bd.a.fromDPToPix(this.pP, 3));
                }
            } else if (obj3 != null) {
                view2.setPadding(0, 1, 0, com.tencent.mm.bd.a.fromDPToPix(this.pP, 7));
            } else {
                view2.setPadding(0, 1, 0, com.tencent.mm.bd.a.fromDPToPix(this.pP, 3));
            }
            if (obj3 != null) {
                i = (int) this.pP.getResources().getDimension(2131493199);
                ((TranslateCommentTextView) view2).jNO.jXx.setPadding(0, 0, i, 0);
            }
            if (!(obj2 == null && obj == null)) {
                this.jpB.eyZ.a(view2, this.jpB.joV.kbI, this.jpB.joV.kbv);
            }
            view2.setOnClickListener(new com.tencent.mm.plugin.sns.ui.h.a(this.jpB.jUe, com_tencent_mm_protocal_c_avr, str2, str3, cVar));
            view2.setTag(new com.tencent.mm.plugin.sns.ui.k(avVar.jWu, com_tencent_mm_protocal_c_avr, str, str3, view2, 1));
            if (obj != null) {
                linearLayout.addView(view2);
            }
            i2++;
        }
        return true;
    }

    private static void a(View view, CharSequence charSequence) {
        if (view instanceof SnsCommentPreloadTextView) {
            ((SnsCommentPreloadTextView) view).setText(charSequence);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
    }

    private com.tencent.mm.plugin.sns.e.am.b C(String str, long j) {
        if (this.jZZ.size() <= 0) {
            return null;
        }
        Iterator it = this.jZZ.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.sns.e.am.b bVar = (com.tencent.mm.plugin.sns.e.am.b) it.next();
            if (bVar.id != null && bVar.id.equals(com.tencent.mm.plugin.sns.e.am.cB(str, String.valueOf(j)))) {
                return bVar;
            }
        }
        return null;
    }
}
