package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "offermissions",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "user_id"
                ),
                @ForeignKey(
                        entity = Offer.class,
                        parentColumns = "id",
                        childColumns = "offer_id"
                ),
        })
public class OfferMission {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    @ColumnInfo(name = "user_id")
    private User user;

    @ColumnInfo(name = "offer_id")
    private Offer offer;


    public OfferMission(Long id, @NonNull String title, @NonNull String content, @NonNull User user, Offer offer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.offer = offer;
    }

    public Long getId() {
        return id;
    }

    public OfferMission setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public OfferMission setTitle(@NonNull String title) {
        this.title = title;
        return this;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public OfferMission setContent(@NonNull String content) {
        this.content = content;
        return this;
    }

    @NonNull
    public User getUser() {
        return user;
    }

    public OfferMission setUser(@NonNull User user) {
        this.user = user;
        return this;
    }

    public Offer getOffer() {
        return offer;
    }

    public OfferMission setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }
}
