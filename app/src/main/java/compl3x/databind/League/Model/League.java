package compl3x.databind.League.Model;

/**
 * Created by chad on 1/30/2017.
 */

public class League {
    private final String descript = "random description probably replace me with injected strings!:";
    private final String leaderDescript = "injectionAllstarspl0x:";
    private final String defaultLeagueTitle = "DefaultLeagueTitle";

    private String descriptor;
    private Boolean isActive;
    private Boolean signupAvailable;
    private String leaderKey;
    private String title;
    //noted probably these field should be final

    public League(int count) {
        this.descriptor = descript + String.valueOf(count);
        this.isActive = true;
        this.signupAvailable = true;
        this.leaderKey = leaderDescript + String.valueOf(count);
        this.title = defaultLeagueTitle;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getLeaderKey() {
        return leaderKey;
    }

    public void setLeaderKey(String leaderKey) {
        this.leaderKey = leaderKey;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getSignupAvailable() {
        return signupAvailable;
    }

    public void setSignupAvailable(Boolean signupAvailable) {
        this.signupAvailable = signupAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
