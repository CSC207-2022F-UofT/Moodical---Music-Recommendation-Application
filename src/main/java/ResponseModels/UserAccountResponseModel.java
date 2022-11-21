package ResponseModels;

public class UserAccountResponseModel {

    String loginInformation;

    public UserAccountResponseModel(String loginInformation) {
        this.loginInformation = loginInformation;
    }

    public String getLoginInformation() {
        return loginInformation;
    }

    public void setLoginInformation(String loginInformation) {
        this.loginInformation = loginInformation;
    }

}
