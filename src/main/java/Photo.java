import javax.persistence.*;
@Embeddable
public class Photo {
    @Lob
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

}