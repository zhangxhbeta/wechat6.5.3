package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.text.TextUtils;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class j {
    private static SimpleDateFormat eNn = null;
    private static SimpleDateFormat eNo = null;
    private static SimpleDateFormat eNp = null;

    public static int qv(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            v.e("MicroMsg.CardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                v.e("MicroMsg.CardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static int am(String str, int i) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            v.e("MicroMsg.CardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(i, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                v.e("MicroMsg.CardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static ShapeDrawable t(Context context, int i) {
        return bs(i, context.getResources().getDimensionPixelOffset(2131493342));
    }

    public static ShapeDrawable bs(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static ShapeDrawable c(Context context, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131493170);
        float[] fArr = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStrokeWidth((float) dimensionPixelSize);
        return shapeDrawable;
    }

    public static List<b> ac(List<jg> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<b> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            jg jgVar = (jg) list.get(i);
            b bVar = new b();
            bVar.title = jgVar.title;
            bVar.eBN = jgVar.eBN;
            bVar.eEL = jgVar.eEL;
            bVar.url = jgVar.url;
            bVar.mlB = jgVar.mlB;
            bVar.eBV = false;
            bVar.eBU = 1;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String ao(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (eNn == null) {
            eNn = new SimpleDateFormat("yyyy.MM.dd");
        }
        return eNn.format(new Date(j2));
    }

    public static boolean qw(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static Bitmap k(Bitmap bitmap) {
        boolean z = true;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.CardUtil";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        v.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        return createBitmap;
    }

    public static void l(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            v.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[]{bitmap});
            bitmap.recycle();
        }
    }

    public static boolean b(CardInfo cardInfo) {
        if (cardInfo == null) {
            v.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            return false;
        }
        CardInfo pQ = af.aak().pQ(cardInfo.field_card_id);
        if (pQ == null) {
            boolean b = af.aak().b(cardInfo);
            v.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", new Object[]{Boolean.valueOf(b)});
            if (!b) {
                v.e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            return b;
        }
        cardInfo.field_stickyIndex = pQ.field_stickyIndex;
        cardInfo.field_stickyEndTime = pQ.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = pQ.field_stickyAnnouncement;
        v.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[]{Boolean.valueOf(af.aak().a(cardInfo, new String[0]))});
        return af.aak().a(cardInfo, new String[0]);
    }

    public static void a(com.tencent.mm.plugin.card.base.b bVar, String str, String str2, int i) {
        byte[] E;
        a aVar;
        Bitmap a = com.tencent.mm.platformtools.j.a(new i(bVar.Zv().eBM));
        if (a != null) {
            E = d.E(a);
        } else {
            E = null;
        }
        if (bVar == null) {
            aVar = null;
        } else {
            int i2;
            if (i == 23) {
                i = 2;
                i2 = 1;
            } else {
                i2 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            a aVar2 = new a();
            if (bVar.Zv() != null) {
                aVar2.title = bVar.Zx().mSm;
                aVar2.description = bVar.Zv().title;
                aVar2.type = 16;
                aVar2.aXx = 0;
                aVar2.coe = 3;
                aVar2.appId = bVar.Zv().bmJ;
                aVar2.cov = 0;
                aVar2.thumburl = bVar.Zv().eBM;
                aVar2.cpo = i;
                aVar2.cpn = bVar.Zv().eCD;
                aVar2.url = bVar.Zv().mkT;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<from_username>").append(bVar.ZB()).append("</from_username>");
            if (jj(i)) {
                stringBuilder2.append("<card_id>").append(bVar.ZA()).append("</card_id>");
            } else if (i == 5) {
                stringBuilder2.append("<card_id>").append(bVar.Zz()).append("</card_id>");
            }
            stringBuilder2.append("<card_type>").append(bVar.Zv().eBL).append("</card_type>");
            stringBuilder2.append("<from_scene>").append(i).append("</from_scene>");
            stringBuilder2.append("<color>").append(bVar.Zv().coN).append("</color>");
            stringBuilder2.append("<card_type_name>").append(bVar.Zv().eCC).append("</card_type_name>");
            stringBuilder2.append("<brand_name>").append(bVar.Zv().eCD).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                stringBuilder2.append("<card_ext></card_ext>");
            } else {
                stringBuilder2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            stringBuilder2.append("<is_recommend>").append(i2).append("</is_recommend>");
            stringBuilder2.append("<recommend_card_id>").append(bVar.Zz()).append("</recommend_card_id>");
            aVar2.cpm = stringBuilder.append(stringBuilder2.toString()).toString();
            aVar2.bgD = a.b(aVar2);
            aVar = aVar2;
        }
        l.a(aVar, bVar.Zv().bmJ, bVar.Zv().eCD, str, null, E);
    }

    public static void bk(String str, String str2) {
        if (!be.kS(str)) {
            mr mrVar = new mr();
            mrVar.boa.bob = str2;
            mrVar.boa.content = str;
            mrVar.boa.type = m.fp(str2);
            mrVar.boa.flags = 0;
            com.tencent.mm.sdk.c.a.nhr.z(mrVar);
        }
    }

    public static boolean jj(int i) {
        return i == 0 || i == 1 || i == 2 || i == 9 || i == 12 || i == 17 || i == 21;
    }

    public static boolean jk(int i) {
        return i == 7 || i == 8 || i == 16;
    }

    public static boolean jl(int i) {
        return i == 3 || i == 4 || i == 5 || i == 15;
    }

    public static boolean iT(int i) {
        switch (i) {
            case 0:
            case 10:
            case 11:
            case 20:
            case 30:
                return true;
            default:
                return false;
        }
    }

    public static void acG() {
        ak.yW();
        Integer num = (Integer) c.vf().get(282883, null);
        if (num == null || num.intValue() != 1) {
            v.i("MicroMsg.CardUtil", "open card entrance");
            ak.yW();
            c.vf().set(282883, Integer.valueOf(1));
            com.tencent.mm.p.c.us().s(262152, true);
            return;
        }
        v.i("MicroMsg.CardUtil", "card entrance is open");
    }

    public static boolean acH() {
        ak.yW();
        Integer num = (Integer) c.vf().get(282883, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static void acI() {
        ak.yW();
        Integer num = (Integer) c.vf().get(t.a.npN, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            v.i("MicroMsg.CardUtil", "open share card entrance");
            ak.yW();
            c.vf().a(t.a.npN, Integer.valueOf(1));
            com.tencent.mm.p.c.us().s(262152, true);
            return;
        }
        v.i("MicroMsg.CardUtil", "share card entrance is open");
    }

    public static boolean acJ() {
        ak.yW();
        Integer num = (Integer) c.vf().get(t.a.npN, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static String b(Context context, float f) {
        if (f <= 0.0f) {
            return "";
        }
        if (f > 0.0f && f < 1000.0f) {
            return context.getString(2131231613, new Object[]{((int) f)});
        } else if (f < 1000.0f) {
            return "";
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = new DecimalFormat("0.00").format((double) (f / 1000.0f));
            return context.getString(2131231612, objArr);
        }
    }

    public static boolean FZ() {
        try {
            return ((LocationManager) aa.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            v.a("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean Ga() {
        try {
            return ((LocationManager) aa.getContext().getSystemService("location")).isProviderEnabled("network");
        } catch (Throwable e) {
            v.a("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean a(ShareCardInfo shareCardInfo) {
        if (shareCardInfo == null) {
            v.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            return false;
        }
        ShareCardInfo qc = af.aas().qc(shareCardInfo.field_card_id);
        if (qc == null) {
            boolean b = af.aas().b(shareCardInfo);
            v.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[]{Boolean.valueOf(b)});
            if (b) {
                com.tencent.mm.plugin.card.sharecard.a.b.bg(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            } else {
                v.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            }
            return b;
        }
        shareCardInfo.field_categoryType = qc.field_categoryType;
        shareCardInfo.field_itemIndex = qc.field_itemIndex;
        v.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[]{Boolean.valueOf(af.aas().a(shareCardInfo, new String[0]))});
        return af.aas().a(shareCardInfo, new String[0]);
    }

    public static boolean g(com.tencent.mm.plugin.card.base.b bVar) {
        boolean a;
        if (bVar instanceof CardInfo) {
            a = af.aak().a((CardInfo) bVar, new String[0]);
            if (a) {
                return a;
            }
            v.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[]{bVar.Zz()});
            return a;
        } else if (!(bVar instanceof ShareCardInfo)) {
            return false;
        } else {
            a = af.aas().a((ShareCardInfo) bVar, new String[0]);
            if (a) {
                return a;
            }
            v.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[]{bVar.Zz()});
            return a;
        }
    }

    public static void qx(String str) {
        ak.yW();
        c.vf().a(t.a.npL, str);
    }

    public static String acK() {
        ak.yW();
        return (String) c.vf().get(t.a.npL, "");
    }

    public static String qy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        CharSequence et = com.tencent.mm.model.l.et(str);
        CharSequence er = com.tencent.mm.model.l.er(str);
        if (!TextUtils.isEmpty(et)) {
            return et;
        }
        if (TextUtils.isEmpty(er)) {
            return str;
        }
        return er;
    }

    public static ArrayList<String> ad(List<String> list) {
        if (list == null || list.isEmpty()) {
            v.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        for (String vv : list) {
            Collection vy = com.tencent.mm.pluginsdk.j.a.bmu().vy(com.tencent.mm.pluginsdk.j.a.bmu().vv(vv));
            if (vy == null || vy.size() == 0) {
                v.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(vy);
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public static ArrayList<String> ae(List<String> list) {
        if (list == null || list.isEmpty()) {
            v.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String vv : list) {
            CharSequence vv2 = com.tencent.mm.pluginsdk.j.a.bmu().vv(vv);
            if (!TextUtils.isEmpty(vv2)) {
                arrayList.add(vv2);
            }
        }
        return arrayList;
    }

    public static String qz(String str) {
        List list;
        List<Object> asList = Arrays.asList(str.split(","));
        List linkedList = new LinkedList();
        if (ak.uz()) {
            if (asList == null || asList.size() == 0) {
                list = linkedList;
                return be.b(list, ",");
            }
            for (Object obj : asList) {
                Object obj2;
                ak.yW();
                u LX = c.wH().LX(obj2);
                if (!(LX == null || ((int) LX.chr) == 0)) {
                    obj2 = LX.tU();
                }
                linkedList.add(obj2);
            }
        }
        list = linkedList;
        return be.b(list, ",");
    }

    public static auw a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        v.i("MicroMsg.CardUtil", "getShareTag()");
        auw com_tencent_mm_protocal_c_auw = new auw();
        Collection arrayList3;
        int i2;
        String str;
        if (i == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                com_tencent_mm_protocal_c_auw.mSn.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                for (i2 = 0; i2 < arrayList2.size(); i2++) {
                    str = (String) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(str) && qw(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                }
                com_tencent_mm_protocal_c_auw.mSq.addAll(arrayList3);
            }
        } else if (i == 3) {
            if (arrayList != null && arrayList.size() > 0) {
                com_tencent_mm_protocal_c_auw.mSp.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                for (i2 = 0; i2 < arrayList2.size(); i2++) {
                    str = (String) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(str) && qw(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                }
                com_tencent_mm_protocal_c_auw.mSr.addAll(arrayList3);
            }
        }
        return com_tencent_mm_protocal_c_auw;
    }

    public static boolean a(ld ldVar, String str) {
        if (aN(ldVar.mlB)) {
            String str2 = ldVar.title;
            if (qA(str)) {
                v.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            v.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        v.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    public static boolean a(b bVar, String str) {
        if (aN(bVar.mlB)) {
            String str2 = bVar.title;
            if (qA(str)) {
                v.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            v.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        v.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    private static boolean aN(long j) {
        if ((8 & j) <= 0) {
            return false;
        }
        v.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
        return true;
    }

    private static boolean qA(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            return true;
        }
        v.i("MicroMsg.CardUtil", "hasShowWarning()");
        ak.yW();
        String str2 = (String) c.vf().get(t.a.npS, "");
        if (TextUtils.isEmpty(str2)) {
            v.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            v.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            return false;
        }
        for (Object equals : split) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static void qB(String str) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            return;
        }
        v.i("MicroMsg.CardUtil", "setShowWarningFlag()");
        ak.yW();
        String str2 = (String) c.vf().get(t.a.npS, "");
        if (TextUtils.isEmpty(str2)) {
            v.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str2.split(",");
            if (split == null || split.length == 0) {
                v.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
                str2 = str;
            }
            for (Object equals : split) {
                if (str.equals(equals)) {
                    obj = 1;
                }
            }
            str = obj == null ? str2 + "," + str : str2;
        }
        ak.yW();
        c.vf().a(t.a.npS, str);
    }

    public static String o(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        float f = af.aaq().bYg;
        float f2 = af.aaq().bYf;
        if (f == -1000.0f || f2 == -1000.0f) {
            v.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            return str;
        } else if ((16 & j) <= 0) {
            return str;
        } else {
            String replace = str.replace("#", ("&longitude=" + f + "&latitude=" + f2) + "#");
            v.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:" + str);
            v.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:" + replace);
            return replace;
        }
    }

    public static int qC(String str) {
        if (TextUtils.isEmpty(str) || str.equals(k.xF())) {
            return 0;
        }
        return 1;
    }

    public static Drawable c(Context context, String str, int i) {
        Drawable c = c(context, qv(str), i);
        Drawable bs = bs(qv(str), i);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, bs);
        stateListDrawable.addState(new int[0], c);
        return stateListDrawable;
    }

    public static ColorStateList N(Context context, String str) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, new int[]{context.getResources().getColor(2131690127), qv(str)});
    }
}
