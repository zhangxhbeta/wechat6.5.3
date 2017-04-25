package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class k extends BroadcastReceiver {
    private /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            o.a().a(new b(this.a, intent));
        } catch (Throwable th) {
        }
    }
}
