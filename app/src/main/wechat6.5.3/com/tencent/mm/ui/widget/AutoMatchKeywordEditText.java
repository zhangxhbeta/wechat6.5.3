package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.v;

public class AutoMatchKeywordEditText extends MMEditText {
    public a oYW;
    private int oYX;
    private int oYY;

    public interface a {
        void a(EditText editText, int i, int i2);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.oYX = getSelectionStart();
        this.oYY = getSelectionEnd();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.oYX != selectionStart || this.oYY != selectionEnd) {
            this.oYX = selectionStart;
            this.oYY = selectionEnd;
            if (this.oYW != null) {
                this.oYW.a(this, getSelectionStart(), getSelectionEnd());
            }
        }
    }

    public void setSelection(int i) {
        v.d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i);
        this.oYX = getSelectionStart();
        this.oYY = getSelectionEnd();
        if ((selectionStart != getSelectionStart() || selectionEnd != getSelectionEnd()) && this.oYW != null) {
            this.oYW.a(this, getSelectionStart(), getSelectionEnd());
        }
    }

    public void setSelection(int i, int i2) {
        v.d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i, i2);
        this.oYX = getSelectionStart();
        this.oYY = getSelectionEnd();
        if ((selectionStart != getSelectionStart() || selectionEnd != getSelectionEnd()) && this.oYW != null) {
            this.oYW.a(this, getSelectionStart(), getSelectionEnd());
        }
    }

    public void extendSelection(int i) {
        v.d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
        super.extendSelection(i);
        this.oYX = getSelectionStart();
        this.oYY = getSelectionEnd();
    }

    public boolean moveCursorToVisibleOffset() {
        v.d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
        return super.moveCursorToVisibleOffset();
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        v.d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
        return super.performAccessibilityAction(i, bundle);
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        v.d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
        return super.onDragEvent(dragEvent);
    }
}
