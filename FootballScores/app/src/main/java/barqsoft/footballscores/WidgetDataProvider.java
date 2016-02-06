package barqsoft.footballscores;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by Quincy on 2/5/2016.
 */
public class WidgetDataProvider
        implements RemoteViewsService.RemoteViewsFactory {

    private Cursor mCursor;
    private Context mContext;
    private Intent mIntent;

    public WidgetDataProvider(Context context, Intent intent) {
        mContext = context;
        mIntent = intent;
    }

    private void initData() {
        SQLiteDatabase sqLiteDatabase =
                new ScoresDBHelper(mContext).getReadableDatabase();
        mCursor =
                sqLiteDatabase.query(DatabaseContract.SCORES_TABLE, null, null, null, null, null, "date");
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return mCursor.getCount();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteView = new RemoteViews(
                mContext.getPackageName(), R.layout.widget_list_item);
        mCursor.moveToPosition(position);

        String date = mCursor.getString(mCursor.getColumnIndex("date"));
        String home = mCursor.getString(mCursor.getColumnIndex("home"));
        String away = mCursor.getString(mCursor.getColumnIndex("away"));
        String home_goals = mCursor.getString(mCursor.getColumnIndex("home_goals"));
        String away_goals = mCursor.getString(mCursor.getColumnIndex("away_goals"));

        if (Integer.valueOf(home_goals).equals(-1)) {
            home_goals = "";
        }

        if (Integer.valueOf(away_goals).equals(-1)) {
            away_goals = "";
        }

        remoteView.setTextViewText(R.id.data_textview, date);
        remoteView.setTextViewText(R.id.home_name, home);
        remoteView.setTextViewText(R.id.away_name, away);
        remoteView.setTextViewText(R.id.score_textview, home_goals + " : " + away_goals);

        return remoteView;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
