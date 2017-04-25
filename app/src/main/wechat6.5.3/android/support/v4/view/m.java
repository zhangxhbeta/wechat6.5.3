package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class m {

    static class a implements OnActionExpandListener {
        private b wq;

        public a(b bVar) {
            this.wq = bVar;
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.wq.onMenuItemActionExpand(menuItem);
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.wq.onMenuItemActionCollapse(menuItem);
        }
    }

    interface b {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    public static MenuItem a(MenuItem menuItem, b bVar) {
        return menuItem.setOnActionExpandListener(new a(bVar));
    }
}
