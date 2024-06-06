
package carvaan.Entity;


public class Admin {
    String userName;
    String passWord;

    public Admin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Admin{" + "userName=" + userName + ", passWord=" + passWord + '}';
    }
    
    
    
}
