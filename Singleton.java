

class DBConnection{
    private DBConnection dbConnection=null;
    public int value;
    public DBConnection(){
            System.out.println("New DbConnection established succesfully!");
    }
}


class Singleton{
    public static void main(String[] args){
        DBConnection dbConnection = new DBConnection();
    }
}
