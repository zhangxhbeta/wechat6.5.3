package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.app.plugin.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.FileUtils;

class bw extends b {
    private a onG;

    public bw(int i) {
        super(i);
    }

    public View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903307);
        view.setTag(new ed(this.eKg).o(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.nQK;
    }

    public void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        CharSequence trim;
        CharSequence charSequence;
        Object obj;
        Object obj2;
        Object obj3;
        CharSequence charSequence2;
        TextView textView;
        int i2;
        this.onG = aVar2;
        ed edVar = (ed) aVar;
        String str2 = atVar.field_content;
        String str3 = atVar.field_transContent;
        String str4 = aVar2.onh.bdo;
        Object obj4 = null;
        if (c.oP()) {
            edVar.olI.jJ(false);
            if (atVar.bwu()) {
                if (atVar.bwy()) {
                    edVar.olI.OR(atVar.field_transBrandWording);
                    obj4 = 1;
                } else {
                    edVar.olI.bEU();
                }
            } else if (aVar2.al(atVar) == ChattingTranslateView.a.Translating) {
                edVar.olI.bEV();
            } else {
                edVar.olI.bEU();
            }
        } else {
            edVar.olI.jJ(true);
        }
        if (aVar2.nQK && !aVar2.lKa) {
            int fK = aw.fK(str2);
            if (fK != -1) {
                String trim2 = str2.substring(0, fK).trim();
                if (trim2 == null || trim2.length() <= 0) {
                    trim2 = str4;
                }
                str2 = str2.substring(fK + 1).trim();
                if (obj4 != null) {
                    str3 = trim2;
                    trim = str3.substring(fK + 1).trim();
                    charSequence = str2;
                } else {
                    obj = str2;
                    String str5 = str3;
                    str3 = trim2;
                    obj2 = str5;
                }
                a((ad.a) edVar, aVar2, atVar, str3);
                ad.a((ad.a) edVar, aVar2, str3, atVar);
                if (atVar.bNo == null && atVar.bNo.contains("announcement@all")) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj4 == null && obj3 == null) {
                    charSequence2 = " ";
                    if (u.dW(aVar2.onh.cyO) || u.dW(aVar2.onh.bdo)) {
                        Context context = edVar.olH.getContext();
                        edVar.olH.getTextSize();
                        charSequence = e.b(context, charSequence, 1);
                        context = edVar.olH.getContext();
                        trim = atVar.field_transContent;
                        edVar.olH.getTextSize();
                        a(edVar.olH, charSequence, e.b(context, trim, 1), charSequence2, ah(atVar));
                    } else {
                        a(edVar.olH, e.a(edVar.olH.getContext(), charSequence, (int) edVar.olH.getTextSize(), 1), e.a(edVar.olH.getContext(), trim, (int) edVar.olH.getTextSize(), 1), charSequence2, ah(atVar));
                    }
                } else if (obj3 == null) {
                    edVar.d(edVar.olH, charSequence);
                    if (!u.dW(aVar2.onh.cyO) || u.dW(aVar2.onh.bdo)) {
                        edVar.olH.setText(charSequence);
                        textView = edVar.olH;
                        i2 = atVar.field_type;
                        str4 = ah(atVar);
                        if (i2 != 301989937) {
                            e.b(textView, null, str4);
                        }
                        textView.getText();
                    } else {
                        edVar.olH.setText(charSequence);
                        textView = edVar.olH;
                        i2 = atVar.field_type;
                        str4 = ah(atVar);
                        if (i2 != 301989937) {
                            e.a(textView, null, str4);
                        }
                        textView.getText();
                    }
                } else if (obj3 != null) {
                    charSequence2 = " ";
                    str3 = edVar.olH.getContext().getString(2131234628, new Object[]{"@"});
                    if (obj4 == null) {
                        a(edVar.olH, e.a(edVar.olH.getContext(), str3 + "\n" + charSequence, (int) edVar.olH.getTextSize(), Integer.valueOf(31)), e.a(edVar.olH.getContext(), trim, (int) edVar.olH.getTextSize(), Integer.valueOf(31)), charSequence2, ah(atVar));
                    } else {
                        edVar.olH.setText(str3 + "\n" + charSequence);
                        e.a(edVar.olH, Integer.valueOf(31), ah(atVar));
                    }
                }
                edVar.olH.setTag(dl.a(atVar, aVar2.nQK, i));
                edVar.olH.setOnClickListener(aVar2.onh.oqh);
                edVar.olH.setOnLongClickListener(aVar2.onh.oqj);
                edVar.olH.pdC = aVar2.onh.oql;
            }
        }
        obj2 = str3;
        str3 = str4;
        obj = str2;
        a((ad.a) edVar, aVar2, atVar, str3);
        ad.a((ad.a) edVar, aVar2, str3, atVar);
        if (atVar.bNo == null) {
        }
        obj3 = null;
        if (obj4 == null) {
        }
        if (obj3 == null) {
            edVar.d(edVar.olH, charSequence);
            if (u.dW(aVar2.onh.cyO)) {
            }
            edVar.olH.setText(charSequence);
            textView = edVar.olH;
            i2 = atVar.field_type;
            str4 = ah(atVar);
            if (i2 != 301989937) {
                e.b(textView, null, str4);
            }
            textView.getText();
        } else if (obj3 != null) {
            charSequence2 = " ";
            str3 = edVar.olH.getContext().getString(2131234628, new Object[]{"@"});
            if (obj4 == null) {
                edVar.olH.setText(str3 + "\n" + charSequence);
                e.a(edVar.olH, Integer.valueOf(31), ah(atVar));
            } else {
                a(edVar.olH, e.a(edVar.olH.getContext(), str3 + "\n" + charSequence, (int) edVar.olH.getTextSize(), Integer.valueOf(31)), e.a(edVar.olH.getContext(), trim, (int) edVar.olH.getTextSize(), Integer.valueOf(31)), charSequence2, ah(atVar));
            }
        }
        edVar.olH.setTag(dl.a(atVar, aVar2.nQK, i));
        edVar.olH.setOnClickListener(aVar2.onh.oqh);
        edVar.olH.setOnLongClickListener(aVar2.onh.oqj);
        edVar.olH.pdC = aVar2.onh.oql;
    }

    private void a(TextView textView, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, String str) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append(charSequence3);
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append(charSequence2);
        int length = charSequence.length() + 1;
        int length2 = charSequence3.length();
        textView.measure(0, 0);
        Drawable drawable = this.onG.getResources().getDrawable(2130839349);
        drawable.setBounds(0, 0, (textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight(), 2);
        spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), length, length + length2, 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), length + 1, (length + length2) + 1, 17);
        textView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        OnTouchListener hVar = new h();
        hVar.jGE = str;
        textView.setOnTouchListener(hVar);
    }

    private String ah(at atVar) {
        if (atVar == null) {
            return null;
        }
        String fz = o.fz(atVar.field_msgSvrId);
        o.b n = o.yx().n(fz, true);
        n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
        n.l("preUsername", a(this.onG, atVar));
        n.l("preChatName", ad.b(this.onG, atVar));
        return fz;
    }

    protected boolean bEy() {
        return false;
    }

    public boolean a(ContextMenu contextMenu, View view, at atVar) {
        if (atVar.bwm() || atVar.bwe()) {
            int i = ((dl) view.getTag()).position;
            if (atVar.bwm()) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_READ_FAILED, 0, view.getContext().getString(2131231826));
            }
            contextMenu.add(i, MMGIFException.D_GIF_ERR_DATA_TOO_BIG, 0, view.getContext().getString(2131234555));
            if (com.tencent.mm.ay.c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            if (g.G(this.onG.nDR.nEl, atVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
            }
            if (atVar.bwm() && com.tencent.mm.modelbiz.e.De()) {
                this.onG.bFL();
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
            }
            if (c.oP()) {
                if (atVar.bwu() && atVar.bwy()) {
                    contextMenu.add(i, 124, 0, view.getContext().getString(2131231840));
                } else {
                    contextMenu.add(i, 124, 0, view.getContext().getString(2131231841));
                }
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }
}
