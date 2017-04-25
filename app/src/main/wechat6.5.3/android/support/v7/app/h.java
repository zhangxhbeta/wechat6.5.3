package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

final class h extends g {
    private final UiModeManager FT;

    class a extends a {
        final /* synthetic */ h FU;

        a(h hVar, Callback callback) {
            this.FU = hVar;
            super(hVar, callback);
        }

        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.FU.FR) {
                switch (i) {
                    case 0:
                        return a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    h(Context context, Window window, c cVar) {
        super(context, window, cVar);
        this.FT = (UiModeManager) context.getSystemService("uimode");
    }

    final Callback a(Callback callback) {
        return new a(this, callback);
    }

    final int at(int i) {
        if (i == 0 && this.FT.getNightMode() == 0) {
            return -1;
        }
        return super.at(i);
    }
}
