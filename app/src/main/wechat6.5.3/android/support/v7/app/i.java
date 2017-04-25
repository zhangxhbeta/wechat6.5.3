package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.a.a.a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class i extends Dialog implements c {
    private d Fz;

    public i(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.dialogTheme, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        cU().onCreate(null);
        cU().cY();
    }

    public void onCreate(Bundle bundle) {
        cU().cX();
        super.onCreate(bundle);
        cU().onCreate(bundle);
    }

    public void setContentView(int i) {
        cU().setContentView(i);
    }

    public void setContentView(View view) {
        cU().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        cU().setContentView(view, layoutParams);
    }

    public View findViewById(int i) {
        return cU().findViewById(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        cU().setTitle(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        cU().setTitle(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        cU().addContentView(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        cU().onStop();
    }

    public final boolean de() {
        return cU().requestWindowFeature(1);
    }

    public void invalidateOptionsMenu() {
        cU().invalidateOptionsMenu();
    }

    private d cU() {
        if (this.Fz == null) {
            this.Fz = d.a((Dialog) this, (c) this);
        }
        return this.Fz;
    }
}
