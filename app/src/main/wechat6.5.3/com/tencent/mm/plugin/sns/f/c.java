package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.e.a.ix;
import com.tencent.mm.e.a.iy;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.e;
import com.tencent.mm.plugin.sns.e.p;
import com.tencent.mm.plugin.sns.e.t;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c implements e, com.tencent.mm.v.e {
    public static final Pattern jpG = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern jpH = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    public com.tencent.mm.plugin.sns.g.c jku;
    public final int joU = 14;
    public ListView jpA;
    public as jpB;
    public Map<Long, Integer> jpC = new HashMap();
    public HashSet<Long> jpD = new HashSet();
    public HashSet<Long> jpE = new HashSet();
    public HashMap<Long, a> jpF = new HashMap();
    private com.tencent.mm.pluginsdk.ui.d.j.a jpI = new com.tencent.mm.pluginsdk.ui.d.j.a(this) {
        final /* synthetic */ c jpN;

        {
            this.jpN = r1;
        }

        public final void aW(Object obj) {
        }
    };
    public final int jpy = 500;
    public List<d> jpz;

    static class a {
        long jkk;
        d jpS;
        int jpT = 0;
        int jpU = 0;
        String jpV = "";
        String jpW = "";
        String jpX;
        long mEndTime = -1;
        long mStartTime = -1;

        public a(long j, long j2, String str, d dVar) {
            this.jpS = dVar;
            this.mStartTime = j;
            this.jkk = j2;
            this.jpX = str;
        }

        public final void cs(int i, int i2) {
            this.jpT = i;
            this.jpU = i2;
        }

        public final void l(int i, int i2, int i3, int i4) {
            if (i != -1 && i2 != -1) {
                String str = i + ":" + i2 + ":" + i3 + ":" + i4;
                String str2 = i + ":" + i2;
                if (!str.equals(this.jpV)) {
                    if (!this.jpV.startsWith(str2) || i3 != 0 || i4 != 0) {
                        this.jpV = str;
                        str = i + ":" + i2 + ":" + i3 + ":" + i4;
                        if (!be.kS(this.jpW)) {
                            this.jpW += "|";
                        }
                        this.jpW += str;
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, Context context, View view, a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar2, d dVar) {
        v.i("MicroMsg.SnSABTestMgr", "processButtonClick");
        if (view.getTag() instanceof awa) {
            cVar.a(context, (awa) view.getTag(), aVar, bVar, cVar2, dVar);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.SnSABTestMgr", "onSceneend " + i + " errCode " + i2);
        com.tencent.mm.sdk.c.a.nhr.z(new ix());
    }

    private void cU(long j) {
        if (this.jku == null) {
            this.jku = new com.tencent.mm.plugin.sns.g.c();
        }
        if (this.jku.jqp.size() > 500) {
            this.jku.jqp.remove(0);
        }
        this.jku.jqp.add(Long.valueOf(j));
    }

    public final void clean() {
        this.jpA = null;
        this.jpB = null;
        if (this.jpD != null) {
            Iterator it = this.jpD.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                ak.vy().a(new p(l.longValue(), 0, 0, null), 0);
                v.i("MicroMsg.SnSABTestMgr", "report id " + l);
            }
        }
        if (this.jpF != null) {
            for (a a : this.jpF.values()) {
                a(a);
            }
            this.jpF.clear();
        }
        if (this.jpz.size() != 0 && this.jku != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.xp()).append("ws_1100004").toString();
            v.i("MicroMsg.SnSABTestMgr", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = this.jku.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                v.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.jku.jqp.size());
            } catch (Throwable e) {
                v.a("MicroMsg.SnSABTestMgr", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public static void c(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        cVar.kaK = false;
        cVar.kaJ = (ViewStub) view.findViewById(2131759493);
        cVar.kaJ.setVisibility(8);
        cVar.kaO = (ViewStub) view.findViewById(2131759500);
        cVar.kaO.setVisibility(8);
    }

    public final void a(Context context, awa com_tencent_mm_protocal_c_awa, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (!u.bsV()) {
            b(cVar);
        } else if (this.jpz == null || this.jpz.size() == 0) {
            b(cVar);
        } else if (this.jpE.contains(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))) {
            b(cVar);
            cVar.kbc.setVisibility(8);
            cVar.dtX.setVisibility(8);
            cVar.kad.setVisibility(8);
        } else if (com_tencent_mm_protocal_c_awa.mdw == null || com_tencent_mm_protocal_c_awa.mdw.equals(ad.aSk())) {
            b(cVar);
        } else if (this.jku == null || !this.jku.jqp.contains(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))) {
            int i;
            if (com_tencent_mm_protocal_c_awa != null) {
                try {
                    byte[] a = m.a(com_tencent_mm_protocal_c_awa.mTy);
                    if (be.bl(a)) {
                        i = 0;
                    } else {
                        i = ((awi) new awi().az(a)).mTH;
                    }
                } catch (Exception e) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            int i2 = 0;
            if (this.jpC.containsKey(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))) {
                i2 = ((Integer) this.jpC.get(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))).intValue();
                if (i2 == -1) {
                    b(cVar);
                    return;
                }
            }
            int i3 = i2;
            d dVar = null;
            for (d dVar2 : this.jpz) {
                if (dVar2 != null) {
                    if (dVar2.jpY == i) {
                        dVar = dVar2;
                        break;
                    }
                }
                b(cVar);
                return;
            }
            if (dVar == null) {
                b(cVar);
            } else if (i3 >= dVar.jpZ.size()) {
                b(cVar);
            } else {
                final b bVar = (b) dVar.jpZ.get(i3);
                int i4 = bVar.aXx;
                b(cVar);
                if (i > 0) {
                    if (this.jpF.containsKey(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))) {
                        ((a) this.jpF.get(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))).cs(i4, bVar.jqe.size());
                    } else {
                        a aVar = new a(System.currentTimeMillis(), com_tencent_mm_protocal_c_awa.mjq, i.cE(com_tencent_mm_protocal_c_awa.mjq), dVar);
                        aVar.cs(i4, bVar.jqe.size());
                        this.jpF.put(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq), aVar);
                    }
                    if (i4 == 1) {
                        CharSequence charSequence = bVar.title;
                        if (!cVar.kaK) {
                            cVar.kaL = cVar.kaJ.inflate();
                            cVar.kaK = true;
                            cVar.kaN = (TextView) cVar.kaL.findViewById(2131759230);
                            cVar.kaM = (LinearLayout) cVar.kaL.findViewById(2131759231);
                        }
                        cVar.kaL.setVisibility(0);
                        cVar.kaN.setText(charSequence);
                        List list = bVar.jqe;
                        if (list.size() != cVar.kaM.getChildCount()) {
                            cVar.kaM.removeAllViews();
                            for (i = 0; i < list.size(); i++) {
                                a aVar2 = (a) list.get(i);
                                View textView = new TextView(cVar.kaM.getContext());
                                textView.setText(aVar2.jqa);
                                textView.setPadding(0, 0, com.tencent.mm.bd.a.fromDPToPix(context, 10), 0);
                                textView.setVisibility(0);
                                textView.setTextSize(1, 14.0f * com.tencent.mm.bd.a.ds(context));
                                textView.setTextColor(context.getResources().getColor(2131690029));
                                cVar.kaM.addView(textView);
                            }
                        }
                        for (i2 = 0; i2 < list.size(); i2++) {
                            final a aVar3 = (a) list.get(i2);
                            TextView textView2 = (TextView) cVar.kaM.getChildAt(i2);
                            textView2.setText(a(context, textView2, a(f.a(aVar3), com_tencent_mm_protocal_c_awa), com_tencent_mm_protocal_c_awa, cVar, aVar3, bVar, dVar));
                            textView2.setTag(com_tencent_mm_protocal_c_awa);
                            final Context context2 = context;
                            final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
                            final d dVar3 = dVar;
                            textView2.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ c jpN;

                                public final void onClick(View view) {
                                    c.a(this.jpN, context2, view, aVar3, bVar, cVar2, dVar3);
                                }
                            });
                        }
                        return;
                    } else if (i4 == 4) {
                        a(context, com_tencent_mm_protocal_c_awa, cVar, bVar, dVar);
                        return;
                    } else if (i4 == 2) {
                        if (!b(context, com_tencent_mm_protocal_c_awa, cVar, bVar, dVar)) {
                            return;
                        }
                        return;
                    }
                }
                b(cVar);
            }
        } else {
            b(cVar);
        }
    }

    private boolean a(Context context, awa com_tencent_mm_protocal_c_awa, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        cVar.kad.setBackgroundDrawable(null);
        int i = cVar.position - 1;
        if (this.jpB != null) {
            WeakReference weakReference = (WeakReference) this.jpB.jUg.get(Integer.valueOf(i));
            if (!(weakReference == null || weakReference.get() == null)) {
                ((View) weakReference.get()).setBackgroundDrawable(null);
            }
        }
        if (!cVar.kaP) {
            cVar.kaQ = cVar.kaO.inflate();
            cVar.kaP = true;
            cVar.kaR = (LinearLayout) cVar.kaQ.findViewById(2131759232);
        }
        cVar.kaQ.setVisibility(0);
        cVar.kbc.setVisibility(8);
        cVar.dtX.setVisibility(8);
        List list = bVar.jqe;
        if (list.size() != cVar.kaR.getChildCount()) {
            cVar.kaR.removeAllViews();
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(context, 10);
            for (i = 0; i < list.size(); i++) {
                View textView = new TextView(context);
                textView.setBackgroundResource(2130837619);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bd.a.ds(context));
                textView.setTextColor(context.getResources().getColor(2131689547));
                cVar.kaR.addView(textView);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            final a aVar = (a) list.get(i2);
            TextView textView2 = (TextView) cVar.kaR.getChildAt(i2);
            textView2.setText(aVar.jqa);
            textView2.setTag(com_tencent_mm_protocal_c_awa);
            String a = a(f.a(aVar), com_tencent_mm_protocal_c_awa);
            final Context context2 = context;
            final b bVar2 = bVar;
            final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
            final d dVar2 = dVar;
            textView2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c jpN;

                public final void onClick(View view) {
                    c.a(this.jpN, context2, view, aVar, bVar2, cVar2, dVar2);
                }
            });
            textView2.setText(a(context, textView2, a, com_tencent_mm_protocal_c_awa, cVar, aVar, bVar, dVar), BufferType.SPANNABLE);
            if (aVar.actionType != 5) {
                textView2.setCompoundDrawablePadding(com.tencent.mm.bd.a.fromDPToPix(context, 5));
                textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(2131165220), null, null, null);
            }
        }
        return true;
    }

    private boolean b(Context context, awa com_tencent_mm_protocal_c_awa, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        if (bVar.jqe.size() != 2) {
            return false;
        }
        final a aVar = (a) bVar.jqe.get(0);
        a aVar2 = (a) bVar.jqe.get(1);
        String a = a(f.a(aVar), com_tencent_mm_protocal_c_awa);
        String a2 = a(f.a(aVar2), com_tencent_mm_protocal_c_awa);
        String a3 = a(bVar.title, com_tencent_mm_protocal_c_awa);
        String string = context.getString(2131231164);
        final Context context2 = context;
        final awa com_tencent_mm_protocal_c_awa2 = com_tencent_mm_protocal_c_awa;
        final b bVar2 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
        final d dVar2 = dVar;
        AnonymousClass3 anonymousClass3 = new DialogInterface.OnClickListener(this) {
            final /* synthetic */ c jpN;

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.SnSABTestMgr", "onClick alert1");
                this.jpN.a(context2, com_tencent_mm_protocal_c_awa2, aVar, bVar2, cVar2, dVar2);
            }
        };
        final Context context3 = context;
        final awa com_tencent_mm_protocal_c_awa3 = com_tencent_mm_protocal_c_awa;
        final a aVar3 = aVar2;
        final b bVar3 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar3 = cVar;
        final d dVar3 = dVar;
        g.b(context, a3, string, a, a2, anonymousClass3, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ c jpN;

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.SnSABTestMgr", "onClick alert2");
                this.jpN.a(context3, com_tencent_mm_protocal_c_awa3, aVar3, bVar3, cVar3, dVar3);
            }
        });
        return true;
    }

    private void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            Context context = cVar.kad.getContext();
            if (context != null) {
                if (cVar.kad.getBackground() == null) {
                    cVar.kad.setBackgroundResource(2130838046);
                    cVar.kad.setPadding(com.tencent.mm.bd.a.fromDPToPix(context, 12), com.tencent.mm.bd.a.fromDPToPix(context, 12), com.tencent.mm.bd.a.fromDPToPix(context, 12), com.tencent.mm.bd.a.fromDPToPix(context, 8));
                }
                int i = cVar.position - 1;
                if (this.jpB != null) {
                    WeakReference weakReference = (WeakReference) this.jpB.jUg.get(Integer.valueOf(i));
                    if (weakReference != null && weakReference.get() != null) {
                        ((View) weakReference.get()).setBackgroundResource(2130838046);
                        ((View) weakReference.get()).setPadding(com.tencent.mm.bd.a.fromDPToPix(context, 12), com.tencent.mm.bd.a.fromDPToPix(context, 12), com.tencent.mm.bd.a.fromDPToPix(context, 12), com.tencent.mm.bd.a.fromDPToPix(context, 8));
                    }
                }
            }
        }
    }

    private void a(Context context, awa com_tencent_mm_protocal_c_awa, a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d dVar) {
        v.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + com_tencent_mm_protocal_c_awa.mdw + " " + com_tencent_mm_protocal_c_awa.mjq);
        int i = aVar.jqc - 1;
        a aVar2 = (a) this.jpF.get(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq));
        if (aVar2 != null) {
            aVar2.l(bVar.aXx, bVar.jqe.size(), aVar.index, aVar.actionType);
            aVar2.jpT = -1;
            aVar2.jpU = -1;
        }
        if (aVar.actionType == 3) {
            this.jpD.add(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq));
            this.jpC.put(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq), Integer.valueOf(i));
        } else if (aVar.actionType == 1) {
            this.jpC.put(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq), Integer.valueOf(i));
            cU(com_tencent_mm_protocal_c_awa.mjq);
            b(cVar);
        } else if (aVar.actionType == 5) {
            if (this.jpD.contains(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))) {
                this.jpD.remove(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq));
                cU(com_tencent_mm_protocal_c_awa.mjq);
                b(cVar);
                if (this.jpF.containsKey(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq))) {
                    a((a) this.jpF.remove(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq)));
                }
            }
            this.jpC.put(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq), Integer.valueOf(-1));
            a(cVar);
            return;
        } else if (aVar.actionType == 7) {
            if (i < dVar.jpZ.size()) {
                b bVar2 = (b) dVar.jpZ.get(i);
                if (bVar2.aXx == 2) {
                    b(context, com_tencent_mm_protocal_c_awa, cVar, bVar2, dVar);
                    return;
                } else if (bVar2.aXx == 5) {
                    s.makeText(context, be.ah(bVar2.title, ""), 0).show();
                    cU(com_tencent_mm_protocal_c_awa.mjq);
                    b(cVar);
                    return;
                }
            }
        } else if (aVar.actionType == 6) {
            s.makeText(context, be.ah(context.getString(2131235352), ""), 0).show();
            this.jpE.add(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq));
            b(cVar);
            com.tencent.mm.sdk.c.a.nhr.z(new iy());
            a(cVar);
            return;
        } else if (aVar.actionType == 2) {
            r0 = aVar.jumpUrl;
            v.i("MicroMsg.SnSABTestMgr", "jump url " + r0);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r0);
            intent.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.b.a.drp.j(intent, context);
            cU(com_tencent_mm_protocal_c_awa.mjq);
            b(cVar);
            a(cVar);
            return;
        } else if (aVar.actionType == 8) {
            return;
        } else {
            if (aVar.actionType == 4) {
                r0 = com_tencent_mm_protocal_c_awa.mdw;
                List linkedList = new LinkedList();
                linkedList.add(r0);
                ak.vy().a(new t(1, 5, "", linkedList.size(), linkedList, 0), 0);
            }
        }
        if (i == 4 || i == 1) {
            a(context, com_tencent_mm_protocal_c_awa, cVar);
        }
    }

    private static void b(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            if (cVar.kaJ != null) {
                cVar.kaJ.setVisibility(8);
            }
            if (cVar.kaL != null) {
                cVar.kaL.setVisibility(8);
            }
            if (cVar.kaO != null) {
                cVar.kaO.setVisibility(8);
            }
            if (cVar.kaQ != null) {
                cVar.kaQ.setVisibility(8);
            }
            if (cVar.kbc.getVisibility() == 8) {
                cVar.kbc.setVisibility(0);
            }
            if (cVar.dtX.getVisibility() == 8) {
                cVar.dtX.setVisibility(0);
            }
            if (cVar.kad.getVisibility() == 8) {
                cVar.kad.setVisibility(0);
            }
        }
    }

    private static String a(String str, awa com_tencent_mm_protocal_c_awa) {
        String str2;
        Throwable e;
        try {
            if (be.kS(str)) {
                return "";
            }
            int i;
            String str3 = com_tencent_mm_protocal_c_awa.mdw;
            ak.yW();
            com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str3);
            if (str.contains("{username}")) {
                str = str.replace("{username}", LX.tU());
            }
            if (LX.bBZ == 1) {
                i = 0;
                str2 = str;
            } else if (LX.bBZ == 2) {
                i = 1;
                str2 = str;
            } else {
                i = 2;
                str2 = str;
            }
            while (true) {
                Matcher matcher = jpH.matcher(str2);
                if (!matcher.find() || matcher.groupCount() != 3) {
                    return str2;
                }
                CharSequence group;
                CharSequence group2 = matcher.group();
                if (i == 0) {
                    group = matcher.group(1);
                } else if (i == 1) {
                    try {
                        group = matcher.group(2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    group = matcher.group(3);
                }
                str2 = str2.replace(group2, group);
            }
        } catch (Throwable e3) {
            e = e3;
            str2 = str;
            v.a("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
            return str2;
        }
    }

    private SpannableString a(Context context, TextView textView, String str, awa com_tencent_mm_protocal_c_awa, com.tencent.mm.plugin.sns.ui.a.a.c cVar, a aVar, b bVar, d dVar) {
        Matcher matcher = jpG.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return com.tencent.mm.pluginsdk.ui.d.e.a(context, str);
        }
        CharSequence group = matcher.group();
        Object group2 = matcher.group(1);
        int indexOf = str.indexOf(group);
        CharSequence replace = str.replace(group, group2);
        textView.setOnClickListener(null);
        textView.setClickable(true);
        SpannableString spannableString = new SpannableString(replace);
        textView.setOnTouchListener(new y());
        final Context context2 = context;
        final awa com_tencent_mm_protocal_c_awa2 = com_tencent_mm_protocal_c_awa;
        final a aVar2 = aVar;
        final b bVar2 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
        final d dVar2 = dVar;
        spannableString.setSpan(new j(com_tencent_mm_protocal_c_awa.mdw, new com.tencent.mm.pluginsdk.ui.d.j.a(this) {
            final /* synthetic */ c jpN;

            public final void aW(Object obj) {
                this.jpN.a(context2, com_tencent_mm_protocal_c_awa2, aVar2, bVar2, cVar2, dVar2);
            }
        }), indexOf, group2.length() + indexOf, 33);
        return spannableString;
    }

    public final void a(int i, String str, long j, String str2, azr com_tencent_mm_protocal_c_azr, boolean z, bc bcVar) {
    }

    public final void a(int i, String str, long j, String str2, azr com_tencent_mm_protocal_c_azr, boolean z) {
        if (this.jpF.containsKey(Long.valueOf(j))) {
            a aVar = (a) this.jpF.get(Long.valueOf(j));
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            aVar.l(aVar.jpT, aVar.jpU, 0, 0);
        }
    }

    private static void a(a aVar) {
        d dVar = aVar.jpS;
        if (dVar != null) {
            String str = dVar.jpx;
            String str2 = dVar.jpw;
            String str3 = aVar.jpX;
            aVar.l(aVar.jpT, aVar.jpU, 0, 0);
            String str4 = aVar.jpW;
            if (be.kS(str4)) {
                str4 = aVar.jpT + ":" + aVar.jpU + ":0:0";
            }
            String str5 = "";
            long j = aVar.mStartTime / 1000;
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            long j2 = aVar.mEndTime / 1000;
            if (aVar != null) {
                v.i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j + " timelineId: " + str3);
                com.tencent.mm.plugin.report.service.g.iuh.h(11917, new Object[]{str, str2, str5, str5, Integer.valueOf(1), str3, str4, Long.valueOf(j), Long.valueOf(j2)});
            }
        }
    }
}
