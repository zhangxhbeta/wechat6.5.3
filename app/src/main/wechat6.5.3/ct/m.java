package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class m extends BroadcastReceiver {
    private /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public final void onReceive(Context context, Intent intent) {
        new StringBuilder("onAccessSchedulerTriggered by timer, curTime:").append(System.currentTimeMillis());
        bd.a();
        o.a().a(new a());
    }
}
