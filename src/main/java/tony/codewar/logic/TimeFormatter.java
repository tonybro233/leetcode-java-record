package tony.codewar.logic;

// The function must accept a non-negative integer. If it is zero, it just returns "now".
// Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
// TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
// TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"

public class TimeFormatter {

    private static final int yearSec = 31536000;
    private static final int daySec = 86400;
    private static final int hourSec = 3600;
    private static final int minuteSec = 60;

    public static String formatDuration(int seconds) {
        if (0 == seconds){
            return "now";
        }
        int year = 0;
        int day = 0;
        int hour = 0;
        int minute = 0;
        int second = 0;
        do {
            if (seconds / yearSec != 0){
                year = seconds / yearSec;
                seconds -= year * yearSec;
            }
            if (seconds == 0){
                break;
            }
            if (seconds / daySec != 0){
                day = seconds / daySec;
                seconds -= day * daySec;
            }
            if (seconds == 0){
                break;
            }
            if (seconds / hourSec != 0){
                hour = seconds / hourSec;
                seconds -= hour * hourSec;
            }
            if (seconds == 0){
                break;
            }
            if (seconds / minuteSec != 0){
                minute = seconds / minuteSec;
                seconds -= minute * minuteSec;
            }
            if (seconds == 0){
                break;
            }
            second = seconds;
        }while (false);

        int count = (year == 0 ? 0 : 1) +
                (day == 0 ? 0 : 1) +
                (minute == 0 ? 0 : 1) +
                (hour == 0 ? 0 : 1) +
                (second == 0 ? 0 : 1);

        StringBuilder sb = new StringBuilder();
        if (0 != year){
            sb.append(year).append(" year");
            if (year > 1){
                sb.append('s');
            }
            count--;
            if (count > 1){
                sb.append(", ");
            } else if (count == 1){
                sb.append(" and ");
            } else {
                return sb.toString();
            }
        }
        if (0 != day){
            sb.append(day).append(" day");
            if (day > 1){
                sb.append('s');
            }
            count--;
            if (count > 1){
                sb.append(", ");
            } else if (count == 1){
                sb.append(" and ");
            } else {
                return sb.toString();
            }
        }
        if (0 != hour){
            sb.append(hour).append(" hour");
            if (hour > 1){
                sb.append('s');
            }
            count--;
            if (count > 1){
                sb.append(", ");
            } else if (count == 1){
                sb.append(" and ");
            } else {
                return sb.toString();
            }
        }
        if (0 != minute){
            sb.append(minute).append(" minute");
            if (minute > 1){
                sb.append('s');
            }
            count--;
            if (count == 1){
                sb.append(" and ");
            } else {
                return sb.toString();
            }
        }
        if (0 != second){
            sb.append(second).append(" second");
            if (second > 1){
                sb.append('s');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String s = formatDuration(62);
        System.out.println(s);
    }
}
