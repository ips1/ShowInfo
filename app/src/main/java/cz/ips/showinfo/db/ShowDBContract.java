package cz.ips.showinfo.db;

import android.provider.BaseColumns;

/**
 * Created by petrkubat on 03/02/15.
 */
public final class ShowDBContract {
    public static abstract class ShowEntry implements BaseColumns {
        public static final String TABLE_NAME = "shows";
        public static final String COLUMN_NAME_SHOW_ID = "show_id";
        public static final String COLUMN_NAME_SHOW_NAME = "name";
        public static final String COLUMN_NAME_SHOW_DESCRIPTION = "description";

        // Aired from, to, country...
    }

    /*
    public static abstract class SeasonEntry implements BaseColumns {
        public static final String TABLE_NAME = "seasons";
        //public static final String COLUMN_NAME_SEASON_ID = "season_id";
        public static final String COLUMN_NAME_SEASON_NUMBER = "season_no";
        public static final String COLUMN_NAME_SHOW_ID = "show_id";
    }*/

    public static abstract class EpisodeEntry implements BaseColumns {
        public static final String TABLE_NAME = "episodes";
        //public static final String COLUMN_NAME_EPISODE_ID = "episode_id";
        public static final String COLUMN_NAME_SHOW_ID = "show_id";
        public static final String COLUMN_NAME_SEASON_NUMBER = "season_no";
        public static final String COLUMN_NAME_EPISODE_NUMBER = "episode_no";
        public static final String COLUMN_NAME_EPISODE_NAME = "name";
        public static final String COLUMN_NAME_EPISODE_DESCRIPTION = "description";
        public static final String COLUMN_NAME_EPISODE_SEEN = "seen";
    }
}
