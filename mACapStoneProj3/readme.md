## JAVA DEVELOPER - CAPSTONE PROJECT 3
16 Nov 20 to 27 Nov 20 (2 weeks)

This directories
* 201121 mySql Connection BackUp.zip 
    - backup connection from MySQlWorkbench.
* [All_LogProjects](All_LogProjects) 
    - samples **logger** for console output, file output on different levels.
* [Calculator](Calculator) 
  -  Chandra's sample on Calculator via **fxml**, see img.
* [CustomerApp-V3](CustomerApp-V3) 
  - Chandra's customerApp running on java fxml, see img.
* [CustomerApp.md](CustomerApp.md) 
  - initiate Chandra's customerApp console output
* [FxTableview](FxTableview) 
  -  create **ArrayList** and run on fxml, see img.
* [JDBC_App](JDBC_App) 
  - Chandra sample **mySql connections**.
* JavaFx_Samples_V2.0.zip 
  -  FXApp3 w *Alert*, FXApp4 Color & Calender, FXApp5 text entry, FXTimer
* [LocaleEx](LocaleEx) 
  -  sample for *language* conversion
* [**corebanking**](corebanking) 
  - **project for this training, all training done here.**
* [customerapp](customerapp) 
  - Chandra 1st example, workable
* [logNov16_2020.txt](logNov16_2020.txt) 
  - log text during this two week traning
* [**smallDB**](smallDB) 
  - small sql DB connecton with **pojo**, **DAO** (see below), **CRUD**. **kick-start**.
* [vSimpleFx](vSimpleFx) 
  - Fx SceneBuilder fxml *kick-start*.  

---
## snippet

### Simple console logger
refer to [All_LogProjects](All_LogProjects)
``` java
...
public class LogV1 {
    private static final Logger LOGGER = Logger.getLogger(LogV1.class.getName());
    public static void main(String[] args) {
            LOGGER.info(" Info Message From App");
            //Biz Logic here.. ... .. . . 
            LOGGER.info(" Info Message From App");
    }
}
```

### create ArrayList and print
refer to [FxTableview](FxTableview)
``` java
//.... pojo
    public static List<alist> rows() {
        List<alist> r = new ArrayList<>();
        r.add(new alist(11, "Eleven"));
        r.add(new alist(12, "Twelve"));
        r.add(new alist(13, "Thirteen"));
        r.add(new alist(0, "Zero"));
        return r;
    }

    public static void main(String[] args) {
        rows().forEach(ea -> {
            System.out.println(ea);
        });
    }
```
### locale
CoreBanking.corebanking.CoreBanking.java
``` java
    public static void custlocale() {
        System.out.print("Enter the language [en/es/zh] : ");
        String language = myObj.next();
        System.out.print("Enter the country code [US/ES/CN] : ");
        String country = myObj.next();

        Locale locale = new Locale(language, country);
        System.out.println(" Locale finalized :::: " + locale.getDisplayLanguage());
        ResourceBundle msgs = ResourceBundle.getBundle("bundles.Msg_Bundle", locale);

        System.out.print(msgs.getObject("fname") + " : "); // Enter your First Name : 
        currName = myObj.next();
        String fname = "\n\t" + msgs.getObject("welcomemsg") + " " + currName;
        System.out.println(fname);
    }
```
CoreBanking.bundles.Msg_Bundle_zh_CN
``` yaml
fname=输入您的名字
lname=输入您的姓氏
dob=出生日期
email=输入你的电子邮箱
phone=电话号码
welcomemsg=欢迎，先生/夫人
```

### kick start DAO
smallDB.Dao.java
``` java
...
public class Dao {
    public static Statement init() throws Exception {
        Connection conn = initConn(); 
        return conn.createStatement();
    }
    
    public static Connection initConn() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        // package >Properties >Libraries > ClassPath= mysqlCJ
        conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/smallDB?"
                        + "useTimezone=true&serverTimezone=UTC&"
                        + "user=root&password=mysql_80");
        return conn;
    }
    
    public static boolean insertCust(smCust c) throws Exception{
        Statement stmt = Dao.init();
        String insStmt = "insert into smallDB.cust (nric, cname, address, age) "
                + "VALUES("+ c.getNric() + ",\"" + c.getName() + "\",  \"" 
                + c.getAddress() + "\", " + c.getAge() 
                + ");";
                
        int result = stmt.executeUpdate(insStmt);
        if(result > 0){
            System.out.println(" Insert Success ");
        }else {
            System.out.println(" Insert Fail ");
        }
        
        return true;
    }    
    
    public static List <smCust> listCust() throws Exception{
        Statement stmt = Dao.init();
        List <smCust> custList = new ArrayList<>();
        String qStmt = "Select * from smallDB.Cust;";
        
        ResultSet rs = stmt.executeQuery(qStmt);
        while(rs.next()){
            custList.add(new smCust(rs.getInt("nric"),rs.getString("cname"),
                    rs.getString("address"),rs.getInt("age")));
        }
        return custList;
    }  

    public static void main(String[] args) throws Exception {
        Dao.listCust().stream().forEach(System.out::println);
        System.out.println("First Part: " + Dao.listCust().get(0));
    } 
}
```

