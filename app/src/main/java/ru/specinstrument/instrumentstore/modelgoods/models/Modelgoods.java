package ru.specinstrument.instrumentstore.modelgoods.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anujgupta on 26/12/17.
 */

public class Modelgoods {

    /*@SerializedName("vote_count")
    @Expose
    private Integer voteCount;*/
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("printprior")
    @Expose
    private String printprior;
    @SerializedName("changedate")
    @Expose
    private String changedate;

    /**
     * No args constructor for use in serialization
     *
     */
    public Modelgoods() {
    }

    /**
     *

     * @param id
     * @param name
     * @param changedate
     * @param userid
     * @param printprior
     *
     */
    public Modelgoods(String id,  String name,  String userid,  String printprior,  String changedate) {
        super();

        this.id = id;
        this.name = name;
        this.userid = userid;
        this.printprior = printprior;
        this.changedate = changedate;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }



    public String getPrintprior() {
        return printprior;
    }

    public void setPrintprior(String printprior) {
        this.printprior = printprior;
    }

     public String getChangedate() {
        return changedate;
    }

    public void setChangedate(String changedate) {
        this.changedate = changedate;
    }

}
