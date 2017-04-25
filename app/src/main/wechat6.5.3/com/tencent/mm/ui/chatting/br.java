package com.tencent.mm.ui.chatting;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;

final class br implements a {

    static class a extends LinkMovementMethod {
        private c opp;

        a() {
        }

        public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.opp = a(textView, spannable, motionEvent);
                if (this.opp != null) {
                    this.opp.opr = true;
                    Selection.setSelection(spannable, spannable.getSpanStart(this.opp), spannable.getSpanEnd(this.opp));
                }
            } else if (motionEvent.getAction() == 2) {
                c a = a(textView, spannable, motionEvent);
                if (!(this.opp == null || a == this.opp)) {
                    this.opp.opr = false;
                    this.opp = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                if (this.opp != null) {
                    this.opp.opr = false;
                    super.onTouchEvent(textView, spannable, motionEvent);
                }
                this.opp = null;
                Selection.removeSelection(spannable);
            }
            return true;
        }

        private static c a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
            c[] cVarArr = (c[]) spannable.getSpans(x, x, c.class);
            if (cVarArr.length > 0) {
                return cVarArr[0];
            }
            return null;
        }
    }

    static class b {
        public int end;
        public ClickableSpan opq;
        public int start;

        b() {
        }
    }

    static abstract class c extends ClickableSpan {
        boolean opr;
        private int ops;
        private int opt;

        public c(int i, int i2) {
            this.ops = i;
            this.opt = i2;
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.opr ? this.opt : this.ops);
            textPaint.setUnderlineText(false);
        }
    }

    br() {
    }

    public final void a(com.tencent.mm.ui.chatting.ad.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar) {
        final b bVar = (b) aVar;
        int color = bVar.lts.getContext().getResources().getColor(2131689819);
        int color2 = bVar.lts.getContext().getResources().getColor(2131689820);
        final com.tencent.mm.aj.a bwD = atVar.bwD();
        if (bwD == null) {
            bVar.kad.setVisibility(8);
        } else {
            int i2;
            CharSequence charSequence;
            bVar.kad.setVisibility(0);
            bVar.lts.setText(e.a(bVar.lts.getContext(), be.ma(bwD.cSX), bVar.lts.getTextSize()));
            bVar.lts.setMovementMethod(new a());
            Object newSpannable;
            if (bwD.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication") || bwD.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
                color = bVar.lts.getContext().getResources().getColor(2131689767);
                color2 = bVar.lts.getContext().getResources().getColor(2131689565);
                if (atVar.bwB()) {
                    color = bVar.lts.getContext().getResources().getColor(2131689767);
                    color2 = bVar.lts.getContext().getResources().getColor(2131689565);
                    newSpannable = Factory.getInstance().newSpannable(bVar.lts.getText());
                    i2 = 0;
                } else {
                    Spannable newSpannable2 = Factory.getInstance().newSpannable("    " + bVar.lts.getText());
                    Drawable drawable = bVar.lts.getContext().getResources().getDrawable(2131165620);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(drawable);
                    eVar.pbC = (int) (((((float) drawable.getIntrinsicHeight()) - bVar.lts.getTextSize()) + ((float) com.tencent.mm.bd.a.fromDPToPix(bVar.lts.getContext(), 2))) / 2.0f);
                    newSpannable2.setSpan(eVar, 0, 3, 33);
                    charSequence = newSpannable2;
                    i2 = 4;
                }
            } else {
                newSpannable = Factory.getInstance().newSpannable(bVar.lts.getText());
                i2 = 0;
            }
            for (int i3 = 0; i3 < bwD.cSZ.size(); i3++) {
                b bVar2 = new b();
                final com.tencent.mm.ui.chatting.ChattingUI.a aVar3 = aVar2;
                final at atVar2 = atVar;
                final int i4 = i;
                bVar2.opq = new c(this, color, color2) {
                    final /* synthetic */ br opo;

                    public final void onClick(View view) {
                        v.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", bwD);
                        aVar3.a(bVar.kad, atVar2, bwD, i3);
                    }
                };
                bVar2.start = ((Integer) bwD.cTa.get(i3)).intValue();
                bVar2.end = ((Integer) bwD.cTb.get(i3)).intValue();
                charSequence.setSpan(bVar2.opq, bVar2.start + i2, bVar2.end + i2, 33);
            }
            bVar.lts.setText(charSequence);
            bVar.lts.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ br opo;

                {
                    this.opo = r1;
                }

                public final void onClick(View view) {
                    v.d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
                }
            });
        }
        bVar.lts.invalidate();
    }
}
