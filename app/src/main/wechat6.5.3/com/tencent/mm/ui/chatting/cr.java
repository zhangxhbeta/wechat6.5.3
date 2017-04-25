package com.tencent.mm.ui.chatting;

import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.p;

class cr implements com.tencent.mm.ui.widget.MMTextView.a {
    o eLp = null;
    private ScrollView fzH = null;
    ac handler = new ac(this) {
        final /* synthetic */ cr ord;

        {
            this.ord = r1;
        }

        public final void handleMessage(Message message) {
            View view = (View) message.obj;
            if (this.ord.lip != view.getScrollY()) {
                this.ord.kir = true;
                this.ord.handler.sendMessageDelayed(this.ord.handler.obtainMessage(0, view), 5);
                this.ord.lip = view.getScrollY();
                return;
            }
            this.ord.kir = false;
        }
    };
    long ikd = 0;
    private TextView kG = null;
    boolean kir = false;
    boolean kis = false;
    int lip = 0;
    private OnTouchListener nHF = null;
    private com.tencent.mm.ui.chatting.ChattingUI.a onG = null;
    private TextView oqZ = null;
    private final int ora = 3;
    private int orb = 0;
    int orc = 0;

    public static class a extends LinkMovementMethod {
        a orf;

        public interface a {
            void a(MotionEvent motionEvent, Spannable spannable, ClickableSpan clickableSpan);
        }

        public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
                int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
                Layout layout = textView.getLayout();
                x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (this.orf != null) {
                        this.orf.a(motionEvent, spannable, clickableSpanArr[0]);
                    }
                    if (action == 1) {
                        clickableSpanArr[0].onClick(textView);
                    } else if (action == 0) {
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
            } else if (this.orf != null) {
                this.orf.a(motionEvent, spannable, null);
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    static /* synthetic */ void a(cr crVar) {
        crVar.lip = 0;
        crVar.orc = 0;
        crVar.kir = false;
        crVar.kis = false;
        crVar.handler.removeMessages(0);
    }

    public cr(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        this.onG = aVar;
    }

    public boolean c(View view, MotionEvent motionEvent) {
        if (view.getTag() instanceof dl) {
            dl dlVar = (dl) view.getTag();
            if (dlVar.eKg == 0 && (view instanceof TextView) && dlVar.bmk != null && this.onG != null) {
                p pVar = this.onG;
                if (this.eLp == null) {
                    View inflate = View.inflate(pVar.nDR.nEl, 2130903329, null);
                    this.fzH = (ScrollView) inflate.findViewById(2131756234);
                    this.kG = (TextView) inflate.findViewById(2131756235);
                    this.oqZ = (TextView) inflate.findViewById(2131756233);
                    this.nHF = new OnTouchListener(this) {
                        final /* synthetic */ cr ord;

                        {
                            this.ord = r1;
                        }

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                this.ord.ikd = t.Nj();
                                this.ord.lip = view.getScrollY();
                                this.ord.orc = this.ord.lip;
                                this.ord.handler.removeMessages(0);
                                if (this.ord.kir) {
                                    this.ord.kir = false;
                                    this.ord.kis = true;
                                }
                            } else if (motionEvent.getAction() != 2 && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 4)) {
                                if (Math.abs(this.ord.orc - view.getScrollY()) > 3) {
                                    this.ord.handler.sendMessage(this.ord.handler.obtainMessage(0, view));
                                }
                                if (t.Nj() - this.ord.ikd < 800 && Math.abs(this.ord.orc - view.getScrollY()) <= 3 && !this.ord.kis && this.ord.eLp != null && this.ord.eLp.isShowing()) {
                                    this.ord.handler.removeMessages(0);
                                    cr.a(this.ord);
                                    this.ord.eLp.dismiss();
                                }
                                this.ord.kis = false;
                            }
                            return false;
                        }
                    };
                    this.fzH.setOnTouchListener(this.nHF);
                    inflate.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ cr ord;

                        {
                            this.ord = r1;
                        }

                        public final void onClick(View view) {
                            if (this.ord.eLp != null && this.ord.eLp.isShowing()) {
                                cr.a(this.ord);
                                this.ord.eLp.dismiss();
                            }
                        }
                    });
                    this.eLp = new o(inflate, -1, -1, true);
                    this.eLp.setAnimationStyle(2131558784);
                    this.eLp.update();
                    this.eLp.setBackgroundDrawable(new ColorDrawable(16777215));
                    this.eLp.setOnDismissListener(new OnDismissListener(this) {
                        final /* synthetic */ cr ord;

                        {
                            this.ord = r1;
                        }

                        public final void onDismiss() {
                        }
                    });
                }
                if (!(this.eLp == null || this.eLp.isShowing())) {
                    this.fzH.scrollTo(0, 0);
                    CharSequence text = ((TextView) view).getText();
                    if (text instanceof SpannableString) {
                        text = c(text, this.oqZ);
                        b.daJ.u(dlVar.bmk);
                    }
                    CharSequence charSequence = text;
                    this.onG.ale();
                    this.kG.setText(charSequence);
                    this.kG.setTextIsSelectable(true);
                    this.eLp.showAtLocation(view.getRootView(), 17, 0, 0);
                    this.eLp.setFocusable(true);
                    this.eLp.setTouchable(true);
                    this.eLp.setBackgroundDrawable(new ColorDrawable(16777215));
                    this.eLp.setOutsideTouchable(true);
                    MovementMethod aVar = new a();
                    aVar.orf = new a(this) {
                        final /* synthetic */ cr ord;
                        private ClickableSpan ore = null;

                        {
                            this.ord = r2;
                        }

                        public final void a(MotionEvent motionEvent, Spannable spannable, ClickableSpan clickableSpan) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                if (clickableSpan != null) {
                                    if (!(aa.getContext() == null || aa.getContext().getResources() == null)) {
                                        spannable.setSpan(new BackgroundColorSpan(aa.getContext().getResources().getColor(2131689821)), spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpan), 33);
                                    }
                                    this.ore = clickableSpan;
                                }
                            } else if (action == 1) {
                                if (clickableSpan != null) {
                                    spannable.setSpan(new BackgroundColorSpan(-1), spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpan), 33);
                                }
                            } else if (action == 3 && this.ore != null) {
                                spannable.setSpan(new BackgroundColorSpan(-1), spannable.getSpanStart(this.ore), spannable.getSpanEnd(this.ore), 33);
                            }
                        }
                    };
                    this.kG.setMovementMethod(aVar);
                    this.kG.setFocusable(false);
                    this.kG.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ cr ord;

                        {
                            this.ord = r1;
                        }

                        public final void onClick(View view) {
                            if (this.ord.eLp != null && this.ord.eLp.isShowing()) {
                                this.ord.eLp.dismiss();
                            }
                        }
                    });
                    this.eLp.update();
                }
                return true;
            }
        }
        return false;
    }

    protected CharSequence c(CharSequence charSequence, TextView textView) {
        if (!(charSequence instanceof SpannableString)) {
            return charSequence;
        }
        textView.setText(((SpannableString) charSequence).toString());
        e.e(textView, 1);
        return textView.getText();
    }
}
