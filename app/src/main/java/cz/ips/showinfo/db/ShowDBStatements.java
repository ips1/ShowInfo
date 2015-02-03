package cz.ips.showinfo.db;

/**
 * Created by petrkubat on 03/02/15.
 */
public final class ShowDBStatements {
    private static final String TEXT_TYPE = " TEXT";
    private static final String NUM_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_SHOWS =
            "CREATE TABLE " + ShowDBContract.ShowEntry.TABLE_NAME + " (" +
                    ShowDBContract.ShowEntry._ID + " INTEGER PRIMARY KEY," +
                    ShowDBContract.ShowEntry.COLUMN_NAME_SHOW_ID + NUM_TYPE + COMMA_SEP +
                    ShowDBContract.ShowEntry.COLUMN_NAME_SHOW_NAME + TEXT_TYPE + COMMA_SEP +
                    ShowDBContract.ShowEntry.COLUMN_NAME_SHOW_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            " )";

    /*
    public static final String SQL_CREATE_SEASONS =
            "CREATE TABLE " + ShowDBContract.SeasonEntry.TABLE_NAME + " (" +
                    ShowDBContract.SeasonEntry._ID + " INTEGER PRIMARY KEY," +
                    ShowDBContract.SeasonEntry.COLUMN_NAME_SEASON_NUMBER + NUM_TYPE + COMMA_SEP +
                    ShowDBContract.SeasonEntry.COLUMN_NAME_SHOW_ID + NUM_TYPE + COMMA_SEP +
                    " )";
*/

    public static final String SQL_CREATE_EPISODES =
            "CREATE TABLE " + ShowDBContract.EpisodeEntry.TABLE_NAME + " (" +
                    ShowDBContract.EpisodeEntry._ID + " INTEGER PRIMARY KEY," +
                    ShowDBContract.EpisodeEntry.COLUMN_NAME_EPISODE_NUMBER + NUM_TYPE + COMMA_SEP +
                    ShowDBContract.EpisodeEntry.COLUMN_NAME_SEASON_NUMBER + NUM_TYPE + COMMA_SEP +
                    ShowDBContract.EpisodeEntry.COLUMN_NAME_SHOW_ID + NUM_TYPE + COMMA_SEP +
                    ShowDBContract.EpisodeEntry.COLUMN_NAME_EPISODE_NAME + TEXT_TYPE + COMMA_SEP +
                    ShowDBContract.EpisodeEntry.COLUMN_NAME_EPISODE_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    ShowDBContract.EpisodeEntry.COLUMN_NAME_EPISODE_SEEN + NUM_TYPE + COMMA_SEP +
                    " )";

    public static final String SQL_DELETE_SHOWS =
            "DROP TABLE IF EXISTS " + ShowDBContract.ShowEntry.TABLE_NAME;

    /*
    public static final String SQL_DELETE_SEASONS =
            "DROP TABLE IF EXISTS " + ShowDBContract.SeasonEntry.TABLE_NAME;
*/

    public static final String SQL_DELETE_EPISODES =
            "DROP TABLE IF EXISTS " + ShowDBContract.EpisodeEntry.TABLE_NAME;
}
