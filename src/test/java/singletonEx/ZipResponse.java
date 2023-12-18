package singletonEx;

public class ZipResponse {
    private String zipcode;

    public ZipResponse(String zipcode){
        this.zipcode=zipcode;
    }
    public String zipResponse(){
        return "response: "+zipcode;
    }
}
