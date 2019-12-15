public class UserModel {
    public int mUserID;
    public String mPassword;

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append("\"").append(mUserID).append("\"").append(",");
        sb.append("\"").append(mPassword).append("\"").append(",");

        return sb.toString();
    }
}
