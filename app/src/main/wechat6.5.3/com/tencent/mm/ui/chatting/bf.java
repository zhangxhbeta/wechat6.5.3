package com.tencent.mm.ui.chatting;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class bf {
    private static final LayoutParams ooR = new LayoutParams(-1, -2);

    private static class a implements Comparable<a> {
        public boolean boR;
        public int color;
        public int offset;
        public int ooS;
        public boolean ooT;
        public String ooU;

        private a() {
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (aVar != null) {
                return this.offset - aVar.offset;
            }
            v.e("MicroMsg.LineNode", "compareTo fail, should not be null");
            return 1;
        }

        public static a p(Map<String, String> map, String str) {
            a aVar = new a();
            try {
                aVar.offset = be.getInt((String) map.get(str + ".offset"), 0);
                String str2 = (String) map.get(str + ".font");
                if (be.kS(str2)) {
                    v.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
                    str2 = "m";
                } else {
                    str2 = str2.toLowerCase();
                }
                aVar.boR = str2.contains("b");
                aVar.ooT = str2.contains("u");
                aVar.ooS = bf.ON(str2);
                aVar.color = bf.ce((String) map.get(str + ".color"), WebView.NIGHT_MODE_COLOR);
                aVar.ooU = (String) map.get(str + ".chars");
                if (!be.kS(aVar.ooU)) {
                    return aVar;
                }
                v.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
                return null;
            } catch (Exception e) {
                v.e("MicroMsg.LineNode", "parseFrom fail, ex = " + e.getMessage());
                return null;
            }
        }
    }

    private static class b {
        public boolean boR;
        public int color;
        public int ooS;
        public boolean ooT;
        public int ooV;
        public int ooW;

        private b() {
        }

        public static b q(Map<String, String> map, String str) {
            String str2 = (String) map.get(str + ".range");
            if (be.kS(str2)) {
                v.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
                return null;
            } else if (str2.length() >= 5 && str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}' && str2.contains(",")) {
                v.d("MicroMsg.StyleNode", "parseFrom, range = " + str2);
                String[] split = str2.substring(1, str2.length() - 1).split(",");
                if (split == null || split.length != 2) {
                    v.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + split.length);
                    return null;
                }
                b bVar = new b();
                try {
                    bVar.ooV = Integer.parseInt(split[0]);
                    bVar.ooW = Integer.parseInt(split[1]) + bVar.ooV;
                    str2 = (String) map.get(str + ".font");
                    if (be.kS(str2)) {
                        v.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
                        str2 = "m";
                    } else {
                        str2 = str2.toLowerCase();
                    }
                    bVar.boR = str2.contains("b");
                    bVar.ooT = str2.contains("u");
                    bVar.ooS = bf.ON(str2);
                    bVar.color = bf.ce((String) map.get(str + ".color"), WebView.NIGHT_MODE_COLOR);
                    return bVar;
                } catch (Exception e) {
                    v.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + e.getMessage());
                    return null;
                }
            } else {
                v.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = " + str2);
                return null;
            }
        }
    }

    static /* synthetic */ int ON(String str) {
        if (str.contains("m")) {
            return 18;
        }
        return str.contains("l") ? 21 : 14;
    }

    public static boolean a(LinearLayout linearLayout, Map<String, String> map) {
        if (linearLayout == null) {
            v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
            return false;
        }
        String str = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        if (be.kS(str)) {
            v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
            return false;
        }
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(WebView.NIGHT_MODE_COLOR), 0, spannableString.length(), 17);
        } catch (IndexOutOfBoundsException e) {
            v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", e.getMessage());
        }
        int i = 0;
        while (true) {
            String str2 = ".msg.appmsg.mmreader.category.item.styles.style" + (i == 0 ? SQLiteDatabase.KeyEmpty : String.valueOf(i));
            if (!map.containsKey(str2)) {
                break;
            }
            b q = b.q(map, str2);
            if (q == null) {
                v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = " + str2);
            } else if (q.ooV >= q.ooW) {
                v.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + q.ooV + ", rangeTo = " + q.ooW);
            } else {
                int length;
                int i2 = q.ooV;
                int i3 = q.ooW;
                int i4 = q.ooS;
                boolean z = q.boR;
                boolean z2 = q.ooT;
                v.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", fontSize = " + i4 + ", isBlack = " + z + ", isUnderLine = " + z2);
                if (i2 < 0) {
                    v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    length = spannableString.length();
                } else {
                    length = i3;
                }
                if (z) {
                    try {
                        spannableString.setSpan(new StyleSpan(1), i2, length, 17);
                    } catch (IndexOutOfBoundsException e2) {
                        v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e2.getMessage());
                    }
                }
                if (z2) {
                    try {
                        spannableString.setSpan(new UnderlineSpan(), i2, length, 17);
                    } catch (IndexOutOfBoundsException e22) {
                        v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e22.getMessage());
                    }
                }
                if (i4 != 14) {
                    try {
                        spannableString.setSpan(new AbsoluteSizeSpan(i4), i2, length, 17);
                    } catch (IndexOutOfBoundsException e3) {
                        v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e3.getMessage());
                    }
                }
                i2 = q.ooV;
                i3 = q.ooW;
                length = q.color;
                v.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", color = " + length);
                if (i2 < 0) {
                    v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i3 = spannableString.length();
                }
                try {
                    spannableString.setSpan(new ForegroundColorSpan(length), i2, i3, 17);
                } catch (IndexOutOfBoundsException e32) {
                    v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e32.getMessage());
                }
            }
            i++;
        }
        v.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = " + i);
        i = 0;
        List arrayList = new ArrayList();
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.line" + (i == 0 ? SQLiteDatabase.KeyEmpty : String.valueOf(i));
            if (map.containsKey(str2)) {
                a p = a.p(map, str2);
                if (p == null) {
                    v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = " + str2);
                } else {
                    arrayList.add(p);
                }
                i++;
            } else {
                v.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = " + i);
                Collections.sort(arrayList);
                linearLayout.removeAllViews();
                a(linearLayout, spannableString, arrayList);
                return true;
            }
        }
    }

    private static boolean a(LinearLayout linearLayout, SpannableString spannableString, List<a> list) {
        v.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + list.size());
        int length = spannableString.length();
        int i = 0;
        for (a aVar : list) {
            if (aVar.offset > i) {
                View textView = new TextView(linearLayout.getContext());
                textView.setText(spannableString.subSequence(i, Math.min(aVar.offset, length)));
                textView.setLineSpacing(3.0f, 1.0f);
                linearLayout.addView(textView, ooR);
            }
            View textView2 = new TextView(linearLayout.getContext());
            textView2.setText(OL(aVar.ooU));
            textView2.setSingleLine(true);
            if (aVar.ooS != 14) {
                textView2.setTextSize((float) aVar.ooS);
            }
            if (aVar.boR) {
                textView2.setTypeface(null, 1);
            }
            if (aVar.ooT) {
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            textView2.setTextColor(aVar.color);
            linearLayout.addView(textView2, ooR);
            i = aVar.offset;
        }
        if (i >= length) {
            v.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + length);
        } else {
            View textView3 = new TextView(linearLayout.getContext());
            textView3.setTextSize(0, (float) com.tencent.mm.bd.a.N(textView3.getContext(), 2131493128));
            textView3.setText(spannableString.subSequence(i, length));
            textView3.setLineSpacing(2.0f, 1.0f);
            linearLayout.addView(textView3, ooR);
        }
        return true;
    }

    private static String OL(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() < 80) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private static int ce(String str, int i) {
        int i2 = WebView.NIGHT_MODE_COLOR;
        if (!be.kS(str)) {
            try {
                i2 = Color.parseColor(str);
            } catch (Exception e) {
                v.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + e.getMessage());
            }
        }
        return i2;
    }
}
