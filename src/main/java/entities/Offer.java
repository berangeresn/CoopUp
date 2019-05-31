package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "offers",
        foreignKeys = {
                @ForeignKey(
                        entity = OfferMission.class,
                        parentColumns = "id",
                        childColumns = "offermission_id"
                ),
                @ForeignKey(
                        entity = Cooperator.class,
                        parentColumns = "id",
                        childColumns = "cooperator_id"
                )
        })

public class Offer {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    private String content;

    @NonNull
    @ColumnInfo(name = "cooperator_id")
    private Cooperator cooperator;

    @NonNull
    @ColumnInfo(name = "offermission_id")
    private OfferMission offerMission;

    public Offer(Long id, @NonNull String content, @NonNull Cooperator cooperator, @NonNull OfferMission offerMission) {
        this.id = id;
        this.content = content;
        this.cooperator = cooperator;
        this.offerMission = offerMission;
    }

    public Long getId() {
        return id;
    }

    public Offer setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public Offer setContent(@NonNull String content) {
        this.content = content;
        return this;
    }

    @NonNull
    public Cooperator getCooperator() {
        return cooperator;
    }

    public Offer setCooperator(@NonNull Cooperator cooperator) {
        this.cooperator = cooperator;
        return this;
    }

    @NonNull
    public OfferMission getOfferMission() {
        return offerMission;
    }

    public Offer setOfferMission(@NonNull OfferMission offerMission) {
        this.offerMission = offerMission;
        return this;
    }
}
