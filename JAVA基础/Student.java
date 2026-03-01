import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Student {
  protected String name;
  protected String number;
  private String password;
  private static int count = 0;

  Student(String name,String number,String password){

     if (name == null || name.trim().isEmpty() 
            || number == null || number.trim().isEmpty() 
            || password == null || password.trim().isEmpty()) {
        throw new IllegalArgumentException("姓名、学号、密码均不得为null、空字符串或全空格");
    }

    this.name = name;
    this.number = number;
    this.password = password;
    count++;
  }

  public static int getCount(){
    return count;
  }

  // tools
  private String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  private String generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] Saltbytes = new byte[32];
    random.nextBytes(Saltbytes);
    return bytesToHex(Saltbytes);
  }

  private String sha256Encrypt(){

  }


  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void initPassword(String password) {
    this.password = password;
  }

  private boolean checkPassword(String password) {
    return password.equals(this.password);
  }

  public boolean setPassword(String newPassword, String oldPassword) {
    if (checkPassword(oldPassword)) {
      this.password = newPassword;
      return true;
    } else {
      return false;
    }
  }

}
