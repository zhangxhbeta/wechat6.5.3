package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

public interface l {

    public interface a {
        void a(f fVar, boolean z);

        boolean d(f fVar);
    }

    boolean E();

    void a(Context context, f fVar);

    void a(f fVar, boolean z);

    boolean a(p pVar);

    boolean b(h hVar);

    boolean c(h hVar);

    void f(boolean z);

    int getId();

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();
}
