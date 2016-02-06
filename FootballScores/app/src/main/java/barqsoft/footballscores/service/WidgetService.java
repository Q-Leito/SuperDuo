package barqsoft.footballscores.service;

import android.content.Intent;
import android.widget.RemoteViewsService;

import barqsoft.footballscores.WidgetDataProvider;

/**
 * Created by Quincy on 2/5/2016.
 */
public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        // Return remote view factory here
        return new WidgetDataProvider(this, intent);
    }
}
