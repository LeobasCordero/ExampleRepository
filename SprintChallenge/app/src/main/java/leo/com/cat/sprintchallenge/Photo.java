package leo.com.cat.sprintchallenge;

/**
 * Created by Exchange on 10/16/2015.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Photo {

    @SerializedName("ID")
    @Expose
    private Integer ID;
    @SerializedName("ImageID")
    @Expose
    private Integer ImageID;
    @SerializedName("Title")
    @Expose
    private String Title;
    @SerializedName("UserID")
    @Expose
    private Integer UserID;
    @SerializedName("UserName")
    @Expose
    private String UserName;

    /**
     *
     * @return
     * The ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     *
     * @param ID
     * The ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     * The ImageID
     */
    public Integer getImageID() {
        return ImageID;
    }

    /**
     *
     * @param ImageID
     * The ImageID
     */
    public void setImageID(Integer ImageID) {
        this.ImageID = ImageID;
    }

    /**
     *
     * @return
     * The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     *
     * @param Title
     * The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     *
     * @return
     * The UserID
     */
    public Integer getUserID() {
        return UserID;
    }

    /**
     *
     * @param UserID
     * The UserID
     */
    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }

    /**
     *
     * @return
     * The UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     *
     * @param UserName
     * The UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

}