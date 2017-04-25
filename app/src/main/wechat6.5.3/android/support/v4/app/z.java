package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public final class z {

    public static abstract class a {

        public interface a {
        }

        public abstract PendingIntent bm();

        public abstract android.support.v4.app.ag.a[] bn();

        public abstract Bundle getExtras();

        public abstract int getIcon();

        public abstract CharSequence getTitle();
    }

    public static abstract class b {

        public interface a {
        }

        abstract android.support.v4.app.ag.a bo();

        abstract long getLatestTimestamp();

        abstract String[] getMessages();

        abstract String[] getParticipants();

        abstract PendingIntent getReadPendingIntent();

        abstract PendingIntent getReplyPendingIntent();
    }
}
