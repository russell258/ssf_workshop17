package sg.nus.edu.iss.ssf_workshop17.model;

import java.io.Serializable;

//make sure is jakarta json, not google!
import jakarta.json.JsonObject;



public class Conditions implements Serializable{
    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    //get main, description, icon
    public static Conditions createJson(JsonObject j){
        Conditions c = new Conditions();
        c.description = "%s - %s"
                        .formatted(j.getString("main"),j.getString("description"));
        c.icon = "https://openweathermap.org/img/wn/%s@4x.png"
                        .formatted(j.getString("icon"));
        
        //c.icon = "https://openweathermap.org/img/wn/" + j.getString("icon")  + "@4x.png";
        // can do ^^ this way also

        return c;
    }
    

}
