package database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dao.ArticleDao;
import dao.CategoryDao;
import dao.CommentDao;
import dao.CooperatorDao;
import dao.JobDao;
import dao.OfferDao;
import dao.OfferMissionDao;
import dao.ProfileDao;
import dao.RecommendationDao;
import dao.SkillDao;
import dao.UserDao;
import entities.Article;
import entities.Category;
import entities.Comment;
import entities.Cooperator;
import entities.Job;
import entities.Offer;
import entities.OfferMission;
import entities.Profile;
import entities.Recommendation;
import entities.Skill;
import entities.User;

@Database(entities = {Article.class, Category.class, Comment.class, Cooperator.class, Job.class, Offer.class, OfferMission.class,
        Profile.class, Recommendation.class, Skill.class, User.class}, version = 1)
public abstract class CoopUpRoomDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
    public abstract CategoryDao categoryDao();
    public abstract CommentDao commentDao();
    public abstract JobDao jobDao();
    public abstract OfferDao offerDao();
    public abstract OfferMissionDao offerMissionDao();
    public abstract ProfileDao profileDao();
    public abstract RecommendationDao recommendationDao();
    public abstract SkillDao skillDao();
    public abstract UserDao userDao();
    public abstract CooperatorDao cooperatorDao();

    private static volatile CoopUpRoomDatabase INSTANCE;

    public static CoopUpRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CoopUpRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CoopUpRoomDatabase.class, "coopup_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
