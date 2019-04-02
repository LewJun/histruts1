public class UserRole {
    public int id_user;

    public int id_role;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id_user=" + id_user +
                ", id_role=" + id_role +
                '}';
    }
}
