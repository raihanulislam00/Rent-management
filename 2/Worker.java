//package Classes;

public class Worker {

    public String wName;
    public String wID;
    public String workerPwd;
    public String phonenNo;

    public Worker(String wName, String wID, String workerPwd, String phonenNo) {
        this.wName = wName;
        this.wID = wID;
        this.workerPwd = workerPwd;
        this.phonenNo = phonenNo;
    }

    //Setter
    public void setwName(String wName) {
        this.wName = wName;
    }

    public void setwID(String wID) {
        this.wID = wID;
    }

    public void setWorkerPwd(String workerPwd) {
        this.workerPwd = workerPwd;
    }

    public void setPhonenNo(String phonenNo) {
        this.phonenNo = phonenNo;
    }

//Getter
    public String getwName() {
        return wName;
    }

    public String getwID() {
        return wID;
    }

    public String getWorkerPwd() {
        return workerPwd;
    }

    public String getPhonenNo() {
        return phonenNo;
    }

    @Override
    public String toString() {
        return (wName + "\t" + wID + "\t" + workerPwd + "\t" + phonenNo + "");
    }

}
