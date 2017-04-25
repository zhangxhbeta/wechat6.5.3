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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.model.o;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mmdb.FileUtils;

class bx extends c {
    private a onG;

    public bx(int i) {
        super(i);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903338);
        view.setTag(new ed(this.eKg).o(view, false));
        return view;
    }

    public void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        boolean z;
        boolean z2;
        int i2 = 8;
        this.onG = aVar2;
        aVar = (ed) aVar;
        if (ad.bEA()) {
            if (aVar.ieT != null) {
                aVar.ieT.setVisibility(8);
            }
            if (atVar.field_status == 1 || atVar.field_status == 5) {
                if (aVar.okm != null) {
                    aVar.okm.setVisibility(8);
                }
                aVar.olH.setBackgroundResource(2130838029);
                atVar.nvD = true;
            } else {
                aVar.olH.setBackgroundResource(2130838028);
                if (aVar.okm != null) {
                    if (ad.a(aVar2.onh, atVar.field_msgId)) {
                        if (atVar.nvD) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            aVar.olH.startAnimation(alphaAnimation);
                            atVar.nvD = false;
                        }
                        aVar.okm.setVisibility(0);
                    } else {
                        aVar.okm.setVisibility(8);
                    }
                }
            }
        } else if (aVar.ieT != null) {
            ProgressBar progressBar = aVar.ieT;
            if (atVar.field_status < 2) {
                i2 = 0;
            }
            progressBar.setVisibility(i2);
        }
        CharSequence charSequence = atVar.field_content;
        if (be.kS(charSequence)) {
            v.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId));
        }
        if (com.tencent.mm.app.plugin.c.oP()) {
            aVar.olI.jJ(false);
            if (atVar.bwu()) {
                if (atVar.bwy()) {
                    aVar.olI.OR(atVar.field_transBrandWording);
                    z = true;
                } else {
                    aVar.olI.bEU();
                    z = false;
                }
            } else if (aVar2.al(atVar) == ChattingTranslateView.a.Translating) {
                aVar.olI.bEV();
                z = false;
            } else {
                aVar.olI.bEU();
                z = false;
            }
        } else {
            aVar.olI.jJ(true);
            z = false;
        }
        if (z) {
            aVar.olI.measure(0, 0);
            aVar.olH.setMinWidth(aVar.olI.getMeasuredWidth());
        } else {
            aVar.olH.setMinWidth(0);
        }
        if (atVar.bNo == null || !atVar.bNo.contains("announcement@all")) {
            z2 = false;
        } else {
            z2 = true;
        }
        CharSequence charSequence2;
        if (z && !z2) {
            charSequence2 = " ";
            if (u.dW(aVar2.onh.cyO) || u.dW(aVar2.onh.bdo)) {
                Context context = aVar.olH.getContext();
                aVar.olH.getTextSize();
                CharSequence b = e.b(context, charSequence, 1);
                context = aVar.olH.getContext();
                CharSequence charSequence3 = atVar.field_transContent;
                aVar.olH.getTextSize();
                a(aVar.olH, b, e.b(context, charSequence3, 1), charSequence2, ah(atVar));
            } else {
                a(aVar.olH, e.a(aVar.olH.getContext(), charSequence, (int) aVar.olH.getTextSize(), 1), e.a(aVar.olH.getContext(), atVar.field_transContent, (int) aVar.olH.getTextSize(), 1), charSequence2, ah(atVar));
            }
        } else if (z2) {
            charSequence2 = " ";
            String string = aVar.olH.getContext().getString(2131234628, new Object[]{"@"});
            if (z) {
                a(aVar.olH, e.a(aVar.olH.getContext(), string + "\n" + charSequence, (int) aVar.olH.getTextSize(), Integer.valueOf(31)), e.a(aVar.olH.getContext(), atVar.field_transContent, (int) aVar.olH.getTextSize(), Integer.valueOf(31)), charSequence2, ah(atVar));
            } else {
                aVar.olH.setText(string + "\n" + charSequence);
                e.a(aVar.olH, Integer.valueOf(31), ah(atVar));
            }
        } else {
            aVar.d(aVar.olH, charSequence);
            TextView textView;
            int i3;
            String ah;
            if (u.dW(aVar2.onh.cyO) || u.dW(aVar2.onh.bdo)) {
                aVar.olH.setText(charSequence);
                textView = aVar.olH;
                i3 = atVar.field_type;
                ah = ah(atVar);
                if (i3 != 301989937) {
                    e.b(textView, null, ah);
                }
                textView.getText();
            } else {
                aVar.olH.setText(charSequence);
                textView = aVar.olH;
                i3 = atVar.field_type;
                ah = ah(atVar);
                if (i3 != 301989937) {
                    e.a(textView, null, ah);
                }
                textView.getText();
            }
        }
        aVar.olH.setTag(dl.a(atVar, aVar2.nQK, i));
        aVar.olH.setOnClickListener(aVar2.onh.oqh);
        aVar.olH.setOnLongClickListener(aVar2.onh.oqj);
        aVar.olH.pdC = aVar2.onh.oql;
        ad.a(i, aVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
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
        Drawable drawable = this.onG.getResources().getDrawable(2130839350);
        drawable.setBounds(0, 0, (textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight(), 2);
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(4, true), length + 1, (length + length2) + 1, 17);
        spannableStringBuilder.setSpan(imageSpan, length, length2 + length, 33);
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
        b n = o.yx().n(fz, true);
        n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
        n.l("preUsername", a(this.onG, atVar));
        n.l("preChatName", ad.b(this.onG, atVar));
        return fz;
    }

    public boolean a(ContextMenu contextMenu, View view, at atVar) {
        boolean z;
        if (atVar.bNo == null || !atVar.bNo.contains("announcement@all")) {
            z = false;
        } else {
            z = true;
        }
        if (atVar.bwm() || atVar.bwe()) {
            int i = ((dl) view.getTag()).position;
            if (atVar.bwm()) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_READ_FAILED, 0, view.getContext().getString(2131231826));
            }
            contextMenu.add(i, MMGIFException.D_GIF_ERR_DATA_TOO_BIG, 0, view.getContext().getString(2131234555));
            if (atVar.field_status == 5) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, view.getContext().getString(2131231874));
            }
            if (com.tencent.mm.ay.c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            if (g.G(this.onG.nDR.nEl, atVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
            }
            if (!z && !atVar.bvZ() && atVar.bwm() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
            }
            if (com.tencent.mm.app.plugin.c.oP()) {
                if (atVar.bwu() && atVar.bwy()) {
                    contextMenu.add(i, 124, 0, view.getContext().getString(2131231840));
                } else {
                    contextMenu.add(i, 124, 0, view.getContext().getString(2131231841));
                }
            }
            if (atVar.bwm() && com.tencent.mm.modelbiz.e.De()) {
                this.onG.bFL();
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
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
