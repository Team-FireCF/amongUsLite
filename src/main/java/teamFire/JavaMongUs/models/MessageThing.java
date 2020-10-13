package teamFire.JavaMongUs.models;

public class MessageThing {
    private String message;

    public MessageThing(){}
    public MessageThing(String message){this.message = message;}

    public String getMessage(){return message;}
    public void setMessage(String message){this.message = message;}
}
