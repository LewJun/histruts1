public class RolePermission {
    public int id_role;

    public int id_permission;

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public int getId_permission() {
        return id_permission;
    }

    public void setId_permission(int id_permission) {
        this.id_permission = id_permission;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id_role=" + id_role +
                ", id_permission=" + id_permission +
                '}';
    }
}
