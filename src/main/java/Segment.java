import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Segment {
    MediaType mediaType;
    UUID id;
    List<String> freeText;
    LocalDate dateCreated;

    @Override
    public String toString() {
        return "Segment{" +
                "mediaType=" + mediaType +
                ", id=" + id +
                ", freeText=" + freeText +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
