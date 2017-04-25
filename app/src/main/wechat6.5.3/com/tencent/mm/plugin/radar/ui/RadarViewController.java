package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.a.e.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class RadarViewController extends RelativeLayout implements com.tencent.mm.plugin.radar.a.c.b, com.tencent.mm.plugin.radar.a.e.c {
    private final int ikA = 33554433;
    private final int ikB = 33554434;
    RadarWaveView ikj = null;
    RadarMemberView ikk = null;
    RadarSpecialGridView ikl = null;
    RadarTipsView ikm = null;
    private Button ikn = null;
    TextView iko = null;
    ProgressBar ikp = null;
    Button ikq = null;
    View ikr = null;
    e iks = null;
    com.tencent.mm.plugin.radar.a.c ikt = null;
    b iku = null;
    d ikv = d.SEARCHING;
    private boolean ikw = false;
    private OnClickListener ikx = new OnClickListener(this) {
        final /* synthetic */ RadarViewController ikC;

        {
            this.ikC = r1;
        }

        public final void onClick(View view) {
        }
    };
    OnClickListener iky = new OnClickListener(this) {
        final /* synthetic */ RadarViewController ikC;

        {
            this.ikC = r1;
        }

        public final void onClick(View view) {
            if (this.ikC.ikv == d.SEARCHING || this.ikC.ikv == d.SEARCH_RETRUN) {
                ((Activity) this.ikC.getContext()).finish();
                return;
            }
            LinkedList linkedList;
            RadarViewController radarViewController = this.ikC;
            b b = this.ikC.iku;
            if (b.ikK == null) {
                linkedList = null;
            } else {
                linkedList = new LinkedList();
                for (Object obj : b.ikK) {
                    if (obj != null) {
                        linkedList.add(obj);
                    }
                }
            }
            if (radarViewController.R(linkedList)) {
                if (this.ikC.ikj != null) {
                    this.ikC.ikj.aJb();
                    this.ikC.ikj.setVisibility(0);
                }
                this.ikC.iks.aIG();
                this.ikC.a(d.SEARCH_RETRUN);
            } else {
                this.ikC.a(d.SEARCHING);
            }
            if (this.ikC.iku != null) {
                this.ikC.iku.aIO();
            }
        }
    };
    private final int ikz = 33554432;
    private Context mContext;

    private class a {
        final /* synthetic */ RadarViewController ikC;
        private int ikG;
        boolean ikH;
        ac ikI;

        private a(RadarViewController radarViewController) {
            boolean z = false;
            this.ikC = radarViewController;
            this.ikG = 0;
            if (this.ikC.getContext().getResources().getDisplayMetrics().densityDpi <= 240) {
                z = true;
            }
            this.ikH = z;
            this.ikI = new ac(this) {
                final /* synthetic */ a ikJ;

                {
                    this.ikJ = r1;
                }

                public final void handleMessage(Message message) {
                    if (message.obj instanceof View) {
                        View view = (View) message.obj;
                        view.setVisibility(0);
                        view.clearAnimation();
                        if (!this.ikJ.ikH) {
                            Object tag = view.getTag(33554434);
                            Animation animation = tag instanceof Animation ? (Animation) tag : null;
                            if (animation == null) {
                                animation = this.ikJ.getInAnimation();
                            }
                            view.startAnimation(animation);
                        }
                    }
                }
            };
        }

        public final Animation getInAnimation() {
            return AnimationUtils.loadAnimation(this.ikC.getContext(), 2130968655);
        }

        public final void f(int i, View view) {
            Message obtainMessage = this.ikI.obtainMessage();
            obtainMessage.what = bW(view);
            obtainMessage.obj = view;
            view.setVisibility(4);
            this.ikI.sendMessageDelayed(obtainMessage, (long) ((i + 1) * 500));
        }

        public final int aJa() {
            int i = this.ikG + 1;
            this.ikG = i;
            return i;
        }

        static int bW(View view) {
            Object tag = view.getTag(33554433);
            if (tag instanceof Integer) {
                return ((Integer) tag).intValue();
            }
            return -1;
        }
    }

    public class c {
        public apa iiD;
        final /* synthetic */ RadarViewController ikC;

        public c(RadarViewController radarViewController, apa com_tencent_mm_protocal_c_apa) {
            this.ikC = radarViewController;
            this.iiD = com_tencent_mm_protocal_c_apa;
        }
    }

    public class b extends a {
        private Context context;
        final /* synthetic */ RadarViewController ikC;
        public apa[] ikK = new apa[12];
        public HashMap<String, aif> ikL = new HashMap();
        public HashMap<String, Integer> ikM = new HashMap();
        a ikN;
        private int ikO = 0;
        public HashMap<String, View> ikP = new HashMap();
        private boolean ikQ = false;

        public class a {
            TextView ikR;
            ImageView ikS;
            ImageView ikT;
            RadarStateView ikU;
            RadarStateChooseView ikV;
            final /* synthetic */ b ikW;

            public a(b bVar, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
                this.ikW = bVar;
                this.ikR = textView;
                this.ikS = imageView;
                this.ikU = radarStateView;
                this.ikT = imageView2;
                this.ikV = radarStateChooseView;
            }
        }

        public final /* bridge */ /* synthetic */ void aIO() {
            super.aIO();
        }

        public b(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context) {
            this.ikC = radarViewController;
            super(radarSpecialGridView, context);
            this.context = context;
            this.ikN = new a();
        }

        protected static boolean d(apa com_tencent_mm_protocal_c_apa) {
            if (com_tencent_mm_protocal_c_apa == null || (be.ma(com_tencent_mm_protocal_c_apa.gln).equals("") && be.ma(com_tencent_mm_protocal_c_apa.mrE).equals(""))) {
                return true;
            }
            return false;
        }

        public final void S(LinkedList<apa> linkedList) {
            if (linkedList.size() != 0) {
                int i;
                apa com_tencent_mm_protocal_c_apa;
                for (apa c : this.ikK) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_apa = (apa) it.next();
                        if (c.c(com_tencent_mm_protocal_c_apa).equals(c.c(c))) {
                            linkedList.remove(com_tencent_mm_protocal_c_apa);
                            break;
                        }
                    }
                }
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_apa = (apa) it2.next();
                    int abs = Math.abs(((int) System.currentTimeMillis()) % 6);
                    for (i = 0; i < this.ikK.length; i++) {
                        int i2 = (i + abs) % 12;
                        if (i2 != 4 && i2 != 7 && d(this.ikK[i2])) {
                            this.ikK[i2] = com_tencent_mm_protocal_c_apa;
                            this.ikM.put(c.b(com_tencent_mm_protocal_c_apa), Integer.valueOf(0));
                            break;
                        }
                    }
                }
                if (linkedList.size() > 0) {
                    super.aIO();
                    com.tencent.mm.plugin.radar.a.d dVar = com.tencent.mm.plugin.radar.a.d.iie;
                    i = linkedList.size();
                    if (dVar.bhN == 0 && i > 0) {
                        float aIF = (((float) (com.tencent.mm.plugin.radar.a.d.aIF() - dVar.iii)) * 1.0f) / 1000.0f;
                        v.d("MicroMsg.RadarKvStatReport", "FoundFirstFriendTimeSpent %s", new Object[]{Float.valueOf(aIF)});
                        g.iuh.Y(10682, String.format("%s", new Object[]{Float.valueOf(aIF)}));
                    }
                    dVar.bhN += i;
                    dVar.iij = i + dVar.iij;
                }
            }
        }

        public final int getCount() {
            if (this.ikQ) {
                return 0;
            }
            return this.ikK.length;
        }

        public final View w(View view, int i) {
            v.d("MicroMsg.Radar.RadarViewController", "getview RadarStatus%s", new Object[]{this.ikC.ikv});
            apa com_tencent_mm_protocal_c_apa = this.ikK[i];
            if (d(com_tencent_mm_protocal_c_apa)) {
                return x(view, i);
            }
            View view2;
            String b = c.b(com_tencent_mm_protocal_c_apa);
            d a = this.ikC.ikv;
            if (view == null) {
                View inflate = View.inflate(this.context, 2130904217, null);
                inflate.setTag(33554433, Integer.valueOf(this.ikN.aJa()));
                inflate.setTag(33554434, this.ikN.getInAnimation());
                view2 = inflate;
            } else {
                view2 = view;
            }
            ImageView imageView = (ImageView) view2.findViewById(2131758739);
            RadarStateView radarStateView = (RadarStateView) view2.findViewById(2131758738);
            TextView textView = (TextView) view2.findViewById(2131758742);
            ImageView imageView2 = (ImageView) view2.findViewById(2131758740);
            RadarStateChooseView radarStateChooseView = (RadarStateChooseView) view2.findViewById(2131758741);
            imageView.setVisibility(0);
            radarStateView.setVisibility(0);
            textView.setVisibility(0);
            imageView2.setVisibility(0);
            if (a == d.SEARCHING || a == d.SEARCH_RETRUN) {
                radarStateView.setVisibility(0);
                radarStateChooseView.setVisibility(8);
            } else {
                radarStateView.setVisibility(8);
                radarStateChooseView.setVisibility(0);
            }
            view2.setTag(new a(this, textView, imageView, radarStateView, radarStateChooseView, imageView2));
            if (i == 7 || i % 3 == 1) {
                view2.findViewById(2131758743).setVisibility(0);
                view2.findViewById(2131758737).setVisibility(8);
            } else {
                view2.findViewById(2131758737).setVisibility(0);
                view2.findViewById(2131758743).setVisibility(8);
            }
            if (view == null || view2 != view) {
                this.ikP.put(b, view2);
            }
            a aVar = (a) view2.getTag();
            aVar.ikR.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.ikC.getContext(), com_tencent_mm_protocal_c_apa.efy, aVar.ikR.getTextSize()));
            com.tencent.mm.plugin.radar.ui.b.a.m(aVar.ikS, b);
            view2.findViewById(2131758734).setTag(new c(this.ikC, com_tencent_mm_protocal_c_apa));
            RadarStateView radarStateView2;
            RadarStateChooseView radarStateChooseView2;
            if (this.ikC.ikv == d.SEARCHING || this.ikC.ikv == d.SEARCH_RETRUN) {
                aVar.ikT.setBackgroundResource(2130839087);
                radarStateView2 = aVar.ikU;
                radarStateView2.ijI = true;
                radarStateView2.aIT();
                radarStateChooseView2 = aVar.ikV;
                radarStateChooseView2.ijE = false;
                radarStateChooseView2.setVisibility(8);
                com.tencent.mm.plugin.radar.a.c.d a2 = this.ikC.iks.a(com_tencent_mm_protocal_c_apa, false);
                if (a2 == null) {
                    a2 = this.ikC.ikt.yq(b);
                    e d = this.ikC.iks;
                    d.b(com_tencent_mm_protocal_c_apa.gln, a2);
                    d.b(com_tencent_mm_protocal_c_apa.mrE, a2);
                }
                com.tencent.mm.plugin.radar.a.c.d a3 = this.ikC.iks.a(com_tencent_mm_protocal_c_apa, true);
                RadarStateView radarStateView3 = aVar.ikU;
                if (a3 == null) {
                    a3 = com.tencent.mm.plugin.radar.a.c.d.Stranger;
                }
                radarStateView3.init();
                radarStateView3.ijJ.removeMessages(0);
                radarStateView3.clearAnimation();
                radarStateView3.iiE = a3;
                radarStateView3.ijB = false;
                radarStateView3.aIT();
                radarStateView3 = aVar.ikU;
                radarStateView3.init();
                v.d("MicroMsg.RadarStateView", " turnToState : " + a2);
                boolean z = false;
                if (radarStateView3.iiE == a2) {
                    radarStateView3.aIT();
                } else {
                    if ((radarStateView3.getVisibility() == 0 ? 1 : null) != null) {
                        radarStateView3.aIV();
                        z = true;
                    }
                    v.d("MicroMsg.RadarStateView", " delay : " + z);
                    radarStateView3.iiE = a2;
                    if (radarStateView3.iiE != com.tencent.mm.plugin.radar.a.c.d.Stranger) {
                        if (z) {
                            radarStateView3.ijJ.sendEmptyMessageDelayed(0, 320);
                        } else {
                            radarStateView3.ijJ.sendEmptyMessage(0);
                        }
                    }
                }
                e d2 = this.ikC.iks;
                d2.a(com_tencent_mm_protocal_c_apa.gln, null);
                d2.a(com_tencent_mm_protocal_c_apa.mrE, null);
                if (i == 0) {
                    this.ikO = this.ikM.size();
                }
                if (this.ikM.remove(b) == null) {
                    return view2;
                }
                this.ikN.f(this.ikO - this.ikM.size(), view2);
                return view2;
            } else if (be.kS((String) this.ikC.iks.aIJ().get(c.c(com_tencent_mm_protocal_c_apa)))) {
                return x(view, i);
            } else {
                com.tencent.mm.plugin.radar.a.e.a aVar2;
                RadarStateChooseView radarStateChooseView3;
                radarStateView2 = aVar.ikU;
                radarStateView2.ijI = false;
                radarStateView2.setVisibility(8);
                radarStateChooseView2 = aVar.ikV;
                radarStateChooseView2.ijE = true;
                radarStateChooseView2.aIT();
                e d3 = this.ikC.iks;
                if (!(d3.aIN() == null || com_tencent_mm_protocal_c_apa == null)) {
                    String b2 = c.b(com_tencent_mm_protocal_c_apa);
                    if (d3.aIN().containsKey(b2)) {
                        aVar2 = (com.tencent.mm.plugin.radar.a.e.a) d3.aIN().get(b2);
                        if (aVar2 != com.tencent.mm.plugin.radar.a.e.a.UnSelected) {
                            aVar.ikT.setBackgroundResource(2131165857);
                        } else {
                            aVar.ikT.setBackgroundDrawable(null);
                        }
                        radarStateChooseView3 = aVar.ikV;
                        if (radarStateChooseView3.ijF != aVar2) {
                            radarStateChooseView3.ijF = aVar2;
                            if (radarStateChooseView3.ijF != com.tencent.mm.plugin.radar.a.e.a.Selected) {
                                if (radarStateChooseView3.ijE) {
                                    radarStateChooseView3.init();
                                    radarStateChooseView3.aIT();
                                    radarStateChooseView3.ijB = true;
                                    radarStateChooseView3.startAnimation(radarStateChooseView3.ijC);
                                }
                            } else if (radarStateChooseView3.ijE) {
                                radarStateChooseView3.init();
                                radarStateChooseView3.aIT();
                                radarStateChooseView3.startAnimation(radarStateChooseView3.ijD);
                            }
                        }
                        if (i == 0) {
                            this.ikO = this.ikM.size();
                        }
                        if (this.ikM.remove(c.c(com_tencent_mm_protocal_c_apa)) != null) {
                            return view2;
                        }
                        this.ikN.f(this.ikO - this.ikM.size(), view2);
                        return view2;
                    }
                }
                aVar2 = com.tencent.mm.plugin.radar.a.e.a.UnSelected;
                if (aVar2 != com.tencent.mm.plugin.radar.a.e.a.UnSelected) {
                    aVar.ikT.setBackgroundDrawable(null);
                } else {
                    aVar.ikT.setBackgroundResource(2131165857);
                }
                radarStateChooseView3 = aVar.ikV;
                if (radarStateChooseView3.ijF != aVar2) {
                    radarStateChooseView3.ijF = aVar2;
                    if (radarStateChooseView3.ijF != com.tencent.mm.plugin.radar.a.e.a.Selected) {
                        if (radarStateChooseView3.ijE) {
                            radarStateChooseView3.init();
                            radarStateChooseView3.aIT();
                            radarStateChooseView3.startAnimation(radarStateChooseView3.ijD);
                        }
                    } else if (radarStateChooseView3.ijE) {
                        radarStateChooseView3.init();
                        radarStateChooseView3.aIT();
                        radarStateChooseView3.ijB = true;
                        radarStateChooseView3.startAnimation(radarStateChooseView3.ijC);
                    }
                }
                if (i == 0) {
                    this.ikO = this.ikM.size();
                }
                if (this.ikM.remove(c.c(com_tencent_mm_protocal_c_apa)) != null) {
                    return view2;
                }
                this.ikN.f(this.ikO - this.ikM.size(), view2);
                return view2;
            }
        }

        private View x(View view, int i) {
            if (view == null) {
                view = View.inflate(this.context, 2130904217, null);
                view.setTag(33554433, Integer.valueOf(this.ikN.aJa()));
                view.setTag(33554434, this.ikN.getInAnimation());
            }
            view.findViewById(2131758739).setVisibility(8);
            view.findViewById(2131758740).setVisibility(8);
            view.findViewById(2131758742).setVisibility(4);
            view.findViewById(2131758738).setVisibility(4);
            view.findViewById(2131758741).setVisibility(4);
            if (i == 7 || i % 3 == 1) {
                view.findViewById(2131758743).setVisibility(0);
                view.findViewById(2131758737).setVisibility(8);
            } else {
                view.findViewById(2131758737).setVisibility(0);
                view.findViewById(2131758743).setVisibility(8);
            }
            return view;
        }

        public final void e(apa com_tencent_mm_protocal_c_apa) {
            if (!d(com_tencent_mm_protocal_c_apa)) {
                String b = c.b(com_tencent_mm_protocal_c_apa);
                if (this.ikC.iks.aIJ().containsKey(b)) {
                    b = (String) this.ikC.iks.aIJ().get(b);
                }
                aif com_tencent_mm_protocal_c_aif = new aif();
                com_tencent_mm_protocal_c_aif.moS = m.lY(b);
                this.ikL.put(b, com_tencent_mm_protocal_c_aif);
            }
        }

        public final void f(apa com_tencent_mm_protocal_c_apa) {
            if (!d(com_tencent_mm_protocal_c_apa)) {
                Object b = c.b(com_tencent_mm_protocal_c_apa);
                if (this.ikC.iks.aIJ().containsKey(b)) {
                    b = (String) this.ikC.iks.aIJ().get(b);
                }
                this.ikL.remove(b);
            }
        }
    }

    public RadarViewController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iks = new e(this, context.getApplicationContext());
        this.ikt = new com.tencent.mm.plugin.radar.a.c(this, context);
        this.mContext = context;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.ikk.isShowing()) {
            return false;
        }
        this.ikk.dismiss();
        return true;
    }

    private void d(String str, com.tencent.mm.plugin.radar.a.c.d dVar) {
        com.tencent.mm.plugin.radar.a.c.d ac = this.iks.ac(str, false);
        if (ac != null && ac != dVar) {
            this.iks.b(str, dVar);
            this.iku.aIO();
        }
    }

    public final void a(boolean z, boolean z2, String str, String str2, long j) {
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.a.c.d.Added);
        } else if (z2) {
            d(str2, com.tencent.mm.plugin.radar.a.c.d.Verifying);
        } else {
            this.ikm.yr(str);
            com.tencent.mm.plugin.radar.a.e.b bVar = (com.tencent.mm.plugin.radar.a.e.b) this.iks.aIK().get(Long.valueOf(j));
            if (bVar != null) {
                d(c.b(bVar.iiD), bVar.iiE);
                d(c.c(bVar.iiD), bVar.iiE);
            }
        }
        this.iks.aIK().remove(Long.valueOf(j));
    }

    public final void a(boolean z, String str, String str2, long j) {
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.a.c.d.Added);
        } else {
            this.ikm.yr(str);
            com.tencent.mm.plugin.radar.a.e.b bVar = (com.tencent.mm.plugin.radar.a.e.b) this.iks.aIK().get(Long.valueOf(j));
            if (bVar != null) {
                d(c.b(bVar.iiD), bVar.iiE);
            }
        }
        this.iks.aIK().remove(Long.valueOf(j));
    }

    public final void C(u uVar) {
        if (this.iks.ac(uVar.field_username, false) == null && this.iks.ac(uVar.field_encryptUsername, false) == null) {
            LinkedList linkedList = new LinkedList();
            String str = uVar.field_username;
            String str2 = uVar.field_encryptUsername;
            String str3 = uVar.field_nickname;
            apa com_tencent_mm_protocal_c_apa = new apa();
            com_tencent_mm_protocal_c_apa.mNn = 100;
            com_tencent_mm_protocal_c_apa.gln = str;
            com_tencent_mm_protocal_c_apa.efy = str3;
            com_tencent_mm_protocal_c_apa.mqa = "";
            com_tencent_mm_protocal_c_apa.mrE = str2;
            linkedList.add(com_tencent_mm_protocal_c_apa);
            Q(linkedList);
        }
        if (this.ikk.isShowing()) {
            this.ikk.c(uVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.NeedVerify);
        }
        d(uVar.field_username, com.tencent.mm.plugin.radar.a.c.d.NeedVerify);
        d(uVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.NeedVerify);
    }

    public final void B(u uVar) {
        if (this.ikk.isShowing()) {
            this.ikk.c(uVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.Added);
        }
        d(uVar.field_username, com.tencent.mm.plugin.radar.a.c.d.Added);
        d(uVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.Added);
    }

    public final void eX(boolean z) {
    }

    public final void a(int i, int i2, LinkedList<apa> linkedList) {
        if (i == 0 && i2 == 0) {
            Q(linkedList);
            return;
        }
        v.e("MicroMsg.Radar.RadarViewController", "radar member return error : %s, type : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        if (2 == i) {
            this.ikm.yr(getContext().getString(2131232875));
        } else {
            this.ikm.yr(getContext().getString(2131234304));
        }
    }

    public final void b(int i, int i2, LinkedList<aox> linkedList) {
        int i3 = 0;
        if (i == 0 && i2 == 0 && linkedList != null) {
            a(d.RALATIONCHAIN_RETRUN);
            if (this.iku != null) {
                b bVar = this.iku;
                bVar.ikC.iks.aIN().clear();
                bVar.ikC.iks.aIJ().clear();
                bVar.ikL.clear();
                bVar.ikM.clear();
                LinkedList linkedList2 = null;
                if (linkedList != null && linkedList.size() > 0) {
                    int i4;
                    LinkedList linkedList3 = new LinkedList();
                    int size = linkedList.size();
                    for (i4 = 0; i4 < size; i4++) {
                        aox com_tencent_mm_protocal_c_aox = (aox) linkedList.get(i4);
                        aoy com_tencent_mm_protocal_c_aoy = new aoy();
                        com_tencent_mm_protocal_c_aoy.mOD = com_tencent_mm_protocal_c_aox.gln;
                        linkedList3.add(com_tencent_mm_protocal_c_aoy);
                        bVar.ikC.iks.aIJ().put(com_tencent_mm_protocal_c_aox.mrE, com_tencent_mm_protocal_c_aox.gln);
                        HashMap hashMap = bVar.ikM;
                        Object obj = com_tencent_mm_protocal_c_aox == null ? "" : com_tencent_mm_protocal_c_aox.mrE != null ? com_tencent_mm_protocal_c_aox.mrE : com_tencent_mm_protocal_c_aox.gln;
                        hashMap.put(obj, Integer.valueOf(0));
                    }
                    if (bVar.ikC.iku != null) {
                        i4 = bVar.ikK.length;
                        while (i3 < i4) {
                            apa com_tencent_mm_protocal_c_apa = bVar.ikK[i3];
                            if (!be.kS((String) bVar.ikC.iks.aIJ().get(c.c(com_tencent_mm_protocal_c_apa)))) {
                                bVar.ikC.iku.e(com_tencent_mm_protocal_c_apa);
                                bVar.ikC.iks.a(com_tencent_mm_protocal_c_apa);
                            }
                            i3++;
                        }
                    }
                    linkedList2 = linkedList3;
                }
                bVar.ikC.iks.iiq = linkedList2;
                this.iku.aIO();
                aIZ();
                return;
            }
            return;
        }
        a(d.SEARCHING);
        this.ikm.yr(getContext().getString(2131234304));
    }

    private void Q(LinkedList<apa> linkedList) {
        if (linkedList.size() == 0 && this.iku.getCount() == 0) {
            this.ikm.eZ(true);
        } else {
            this.ikm.eZ(false);
        }
        v.d("MicroMsg.Radar.RadarViewController", "members got, size : " + linkedList.size());
        v.d("MicroMsg.Radar.RadarViewController", "has friend:%s", new Object[]{String.valueOf(R(linkedList))});
        this.iku.S(linkedList);
        if (this.ikw && r0) {
            a(d.SEARCH_RETRUN);
        }
    }

    private boolean R(LinkedList<apa> linkedList) {
        Iterator it = linkedList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.tencent.mm.plugin.radar.a.c.d yq;
            boolean z2;
            apa com_tencent_mm_protocal_c_apa = (apa) it.next();
            com.tencent.mm.plugin.radar.a.c.d a = this.iks.a(com_tencent_mm_protocal_c_apa, false);
            if (a == null) {
                String b = c.b(com_tencent_mm_protocal_c_apa);
                yq = this.ikt.yq(b);
                this.iks.b(b, yq);
            } else {
                yq = a;
            }
            if (yq == com.tencent.mm.plugin.radar.a.c.d.Added) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    private void aIZ() {
        boolean z = false;
        if (this.ikn != null) {
            b bVar = this.iku;
            int size = bVar.ikL == null ? 0 : bVar.ikL.size();
            if (size == 0) {
                this.ikn.setText(2131231107);
            } else {
                this.ikn.setText(String.format(getContext().getString(2131234297), new Object[]{Integer.valueOf(size)}));
            }
            Button button = this.ikn;
            if (size > 1) {
                z = true;
            }
            button.setEnabled(z);
            this.ikn.setTextColor(size > 1 ? getResources().getColorStateList(2131690182) : getResources().getColorStateList(2131689939));
            this.ikn.setBackgroundResource(2130837799);
        }
    }

    private void a(d dVar) {
        this.ikv = dVar;
        switch (dVar) {
            case SEARCHING:
                this.ikr.setVisibility(8);
                if (this.ikq != null) {
                    this.ikq.setText(2131234298);
                }
                if (this.ikn != null) {
                    this.ikn.setVisibility(4);
                    this.ikn.setBackgroundResource(2130837799);
                    this.ikn.setEnabled(false);
                }
                if (!(this.iko == null || this.ikp == null)) {
                    this.ikp.setVisibility(8);
                    this.iko.setText("");
                }
                if (this.ikj != null) {
                    this.ikj.aJb();
                    this.ikj.setVisibility(0);
                }
                this.iks.aIG();
                return;
            case SEARCH_RETRUN:
                this.ikr.setVisibility(8);
                if (this.ikn != null) {
                    this.ikn.setText(2131234291);
                    this.ikn.setMinWidth(com.tencent.mm.bd.a.N(getContext(), 2131493395));
                    this.ikn.setTextColor(getResources().getColorStateList(2131690182));
                    this.ikn.setBackgroundResource(2130837799);
                    this.ikn.setEnabled(true);
                    fa(false);
                }
                if (this.iko != null && this.ikp != null) {
                    this.ikp.setVisibility(8);
                    this.iko.setText("");
                    return;
                }
                return;
            case RALATIONCHAIN_RETRUN:
                this.ikr.setVisibility(0);
                if (this.iks != null) {
                    this.iks.aIH();
                }
                if (!(this.iko == null || this.ikp == null)) {
                    this.ikp.setVisibility(8);
                    this.iko.setText(2131234289);
                }
                if (this.ikl != null) {
                    this.ikl.setVisibility(0);
                }
                fa(true);
                if (this.ikn != null) {
                    this.ikn.setVisibility(0);
                    this.ikn.setMinWidth(com.tencent.mm.bd.a.N(getContext(), 2131493543));
                }
                aIZ();
                return;
            case RALATIONCHAIN:
                if (!(this.ikr == null || this.ikr.getVisibility() == 0)) {
                    this.ikr.setAnimation(AnimationUtils.loadAnimation(getContext(), 2130968648));
                    this.ikr.setVisibility(0);
                }
                if (this.ikq != null) {
                    this.ikq.setText(2131231010);
                }
                if (this.iks != null) {
                    this.iks.aIH();
                }
                if (!(this.iko == null || this.ikp == null)) {
                    this.ikp.setVisibility(0);
                    this.iko.setText(2131234300);
                }
                if (this.ikj != null) {
                    this.ikj.aJc();
                    this.ikj.setVisibility(4);
                }
                if (this.ikl != null) {
                    this.ikl.setVisibility(4);
                }
                if (this.iku != null) {
                    b bVar = this.iku;
                    bVar.ikM.clear();
                    bVar.ikP.clear();
                    for (String str : bVar.ikP.keySet()) {
                        a aVar = bVar.ikN;
                        View view = (View) bVar.ikP.get(str);
                        int bW = a.bW(view);
                        if (bW > 0) {
                            aVar.ikI.removeMessages(bW);
                        }
                        view.clearAnimation();
                    }
                    bVar.aIO();
                    return;
                }
                return;
            case CREATING_CHAT:
                this.ikr.setVisibility(8);
                if (this.iks != null) {
                    this.iks.aIH();
                }
                if (!(this.iko == null || this.ikp == null)) {
                    this.ikp.setVisibility(0);
                    this.iko.setText(2131234290);
                }
                if (this.ikn != null) {
                    this.ikn.setVisibility(4);
                    return;
                }
                return;
            default:
                v.d("MicroMsg.Radar.RadarViewController", "swithcRadarUI");
                return;
        }
    }

    private void fa(boolean z) {
        if (this.ikn == null) {
            return;
        }
        if (this.ikn.getVisibility() != 0 || z) {
            this.ikn.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968648));
            this.ikn.setVisibility(0);
        }
    }
}
