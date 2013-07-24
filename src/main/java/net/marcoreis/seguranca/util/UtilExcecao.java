package net.marcoreis.seguranca.util;

public class UtilExcecao {
  public static String getRootErrorMessage(Exception e) {
    String errorMessage = "Erro";
    if (e == null) {
      return errorMessage;
    }
    Throwable t = e;
    while (t != null) {
      errorMessage = t.getLocalizedMessage();
      t = t.getCause();
    }
    return errorMessage;
  }
}
