package servidor.tokens;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Objects;
import java.util.UUID;

/**
 * Token de administrador, Singleton.
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class AdminToken {

  private static AdminToken admin = null;
  private static String uuid;

  private AdminToken() {
    uuid = UUID.randomUUID().toString();
  }

  /** 
   * JavaDoc.
   * @return Constructor de AdminToken
   */
  public static AdminToken getInstance() {
    if (admin == null) {
      admin = new AdminToken();
    }
    return admin;
  }

  /**
   *JavaDoc.
   * @return getter de UUID
   */
  public static String getUuid() {
    return uuid;
  }

  /**
   *JavaDoc.
   * @param obj //
   * @return Metodo equals
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final AdminToken other = (AdminToken) obj;
    if (!Objects.equals(this.uuid, other.uuid)) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    return 42;
  }

  /**
   *Java Doc.
   * @return metodo toString
   */
  @Override
  public String toString() {
    return "AdminToken{" + uuid + '}';
  }

}
