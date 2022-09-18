import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class ConvertTmstmp {
    public static void main(String args[]) throws Exception {
        System.out.println("Time in UTC " + Instant.now());
        String timeUTC = Instant.now().toString();
        System.out.println("Time in UTC in String " + timeUTC);
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
        LocalDateTime dateTime = LocalDateTime.parse(timeUTC, formatter);
        System.out.println(dateTime);
        TimeZone toTimeZone = TimeZone.getTimeZone("CST");

        System.out.println("SIMPLER APPROACH");
        timeUTC = "2022-09-18T01:49:09.334362Z";
        Instant instant = Instant.parse(timeUTC);
        ZoneId z = ZoneId.of("America/Chicago");
        ZonedDateTime zdt = instant.atZone(z);
        System.out.println(zdt.toLocalDate());

    }
}