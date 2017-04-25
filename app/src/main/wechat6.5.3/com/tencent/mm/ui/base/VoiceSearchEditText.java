package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class VoiceSearchEditText extends EditText {
    private Context context;
    public String dXe = "";
    private OnClickListener lwQ;
    final Drawable obR = getResources().getDrawable(2130839416);
    final Drawable obS = null;
    final Drawable obT = getResources().getDrawable(2130839084);
    private boolean obU = true;
    private boolean obV = false;
    private boolean obW = false;

    static /* synthetic */ void e(VoiceSearchEditText voiceSearchEditText) {
        v.d("MicroMsg.VoiceSearchEditText", "checkView");
        if (voiceSearchEditText.getText().toString().equals("") && voiceSearchEditText.obV) {
            voiceSearchEditText.obU = true;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.obS, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.obR, voiceSearchEditText.getCompoundDrawables()[3]);
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.obS, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.obT, voiceSearchEditText.getCompoundDrawables()[3]);
        } else {
            voiceSearchEditText.obU = false;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.obS, voiceSearchEditText.getCompoundDrawables()[1], null, voiceSearchEditText.getCompoundDrawables()[3]);
        }
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.obV = false;
        this.obR.setBounds(0, 0, this.obR.getIntrinsicWidth(), this.obR.getIntrinsicHeight());
        this.obT.setBounds(0, 0, this.obT.getIntrinsicWidth(), this.obT.getIntrinsicHeight());
        this.obU = true;
        if (this.obV) {
            setCompoundDrawables(this.obS, getCompoundDrawables()[1], this.obR, getCompoundDrawables()[3]);
        } else if (getText().toString().length() > 0) {
            setCompoundDrawables(this.obS, getCompoundDrawables()[1], this.obT, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawables(this.obS, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        }
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ VoiceSearchEditText obX;

            {
                this.obX = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                View view2 = this.obX;
                if (view2.getCompoundDrawables()[2] == null) {
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return true;
                }
                this.obX.obW = true;
                if (this.obX.obU && this.obX.obV && view2.getText().toString().equals("")) {
                    if (motionEvent.getX() <= ((float) (((view2.getWidth() - view2.getPaddingRight()) - this.obX.obR.getIntrinsicWidth()) - a.fromDPToPix(view2.context, 25)))) {
                        view2.requestFocus();
                        if (this.obX.getContext() instanceof Activity) {
                            MMActivity.J((Activity) this.obX.getContext());
                        }
                        if (this.obX.lwQ != null) {
                            this.obX.lwQ.onClick(null);
                        }
                    } else if (this.obX.lwQ != null) {
                        v.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
                        if (this.obX.getContext() instanceof MMActivity) {
                            ((MMActivity) this.obX.getContext()).cx(view2);
                        }
                        this.obX.lwQ.onClick(this.obX);
                        return true;
                    }
                } else if (view2.getText().toString().length() > 0) {
                    if (motionEvent.getX() > ((float) (((view2.getWidth() - view2.getPaddingRight()) - this.obX.obT.getIntrinsicWidth()) - a.fromDPToPix(view2.context, 25)))) {
                        view2.setText("");
                        VoiceSearchEditText.e(this.obX);
                    } else if (!view2.isFocused()) {
                        view2.requestFocus();
                        if (this.obX.getContext() instanceof Activity) {
                            MMActivity.J((Activity) this.obX.getContext());
                        }
                    }
                } else if (this.obX.lwQ != null) {
                    this.obX.lwQ.onClick(null);
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ VoiceSearchEditText obX;

            {
                this.obX = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.obX.obW = true;
                VoiceSearchEditText.e(this.obX);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ VoiceSearchEditText obX;

            {
                this.obX = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                v.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.obX.obW)});
                if (!z && this.obX.obW) {
                    VoiceSearchEditText.e(this.obX);
                    this.obX.obW = false;
                }
            }
        });
        if (context instanceof Activity) {
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (currentFocus == null || currentFocus != this) {
                this.obW = false;
            } else {
                this.obW = true;
            }
        }
        requestFocus();
    }
}
