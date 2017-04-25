package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.y;
import android.support.v7.view.menu.f;
import android.support.v7.widget.u;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.util.ArrayList;

final class k extends ActionBar {
    u GR;
    Callback GS;
    private boolean GT;
    private boolean GU;
    private ArrayList<Object> GV;
    private final Runnable GW;

    private final class a implements android.support.v7.view.menu.l.a {
        final /* synthetic */ k GX;
        private boolean Gi;

        private a(k kVar) {
            this.GX = kVar;
        }

        public final boolean d(f fVar) {
            if (this.GX.GS == null) {
                return false;
            }
            this.GX.GS.onMenuOpened(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, fVar);
            return true;
        }

        public final void a(f fVar, boolean z) {
            if (!this.Gi) {
                this.Gi = true;
                this.GX.GR.dismissPopupMenus();
                if (this.GX.GS != null) {
                    this.GX.GS.onPanelClosed(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, fVar);
                }
                this.Gi = false;
            }
        }
    }

    private final class b implements android.support.v7.view.menu.f.a {
        final /* synthetic */ k GX;

        private b(k kVar) {
            this.GX = kVar;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return false;
        }

        public final void b(f fVar) {
            if (this.GX.GS == null) {
                return;
            }
            if (this.GX.GR.isOverflowMenuShowing()) {
                this.GX.GS.onPanelClosed(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, fVar);
            } else if (this.GX.GS.onPreparePanel(0, null, fVar)) {
                this.GX.GS.onMenuOpened(MMGIFException.D_GIF_ERR_DATA_TOO_BIG, fVar);
            }
        }
    }

    public final void setCustomView(View view) {
        LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -2);
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.GR.setCustomView(view);
    }

    public final void cN() {
        setCustomView(LayoutInflater.from(this.GR.getContext()).inflate(2130903079, this.GR.eM(), false));
    }

    public final void cO() {
        this.GR.setIcon(2130839576);
    }

    public final void setLogo(Drawable drawable) {
        this.GR.setLogo(drawable);
    }

    public final void setElevation(float f) {
        y.g(this.GR.eM(), f);
    }

    public final Context getThemedContext() {
        return this.GR.getContext();
    }

    public final void w(boolean z) {
    }

    public final void x(boolean z) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void e(CharSequence charSequence) {
        this.GR.e(charSequence);
    }

    public final boolean requestFocus() {
        ViewGroup eM = this.GR.eM();
        if (eM == null || eM.hasFocus()) {
            return false;
        }
        eM.requestFocus();
        return true;
    }

    public final void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    private void setDisplayOptions(int i, int i2) {
        this.GR.setDisplayOptions((this.GR.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public final void cP() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void cQ() {
        setDisplayOptions(0, 8);
    }

    public final void cR() {
        setDisplayOptions(16, 16);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.GR.setBackgroundDrawable(drawable);
    }

    public final View getCustomView() {
        return this.GR.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.GR.getTitle();
    }

    public final int getDisplayOptions() {
        return this.GR.getDisplayOptions();
    }

    public final int getHeight() {
        return this.GR.getHeight();
    }

    public final void show() {
        this.GR.setVisibility(0);
    }

    public final void hide() {
        this.GR.setVisibility(8);
    }

    public final boolean isShowing() {
        return this.GR.getVisibility() == 0;
    }

    public final boolean cS() {
        this.GR.eM().removeCallbacks(this.GW);
        y.a(this.GR.eM(), this.GW);
        return true;
    }

    public final boolean collapseActionView() {
        if (!this.GR.hasExpandedActionView()) {
            return false;
        }
        this.GR.collapseActionView();
        return true;
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (!this.GT) {
            this.GR.a(new a(), new b());
            this.GT = true;
        }
        Menu menu = this.GR.getMenu();
        if (menu != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            menu.setQwertyMode(z);
            menu.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    final void onDestroy() {
        this.GR.eM().removeCallbacks(this.GW);
    }

    public final void y(boolean z) {
        if (z != this.GU) {
            this.GU = z;
            int size = this.GV.size();
            for (int i = 0; i < size; i++) {
                this.GV.get(i);
            }
        }
    }
}
