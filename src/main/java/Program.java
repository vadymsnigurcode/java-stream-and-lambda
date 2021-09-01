import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.UUID.*;

public class Program {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        System.out.println("by media");
        List<Segment> segments;
        segments = GenerateData();
        for (MediaType media:MediaType.values()) {
            List<Segment> filtered = segments.stream().filter(s->s.mediaType == media).collect(Collectors.toList());
            filtered
                    .stream()
                    .forEach(s->{
                        System.out.println(s.toString());
                    });
        }

        System.out.println("UUID started from 'a'");
        List<Segment> filtered = segments
                .stream()
                .filter(s->s.id.toString().substring(0, 1).equals("a")).collect(Collectors.toList());
        filtered
                .stream()
                .forEach(s->{
                    System.out.println(s.toString());
                });

        System.out.println("today");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        filtered = segments
                .stream()
                .filter(s->s.dateCreated.getDayOfMonth() == dayOfMonth ).collect(Collectors.toList());
        filtered
                .stream()
                .forEach(s->{
                    System.out.println(s.toString());
                });


        System.out.println("voice ids");
        filtered = segments
                .stream()
                .filter(s->s.mediaType == MediaType.Voice ).collect(Collectors.toList());
        filtered
                .stream()
                .forEach(s->{
                    System.out.println(s.id);
                });

        System.out.println("only IDs");
        List<UUID> uuds = segments
                .stream()
                .map(s->s.id).collect(Collectors.toList());
        uuds.stream().forEach(s -> System.out.println(s));
    }

    private static List<Segment> GenerateData() {
        LocalDate now = LocalDate.now();
        return new ArrayList<Segment>() {{
            add(new Segment() {{
                mediaType = MediaType.Voice;
                id = UUID.randomUUID();
                freeText = new ArrayList<String>() {{
                    add("1");
                    add("2");
                }};
                dateCreated = now;
            }});
            add(new Segment() {{
                mediaType = MediaType.Screen;
                id = UUID.randomUUID();
                freeText = new ArrayList<String>() {{
                    add("3");
                    add("4");
                }};
                dateCreated = now;
            }});
            add(new Segment() {{
                mediaType = MediaType.Voice;
                id = UUID.randomUUID();
                freeText = new ArrayList<String>() {{
                    add("5");
                    add("6");
                }};
                dateCreated = now;
            }});
            add(new Segment() {{
                mediaType = MediaType.Chat;
                id = UUID.randomUUID();
                freeText = new ArrayList<String>() {{
                    add("7");
                    add("8");
                }};
                dateCreated = now;
            }});
            add(new Segment() {{
                mediaType = MediaType.Screen;
                id = UUID.randomUUID();
                freeText = new ArrayList<String>() {{
                    add("1");
                    add("2");
                }};
                dateCreated = now;
            }});

        }};
    }
}
