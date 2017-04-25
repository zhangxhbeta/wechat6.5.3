package android.support.v4.c.a;

import android.support.v4.view.d;
import android.support.v4.view.l.e;
import android.view.MenuItem;
import android.view.View;

public interface b extends MenuItem {
    b a(d dVar);

    b a(e eVar);

    d bx();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
