package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.mm.bf.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class e {
    static LinkedList<b> lQS = new LinkedList();

    public static void a(b bVar) {
        lQS.add(bVar);
    }

    public static void b(b bVar) {
        lQS.remove(bVar);
    }

    public static SpannableString a(TextView textView, Object obj) {
        return a(textView, 1, true, obj);
    }

    public static SpannableString a(TextView textView, int i, boolean z, Object obj) {
        if (textView == null) {
            v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        int textSize = (int) textView.getTextSize();
        k kVar = new k(textView.getContext());
        kVar.lRy = true;
        kVar.lRx = true;
        kVar.lRD = true;
        kVar.lRF = true;
        kVar.lRG = 1;
        kVar.lRz = true;
        kVar.lRB = false;
        kVar.lRI = true;
        k i2 = kVar.i(textView);
        i2.lRA = true;
        i2.lRC = true;
        if (obj != null) {
            i2.lRJ = obj;
        }
        return i2.a(textView.getText(), textSize, z);
    }

    public static SpannableString e(TextView textView, int i) {
        if (textView == null) {
            v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        int textSize = (int) textView.getTextSize();
        k kVar = new k(textView.getContext());
        kVar.lRy = true;
        kVar.lRx = true;
        kVar.lRG = i;
        kVar.lRz = true;
        kVar.lRB = false;
        kVar.lRI = true;
        k i2 = kVar.i(textView);
        if (i == 1) {
            i2.lRA = true;
            i2.lRC = true;
        } else if (i == 2) {
            i2.lRA = false;
            i2.lRC = false;
        }
        return i2.a(textView.getText(), textSize, true);
    }

    public static SpannableString a(TextView textView, Object obj, String str) {
        if (textView == null) {
            v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        int textSize = (int) textView.getTextSize();
        k kVar = new k(textView.getContext());
        kVar.lRy = true;
        kVar.lRx = true;
        kVar.lRG = 1;
        kVar.lRz = true;
        kVar.lRB = false;
        kVar.lRI = true;
        k i = kVar.i(textView);
        i.lRJ = obj;
        i.jGE = str;
        i.lRA = true;
        i.lRC = true;
        return i.a(textView.getText(), textSize, true);
    }

    public static SpannableString h(TextView textView) {
        if (textView == null) {
            v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        int textSize = (int) textView.getTextSize();
        k kVar = new k(textView.getContext());
        kVar.lRy = true;
        kVar.lRx = false;
        kVar.lRG = 1;
        kVar.lRz = true;
        kVar.lRB = false;
        kVar.lRI = false;
        k i = kVar.i(textView);
        i.lRA = true;
        i.lRC = true;
        return i.a(textView.getText(), textSize, true);
    }

    public static SpannableString b(TextView textView, Object obj, String str) {
        if (textView == null) {
            v.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString(SQLiteDatabase.KeyEmpty);
        }
        int textSize = (int) textView.getTextSize();
        k kVar = new k(textView.getContext());
        kVar.lRy = true;
        kVar.lRx = false;
        kVar.lRG = 1;
        kVar.lRz = true;
        kVar.lRB = false;
        kVar.lRI = false;
        k i = kVar.i(textView);
        i.lRJ = null;
        i.jGE = str;
        i.lRA = true;
        i.lRC = true;
        return i.a(textView.getText(), textSize, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i) {
        return c(context, charSequence, i);
    }

    public static SpannableString a(Context context, CharSequence charSequence, float f) {
        return c(context, charSequence, (int) f);
    }

    public static SpannableString b(Context context, CharSequence charSequence, int i) {
        k kVar = new k(context);
        kVar.lRz = false;
        kVar.lRA = false;
        kVar.lRx = false;
        kVar.lRB = false;
        kVar.lRG = i;
        kVar.lRy = false;
        kVar.lRI = false;
        CharSequence a = kVar.a(charSequence, 0, true);
        g.buU();
        g.d(a);
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence) {
        return c(context, charSequence, 0);
    }

    private static SpannableString c(Context context, CharSequence charSequence, int i) {
        k kVar = new k(context);
        kVar.lRz = false;
        kVar.lRA = false;
        kVar.lRx = false;
        kVar.lRB = false;
        kVar.lRy = false;
        kVar.lRI = false;
        CharSequence a = kVar.a(charSequence, i, true);
        g.buU();
        g.d(a);
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, int i2) {
        k kVar = new k(context);
        kVar.lRy = true;
        kVar.lRx = true;
        kVar.lRG = i2;
        kVar.lRz = true;
        kVar.lRB = false;
        kVar.lRI = true;
        if (i2 == 1) {
            kVar.lRA = true;
            kVar.lRC = true;
        } else if (i2 == 2) {
            kVar.lRA = false;
            kVar.lRC = false;
        }
        return kVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj) {
        k kVar = new k(context);
        kVar.lRy = true;
        kVar.lRx = true;
        kVar.lRG = 1;
        kVar.lRz = true;
        kVar.lRB = false;
        kVar.lRI = true;
        kVar.lRJ = obj;
        kVar.lRA = true;
        kVar.lRC = true;
        return kVar.a(charSequence, i, true);
    }

    public static SpannableString d(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, true);
    }

    public static SpannableString b(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, false);
    }

    private static SpannableString a(Context context, CharSequence charSequence, int i, boolean z) {
        k kVar = new k(context);
        kVar.lRy = false;
        kVar.lRx = true;
        kVar.lRD = true;
        kVar.lRE = z;
        kVar.lRF = true;
        kVar.lRG = 1;
        kVar.lRz = false;
        kVar.lRB = false;
        kVar.lRA = false;
        kVar.lRC = false;
        kVar.lRI = false;
        return kVar.a(charSequence, i, true);
    }

    public static String HP(String str) {
        if (be.kS(str)) {
            return str;
        }
        k kVar = new k(aa.getContext());
        kVar.lRy = false;
        kVar.lRx = true;
        kVar.lRD = true;
        kVar.lRE = true;
        kVar.lRF = true;
        kVar.lRG = 1;
        kVar.lRz = false;
        kVar.lRB = false;
        kVar.lRA = false;
        kVar.lRC = false;
        kVar.pRu = false;
        kVar.lRI = false;
        return kVar.a(str, 0, false).toString();
    }

    public static void clearCache() {
        v.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        k.clearCache();
        g.buU();
    }
}