### [CoreBanking](corebanking) snippet
set global variable for inter use between object 
``` java
public class AccMap_CRUD {
    private static List<AccMap> globalMapL = new ArrayList<>();
```
``` java
public class BankAccCrud {
    private static BankAcc globalAcc; // ref to 8 >> Acc Balance & history 
```


``` java
        //SavingAccDao.listSA().stream().forEach(System.out::println);
        BankAccDao.listSA().stream().forEach(eaRow -> {
            System.out.println(eaRow);
        });
```


get the next id from mySql of table
``` java
public class BankAccDao {
    public static int getNextID() {
        int nxtID = 0;
        try {
            Statement stmt = sqlConnect.init();
            String nxID = "select max(idSA) from coreBanking.SA;";
            ResultSet rs = stmt.executeQuery(nxID);
            rs.next();
            nxtID = rs.getInt(1) + 1;
        } catch (Exception e) {
            System.out.println(" Exception from sqlConnect :: " + e.getMessage());
            e.printStackTrace();
        }
        return nxtID;
    }

```

using row to manipulate data via SQL. BankAccDao.java
``` java
    public static BankAcc accRow(int idSA) throws Exception {
        LogUtil.IL.info(" Info Message From >> SavingAccDao.accInfo");
        Statement stmt = sqlConnect.init();
        BankAcc accInfo = null;
        String qStmt = "Select * from coreBanking.SA where idSA = " + idSA + ";";

        ResultSet rs = stmt.executeQuery(qStmt);
        while (rs.next()) {
            accInfo = (new BankAcc(
                    rs.getInt("idSA"),
                    rs.getString("accNo"),
                    rs.getDouble("balance"),
                    rs.getDouble("intRate"),
                    rs.getDate("accOpenDate").toLocalDate(),
                    //rs.getDate("accClosedDate").toLocalDate(),
                    rs.getDouble("minBal")
            ));
        }
        return accInfo;
    }
```
MAP two tables to one table. BankOpe
``` java
                case 1:
                    System.out.println("Create New Account  ");
                    BankAcc newBankAcc = BankAccCrud.inSAacc(); // create acc
                    AccMap_CRUD.newAccMap(customer, newBankAcc);// create map
                    bkArray = newBankAcc; // transfer over
                    break;
```
Yet to use this. bankacc.Test.java
``` java
        System.out.println(loadEmp().stream().collect(Collectors.counting()));

        System.out.println(loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toList()));

                Stream.of("Monday", "Tuesday", "Wednesday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));
```
start with P O J O. Cust.java
``` java
    private int nric;
    private String name;
    private String address;
    private String email;
    private String mobileNo;
    private LocalDate DOB;
    private LocalDateTime startDate;
    private byte active;
```
check mySql if any field is available. CustDAO.java
``` java
    public static boolean noCustNric(int nric) throws Exception {
        Statement stmt = sqlConnect.init();
        String qStmt = "Select count(*) from coreBanking.customer where nric = "
                + nric + ";";

        ResultSet rs = stmt.executeQuery(qStmt);
        if (rs.next() && rs.getInt(1) == 1) {       // **********
            //System.out.println(" Nric is in database... ");
            return false;
        } else {
            //System.out.println(" available ");
        }
        return true;
    }
```
convert ArrayList to ObservableList. HistDAO.java
``` java
    public static ObservableList<TxHist> oHistByAccid(int accid) throws Exception {
        List<TxHist> rs = HistDAO.getHistByAccid(accid);
        ObservableList<TxHist> ors = FXCollections.observableArrayList();
        for (TxHist row : rs) {
            ors.add(row);
//            System.out.println("Row" + row.toStringV3());
        }
        return ors;
    }
```
