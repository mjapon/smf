package smf.util;


public class DatosUserSesion {

    private Integer userId;
    private String userName;
    private Integer tdvId;
    private String tdvNum;

    public DatosUserSesion() {

    }

    public DatosUserSesion(Integer userId, String userName, Integer tdvId, String tdvNum) {
        this.userId = userId;
        this.userName = userName;
        this.tdvId = tdvId;
        this.tdvNum = tdvNum;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTdvId() {
        return tdvId;
    }

    public void setTdvId(Integer tdvId) {
        this.tdvId = tdvId;
    }

    public String getTdvNum() {
        return tdvNum;
    }

    public void setTdvNum(String tdvNum) {
        this.tdvNum = tdvNum;
    }
}
