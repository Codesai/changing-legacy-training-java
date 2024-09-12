package marketing_campaign;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;


public class MarketingCampaign {
    public boolean isActive() {
        return getNowInMilliseconds() % 2 == 0;
    }

    public boolean isCrazySalesDay() {
        return getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }

    private DayOfWeek getDayOfWeek() {
        return LocalDate.now().getDayOfWeek();
    }

    private long getNowInMilliseconds() {
        return ZonedDateTime.now().toInstant().toEpochMilli();
    }
}
