
/*

Java Time API

1) Current and other date and time (V)
2) plus and minus date and time units (V)
3) Compare of dates (V)
4) Date Format ISO-8601 (V)
5) Zoned date time
6) Period and Duration (V)
7) Customization

 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimeAppl {
    public static void main(String[] args) {
        //выясняем сегодняшнюю дату
        LocalDate localDate = LocalDate.now();
        //печатаем
        System.out.println(localDate);
        // а который час?
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        // а который день и час?
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // задаем нужную нам дату во времени
        LocalDate gagarin = LocalDate.of(1961, 4, 12);
        // печатаем, видим формат
        System.out.println(gagarin);
        System.out.println(gagarin.getDayOfMonth());
        // Какой это был день недели?
        System.out.println(gagarin.getDayOfWeek());
        // Какой это был день года?
        System.out.println(gagarin.getDayOfYear());
        // проверка года на "високосность"
        System.out.println(Year.isLeap(2032));
        // сравнение дат
        System.out.println(gagarin.isBefore(localDate)); // yes
        System.out.println(gagarin.isAfter(localDate)); // no
        // еще проверки
        System.out.println("---------------------------------------");
        System.out.println(gagarin.isBefore(gagarin)); // no
        System.out.println(gagarin.isAfter(gagarin)); // no
        System.out.println("---------------------------------------");
        System.out.println(localDate.compareTo(gagarin));// years, then month, day ...
        System.out.println(gagarin.compareTo(gagarin)); // 0
        System.out.println(gagarin.compareTo(localDate)); // years, then month, day ...
        System.out.println("========================================");

        // travel in time
        LocalDate newDate = localDate.plusDays(10); // какая будет дата через 10 дней
        System.out.println(newDate);

        System.out.println(localDate);
        newDate = localDate.minusDays(10);

        System.out.println(newDate);
        newDate = localDate.plusWeeks(7);

        System.out.println(newDate);
        newDate = localDate.minusMonths(3);

        System.out.println(newDate);
        newDate = localDate.plus(14, ChronoUnit.DECADES);
        System.out.println(newDate);


        LocalTime newTime = localTime.plus(13, ChronoUnit.MINUTES);
        System.out.println(newTime);

        LocalDateTime newLocalDateTime = localDateTime.plus(9, ChronoUnit.HALF_DAYS);
        System.out.println(newLocalDateTime);

        long period = ChronoUnit.DAYS.between(gagarin, localDate);
        System.out.println(period);
        period = ChronoUnit.YEARS.between(gagarin, localDate);
        System.out.println(period);

        //
        LocalDate lenin = LocalDate.of(1870, 4, 22);
        period = ChronoUnit.YEARS.between(lenin, LocalDate.now());
        System.out.println(period);

        period = ChronoUnit.WEEKS.between(gagarin, localDate);
        System.out.println(period);

        period = ChronoUnit.MONTHS.between(localDate, gagarin);
        System.out.println(period);

        // DateTimeFormatter
        System.out.println("=== DateTimeFormatter ===");
        DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;

        String date = gagarin.format(df);
        System.out.println(date); // напечатали дату в выбранном формате
        // преобразовали в строку
        date = gagarin.toString();
        System.out.println(date); // напечатали
        // выбрали другой формат
        df = DateTimeFormatter.ISO_LOCAL_DATE;
        date = gagarin.format(df); // поменяли формат дате
        System.out.println(date); // напечатали

        // задаем другой формат
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = gagarin.format(df);// поменяли формат дате
        System.out.println(date); // напечатали

        // задаем новый формат
        df = DateTimeFormatter.ofPattern("dd/M/yyyy");
        date = gagarin.format(df); // поменяли формат дате
        System.out.println(date);// напечатали
        // задаем ещё формат
        df = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        date = gagarin.format(df); // поменяли формат дате
        System.out.println(date);// напечатали
        // и опять
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
        date = gagarin.format(df); // поменяли формат дате
        System.out.println(date); // напечатали
        //
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.FRANCE);
        date = gagarin.format(df);
        System.out.println(date);
        //
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("lv"));
        date = gagarin.format(df);
        System.out.println(date);

        date = "30/06/2024";
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        newDate = LocalDate.parse(date, df);
        System.out.println(newDate.toString());
        System.out.println(newDate.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("lv"))));

        // calculate years between dates
        System.out.println("////////////////////////////////////////////////////////");
        LocalDate day = LocalDate.of(1963, 10,19);
        int years = (int) ChronoUnit.YEARS.between(day, LocalDate.now());
        System.out.println(years);

        // parcing date from string
        String stringDate = "27/08/2024";
        System.out.println("--///////////////////////////////////////////////////////--");
        LocalDate res = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        System.out.println(res);

    }
}
