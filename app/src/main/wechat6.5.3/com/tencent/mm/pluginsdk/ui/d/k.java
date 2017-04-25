package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class k {
    private static final f<String, SpannableString> lRt = new f(500);
    String jGE;
    private TextView kG;
    boolean lRA;
    boolean lRB;
    boolean lRC;
    boolean lRD;
    boolean lRE;
    boolean lRF;
    int lRG;
    private int lRH;
    boolean lRI;
    Object lRJ;
    private ArrayList<h> lRu;
    private ArrayList<a> lRv;
    private ArrayList<i> lRw;
    boolean lRx;
    boolean lRy;
    boolean lRz;
    private Context mContext;
    boolean pRu;

    class a {
        int end;
        final /* synthetic */ k lRK;
        int start;

        a(k kVar, int i, int i2) {
            this.lRK = kVar;
            this.start = i;
            this.end = i2;
        }
    }

    public k(Context context) {
        this.lRu = new ArrayList();
        this.lRv = new ArrayList();
        this.lRw = new ArrayList();
        this.kG = null;
        this.lRx = false;
        this.lRy = false;
        this.lRz = true;
        this.lRA = true;
        this.lRB = false;
        this.lRC = false;
        this.lRD = false;
        this.lRE = false;
        this.lRF = false;
        this.pRu = true;
        this.lRG = 0;
        this.lRH = 0;
        this.mContext = null;
        this.lRI = false;
        this.lRu = new ArrayList();
        this.lRv = new ArrayList();
        this.lRw = new ArrayList();
        this.mContext = context;
    }

    public final k i(TextView textView) {
        this.kG = textView;
        this.mContext = this.kG.getContext();
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.text.SpannableString a(java.lang.CharSequence r11, int r12, boolean r13) {
        /*
        r10 = this;
        r9 = 1067869798; // 0x3fa66666 float:1.3 double:5.275977814E-315;
        r1 = 1;
        r3 = 0;
        if (r11 != 0) goto L_0x0010;
    L_0x0007:
        r0 = new android.text.SpannableString;
        r1 = "";
        r0.<init>(r1);
    L_0x000f:
        return r0;
    L_0x0010:
        r10.lRH = r12;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r11);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRH;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRx;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRy;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRz;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRA;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRG;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRI;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRD;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRE;
        r0 = r0.append(r2);
        r2 = "@";
        r0 = r0.append(r2);
        r2 = r10.lRF;
        r0 = r0.append(r2);
        r4 = r0.toString();
        if (r13 == 0) goto L_0x00b8;
    L_0x00a3:
        r0 = lRt;
        r0 = r0.get(r4);
        r0 = (android.text.SpannableString) r0;
        if (r0 == 0) goto L_0x00b8;
    L_0x00ad:
        b(r0);
        r10.c(r0);
        r10.bqL();
        goto L_0x000f;
    L_0x00b8:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.lRu = r0;
        r0 = r10.lRH;
        if (r0 > 0) goto L_0x00d0;
    L_0x00c3:
        r0 = r10.kG;
        if (r0 == 0) goto L_0x01e5;
    L_0x00c7:
        r0 = r10.kG;
        r0 = r0.getTextSize();
        r0 = (int) r0;
        r10.lRH = r0;
    L_0x00d0:
        r0 = r10.lRu;
        if (r0 != 0) goto L_0x00db;
    L_0x00d4:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.lRu = r0;
    L_0x00db:
        r0 = r10.lRv;
        if (r0 != 0) goto L_0x00e6;
    L_0x00df:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.lRv = r0;
    L_0x00e6:
        r0 = r10.lRu;
        r0.clear();
        r0 = r10.lRv;
        r0.clear();
        if (r11 == 0) goto L_0x0215;
    L_0x00f2:
        r0 = com.tencent.mm.compatible.d.p.ceJ;
        r0 = r0.cdB;
        if (r0 != r1) goto L_0x01f2;
    L_0x00f8:
        r0 = r1;
    L_0x00f9:
        if (r0 == 0) goto L_0x0131;
    L_0x00fb:
        r0 = r10.pRu;
        if (r0 == 0) goto L_0x0131;
    L_0x00ff:
        com.tencent.mm.bf.g.buU();
        r0 = com.tencent.mm.bf.f.buR();
        r2 = r11.toString();
        r0 = r0.Ll(r2);
        if (r0 == 0) goto L_0x0218;
    L_0x0110:
        r0 = r1;
    L_0x0111:
        if (r0 != 0) goto L_0x0123;
    L_0x0113:
        com.tencent.mm.bf.g.buU();
        com.tencent.mm.bf.b.buL();
        r0 = r11.toString();
        r0 = com.tencent.mm.bf.b.Lj(r0);
        if (r0 == 0) goto L_0x0131;
    L_0x0123:
        r0 = r11.toString();
        r1 = "\n";
        r2 = "                                                                                                                                                                                                                                                                                                                        ";
        r11 = r0.replace(r1, r2);
    L_0x0131:
        r0 = r10.lRx;
        if (r0 == 0) goto L_0x0139;
    L_0x0135:
        r11 = r10.w(r11);
    L_0x0139:
        r0 = r10.lRD;
        if (r0 == 0) goto L_0x0141;
    L_0x013d:
        r11 = r10.u(r11);
    L_0x0141:
        r0 = r10.lRF;
        if (r0 == 0) goto L_0x0149;
    L_0x0145:
        r11 = r10.v(r11);
    L_0x0149:
        r0 = r10.pRu;
        if (r0 == 0) goto L_0x02af;
    L_0x014d:
        r0 = com.tencent.mm.bf.g.buU();
        r1 = r10.mContext;
        r2 = r10.lRH;
        r0 = r0.e(r1, r11, r2);
    L_0x0159:
        r1 = r10.lRz;
        if (r1 == 0) goto L_0x0166;
    L_0x015d:
        r1 = r10.lRv;
        r2 = r10.x(r0);
        r1.addAll(r2);
    L_0x0166:
        r1 = r10.lRx;
        if (r1 == 0) goto L_0x0173;
    L_0x016a:
        r1 = r10.lRv;
        r2 = r10.y(r0);
        r1.addAll(r2);
    L_0x0173:
        r1 = r10.lRC;
        if (r1 == 0) goto L_0x0180;
    L_0x0177:
        r1 = r10.lRv;
        r2 = r10.C(r0);
        r1.addAll(r2);
    L_0x0180:
        r1 = r10.lRA;
        if (r1 == 0) goto L_0x018d;
    L_0x0184:
        r1 = r10.lRv;
        r2 = r10.z(r0);
        r1.addAll(r2);
    L_0x018d:
        r1 = r10.lRy;
        if (r1 == 0) goto L_0x019a;
    L_0x0191:
        r1 = r10.lRv;
        r2 = r10.A(r0);
        r1.addAll(r2);
    L_0x019a:
        r1 = r10.lRB;
        if (r1 == 0) goto L_0x01a7;
    L_0x019e:
        r1 = r10.lRv;
        r2 = r10.B(r0);
        r1.addAll(r2);
    L_0x01a7:
        r1 = r0 instanceof android.text.Spannable;
        if (r1 == 0) goto L_0x021b;
    L_0x01ab:
        r0 = (android.text.SpannableString) r0;
        r1 = r0;
    L_0x01ae:
        r0 = r10.lRI;
        if (r0 == 0) goto L_0x0221;
    L_0x01b2:
        r0 = r10.lRu;
        r2 = r0.iterator();
    L_0x01b8:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0221;
    L_0x01be:
        r0 = r2.next();
        r0 = (com.tencent.mm.pluginsdk.ui.applet.h) r0;
        r5 = r0.start;
        r6 = r1.length();
        if (r5 > r6) goto L_0x01b8;
    L_0x01cc:
        r5 = r0.end;
        r6 = r1.length();
        if (r5 > r6) goto L_0x01b8;
    L_0x01d4:
        r5 = new com.tencent.mm.pluginsdk.ui.d.i;
        r6 = r10.lRG;
        r5.<init>(r6, r0);
        r6 = r0.start;
        r0 = r0.end;
        r7 = 33;
        r1.setSpan(r5, r6, r0, r7);
        goto L_0x01b8;
    L_0x01e5:
        r0 = r10.mContext;
        r2 = 2131493169; // 0x7f0c0131 float:1.860981E38 double:1.053097549E-314;
        r0 = com.tencent.mm.bd.a.N(r0, r2);
        r10.lRH = r0;
        goto L_0x00d0;
    L_0x01f2:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 16;
        if (r0 != r2) goto L_0x0215;
    L_0x01f8:
        r0 = android.os.Build.MANUFACTURER;
        r2 = "";
        r0 = com.tencent.mm.sdk.platformtools.be.ah(r0, r2);
        r0 = r0.toLowerCase();
        r2 = "meizu";
        r2 = r2.toLowerCase();
        r0 = r0.indexOf(r2);
        if (r0 >= 0) goto L_0x0215;
    L_0x0212:
        r0 = r1;
        goto L_0x00f9;
    L_0x0215:
        r0 = r3;
        goto L_0x00f9;
    L_0x0218:
        r0 = r3;
        goto L_0x0111;
    L_0x021b:
        r1 = new android.text.SpannableString;
        r1.<init>(r0);
        goto L_0x01ae;
    L_0x0221:
        r0 = r10.lRw;
        r5 = r0.iterator();
    L_0x0227:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x029a;
    L_0x022d:
        r0 = r5.next();
        r0 = (com.tencent.mm.pluginsdk.ui.applet.i) r0;
        r2 = r0.start;
        r6 = r1.length();
        if (r2 > r6) goto L_0x0227;
    L_0x023b:
        r2 = r0.end;
        r6 = r1.length();
        if (r2 > r6) goto L_0x0227;
    L_0x0243:
        r2 = r10.mContext;
        r2 = r2.getResources();
        r6 = r0.id;
        r6 = r2.getDrawable(r6);
        r2 = r0.width;
        if (r2 <= 0) goto L_0x0284;
    L_0x0253:
        r2 = r0.height;
        if (r2 <= 0) goto L_0x0284;
    L_0x0257:
        r2 = r10.mContext;
        r7 = r0.width;
        r2 = com.tencent.mm.bd.a.fromDPToPix(r2, r7);
        r7 = r10.mContext;
        r8 = r0.height;
        r7 = com.tencent.mm.bd.a.fromDPToPix(r7, r8);
        r6.setBounds(r3, r3, r2, r7);
    L_0x026a:
        r2 = new com.tencent.mm.ui.widget.e;
        r2.<init>(r6);
        r6 = r10.mContext;
        r7 = 2;
        r6 = com.tencent.mm.bd.a.fromDPToPix(r6, r7);
        r2.pbC = r6;
        r6 = r0.start;
        r0 = r0.start;
        r0 = r0 + 1;
        r7 = 18;
        r1.setSpan(r2, r6, r0, r7);
        goto L_0x0227;
    L_0x0284:
        r2 = r10.kG;
        if (r2 != 0) goto L_0x0291;
    L_0x0288:
        r2 = r10.lRH;
        r2 = (float) r2;
        r2 = r2 * r9;
        r2 = (int) r2;
    L_0x028d:
        r6.setBounds(r3, r3, r2, r2);
        goto L_0x026a;
    L_0x0291:
        r2 = r10.kG;
        r2 = r2.getTextSize();
        r2 = r2 * r9;
        r2 = (int) r2;
        goto L_0x028d;
    L_0x029a:
        r10.c(r1);
        r10.bqL();
        if (r13 == 0) goto L_0x02ac;
    L_0x02a2:
        r0 = lRt;
        r2 = new android.text.SpannableString;
        r2.<init>(r1);
        r0.k(r4, r2);
    L_0x02ac:
        r0 = r1;
        goto L_0x000f;
    L_0x02af:
        r0 = r11;
        goto L_0x0159;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.d.k.a(java.lang.CharSequence, int, boolean):android.text.SpannableString");
    }

    private static void b(Spannable spannable) {
        int i = 0;
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        while (i < spans.length) {
            if (!((spans[i] instanceof e) || (spans[i] instanceof i))) {
                spannable.removeSpan(spans[i]);
            }
            i++;
        }
    }

    private CharSequence u(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQJ.matcher(charSequence.toString());
        while (matcher.find()) {
            CharSequence replace;
            if (this.lRE) {
                replace = charSequence.toString().replace(matcher.group(0), SQLiteDatabase.KeyEmpty);
            } else {
                replace = charSequence.toString().replace(matcher.group(0), "  ");
                String group = matcher.group(1);
                int start = matcher.start();
                int i = start + 2;
                int identifier = this.mContext.getResources().getIdentifier(group.toLowerCase(), "drawable", this.mContext.getPackageName());
                if (identifier != 0) {
                    i iVar = new i(start, i, identifier);
                    if (!be.kS(group) && "original_label".equals(group)) {
                        iVar.height = 15;
                        iVar.width = 35;
                    }
                    this.lRw.add(iVar);
                } else {
                    v.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQH.matcher(replace);
            charSequence = replace;
        }
        return charSequence;
    }

    private CharSequence v(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQI.matcher(charSequence);
        CharSequence charSequence2 = charSequence;
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Object group4 = matcher.group(3);
            if (group3.length() >= 2) {
                CharSequence replace = charSequence2.toString().replace(group, group4);
                int start = matcher.start(0);
                int length = start + group4.length();
                if (start < 0 || length > charSequence.length()) {
                    v.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                    charSequence2 = replace;
                } else {
                    int parseColor;
                    try {
                        parseColor = Color.parseColor(group2);
                    } catch (Exception e) {
                        v.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", group2);
                        parseColor = 0;
                    }
                    h a = a.a(this.mContext, group3, start, length, parseColor, parseColor & -1711276033);
                    if (a != null) {
                        if (this.lRJ != null) {
                            a.data = this.lRJ;
                        }
                        this.lRu.add(a);
                        this.lRv.add(new a(this, start, length));
                    }
                    matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQI.matcher(replace);
                    charSequence2 = replace;
                }
            }
        }
        return charSequence2;
    }

    private CharSequence w(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQH.matcher(charSequence.toString());
        CharSequence charSequence2 = charSequence;
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            Object group3 = matcher.group(2);
            if (group2.length() >= 2) {
                charSequence2 = charSequence2.toString().replace(group, group3);
                int start = matcher.start(0);
                int length = group3.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    v.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    h a = a.a(this.mContext, group2, start, length);
                    if (a != null) {
                        this.lRu.add(a);
                        this.lRv.add(new a(this, start, length));
                    }
                    matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQH.matcher(charSequence2);
                }
            }
        }
        return charSequence2;
    }

    private ArrayList<a> x(CharSequence charSequence) {
        int i = 2000;
        ArrayList<a> arrayList = new ArrayList();
        Pattern pattern = com.tencent.mm.pluginsdk.ui.d.d.a.lQN;
        if (charSequence.length() <= 2000) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            h hVar = new h(matcher.group(), 24, null);
            hVar.start = start;
            hVar.end = end;
            if (!a(this.lRv, new a(this, start, end))) {
                this.lRu.add(hVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> y(CharSequence charSequence) {
        Matcher matcher;
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQM.matcher(charSequence2.toLowerCase());
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQL.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.lRv, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end < charSequence2.length()) {
                    char charAt = charSequence2.charAt(end);
                    if ('a' <= charAt && charAt <= 'z') {
                    }
                }
                h hVar = new h(charSequence2.substring(start, end), 1, this.lRJ);
                hVar.start = start;
                hVar.end = end;
                this.lRu.add(hVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> z(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQP.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.lRv, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                h hVar = new h(charSequence2.substring(start, end), 28, null);
                hVar.start = start;
                hVar.end = end;
                this.lRu.add(hVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> A(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQO.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Object group = matcher.group();
            int i = end - start;
            if (group.startsWith("+")) {
                i--;
            }
            if ((!(i == 6 || i == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567".contains(group)) && !a(this.lRv, new a(this, start, end))) {
                h hVar = new h(group, 25, this.lRJ);
                hVar.start = start;
                hVar.end = end;
                this.lRu.add(hVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> B(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Iterator it = a.aS(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            a aVar = new a(this, hVar.start, hVar.end);
            if (!a(this.lRv, aVar)) {
                this.lRu.add(hVar);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList<a> C(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQR.matcher(charSequence2);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            a aVar = new a(this, start, end);
            if (!a(this.lRv, aVar) && start >= 0 && end <= charSequence2.length()) {
                h hVar = new h(charSequence2.substring(start, end), 30, null);
                hVar.start = start;
                hVar.end = end;
                this.lRu.add(hVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() <= 0) {
            matcher = com.tencent.mm.pluginsdk.ui.d.d.a.lQQ.matcher(charSequence2);
            while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                aVar = new a(this, start, end);
                if (!a(this.lRv, aVar) && start >= 0 && end <= charSequence2.length()) {
                    hVar = new h(charSequence2.substring(start, end), 30, null);
                    hVar.start = start;
                    hVar.end = end;
                    this.lRu.add(hVar);
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private static boolean a(ArrayList<a> arrayList, a aVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj;
            a aVar2 = (a) it.next();
            if (aVar2.end <= aVar.start || aVar.end <= aVar2.start) {
                obj = null;
                continue;
            } else {
                obj = 1;
                continue;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private void c(Spannable spannable) {
        if (this.kG != null && !be.kS(spannable.toString())) {
            if (q.dqJ) {
                this.kG.setText(spannable, BufferType.SPANNABLE);
            } else {
                this.kG.setText(spannable);
            }
        }
    }

    private void bqL() {
        if (this.kG != null) {
            OnTouchListener hVar = new h();
            hVar.jGE = this.jGE;
            this.kG.setOnTouchListener(hVar);
        }
    }

    public static void clearCache() {
        lRt.clear();
    }
}
