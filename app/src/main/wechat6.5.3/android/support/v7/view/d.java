package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.a.a.j;
import android.view.LayoutInflater;

public final class d extends ContextWrapper {
    private LayoutInflater CE;
    public int NH;
    private Theme NI;

    public d(Context context, int i) {
        super(context);
        this.NH = i;
    }

    public final void setTheme(int i) {
        if (this.NH != i) {
            this.NH = i;
            dl();
        }
    }

    public final Theme getTheme() {
        if (this.NI != null) {
            return this.NI;
        }
        if (this.NH == 0) {
            this.NH = j.Kf;
        }
        dl();
        return this.NI;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.CE == null) {
            this.CE = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.CE;
    }

    private void dl() {
        if (this.NI == null) {
            this.NI = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.NI.setTo(theme);
            }
        }
        this.NI.applyStyle(this.NH, true);
    }
}
