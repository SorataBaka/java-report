import java.util.UUID;
import java.time.LocalDate;
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private UUID userId;
    private LocalDate joinedAt;
    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.userId = UUID.randomUUID();
        this.joinedAt = LocalDate.now();
    }
    //Setters
    public User setFirstName(String firstName){
        this.firstName = firstName;
        return this; //メソッドチェーン
    }
    public User setLastName(String lastName){
        this.lastName = lastName;
        return this; //メソッドチェーン
    }
    public User setEmail(String email){
        this.email = email;
        return this; //メソッドチェーン
    }
    //Getters
    public String getName(){
        return this.firstName + " " + this.lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getUserId(){
        return this.userId.toString();
    }
    public LocalDate getJoinedAt(){
        return this.joinedAt;
    }
}