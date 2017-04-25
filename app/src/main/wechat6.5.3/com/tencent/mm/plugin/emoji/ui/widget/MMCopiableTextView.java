package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class MMCopiableTextView extends EditText implements OnLongClickListener {
    private final String TAG = "MicroMsg.MMCopiableTextView";
    private int fkP;
    private int fqS;

    public MMCopiableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMCopiableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOnLongClickListener(this);
        setLongClickable(true);
    }

    protected void onCreateContextMenu(ContextMenu contextMenu) {
    }

    protected boolean getDefaultEditable() {
        return false;
    }

    public boolean onLongClick(View view) {
        String obj = getEditableText().toString();
        if (!be.kS(obj) && this.fkP > 0 && this.fqS > 0 && this.fqS > this.fkP) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setText(obj.substring(this.fkP, this.fqS).trim());
                v.i("MicroMsg.MMCopiableTextView", "copy text :%s", new Object[]{clipboardManager.getText()});
            }
            Toast.makeText(getContext(), 2131231016, 0).show();
        }
        return false;
    }
}
