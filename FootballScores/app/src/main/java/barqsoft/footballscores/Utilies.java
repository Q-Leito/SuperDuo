package barqsoft.footballscores;

import android.content.Context;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utilies {
    public static final int SERIE_A = 357;
    public static final int PREMIER_LEAGUE = 354;
    public static final int CHAMPIONS_LEAGUE = 362;
    public static final int PRIMERA_DIVISION = 358;
    public static final int BUNDESLIGA = 351;

    public static String getLeague(Context context, int league_num) {
        switch (league_num) {
            case SERIE_A:
                return context.getString(R.string.serie_a);
            case PREMIER_LEAGUE:
                return context.getString(R.string.premier_league);
            case CHAMPIONS_LEAGUE:
                return context.getString(R.string.champions_league);
            case PRIMERA_DIVISION:
                return context.getString(R.string.primera_divison);
            case BUNDESLIGA:
                return context.getString(R.string.bundesliga);
            default:
                return context.getString(R.string.not_known_league);
        }
    }

    public static String getMatchDay(Context context, int match_day, int league_num) {
        if (league_num == CHAMPIONS_LEAGUE) {
            if (match_day <= 6) {
                return context.getString(R.string.group_stage_text);
            } else if (match_day == 7 || match_day == 8) {
                return context.getString(R.string.first_knockout_round);
            } else if (match_day == 9 || match_day == 10) {
                return context.getString(R.string.quarter_final);
            } else if (match_day == 11 || match_day == 12) {
                return context.getString(R.string.semi_final);
            } else {
                return context.getString(R.string.final_text);
            }
        } else {
            return context.getString(R.string.matchday_text) + String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals, int awaygoals) {
        if (home_goals < 0 || awaygoals < 0) {
            return " - ";
        } else {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static int getTeamCrestByTeamName(Context context, String teamName) {
        if (teamName == null) {
            return R.drawable.no_icon;
        } else if (teamName.equals(context.getString(R.string.arsenal))) {
            return R.drawable.arsenal;
        } else if (teamName.equals(context.getString(R.string.manchester_united))) {
            return R.drawable.manchester_united;
        } else if (teamName.equals(context.getString(R.string.swansea_city_afc))) {
            return R.drawable.swansea_city_afc;
        } else if (teamName.equals(context.getString(R.string.leicester_city_fc))) {
            return R.drawable.leicester_city_fc_hd_logo;
        } else if (teamName.equals(context.getString(R.string.everton_fc))) {
            return R.drawable.everton_fc_logo1;
        } else if (teamName.equals(context.getString(R.string.west_ham_united))) {
            return R.drawable.west_ham;
        } else if (teamName.equals(context.getString(R.string.tottenham_hotspur))) {
            return R.drawable.tottenham_hotspur;
        } else if (teamName.equals(context.getString(R.string.west_bromwich_albion))) {
            return R.drawable.west_bromwich_albion_hd_logo;
        } else if (teamName.equals(context.getString(R.string.sunderland))) {
            return R.drawable.sunderland;
        } else if (teamName.equals(context.getString(R.string.stoke_city))) {
            return R.drawable.stoke_city;
        } else {
            return R.drawable.no_icon;
        }
    }
}
