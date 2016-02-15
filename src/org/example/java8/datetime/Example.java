package org.example.java8.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class Example {

    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2016, 2, 17);
        System.out.println(localDate1);
        System.out.println(localDate1.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        System.out.println(localDate1.atTime(LocalTime.of(15, 00)));
        System.out.println(Period.between(localDate1, localDate1.plusDays(59)));
        System.out.println(MonthDay.of(2, 14));
        System.out.println(YearMonth.of(2015, 2));
        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(localDate1, LocalTime.NOON, ZoneOffset.ofHours(0));
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(localDate1.plusDays(49), LocalTime.NOON, ZoneOffset.ofHours(12));
        System.out.println(Duration.between(offsetDateTime1, offsetDateTime2));
        System.out.println(Instant.now());
        System.out.println(
                localDate1.format(new DateTimeFormatterBuilder().appendLiteral("###").appendValueReduced(ChronoField.YEAR, 1, 1, LocalDate.of(2016, 1, 1))
                        .appendLiteral("#").appendText(ChronoField.DAY_OF_WEEK).appendLiteral("#").appendText(ChronoField.EPOCH_DAY).toFormatter()));
    }

}
