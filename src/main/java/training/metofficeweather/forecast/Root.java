package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class Root {

    public void setSiteRep(SiteRep siteRep) {
        this.siteRep = siteRep;
    }

    @SerializedName("SiteRep")
    private SiteRep siteRep;

    public SiteRep getSiteRep(){
        return siteRep;
    }
}
