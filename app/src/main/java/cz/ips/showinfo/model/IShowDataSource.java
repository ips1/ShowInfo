package cz.ips.showinfo.model;

import java.util.List;

/**
 * Created by petrkubat on 03/02/15.
 */
public interface IShowDataSource {
    public List<Show> getAllShows();
    public List<Episode> getEpisodesForShow(long showID);

    public void addNewShow(Show show);
    public void addNewEpisode(Episode episode, long showID);

    // TODO: update methods
}
